package com.baidu.mapapi.search.share;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.n;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.share.RouteShareURLOption;
import com.baidu.platform.core.g.h;

/* loaded from: classes7.dex */
public class ShareUrlSearch extends n {
    private boolean b = false;

    /* renamed from: a, reason: collision with root package name */
    com.baidu.platform.core.g.a f5997a = new h();

    private boolean a(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static ShareUrlSearch newInstance() {
        BMapManager.init();
        return new ShareUrlSearch();
    }

    public void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.f5997a.a();
        BMapManager.destroy();
    }

    public boolean requestLocationShareUrl(LocationShareURLOption locationShareURLOption) {
        com.baidu.platform.core.g.a aVar = this.f5997a;
        if (aVar != null) {
            if (locationShareURLOption != null && locationShareURLOption.mLocation != null && locationShareURLOption.mName != null && locationShareURLOption.mSnippet != null) {
                return aVar.a(locationShareURLOption);
            }
            throw new IllegalArgumentException("BDMapSDKException: option or name or snippet  can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: searcher has been destroyed");
    }

    public boolean requestPoiDetailShareUrl(PoiDetailShareURLOption poiDetailShareURLOption) {
        com.baidu.platform.core.g.a aVar = this.f5997a;
        if (aVar != null) {
            if (poiDetailShareURLOption != null && poiDetailShareURLOption.mUid != null) {
                return aVar.a(poiDetailShareURLOption);
            }
            throw new IllegalArgumentException("BDMapSDKException: option or uid can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: searcher has been destroyed");
    }

    public boolean requestRouteShareUrl(RouteShareURLOption routeShareURLOption) {
        if (this.f5997a != null) {
            if (routeShareURLOption != null) {
                if (routeShareURLOption.getmMode().ordinal() < 0) {
                    return false;
                }
                PlanNode planNode = routeShareURLOption.mFrom;
                if (planNode != null && routeShareURLOption.mTo != null) {
                    if (routeShareURLOption.mMode == RouteShareURLOption.RouteShareMode.BUS_ROUTE_SHARE_MODE) {
                        if ((planNode.getLocation() == null || routeShareURLOption.mTo.getLocation() == null) && routeShareURLOption.mCityCode < 0) {
                            throw new IllegalArgumentException("BDMapSDKException: city code can not be null if don't set start or end point");
                        }
                    } else {
                        if (planNode.getLocation() == null && !a(routeShareURLOption.mFrom.getCity())) {
                            throw new IllegalArgumentException("BDMapSDKException: start cityCode must be set if not set start location");
                        }
                        if (routeShareURLOption.mTo.getLocation() == null && !a(routeShareURLOption.mTo.getCity())) {
                            throw new IllegalArgumentException("BDMapSDKException: end cityCode must be set if not set end location");
                        }
                    }
                    return this.f5997a.a(routeShareURLOption);
                }
                throw new IllegalArgumentException("BDMapSDKException: start or end point can not be null");
            }
            throw new IllegalArgumentException("BDMapSDKException: option is null");
        }
        throw new IllegalStateException("BDMapSDKException: searcher has been destroyed");
    }

    public void setOnGetShareUrlResultListener(OnGetShareUrlResultListener onGetShareUrlResultListener) {
        com.baidu.platform.core.g.a aVar = this.f5997a;
        if (aVar != null) {
            if (onGetShareUrlResultListener != null) {
                aVar.a(onGetShareUrlResultListener);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: searcher has been destroyed");
    }
}
