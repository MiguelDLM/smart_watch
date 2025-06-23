package com.baidu.platform.core.i;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.weather.WeatherDataType;

/* loaded from: classes8.dex */
/* synthetic */ class d {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f10005a;
    static final /* synthetic */ int[] b;
    static final /* synthetic */ int[] c;

    static {
        int[] iArr = new int[LanguageType.values().length];
        c = iArr;
        try {
            iArr[LanguageType.LanguageTypeEnglish.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            c[LanguageType.LanguageTypeChinese.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[CoordType.values().length];
        b = iArr2;
        try {
            iArr2[CoordType.BD09LL.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            b[CoordType.GCJ02.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr3 = new int[WeatherDataType.values().length];
        f10005a = iArr3;
        try {
            iArr3[WeatherDataType.WEATHER_DATA_TYPE_REAL_TIME.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f10005a[WeatherDataType.WEATHER_DATA_TYPE_FORECASTS_FOR_DAY.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f10005a[WeatherDataType.WEATHER_DATA_TYPE_FORECASTS_FOR_HOUR.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f10005a[WeatherDataType.WEATHER_DATA_TYPE_LIFE_INDEX.ordinal()] = 4;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f10005a[WeatherDataType.WEATHER_DATA_TYPE_ALERT.ordinal()] = 5;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f10005a[WeatherDataType.WEATHER_DATA_TYPE_ALL.ordinal()] = 6;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
