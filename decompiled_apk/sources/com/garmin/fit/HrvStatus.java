package com.garmin.fit;

/* loaded from: classes9.dex */
public enum HrvStatus {
    NONE(0),
    POOR(1),
    LOW(2),
    UNBALANCED(3),
    BALANCED(4),
    INVALID(255);

    protected short value;

    HrvStatus(short s) {
        this.value = s;
    }

    public static HrvStatus getByValue(Short sh) {
        for (HrvStatus hrvStatus : values()) {
            if (sh.shortValue() == hrvStatus.value) {
                return hrvStatus;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(HrvStatus hrvStatus) {
        return hrvStatus.name();
    }

    public short getValue() {
        return this.value;
    }
}
