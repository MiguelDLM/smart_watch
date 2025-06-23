package com.garmin.fit;

/* loaded from: classes9.dex */
public enum FitnessEquipmentState {
    READY(0),
    IN_USE(1),
    PAUSED(2),
    UNKNOWN(3),
    INVALID(255);

    protected short value;

    FitnessEquipmentState(short s) {
        this.value = s;
    }

    public static FitnessEquipmentState getByValue(Short sh) {
        for (FitnessEquipmentState fitnessEquipmentState : values()) {
            if (sh.shortValue() == fitnessEquipmentState.value) {
                return fitnessEquipmentState;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(FitnessEquipmentState fitnessEquipmentState) {
        return fitnessEquipmentState.name();
    }

    public short getValue() {
        return this.value;
    }
}
