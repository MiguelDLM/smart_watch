package com.baidu.platform.comapi.wnplatform;

/* loaded from: classes8.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private int f9911a;
    private int b;
    private int c;
    private boolean d;
    private int e;

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        static final f f9912a = new f();
    }

    public static f a() {
        return a.f9912a;
    }

    public boolean b() {
        return (this.b & 1) == 1;
    }

    public boolean c() {
        return (this.b & 2) == 2;
    }

    public boolean d() {
        if ((this.b & 4) == 4) {
            return true;
        }
        return false;
    }

    public int e() {
        return this.b;
    }

    public boolean f() {
        if ((this.b & 16) == 16) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f9911a == 0) {
            return true;
        }
        return false;
    }

    public boolean h() {
        int i = this.f9911a;
        if (i == 1 || i == 2) {
            return true;
        }
        return false;
    }

    public int i() {
        return this.c;
    }

    public boolean j() {
        return this.d;
    }

    private f() {
        this.e = 0;
    }

    public void a(int i) {
        this.b = i;
        if (a().j()) {
            return;
        }
        this.b &= -5;
    }

    public void b(int i) {
        this.f9911a = i;
    }

    public void c(int i) {
        this.c = i;
    }

    public void a(boolean z) {
        this.d = z;
        com.baidu.platform.comapi.walknavi.b.a().K().c(z);
    }
}
