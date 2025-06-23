package com.baidu.platform.core.c;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.sma.smartv3.network.BaiDu;
import com.szabh.smable3.entity.Languages;

/* loaded from: classes8.dex */
public class f extends com.baidu.platform.base.e {
    public f(ReverseGeoCodeOption reverseGeoCodeOption) {
        a(reverseGeoCodeOption);
    }

    private void a(ReverseGeoCodeOption reverseGeoCodeOption) {
        if (reverseGeoCodeOption.getLocation() != null) {
            LatLng latLng = new LatLng(reverseGeoCodeOption.getLocation().latitude, reverseGeoCodeOption.getLocation().longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            this.f9530a.a("location", latLng.latitude + "," + latLng.longitude);
        }
        if (reverseGeoCodeOption.getLanguage() == LanguageType.LanguageTypeEnglish) {
            this.f9530a.a("language", Languages.DEFAULT_LANGUAGE);
        }
        this.f9530a.a("coordtype", "bd09ll");
        this.f9530a.a("page_index", String.valueOf(reverseGeoCodeOption.getPageNum()));
        this.f9530a.a(BaiDu.PAGE_SIZE_KEY, String.valueOf(reverseGeoCodeOption.getPageSize()));
        this.f9530a.a("pois", "1");
        this.f9530a.a("extensions_poi", "1");
        this.f9530a.a("extensions_town", "true");
        if (reverseGeoCodeOption.getExtensionsRoad()) {
            this.f9530a.a("extensions_road", "true");
        } else {
            this.f9530a.a("extensions_road", "false");
        }
        String poiType = reverseGeoCodeOption.getPoiType();
        if (!TextUtils.isEmpty(poiType)) {
            this.f9530a.a("poi_types", poiType);
        }
        this.f9530a.a("output", "jsonaes");
        this.f9530a.a(TypedValues.TransitionType.S_FROM, "android_map_sdk");
        this.f9530a.a("latest_admin", String.valueOf(reverseGeoCodeOption.getLatestAdmin()));
        this.f9530a.a("radius", String.valueOf(reverseGeoCodeOption.getRadius()));
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.e();
    }
}
