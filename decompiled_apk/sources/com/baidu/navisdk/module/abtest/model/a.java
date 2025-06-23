package com.baidu.navisdk.module.abtest.model;

import android.os.Build;
import android.os.Bundle;
import com.baidu.navisdk.util.common.LogUtil;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a extends j {
    private String p;
    private boolean q;
    private boolean r;
    private int s;

    public a(com.baidu.navisdk.module.statistics.abtest.a aVar) {
        super(aVar);
        this.p = null;
        this.q = false;
        this.r = false;
        this.s = 29;
        x();
    }

    public static boolean v() {
        a w = w();
        if (w != null && w.s()) {
            return true;
        }
        return false;
    }

    public static a w() {
        com.baidu.navisdk.framework.interfaces.a a2 = com.baidu.navisdk.framework.interfaces.c.p().a();
        if (a2 == null) {
            return null;
        }
        return (a) a2.g(14);
    }

    private void x() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-ABARNaviData", "init");
        }
        com.baidu.navisdk.module.statistics.abtest.a aVar = this.j;
        if (aVar != null) {
            a(aVar.e(n()));
        }
    }

    public static boolean y() {
        a w = w();
        if (w != null && w.u()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public void a(JSONObject jSONObject, int i) {
        super.a(jSONObject, i);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("Statistics-ABARNaviData", "parseConfig: " + jSONObject);
        }
        if (jSONObject != null) {
            this.p = jSONObject.toString();
            this.r = jSONObject.optBoolean("enable", false);
            this.q = jSONObject.optBoolean("disable_portrait", false);
            this.s = jSONObject.optInt("min_sdk", this.s);
        }
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public void b(Bundle bundle) {
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String h() {
        return "Statistics-ABARNaviData";
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public int n() {
        return 14;
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public int o() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-ABARNaviData", "plan:" + super.o());
        }
        return super.o();
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public void r() {
        super.r();
        x();
    }

    public boolean s() {
        return this.q;
    }

    public String t() {
        return this.p;
    }

    public boolean u() {
        if (this.r && Build.VERSION.SDK_INT >= this.s) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.module.abtest.model.j, com.baidu.navisdk.comapi.statistics.f
    public void b(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-ABARNaviData", "onEvent");
        }
        super.b(i);
    }
}
