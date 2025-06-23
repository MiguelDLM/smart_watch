package com.garmin.fit;

/* loaded from: classes9.dex */
public enum ActivitySubtype {
    GENERIC(0),
    TREADMILL(1),
    STREET(2),
    TRAIL(3),
    TRACK(4),
    SPIN(5),
    INDOOR_CYCLING(6),
    ROAD(7),
    MOUNTAIN(8),
    DOWNHILL(9),
    RECUMBENT(10),
    CYCLOCROSS(11),
    HAND_CYCLING(12),
    TRACK_CYCLING(13),
    INDOOR_ROWING(14),
    ELLIPTICAL(15),
    STAIR_CLIMBING(16),
    LAP_SWIMMING(17),
    OPEN_WATER(18),
    ALL(254),
    INVALID(255);

    protected short value;

    ActivitySubtype(short s) {
        this.value = s;
    }

    public static ActivitySubtype getByValue(Short sh) {
        for (ActivitySubtype activitySubtype : values()) {
            if (sh.shortValue() == activitySubtype.value) {
                return activitySubtype;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(ActivitySubtype activitySubtype) {
        return activitySubtype.name();
    }

    public short getValue() {
        return this.value;
    }
}
