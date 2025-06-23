package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleWeather2 extends BleWritable {
    public static final int CLOUDY = 2;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int DRIZZLE = 13;
    public static final int FOGGY = 9;
    public static final int HAZE = 11;
    public static final int HEAVY_RAIN = 14;
    public static final int HEAVY_SNOW = 17;
    public static final int HIGH_WINDY = 7;
    public static final int ITEM_LENGTH = 20;
    public static final int LIGHTNING = 15;
    public static final int LIGHT_SNOW = 16;
    public static final int OTHER = 0;
    public static final int OVERCAST = 3;
    public static final int RAINY = 4;
    public static final int SAND_STORM = 10;
    public static final int SLEET = 18;
    public static final int SNOWSTORM = 20;
    public static final int SNOWY = 8;
    public static final int SUNNY = 1;
    public static final int THUNDER = 5;
    public static final int THUNDERSHOWER = 6;
    public static final int TORNADO = 19;
    public static final int WIND = 12;
    private int mAQI;
    private int mAltitude;
    private int mCurrentTemperature;
    private int mHumidity;
    private int mMaxTemperature;
    private int mMinTemperature;
    private int mPrecipitation;
    private int mSunrisMinute;
    private int mSunrisSecond;
    private int mSunriseHour;
    private int mSunsetHour;
    private int mSunsetMinute;
    private int mSunsetSecond;
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

    public BleWeather2() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 131071, null);
    }

    @kotlin.OOXIXo(message = "海拔已废弃")
    public static /* synthetic */ void getMAltitude$annotations() {
    }

    public final int component1() {
        return this.mCurrentTemperature;
    }

    public final int component10() {
        return this.mSunriseHour;
    }

    public final int component11() {
        return this.mSunrisMinute;
    }

    public final int component12() {
        return this.mSunrisSecond;
    }

    public final int component13() {
        return this.mSunsetHour;
    }

    public final int component14() {
        return this.mSunsetMinute;
    }

    public final int component15() {
        return this.mSunsetSecond;
    }

    public final int component16() {
        return this.mAltitude;
    }

    public final int component17() {
        return this.mAQI;
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
    public final BleWeather2 copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        return new BleWeather2(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mCurrentTemperature);
        writeInt8(this.mMaxTemperature);
        writeInt8(this.mMinTemperature);
        int i = this.mWeatherCode;
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt16(i, LITTLE_ENDIAN);
        writeInt8(this.mWindSpeed);
        writeInt8(this.mHumidity);
        writeInt8(this.mVisibility);
        writeInt8(this.mUltraVioletIntensity);
        int i2 = this.mPrecipitation;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt16(i2, LITTLE_ENDIAN);
        writeInt8(this.mSunriseHour);
        writeInt8(this.mSunrisMinute);
        writeInt8(this.mSunrisSecond);
        writeInt8(this.mSunsetHour);
        writeInt8(this.mSunsetMinute);
        writeInt8(this.mSunsetSecond);
        int i3 = this.mAQI;
        if (i3 != 0) {
            IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
            writeInt16(i3, LITTLE_ENDIAN);
        } else {
            int i4 = this.mAltitude;
            IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
            writeInt16(i4, LITTLE_ENDIAN);
        }
        writeInt8(0);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleWeather2)) {
            return false;
        }
        BleWeather2 bleWeather2 = (BleWeather2) obj;
        return this.mCurrentTemperature == bleWeather2.mCurrentTemperature && this.mMaxTemperature == bleWeather2.mMaxTemperature && this.mMinTemperature == bleWeather2.mMinTemperature && this.mWeatherCode == bleWeather2.mWeatherCode && this.mWindSpeed == bleWeather2.mWindSpeed && this.mHumidity == bleWeather2.mHumidity && this.mVisibility == bleWeather2.mVisibility && this.mUltraVioletIntensity == bleWeather2.mUltraVioletIntensity && this.mPrecipitation == bleWeather2.mPrecipitation && this.mSunriseHour == bleWeather2.mSunriseHour && this.mSunrisMinute == bleWeather2.mSunrisMinute && this.mSunrisSecond == bleWeather2.mSunrisSecond && this.mSunsetHour == bleWeather2.mSunsetHour && this.mSunsetMinute == bleWeather2.mSunsetMinute && this.mSunsetSecond == bleWeather2.mSunsetSecond && this.mAltitude == bleWeather2.mAltitude && this.mAQI == bleWeather2.mAQI;
    }

    public final int getMAQI() {
        return this.mAQI;
    }

    public final int getMAltitude() {
        return this.mAltitude;
    }

    public final int getMCurrentTemperature() {
        return this.mCurrentTemperature;
    }

    public final int getMHumidity() {
        return this.mHumidity;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 20;
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

    public final int getMSunrisMinute() {
        return this.mSunrisMinute;
    }

    public final int getMSunrisSecond() {
        return this.mSunrisSecond;
    }

    public final int getMSunriseHour() {
        return this.mSunriseHour;
    }

    public final int getMSunsetHour() {
        return this.mSunsetHour;
    }

    public final int getMSunsetMinute() {
        return this.mSunsetMinute;
    }

    public final int getMSunsetSecond() {
        return this.mSunsetSecond;
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
        return (((((((((((((((((((((((((((((((this.mCurrentTemperature * 31) + this.mMaxTemperature) * 31) + this.mMinTemperature) * 31) + this.mWeatherCode) * 31) + this.mWindSpeed) * 31) + this.mHumidity) * 31) + this.mVisibility) * 31) + this.mUltraVioletIntensity) * 31) + this.mPrecipitation) * 31) + this.mSunriseHour) * 31) + this.mSunrisMinute) * 31) + this.mSunrisSecond) * 31) + this.mSunsetHour) * 31) + this.mSunsetMinute) * 31) + this.mSunsetSecond) * 31) + this.mAltitude) * 31) + this.mAQI;
    }

    public final void setMAQI(int i) {
        this.mAQI = i;
    }

    public final void setMAltitude(int i) {
        this.mAltitude = i;
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

    public final void setMSunrisMinute(int i) {
        this.mSunrisMinute = i;
    }

    public final void setMSunrisSecond(int i) {
        this.mSunrisSecond = i;
    }

    public final void setMSunriseHour(int i) {
        this.mSunriseHour = i;
    }

    public final void setMSunsetHour(int i) {
        this.mSunsetHour = i;
    }

    public final void setMSunsetMinute(int i) {
        this.mSunsetMinute = i;
    }

    public final void setMSunsetSecond(int i) {
        this.mSunsetSecond = i;
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
        return "BleWeather(mCurrentTemperature=" + this.mCurrentTemperature + ", mMaxTemperature=" + this.mMaxTemperature + ", mMinTemperature=" + this.mMinTemperature + ", mWeatherCode=" + this.mWeatherCode + ", mWindSpeed=" + this.mWindSpeed + ", mHumidity=" + this.mHumidity + ", mVisibility=" + this.mVisibility + ", mUltraVioletIntensity=" + this.mUltraVioletIntensity + ", mPrecipitation=" + this.mPrecipitation + ", mSunriseHour=" + this.mSunriseHour + ", mSunrisMinute=" + this.mSunrisMinute + ", mSunrisSecond=" + this.mSunrisSecond + ", mSunsetHour=" + this.mSunsetHour + ", mSunsetMinute=" + this.mSunsetMinute + ", mSunsetSecond=" + this.mSunsetSecond + ", mAQI=" + this.mAQI + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleWeather2(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, IIXOooo iIXOooo) {
        this((i18 & 1) != 0 ? 0 : i, (i18 & 2) != 0 ? 0 : i2, (i18 & 4) != 0 ? 0 : i3, (i18 & 8) != 0 ? 0 : i4, (i18 & 16) != 0 ? 0 : i5, (i18 & 32) != 0 ? 0 : i6, (i18 & 64) != 0 ? 0 : i7, (i18 & 128) != 0 ? 0 : i8, (i18 & 256) != 0 ? 0 : i9, (i18 & 512) != 0 ? 0 : i10, (i18 & 1024) != 0 ? 0 : i11, (i18 & 2048) != 0 ? 0 : i12, (i18 & 4096) != 0 ? 0 : i13, (i18 & 8192) != 0 ? 0 : i14, (i18 & 16384) != 0 ? 0 : i15, (i18 & 32768) != 0 ? 0 : i16, (i18 & 65536) != 0 ? 0 : i17);
    }

    public BleWeather2(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        this.mCurrentTemperature = i;
        this.mMaxTemperature = i2;
        this.mMinTemperature = i3;
        this.mWeatherCode = i4;
        this.mWindSpeed = i5;
        this.mHumidity = i6;
        this.mVisibility = i7;
        this.mUltraVioletIntensity = i8;
        this.mPrecipitation = i9;
        this.mSunriseHour = i10;
        this.mSunrisMinute = i11;
        this.mSunrisSecond = i12;
        this.mSunsetHour = i13;
        this.mSunsetMinute = i14;
        this.mSunsetSecond = i15;
        this.mAltitude = i16;
        this.mAQI = i17;
    }
}
