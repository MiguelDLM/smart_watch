package com.baidu.navisdk.util.common;

import OI0.oxoX;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.util.SystemInfoUtil;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes8.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public static String f9250a = "";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006f  */
    /* JADX WARN: Type inference failed for: r0v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(android.content.Context r5) {
        /*
            java.lang.String r0 = com.baidu.navisdk.util.common.q.f9250a
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Lb
            java.lang.String r5 = com.baidu.navisdk.util.common.q.f9250a
            return r5
        Lb:
            com.baidu.navisdk.util.common.e0 r5 = com.baidu.navisdk.util.common.e0.a(r5)
            java.lang.String r0 = ""
            java.lang.String r1 = "cpu_name"
            java.lang.String r0 = r5.a(r1, r0)
            com.baidu.navisdk.util.common.q.f9250a = r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L22
            java.lang.String r5 = com.baidu.navisdk.util.common.q.f9250a
            return r5
        L22:
            r0 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5c
            java.lang.String r3 = "/proc/cpuinfo"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5c
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L81
            r3.<init>(r2)     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L81
        L2f:
            java.lang.String r0 = r3.readLine()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L57
            if (r0 == 0) goto L50
            java.lang.String r4 = "Hardware"
            boolean r4 = r0.contains(r4)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L57
            if (r4 == 0) goto L2f
            java.lang.String r4 = ":"
            java.lang.String[] r0 = r0.split(r4)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L57
            r4 = 1
            r0 = r0[r4]     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L57
            java.lang.String r0 = r0.trim()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L57
            com.baidu.navisdk.util.common.q.f9250a = r0     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L57
            goto L2f
        L4d:
            r5 = move-exception
            r0 = r3
            goto L82
        L50:
            a(r2)
            a(r3)
            goto L67
        L57:
            r0 = r3
            goto L5d
        L59:
            r5 = move-exception
            r2 = r0
            goto L82
        L5c:
            r2 = r0
        L5d:
            java.lang.String r3 = "INVALID"
            com.baidu.navisdk.util.common.q.f9250a = r3     // Catch: java.lang.Throwable -> L81
            a(r2)
            a(r0)
        L67:
            java.lang.String r0 = com.baidu.navisdk.util.common.q.f9250a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L7e
            java.lang.String r0 = com.baidu.navisdk.util.common.q.f9250a
            java.lang.String r2 = ","
            java.lang.String r3 = " "
            java.lang.String r0 = r0.replace(r2, r3)
            com.baidu.navisdk.util.common.q.f9250a = r0
            r5.b(r1, r0)
        L7e:
            java.lang.String r5 = com.baidu.navisdk.util.common.q.f9250a
            return r5
        L81:
            r5 = move-exception
        L82:
            a(r2)
            a(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.common.q.a(android.content.Context):java.lang.String");
    }

    public static long b(Context context) {
        return w.a(context).totalMem / 1048576;
    }

    public static String c() {
        StringBuilder sb = new StringBuilder();
        sb.append(f());
        sb.append(",");
        sb.append(g());
        sb.append(",");
        if (!TextUtils.isEmpty(f9250a)) {
            sb.append(f9250a);
            sb.append(",");
        }
        sb.append(e());
        sb.append(",");
        sb.append(a());
        return sb.toString();
    }

    public static String d() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, oxoX.f1509II0XooXoX);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String e() {
        return Build.HARDWARE;
    }

    public static String f() {
        return Build.MANUFACTURER;
    }

    public static String g() {
        return Build.MODEL;
    }

    public static boolean h() {
        return "HUAWEI".equals(Build.MANUFACTURER);
    }

    public static boolean i() {
        if (Build.VERSION.SDK_INT == 29) {
            String str = Build.MANUFACTURER;
            if (TextUtils.equals(str, "Xiaomi") || TextUtils.equals(str, "meizu")) {
                return true;
            }
        }
        return false;
    }

    public static boolean j() {
        return "vivo".equals(Build.MANUFACTURER);
    }

    public static int b() {
        return Runtime.getRuntime().availableProcessors();
    }

    public static String c(Context context) {
        e0 a2 = e0.a(context);
        int a3 = a2.a("cpu_max_freq", 0);
        if (a3 > 0) {
            return String.valueOf(a3);
        }
        int b = b();
        for (int i = 0; i < b; i++) {
            String a4 = a("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq");
            if (!TextUtils.isEmpty(a4) && TextUtils.isDigitsOnly(a4)) {
                a3 = Math.max(a3, Integer.parseInt(a4));
            }
        }
        a2.b("cpu_max_freq", a3);
        return String.valueOf(a3);
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", str).start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                sb.append(new String(bArr));
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            sb = new StringBuilder(SystemInfoUtil.NA);
        }
        return sb.toString().trim();
    }

    public static String a() {
        return Build.BOARD;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
