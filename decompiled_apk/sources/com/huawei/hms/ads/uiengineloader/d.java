package com.huawei.hms.ads.uiengineloader;

import android.os.Build;
import android.text.TextUtils;
import com.hihonor.android.os.Build;

/* loaded from: classes10.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final int f17345a = 27;
    private static final String b = "DeviceUtil";

    public static String a(String str) {
        Class<?> cls;
        try {
            if (Build.VERSION.SDK_INT >= 27) {
                try {
                    cls = Class.forName(d() ? "com.hihonor.android.os.SystemPropertiesEx" : "com.huawei.android.os.SystemPropertiesEx");
                } catch (ClassNotFoundException unused) {
                }
                return (String) cls.getMethod("get", String.class).invoke(cls, str);
            }
            cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Throwable th) {
            af.c(b, "getSystemProperties Exception:" + th.getClass().getSimpleName());
            return null;
        }
    }

    private static boolean b() {
        if (a()) {
            return true;
        }
        String a2 = a(com.huawei.hms.ads.dynamic.a.s);
        return !TextUtils.isEmpty(a2) && a2.startsWith(com.huawei.hms.ads.dynamic.a.t);
    }

    private static boolean c() {
        String a2 = a(com.huawei.hms.ads.dynamic.a.s);
        return !TextUtils.isEmpty(a2) && a2.startsWith(com.huawei.hms.ads.dynamic.a.t);
    }

    private static boolean d() {
        try {
            if (!Build.MANUFACTURER.equalsIgnoreCase("HONOR") || Build.VERSION.SDK_INT < 31) {
                return false;
            }
            return Build.VERSION.MAGIC_SDK_INT >= 33;
        } catch (Throwable th) {
            af.d(b, "isHonor6UpPhone Error:" + th.getClass().getSimpleName());
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a() {
        /*
            java.lang.String r0 = "HONOR"
            java.lang.String r1 = "HUAWEI"
            r2 = 0
            java.lang.String r3 = android.os.Build.BRAND     // Catch: java.lang.Throwable -> L25
            boolean r4 = r3.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L25
            r5 = 1
            if (r4 != 0) goto L27
            java.lang.String r4 = android.os.Build.MANUFACTURER     // Catch: java.lang.Throwable -> L25
            boolean r1 = r4.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L25
            if (r1 != 0) goto L27
            boolean r1 = r3.equalsIgnoreCase(r0)     // Catch: java.lang.Throwable -> L25
            if (r1 != 0) goto L27
            boolean r0 = r4.equalsIgnoreCase(r0)     // Catch: java.lang.Throwable -> L25
            if (r0 == 0) goto L23
            goto L27
        L23:
            r0 = 0
            goto L28
        L25:
            r0 = move-exception
            goto L48
        L27:
            r0 = 1
        L28:
            if (r0 != 0) goto L64
            java.lang.String r1 = "com.huawei.android.os.BuildEx$VERSION"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L45
            java.lang.String r3 = "EMUI_SDK_INT"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r3)     // Catch: java.lang.Throwable -> L45
            r3 = 0
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Throwable -> L45
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L45
            int r0 = r1.intValue()     // Catch: java.lang.Throwable -> L45
            if (r0 <= 0) goto L63
            r2 = 1
            goto L63
        L45:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L48:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "isHuaweiPhone Error:"
            r1.<init>(r3)
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "DeviceUtil"
            com.huawei.hms.ads.uiengineloader.af.d(r1, r0)
        L63:
            r0 = r2
        L64:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.uiengineloader.d.a():boolean");
    }
}
