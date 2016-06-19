package com.maryann.dbrg.core;

/**
 * Created by Rufo on 5/22/2016.
 */
public enum BibleVerseEnum {
    GENESIS("Genesis"),
    EXODUS("Exodus"),
    LEVITICUS("Leviticus"),
    NUMBERS("Number"),
    DEUTERONOMY("Deuteronomy"),
    JOSHUA("Joshua"),
    JUDGES("Judges"),
    RUTH("Ruth"),
    ONE_SAMUEL("1 Samuel"),
    TWO_SAMUEL("2 Samuel"),
    ONE_KINGS("1 Kings"),
    TWO_KINGS("2 Kings"),
    ONE_CHRONICLES("1 Chronicles"),
    TWO_CHRONICLES("2 Chronicles"),
    EZRA("Ezra"),
    NEHEMIAH("Nehemia"),
    ESTHER("Esther"),
    JOB("Job"),
    ECCLESIASTES("Ecclesiastes"),
    SONG_OF_SOLOMON("Song of Solomon"),
    ISAIAH("Isaiah"),
    JEREMIAH("Jeremiah"),
    LAMENTATIONS("Lamentations"),
    EZEKIEL("Ezekiel"),
    DANIEL("Daniel"),
    HOSEA("Hosea"),
    JOEL("Joel"),
    AMOS("Amos"),
    OBADIAH("Obadiah"),
    JONAH("Jonah"),
    MICAH("Micah"),
    NAHUM("Nahum"),
    HABAKKUK("Habakkuk"),
    ZEPHANIAH("Zephaniah"),
    HAGGAI("Haggai"),
    ZECHARIAH("Zechariah"),
    MALACHI("Malachi"),
    PSALM("Psalm"),
    PROVERBS("Proverbs"),
    MATTHEW("Matthew"),
    MARK("Mark"),
    LUKE("Luke"),
    JOHN("John"),
    ACTS("Acts"),
    ROMANS("Romans"),
    ONE_CORINTHIANS("1 Corinthians"),
    TWO_CORINTHIANS("2 Corinthians"),
    GALATIANS("Galatians"),
    EPHESIANS("Ephesians"),
    PHILIPPIANS("Philippians"),
    COLOSSIANS("Colossians"),
    ONE_THESSALONIANS("1 Thessalonians"),
    TWO_THESSALONIANS("2 Thessalonians"),
    ONE_TIMOTHY("1 Timothy"),
    TWO_TIMOTHY("2 Timothy"),
    TITUS("Titus"),
    PHILEMON("Philemon"),
    HEBREWS("Hebrews"),
    JAMES("James"),
    ONE_PETER("1 Peter"),
    TWO_PETER("2 Peter"),
    ONE_JOHN("1 John"),
    TWO_JOHN("2 John"),
    THREE_JOHN("3 John"),
    JUDE("Jude"),
    REVELATION("Revelation");

    private String desc;

    BibleVerseEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
