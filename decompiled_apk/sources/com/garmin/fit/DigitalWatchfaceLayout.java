package com.garmin.fit;

/* loaded from: classes9.dex */
public enum DigitalWatchfaceLayout {
    TRADITIONAL(0),
    MODERN(1),
    BOLD(2),
    INVALID(255);

    protected short value;

    DigitalWatchfaceLayout(short s) {
        this.value = s;
    }

    public static DigitalWatchfaceLayout getByValue(Short sh) {
        for (DigitalWatchfaceLayout digitalWatchfaceLayout : values()) {
            if (sh.shortValue() == digitalWatchfaceLayout.value) {
                return digitalWatchfaceLayout;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(DigitalWatchfaceLayout digitalWatchfaceLayout) {
        return digitalWatchfaceLayout.name();
    }

    public short getValue() {
        return this.value;
    }
}
