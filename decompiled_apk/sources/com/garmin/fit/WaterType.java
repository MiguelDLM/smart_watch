package com.garmin.fit;

/* loaded from: classes9.dex */
public enum WaterType {
    FRESH(0),
    SALT(1),
    EN13319(2),
    CUSTOM(3),
    INVALID(255);

    protected short value;

    WaterType(short s) {
        this.value = s;
    }

    public static WaterType getByValue(Short sh) {
        for (WaterType waterType : values()) {
            if (sh.shortValue() == waterType.value) {
                return waterType;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(WaterType waterType) {
        return waterType.name();
    }

    public short getValue() {
        return this.value;
    }
}
