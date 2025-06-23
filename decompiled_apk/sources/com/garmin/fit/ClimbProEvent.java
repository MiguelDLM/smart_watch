package com.garmin.fit;

/* loaded from: classes9.dex */
public enum ClimbProEvent {
    APPROACH(0),
    START(1),
    COMPLETE(2),
    INVALID(255);

    protected short value;

    ClimbProEvent(short s) {
        this.value = s;
    }

    public static ClimbProEvent getByValue(Short sh) {
        for (ClimbProEvent climbProEvent : values()) {
            if (sh.shortValue() == climbProEvent.value) {
                return climbProEvent;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(ClimbProEvent climbProEvent) {
        return climbProEvent.name();
    }

    public short getValue() {
        return this.value;
    }
}
