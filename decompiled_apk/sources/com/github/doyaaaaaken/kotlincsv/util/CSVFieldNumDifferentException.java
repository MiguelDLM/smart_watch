package com.github.doyaaaaaken.kotlincsv.util;

/* loaded from: classes9.dex */
public final class CSVFieldNumDifferentException extends MalformedCSVException {
    private final int csvRowNum;
    private final int fieldNum;
    private final int fieldNumOnFailedRow;

    public CSVFieldNumDifferentException(int i, int i2, int i3) {
        super("Fields num seems to be " + i + " on each row, but on " + i3 + "th csv row, fields num is " + i2 + '.');
        this.fieldNum = i;
        this.fieldNumOnFailedRow = i2;
        this.csvRowNum = i3;
    }

    public final int getCsvRowNum() {
        return this.csvRowNum;
    }

    public final int getFieldNum() {
        return this.fieldNum;
    }

    public final int getFieldNumOnFailedRow() {
        return this.fieldNumOnFailedRow;
    }
}
