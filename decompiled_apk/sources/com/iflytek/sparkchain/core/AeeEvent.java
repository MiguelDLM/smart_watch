package com.iflytek.sparkchain.core;

@Deprecated
/* loaded from: classes10.dex */
public enum AeeEvent implements Const {
    AEE_EVENT_UNKNOWN(0),
    AEE_EVENT_START(1),
    AEE_EVENT_END(2),
    AEE_EVENT_TIMEOUT(3),
    AEE_EVENT_PROGRESS(4);


    /* renamed from: a, reason: collision with root package name */
    private final int f17441a;

    AeeEvent(int i) {
        this.f17441a = i;
    }

    public static AeeEvent valueOf(int i) {
        if (i == 0) {
            return AEE_EVENT_UNKNOWN;
        }
        if (i == 1) {
            return AEE_EVENT_START;
        }
        if (i == 2) {
            return AEE_EVENT_END;
        }
        if (i == 3) {
            return AEE_EVENT_TIMEOUT;
        }
        if (i == 4) {
            return AEE_EVENT_PROGRESS;
        }
        return null;
    }

    @Override // com.iflytek.sparkchain.core.Const
    public int getValue() {
        return this.f17441a;
    }
}
