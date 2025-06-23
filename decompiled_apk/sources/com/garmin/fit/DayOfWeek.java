package com.garmin.fit;

/* loaded from: classes9.dex */
public enum DayOfWeek {
    SUNDAY(0),
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    INVALID(255);

    protected short value;

    DayOfWeek(short s) {
        this.value = s;
    }

    public static DayOfWeek getByValue(Short sh) {
        for (DayOfWeek dayOfWeek : values()) {
            if (sh.shortValue() == dayOfWeek.value) {
                return dayOfWeek;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(DayOfWeek dayOfWeek) {
        return dayOfWeek.name();
    }

    public short getValue() {
        return this.value;
    }
}
