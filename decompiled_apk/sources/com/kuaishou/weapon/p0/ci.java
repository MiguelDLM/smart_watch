package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class ci {

    /* renamed from: a, reason: collision with root package name */
    private Context f18353a;
    private int b;

    public ci(Context context, int i) {
        this.f18353a = context;
        this.b = i;
    }

    public JSONObject a() {
        long currentTimeMillis;
        JSONObject jSONObject;
        JSONArray a2;
        try {
            currentTimeMillis = System.currentTimeMillis();
            jSONObject = new JSONObject();
        } catch (Throwable unused) {
        }
        if (!WeaponHI.as) {
            return null;
        }
        h a3 = h.a(this.f18353a, "re_po_rt");
        int b = a3.b(df.o, 0);
        boolean e = a3.e("a1_p_s_p_s");
        boolean e2 = a3.e("a1_p_s_p_s_c_b");
        if (b == 1 && ((e || e2) && (a2 = new w(this.f18353a).a(0)) != null)) {
            jSONObject.put("10000", a2);
            try {
                jSONObject.put("11301", bh.c(com.kwad.sdk.e.b.Jd().Jc()));
                jSONObject.put("11302", bh.c(com.kwad.sdk.e.b.Jd().getSdkVersion()));
                jSONObject.put("11303", bh.c(com.kwad.sdk.e.b.Jd().getAppId()));
            } catch (Throwable unused2) {
            }
            jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
            jSONObject.put("11017", jSONObject.toString().length());
            return jSONObject;
        }
        return null;
    }

    public String a(String str) {
        JSONObject a2;
        try {
            JSONObject a3 = new cm(str, ck.l).a(this.f18353a);
            if (a3 == null || (a2 = a()) == null) {
                return null;
            }
            a3.put("module_section", a2);
            return a3.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
