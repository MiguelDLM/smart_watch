package com.baidu.platform.comapi.walknavi.widget.a;

/* loaded from: classes8.dex */
class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f9870a;

    public n(m mVar) {
        this.f9870a = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.h.b bVar;
        com.baidu.platform.comapi.walknavi.h.b bVar2;
        bVar = this.f9870a.f9869a.e;
        if (bVar != null) {
            bVar2 = this.f9870a.f9869a.e;
            bVar2.b(5, true);
        }
    }
}
