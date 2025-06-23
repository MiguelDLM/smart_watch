package com.garmin.fit;

/* loaded from: classes9.dex */
public enum AutolapTrigger {
    TIME(0),
    DISTANCE(1),
    POSITION_START(2),
    POSITION_LAP(3),
    POSITION_WAYPOINT(4),
    POSITION_MARKED(5),
    OFF(6),
    INVALID(255);

    protected short value;

    AutolapTrigger(short s) {
        this.value = s;
    }

    public static AutolapTrigger getByValue(Short sh) {
        for (AutolapTrigger autolapTrigger : values()) {
            if (sh.shortValue() == autolapTrigger.value) {
                return autolapTrigger;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(AutolapTrigger autolapTrigger) {
        return autolapTrigger.name();
    }

    public short getValue() {
        return this.value;
    }
}
