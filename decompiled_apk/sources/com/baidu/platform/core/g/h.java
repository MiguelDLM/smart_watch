package com.baidu.platform.core.g;

import com.baidu.mapapi.search.share.LocationShareURLOption;
import com.baidu.mapapi.search.share.OnGetShareUrlResultListener;
import com.baidu.mapapi.search.share.PoiDetailShareURLOption;
import com.baidu.mapapi.search.share.RouteShareURLOption;
import com.baidu.platform.base.SearchType;

/* loaded from: classes8.dex */
public class h extends com.baidu.platform.base.a implements a {
    OnGetShareUrlResultListener b = null;

    @Override // com.baidu.platform.core.g.a
    public boolean a(PoiDetailShareURLOption poiDetailShareURLOption) {
        f fVar = new f();
        fVar.a(SearchType.POI_DETAIL_SHARE);
        return a(new c(poiDetailShareURLOption), this.b, fVar);
    }

    @Override // com.baidu.platform.core.g.a
    public boolean a(LocationShareURLOption locationShareURLOption) {
        f fVar = new f();
        fVar.a(SearchType.LOCATION_SEARCH_SHARE);
        return a(new b(locationShareURLOption), this.b, fVar);
    }

    @Override // com.baidu.platform.core.g.a
    public boolean a(RouteShareURLOption routeShareURLOption) {
        d dVar = new d();
        dVar.a(SearchType.ROUTE_PLAN_SHARE);
        return a(new e(routeShareURLOption), this.b, dVar);
    }

    @Override // com.baidu.platform.core.g.a
    public void a(OnGetShareUrlResultListener onGetShareUrlResultListener) {
        this.f9526a.lock();
        this.b = onGetShareUrlResultListener;
        this.f9526a.unlock();
    }

    @Override // com.baidu.platform.core.g.a
    public void a() {
        this.f9526a.lock();
        this.b = null;
        this.f9526a.unlock();
    }
}
