package com.garmin.fit;

/* loaded from: classes9.dex */
public enum StrokeType {
    NO_EVENT(0),
    OTHER(1),
    SERVE(2),
    FOREHAND(3),
    BACKHAND(4),
    SMASH(5),
    INVALID(255);

    protected short value;

    StrokeType(short s) {
        this.value = s;
    }

    public static StrokeType getByValue(Short sh) {
        for (StrokeType strokeType : values()) {
            if (sh.shortValue() == strokeType.value) {
                return strokeType;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(StrokeType strokeType) {
        return strokeType.name();
    }

    public short getValue() {
        return this.value;
    }
}
