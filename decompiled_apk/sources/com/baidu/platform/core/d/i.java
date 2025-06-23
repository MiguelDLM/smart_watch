package com.baidu.platform.core.d;

import android.text.TextUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiFilter;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.sma.smartv3.network.BaiDu;
import com.szabh.smable3.entity.Languages;

/* loaded from: classes8.dex */
public class i extends com.baidu.platform.base.e {
    public i(PoiNearbySearchOption poiNearbySearchOption) {
        a(poiNearbySearchOption);
    }

    private void a(PoiNearbySearchOption poiNearbySearchOption) {
        PoiFilter poiFilter;
        if (poiNearbySearchOption == null) {
            return;
        }
        this.f9530a.a("query", poiNearbySearchOption.mKeyword);
        if (poiNearbySearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.f9530a.a("language", Languages.DEFAULT_LANGUAGE);
        }
        if (poiNearbySearchOption.mLocation != null) {
            LatLng latLng = poiNearbySearchOption.mLocation;
            LatLng latLng2 = new LatLng(latLng.latitude, latLng.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng2 = CoordTrans.gcjToBaidu(latLng2);
            }
            if (latLng2 != null) {
                this.f9530a.a("location", latLng2.latitude + "," + latLng2.longitude);
            }
        }
        this.f9530a.a("radius", poiNearbySearchOption.mRadius + "");
        this.f9530a.a("output", "json");
        this.f9530a.a("extensions_adcode", poiNearbySearchOption.isExtendAdcode() ? "true" : "false");
        this.f9530a.a("page_num", poiNearbySearchOption.mPageNum + "");
        this.f9530a.a(BaiDu.PAGE_SIZE_KEY, poiNearbySearchOption.mPageCapacity + "");
        this.f9530a.a("scope", poiNearbySearchOption.mScope + "");
        this.f9530a.a("tag", poiNearbySearchOption.mTag);
        if (poiNearbySearchOption.mRadiusLimit) {
            this.f9530a.a("radius_limit", "true");
        } else {
            this.f9530a.a("radius_limit", "false");
        }
        if (poiNearbySearchOption.mScope != 2 || (poiFilter = poiNearbySearchOption.mPoiFilter) == null || TextUtils.isEmpty(poiFilter.toString())) {
            return;
        }
        this.f9530a.a("filter", poiNearbySearchOption.mPoiFilter.toString());
    }

    public i(PoiCitySearchOption poiCitySearchOption) {
        a(poiCitySearchOption);
    }

    public i(PoiBoundSearchOption poiBoundSearchOption) {
        a(poiBoundSearchOption);
    }

    private void a(PoiCitySearchOption poiCitySearchOption) {
        PoiFilter poiFilter;
        if (poiCitySearchOption == null) {
            return;
        }
        this.f9530a.a("query", poiCitySearchOption.mKeyword);
        if (poiCitySearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.f9530a.a("language", Languages.DEFAULT_LANGUAGE);
        }
        this.f9530a.a(TtmlNode.TAG_REGION, poiCitySearchOption.mCity);
        this.f9530a.a("output", "json");
        this.f9530a.a("extensions_adcode", poiCitySearchOption.isExtendAdcode() ? "true" : "false");
        this.f9530a.a("page_num", poiCitySearchOption.mPageNum + "");
        this.f9530a.a(BaiDu.PAGE_SIZE_KEY, poiCitySearchOption.mPageCapacity + "");
        this.f9530a.a("scope", poiCitySearchOption.mScope + "");
        this.f9530a.a("tag", poiCitySearchOption.mTag);
        if (poiCitySearchOption.mIsCityLimit) {
            this.f9530a.a("city_limit", "true");
        } else {
            this.f9530a.a("city_limit", "false");
        }
        if (poiCitySearchOption.mScope != 2 || (poiFilter = poiCitySearchOption.mPoiFilter) == null || TextUtils.isEmpty(poiFilter.toString())) {
            return;
        }
        this.f9530a.a("filter", poiCitySearchOption.mPoiFilter.toString());
    }

    private void a(PoiBoundSearchOption poiBoundSearchOption) {
        PoiFilter poiFilter;
        if (poiBoundSearchOption == null) {
            return;
        }
        this.f9530a.a("query", poiBoundSearchOption.mKeyword);
        if (poiBoundSearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.f9530a.a("language", Languages.DEFAULT_LANGUAGE);
        }
        this.f9530a.a("tag", poiBoundSearchOption.mTag);
        LatLngBounds latLngBounds = poiBoundSearchOption.mBound;
        if (latLngBounds != null && latLngBounds.southwest != null && latLngBounds.northeast != null) {
            LatLng latLng = poiBoundSearchOption.mBound.southwest;
            LatLng latLng2 = new LatLng(latLng.latitude, latLng.longitude);
            LatLng latLng3 = poiBoundSearchOption.mBound.northeast;
            LatLng latLng4 = new LatLng(latLng3.latitude, latLng3.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng2 = CoordTrans.gcjToBaidu(latLng2);
                latLng4 = CoordTrans.gcjToBaidu(latLng4);
            }
            if (latLng2 != null && latLng4 != null) {
                this.f9530a.a("bounds", latLng2.latitude + "," + latLng2.longitude + "," + latLng4.latitude + "," + latLng4.longitude);
            }
        }
        this.f9530a.a("output", "json");
        this.f9530a.a("extensions_adcode", poiBoundSearchOption.isExtendAdcode() ? "true" : "false");
        this.f9530a.a("scope", poiBoundSearchOption.mScope + "");
        this.f9530a.a("page_num", poiBoundSearchOption.mPageNum + "");
        this.f9530a.a(BaiDu.PAGE_SIZE_KEY, poiBoundSearchOption.mPageCapacity + "");
        if (poiBoundSearchOption.mScope != 2 || (poiFilter = poiBoundSearchOption.mPoiFilter) == null || TextUtils.isEmpty(poiFilter.toString())) {
            return;
        }
        this.f9530a.a("filter", poiBoundSearchOption.mPoiFilter.toString());
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.a();
    }
}
