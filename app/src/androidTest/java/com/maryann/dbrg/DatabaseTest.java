package com.maryann.dbrg;

import android.test.AndroidTestCase;

import com.maryann.dbrg.db.DBReader;
import com.maryann.dbrg.util.DateUtil;

import junit.framework.Assert;

import java.util.logging.Logger;

/**
 * Created by Rufo on 7/3/2016.
 */
public class DatabaseTest extends AndroidTestCase {

    public void testGetDailyReadingGuideCount() {
        DBReader dbReader = new DBReader(mContext);
        long count = dbReader.getDailyReadingGuideCount(
                DateUtil.convertStringToLocalDate("January 01, 2016", DateUtil.DATE_FORMAT).toDate(),
                DateUtil.convertStringToLocalDate("December 30, 2016", DateUtil.DATE_FORMAT).toDate());
        assertFalse(count==0);
    }
}
