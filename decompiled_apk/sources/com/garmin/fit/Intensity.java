package com.garmin.fit;

/* loaded from: classes9.dex */
public enum Intensity {
    ACTIVE(0),
    REST(1),
    WARMUP(2),
    COOLDOWN(3),
    RECOVERY(4),
    INTERVAL(5),
    OTHER(6),
    INVALID(255);

    protected short value;

    Intensity(short s) {
        this.value = s;
    }

    public static Intensity getByValue(Short sh) {
        for (Intensity intensity : values()) {
            if (sh.shortValue() == intensity.value) {
                return intensity;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(Intensity intensity) {
        return intensity.name();
    }

    public short getValue() {
        return this.value;
    }
}
