package com.baidu.location.c.a;

import com.baidu.location.c.a.d;
import com.baidu.location.c.k;

/* loaded from: classes7.dex */
class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d.b f5691a;

    public f(d.b bVar) {
        this.f5691a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        d.this.i();
        obj = d.this.n;
        synchronized (obj) {
            try {
                obj2 = d.this.n;
                obj2.notifyAll();
                if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                    k.h().a("WifiScan finished, in callback.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
