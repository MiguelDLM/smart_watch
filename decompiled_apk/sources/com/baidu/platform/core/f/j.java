package com.baidu.platform.core.f;

import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.IndoorRoutePlanOption;
import com.baidu.mapapi.search.route.MassTransitRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.platform.base.SearchType;

/* loaded from: classes8.dex */
public class j extends com.baidu.platform.base.a implements e {
    private OnGetRoutePlanResultListener b = null;

    @Override // com.baidu.platform.core.f.e
    public void a(OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        this.f9526a.lock();
        this.b = onGetRoutePlanResultListener;
        this.f9526a.unlock();
    }

    @Override // com.baidu.platform.core.f.e
    public boolean a(TransitRoutePlanOption transitRoutePlanOption) {
        m mVar = new m();
        mVar.a(SearchType.TRANSIT_ROUTE);
        return a(new n(transitRoutePlanOption), this.b, mVar);
    }

    @Override // com.baidu.platform.core.f.e
    public boolean a(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        h hVar = new h();
        hVar.a(SearchType.MASS_TRANSIT_ROUTE);
        return a(new i(massTransitRoutePlanOption), this.b, hVar);
    }

    @Override // com.baidu.platform.core.f.e
    public boolean a(WalkingRoutePlanOption walkingRoutePlanOption) {
        o oVar = new o();
        oVar.a(SearchType.WALK_ROUTE);
        return a(new p(walkingRoutePlanOption), this.b, oVar);
    }

    @Override // com.baidu.platform.core.f.e
    public boolean a(IndoorRoutePlanOption indoorRoutePlanOption) {
        f fVar = new f();
        fVar.a(SearchType.INDOOR_ROUTE);
        return a(new g(indoorRoutePlanOption), this.b, fVar);
    }

    @Override // com.baidu.platform.core.f.e
    public boolean a(DrivingRoutePlanOption drivingRoutePlanOption) {
        c cVar = new c();
        cVar.a(SearchType.DRIVE_ROUTE);
        return a(new d(drivingRoutePlanOption), this.b, cVar);
    }

    @Override // com.baidu.platform.core.f.e
    public boolean a(BikingRoutePlanOption bikingRoutePlanOption) {
        a aVar = new a();
        aVar.a(SearchType.BIKE_ROUTE);
        return a(new b(bikingRoutePlanOption), this.b, aVar);
    }

    @Override // com.baidu.platform.core.f.e
    public void a() {
        this.f9526a.lock();
        this.b = null;
        this.f9526a.unlock();
    }
}
