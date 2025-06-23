package com.baidu.platform.core.f;

import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.szabh.smable3.entity.Languages;

/* loaded from: classes8.dex */
public class n extends com.baidu.platform.base.e {
    public n(TransitRoutePlanOption transitRoutePlanOption) {
        a(transitRoutePlanOption);
    }

    private void a(TransitRoutePlanOption transitRoutePlanOption) {
        this.f9530a.a("qt", "bus");
        this.f9530a.a("sy", transitRoutePlanOption.mPolicy.getInt() + "");
        this.f9530a.a("ie", "utf-8");
        this.f9530a.a("lrn", "20");
        this.f9530a.a("version", "3");
        this.f9530a.a("rp_format", "json");
        this.f9530a.a("rp_filter", "mobile");
        this.f9530a.a("ic_info", "2");
        this.f9530a.a("exptype", "depall");
        this.f9530a.a("sn", a(transitRoutePlanOption.mFrom));
        this.f9530a.a(Languages.DEFAULT_LANGUAGE, a(transitRoutePlanOption.mTo));
        String str = transitRoutePlanOption.mCityName;
        if (str != null) {
            this.f9530a.a("c", str);
        }
        if (TransitRoutePlanOption.TransitPolicy.EBUS_NO_SUBWAY == transitRoutePlanOption.mPolicy) {
            this.f9530a.a(com.baidu.mapsdkplatform.comapi.f.f6163a, "[0,2,4,7,5,8,9,10,11]");
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.h();
    }
}
