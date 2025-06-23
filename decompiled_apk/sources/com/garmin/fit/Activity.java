package com.garmin.fit;

/* loaded from: classes9.dex */
public enum Activity {
    MANUAL(0),
    AUTO_MULTI_SPORT(1),
    INVALID(255);

    protected short value;

    Activity(short s) {
        this.value = s;
    }

    public static Activity getByValue(Short sh) {
        for (Activity activity : values()) {
            if (sh.shortValue() == activity.value) {
                return activity;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(Activity activity) {
        return activity.name();
    }

    public short getValue() {
        return this.value;
    }
}
