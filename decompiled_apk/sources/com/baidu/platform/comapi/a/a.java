package com.baidu.platform.comapi.a;

import com.baidu.platform.comapi.logstatistics.d;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static a f9535a;
    private static JSONObject b;
    private d c = null;

    public static a a() {
        if (f9535a == null) {
            f9535a = new a();
        }
        if (b == null) {
            b = new JSONObject();
        }
        return f9535a;
    }

    private void b() {
        b = null;
        b = new JSONObject();
    }

    public synchronized boolean a(String str) {
        boolean z;
        try {
            if (this.c == null) {
                this.c = d.a();
            }
            if (this.c != null) {
                JSONObject jSONObject = b;
                if (jSONObject != null && jSONObject.length() > 0) {
                    z = this.c.a(1100, 1, str, b.toString());
                } else {
                    z = this.c.a(1100, 1, str, (String) null);
                }
                b();
            } else {
                z = false;
            }
        } catch (Throwable th) {
            throw th;
        }
        return z;
    }
}
