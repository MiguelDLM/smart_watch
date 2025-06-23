package com.garmin.fit;

/* loaded from: classes9.dex */
public enum Goal {
    TIME(0),
    DISTANCE(1),
    CALORIES(2),
    FREQUENCY(3),
    STEPS(4),
    ASCENT(5),
    ACTIVE_MINUTES(6),
    INVALID(255);

    protected short value;

    Goal(short s) {
        this.value = s;
    }

    public static Goal getByValue(Short sh) {
        for (Goal goal : values()) {
            if (sh.shortValue() == goal.value) {
                return goal;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(Goal goal) {
        return goal.name();
    }

    public short getValue() {
        return this.value;
    }
}
