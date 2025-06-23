package com.baidu.navisdk.ugc.https.detail;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f8187a;
    private String b;
    private com.baidu.navisdk.ugc.eventdetails.model.c c;

    public static a a(String str) {
        a c = c();
        try {
            JSONObject jSONObject = new JSONObject(str);
            c.f8187a = jSONObject.getInt("errno");
            c.b = jSONObject.optString("errmsg");
            c.c = com.baidu.navisdk.ugc.eventdetails.model.c.u(jSONObject.getString("data"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static a c() {
        a aVar = new a();
        aVar.f8187a = -1;
        return aVar;
    }

    public int b() {
        return this.f8187a;
    }

    public String toString() {
        return "UgcDetailModel{errno=" + this.f8187a + ", errmsg='" + this.b + "', mData=" + this.c + '}';
    }

    public com.baidu.navisdk.ugc.eventdetails.model.c a() {
        return this.c;
    }
}
