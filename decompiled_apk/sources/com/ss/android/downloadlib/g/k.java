package com.ss.android.downloadlib.g;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public class k {
    public static void a(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.k r = com.ss.android.downloadlib.addownload.k.r();
        if (r != null) {
            r.a(2, str, str2, jSONObject);
        }
    }

    public static void b(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.k r = com.ss.android.downloadlib.addownload.k.r();
        if (r != null) {
            r.a(3, str, str2, jSONObject);
        }
    }

    public static void c(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.k r = com.ss.android.downloadlib.addownload.k.r();
        if (r != null) {
            r.a(6, str, str2, jSONObject);
        }
    }

    public static void a(String str, String str2) {
        c(str, str2, null);
    }

    public static void a(String str) {
        c(null, str, null);
    }
}
