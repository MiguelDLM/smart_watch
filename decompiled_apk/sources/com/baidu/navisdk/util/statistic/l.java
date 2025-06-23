package com.baidu.navisdk.util.statistic;

/* loaded from: classes8.dex */
public class l implements com.baidu.navisdk.module.statistics.b {
    private static final String c = "l";
    private static l d;

    /* renamed from: a, reason: collision with root package name */
    private float f9377a;
    private boolean b = false;

    public static synchronized l b() {
        l lVar;
        synchronized (l.class) {
            try {
                if (d == null) {
                    d = new l();
                }
                lVar = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }

    public void a(long j, long j2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float a(int i, int i2) {
        if (i2 != 0) {
            return (i * 100) / i2;
        }
        return 100.0f;
    }
}
