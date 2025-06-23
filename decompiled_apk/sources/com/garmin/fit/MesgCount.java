package com.garmin.fit;

/* loaded from: classes9.dex */
public enum MesgCount {
    NUM_PER_FILE(0),
    MAX_PER_FILE(1),
    MAX_PER_FILE_TYPE(2),
    INVALID(255);

    protected short value;

    MesgCount(short s) {
        this.value = s;
    }

    public static MesgCount getByValue(Short sh) {
        for (MesgCount mesgCount : values()) {
            if (sh.shortValue() == mesgCount.value) {
                return mesgCount;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(MesgCount mesgCount) {
        return mesgCount.name();
    }

    public short getValue() {
        return this.value;
    }
}
