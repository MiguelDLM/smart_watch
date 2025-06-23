package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleVoltageRecord extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 8;
    private int mDay;
    private int mHour;
    private int mMinute;
    private int mMonth;
    private int mSecond;
    private int mVoltage;
    private int mYear;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleVoltageRecord() {
        this(0, 0, 0, 0, 0, 0, 0, 127, null);
    }

    public static /* synthetic */ BleVoltageRecord copy$default(BleVoltageRecord bleVoltageRecord, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i = bleVoltageRecord.mYear;
        }
        if ((i8 & 2) != 0) {
            i2 = bleVoltageRecord.mMonth;
        }
        int i9 = i2;
        if ((i8 & 4) != 0) {
            i3 = bleVoltageRecord.mDay;
        }
        int i10 = i3;
        if ((i8 & 8) != 0) {
            i4 = bleVoltageRecord.mHour;
        }
        int i11 = i4;
        if ((i8 & 16) != 0) {
            i5 = bleVoltageRecord.mMinute;
        }
        int i12 = i5;
        if ((i8 & 32) != 0) {
            i6 = bleVoltageRecord.mSecond;
        }
        int i13 = i6;
        if ((i8 & 64) != 0) {
            i7 = bleVoltageRecord.mVoltage;
        }
        return bleVoltageRecord.copy(i, i9, i10, i11, i12, i13, i7);
    }

    public final int component1() {
        return this.mYear;
    }

    public final int component2() {
        return this.mMonth;
    }

    public final int component3() {
        return this.mDay;
    }

    public final int component4() {
        return this.mHour;
    }

    public final int component5() {
        return this.mMinute;
    }

    public final int component6() {
        return this.mSecond;
    }

    public final int component7() {
        return this.mVoltage;
    }

    @OOXIXo
    public final BleVoltageRecord copy(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return new BleVoltageRecord(i, i2, i3, i4, i5, i6, i7);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mYear = readInt8();
        this.mMonth = readInt8();
        this.mDay = readInt8();
        this.mHour = readInt8();
        this.mMinute = readInt8();
        this.mSecond = readInt8();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mVoltage = readUInt16(LITTLE_ENDIAN);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleVoltageRecord)) {
            return false;
        }
        BleVoltageRecord bleVoltageRecord = (BleVoltageRecord) obj;
        return this.mYear == bleVoltageRecord.mYear && this.mMonth == bleVoltageRecord.mMonth && this.mDay == bleVoltageRecord.mDay && this.mHour == bleVoltageRecord.mHour && this.mMinute == bleVoltageRecord.mMinute && this.mSecond == bleVoltageRecord.mSecond && this.mVoltage == bleVoltageRecord.mVoltage;
    }

    public final int getMDay() {
        return this.mDay;
    }

    public final int getMHour() {
        return this.mHour;
    }

    public final int getMMinute() {
        return this.mMinute;
    }

    public final int getMMonth() {
        return this.mMonth;
    }

    public final int getMSecond() {
        return this.mSecond;
    }

    public final int getMVoltage() {
        return this.mVoltage;
    }

    public final int getMYear() {
        return this.mYear;
    }

    public int hashCode() {
        return (((((((((((this.mYear * 31) + this.mMonth) * 31) + this.mDay) * 31) + this.mHour) * 31) + this.mMinute) * 31) + this.mSecond) * 31) + this.mVoltage;
    }

    public final void setMDay(int i) {
        this.mDay = i;
    }

    public final void setMHour(int i) {
        this.mHour = i;
    }

    public final void setMMinute(int i) {
        this.mMinute = i;
    }

    public final void setMMonth(int i) {
        this.mMonth = i;
    }

    public final void setMSecond(int i) {
        this.mSecond = i;
    }

    public final void setMVoltage(int i) {
        this.mVoltage = i;
    }

    public final void setMYear(int i) {
        this.mYear = i;
    }

    @OOXIXo
    public String toString() {
        return "BleVoltageRecord(mYear=" + this.mYear + ", mMonth=" + this.mMonth + ", mDay=" + this.mDay + ", mHour=" + this.mHour + ", mMinute=" + this.mMinute + ", mSecond=" + this.mSecond + ", mVoltage=" + this.mVoltage + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleVoltageRecord(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, IIXOooo iIXOooo) {
        this((i8 & 1) != 0 ? 0 : i, (i8 & 2) != 0 ? 0 : i2, (i8 & 4) != 0 ? 0 : i3, (i8 & 8) != 0 ? 0 : i4, (i8 & 16) != 0 ? 0 : i5, (i8 & 32) != 0 ? 0 : i6, (i8 & 64) != 0 ? 0 : i7);
    }

    public BleVoltageRecord(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.mYear = i;
        this.mMonth = i2;
        this.mDay = i3;
        this.mHour = i4;
        this.mMinute = i5;
        this.mSecond = i6;
        this.mVoltage = i7;
    }
}
