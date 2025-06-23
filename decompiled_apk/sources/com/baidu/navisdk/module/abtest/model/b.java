package com.baidu.navisdk.module.abtest.model;

import android.os.Bundle;

/* loaded from: classes7.dex */
public class b extends j {
    public b(com.baidu.navisdk.module.statistics.abtest.a aVar) {
        super(aVar);
        Bundle e;
        if (aVar != null && (e = aVar.e(9)) != null && e.containsKey("plan")) {
            a(e);
        }
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public void b(Bundle bundle) {
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String h() {
        return "Statistics-ABCarHomeData";
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public int n() {
        return 9;
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public int o() {
        int o = super.o();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.AB_TEST;
        if (gVar.d()) {
            gVar.e("Statistics-ABCarHomeData", "getPlan --> plan = " + o);
        }
        return o;
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public void r() {
        super.r();
        com.baidu.navisdk.module.statistics.abtest.a aVar = this.j;
        if (aVar != null) {
            a(aVar.e(9));
        }
    }
}
