package com.baidu.platform.core.c;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mapapi.search.geocode.GeoCodeOption;

/* loaded from: classes8.dex */
public class c extends com.baidu.platform.base.e {
    public c(GeoCodeOption geoCodeOption) {
        a(geoCodeOption);
    }

    private void a(GeoCodeOption geoCodeOption) {
        this.f9530a.a("city", geoCodeOption.mCity);
        this.f9530a.a("address", geoCodeOption.mAddress);
        this.f9530a.a("output", "json");
        this.f9530a.a("ret_coordtype", "bd09ll");
        this.f9530a.a(TypedValues.TransitionType.S_FROM, "android_map_sdk");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.f();
    }
}
