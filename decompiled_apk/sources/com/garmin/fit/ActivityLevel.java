package com.garmin.fit;

/* loaded from: classes9.dex */
public enum ActivityLevel {
    LOW(0),
    MEDIUM(1),
    HIGH(2),
    INVALID(255);

    protected short value;

    ActivityLevel(short s) {
        this.value = s;
    }

    public static ActivityLevel getByValue(Short sh) {
        for (ActivityLevel activityLevel : values()) {
            if (sh.shortValue() == activityLevel.value) {
                return activityLevel;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(ActivityLevel activityLevel) {
        return activityLevel.name();
    }

    public short getValue() {
        return this.value;
    }
}
