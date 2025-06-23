package com.baidu.navisdk.module.pronavi.model;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class e {
    private static final String d = "e";

    /* renamed from: a, reason: collision with root package name */
    private int f7465a;
    private String b;
    private String c;

    public void a(int i) {
        this.f7465a = i;
    }

    public String b() {
        return this.b;
    }

    public String toString() {
        return "BNServiceAreaZoneTypeBean{id=" + this.f7465a + ", name='" + this.b + "', config='" + this.c + "'}";
    }

    public String a() {
        return this.c;
    }

    public void b(String str) {
        this.b = str;
    }

    public void a(String str) {
        this.c = str;
    }

    public void a(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            int i = jSONObject.getInt("id");
            String string = jSONObject.getString("name");
            String string2 = jSONObject.getString("config");
            a(i);
            b(string);
            a(string2);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(d, "fillData->model=" + toString());
            }
        }
    }

    public static List<e> a(JSONArray jSONArray) throws Exception {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject != null) {
                e eVar = new e();
                eVar.a(jSONObject);
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }
}
