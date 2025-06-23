package com.garmin.fit;

/* loaded from: classes9.dex */
public enum DiveAlarmType {
    DEPTH(0),
    TIME(1),
    SPEED(2),
    INVALID(255);

    protected short value;

    DiveAlarmType(short s) {
        this.value = s;
    }

    public static DiveAlarmType getByValue(Short sh) {
        for (DiveAlarmType diveAlarmType : values()) {
            if (sh.shortValue() == diveAlarmType.value) {
                return diveAlarmType;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(DiveAlarmType diveAlarmType) {
        return diveAlarmType.name();
    }

    public short getValue() {
        return this.value;
    }
}
