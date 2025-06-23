package com.baidu.navisdk.behavrules.action;

import com.facebook.internal.NativeProtocol;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f6636a;
    private String b;

    public a(com.baidu.navisdk.behavrules.a aVar) {
    }

    public static a a(String str, com.baidu.navisdk.behavrules.a aVar) {
        a aVar2 = new a(aVar);
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar2.f6636a = jSONObject.optString("order", null);
            aVar2.b = jSONObject.optString(NativeProtocol.WEB_DIALOG_PARAMS);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return aVar2;
    }

    public String b() {
        return this.b;
    }

    public String a() {
        return this.f6636a;
    }
}
