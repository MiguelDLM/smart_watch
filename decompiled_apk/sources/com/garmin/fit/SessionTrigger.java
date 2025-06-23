package com.garmin.fit;

/* loaded from: classes9.dex */
public enum SessionTrigger {
    ACTIVITY_END(0),
    MANUAL(1),
    AUTO_MULTI_SPORT(2),
    FITNESS_EQUIPMENT(3),
    INVALID(255);

    protected short value;

    SessionTrigger(short s) {
        this.value = s;
    }

    public static SessionTrigger getByValue(Short sh) {
        for (SessionTrigger sessionTrigger : values()) {
            if (sh.shortValue() == sessionTrigger.value) {
                return sessionTrigger;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(SessionTrigger sessionTrigger) {
        return sessionTrigger.name();
    }

    public short getValue() {
        return this.value;
    }
}
