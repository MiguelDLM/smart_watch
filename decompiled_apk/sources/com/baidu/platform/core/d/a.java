package com.baidu.platform.core.d;

import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.baidu.mapapi.search.poi.PoiIndoorOption;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;

/* loaded from: classes8.dex */
public interface a {
    void a();

    void a(OnGetPoiSearchResultListener onGetPoiSearchResultListener);

    boolean a(PoiBoundSearchOption poiBoundSearchOption);

    boolean a(PoiCitySearchOption poiCitySearchOption);

    boolean a(PoiDetailSearchOption poiDetailSearchOption);

    boolean a(PoiIndoorOption poiIndoorOption);

    boolean a(PoiNearbySearchOption poiNearbySearchOption);
}
