package com.maryann.dbrg.model;

import org.joda.time.LocalDate;

import java.util.Date;
import java.util.HashSet;

/**
 * Created by Rufo on 7/2/2016.
 */
public class Iteration {
    private int iteration;
    private Date startDate;
    private Date endDate;
    private int readCount;
    private int missedCount;
    private int iterationCount;
    private HashSet<LocalDate> scheduledDates;
    private HashSet<LocalDate> missedDates;
    private HashSet<LocalDate> readDates;

    public int getIteration() {
        return iteration;
    }

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getMissedCount() {
        return missedCount;
    }

    public void setMissedCount(int missedCount) {
        this.missedCount = missedCount;
    }

    public int getIterationCount() {
        return iterationCount;
    }

    public void setIterationCount(int iterationCount) {
        this.iterationCount = iterationCount;
    }

    public HashSet<LocalDate> getScheduledDates() {
        return scheduledDates;
    }

    public void setScheduledDates(HashSet<LocalDate> scheduledDates) {
        this.scheduledDates = scheduledDates;
    }

    public HashSet<LocalDate> getMissedDates() {
        return missedDates;
    }

    public void setMissedDates(HashSet<LocalDate> missedDates) {
        this.missedDates = missedDates;
    }

    public HashSet<LocalDate> getReadDates() {
        return readDates;
    }

    public void setReadDates(HashSet<LocalDate> readDates) {
        this.readDates = readDates;
    }
}
