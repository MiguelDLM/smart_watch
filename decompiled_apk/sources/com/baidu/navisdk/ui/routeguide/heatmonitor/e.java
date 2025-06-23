package com.baidu.navisdk.ui.routeguide.heatmonitor;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, a> f8622a = new HashMap();

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f8623a;
        private int b;

        public a() {
        }

        public a(int i, int i2) {
            this.f8623a = i;
            this.b = i2;
        }

        public int a() {
            return this.b;
        }

        public int b() {
            return this.f8623a;
        }
    }

    public static e a(String str) {
        try {
            e eVar = new e();
            JSONObject jSONObject = new JSONObject(str);
            a(jSONObject, eVar, 1);
            a(jSONObject, eVar, 2);
            a(jSONObject, eVar, 3);
            return eVar;
        } catch (JSONException e) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.HEAT_MONITOR;
            if (gVar.d()) {
                gVar.e("RGHMControlModel", "parseFromJson(), json = " + str + " e = " + e);
            }
            e.printStackTrace();
            return null;
        }
    }

    public static e b() {
        e eVar = new e();
        eVar.a().put(1, new a(100, -1));
        eVar.a().put(2, new a(110, -1));
        eVar.a().put(3, new a(120, -1));
        return eVar;
    }

    public static void a(JSONObject jSONObject, e eVar, int i) {
        if (eVar == null) {
            return;
        }
        try {
            if (jSONObject.has(String.valueOf(i))) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(String.valueOf(i));
                a aVar = new a();
                aVar.f8623a = jSONObject2.optInt("temp", -1);
                aVar.b = jSONObject2.optInt("level", -1);
                eVar.f8622a.put(Integer.valueOf(i), aVar);
            }
        } catch (JSONException e) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.HEAT_MONITOR;
            if (gVar.d()) {
                gVar.e("RGHMControlModel", "addItem(), jsonObject = " + jSONObject + " e = " + e);
            }
            e.printStackTrace();
        }
    }

    public Map<Integer, a> a() {
        return this.f8622a;
    }
}
