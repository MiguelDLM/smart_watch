package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class BGEMRecordSet {
    private int calendar;
    private long endDate;
    private long startDate;

    public BGEMRecordSet() {
        this(0, 0L, 0L, 7, null);
    }

    public static /* synthetic */ BGEMRecordSet copy$default(BGEMRecordSet bGEMRecordSet, int i, long j, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bGEMRecordSet.calendar;
        }
        if ((i2 & 2) != 0) {
            j = bGEMRecordSet.startDate;
        }
        long j3 = j;
        if ((i2 & 4) != 0) {
            j2 = bGEMRecordSet.endDate;
        }
        return bGEMRecordSet.copy(i, j3, j2);
    }

    public final int component1() {
        return this.calendar;
    }

    public final long component2() {
        return this.startDate;
    }

    public final long component3() {
        return this.endDate;
    }

    @OOXIXo
    public final BGEMRecordSet copy(int i, long j, long j2) {
        return new BGEMRecordSet(i, j, j2);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BGEMRecordSet)) {
            return false;
        }
        BGEMRecordSet bGEMRecordSet = (BGEMRecordSet) obj;
        return this.calendar == bGEMRecordSet.calendar && this.startDate == bGEMRecordSet.startDate && this.endDate == bGEMRecordSet.endDate;
    }

    public final int getCalendar() {
        return this.calendar;
    }

    public final long getEndDate() {
        return this.endDate;
    }

    public final long getStartDate() {
        return this.startDate;
    }

    public int hashCode() {
        return (((this.calendar * 31) + androidx.collection.oIX0oI.oIX0oI(this.startDate)) * 31) + androidx.collection.oIX0oI.oIX0oI(this.endDate);
    }

    public final void setCalendar(int i) {
        this.calendar = i;
    }

    public final void setEndDate(long j) {
        this.endDate = j;
    }

    public final void setStartDate(long j) {
        this.startDate = j;
    }

    @OOXIXo
    public String toString() {
        return "BGEMRecordSet(calendar=" + this.calendar + ", startDate=" + this.startDate + ", endDate=" + this.endDate + HexStringBuilder.COMMENT_END_CHAR;
    }

    public BGEMRecordSet(int i, long j, long j2) {
        this.calendar = i;
        this.startDate = j;
        this.endDate = j2;
    }

    public /* synthetic */ BGEMRecordSet(int i, long j, long j2, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0L : j, (i2 & 4) != 0 ? 0L : j2);
    }
}
