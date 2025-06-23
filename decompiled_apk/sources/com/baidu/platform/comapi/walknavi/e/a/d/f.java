package com.baidu.platform.comapi.walknavi.e.a.d;

import com.baidu.platform.comapi.walknavi.e.a.d.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f9729a;
    final /* synthetic */ h b;
    final /* synthetic */ b.C0536b c;

    public f(b.C0536b c0536b, boolean z, h hVar) {
        this.c = c0536b;
        this.f9729a = z;
        this.b = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        if (this.f9729a) {
            gVar = b.this.d;
            gVar.b(com.baidu.platform.comapi.walknavi.e.a.g.b.b());
            gVar2 = b.this.d;
            gVar2.a(this.b.f9731a);
        }
        if (!this.c.b()) {
            b.this.a(this.f9729a, true);
        }
    }
}
