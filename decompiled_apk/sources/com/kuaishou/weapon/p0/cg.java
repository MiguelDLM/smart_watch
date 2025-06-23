package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import org.apache.log4j.spi.LocationInfo;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class cg {
    public static void a(final Context context, String str, String str2, boolean z) {
        JSONObject jSONObject;
        try {
            String str3 = cu.f18366a + cu.f;
            String a2 = cv.a(context);
            if (!TextUtils.isEmpty(a2)) {
                if (cu.a() && str2 != null) {
                    str3 = str3 + "?logId=" + str2 + "&" + a2;
                } else {
                    str3 = str3 + LocationInfo.NA + a2;
                }
            }
            String str4 = str3;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (z) {
                jSONObject = new JSONObject();
                String c = new bn(context).c(str);
                if (!TextUtils.isEmpty(c)) {
                    jSONObject.put("data", c);
                }
            } else {
                jSONObject = new JSONObject(str);
            }
            n.a().a(new k(context, WeaponHI.cookieData, WeaponHI.encryENV, str4, jSONObject, new j() { // from class: com.kuaishou.weapon.p0.cg.1
                @Override // com.kuaishou.weapon.p0.j
                public final void a(String str5) {
                    cg.a(context, str5);
                }

                @Override // com.kuaishou.weapon.p0.j
                public final void b(String str5) {
                }
            }));
        } catch (Exception unused) {
        }
    }

    public static void a(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("result", 0) == 1) {
                JSONObject jSONObject2 = new JSONObject(new bn(context).a(jSONObject.getString("dataRsp")));
                String string = jSONObject2.getString("conjure");
                if (jSONObject2.getInt("status") == 1) {
                    bx.a(context, string);
                    bx.b(context, string);
                }
            }
        } catch (Exception unused) {
        }
    }
}
