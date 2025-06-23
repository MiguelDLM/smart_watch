package com.baidu.navisdk.util.logic;

/* loaded from: classes8.dex */
public class b {
    private static b b;

    /* renamed from: a, reason: collision with root package name */
    private boolean f9317a = false;

    private b() {
    }

    public static synchronized b b() {
        b bVar;
        synchronized (b.class) {
            try {
                if (b == null) {
                    b = new b();
                }
                bVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public boolean a() {
        return this.f9317a;
    }
}
