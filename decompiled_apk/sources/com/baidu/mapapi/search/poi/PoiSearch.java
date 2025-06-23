package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.n;

/* loaded from: classes7.dex */
public class PoiSearch extends n {
    private boolean b = false;

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.platform.core.d.a f5969a = new com.baidu.platform.core.d.f();

    public static PoiSearch newInstance() {
        BMapManager.init();
        return new PoiSearch();
    }

    public void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.f5969a.a();
        BMapManager.destroy();
    }

    public boolean searchInBound(PoiBoundSearchOption poiBoundSearchOption) {
        com.baidu.platform.core.d.a aVar = this.f5969a;
        if (aVar != null) {
            if (poiBoundSearchOption != null && poiBoundSearchOption.mBound != null && poiBoundSearchOption.mKeyword != null) {
                return aVar.a(poiBoundSearchOption);
            }
            throw new IllegalArgumentException("BDMapSDKException: option or bound or keyworld can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
    }

    public boolean searchInCity(PoiCitySearchOption poiCitySearchOption) {
        com.baidu.platform.core.d.a aVar = this.f5969a;
        if (aVar != null) {
            if (poiCitySearchOption != null && poiCitySearchOption.mCity != null && poiCitySearchOption.mKeyword != null) {
                return aVar.a(poiCitySearchOption);
            }
            throw new IllegalArgumentException("BDMapSDKException: option or city or keyworld can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
    }

    public boolean searchNearby(PoiNearbySearchOption poiNearbySearchOption) {
        com.baidu.platform.core.d.a aVar = this.f5969a;
        if (aVar != null) {
            if (poiNearbySearchOption != null && poiNearbySearchOption.mLocation != null && poiNearbySearchOption.mKeyword != null) {
                if (poiNearbySearchOption.mRadius <= 0) {
                    return false;
                }
                return aVar.a(poiNearbySearchOption);
            }
            throw new IllegalArgumentException("BDMapSDKException: option or location or keyworld can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
    }

    public boolean searchPoiDetail(PoiDetailSearchOption poiDetailSearchOption) {
        if (this.f5969a != null) {
            if (poiDetailSearchOption != null && poiDetailSearchOption.getUid() != null) {
                return this.f5969a.a(poiDetailSearchOption);
            }
            throw new IllegalArgumentException("BDMapSDKException: option or uid can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
    }

    public boolean searchPoiIndoor(PoiIndoorOption poiIndoorOption) {
        com.baidu.platform.core.d.a aVar = this.f5969a;
        if (aVar != null) {
            if (poiIndoorOption != null && poiIndoorOption.bid != null && poiIndoorOption.wd != null) {
                return aVar.a(poiIndoorOption);
            }
            throw new IllegalArgumentException("BDMapSDKException: option or indoor bid or keyword can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
    }

    public void setOnGetPoiSearchResultListener(OnGetPoiSearchResultListener onGetPoiSearchResultListener) {
        com.baidu.platform.core.d.a aVar = this.f5969a;
        if (aVar != null) {
            if (onGetPoiSearchResultListener != null) {
                aVar.a(onGetPoiSearchResultListener);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
    }
}
