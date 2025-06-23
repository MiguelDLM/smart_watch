package com.garmin.fit;

/* loaded from: classes9.dex */
public enum SleepLevel {
    UNMEASURABLE(0),
    AWAKE(1),
    LIGHT(2),
    DEEP(3),
    REM(4),
    INVALID(255);

    protected short value;

    SleepLevel(short s) {
        this.value = s;
    }

    public static SleepLevel getByValue(Short sh) {
        for (SleepLevel sleepLevel : values()) {
            if (sh.shortValue() == sleepLevel.value) {
                return sleepLevel;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(SleepLevel sleepLevel) {
        return sleepLevel.name();
    }

    public short getValue() {
        return this.value;
    }
}
