package com.garmin.fit;

/* loaded from: classes9.dex */
public enum Event {
    TIMER(0),
    WORKOUT(3),
    WORKOUT_STEP(4),
    POWER_DOWN(5),
    POWER_UP(6),
    OFF_COURSE(7),
    SESSION(8),
    LAP(9),
    COURSE_POINT(10),
    BATTERY(11),
    VIRTUAL_PARTNER_PACE(12),
    HR_HIGH_ALERT(13),
    HR_LOW_ALERT(14),
    SPEED_HIGH_ALERT(15),
    SPEED_LOW_ALERT(16),
    CAD_HIGH_ALERT(17),
    CAD_LOW_ALERT(18),
    POWER_HIGH_ALERT(19),
    POWER_LOW_ALERT(20),
    RECOVERY_HR(21),
    BATTERY_LOW(22),
    TIME_DURATION_ALERT(23),
    DISTANCE_DURATION_ALERT(24),
    CALORIE_DURATION_ALERT(25),
    ACTIVITY(26),
    FITNESS_EQUIPMENT(27),
    LENGTH(28),
    USER_MARKER(32),
    SPORT_POINT(33),
    CALIBRATION(36),
    FRONT_GEAR_CHANGE(42),
    REAR_GEAR_CHANGE(43),
    RIDER_POSITION_CHANGE(44),
    ELEV_HIGH_ALERT(45),
    ELEV_LOW_ALERT(46),
    COMM_TIMEOUT(47),
    AUTO_ACTIVITY_DETECT(54),
    DIVE_ALERT(56),
    DIVE_GAS_SWITCHED(57),
    TANK_PRESSURE_RESERVE(71),
    TANK_PRESSURE_CRITICAL(72),
    TANK_LOST(73),
    RADAR_THREAT_ALERT(75),
    TANK_BATTERY_LOW(76),
    TANK_POD_CONNECTED(81),
    TANK_POD_DISCONNECTED(82),
    INVALID(255);

    protected short value;

    Event(short s) {
        this.value = s;
    }

    public static Event getByValue(Short sh) {
        for (Event event : values()) {
            if (sh.shortValue() == event.value) {
                return event;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(Event event) {
        return event.name();
    }

    public short getValue() {
        return this.value;
    }
}
