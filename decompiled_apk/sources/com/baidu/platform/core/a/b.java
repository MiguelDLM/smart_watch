package com.baidu.platform.core.a;

import com.baidu.mapapi.search.building.BuildingSearchOption;
import com.baidu.mapapi.search.building.OnGetBuildingSearchResultListener;
import com.baidu.platform.base.SearchType;

/* loaded from: classes8.dex */
public class b extends com.baidu.platform.base.a {
    private OnGetBuildingSearchResultListener b;

    public boolean a(BuildingSearchOption buildingSearchOption) {
        a aVar = new a();
        aVar.a(SearchType.BUILDING_SEARCH);
        return a(new c(buildingSearchOption), this.b, aVar);
    }

    public void a(OnGetBuildingSearchResultListener onGetBuildingSearchResultListener) {
        this.f9526a.lock();
        this.b = onGetBuildingSearchResultListener;
        this.f9526a.unlock();
    }

    public void a() {
        this.f9526a.lock();
        this.b = null;
        this.f9526a.unlock();
    }
}
