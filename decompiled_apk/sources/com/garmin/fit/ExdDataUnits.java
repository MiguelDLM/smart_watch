package com.garmin.fit;

/* loaded from: classes9.dex */
public enum ExdDataUnits {
    NO_UNITS(0),
    LAPS(1),
    MILES_PER_HOUR(2),
    KILOMETERS_PER_HOUR(3),
    FEET_PER_HOUR(4),
    METERS_PER_HOUR(5),
    DEGREES_CELSIUS(6),
    DEGREES_FARENHEIT(7),
    ZONE(8),
    GEAR(9),
    RPM(10),
    BPM(11),
    DEGREES(12),
    MILLIMETERS(13),
    METERS(14),
    KILOMETERS(15),
    FEET(16),
    YARDS(17),
    KILOFEET(18),
    MILES(19),
    TIME(20),
    ENUM_TURN_TYPE(21),
    PERCENT(22),
    WATTS(23),
    WATTS_PER_KILOGRAM(24),
    ENUM_BATTERY_STATUS(25),
    ENUM_BIKE_LIGHT_BEAM_ANGLE_MODE(26),
    ENUM_BIKE_LIGHT_BATTERY_STATUS(27),
    ENUM_BIKE_LIGHT_NETWORK_CONFIG_TYPE(28),
    LIGHTS(29),
    SECONDS(30),
    MINUTES(31),
    HOURS(32),
    CALORIES(33),
    KILOJOULES(34),
    MILLISECONDS(35),
    SECOND_PER_MILE(36),
    SECOND_PER_KILOMETER(37),
    CENTIMETER(38),
    ENUM_COURSE_POINT(39),
    BRADIANS(40),
    ENUM_SPORT(41),
    INCHES_HG(42),
    MM_HG(43),
    MBARS(44),
    HECTO_PASCALS(45),
    FEET_PER_MIN(46),
    METERS_PER_MIN(47),
    METERS_PER_SEC(48),
    EIGHT_CARDINAL(49),
    INVALID(255);

    protected short value;

    ExdDataUnits(short s) {
        this.value = s;
    }

    public static ExdDataUnits getByValue(Short sh) {
        for (ExdDataUnits exdDataUnits : values()) {
            if (sh.shortValue() == exdDataUnits.value) {
                return exdDataUnits;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(ExdDataUnits exdDataUnits) {
        return exdDataUnits.name();
    }

    public short getValue() {
        return this.value;
    }
}
