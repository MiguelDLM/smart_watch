package com.garmin.fit;

/* loaded from: classes9.dex */
public enum SegmentDeleteStatus {
    DO_NOT_DELETE(0),
    DELETE_ONE(1),
    DELETE_ALL(2),
    INVALID(255);

    protected short value;

    SegmentDeleteStatus(short s) {
        this.value = s;
    }

    public static SegmentDeleteStatus getByValue(Short sh) {
        for (SegmentDeleteStatus segmentDeleteStatus : values()) {
            if (sh.shortValue() == segmentDeleteStatus.value) {
                return segmentDeleteStatus;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(SegmentDeleteStatus segmentDeleteStatus) {
        return segmentDeleteStatus.name();
    }

    public short getValue() {
        return this.value;
    }
}
