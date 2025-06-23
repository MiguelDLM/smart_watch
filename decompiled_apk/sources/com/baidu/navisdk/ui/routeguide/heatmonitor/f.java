package com.baidu.navisdk.ui.routeguide.heatmonitor;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.ui.routeguide.heatmonitor.a f8624a = com.baidu.navisdk.ui.routeguide.heatmonitor.a.CLOUND;
    private final a b = new a(this);
    private final Map<Integer, g> c = new HashMap();

    /* loaded from: classes8.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        private int f8625a;
        private int b;
        private int c;
        private int d;
        private boolean e;

        public a(f fVar) {
        }

        public boolean e() {
            return this.e;
        }

        public int b() {
            return this.c;
        }

        public int c() {
            return this.b;
        }

        public int d() {
            return this.d;
        }

        public int a() {
            return this.f8625a;
        }
    }

    public static f a(String str) {
        try {
            f fVar = new f();
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("config");
            if (jSONObject2 != null) {
                fVar.b.f8625a = jSONObject2.getInt("duration");
                fVar.b.b = jSONObject2.getInt("min_fps");
                fVar.b.c = jSONObject2.getInt("space");
                fVar.b.d = jSONObject2.optInt("record_time", 10);
                fVar.b.e = jSONObject2.optBoolean("record_high_trace", false);
            }
            a(fVar, jSONObject, 0);
            a(fVar, jSONObject, 1);
            a(fVar, jSONObject, 2);
            a(fVar, jSONObject, 3);
            return fVar;
        } catch (JSONException e) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.HEAT_MONITOR;
            if (gVar.d()) {
                gVar.e("RGHMModel", "parseFromJson(), json = " + str + " e = " + e);
            }
            e.printStackTrace();
            return null;
        }
    }

    public com.baidu.navisdk.ui.routeguide.heatmonitor.a b() {
        return this.f8624a;
    }

    public Map<Integer, g> c() {
        return this.c;
    }

    private static void a(f fVar, JSONObject jSONObject, int i) {
        if (fVar == null || jSONObject == null) {
            return;
        }
        try {
            fVar.c.put(Integer.valueOf(i), g.a(jSONObject.getString(String.valueOf(i)), fVar));
        } catch (JSONException e) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.HEAT_MONITOR;
            if (gVar.d()) {
                gVar.e("RGHMModel", "addState(), jsonObject = " + jSONObject + " e = " + e);
            }
            e.printStackTrace();
        }
    }

    public a a() {
        return this.b;
    }

    public void a(com.baidu.navisdk.ui.routeguide.heatmonitor.a aVar) {
        this.f8624a = aVar;
    }
}
