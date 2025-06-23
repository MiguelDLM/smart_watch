package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleAlarm extends BleIdObject {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 28;
    public static final int TAG_LENGTH = 21;
    private int mDay;
    private int mEnabled;
    private int mHour;
    private int mMinute;
    private int mMonth;
    private int mRepeat;

    @OOXIXo
    private String mTag;
    private int mYear;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleAlarm() {
        this(0, 0, 0, 0, 0, 0, 0, null, 255, null);
    }

    public final int component1() {
        return this.mEnabled;
    }

    public final int component2() {
        return this.mRepeat;
    }

    public final int component3() {
        return this.mYear;
    }

    public final int component4() {
        return this.mMonth;
    }

    public final int component5() {
        return this.mDay;
    }

    public final int component6() {
        return this.mHour;
    }

    public final int component7() {
        return this.mMinute;
    }

    @OOXIXo
    public final String component8() {
        return this.mTag;
    }

    @OOXIXo
    public final BleAlarm copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, @OOXIXo String mTag) {
        IIX0o.x0xO0oo(mTag, "mTag");
        return new BleAlarm(i, i2, i3, i4, i5, i6, i7, mTag);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        setMId(readUInt8());
        this.mEnabled = readIntN(1);
        this.mRepeat = readIntN(7);
        this.mYear = readUInt8() + 2000;
        this.mMonth = readUInt8();
        this.mDay = readUInt8();
        this.mHour = readUInt8();
        this.mMinute = readUInt8();
        this.mTag = BleReadable.readString$default(this, 21, null, 2, null);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(getMId());
        writeIntN(this.mEnabled, 1);
        writeIntN(this.mRepeat, 7);
        writeInt8(this.mYear - 2000);
        writeInt8(this.mMonth);
        writeInt8(this.mDay);
        writeInt8(this.mHour);
        writeInt8(this.mMinute);
        BleWritable.writeStringWithFix$default(this, this.mTag, 21, null, 4, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleAlarm)) {
            return false;
        }
        BleAlarm bleAlarm = (BleAlarm) obj;
        return this.mEnabled == bleAlarm.mEnabled && this.mRepeat == bleAlarm.mRepeat && this.mYear == bleAlarm.mYear && this.mMonth == bleAlarm.mMonth && this.mDay == bleAlarm.mDay && this.mHour == bleAlarm.mHour && this.mMinute == bleAlarm.mMinute && IIX0o.Oxx0IOOO(this.mTag, bleAlarm.mTag);
    }

    public final int getMDay() {
        return this.mDay;
    }

    public final int getMEnabled() {
        return this.mEnabled;
    }

    public final int getMHour() {
        return this.mHour;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 28;
    }

    public final int getMMinute() {
        return this.mMinute;
    }

    public final int getMMonth() {
        return this.mMonth;
    }

    public final int getMRepeat() {
        return this.mRepeat;
    }

    @OOXIXo
    public final String getMTag() {
        return this.mTag;
    }

    public final int getMYear() {
        return this.mYear;
    }

    public int hashCode() {
        return (((((((((((((this.mEnabled * 31) + this.mRepeat) * 31) + this.mYear) * 31) + this.mMonth) * 31) + this.mDay) * 31) + this.mHour) * 31) + this.mMinute) * 31) + this.mTag.hashCode();
    }

    public final void setMDay(int i) {
        this.mDay = i;
    }

    public final void setMEnabled(int i) {
        this.mEnabled = i;
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

    public final void setMRepeat(int i) {
        this.mRepeat = i;
    }

    public final void setMTag(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mTag = str;
    }

    public final void setMYear(int i) {
        this.mYear = i;
    }

    @OOXIXo
    public String toString() {
        return "BleAlarm(mAlarmId=" + getMId() + ", mEnabled=" + this.mEnabled + ", mRepeat=" + this.mRepeat + ", mYear=" + this.mYear + ", mMonth=" + this.mMonth + ", mDay=" + this.mDay + ", mHour=" + this.mHour + ", mMinute=" + this.mMinute + ", mTag='" + this.mTag + "')";
    }

    public /* synthetic */ BleAlarm(int i, int i2, int i3, int i4, int i5, int i6, int i7, String str, int i8, IIXOooo iIXOooo) {
        this((i8 & 1) != 0 ? 1 : i, (i8 & 2) != 0 ? 0 : i2, (i8 & 4) != 0 ? 0 : i3, (i8 & 8) != 0 ? 0 : i4, (i8 & 16) != 0 ? 0 : i5, (i8 & 32) != 0 ? 0 : i6, (i8 & 64) == 0 ? i7 : 0, (i8 & 128) != 0 ? "" : str);
    }

    public BleAlarm(int i, int i2, int i3, int i4, int i5, int i6, int i7, @OOXIXo String mTag) {
        IIX0o.x0xO0oo(mTag, "mTag");
        this.mEnabled = i;
        this.mRepeat = i2;
        this.mYear = i3;
        this.mMonth = i4;
        this.mDay = i5;
        this.mHour = i6;
        this.mMinute = i7;
        this.mTag = mTag;
    }
}
