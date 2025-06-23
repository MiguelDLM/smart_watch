package com.baidu.platform.core.h;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.base.e;
import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* loaded from: classes8.dex */
public class d extends e {
    public d(SuggestionSearchOption suggestionSearchOption) {
        a(suggestionSearchOption);
    }

    private void a(SuggestionSearchOption suggestionSearchOption) {
        this.f9530a.a("query", suggestionSearchOption.mKeyword);
        this.f9530a.a(TtmlNode.TAG_REGION, suggestionSearchOption.mCity);
        if (suggestionSearchOption.mLocation != null) {
            LatLng latLng = suggestionSearchOption.mLocation;
            LatLng latLng2 = new LatLng(latLng.latitude, latLng.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng2 = CoordTrans.gcjToBaidu(latLng2);
            }
            this.f9530a.a("location", latLng2.latitude + "," + latLng2.longitude);
        }
        if (suggestionSearchOption.mCityLimit.booleanValue()) {
            this.f9530a.a("city_limit", "true");
        } else {
            this.f9530a.a("city_limit", "false");
        }
        this.f9530a.a(TypedValues.TransitionType.S_FROM, "android_map_sdk");
        this.f9530a.a("output", "json");
        this.f9530a.a("extensions_adcode", suggestionSearchOption.isExtendAdcode() ? "true" : "false");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.d();
    }
}
