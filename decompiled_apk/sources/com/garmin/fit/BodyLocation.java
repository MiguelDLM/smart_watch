package com.garmin.fit;

/* loaded from: classes9.dex */
public enum BodyLocation {
    LEFT_LEG(0),
    LEFT_CALF(1),
    LEFT_SHIN(2),
    LEFT_HAMSTRING(3),
    LEFT_QUAD(4),
    LEFT_GLUTE(5),
    RIGHT_LEG(6),
    RIGHT_CALF(7),
    RIGHT_SHIN(8),
    RIGHT_HAMSTRING(9),
    RIGHT_QUAD(10),
    RIGHT_GLUTE(11),
    TORSO_BACK(12),
    LEFT_LOWER_BACK(13),
    LEFT_UPPER_BACK(14),
    RIGHT_LOWER_BACK(15),
    RIGHT_UPPER_BACK(16),
    TORSO_FRONT(17),
    LEFT_ABDOMEN(18),
    LEFT_CHEST(19),
    RIGHT_ABDOMEN(20),
    RIGHT_CHEST(21),
    LEFT_ARM(22),
    LEFT_SHOULDER(23),
    LEFT_BICEP(24),
    LEFT_TRICEP(25),
    LEFT_BRACHIORADIALIS(26),
    LEFT_FOREARM_EXTENSORS(27),
    RIGHT_ARM(28),
    RIGHT_SHOULDER(29),
    RIGHT_BICEP(30),
    RIGHT_TRICEP(31),
    RIGHT_BRACHIORADIALIS(32),
    RIGHT_FOREARM_EXTENSORS(33),
    NECK(34),
    THROAT(35),
    WAIST_MID_BACK(36),
    WAIST_FRONT(37),
    WAIST_LEFT(38),
    WAIST_RIGHT(39),
    INVALID(255);

    protected short value;

    BodyLocation(short s) {
        this.value = s;
    }

    public static BodyLocation getByValue(Short sh) {
        for (BodyLocation bodyLocation : values()) {
            if (sh.shortValue() == bodyLocation.value) {
                return bodyLocation;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(BodyLocation bodyLocation) {
        return bodyLocation.name();
    }

    public short getValue() {
        return this.value;
    }
}
