package com.garmin.fit;

/* loaded from: classes9.dex */
public enum MaxMetHeartRateSource {
    WHR(0),
    HRM(1),
    INVALID(255);

    protected short value;

    MaxMetHeartRateSource(short s) {
        this.value = s;
    }

    public static MaxMetHeartRateSource getByValue(Short sh) {
        for (MaxMetHeartRateSource maxMetHeartRateSource : values()) {
            if (sh.shortValue() == maxMetHeartRateSource.value) {
                return maxMetHeartRateSource;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(MaxMetHeartRateSource maxMetHeartRateSource) {
        return maxMetHeartRateSource.name();
    }

    public short getValue() {
        return this.value;
    }
}
