package com.ss.android.downloadlib;

/* loaded from: classes11.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static volatile f f26105a;
    private com.ss.android.download.api.config.f b = null;

    private f() {
    }

    public static f a() {
        if (f26105a == null) {
            synchronized (f.class) {
                try {
                    if (f26105a == null) {
                        f26105a = new f();
                    }
                } finally {
                }
            }
        }
        return f26105a;
    }

    public com.ss.android.download.api.config.f b() {
        return this.b;
    }
}
