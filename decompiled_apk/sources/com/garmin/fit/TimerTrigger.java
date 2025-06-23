package com.garmin.fit;

/* loaded from: classes9.dex */
public enum TimerTrigger {
    MANUAL(0),
    AUTO(1),
    FITNESS_EQUIPMENT(2),
    INVALID(255);

    protected short value;

    TimerTrigger(short s) {
        this.value = s;
    }

    public static TimerTrigger getByValue(Short sh) {
        for (TimerTrigger timerTrigger : values()) {
            if (sh.shortValue() == timerTrigger.value) {
                return timerTrigger;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(TimerTrigger timerTrigger) {
        return timerTrigger.name();
    }

    public short getValue() {
        return this.value;
    }
}
