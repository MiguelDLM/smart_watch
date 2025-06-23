package com.garmin.fit;

/* loaded from: classes9.dex */
public enum BacklightMode {
    OFF(0),
    MANUAL(1),
    KEY_AND_MESSAGES(2),
    AUTO_BRIGHTNESS(3),
    SMART_NOTIFICATIONS(4),
    KEY_AND_MESSAGES_NIGHT(5),
    KEY_AND_MESSAGES_AND_SMART_NOTIFICATIONS(6),
    INVALID(255);

    protected short value;

    BacklightMode(short s) {
        this.value = s;
    }

    public static BacklightMode getByValue(Short sh) {
        for (BacklightMode backlightMode : values()) {
            if (sh.shortValue() == backlightMode.value) {
                return backlightMode;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(BacklightMode backlightMode) {
        return backlightMode.name();
    }

    public short getValue() {
        return this.value;
    }
}
