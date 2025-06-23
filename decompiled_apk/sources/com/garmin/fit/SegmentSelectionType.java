package com.garmin.fit;

/* loaded from: classes9.dex */
public enum SegmentSelectionType {
    STARRED(0),
    SUGGESTED(1),
    INVALID(255);

    protected short value;

    SegmentSelectionType(short s) {
        this.value = s;
    }

    public static SegmentSelectionType getByValue(Short sh) {
        for (SegmentSelectionType segmentSelectionType : values()) {
            if (sh.shortValue() == segmentSelectionType.value) {
                return segmentSelectionType;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(SegmentSelectionType segmentSelectionType) {
        return segmentSelectionType.name();
    }

    public short getValue() {
        return this.value;
    }
}
