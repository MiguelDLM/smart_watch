package com.baidu.platform.core.f;

import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.szabh.smable3.entity.Languages;

/* loaded from: classes8.dex */
public class p extends com.baidu.platform.base.e {
    public p(WalkingRoutePlanOption walkingRoutePlanOption) {
        a(walkingRoutePlanOption);
    }

    private void a(WalkingRoutePlanOption walkingRoutePlanOption) {
        this.f9530a.a("qt", "walk2");
        this.f9530a.a("sn", a(walkingRoutePlanOption.mFrom));
        this.f9530a.a(Languages.DEFAULT_LANGUAGE, a(walkingRoutePlanOption.mTo));
        PlanNode planNode = walkingRoutePlanOption.mFrom;
        if (planNode != null) {
            this.f9530a.a("sc", planNode.getCity());
        }
        PlanNode planNode2 = walkingRoutePlanOption.mTo;
        if (planNode2 != null) {
            this.f9530a.a("ec", planNode2.getCity());
        }
        this.f9530a.a("ie", "utf-8");
        this.f9530a.a("lrn", "20");
        this.f9530a.a("version", "3");
        this.f9530a.a("rp_format", "json");
        this.f9530a.a("rp_filter", "mobile");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.k();
    }
}
