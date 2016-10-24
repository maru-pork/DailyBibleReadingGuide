package com.maryann.dbrg.view;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.maryann.dbrg.R;
import com.maryann.dbrg.model.DailyBibleGuide;
import com.maryann.dbrg.util.DateUtil;

import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;
import java.util.Date;

import static com.maryann.dbrg.util.DateUtil.DATE_FORMAT;
import static com.maryann.dbrg.util.DateUtil.convertStringToLocalDate;

/**
 * Created by Rufo on 10/23/2016.
 */
public abstract class DailyVerseDialog extends Dialog implements View.OnClickListener {

    private Activity m;
    private DailyBibleGuide dailyBibleGuide;
    private EditText etReadDate;
    private EditText etNotes;
    private final Calendar currentCalendar;

    public DailyVerseDialog(Activity activity, DailyBibleGuide dailyBibleGuide) {
        super(activity);
        this.m = activity;
        this.dailyBibleGuide = dailyBibleGuide;
        this.currentCalendar = Calendar.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.daily_verse_layout);
        setCancelable(false);
        setTitle(m.getString(R.string.mark_as_read));

        // init components
        TextView tvCurrentDate = (TextView) findViewById(R.id.tv_current_date);
        TextView tvVerse = (TextView) findViewById(R.id.tv_verse);
        TextView tvReadDate = (TextView) findViewById(R.id.tv_read_date);
        TextView tvNotes = (TextView) findViewById(R.id.tv_notes);
        etReadDate = (EditText) findViewById(R.id.et_read_date);
        etNotes = (EditText) findViewById(R.id.et_notes);
        Button btnSaveDaily = (Button) findViewById(R.id.btn_save_daily);
        Button btnCancel = (Button) findViewById(R.id.btn_cancel_daily);

        // setUp visibility
        tvReadDate.setVisibility(View.GONE);
        tvNotes.setVisibility(View.GONE);

        etReadDate.setVisibility(View.VISIBLE);
        etNotes.setVisibility(View.VISIBLE);
        btnSaveDaily.setVisibility(View.VISIBLE);
        btnCancel.setVisibility(View.VISIBLE);

        // setUp components data display
        String[] verse = dailyBibleGuide.getVerse().split(";");
        Date readDate = dailyBibleGuide.getReadDate();

        tvCurrentDate.setText(DateFormat.format(DATE_FORMAT, dailyBibleGuide.getScheduledDate()));
        tvVerse.setText(m.getString(R.string.format_verse, verse[0], verse[1], verse[2]));
        etReadDate.setText(readDate == null ?
                DateFormat.format(DATE_FORMAT, currentCalendar.getTime()) : DateFormat.format(DATE_FORMAT, readDate));
        etReadDate.setInputType(InputType.TYPE_NULL);
        etNotes.setText(dailyBibleGuide.getNotes());

        // set up listener
        btnCancel.setOnClickListener(this);
        btnSaveDaily.setOnClickListener(this);
        etReadDate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.et_read_date:
                final DatePickerDialog datePickerDialog = new DatePickerDialog(
                        m,
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
                datePickerDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Clear", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == DialogInterface.BUTTON_NEGATIVE) {
                            datePickerDialog.cancel();
                            etReadDate.setText("");
                        }
                    }
                });
                datePickerDialog.show();
                break;

            case R.id.btn_save_daily:
                dailyBibleGuide.setReadDate(StringUtils.isEmpty(etReadDate.getText()) ?
                        null : convertStringToLocalDate(etReadDate.getText().toString(), DateUtil.DATE_FORMAT).toDate());
                dailyBibleGuide.setNotes(etNotes.getText().toString());
                setSaveOnClickAction(dailyBibleGuide);

            default:
                dismiss();
                break;
        }
    }

    public abstract void setSaveOnClickAction(DailyBibleGuide dailyBibleGuide);
}
