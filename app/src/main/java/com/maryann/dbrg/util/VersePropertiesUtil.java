package com.maryann.dbrg.util;

import android.content.Context;
import android.content.res.AssetManager;

import com.maryann.dbrg.model.DailyBibleGuide;

import org.joda.time.LocalDate;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import static org.joda.time.format.DateTimeFormat.forPattern;

/**
 * Created by Rufo on 10/15/2016.
 */
public class VersePropertiesUtil {

    public static final String VERSE_PROPERTIES = "verse.properties";

    public static final int LIST_COUNT = 365;

    public static final String DATE_PATTERN = "M/d/yy";

    public static Properties getVerseProperties(Context mContext) throws IOException {
        AssetManager assetManager = mContext.getAssets();
        InputStream inputStream = assetManager.open(VERSE_PROPERTIES);
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties;
    }

    /**
     * Default construction of BibleGuide. Uses the date given on property file for scheduled date values.
     * @param mContext
     * @return
     * @throws IOException
     */
    public static List<DailyBibleGuide> constructBibleGuideList(Context mContext) throws IOException {
        Properties properties = getVerseProperties(mContext);
        List<DailyBibleGuide> guides = new ArrayList<>();
        for (int propKey = 1; propKey <= LIST_COUNT; propKey++) {
            String[] verseProp = ((String) properties.get(String.valueOf(propKey))).split(",");
            LocalDate scheduledDate = LocalDate.parse(verseProp[0], forPattern(DATE_PATTERN));

            DailyBibleGuide guide = new DailyBibleGuide();
            guide.setVerse(verseProp[1]);
            guide.setScheduledDate(scheduledDate.toDate());
            guide.setIteration(scheduledDate.getYear());
            guides.add(guide);
        }
        return guides;
    }

    /**
     * Customized construction of BibleGuide. Uses the param start date and increments it for scheduled date values.
     * @param mContext
     * @param startDate
     * @return
     * @throws IOException
     */
    public static List<DailyBibleGuide> constructBibleGuideList(Context mContext, LocalDate startDate) throws IOException {
        if (startDate == null) throw new IllegalArgumentException("Start date cannot not be null");

        List<DailyBibleGuide> guides = constructBibleGuideList(mContext);
        int i = 0;
        for (DailyBibleGuide guide : guides) {
            LocalDate scheduledDate = startDate.plusDays(i++);
            if (DateUtil.isLeapYear(startDate)) {
                if (scheduledDate.compareTo(
                        new LocalDate(startDate.getYear(), 2, 29)) == 0) {
                    // add one day to skip February 29
                    startDate = startDate.plusDays(1);
                }
            }
            guide.setScheduledDate(scheduledDate.toDate());
            guide.setIteration(startDate.getYear());
        }
        return guides;
    }

}
