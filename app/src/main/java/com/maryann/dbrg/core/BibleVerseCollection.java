package com.maryann.dbrg.core;

import com.maryann.dbrg.model.BibleDailyReadingGuide;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rufo on 5/22/2016.
 *
 * Source: A Pocketful of Promises For Women, Lighthouse Inspirational Books &amp; Gifts, Inc.
 */
public class BibleVerseCollection {

    private static final String EMPTY_SPACE = " ";
    private List<BibleDailyReadingGuide> verseList;
    private Integer verseCount;

    public BibleVerseCollection() {
        verseList = new ArrayList<BibleDailyReadingGuide>();
        /**January*/
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-01").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "1-2;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "1;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-02").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "3-4;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "2;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-03").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "5-7;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "3;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "5" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-04").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "8-9;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "4;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "6-7" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-05").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "10-11;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "5;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "8-9" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-06").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "12-13;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "6;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "10-11" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-07").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "14-15;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "7;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "12" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-08").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "16-17;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "8;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "13" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-09").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "18-19;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "9;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "14-15" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-10").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "20-21;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "10;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "16-17" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-11").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "22-23;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "11;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "18" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-12").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "24;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "12;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "19-20" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-13").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "25-26;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "13;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "21" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-14").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "27-28;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "14;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "22" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-15").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "29-30;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "15;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "23" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-16").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "31-32;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "16;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "24" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-17").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "33-34;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "17;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "25" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-18").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "35-36;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "18;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "26" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-19").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "37-38;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "19;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "27" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-20").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "39-40;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "20;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "28" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-21").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "41-42;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "21;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "1" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-22").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "43-44;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "22;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-23").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "45-46;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "23;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "3" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-24").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "47-48;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "24;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-25").toDate(), BibleVerseEnum.GENESIS.getDesc() + EMPTY_SPACE + "49-50;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "25;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "5" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-26").toDate(), BibleVerseEnum.EXODUS.getDesc() + EMPTY_SPACE + "1-2;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "26;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "6" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-27").toDate(), BibleVerseEnum.EXODUS.getDesc() + EMPTY_SPACE + "3-4;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "27;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "7" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-28").toDate(), BibleVerseEnum.EXODUS.getDesc() + EMPTY_SPACE + "5-6;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "28;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "8" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-29").toDate(), BibleVerseEnum.EXODUS.getDesc() + EMPTY_SPACE + "7-8;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "29;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "9" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-30").toDate(), BibleVerseEnum.EXODUS.getDesc() + EMPTY_SPACE + "9-10;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "30;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "10" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-01-31").toDate(), BibleVerseEnum.EXODUS.getDesc() + EMPTY_SPACE + "11-12;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "31;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "11" ));


        /**February*/
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-01").toDate(), BibleVerseEnum.EXODUS.getDesc() + EMPTY_SPACE + "13-14;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "32;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "12" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-02").toDate(), BibleVerseEnum.EXODUS.getDesc() + EMPTY_SPACE + "15-16;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "33;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "13" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-03").toDate(), BibleVerseEnum.EXODUS.getDesc() + EMPTY_SPACE + "17-18;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "34;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "14" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-04").toDate(), BibleVerseEnum.EXODUS.getDesc() + EMPTY_SPACE + "19-20;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "35;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "15" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-05").toDate(), BibleVerseEnum.EXODUS.getDesc() + EMPTY_SPACE + "21-22;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "36;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "16" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-06").toDate(), BibleVerseEnum.EXODUS.getDesc() + EMPTY_SPACE + "23-24;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "37;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "1" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-07").toDate(), BibleVerseEnum.EXODUS.getDesc() + EMPTY_SPACE + "25-26;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "38;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-08").toDate(), BibleVerseEnum.EXODUS.getDesc() + EMPTY_SPACE + "27-28;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "39;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "3" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-09").toDate(), BibleVerseEnum.EXODUS.getDesc() + EMPTY_SPACE + "29-30;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "40;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-10").toDate(), BibleVerseEnum.EXODUS.getDesc() + EMPTY_SPACE + "31-32;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "41;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "5" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-11").toDate(), BibleVerseEnum.EXODUS.getDesc() + EMPTY_SPACE + "33-34;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "42;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "6" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-12").toDate(), BibleVerseEnum.EXODUS.getDesc() + EMPTY_SPACE + "35-36;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "43;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "7" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-13").toDate(), BibleVerseEnum.EXODUS.getDesc() + EMPTY_SPACE + "37-38;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "44;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "8" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-14").toDate(), BibleVerseEnum.EXODUS.getDesc() + EMPTY_SPACE + "39-40;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "45;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "9" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-15").toDate(), BibleVerseEnum.LEVITICUS.getDesc() + EMPTY_SPACE + "1-2;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "46;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "10" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-16").toDate(), BibleVerseEnum.LEVITICUS.getDesc() + EMPTY_SPACE + "3-4;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "47;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "11" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-17").toDate(), BibleVerseEnum.LEVITICUS.getDesc() + EMPTY_SPACE + "5-6;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "48;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "12" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-18").toDate(), BibleVerseEnum.LEVITICUS.getDesc() + EMPTY_SPACE + "7-8;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "49;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "13" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-19").toDate(), BibleVerseEnum.LEVITICUS.getDesc() + EMPTY_SPACE + "9-10;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "50;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "14" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-20").toDate(), BibleVerseEnum.LEVITICUS.getDesc() + EMPTY_SPACE + "11-12;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "51;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "15" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-21").toDate(), BibleVerseEnum.LEVITICUS.getDesc() + EMPTY_SPACE + "13;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "52;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "16" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-22").toDate(), BibleVerseEnum.LEVITICUS.getDesc() + EMPTY_SPACE + "14;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "53;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "17" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-23").toDate(), BibleVerseEnum.LEVITICUS.getDesc() + EMPTY_SPACE + "15-16;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "54;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "18" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-24").toDate(), BibleVerseEnum.LEVITICUS.getDesc() + EMPTY_SPACE + "17-18;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "55;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "19" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-25").toDate(), BibleVerseEnum.LEVITICUS.getDesc() + EMPTY_SPACE + "19-20;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "56;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "20" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-26").toDate(), BibleVerseEnum.LEVITICUS.getDesc() + EMPTY_SPACE + "21-22;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "57;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "21" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-27").toDate(), BibleVerseEnum.LEVITICUS.getDesc() + EMPTY_SPACE + "23-24;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "58;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "22" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-02-28").toDate(), BibleVerseEnum.LEVITICUS.getDesc() + EMPTY_SPACE + "25;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "59;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "23" ));

        /**March*/
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-01").toDate(), BibleVerseEnum.LEVITICUS.getDesc() + EMPTY_SPACE + "26-27;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "60;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "24" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-02").toDate(), BibleVerseEnum.NUMBERS.getDesc() + EMPTY_SPACE + "1-2;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "61;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "1" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-03").toDate(), BibleVerseEnum.NUMBERS.getDesc() + EMPTY_SPACE + "3-4;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "62;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "2-3" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-04").toDate(), BibleVerseEnum.NUMBERS.getDesc() + EMPTY_SPACE + "5-6;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "63;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-05").toDate(), BibleVerseEnum.NUMBERS.getDesc() + EMPTY_SPACE + "7;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "64;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "5" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-06").toDate(), BibleVerseEnum.NUMBERS.getDesc() + EMPTY_SPACE + "8-9;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "65;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "6" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-07").toDate(), BibleVerseEnum.NUMBERS.getDesc() + EMPTY_SPACE + "10-11;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "66;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "7" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-08").toDate(), BibleVerseEnum.NUMBERS.getDesc() + EMPTY_SPACE + "12-13;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "67;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "8" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-09").toDate(), BibleVerseEnum.NUMBERS.getDesc() + EMPTY_SPACE + "14-15;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "68;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "9" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-10").toDate(), BibleVerseEnum.NUMBERS.getDesc() + EMPTY_SPACE + "16;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "69;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "10" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-11").toDate(), BibleVerseEnum.NUMBERS.getDesc() + EMPTY_SPACE + "17-18;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "70;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "11" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-12").toDate(), BibleVerseEnum.NUMBERS.getDesc() + EMPTY_SPACE + "19-20;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "71;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "12" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-13").toDate(), BibleVerseEnum.NUMBERS.getDesc() + EMPTY_SPACE + "21-22;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "72;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "13" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-14").toDate(), BibleVerseEnum.NUMBERS.getDesc() + EMPTY_SPACE + "23-24;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "73;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "14-15" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-15").toDate(), BibleVerseEnum.NUMBERS.getDesc() + EMPTY_SPACE + "25-26;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "74;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "16" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-16").toDate(), BibleVerseEnum.NUMBERS.getDesc() + EMPTY_SPACE + "27-28;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "75;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "17" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-17").toDate(), BibleVerseEnum.NUMBERS.getDesc() + EMPTY_SPACE + "29-30;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "76;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "18" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-18").toDate(), BibleVerseEnum.NUMBERS.getDesc() + EMPTY_SPACE + "31-32;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "77;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "19" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-19").toDate(), BibleVerseEnum.NUMBERS.getDesc() + EMPTY_SPACE + "33-34;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "78;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "20" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-20").toDate(), BibleVerseEnum.NUMBERS.getDesc() + EMPTY_SPACE + "35-36;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "79;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "21" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-21").toDate(), BibleVerseEnum.DEUTERONOMY.getDesc() + EMPTY_SPACE + "1-2;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "80;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "1" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-22").toDate(), BibleVerseEnum.DEUTERONOMY.getDesc() + EMPTY_SPACE + "3-4;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "81;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-23").toDate(), BibleVerseEnum.DEUTERONOMY.getDesc() + EMPTY_SPACE + "5-6;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "82;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-24").toDate(), BibleVerseEnum.DEUTERONOMY.getDesc() + EMPTY_SPACE + "7-8;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "83;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "5-6" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-25").toDate(), BibleVerseEnum.DEUTERONOMY.getDesc() + EMPTY_SPACE + "9-10;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "84;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "7" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-26").toDate(), BibleVerseEnum.DEUTERONOMY.getDesc() + EMPTY_SPACE + "11-12;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "85;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "8" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-27").toDate(), BibleVerseEnum.DEUTERONOMY.getDesc() + EMPTY_SPACE + "13-14;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "86;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "9" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-28").toDate(), BibleVerseEnum.DEUTERONOMY.getDesc() + EMPTY_SPACE + "15-16;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "87;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "10" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-29").toDate(), BibleVerseEnum.DEUTERONOMY.getDesc() + EMPTY_SPACE + "17-18;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "88;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "11-12" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-30").toDate(), BibleVerseEnum.DEUTERONOMY.getDesc() + EMPTY_SPACE + "19-20;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "89;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "13" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-03-31").toDate(), BibleVerseEnum.DEUTERONOMY.getDesc() + EMPTY_SPACE + "21-22;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "90;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "14" ));

        /**April*/
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-01").toDate(), BibleVerseEnum.DEUTERONOMY.getDesc() + EMPTY_SPACE + "23-24;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "91;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "15" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-02").toDate(), BibleVerseEnum.DEUTERONOMY.getDesc() + EMPTY_SPACE + "25-27;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "92;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "16" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-03").toDate(), BibleVerseEnum.DEUTERONOMY.getDesc() + EMPTY_SPACE + "28-29;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "93;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "17" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-04").toDate(), BibleVerseEnum.DEUTERONOMY.getDesc() + EMPTY_SPACE + "30-31;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "94;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "18" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-05").toDate(), BibleVerseEnum.DEUTERONOMY.getDesc() + EMPTY_SPACE + "32;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "95;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "19" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-06").toDate(), BibleVerseEnum.DEUTERONOMY.getDesc() + EMPTY_SPACE + "33-34;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "96;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "20" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-07").toDate(), BibleVerseEnum.JOSHUA.getDesc() + EMPTY_SPACE + "1-2;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "97;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "21" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-08").toDate(), BibleVerseEnum.JOSHUA.getDesc() + EMPTY_SPACE + "3-4;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "98;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "22" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-09").toDate(), BibleVerseEnum.JOSHUA.getDesc() + EMPTY_SPACE + "5-6;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "99;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "23" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-10").toDate(), BibleVerseEnum.JOSHUA.getDesc() + EMPTY_SPACE + "7-8;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "100;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "24-25" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-11").toDate(), BibleVerseEnum.JOSHUA.getDesc() + EMPTY_SPACE + "9-10;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "101;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "26" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-12").toDate(), BibleVerseEnum.JOSHUA.getDesc() + EMPTY_SPACE + "11-12;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "102;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "27" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-13").toDate(), BibleVerseEnum.JOSHUA.getDesc() + EMPTY_SPACE + "13-14;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "103;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "28" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-14").toDate(), BibleVerseEnum.JOSHUA.getDesc() + EMPTY_SPACE + "15-16;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "104;" + BibleVerseEnum.ROMANS.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-15").toDate(), BibleVerseEnum.JOSHUA.getDesc() + EMPTY_SPACE + "17-18;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "105;" + BibleVerseEnum.ROMANS.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-16").toDate(), BibleVerseEnum.JOSHUA.getDesc() + EMPTY_SPACE + "19-20;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "106;" + BibleVerseEnum.ROMANS.getDesc() + EMPTY_SPACE + "5-6" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-17").toDate(), BibleVerseEnum.JOSHUA.getDesc() + EMPTY_SPACE + "21-22;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "107;" + BibleVerseEnum.ROMANS.getDesc() + EMPTY_SPACE + "7-8" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-18").toDate(), BibleVerseEnum.JOSHUA.getDesc() + EMPTY_SPACE + "23-24;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "108;" + BibleVerseEnum.ROMANS.getDesc() + EMPTY_SPACE + "9-10" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-19").toDate(), BibleVerseEnum.JUDGES.getDesc() + EMPTY_SPACE + "1-2;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "109;" + BibleVerseEnum.ROMANS.getDesc() + EMPTY_SPACE + "11-12" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-20").toDate(), BibleVerseEnum.JUDGES.getDesc() + EMPTY_SPACE + "3-4;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "110;" + BibleVerseEnum.ROMANS.getDesc() + EMPTY_SPACE + "13-14" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-21").toDate(), BibleVerseEnum.JUDGES.getDesc() + EMPTY_SPACE + "5-6;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "111;" + BibleVerseEnum.ROMANS.getDesc() + EMPTY_SPACE + "15-16" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-22").toDate(), BibleVerseEnum.JUDGES.getDesc() + EMPTY_SPACE + "7-8;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "112;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-23").toDate(), BibleVerseEnum.JUDGES.getDesc() + EMPTY_SPACE + "9;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "113;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-24").toDate(), BibleVerseEnum.JUDGES.getDesc() + EMPTY_SPACE + "10-11;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "114;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "5-6" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-25").toDate(), BibleVerseEnum.JUDGES.getDesc() + EMPTY_SPACE + "12-13;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "115;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "7" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-26").toDate(), BibleVerseEnum.JUDGES.getDesc() + EMPTY_SPACE + "14-15;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "116;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "8-9" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-27").toDate(), BibleVerseEnum.JUDGES.getDesc() + EMPTY_SPACE + "16-17;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "117;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "10" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-28").toDate(), BibleVerseEnum.JUDGES.getDesc() + EMPTY_SPACE + "18-19;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "118;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "11" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-29").toDate(), BibleVerseEnum.JUDGES.getDesc() + EMPTY_SPACE + "20-21;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "119:1-88;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "12" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-04-30").toDate(), BibleVerseEnum.RUTH.getDesc() + EMPTY_SPACE + "1-4;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "119:89-176;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "13" ));

        /**May*/
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-01").toDate(), BibleVerseEnum.ONE_SAMUEL.getDesc() + EMPTY_SPACE + "1-2;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "120;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "14" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-02").toDate(), BibleVerseEnum.ONE_SAMUEL.getDesc() + EMPTY_SPACE + "3-4;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "121;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "15" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-03").toDate(), BibleVerseEnum.ONE_SAMUEL.getDesc() + EMPTY_SPACE + "5-6;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "122;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "16" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-04").toDate(), BibleVerseEnum.ONE_SAMUEL.getDesc() + EMPTY_SPACE + "7-8;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "123;" + BibleVerseEnum.TWO_CORINTHIANS.getDesc() + EMPTY_SPACE + "1" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-05").toDate(), BibleVerseEnum.ONE_SAMUEL.getDesc() + EMPTY_SPACE + "9-10;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "124;" + BibleVerseEnum.TWO_CORINTHIANS.getDesc() + EMPTY_SPACE + "2-3" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-06").toDate(), BibleVerseEnum.ONE_SAMUEL.getDesc() + EMPTY_SPACE + "11-12;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "125;" + BibleVerseEnum.TWO_CORINTHIANS.getDesc() + EMPTY_SPACE + "4-5" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-07").toDate(), BibleVerseEnum.ONE_SAMUEL.getDesc() + EMPTY_SPACE + "13-14;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "126;" + BibleVerseEnum.TWO_CORINTHIANS.getDesc() + EMPTY_SPACE + "6-7" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-08").toDate(), BibleVerseEnum.ONE_SAMUEL.getDesc() + EMPTY_SPACE + "15-16;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "127;" + BibleVerseEnum.TWO_CORINTHIANS.getDesc() + EMPTY_SPACE + "8" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-09").toDate(), BibleVerseEnum.ONE_SAMUEL.getDesc() + EMPTY_SPACE + "17;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "128;" + BibleVerseEnum.TWO_CORINTHIANS.getDesc() + EMPTY_SPACE + "9-10" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-10").toDate(), BibleVerseEnum.ONE_SAMUEL.getDesc() + EMPTY_SPACE + "18-19;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "129;" + BibleVerseEnum.TWO_CORINTHIANS.getDesc() + EMPTY_SPACE + "11" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-11").toDate(), BibleVerseEnum.ONE_SAMUEL.getDesc() + EMPTY_SPACE + "20-21;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "130;" + BibleVerseEnum.TWO_CORINTHIANS.getDesc() + EMPTY_SPACE + "12" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-12").toDate(), BibleVerseEnum.ONE_SAMUEL.getDesc() + EMPTY_SPACE + "22-23;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "131;" + BibleVerseEnum.TWO_CORINTHIANS.getDesc() + EMPTY_SPACE + "13" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-13").toDate(), BibleVerseEnum.ONE_SAMUEL.getDesc() + EMPTY_SPACE + "24-25;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "132;" + BibleVerseEnum.GALATIANS.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-14").toDate(), BibleVerseEnum.ONE_SAMUEL.getDesc() + EMPTY_SPACE + "26-27;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "133;" + BibleVerseEnum.GALATIANS.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-15").toDate(), BibleVerseEnum.ONE_SAMUEL.getDesc() + EMPTY_SPACE + "28-29;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "134;" + BibleVerseEnum.GALATIANS.getDesc() + EMPTY_SPACE + "5-6" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-16").toDate(), BibleVerseEnum.ONE_SAMUEL.getDesc() + EMPTY_SPACE + "30-31;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "135;" + BibleVerseEnum.EPHESIANS.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-17").toDate(), BibleVerseEnum.TWO_SAMUEL.getDesc() + EMPTY_SPACE + "1-2;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "136;" + BibleVerseEnum.EPHESIANS.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-18").toDate(), BibleVerseEnum.TWO_SAMUEL.getDesc() + EMPTY_SPACE + "3-4;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "137;" + BibleVerseEnum.EPHESIANS.getDesc() + EMPTY_SPACE + "5-6" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-19").toDate(), BibleVerseEnum.TWO_SAMUEL.getDesc() + EMPTY_SPACE + "5-6;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "138;" + BibleVerseEnum.PHILIPPIANS.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-20").toDate(), BibleVerseEnum.TWO_SAMUEL.getDesc() + EMPTY_SPACE + "7-8;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "139;" + BibleVerseEnum.PHILIPPIANS.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-21").toDate(), BibleVerseEnum.TWO_SAMUEL.getDesc() + EMPTY_SPACE + "9-10;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "140;" + BibleVerseEnum.COLOSSIANS.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-22").toDate(), BibleVerseEnum.TWO_SAMUEL.getDesc() + EMPTY_SPACE + "11-12;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "141;" + BibleVerseEnum.COLOSSIANS.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-23").toDate(), BibleVerseEnum.TWO_SAMUEL.getDesc() + EMPTY_SPACE + "13-14;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "142;" + BibleVerseEnum.ONE_THESSALONIANS.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-24").toDate(), BibleVerseEnum.TWO_SAMUEL.getDesc() + EMPTY_SPACE + "15-16;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "143;" + BibleVerseEnum.ONE_THESSALONIANS.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-25").toDate(), BibleVerseEnum.TWO_SAMUEL.getDesc() + EMPTY_SPACE + "17-18;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "144;" + BibleVerseEnum.ONE_THESSALONIANS.getDesc() + EMPTY_SPACE + "5" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-26").toDate(), BibleVerseEnum.TWO_SAMUEL.getDesc() + EMPTY_SPACE + "19;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "145;" + BibleVerseEnum.TWO_THESSALONIANS.getDesc() + EMPTY_SPACE + "1-3" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-27").toDate(), BibleVerseEnum.TWO_SAMUEL.getDesc() + EMPTY_SPACE + "20-21;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "146;" + BibleVerseEnum.ONE_TIMOTHY.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-28").toDate(), BibleVerseEnum.TWO_SAMUEL.getDesc() + EMPTY_SPACE + "22;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "147;" + BibleVerseEnum.ONE_TIMOTHY.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-29").toDate(), BibleVerseEnum.TWO_SAMUEL.getDesc() + EMPTY_SPACE + "23-24;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "148;" + BibleVerseEnum.ONE_TIMOTHY.getDesc() + EMPTY_SPACE + "5-6" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-30").toDate(), BibleVerseEnum.ONE_KINGS.getDesc() + EMPTY_SPACE + "1;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "149;" + BibleVerseEnum.TWO_TIMOTHY.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-05-31").toDate(), BibleVerseEnum.ONE_KINGS.getDesc() + EMPTY_SPACE + "2-3;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "150;" + BibleVerseEnum.TWO_TIMOTHY.getDesc() + EMPTY_SPACE + "3-4" ));

        /**June*/
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-01").toDate(), BibleVerseEnum.ONE_KINGS.getDesc() + EMPTY_SPACE + "4-5;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "1;" + BibleVerseEnum.TITUS.getDesc() + EMPTY_SPACE + "1-3" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-02").toDate(), BibleVerseEnum.ONE_KINGS.getDesc() + EMPTY_SPACE + "6-7;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "2;" + BibleVerseEnum.PHILEMON.getDesc()));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-03").toDate(), BibleVerseEnum.ONE_KINGS.getDesc() + EMPTY_SPACE + "8;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "3;" + BibleVerseEnum.HEBREWS.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-04").toDate(), BibleVerseEnum.ONE_KINGS.getDesc() + EMPTY_SPACE + "9-10;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "4;" + BibleVerseEnum.HEBREWS.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-05").toDate(), BibleVerseEnum.ONE_KINGS.getDesc() + EMPTY_SPACE + "11-12;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "5;" + BibleVerseEnum.HEBREWS.getDesc() + EMPTY_SPACE + "5-6" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-06").toDate(), BibleVerseEnum.ONE_KINGS.getDesc() + EMPTY_SPACE + "13-14;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "6;" + BibleVerseEnum.HEBREWS.getDesc() + EMPTY_SPACE + "7-8" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-07").toDate(), BibleVerseEnum.ONE_KINGS.getDesc() + EMPTY_SPACE + "15-16;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "7;" + BibleVerseEnum.HEBREWS.getDesc() + EMPTY_SPACE + "9-10" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-08").toDate(), BibleVerseEnum.ONE_KINGS.getDesc() + EMPTY_SPACE + "17-18;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "8;" + BibleVerseEnum.HEBREWS.getDesc() + EMPTY_SPACE + "11" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-09").toDate(), BibleVerseEnum.ONE_KINGS.getDesc() + EMPTY_SPACE + "19-20;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "9;" + BibleVerseEnum.HEBREWS.getDesc() + EMPTY_SPACE + "12" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-10").toDate(), BibleVerseEnum.ONE_KINGS.getDesc() + EMPTY_SPACE + "21-22;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "10;" + BibleVerseEnum.HEBREWS.getDesc() + EMPTY_SPACE + "13" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-11").toDate(), BibleVerseEnum.TWO_KINGS.getDesc() + EMPTY_SPACE + "1-2;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "11;" + BibleVerseEnum.JAMES.getDesc() + EMPTY_SPACE + "1" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-12").toDate(), BibleVerseEnum.TWO_KINGS.getDesc() + EMPTY_SPACE + "3-4;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "12;" + BibleVerseEnum.JAMES.getDesc() + EMPTY_SPACE + "2-3" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-13").toDate(), BibleVerseEnum.TWO_KINGS.getDesc() + EMPTY_SPACE + "5-6;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "13;" + BibleVerseEnum.JAMES.getDesc() + EMPTY_SPACE + "4-5" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-14").toDate(), BibleVerseEnum.TWO_KINGS.getDesc() + EMPTY_SPACE + "7-8;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "14;" + BibleVerseEnum.ONE_PETER.getDesc() + EMPTY_SPACE + "1" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-15").toDate(), BibleVerseEnum.TWO_KINGS.getDesc() + EMPTY_SPACE + "9-10;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "15;" + BibleVerseEnum.ONE_PETER.getDesc() + EMPTY_SPACE + "2-3" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-16").toDate(), BibleVerseEnum.TWO_KINGS.getDesc() + EMPTY_SPACE + "11-12;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "16;" + BibleVerseEnum.ONE_PETER.getDesc() + EMPTY_SPACE + "4-5" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-17").toDate(), BibleVerseEnum.TWO_KINGS.getDesc() + EMPTY_SPACE + "13-14;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "17;" + BibleVerseEnum.TWO_PETER.getDesc() + EMPTY_SPACE + "1-3" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-18").toDate(), BibleVerseEnum.TWO_KINGS.getDesc() + EMPTY_SPACE + "15-16;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "18;" + BibleVerseEnum.ONE_JOHN.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-19").toDate(), BibleVerseEnum.TWO_KINGS.getDesc() + EMPTY_SPACE + "17;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "19;" + BibleVerseEnum.ONE_JOHN.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-20").toDate(), BibleVerseEnum.TWO_KINGS.getDesc() + EMPTY_SPACE + "18-19;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "20;" + BibleVerseEnum.ONE_JOHN.getDesc() + EMPTY_SPACE + "5" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-21").toDate(), BibleVerseEnum.TWO_KINGS.getDesc() + EMPTY_SPACE + "20-21;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "21;" + BibleVerseEnum.TWO_JOHN.getDesc()));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-22").toDate(), BibleVerseEnum.TWO_KINGS.getDesc() + EMPTY_SPACE + "22-23;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "22;" + BibleVerseEnum.THREE_JOHN.getDesc()));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-23").toDate(), BibleVerseEnum.TWO_KINGS.getDesc() + EMPTY_SPACE + "24-25;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "23;" + BibleVerseEnum.JUDE.getDesc()));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-24").toDate(), BibleVerseEnum.ONE_CHRONICLES.getDesc() + EMPTY_SPACE + "1;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "24;" + BibleVerseEnum.REVELATION.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-25").toDate(), BibleVerseEnum.ONE_CHRONICLES.getDesc() + EMPTY_SPACE + "2-3;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "25;" + BibleVerseEnum.REVELATION.getDesc() + EMPTY_SPACE + "3-5" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-26").toDate(), BibleVerseEnum.ONE_CHRONICLES.getDesc() + EMPTY_SPACE + "4-5;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "26;" + BibleVerseEnum.REVELATION.getDesc() + EMPTY_SPACE + "6-7" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-27").toDate(), BibleVerseEnum.ONE_CHRONICLES.getDesc() + EMPTY_SPACE + "6-7;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "27;" + BibleVerseEnum.REVELATION.getDesc() + EMPTY_SPACE + "8-10" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-28").toDate(), BibleVerseEnum.ONE_CHRONICLES.getDesc() + EMPTY_SPACE + "8-9;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "28;" + BibleVerseEnum.REVELATION.getDesc() + EMPTY_SPACE + "11-12" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-29").toDate(), BibleVerseEnum.ONE_CHRONICLES.getDesc() + EMPTY_SPACE + "10-11;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "29;" + BibleVerseEnum.REVELATION.getDesc() + EMPTY_SPACE + "13-14" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-06-30").toDate(), BibleVerseEnum.ONE_CHRONICLES.getDesc() + EMPTY_SPACE + "12-13;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "30;" + BibleVerseEnum.REVELATION.getDesc() + EMPTY_SPACE + "15-17" ));

        /**July*/
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-01").toDate(), BibleVerseEnum.ONE_CHRONICLES.getDesc() + EMPTY_SPACE + "14-15;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "31;" + BibleVerseEnum.REVELATION.getDesc() + EMPTY_SPACE + "18-19" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-02").toDate(), BibleVerseEnum.ONE_CHRONICLES.getDesc() + EMPTY_SPACE + "16-17;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "1;" + BibleVerseEnum.REVELATION.getDesc() + EMPTY_SPACE + "20-22" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-03").toDate(), BibleVerseEnum.ONE_CHRONICLES.getDesc() + EMPTY_SPACE + "18-19;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "2;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-04").toDate(), BibleVerseEnum.ONE_CHRONICLES.getDesc() + EMPTY_SPACE + "20-21;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "3;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-05").toDate(), BibleVerseEnum.ONE_CHRONICLES.getDesc() + EMPTY_SPACE + "22-23;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "4;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "5" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-06").toDate(), BibleVerseEnum.ONE_CHRONICLES.getDesc() + EMPTY_SPACE + "24-25;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "5;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "6-7" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-07").toDate(), BibleVerseEnum.ONE_CHRONICLES.getDesc() + EMPTY_SPACE + "26-27;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "6;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "8-9" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-08").toDate(), BibleVerseEnum.ONE_CHRONICLES.getDesc() + EMPTY_SPACE + "28-29;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "7;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "10-11" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-09").toDate(), BibleVerseEnum.TWO_CHRONICLES.getDesc() + EMPTY_SPACE + "1-2;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "8;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "12" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-10").toDate(), BibleVerseEnum.TWO_CHRONICLES.getDesc() + EMPTY_SPACE + "3-4;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "9;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "13" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-11").toDate(), BibleVerseEnum.TWO_CHRONICLES.getDesc() + EMPTY_SPACE + "5-6;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "10;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "14-15" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-12").toDate(), BibleVerseEnum.TWO_CHRONICLES.getDesc() + EMPTY_SPACE + "7-8;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "11;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "16-17" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-13").toDate(), BibleVerseEnum.TWO_CHRONICLES.getDesc() + EMPTY_SPACE + "9-10;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "12;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "18" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-14").toDate(), BibleVerseEnum.TWO_CHRONICLES.getDesc() + EMPTY_SPACE + "11-12;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "13;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "19-20" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-15").toDate(), BibleVerseEnum.TWO_CHRONICLES.getDesc() + EMPTY_SPACE + "13-14;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "14;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "21" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-16").toDate(), BibleVerseEnum.TWO_CHRONICLES.getDesc() + EMPTY_SPACE + "15-16;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "15;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "22" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-17").toDate(), BibleVerseEnum.TWO_CHRONICLES.getDesc() + EMPTY_SPACE + "17-18;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "16;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "23" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-18").toDate(), BibleVerseEnum.TWO_CHRONICLES.getDesc() + EMPTY_SPACE + "19-20;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "17;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "24" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-19").toDate(), BibleVerseEnum.TWO_CHRONICLES.getDesc() + EMPTY_SPACE + "21-22;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "18;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "25" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-20").toDate(), BibleVerseEnum.TWO_CHRONICLES.getDesc() + EMPTY_SPACE + "23-24;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "19;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "26" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-21").toDate(), BibleVerseEnum.TWO_CHRONICLES.getDesc() + EMPTY_SPACE + "25-26;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "20;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "27" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-22").toDate(), BibleVerseEnum.TWO_CHRONICLES.getDesc() + EMPTY_SPACE + "27-28;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "21;" + BibleVerseEnum.MATTHEW.getDesc() + EMPTY_SPACE + "28" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-23").toDate(), BibleVerseEnum.TWO_CHRONICLES.getDesc() + EMPTY_SPACE + "29-30;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "22;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "1" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-24").toDate(), BibleVerseEnum.TWO_CHRONICLES.getDesc() + EMPTY_SPACE + "31-32;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "23;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-25").toDate(), BibleVerseEnum.TWO_CHRONICLES.getDesc() + EMPTY_SPACE + "33-34;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "24;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "3" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-26").toDate(), BibleVerseEnum.TWO_CHRONICLES.getDesc() + EMPTY_SPACE + "35-36;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "25;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-27").toDate(), BibleVerseEnum.EZRA.getDesc() + EMPTY_SPACE + "1-2;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "26;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "5" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-28").toDate(), BibleVerseEnum.EZRA.getDesc() + EMPTY_SPACE + "3-4;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "27;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "6" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-29").toDate(), BibleVerseEnum.EZRA.getDesc() + EMPTY_SPACE + "5-6;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "28;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "7" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-30").toDate(), BibleVerseEnum.EZRA.getDesc() + EMPTY_SPACE + "7-8;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "29;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "8" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-07-31").toDate(), BibleVerseEnum.EZRA.getDesc() + EMPTY_SPACE + "9-10;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "30;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "9" ));

        /**August*/
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-01").toDate(), BibleVerseEnum.NEHEMIAH.getDesc() + EMPTY_SPACE + "1-2;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "31;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "10" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-02").toDate(), BibleVerseEnum.NEHEMIAH.getDesc() + EMPTY_SPACE + "3-4;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "32;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "11" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-03").toDate(), BibleVerseEnum.NEHEMIAH.getDesc() + EMPTY_SPACE + "5-6;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "33;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "12" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-04").toDate(), BibleVerseEnum.NEHEMIAH.getDesc() + EMPTY_SPACE + "7;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "34;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "13" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-05").toDate(), BibleVerseEnum.NEHEMIAH.getDesc() + EMPTY_SPACE + "8-9;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "35;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "14" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-06").toDate(), BibleVerseEnum.NEHEMIAH.getDesc() + EMPTY_SPACE + "10-11;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "36;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "15" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-07").toDate(), BibleVerseEnum.NEHEMIAH.getDesc() + EMPTY_SPACE + "12-13;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "37;" + BibleVerseEnum.MARK.getDesc() + EMPTY_SPACE + "16" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-08").toDate(), BibleVerseEnum.ESTHER.getDesc() + EMPTY_SPACE + "1-2;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "38;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "1" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-09").toDate(), BibleVerseEnum.ESTHER.getDesc() + EMPTY_SPACE + "3-4;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "39;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-10").toDate(), BibleVerseEnum.ESTHER.getDesc() + EMPTY_SPACE + "5-6;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "40;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "3" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-11").toDate(), BibleVerseEnum.ESTHER.getDesc() + EMPTY_SPACE + "7-8;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "41;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-12").toDate(), BibleVerseEnum.ESTHER.getDesc() + EMPTY_SPACE + "9-10;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "42;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "5" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-13").toDate(), BibleVerseEnum.JOB.getDesc() + EMPTY_SPACE + "1-2;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "43;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "6" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-14").toDate(), BibleVerseEnum.JOB.getDesc() + EMPTY_SPACE + "3-4;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "44;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "7" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-15").toDate(), BibleVerseEnum.JOB.getDesc() + EMPTY_SPACE + "5-6;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "45;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "8" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-16").toDate(), BibleVerseEnum.JOB.getDesc() + EMPTY_SPACE + "7-8;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "46;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "9" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-17").toDate(), BibleVerseEnum.JOB.getDesc() + EMPTY_SPACE + "9-10;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "47;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "10" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-18").toDate(), BibleVerseEnum.JOB.getDesc() + EMPTY_SPACE + "11-12;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "48;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "11" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-19").toDate(), BibleVerseEnum.JOB.getDesc() + EMPTY_SPACE + "13-14;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "49;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "12" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-20").toDate(), BibleVerseEnum.JOB.getDesc() + EMPTY_SPACE + "15-16;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "50;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "13" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-21").toDate(), BibleVerseEnum.JOB.getDesc() + EMPTY_SPACE + "17-18;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "51;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "14" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-22").toDate(), BibleVerseEnum.JOB.getDesc() + EMPTY_SPACE + "19-20;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "52;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "15" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-23").toDate(), BibleVerseEnum.JOB.getDesc() + EMPTY_SPACE + "21-22;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "53;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "16" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-24").toDate(), BibleVerseEnum.JOB.getDesc() + EMPTY_SPACE + "23-25;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "54;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "17" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-25").toDate(), BibleVerseEnum.JOB.getDesc() + EMPTY_SPACE + "26-28;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "55;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "18" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-26").toDate(), BibleVerseEnum.JOB.getDesc() + EMPTY_SPACE + "29-30;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "56;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "19" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-27").toDate(), BibleVerseEnum.JOB.getDesc() + EMPTY_SPACE + "31-32;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "57;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "20" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-28").toDate(), BibleVerseEnum.JOB.getDesc() + EMPTY_SPACE + "33-34;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "58;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "21" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-29").toDate(), BibleVerseEnum.JOB.getDesc() + EMPTY_SPACE + "35-36;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "59;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "22" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-30").toDate(), BibleVerseEnum.JOB.getDesc() + EMPTY_SPACE + "37-38;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "60;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "23" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-08-31").toDate(), BibleVerseEnum.JOB.getDesc() + EMPTY_SPACE + "39-40;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "61;" + BibleVerseEnum.LUKE.getDesc() + EMPTY_SPACE + "24" ));

        /**September*/
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-01").toDate(), BibleVerseEnum.JOB.getDesc() + EMPTY_SPACE + "41-42;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "62;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "1" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-02").toDate(), BibleVerseEnum.ECCLESIASTES.getDesc() + EMPTY_SPACE + "1-2;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "63;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "2-3" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-03").toDate(), BibleVerseEnum.ECCLESIASTES.getDesc() + EMPTY_SPACE + "3-4;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "64;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-04").toDate(), BibleVerseEnum.ECCLESIASTES.getDesc() + EMPTY_SPACE + "5-6;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "65;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "5" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-05").toDate(), BibleVerseEnum.ECCLESIASTES.getDesc() + EMPTY_SPACE + "7-8;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "66;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "6" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-06").toDate(), BibleVerseEnum.ECCLESIASTES.getDesc() + EMPTY_SPACE + "9-10;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "67;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "7" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-07").toDate(), BibleVerseEnum.ECCLESIASTES.getDesc() + EMPTY_SPACE + "11-12;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "68;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "8" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-08").toDate(), BibleVerseEnum.SONG_OF_SOLOMON.getDesc() + EMPTY_SPACE + "1-2;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "69;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "9" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-09").toDate(), BibleVerseEnum.SONG_OF_SOLOMON.getDesc() + EMPTY_SPACE + "3-4;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "70;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "10" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-10").toDate(), BibleVerseEnum.SONG_OF_SOLOMON.getDesc() + EMPTY_SPACE + "5-6;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "71;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "11" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-11").toDate(), BibleVerseEnum.SONG_OF_SOLOMON.getDesc() + EMPTY_SPACE + "7-8;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "72;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "12" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-12").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "1-2;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "73;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "13" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-13").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "3-5;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "74;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "14-15" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-14").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "6-8;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "75;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "16" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-15").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "9-10;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "76;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "17" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-16").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "11-13;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "77;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "18" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-17").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "14-15;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "78;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "19" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-18").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "16-17;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "79;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "20" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-19").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "18-19;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "80;" + BibleVerseEnum.JOHN.getDesc() + EMPTY_SPACE + "21" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-20").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "20-22;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "81;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "1" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-21").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "23-24;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "82;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-22").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "25-26;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "83;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-23").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "27-28;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "84;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "5-6" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-24").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "29-30;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "85;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "7" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-25").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "31-32;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "86;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "8" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-26").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "33-34;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "87;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "9" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-27").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "35-36;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "88;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "10" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-28").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "37-38;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "89;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "11-12" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-29").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "39-40;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "90;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "13" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-09-30").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "41-42;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "91;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "14" ));

        /**October*/
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-01").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "43-44;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "92;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "15" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-02").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "45-46;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "93;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "16" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-03").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "47-48;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "94;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "17" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-04").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "49-50;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "95;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "18" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-05").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "51-52;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "96;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "19" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-06").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "53-54;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "97;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "20" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-07").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "55-56;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "98;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "21" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-08").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "57-58;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "99;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "22" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-09").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "59-60;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "100;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "23" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-10").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "61-62;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "101;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "24-25" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-11").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "63-64;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "102;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "26" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-12").toDate(), BibleVerseEnum.ISAIAH.getDesc() + EMPTY_SPACE + "65-66;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "103;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "27" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-13").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "1-2;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "104;" + BibleVerseEnum.ACTS.getDesc() + EMPTY_SPACE + "28" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-14").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "3-4;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "105;" + BibleVerseEnum.ROMANS.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-15").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "5-6;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "106;" + BibleVerseEnum.ROMANS.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-16").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "7-8;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "107;" + BibleVerseEnum.ROMANS.getDesc() + EMPTY_SPACE + "5-6" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-17").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "9-10;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "108;" + BibleVerseEnum.ROMANS.getDesc() + EMPTY_SPACE + "7-8" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-18").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "11-12;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "109;" + BibleVerseEnum.ROMANS.getDesc() + EMPTY_SPACE + "9-10" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-19").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "13-14;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "110;" + BibleVerseEnum.ROMANS.getDesc() + EMPTY_SPACE + "11-12" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-20").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "15-16;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "111;" + BibleVerseEnum.ROMANS.getDesc() + EMPTY_SPACE + "13-14" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-21").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "17-18;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "112;" + BibleVerseEnum.ROMANS.getDesc() + EMPTY_SPACE + "15-16" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-22").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "19-20;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "113;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-23").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "21-22;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "114;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-24").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "23-24;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "115;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "5-6" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-25").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "25-26;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "116;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "7" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-26").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "27-28;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "117;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "8-9" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-27").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "29-30;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "118;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "10" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-28").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "31-32;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "119:1-64;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "11" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-29").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "33-34;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "119:65-120;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "12" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-30").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "35-36;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "119:121-176;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "13" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-10-31").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "37-38;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "120;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "14" ));

        /**November*/
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-01").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "39-40;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "121;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "15" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-02").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "41-42;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "122;" + BibleVerseEnum.ONE_CORINTHIANS.getDesc() + EMPTY_SPACE + "16" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-03").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "43-44;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "123;" + BibleVerseEnum.TWO_CORINTHIANS.getDesc() + EMPTY_SPACE + "1" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-04").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "45-46;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "124;" + BibleVerseEnum.TWO_CORINTHIANS.getDesc() + EMPTY_SPACE + "2-3" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-05").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "47-48;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "125;" + BibleVerseEnum.TWO_CORINTHIANS.getDesc() + EMPTY_SPACE + "4-5" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-06").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "49-50;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "126;" + BibleVerseEnum.TWO_CORINTHIANS.getDesc() + EMPTY_SPACE + "6-7" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-07").toDate(), BibleVerseEnum.JEREMIAH.getDesc() + EMPTY_SPACE + "51-52;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "127;" + BibleVerseEnum.TWO_CORINTHIANS.getDesc() + EMPTY_SPACE + "8" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-08").toDate(), BibleVerseEnum.LAMENTATIONS.getDesc() + EMPTY_SPACE + "1-2;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "128;" + BibleVerseEnum.TWO_CORINTHIANS.getDesc() + EMPTY_SPACE + "9-10" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-09").toDate(), BibleVerseEnum.LAMENTATIONS.getDesc() + EMPTY_SPACE + "3;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "129;" + BibleVerseEnum.TWO_CORINTHIANS.getDesc() + EMPTY_SPACE + "11" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-10").toDate(), BibleVerseEnum.LAMENTATIONS.getDesc() + EMPTY_SPACE + "4-5;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "130;" + BibleVerseEnum.TWO_CORINTHIANS.getDesc() + EMPTY_SPACE + "12" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-11").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "1-2;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "131;" + BibleVerseEnum.TWO_CORINTHIANS.getDesc() + EMPTY_SPACE + "13" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-12").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "3-4;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "132;" + BibleVerseEnum.GALATIANS.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-13").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "5-6;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "133;" + BibleVerseEnum.GALATIANS.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-14").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "7-8;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "134;" + BibleVerseEnum.GALATIANS.getDesc() + EMPTY_SPACE + "5-6" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-15").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "9-10;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "135;" + BibleVerseEnum.EPHESIANS.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-16").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "11-12;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "136;" + BibleVerseEnum.EPHESIANS.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-17").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "13-14;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "137;" + BibleVerseEnum.EPHESIANS.getDesc() + EMPTY_SPACE + "5-6" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-18").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "15-16;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "138;" + BibleVerseEnum.PHILIPPIANS.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-19").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "17-18;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "139;" + BibleVerseEnum.PHILIPPIANS.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-20").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "19-20;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "140;" + BibleVerseEnum.COLOSSIANS.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-21").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "21-22;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "141;" + BibleVerseEnum.COLOSSIANS.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-22").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "23-24;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "142;" + BibleVerseEnum.ONE_THESSALONIANS.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-23").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "25-26;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "143;" + BibleVerseEnum.ONE_THESSALONIANS.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-24").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "27-28;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "144;" + BibleVerseEnum.ONE_THESSALONIANS.getDesc() + EMPTY_SPACE + "5" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-25").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "29-30;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "145;" + BibleVerseEnum.TWO_THESSALONIANS.getDesc() + EMPTY_SPACE + "1-3" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-26").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "31-32;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "146;" + BibleVerseEnum.ONE_TIMOTHY.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-27").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "33-34;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "147;" + BibleVerseEnum.ONE_TIMOTHY.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-28").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "35-36;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "148;" + BibleVerseEnum.ONE_TIMOTHY.getDesc() + EMPTY_SPACE + "5-6" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-29").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "37-38;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "149;" + BibleVerseEnum.TWO_TIMOTHY.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-11-30").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "39-40;" + BibleVerseEnum.PSALM.getDesc() + EMPTY_SPACE + "150;" + BibleVerseEnum.TWO_TIMOTHY.getDesc() + EMPTY_SPACE + "3-4" ));

        /**December*/
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-01").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "41-42;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "1;" + BibleVerseEnum.TITUS.getDesc() + EMPTY_SPACE + "1-3" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-02").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "43-44;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "2;" + BibleVerseEnum.PHILEMON.getDesc()));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-03").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "45-46;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "3;" + BibleVerseEnum.HEBREWS.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-04").toDate(), BibleVerseEnum.EZEKIEL.getDesc() + EMPTY_SPACE + "47-48;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "4;" + BibleVerseEnum.HEBREWS.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-05").toDate(), BibleVerseEnum.DANIEL.getDesc() + EMPTY_SPACE + "1-2;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "5;" + BibleVerseEnum.HEBREWS.getDesc() + EMPTY_SPACE + "5-6" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-06").toDate(), BibleVerseEnum.DANIEL.getDesc() + EMPTY_SPACE + "3-4;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "6;" + BibleVerseEnum.HEBREWS.getDesc() + EMPTY_SPACE + "7-8" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-07").toDate(), BibleVerseEnum.DANIEL.getDesc() + EMPTY_SPACE + "5-6;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "7;" + BibleVerseEnum.HEBREWS.getDesc() + EMPTY_SPACE + "9-10" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-08").toDate(), BibleVerseEnum.DANIEL.getDesc() + EMPTY_SPACE + "7-8;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "8;" + BibleVerseEnum.HEBREWS.getDesc() + EMPTY_SPACE + "11" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-09").toDate(), BibleVerseEnum.DANIEL.getDesc() + EMPTY_SPACE + "9-10;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "9;" + BibleVerseEnum.HEBREWS.getDesc() + EMPTY_SPACE + "12" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-10").toDate(), BibleVerseEnum.DANIEL.getDesc() + EMPTY_SPACE + "11-12;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "10;" + BibleVerseEnum.HEBREWS.getDesc() + EMPTY_SPACE + "13" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-11").toDate(), BibleVerseEnum.HOSEA.getDesc() + EMPTY_SPACE + "1-3;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "11;" + BibleVerseEnum.JAMES.getDesc() + EMPTY_SPACE + "1-3" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-12").toDate(), BibleVerseEnum.HOSEA.getDesc() + EMPTY_SPACE + "4-6;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "12;" + BibleVerseEnum.JAMES.getDesc() + EMPTY_SPACE + "4-5" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-13").toDate(), BibleVerseEnum.HOSEA.getDesc() + EMPTY_SPACE + "7-8;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "13;" + BibleVerseEnum.ONE_PETER.getDesc() + EMPTY_SPACE + "1" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-14").toDate(), BibleVerseEnum.HOSEA.getDesc() + EMPTY_SPACE + "9-11;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "14;" + BibleVerseEnum.ONE_PETER.getDesc() + EMPTY_SPACE + "2-3" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-15").toDate(), BibleVerseEnum.HOSEA.getDesc() + EMPTY_SPACE + "12-14;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "15;" + BibleVerseEnum.ONE_PETER.getDesc() + EMPTY_SPACE + "4-5" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-16").toDate(), BibleVerseEnum.JOEL.getDesc() + EMPTY_SPACE + "1-3;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "16;" + BibleVerseEnum.TWO_PETER.getDesc() + EMPTY_SPACE + "1-3" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-17").toDate(), BibleVerseEnum.AMOS.getDesc() + EMPTY_SPACE + "1-3;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "17;" + BibleVerseEnum.ONE_JOHN.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-18").toDate(), BibleVerseEnum.AMOS.getDesc() + EMPTY_SPACE + "4-6;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "18;" + BibleVerseEnum.ONE_JOHN.getDesc() + EMPTY_SPACE + "3-4" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-19").toDate(), BibleVerseEnum.AMOS.getDesc() + EMPTY_SPACE + "7-9;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "19;" + BibleVerseEnum.ONE_JOHN.getDesc() + EMPTY_SPACE + "5" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-20").toDate(), BibleVerseEnum.OBADIAH.getDesc() + EMPTY_SPACE + ";" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "20;" + BibleVerseEnum.TWO_JOHN.getDesc()));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-21").toDate(), BibleVerseEnum.JONAH.getDesc() + EMPTY_SPACE + "1-4;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "21;" + BibleVerseEnum.THREE_JOHN.getDesc()));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-22").toDate(), BibleVerseEnum.MICAH.getDesc() + EMPTY_SPACE + "1-4;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "22;" + BibleVerseEnum.JUDE.getDesc()));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-23").toDate(), BibleVerseEnum.MICAH.getDesc() + EMPTY_SPACE + "5-7;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "23;" + BibleVerseEnum.REVELATION.getDesc() + EMPTY_SPACE + "1-2" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-24").toDate(), BibleVerseEnum.NAHUM.getDesc() + EMPTY_SPACE + "1-3;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "24;" + BibleVerseEnum.REVELATION.getDesc() + EMPTY_SPACE + "3-5" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-25").toDate(), BibleVerseEnum.HABAKKUK.getDesc() + EMPTY_SPACE + "1-3;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "25;" + BibleVerseEnum.REVELATION.getDesc() + EMPTY_SPACE + "6-7" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-26").toDate(), BibleVerseEnum.ZEPHANIAH.getDesc() + EMPTY_SPACE + "1-3;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "26;" + BibleVerseEnum.REVELATION.getDesc() + EMPTY_SPACE + "8-10" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-27").toDate(), BibleVerseEnum.HAGGAI.getDesc() + EMPTY_SPACE + "1-2;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "27;" + BibleVerseEnum.REVELATION.getDesc() + EMPTY_SPACE + "11-12" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-28").toDate(), BibleVerseEnum.ZECHARIAH.getDesc() + EMPTY_SPACE + "1-4;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "28;" + BibleVerseEnum.REVELATION.getDesc() + EMPTY_SPACE + "13-14" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-29").toDate(), BibleVerseEnum.ZECHARIAH.getDesc() + EMPTY_SPACE + "5-9;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "29;" + BibleVerseEnum.REVELATION.getDesc() + EMPTY_SPACE + "15-17" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-30").toDate(), BibleVerseEnum.ZECHARIAH.getDesc() + EMPTY_SPACE + "10-14;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "30;" + BibleVerseEnum.REVELATION.getDesc() + EMPTY_SPACE + "18-19" ));
        verseList.add(new BibleDailyReadingGuide(
                LocalDate.parse("2016-12-31").toDate(), BibleVerseEnum.MALACHI.getDesc() + EMPTY_SPACE + "1-4;" + BibleVerseEnum.PROVERBS.getDesc() + EMPTY_SPACE + "31;" + BibleVerseEnum.REVELATION.getDesc() + EMPTY_SPACE + "20-22" ));

        verseCount = verseList.size();
    }

    public List<BibleDailyReadingGuide> getVerseList() {
        return verseList;
    }

    public Integer getVerseCount() {
        return verseCount;
    }
}
