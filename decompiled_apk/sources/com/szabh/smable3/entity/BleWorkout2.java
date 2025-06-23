package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.android.exoplayer2.C;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleWorkout2 extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 128;
    private int mAirPressure;
    private int mAltitude;
    private int mAvgBpm;
    private int mAvgStress;
    private int mCalorie;
    private int mDistance;
    private int mDuration;
    private int mEnd;
    private int mMaxAltitude;
    private int mMaxBpm;
    private int mMaxPace;
    private int mMaxSpeed;
    private int mMaxSpm;
    private int mMaxStress;
    private int mMinAltitude;
    private int mMinBpm;
    private int mMinPace;
    private int mMinSpeed;
    private int mMinSpm;
    private int mMinStress;
    private int mMode;
    private int mPace;
    private int mRestDuration;
    private int mSpeed;
    private int mSpm;
    private int mStart;
    private int mStep;
    private int mUndefined;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleWorkout2() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 268435455, null);
    }

    public final int component1() {
        return this.mStart;
    }

    public final int component10() {
        return this.mCalorie;
    }

    public final int component11() {
        return this.mSpeed;
    }

    public final int component12() {
        return this.mPace;
    }

    public final int component13() {
        return this.mAvgBpm;
    }

    public final int component14() {
        return this.mMaxBpm;
    }

    public final int component15() {
        return this.mMinBpm;
    }

    public final int component16() {
        return this.mUndefined;
    }

    public final int component17() {
        return this.mMaxSpm;
    }

    public final int component18() {
        return this.mMinSpm;
    }

    public final int component19() {
        return this.mMaxPace;
    }

    public final int component2() {
        return this.mEnd;
    }

    public final int component20() {
        return this.mMinPace;
    }

    public final int component21() {
        return this.mMaxAltitude;
    }

    public final int component22() {
        return this.mMinAltitude;
    }

    public final int component23() {
        return this.mMinStress;
    }

    public final int component24() {
        return this.mMaxStress;
    }

    public final int component25() {
        return this.mAvgStress;
    }

    public final int component26() {
        return this.mMaxSpeed;
    }

    public final int component27() {
        return this.mMinSpeed;
    }

    public final int component28() {
        return this.mRestDuration;
    }

    public final int component3() {
        return this.mDuration;
    }

    public final int component4() {
        return this.mAltitude;
    }

    public final int component5() {
        return this.mAirPressure;
    }

    public final int component6() {
        return this.mSpm;
    }

    public final int component7() {
        return this.mMode;
    }

    public final int component8() {
        return this.mStep;
    }

    public final int component9() {
        return this.mDistance;
    }

    @OOXIXo
    public final BleWorkout2 copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28) {
        return new BleWorkout2(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, i28);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mStart = BleReadable.readInt32$default(this, null, 1, null);
        this.mEnd = BleReadable.readInt32$default(this, null, 1, null);
        this.mDuration = BleReadable.readUInt16$default(this, null, 1, null);
        this.mAltitude = BleReadable.readInt16$default(this, null, 1, null);
        this.mAirPressure = BleReadable.readUInt16$default(this, null, 1, null);
        this.mSpm = readUInt8();
        this.mMode = readUInt8();
        this.mStep = BleReadable.readInt32$default(this, null, 1, null);
        this.mDistance = BleReadable.readInt32$default(this, null, 1, null);
        this.mCalorie = BleReadable.readInt32$default(this, null, 1, null);
        this.mSpeed = BleReadable.readInt32$default(this, null, 1, null);
        this.mPace = BleReadable.readInt32$default(this, null, 1, null);
        this.mAvgBpm = readUInt8();
        this.mMaxBpm = readUInt8();
        this.mMinBpm = readUInt8();
        this.mUndefined = readInt8();
        this.mMaxSpm = BleReadable.readInt16$default(this, null, 1, null);
        this.mMinSpm = BleReadable.readInt16$default(this, null, 1, null);
        this.mMaxPace = BleReadable.readInt32$default(this, null, 1, null);
        this.mMinPace = BleReadable.readInt32$default(this, null, 1, null);
        this.mMaxAltitude = BleReadable.readInt16$default(this, null, 1, null);
        this.mMinAltitude = BleReadable.readInt16$default(this, null, 1, null);
        this.mMinStress = readUInt8();
        this.mMaxStress = readUInt8();
        this.mAvgStress = readUInt8();
        this.mMaxSpeed = BleReadable.readInt32$default(this, null, 1, null);
        this.mMinSpeed = BleReadable.readInt32$default(this, null, 1, null);
        this.mRestDuration = BleReadable.readInt32$default(this, null, 1, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleWorkout2)) {
            return false;
        }
        BleWorkout2 bleWorkout2 = (BleWorkout2) obj;
        return this.mStart == bleWorkout2.mStart && this.mEnd == bleWorkout2.mEnd && this.mDuration == bleWorkout2.mDuration && this.mAltitude == bleWorkout2.mAltitude && this.mAirPressure == bleWorkout2.mAirPressure && this.mSpm == bleWorkout2.mSpm && this.mMode == bleWorkout2.mMode && this.mStep == bleWorkout2.mStep && this.mDistance == bleWorkout2.mDistance && this.mCalorie == bleWorkout2.mCalorie && this.mSpeed == bleWorkout2.mSpeed && this.mPace == bleWorkout2.mPace && this.mAvgBpm == bleWorkout2.mAvgBpm && this.mMaxBpm == bleWorkout2.mMaxBpm && this.mMinBpm == bleWorkout2.mMinBpm && this.mUndefined == bleWorkout2.mUndefined && this.mMaxSpm == bleWorkout2.mMaxSpm && this.mMinSpm == bleWorkout2.mMinSpm && this.mMaxPace == bleWorkout2.mMaxPace && this.mMinPace == bleWorkout2.mMinPace && this.mMaxAltitude == bleWorkout2.mMaxAltitude && this.mMinAltitude == bleWorkout2.mMinAltitude && this.mMinStress == bleWorkout2.mMinStress && this.mMaxStress == bleWorkout2.mMaxStress && this.mAvgStress == bleWorkout2.mAvgStress && this.mMaxSpeed == bleWorkout2.mMaxSpeed && this.mMinSpeed == bleWorkout2.mMinSpeed && this.mRestDuration == bleWorkout2.mRestDuration;
    }

    public final int getMAirPressure() {
        return this.mAirPressure;
    }

    public final int getMAltitude() {
        return this.mAltitude;
    }

    public final int getMAvgBpm() {
        return this.mAvgBpm;
    }

    public final int getMAvgStress() {
        return this.mAvgStress;
    }

    public final int getMCalorie() {
        return this.mCalorie;
    }

    public final int getMDistance() {
        return this.mDistance;
    }

    public final int getMDuration() {
        return this.mDuration;
    }

    public final int getMEnd() {
        return this.mEnd;
    }

    public final int getMMaxAltitude() {
        return this.mMaxAltitude;
    }

    public final int getMMaxBpm() {
        return this.mMaxBpm;
    }

    public final int getMMaxPace() {
        return this.mMaxPace;
    }

    public final int getMMaxSpeed() {
        return this.mMaxSpeed;
    }

    public final int getMMaxSpm() {
        return this.mMaxSpm;
    }

    public final int getMMaxStress() {
        return this.mMaxStress;
    }

    public final int getMMinAltitude() {
        return this.mMinAltitude;
    }

    public final int getMMinBpm() {
        return this.mMinBpm;
    }

    public final int getMMinPace() {
        return this.mMinPace;
    }

    public final int getMMinSpeed() {
        return this.mMinSpeed;
    }

    public final int getMMinSpm() {
        return this.mMinSpm;
    }

    public final int getMMinStress() {
        return this.mMinStress;
    }

    public final int getMMode() {
        return this.mMode;
    }

    public final int getMPace() {
        return this.mPace;
    }

    public final int getMRestDuration() {
        return this.mRestDuration;
    }

    public final int getMSpeed() {
        return this.mSpeed;
    }

    public final int getMSpm() {
        return this.mSpm;
    }

    public final int getMStart() {
        return this.mStart;
    }

    public final int getMStep() {
        return this.mStep;
    }

    public final int getMUndefined() {
        return this.mUndefined;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((this.mStart * 31) + this.mEnd) * 31) + this.mDuration) * 31) + this.mAltitude) * 31) + this.mAirPressure) * 31) + this.mSpm) * 31) + this.mMode) * 31) + this.mStep) * 31) + this.mDistance) * 31) + this.mCalorie) * 31) + this.mSpeed) * 31) + this.mPace) * 31) + this.mAvgBpm) * 31) + this.mMaxBpm) * 31) + this.mMinBpm) * 31) + this.mUndefined) * 31) + this.mMaxSpm) * 31) + this.mMinSpm) * 31) + this.mMaxPace) * 31) + this.mMinPace) * 31) + this.mMaxAltitude) * 31) + this.mMinAltitude) * 31) + this.mMinStress) * 31) + this.mMaxStress) * 31) + this.mAvgStress) * 31) + this.mMaxSpeed) * 31) + this.mMinSpeed) * 31) + this.mRestDuration;
    }

    public final void setMAirPressure(int i) {
        this.mAirPressure = i;
    }

    public final void setMAltitude(int i) {
        this.mAltitude = i;
    }

    public final void setMAvgBpm(int i) {
        this.mAvgBpm = i;
    }

    public final void setMAvgStress(int i) {
        this.mAvgStress = i;
    }

    public final void setMCalorie(int i) {
        this.mCalorie = i;
    }

    public final void setMDistance(int i) {
        this.mDistance = i;
    }

    public final void setMDuration(int i) {
        this.mDuration = i;
    }

    public final void setMEnd(int i) {
        this.mEnd = i;
    }

    public final void setMMaxAltitude(int i) {
        this.mMaxAltitude = i;
    }

    public final void setMMaxBpm(int i) {
        this.mMaxBpm = i;
    }

    public final void setMMaxPace(int i) {
        this.mMaxPace = i;
    }

    public final void setMMaxSpeed(int i) {
        this.mMaxSpeed = i;
    }

    public final void setMMaxSpm(int i) {
        this.mMaxSpm = i;
    }

    public final void setMMaxStress(int i) {
        this.mMaxStress = i;
    }

    public final void setMMinAltitude(int i) {
        this.mMinAltitude = i;
    }

    public final void setMMinBpm(int i) {
        this.mMinBpm = i;
    }

    public final void setMMinPace(int i) {
        this.mMinPace = i;
    }

    public final void setMMinSpeed(int i) {
        this.mMinSpeed = i;
    }

    public final void setMMinSpm(int i) {
        this.mMinSpm = i;
    }

    public final void setMMinStress(int i) {
        this.mMinStress = i;
    }

    public final void setMMode(int i) {
        this.mMode = i;
    }

    public final void setMPace(int i) {
        this.mPace = i;
    }

    public final void setMRestDuration(int i) {
        this.mRestDuration = i;
    }

    public final void setMSpeed(int i) {
        this.mSpeed = i;
    }

    public final void setMSpm(int i) {
        this.mSpm = i;
    }

    public final void setMStart(int i) {
        this.mStart = i;
    }

    public final void setMStep(int i) {
        this.mStep = i;
    }

    public final void setMUndefined(int i) {
        this.mUndefined = i;
    }

    @OOXIXo
    public String toString() {
        return "BleWorkout2(mStart=" + this.mStart + ", mEnd=" + this.mEnd + ", mDuration=" + this.mDuration + ", mAltitude=" + this.mAltitude + ", mAirPressure=" + this.mAirPressure + ", mSpm=" + this.mSpm + ", mMode=" + this.mMode + ", mStep=" + this.mStep + ", mDistance=" + this.mDistance + ", mCalorie=" + this.mCalorie + ", mSpeed=" + this.mSpeed + ", mPace=" + this.mPace + ", mAvgBpm=" + this.mAvgBpm + ", mMaxBpm=" + this.mMaxBpm + ", mMinBpm=" + this.mMinBpm + ", mUndefined=" + this.mUndefined + ", mMaxSpm=" + this.mMaxSpm + ", mMinSpm=" + this.mMinSpm + ", mMaxPace=" + this.mMaxPace + ", mMinPace=" + this.mMinPace + ", mMaxAltitude=" + this.mMaxAltitude + ", mMinAltitude=" + this.mMinAltitude + ", mMinStress=" + this.mMinStress + ", mMaxStress=" + this.mMaxStress + ", mAvgStress=" + this.mAvgStress + ", mMaxSpeed=" + this.mMaxSpeed + ", mMinSpeed=" + this.mMinSpeed + ", mRestDuration=" + this.mRestDuration + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleWorkout2(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, IIXOooo iIXOooo) {
        this((i29 & 1) != 0 ? 0 : i, (i29 & 2) != 0 ? 0 : i2, (i29 & 4) != 0 ? 0 : i3, (i29 & 8) != 0 ? 0 : i4, (i29 & 16) != 0 ? 0 : i5, (i29 & 32) != 0 ? 0 : i6, (i29 & 64) != 0 ? 0 : i7, (i29 & 128) != 0 ? 0 : i8, (i29 & 256) != 0 ? 0 : i9, (i29 & 512) != 0 ? 0 : i10, (i29 & 1024) != 0 ? 0 : i11, (i29 & 2048) != 0 ? 0 : i12, (i29 & 4096) != 0 ? 0 : i13, (i29 & 8192) != 0 ? 0 : i14, (i29 & 16384) != 0 ? 0 : i15, (i29 & 32768) != 0 ? 0 : i16, (i29 & 65536) != 0 ? 0 : i17, (i29 & 131072) != 0 ? 0 : i18, (i29 & 262144) != 0 ? 0 : i19, (i29 & 524288) != 0 ? 0 : i20, (i29 & 1048576) != 0 ? 0 : i21, (i29 & 2097152) != 0 ? 0 : i22, (i29 & 4194304) != 0 ? 0 : i23, (i29 & 8388608) != 0 ? 0 : i24, (i29 & 16777216) != 0 ? 0 : i25, (i29 & 33554432) != 0 ? 0 : i26, (i29 & 67108864) != 0 ? 0 : i27, (i29 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? 0 : i28);
    }

    public BleWorkout2(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28) {
        this.mStart = i;
        this.mEnd = i2;
        this.mDuration = i3;
        this.mAltitude = i4;
        this.mAirPressure = i5;
        this.mSpm = i6;
        this.mMode = i7;
        this.mStep = i8;
        this.mDistance = i9;
        this.mCalorie = i10;
        this.mSpeed = i11;
        this.mPace = i12;
        this.mAvgBpm = i13;
        this.mMaxBpm = i14;
        this.mMinBpm = i15;
        this.mUndefined = i16;
        this.mMaxSpm = i17;
        this.mMinSpm = i18;
        this.mMaxPace = i19;
        this.mMinPace = i20;
        this.mMaxAltitude = i21;
        this.mMinAltitude = i22;
        this.mMinStress = i23;
        this.mMaxStress = i24;
        this.mAvgStress = i25;
        this.mMaxSpeed = i26;
        this.mMinSpeed = i27;
        this.mRestDuration = i28;
    }
}
