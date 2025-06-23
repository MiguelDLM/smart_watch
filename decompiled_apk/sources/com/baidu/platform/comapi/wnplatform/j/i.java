package com.baidu.platform.comapi.wnplatform.j;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;
import com.baidu.mapapi.walknavi.params.WalkNaviLaunchParam;
import com.baidu.mapapi.walknavi.params.WalkRouteNodeInfo;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class i implements com.baidu.platform.comapi.wnplatform.c.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WalkNaviLaunchParam f9927a;
    final /* synthetic */ IWRoutePlanListener b;
    final /* synthetic */ h c;

    public i(h hVar, WalkNaviLaunchParam walkNaviLaunchParam, IWRoutePlanListener iWRoutePlanListener) {
        this.c = hVar;
        this.f9927a = walkNaviLaunchParam;
        this.b = iWRoutePlanListener;
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.b
    public void a(WLocData wLocData) {
        LatLng a2 = com.baidu.platform.comapi.walknavi.b.a().X().a(wLocData);
        if (a2 == null) {
            return;
        }
        com.baidu.platform.comapi.walknavi.b.a().X().b(this);
        WalkRouteNodeInfo walkRouteNodeInfo = new WalkRouteNodeInfo();
        walkRouteNodeInfo.setLocation(a2);
        this.f9927a.startNodeInfo(walkRouteNodeInfo);
        if (this.c.a(this.f9927a)) {
            IWRoutePlanListener iWRoutePlanListener = this.b;
            if (iWRoutePlanListener != null) {
                iWRoutePlanListener.onRoutePlanFail(WalkRoutePlanError.DISTANCE_LESS_THAN_30M);
                return;
            }
            return;
        }
        if (this.c.b(this.f9927a)) {
            IWRoutePlanListener iWRoutePlanListener2 = this.b;
            if (iWRoutePlanListener2 != null) {
                iWRoutePlanListener2.onRoutePlanFail(WalkRoutePlanError.DISTANCE_MORE_THAN_50KM);
                return;
            }
            return;
        }
        this.c.a(this.f9927a, this.b, true);
    }
}
