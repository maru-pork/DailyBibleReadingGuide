package com.maryann.dbrg.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.maryann.dbrg.BuildConfig;
import com.maryann.dbrg.R;
import com.maryann.dbrg.core.CreateGuidesAsyncTask;
import com.maryann.dbrg.core.ResultWrapper;
import com.maryann.dbrg.db.DBHelper;
import com.maryann.dbrg.model.DailyBibleGuide;
import com.maryann.dbrg.model.Iteration;
import com.maryann.dbrg.model.SpIterationModel;
import com.maryann.dbrg.service.DailyBibleGuideService;
import com.maryann.dbrg.util.DateUtil;
import com.maryann.dbrg.view.CalendarCustomView;
import com.maryann.dbrg.view.CalendarEventHandler;
import com.maryann.dbrg.view.DailyVerseDialog;
import com.maryann.dbrg.view.IterationDialog;
import com.maryann.dbrg.view.NewIterationDialog;
import com.maryann.dbrg.view.ViewIterationDialog;

import org.joda.time.LocalDate;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import static com.maryann.dbrg.util.DateUtil.CURRENT_DATE;

/**
 * Created by Rufo on 5/22/2016.
 */
public class MainActivity extends AppCompatActivity {

    private DailyBibleGuideService service;

    private TextView tvCurrentDate;
    private TextView tvVerse;
    private TextView tvReadDate;
    private TextView tvNotes;

    private final Integer ITERATION_COUNT = 365;
    private final String EMPTY_STRING = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // initialize service
        service = new DailyBibleGuideService(DBHelper.getInstance(getBaseContext()), getBaseContext());
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                Dialog dlgAbout = new Dialog(this);
                dlgAbout.setContentView(R.layout.about_dialog_layout);
                dlgAbout.setTitle(getString(R.string.about_title));
                TextView tvVersion = (TextView) dlgAbout.findViewById(R.id.tv_version);
                tvVersion.setText(getString(R.string.about_version, BuildConfig.VERSION_CODE, BuildConfig.VERSION_NAME));

                dlgAbout.show();
                break;

            case R.id.action_iteration:
                DailyBibleGuide currentGuide = service.getDailyBibleGuide(LocalDate.now().toDate()).getEntity();
                // if guide exist for current date, display View Iteration Dialog, else display New Iteration Dialog
                if(currentGuide != null) {
                    ResultWrapper<Iteration> resultWrapper = service.constructIterationModel();
                    if (toDisplayErrorMessageIfExists(resultWrapper)){
                        new ViewIterationDialog(this, resultWrapper.getEntity()).show();
                    }

                } else {
                    new NewIterationDialog(this) {
                        @Override
                        public void setSaveOnClickAction(final LocalDate startDate, LocalDate endDate) {
                            ResultWrapper<DailyBibleGuide> resultWrapper = service.validateIfIterationExists(startDate, endDate);
                            if(!toDisplayErrorMessageIfExists(resultWrapper)) return;

                            final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                            progressDialog.setTitle(getString(R.string.progress_saving_title));
                            progressDialog.setMessage(getString(R.string.progress_saving_message));
                            progressDialog.setCancelable(false);
                            progressDialog.show();

                            CreateGuidesAsyncTask task = new CreateGuidesAsyncTask(startDate, service);
                            task.execute((Void) null);

                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    progressDialog.dismiss();
                                    dismiss();

                                    List<DailyBibleGuide> list = service.getGuidesByIteration(startDate.getYear()).getEntity();
                                    if (list != null && list.size() == ITERATION_COUNT) {
                                        Toast.makeText(MainActivity.this, getString(R.string.success_save_iteration, startDate.getYear()), Toast.LENGTH_SHORT).show();
                                        initView();
                                    } else {
                                        Toast.makeText(MainActivity.this, getString(R.string.error_save_iteration, startDate.getYear()), Toast.LENGTH_SHORT).show();
                                    }

                                }
                            }, 15000);
                        }
                    }.show();
                }
                break;

            case R.id.action_export:
                new IterationDialog(this) {
                    @Override
                    public void setRemoveOnClickAction(Integer iteration) {
                        ResultWrapper<DailyBibleGuide> resultWrapper = service.deleteDailyBibleGuide(iteration);
                        if (!toDisplayErrorMessageIfExists(resultWrapper)) return;

                        Toast.makeText(MainActivity.this,
                                getString(R.string.success_remove_iteration, iteration),
                                Toast.LENGTH_SHORT).show();
                        initView();
                    }

                    @Override
                    public void setExportOnClickAction(Integer iteration) {
                        ResultWrapper<File> resultWrapperExpt = service.exportGuideToFile(iteration);
                        if (!toDisplayErrorMessageIfExists(resultWrapperExpt)) return;

                        sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(resultWrapperExpt.getEntity())));
                        Toast.makeText(MainActivity.this, "Exporting data to csv file..", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public List<SpIterationModel> setUpSpIterations() {
                        ResultWrapper<List<SpIterationModel>> resultWrapper = service.getIterations();
                        if(toDisplayErrorMessageIfExists(resultWrapper))
                            return resultWrapper.getEntity();
                        return new ArrayList<>();
                    }

                    @Override
                    public Iteration setUpIteration(Integer selectedIteration) {
                        return service.constructIterationModel(selectedIteration).getEntity();
                    }
                }.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        // init components
        tvCurrentDate = (TextView) findViewById(R.id.tv_current_date);
        tvVerse = (TextView) findViewById(R.id.tv_verse);
        tvReadDate = (TextView) findViewById(R.id.tv_read_date);
        tvNotes = (TextView) findViewById(R.id.tv_notes);

        initMainContents(CURRENT_DATE);
        initMainCalendar();
    }

    private void initMainContents(LocalDate date) {
        DailyBibleGuide guide = service.getDailyBibleGuide(date.toDate()).getEntity();
        if (guide == null) {
            tvCurrentDate.setText(DateFormat.format(DateUtil.DATE_FORMAT, date.toDate()));
            tvVerse.setText(EMPTY_STRING);
            tvReadDate.setText(EMPTY_STRING);
            tvNotes.setText(EMPTY_STRING);
        } else {
            String[] verse = guide.getVerse().split(";");
            Date readDate = guide.getReadDate();

            tvCurrentDate.setText(DateFormat.format(DateUtil.DATE_FORMAT, guide.getScheduledDate()));
            tvVerse.setText(getString(R.string.format_verse, verse[0], verse[1], verse[2]));
            tvReadDate.setText(readDate == null ? EMPTY_STRING : DateFormat.format(DateUtil.DATE_FORMAT,readDate));
            tvNotes.setText(guide.getNotes());
        }
    }

    private void initMainCalendar() {
        HashSet<LocalDate> scheduledDates = new HashSet<>();
        HashSet<LocalDate> missedDates = new HashSet<>();
        HashSet<LocalDate> readDates = new HashSet<>();

        // init only the current iteration on calendar display, disregard the previous iterations if exists
        DailyBibleGuide currentGuide = service.getDailyBibleGuide(CURRENT_DATE.toDate()).getEntity();

        if(currentGuide != null) {
            ResultWrapper<Iteration> resultWrapper = service.constructIterationModel(currentGuide.getIteration());
            if (toDisplayErrorMessageIfExists(resultWrapper)) {
                // add dates to hashSets if currentGuide exist
                scheduledDates.addAll(resultWrapper.getEntity().getScheduledDates());
                missedDates.addAll(resultWrapper.getEntity().getMissedDates());
                readDates.addAll(resultWrapper.getEntity().getReadDates());
            }
        }

        CalendarCustomView calendarView = (CalendarCustomView) findViewById(R.id.calendar);
        calendarView.initCalendarDates(scheduledDates, missedDates, readDates);
        calendarView.setCalendarEventHandler(new CalendarEventHandler() {
            @Override
            public void onDayLongPress(LocalDate date) {
                DailyBibleGuide dailyBibleGuide = service.getDailyBibleGuide(date.toDate()).getEntity();
                if (dailyBibleGuide != null) {
                    new DailyVerseDialog(MainActivity.this, dailyBibleGuide) {
                        @Override
                        public void setSaveOnClickAction(DailyBibleGuide dailyBibleGuide) {
                            ResultWrapper<DailyBibleGuide> resultWrapper = service.updateDailyBibleGuide(dailyBibleGuide);
                            if (!toDisplayErrorMessageIfExists(resultWrapper)) return;

                            Toast.makeText(MainActivity.this, getString(R.string.success_mark_as_read,
                                    DateFormat.format(DateUtil.DATE_FORMAT, dailyBibleGuide.getScheduledDate())),
                                    Toast.LENGTH_SHORT).show();
                            initView();
                        }
                    }.show();
                } else {
                    Toast.makeText(MainActivity.this, getString(R.string.warning_no_iteration), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onDayClick(LocalDate date) {
                initMainContents(date);
            }
        });
    }

    public <T> boolean toDisplayErrorMessageIfExists(ResultWrapper<T> resultWrapper) {
        if (resultWrapper.getErrorMessages().isEmpty()) {
            return true;
        }

        StringBuilder errorMessage = new StringBuilder();
        for (String error : resultWrapper.getErrorMessages()) {
            errorMessage.append(error);
            errorMessage.append("\n");
        }
        Toast.makeText(MainActivity.this, errorMessage.toString(), Toast.LENGTH_SHORT).show();
        return false;
    }

}
