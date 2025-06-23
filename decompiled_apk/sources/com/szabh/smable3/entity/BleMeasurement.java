package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleMeasurement extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int STATE_END = 2;
    public static final int STATE_FAILED = 3;
    public static final int STATE_GOING = 1;
    public static final int STATE_START = 0;
    public static final int TYPE_BLOOD_GLUCOSE = 0;
    private int mDay;
    private int mHour;
    private int mLength;
    private final int mLengthToWrite;
    private int mMillisecond;
    private int mMinute;
    private int mMonth;

    @OOXIXo
    private byte[] mPacket;
    private int mSecond;
    private int mState;
    private int mType;
    private int mYear;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleMeasurement() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 2047, null);
    }

    public final int component1() {
        return this.mType;
    }

    public final int component10() {
        return this.mLength;
    }

    @OOXIXo
    public final byte[] component11() {
        return this.mPacket;
    }

    public final int component2() {
        return this.mState;
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

    public final int component8() {
        return this.mSecond;
    }

    public final int component9() {
        return this.mMillisecond;
    }

    @OOXIXo
    public final BleMeasurement copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, @OOXIXo byte[] mPacket) {
        IIX0o.x0xO0oo(mPacket, "mPacket");
        return new BleMeasurement(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, mPacket);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mType = readUInt8();
        this.mState = readUInt8();
        this.mYear = readUInt8() + 2000;
        this.mMonth = readUInt8();
        this.mDay = readUInt8();
        this.mHour = readUInt8();
        this.mMinute = readUInt8();
        this.mSecond = readUInt8();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mMillisecond = readUInt16(LITTLE_ENDIAN);
        readBytes(20);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        char readUInt16 = readUInt16(LITTLE_ENDIAN);
        this.mLength = readUInt16;
        this.mPacket = readBytes(readUInt16);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mType);
        writeInt8(this.mState);
        writeInt8(this.mYear - 2000);
        writeInt8(this.mMonth);
        writeInt8(this.mDay);
        writeInt8(this.mHour);
        writeInt8(this.mMinute);
        writeInt8(this.mSecond);
        int i = this.mMillisecond;
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt16(i, LITTLE_ENDIAN);
        BleWritable.writeBytes$default(this, new byte[20], null, 2, null);
        int i2 = this.mLength;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt16(i2, LITTLE_ENDIAN);
        BleWritable.writeBytes$default(this, this.mPacket, null, 2, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleMeasurement)) {
            return false;
        }
        BleMeasurement bleMeasurement = (BleMeasurement) obj;
        return this.mType == bleMeasurement.mType && this.mState == bleMeasurement.mState && this.mYear == bleMeasurement.mYear && this.mMonth == bleMeasurement.mMonth && this.mDay == bleMeasurement.mDay && this.mHour == bleMeasurement.mHour && this.mMinute == bleMeasurement.mMinute && this.mSecond == bleMeasurement.mSecond && this.mMillisecond == bleMeasurement.mMillisecond && this.mLength == bleMeasurement.mLength && IIX0o.Oxx0IOOO(this.mPacket, bleMeasurement.mPacket);
    }

    public final int getMDay() {
        return this.mDay;
    }

    public final int getMHour() {
        return this.mHour;
    }

    public final int getMLength() {
        return this.mLength;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return this.mLengthToWrite;
    }

    public final int getMMillisecond() {
        return this.mMillisecond;
    }

    public final int getMMinute() {
        return this.mMinute;
    }

    public final int getMMonth() {
        return this.mMonth;
    }

    @OOXIXo
    public final byte[] getMPacket() {
        return this.mPacket;
    }

    public final int getMSecond() {
        return this.mSecond;
    }

    public final int getMState() {
        return this.mState;
    }

    public final int getMType() {
        return this.mType;
    }

    public final int getMYear() {
        return this.mYear;
    }

    public int hashCode() {
        return (((((((((((((((((((this.mType * 31) + this.mState) * 31) + this.mYear) * 31) + this.mMonth) * 31) + this.mDay) * 31) + this.mHour) * 31) + this.mMinute) * 31) + this.mSecond) * 31) + this.mMillisecond) * 31) + this.mLength) * 31) + Arrays.hashCode(this.mPacket);
    }

    public final void setMDay(int i) {
        this.mDay = i;
    }

    public final void setMHour(int i) {
        this.mHour = i;
    }

    public final void setMLength(int i) {
        this.mLength = i;
    }

    public final void setMMillisecond(int i) {
        this.mMillisecond = i;
    }

    public final void setMMinute(int i) {
        this.mMinute = i;
    }

    public final void setMMonth(int i) {
        this.mMonth = i;
    }

    public final void setMPacket(@OOXIXo byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "<set-?>");
        this.mPacket = bArr;
    }

    public final void setMSecond(int i) {
        this.mSecond = i;
    }

    public final void setMState(int i) {
        this.mState = i;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    public final void setMYear(int i) {
        this.mYear = i;
    }

    @OOXIXo
    public String toString() {
        return "BleMeasurement(mType=" + this.mType + ", mState=" + this.mState + ", mYear=" + this.mYear + ", mMonth=" + this.mMonth + ", mDay=" + this.mDay + ", mHour=" + this.mHour + ", mMinute=" + this.mMinute + ", mSecond=" + this.mSecond + ", mMillisecond=" + this.mMillisecond + ", mLength=" + this.mLength + ", mPacket=" + this.mPacket.length + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleMeasurement(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, byte[] bArr, int i11, IIXOooo iIXOooo) {
        this((i11 & 1) != 0 ? 0 : i, (i11 & 2) != 0 ? 0 : i2, (i11 & 4) != 0 ? 0 : i3, (i11 & 8) != 0 ? 0 : i4, (i11 & 16) != 0 ? 0 : i5, (i11 & 32) != 0 ? 0 : i6, (i11 & 64) != 0 ? 0 : i7, (i11 & 128) != 0 ? 0 : i8, (i11 & 256) != 0 ? 0 : i9, (i11 & 512) != 0 ? 0 : i10, (i11 & 1024) != 0 ? new byte[0] : bArr);
    }

    public BleMeasurement(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, @OOXIXo byte[] mPacket) {
        IIX0o.x0xO0oo(mPacket, "mPacket");
        this.mType = i;
        this.mState = i2;
        this.mYear = i3;
        this.mMonth = i4;
        this.mDay = i5;
        this.mHour = i6;
        this.mMinute = i7;
        this.mSecond = i8;
        this.mMillisecond = i9;
        this.mLength = i10;
        this.mPacket = mPacket;
        this.mLengthToWrite = mPacket.length + 32;
    }
}
