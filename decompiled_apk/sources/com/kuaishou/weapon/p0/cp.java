package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import org.apache.log4j.spi.LocationInfo;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class cp {
    public static void a(Context context, String str) {
        try {
            a(context, str, null, false, true);
        } catch (Throwable unused) {
        }
    }

    public static void a(final Context context, String str, final String str2, final boolean z, boolean z2) {
        JSONObject jSONObject;
        try {
            String str3 = cu.f18366a + cu.e;
            String a2 = cv.a(context);
            if (!TextUtils.isEmpty(a2)) {
                if (cu.a() && str2 != null) {
                    str3 = str3 + "?logId=" + str2 + "&" + a2;
                } else {
                    str3 = str3 + LocationInfo.NA + a2;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (z2) {
                jSONObject = new JSONObject();
                String c = new bn(context).c(str);
                if (!TextUtils.isEmpty(c)) {
                    jSONObject.put("data", c);
                }
            } else {
                jSONObject = new JSONObject(str);
            }
            l a3 = l.a(context);
            m mVar = new m(str3, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            a3.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.cp.1
                @Override // com.kuaishou.weapon.p0.j
                public final void a(String str4) {
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            if (str2.equals(ck.b)) {
                                df.a(context).a(System.currentTimeMillis());
                            } else if (str2.equals(ck.c)) {
                                df.a(context).a(df.bj, System.currentTimeMillis());
                            } else if (str2.equals(ck.d)) {
                                df.a(context).a(df.bi, System.currentTimeMillis());
                            } else if (str2.equals(ck.g)) {
                                df.a(context).a(df.bm, System.currentTimeMillis());
                            } else if (str2.equals(ck.i)) {
                                df.a(context).a(df.bh, System.currentTimeMillis());
                            }
                        } catch (Exception unused) {
                        }
                    }
                }

                @Override // com.kuaishou.weapon.p0.j
                public final void b(String str4) {
                    if (z) {
                        TextUtils.isEmpty(str2);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
