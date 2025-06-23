package com.bytedance.sdk.openadsdk.api.plugin.c;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.JProtect;
import java.security.SecureRandom;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class b {
    @JProtect
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String a2 = a();
        String a3 = a(a2, 32);
        String b = b();
        return 3 + a2 + b + ((a3 == null || b == null) ? null : a.a(str, b, a3));
    }

    public static String b() {
        String a2 = a(8);
        if (a2 == null || a2.length() != 16) {
            return null;
        }
        return a2;
    }

    private static SecureRandom c() {
        SecureRandom instanceStrong;
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                instanceStrong = SecureRandom.getInstanceStrong();
                return instanceStrong;
            } catch (Throwable unused) {
                return new SecureRandom();
            }
        }
        return new SecureRandom();
    }

    @JProtect
    public static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String a2 = a(jSONObject.toString());
                if (!TextUtils.isEmpty(a2)) {
                    jSONObject2.put("message", a2);
                    jSONObject2.put("cypher", 3);
                } else {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            jSONObject2.put("message", jSONObject.toString());
            jSONObject2.put("cypher", 0);
        }
        return jSONObject2;
    }

    public static String a() {
        String a2 = a(16);
        if (a2 == null || a2.length() != 32) {
            return null;
        }
        return a2;
    }

    public static String a(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    public static String a(int i) {
        try {
            byte[] bArr = new byte[i];
            c().nextBytes(bArr);
            return c.a(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
