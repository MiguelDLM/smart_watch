package com.baidu.navisdk.ui.routeguide.model;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class o {
    private a c;
    private RoutePlanNode d;
    private String g;
    private int i;
    private int j;
    public String o;
    public String p;
    private int r;
    private int s;
    private String t;

    /* renamed from: a, reason: collision with root package name */
    private int f8958a = 0;
    private List<String> b = new ArrayList();
    private String e = JarUtils.getResources().getString(R.string.nsdk_indoorpark_more_stall_not_info);
    private int f = 0;
    private String h = "";
    private String k = "";
    private String l = "";
    private boolean m = true;
    private boolean n = false;
    private int q = 0;

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f8959a = "";
        private String b = "";
        private String c = "";
        private String d = "";
        private int e;
        private int f;
        private double g;
        private double h;

        public String a() {
            return this.f8959a;
        }

        public void b(String str) {
            this.f8959a = str;
        }

        public int c() {
            return this.e;
        }

        public void d(String str) {
            this.b = str;
        }

        public String toString() {
            return "IndoorStall{name='" + this.f8959a + "', bID='" + this.b + "', uid='" + this.c + "', floor='" + this.d + "', x=" + this.e + ", y=" + this.f + ", xMC=" + this.g + ", yMC=" + this.h + '}';
        }

        public void a(String str) {
            this.d = str;
        }

        public void b(int i) {
            this.f = i;
        }

        public void c(String str) {
            this.c = str;
        }

        public int d() {
            return this.f;
        }

        public void a(int i) {
            this.e = i;
        }

        public void b(double d) {
            this.h = d;
        }

        public void a(double d) {
            this.g = d;
        }

        public String b() {
            return this.c;
        }

        public static a a(JSONObject jSONObject) {
            a aVar;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGIndoorParkModel", "newInstance->jsonObject=" + jSONObject.toString());
            }
            try {
                String string = jSONObject.getString("name");
                String string2 = jSONObject.getString(MapBundleKey.MapObjKey.OBJ_BID);
                String string3 = jSONObject.getString("uid");
                String string4 = jSONObject.getString("floor");
                float f = (float) jSONObject.getDouble("x");
                float f2 = (float) jSONObject.getDouble("y");
                aVar = new a();
                try {
                    aVar.a(f);
                    aVar.b(f2);
                    Bundle b = com.baidu.navisdk.util.common.o.b((int) f, (int) f2);
                    if (b != null) {
                        if (gVar.d()) {
                            gVar.e("RGIndoorParkModel", "newInstance->location=" + b.toString());
                        }
                        aVar.a(b.getInt("LLx"));
                        aVar.b(b.getInt("LLy"));
                    }
                    aVar.d(string2);
                    aVar.c(string3);
                    aVar.b(string);
                    aVar.a(string4);
                } catch (JSONException e) {
                    e = e;
                    com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar2.d()) {
                        e.printStackTrace();
                        gVar2.e("RGIndoorParkModel", "newInstance->exception=" + e.toString());
                    }
                    return aVar;
                }
            } catch (JSONException e2) {
                e = e2;
                aVar = null;
            }
            return aVar;
        }
    }

    public void a(RoutePlanNode routePlanNode) {
        this.d = routePlanNode;
    }

    public void b(String str) {
        this.g = str;
    }

    public RoutePlanNode c() {
        return this.d;
    }

    public void d(int i) {
        this.i = i;
    }

    public void e(int i) {
        this.j = i;
    }

    public String f() {
        return this.g;
    }

    public void g(String str) {
        this.t = str;
    }

    public String h() {
        return this.l;
    }

    public int i() {
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (fVar != null && fVar.g() != null) {
            return fVar.g().getParkType();
        }
        return -1;
    }

    public List<String> j() {
        return this.b;
    }

    public String k() {
        if (this.m) {
            return this.k;
        }
        return this.l;
    }

    public int l() {
        return this.q;
    }

    public String m() {
        return this.p;
    }

    public String n() {
        try {
            return new JSONObject(this.o).optString("indoorpark_ext", null);
        } catch (Exception unused) {
            return null;
        }
    }

    public int o() {
        return this.i;
    }

    public int p() {
        return this.j;
    }

    public String q() {
        return this.t;
    }

    public boolean r() {
        List<String> list = this.b;
        if (list != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean s() {
        if (this.q == 0) {
            return true;
        }
        return false;
    }

    public boolean t() {
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (fVar != null && fVar.g() != null) {
            return com.baidu.navisdk.util.common.h.c(fVar.g().getParkType());
        }
        return false;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("RGIndoorParkModel{type=");
        sb.append(this.f8958a);
        sb.append(", floorList=");
        sb.append(this.b);
        sb.append(", cardText='");
        sb.append(this.e);
        sb.append('\'');
        sb.append(", action=");
        sb.append(this.f);
        sb.append(", curFloor='");
        sb.append(this.g);
        sb.append('\'');
        sb.append(", mainBid='");
        sb.append(this.h);
        sb.append('\'');
        sb.append(", parkTotal=");
        sb.append(this.i);
        sb.append(", parkleft=");
        sb.append(this.j);
        sb.append(", mNaviMode=");
        sb.append(this.q);
        sb.append(", mEndNodeParkType=");
        sb.append(this.r);
        sb.append(", curStall=");
        a aVar = this.c;
        String str2 = null;
        if (aVar != null) {
            str = aVar.toString();
        } else {
            str = null;
        }
        sb.append(str);
        sb.append(", \n\tbeforeEndNode=");
        RoutePlanNode routePlanNode = this.d;
        if (routePlanNode != null) {
            str2 = routePlanNode.toString();
        }
        sb.append(str2);
        sb.append('}');
        return sb.toString();
    }

    public boolean u() {
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (fVar != null && fVar.g() != null) {
            return com.baidu.navisdk.util.common.h.d(fVar.g().getParkType());
        }
        return false;
    }

    public boolean v() {
        if (this.q == 1) {
            return true;
        }
        return false;
    }

    public boolean w() {
        if (this.q == 2) {
            return true;
        }
        return false;
    }

    public boolean x() {
        int i = this.q;
        if (i == 2 || i == 1) {
            return true;
        }
        return false;
    }

    public boolean y() {
        return this.m;
    }

    public void z() {
        this.m = false;
    }

    public void a(boolean z) {
        this.n = z;
    }

    public int b() {
        return this.f;
    }

    public void c(String str) {
        this.l = str;
    }

    public String d() {
        return this.e;
    }

    public int e() {
        return this.s;
    }

    public void f(String str) {
        this.k = str;
    }

    public a g() {
        return this.c;
    }

    public void a(int i) {
        this.f = i;
    }

    public void b(int i) {
        this.s = i;
    }

    public void c(int i) {
        this.q = i;
    }

    public void d(String str) {
        this.p = str;
    }

    public void e(String str) {
        this.o = str;
    }

    public void f(int i) {
        this.f8958a = i;
    }

    public void a(String str) {
        this.e = str;
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    public void a(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            a(jSONObject.getJSONArray("floor_inuse"));
            int i = jSONObject.getInt("parktotal");
            int i2 = jSONObject.getInt("parkleft");
            String string = jSONObject.getString("parent_bid");
            String string2 = jSONObject.getString("tts");
            d(i);
            e(i2);
            c(string);
            g(string2);
            a a2 = a.a(jSONObject.getJSONObject("data"));
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGIndoorParkModel", "fillIndoorParkData->model=" + toString());
            }
            if (a2 != null) {
                this.c = a2;
            }
        }
    }

    private void a(JSONArray jSONArray) {
        this.b.clear();
        for (int i = 0; jSONArray != null && i < jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            if (!TextUtils.isEmpty(optString)) {
                this.b.add(optString);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a() {
        /*
            r5 = this;
            boolean r0 = r5.m
            r1 = 1
            if (r0 == 0) goto L12
            com.baidu.navisdk.skyeye.a r0 = com.baidu.navisdk.skyeye.a.n()
            com.baidu.navisdk.util.common.g r2 = com.baidu.navisdk.util.common.g.INDOOR_PARK
            java.lang.String r3 = "start node building_id is null"
            r0.a(r2, r3)
            r0 = 1
            goto L44
        L12:
            boolean r0 = r5.u()
            if (r0 == 0) goto L25
            com.baidu.navisdk.skyeye.a r0 = com.baidu.navisdk.skyeye.a.n()
            com.baidu.navisdk.util.common.g r2 = com.baidu.navisdk.util.common.g.INDOOR_PARK
            java.lang.String r3 = "outdoor park"
            r0.a(r2, r3)
        L23:
            r0 = 1
            goto L37
        L25:
            boolean r0 = r5.r()
            if (r0 == 0) goto L36
            java.lang.String r0 = r5.k()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L36
            goto L23
        L36:
            r0 = 0
        L37:
            if (r0 != 0) goto L44
            com.baidu.navisdk.skyeye.a r2 = com.baidu.navisdk.skyeye.a.n()
            com.baidu.navisdk.util.common.g r3 = com.baidu.navisdk.util.common.g.INDOOR_PARK
            java.lang.String r4 = "indoor floor or bid is null"
            r2.a(r3, r4)
        L44:
            boolean r2 = r5.n
            if (r2 == 0) goto L49
            goto L4a
        L49:
            r1 = r0
        L4a:
            com.baidu.navisdk.util.common.g r0 = com.baidu.navisdk.util.common.g.INDOOR_PARK
            boolean r2 = r0.d()
            if (r2 == 0) goto L9d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "allowEnterIndoorPark->result = "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r3 = ", FloorList="
            r2.append(r3)
            java.util.List<java.lang.String> r3 = r5.b
            int r3 = r3.size()
            r2.append(r3)
            java.lang.String r3 = ", MainBid="
            r2.append(r3)
            java.lang.String r3 = r5.k()
            r2.append(r3)
            java.lang.String r3 = ", ParkType="
            r2.append(r3)
            int r3 = r5.q
            r2.append(r3)
            java.lang.String r3 = ", isOutDoorParkType="
            r2.append(r3)
            boolean r3 = r5.u()
            r2.append(r3)
            java.lang.String r3 = ""
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "RGIndoorParkModel"
            r0.e(r3, r2)
        L9d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.model.o.a():boolean");
    }
}
