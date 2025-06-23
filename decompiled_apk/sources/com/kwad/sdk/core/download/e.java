package com.kwad.sdk.core.download;

/* loaded from: classes11.dex */
public final class e {
    private volatile boolean avK = false;

    public final void DR() {
        this.avK = true;
    }

    public final boolean DS() {
        if (!this.avK) {
            return true;
        }
        return false;
    }
}
