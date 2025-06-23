package com.garmin.fit;

/* loaded from: classes9.dex */
public enum TimeMode {
    HOUR12(0),
    HOUR24(1),
    MILITARY(2),
    HOUR_12_WITH_SECONDS(3),
    HOUR_24_WITH_SECONDS(4),
    UTC(5),
    INVALID(255);

    protected short value;

    TimeMode(short s) {
        this.value = s;
    }

    public static TimeMode getByValue(Short sh) {
        for (TimeMode timeMode : values()) {
            if (sh.shortValue() == timeMode.value) {
                return timeMode;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(TimeMode timeMode) {
        return timeMode.name();
    }

    public short getValue() {
        return this.value;
    }
}
