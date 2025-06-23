package com.garmin.fit;

/* loaded from: classes9.dex */
public enum TapSensitivity {
    HIGH(0),
    MEDIUM(1),
    LOW(2),
    INVALID(255);

    protected short value;

    TapSensitivity(short s) {
        this.value = s;
    }

    public static TapSensitivity getByValue(Short sh) {
        for (TapSensitivity tapSensitivity : values()) {
            if (sh.shortValue() == tapSensitivity.value) {
                return tapSensitivity;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(TapSensitivity tapSensitivity) {
        return tapSensitivity.name();
    }

    public short getValue() {
        return this.value;
    }
}
