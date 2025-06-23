package com.garmin.fit;

/* loaded from: classes9.dex */
public enum Side {
    RIGHT(0),
    LEFT(1),
    INVALID(255);

    protected short value;

    Side(short s) {
        this.value = s;
    }

    public static Side getByValue(Short sh) {
        for (Side side : values()) {
            if (sh.shortValue() == side.value) {
                return side;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(Side side) {
        return side.name();
    }

    public short getValue() {
        return this.value;
    }
}
