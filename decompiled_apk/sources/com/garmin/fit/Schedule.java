package com.garmin.fit;

/* loaded from: classes9.dex */
public enum Schedule {
    WORKOUT(0),
    COURSE(1),
    INVALID(255);

    protected short value;

    Schedule(short s) {
        this.value = s;
    }

    public static Schedule getByValue(Short sh) {
        for (Schedule schedule : values()) {
            if (sh.shortValue() == schedule.value) {
                return schedule;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(Schedule schedule) {
        return schedule.name();
    }

    public short getValue() {
        return this.value;
    }
}
