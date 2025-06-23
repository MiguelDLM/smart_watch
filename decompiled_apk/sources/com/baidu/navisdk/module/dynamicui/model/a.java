package com.baidu.navisdk.module.dynamicui.model;

import com.baidu.navisdk.module.dynamicui.i.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public abstract class a<T extends b> {

    /* renamed from: a, reason: collision with root package name */
    String f7165a;
    String b;
    String c;
    T d;

    public T a() {
        return this.d;
    }

    public abstract T a(String str);

    public String b() {
        return this.f7165a;
    }

    public String c() {
        return this.b;
    }

    public void b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f7165a = jSONObject.getString("ui");
            this.b = jSONObject.optString("uiData");
            String optString = jSONObject.optString("style");
            this.c = optString;
            this.d = a(optString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
