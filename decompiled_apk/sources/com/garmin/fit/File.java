package com.garmin.fit;

/* loaded from: classes9.dex */
public enum File {
    DEVICE(1),
    SETTINGS(2),
    SPORT(3),
    ACTIVITY(4),
    WORKOUT(5),
    COURSE(6),
    SCHEDULES(7),
    WEIGHT(9),
    TOTALS(10),
    GOALS(11),
    BLOOD_PRESSURE(14),
    MONITORING_A(15),
    ACTIVITY_SUMMARY(20),
    MONITORING_DAILY(28),
    MONITORING_B(32),
    SEGMENT(34),
    SEGMENT_LIST(35),
    EXD_CONFIGURATION(40),
    MFG_RANGE_MIN(247),
    MFG_RANGE_MAX(254),
    INVALID(255);

    protected short value;

    File(short s) {
        this.value = s;
    }

    public static File getByValue(Short sh) {
        for (File file : values()) {
            if (sh.shortValue() == file.value) {
                return file;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(File file) {
        return file.name();
    }

    public short getValue() {
        return this.value;
    }
}
