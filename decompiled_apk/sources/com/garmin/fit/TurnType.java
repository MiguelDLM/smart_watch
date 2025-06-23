package com.garmin.fit;

/* loaded from: classes9.dex */
public enum TurnType {
    ARRIVING_IDX(0),
    ARRIVING_LEFT_IDX(1),
    ARRIVING_RIGHT_IDX(2),
    ARRIVING_VIA_IDX(3),
    ARRIVING_VIA_LEFT_IDX(4),
    ARRIVING_VIA_RIGHT_IDX(5),
    BEAR_KEEP_LEFT_IDX(6),
    BEAR_KEEP_RIGHT_IDX(7),
    CONTINUE_IDX(8),
    EXIT_LEFT_IDX(9),
    EXIT_RIGHT_IDX(10),
    FERRY_IDX(11),
    ROUNDABOUT_45_IDX(12),
    ROUNDABOUT_90_IDX(13),
    ROUNDABOUT_135_IDX(14),
    ROUNDABOUT_180_IDX(15),
    ROUNDABOUT_225_IDX(16),
    ROUNDABOUT_270_IDX(17),
    ROUNDABOUT_315_IDX(18),
    ROUNDABOUT_360_IDX(19),
    ROUNDABOUT_NEG_45_IDX(20),
    ROUNDABOUT_NEG_90_IDX(21),
    ROUNDABOUT_NEG_135_IDX(22),
    ROUNDABOUT_NEG_180_IDX(23),
    ROUNDABOUT_NEG_225_IDX(24),
    ROUNDABOUT_NEG_270_IDX(25),
    ROUNDABOUT_NEG_315_IDX(26),
    ROUNDABOUT_NEG_360_IDX(27),
    ROUNDABOUT_GENERIC_IDX(28),
    ROUNDABOUT_NEG_GENERIC_IDX(29),
    SHARP_TURN_LEFT_IDX(30),
    SHARP_TURN_RIGHT_IDX(31),
    TURN_LEFT_IDX(32),
    TURN_RIGHT_IDX(33),
    UTURN_LEFT_IDX(34),
    UTURN_RIGHT_IDX(35),
    ICON_INV_IDX(36),
    ICON_IDX_CNT(37),
    INVALID(255);

    protected short value;

    TurnType(short s) {
        this.value = s;
    }

    public static TurnType getByValue(Short sh) {
        for (TurnType turnType : values()) {
            if (sh.shortValue() == turnType.value) {
                return turnType;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(TurnType turnType) {
        return turnType.name();
    }

    public short getValue() {
        return this.value;
    }
}
