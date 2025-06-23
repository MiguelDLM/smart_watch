package com.baidu.platform.comapi.wnplatform.j;

import com.baidu.mapapi.bikenavi.adapter.IBRoutePlanListener;
import com.baidu.mapapi.bikenavi.params.BikeNaviLaunchParam;
import com.baidu.mapapi.bikenavi.params.BikeRouteNodeInfo;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class b implements com.baidu.platform.comapi.wnplatform.c.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BikeNaviLaunchParam f9924a;
    final /* synthetic */ IBRoutePlanListener b;
    final /* synthetic */ a c;

    public b(a aVar, BikeNaviLaunchParam bikeNaviLaunchParam, IBRoutePlanListener iBRoutePlanListener) {
        this.c = aVar;
        this.f9924a = bikeNaviLaunchParam;
        this.b = iBRoutePlanListener;
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.b
    public void a(WLocData wLocData) {
        LatLng a2 = com.baidu.platform.comapi.walknavi.b.a().X().a(wLocData);
        if (a2 == null) {
            return;
        }
        com.baidu.platform.comapi.walknavi.b.a().X().b(this);
        BikeRouteNodeInfo bikeRouteNodeInfo = new BikeRouteNodeInfo();
        bikeRouteNodeInfo.setLocation(a2);
        this.f9924a.startNodeInfo(bikeRouteNodeInfo);
        this.c.b(this.f9924a, this.b);
    }
}
