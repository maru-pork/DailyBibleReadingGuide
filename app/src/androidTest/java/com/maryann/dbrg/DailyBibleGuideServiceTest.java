package com.maryann.dbrg;

import android.test.AndroidTestCase;

import com.maryann.dbrg.core.ResultWrapper;
import com.maryann.dbrg.db.DBHelper;
import com.maryann.dbrg.model.DailyBibleGuide;
import com.maryann.dbrg.model.Iteration;
import com.maryann.dbrg.model.SpIterationModel;
import com.maryann.dbrg.service.DailyBibleGuideService;

import org.joda.time.LocalDate;

import java.util.Date;
import java.util.List;

/**
 * Created by Rufo on 9/12/2016.
 */
public class DailyBibleGuideServiceTest extends AndroidTestCase {

    private DailyBibleGuideService service;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        service = new DailyBibleGuideService(new DBHelper(mContext, true), mContext);
    }

    public void testCreateDailyBibleGuide() {
        LocalDate startDate = new LocalDate(2016, 10, 22); // Oct 22, 2016
        ResultWrapper<List<DailyBibleGuide>> result = service.createDailyBibleGuide(startDate);
        assertFalse(result.getEntity().isEmpty());
        assertTrue(result.getErrorMessages().isEmpty());

        result = service.createDailyBibleGuide(null);
        assertFalse(result.getErrorMessages().isEmpty());
        assertEquals("Start Date cannot be null", result.getErrorMessages().get(0));
    }

    public void testGetIterations() {
        LocalDate startDate = new LocalDate(2016, 10, 22); // Oct 22, 2016
        service.createDailyBibleGuide(startDate);

        ResultWrapper<List<SpIterationModel>> resultWrapper = service.getIterations();
        assertEquals(1, resultWrapper.getEntity().size());
        assertEquals(startDate.getYear(), resultWrapper.getEntity().get(0).getIteration());
        assertTrue(resultWrapper.getErrorMessages().isEmpty());
    }

    public void testGetDailyBibleGuide() {
        LocalDate startDate = new LocalDate(2016, 10, 22); // Oct 22, 2016
        service.createDailyBibleGuide(startDate);

        ResultWrapper<DailyBibleGuide> resultWrapper = service.getDailyBibleGuide(startDate.toDate());
        assertNotNull(resultWrapper.getEntity());

        resultWrapper = service.getDailyBibleGuide(null);
        assertFalse(resultWrapper.getErrorMessages().isEmpty());
        assertEquals("Scheduled date cannot be null", resultWrapper.getErrorMessages().get(0));
    }

    public void testGetGuidesByIteration() {
        LocalDate startDate = new LocalDate(2016, 10, 22); // Oct 22, 2016
        service.createDailyBibleGuide(startDate);

        ResultWrapper<List<DailyBibleGuide>> resultWrapper = service.getGuidesByIteration(startDate.getYear());
        assertTrue(resultWrapper.getErrorMessages().isEmpty());
        assertFalse(resultWrapper.getEntity().isEmpty());

        resultWrapper = service.getGuidesByIteration(0);
        assertTrue(resultWrapper.getErrorMessages().isEmpty());
        assertTrue(resultWrapper.getEntity().isEmpty());
    }

    public void testValidateIfIterationExists() {
        LocalDate startDate = new LocalDate(2016, 10, 22); // Oct 22, 2016
        service.createDailyBibleGuide(startDate);

        ResultWrapper<DailyBibleGuide> resultWrapper = service.validateIfIterationExists(new LocalDate(2017, 1, 31), new LocalDate(2017, 12, 31));
        assertFalse(resultWrapper.getErrorMessages().isEmpty());
        assertEquals("There's an existing iteration on the selected start date", resultWrapper.getErrorMessages().get(0));

        resultWrapper = service.validateIfIterationExists(new LocalDate(2016, 1, 31), new LocalDate(2016, 12, 31));
        assertFalse(resultWrapper.getErrorMessages().isEmpty());
        assertEquals("There's an existing iteration on the selected start date", resultWrapper.getErrorMessages().get(0));

        resultWrapper = service.validateIfIterationExists(null, null);
        assertFalse(resultWrapper.getErrorMessages().isEmpty());
        assertEquals("start date nor end date cannot be null", resultWrapper.getErrorMessages().get(0));

        resultWrapper = service.validateIfIterationExists(new LocalDate(2018, 1, 31), new LocalDate(2018, 12, 31));
        assertTrue(resultWrapper.getErrorMessages().isEmpty());
    }

    public void testDeleteDailyBibleGuide() {
        LocalDate startDate = new LocalDate(2016, 10, 22); // Oct 22, 2016
        service.createDailyBibleGuide(startDate);

        ResultWrapper<DailyBibleGuide> resultWrapper = service.deleteDailyBibleGuide(startDate.getYear());
        assertTrue(resultWrapper.getErrorMessages().isEmpty());
    }

    public void testUpdateDailyBibleGuide() {
        LocalDate startDate = new LocalDate(2016, 10, 22); // Oct 22, 2016
        service.createDailyBibleGuide(startDate);

        DailyBibleGuide guideToMarkAsRead = service.getDailyBibleGuide(startDate.toDate()).getEntity();
        // initially read date, missed, notes do not have values
        assertNull(guideToMarkAsRead.getReadDate());
        assertEquals(0, guideToMarkAsRead.getMissed().intValue());
        assertNull(guideToMarkAsRead.getNotes());

        // Scenario 1: No Read date
        ResultWrapper<DailyBibleGuide> resultWrapper = service.updateDailyBibleGuide(guideToMarkAsRead);
        assertEquals("Read Date is required.", resultWrapper.getErrorMessages().get(0));

        // Scenario 2: read date is marked as same with scheduled date
        Date scheduledDate = guideToMarkAsRead.getScheduledDate();
        Date readDate = scheduledDate;
        int missed = new LocalDate(readDate).isAfter(new LocalDate(scheduledDate)) ? 1 : 0;
        assertEquals(0, missed);
        String note = "sample note";

        guideToMarkAsRead.setReadDate(readDate);
        guideToMarkAsRead.setMissed(missed);
        guideToMarkAsRead.setNotes(note);
        assertFalse(guideToMarkAsRead.getMissedIndicator());

        resultWrapper = service.updateDailyBibleGuide(guideToMarkAsRead);
        assertTrue(resultWrapper.getErrorMessages().isEmpty());
        guideToMarkAsRead = service.getDailyBibleGuide(scheduledDate).getEntity();
        assertEquals(readDate, guideToMarkAsRead.getReadDate());
        assertEquals(missed, guideToMarkAsRead.getMissed().intValue());
        assertEquals(note, guideToMarkAsRead.getNotes());
        assertFalse(guideToMarkAsRead.getMissedIndicator());

        // Scenario 3: Clear recently marked as read
        guideToMarkAsRead = service.getDailyBibleGuide(scheduledDate).getEntity();
        assertNotNull(guideToMarkAsRead.getReadDate());
        assertEquals(0, guideToMarkAsRead.getMissed().intValue());
        assertNotNull(guideToMarkAsRead.getNotes());

        guideToMarkAsRead.setReadDate(null);

        resultWrapper = service.updateDailyBibleGuide(guideToMarkAsRead);
        guideToMarkAsRead = service.getDailyBibleGuide(scheduledDate).getEntity();
        assertTrue(resultWrapper.getErrorMessages().isEmpty());
        assertNull(guideToMarkAsRead.getReadDate());
        assertEquals(0, guideToMarkAsRead.getMissed().intValue());
        assertEquals(note, guideToMarkAsRead.getNotes());

        // Scenario 3: read date is marked one day after the scheduled date
        guideToMarkAsRead = service.getDailyBibleGuide(scheduledDate).getEntity();
        scheduledDate = guideToMarkAsRead.getScheduledDate();
        readDate = new LocalDate(scheduledDate).plusDays(1).toDate();
        missed = new LocalDate(readDate).isAfter(new LocalDate(scheduledDate)) ? 1 : 0;
        assertEquals(1, missed);
        note = "sample note late";

        guideToMarkAsRead.setReadDate(readDate);
        guideToMarkAsRead.setMissed(missed);
        guideToMarkAsRead.setNotes(note);
        assertTrue(guideToMarkAsRead.getMissedIndicator());

        resultWrapper = service.updateDailyBibleGuide(guideToMarkAsRead);
        assertTrue(resultWrapper.getErrorMessages().isEmpty());
        guideToMarkAsRead = service.getDailyBibleGuide(scheduledDate).getEntity();
        assertEquals(readDate, guideToMarkAsRead.getReadDate());
        assertEquals(missed, guideToMarkAsRead.getMissed().intValue());
        assertEquals(note, guideToMarkAsRead.getNotes());
        assertTrue(guideToMarkAsRead.getMissedIndicator());
    }
}