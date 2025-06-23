package com.baidu.mshield.b.a;

import android.os.Build;

/* loaded from: classes7.dex */
public class e {
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
    
        com.baidu.mshield.b.c.a.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a() {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 22
            if (r0 <= r1) goto Lb
            boolean r0 = com.baidu.mapsdkplatform.comapi.oIX0oI.oIX0oI()
            return r0
        Lb:
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54
            r1.<init>()     // Catch: java.lang.Throwable -> L54
            java.lang.String r2 = "/proc/"
            r1.append(r2)     // Catch: java.lang.Throwable -> L54
            int r2 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L54
            r1.append(r2)     // Catch: java.lang.Throwable -> L54
            java.lang.String r2 = "/maps"
            r1.append(r2)     // Catch: java.lang.Throwable -> L54
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L54
            java.lang.String r2 = "/system/lib64/libc.so"
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L54
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L54
            boolean r1 = r3.exists()     // Catch: java.lang.Throwable -> L54
            if (r1 == 0) goto L80
            boolean r1 = r3.isDirectory()     // Catch: java.lang.Throwable -> L54
            if (r1 == 0) goto L3a
            goto L80
        L3a:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L64
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L64
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L64
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L64
        L44:
            java.lang.String r3 = r1.readLine()     // Catch: java.lang.Throwable -> L5c
            if (r3 == 0) goto L5e
            boolean r3 = r3.contains(r2)     // Catch: java.lang.Throwable -> L5c
            if (r3 == 0) goto L44
            r1.close()     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
            goto L5a
        L54:
            r1 = move-exception
            goto L81
        L56:
            r1 = move-exception
            com.baidu.mshield.b.c.a.a(r1)     // Catch: java.lang.Throwable -> L54
        L5a:
            r0 = 1
            return r0
        L5c:
            r2 = move-exception
            goto L67
        L5e:
            r1.close()     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L62
            goto L84
        L62:
            r1 = move-exception
            goto L70
        L64:
            r1 = move-exception
            r2 = r1
            r1 = 0
        L67:
            com.baidu.mshield.b.c.a.a(r2)     // Catch: java.lang.Throwable -> L74
            if (r1 == 0) goto L84
            r1.close()     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L62
            goto L84
        L70:
            com.baidu.mshield.b.c.a.a(r1)     // Catch: java.lang.Throwable -> L54
            goto L84
        L74:
            r2 = move-exception
            if (r1 == 0) goto L7f
            r1.close()     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L7b
            goto L7f
        L7b:
            r1 = move-exception
            com.baidu.mshield.b.c.a.a(r1)     // Catch: java.lang.Throwable -> L54
        L7f:
            throw r2     // Catch: java.lang.Throwable -> L54
        L80:
            return r0
        L81:
            com.baidu.mshield.b.c.a.a(r1)
        L84:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.b.a.e.a():boolean");
    }

    public static int b() {
        try {
            return Runtime.getRuntime().availableProcessors();
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return 0;
        }
    }

    public static String c() {
        try {
            String[] strArr = Build.SUPPORTED_ABIS;
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str);
                sb.append(',');
            }
            return sb.toString().substring(0, r0.length() - 1);
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return "";
        }
    }
}
