package com.baidu.platform.core.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.building.BuildingSearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.base.e;

/* loaded from: classes8.dex */
public class c extends e {
    public c(BuildingSearchOption buildingSearchOption) {
        a(buildingSearchOption);
    }

    private void a(BuildingSearchOption buildingSearchOption) {
        if (buildingSearchOption == null) {
            return;
        }
        LatLng latLng = buildingSearchOption.getLatLng();
        if (latLng != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            this.f9530a.a("latitude", latLng.latitude + "");
            this.f9530a.a("longitude", latLng.longitude + "");
        }
        this.f9530a.a("coord_type", "bd09ll");
        this.f9530a.a(TypedValues.TransitionType.S_FROM, "android_map_sdk");
        this.f9530a.a("output", "json");
        this.f9530a.a("data_set", "building");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.v();
    }
}
