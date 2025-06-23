package com.kwad.framework.filedownloader;

import android.os.SystemClock;
import com.kwad.framework.filedownloader.s;

/* loaded from: classes11.dex */
public final class b implements s.a, s.b {
    private long aeA;
    private long aeB;
    private int aeC;
    private int aeD = 1000;
    private long aez;
    private long mStartTime;

    @Override // com.kwad.framework.filedownloader.s.b
    public final void N(long j) {
        if (this.aeD <= 0) {
            return;
        }
        if (this.aez != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.aez;
            if (uptimeMillis >= this.aeD || (this.aeC == 0 && uptimeMillis > 0)) {
                int i = (int) ((j - this.aeA) / uptimeMillis);
                this.aeC = i;
                this.aeC = Math.max(0, i);
            } else {
                return;
            }
        }
        this.aeA = j;
        this.aez = SystemClock.uptimeMillis();
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void end(long j) {
        if (this.mStartTime <= 0) {
            return;
        }
        long j2 = j - this.aeB;
        this.aez = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.mStartTime;
        if (uptimeMillis <= 0) {
            this.aeC = (int) j2;
        } else {
            this.aeC = (int) (j2 / uptimeMillis);
        }
    }

    @Override // com.kwad.framework.filedownloader.s.a
    public final int getSpeed() {
        return this.aeC;
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void reset() {
        this.aeC = 0;
        this.aez = 0L;
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void start(long j) {
        this.mStartTime = SystemClock.uptimeMillis();
        this.aeB = j;
    }
}
