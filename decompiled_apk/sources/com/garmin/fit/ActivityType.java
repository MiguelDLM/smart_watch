package com.garmin.fit;

/* loaded from: classes9.dex */
public enum ActivityType {
    GENERIC(0),
    RUNNING(1),
    CYCLING(2),
    TRANSITION(3),
    FITNESS_EQUIPMENT(4),
    SWIMMING(5),
    WALKING(6),
    SEDENTARY(8),
    ALL(254),
    INVALID(255);

    protected short value;

    ActivityType(short s) {
        this.value = s;
    }

    public static ActivityType getByValue(Short sh) {
        for (ActivityType activityType : values()) {
            if (sh.shortValue() == activityType.value) {
                return activityType;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(ActivityType activityType) {
        return activityType.name();
    }

    public short getValue() {
        return this.value;
    }
}
