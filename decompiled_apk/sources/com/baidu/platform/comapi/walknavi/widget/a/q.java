package com.baidu.platform.comapi.walknavi.widget.a;

/* loaded from: classes8.dex */
class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f9873a;

    public q(p pVar) {
        this.f9873a = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.h.b bVar;
        com.baidu.platform.comapi.walknavi.h.b bVar2;
        com.baidu.platform.comapi.walknavi.h.b bVar3;
        bVar = this.f9873a.f9872a.e;
        if (bVar != null) {
            bVar2 = this.f9873a.f9872a.e;
            bVar2.b(3, false);
            bVar3 = this.f9873a.f9872a.e;
            bVar3.b(true);
        }
    }
}
