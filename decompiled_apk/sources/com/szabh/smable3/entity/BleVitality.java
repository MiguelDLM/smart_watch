package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleVitality extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 20;
    private int mAllVitality;
    private int mHighIntensityTime;
    private int mHighIntensityValue;
    private int mLowIntensityTime;
    private int mLowIntensityValue;
    private int mMediumIntensityTime;
    private int mMediumIntensityValue;
    private int mTime;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleVitality() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 255, null);
    }

    public final int component1() {
        return this.mTime;
    }

    public final int component2() {
        return this.mAllVitality;
    }

    public final int component3() {
        return this.mLowIntensityTime;
    }

    public final int component4() {
        return this.mLowIntensityValue;
    }

    public final int component5() {
        return this.mMediumIntensityTime;
    }

    public final int component6() {
        return this.mMediumIntensityValue;
    }

    public final int component7() {
        return this.mHighIntensityTime;
    }

    public final int component8() {
        return this.mHighIntensityValue;
    }

    @OOXIXo
    public final BleVitality copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return new BleVitality(i, i2, i3, i4, i5, i6, i7, i8);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mTime = readInt32(LITTLE_ENDIAN);
        this.mAllVitality = readInt8();
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mLowIntensityTime = readInt32(LITTLE_ENDIAN);
        this.mLowIntensityValue = readInt8();
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mMediumIntensityTime = readInt32(LITTLE_ENDIAN);
        this.mMediumIntensityValue = readInt8();
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mHighIntensityTime = readInt32(LITTLE_ENDIAN);
        this.mHighIntensityValue = readInt8();
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleVitality)) {
            return false;
        }
        BleVitality bleVitality = (BleVitality) obj;
        return this.mTime == bleVitality.mTime && this.mAllVitality == bleVitality.mAllVitality && this.mLowIntensityTime == bleVitality.mLowIntensityTime && this.mLowIntensityValue == bleVitality.mLowIntensityValue && this.mMediumIntensityTime == bleVitality.mMediumIntensityTime && this.mMediumIntensityValue == bleVitality.mMediumIntensityValue && this.mHighIntensityTime == bleVitality.mHighIntensityTime && this.mHighIntensityValue == bleVitality.mHighIntensityValue;
    }

    public final int getMAllVitality() {
        return this.mAllVitality;
    }

    public final int getMHighIntensityTime() {
        return this.mHighIntensityTime;
    }

    public final int getMHighIntensityValue() {
        return this.mHighIntensityValue;
    }

    public final int getMLowIntensityTime() {
        return this.mLowIntensityTime;
    }

    public final int getMLowIntensityValue() {
        return this.mLowIntensityValue;
    }

    public final int getMMediumIntensityTime() {
        return this.mMediumIntensityTime;
    }

    public final int getMMediumIntensityValue() {
        return this.mMediumIntensityValue;
    }

    public final int getMTime() {
        return this.mTime;
    }

    public int hashCode() {
        return (((((((((((((this.mTime * 31) + this.mAllVitality) * 31) + this.mLowIntensityTime) * 31) + this.mLowIntensityValue) * 31) + this.mMediumIntensityTime) * 31) + this.mMediumIntensityValue) * 31) + this.mHighIntensityTime) * 31) + this.mHighIntensityValue;
    }

    public final void setMAllVitality(int i) {
        this.mAllVitality = i;
    }

    public final void setMHighIntensityTime(int i) {
        this.mHighIntensityTime = i;
    }

    public final void setMHighIntensityValue(int i) {
        this.mHighIntensityValue = i;
    }

    public final void setMLowIntensityTime(int i) {
        this.mLowIntensityTime = i;
    }

    public final void setMLowIntensityValue(int i) {
        this.mLowIntensityValue = i;
    }

    public final void setMMediumIntensityTime(int i) {
        this.mMediumIntensityTime = i;
    }

    public final void setMMediumIntensityValue(int i) {
        this.mMediumIntensityValue = i;
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    @OOXIXo
    public String toString() {
        return "BleVitality(mTime=" + this.mTime + ", mAllVitality=" + this.mAllVitality + ", mLowIntensityTime=" + this.mLowIntensityTime + ", mLowIntensityValue=" + this.mLowIntensityValue + ", mMediumIntensityTime=" + this.mMediumIntensityTime + ", mMediumIntensityValue=" + this.mMediumIntensityValue + ", mHighIntensityTime=" + this.mHighIntensityTime + ", mHighIntensityValue=" + this.mHighIntensityValue + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleVitality(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, IIXOooo iIXOooo) {
        this((i9 & 1) != 0 ? 0 : i, (i9 & 2) != 0 ? 0 : i2, (i9 & 4) != 0 ? 0 : i3, (i9 & 8) != 0 ? 0 : i4, (i9 & 16) != 0 ? 0 : i5, (i9 & 32) != 0 ? 0 : i6, (i9 & 64) != 0 ? 0 : i7, (i9 & 128) == 0 ? i8 : 0);
    }

    public BleVitality(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.mTime = i;
        this.mAllVitality = i2;
        this.mLowIntensityTime = i3;
        this.mLowIntensityValue = i4;
        this.mMediumIntensityTime = i5;
        this.mMediumIntensityValue = i6;
        this.mHighIntensityTime = i7;
        this.mHighIntensityValue = i8;
    }
}
