package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleCheckInEveryDay extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 16;
    private int mCheckTime;
    private int mEarnPoints;
    private int mEndHour;
    private int mEndMinute;
    private int mStartHour;
    private int mStartMinute;
    private int mStatus;
    private int mStepRanking;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleCheckInEveryDay() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 255, null);
    }

    public final int component1() {
        return this.mStartHour;
    }

    public final int component2() {
        return this.mStartMinute;
    }

    public final int component3() {
        return this.mEndHour;
    }

    public final int component4() {
        return this.mEndMinute;
    }

    public final int component5() {
        return this.mStepRanking;
    }

    public final int component6() {
        return this.mEarnPoints;
    }

    public final int component7() {
        return this.mCheckTime;
    }

    public final int component8() {
        return this.mStatus;
    }

    @OOXIXo
    public final BleCheckInEveryDay copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return new BleCheckInEveryDay(i, i2, i3, i4, i5, i6, i7, i8);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mStartHour = readInt8();
        this.mStartMinute = readInt8();
        this.mEndHour = readInt8();
        this.mEndMinute = readInt8();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mStepRanking = readInt16(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mEarnPoints = readInt16(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mCheckTime = readInt32(LITTLE_ENDIAN);
        this.mStatus = readInt8();
        BleReadable.readInt24$default(this, null, 1, null);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mStartHour);
        writeInt8(this.mStartMinute);
        writeInt8(this.mEndHour);
        writeInt8(this.mEndMinute);
        int i = this.mStepRanking;
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt16(i, LITTLE_ENDIAN);
        int i2 = this.mEarnPoints;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt16(i2, LITTLE_ENDIAN);
        int i3 = this.mCheckTime;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt32(i3, LITTLE_ENDIAN);
        writeInt8(this.mStatus);
        BleWritable.writeInt24$default(this, 0, null, 2, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleCheckInEveryDay)) {
            return false;
        }
        BleCheckInEveryDay bleCheckInEveryDay = (BleCheckInEveryDay) obj;
        return this.mStartHour == bleCheckInEveryDay.mStartHour && this.mStartMinute == bleCheckInEveryDay.mStartMinute && this.mEndHour == bleCheckInEveryDay.mEndHour && this.mEndMinute == bleCheckInEveryDay.mEndMinute && this.mStepRanking == bleCheckInEveryDay.mStepRanking && this.mEarnPoints == bleCheckInEveryDay.mEarnPoints && this.mCheckTime == bleCheckInEveryDay.mCheckTime && this.mStatus == bleCheckInEveryDay.mStatus;
    }

    public final int getMCheckTime() {
        return this.mCheckTime;
    }

    public final int getMEarnPoints() {
        return this.mEarnPoints;
    }

    public final int getMEndHour() {
        return this.mEndHour;
    }

    public final int getMEndMinute() {
        return this.mEndMinute;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 16;
    }

    public final int getMStartHour() {
        return this.mStartHour;
    }

    public final int getMStartMinute() {
        return this.mStartMinute;
    }

    public final int getMStatus() {
        return this.mStatus;
    }

    public final int getMStepRanking() {
        return this.mStepRanking;
    }

    public int hashCode() {
        return (((((((((((((this.mStartHour * 31) + this.mStartMinute) * 31) + this.mEndHour) * 31) + this.mEndMinute) * 31) + this.mStepRanking) * 31) + this.mEarnPoints) * 31) + this.mCheckTime) * 31) + this.mStatus;
    }

    public final void setMCheckTime(int i) {
        this.mCheckTime = i;
    }

    public final void setMEarnPoints(int i) {
        this.mEarnPoints = i;
    }

    public final void setMEndHour(int i) {
        this.mEndHour = i;
    }

    public final void setMEndMinute(int i) {
        this.mEndMinute = i;
    }

    public final void setMStartHour(int i) {
        this.mStartHour = i;
    }

    public final void setMStartMinute(int i) {
        this.mStartMinute = i;
    }

    public final void setMStatus(int i) {
        this.mStatus = i;
    }

    public final void setMStepRanking(int i) {
        this.mStepRanking = i;
    }

    @OOXIXo
    public String toString() {
        return "BleCheckInEveryDay(mStartHour=" + this.mStartHour + ", mStartMinute=" + this.mStartMinute + ", mEndHour=" + this.mEndHour + ", mEndMinute=" + this.mEndMinute + ", mStepRanking=" + this.mStepRanking + ", mEarnPoints=" + this.mEarnPoints + ", mCheckTime=" + this.mCheckTime + ", mStatus=" + this.mStatus + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleCheckInEveryDay(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, IIXOooo iIXOooo) {
        this((i9 & 1) != 0 ? 0 : i, (i9 & 2) != 0 ? 0 : i2, (i9 & 4) != 0 ? 0 : i3, (i9 & 8) != 0 ? 0 : i4, (i9 & 16) != 0 ? 0 : i5, (i9 & 32) != 0 ? 0 : i6, (i9 & 64) != 0 ? 0 : i7, (i9 & 128) == 0 ? i8 : 0);
    }

    public BleCheckInEveryDay(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.mStartHour = i;
        this.mStartMinute = i2;
        this.mEndHour = i3;
        this.mEndMinute = i4;
        this.mStepRanking = i5;
        this.mEarnPoints = i6;
        this.mCheckTime = i7;
        this.mStatus = i8;
    }
}
