package com.baidu.platform.comapi.walknavi.widget.a;

/* loaded from: classes8.dex */
class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f9868a;

    public l(k kVar) {
        this.f9868a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.h.b bVar;
        com.baidu.platform.comapi.walknavi.h.b bVar2;
        bVar = this.f9868a.f9867a.e;
        if (bVar != null) {
            bVar2 = this.f9868a.f9867a.e;
            bVar2.b(4, true);
        }
    }
}
