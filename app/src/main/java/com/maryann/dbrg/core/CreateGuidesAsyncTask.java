package com.maryann.dbrg.core;

import android.os.AsyncTask;

import com.maryann.dbrg.service.DailyBibleGuideService;

import java.util.Calendar;

/**
 * Created by Rufo on 5/22/2016.
 */
public class CreateGuidesAsyncTask extends AsyncTask<Void, Void, Boolean> {

    private Calendar currentCalendar;
    private DailyBibleGuideService dbService;

    public CreateGuidesAsyncTask(Calendar currentCalendar, DailyBibleGuideService dbService) {
        this.currentCalendar = currentCalendar;
        this.dbService = dbService;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        dbService.createBibleDailyReadingGuide(currentCalendar);
        return null;
    }
}
