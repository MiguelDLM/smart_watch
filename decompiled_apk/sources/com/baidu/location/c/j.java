package com.baidu.location.c;

import com.baidu.location.b.ah;
import com.baidu.location.b.an;
import com.baidu.location.b.x;
import com.baidu.location.c.h;

/* loaded from: classes7.dex */
class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f5709a;
    final /* synthetic */ h.b b;

    public j(h.b bVar, boolean z) {
        this.b = bVar;
        this.f5709a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = h.this.l;
        if (!z) {
            h.this.l = this.f5709a;
        }
        x.c().i();
        if (System.currentTimeMillis() - ah.b() <= 5000) {
            an.a().c();
        }
    }
}
