package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.util.SparseIntArray;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class SleepDayData {

    @OOXIXo
    private String evaluation;
    private int startTime;

    @OOXIXo
    private SparseIntArray status;
    private int total;

    public SleepDayData() {
        this(0, 0, null, null, 15, null);
    }

    public static /* synthetic */ SleepDayData copy$default(SleepDayData sleepDayData, int i, int i2, SparseIntArray sparseIntArray, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = sleepDayData.total;
        }
        if ((i3 & 2) != 0) {
            i2 = sleepDayData.startTime;
        }
        if ((i3 & 4) != 0) {
            sparseIntArray = sleepDayData.status;
        }
        if ((i3 & 8) != 0) {
            str = sleepDayData.evaluation;
        }
        return sleepDayData.copy(i, i2, sparseIntArray, str);
    }

    public final int component1() {
        return this.total;
    }

    public final int component2() {
        return this.startTime;
    }

    @OOXIXo
    public final SparseIntArray component3() {
        return this.status;
    }

    @OOXIXo
    public final String component4() {
        return this.evaluation;
    }

    @OOXIXo
    public final SleepDayData copy(int i, int i2, @OOXIXo SparseIntArray status, @OOXIXo String evaluation) {
        IIX0o.x0xO0oo(status, "status");
        IIX0o.x0xO0oo(evaluation, "evaluation");
        return new SleepDayData(i, i2, status, evaluation);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepDayData)) {
            return false;
        }
        SleepDayData sleepDayData = (SleepDayData) obj;
        return this.total == sleepDayData.total && this.startTime == sleepDayData.startTime && IIX0o.Oxx0IOOO(this.status, sleepDayData.status) && IIX0o.Oxx0IOOO(this.evaluation, sleepDayData.evaluation);
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
        return (((((this.total * 31) + this.startTime) * 31) + this.status.hashCode()) * 31) + this.evaluation.hashCode();
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
        return "SleepDayData(total=" + this.total + ", startTime=" + this.startTime + ", status=" + this.status + ", evaluation=" + this.evaluation + HexStringBuilder.COMMENT_END_CHAR;
    }

    public SleepDayData(int i, int i2, @OOXIXo SparseIntArray status, @OOXIXo String evaluation) {
        IIX0o.x0xO0oo(status, "status");
        IIX0o.x0xO0oo(evaluation, "evaluation");
        this.total = i;
        this.startTime = i2;
        this.status = status;
        this.evaluation = evaluation;
    }

    public /* synthetic */ SleepDayData(int i, int i2, SparseIntArray sparseIntArray, String str, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? new SparseIntArray() : sparseIntArray, (i3 & 8) != 0 ? HelpFormatter.DEFAULT_LONG_OPT_PREFIX : str);
    }
}
