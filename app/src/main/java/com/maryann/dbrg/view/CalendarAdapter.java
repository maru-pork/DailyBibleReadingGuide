package com.maryann.dbrg.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.maryann.dbrg.R;
import com.maryann.dbrg.util.DateUtil;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Rufo on 5/22/2016.
 */
public class CalendarAdapter extends ArrayAdapter {

    private LayoutInflater inflater;
    private HashSet<LocalDate> missedDates;
    private HashSet<LocalDate> scheduledDates;
    private HashSet<LocalDate> readDates;

    public CalendarAdapter(Context context, ArrayList<LocalDate> days, HashSet<LocalDate> missedDates, HashSet<LocalDate> scheduledDates, HashSet<LocalDate> readDates) {
        super(context, R.layout.calendar_day_layout, days);
        inflater = LayoutInflater.from(context);
        this.missedDates = missedDates;
        this.scheduledDates = scheduledDates;
        this.readDates = readDates;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LocalDate date = (LocalDate) getItem(position);

        if (view == null) {
            view = inflater.inflate(R.layout.calendar_day_layout, parent, false);
        }

        TextView textView = (TextView)view;
        textView.setTextColor(Color.LTGRAY);

        if (date.isEqual(DateUtil.CURRENT_DATE)) {
            textView.setTextColor(Color.DKGRAY);
            textView.setBackgroundColor(Color.LTGRAY);
        }

        if (scheduledDates.contains(date)) {
            textView.setTextColor(Color.BLACK);
        }

        if (readDates.contains(date)) {
            textView.setTextColor(Color.BLUE);
            textView.setTypeface(null, Typeface.BOLD);
        }

        if (missedDates.contains(date)) {
            textView.setTextColor(Color.RED);
        }

        textView.setText(String.valueOf(date.getDayOfMonth()));
        return view;
    }


}
