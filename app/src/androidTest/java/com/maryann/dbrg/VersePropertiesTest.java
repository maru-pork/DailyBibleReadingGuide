package com.maryann.dbrg;

import android.test.AndroidTestCase;

import com.maryann.dbrg.model.DailyBibleGuide;

import org.joda.time.LocalDate;
import org.junit.Before;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static com.maryann.dbrg.util.VersePropertiesUtil.*;
import static org.joda.time.format.DateTimeFormat.*;

import static com.maryann.dbrg.util.DateUtil.*;
import static org.joda.time.LocalDate.*;

/**
 * Created by Rufo on 10/15/2016.
 */
public class VersePropertiesTest extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Test contents of verse.properties
     * @throws IOException
     */
    public void testPropContents() throws IOException {
        Properties properties = getVerseProperties(mContext);
        assertEquals("1/1/16,Genesis 1-2;Psalm 1;Matthew 1-2", properties.get("1"));
        assertEquals("6/15/16,2 Kings 9-10;Proverbs 15;1 Peter 2-3", properties.get("166"));
        assertEquals("10/8/16,Isaiah 57-58;Psalm 99;Acts 22", properties.get("281"));
        assertEquals("11/22/16,Ezekiel 23-24;Psalm 142;1 Thessalonians 1-2", properties.get("326"));
        assertEquals("12/31/16,Malachi 1-4;Proverbs 31;Revelation 20-22", properties.get("365"));
    }

    /**
     * Test content count of verse.properties.
     * @throws IOException
     */
    public void testPropCount() throws IOException {
        int propertyCount = 365;
        assertEquals(propertyCount, LIST_COUNT);
        assertEquals(propertyCount, constructBibleGuideList(mContext).size());
    }

    /**
     * Test property date format used in verse.properties.
     * @throws IOException
     */
    public void testPropDate() throws IOException {
        String datePattern = "M/d/yy";
        assertEquals(datePattern, DATE_PATTERN);

        Properties properties = getVerseProperties(mContext);
        String[] verseArrFirst = ((String) properties.get("1")).split(",");
        assertEquals("1/1/16,Genesis 1-2;Psalm 1;Matthew 1-2", verseArrFirst[0]+","+verseArrFirst[1]);
        assertEquals(LocalDate.parse("1/1/16", forPattern(DATE_PATTERN)), LocalDate.parse(verseArrFirst[0], forPattern(DATE_PATTERN)));

        String[] verseArrLast = ((String) properties.get("365")).split(",");
        assertEquals("12/31/16,Malachi 1-4;Proverbs 31;Revelation 20-22", verseArrLast[0]+","+verseArrLast[1]);
        assertEquals(LocalDate.parse("12/31/16", forPattern(DATE_PATTERN)), LocalDate.parse(verseArrLast[0], forPattern(DATE_PATTERN)));
    }

    /**
     * Test the construction of BibleGuide.
     * @throws IOException
     */
    public void testConstructBibleGuideList() throws IOException {
        // from verse.properties file
        LocalDate startDate = new LocalDate(2016, 1, 1);
        LocalDate endDate = new LocalDate(2016, 12, 31);
        List<DailyBibleGuide> guides = constructBibleGuideList(mContext);
        assertEqualsConstructGuideList(startDate, endDate, guides);

        // for leap year
        startDate = new LocalDate(2016, 1, 1);
        endDate = new LocalDate(2016, 12, 31);
        guides = constructBibleGuideList(mContext, startDate);
        assertEqualsConstructGuideList(startDate, endDate, guides);

        // for leap year, not start of the year
        startDate = new LocalDate(2016, 2, 1);
        endDate = new LocalDate(2017, 1, 31);
        guides = constructBibleGuideList(mContext, startDate);
        assertEqualsConstructGuideList(startDate, endDate, guides);

        // for not leap year
        startDate = new LocalDate(2017, 1, 1);
        endDate = new LocalDate(2017, 12, 31);
        guides = constructBibleGuideList(mContext, startDate);
        assertEqualsConstructGuideList(startDate, endDate, guides);

        // for not leap year, not start of the year,
        startDate = new LocalDate(2017, 2, 1);
        endDate = new LocalDate(2018, 1, 31);
        guides = constructBibleGuideList(mContext, startDate);
        assertEqualsConstructGuideList(startDate, endDate, guides);
    }

    private void assertEqualsConstructGuideList(LocalDate expectedStartDate, LocalDate expectedEndDate, List<DailyBibleGuide> actual) {
        assertEquals(365, actual.size());
        assertEquals(expectedStartDate.toDate(), actual.get(0).getScheduledDate());
        assertEquals(expectedEndDate.toDate(), actual.get(actual.size()-1).getScheduledDate());
    }

    public void testLeapYearConstructBibleGuideList() throws IOException  {
        List<DailyBibleGuide> guidesFromProp = constructBibleGuideList(mContext);

        LocalDate startDate = new LocalDate(2016, 1, 1);
        List<DailyBibleGuide> guides = constructBibleGuideList(mContext, startDate);

        assertEquals(guidesFromProp.size(), guides.size());
        for (int i=0; i<365; i++) {
            assertEquals(guidesFromProp.get(i).getScheduledDate(), guides.get(i).getScheduledDate());
        }
    }
}
