package com.baidu.mapapi.search.route;

import com.baidu.mapapi.BMapManager;

/* loaded from: classes7.dex */
public class RoutePlanSearch extends com.baidu.mapapi.search.core.n {
    private boolean b = false;

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.platform.core.f.e f5990a = new com.baidu.platform.core.f.j();

    public static RoutePlanSearch newInstance() {
        BMapManager.init();
        return new RoutePlanSearch();
    }

    public boolean bikingSearch(BikingRoutePlanOption bikingRoutePlanOption) {
        PlanNode planNode;
        if (this.f5990a != null) {
            if (bikingRoutePlanOption != null && bikingRoutePlanOption.mTo != null && (planNode = bikingRoutePlanOption.mFrom) != null) {
                if (planNode.getLocation() == null && (bikingRoutePlanOption.mFrom.getName() == null || bikingRoutePlanOption.mFrom.getName().length() <= 0 || bikingRoutePlanOption.mFrom.getCity() == null || bikingRoutePlanOption.mFrom.getCity().length() <= 0)) {
                    throw new IllegalArgumentException("BDMapSDKException: route plan option , origin is illegal");
                }
                if (bikingRoutePlanOption.mTo.getLocation() == null && (bikingRoutePlanOption.mTo.getName() == null || bikingRoutePlanOption.mTo.getName().length() <= 0 || bikingRoutePlanOption.mTo.getCity() == null || bikingRoutePlanOption.mTo.getCity().length() <= 0)) {
                    throw new IllegalArgumentException("BDMapSDKException: route plan option , destination is illegal");
                }
                return this.f5990a.a(bikingRoutePlanOption);
            }
            throw new IllegalArgumentException("BDMapSDKException: route plan option , origin or destination can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
    }

    public void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.f5990a.a();
        BMapManager.destroy();
    }

    public boolean drivingSearch(DrivingRoutePlanOption drivingRoutePlanOption) {
        com.baidu.platform.core.f.e eVar = this.f5990a;
        if (eVar != null) {
            if (drivingRoutePlanOption != null && drivingRoutePlanOption.mTo != null && drivingRoutePlanOption.mFrom != null) {
                return eVar.a(drivingRoutePlanOption);
            }
            throw new IllegalArgumentException("BDMapSDKException: route plan option , origin or destination can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
    }

    public boolean masstransitSearch(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        PlanNode planNode;
        if (this.f5990a != null) {
            if (massTransitRoutePlanOption != null && massTransitRoutePlanOption.mTo != null && (planNode = massTransitRoutePlanOption.mFrom) != null) {
                if (planNode.getLocation() == null && (massTransitRoutePlanOption.mFrom.getName() == null || massTransitRoutePlanOption.mFrom.getCity() == null)) {
                    throw new IllegalArgumentException("BDMapSDKException: route plan option,origin is illegal");
                }
                if (massTransitRoutePlanOption.mTo.getLocation() == null && (massTransitRoutePlanOption.mTo.getName() == null || massTransitRoutePlanOption.mTo.getCity() == null)) {
                    throw new IllegalArgumentException("BDMapSDKException: route plan option,destination is illegal");
                }
                return this.f5990a.a(massTransitRoutePlanOption);
            }
            throw new IllegalArgumentException("BDMapSDKException: route plan option,origin or destination can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
    }

    public void setOnGetRoutePlanResultListener(OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        com.baidu.platform.core.f.e eVar = this.f5990a;
        if (eVar != null) {
            if (onGetRoutePlanResultListener != null) {
                eVar.a(onGetRoutePlanResultListener);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
    }

    public boolean transitSearch(TransitRoutePlanOption transitRoutePlanOption) {
        com.baidu.platform.core.f.e eVar = this.f5990a;
        if (eVar != null) {
            if (transitRoutePlanOption != null && transitRoutePlanOption.mCityName != null && transitRoutePlanOption.mTo != null && transitRoutePlanOption.mFrom != null) {
                return eVar.a(transitRoutePlanOption);
            }
            throw new IllegalArgumentException("BDMapSDKException: route plan option,origin or destination or city can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
    }

    public boolean walkingIndoorSearch(IndoorRoutePlanOption indoorRoutePlanOption) {
        com.baidu.platform.core.f.e eVar = this.f5990a;
        if (eVar != null) {
            if (indoorRoutePlanOption != null && indoorRoutePlanOption.mTo != null && indoorRoutePlanOption.mFrom != null) {
                return eVar.a(indoorRoutePlanOption);
            }
            throw new IllegalArgumentException("BDMapSDKException: option , origin or destination can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
    }

    public boolean walkingSearch(WalkingRoutePlanOption walkingRoutePlanOption) {
        com.baidu.platform.core.f.e eVar = this.f5990a;
        if (eVar != null) {
            if (walkingRoutePlanOption != null && walkingRoutePlanOption.mTo != null && walkingRoutePlanOption.mFrom != null) {
                return eVar.a(walkingRoutePlanOption);
            }
            throw new IllegalArgumentException("BDMapSDKException: option , origin or destination can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
    }
}
