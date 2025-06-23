package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleDeviceSportData extends BleReadable implements Serializable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 64;
    private int mAltitude;
    private int mBpm;
    private int mCalorie;
    private int mDistance;
    private int mDuration;
    private int mMode;
    private int mPace;
    private int mRiseAltitude;
    private int mSpeed;
    private int mSpm;
    private int mStep;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleDeviceSportData() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2047, null);
    }

    public final int component1() {
        return this.mDuration;
    }

    public final int component10() {
        return this.mRiseAltitude;
    }

    public final int component11() {
        return this.mMode;
    }

    public final int component2() {
        return this.mBpm;
    }

    public final int component3() {
        return this.mSpm;
    }

    public final int component4() {
        return this.mStep;
    }

    public final int component5() {
        return this.mDistance;
    }

    public final int component6() {
        return this.mCalorie;
    }

    public final int component7() {
        return this.mSpeed;
    }

    public final int component8() {
        return this.mPace;
    }

    public final int component9() {
        return this.mAltitude;
    }

    @OOXIXo
    public final BleDeviceSportData copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        return new BleDeviceSportData(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mDuration = readUInt16(LITTLE_ENDIAN);
        this.mBpm = readUInt8();
        this.mSpm = readUInt8();
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mStep = readInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mDistance = readInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mCalorie = readInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mSpeed = readInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mPace = readInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mAltitude = readInt16(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mRiseAltitude = readInt16(LITTLE_ENDIAN);
        this.mMode = readUInt8();
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleDeviceSportData)) {
            return false;
        }
        BleDeviceSportData bleDeviceSportData = (BleDeviceSportData) obj;
        return this.mDuration == bleDeviceSportData.mDuration && this.mBpm == bleDeviceSportData.mBpm && this.mSpm == bleDeviceSportData.mSpm && this.mStep == bleDeviceSportData.mStep && this.mDistance == bleDeviceSportData.mDistance && this.mCalorie == bleDeviceSportData.mCalorie && this.mSpeed == bleDeviceSportData.mSpeed && this.mPace == bleDeviceSportData.mPace && this.mAltitude == bleDeviceSportData.mAltitude && this.mRiseAltitude == bleDeviceSportData.mRiseAltitude && this.mMode == bleDeviceSportData.mMode;
    }

    public final int getMAltitude() {
        return this.mAltitude;
    }

    public final int getMBpm() {
        return this.mBpm;
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

    public final int getMMode() {
        return this.mMode;
    }

    public final int getMPace() {
        return this.mPace;
    }

    public final int getMRiseAltitude() {
        return this.mRiseAltitude;
    }

    public final int getMSpeed() {
        return this.mSpeed;
    }

    public final int getMSpm() {
        return this.mSpm;
    }

    public final int getMStep() {
        return this.mStep;
    }

    public int hashCode() {
        return (((((((((((((((((((this.mDuration * 31) + this.mBpm) * 31) + this.mSpm) * 31) + this.mStep) * 31) + this.mDistance) * 31) + this.mCalorie) * 31) + this.mSpeed) * 31) + this.mPace) * 31) + this.mAltitude) * 31) + this.mRiseAltitude) * 31) + this.mMode;
    }

    public final void setMAltitude(int i) {
        this.mAltitude = i;
    }

    public final void setMBpm(int i) {
        this.mBpm = i;
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

    public final void setMRiseAltitude(int i) {
        this.mRiseAltitude = i;
    }

    public final void setMSpeed(int i) {
        this.mSpeed = i;
    }

    public final void setMSpm(int i) {
        this.mSpm = i;
    }

    public final void setMStep(int i) {
        this.mStep = i;
    }

    @OOXIXo
    public String toString() {
        return "BleDeviceSportData(mDuration=" + this.mDuration + ", mBpm=" + this.mBpm + ", mSpm=" + this.mSpm + ", mStep=" + this.mStep + ", mDistance=" + this.mDistance + ", mCalorie=" + this.mCalorie + ", mSpeed=" + this.mSpeed + ", mPace=" + this.mPace + ", mAltitude=" + this.mAltitude + ", mRiseAltitude=" + this.mRiseAltitude + ", mMode=" + this.mMode + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleDeviceSportData(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, IIXOooo iIXOooo) {
        this((i12 & 1) != 0 ? 0 : i, (i12 & 2) != 0 ? 0 : i2, (i12 & 4) != 0 ? 0 : i3, (i12 & 8) != 0 ? 0 : i4, (i12 & 16) != 0 ? 0 : i5, (i12 & 32) != 0 ? 0 : i6, (i12 & 64) != 0 ? 0 : i7, (i12 & 128) != 0 ? 0 : i8, (i12 & 256) != 0 ? 0 : i9, (i12 & 512) != 0 ? 0 : i10, (i12 & 1024) == 0 ? i11 : 0);
    }

    public BleDeviceSportData(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.mDuration = i;
        this.mBpm = i2;
        this.mSpm = i3;
        this.mStep = i4;
        this.mDistance = i5;
        this.mCalorie = i6;
        this.mSpeed = i7;
        this.mPace = i8;
        this.mAltitude = i9;
        this.mRiseAltitude = i10;
        this.mMode = i11;
    }
}
