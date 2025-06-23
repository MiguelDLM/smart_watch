package com.garmin.fit;

/* loaded from: classes9.dex */
public enum HrZoneCalc {
    CUSTOM(0),
    PERCENT_MAX_HR(1),
    PERCENT_HRR(2),
    PERCENT_LTHR(3),
    INVALID(255);

    protected short value;

    HrZoneCalc(short s) {
        this.value = s;
    }

    public static HrZoneCalc getByValue(Short sh) {
        for (HrZoneCalc hrZoneCalc : values()) {
            if (sh.shortValue() == hrZoneCalc.value) {
                return hrZoneCalc;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(HrZoneCalc hrZoneCalc) {
        return hrZoneCalc.name();
    }

    public short getValue() {
        return this.value;
    }
}
