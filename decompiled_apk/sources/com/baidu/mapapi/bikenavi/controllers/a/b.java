package com.baidu.mapapi.bikenavi.controllers.a;

import com.baidu.mapapi.bikenavi.adapter.IBEngineInitListener;

/* loaded from: classes7.dex */
class b implements com.baidu.platform.comapi.walknavi.c.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IBEngineInitListener f5768a;
    final /* synthetic */ a b;

    public b(a aVar, IBEngineInitListener iBEngineInitListener) {
        this.b = aVar;
        this.f5768a = iBEngineInitListener;
    }

    @Override // com.baidu.platform.comapi.walknavi.c.a
    public void a() {
        this.f5768a.engineInitSuccess();
    }

    @Override // com.baidu.platform.comapi.walknavi.c.a
    public void b() {
        this.f5768a.engineInitFail();
    }
}
