package com.sma.smartv3.model;

import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class BPHourData {
    private int dbpMax;
    private int dbpMin;
    private int dbpNum;
    private int dbpTotal;
    private int sbpMax;
    private int sbpMin;
    private int sbpNum;
    private int sbpTotal;

    public BPHourData() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 255, null);
    }

    public final int getDbpMax() {
        return this.dbpMax;
    }

    public final int getDbpMin() {
        return this.dbpMin;
    }

    public final int getDbpNum() {
        return this.dbpNum;
    }

    public final int getDbpTotal() {
        return this.dbpTotal;
    }

    public final int getSbpMax() {
        return this.sbpMax;
    }

    public final int getSbpMin() {
        return this.sbpMin;
    }

    public final int getSbpNum() {
        return this.sbpNum;
    }

    public final int getSbpTotal() {
        return this.sbpTotal;
    }

    public final void setDbpMax(int i) {
        this.dbpMax = i;
    }

    public final void setDbpMin(int i) {
        this.dbpMin = i;
    }

    public final void setDbpNum(int i) {
        this.dbpNum = i;
    }

    public final void setDbpTotal(int i) {
        this.dbpTotal = i;
    }

    public final void setSbpMax(int i) {
        this.sbpMax = i;
    }

    public final void setSbpMin(int i) {
        this.sbpMin = i;
    }

    public final void setSbpNum(int i) {
        this.sbpNum = i;
    }

    public final void setSbpTotal(int i) {
        this.sbpTotal = i;
    }

    public BPHourData(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.dbpMax = i;
        this.dbpMin = i2;
        this.dbpTotal = i3;
        this.dbpNum = i4;
        this.sbpMax = i5;
        this.sbpMin = i6;
        this.sbpTotal = i7;
        this.sbpNum = i8;
    }

    public /* synthetic */ BPHourData(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, IIXOooo iIXOooo) {
        this((i9 & 1) != 0 ? 0 : i, (i9 & 2) != 0 ? 0 : i2, (i9 & 4) != 0 ? 0 : i3, (i9 & 8) != 0 ? 0 : i4, (i9 & 16) != 0 ? 0 : i5, (i9 & 32) != 0 ? 0 : i6, (i9 & 64) != 0 ? 0 : i7, (i9 & 128) == 0 ? i8 : 0);
    }
}
