package com.garmin.fit;

/* loaded from: classes9.dex */
public enum DisplayOrientation {
    AUTO(0),
    PORTRAIT(1),
    LANDSCAPE(2),
    PORTRAIT_FLIPPED(3),
    LANDSCAPE_FLIPPED(4),
    INVALID(255);

    protected short value;

    DisplayOrientation(short s) {
        this.value = s;
    }

    public static DisplayOrientation getByValue(Short sh) {
        for (DisplayOrientation displayOrientation : values()) {
            if (sh.shortValue() == displayOrientation.value) {
                return displayOrientation;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(DisplayOrientation displayOrientation) {
        return displayOrientation.name();
    }

    public short getValue() {
        return this.value;
    }
}
