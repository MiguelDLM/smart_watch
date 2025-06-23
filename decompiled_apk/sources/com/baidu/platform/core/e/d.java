package com.baidu.platform.core.e;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.recommendstop.RecommendStopSearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.base.e;

/* loaded from: classes8.dex */
public class d extends e {
    public d(RecommendStopSearchOption recommendStopSearchOption) {
        a(recommendStopSearchOption);
    }

    private void a(RecommendStopSearchOption recommendStopSearchOption) {
        if (recommendStopSearchOption != null && recommendStopSearchOption.mLocation != null) {
            LatLng latLng = new LatLng(recommendStopSearchOption.getLocation().latitude, recommendStopSearchOption.getLocation().longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            this.f9530a.a("location", latLng.longitude + "," + latLng.latitude);
            this.f9530a.a("station_info", recommendStopSearchOption.isNeedStationInfo() ? "1" : "0");
        }
        this.f9530a.a("coordtype", "bd09ll");
        this.f9530a.a(TypedValues.TransitionType.S_FROM, "android_map_sdk");
        this.f9530a.a("output", "json");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.u();
    }
}
