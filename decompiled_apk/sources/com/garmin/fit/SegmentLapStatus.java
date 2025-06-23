package com.garmin.fit;

/* loaded from: classes9.dex */
public enum SegmentLapStatus {
    END(0),
    FAIL(1),
    INVALID(255);

    protected short value;

    SegmentLapStatus(short s) {
        this.value = s;
    }

    public static SegmentLapStatus getByValue(Short sh) {
        for (SegmentLapStatus segmentLapStatus : values()) {
            if (sh.shortValue() == segmentLapStatus.value) {
                return segmentLapStatus;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(SegmentLapStatus segmentLapStatus) {
        return segmentLapStatus.name();
    }

    public short getValue() {
        return this.value;
    }
}
