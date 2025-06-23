package com.garmin.fit;

/* loaded from: classes9.dex */
public enum DisplayHeart {
    BPM(0),
    MAX(1),
    RESERVE(2),
    INVALID(255);

    protected short value;

    DisplayHeart(short s) {
        this.value = s;
    }

    public static DisplayHeart getByValue(Short sh) {
        for (DisplayHeart displayHeart : values()) {
            if (sh.shortValue() == displayHeart.value) {
                return displayHeart;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(DisplayHeart displayHeart) {
        return displayHeart.name();
    }

    public short getValue() {
        return this.value;
    }
}
