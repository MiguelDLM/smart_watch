package com.garmin.fit;

/* loaded from: classes9.dex */
public enum DiveBacklightMode {
    AT_DEPTH(0),
    ALWAYS_ON(1),
    INVALID(255);

    protected short value;

    DiveBacklightMode(short s) {
        this.value = s;
    }

    public static DiveBacklightMode getByValue(Short sh) {
        for (DiveBacklightMode diveBacklightMode : values()) {
            if (sh.shortValue() == diveBacklightMode.value) {
                return diveBacklightMode;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(DiveBacklightMode diveBacklightMode) {
        return diveBacklightMode.name();
    }

    public short getValue() {
        return this.value;
    }
}
