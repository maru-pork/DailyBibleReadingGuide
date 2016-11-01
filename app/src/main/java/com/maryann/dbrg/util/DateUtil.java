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
    public final static LocalDate CURRENT_DATE = getCurrentDate();
    public final static Calendar CURRENT_CALENDAR = getCurrentCalendar();

    private static LocalDate getCurrentDate() {
        return LocalDate.now();
        
        // for testing purposes onlyss
        /*return convertStringToLocalDate("January 01, 2017", DATE_FORMAT);*/
    }

    private static Calendar getCurrentCalendar() {
        return Calendar.getInstance();

        // for testing purposes only
        /*Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2017);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar;*/
    }

    public static boolean isLeapYear(LocalDate date) {
        return date.year().toInterval().toDuration().getStandardDays() > 365;
    }

    public static boolean isLeapYear(Calendar calendar) {
        return calendar.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
    }

    public static Date getDateIfExists(Long dateInLong) {
        if (dateInLong == null || dateInLong == 0)
            return null;

        return new Date(dateInLong);
    }

    public static Date getDateOrThrow(Long dateInLong) throws Exception {
        if (dateInLong == null || dateInLong == 0)
            throw  new Exception("Value(dateInLong) is required.");

        return getDateIfExists(dateInLong);
    }

    public static LocalDate convertDateToLocalDate(Date date) {
        return new LocalDate(date);
    }

    public static LocalDate convertStringToLocalDate(String date, String pattern) {
        return LocalDate.parse(date,
                DateTimeFormat.forPattern(pattern));
    }

}
