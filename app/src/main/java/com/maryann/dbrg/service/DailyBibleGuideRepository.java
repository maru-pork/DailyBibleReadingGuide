package com.maryann.dbrg.service;

import com.maryann.dbrg.model.DailyBibleGuide;

import java.util.Date;
import java.util.List;

/**
 * Created by Rufo on 9/26/2016.
 */
public interface DailyBibleGuideRepository {

    /**
     * Insert new rows returning the primary key value of the last inserted row
     * @param dailyBibleGuides
     * @return long
     * @throws Exception
     */
    long insertDailyBibleGuide(List<DailyBibleGuide> dailyBibleGuides) throws Exception;

    /**
     *
     * @param dailyBibleGuide
     * @throws Exception
     */
    void updateDailyBibleGuide(DailyBibleGuide dailyBibleGuide) throws Exception;

    /**
     *
     * @param dailyBibleGuide
     * @throws Exception
     */
    void clearDailyBibleGuide(DailyBibleGuide dailyBibleGuide) throws Exception;

    /**
     *
     * @param iteration
     * @throws Exception
     */
    void deleteDailyBibleGuides(Integer iteration) throws Exception;

    /**
     *
     * @return List<DailyBibleGuide>
     * @throws Exception
     */
    List<DailyBibleGuide> getAllDailyBibleGuides() throws Exception;

    /**
     *
     * @param iteration
     * @return
     * @throws Exception
     */
    List<DailyBibleGuide> getAllDailyBibleGuides(Integer iteration) throws Exception;

    /**
     *
     * @param startDate
     * @param endDate
     * @return
     * @throws Exception
     */
    List<DailyBibleGuide> getAllDailyBibleGuides(Date startDate, Date endDate) throws  Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    long getGuidesCount() throws Exception;

    /**
     *
     * @param iteration
     * @return
     * @throws Exception
     */
    long getGuidesCount(Integer iteration) throws  Exception;

    /**
     *
     * @param startDate
     * @param endDate
     * @return
     * @throws Exception
     */
    long getGuidesCount(Date startDate, Date endDate) throws  Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    DailyBibleGuide getDailyBibleGuide(long id) throws  Exception;

    /**
     *
     * @param scheduledDate
     * @return
     * @throws Exception
     */
    DailyBibleGuide getDailyBibleGuide(Date scheduledDate) throws  Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    List<Integer> getIterations() throws  Exception;

    /**
     *
     * @param date
     * @return
     * @throws Exception
     */
    Integer getIteration(Date date) throws  Exception;

}
