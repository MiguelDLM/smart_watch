package com.garmin.fit;

/* loaded from: classes9.dex */
public enum WktStepDuration {
    TIME(0),
    DISTANCE(1),
    HR_LESS_THAN(2),
    HR_GREATER_THAN(3),
    CALORIES(4),
    OPEN(5),
    REPEAT_UNTIL_STEPS_CMPLT(6),
    REPEAT_UNTIL_TIME(7),
    REPEAT_UNTIL_DISTANCE(8),
    REPEAT_UNTIL_CALORIES(9),
    REPEAT_UNTIL_HR_LESS_THAN(10),
    REPEAT_UNTIL_HR_GREATER_THAN(11),
    REPEAT_UNTIL_POWER_LESS_THAN(12),
    REPEAT_UNTIL_POWER_GREATER_THAN(13),
    POWER_LESS_THAN(14),
    POWER_GREATER_THAN(15),
    TRAINING_PEAKS_TSS(16),
    REPEAT_UNTIL_POWER_LAST_LAP_LESS_THAN(17),
    REPEAT_UNTIL_MAX_POWER_LAST_LAP_LESS_THAN(18),
    POWER_3S_LESS_THAN(19),
    POWER_10S_LESS_THAN(20),
    POWER_30S_LESS_THAN(21),
    POWER_3S_GREATER_THAN(22),
    POWER_10S_GREATER_THAN(23),
    POWER_30S_GREATER_THAN(24),
    POWER_LAP_LESS_THAN(25),
    POWER_LAP_GREATER_THAN(26),
    REPEAT_UNTIL_TRAINING_PEAKS_TSS(27),
    REPETITION_TIME(28),
    REPS(29),
    TIME_ONLY(31),
    INVALID(255);

    protected short value;

    WktStepDuration(short s) {
        this.value = s;
    }

    public static WktStepDuration getByValue(Short sh) {
        for (WktStepDuration wktStepDuration : values()) {
            if (sh.shortValue() == wktStepDuration.value) {
                return wktStepDuration;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(WktStepDuration wktStepDuration) {
        return wktStepDuration.name();
    }

    public short getValue() {
        return this.value;
    }
}
