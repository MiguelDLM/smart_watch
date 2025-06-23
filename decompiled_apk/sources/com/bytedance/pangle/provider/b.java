package com.bytedance.pangle.provider;

import android.net.Uri;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class b {
    public static String a(String str, String str2, Uri uri) {
        String str3;
        if (str2 == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ContentProviderManager.PLUGIN_PROCESS_NAME, str);
            jSONObject.put("plugin_pkg_name", str2);
            if (uri != null) {
                str3 = uri.toString();
            } else {
                str3 = "";
            }
            jSONObject.put("uri", str3);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }
}
