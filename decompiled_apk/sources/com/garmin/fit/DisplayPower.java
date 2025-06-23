package com.garmin.fit;

/* loaded from: classes9.dex */
public enum DisplayPower {
    WATTS(0),
    PERCENT_FTP(1),
    INVALID(255);

    protected short value;

    DisplayPower(short s) {
        this.value = s;
    }

    public static DisplayPower getByValue(Short sh) {
        for (DisplayPower displayPower : values()) {
            if (sh.shortValue() == displayPower.value) {
                return displayPower;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(DisplayPower displayPower) {
        return displayPower.name();
    }

    public short getValue() {
        return this.value;
    }
}
