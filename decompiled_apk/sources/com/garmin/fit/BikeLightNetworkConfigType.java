package com.garmin.fit;

/* loaded from: classes9.dex */
public enum BikeLightNetworkConfigType {
    AUTO(0),
    INDIVIDUAL(4),
    HIGH_VISIBILITY(5),
    TRAIL(6),
    INVALID(255);

    protected short value;

    BikeLightNetworkConfigType(short s) {
        this.value = s;
    }

    public static BikeLightNetworkConfigType getByValue(Short sh) {
        for (BikeLightNetworkConfigType bikeLightNetworkConfigType : values()) {
            if (sh.shortValue() == bikeLightNetworkConfigType.value) {
                return bikeLightNetworkConfigType;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(BikeLightNetworkConfigType bikeLightNetworkConfigType) {
        return bikeLightNetworkConfigType.name();
    }

    public short getValue() {
        return this.value;
    }
}
