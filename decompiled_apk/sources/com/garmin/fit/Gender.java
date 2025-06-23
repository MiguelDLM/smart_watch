package com.garmin.fit;

/* loaded from: classes9.dex */
public enum Gender {
    FEMALE(0),
    MALE(1),
    INVALID(255);

    protected short value;

    Gender(short s) {
        this.value = s;
    }

    public static Gender getByValue(Short sh) {
        for (Gender gender : values()) {
            if (sh.shortValue() == gender.value) {
                return gender;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(Gender gender) {
        return gender.name();
    }

    public short getValue() {
        return this.value;
    }
}
