package com.baidu.navisdk.module.pronavi.model;

import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {
    private static final String f = "a";

    /* renamed from: a, reason: collision with root package name */
    private String f7461a;
    private String b;
    private int c;
    private String d;
    private String e;

    public int a() {
        return this.c;
    }

    public void b(String str) {
        this.d = str;
    }

    public void c(String str) {
        this.e = str;
    }

    public void d(String str) {
        this.f7461a = str;
    }

    public String toString() {
        return "BNParkingLotDetailBean{uid='" + this.f7461a + "', parkType='" + this.b + "', parkLeft=" + this.c + ", pointX='" + this.d + "', pointY='" + this.e + "'}";
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            int i = jSONObject.getInt("parkleft");
            String string = jSONObject.getString("parktype");
            String string2 = jSONObject.getString("point_x");
            String string3 = jSONObject.getString("point_y");
            d(jSONObject.getString("park_uid"));
            a(string);
            a(i);
            b(string2);
            c(string3);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(f, "fillParkLotDetailData->model=" + toString());
            }
        }
    }
}
