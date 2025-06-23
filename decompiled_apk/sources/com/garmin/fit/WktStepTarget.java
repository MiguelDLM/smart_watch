package com.garmin.fit;

/* loaded from: classes9.dex */
public enum WktStepTarget {
    SPEED(0),
    HEART_RATE(1),
    OPEN(2),
    CADENCE(3),
    POWER(4),
    GRADE(5),
    RESISTANCE(6),
    POWER_3S(7),
    POWER_10S(8),
    POWER_30S(9),
    POWER_LAP(10),
    SWIM_STROKE(11),
    SPEED_LAP(12),
    HEART_RATE_LAP(13),
    INVALID(255);

    protected short value;

    WktStepTarget(short s) {
        this.value = s;
    }

    public static WktStepTarget getByValue(Short sh) {
        for (WktStepTarget wktStepTarget : values()) {
            if (sh.shortValue() == wktStepTarget.value) {
                return wktStepTarget;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(WktStepTarget wktStepTarget) {
        return wktStepTarget.name();
    }

    public short getValue() {
        return this.value;
    }
}
