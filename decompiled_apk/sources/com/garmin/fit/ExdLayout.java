package com.garmin.fit;

/* loaded from: classes9.dex */
public enum ExdLayout {
    FULL_SCREEN(0),
    HALF_VERTICAL(1),
    HALF_HORIZONTAL(2),
    HALF_VERTICAL_RIGHT_SPLIT(3),
    HALF_HORIZONTAL_BOTTOM_SPLIT(4),
    FULL_QUARTER_SPLIT(5),
    HALF_VERTICAL_LEFT_SPLIT(6),
    HALF_HORIZONTAL_TOP_SPLIT(7),
    DYNAMIC(8),
    INVALID(255);

    protected short value;

    ExdLayout(short s) {
        this.value = s;
    }

    public static ExdLayout getByValue(Short sh) {
        for (ExdLayout exdLayout : values()) {
            if (sh.shortValue() == exdLayout.value) {
                return exdLayout;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(ExdLayout exdLayout) {
        return exdLayout.name();
    }

    public short getValue() {
        return this.value;
    }
}
