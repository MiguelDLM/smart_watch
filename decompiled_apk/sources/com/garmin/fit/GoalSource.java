package com.garmin.fit;

/* loaded from: classes9.dex */
public enum GoalSource {
    AUTO(0),
    COMMUNITY(1),
    USER(2),
    INVALID(255);

    protected short value;

    GoalSource(short s) {
        this.value = s;
    }

    public static GoalSource getByValue(Short sh) {
        for (GoalSource goalSource : values()) {
            if (sh.shortValue() == goalSource.value) {
                return goalSource;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(GoalSource goalSource) {
        return goalSource.name();
    }

    public short getValue() {
        return this.value;
    }
}
