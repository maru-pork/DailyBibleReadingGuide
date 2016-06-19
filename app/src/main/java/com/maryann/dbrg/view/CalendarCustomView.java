package com.maryann.dbrg.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maryann.dbrg.R;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Rufo on 5/22/2016.
 *
 * Source: https://www.toptal.com/android/android-customization-how-to-build-a-ui-component-that-does-what-you-want
 */
public class CalendarCustomView extends LinearLayout {

    private static final int DAYS_COUNT = 42;
    private static final String MONTH_YEAR_FORMAT = "MMMM yyyy";

    private LocalDate currentDay = LocalDate.now();

    private CalendarEventHandler calendarEventHandler;
    private HashSet<LocalDate> missedDates;
    private HashSet<LocalDate> scheduledDates;
    private HashSet<LocalDate> readDates;

    private LinearLayout header;
    private ImageView btnPrev;
    private ImageView btnNext;
    private TextView txtDate;
    private GridView grid;

    public CalendarCustomView(Context context) {
        super(context);
    }

    public CalendarCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initControl(context, attrs);
    }

    public CalendarCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initControl(context, attrs);
    }

    /**
     * Load control xml layout
     */
    private void initControl(Context context, AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.calendar_layout, this);

        initElements();
        initClickHandlers();
        initCalendarDates(missedDates, scheduledDates, readDates);
        initDesign();
    }

    private void initElements(){
        header = (LinearLayout) findViewById(R.id.calendar_header);
        btnPrev = (ImageView) findViewById(R.id.calendar_prev_button);
        btnNext = (ImageView) findViewById(R.id.calendar_next_button);
        txtDate = (TextView) findViewById(R.id.calendar_date_display);
        grid = (GridView) findViewById(R.id.calendar_grid);
    }

    private void initClickHandlers() {
        btnNext.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDay = currentDay.plusMonths(1);
                initCalendarDates(scheduledDates, missedDates, readDates);
            }
        });

        btnPrev.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDay = currentDay.minusMonths(1);
                initCalendarDates(scheduledDates, missedDates, readDates);
            }
        });

        grid.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> view, View cell, int position, long id) {
                if (calendarEventHandler == null)
                    return false;

                calendarEventHandler.onDayLongPress((LocalDate) view.getItemAtPosition(position));
                return true;
            }
        });

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                calendarEventHandler.onDayClick((LocalDate) parent.getItemAtPosition(position));
            }
        });
    }

    public void initCalendarDates(HashSet<LocalDate> scheduledDates, HashSet<LocalDate> missedDates, HashSet<LocalDate> readDates){
        this.missedDates = missedDates;
        this.scheduledDates = scheduledDates;
        this.readDates = readDates;
        ArrayList<LocalDate> dateList = new ArrayList<>();
        LocalDate date = currentDay;

        // determine the cell for current month's beginning
        date = date.withDayOfMonth(1);
        int monthBeginningCell = date.getDayOfWeek();

        // move calendar backwards to the beginning of the week
        date = date.minusDays(monthBeginningCell);

        while (dateList.size() < DAYS_COUNT) {
            dateList.add(date);
            date = date.plusDays(1);
        }

        // update grid
        grid.setAdapter(new CalendarAdapter(getContext(), dateList, missedDates, scheduledDates, readDates));

        // update title
        txtDate.setText(currentDay.toString(MONTH_YEAR_FORMAT));
    }

    private void initDesign() {
        header.setBackgroundColor(Color.LTGRAY);
    }

    public void setCalendarEventHandler(CalendarEventHandler calendarEventHandler) {
        this.calendarEventHandler = calendarEventHandler;
    }
}
