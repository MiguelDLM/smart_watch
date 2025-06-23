package com.baidu.ar;

import android.content.Context;
import android.os.Vibrator;

/* loaded from: classes7.dex */
public class ad {
    private static ad fQ;
    long[] fP = {800, 60, 400, 60};
    private Vibrator fR;

    private ad(Context context) {
        this.fR = (Vibrator) context.getSystemService("vibrator");
    }

    public static synchronized ad b(Context context) {
        ad adVar;
        synchronized (ad.class) {
            try {
                if (fQ == null) {
                    fQ = new ad(context);
                }
                adVar = fQ;
            } catch (Throwable th) {
                throw th;
            }
        }
        return adVar;
    }

    public void a(long j) {
        this.fR.vibrate(j);
    }

    public void a(long[] jArr) {
        this.fR.vibrate(jArr, -1);
    }
}
