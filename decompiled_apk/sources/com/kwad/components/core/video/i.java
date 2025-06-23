package com.kwad.components.core.video;

import android.os.SystemClock;
import androidx.annotation.NonNull;

/* loaded from: classes11.dex */
public final class i {
    private volatile boolean VE;
    private long VF;
    private a VG = new a();

    /* loaded from: classes11.dex */
    public static class a {
        private long VH = 0;
        private int VI = 0;

        public final void accumulate(long j) {
            this.VH += j;
            this.VI++;
        }

        public final void reset() {
            this.VH = 0L;
            this.VI = 0;
        }

        public final int sA() {
            return this.VI;
        }

        public final long sB() {
            return this.VH;
        }
    }

    public final void reset() {
        this.VE = false;
        this.VF = 0L;
        this.VG.reset();
    }

    public final void sv() {
        if (this.VE) {
            return;
        }
        this.VE = true;
        this.VF = SystemClock.elapsedRealtime();
        com.kwad.sdk.core.video.a.a.a.eF("videoStartBlock");
    }

    public final void sw() {
        if (this.VE) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.VF;
            this.VG.accumulate(elapsedRealtime);
            this.VE = false;
            com.kwad.sdk.core.video.a.a.a.eF("videoEndBlock");
            com.kwad.sdk.core.video.a.a.a.eF("videoBlockTime_" + elapsedRealtime);
        }
    }

    public final boolean sx() {
        return this.VE;
    }

    @NonNull
    public final a sy() {
        if (this.VE) {
            this.VG.accumulate(SystemClock.elapsedRealtime() - this.VF);
            this.VE = false;
        }
        return this.VG;
    }

    public final long sz() {
        return this.VF;
    }
}
