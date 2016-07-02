package com.maryann.dbrg.util;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Rufo on 5/22/2016.
 */
public class DateUtil {

    public final static String DATE_FORMAT = "MMMM dd, yyyy";
    public final static String MONTH_YEAR_FORMAT = "MMMM yyyy";
    public final static LocalDate CURRENT_DATE = LocalDate.now();;
    public final static Calendar CURRENT_CALENDAR = Calendar.getInstance();;

    public static LocalDate getCurrentDate() {
        // for testing purposes only
        return LocalDate.parse("Jan 1 2017",
                DateTimeFormat.forPattern("MMM d yyyy"));
    }

    public static Calendar getCurrentCalendar() {
        // for testing purposes only
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2017);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar;
    }

    public static boolean isLeapYear(LocalDate date) {
        return date.year().toInterval().toDuration().getStandardDays() > 365;
    }

    public static boolean isLeapYear(Calendar calendar) {
        return calendar.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
    }

    public static LocalDate convertDateToLocalDate(Date date) {
        return new LocalDate(date);
    }

    public static Date convertLocalDateToDate(LocalDate localDate) {
        return localDate.toDate();
    }

}
