package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleSosCallLog extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 48;
    private static final int PHONE_LENGTH = 24;
    private int mBOValue;
    private int mBpm;
    private int mDuration;
    private int mLastBOTime;
    private int mLastHrTime;

    @OOXIXo
    private String mPhone;
    private int mTime;
    private int mType;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleSosCallLog() {
        this(0, 0, 0, null, 0, 0, 0, 0, 255, null);
    }

    public final int component1() {
        return this.mTime;
    }

    public final int component2() {
        return this.mDuration;
    }

    public final int component3() {
        return this.mType;
    }

    @OOXIXo
    public final String component4() {
        return this.mPhone;
    }

    public final int component5() {
        return this.mLastHrTime;
    }

    public final int component6() {
        return this.mLastBOTime;
    }

    public final int component7() {
        return this.mBpm;
    }

    public final int component8() {
        return this.mBOValue;
    }

    @OOXIXo
    public final BleSosCallLog copy(int i, int i2, int i3, @OOXIXo String mPhone, int i4, int i5, int i6, int i7) {
        IIX0o.x0xO0oo(mPhone, "mPhone");
        return new BleSosCallLog(i, i2, i3, mPhone, i4, i5, i6, i7);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mTime = (int) readUInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mDuration = readInt16(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mType = readUInt16(LITTLE_ENDIAN);
        this.mPhone = BleReadable.readString$default(this, 24, null, 2, null);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mLastHrTime = (int) readUInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mLastBOTime = (int) readUInt32(LITTLE_ENDIAN);
        this.mBpm = readUInt8();
        this.mBOValue = readUInt8();
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleSosCallLog)) {
            return false;
        }
        BleSosCallLog bleSosCallLog = (BleSosCallLog) obj;
        return this.mTime == bleSosCallLog.mTime && this.mDuration == bleSosCallLog.mDuration && this.mType == bleSosCallLog.mType && IIX0o.Oxx0IOOO(this.mPhone, bleSosCallLog.mPhone) && this.mLastHrTime == bleSosCallLog.mLastHrTime && this.mLastBOTime == bleSosCallLog.mLastBOTime && this.mBpm == bleSosCallLog.mBpm && this.mBOValue == bleSosCallLog.mBOValue;
    }

    public final int getMBOValue() {
        return this.mBOValue;
    }

    public final int getMBpm() {
        return this.mBpm;
    }

    public final int getMDuration() {
        return this.mDuration;
    }

    public final int getMLastBOTime() {
        return this.mLastBOTime;
    }

    public final int getMLastHrTime() {
        return this.mLastHrTime;
    }

    @OOXIXo
    public final String getMPhone() {
        return this.mPhone;
    }

    public final int getMTime() {
        return this.mTime;
    }

    public final int getMType() {
        return this.mType;
    }

    public int hashCode() {
        return (((((((((((((this.mTime * 31) + this.mDuration) * 31) + this.mType) * 31) + this.mPhone.hashCode()) * 31) + this.mLastHrTime) * 31) + this.mLastBOTime) * 31) + this.mBpm) * 31) + this.mBOValue;
    }

    public final void setMBOValue(int i) {
        this.mBOValue = i;
    }

    public final void setMBpm(int i) {
        this.mBpm = i;
    }

    public final void setMDuration(int i) {
        this.mDuration = i;
    }

    public final void setMLastBOTime(int i) {
        this.mLastBOTime = i;
    }

    public final void setMLastHrTime(int i) {
        this.mLastHrTime = i;
    }

    public final void setMPhone(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mPhone = str;
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    @OOXIXo
    public String toString() {
        return "BleSosCallLog(mTime=" + this.mTime + ", mDuration=" + this.mDuration + ", mType=" + this.mType + ", mPhone=" + this.mPhone + ", mLastHrTime=" + this.mLastHrTime + ", mLastBOTime=" + this.mLastBOTime + ", mBpm=" + this.mBpm + ", mBOValue=" + this.mBOValue + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleSosCallLog(int i, int i2, int i3, String str, int i4, int i5, int i6, int i7, int i8, IIXOooo iIXOooo) {
        this((i8 & 1) != 0 ? 0 : i, (i8 & 2) != 0 ? 0 : i2, (i8 & 4) != 0 ? 0 : i3, (i8 & 8) != 0 ? "" : str, (i8 & 16) != 0 ? 0 : i4, (i8 & 32) != 0 ? 0 : i5, (i8 & 64) != 0 ? 0 : i6, (i8 & 128) == 0 ? i7 : 0);
    }

    public BleSosCallLog(int i, int i2, int i3, @OOXIXo String mPhone, int i4, int i5, int i6, int i7) {
        IIX0o.x0xO0oo(mPhone, "mPhone");
        this.mTime = i;
        this.mDuration = i2;
        this.mType = i3;
        this.mPhone = mPhone;
        this.mLastHrTime = i4;
        this.mLastBOTime = i5;
        this.mBpm = i6;
        this.mBOValue = i7;
    }
}
