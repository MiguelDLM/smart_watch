package com.baidu.navisdk.ui.routeguide.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    private final String f8979a = "RGRemainStallModel";

    @oOoXoXO
    private String b;
    private int c;
    private int d;

    @oOoXoXO
    private String e;

    @oOoXoXO
    private List<a> f;

    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @oOoXoXO
        private String f8980a;
        private int b;
        private int c;

        public a(@oOoXoXO String str, int i, int i2) {
            this.f8980a = str;
            this.b = i;
            this.c = i2;
        }

        public final int a() {
            return this.b;
        }

        @oOoXoXO
        public final String b() {
            return this.f8980a;
        }

        public final int c() {
            return this.c;
        }

        @OOXIXo
        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("name: ");
            String str2 = this.f8980a;
            if (str2 != null) {
                str = str2.toString();
            } else {
                str = null;
            }
            sb.append(str);
            sb.append(", left: ");
            sb.append(this.b);
            sb.append(", total: ");
            sb.append(this.c);
            return sb.toString();
        }
    }

    @oOoXoXO
    public final List<a> a() {
        return this.f;
    }

    @oOoXoXO
    public final String b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    @OOXIXo
    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("name: ");
        String str3 = this.b;
        String str4 = null;
        if (str3 != null) {
            str = str3.toString();
        } else {
            str = null;
        }
        sb.append(str);
        sb.append(", park_left: ");
        sb.append(this.c);
        sb.append(", park_total: ");
        sb.append(this.d);
        sb.append(", uid: ");
        String str5 = this.e;
        if (str5 != null) {
            str2 = str5.toString();
        } else {
            str2 = null;
        }
        sb.append(str2);
        sb.append(", area_carport_list: ");
        List<a> list = this.f;
        if (list != null) {
            str4 = list.toString();
        }
        sb.append(str4);
        return sb.toString();
    }

    private final void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(this.f8979a, "fillAreaCarportListInfo-> json is null");
                return;
            }
            return;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("area_carport_list");
        if (jSONArray == null) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e(this.f8979a, "fillAreaCarportListInfo-> jsonArray is null");
                return;
            }
            return;
        }
        this.f = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            IIX0o.oO(jSONObject2, "jsonArray.getJSONObject(i)");
            String string = jSONObject2.getString("name");
            int i2 = jSONObject2.getInt("left");
            int i3 = jSONObject2.getInt("total");
            List<a> list = this.f;
            IIX0o.ooOOo0oXI(list);
            list.add(new a(string, i2, i3));
        }
    }

    public final void a(@oOoXoXO JSONObject jSONObject) {
        if (jSONObject == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(this.f8979a, "fillData-> json is null");
                return;
            }
            return;
        }
        String string = jSONObject.getString("name");
        String string2 = jSONObject.getString("uid");
        int i = jSONObject.getInt("park_left");
        int i2 = jSONObject.getInt("park_total");
        this.b = string;
        this.c = i;
        this.d = i2;
        this.e = string2;
        b(jSONObject);
    }
}
