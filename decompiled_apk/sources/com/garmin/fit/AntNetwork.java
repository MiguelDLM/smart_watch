package com.garmin.fit;

/* loaded from: classes9.dex */
public enum AntNetwork {
    PUBLIC(0),
    ANTPLUS(1),
    ANTFS(2),
    PRIVATE(3),
    INVALID(255);

    protected short value;

    AntNetwork(short s) {
        this.value = s;
    }

    public static AntNetwork getByValue(Short sh) {
        for (AntNetwork antNetwork : values()) {
            if (sh.shortValue() == antNetwork.value) {
                return antNetwork;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(AntNetwork antNetwork) {
        return antNetwork.name();
    }

    public short getValue() {
        return this.value;
    }
}
