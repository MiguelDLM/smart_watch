package com.baidu.platform.comapi.wnplatform.tts;

/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9970a = "d";
    private static d b;
    private boolean c = false;

    private d() {
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            try {
                if (b == null) {
                    b = new d();
                }
                dVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    public synchronized void a(boolean z) {
        com.baidu.platform.comapi.wnplatform.d.a.b(f9970a + "setBusy:" + z);
        this.c = z;
    }
}
