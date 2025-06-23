package com.baidu.mapapi.walknavi.controllers.a;

import com.baidu.mapapi.walknavi.adapter.IWNaviCalcRouteListener;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;
import com.baidu.platform.comapi.wnplatform.j.g;

/* loaded from: classes7.dex */
class e implements g {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IWNaviCalcRouteListener f6033a;
    final /* synthetic */ a b;

    public e(a aVar, IWNaviCalcRouteListener iWNaviCalcRouteListener) {
        this.b = aVar;
        this.f6033a = iWNaviCalcRouteListener;
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void a() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void b() {
        IWNaviCalcRouteListener iWNaviCalcRouteListener = this.f6033a;
        if (iWNaviCalcRouteListener != null) {
            iWNaviCalcRouteListener.onNaviCalcRouteSuccess();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void c() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void a(int i) {
        IWNaviCalcRouteListener iWNaviCalcRouteListener = this.f6033a;
        if (iWNaviCalcRouteListener != null) {
            iWNaviCalcRouteListener.onNaviCalcRouteFail(WalkRoutePlanError.PARSE_FAIL);
        }
    }
}
