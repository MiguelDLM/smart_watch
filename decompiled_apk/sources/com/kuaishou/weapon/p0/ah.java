package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.lang.reflect.Proxy;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class ah {

    /* renamed from: a, reason: collision with root package name */
    private static final String f18304a = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=";
    private final String b = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy";
    private final String c = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl";
    private final String d = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==";
    private final String e = "SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=";

    private void b(JSONObject jSONObject, int i) {
        try {
            Object a2 = dh.a(new String(c.a(f18304a.getBytes(), 2)), (Object) null, "getPackageManager", new Object[0]);
            if (a2 != null) {
                a(a2, jSONObject, i);
            }
        } catch (Exception unused) {
        }
    }

    private void c(JSONObject jSONObject, int i) {
        Object a2;
        Object a3;
        try {
            if (Build.VERSION.SDK_INT >= 29 && (a2 = dh.a(new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==".getBytes(), 2)), new String(c.a("SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=".getBytes(), 2)))) != null && (a3 = dh.a("android.util.Singleton", a2, "get", new Object[0])) != null) {
                a(a3, jSONObject, i);
            }
        } catch (Exception unused) {
        }
    }

    private void d(JSONObject jSONObject, int i) {
        Object a2;
        try {
            Object a3 = dh.a(new String(c.a(f18304a.getBytes(), 2)), (Object) null, "currentActivityThread", new Object[0]);
            if (a3 != null && (a2 = dh.a(a3.getClass(), a3, "mInstrumentation")) != null) {
                a(a2, jSONObject, i);
            }
        } catch (Exception unused) {
        }
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            b(jSONObject, 0);
            a(jSONObject, 1);
            c(jSONObject, 2);
            d(jSONObject, 3);
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private void a(JSONObject jSONObject, int i) {
        Object a2;
        Object a3;
        try {
            String str = new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy".getBytes(), 2));
            String str2 = new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl".getBytes(), 2));
            if (Build.VERSION.SDK_INT >= 26) {
                a2 = dh.a(str, "IActivityManagerSingleton");
            } else {
                a2 = dh.a(str2, "gDefault");
            }
            if (a2 == null || (a3 = dh.a("android.util.Singleton", a2, "get", new Object[0])) == null) {
                return;
            }
            a(a3, jSONObject, i);
        } catch (Exception unused) {
        }
    }

    private boolean a(Object obj, JSONObject jSONObject, int i) {
        if (jSONObject != null) {
            try {
                boolean isProxyClass = Proxy.isProxyClass(obj.getClass());
                String name = obj.getClass().getName();
                if (isProxyClass) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    jSONObject.put(sb.toString(), isProxyClass ? 1 : 0);
                    jSONObject.put(i + "-c", name);
                } else if (i == 3 && !name.contains("Instrumentation")) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i);
                    jSONObject.put(sb2.toString(), isProxyClass ? 1 : 0);
                    jSONObject.put(i + "-c", name);
                }
                return isProxyClass;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            PackageManager packageManager = context.getPackageManager();
            Object a2 = dh.a(packageManager.getClass(), packageManager, "mPM");
            if (a2 == null) {
                return null;
            }
            if (a(a2, jSONObject, 0)) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
