package com.garmin.fit;

/* loaded from: classes9.dex */
public enum WatchfaceMode {
    DIGITAL(0),
    ANALOG(1),
    CONNECT_IQ(2),
    DISABLED(3),
    INVALID(255);

    protected short value;

    WatchfaceMode(short s) {
        this.value = s;
    }

    public static WatchfaceMode getByValue(Short sh) {
        for (WatchfaceMode watchfaceMode : values()) {
            if (sh.shortValue() == watchfaceMode.value) {
                return watchfaceMode;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(WatchfaceMode watchfaceMode) {
        return watchfaceMode.name();
    }

    public short getValue() {
        return this.value;
    }
}
