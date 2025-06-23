package com.jd.ad.sdk.jad_gp;

import android.annotation.TargetApi;
import android.os.SystemClock;

/* loaded from: classes10.dex */
public final class jad_jt {
    public static final double jad_an = 1.0d / Math.pow(10.0d, 6.0d);

    public static double jad_an(long j) {
        return (jad_an() - j) * jad_an;
    }

    @TargetApi(17)
    public static long jad_an() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
