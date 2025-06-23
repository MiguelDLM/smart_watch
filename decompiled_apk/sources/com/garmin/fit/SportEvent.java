package com.garmin.fit;

/* loaded from: classes9.dex */
public enum SportEvent {
    UNCATEGORIZED(0),
    GEOCACHING(1),
    FITNESS(2),
    RECREATION(3),
    RACE(4),
    SPECIAL_EVENT(5),
    TRAINING(6),
    TRANSPORTATION(7),
    TOURING(8),
    INVALID(255);

    protected short value;

    SportEvent(short s) {
        this.value = s;
    }

    public static SportEvent getByValue(Short sh) {
        for (SportEvent sportEvent : values()) {
            if (sh.shortValue() == sportEvent.value) {
                return sportEvent;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(SportEvent sportEvent) {
        return sportEvent.name();
    }

    public short getValue() {
        return this.value;
    }
}
