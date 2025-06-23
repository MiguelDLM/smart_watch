package com.baidu.platform.comapi.walknavi.h.c;

import com.baidu.platform.comapi.wnplatform.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class d implements c.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f9776a;

    public d(c cVar) {
        this.f9776a = cVar;
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.b
    public void a() {
        com.baidu.platform.comapi.walknavi.h.b bVar;
        com.baidu.platform.comapi.walknavi.h.b bVar2;
        this.f9776a.c();
        bVar = this.f9776a.n;
        if (bVar instanceof com.baidu.platform.comapi.walknavi.h.b) {
            bVar2 = this.f9776a.n;
            bVar2.e(1);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.b
    public void b() {
    }
}
