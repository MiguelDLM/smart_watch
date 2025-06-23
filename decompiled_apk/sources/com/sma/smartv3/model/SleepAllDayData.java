package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.util.SparseIntArray;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.szabh.smable3.entity.BleSleep;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class SleepAllDayData {

    @OOXIXo
    private List<BleSleep> analyseSleep;
    private int endTime;

    @OOXIXo
    private String evaluation;
    private int startTime;

    @OOXIXo
    private SparseIntArray status;
    private int total;

    public SleepAllDayData() {
        this(0, 0, 0, null, null, null, 63, null);
    }

    public static /* synthetic */ SleepAllDayData copy$default(SleepAllDayData sleepAllDayData, int i, int i2, int i3, SparseIntArray sparseIntArray, String str, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = sleepAllDayData.total;
        }
        if ((i4 & 2) != 0) {
            i2 = sleepAllDayData.startTime;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = sleepAllDayData.endTime;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            sparseIntArray = sleepAllDayData.status;
        }
        SparseIntArray sparseIntArray2 = sparseIntArray;
        if ((i4 & 16) != 0) {
            str = sleepAllDayData.evaluation;
        }
        String str2 = str;
        if ((i4 & 32) != 0) {
            list = sleepAllDayData.analyseSleep;
        }
        return sleepAllDayData.copy(i, i5, i6, sparseIntArray2, str2, list);
    }

    public final int component1() {
        return this.total;
    }

    public final int component2() {
        return this.startTime;
    }

    public final int component3() {
        return this.endTime;
    }

    @OOXIXo
    public final SparseIntArray component4() {
        return this.status;
    }

    @OOXIXo
    public final String component5() {
        return this.evaluation;
    }

    @OOXIXo
    public final List<BleSleep> component6() {
        return this.analyseSleep;
    }

    @OOXIXo
    public final SleepAllDayData copy(int i, int i2, int i3, @OOXIXo SparseIntArray status, @OOXIXo String evaluation, @OOXIXo List<BleSleep> analyseSleep) {
        IIX0o.x0xO0oo(status, "status");
        IIX0o.x0xO0oo(evaluation, "evaluation");
        IIX0o.x0xO0oo(analyseSleep, "analyseSleep");
        return new SleepAllDayData(i, i2, i3, status, evaluation, analyseSleep);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepAllDayData)) {
            return false;
        }
        SleepAllDayData sleepAllDayData = (SleepAllDayData) obj;
        return this.total == sleepAllDayData.total && this.startTime == sleepAllDayData.startTime && this.endTime == sleepAllDayData.endTime && IIX0o.Oxx0IOOO(this.status, sleepAllDayData.status) && IIX0o.Oxx0IOOO(this.evaluation, sleepAllDayData.evaluation) && IIX0o.Oxx0IOOO(this.analyseSleep, sleepAllDayData.analyseSleep);
    }

    @OOXIXo
    public final List<BleSleep> getAnalyseSleep() {
        return this.analyseSleep;
    }

    public final int getEndTime() {
        return this.endTime;
    }

    @OOXIXo
    public final String getEvaluation() {
        return this.evaluation;
    }

    public final int getStartTime() {
        return this.startTime;
    }

    @OOXIXo
    public final SparseIntArray getStatus() {
        return this.status;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        return (((((((((this.total * 31) + this.startTime) * 31) + this.endTime) * 31) + this.status.hashCode()) * 31) + this.evaluation.hashCode()) * 31) + this.analyseSleep.hashCode();
    }

    public final void setAnalyseSleep(@OOXIXo List<BleSleep> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.analyseSleep = list;
    }

    public final void setEndTime(int i) {
        this.endTime = i;
    }

    public final void setEvaluation(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.evaluation = str;
    }

    public final void setStartTime(int i) {
        this.startTime = i;
    }

    public final void setStatus(@OOXIXo SparseIntArray sparseIntArray) {
        IIX0o.x0xO0oo(sparseIntArray, "<set-?>");
        this.status = sparseIntArray;
    }

    public final void setTotal(int i) {
        this.total = i;
    }

    @OOXIXo
    public String toString() {
        return "SleepAllDayData(total=" + this.total + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", status=" + this.status + ", evaluation=" + this.evaluation + ", analyseSleep=" + this.analyseSleep + HexStringBuilder.COMMENT_END_CHAR;
    }

    public SleepAllDayData(int i, int i2, int i3, @OOXIXo SparseIntArray status, @OOXIXo String evaluation, @OOXIXo List<BleSleep> analyseSleep) {
        IIX0o.x0xO0oo(status, "status");
        IIX0o.x0xO0oo(evaluation, "evaluation");
        IIX0o.x0xO0oo(analyseSleep, "analyseSleep");
        this.total = i;
        this.startTime = i2;
        this.endTime = i3;
        this.status = status;
        this.evaluation = evaluation;
        this.analyseSleep = analyseSleep;
    }

    public /* synthetic */ SleepAllDayData(int i, int i2, int i3, SparseIntArray sparseIntArray, String str, List list, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) == 0 ? i3 : 0, (i4 & 8) != 0 ? new SparseIntArray() : sparseIntArray, (i4 & 16) != 0 ? HelpFormatter.DEFAULT_LONG_OPT_PREFIX : str, (i4 & 32) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list);
    }
}
