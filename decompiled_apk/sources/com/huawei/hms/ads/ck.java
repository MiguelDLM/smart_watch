package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes10.dex */
public class ck {
    private static final byte[] B = new byte[0];
    private static final String Code = "DeviceManager";
    private static final String I = "02";
    private static final String V = "ro.build.2b2c.partner.ext_channel";
    private static volatile cv Z;

    public static boolean B(Context context) {
        return V(context) || Code();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean C(android.content.Context r7) {
        /*
            java.lang.String r0 = "DeviceManager"
            java.lang.String r1 = "HONOR"
            java.lang.String r2 = "HUAWEI"
            android.content.Context r7 = r7.getApplicationContext()
            com.huawei.openalliance.ad.utils.aq r7 = com.huawei.openalliance.ad.utils.aq.Code(r7)
            java.lang.String r3 = r7.Z()
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            r5 = 1
            if (r4 != 0) goto L23
            java.lang.String r7 = java.lang.String.valueOf(r5)
            boolean r7 = android.text.TextUtils.equals(r7, r3)
            goto La3
        L23:
            r3 = 0
            java.lang.String r4 = android.os.Build.BRAND     // Catch: java.lang.Throwable -> L43 java.lang.RuntimeException -> L45
            boolean r6 = r4.equalsIgnoreCase(r2)     // Catch: java.lang.Throwable -> L43 java.lang.RuntimeException -> L45
            if (r6 != 0) goto L47
            java.lang.String r6 = android.os.Build.MANUFACTURER     // Catch: java.lang.Throwable -> L43 java.lang.RuntimeException -> L45
            boolean r2 = r6.equalsIgnoreCase(r2)     // Catch: java.lang.Throwable -> L43 java.lang.RuntimeException -> L45
            if (r2 != 0) goto L47
            boolean r2 = r4.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L43 java.lang.RuntimeException -> L45
            if (r2 != 0) goto L47
            boolean r1 = r6.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L43 java.lang.RuntimeException -> L45
            if (r1 == 0) goto L41
            goto L47
        L41:
            r1 = 0
            goto L48
        L43:
            r1 = move-exception
            goto L7a
        L45:
            r1 = move-exception
            goto L97
        L47:
            r1 = 1
        L48:
            if (r1 != 0) goto L78
            boolean r2 = com.huawei.openalliance.ad.utils.d.I()     // Catch: java.lang.Throwable -> L57 java.lang.RuntimeException -> L5b
            if (r2 == 0) goto L5f
            java.lang.String r2 = "com.hihonor.android.os.Build$VERSION"
        L52:
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L57 java.lang.RuntimeException -> L5b
            goto L62
        L57:
            r2 = move-exception
            r3 = r1
            r1 = r2
            goto L7a
        L5b:
            r2 = move-exception
            r3 = r1
            r1 = r2
            goto L97
        L5f:
            java.lang.String r2 = "com.huawei.android.os.BuildEx$VERSION"
            goto L52
        L62:
            java.lang.String r4 = "EMUI_SDK_INT"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r4)     // Catch: java.lang.Throwable -> L57 java.lang.RuntimeException -> L5b
            r4 = 0
            java.lang.Object r2 = r2.get(r4)     // Catch: java.lang.Throwable -> L57 java.lang.RuntimeException -> L5b
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> L57 java.lang.RuntimeException -> L5b
            int r0 = r2.intValue()     // Catch: java.lang.Throwable -> L57 java.lang.RuntimeException -> L5b
            if (r0 <= 0) goto L76
            goto L77
        L76:
            r5 = 0
        L77:
            r1 = r5
        L78:
            r3 = r1
            goto L9f
        L7a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "isHuaweiPhone Error:"
        L81:
            r2.append(r4)
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getSimpleName()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.huawei.hms.ads.fb.Z(r0, r1)
            goto L9f
        L97:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "isHuaweiPhone RuntimeException:"
            goto L81
        L9f:
            r7.V(r3)
            r7 = r3
        La3:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.ck.C(android.content.Context):boolean");
    }

    public static cv Code(Context context) {
        if (Z == null) {
            synchronized (B) {
                try {
                    if (Z == null) {
                        Z = I(context) ? cs.V(context) : Z(context) ? cq.V(context) : Code() ? cp.V(context) : cu.V(context);
                    }
                } finally {
                }
            }
        }
        return Z;
    }

    public static boolean I(Context context) {
        com.huawei.openalliance.ad.utils.aq Code2 = com.huawei.openalliance.ad.utils.aq.Code(context);
        String L = Code2.L();
        if (!TextUtils.isEmpty(L)) {
            return TextUtils.equals(String.valueOf(true), L);
        }
        boolean z = V(context) && !Z(context);
        Code2.Z(z);
        return z;
    }

    public static boolean V(Context context) {
        return C(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        if (com.hihonor.android.os.Build.VERSION.MAGIC_SDK_INT >= 33) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean Z(android.content.Context r4) {
        /*
            com.huawei.openalliance.ad.utils.aq r4 = com.huawei.openalliance.ad.utils.aq.Code(r4)
            java.lang.String r0 = r4.a()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 1
            if (r1 != 0) goto L18
            java.lang.String r4 = java.lang.String.valueOf(r2)
            boolean r4 = android.text.TextUtils.equals(r4, r0)
            goto L57
        L18:
            r0 = 0
            java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch: java.lang.Throwable -> L30
            java.lang.String r3 = "HONOR"
            boolean r1 = r1.equalsIgnoreCase(r3)     // Catch: java.lang.Throwable -> L30
            if (r1 == 0) goto L32
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L30
            r3 = 31
            if (r1 < r3) goto L32
            int r1 = com.hihonor.android.os.Build.VERSION.MAGIC_SDK_INT     // Catch: java.lang.Throwable -> L30
            r3 = 33
            if (r1 < r3) goto L32
            goto L33
        L30:
            r1 = move-exception
            goto L35
        L32:
            r2 = 0
        L33:
            r0 = r2
            goto L53
        L35:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "isHonor6UpPhone Error:"
            r2.append(r3)
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getSimpleName()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "DeviceManager"
            com.huawei.hms.ads.fb.Z(r2, r1)
        L53:
            r4.B(r0)
            r4 = r0
        L57:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.ck.Z(android.content.Context):boolean");
    }

    private static boolean Code() {
        String Code2 = com.huawei.openalliance.ad.utils.bc.Code("ro.build.2b2c.partner.ext_channel");
        return !TextUtils.isEmpty(Code2) && Code2.startsWith("02");
    }
}
