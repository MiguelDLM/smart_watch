package com.garmin.fit;

/* loaded from: classes9.dex */
public enum HrType {
    NORMAL(0),
    IRREGULAR(1),
    INVALID(255);

    protected short value;

    HrType(short s) {
        this.value = s;
    }

    public static HrType getByValue(Short sh) {
        for (HrType hrType : values()) {
            if (sh.shortValue() == hrType.value) {
                return hrType;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(HrType hrType) {
        return hrType.name();
    }

    public short getValue() {
        return this.value;
    }
}
