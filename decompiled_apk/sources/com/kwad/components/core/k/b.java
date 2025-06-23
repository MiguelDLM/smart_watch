package com.kwad.components.core.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.e.c;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class b {
    public static boolean al(Context context) {
        boolean z;
        if (context == null) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_local_ad_force_active", 0);
        a aVar = new a();
        if (sharedPreferences.contains("ksadsdk_local_ad_force_active_data")) {
            String string = sharedPreferences.getString("ksadsdk_local_ad_force_active_data", null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    aVar.parseJson(new JSONObject(string));
                } catch (Exception e) {
                    c.printStackTraceOnly(e);
                }
            }
            z = aVar.j(d.CR(), d.CS());
            c.d("LocalAdForceActiveHelper", "addCount contains success: " + z);
        } else {
            c.d("LocalAdForceActiveHelper", "addCount not contains");
            aVar.ph();
            z = true;
        }
        if (z) {
            sharedPreferences.edit().putString("ksadsdk_local_ad_force_active_data", aVar.toJson().toString()).apply();
        }
        return z;
    }
}
