package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleAppSportData extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 32;
    private int mAirPressure;
    private int mAltitude;
    private int mCalorie;
    private int mDistance;
    private int mDuration;
    private int mMode;
    private int mPace;
    private float mSpeed;
    private int mSpm;
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

    public BleAppSportData() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0.0f, 0, 0, 2047, null);
    }

    public final int component1() {
        return this.mStep;
    }

    public final int component10() {
        return this.mMode;
    }

    public final int component11() {
        return this.mUndefined;
    }

    public final int component2() {
        return this.mDistance;
    }

    public final int component3() {
        return this.mCalorie;
    }

    public final int component4() {
        return this.mDuration;
    }

    public final int component5() {
        return this.mSpm;
    }

    public final int component6() {
        return this.mAltitude;
    }

    public final int component7() {
        return this.mAirPressure;
    }

    public final int component8() {
        return this.mPace;
    }

    public final float component9() {
        return this.mSpeed;
    }

    @OOXIXo
    public final BleAppSportData copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, int i9, int i10) {
        return new BleAppSportData(i, i2, i3, i4, i5, i6, i7, i8, f, i9, i10);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        int i = this.mStep;
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt32(i, LITTLE_ENDIAN);
        int i2 = this.mDistance;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt32(i2, LITTLE_ENDIAN);
        int i3 = this.mCalorie;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt32(i3, LITTLE_ENDIAN);
        int i4 = this.mDuration;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt16(i4, LITTLE_ENDIAN);
        int i5 = this.mSpm;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt16(i5, LITTLE_ENDIAN);
        int i6 = this.mAltitude;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt16(i6, LITTLE_ENDIAN);
        int i7 = this.mAirPressure;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt16(i7, LITTLE_ENDIAN);
        int i8 = this.mPace;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt32(i8, LITTLE_ENDIAN);
        float f = this.mSpeed;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeFloat(f, LITTLE_ENDIAN);
        writeInt8(this.mMode);
        int i9 = this.mUndefined;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt24(i9, LITTLE_ENDIAN);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleAppSportData)) {
            return false;
        }
        BleAppSportData bleAppSportData = (BleAppSportData) obj;
        return this.mStep == bleAppSportData.mStep && this.mDistance == bleAppSportData.mDistance && this.mCalorie == bleAppSportData.mCalorie && this.mDuration == bleAppSportData.mDuration && this.mSpm == bleAppSportData.mSpm && this.mAltitude == bleAppSportData.mAltitude && this.mAirPressure == bleAppSportData.mAirPressure && this.mPace == bleAppSportData.mPace && Float.compare(this.mSpeed, bleAppSportData.mSpeed) == 0 && this.mMode == bleAppSportData.mMode && this.mUndefined == bleAppSportData.mUndefined;
    }

    public final int getMAirPressure() {
        return this.mAirPressure;
    }

    public final int getMAltitude() {
        return this.mAltitude;
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

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 32;
    }

    public final int getMMode() {
        return this.mMode;
    }

    public final int getMPace() {
        return this.mPace;
    }

    public final float getMSpeed() {
        return this.mSpeed;
    }

    public final int getMSpm() {
        return this.mSpm;
    }

    public final int getMStep() {
        return this.mStep;
    }

    public final int getMUndefined() {
        return this.mUndefined;
    }

    public int hashCode() {
        return (((((((((((((((((((this.mStep * 31) + this.mDistance) * 31) + this.mCalorie) * 31) + this.mDuration) * 31) + this.mSpm) * 31) + this.mAltitude) * 31) + this.mAirPressure) * 31) + this.mPace) * 31) + Float.floatToIntBits(this.mSpeed)) * 31) + this.mMode) * 31) + this.mUndefined;
    }

    public final void setMAirPressure(int i) {
        this.mAirPressure = i;
    }

    public final void setMAltitude(int i) {
        this.mAltitude = i;
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

    public final void setMMode(int i) {
        this.mMode = i;
    }

    public final void setMPace(int i) {
        this.mPace = i;
    }

    public final void setMSpeed(float f) {
        this.mSpeed = f;
    }

    public final void setMSpm(int i) {
        this.mSpm = i;
    }

    public final void setMStep(int i) {
        this.mStep = i;
    }

    public final void setMUndefined(int i) {
        this.mUndefined = i;
    }

    @OOXIXo
    public String toString() {
        return "BleAppSportData(mStep=" + this.mStep + ", mDistance=" + this.mDistance + ", mCalorie=" + this.mCalorie + ", mDuration=" + this.mDuration + ", mSpm=" + this.mSpm + ", mAltitude=" + this.mAltitude + ", mAirPressure=" + this.mAirPressure + ", mPace=" + this.mPace + ", mSpeed=" + this.mSpeed + ", mMode=" + this.mMode + ", mUndefined=" + this.mUndefined + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleAppSportData(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, int i9, int i10, int i11, IIXOooo iIXOooo) {
        this((i11 & 1) != 0 ? 0 : i, (i11 & 2) != 0 ? 0 : i2, (i11 & 4) != 0 ? 0 : i3, (i11 & 8) != 0 ? 0 : i4, (i11 & 16) != 0 ? 0 : i5, (i11 & 32) != 0 ? 0 : i6, (i11 & 64) != 0 ? 0 : i7, (i11 & 128) != 0 ? 0 : i8, (i11 & 256) != 0 ? 0.0f : f, (i11 & 512) != 0 ? 0 : i9, (i11 & 1024) == 0 ? i10 : 0);
    }

    public BleAppSportData(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, int i9, int i10) {
        this.mStep = i;
        this.mDistance = i2;
        this.mCalorie = i3;
        this.mDuration = i4;
        this.mSpm = i5;
        this.mAltitude = i6;
        this.mAirPressure = i7;
        this.mPace = i8;
        this.mSpeed = f;
        this.mMode = i9;
        this.mUndefined = i10;
    }
}
