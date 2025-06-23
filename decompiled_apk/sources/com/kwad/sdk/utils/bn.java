package com.kwad.sdk.utils;

import android.os.SystemClock;

/* loaded from: classes11.dex */
public final class bn {
    private long aSb;
    private long aSc;
    private boolean aSd;

    public bn() {
        reset();
    }

    private void reset() {
        this.aSb = 0L;
        this.aSc = -1L;
    }

    public final void Oa() {
        if (this.aSd && this.aSc < 0) {
            this.aSc = SystemClock.elapsedRealtime();
        }
    }

    public final void Ob() {
        if (this.aSd && this.aSc > 0) {
            this.aSb += SystemClock.elapsedRealtime() - this.aSc;
            this.aSc = -1L;
        }
    }

    public final long Oc() {
        if (!this.aSd) {
            return 0L;
        }
        this.aSd = false;
        if (this.aSc > 0) {
            this.aSb += SystemClock.elapsedRealtime() - this.aSc;
            this.aSc = -1L;
        }
        return this.aSb;
    }

    public final long getTime() {
        if (this.aSc > 0) {
            return (this.aSb + SystemClock.elapsedRealtime()) - this.aSc;
        }
        return this.aSb;
    }

    public final void startTiming() {
        reset();
        this.aSd = true;
        this.aSc = SystemClock.elapsedRealtime();
    }
}
