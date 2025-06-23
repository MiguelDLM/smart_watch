package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class MenstrualPeriodResults {

    @OOXIXo
    private String mCalendar;
    private int mType;

    /* JADX WARN: Multi-variable type inference failed */
    public MenstrualPeriodResults() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ MenstrualPeriodResults copy$default(MenstrualPeriodResults menstrualPeriodResults, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = menstrualPeriodResults.mCalendar;
        }
        if ((i2 & 2) != 0) {
            i = menstrualPeriodResults.mType;
        }
        return menstrualPeriodResults.copy(str, i);
    }

    @OOXIXo
    public final String component1() {
        return this.mCalendar;
    }

    public final int component2() {
        return this.mType;
    }

    @OOXIXo
    public final MenstrualPeriodResults copy(@OOXIXo String mCalendar, int i) {
        IIX0o.x0xO0oo(mCalendar, "mCalendar");
        return new MenstrualPeriodResults(mCalendar, i);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MenstrualPeriodResults)) {
            return false;
        }
        MenstrualPeriodResults menstrualPeriodResults = (MenstrualPeriodResults) obj;
        return IIX0o.Oxx0IOOO(this.mCalendar, menstrualPeriodResults.mCalendar) && this.mType == menstrualPeriodResults.mType;
    }

    @OOXIXo
    public final String getMCalendar() {
        return this.mCalendar;
    }

    public final int getMType() {
        return this.mType;
    }

    public int hashCode() {
        return (this.mCalendar.hashCode() * 31) + this.mType;
    }

    public final void setMCalendar(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mCalendar = str;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    @OOXIXo
    public String toString() {
        return "MenstrualPeriodResults(mCalendar=" + this.mCalendar + ", mType=" + this.mType + HexStringBuilder.COMMENT_END_CHAR;
    }

    public MenstrualPeriodResults(@OOXIXo String mCalendar, int i) {
        IIX0o.x0xO0oo(mCalendar, "mCalendar");
        this.mCalendar = mCalendar;
        this.mType = i;
    }

    public /* synthetic */ MenstrualPeriodResults(String str, int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i);
    }
}
