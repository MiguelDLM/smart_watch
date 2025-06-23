package com.garmin.fit;

/* loaded from: classes9.dex */
public enum ExdQualifiers {
    NO_QUALIFIER(0),
    INSTANTANEOUS(1),
    AVERAGE(2),
    LAP(3),
    MAXIMUM(4),
    MAXIMUM_AVERAGE(5),
    MAXIMUM_LAP(6),
    LAST_LAP(7),
    AVERAGE_LAP(8),
    TO_DESTINATION(9),
    TO_GO(10),
    TO_NEXT(11),
    NEXT_COURSE_POINT(12),
    TOTAL(13),
    THREE_SECOND_AVERAGE(14),
    TEN_SECOND_AVERAGE(15),
    THIRTY_SECOND_AVERAGE(16),
    PERCENT_MAXIMUM(17),
    PERCENT_MAXIMUM_AVERAGE(18),
    LAP_PERCENT_MAXIMUM(19),
    ELAPSED(20),
    SUNRISE(21),
    SUNSET(22),
    COMPARED_TO_VIRTUAL_PARTNER(23),
    MAXIMUM_24H(24),
    MINIMUM_24H(25),
    MINIMUM(26),
    FIRST(27),
    SECOND(28),
    THIRD(29),
    SHIFTER(30),
    LAST_SPORT(31),
    MOVING(32),
    STOPPED(33),
    ESTIMATED_TOTAL(34),
    ZONE_9(242),
    ZONE_8(243),
    ZONE_7(244),
    ZONE_6(245),
    ZONE_5(246),
    ZONE_4(247),
    ZONE_3(248),
    ZONE_2(249),
    ZONE_1(250),
    INVALID(255);

    protected short value;

    ExdQualifiers(short s) {
        this.value = s;
    }

    public static ExdQualifiers getByValue(Short sh) {
        for (ExdQualifiers exdQualifiers : values()) {
            if (sh.shortValue() == exdQualifiers.value) {
                return exdQualifiers;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(ExdQualifiers exdQualifiers) {
        return exdQualifiers.name();
    }

    public short getValue() {
        return this.value;
    }
}
