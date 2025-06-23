package com.baidu.platform.comapi.wnplatform.f;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f9913a;
    private String b;
    private String c;

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f9913a == null) {
                    f9913a = new a();
                }
                aVar = f9913a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }
}
