package com.garmin.fit;

/* loaded from: classes9.dex */
public enum WeatherSeverity {
    UNKNOWN(0),
    WARNING(1),
    WATCH(2),
    ADVISORY(3),
    STATEMENT(4),
    INVALID(255);

    protected short value;

    WeatherSeverity(short s) {
        this.value = s;
    }

    public static WeatherSeverity getByValue(Short sh) {
        for (WeatherSeverity weatherSeverity : values()) {
            if (sh.shortValue() == weatherSeverity.value) {
                return weatherSeverity;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(WeatherSeverity weatherSeverity) {
        return weatherSeverity.name();
    }

    public short getValue() {
        return this.value;
    }
}
