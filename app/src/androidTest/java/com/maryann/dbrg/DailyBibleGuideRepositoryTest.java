package com.maryann.dbrg;

import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import com.maryann.dbrg.db.DBHelper;
import com.maryann.dbrg.model.DailyBibleGuide;
import com.maryann.dbrg.service.DailyBibleGuideRepository;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.maryann.dbrg.util.VersePropertiesUtil.constructBibleGuideList;

/**
 * Created by Rufo on 7/3/2016.
 */
public class DailyBibleGuideRepositoryTest extends AndroidTestCase {

    private DailyBibleGuideRepository repository;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        repository = new DBHelper(mContext, true);
    }

    public void testCreateDB() {
        DBHelper dbHelper = new DBHelper(mContext, true);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        assertTrue(db.isOpen());
        db.close();
    }

    /**
     * Test for insertDailyBibleGuide DONE
     * @throws Exception
     */
    public void testInsertDailyBibleGuide() throws Exception {
        List<DailyBibleGuide> guidesFrProp = constructBibleGuideList(mContext);
        long lastInsertedPk = repository.insertDailyBibleGuide(guidesFrProp);
        assertEquals(365, lastInsertedPk);

        List<DailyBibleGuide> guidesFrDb = repository.getAllDailyBibleGuides();
        assertEquals(guidesFrProp.size(), guidesFrDb.size());
        DailyBibleGuide guideFrProp = null;
        DailyBibleGuide result = null;
        for (int x = 0; x < guidesFrDb.size(); x++) {
            guideFrProp = guidesFrProp.get(x);
            result = guidesFrDb.get(x);
            assertEqualsDailyBibleGuideFrProp(guideFrProp, result);
        }
    }

    /**
     * Test for updateDailyBibleGuide and clearDailyBibleGuide DONE
     * @throws Exception
     */
    public void testUpdateClearDailyBibleGuide() throws Exception {
        List<DailyBibleGuide> guidesFrProp = constructBibleGuideList(mContext);
        repository.insertDailyBibleGuide(guidesFrProp);

        // test for updateDailyBibleGuide
        long id = 1;
        DailyBibleGuide guideToUpdate = repository.getDailyBibleGuide(id);
        guideToUpdate.setReadDate(new Date());
        guideToUpdate.setMissed(0);
        guideToUpdate.setNotes("sample note");
        repository.updateDailyBibleGuide(guideToUpdate);
        assertEqualsDailyBibleGuide(guideToUpdate, repository.getDailyBibleGuide(id));

        id = 2;
        guideToUpdate = repository.getDailyBibleGuide(id);
        guideToUpdate.setReadDate(new Date());
        guideToUpdate.setMissed(1);
        guideToUpdate.setNotes("sample note");
        repository.updateDailyBibleGuide(guideToUpdate);
        assertEqualsDailyBibleGuide(guideToUpdate, repository.getDailyBibleGuide(id));

        // test for clearDailyBibleGuide
        id = 3;
        guideToUpdate = repository.getDailyBibleGuide(id);
        guideToUpdate.setReadDate(null);
        guideToUpdate.setMissed(0); // 0 == null
        guideToUpdate.setNotes("notes clear");
        repository.clearDailyBibleGuide(guideToUpdate);
        assertEqualsDailyBibleGuide(guideToUpdate, repository.getDailyBibleGuide(id));
    }

    /**
     * Test for deleteDailyBibleGuides DONE
     * @throws Exception DONE
     */
    public void testDeleteDailyBibleGuides() throws Exception {
        List<DailyBibleGuide> guidesFrProp = new ArrayList<>();
        guidesFrProp.addAll(constructBibleGuideList(mContext, new LocalDate(2016,1,1)));
        guidesFrProp.addAll(constructBibleGuideList(mContext, new LocalDate(2017,1,1)));
        guidesFrProp.addAll(constructBibleGuideList(mContext, new LocalDate(2018,1,1)));
        repository.insertDailyBibleGuide(guidesFrProp);

        assertFalse(repository.getAllDailyBibleGuides(2016).isEmpty());
        assertFalse(repository.getAllDailyBibleGuides(2017).isEmpty());
        assertFalse(repository.getAllDailyBibleGuides(2018).isEmpty());

        repository.deleteDailyBibleGuides(2016);
        assertTrue(repository.getAllDailyBibleGuides(2016).isEmpty());
        assertFalse(repository.getAllDailyBibleGuides(2017).isEmpty());
        assertFalse(repository.getAllDailyBibleGuides(2018).isEmpty());
    }

    /**
     * Test for getAllDailyBibleGuides DONE
     * @throws Exception
     */
    public void testGetAllDailyBibleGuides() throws Exception {
        List<DailyBibleGuide> guidesFrProp = constructBibleGuideList(mContext);
        repository.insertDailyBibleGuide(guidesFrProp);

        // getAllDailyBibleGuides
        List<DailyBibleGuide> guidesFrDb = repository.getAllDailyBibleGuides();
        assertEquals(guidesFrProp.size(), guidesFrDb.size());
        DailyBibleGuide guideFrProp = null;
        DailyBibleGuide result = null;
        for (int x = 0; x < guidesFrDb.size(); x++) {
            guideFrProp = guidesFrProp.get(x);
            result = guidesFrDb.get(x);
            assertEqualsDailyBibleGuideFrProp(guideFrProp, result);
        }

        // getAllDailyBibleGuides by iteration
        guidesFrDb = repository.getAllDailyBibleGuides(2016);
        assertEquals(guidesFrProp.size(), guidesFrDb.size());
        for (int x = 0; x < guidesFrDb.size(); x++) {
            guideFrProp = guidesFrProp.get(x);
            result = guidesFrDb.get(x);
            assertEqualsDailyBibleGuideFrProp(guideFrProp, result);
        }
        guidesFrDb = repository.getAllDailyBibleGuides(2017);
        assertTrue(guidesFrDb.isEmpty());

        // getAllDailyBibleGuides by startDate and endDate
        guidesFrDb = repository.getAllDailyBibleGuides(new LocalDate(2016, 1, 1).toDate(), new LocalDate(2016, 12, 31).toDate());
        assertEquals(guidesFrProp.size(), guidesFrDb.size());
        for (int x = 0; x < guidesFrDb.size(); x++) {
            guideFrProp = guidesFrProp.get(x);
            result = guidesFrDb.get(x);
            assertEqualsDailyBibleGuideFrProp(guideFrProp, result);
        }

        guidesFrDb = repository.getAllDailyBibleGuides(new LocalDate(2016, 1, 1).toDate(), new LocalDate(2016, 11, 30).toDate());
        assertEquals(334, guidesFrDb.size());

        guidesFrDb = repository.getAllDailyBibleGuides(new LocalDate(2015, 1, 1).toDate(), new LocalDate(2015, 12, 31).toDate());
        assertTrue(guidesFrDb.isEmpty());
    }

    /**
     * Test for getGuidesCount DONE
     * @throws Exception
     */
    public void testGetGuidesCount() throws Exception {
        List<DailyBibleGuide> guidesFrProp = constructBibleGuideList(mContext);
        repository.insertDailyBibleGuide(guidesFrProp);
        int expectedCount = guidesFrProp.size(); // 365

        // getGuidesCount
        assertEquals(expectedCount, repository.getGuidesCount());

        // getGuidesCount by iteration
        assertEquals(expectedCount, repository.getGuidesCount(2016));
        assertEquals(0, repository.getGuidesCount(2015));

        // getGuidesCount by startDate and endDate
        assertEquals(expectedCount, repository.getGuidesCount(new LocalDate(2016, 1, 1).toDate(), new LocalDate(2016, 12, 31).toDate()));
        assertEquals(334, repository.getGuidesCount(new LocalDate(2016, 1, 1).toDate(), new LocalDate(2016, 11, 30).toDate()));
        assertEquals(0, repository.getGuidesCount(new LocalDate(2015, 1, 1).toDate(), new LocalDate(2015, 12, 31).toDate()));
    }

    /**
     * Test for getDailyBibleGuide DONE
     * @throws Exception
     */
    public void testGetDailyBibleGuide() throws Exception {
        List<DailyBibleGuide> guidesFrProp = constructBibleGuideList(mContext);
        repository.insertDailyBibleGuide(guidesFrProp);

        // getDailyBibleGuide by ID
        DailyBibleGuide guideFrProp = null;
        DailyBibleGuide result = null;
        for (int x = 0; x < guidesFrProp.size(); x++) {
            guideFrProp = guidesFrProp.get(x);
            result = repository.getDailyBibleGuide(x + 1);

            assertEqualsDailyBibleGuideFrProp(guideFrProp, result);
        }
        assertNull(repository.getDailyBibleGuide(366));

        // getDailyBibleGuide by date
        for (int x = 0; x < guidesFrProp.size(); x++) {
            guideFrProp = guidesFrProp.get(x);
            result = repository.getDailyBibleGuide(guideFrProp.getScheduledDate());

            assertEqualsDailyBibleGuideFrProp(guideFrProp, result);
        }
        assertNull(repository.getDailyBibleGuide(new LocalDate(2017, 1, 31).toDate()));
    }

    /**
     * Test for getIterations and getIteration DONE
     * @throws Exception
     */
    public void testGetIterations() throws Exception {
        List<DailyBibleGuide> guidesFrProp = new ArrayList<>();
        guidesFrProp.addAll(constructBibleGuideList(mContext, new LocalDate(2016,1,1)));
        guidesFrProp.addAll(constructBibleGuideList(mContext, new LocalDate(2017,1,1)));
        guidesFrProp.addAll(constructBibleGuideList(mContext, new LocalDate(2018,1,1)));
        guidesFrProp.addAll(constructBibleGuideList(mContext, new LocalDate(2019,10,22)));
        repository.insertDailyBibleGuide(guidesFrProp);

        // test for getIterations
        List<Integer> iterations = repository.getIterations();
        assertEquals(Arrays.asList(new Integer[]{2019, 2018,2017,2016}), iterations);

        // test for getIteration by date
        Integer iteration = repository.getIteration(new LocalDate(2016, 1, 1).toDate());
        assertEquals(2016, iteration.intValue());

        iteration = repository.getIteration(new LocalDate(2019, 1, 1).toDate());
        assertEquals(0, iteration.intValue());

        iteration = repository.getIteration(new LocalDate(2020, 1, 1).toDate());
        assertEquals(2019, iteration.intValue());
    }

    private void assertEqualsDailyBibleGuideFrProp(DailyBibleGuide guideFrProp, DailyBibleGuide result) {
        assertNotNull(result.getId().longValue());
        assertEquals(guideFrProp.getVerse(), result.getVerse());
        assertEquals(guideFrProp.getScheduledDate(), result.getScheduledDate());
        assertNull(result.getReadDate());
        assertEquals(0, result.getMissed().intValue());
        assertEquals(guideFrProp.getIteration(), result.getIteration());
        assertNull(result.getNotes());

        assertFalse(result.getMissedIndicator().booleanValue());
    }

    private void assertEqualsDailyBibleGuide(DailyBibleGuide expected, DailyBibleGuide actual) {
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getVerse(), actual.getVerse());
        assertEquals(expected.getScheduledDate(), actual.getScheduledDate());
        assertEquals(expected.getReadDate(), actual.getReadDate());
        assertEquals(expected.getMissed(), actual.getMissed());
        assertEquals(expected.getIteration(), actual.getIteration());
        assertEquals(expected.getNotes(), actual.getNotes());

        assertEquals(expected.getMissedIndicator(), actual.getMissedIndicator());
    }

}
