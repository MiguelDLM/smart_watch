package com.garmin.fit;

/* loaded from: classes9.dex */
public enum WeatherReport {
    CURRENT(0),
    FORECAST(1),
    HOURLY_FORECAST(1),
    DAILY_FORECAST(2),
    INVALID(255);

    protected short value;

    WeatherReport(short s) {
        this.value = s;
    }

    public static WeatherReport getByValue(Short sh) {
        for (WeatherReport weatherReport : values()) {
            if (sh.shortValue() == weatherReport.value) {
                return weatherReport;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(WeatherReport weatherReport) {
        return weatherReport.name();
    }

    public short getValue() {
        return this.value;
    }
}
