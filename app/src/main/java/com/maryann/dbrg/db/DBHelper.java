package com.maryann.dbrg.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.maryann.dbrg.model.DailyBibleGuide;
import com.maryann.dbrg.service.DailyBibleGuideRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.maryann.dbrg.db.DBContract.DailyBible;
import static com.maryann.dbrg.util.DateUtil.getDateIfExists;
import static com.maryann.dbrg.util.DateUtil.getDateOrThrow;

/**
 * Created by Rufo on 9/26/2016.
 */
public class DBHelper extends SQLiteOpenHelper implements DailyBibleGuideRepository {

    private static DBHelper sInstance;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "bible_guide.db";
    private static boolean isTest;

    private static final String COMMA_SEP = ",";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INT";
    private static final String SQL_CREATE_TBL_DAILY_BIBLE;
    private static final String SQL_DELETE_TBL_DAILY_BIBLE;
    static {
        SQL_CREATE_TBL_DAILY_BIBLE = "CREATE TABLE " + DailyBible.TABLE_NAME + " (" +
                DailyBible._ID + " INTEGER PRIMARY KEY," +
                DailyBible.COLUMN_VERSE + TEXT_TYPE + COMMA_SEP +
                DailyBible.COLUMN_DATE_SCHEDULED + INT_TYPE + COMMA_SEP +
                DailyBible.COLUMN_DATE_READ + INT_TYPE + COMMA_SEP +
                DailyBible.COLUMN_IS_MISSED + INT_TYPE + COMMA_SEP +
                DailyBible.COLUMN_ITERATION + INT_TYPE + COMMA_SEP +
                DailyBible.COLUMN_NOTES + TEXT_TYPE + " )";
        SQL_DELETE_TBL_DAILY_BIBLE = "DROP TABLE IF EXISTS " + DailyBible.TABLE_NAME;
    }

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Constructor used for testing only
     * @param context
     * @param isTest
     */
    public DBHelper(Context context, boolean isTest) {
        super(context, null, null, DATABASE_VERSION);
        this.isTest = isTest;
    }

    public static synchronized DBHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DBHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TBL_DAILY_BIBLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TBL_DAILY_BIBLE);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    @Override
    public long insertDailyBibleGuide(List<DailyBibleGuide> dailyBibleGuides) throws Exception {
        SQLiteDatabase db = null;
        long result = 0;
        try {
            db = this.getWritableDatabase();
            db.beginTransaction();
            for (DailyBibleGuide dailyBibleGuide : dailyBibleGuides) {
                ContentValues values = new ContentValues();
                values.put(DailyBible.COLUMN_VERSE, dailyBibleGuide.getVerse());
                values.put(DailyBible.COLUMN_DATE_SCHEDULED, dailyBibleGuide.getScheduledDate().getTime());
                values.put(DailyBible.COLUMN_ITERATION, dailyBibleGuide.getIteration());

                result = db.insert(DailyBible.TABLE_NAME, null, values);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            close(db);
        }
        return result;
    }

    @Override
    public void updateDailyBibleGuide(DailyBibleGuide dailyBibleGuide) throws Exception {
        SQLiteDatabase db = null;
        try {
            db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(DailyBible.COLUMN_DATE_READ, dailyBibleGuide.getReadDate().getTime());
            values.put(DailyBible.COLUMN_IS_MISSED, dailyBibleGuide.getMissed());
            values.put(DailyBible.COLUMN_NOTES, dailyBibleGuide.getNotes());

            String whereClause = DailyBible._ID + "=?";
            String[] whereArgs = new String[]{String.valueOf(dailyBibleGuide.getId())};
            db.update(DailyBible.TABLE_NAME, values, whereClause, whereArgs);
        } finally {
            close(db);
        }
    }

    @Override
    public void clearDailyBibleGuide(DailyBibleGuide dailyBibleGuide) throws Exception {
        SQLiteDatabase db = null;
        try {
            db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.putNull(DailyBible.COLUMN_DATE_READ);
            values.putNull(DailyBible.COLUMN_IS_MISSED);
            values.put(DailyBible.COLUMN_NOTES, dailyBibleGuide.getNotes());

            String whereClause = DailyBible._ID + "=?";
            String[] whereArgs = new String[]{String.valueOf(dailyBibleGuide.getId())};
            db.update(DailyBible.TABLE_NAME, values, whereClause, whereArgs);
        } finally {
            close(db);
        }
    }

    @Override
    public void deleteDailyBibleGuides(Integer iteration) throws Exception {
        SQLiteDatabase db = null;
        try {
            db = this.getWritableDatabase();
            String whereClause = DailyBible.COLUMN_ITERATION + "=?";
            String[] whereArgs = new String[]{String.valueOf(iteration)};
            db.delete(DailyBible.TABLE_NAME, whereClause, whereArgs);
        } finally {
            close(db);
        }
    }

    public List<DailyBibleGuide> getAllDailyBibleGuides() throws Exception {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        List<DailyBibleGuide> results = new ArrayList<>();
        try {
            db = this.getReadableDatabase();
            String orderBy = DailyBible._ID + " ASC";
            cursor = db.query(DailyBible.TABLE_NAME, null, null, null, null, null, orderBy);
            while (cursor.moveToNext()) {
                results.add(constructDailyBibleFrCursor(cursor));
            }
        } finally {
            close(db, cursor);
        }
        return results;
    }

    @Override
    public List<DailyBibleGuide> getAllDailyBibleGuides(Integer iteration) throws Exception {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        List<DailyBibleGuide> results = new ArrayList<>();
        try {
            db = this.getReadableDatabase();
            String selection = DailyBible.COLUMN_ITERATION + "=?";
            String[] selectionArgs = new String[]{String.valueOf(iteration)};
            String orderBy = DailyBible._ID + " ASC";
            cursor = db.query(DailyBible.TABLE_NAME, null, selection, selectionArgs, null, null, orderBy);
            while (cursor.moveToNext()) {
                results.add(constructDailyBibleFrCursor(cursor));
            }
        } finally {
            close(db, cursor);
        }
        return results;
    }

    @Override
    public List<DailyBibleGuide> getAllDailyBibleGuides(Date startDate, Date endDate) throws Exception {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        List<DailyBibleGuide> results = new ArrayList<>();
        try {
            db = this.getReadableDatabase();
            String selection = DailyBible.COLUMN_DATE_SCHEDULED + ">=? AND " + DailyBible.COLUMN_DATE_SCHEDULED + "<=?";
            String[] selectionArgs = new String[]{String.valueOf(startDate.getTime()), String.valueOf(endDate.getTime())};
            String orderBy = DailyBible._ID + " ASC";
            cursor = db.query(DailyBible.TABLE_NAME, null, selection, selectionArgs, null, null, orderBy);
            while (cursor.moveToNext()) {
                results.add(constructDailyBibleFrCursor(cursor));
            }
        } finally {
            close(db, cursor);
        }
        return results;
    }

    @Override
    public long getGuidesCount() throws Exception {
        SQLiteDatabase db = null;
        long count = 0;
        try {
            db = this.getReadableDatabase();
            count = DatabaseUtils.queryNumEntries(db, DailyBible.TABLE_NAME, null, null);
        } finally {
            close(db);
        }
        return count;
    }

    @Override
    public long getGuidesCount(Integer iteration) throws Exception {
        SQLiteDatabase db = null;
        long count = 0;
        try {
            db = this.getReadableDatabase();
            String selection = DailyBible.COLUMN_ITERATION + "=?";
            String[] selectionArgs = new String[]{iteration.toString()};
            count = DatabaseUtils.queryNumEntries(db, DailyBible.TABLE_NAME, selection, selectionArgs);
        } finally {
            close(db);
        }
        return count;
    }

    @Override
    public long getGuidesCount(Date startDate, Date endDate) throws Exception {
        SQLiteDatabase db = null;
        long count = 0;
        try {
            db = this.getReadableDatabase();
            String selection = DailyBible.COLUMN_DATE_SCHEDULED + ">=? AND " + DailyBible.COLUMN_DATE_SCHEDULED + "<=?";
            String[] selectionArgs = new String[]{String.valueOf(startDate.getTime()), String.valueOf(endDate.getTime())};
            count = DatabaseUtils.queryNumEntries(db, DailyBible.TABLE_NAME, selection, selectionArgs);
        } finally {
            close(db);
        }
        return count;
    }

    @Override
    public DailyBibleGuide getDailyBibleGuide(long id) throws Exception {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        DailyBibleGuide dailyBibleGuide = null;
        try {
            db = this.getReadableDatabase();
            String selection = DailyBible._ID + "=?";
            String[] selectionArgs = new String[]{String.valueOf(id)};
            String limit = "1";
            cursor = db.query(DailyBible.TABLE_NAME, null, selection, selectionArgs, null, null, null, limit);
            if (cursor.moveToFirst()) {
                dailyBibleGuide = constructDailyBibleFrCursor(cursor);
            }
        } finally {
            close(db, cursor);
        }
        return dailyBibleGuide;
    }

    @Override
    public DailyBibleGuide getDailyBibleGuide(Date scheduledDate) throws Exception {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        DailyBibleGuide dailyBibleGuide = null;
        try {
            db = this.getReadableDatabase();
            String selection = DailyBible.COLUMN_DATE_SCHEDULED + "=?";
            String[] selectionArgs = new String[]{String.valueOf(scheduledDate.getTime())};
            String limit = "1";
            cursor = db.query(DailyBible.TABLE_NAME, null, selection, selectionArgs, null, null, null, limit);
            if (cursor.moveToFirst()) {
                dailyBibleGuide = constructDailyBibleFrCursor(cursor);
            }
        } finally {
            close(db, cursor);
        }
        return dailyBibleGuide;
    }

    @Override
    public List<Integer> getIterations() throws Exception {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        List<Integer> iterations = new ArrayList<>();
        try {
            db = this.getReadableDatabase();
            String[] columns = new String[]{DailyBible.COLUMN_ITERATION};
            String groupBy = DailyBible.COLUMN_ITERATION;
            String orderBy = DailyBible.COLUMN_ITERATION + " DESC";
            cursor = db.query(true, DailyBible.TABLE_NAME, columns, null, null, groupBy, null, orderBy, null);
            while (cursor.moveToNext()) {
                iterations.add(cursor.getInt(cursor.getColumnIndex(DailyBible.COLUMN_ITERATION)));
            }
        } finally {
            close(db, cursor);
        }
        return iterations;
    }

    @Override
    public Integer getIteration(Date date) throws Exception {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        Integer iteration = 0;
        try {
            db = this.getReadableDatabase();
            String selection = DailyBible.COLUMN_DATE_SCHEDULED + "=?";
            String[] selectionArgs = new String[]{String.valueOf(date.getTime())};
            String limit = "1";
            cursor = db.query(DailyBible.TABLE_NAME, new String[]{DailyBible.COLUMN_ITERATION}, selection, selectionArgs, null, null, null, limit);
            if (cursor.moveToFirst()) {
                iteration = cursor.getInt(cursor.getColumnIndex(DailyBible.COLUMN_ITERATION));
            }
        } finally {
            close(db, cursor);
        }
        return iteration;
    }

    private DailyBibleGuide constructDailyBibleFrCursor(Cursor cursor) throws  Exception {
        DailyBibleGuide dailyBibleGuide = new DailyBibleGuide();
        dailyBibleGuide.setId(cursor.getLong(cursor.getColumnIndex(DailyBible._ID)));
        dailyBibleGuide.setVerse(cursor.getString(cursor.getColumnIndex(DailyBible.COLUMN_VERSE)));
        dailyBibleGuide.setScheduledDate(getDateOrThrow(cursor.getLong(cursor.getColumnIndex(DailyBible.COLUMN_DATE_SCHEDULED))));
        dailyBibleGuide.setReadDate(getDateIfExists(cursor.getLong(cursor.getColumnIndex(DailyBible.COLUMN_DATE_READ))));
        dailyBibleGuide.setMissed(cursor.getInt(cursor.getColumnIndex(DailyBible.COLUMN_IS_MISSED)));
        dailyBibleGuide.setIteration(cursor.getInt(cursor.getColumnIndex(DailyBible.COLUMN_ITERATION)));
        dailyBibleGuide.setNotes(cursor.getString(cursor.getColumnIndex(DailyBible.COLUMN_NOTES)));
        return dailyBibleGuide;
    }

    /**
     * Closes database and cursor if they are not null.
     * @param sqLiteDatabase to be closed if not null
     * @param cursor         to be closed if not null
     */
    private synchronized void close(SQLiteDatabase sqLiteDatabase, Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
        close(sqLiteDatabase);
    }

    /**
     * Closes database if they are not null.
     * @param sqLiteDatabase
     */
    private synchronized void close(SQLiteDatabase sqLiteDatabase) {
        if (sqLiteDatabase != null && sqLiteDatabase.isOpen()) {
            if (!isTest) sqLiteDatabase.close();
        }
    }
}
