package com.baidu.mshield.x6.d;

import android.content.Context;

/* loaded from: classes7.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static i f6437a = null;
    public static volatile boolean b = false;
    public static volatile boolean c = false;
    public static int d;
    public Context e;

    public i(Context context) {
        this.e = context;
    }

    public void b() {
        try {
            com.baidu.mshield.x6.e.a.c.a().a(new n(this));
        } catch (Throwable th) {
            com.baidu.mshield.x6.e.f.a(th);
        }
    }

    public void a() {
        try {
            com.baidu.mshield.x6.e.a.c.a().a(new k(this));
        } catch (Throwable th) {
            com.baidu.mshield.x6.e.f.a(th);
        }
    }

    public static synchronized i a(Context context) {
        i iVar;
        synchronized (i.class) {
            try {
                if (f6437a == null) {
                    f6437a = new i(context);
                }
                iVar = f6437a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }

    public void a(int i, boolean z) {
        try {
            if (c) {
                return;
            }
            c = true;
            com.baidu.mshield.x6.a.b bVar = new com.baidu.mshield.x6.a.b(this.e);
            if (!z && com.baidu.mshield.x6.e.f.c().equals(bVar.l())) {
                c = false;
            } else {
                com.baidu.mshield.x6.e.a.c.a().a(new j(this, i));
            }
        } catch (Throwable th) {
            c = false;
            com.baidu.mshield.x6.e.f.a(th);
        }
    }

    public void a(int i) {
        try {
            com.baidu.mshield.x6.e.a.c.a().a(new l(this, i));
            a(5, false);
        } catch (Throwable th) {
            com.baidu.mshield.x6.e.f.a(th);
        }
    }

    public void a(int i, int i2) {
        try {
            com.baidu.mshield.x6.e.a.c.a().a(new m(this, i, i2));
            a(5, false);
        } catch (Throwable th) {
            com.baidu.mshield.x6.e.f.a(th);
        }
    }
}
