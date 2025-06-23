package com.iflytek.sparkchain.core;

/* loaded from: classes10.dex */
public enum AiEvent implements Const {
    EVENT_UNKNOWN(0),
    EVENT_START(1),
    EVENT_END(2),
    EVENT_TIMEOUT(3),
    EVENT_PROGRESS(4);

    private final int value;

    AiEvent(int i) {
        this.value = i;
    }

    public static AiEvent valueOf(int i) {
        if (i == 0) {
            return EVENT_UNKNOWN;
        }
        if (i == 1) {
            return EVENT_START;
        }
        if (i == 2) {
            return EVENT_END;
        }
        if (i == 3) {
            return EVENT_TIMEOUT;
        }
        if (i == 4) {
            return EVENT_PROGRESS;
        }
        return null;
    }

    @Override // com.iflytek.sparkchain.core.Const
    public int getValue() {
        return this.value;
    }
}
