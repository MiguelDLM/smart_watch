package com.baidu.platform.core.b;

import com.baidu.mapapi.search.district.DistrictSearchOption;

/* loaded from: classes8.dex */
public class a extends com.baidu.platform.base.e {
    public a(DistrictSearchOption districtSearchOption) {
        a(districtSearchOption);
    }

    private void a(DistrictSearchOption districtSearchOption) {
        if (districtSearchOption == null) {
            return;
        }
        this.f9530a.a("qt", "con");
        this.f9530a.a("rp_format", "json");
        this.f9530a.a("rp_filter", "mobile");
        this.f9530a.a("area_res", "true");
        this.f9530a.a("addr_identify", "1");
        this.f9530a.a("ie", "utf-8");
        this.f9530a.a("pn", "0");
        this.f9530a.a("rn", "10");
        this.f9530a.a("c", districtSearchOption.mCityName);
        String str = districtSearchOption.mDistrictName;
        if (str != null && !str.equals("")) {
            this.f9530a.a("wd", districtSearchOption.mDistrictName);
        } else {
            this.f9530a.a("wd", districtSearchOption.mCityName);
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.n();
    }
}
