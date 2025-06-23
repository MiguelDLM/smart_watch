package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.app.AppPackageInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bv;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes11.dex */
public final class aw {
    public static String aQN = "";

    public static com.kwad.sdk.k.a.b Lg() {
        return com.kwad.sdk.k.a.b.Lg();
    }

    public static com.kwad.sdk.k.a.f Lh() {
        return com.kwad.sdk.k.a.f.Lh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Ng() {
        int i;
        com.kwad.sdk.k.a.f Lh = com.kwad.sdk.k.a.f.Lh();
        if (Lh != null) {
            i = Lh.aOl;
        } else {
            i = -1;
        }
        if (i >= 0) {
            return com.kwad.sdk.e.b.a(false, String.valueOf(i), 0);
        }
        if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).zg()) {
            return com.kwad.sdk.e.b.a(false, String.valueOf(i), 1);
        }
        return com.kwad.sdk.e.b.a(false, String.valueOf(i), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Nh() {
        com.kwad.sdk.k.a.b Lg = com.kwad.sdk.k.a.b.Lg();
        if (Lg != null) {
            return com.kwad.sdk.e.b.a(false, Lg.toJson(), 0);
        }
        if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).zi()) {
            return com.kwad.sdk.e.b.a(false, "", 1);
        }
        return com.kwad.sdk.e.b.a(false, "", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Ni() {
        return com.kwad.sdk.e.b.a(false, "1", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Nj() {
        return com.kwad.sdk.e.b.a(false, String.valueOf(getSdkVersion()), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Nk() {
        return com.kwad.sdk.e.b.a(false, String.valueOf(getAppId()), 0);
    }

    private static String bS(boolean z) {
        String cd = bj.cd(z);
        if (!z) {
            if (TextUtils.isEmpty(cd)) {
                return "";
            }
            return cd;
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(cd)) {
            if (!av.Na() || TextUtils.isEmpty(av.Nb())) {
                z2 = false;
            }
            return com.kwad.sdk.e.b.a(z2, cd, 0);
        }
        if (!av.Na() && o.LS()) {
            return com.kwad.sdk.e.b.a(false, cd, 5);
        }
        return com.kwad.sdk.e.b.a(false, cd, 1);
    }

    private static String bT(boolean z) {
        if (com.kwad.framework.a.a.md.booleanValue() && !TextUtils.isEmpty(bk.getDeviceId())) {
            return bk.getDeviceId();
        }
        String deviceId = bj.getDeviceId();
        if (!z) {
            if (TextUtils.isEmpty(deviceId)) {
                return "";
            }
            return deviceId;
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(deviceId)) {
            if (!av.usePhoneStateDisable() || TextUtils.isEmpty(av.MX())) {
                z2 = false;
            }
            return com.kwad.sdk.e.b.a(z2, deviceId, 0);
        }
        if (!av.usePhoneStateDisable() && o.LQ()) {
            return com.kwad.sdk.e.b.a(false, deviceId, 5);
        }
        return com.kwad.sdk.e.b.a(false, deviceId, 1);
    }

    private static String bU(boolean z) {
        String NV = bj.NV();
        if (!z) {
            if (TextUtils.isEmpty(NV)) {
                return "";
            }
            return NV;
        }
        if (!TextUtils.isEmpty(NV)) {
            return com.kwad.sdk.e.b.a(av.Nc(), NV, 0);
        }
        if (!av.Nc() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ab(8L)) {
            return com.kwad.sdk.e.b.a(false, NV, 2);
        }
        return com.kwad.sdk.e.b.a(false, NV, 1);
    }

    public static /* synthetic */ String bV(boolean z) {
        return bS(true);
    }

    public static /* synthetic */ String bW(boolean z) {
        return Ng();
    }

    public static /* synthetic */ String bX(boolean z) {
        return Nh();
    }

    public static /* synthetic */ String bY(boolean z) {
        return bT(true);
    }

    public static /* synthetic */ String bZ(boolean z) {
        return bU(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(Context context, boolean z) {
        String u = bj.u(context, z);
        if (!z) {
            if (TextUtils.isEmpty(u)) {
                return "";
            }
            return u;
        }
        int i = 1;
        boolean z2 = true;
        if (!TextUtils.isEmpty(u)) {
            if (!av.usePhoneStateDisable() || TextUtils.isEmpty(av.MV())) {
                z2 = false;
            }
            return com.kwad.sdk.e.b.a(z2, u, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, u, 4);
        }
        if (!av.usePhoneStateDisable() && o.LW()) {
            if (SystemUtil.di(context)) {
                i = 3;
            }
            return com.kwad.sdk.e.b.a(false, u, i);
        }
        return com.kwad.sdk.e.b.a(false, u, 1);
    }

    public static String cI(Context context) {
        return c(context, false);
    }

    public static String cJ(Context context) {
        return d(context, false);
    }

    public static String cK(Context context) {
        return e(context, false);
    }

    public static String cL(Context context) {
        return f(context, false);
    }

    public static String cM(Context context) {
        return g(context, false);
    }

    public static String cN(Context context) {
        return h(context, false);
    }

    public static String cO(Context context) {
        return i(context, false);
    }

    public static int cP(Context context) {
        return bj.dp(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String cQ(Context context) {
        int dp = bj.dp(context);
        if (dp > 0) {
            return com.kwad.sdk.e.b.a(false, String.valueOf(dp), 0);
        }
        if (Build.VERSION.SDK_INT < 23) {
            return com.kwad.sdk.e.b.a(false, String.valueOf(dp), 1);
        }
        return com.kwad.sdk.e.b.a(false, String.valueOf(dp), 3);
    }

    public static int cR(Context context) {
        return bj.dq(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String cS(Context context) {
        List<bv.a> o = o(context, 15);
        if (o != null && o.size() > 0) {
            return com.kwad.sdk.e.b.a(av.Nc(), t.O(o), 0);
        }
        int i = 1;
        if (!av.Nc() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ab(32L)) {
            if (!bv.dx(context)) {
                i = 3;
            }
            return com.kwad.sdk.e.b.a(false, "", i);
        }
        return com.kwad.sdk.e.b.a(false, "", 1);
    }

    private static Map<String, AppPackageInfo> cT(Context context) {
        com.kwad.sdk.components.n nVar = (com.kwad.sdk.components.n) com.kwad.sdk.components.c.f(com.kwad.sdk.components.n.class);
        if (nVar != null && o.LU()) {
            return nVar.K(context);
        }
        return new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String cU(Context context) {
        boolean z;
        com.kwad.sdk.core.c.b.En();
        if (!com.kwad.sdk.core.c.b.isAppOnForeground()) {
            return com.kwad.sdk.e.b.a(false, "", 5);
        }
        Map<String, AppPackageInfo> cT = cT(context);
        int i = 1;
        if (cT.size() > 0) {
            if (av.Ne() && av.Nf() != null) {
                z = true;
            } else {
                z = false;
            }
            com.kwad.sdk.components.n nVar = (com.kwad.sdk.components.n) com.kwad.sdk.components.c.f(com.kwad.sdk.components.n.class);
            if (nVar != null && o.LU()) {
                return com.kwad.sdk.e.b.a(z, nVar.c(cT), 0);
            }
        }
        if (!av.Ne() && o.LU()) {
            if (bj.dw(context)) {
                i = 3;
            }
            return com.kwad.sdk.e.b.a(false, "", i);
        }
        return com.kwad.sdk.e.b.a(false, "", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String cV(Context context) {
        com.kwad.sdk.utils.c.a ci = r.ci(context);
        int i = 1;
        boolean z = true;
        if (ci != null && ci.aTt != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("latitude", String.valueOf(ci.aTt.getLatitude()));
            hashMap.put("longitude", String.valueOf(ci.aTt.getLongitude()));
            if (!av.MT() || av.MU() == null) {
                z = false;
            }
            return com.kwad.sdk.e.b.a(z, t.parseMap2JSON(hashMap), 0);
        }
        if (!av.MT() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ab(64L)) {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) == 0) {
                i = 3;
            }
            return com.kwad.sdk.e.b.a(false, "", i);
        }
        return com.kwad.sdk.e.b.a(false, "", 1);
    }

    @NonNull
    private static com.kwad.sdk.e.c cW(final Context context) {
        return new com.kwad.sdk.e.c() { // from class: com.kwad.sdk.utils.aw.1
            @Override // com.kwad.sdk.e.a
            public final String IR() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIMEI:" + aw.c(context, true));
                return aw.c(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String IS() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getAndroidID:" + aw.d(context, true));
                return aw.d(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String IT() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getMac:" + aw.e(context, true));
                return aw.e(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String IU() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + aw.f(context, true));
                return aw.f(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String IV() {
                String g = aw.g(context, true);
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + g);
                return g;
            }

            @Override // com.kwad.sdk.e.a
            public final String IW() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIMSI:" + aw.h(context, true));
                return aw.h(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String IX() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getSimCardPhoneCount:" + aw.cQ(context));
                return aw.cQ(context);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.sdk.utils.aw.bW(boolean):java.lang.String
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4807)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:103)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:63)
                	... 1 more
                */
            @Override // com.kwad.sdk.e.a
            public final java.lang.String IY() {
                /*
                    r3 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.aw.bW(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "getSimCardActivePhoneCount:"
                    r1.<init>(r2)
                    r1.append(r0)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "SDKPrivateSafetyDataUtil"
                    com.kwad.sdk.core.e.c.d(r2, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.aw.AnonymousClass1.IY():java.lang.String");
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.sdk.utils.aw.bX(boolean):java.lang.String
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4807)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:103)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:63)
                	... 1 more
                */
            @Override // com.kwad.sdk.e.a
            public final java.lang.String IZ() {
                /*
                    r3 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.aw.bX(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "getBaseStationInfo:"
                    r1.<init>(r2)
                    r1.append(r0)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "SDKPrivateSafetyDataUtil"
                    com.kwad.sdk.core.e.c.d(r2, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.aw.AnonymousClass1.IZ():java.lang.String");
            }

            @Override // com.kwad.sdk.e.a
            public final String Ja() {
                String cS = aw.cS(context);
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getWifiList:" + cS);
                return cS;
            }

            @Override // com.kwad.sdk.e.a
            public final String Jb() {
                String cU = aw.cU(context);
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getAppList:" + cU);
                return cU;
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.sdk.utils.aw.ca(boolean):java.lang.String
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4807)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:103)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:63)
                	... 1 more
                */
            @Override // com.kwad.sdk.e.a
            public final java.lang.String Jc() {
                /*
                    r3 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.aw.ca(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "getSdkType:"
                    r1.<init>(r2)
                    r1.append(r0)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "SDKPrivateSafetyDataUtil"
                    com.kwad.sdk.core.e.c.d(r2, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.aw.AnonymousClass1.Jc():java.lang.String");
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.sdk.utils.aw.cc(boolean):java.lang.String
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4807)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:103)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:63)
                	... 1 more
                */
            @Override // com.kwad.sdk.e.a
            public final java.lang.String getAppId() {
                /*
                    r3 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.aw.cc(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "getAppId:"
                    r1.<init>(r2)
                    r1.append(r0)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "SDKPrivateSafetyDataUtil"
                    com.kwad.sdk.core.e.c.d(r2, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.aw.AnonymousClass1.getAppId():java.lang.String");
            }

            @Override // com.kwad.sdk.e.a
            public final String getDeviceId() {
                String bY = aw.bY(true);
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getDeviceId:" + bY);
                return bY;
            }

            @Override // com.kwad.sdk.e.a
            public final String getIccId() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIccId:" + aw.i(context, true));
                return aw.i(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String getIp() {
                String bZ = aw.bZ(true);
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIp:" + bZ);
                return bZ;
            }

            @Override // com.kwad.sdk.e.a
            public final String getLocation() {
                String cV = aw.cV(context);
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getLocation:" + cV);
                return cV;
            }

            @Override // com.kwad.sdk.e.a
            public final String getOaid() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getOaid:" + aw.bV(true));
                return aw.bV(true);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.sdk.utils.aw.cb(boolean):java.lang.String
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4807)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:103)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:63)
                	... 1 more
                */
            @Override // com.kwad.sdk.e.a
            public final java.lang.String getSdkVersion() {
                /*
                    r3 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.aw.cb(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "getSdkVersion:"
                    r1.<init>(r2)
                    r1.append(r0)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "SDKPrivateSafetyDataUtil"
                    com.kwad.sdk.core.e.c.d(r2, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.aw.AnonymousClass1.getSdkVersion():java.lang.String");
            }
        };
    }

    public static /* synthetic */ String ca(boolean z) {
        return Ni();
    }

    public static /* synthetic */ String cb(boolean z) {
        return Nj();
    }

    public static /* synthetic */ String cc(boolean z) {
        return Nk();
    }

    public static com.kwad.sdk.utils.c.a ci(Context context) {
        return r.ci(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(Context context, boolean z) {
        String cJ = bj.cJ(context);
        if (!z) {
            if (TextUtils.isEmpty(cJ)) {
                return "";
            }
            return cJ;
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(cJ)) {
            if (!av.usePhoneStateDisable() || TextUtils.isEmpty(av.MX())) {
                z2 = false;
            }
            return com.kwad.sdk.e.b.a(z2, cJ, 0);
        }
        if (!av.usePhoneStateDisable() && o.LQ()) {
            return com.kwad.sdk.e.b.a(false, cJ, 5);
        }
        return com.kwad.sdk.e.b.a(false, cJ, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(Context context, boolean z) {
        String du = bj.du(context);
        if (!z) {
            if (TextUtils.isEmpty(du)) {
                return "";
            }
            return du;
        }
        int i = 1;
        boolean z2 = true;
        if (!TextUtils.isEmpty(du)) {
            if (!av.MY() || TextUtils.isEmpty(av.MZ())) {
                z2 = false;
            }
            return com.kwad.sdk.e.b.a(z2, du.toLowerCase(), 0);
        }
        if (!av.MY() && o.LR()) {
            if (an.aq(context, com.kuaishou.weapon.p0.g.d) == 0) {
                i = 3;
            }
            return com.kwad.sdk.e.b.a(false, du, i);
        }
        return com.kwad.sdk.e.b.a(false, du, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f(Context context, boolean z) {
        String str;
        String[] m280do = bj.m280do(context);
        if (m280do != null && m280do.length > 0) {
            str = m280do[0];
        } else {
            str = null;
        }
        if (!z) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str;
        }
        int i = 1;
        boolean z2 = true;
        if (!TextUtils.isEmpty(str)) {
            if (!av.usePhoneStateDisable() || TextUtils.isEmpty(av.MV())) {
                z2 = false;
            }
            return com.kwad.sdk.e.b.a(z2, str, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, str, 4);
        }
        if (!av.usePhoneStateDisable() && o.LW()) {
            if (SystemUtil.di(context)) {
                i = 3;
            }
            return com.kwad.sdk.e.b.a(false, str, i);
        }
        return com.kwad.sdk.e.b.a(false, str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(Context context, boolean z) {
        String str;
        String[] m280do = bj.m280do(context);
        int i = 1;
        boolean z2 = true;
        if (m280do != null && m280do.length > 1) {
            str = m280do[1];
        } else {
            str = null;
        }
        if (!z) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str;
        }
        if (!TextUtils.isEmpty(str)) {
            if (!av.usePhoneStateDisable() || TextUtils.isEmpty(av.MV())) {
                z2 = false;
            }
            return com.kwad.sdk.e.b.a(z2, str, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, str, 4);
        }
        if (!av.usePhoneStateDisable() && o.LW()) {
            if (SystemUtil.di(context)) {
                i = 3;
            }
            return com.kwad.sdk.e.b.a(false, str, i);
        }
        return com.kwad.sdk.e.b.a(false, str, 1);
    }

    private static String getAppId() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getAppId();
    }

    public static String getDeviceId() {
        return bT(false);
    }

    public static String getOaid() {
        return bS(false);
    }

    private static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String h(Context context, boolean z) {
        String cN = bj.cN(context);
        if (!z) {
            if (TextUtils.isEmpty(cN)) {
                return "";
            }
            return cN;
        }
        if (!TextUtils.isEmpty(cN)) {
            return com.kwad.sdk.e.b.a(av.usePhoneStateDisable(), cN, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, cN, 4);
        }
        int i = 1;
        if (!av.usePhoneStateDisable() && o.LX()) {
            if (SystemUtil.di(context)) {
                i = 3;
            }
            return com.kwad.sdk.e.b.a(false, cN, i);
        }
        return com.kwad.sdk.e.b.a(false, cN, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i(Context context, boolean z) {
        String dr = bj.dr(context);
        if (!z) {
            if (TextUtils.isEmpty(dr)) {
                return "";
            }
            return dr;
        }
        if (!TextUtils.isEmpty(dr)) {
            return com.kwad.sdk.e.b.a(av.usePhoneStateDisable(), dr, 0);
        }
        int i = 1;
        if (!av.usePhoneStateDisable() && o.LY()) {
            if (SystemUtil.di(context)) {
                i = 3;
            }
            return com.kwad.sdk.e.b.a(false, dr, i);
        }
        return com.kwad.sdk.e.b.a(false, dr, 1);
    }

    public static void init(Context context) {
        com.kwad.sdk.e.b.a(cW(context));
    }

    public static List<bv.a> o(Context context, int i) {
        return bv.o(context, 15);
    }
}
