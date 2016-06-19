package com.maryann.dbrg.view;

import org.joda.time.LocalDate;

/**
 * Created by Rufo on 5/22/2016.
 */
public interface CalendarEventHandler {

    void onDayLongPress(LocalDate date);

    void onDayClick(LocalDate date);

}
