package com.garmin.fit;

/* loaded from: classes9.dex */
public enum LapTrigger {
    MANUAL(0),
    TIME(1),
    DISTANCE(2),
    POSITION_START(3),
    POSITION_LAP(4),
    POSITION_WAYPOINT(5),
    POSITION_MARKED(6),
    SESSION_END(7),
    FITNESS_EQUIPMENT(8),
    INVALID(255);

    protected short value;

    LapTrigger(short s) {
        this.value = s;
    }

    public static LapTrigger getByValue(Short sh) {
        for (LapTrigger lapTrigger : values()) {
            if (sh.shortValue() == lapTrigger.value) {
                return lapTrigger;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(LapTrigger lapTrigger) {
        return lapTrigger.name();
    }

    public short getValue() {
        return this.value;
    }
}
