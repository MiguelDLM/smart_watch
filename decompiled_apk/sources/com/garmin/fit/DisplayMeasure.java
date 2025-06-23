package com.garmin.fit;

/* loaded from: classes9.dex */
public enum DisplayMeasure {
    METRIC(0),
    STATUTE(1),
    NAUTICAL(2),
    INVALID(255);

    protected short value;

    DisplayMeasure(short s) {
        this.value = s;
    }

    public static DisplayMeasure getByValue(Short sh) {
        for (DisplayMeasure displayMeasure : values()) {
            if (sh.shortValue() == displayMeasure.value) {
                return displayMeasure;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(DisplayMeasure displayMeasure) {
        return displayMeasure.name();
    }

    public short getValue() {
        return this.value;
    }
}
