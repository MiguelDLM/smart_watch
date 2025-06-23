package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleWeather extends BleWritable implements Serializable {
    public static final int CLOUDY = 2;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int FOGGY = 9;
    public static final int HAZE = 11;
    public static final int HIGH_WINDY = 7;
    public static final int ITEM_LENGTH = 10;
    public static final int OTHER = 0;
    public static final int OVERCAST = 3;
    public static final int RAINY = 4;
    public static final int SAND_STORM = 10;
    public static final int SNOWY = 8;
    public static final int SUNNY = 1;
    public static final int THUNDER = 5;
    public static final int THUNDERSHOWER = 6;
    private int mCurrentTemperature;
    private int mHumidity;
    private int mMaxTemperature;
    private int mMinTemperature;
    private int mPrecipitation;
    private int mUltraVioletIntensity;
    private int mVisibility;
    private int mWeatherCode;
    private int mWindSpeed;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleWeather() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 511, null);
    }

    public final int component1() {
        return this.mCurrentTemperature;
    }

    public final int component2() {
        return this.mMaxTemperature;
    }

    public final int component3() {
        return this.mMinTemperature;
    }

    public final int component4() {
        return this.mWeatherCode;
    }

    public final int component5() {
        return this.mWindSpeed;
    }

    public final int component6() {
        return this.mHumidity;
    }

    public final int component7() {
        return this.mVisibility;
    }

    public final int component8() {
        return this.mUltraVioletIntensity;
    }

    public final int component9() {
        return this.mPrecipitation;
    }

    @OOXIXo
    public final BleWeather copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        return new BleWeather(i, i2, i3, i4, i5, i6, i7, i8, i9);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mCurrentTemperature = readInt8();
        this.mMaxTemperature = readInt8();
        this.mMinTemperature = readInt8();
        this.mWeatherCode = readInt8();
        this.mWindSpeed = readInt8();
        this.mHumidity = readInt8();
        this.mVisibility = readInt8();
        this.mUltraVioletIntensity = readInt8();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mPrecipitation = readInt16(LITTLE_ENDIAN);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mCurrentTemperature);
        writeInt8(this.mMaxTemperature);
        writeInt8(this.mMinTemperature);
        writeInt8(this.mWeatherCode);
        writeInt8(this.mWindSpeed);
        writeInt8(this.mHumidity);
        writeInt8(this.mVisibility);
        writeInt8(this.mUltraVioletIntensity);
        int i = this.mPrecipitation;
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt16(i, LITTLE_ENDIAN);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleWeather)) {
            return false;
        }
        BleWeather bleWeather = (BleWeather) obj;
        return this.mCurrentTemperature == bleWeather.mCurrentTemperature && this.mMaxTemperature == bleWeather.mMaxTemperature && this.mMinTemperature == bleWeather.mMinTemperature && this.mWeatherCode == bleWeather.mWeatherCode && this.mWindSpeed == bleWeather.mWindSpeed && this.mHumidity == bleWeather.mHumidity && this.mVisibility == bleWeather.mVisibility && this.mUltraVioletIntensity == bleWeather.mUltraVioletIntensity && this.mPrecipitation == bleWeather.mPrecipitation;
    }

    public final int getMCurrentTemperature() {
        return this.mCurrentTemperature;
    }

    public final int getMHumidity() {
        return this.mHumidity;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 10;
    }

    public final int getMMaxTemperature() {
        return this.mMaxTemperature;
    }

    public final int getMMinTemperature() {
        return this.mMinTemperature;
    }

    public final int getMPrecipitation() {
        return this.mPrecipitation;
    }

    public final int getMUltraVioletIntensity() {
        return this.mUltraVioletIntensity;
    }

    public final int getMVisibility() {
        return this.mVisibility;
    }

    public final int getMWeatherCode() {
        return this.mWeatherCode;
    }

    public final int getMWindSpeed() {
        return this.mWindSpeed;
    }

    public int hashCode() {
        return (((((((((((((((this.mCurrentTemperature * 31) + this.mMaxTemperature) * 31) + this.mMinTemperature) * 31) + this.mWeatherCode) * 31) + this.mWindSpeed) * 31) + this.mHumidity) * 31) + this.mVisibility) * 31) + this.mUltraVioletIntensity) * 31) + this.mPrecipitation;
    }

    public final void setMCurrentTemperature(int i) {
        this.mCurrentTemperature = i;
    }

    public final void setMHumidity(int i) {
        this.mHumidity = i;
    }

    public final void setMMaxTemperature(int i) {
        this.mMaxTemperature = i;
    }

    public final void setMMinTemperature(int i) {
        this.mMinTemperature = i;
    }

    public final void setMPrecipitation(int i) {
        this.mPrecipitation = i;
    }

    public final void setMUltraVioletIntensity(int i) {
        this.mUltraVioletIntensity = i;
    }

    public final void setMVisibility(int i) {
        this.mVisibility = i;
    }

    public final void setMWeatherCode(int i) {
        this.mWeatherCode = i;
    }

    public final void setMWindSpeed(int i) {
        this.mWindSpeed = i;
    }

    @OOXIXo
    public String toString() {
        return "BleWeather(mCurrentTemperature=" + this.mCurrentTemperature + ", mMaxTemperature=" + this.mMaxTemperature + ", mMinTemperature=" + this.mMinTemperature + ", mWeatherCode=" + this.mWeatherCode + ", mWindSpeed=" + this.mWindSpeed + ", mHumidity=" + this.mHumidity + ", mVisibility=" + this.mVisibility + ", mUltraVioletIntensity=" + this.mUltraVioletIntensity + ", mPrecipitation=" + this.mPrecipitation + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleWeather(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, IIXOooo iIXOooo) {
        this((i10 & 1) != 0 ? 0 : i, (i10 & 2) != 0 ? 0 : i2, (i10 & 4) != 0 ? 0 : i3, (i10 & 8) != 0 ? 0 : i4, (i10 & 16) != 0 ? 0 : i5, (i10 & 32) != 0 ? 0 : i6, (i10 & 64) != 0 ? 0 : i7, (i10 & 128) != 0 ? 0 : i8, (i10 & 256) == 0 ? i9 : 0);
    }

    public BleWeather(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.mCurrentTemperature = i;
        this.mMaxTemperature = i2;
        this.mMinTemperature = i3;
        this.mWeatherCode = i4;
        this.mWindSpeed = i5;
        this.mHumidity = i6;
        this.mVisibility = i7;
        this.mUltraVioletIntensity = i8;
        this.mPrecipitation = i9;
    }
}
