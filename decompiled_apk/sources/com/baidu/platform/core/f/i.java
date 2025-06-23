package com.baidu.platform.core.f;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.MassTransitRoutePlanOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.sma.smartv3.network.BaiDu;

/* loaded from: classes8.dex */
public class i extends com.baidu.platform.base.e {
    public i(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        a(massTransitRoutePlanOption);
    }

    private void a(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        LatLng location = massTransitRoutePlanOption.mFrom.getLocation();
        if (location != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location = CoordTrans.gcjToBaidu(location);
            }
            this.f9530a.a("origin", location.latitude + "," + location.longitude);
        } else {
            this.f9530a.a("origin", massTransitRoutePlanOption.mFrom.getName());
        }
        if (massTransitRoutePlanOption.mFrom.getCity() != null) {
            this.f9530a.a("origin_region", massTransitRoutePlanOption.mFrom.getCity());
        }
        LatLng location2 = massTransitRoutePlanOption.mTo.getLocation();
        if (location2 == null) {
            this.f9530a.a("destination", massTransitRoutePlanOption.mTo.getName());
        } else {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location2 = CoordTrans.gcjToBaidu(location2);
            }
            this.f9530a.a("destination", location2.latitude + "," + location2.longitude);
        }
        if (massTransitRoutePlanOption.mTo.getCity() != null) {
            this.f9530a.a("destination_region", massTransitRoutePlanOption.mTo.getCity());
        }
        this.f9530a.a("tactics_incity", massTransitRoutePlanOption.mTacticsIncity.getInt() + "");
        this.f9530a.a("tactics_intercity", massTransitRoutePlanOption.mTacticsIntercity.getInt() + "");
        this.f9530a.a("trans_type_intercity", massTransitRoutePlanOption.mTransTypeIntercity.getInt() + "");
        this.f9530a.a("page_index", massTransitRoutePlanOption.mPageIndex + "");
        this.f9530a.a(BaiDu.PAGE_SIZE_KEY, massTransitRoutePlanOption.mPageSize + "");
        this.f9530a.a("coord_type", massTransitRoutePlanOption.mCoordType);
        this.f9530a.a("output", "json");
        this.f9530a.a(TypedValues.TransitionType.S_FROM, "android_map_sdk");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.g();
    }
}
