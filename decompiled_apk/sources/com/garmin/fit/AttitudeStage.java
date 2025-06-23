package com.garmin.fit;

/* loaded from: classes9.dex */
public enum AttitudeStage {
    FAILED(0),
    ALIGNING(1),
    DEGRADED(2),
    VALID(3),
    INVALID(255);

    protected short value;

    AttitudeStage(short s) {
        this.value = s;
    }

    public static AttitudeStage getByValue(Short sh) {
        for (AttitudeStage attitudeStage : values()) {
            if (sh.shortValue() == attitudeStage.value) {
                return attitudeStage;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(AttitudeStage attitudeStage) {
        return attitudeStage.name();
    }

    public short getValue() {
        return this.value;
    }
}
