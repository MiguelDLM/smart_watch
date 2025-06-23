package com.baidu.platform.comapi.wnplatform.m;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static JSONObject f9934a;
    private static a b;

    private a() {
    }

    public boolean a(String str) {
        return false;
    }

    public static a a() {
        if (b == null) {
            b = new a();
        }
        if (f9934a == null) {
            f9934a = new JSONObject();
        }
        return b;
    }

    public void a(String str, String str2) {
        try {
            f9934a.put(str, str2);
        } catch (JSONException unused) {
        }
    }

    public void a(String str, int i) {
        try {
            f9934a.put(str, Integer.toString(i));
        } catch (JSONException unused) {
        }
    }
}
