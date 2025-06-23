package com.garmin.fit;

/* loaded from: classes9.dex */
public enum SwimStroke {
    FREESTYLE(0),
    BACKSTROKE(1),
    BREASTSTROKE(2),
    BUTTERFLY(3),
    DRILL(4),
    MIXED(5),
    IM(6),
    INVALID(255);

    protected short value;

    SwimStroke(short s) {
        this.value = s;
    }

    public static SwimStroke getByValue(Short sh) {
        for (SwimStroke swimStroke : values()) {
            if (sh.shortValue() == swimStroke.value) {
                return swimStroke;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(SwimStroke swimStroke) {
        return swimStroke.name();
    }

    public short getValue() {
        return this.value;
    }
}
