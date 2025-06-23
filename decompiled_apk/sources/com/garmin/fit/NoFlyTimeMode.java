package com.garmin.fit;

/* loaded from: classes9.dex */
public enum NoFlyTimeMode {
    STANDARD(0),
    FLAT_24_HOURS(1),
    INVALID(255);

    protected short value;

    NoFlyTimeMode(short s) {
        this.value = s;
    }

    public static NoFlyTimeMode getByValue(Short sh) {
        for (NoFlyTimeMode noFlyTimeMode : values()) {
            if (sh.shortValue() == noFlyTimeMode.value) {
                return noFlyTimeMode;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(NoFlyTimeMode noFlyTimeMode) {
        return noFlyTimeMode.name();
    }

    public short getValue() {
        return this.value;
    }
}
