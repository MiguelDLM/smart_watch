package com.garmin.fit;

/* loaded from: classes9.dex */
public enum GasConsumptionRateType {
    PRESSURE_SAC(0),
    VOLUME_SAC(1),
    RMV(2),
    INVALID(255);

    protected short value;

    GasConsumptionRateType(short s) {
        this.value = s;
    }

    public static GasConsumptionRateType getByValue(Short sh) {
        for (GasConsumptionRateType gasConsumptionRateType : values()) {
            if (sh.shortValue() == gasConsumptionRateType.value) {
                return gasConsumptionRateType;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(GasConsumptionRateType gasConsumptionRateType) {
        return gasConsumptionRateType.name();
    }

    public short getValue() {
        return this.value;
    }
}
