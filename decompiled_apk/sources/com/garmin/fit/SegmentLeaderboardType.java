package com.garmin.fit;

/* loaded from: classes9.dex */
public enum SegmentLeaderboardType {
    OVERALL(0),
    PERSONAL_BEST(1),
    CONNECTIONS(2),
    GROUP(3),
    CHALLENGER(4),
    KOM(5),
    QOM(6),
    PR(7),
    GOAL(8),
    CARROT(9),
    CLUB_LEADER(10),
    RIVAL(11),
    LAST(12),
    RECENT_BEST(13),
    COURSE_RECORD(14),
    INVALID(255);

    protected short value;

    SegmentLeaderboardType(short s) {
        this.value = s;
    }

    public static SegmentLeaderboardType getByValue(Short sh) {
        for (SegmentLeaderboardType segmentLeaderboardType : values()) {
            if (sh.shortValue() == segmentLeaderboardType.value) {
                return segmentLeaderboardType;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(SegmentLeaderboardType segmentLeaderboardType) {
        return segmentLeaderboardType.name();
    }

    public short getValue() {
        return this.value;
    }
}
