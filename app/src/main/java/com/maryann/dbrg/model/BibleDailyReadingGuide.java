package com.maryann.dbrg.model;

import java.util.Date;

/**
 * Created by Rufo on 5/22/2016.
 */
public class BibleDailyReadingGuide {

    private Long id;
    private String verse;
    private Date scheduledDate;
    private Date readDate;
    private Boolean isMissed;
    private Integer iteration;
    private String notes;

    public BibleDailyReadingGuide() {

    }

    public BibleDailyReadingGuide(Date scheduledDate, String verse) {
        this.scheduledDate = scheduledDate;
        this.verse = verse;
    }

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

    public Boolean getMissed() {
        return isMissed;
    }

    public void setMissed(Boolean missed) {
        isMissed = missed;
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
