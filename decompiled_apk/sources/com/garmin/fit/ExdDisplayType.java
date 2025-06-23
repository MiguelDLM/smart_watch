package com.garmin.fit;

/* loaded from: classes9.dex */
public enum ExdDisplayType {
    NUMERICAL(0),
    SIMPLE(1),
    GRAPH(2),
    BAR(3),
    CIRCLE_GRAPH(4),
    VIRTUAL_PARTNER(5),
    BALANCE(6),
    STRING_LIST(7),
    STRING(8),
    SIMPLE_DYNAMIC_ICON(9),
    GAUGE(10),
    INVALID(255);

    protected short value;

    ExdDisplayType(short s) {
        this.value = s;
    }

    public static ExdDisplayType getByValue(Short sh) {
        for (ExdDisplayType exdDisplayType : values()) {
            if (sh.shortValue() == exdDisplayType.value) {
                return exdDisplayType;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(ExdDisplayType exdDisplayType) {
        return exdDisplayType.name();
    }

    public short getValue() {
        return this.value;
    }
}
