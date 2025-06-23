package com.garmin.fit;

/* loaded from: classes9.dex */
public enum DiveGasMode {
    OPEN_CIRCUIT(0),
    CLOSED_CIRCUIT_DILUENT(1),
    INVALID(255);

    protected short value;

    DiveGasMode(short s) {
        this.value = s;
    }

    public static DiveGasMode getByValue(Short sh) {
        for (DiveGasMode diveGasMode : values()) {
            if (sh.shortValue() == diveGasMode.value) {
                return diveGasMode;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(DiveGasMode diveGasMode) {
        return diveGasMode.name();
    }

    public short getValue() {
        return this.value;
    }
}
