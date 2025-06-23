package com.baidu.platform.comapi.walknavi.e.a.c;

import com.baidu.platform.comapi.walknavi.e.a.a.b;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class a {
    public static b a(JSONObject jSONObject) {
        b bVar = new b();
        try {
            if (jSONObject.has("err_code")) {
                bVar.a(jSONObject.getInt("err_code"));
            }
            if (jSONObject.has("err_msg")) {
                bVar.a(jSONObject.getString("err_msg"));
            }
            if (jSONObject.has("ret")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("ret");
                if (jSONObject2.has("ar_key")) {
                    bVar.b(jSONObject2.getString("ar_key"));
                }
                if (jSONObject2.has("ar_resource")) {
                    bVar.c(jSONObject2.getString("ar_resource"));
                }
                if (jSONObject2.has("ar_resource_urls")) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("ar_resource_urls");
                    String[] strArr = new String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr[i] = jSONArray.getString(i);
                    }
                    bVar.a(strArr);
                }
                if (jSONObject2.has("redirect_url")) {
                    bVar.d(jSONObject2.getString("redirect_url"));
                }
                if (jSONObject2.has("version_code")) {
                    bVar.e(jSONObject2.getString("version_code"));
                }
                if (jSONObject2.has("ar_type")) {
                    bVar.b(Integer.parseInt(jSONObject2.getString("ar_type")));
                }
                if (jSONObject2.has("md5")) {
                    bVar.f(jSONObject2.getString("md5"));
                }
                if (jSONObject2.has("hardware_satisfied")) {
                    bVar.b(jSONObject2.getBoolean("hardware_satisfied"));
                }
                if (jSONObject2.has("ac_id")) {
                    bVar.g(jSONObject2.getString("ac_id"));
                }
                if (jSONObject2.has("refused")) {
                    if (Integer.parseInt(jSONObject2.getString("refused")) == 1) {
                        bVar.a(true);
                    } else {
                        bVar.a(false);
                    }
                }
                bVar.h(jSONObject2.optString("ar_code_url"));
            }
        } catch (Exception unused) {
        }
        return bVar;
    }
}
