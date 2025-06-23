package com.garmin.fit;

/* loaded from: classes9.dex */
public enum DateMode {
    DAY_MONTH(0),
    MONTH_DAY(1),
    INVALID(255);

    protected short value;

    DateMode(short s) {
        this.value = s;
    }

    public static DateMode getByValue(Short sh) {
        for (DateMode dateMode : values()) {
            if (sh.shortValue() == dateMode.value) {
                return dateMode;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(DateMode dateMode) {
        return dateMode.name();
    }

    public short getValue() {
        return this.value;
    }
}
