package com.iflytek.sparkchain.core;

/* loaded from: classes10.dex */
public enum AiStatus implements Const {
    BEGIN(0),
    CONTINUE(1),
    END(2),
    ONCE(3);

    private final int value;

    AiStatus(int i) {
        this.value = i;
    }

    public static AiStatus valueOf(int i) {
        if (i == 0) {
            return BEGIN;
        }
        if (i == 1) {
            return CONTINUE;
        }
        if (i == 2) {
            return END;
        }
        if (i == 3) {
            return ONCE;
        }
        throw new IllegalArgumentException("type not supported");
    }

    @Override // com.iflytek.sparkchain.core.Const
    public int getValue() {
        return this.value;
    }
}
