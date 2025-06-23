package com.garmin.fit;

/* loaded from: classes9.dex */
public enum DisplayPosition {
    DEGREE(0),
    DEGREE_MINUTE(1),
    DEGREE_MINUTE_SECOND(2),
    AUSTRIAN_GRID(3),
    BRITISH_GRID(4),
    DUTCH_GRID(5),
    HUNGARIAN_GRID(6),
    FINNISH_GRID(7),
    GERMAN_GRID(8),
    ICELANDIC_GRID(9),
    INDONESIAN_EQUATORIAL(10),
    INDONESIAN_IRIAN(11),
    INDONESIAN_SOUTHERN(12),
    INDIA_ZONE_0(13),
    INDIA_ZONE_IA(14),
    INDIA_ZONE_IB(15),
    INDIA_ZONE_IIA(16),
    INDIA_ZONE_IIB(17),
    INDIA_ZONE_IIIA(18),
    INDIA_ZONE_IIIB(19),
    INDIA_ZONE_IVA(20),
    INDIA_ZONE_IVB(21),
    IRISH_TRANSVERSE(22),
    IRISH_GRID(23),
    LORAN(24),
    MAIDENHEAD_GRID(25),
    MGRS_GRID(26),
    NEW_ZEALAND_GRID(27),
    NEW_ZEALAND_TRANSVERSE(28),
    QATAR_GRID(29),
    MODIFIED_SWEDISH_GRID(30),
    SWEDISH_GRID(31),
    SOUTH_AFRICAN_GRID(32),
    SWISS_GRID(33),
    TAIWAN_GRID(34),
    UNITED_STATES_GRID(35),
    UTM_UPS_GRID(36),
    WEST_MALAYAN(37),
    BORNEO_RSO(38),
    ESTONIAN_GRID(39),
    LATVIAN_GRID(40),
    SWEDISH_REF_99_GRID(41),
    INVALID(255);

    protected short value;

    DisplayPosition(short s) {
        this.value = s;
    }

    public static DisplayPosition getByValue(Short sh) {
        for (DisplayPosition displayPosition : values()) {
            if (sh.shortValue() == displayPosition.value) {
                return displayPosition;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(DisplayPosition displayPosition) {
        return displayPosition.name();
    }

    public short getValue() {
        return this.value;
    }
}
