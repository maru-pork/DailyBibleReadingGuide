package com.maryann.dbrg.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.maryann.dbrg.R;
import com.maryann.dbrg.core.BibleVerseCollection;
import com.maryann.dbrg.core.CreateGuidesAsyncTask;
import com.maryann.dbrg.db.DBReader;
import com.maryann.dbrg.model.BibleDailyReadingGuide;
import com.maryann.dbrg.model.ResponseWrapper;
import com.maryann.dbrg.service.DailyBibleGuideService;
import com.maryann.dbrg.util.DateUtil;
import com.maryann.dbrg.view.CalendarCustomView;
import com.maryann.dbrg.view.CalendarEventHandler;

import org.joda.time.LocalDate;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Rufo on 5/22/2016.
 */
public class MainActivity extends AppCompatActivity {

    private DailyBibleGuideService dbService;
    private TextView tvCurrentDate;
    private TextView tvVerse;
    private TextView tvReadDate;
    private TextView tvNotes;

    private final Integer ITERATION_COUNT =
            new BibleVerseCollection().getVerseCount();
    private final String EMPTY_STRING = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbService = new DailyBibleGuideService(DBReader.getInstance(getBaseContext()));
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
        int id = item.getItemId();
        if (id == R.id.action_about) {
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.about_dialog_layout);
            dialog.setTitle(getString(R.string.about_title));
            dialog.show();

        } else if (id == R.id.action_iteration) {
            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.iteration_dialog_layout);
            dialog.setCancelable(false);

            Button btnCancelIteration = (Button) dialog.findViewById(R.id.btn_cancel_iteration);
            btnCancelIteration.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            BibleDailyReadingGuide guide = dbService.getDailyReadingGuide(DateUtil.CURRENT_DATE.toDate()).getEntity();
            if (guide == null) {
                dialog.setTitle(getString(R.string.new_iteration));
                displayNewIterationDialog(dialog);
            } else {
                dialog.setTitle(getString(R.string.view_iteration));
                displayViewIterationDialog(guide, dialog);
            }

            dialog.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        HashSet<LocalDate> scheduledDates = new HashSet<>();
        HashSet<LocalDate> missedDates = new HashSet<>();
        HashSet<LocalDate> readDates = new HashSet<>();

        BibleDailyReadingGuide currentGuide = dbService.getDailyReadingGuide(DateUtil.CURRENT_DATE.toDate()).getEntity();
        if (currentGuide != null) {
            List<BibleDailyReadingGuide> guideList = dbService.getGuideListByIteration(currentGuide.getIteration()).getEntity();
            for (BibleDailyReadingGuide guide : guideList) {
                LocalDate date = DateUtil.convertDateToLocalDate(guide.getScheduledDate());
                scheduledDates.add(date);
                if (guide.getMissed()) {
                    missedDates.add(date);
                }
                if (guide.getReadDate() != null) {
                    readDates.add(date);
                }
            }
        }

        tvCurrentDate = (TextView) findViewById(R.id.tv_current_date);
        tvVerse = (TextView) findViewById(R.id.tv_verse);
        tvReadDate = (TextView) findViewById(R.id.tv_read_date);
        tvNotes = (TextView) findViewById(R.id.tv_notes);

        displayDailyReading(DateUtil.CURRENT_DATE);

        CalendarCustomView calendarView = (CalendarCustomView) findViewById(R.id.calendar);
        calendarView.initCalendarDates(scheduledDates, missedDates, readDates);
        calendarView.setCalendarEventHandler(new CalendarEventHandler() {
            @Override
            public void onDayLongPress(LocalDate date) {
                displayDailyReadingDialog(date);
            }

            @Override
            public void onDayClick(LocalDate date) {
                displayDailyReading(date);
            }
        });
    }

    private void displayDailyReading(LocalDate date) {
        BibleDailyReadingGuide guide = dbService.getDailyReadingGuide(date.toDate()).getEntity();
        if (guide == null) {
            tvCurrentDate.setText(DateFormat.format(DateUtil.DATE_FORMAT, date.toDate()));
            tvVerse.setText(EMPTY_STRING);
            tvReadDate.setText(EMPTY_STRING);
            tvNotes.setText(EMPTY_STRING);
        } else {
            tvCurrentDate.setText(DateFormat.format(DateUtil.DATE_FORMAT, guide.getScheduledDate()));
            String[] verse = guide.getVerse().split(";");
            tvVerse.setText(getString(R.string.format_verse, verse[0], verse[1], verse[2]));
            Date readDate = guide.getReadDate();
            tvReadDate.setText(readDate == null ? EMPTY_STRING : DateFormat.format(DateUtil.DATE_FORMAT,readDate));
            tvNotes.setText(guide.getNotes());
        }
    }

    private void displayDailyReadingDialog(LocalDate date) {
        final BibleDailyReadingGuide bibleDailyReadingGuide = dbService.getDailyReadingGuide(date.toDate()).getEntity();
        if (bibleDailyReadingGuide != null){
            final Calendar currentCalendar = DateUtil.CURRENT_CALENDAR;

            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.daily_verse_layout);
            dialog.setCancelable(false);
            dialog.setTitle(getString(R.string.mark_as_read));

            TextView tvCurrentDate = (TextView) dialog.findViewById(R.id.tv_current_date);
            TextView tvVerse = (TextView) dialog.findViewById(R.id.tv_verse);
            TextView tvReadDate = (TextView) dialog.findViewById(R.id.tv_read_date);
            TextView tvNotes = (TextView) dialog.findViewById(R.id.tv_notes);
            final EditText etReadDate = (EditText) dialog.findViewById(R.id.et_read_date);
            final EditText etNotes = (EditText) dialog.findViewById(R.id.et_notes);
            Button btnSaveDaily = (Button) dialog.findViewById(R.id.btn_save_daily);
            Button btnCancel = (Button) dialog.findViewById(R.id.btn_cancel_daily);

            tvReadDate.setVisibility(View.GONE);
            etReadDate.setVisibility(View.VISIBLE);
            tvNotes.setVisibility(View.GONE);
            etNotes.setVisibility(View.VISIBLE);
            btnSaveDaily.setVisibility(View.VISIBLE);
            btnCancel.setVisibility(View.VISIBLE);

            tvCurrentDate.setText(DateFormat.format(DateUtil.DATE_FORMAT, bibleDailyReadingGuide.getScheduledDate()));
            String[] verse = bibleDailyReadingGuide.getVerse().split(";");
            tvVerse.setText(getString(R.string.format_verse, verse[0], verse[1], verse[2]));
            Date readDate = bibleDailyReadingGuide.getReadDate();
            etReadDate.setText(readDate == null ?
                    DateFormat.format(DateUtil.DATE_FORMAT, currentCalendar.getTime())
                    : DateFormat.format(DateUtil.DATE_FORMAT, readDate));
            etNotes.setText(bibleDailyReadingGuide.getNotes());

            etReadDate.setInputType(InputType.TYPE_NULL);
            etReadDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                    currentCalendar.set(Calendar.YEAR, year);
                                    currentCalendar.set(Calendar.MONTH, monthOfYear);
                                    currentCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                                    etReadDate.setText(DateFormat.format(DateUtil.DATE_FORMAT, currentCalendar.getTime()));
                                }
                            },
                            currentCalendar.get(Calendar.YEAR),
                            currentCalendar.get(Calendar.MONTH),
                            currentCalendar.get(Calendar.DAY_OF_MONTH));

                    datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis() - 1000);
                    datePickerDialog.show();
                }
            });

            btnSaveDaily.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bibleDailyReadingGuide.setReadDate(currentCalendar.getTime());
                    bibleDailyReadingGuide.setNotes(etNotes.getText().toString());
                    ResponseWrapper<BibleDailyReadingGuide> responseWrapper =
                            dbService.updateBibleDailyReadingGuide(bibleDailyReadingGuide);

                    if (responseWrapper.getErrorMessages().isEmpty()) {
                        Toast.makeText(MainActivity.this, getString(R.string.success_mark_as_read,
                                DateFormat.format(DateUtil.DATE_FORMAT, bibleDailyReadingGuide.getScheduledDate())),
                                Toast.LENGTH_SHORT).show();
                        initView();
                    } else {
                        StringBuilder errorMessage = new StringBuilder();
                        for (String error : responseWrapper.getErrorMessages()) {
                            errorMessage.append(error);
                            errorMessage.append("\n");
                        }
                        Toast.makeText(MainActivity.this, errorMessage.toString(), Toast.LENGTH_SHORT).show();
                    }
                    dialog.dismiss();
                }
            });

            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            dialog.show();
        } else {
            Toast.makeText(MainActivity.this, getString(R.string.warning_no_iteration), Toast.LENGTH_SHORT).show();
        }
    }

    private void displayNewIterationDialog(final Dialog dialog) {
        final Calendar currentCalendar = DateUtil.CURRENT_CALENDAR;

        final EditText etIteration = (EditText) dialog.findViewById(R.id.et_iteration);
        final EditText etStartDate = (EditText) dialog.findViewById(R.id.et_start_date);
        final EditText etEndDate = (EditText) dialog.findViewById(R.id.et_end_date);
        EditText etIterationCount = (EditText) dialog.findViewById(R.id.et_iteration_count);
        Button btnModifyIteration = (Button) dialog.findViewById(R.id.btn_modify_iteration);

        etIteration.setText(String.valueOf(currentCalendar.get(Calendar.YEAR)));
        etStartDate.setEnabled(true);
        etStartDate.setText(DateFormat.format(DateUtil.DATE_FORMAT, currentCalendar.getTime()));
        etStartDate.setInputType(InputType.TYPE_NULL);

        etStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                currentCalendar.set(Calendar.YEAR, year);
                                currentCalendar.set(Calendar.MONTH, monthOfYear);
                                currentCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                                etStartDate.setText(DateFormat.format(DateUtil.DATE_FORMAT, currentCalendar.getTime()));

                                etEndDate.setText(DateFormat.format(DateUtil.DATE_FORMAT, processEndDate(currentCalendar).toDate()));
                                etIteration.setText(String.valueOf(currentCalendar.get(Calendar.YEAR)));
                            }
                        },
                        currentCalendar.get(Calendar.YEAR),
                        currentCalendar.get(Calendar.MONTH),
                        currentCalendar.get(Calendar.DAY_OF_MONTH));

                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();
            }
        });

        etEndDate.setText(DateFormat.format(DateUtil.DATE_FORMAT, processEndDate(currentCalendar).toDate()));
        etIterationCount.setText(String.valueOf(ITERATION_COUNT));

        btnModifyIteration.setVisibility(View.VISIBLE);
        btnModifyIteration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResponseWrapper<List<BibleDailyReadingGuide>> responseWrapper =
                        dbService.validateNewIteration(currentCalendar);
                if (responseWrapper.getErrorMessages().isEmpty()) {
                    final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progressDialog.setTitle(getString(R.string.progress_saving_title));
                    progressDialog.setMessage(getString(R.string.progress_saving_message));
                    progressDialog.setCancelable(false);
                    progressDialog.show();

                    CreateGuidesAsyncTask task = new CreateGuidesAsyncTask(currentCalendar, dbService);
                    task.execute((Void) null);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.dismiss();
                            dialog.dismiss();

                            List<BibleDailyReadingGuide> list = dbService.getGuideListByIteration(currentCalendar.get(Calendar.YEAR)).getEntity();
                            if (list != null && list.size() == ITERATION_COUNT) {
                                Toast.makeText(MainActivity.this, getString(R.string.success_save_iteration, currentCalendar.get(Calendar.YEAR)), Toast.LENGTH_SHORT).show();
                                initView();
                            } else {
                                Toast.makeText(MainActivity.this, getString(R.string.error_save_iteration, currentCalendar.get(Calendar.YEAR)), Toast.LENGTH_SHORT).show();
                            }

                        }
                    }, 15000);

                } else {
                    StringBuilder errorMessage = new StringBuilder();
                    for (String error : responseWrapper.getErrorMessages()) {
                        errorMessage.append(error);
                        errorMessage.append("\n");
                    }
                    Toast.makeText(MainActivity.this, errorMessage.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private LocalDate processEndDate(Calendar currentCalendar) {
        LocalDate endDate =  LocalDate.fromCalendarFields(currentCalendar);
        if (DateUtil.isLeapYear(currentCalendar)) {
            if (endDate.isBefore(new LocalDate(currentCalendar.get(Calendar.YEAR), 2, 29))) {
                endDate = endDate.plusDays(ITERATION_COUNT);
                return endDate;
            }
        }

        endDate = endDate.plusDays(ITERATION_COUNT - 1);
        return endDate;
    }

    private void displayViewIterationDialog(final BibleDailyReadingGuide bibleDailyReadingGuide, final Dialog dialog) {
        final EditText etIteration = (EditText) dialog.findViewById(R.id.et_iteration);
        final EditText etStartDate = (EditText) dialog.findViewById(R.id.et_start_date);
        final EditText etEndDate = (EditText) dialog.findViewById(R.id.et_end_date);
        EditText etIterationCount = (EditText) dialog.findViewById(R.id.et_iteration_count);
        Button btnRemove = (Button) dialog.findViewById(R.id.btn_remove);

        btnRemove.setVisibility(View.VISIBLE);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage(getString(R.string.confirm_remove))
                        .setCancelable(false)
                        .setPositiveButton(getString(R.string.remove), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogIn, int which) {
                                dialog.dismiss();
                                ResponseWrapper<BibleDailyReadingGuide> responseWrapper = dbService.deleteDailyReadingGuide(bibleDailyReadingGuide.getIteration());
                                if (responseWrapper.getErrorMessages().isEmpty()) {
                                    Toast.makeText(MainActivity.this, getString(R.string.success_remove_iteration, bibleDailyReadingGuide.getIteration()), Toast.LENGTH_SHORT).show();
                                } else {
                                    StringBuilder errorMessage = new StringBuilder();
                                    for (String error : responseWrapper.getErrorMessages()) {
                                        errorMessage.append(error);
                                        errorMessage.append("\n");
                                    }
                                    Toast.makeText(MainActivity.this, errorMessage.toString(), Toast.LENGTH_SHORT).show();
                                }
                                initView();
                            }
                        })
                        .setNegativeButton(getString(R.string.cancel), null)
                        .show();

            }
        });

        List<BibleDailyReadingGuide> list = dbService.getGuideListByIteration(bibleDailyReadingGuide.getIteration()).getEntity();
        etIteration.setText(String.valueOf(bibleDailyReadingGuide.getIteration()));
        etStartDate.setText(DateFormat.format(DateUtil.DATE_FORMAT, list.get(0).getScheduledDate()));
        etEndDate.setText(DateFormat.format(DateUtil.DATE_FORMAT, list.get(list.size()-1).getScheduledDate()));

        Integer missedCount = 0;
        Integer readCount = 0;
        for (BibleDailyReadingGuide guide : list) {
            if (guide.getMissed()) {
                missedCount++;
            }
            if (guide.getReadDate() != null) {
                readCount++;
            }
        }

        etIterationCount.setText(getString(R.string.format_iteration, readCount, missedCount, list.size()));
    }


}