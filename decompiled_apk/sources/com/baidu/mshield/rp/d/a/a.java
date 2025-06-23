package com.baidu.mshield.rp.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mshield.utility.d;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Context f6382a;

    public a(Context context) {
        this.f6382a = context;
    }

    public boolean a(String str, String str2, String str3) {
        String str4;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        com.baidu.mshield.b.c.a.b("report from" + str3);
        com.baidu.mshield.b.c.a.b("sj-trigger report" + str);
        try {
            if (TextUtils.isEmpty(str2)) {
                str4 = null;
            } else {
                str4 = "&topic=" + str2;
            }
            String str5 = str4;
            String str6 = com.baidu.mshield.utility.a.a(this.f6382a) + "p/1/r";
            com.baidu.mshield.b.c.a.b("sj-trigger report" + str6);
            String a2 = d.a(this.f6382a, str6, str, false, false, str5);
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            return new JSONObject(a2).getInt("response") == 1;
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return true;
        }
    }

    public void a() {
        try {
            JSONObject jSONObject = new JSONObject(d.a(this.f6382a, com.baidu.mshield.utility.a.a(this.f6382a) + "p/1/rs", false, true)).getJSONObject("c");
            com.baidu.mshield.sharedpreferences.a a2 = com.baidu.mshield.sharedpreferences.a.a(this.f6382a);
            int optInt = jSONObject.optInt("n");
            if (optInt > 0) {
                a2.f(optInt);
            }
            int optInt2 = jSONObject.optInt("i");
            if (optInt2 > 0) {
                a2.g(optInt2);
            }
            int optInt3 = jSONObject.optInt("i2");
            if (optInt3 > 0) {
                a2.h(optInt3);
            }
            int optInt4 = jSONObject.optInt(IAdInterListener.AdReqParam.WIDTH);
            if (optInt4 > 0) {
                a2.i(optInt4);
            }
            if (jSONObject.optInt("s1") > 0) {
                a2.m(jSONObject.optInt("s1"));
            }
            int optInt5 = jSONObject.optInt("s2");
            if (optInt5 > 0) {
                a2.n(optInt5);
            }
            int optInt6 = jSONObject.optInt("t");
            if (optInt6 > 0) {
                a2.j(optInt6);
            }
            int optInt7 = jSONObject.optInt("l1");
            if (optInt7 > 0) {
                a2.l(optInt7);
            }
            int optInt8 = jSONObject.optInt("l2");
            if (optInt8 > 0) {
                a2.k(optInt8);
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }
}
