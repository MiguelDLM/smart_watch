package com.garmin.fit;

/* loaded from: classes9.dex */
public enum RadarThreatLevelType {
    THREAT_UNKNOWN(0),
    THREAT_NONE(1),
    THREAT_APPROACHING(2),
    THREAT_APPROACHING_FAST(3),
    INVALID(255);

    protected short value;

    RadarThreatLevelType(short s) {
        this.value = s;
    }

    public static RadarThreatLevelType getByValue(Short sh) {
        for (RadarThreatLevelType radarThreatLevelType : values()) {
            if (sh.shortValue() == radarThreatLevelType.value) {
                return radarThreatLevelType;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(RadarThreatLevelType radarThreatLevelType) {
        return radarThreatLevelType.name();
    }

    public short getValue() {
        return this.value;
    }
}
