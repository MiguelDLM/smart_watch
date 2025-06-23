package com.kuaishou.weapon.p0;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class cm {

    /* renamed from: a, reason: collision with root package name */
    private String f18357a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;

    public cm(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        this.i = sb.toString();
        this.c = str;
        this.g = str2;
    }

    public static String m() {
        try {
            if (!TextUtils.isEmpty(WeaponHI.skProductName)) {
                return WeaponHI.skProductName;
            }
            return "UNKNOWN_PRODUCT";
        } catch (Exception unused) {
            return "UNKNOWN_PRODUCT";
        }
    }

    private JSONObject n() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("1", this.f18357a);
            jSONObject.put("2", this.b);
            jSONObject.put("3", this.c);
            jSONObject.put("4", this.d);
            jSONObject.put("5", this.e);
            jSONObject.put("6", this.f);
            jSONObject.put("7", this.g);
            jSONObject.put("8", this.h);
            jSONObject.put("9", this.i);
            jSONObject.put("11", this.j);
            jSONObject.put(com.tencent.connect.common.II0xO0.f26834o0IXXIx, this.l);
            jSONObject.put(com.tencent.connect.common.II0xO0.f26825XoIxOXIXo, "com.kuaishou.weapon");
            jSONObject.put(com.tencent.connect.common.II0xO0.f26773OO0, WeaponHI.sKSSdkver);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String a() {
        return this.f18357a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public String h() {
        return this.h;
    }

    public String i() {
        return this.i;
    }

    public String j() {
        return this.j;
    }

    public String k() {
        return this.k;
    }

    public String l() {
        return this.l;
    }

    public void a(String str) {
        this.f18357a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public void d(String str) {
        this.d = str;
    }

    public void e(String str) {
        this.e = str;
    }

    public void f(String str) {
        this.f = str;
    }

    public void g(String str) {
        this.g = str;
    }

    public void h(String str) {
        this.h = str;
    }

    public void i(String str) {
        this.i = str;
    }

    public void j(String str) {
        this.j = str;
    }

    public void k(String str) {
        this.k = str;
    }

    public void l(String str) {
        this.l = str;
    }

    public static String b(Context context) {
        try {
            String str = WeaponHI.sKDeviceId;
            if (!TextUtils.isEmpty(str)) {
                bi.v = 1;
                return str;
            }
        } catch (Exception unused) {
        }
        try {
            h a2 = h.a(context, "re_po_rt");
            boolean e = a2.e("a1_p_s_p_s");
            boolean e2 = a2.e("a1_p_s_p_s_c_b");
            if (e || e2) {
                String str2 = "ANDROID_" + Settings.Secure.getString(context.getContentResolver(), "android_id");
                if (!TextUtils.isEmpty(str2)) {
                    bi.v = 3;
                    return str2;
                }
            }
        } catch (Exception unused2) {
        }
        bi.v = 4;
        return "";
    }

    public JSONObject a(Context context) {
        try {
            a(b(context));
            b(m());
            d(bh.q(context));
            e(bh.r(context));
            f(bh.s(context));
            h("5.3.6");
            j(bt.a(context));
            l(WeaponHI.sKSAppkey);
            return n();
        } catch (Throwable unused) {
            return null;
        }
    }
}
