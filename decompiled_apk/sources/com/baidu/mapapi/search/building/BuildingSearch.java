package com.baidu.mapapi.search.building;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.n;
import com.baidu.platform.core.a.b;

/* loaded from: classes7.dex */
public class BuildingSearch extends n {
    private boolean b = false;

    /* renamed from: a, reason: collision with root package name */
    private final b f5931a = new b();

    public static BuildingSearch newInstance() {
        BMapManager.init();
        return new BuildingSearch();
    }

    public void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.f5931a.a();
        BMapManager.destroy();
    }

    public boolean requestBuilding(BuildingSearchOption buildingSearchOption) {
        if (this.f5931a != null) {
            if (buildingSearchOption != null && buildingSearchOption.getLatLng() != null) {
                return this.f5931a.a(buildingSearchOption);
            }
            throw new IllegalStateException("BDMapSDKException: option or location can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: BuildingSearch is null, please call newInstance() first.");
    }

    public void setOnGetBuildingSearchResultListener(OnGetBuildingSearchResultListener onGetBuildingSearchResultListener) {
        b bVar = this.f5931a;
        if (bVar != null) {
            if (onGetBuildingSearchResultListener != null) {
                bVar.a(onGetBuildingSearchResultListener);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: BuildingSearch is null, please call newInstance first.");
    }
}
