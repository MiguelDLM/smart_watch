package com.kwad.sdk.utils;

import android.content.Context;
import android.os.PowerManager;
import android.os.SystemClock;

/* loaded from: classes11.dex */
public final class ap {
    private static volatile ap aQF = new ap();
    private volatile boolean aQG;
    private volatile long aQH = 0;
    private volatile PowerManager aQI;

    public static ap MM() {
        return aQF;
    }

    public final boolean cF(Context context) {
        boolean z;
        if (this.aQH > 0 && SystemClock.elapsedRealtime() - this.aQH < 600) {
            return this.aQG;
        }
        if (this.aQI == null && context != null) {
            synchronized (this) {
                try {
                    if (this.aQI == null) {
                        this.aQI = (PowerManager) context.getApplicationContext().getSystemService("power");
                    }
                } finally {
                }
            }
        }
        if (this.aQI != null) {
            z = this.aQI.isInteractive();
        } else {
            z = false;
        }
        this.aQG = z;
        this.aQH = SystemClock.elapsedRealtime();
        return this.aQG;
    }
}
