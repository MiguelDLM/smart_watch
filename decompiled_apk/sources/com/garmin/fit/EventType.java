package com.garmin.fit;

/* loaded from: classes9.dex */
public enum EventType {
    START(0),
    STOP(1),
    CONSECUTIVE_DEPRECIATED(2),
    MARKER(3),
    STOP_ALL(4),
    BEGIN_DEPRECIATED(5),
    END_DEPRECIATED(6),
    END_ALL_DEPRECIATED(7),
    STOP_DISABLE(8),
    STOP_DISABLE_ALL(9),
    INVALID(255);

    protected short value;

    EventType(short s) {
        this.value = s;
    }

    public static EventType getByValue(Short sh) {
        for (EventType eventType : values()) {
            if (sh.shortValue() == eventType.value) {
                return eventType;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(EventType eventType) {
        return eventType.name();
    }

    public short getValue() {
        return this.value;
    }
}
