package com.garmin.fit;

/* loaded from: classes9.dex */
public enum PwrZoneCalc {
    CUSTOM(0),
    PERCENT_FTP(1),
    INVALID(255);

    protected short value;

    PwrZoneCalc(short s) {
        this.value = s;
    }

    public static PwrZoneCalc getByValue(Short sh) {
        for (PwrZoneCalc pwrZoneCalc : values()) {
            if (sh.shortValue() == pwrZoneCalc.value) {
                return pwrZoneCalc;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(PwrZoneCalc pwrZoneCalc) {
        return pwrZoneCalc.name();
    }

    public short getValue() {
        return this.value;
    }
}
