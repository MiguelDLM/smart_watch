package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class ch {

    /* renamed from: a, reason: collision with root package name */
    private Context f18352a;
    private int b;

    public ch(Context context, int i) {
        this.f18352a = context;
        this.b = i;
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (h.a(this.f18352a, "re_po_rt").b(df.y, 1) != 1) {
                return null;
            }
            try {
                JSONArray a2 = new x().a(this.f18352a);
                if (a2 != null && a2.length() > 0) {
                    jSONObject.put("10000", a2);
                    jSONObject.put("11301", bh.c(com.kwad.sdk.e.b.Jd().Jc()));
                    jSONObject.put("11302", bh.c(com.kwad.sdk.e.b.Jd().getSdkVersion()));
                    jSONObject.put("11303", bh.c(com.kwad.sdk.e.b.Jd().getAppId()));
                }
            } catch (Throwable unused) {
            }
            return jSONObject;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public String a(String str) {
        JSONObject a2;
        try {
            JSONObject a3 = new cm(str, ck.l).a(this.f18352a);
            if (a3 != null && (a2 = a()) != null && a2.length() != 0) {
                a3.put("module_section", a2);
                return a3.toString();
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
