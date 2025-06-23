package com.baidu.sec.privacy.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;

/* loaded from: classes8.dex */
public class g {
    public static boolean a(Context context, int i) {
        if (com.baidu.sec.privacy.b.a.a(i)) {
            return b(context, i);
        }
        return false;
    }

    public static boolean b(Context context, int i) {
        if (com.baidu.sec.privacy.b.a.b(i)) {
            return true;
        }
        return c.a(context);
    }

    public static int a(Context context, int i, String str, int i2, boolean z, com.baidu.sec.privacy.c.a.a<Integer> aVar, Object... objArr) {
        int a2;
        try {
            if (!com.baidu.sec.privacy.b.a.a(i)) {
                return i2;
            }
            String str2 = i + "";
            if (!TextUtils.isEmpty(str)) {
                str2 = str2 + Base64.encodeToString(str.getBytes(), 0);
            }
            if (!a(str2)) {
                if (com.baidu.sec.privacy.b.a.c(str2) && (a2 = com.baidu.sec.privacy.b.a.a(str2, i2)) != i2) {
                    return a2;
                }
                if (b(context, i)) {
                    int intValue = aVar.b(str, objArr).intValue();
                    if (intValue != i2) {
                        com.baidu.sec.privacy.b.a.b(str2, intValue);
                    }
                    return intValue;
                }
                return a(context, i2, z);
            }
            if (b(context, i)) {
                int intValue2 = aVar.b(str, objArr).intValue();
                if (intValue2 == i2) {
                    return com.baidu.sec.privacy.b.a.c(str2) ? com.baidu.sec.privacy.b.a.a(str2, i2) : i2;
                }
                com.baidu.sec.privacy.b.a.b(str2, intValue2);
                return intValue2;
            }
            if (com.baidu.sec.privacy.b.a.c(str2)) {
                int a3 = com.baidu.sec.privacy.b.a.a(str2, i2);
                return a3 == i2 ? a(context, i2, z) : a3;
            }
            return a(context, i2, z);
        } catch (Throwable th) {
            c.a(th);
            return i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0032 A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:50:0x0008, B:5:0x0016, B:9:0x001d, B:11:0x0032, B:12:0x0049, B:14:0x004f, B:16:0x0055, B:20:0x0062, B:22:0x0068, B:24:0x0074, B:26:0x0078, B:29:0x007f, B:31:0x0085, B:33:0x0091, B:35:0x0097, B:38:0x009d, B:40:0x00a1, B:42:0x00a7, B:44:0x00b1, B:47:0x00b7), top: B:49:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:50:0x0008, B:5:0x0016, B:9:0x001d, B:11:0x0032, B:12:0x0049, B:14:0x004f, B:16:0x0055, B:20:0x0062, B:22:0x0068, B:24:0x0074, B:26:0x0078, B:29:0x007f, B:31:0x0085, B:33:0x0091, B:35:0x0097, B:38:0x009d, B:40:0x00a1, B:42:0x00a7, B:44:0x00b1, B:47:0x00b7), top: B:49:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(android.content.Context r6, int r7, java.lang.String r8, boolean r9, com.baidu.sec.privacy.c.a.a<java.lang.String> r10, java.lang.Object... r11) {
        /*
            r0 = 64
            r1 = 0
            java.lang.String r2 = ""
            r3 = 1
            if (r7 != r0) goto L13
            boolean r0 = com.baidu.sec.privacy.b.a.c()     // Catch: java.lang.Throwable -> L10
            if (r0 == 0) goto L13
            r0 = 0
            goto L14
        L10:
            r6 = move-exception
            goto Lbc
        L13:
            r0 = 1
        L14:
            if (r0 == 0) goto L1d
            boolean r4 = com.baidu.sec.privacy.b.a.a(r7)     // Catch: java.lang.Throwable -> L10
            if (r4 != 0) goto L1d
            return r2
        L1d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L10
            r4.<init>()     // Catch: java.lang.Throwable -> L10
            r4.append(r7)     // Catch: java.lang.Throwable -> L10
            r4.append(r2)     // Catch: java.lang.Throwable -> L10
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L10
            boolean r5 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> L10
            if (r5 != 0) goto L49
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L10
            r5.<init>()     // Catch: java.lang.Throwable -> L10
            r5.append(r4)     // Catch: java.lang.Throwable -> L10
            byte[] r4 = r8.getBytes()     // Catch: java.lang.Throwable -> L10
            java.lang.String r1 = android.util.Base64.encodeToString(r4, r1)     // Catch: java.lang.Throwable -> L10
            r5.append(r1)     // Catch: java.lang.Throwable -> L10
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> L10
        L49:
            boolean r1 = a(r4)     // Catch: java.lang.Throwable -> L10
            if (r1 != 0) goto L7d
            boolean r1 = com.baidu.sec.privacy.b.a.c(r4)     // Catch: java.lang.Throwable -> L10
            if (r1 == 0) goto L60
            java.lang.String r1 = com.baidu.sec.privacy.b.a.a(r4, r2)     // Catch: java.lang.Throwable -> L10
            boolean r5 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L10
            if (r5 != 0) goto L60
            return r1
        L60:
            if (r0 == 0) goto L66
            boolean r3 = b(r6, r7)     // Catch: java.lang.Throwable -> L10
        L66:
            if (r3 == 0) goto L78
            java.lang.Object r6 = r10.b(r8, r11)     // Catch: java.lang.Throwable -> L10
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L10
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L10
            if (r7 != 0) goto L77
            com.baidu.sec.privacy.b.a.b(r4, r6)     // Catch: java.lang.Throwable -> L10
        L77:
            return r6
        L78:
            java.lang.String r6 = a(r6, r9)     // Catch: java.lang.Throwable -> L10
            return r6
        L7d:
            if (r0 == 0) goto L83
            boolean r3 = b(r6, r7)     // Catch: java.lang.Throwable -> L10
        L83:
            if (r3 == 0) goto La1
            java.lang.Object r6 = r10.b(r8, r11)     // Catch: java.lang.Throwable -> L10
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L10
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L10
            if (r7 == 0) goto L9d
            boolean r6 = com.baidu.sec.privacy.b.a.c(r4)     // Catch: java.lang.Throwable -> L10
            if (r6 == 0) goto L9c
            java.lang.String r6 = com.baidu.sec.privacy.b.a.a(r4, r2)     // Catch: java.lang.Throwable -> L10
            return r6
        L9c:
            return r2
        L9d:
            com.baidu.sec.privacy.b.a.b(r4, r6)     // Catch: java.lang.Throwable -> L10
            return r6
        La1:
            boolean r7 = com.baidu.sec.privacy.b.a.c(r4)     // Catch: java.lang.Throwable -> L10
            if (r7 == 0) goto Lb7
            java.lang.String r7 = com.baidu.sec.privacy.b.a.a(r4, r2)     // Catch: java.lang.Throwable -> L10
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L10
            if (r8 == 0) goto Lb6
            java.lang.String r6 = a(r6, r9)     // Catch: java.lang.Throwable -> L10
            return r6
        Lb6:
            return r7
        Lb7:
            java.lang.String r6 = a(r6, r9)     // Catch: java.lang.Throwable -> L10
            return r6
        Lbc:
            com.baidu.sec.privacy.d.c.a(r6)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sec.privacy.d.g.a(android.content.Context, int, java.lang.String, boolean, com.baidu.sec.privacy.c.a.a, java.lang.Object[]):java.lang.String");
    }

    public static String a(Context context, int i, boolean z, com.baidu.sec.privacy.c.a.a<String> aVar, Object... objArr) {
        return a(context, i, null, z, aVar, objArr);
    }

    public static boolean a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("la_in");
        return System.currentTimeMillis() - com.baidu.sec.privacy.b.a.a(sb.toString(), 0L) >= 86400000;
    }

    public static String a(Context context, boolean z) {
        return !z ? "" : !c.b(context) ? "-1000" : "-1001";
    }

    public static int a(Context context, int i, boolean z) {
        return !z ? i : !c.b(context) ? -1000 : -1001;
    }
}
