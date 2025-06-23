package com.baidu.mapapi.search.weather;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;

/* loaded from: classes7.dex */
public class WeatherSearchOption {
    private String b;
    private LatLng c;

    /* renamed from: a, reason: collision with root package name */
    private WeatherServerType f6009a = WeatherServerType.WEATHER_SERVER_TYPE_DEFAULT;
    private WeatherDataType d = WeatherDataType.WEATHER_DATA_TYPE_REAL_TIME;
    private LanguageType e = LanguageType.LanguageTypeChinese;

    public WeatherSearchOption districtID(String str) {
        this.b = str;
        return this;
    }

    public WeatherDataType getDataType() {
        return this.d;
    }

    public String getDistrictID() {
        return this.b;
    }

    public LanguageType getLanguageType() {
        return this.e;
    }

    public LatLng getLocation() {
        return this.c;
    }

    public WeatherServerType getServerType() {
        return this.f6009a;
    }

    public WeatherSearchOption languageType(LanguageType languageType) {
        this.e = languageType;
        return this;
    }

    public WeatherSearchOption location(LatLng latLng) {
        this.c = latLng;
        return this;
    }

    public WeatherSearchOption serverType(WeatherServerType weatherServerType) {
        this.f6009a = weatherServerType;
        return this;
    }

    public WeatherSearchOption weatherDataType(WeatherDataType weatherDataType) {
        this.d = weatherDataType;
        return this;
    }
}
