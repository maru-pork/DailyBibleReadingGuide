package com.maryann.dbrg.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.maryann.dbrg.model.BibleDailyReadingGuide;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Rufo on 5/22/2016.
 */
public class DBReader extends SQLiteOpenHelper {

    private static final String EMPTY_STRING = "";
    private static final String EMPTY_SPACE = " ";
    private static final String COMMA_SEP = ",";
    private static final String TEXT_TYPE = "TEXT";
    private static final String INT_TYPE = "INT";

    private static DBReader sInstance;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "dbrg.db";

    public DBReader(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized DBReader getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DBReader(context.getApplicationContext());
        }
        return sInstance;
    }

    public static final String SQL_CREATE_DAILY_BIBLE =
            "CREATE TABLE " + DBContract.DailyBibleGuide.TABLE_NAME + " (" +
                    DBContract.DailyBibleGuide._ID + " INTEGER PRIMARY KEY," +
                    DBContract.DailyBibleGuide.COLUMN_VERSE + EMPTY_SPACE + TEXT_TYPE + COMMA_SEP +
                    DBContract.DailyBibleGuide.COLUMN_DATE_SCHEDULED + EMPTY_SPACE + INT_TYPE + COMMA_SEP +
                    DBContract.DailyBibleGuide.COLUMN_DATE_READ + EMPTY_SPACE + INT_TYPE + COMMA_SEP +
                    DBContract.DailyBibleGuide.COLUMN_IS_MISSED + EMPTY_SPACE + INT_TYPE + COMMA_SEP +
                    DBContract.DailyBibleGuide.COLUMN_ITERATION + EMPTY_SPACE + INT_TYPE + COMMA_SEP +
                    DBContract.DailyBibleGuide.COLUMN_NOTES + EMPTY_SPACE + TEXT_TYPE + " )";

    public static final String SQL_DELETE_DAILY_BIBLE = "DROP TABLE IF EXISTS " + DBContract.DailyBibleGuide.TABLE_NAME;


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_DAILY_BIBLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_DAILY_BIBLE);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void createBibleDailyReadingGuide(List<BibleDailyReadingGuide> bibleDailyReadingGuides) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (BibleDailyReadingGuide bibleDailyReadingGuide : bibleDailyReadingGuides) {
            ContentValues values = new ContentValues();
            values.put(DBContract.DailyBibleGuide.COLUMN_VERSE, bibleDailyReadingGuide.getVerse());
            values.put(DBContract.DailyBibleGuide.COLUMN_DATE_SCHEDULED, bibleDailyReadingGuide.getScheduledDate().getTime());
            values.put(DBContract.DailyBibleGuide.COLUMN_ITERATION, bibleDailyReadingGuide.getIteration());
            values.put(DBContract.DailyBibleGuide.COLUMN_NOTES, EMPTY_STRING);

            db.insert(DBContract.DailyBibleGuide.TABLE_NAME, null, values);
        }
        db.close();
    }

    public void updateBibleDailyReadingGuide(BibleDailyReadingGuide bibleDailyReadingGuide) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBContract.DailyBibleGuide.COLUMN_DATE_READ, bibleDailyReadingGuide.getReadDate().getTime());
        values.put(DBContract.DailyBibleGuide.COLUMN_IS_MISSED, bibleDailyReadingGuide.getMissed() ? 1 : 0);
        values.put(DBContract.DailyBibleGuide.COLUMN_NOTES, bibleDailyReadingGuide.getNotes());

        db.update(DBContract.DailyBibleGuide.TABLE_NAME, values,
                DBContract.DailyBibleGuide._ID + " = ?", new String[]{String.valueOf(bibleDailyReadingGuide.getId())});
    }

    public BibleDailyReadingGuide getDailyReadingGuide(Date date) {
        SQLiteDatabase db = null;
        Cursor res = null;
        BibleDailyReadingGuide bibleDailyReadingGuide = null;
        try {
            db = this.getReadableDatabase();
            res = db.rawQuery(
                    "SELECT * FROM " + DBContract.DailyBibleGuide.TABLE_NAME +
                    " WHERE " + DBContract.DailyBibleGuide.COLUMN_DATE_SCHEDULED + " = " + date.getTime(), null);
            if (res.getCount() > 0) {
                res.moveToFirst();
                while (!res.isAfterLast()) {
                    bibleDailyReadingGuide = new BibleDailyReadingGuide();
                    bibleDailyReadingGuide.setId(res.getLong(res.getColumnIndex(DBContract.DailyBibleGuide._ID)));
                    bibleDailyReadingGuide.setVerse(res.getString(res.getColumnIndex(DBContract.DailyBibleGuide.COLUMN_VERSE)));
                    bibleDailyReadingGuide.setScheduledDate(new Date(res.getLong(res.getColumnIndex(DBContract.DailyBibleGuide.COLUMN_DATE_SCHEDULED))));

                    Long readDate = res.getLong(res.getColumnIndex(DBContract.DailyBibleGuide.COLUMN_DATE_READ));
                    bibleDailyReadingGuide.setReadDate(readDate == 0 ? null : new Date(readDate));

                    int missed = res.getInt(res.getColumnIndex(DBContract.DailyBibleGuide.COLUMN_IS_MISSED));
                    bibleDailyReadingGuide.setMissed(missed != 0);

                    bibleDailyReadingGuide.setIteration(res.getInt(res.getColumnIndex(DBContract.DailyBibleGuide.COLUMN_ITERATION)));
                    bibleDailyReadingGuide.setNotes(res.getString(res.getColumnIndex(DBContract.DailyBibleGuide.COLUMN_NOTES)));

                    res.moveToNext();
                }
            }

        } finally {
            close(db, res);
        }
        return bibleDailyReadingGuide;
    }

    public List<BibleDailyReadingGuide> getGuideListByIteration(int iteration) {
        SQLiteDatabase db = null;
        Cursor res = null;
        List<BibleDailyReadingGuide> dailyList = new ArrayList<>();
        try {
            db = this.getReadableDatabase();
            res = db.rawQuery(
                    "SELECT * FROM " + DBContract.DailyBibleGuide.TABLE_NAME +
                            " WHERE " + DBContract.DailyBibleGuide.COLUMN_ITERATION + " = " + iteration +
                            " ORDER BY " + DBContract.DailyBibleGuide.COLUMN_DATE_SCHEDULED, null);
            if (res.getCount() > 0) {
                res.moveToFirst();
                while (!res.isAfterLast()) {
                    BibleDailyReadingGuide bibleDailyReadingGuide = new BibleDailyReadingGuide();
                    bibleDailyReadingGuide.setId(res.getLong(res.getColumnIndex(DBContract.DailyBibleGuide._ID)));
                    bibleDailyReadingGuide.setVerse(res.getString(res.getColumnIndex(DBContract.DailyBibleGuide.COLUMN_VERSE)));
                    bibleDailyReadingGuide.setScheduledDate(new Date(res.getLong(res.getColumnIndex(DBContract.DailyBibleGuide.COLUMN_DATE_SCHEDULED))));

                    Long readDate = res.getLong(res.getColumnIndex(DBContract.DailyBibleGuide.COLUMN_DATE_READ));
                    bibleDailyReadingGuide.setReadDate(readDate == 0 ? null : new Date(readDate));

                    int missed = res.getInt(res.getColumnIndex(DBContract.DailyBibleGuide.COLUMN_IS_MISSED));
                    bibleDailyReadingGuide.setMissed(missed != 0);

                    bibleDailyReadingGuide.setIteration(res.getInt(res.getColumnIndex(DBContract.DailyBibleGuide.COLUMN_ITERATION)));
                    bibleDailyReadingGuide.setNotes(res.getString(res.getColumnIndex(DBContract.DailyBibleGuide.COLUMN_NOTES)));

                    dailyList.add(bibleDailyReadingGuide);
                    res.moveToNext();
                }
            }

        } finally {
            close(db, res);
        }
        return dailyList;
    }

    public void deleteDailyReadingGuide(int iteration) {
        SQLiteDatabase db = null;
        try {
            db = this.getReadableDatabase();
            db.delete(DBContract.DailyBibleGuide.TABLE_NAME,
                    DBContract.DailyBibleGuide.COLUMN_ITERATION + "=?",
                    new String[]{String.valueOf(iteration)});
        } finally {
            close(db, null);
        }
    }

    /**
     * Closes database and cursor if they are not null.
     *
     * @param sqLiteDatabase to be closed if not null
     * @param cursor         to be closed if not null
     */
    private synchronized void close(SQLiteDatabase sqLiteDatabase, Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
        if (sqLiteDatabase != null) {
            sqLiteDatabase.close();
        }
    }

}
