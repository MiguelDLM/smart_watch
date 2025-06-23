package com.baidu.mapapi.walknavi.controllers.a;

import com.baidu.mapapi.walknavi.adapter.IWEngineInitListener;

/* loaded from: classes7.dex */
class b implements com.baidu.platform.comapi.walknavi.c.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IWEngineInitListener f6030a;
    final /* synthetic */ a b;

    public b(a aVar, IWEngineInitListener iWEngineInitListener) {
        this.b = aVar;
        this.f6030a = iWEngineInitListener;
    }

    @Override // com.baidu.platform.comapi.walknavi.c.a
    public void a() {
        this.f6030a.engineInitSuccess();
    }

    @Override // com.baidu.platform.comapi.walknavi.c.a
    public void b() {
        this.f6030a.engineInitFail();
    }
}
