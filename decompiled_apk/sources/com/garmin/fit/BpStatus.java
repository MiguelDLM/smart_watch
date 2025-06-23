package com.garmin.fit;

/* loaded from: classes9.dex */
public enum BpStatus {
    NO_ERROR(0),
    ERROR_INCOMPLETE_DATA(1),
    ERROR_NO_MEASUREMENT(2),
    ERROR_DATA_OUT_OF_RANGE(3),
    ERROR_IRREGULAR_HEART_RATE(4),
    INVALID(255);

    protected short value;

    BpStatus(short s) {
        this.value = s;
    }

    public static BpStatus getByValue(Short sh) {
        for (BpStatus bpStatus : values()) {
            if (sh.shortValue() == bpStatus.value) {
                return bpStatus;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(BpStatus bpStatus) {
        return bpStatus.name();
    }

    public short getValue() {
        return this.value;
    }
}
