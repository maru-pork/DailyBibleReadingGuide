package com.maryann.dbrg.service;

import android.content.Context;
import android.os.Environment;
import android.text.format.DateFormat;

import com.maryann.dbrg.core.ResultWrapper;
import com.maryann.dbrg.model.DailyBibleGuide;
import com.maryann.dbrg.model.Iteration;
import com.maryann.dbrg.model.SpIterationModel;
import com.maryann.dbrg.util.DateUtil;

import org.joda.time.LocalDate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import static com.maryann.dbrg.util.DateUtil.convertDateToLocalDate;
import static com.maryann.dbrg.util.VersePropertiesUtil.constructBibleGuideList;

/**
 * Created by Rufo on 5/22/2016.
 */
public class DailyBibleGuideService {

    private DailyBibleGuideRepository repository;
    private Context context;
    public DailyBibleGuideService(DailyBibleGuideRepository repository, Context context) {
        this.repository = repository;
        this.context = context;
    }

    public ResultWrapper<List<SpIterationModel>> getIterations() {
        List<SpIterationModel> spIterations = new ArrayList<>();

        ResultWrapper<List<SpIterationModel>> resultWrapper = new ResultWrapper<>(spIterations);
        List<String> errorMessages = new ArrayList<>();
        resultWrapper.setErrorMessages(errorMessages);
        try {
            Integer currentIteration = repository.getIteration(LocalDate.now().toDate());
            List<Integer> iterations = repository.getIterations();
            for (Integer iteration : iterations) {
                spIterations.add(new SpIterationModel(iteration, currentIteration));
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorMessages.add(e.getMessage());
        }
        return resultWrapper;
    }

    public Integer getCurrentIteration() {
        // return the current iteration if any, else default 0
        try {
            return repository.getIteration(LocalDate.now().toDate());
        } catch (Exception e) {
            return 0;
        }
    }

    public ResultWrapper<DailyBibleGuide> getDailyBibleGuide(Date scheduledDate) {
        ResultWrapper<DailyBibleGuide> resultWrapper = new ResultWrapper<>();
        List<String> errorMessages = new ArrayList<>();
        resultWrapper.setErrorMessages(errorMessages);
        try {
            if (scheduledDate == null)
                throw new IllegalArgumentException("Scheduled date cannot be null");

            DailyBibleGuide guide = repository.getDailyBibleGuide(scheduledDate);
            resultWrapper.setEntity(guide);
        } catch (Exception e) {
            e.printStackTrace();
            errorMessages.add(e.getMessage());
        }
        return resultWrapper;
    }

    public ResultWrapper<List<DailyBibleGuide>> getGuidesByIteration(int iteration) {
        List<DailyBibleGuide> guides = new ArrayList<>();

        ResultWrapper<List<DailyBibleGuide>> resultWrapper = new ResultWrapper<>(guides);
        List<String> errorMessages = new ArrayList<>();
        resultWrapper.setErrorMessages(errorMessages);
        try {
            guides.addAll(repository.getAllDailyBibleGuides(iteration));
        } catch (Exception e) {
            e.printStackTrace();
            errorMessages.add(e.getMessage());
        }
        return resultWrapper;
    }

    public ResultWrapper<DailyBibleGuide> validateIfIterationExists(LocalDate startDate, LocalDate endDate) {
        ResultWrapper<DailyBibleGuide> resultWrapper = new ResultWrapper<>();
        List<String> errorMessages = new ArrayList<>();
        resultWrapper.setErrorMessages(errorMessages);
        try {
            if (startDate == null || endDate == null)
                throw new IllegalArgumentException("start date nor end date cannot be null");

            long guidesCount = repository.getGuidesCount(startDate.toDate(), endDate.toDate());
            if (guidesCount != 0)
                errorMessages.add("There's an existing iteration on the selected start date");
        } catch (Exception e) {
            e.printStackTrace();
            errorMessages.add(e.getMessage());
        }
        return resultWrapper;
    }

    public ResultWrapper<List<DailyBibleGuide>> createDailyBibleGuide(LocalDate startDate) {
        ResultWrapper<List<DailyBibleGuide>> resultWrapper = new ResultWrapper<>();
        List<String> errorMessages = new ArrayList<>();
        resultWrapper.setErrorMessages(errorMessages);
        try {
            if (startDate == null)
                throw new IllegalArgumentException("Start Date cannot be null");

            List<DailyBibleGuide> guides =
                    constructBibleGuideList(context, startDate);
            if (guides.isEmpty())
                throw new IllegalArgumentException("No guides found from properties");

            repository.insertDailyBibleGuide(guides);
            resultWrapper.setEntity(guides);
        } catch (IOException e) {
            e.printStackTrace();
            errorMessages.add("Error while getting verse.properties file.");
        } catch (Exception e) {
            e.printStackTrace();
            errorMessages.add(e.getMessage());
        }
        return resultWrapper;
    }

    public ResultWrapper<DailyBibleGuide> deleteDailyBibleGuide(int iteration) {
        ResultWrapper<DailyBibleGuide> resultWrapper = new ResultWrapper<>();
        List<String> errorMessages = new ArrayList<>();
        resultWrapper.setErrorMessages(errorMessages);
        try {
            repository.deleteDailyBibleGuides(iteration);
            if (!repository.getAllDailyBibleGuides(iteration).isEmpty()) {
                errorMessages.add("No guides were deleted.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorMessages.add(e.getMessage());
        }
        return resultWrapper;
    }

    public ResultWrapper<DailyBibleGuide> updateDailyBibleGuide(DailyBibleGuide dailyBibleGuide) {
        ResultWrapper<DailyBibleGuide> resultWrapper = new ResultWrapper<>();
        List<String> errorMessages = new ArrayList<>();
        resultWrapper.setErrorMessages(errorMessages);
        try {
            if (dailyBibleGuide.getScheduledDate() == null) {
                errorMessages.add("Scheduled Date is required.");
                return resultWrapper;
            }

            // read date is required only if first time to mark as read
            DailyBibleGuide guideFrDb = repository.getDailyBibleGuide(dailyBibleGuide.getScheduledDate());
            if (guideFrDb.getReadDate() == null && dailyBibleGuide.getReadDate() == null) {
                errorMessages.add("Read Date is required.");
                return resultWrapper;
            }

            if (dailyBibleGuide.getReadDate() != null) {
                LocalDate scheduledDate = DateUtil.convertDateToLocalDate(dailyBibleGuide.getScheduledDate());
                LocalDate readDate = DateUtil.convertDateToLocalDate(dailyBibleGuide.getReadDate());
                dailyBibleGuide.setMissed(readDate.isAfter(scheduledDate) ? 1 : 0);
                repository.updateDailyBibleGuide(dailyBibleGuide);
            } else {
                repository.clearDailyBibleGuide(dailyBibleGuide);
            }
            resultWrapper.setEntity(dailyBibleGuide);
        } catch (Exception e) {
            e.printStackTrace();
            errorMessages.add(e.getMessage());
        }
        return resultWrapper;
    }

    public ResultWrapper<File> exportGuideToFile(int iteration) {
        ResultWrapper<File> resultWrapper = new ResultWrapper<>();
        List<String> errorMessages = new ArrayList<>();
        resultWrapper.setErrorMessages(errorMessages);

        try {
            String fileName = "DBRG("+ iteration +").csv";
            File root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(root, fileName);
            FileWriter writer = new FileWriter(file);
            writer.write(String.format("%s,%s,%s,%s,%s\n", "Iteration", "Verse", "Scheduled", "Read", "Notes"));

            List<DailyBibleGuide> guides = repository.getAllDailyBibleGuides(iteration);
            for (DailyBibleGuide guide: guides) {
                String line = String.format("%s,%s,%s,%s,%s\n",
                        String.valueOf(guide.getIteration()),
                        guide.getVerse(),
                        String.valueOf(DateFormat.format("MM/dd/yyyy", guide.getScheduledDate())),
                        guide.getReadDate() == null ? "-" : String.valueOf(DateFormat.format("MM/dd/yyyy", guide.getReadDate())),
                        guide.getNotes() == null || guide.getNotes().isEmpty() ? "-" : guide.getNotes());
                writer.write(line);
            }
            writer.flush();
            writer.close();

            resultWrapper.setEntity(file);
        } catch (Exception e) {
            e.printStackTrace();
            errorMessages.add(e.getMessage());
        }
        return resultWrapper;
    }

    public ResultWrapper<Iteration> constructIterationModel(Integer... iteration) {
        ResultWrapper<Iteration> resultWrapper = new ResultWrapper<>();
        List<String> errorMessages = new ArrayList<>();
        resultWrapper.setErrorMessages(errorMessages);

        Integer currentIteration;
        if (iteration.length == 0) {
            currentIteration = getCurrentIteration();
        } else {
            currentIteration = iteration[0];
        }

        Iteration iterationModel = null;
        try {
            List<DailyBibleGuide> guides = repository.getAllDailyBibleGuides(currentIteration);

            HashSet<LocalDate> scheduledDates = new HashSet<>();
            HashSet<LocalDate> missedDates = new HashSet<>();
            HashSet<LocalDate> readDates = new HashSet<>();
            Integer missedCount = 0;
            Integer readCount = 0;

            for (DailyBibleGuide guide : guides) {
                LocalDate date = convertDateToLocalDate(guide.getScheduledDate());
                scheduledDates.add(date);
                if (guide.getMissedIndicator()) {
                    missedCount++;
                    missedDates.add(date);
                }
                if (guide.getReadDate() != null) {
                    readCount++;
                    readDates.add(date);
                }
            }

            iterationModel = new Iteration();
            iterationModel.setIteration(guides.get(0).getIteration());
            iterationModel.setStartDate(guides.get(0).getScheduledDate());
            iterationModel.setEndDate(guides.get(guides.size()-1).getScheduledDate());
            iterationModel.setMissedCount(missedCount);
            iterationModel.setReadCount(readCount);
            iterationModel.setIterationCount(guides.size());
            iterationModel.setMissedDates(missedDates);
            iterationModel.setReadDates(readDates);
            iterationModel.setScheduledDates(scheduledDates);

            resultWrapper.setEntity(iterationModel);
        } catch (Exception e) {
            e.printStackTrace();
            errorMessages.add(e.getMessage());
        }
        return resultWrapper;
    }
}
