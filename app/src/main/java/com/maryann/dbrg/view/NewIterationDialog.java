package com.maryann.dbrg.view;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.InputType;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.maryann.dbrg.R;
import com.maryann.dbrg.util.DateUtil;
import com.maryann.dbrg.util.VersePropertiesUtil;

import org.joda.time.LocalDate;

import java.util.Calendar;

import static com.maryann.dbrg.util.DateUtil.DATE_FORMAT;
import static com.maryann.dbrg.util.DateUtil.convertStringToLocalDate;
import static com.maryann.dbrg.util.DateUtil.isLeapYear;

/**
 * Created by Rufo on 10/23/2016.
 */
public abstract class NewIterationDialog extends Dialog implements View.OnClickListener {

    private Activity m;

    private EditText etIteration;
    private EditText etStartDate;
    private EditText etEndDate;

    private final Calendar currentCalendar;
    private final int ITERATION_COUNT;

    public NewIterationDialog(Activity activity) {
        super(activity);
        this.m = activity;
        currentCalendar = Calendar.getInstance();
        ITERATION_COUNT = VersePropertiesUtil.LIST_COUNT;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iteration_dialog_layout);
        setTitle(m.getString(R.string.new_iteration));
        setCancelable(false);

        // initialize components
        etIteration = (EditText) findViewById(R.id.et_iteration);
        etStartDate = (EditText) findViewById(R.id.et_start_date);
        etEndDate = (EditText) findViewById(R.id.et_end_date);
        EditText etIterationCount = (EditText) findViewById(R.id.et_iteration_count);
        Button btnCancel = (Button) findViewById(R.id.btn_cancel_iteration);
        Button btnSave = (Button) findViewById(R.id.btn_ok_iteration);

        // setUp components data display
        btnSave.setText(m.getString(R.string.create));
        etIteration.setText(String.valueOf(currentCalendar.get(Calendar.YEAR)));
        etStartDate.setEnabled(true);
        etStartDate.setText(DateFormat.format(DateUtil.DATE_FORMAT, currentCalendar.getTime()));
        etStartDate.setInputType(InputType.TYPE_NULL);
        etEndDate.setText(DateFormat.format(DATE_FORMAT, processEndDate(currentCalendar).toDate()));
        etIterationCount.setText(String.valueOf(ITERATION_COUNT));

        // setup listener
        etStartDate.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.et_start_date:
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        m,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                currentCalendar.set(Calendar.YEAR, year);
                                currentCalendar.set(Calendar.MONTH, monthOfYear);
                                currentCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                                etIteration.setText(String.valueOf(currentCalendar.get(Calendar.YEAR)));
                                etStartDate.setText(DateFormat.format(DateUtil.DATE_FORMAT, currentCalendar.getTime()));
                                etEndDate.setText(DateFormat.format(DateUtil.DATE_FORMAT, processEndDate(currentCalendar).toDate()));
                            }
                        },
                        currentCalendar.get(Calendar.YEAR),
                        currentCalendar.get(Calendar.MONTH),
                        currentCalendar.get(Calendar.DAY_OF_MONTH));

                datePickerDialog.getDatePicker().setMaxDate(Calendar.getInstance().getTimeInMillis());
                datePickerDialog.show();
                break;

            case  R.id.btn_ok_iteration:
                setSaveOnClickAction(convertStringToLocalDate(etStartDate.getText().toString(), DATE_FORMAT),
                        convertStringToLocalDate(etEndDate.getText().toString(), DATE_FORMAT));
            default:
                dismiss();
                break;
        }
    }

    private LocalDate processEndDate(Calendar currentCalendar) {
        LocalDate endDate =  LocalDate.fromCalendarFields(currentCalendar);
        if (isLeapYear(currentCalendar)) {
            if (endDate.isBefore(new LocalDate(currentCalendar.get(Calendar.YEAR), 2, 29))) {
                endDate = endDate.plusDays(ITERATION_COUNT);
                return endDate;
            }
        }
        endDate = endDate.plusDays(ITERATION_COUNT - 1);
        return endDate;
    }

    public abstract void setSaveOnClickAction(LocalDate startDate, LocalDate endDate);
}
