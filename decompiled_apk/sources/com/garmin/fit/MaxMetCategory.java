package com.garmin.fit;

/* loaded from: classes9.dex */
public enum MaxMetCategory {
    GENERIC(0),
    CYCLING(1),
    INVALID(255);

    protected short value;

    MaxMetCategory(short s) {
        this.value = s;
    }

    public static MaxMetCategory getByValue(Short sh) {
        for (MaxMetCategory maxMetCategory : values()) {
            if (sh.shortValue() == maxMetCategory.value) {
                return maxMetCategory;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(MaxMetCategory maxMetCategory) {
        return maxMetCategory.name();
    }

    public short getValue() {
        return this.value;
    }
}
