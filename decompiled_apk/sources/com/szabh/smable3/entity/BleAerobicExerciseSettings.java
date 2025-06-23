package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleAerobicExerciseSettings extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 9;
    private int mExerciseHour;
    private int mExerciseMinute;
    private int mHighHrMaxMinute;
    private int mHighHrMaxVibration;
    private int mHrMax;
    private int mHrMin;
    private int mLowHrMinMinute;
    private int mLowHrMinVibration;
    private int mLowOrHighHrDuration;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleAerobicExerciseSettings() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 511, null);
    }

    public final int component1() {
        return this.mExerciseHour;
    }

    public final int component2() {
        return this.mExerciseMinute;
    }

    public final int component3() {
        return this.mHrMin;
    }

    public final int component4() {
        return this.mHrMax;
    }

    public final int component5() {
        return this.mLowHrMinMinute;
    }

    public final int component6() {
        return this.mLowHrMinVibration;
    }

    public final int component7() {
        return this.mHighHrMaxMinute;
    }

    public final int component8() {
        return this.mHighHrMaxVibration;
    }

    public final int component9() {
        return this.mLowOrHighHrDuration;
    }

    @OOXIXo
    public final BleAerobicExerciseSettings copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        return new BleAerobicExerciseSettings(i, i2, i3, i4, i5, i6, i7, i8, i9);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mExerciseHour = readUInt8();
        this.mExerciseMinute = readUInt8();
        this.mHrMin = readUInt8();
        this.mHrMax = readUInt8();
        this.mLowHrMinMinute = readUInt8();
        this.mLowHrMinVibration = readUInt8();
        this.mHighHrMaxMinute = readUInt8();
        this.mHighHrMaxVibration = readUInt8();
        this.mLowOrHighHrDuration = readUInt8();
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mExerciseHour);
        writeInt8(this.mExerciseMinute);
        writeInt8(this.mHrMin);
        writeInt8(this.mHrMax);
        writeInt8(this.mLowHrMinMinute);
        writeInt8(this.mLowHrMinVibration);
        writeInt8(this.mHighHrMaxMinute);
        writeInt8(this.mHighHrMaxVibration);
        writeInt8(this.mLowOrHighHrDuration);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleAerobicExerciseSettings)) {
            return false;
        }
        BleAerobicExerciseSettings bleAerobicExerciseSettings = (BleAerobicExerciseSettings) obj;
        return this.mExerciseHour == bleAerobicExerciseSettings.mExerciseHour && this.mExerciseMinute == bleAerobicExerciseSettings.mExerciseMinute && this.mHrMin == bleAerobicExerciseSettings.mHrMin && this.mHrMax == bleAerobicExerciseSettings.mHrMax && this.mLowHrMinMinute == bleAerobicExerciseSettings.mLowHrMinMinute && this.mLowHrMinVibration == bleAerobicExerciseSettings.mLowHrMinVibration && this.mHighHrMaxMinute == bleAerobicExerciseSettings.mHighHrMaxMinute && this.mHighHrMaxVibration == bleAerobicExerciseSettings.mHighHrMaxVibration && this.mLowOrHighHrDuration == bleAerobicExerciseSettings.mLowOrHighHrDuration;
    }

    public final int getMExerciseHour() {
        return this.mExerciseHour;
    }

    public final int getMExerciseMinute() {
        return this.mExerciseMinute;
    }

    public final int getMHighHrMaxMinute() {
        return this.mHighHrMaxMinute;
    }

    public final int getMHighHrMaxVibration() {
        return this.mHighHrMaxVibration;
    }

    public final int getMHrMax() {
        return this.mHrMax;
    }

    public final int getMHrMin() {
        return this.mHrMin;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 9;
    }

    public final int getMLowHrMinMinute() {
        return this.mLowHrMinMinute;
    }

    public final int getMLowHrMinVibration() {
        return this.mLowHrMinVibration;
    }

    public final int getMLowOrHighHrDuration() {
        return this.mLowOrHighHrDuration;
    }

    public int hashCode() {
        return (((((((((((((((this.mExerciseHour * 31) + this.mExerciseMinute) * 31) + this.mHrMin) * 31) + this.mHrMax) * 31) + this.mLowHrMinMinute) * 31) + this.mLowHrMinVibration) * 31) + this.mHighHrMaxMinute) * 31) + this.mHighHrMaxVibration) * 31) + this.mLowOrHighHrDuration;
    }

    public final void setMExerciseHour(int i) {
        this.mExerciseHour = i;
    }

    public final void setMExerciseMinute(int i) {
        this.mExerciseMinute = i;
    }

    public final void setMHighHrMaxMinute(int i) {
        this.mHighHrMaxMinute = i;
    }

    public final void setMHighHrMaxVibration(int i) {
        this.mHighHrMaxVibration = i;
    }

    public final void setMHrMax(int i) {
        this.mHrMax = i;
    }

    public final void setMHrMin(int i) {
        this.mHrMin = i;
    }

    public final void setMLowHrMinMinute(int i) {
        this.mLowHrMinMinute = i;
    }

    public final void setMLowHrMinVibration(int i) {
        this.mLowHrMinVibration = i;
    }

    public final void setMLowOrHighHrDuration(int i) {
        this.mLowOrHighHrDuration = i;
    }

    @OOXIXo
    public String toString() {
        return "BleAerobicExerciseSettings(mExerciseHour=" + this.mExerciseHour + ", mExerciseMinute=" + this.mExerciseMinute + ", mHrMin=" + this.mHrMin + ", mHrMax=" + this.mHrMax + ", mLowHrMinMinute=" + this.mLowHrMinMinute + ", mLowHrMinVibration=" + this.mLowHrMinVibration + ", mHighHrMaxMinute=" + this.mHighHrMaxMinute + ", mHighHrMaxVibration=" + this.mHighHrMaxVibration + ", mLowOrHighHrDuration=" + this.mLowOrHighHrDuration + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleAerobicExerciseSettings(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, IIXOooo iIXOooo) {
        this((i10 & 1) != 0 ? 0 : i, (i10 & 2) != 0 ? 0 : i2, (i10 & 4) != 0 ? 0 : i3, (i10 & 8) != 0 ? 0 : i4, (i10 & 16) != 0 ? 0 : i5, (i10 & 32) != 0 ? 0 : i6, (i10 & 64) != 0 ? 0 : i7, (i10 & 128) != 0 ? 0 : i8, (i10 & 256) == 0 ? i9 : 0);
    }

    public BleAerobicExerciseSettings(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.mExerciseHour = i;
        this.mExerciseMinute = i2;
        this.mHrMin = i3;
        this.mHrMax = i4;
        this.mLowHrMinMinute = i5;
        this.mLowHrMinVibration = i6;
        this.mHighHrMaxMinute = i7;
        this.mHighHrMaxVibration = i8;
        this.mLowOrHighHrDuration = i9;
    }
}
