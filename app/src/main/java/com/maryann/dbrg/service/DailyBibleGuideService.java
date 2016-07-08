package com.maryann.dbrg.service;

import com.maryann.dbrg.core.BibleVerseCollection;
import com.maryann.dbrg.db.DBReader;
import com.maryann.dbrg.model.BibleDailyReadingGuide;
import com.maryann.dbrg.model.IterationModel;
import com.maryann.dbrg.model.ResponseWrapper;
import com.maryann.dbrg.util.DateUtil;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rufo on 5/22/2016.
 */
public class DailyBibleGuideService {

    private DBReader dbReader;

    public DailyBibleGuideService(DBReader dbReader) {
        this.dbReader = dbReader;
    }

    public ResponseWrapper<List<IterationModel>> getIterations(Integer currentIteration) {
        List<IterationModel> iterationModels = new ArrayList<>();
        for (Integer iteration : dbReader.getIterationList()) {
            iterationModels.add(new IterationModel(iteration, currentIteration));
        }
        return new ResponseWrapper<>(iterationModels);
    }

    public ResponseWrapper<BibleDailyReadingGuide> getDailyReadingGuide(Date date) {
        return new ResponseWrapper<>(dbReader.getDailyReadingGuide(date));
    }

    public ResponseWrapper<List<BibleDailyReadingGuide>> getGuideListByIteration(int iteration) {
        return new ResponseWrapper<>(dbReader.getGuideListByIteration(iteration));
    }

    public ResponseWrapper<List<BibleDailyReadingGuide>> validateNewIteration(LocalDate startDate, LocalDate endDate) {
        List<String> errorMessages = new ArrayList<>();
        Long existingGuides = dbReader.getDailyReadingGuideCount(startDate.toDate(), endDate.toDate());
        if (existingGuides != 0) {
            errorMessages.add("There's an existing iteration on the selected start date");
        }

        ResponseWrapper<List<BibleDailyReadingGuide>> response =
                new ResponseWrapper<List<BibleDailyReadingGuide>>(new ArrayList<BibleDailyReadingGuide>());
        response.setErrorMessages(errorMessages);

        return response;
    }

    public void createBibleDailyReadingGuide(Calendar currentCalendar) {
        List<BibleDailyReadingGuide> guides = new BibleVerseCollection().getVerseList();

        LocalDate startDate = LocalDate.fromCalendarFields(currentCalendar);
        for (BibleDailyReadingGuide guide : guides) {
            guide.setIteration(currentCalendar.get(Calendar.YEAR));
            guide.setScheduledDate(startDate.toDate());
            startDate = startDate.plusDays(1);
            if (DateUtil.isLeapYear(startDate)) {
                if (startDate.compareTo(new LocalDate(startDate.getYear(), 2, 29)) == 0) {
                    // add one day to skip February 29
                    startDate = startDate.plusDays(1);
                }
            }
        }
        dbReader.createBibleDailyReadingGuide(guides);
    }

    public ResponseWrapper<BibleDailyReadingGuide> deleteDailyReadingGuide(int iteration) {
        List<String> errorMessages = new ArrayList<>();
        dbReader.deleteDailyReadingGuide(iteration);

        if (!dbReader.getGuideListByIteration(iteration).isEmpty()) {
            errorMessages.add("Error on removing iteration.");
        }

        ResponseWrapper<BibleDailyReadingGuide> response =
                new ResponseWrapper<>(new BibleDailyReadingGuide());
        response.setErrorMessages(errorMessages);
        return response;
    }

    public ResponseWrapper<BibleDailyReadingGuide> updateBibleDailyReadingGuide(BibleDailyReadingGuide bibleDailyReadingGuide) {
        List<String> errorMessages = new ArrayList<>();

        if (bibleDailyReadingGuide.getScheduledDate() == null) {
            errorMessages.add("Scheduled Date is required.");
        }

        if (errorMessages.isEmpty()) {
            if (dbReader.getDailyReadingGuide(bibleDailyReadingGuide.getScheduledDate())
                    .getReadDate() == null) {
                if (bibleDailyReadingGuide.getReadDate() == null) {
                    errorMessages.add("Read Date is required.");
                }
            }
        }

        if (errorMessages.isEmpty()) {
            if (bibleDailyReadingGuide.getReadDate() != null) {
                LocalDate scheduledDate = DateUtil.convertDateToLocalDate(bibleDailyReadingGuide.getScheduledDate());
                LocalDate readDate = DateUtil.convertDateToLocalDate(bibleDailyReadingGuide.getReadDate());
                bibleDailyReadingGuide.setMissed(readDate.isAfter(scheduledDate));
                dbReader.updateBibleDailyReadingGuide(bibleDailyReadingGuide);
            } else {
                dbReader.clearBibleDailyReadingGuide(bibleDailyReadingGuide);
            }
        }

        ResponseWrapper<BibleDailyReadingGuide> response =
                new ResponseWrapper<>(bibleDailyReadingGuide);
        response.setErrorMessages(errorMessages);
        return response;
    }



}
