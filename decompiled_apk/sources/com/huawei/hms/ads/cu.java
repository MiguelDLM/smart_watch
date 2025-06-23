package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.util.List;

/* loaded from: classes10.dex */
public class cu extends cm {
    private static final int B = 32;
    private static final int C = 8;
    private static final byte[] F = new byte[0];
    public static final String I = "CN";
    private static cv S = null;
    private static final String Z = "ThirdDeviceImpl";

    public cu(Context context) {
        super(context);
    }

    private static cv I(Context context) {
        cv cvVar;
        synchronized (F) {
            try {
                if (S == null) {
                    S = new cu(context);
                }
                cvVar = S;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cvVar;
    }

    public static cv V(Context context) {
        return I(context);
    }

    @Override // com.huawei.hms.ads.cm, com.huawei.hms.ads.cv
    public int Code(View view) {
        int identifier;
        WindowInsets rootWindowInsets;
        WindowInsets rootWindowInsets2;
        DisplayCutout displayCutout;
        List boundingRects;
        int i = -1;
        if (view == null) {
            return -1;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                rootWindowInsets = view.getRootWindowInsets();
                if (rootWindowInsets != null) {
                    rootWindowInsets2 = view.getRootWindowInsets();
                    displayCutout = rootWindowInsets2.getDisplayCutout();
                    if (displayCutout != null) {
                        boundingRects = displayCutout.getBoundingRects();
                        if (!com.huawei.openalliance.ad.utils.ad.Code(boundingRects)) {
                            i = ((Rect) boundingRects.get(0)).height();
                        }
                    }
                }
            }
            if (i < 0 && (identifier = this.Code.getResources().getIdentifier("notch_height", "dimen", "android")) > 0) {
                i = this.Code.getResources().getDimensionPixelSize(identifier);
            }
            if (i >= 0) {
                return i;
            }
            int identifier2 = this.Code.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier2 > 0) {
                i = this.Code.getResources().getDimensionPixelSize(identifier2);
            }
            if (i == 0) {
                return 110;
            }
            return i;
        } catch (Throwable th) {
            fb.V(Z, "getNotchHeight err: %s", th.getClass().getSimpleName());
            return -1;
        }
    }

    @Override // com.huawei.hms.ads.cm, com.huawei.hms.ads.cv
    public boolean Code() {
        return "CN".equalsIgnoreCase(ed.Code(this.Code).W());
    }

    @Override // com.huawei.hms.ads.cm, com.huawei.hms.ads.cv
    public boolean V() {
        return Code();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.huawei.hms.ads.cm, com.huawei.hms.ads.cv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean Code(android.content.Context r10) {
        /*
            r9 = this;
            r0 = 2
            r1 = 1
            r2 = 0
            java.lang.String r3 = "Notch"
            java.lang.String r4 = "ThirdDeviceImpl"
            java.lang.String r5 = "android.os.SystemProperties"
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch: java.lang.Throwable -> L38
            java.lang.String r6 = "getInt"
            java.lang.Class[] r7 = new java.lang.Class[r0]     // Catch: java.lang.Throwable -> L38
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r7[r2] = r8     // Catch: java.lang.Throwable -> L38
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> L38
            r7[r1] = r8     // Catch: java.lang.Throwable -> L38
            java.lang.reflect.Method r6 = r5.getMethod(r6, r7)     // Catch: java.lang.Throwable -> L38
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L38
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L38
            java.lang.String r8 = "ro.miui.notch"
            r0[r2] = r8     // Catch: java.lang.Throwable -> L38
            r0[r1] = r7     // Catch: java.lang.Throwable -> L38
            java.lang.Object r0 = r6.invoke(r5, r0)     // Catch: java.lang.Throwable -> L38
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L38
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L38
            if (r0 != 0) goto L36
            goto L55
        L36:
            r0 = 1
            goto L56
        L38:
            r0 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "isNotchEnable mi Throwable:"
            r5.append(r6)
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            com.huawei.hms.ads.fb.I(r4, r0)
        L55:
            r0 = 0
        L56:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r0)
            java.lang.Object[] r6 = new java.lang.Object[r1]
            r6[r2] = r5
            java.lang.String r5 = "isNotchEnable xiaomi, hasNotch = %s"
            com.huawei.hms.ads.fb.Code(r4, r5, r6)
            if (r0 != 0) goto L8d
            android.content.pm.PackageManager r5 = r10.getPackageManager()     // Catch: java.lang.Throwable -> L70
            java.lang.String r6 = "com.oppo.feature.screen.heteromorphism"
            boolean r0 = r5.hasSystemFeature(r6)     // Catch: java.lang.Throwable -> L70
            goto L8d
        L70:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "isNotchEnable oppo Throwable:"
            r6.append(r7)
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.huawei.hms.ads.fb.I(r4, r5)
        L8d:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r0)
            java.lang.Object[] r6 = new java.lang.Object[r1]
            r6[r2] = r5
            java.lang.String r5 = "isNotchEnable oppo, hasNotch = %s"
            com.huawei.hms.ads.fb.Code(r4, r5, r6)
            if (r0 != 0) goto Le7
            java.lang.ClassLoader r10 = r10.getClassLoader()     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Le1 java.lang.ClassNotFoundException -> Le4
            java.lang.String r5 = "android.util.FtFeature"
            java.lang.Class r10 = r10.loadClass(r5)     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Le1 java.lang.ClassNotFoundException -> Le4
            java.lang.String r5 = "isFeatureSupport"
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Le1 java.lang.ClassNotFoundException -> Le4
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Le1 java.lang.ClassNotFoundException -> Le4
            r6[r2] = r7     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Le1 java.lang.ClassNotFoundException -> Le4
            java.lang.reflect.Method r5 = r10.getMethod(r5, r6)     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Le1 java.lang.ClassNotFoundException -> Le4
            r6 = 32
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Le1 java.lang.ClassNotFoundException -> Le4
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Le1 java.lang.ClassNotFoundException -> Le4
            r7[r2] = r6     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Le1 java.lang.ClassNotFoundException -> Le4
            java.lang.Object r6 = r5.invoke(r10, r7)     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Le1 java.lang.ClassNotFoundException -> Le4
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Le1 java.lang.ClassNotFoundException -> Le4
            boolean r0 = r6.booleanValue()     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Le1 java.lang.ClassNotFoundException -> Le4
            r6 = 8
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Le1 java.lang.ClassNotFoundException -> Le4
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Le1 java.lang.ClassNotFoundException -> Le4
            r7[r2] = r6     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Le1 java.lang.ClassNotFoundException -> Le4
            java.lang.Object r10 = r5.invoke(r10, r7)     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Le1 java.lang.ClassNotFoundException -> Le4
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Le1 java.lang.ClassNotFoundException -> Le4
            boolean r0 = r10.booleanValue()     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Le1 java.lang.ClassNotFoundException -> Le4
            goto Le7
        Ldb:
            java.lang.String r10 = "hasNotchAtVivo Exception"
        Ldd:
            com.huawei.hms.ads.fb.Z(r3, r10)
            goto Le7
        Le1:
            java.lang.String r10 = "hasNotchAtVivo NoSuchMethodException"
            goto Ldd
        Le4:
            java.lang.String r10 = "hasNotchAtVivo ClassNotFoundException"
            goto Ldd
        Le7:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r0)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r2] = r10
            java.lang.String r10 = "isNotchEnable vivo, hasNotch = %s"
            com.huawei.hms.ads.fb.Code(r4, r10, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.cu.Code(android.content.Context):boolean");
    }
}
