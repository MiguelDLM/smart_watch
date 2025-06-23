package com.baidu.navisdk.comapi.trajectory;

/* loaded from: classes7.dex */
public class c {
    private static c c;

    /* renamed from: a, reason: collision with root package name */
    private f f6743a;
    private g b;

    private c() {
        d();
    }

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                c = new c();
            }
        }
        return c;
    }

    private void d() {
        this.f6743a = new f();
        this.b = new g();
    }

    public final f a() {
        return this.f6743a;
    }

    public final g b() {
        return this.b;
    }
}
