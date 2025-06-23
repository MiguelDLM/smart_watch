package com.garmin.fit;

/* loaded from: classes9.dex */
public enum ActivityClass {
    LEVEL(XIOOI.f13805oIX0oI),
    LEVEL_MAX(100),
    ATHLETE(128),
    INVALID(255);

    protected short value;

    ActivityClass(short s) {
        this.value = s;
    }

    public static ActivityClass getByValue(Short sh) {
        for (ActivityClass activityClass : values()) {
            if (sh.shortValue() == activityClass.value) {
                return activityClass;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(ActivityClass activityClass) {
        return activityClass.name();
    }

    public short getValue() {
        return this.value;
    }
}
