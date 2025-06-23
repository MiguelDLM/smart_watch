package com.baidu.platform.core.f;

import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.PlanNode;
import com.facebook.appevents.codeless.internal.Constants;
import com.szabh.smable3.entity.Languages;
import java.util.List;

/* loaded from: classes8.dex */
public class d extends com.baidu.platform.base.e {
    public d(DrivingRoutePlanOption drivingRoutePlanOption) {
        a(drivingRoutePlanOption);
    }

    private void a(DrivingRoutePlanOption drivingRoutePlanOption) {
        this.f9530a.a("qt", "cars");
        this.f9530a.a("sy", drivingRoutePlanOption.mPolicy.getInt() + "");
        this.f9530a.a("ie", "utf-8");
        this.f9530a.a("lrn", "20");
        this.f9530a.a("version", "6");
        this.f9530a.a(Constants.EXTINFO, "32");
        this.f9530a.a("mrs", "1");
        this.f9530a.a("rp_format", "json");
        this.f9530a.a("rp_filter", "mobile");
        this.f9530a.a("route_traffic", drivingRoutePlanOption.mtrafficPolicy.getInt() + "");
        this.f9530a.a("sn", a(drivingRoutePlanOption.mFrom));
        this.f9530a.a(Languages.DEFAULT_LANGUAGE, a(drivingRoutePlanOption.mTo));
        String str = drivingRoutePlanOption.mCityName;
        if (str != null) {
            this.f9530a.a("c", str);
        }
        PlanNode planNode = drivingRoutePlanOption.mFrom;
        if (planNode != null) {
            this.f9530a.a("sc", planNode.getCity());
        }
        PlanNode planNode2 = drivingRoutePlanOption.mTo;
        if (planNode2 != null) {
            this.f9530a.a("ec", planNode2.getCity());
        }
        List<PlanNode> list = drivingRoutePlanOption.mWayPoints;
        String str2 = new String();
        String str3 = new String();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                PlanNode planNode3 = list.get(i);
                if (planNode3 != null) {
                    str2 = str2 + a(planNode3);
                    str3 = str3 + planNode3.getCity();
                    if (i != list.size() - 1) {
                        str3 = str3 + "|";
                        str2 = str2 + "|";
                    }
                }
            }
            this.f9530a.a("wp", str2);
            this.f9530a.a("wpc", str3);
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.i();
    }
}
