package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class WeatherForecast extends JsonFieldContainer implements Serializable {
    private int clouds_all;
    private int cnt;
    private long dt;

    @OOXIXo
    private String dt_read;
    private float feels_like_day;
    private float feels_like_eve;
    private float feels_like_morn;
    private float feels_like_night;
    private int humidity;
    private float lat;
    private float lon;
    private int population;
    private int pressure;
    private float rain;
    private float rain_pop;
    private float snow;
    private int sys_cod;

    @OOXIXo
    private String sys_country;
    private float sys_message;
    private long sys_sunrise;

    @OOXIXo
    private String sys_sunrise_read;
    private long sys_sunset;

    @OOXIXo
    private String sys_sunset_read;
    private float temp_day;
    private float temp_eve;
    private float temp_max;
    private float temp_min;
    private float temp_morn;
    private float temp_night;
    private int timezone;
    private long updateTime;
    private int uvi;

    @OOXIXo
    private String weather_description;

    @OOXIXo
    private String weather_icon;
    private int weather_id;

    @OOXIXo
    private String weather_main;
    private int wind_deg;
    private float wind_gust;
    private float wind_speed;

    public WeatherForecast(float f, float f2, @OOXIXo String sys_country, int i, int i2, int i3, float f3, int i4, long j, @OOXIXo String dt_read, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, int i5, int i6, int i7, @OOXIXo String weather_main, @OOXIXo String weather_description, @OOXIXo String weather_icon, float f14, int i8, float f15, int i9, int i10, float f16, float f17, float f18, long j2, @OOXIXo String sys_sunrise_read, long j3, @OOXIXo String sys_sunset_read, long j4) {
        IIX0o.x0xO0oo(sys_country, "sys_country");
        IIX0o.x0xO0oo(dt_read, "dt_read");
        IIX0o.x0xO0oo(weather_main, "weather_main");
        IIX0o.x0xO0oo(weather_description, "weather_description");
        IIX0o.x0xO0oo(weather_icon, "weather_icon");
        IIX0o.x0xO0oo(sys_sunrise_read, "sys_sunrise_read");
        IIX0o.x0xO0oo(sys_sunset_read, "sys_sunset_read");
        this.lat = f;
        this.lon = f2;
        this.sys_country = sys_country;
        this.population = i;
        this.timezone = i2;
        this.sys_cod = i3;
        this.sys_message = f3;
        this.cnt = i4;
        this.dt = j;
        this.dt_read = dt_read;
        this.temp_day = f4;
        this.temp_min = f5;
        this.temp_max = f6;
        this.temp_night = f7;
        this.temp_eve = f8;
        this.temp_morn = f9;
        this.feels_like_day = f10;
        this.feels_like_night = f11;
        this.feels_like_eve = f12;
        this.feels_like_morn = f13;
        this.pressure = i5;
        this.humidity = i6;
        this.weather_id = i7;
        this.weather_main = weather_main;
        this.weather_description = weather_description;
        this.weather_icon = weather_icon;
        this.wind_speed = f14;
        this.wind_deg = i8;
        this.wind_gust = f15;
        this.clouds_all = i9;
        this.uvi = i10;
        this.rain = f16;
        this.snow = f17;
        this.rain_pop = f18;
        this.sys_sunrise = j2;
        this.sys_sunrise_read = sys_sunrise_read;
        this.sys_sunset = j3;
        this.sys_sunset_read = sys_sunset_read;
        this.updateTime = j4;
    }

    public final float component1() {
        return this.lat;
    }

    @OOXIXo
    public final String component10() {
        return this.dt_read;
    }

    public final float component11() {
        return this.temp_day;
    }

    public final float component12() {
        return this.temp_min;
    }

    public final float component13() {
        return this.temp_max;
    }

    public final float component14() {
        return this.temp_night;
    }

    public final float component15() {
        return this.temp_eve;
    }

    public final float component16() {
        return this.temp_morn;
    }

    public final float component17() {
        return this.feels_like_day;
    }

    public final float component18() {
        return this.feels_like_night;
    }

    public final float component19() {
        return this.feels_like_eve;
    }

    public final float component2() {
        return this.lon;
    }

    public final float component20() {
        return this.feels_like_morn;
    }

    public final int component21() {
        return this.pressure;
    }

    public final int component22() {
        return this.humidity;
    }

    public final int component23() {
        return this.weather_id;
    }

    @OOXIXo
    public final String component24() {
        return this.weather_main;
    }

    @OOXIXo
    public final String component25() {
        return this.weather_description;
    }

    @OOXIXo
    public final String component26() {
        return this.weather_icon;
    }

    public final float component27() {
        return this.wind_speed;
    }

    public final int component28() {
        return this.wind_deg;
    }

    public final float component29() {
        return this.wind_gust;
    }

    @OOXIXo
    public final String component3() {
        return this.sys_country;
    }

    public final int component30() {
        return this.clouds_all;
    }

    public final int component31() {
        return this.uvi;
    }

    public final float component32() {
        return this.rain;
    }

    public final float component33() {
        return this.snow;
    }

    public final float component34() {
        return this.rain_pop;
    }

    public final long component35() {
        return this.sys_sunrise;
    }

    @OOXIXo
    public final String component36() {
        return this.sys_sunrise_read;
    }

    public final long component37() {
        return this.sys_sunset;
    }

    @OOXIXo
    public final String component38() {
        return this.sys_sunset_read;
    }

    public final long component39() {
        return this.updateTime;
    }

    public final int component4() {
        return this.population;
    }

    public final int component5() {
        return this.timezone;
    }

    public final int component6() {
        return this.sys_cod;
    }

    public final float component7() {
        return this.sys_message;
    }

    public final int component8() {
        return this.cnt;
    }

    public final long component9() {
        return this.dt;
    }

    @OOXIXo
    public final WeatherForecast copy(float f, float f2, @OOXIXo String sys_country, int i, int i2, int i3, float f3, int i4, long j, @OOXIXo String dt_read, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, int i5, int i6, int i7, @OOXIXo String weather_main, @OOXIXo String weather_description, @OOXIXo String weather_icon, float f14, int i8, float f15, int i9, int i10, float f16, float f17, float f18, long j2, @OOXIXo String sys_sunrise_read, long j3, @OOXIXo String sys_sunset_read, long j4) {
        IIX0o.x0xO0oo(sys_country, "sys_country");
        IIX0o.x0xO0oo(dt_read, "dt_read");
        IIX0o.x0xO0oo(weather_main, "weather_main");
        IIX0o.x0xO0oo(weather_description, "weather_description");
        IIX0o.x0xO0oo(weather_icon, "weather_icon");
        IIX0o.x0xO0oo(sys_sunrise_read, "sys_sunrise_read");
        IIX0o.x0xO0oo(sys_sunset_read, "sys_sunset_read");
        return new WeatherForecast(f, f2, sys_country, i, i2, i3, f3, i4, j, dt_read, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, i5, i6, i7, weather_main, weather_description, weather_icon, f14, i8, f15, i9, i10, f16, f17, f18, j2, sys_sunrise_read, j3, sys_sunset_read, j4);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WeatherForecast)) {
            return false;
        }
        WeatherForecast weatherForecast = (WeatherForecast) obj;
        return Float.compare(this.lat, weatherForecast.lat) == 0 && Float.compare(this.lon, weatherForecast.lon) == 0 && IIX0o.Oxx0IOOO(this.sys_country, weatherForecast.sys_country) && this.population == weatherForecast.population && this.timezone == weatherForecast.timezone && this.sys_cod == weatherForecast.sys_cod && Float.compare(this.sys_message, weatherForecast.sys_message) == 0 && this.cnt == weatherForecast.cnt && this.dt == weatherForecast.dt && IIX0o.Oxx0IOOO(this.dt_read, weatherForecast.dt_read) && Float.compare(this.temp_day, weatherForecast.temp_day) == 0 && Float.compare(this.temp_min, weatherForecast.temp_min) == 0 && Float.compare(this.temp_max, weatherForecast.temp_max) == 0 && Float.compare(this.temp_night, weatherForecast.temp_night) == 0 && Float.compare(this.temp_eve, weatherForecast.temp_eve) == 0 && Float.compare(this.temp_morn, weatherForecast.temp_morn) == 0 && Float.compare(this.feels_like_day, weatherForecast.feels_like_day) == 0 && Float.compare(this.feels_like_night, weatherForecast.feels_like_night) == 0 && Float.compare(this.feels_like_eve, weatherForecast.feels_like_eve) == 0 && Float.compare(this.feels_like_morn, weatherForecast.feels_like_morn) == 0 && this.pressure == weatherForecast.pressure && this.humidity == weatherForecast.humidity && this.weather_id == weatherForecast.weather_id && IIX0o.Oxx0IOOO(this.weather_main, weatherForecast.weather_main) && IIX0o.Oxx0IOOO(this.weather_description, weatherForecast.weather_description) && IIX0o.Oxx0IOOO(this.weather_icon, weatherForecast.weather_icon) && Float.compare(this.wind_speed, weatherForecast.wind_speed) == 0 && this.wind_deg == weatherForecast.wind_deg && Float.compare(this.wind_gust, weatherForecast.wind_gust) == 0 && this.clouds_all == weatherForecast.clouds_all && this.uvi == weatherForecast.uvi && Float.compare(this.rain, weatherForecast.rain) == 0 && Float.compare(this.snow, weatherForecast.snow) == 0 && Float.compare(this.rain_pop, weatherForecast.rain_pop) == 0 && this.sys_sunrise == weatherForecast.sys_sunrise && IIX0o.Oxx0IOOO(this.sys_sunrise_read, weatherForecast.sys_sunrise_read) && this.sys_sunset == weatherForecast.sys_sunset && IIX0o.Oxx0IOOO(this.sys_sunset_read, weatherForecast.sys_sunset_read) && this.updateTime == weatherForecast.updateTime;
    }

    public final int getClouds_all() {
        return this.clouds_all;
    }

    public final int getCnt() {
        return this.cnt;
    }

    public final long getDt() {
        return this.dt;
    }

    @OOXIXo
    public final String getDt_read() {
        return this.dt_read;
    }

    public final float getFeels_like_day() {
        return this.feels_like_day;
    }

    public final float getFeels_like_eve() {
        return this.feels_like_eve;
    }

    public final float getFeels_like_morn() {
        return this.feels_like_morn;
    }

    public final float getFeels_like_night() {
        return this.feels_like_night;
    }

    public final int getHumidity() {
        return this.humidity;
    }

    public final float getLat() {
        return this.lat;
    }

    public final float getLon() {
        return this.lon;
    }

    public final int getPopulation() {
        return this.population;
    }

    public final int getPressure() {
        return this.pressure;
    }

    public final float getRain() {
        return this.rain;
    }

    public final float getRain_pop() {
        return this.rain_pop;
    }

    public final float getSnow() {
        return this.snow;
    }

    public final int getSys_cod() {
        return this.sys_cod;
    }

    @OOXIXo
    public final String getSys_country() {
        return this.sys_country;
    }

    public final float getSys_message() {
        return this.sys_message;
    }

    public final long getSys_sunrise() {
        return this.sys_sunrise;
    }

    @OOXIXo
    public final String getSys_sunrise_read() {
        return this.sys_sunrise_read;
    }

    public final long getSys_sunset() {
        return this.sys_sunset;
    }

    @OOXIXo
    public final String getSys_sunset_read() {
        return this.sys_sunset_read;
    }

    public final float getTemp_day() {
        return this.temp_day;
    }

    public final float getTemp_eve() {
        return this.temp_eve;
    }

    public final float getTemp_max() {
        return this.temp_max;
    }

    public final float getTemp_min() {
        return this.temp_min;
    }

    public final float getTemp_morn() {
        return this.temp_morn;
    }

    public final float getTemp_night() {
        return this.temp_night;
    }

    public final int getTimezone() {
        return this.timezone;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public final int getUvi() {
        return this.uvi;
    }

    @OOXIXo
    public final String getWeather_description() {
        return this.weather_description;
    }

    @OOXIXo
    public final String getWeather_icon() {
        return this.weather_icon;
    }

    public final int getWeather_id() {
        return this.weather_id;
    }

    @OOXIXo
    public final String getWeather_main() {
        return this.weather_main;
    }

    public final int getWind_deg() {
        return this.wind_deg;
    }

    public final float getWind_gust() {
        return this.wind_gust;
    }

    public final float getWind_speed() {
        return this.wind_speed;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((Float.floatToIntBits(this.lat) * 31) + Float.floatToIntBits(this.lon)) * 31) + this.sys_country.hashCode()) * 31) + this.population) * 31) + this.timezone) * 31) + this.sys_cod) * 31) + Float.floatToIntBits(this.sys_message)) * 31) + this.cnt) * 31) + androidx.collection.oIX0oI.oIX0oI(this.dt)) * 31) + this.dt_read.hashCode()) * 31) + Float.floatToIntBits(this.temp_day)) * 31) + Float.floatToIntBits(this.temp_min)) * 31) + Float.floatToIntBits(this.temp_max)) * 31) + Float.floatToIntBits(this.temp_night)) * 31) + Float.floatToIntBits(this.temp_eve)) * 31) + Float.floatToIntBits(this.temp_morn)) * 31) + Float.floatToIntBits(this.feels_like_day)) * 31) + Float.floatToIntBits(this.feels_like_night)) * 31) + Float.floatToIntBits(this.feels_like_eve)) * 31) + Float.floatToIntBits(this.feels_like_morn)) * 31) + this.pressure) * 31) + this.humidity) * 31) + this.weather_id) * 31) + this.weather_main.hashCode()) * 31) + this.weather_description.hashCode()) * 31) + this.weather_icon.hashCode()) * 31) + Float.floatToIntBits(this.wind_speed)) * 31) + this.wind_deg) * 31) + Float.floatToIntBits(this.wind_gust)) * 31) + this.clouds_all) * 31) + this.uvi) * 31) + Float.floatToIntBits(this.rain)) * 31) + Float.floatToIntBits(this.snow)) * 31) + Float.floatToIntBits(this.rain_pop)) * 31) + androidx.collection.oIX0oI.oIX0oI(this.sys_sunrise)) * 31) + this.sys_sunrise_read.hashCode()) * 31) + androidx.collection.oIX0oI.oIX0oI(this.sys_sunset)) * 31) + this.sys_sunset_read.hashCode()) * 31) + androidx.collection.oIX0oI.oIX0oI(this.updateTime);
    }

    public final void setClouds_all(int i) {
        this.clouds_all = i;
    }

    public final void setCnt(int i) {
        this.cnt = i;
    }

    public final void setDt(long j) {
        this.dt = j;
    }

    public final void setDt_read(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.dt_read = str;
    }

    public final void setFeels_like_day(float f) {
        this.feels_like_day = f;
    }

    public final void setFeels_like_eve(float f) {
        this.feels_like_eve = f;
    }

    public final void setFeels_like_morn(float f) {
        this.feels_like_morn = f;
    }

    public final void setFeels_like_night(float f) {
        this.feels_like_night = f;
    }

    public final void setHumidity(int i) {
        this.humidity = i;
    }

    public final void setLat(float f) {
        this.lat = f;
    }

    public final void setLon(float f) {
        this.lon = f;
    }

    public final void setPopulation(int i) {
        this.population = i;
    }

    public final void setPressure(int i) {
        this.pressure = i;
    }

    public final void setRain(float f) {
        this.rain = f;
    }

    public final void setRain_pop(float f) {
        this.rain_pop = f;
    }

    public final void setSnow(float f) {
        this.snow = f;
    }

    public final void setSys_cod(int i) {
        this.sys_cod = i;
    }

    public final void setSys_country(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.sys_country = str;
    }

    public final void setSys_message(float f) {
        this.sys_message = f;
    }

    public final void setSys_sunrise(long j) {
        this.sys_sunrise = j;
    }

    public final void setSys_sunrise_read(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.sys_sunrise_read = str;
    }

    public final void setSys_sunset(long j) {
        this.sys_sunset = j;
    }

    public final void setSys_sunset_read(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.sys_sunset_read = str;
    }

    public final void setTemp_day(float f) {
        this.temp_day = f;
    }

    public final void setTemp_eve(float f) {
        this.temp_eve = f;
    }

    public final void setTemp_max(float f) {
        this.temp_max = f;
    }

    public final void setTemp_min(float f) {
        this.temp_min = f;
    }

    public final void setTemp_morn(float f) {
        this.temp_morn = f;
    }

    public final void setTemp_night(float f) {
        this.temp_night = f;
    }

    public final void setTimezone(int i) {
        this.timezone = i;
    }

    public final void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public final void setUvi(int i) {
        this.uvi = i;
    }

    public final void setWeather_description(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.weather_description = str;
    }

    public final void setWeather_icon(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.weather_icon = str;
    }

    public final void setWeather_id(int i) {
        this.weather_id = i;
    }

    public final void setWeather_main(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.weather_main = str;
    }

    public final void setWind_deg(int i) {
        this.wind_deg = i;
    }

    public final void setWind_gust(float f) {
        this.wind_gust = f;
    }

    public final void setWind_speed(float f) {
        this.wind_speed = f;
    }

    @OOXIXo
    public String toString() {
        return "WeatherForecast(lat=" + this.lat + ", lon=" + this.lon + ", sys_country=" + this.sys_country + ", population=" + this.population + ", timezone=" + this.timezone + ", sys_cod=" + this.sys_cod + ", sys_message=" + this.sys_message + ", cnt=" + this.cnt + ", dt=" + this.dt + ", dt_read=" + this.dt_read + ", temp_day=" + this.temp_day + ", temp_min=" + this.temp_min + ", temp_max=" + this.temp_max + ", temp_night=" + this.temp_night + ", temp_eve=" + this.temp_eve + ", temp_morn=" + this.temp_morn + ", feels_like_day=" + this.feels_like_day + ", feels_like_night=" + this.feels_like_night + ", feels_like_eve=" + this.feels_like_eve + ", feels_like_morn=" + this.feels_like_morn + ", pressure=" + this.pressure + ", humidity=" + this.humidity + ", weather_id=" + this.weather_id + ", weather_main=" + this.weather_main + ", weather_description=" + this.weather_description + ", weather_icon=" + this.weather_icon + ", wind_speed=" + this.wind_speed + ", wind_deg=" + this.wind_deg + ", wind_gust=" + this.wind_gust + ", clouds_all=" + this.clouds_all + ", uvi=" + this.uvi + ", rain=" + this.rain + ", snow=" + this.snow + ", rain_pop=" + this.rain_pop + ", sys_sunrise=" + this.sys_sunrise + ", sys_sunrise_read=" + this.sys_sunrise_read + ", sys_sunset=" + this.sys_sunset + ", sys_sunset_read=" + this.sys_sunset_read + ", updateTime=" + this.updateTime + HexStringBuilder.COMMENT_END_CHAR;
    }
}
