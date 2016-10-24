package com.maryann.dbrg.db;

import android.provider.BaseColumns;

/**
 * Created by Rufo on 5/22/2016.
 */
public class DBContract {

    private DBContract() {}

    public static abstract class DailyBible implements BaseColumns {
        public static final String TABLE_NAME = "daily_bible";
        public static final String COLUMN_VERSE = "verse";
        public static final String COLUMN_DATE_SCHEDULED = "scheduled_date";
        public static final String COLUMN_DATE_READ = "read_date";
        public static final String COLUMN_IS_MISSED = "is_missed";
        public static final String COLUMN_ITERATION = "iteration";
        public static final String COLUMN_NOTES = "notes";
    }

}
