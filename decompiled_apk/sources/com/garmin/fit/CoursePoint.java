package com.garmin.fit;

/* loaded from: classes9.dex */
public enum CoursePoint {
    GENERIC(0),
    SUMMIT(1),
    VALLEY(2),
    WATER(3),
    FOOD(4),
    DANGER(5),
    LEFT(6),
    RIGHT(7),
    STRAIGHT(8),
    FIRST_AID(9),
    FOURTH_CATEGORY(10),
    THIRD_CATEGORY(11),
    SECOND_CATEGORY(12),
    FIRST_CATEGORY(13),
    HORS_CATEGORY(14),
    SPRINT(15),
    LEFT_FORK(16),
    RIGHT_FORK(17),
    MIDDLE_FORK(18),
    SLIGHT_LEFT(19),
    SHARP_LEFT(20),
    SLIGHT_RIGHT(21),
    SHARP_RIGHT(22),
    U_TURN(23),
    SEGMENT_START(24),
    SEGMENT_END(25),
    CAMPSITE(27),
    AID_STATION(28),
    REST_AREA(29),
    GENERAL_DISTANCE(30),
    SERVICE(31),
    ENERGY_GEL(32),
    SPORTS_DRINK(33),
    MILE_MARKER(34),
    CHECKPOINT(35),
    SHELTER(36),
    MEETING_SPOT(37),
    OVERLOOK(38),
    TOILET(39),
    SHOWER(40),
    GEAR(41),
    SHARP_CURVE(42),
    STEEP_INCLINE(43),
    TUNNEL(44),
    BRIDGE(45),
    OBSTACLE(46),
    CROSSING(47),
    STORE(48),
    TRANSITION(49),
    NAVAID(50),
    TRANSPORT(51),
    ALERT(52),
    INFO(53),
    INVALID(255);

    protected short value;

    CoursePoint(short s) {
        this.value = s;
    }

    public static CoursePoint getByValue(Short sh) {
        for (CoursePoint coursePoint : values()) {
            if (sh.shortValue() == coursePoint.value) {
                return coursePoint;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(CoursePoint coursePoint) {
        return coursePoint.name();
    }

    public short getValue() {
        return this.value;
    }
}
