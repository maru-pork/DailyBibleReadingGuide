package com.maryann.dbrg.model;

import java.util.Date;

/**
 * Created by Rufo on 9/19/2016.
 */
public class DailyBibleGuide {

    private Long id;
    private String verse;
    private Date scheduledDate;
    private Date readDate;
    private Integer missed;
    private Integer iteration;
    private String notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVerse() {
        return verse;
    }

    public void setVerse(String verse) {
        this.verse = verse;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public Date getReadDate() {
        return readDate;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }

    public Integer getMissed() {
        return missed;
    }

    public void setMissed(Integer missed) {
        this.missed = missed;
    }

    public Boolean getMissedIndicator() {
        return missed == 1;
    }

    public Integer getIteration() {
        return iteration;
    }

    public void setIteration(Integer iteration) {
        this.iteration = iteration;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
