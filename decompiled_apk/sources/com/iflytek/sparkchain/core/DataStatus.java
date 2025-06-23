package com.iflytek.sparkchain.core;

@Deprecated
/* loaded from: classes10.dex */
public enum DataStatus implements Const {
    BEGIN(0),
    CONTINUE(1),
    END(2),
    ONCE(3);


    /* renamed from: a, reason: collision with root package name */
    private final int f17453a;

    DataStatus(int i) {
        this.f17453a = i;
    }

    public static DataStatus valueOf(int i) {
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
        return this.f17453a;
    }

    public AiStatus next() {
        return AiStatus.valueOf(this.f17453a);
    }
}
