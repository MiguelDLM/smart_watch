package com.garmin.fit;

/* loaded from: classes9.dex */
public enum SplitType {
    ASCENT_SPLIT(1),
    DESCENT_SPLIT(2),
    INTERVAL_ACTIVE(3),
    INTERVAL_REST(4),
    INTERVAL_WARMUP(5),
    INTERVAL_COOLDOWN(6),
    INTERVAL_RECOVERY(7),
    INTERVAL_OTHER(8),
    CLIMB_ACTIVE(9),
    CLIMB_REST(10),
    SURF_ACTIVE(11),
    RUN_ACTIVE(12),
    RUN_REST(13),
    WORKOUT_ROUND(14),
    RWD_RUN(17),
    RWD_WALK(18),
    WINDSURF_ACTIVE(21),
    RWD_STAND(22),
    TRANSITION(23),
    SKI_LIFT_SPLIT(28),
    SKI_RUN_SPLIT(29),
    INVALID(255);

    protected short value;

    SplitType(short s) {
        this.value = s;
    }

    public static SplitType getByValue(Short sh) {
        for (SplitType splitType : values()) {
            if (sh.shortValue() == splitType.value) {
                return splitType;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(SplitType splitType) {
        return splitType.name();
    }

    public short getValue() {
        return this.value;
    }
}
