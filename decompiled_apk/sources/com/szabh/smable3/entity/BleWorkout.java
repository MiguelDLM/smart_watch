package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.garmin.fit.OOxOOxIO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleWorkout extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 48;
    private int mAirPressure;
    private int mAltitude;
    private int mAvgBpm;
    private int mCalorie;
    private int mDistance;
    private int mDuration;
    private int mEnd;
    private int mMaxBpm;
    private int mMode;
    private int mPace;
    private int mSpeed;
    private int mSpm;
    private int mStart;
    private int mStep;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleWorkout() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, OOxOOxIO.f12624oIX0oI, null);
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

    public final int component2() {
        return this.mEnd;
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
    public final BleWorkout copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        return new BleWorkout(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14);
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
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleWorkout)) {
            return false;
        }
        BleWorkout bleWorkout = (BleWorkout) obj;
        return this.mStart == bleWorkout.mStart && this.mEnd == bleWorkout.mEnd && this.mDuration == bleWorkout.mDuration && this.mAltitude == bleWorkout.mAltitude && this.mAirPressure == bleWorkout.mAirPressure && this.mSpm == bleWorkout.mSpm && this.mMode == bleWorkout.mMode && this.mStep == bleWorkout.mStep && this.mDistance == bleWorkout.mDistance && this.mCalorie == bleWorkout.mCalorie && this.mSpeed == bleWorkout.mSpeed && this.mPace == bleWorkout.mPace && this.mAvgBpm == bleWorkout.mAvgBpm && this.mMaxBpm == bleWorkout.mMaxBpm;
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

    public final int getMMaxBpm() {
        return this.mMaxBpm;
    }

    public final int getMMode() {
        return this.mMode;
    }

    public final int getMPace() {
        return this.mPace;
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

    public int hashCode() {
        return (((((((((((((((((((((((((this.mStart * 31) + this.mEnd) * 31) + this.mDuration) * 31) + this.mAltitude) * 31) + this.mAirPressure) * 31) + this.mSpm) * 31) + this.mMode) * 31) + this.mStep) * 31) + this.mDistance) * 31) + this.mCalorie) * 31) + this.mSpeed) * 31) + this.mPace) * 31) + this.mAvgBpm) * 31) + this.mMaxBpm;
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

    public final void setMMaxBpm(int i) {
        this.mMaxBpm = i;
    }

    public final void setMMode(int i) {
        this.mMode = i;
    }

    public final void setMPace(int i) {
        this.mPace = i;
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

    @OOXIXo
    public String toString() {
        return "BleWorkout(mStart=" + this.mStart + ", mEnd=" + this.mEnd + ", mDuration=" + this.mDuration + ", mAltitude=" + this.mAltitude + ", mAirPressure=" + this.mAirPressure + ", mSpm=" + this.mSpm + ", mMode=" + this.mMode + ", mStep=" + this.mStep + ", mDistance=" + this.mDistance + ", mCalorie=" + this.mCalorie + ", mSpeed=" + this.mSpeed + ", mPace=" + this.mPace + ", mAvgBpm=" + this.mAvgBpm + ", mMaxBpm=" + this.mMaxBpm + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleWorkout(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, IIXOooo iIXOooo) {
        this((i15 & 1) != 0 ? 0 : i, (i15 & 2) != 0 ? 0 : i2, (i15 & 4) != 0 ? 0 : i3, (i15 & 8) != 0 ? 0 : i4, (i15 & 16) != 0 ? 0 : i5, (i15 & 32) != 0 ? 0 : i6, (i15 & 64) != 0 ? 0 : i7, (i15 & 128) != 0 ? 0 : i8, (i15 & 256) != 0 ? 0 : i9, (i15 & 512) != 0 ? 0 : i10, (i15 & 1024) != 0 ? 0 : i11, (i15 & 2048) != 0 ? 0 : i12, (i15 & 4096) != 0 ? 0 : i13, (i15 & 8192) == 0 ? i14 : 0);
    }

    public BleWorkout(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
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
    }
}
