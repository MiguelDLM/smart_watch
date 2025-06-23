package com.baidu.platform.comapi.walknavi.h.c;

import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.platform.comapi.walknavi.h.c.c;

/* loaded from: classes8.dex */
class n implements c.InterfaceC0538c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f9786a;

    public n(m mVar) {
        this.f9786a = mVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.h.c.c.InterfaceC0538c
    public void a() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.f9786a.f9785a.ac;
        if (iWNPCLoadAndInitListener != null) {
            iWNPCLoadAndInitListener2 = this.f9786a.f9785a.ac;
            iWNPCLoadAndInitListener2.onSuccess();
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.h.c.c.InterfaceC0538c
    public void b() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.f9786a.f9785a.ac;
        if (iWNPCLoadAndInitListener != null) {
            com.baidu.platform.comapi.walknavi.e.e.c().a("");
            this.f9786a.f9785a.b(true);
            com.baidu.platform.comapi.walknavi.b.a().K().a(0, 0);
            this.f9786a.f9785a.u();
            iWNPCLoadAndInitListener2 = this.f9786a.f9785a.ac;
            iWNPCLoadAndInitListener2.onFail();
        }
    }
}
