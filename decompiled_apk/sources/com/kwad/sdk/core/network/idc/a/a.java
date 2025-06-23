package com.kwad.sdk.core.network.idc.a;

/* loaded from: classes11.dex */
public final class a {
    private final long axX;
    private volatile boolean axY = false;

    public a(long j, boolean z) {
        this.axX = j;
    }

    public final boolean EI() {
        return this.axY;
    }

    public final long EJ() {
        return this.axX;
    }

    public final a bm(boolean z) {
        this.axY = true;
        return this;
    }
}
