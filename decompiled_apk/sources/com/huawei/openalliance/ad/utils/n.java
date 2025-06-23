package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import com.hihonor.android.fsm.HwFoldScreenManagerEx;
import com.huawei.android.app.PackageManagerEx;
import com.huawei.hms.ads.cl;
import com.huawei.hms.ads.fb;

/* loaded from: classes10.dex */
public class n {
    static final String B = "CN";
    private static final String C = "DeviceUtil";
    static final String Code = "content";
    private static final int D = 1;
    private static final float F = 1.5f;
    static final String I = "/switch/query";
    private static final int L = 2;
    private static final String S = "com.huawei.hardware.screen.type.eink";
    static final String V = "com.huawei.hwid.pps.apiprovider";
    static final String Z = "isSwitchChecked";

    public static boolean B(Context context) {
        return "1".equalsIgnoreCase(m.Code(context).Code());
    }

    public static boolean C(Context context) {
        return "0".equalsIgnoreCase(m.Code(context).Code());
    }

    public static String Code() {
        String Code2 = bc.Code("ro.product.model");
        return TextUtils.isEmpty(Code2) ? Build.MODEL : Code2;
    }

    public static int D(Context context) {
        return ((float) d.B(context)) / ((float) d.Z(context)) > F ? 2 : 1;
    }

    public static boolean F(Context context) {
        int D2;
        try {
            D2 = cl.Code(context).S();
        } catch (Throwable th) {
            D2 = D(context);
            fb.I(C, "getFoldableStatus %s", th.getClass().getSimpleName());
        }
        return D2 == 1;
    }

    public static int I(Context context) {
        aq Code2 = aq.Code(context);
        if (Code2.S() != null) {
            return Code2.S().intValue();
        }
        int I2 = m.Code(context).I();
        Code2.Code(I2);
        return I2;
    }

    public static Context L(Context context) {
        Context createDeviceProtectedStorageContext;
        if (!V()) {
            return context;
        }
        createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        return createDeviceProtectedStorageContext;
    }

    public static boolean S(Context context) {
        try {
            return d.I() ? HwFoldScreenManagerEx.isFoldable() : com.huawei.android.fsm.HwFoldScreenManagerEx.isFoldable();
        } catch (Throwable th) {
            fb.I(C, "isFoldablePhone exception: %s", th.getClass().getSimpleName());
            return false;
        }
    }

    public static boolean V() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean Z(Context context) {
        boolean z;
        boolean z2;
        aq Code2 = aq.Code(context);
        try {
            if (Code2.F() != null) {
                z2 = Code2.F().booleanValue();
            } else {
                z2 = ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(1) != null;
                try {
                    Code2.Code(Boolean.valueOf(z2));
                } catch (Throwable th) {
                    z = z2;
                    th = th;
                    fb.I(C, "getHasAccAndRotate err: %s", th.getClass().getSimpleName());
                    return z;
                }
            }
            return z2;
        } catch (Throwable th2) {
            th = th2;
            z = true;
        }
    }

    public static void Code(final aq aqVar, final Context context) {
        h.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.n.1
            /* JADX WARN: Code restructure failed: missing block: B:20:0x0091, code lost:
            
                r2.Code(false);
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x0097, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x008e, code lost:
            
                if (r0 == null) goto L23;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    r8 = this;
                    android.net.Uri$Builder r0 = new android.net.Uri$Builder
                    r0.<init>()
                    java.lang.String r1 = "content"
                    android.net.Uri$Builder r0 = r0.scheme(r1)
                    java.lang.String r1 = "com.huawei.hwid.pps.apiprovider"
                    android.net.Uri$Builder r0 = r0.authority(r1)
                    java.lang.String r1 = "/switch/query"
                    android.net.Uri$Builder r0 = r0.path(r1)
                    android.net.Uri r2 = r0.build()
                    android.content.Context r0 = r1
                    boolean r0 = com.huawei.openalliance.ad.utils.w.Code(r0, r2)
                    java.lang.String r7 = "DeviceUtil"
                    if (r0 != 0) goto L2b
                    java.lang.String r0 = "provider uri invalid."
                    com.huawei.hms.ads.fb.I(r7, r0)
                    return
                L2b:
                    r0 = 0
                    android.content.Context r1 = r1     // Catch: java.lang.Throwable -> L65
                    android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L65
                    r5 = 0
                    r6 = 0
                    r3 = 0
                    r4 = 0
                    android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L65
                    if (r0 == 0) goto L67
                    boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L65
                    if (r1 == 0) goto L67
                    java.lang.String r1 = "isSwitchChecked"
                    int r1 = r0.getColumnIndexOrThrow(r1)     // Catch: java.lang.Throwable -> L5f
                    java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Throwable -> L5f
                    java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L5f
                    java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L5f
                    boolean r1 = r2.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L5f
                    com.huawei.openalliance.ad.utils.aq r2 = r2     // Catch: java.lang.Throwable -> L5f
                    r2.Code(r1)     // Catch: java.lang.Throwable -> L5f
                    r0.close()
                    return
                L5f:
                    java.lang.String r1 = "loc_tag isBaseLocationSwitch Exception"
                    com.huawei.hms.ads.fb.Z(r7, r1)     // Catch: java.lang.Throwable -> L65
                    goto L6c
                L65:
                    r1 = move-exception
                    goto L72
                L67:
                    java.lang.String r1 = "loc_tag isBaseLocationSwitch, cursor is null"
                    com.huawei.hms.ads.fb.I(r7, r1)     // Catch: java.lang.Throwable -> L65
                L6c:
                    if (r0 == 0) goto L91
                L6e:
                    r0.close()
                    goto L91
                L72:
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L98
                    r2.<init>()     // Catch: java.lang.Throwable -> L98
                    java.lang.String r3 = "loc_tag isBaseLocationSwitch query error: "
                    r2.append(r3)     // Catch: java.lang.Throwable -> L98
                    java.lang.Class r1 = r1.getClass()     // Catch: java.lang.Throwable -> L98
                    java.lang.String r1 = r1.getSimpleName()     // Catch: java.lang.Throwable -> L98
                    r2.append(r1)     // Catch: java.lang.Throwable -> L98
                    java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L98
                    com.huawei.hms.ads.fb.Z(r7, r1)     // Catch: java.lang.Throwable -> L98
                    if (r0 == 0) goto L91
                    goto L6e
                L91:
                    com.huawei.openalliance.ad.utils.aq r0 = r2
                    r1 = 0
                    r0.Code(r1)
                    return
                L98:
                    r1 = move-exception
                    if (r0 == 0) goto L9e
                    r0.close()
                L9e:
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.utils.n.AnonymousClass1.run():void");
            }
        });
    }

    public static boolean I() {
        try {
            return PackageManagerEx.hasHwSystemFeature(S);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean V(Context context) {
        aq Code2 = aq.Code(context);
        if (Code2.B() != null) {
            return Code2.B().booleanValue();
        }
        boolean V2 = m.Code(context).V();
        Code2.I(V2);
        return V2;
    }

    public static boolean Code(Context context) {
        aq Code2 = aq.Code(context);
        boolean V2 = Code2.V();
        Code(Code2, context);
        return V2;
    }
}
