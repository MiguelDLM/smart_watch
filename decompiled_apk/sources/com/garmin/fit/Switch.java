package com.garmin.fit;

/* loaded from: classes9.dex */
public enum Switch {
    OFF(0),
    ON(1),
    AUTO(2),
    INVALID(255);

    protected short value;

    Switch(short s) {
        this.value = s;
    }

    public static Switch getByValue(Short sh) {
        for (Switch r3 : values()) {
            if (sh.shortValue() == r3.value) {
                return r3;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(Switch r0) {
        return r0.name();
    }

    public short getValue() {
        return this.value;
    }
}
