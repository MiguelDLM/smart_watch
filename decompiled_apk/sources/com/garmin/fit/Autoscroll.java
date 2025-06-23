package com.garmin.fit;

/* loaded from: classes9.dex */
public enum Autoscroll {
    NONE(0),
    SLOW(1),
    MEDIUM(2),
    FAST(3),
    INVALID(255);

    protected short value;

    Autoscroll(short s) {
        this.value = s;
    }

    public static Autoscroll getByValue(Short sh) {
        for (Autoscroll autoscroll : values()) {
            if (sh.shortValue() == autoscroll.value) {
                return autoscroll;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(Autoscroll autoscroll) {
        return autoscroll.name();
    }

    public short getValue() {
        return this.value;
    }
}
