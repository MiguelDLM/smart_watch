package com.garmin.fit;

/* loaded from: classes9.dex */
public enum GoalRecurrence {
    OFF(0),
    DAILY(1),
    WEEKLY(2),
    MONTHLY(3),
    YEARLY(4),
    CUSTOM(5),
    INVALID(255);

    protected short value;

    GoalRecurrence(short s) {
        this.value = s;
    }

    public static GoalRecurrence getByValue(Short sh) {
        for (GoalRecurrence goalRecurrence : values()) {
            if (sh.shortValue() == goalRecurrence.value) {
                return goalRecurrence;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(GoalRecurrence goalRecurrence) {
        return goalRecurrence.name();
    }

    public short getValue() {
        return this.value;
    }
}
