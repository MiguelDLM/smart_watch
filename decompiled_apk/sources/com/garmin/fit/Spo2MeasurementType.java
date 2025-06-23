package com.garmin.fit;

/* loaded from: classes9.dex */
public enum Spo2MeasurementType {
    OFF_WRIST(0),
    SPOT_CHECK(1),
    CONTINUOUS_CHECK(2),
    PERIODIC(3),
    INVALID(255);

    protected short value;

    Spo2MeasurementType(short s) {
        this.value = s;
    }

    public static Spo2MeasurementType getByValue(Short sh) {
        for (Spo2MeasurementType spo2MeasurementType : values()) {
            if (sh.shortValue() == spo2MeasurementType.value) {
                return spo2MeasurementType;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(Spo2MeasurementType spo2MeasurementType) {
        return spo2MeasurementType.name();
    }

    public short getValue() {
        return this.value;
    }
}
