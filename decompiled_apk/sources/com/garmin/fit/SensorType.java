package com.garmin.fit;

/* loaded from: classes9.dex */
public enum SensorType {
    ACCELEROMETER(0),
    GYROSCOPE(1),
    COMPASS(2),
    BAROMETER(3),
    INVALID(255);

    protected short value;

    SensorType(short s) {
        this.value = s;
    }

    public static SensorType getByValue(Short sh) {
        for (SensorType sensorType : values()) {
            if (sh.shortValue() == sensorType.value) {
                return sensorType;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(SensorType sensorType) {
        return sensorType.name();
    }

    public short getValue() {
        return this.value;
    }
}
