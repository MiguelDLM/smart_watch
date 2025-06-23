package com.garmin.fit;

/* loaded from: classes9.dex */
public enum PowerPhaseType {
    POWER_PHASE_START_ANGLE(0),
    POWER_PHASE_END_ANGLE(1),
    POWER_PHASE_ARC_LENGTH(2),
    POWER_PHASE_CENTER(3),
    INVALID(255);

    protected short value;

    PowerPhaseType(short s) {
        this.value = s;
    }

    public static PowerPhaseType getByValue(Short sh) {
        for (PowerPhaseType powerPhaseType : values()) {
            if (sh.shortValue() == powerPhaseType.value) {
                return powerPhaseType;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(PowerPhaseType powerPhaseType) {
        return powerPhaseType.name();
    }

    public short getValue() {
        return this.value;
    }
}
