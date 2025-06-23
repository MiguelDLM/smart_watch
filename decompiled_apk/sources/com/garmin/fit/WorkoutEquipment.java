package com.garmin.fit;

/* loaded from: classes9.dex */
public enum WorkoutEquipment {
    NONE(0),
    SWIM_FINS(1),
    SWIM_KICKBOARD(2),
    SWIM_PADDLES(3),
    SWIM_PULL_BUOY(4),
    SWIM_SNORKEL(5),
    INVALID(255);

    protected short value;

    WorkoutEquipment(short s) {
        this.value = s;
    }

    public static WorkoutEquipment getByValue(Short sh) {
        for (WorkoutEquipment workoutEquipment : values()) {
            if (sh.shortValue() == workoutEquipment.value) {
                return workoutEquipment;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(WorkoutEquipment workoutEquipment) {
        return workoutEquipment.name();
    }

    public short getValue() {
        return this.value;
    }
}
