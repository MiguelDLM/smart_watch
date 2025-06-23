package com.baidu.navisdk.module.abtest.model;

import android.os.Bundle;
import com.baidu.navisdk.util.common.LogUtil;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class h extends j {
    private boolean p;

    public h(com.baidu.navisdk.module.statistics.abtest.a aVar) {
        super(aVar);
        this.p = false;
        u();
    }

    public static h t() {
        com.baidu.navisdk.framework.interfaces.a a2 = com.baidu.navisdk.framework.interfaces.c.p().a();
        if (a2 == null) {
            return null;
        }
        return (h) a2.g(16);
    }

    private void u() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-ABNormalHDData", "init");
        }
        com.baidu.navisdk.module.statistics.abtest.a aVar = this.j;
        if (aVar != null) {
            a(aVar.e(n()));
        }
    }

    public static boolean v() {
        h t = t();
        if (t != null && t.s()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public void a(JSONObject jSONObject, int i) {
        super.a(jSONObject, i);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("Statistics-ABNormalHDData", "parseConfig: " + jSONObject);
        }
        if (jSONObject != null) {
            this.p = jSONObject.optBoolean("enable", false);
        }
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public void b(Bundle bundle) {
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String h() {
        return "Statistics-ABNormalHDData";
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public int n() {
        return 16;
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public int o() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-ABNormalHDData", "plan:" + super.o());
        }
        return super.o();
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public void r() {
        super.r();
        u();
    }

    public boolean s() {
        return this.p;
    }

    @Override // com.baidu.navisdk.module.abtest.model.j, com.baidu.navisdk.comapi.statistics.f
    public void b(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-ABNormalHDData", "onEvent");
        }
        super.b(i);
    }
}
