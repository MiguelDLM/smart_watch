package com.baidu.mshield.x6.d;

import android.content.Context;

/* loaded from: classes7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static volatile f f6434a;
    public final Context b;
    public final Runnable c = new g(this);

    public f(Context context) {
        this.b = context;
    }

    public final void b(Context context) {
        try {
            if (com.baidu.mshield.b.a.d.b(context)) {
                com.baidu.mshield.b.c.a.a(" doDelayWork ");
                com.baidu.mshield.x6.a.b bVar = new com.baidu.mshield.x6.a.b(context);
                if (!com.baidu.mshield.x6.e.f.c().equals(bVar.l())) {
                    i.a(context).a(1, true);
                }
                if (!bVar.h() && !i.b) {
                    i.a(context).a(4);
                }
            }
        } catch (Throwable th) {
            com.baidu.mshield.x6.e.f.a(th);
        }
    }

    public static f a(Context context) {
        if (f6434a == null) {
            synchronized (f.class) {
                try {
                    if (f6434a == null) {
                        f6434a = new f(context);
                    }
                } finally {
                }
            }
        }
        return f6434a;
    }

    public synchronized void a(long j) {
        try {
            com.baidu.mshield.b.c.a.a("startCheckDelayTime=" + j);
            com.baidu.mshield.x6.e.c.b().postDelayed(this.c, j);
        } finally {
        }
    }
}
