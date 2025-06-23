package com.baidu.nplatform.comapi.map;

/* loaded from: classes8.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private c f9512a;

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        static final i f9513a = new i();
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a();

        void a(boolean z);
    }

    public static i d() {
        return b.f9513a;
    }

    public c a() {
        return this.f9512a;
    }

    public void b() {
        if (a() != null) {
            a().a(false);
        }
    }

    public void c() {
        if (a() != null) {
            a().a();
        }
    }

    private i() {
    }
}
