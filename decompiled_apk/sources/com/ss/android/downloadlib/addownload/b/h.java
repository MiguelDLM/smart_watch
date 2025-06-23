package com.ss.android.downloadlib.addownload.b;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static volatile h f25974a;

    private h() {
    }

    public static h a() {
        if (f25974a == null) {
            synchronized (d.class) {
                try {
                    if (f25974a == null) {
                        f25974a = new h();
                    }
                } finally {
                }
            }
        }
        return f25974a;
    }

    public void a(int i, int i2, com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(bVar.s());
        if (a2.a("report_api_hijack", 0) == 0) {
            return;
        }
        int i3 = i2 - i;
        if (i <= 0 || i3 <= a2.a("check_api_hijack_version_code_diff", 500)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version_code_diff", i3);
            jSONObject.put("installed_version_code", i2);
            jSONObject.put("hijack_type", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().b("api_hijack", jSONObject, bVar);
    }
}
