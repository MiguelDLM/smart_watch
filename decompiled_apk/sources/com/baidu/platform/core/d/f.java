package com.baidu.platform.core.d;

import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.baidu.mapapi.search.poi.PoiIndoorOption;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.platform.base.SearchType;

/* loaded from: classes8.dex */
public class f extends com.baidu.platform.base.a implements a {
    private OnGetPoiSearchResultListener b = null;

    @Override // com.baidu.platform.core.d.a
    public boolean a(PoiNearbySearchOption poiNearbySearchOption) {
        g gVar = new g(poiNearbySearchOption.mPageNum, poiNearbySearchOption.mPageCapacity);
        gVar.a(SearchType.POI_NEAR_BY_SEARCH);
        return a(new i(poiNearbySearchOption), this.b, gVar);
    }

    @Override // com.baidu.platform.core.d.a
    public boolean a(PoiCitySearchOption poiCitySearchOption) {
        g gVar = new g(poiCitySearchOption.mPageNum, poiCitySearchOption.mPageCapacity);
        gVar.a(SearchType.POI_IN_CITY_SEARCH);
        return a(new i(poiCitySearchOption), this.b, gVar);
    }

    @Override // com.baidu.platform.core.d.a
    public boolean a(PoiBoundSearchOption poiBoundSearchOption) {
        g gVar = new g(poiBoundSearchOption.mPageNum, poiBoundSearchOption.mPageCapacity);
        gVar.a(SearchType.POI_IN_BOUND_SEARCH);
        return a(new i(poiBoundSearchOption), this.b, gVar);
    }

    @Override // com.baidu.platform.core.d.a
    public boolean a(PoiDetailSearchOption poiDetailSearchOption) {
        d dVar = new d();
        if (poiDetailSearchOption != null) {
            dVar.a(poiDetailSearchOption.isSearchByUids());
        }
        dVar.a(SearchType.POI_DETAIL_SEARCH);
        return a(new e(poiDetailSearchOption), this.b, dVar);
    }

    @Override // com.baidu.platform.core.d.a
    public boolean a(PoiIndoorOption poiIndoorOption) {
        b bVar = new b();
        bVar.a(SearchType.INDOOR_POI_SEARCH);
        return a(new c(poiIndoorOption), this.b, bVar);
    }

    @Override // com.baidu.platform.core.d.a
    public void a(OnGetPoiSearchResultListener onGetPoiSearchResultListener) {
        this.f9526a.lock();
        this.b = onGetPoiSearchResultListener;
        this.f9526a.unlock();
    }

    @Override // com.baidu.platform.core.d.a
    public void a() {
        this.f9526a.lock();
        this.b = null;
        this.f9526a.unlock();
    }
}
