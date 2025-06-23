package com.baidu.navisdk.module.abtest.model;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.util.common.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public abstract class j extends com.baidu.navisdk.comapi.statistics.f {
    protected com.baidu.navisdk.module.statistics.abtest.a j;
    private int k;
    private boolean l;
    private int m;
    private int n;
    private boolean o;

    public j(com.baidu.navisdk.module.statistics.abtest.a aVar) {
        super(com.baidu.navisdk.comapi.statistics.b.f());
        this.k = 0;
        this.l = false;
        this.m = 0;
        this.n = -1;
        this.o = false;
        this.j = aVar;
    }

    private void s() {
        String str;
        if (q()) {
            b("event_id", n() + "");
            b("plan", o() + "");
            if (p()) {
                str = "1";
            } else {
                str = "0";
            }
            b("real_time_analyze", str);
            a(false);
        }
    }

    public void a(Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(h(), "initABTestStatData-> " + bundle);
        }
        this.n = bundle.getInt("plan", -1);
        this.l = bundle.getBoolean("statisticSwitch", false);
        int i = bundle.getInt("statisticType", 0);
        this.m = i;
        this.k = i == 1 ? 0 : 3;
        this.o = bundle.getInt("realTimeAnalyze", 0) == 1;
        c(bundle);
        b(bundle);
        s();
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public void b(int i) {
        super.b(i);
        this.j.o(n());
    }

    public abstract void b(Bundle bundle);

    public void c(Bundle bundle) {
        JSONObject jSONObject;
        String str = "";
        if (bundle != null && bundle.containsKey("strContentJson")) {
            str = bundle.getString("strContentJson", "");
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            if (LogUtil.LOGGABLE) {
                LogUtil.e("ABTestData", "parseConfig,e:" + e);
            }
            jSONObject = null;
        }
        a(jSONObject, n());
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String d() {
        return "60001";
    }

    public void e(String str, String str2) {
        b(str, str2);
        a(false);
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public int i() {
        return this.k;
    }

    public abstract int n();

    public int o() {
        return this.n;
    }

    public boolean p() {
        return this.o;
    }

    public boolean q() {
        return this.l;
    }

    public void r() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(h(), "onDataUpdate");
        }
    }

    public void d(String str, String str2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(h(), "addStatistics->key:" + str + ", value:" + str2);
        }
        if (q()) {
            e(str, str2);
        }
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String c() {
        return d() + "_" + n() + "";
    }

    public void a(JSONObject jSONObject, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ABTestData", "parseConfig,eventId:" + i + ",curIdJsonObject:" + jSONObject);
        }
    }

    public void a(String str, Object obj) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(h(), "addStatistics->key:" + str + ", value:" + obj);
        }
        if (q()) {
            e(str, "" + obj);
        }
    }
}
