package com.garmin.fit;

/* loaded from: classes9.dex */
public enum AnalogWatchfaceLayout {
    MINIMAL(0),
    TRADITIONAL(1),
    MODERN(2),
    INVALID(255);

    protected short value;

    AnalogWatchfaceLayout(short s) {
        this.value = s;
    }

    public static AnalogWatchfaceLayout getByValue(Short sh) {
        for (AnalogWatchfaceLayout analogWatchfaceLayout : values()) {
            if (sh.shortValue() == analogWatchfaceLayout.value) {
                return analogWatchfaceLayout;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(AnalogWatchfaceLayout analogWatchfaceLayout) {
        return analogWatchfaceLayout.name();
    }

    public short getValue() {
        return this.value;
    }
}
