package com.garmin.fit;

/* loaded from: classes9.dex */
public enum SourceType {
    ANT(0),
    ANTPLUS(1),
    BLUETOOTH(2),
    BLUETOOTH_LOW_ENERGY(3),
    WIFI(4),
    LOCAL(5),
    INVALID(255);

    protected short value;

    SourceType(short s) {
        this.value = s;
    }

    public static SourceType getByValue(Short sh) {
        for (SourceType sourceType : values()) {
            if (sh.shortValue() == sourceType.value) {
                return sourceType;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(SourceType sourceType) {
        return sourceType.name();
    }

    public short getValue() {
        return this.value;
    }
}
