package com.garmin.fit;

/* loaded from: classes9.dex */
public enum MaxMetSpeedSource {
    ONBOARD_GPS(0),
    CONNECTED_GPS(1),
    CADENCE(2),
    INVALID(255);

    protected short value;

    MaxMetSpeedSource(short s) {
        this.value = s;
    }

    public static MaxMetSpeedSource getByValue(Short sh) {
        for (MaxMetSpeedSource maxMetSpeedSource : values()) {
            if (sh.shortValue() == maxMetSpeedSource.value) {
                return maxMetSpeedSource;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(MaxMetSpeedSource maxMetSpeedSource) {
        return maxMetSpeedSource.name();
    }

    public short getValue() {
        return this.value;
    }
}
