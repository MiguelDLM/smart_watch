package com.garmin.fit;

/* loaded from: classes9.dex */
public enum Bool {
    FALSE(0),
    TRUE(1),
    INVALID(255);

    protected short value;

    Bool(short s) {
        this.value = s;
    }

    public static Bool getByValue(Short sh) {
        for (Bool bool : values()) {
            if (sh.shortValue() == bool.value) {
                return bool;
            }
        }
        return INVALID;
    }

    public short getValue() {
        return this.value;
    }
}
