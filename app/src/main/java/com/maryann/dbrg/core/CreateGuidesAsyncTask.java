package com.maryann.dbrg.core;

import android.os.AsyncTask;

import com.maryann.dbrg.service.DailyBibleGuideService;

import org.joda.time.LocalDate;

/**
 * Created by Rufo on 5/22/2016.
 */
public class CreateGuidesAsyncTask extends AsyncTask<Void, Void, Boolean> {

    private LocalDate startDate;
    private DailyBibleGuideService dbService;

    public CreateGuidesAsyncTask(LocalDate startDate, DailyBibleGuideService dbService) {
        this.startDate = startDate;
        this.dbService = dbService;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        dbService.createDailyBibleGuide(startDate);
        return null;
    }
}
