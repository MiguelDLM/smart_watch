package com.huawei.openalliance.ad.media;

import XXO0.oIX0oI;

@com.huawei.openalliance.ad.annotations.b
/* loaded from: classes10.dex */
public enum d {
    END(-2),
    ERROR(-1),
    IDLE(0),
    INITIALIZED(1),
    PREPARING(2),
    PREPARED(3),
    PLAYING(4),
    PAUSED(5),
    PLAYBACK_COMPLETED(6);

    int L;

    d(int i) {
        this.L = i;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int Code() {
        return this.L;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name() + oIX0oI.I0Io.f4096II0xO0 + this.L + oIX0oI.I0Io.f4095I0Io;
    }
}
