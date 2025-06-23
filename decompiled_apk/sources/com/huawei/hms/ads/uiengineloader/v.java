package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.ads.dynamic.DynamicModule;

/* loaded from: classes10.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17360a = "ads_KitLoadStrategy";
    private static final String b = "content://com.huawei.hwid.pps.apiprovider/check_uiengine";
    private static final int c = 30472100;
    private static final byte[] d = new byte[0];

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004c, code lost:
    
        r2 = com.huawei.hms.ads.uiengineloader.aa.b(r10, r6);
        r4 = android.text.TextUtils.isEmpty(r2);
        com.huawei.hms.ads.uiengineloader.af.b("HiAdTools", "is sign empty: ".concat(java.lang.String.valueOf(r4)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
    
        if (r4 != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0067, code lost:
    
        if (com.huawei.hms.ads.dynamic.DynamicModule.getCommonInter() == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0069, code lost:
    
        r3 = com.huawei.hms.ads.dynamic.DynamicModule.getCommonInter().isTrustApp(r6, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0072, code lost:
    
        com.huawei.hms.ads.uiengineloader.af.d("LoaderHandler", "DynamicModule.commonInter is null");
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0083, code lost:
    
        r2 = new org.json.JSONObject();
        r2.put(com.huawei.openalliance.ad.constant.w.az, r12);
        r10 = r10.getContentResolver().query(android.net.Uri.parse(com.huawei.hms.ads.uiengineloader.v.b), null, r11, new java.lang.String[]{r2.toString()}, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a5, code lost:
    
        if (r10 == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a7, code lost:
    
        com.huawei.hms.ads.uiengineloader.af.b(com.huawei.hms.ads.uiengineloader.v.f17360a, "query success.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b0, code lost:
    
        return r10.getExtras();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b8, code lost:
    
        throw new com.huawei.hms.ads.dynamicloader.j("query ret is null");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.os.Bundle a(android.content.Context r10, java.lang.String r11, int r12) throws com.huawei.hms.ads.dynamicloader.j {
        /*
            java.lang.String r0 = "ads_KitLoadStrategy"
            java.lang.String r1 = "content://com.huawei.hwid.pps.apiprovider/check_uiengine"
            android.net.Uri r2 = android.net.Uri.parse(r1)     // Catch: java.lang.Exception -> L47
            r3 = 0
            if (r10 == 0) goto L81
            if (r2 != 0) goto Lf
            goto L81
        Lf:
            android.content.pm.PackageManager r4 = r10.getPackageManager()     // Catch: java.lang.Exception -> L47
            java.lang.String r2 = r2.getAuthority()     // Catch: java.lang.Exception -> L47
            android.content.pm.ProviderInfo r2 = r4.resolveContentProvider(r2, r3)     // Catch: java.lang.Exception -> L47
            java.lang.String r5 = "HiAdTools"
            if (r2 == 0) goto L7c
            android.content.pm.ApplicationInfo r2 = r2.applicationInfo     // Catch: java.lang.Exception -> L47
            if (r2 == 0) goto L81
            java.lang.String r6 = r2.packageName     // Catch: java.lang.Exception -> L47
            java.lang.String r7 = "Target provider service's package name is : "
            java.lang.String r8 = java.lang.String.valueOf(r6)     // Catch: java.lang.Exception -> L47
            java.lang.String r7 = r7.concat(r8)     // Catch: java.lang.Exception -> L47
            com.huawei.hms.ads.uiengineloader.af.b(r5, r7)     // Catch: java.lang.Exception -> L47
            if (r6 == 0) goto L81
            java.lang.String r7 = r10.getPackageName()     // Catch: java.lang.Exception -> L47
            int r4 = r4.checkSignatures(r7, r6)     // Catch: java.lang.Exception -> L47
            r7 = 1
            if (r4 == 0) goto L4a
            int r2 = r2.flags     // Catch: java.lang.Exception -> L47
            r2 = r2 & r7
            if (r2 != r7) goto L45
            goto L4a
        L45:
            r7 = 0
            goto L4a
        L47:
            r10 = move-exception
            goto Lc1
        L4a:
            if (r7 != 0) goto L7a
            java.lang.String r2 = com.huawei.hms.ads.uiengineloader.aa.b(r10, r6)     // Catch: java.lang.Exception -> L47
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L47
            java.lang.String r8 = "is sign empty: "
            java.lang.String r9 = java.lang.String.valueOf(r4)     // Catch: java.lang.Exception -> L47
            java.lang.String r8 = r8.concat(r9)     // Catch: java.lang.Exception -> L47
            com.huawei.hms.ads.uiengineloader.af.b(r5, r8)     // Catch: java.lang.Exception -> L47
            if (r4 != 0) goto L7a
            com.huawei.hms.ads.common.inter.LoaderCommonInter r4 = com.huawei.hms.ads.dynamic.DynamicModule.getCommonInter()     // Catch: java.lang.Exception -> L47
            if (r4 == 0) goto L72
            com.huawei.hms.ads.common.inter.LoaderCommonInter r3 = com.huawei.hms.ads.dynamic.DynamicModule.getCommonInter()     // Catch: java.lang.Exception -> L47
            boolean r3 = r3.isTrustApp(r6, r2)     // Catch: java.lang.Exception -> L47
            goto L81
        L72:
            java.lang.String r2 = "LoaderHandler"
            java.lang.String r4 = "DynamicModule.commonInter is null"
            com.huawei.hms.ads.uiengineloader.af.d(r2, r4)     // Catch: java.lang.Exception -> L47
            goto L81
        L7a:
            r3 = r7
            goto L81
        L7c:
            java.lang.String r2 = "Invalid param"
            com.huawei.hms.ads.uiengineloader.af.d(r5, r2)     // Catch: java.lang.Exception -> L47
        L81:
            if (r3 == 0) goto Lb9
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Exception -> L47
            r2.<init>()     // Catch: java.lang.Exception -> L47
            java.lang.String r3 = "engineInterval"
            r2.put(r3, r12)     // Catch: java.lang.Exception -> L47
            android.content.ContentResolver r4 = r10.getContentResolver()     // Catch: java.lang.Exception -> L47
            android.net.Uri r5 = android.net.Uri.parse(r1)     // Catch: java.lang.Exception -> L47
            java.lang.String r10 = r2.toString()     // Catch: java.lang.Exception -> L47
            java.lang.String[] r8 = new java.lang.String[]{r10}     // Catch: java.lang.Exception -> L47
            java.lang.String r9 = ""
            r6 = 0
            r7 = r11
            android.database.Cursor r10 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L47
            if (r10 == 0) goto Lb1
            java.lang.String r11 = "query success."
            com.huawei.hms.ads.uiengineloader.af.b(r0, r11)     // Catch: java.lang.Exception -> L47
            android.os.Bundle r10 = r10.getExtras()     // Catch: java.lang.Exception -> L47
            return r10
        Lb1:
            com.huawei.hms.ads.dynamicloader.j r10 = new com.huawei.hms.ads.dynamicloader.j     // Catch: java.lang.Exception -> L47
            java.lang.String r11 = "query ret is null"
            r10.<init>(r11)     // Catch: java.lang.Exception -> L47
            throw r10     // Catch: java.lang.Exception -> L47
        Lb9:
            com.huawei.hms.ads.dynamicloader.j r10 = new com.huawei.hms.ads.dynamicloader.j     // Catch: java.lang.Exception -> L47
            java.lang.String r11 = "apiProvider uri is invalid"
            r10.<init>(r11)     // Catch: java.lang.Exception -> L47
            throw r10     // Catch: java.lang.Exception -> L47
        Lc1:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "Failed to call checkNewModule: "
            r11.<init>(r12)
            java.lang.String r10 = r10.getMessage()
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            com.huawei.hms.ads.uiengineloader.af.c(r0, r10)
            com.huawei.hms.ads.dynamicloader.j r10 = new com.huawei.hms.ads.dynamicloader.j
            java.lang.String r11 = "call PPSKit checkNewModule error"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.uiengineloader.v.a(android.content.Context, java.lang.String, int):android.os.Bundle");
    }

    public static /* synthetic */ void b(Context context, String str, int i, String str2) {
        int i2;
        long j;
        int i3;
        try {
            af.b(f17360a, "start queryModule: ".concat(String.valueOf(str)));
            c.a(1, Integer.valueOf(i), null);
            if (DynamicModule.getSpHandler() != null) {
                i2 = DynamicModule.getSpHandler().getLoaderEngin2KitUpdate(str2);
            } else {
                af.d("LoaderHandler", "DynamicModule.spHandler is null");
                i2 = 60000;
            }
            af.a(f17360a, "interval: ".concat(String.valueOf(i2)));
        } catch (Throwable th) {
            c.a(5, Integer.valueOf(i), null);
            af.c(f17360a, "checkRemoteVersion error: " + th.getMessage());
            af.c(f17360a, "start call HMSLoadStrategy");
            t.a(context, str, i);
        }
        synchronized (d) {
            try {
                if (DynamicModule.getSpHandler() != null) {
                    j = DynamicModule.getSpHandler().getKitloaderLastCheckTime();
                } else {
                    af.d("LoaderHandler", "DynamicModule.spHandler is null");
                    j = 0;
                }
                af.a(f17360a, "lastCheckTime: ".concat(String.valueOf(j)));
                if (j <= 0 || System.currentTimeMillis() - j >= i2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (DynamicModule.getSpHandler() != null) {
                        DynamicModule.getSpHandler().setKitloaderLastCheckTime(currentTimeMillis);
                    } else {
                        af.d("LoaderHandler", "DynamicModule.spHandler is null");
                    }
                    if (DynamicModule.getSpHandler() != null) {
                        i3 = DynamicModule.getSpHandler().getLoaderEngineInterval(str2);
                    } else {
                        af.d("LoaderHandler", "DynamicModule.spHandler is null");
                        i3 = 10080000;
                    }
                    af.a(f17360a, "engineInterval: ".concat(String.valueOf(i3)));
                    c.a(2, Integer.valueOf(i), null);
                    Bundle a2 = a(context, str, i3);
                    int i4 = a2.getInt("module_version");
                    Integer valueOf = Integer.valueOf(i4);
                    if (i4 == 0) {
                        af.c(f17360a, "the query module:" + str + " is not existed in PPSKit.");
                        af.c(f17360a, "start call HMSLoadStrategy");
                        t.a(context, str, i);
                        return;
                    }
                    if (i >= i4) {
                        af.b(f17360a, "no update,localVersion: " + i + " reomoteVersion: " + valueOf);
                        return;
                    }
                    c.a(3, Integer.valueOf(i), valueOf);
                    af.b(f17360a, "Ready to cp module.");
                    boolean a3 = x.a(context, a2);
                    af.b(f17360a, "cp remote version by module name:" + str + " ,result:" + a3);
                    if (!a3) {
                        throw new com.huawei.hms.ads.dynamicloader.j("KitLoadStrategy copy module error");
                    }
                    c.a(4, Integer.valueOf(i), valueOf);
                    af.a(f17360a, "bundle info: moduleName:" + str + ", moduleVersion:" + valueOf);
                    af.b(f17360a, "end queryModule: ".concat(String.valueOf(str)));
                }
            } finally {
            }
        }
    }

    private static void c(Context context, String str, int i, String str2) {
        int i2;
        long j;
        int i3;
        try {
            af.b(f17360a, "start queryModule: ".concat(String.valueOf(str)));
            c.a(1, Integer.valueOf(i), null);
            if (DynamicModule.getSpHandler() != null) {
                i2 = DynamicModule.getSpHandler().getLoaderEngin2KitUpdate(str2);
            } else {
                af.d("LoaderHandler", "DynamicModule.spHandler is null");
                i2 = 60000;
            }
            af.a(f17360a, "interval: ".concat(String.valueOf(i2)));
        } catch (Throwable th) {
            c.a(5, Integer.valueOf(i), null);
            af.c(f17360a, "checkRemoteVersion error: " + th.getMessage());
            af.c(f17360a, "start call HMSLoadStrategy");
            t.a(context, str, i);
        }
        synchronized (d) {
            try {
                if (DynamicModule.getSpHandler() != null) {
                    j = DynamicModule.getSpHandler().getKitloaderLastCheckTime();
                } else {
                    af.d("LoaderHandler", "DynamicModule.spHandler is null");
                    j = 0;
                }
                af.a(f17360a, "lastCheckTime: ".concat(String.valueOf(j)));
                if (j <= 0 || System.currentTimeMillis() - j >= i2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (DynamicModule.getSpHandler() != null) {
                        DynamicModule.getSpHandler().setKitloaderLastCheckTime(currentTimeMillis);
                    } else {
                        af.d("LoaderHandler", "DynamicModule.spHandler is null");
                    }
                    if (DynamicModule.getSpHandler() != null) {
                        i3 = DynamicModule.getSpHandler().getLoaderEngineInterval(str2);
                    } else {
                        af.d("LoaderHandler", "DynamicModule.spHandler is null");
                        i3 = 10080000;
                    }
                    af.a(f17360a, "engineInterval: ".concat(String.valueOf(i3)));
                    c.a(2, Integer.valueOf(i), null);
                    Bundle a2 = a(context, str, i3);
                    int i4 = a2.getInt("module_version");
                    Integer valueOf = Integer.valueOf(i4);
                    if (i4 == 0) {
                        af.c(f17360a, "the query module:" + str + " is not existed in PPSKit.");
                        af.c(f17360a, "start call HMSLoadStrategy");
                        t.a(context, str, i);
                        return;
                    }
                    if (i >= i4) {
                        af.b(f17360a, "no update,localVersion: " + i + " reomoteVersion: " + valueOf);
                        return;
                    }
                    c.a(3, Integer.valueOf(i), valueOf);
                    af.b(f17360a, "Ready to cp module.");
                    boolean a3 = x.a(context, a2);
                    af.b(f17360a, "cp remote version by module name:" + str + " ,result:" + a3);
                    if (!a3) {
                        throw new com.huawei.hms.ads.dynamicloader.j("KitLoadStrategy copy module error");
                    }
                    c.a(4, Integer.valueOf(i), valueOf);
                    af.a(f17360a, "bundle info: moduleName:" + str + ", moduleVersion:" + valueOf);
                    af.b(f17360a, "end queryModule: ".concat(String.valueOf(str)));
                }
            } finally {
            }
        }
    }

    public static void a(final Context context, final String str, final int i, final String str2) {
        new Thread() { // from class: com.huawei.hms.ads.uiengineloader.v.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                boolean z;
                if (e.a(context) < v.c) {
                    af.b(v.f17360a, "PPSKit is below need version");
                    t.a(context, str, i);
                    return;
                }
                String str3 = str2;
                if (DynamicModule.getSpHandler() != null) {
                    z = DynamicModule.getSpHandler().getLoaderEngineUpdate(str3);
                } else {
                    af.d("LoaderHandler", "DynamicModule.spHandler is null");
                    z = false;
                }
                if (z) {
                    v.b(context, str, i, str2);
                } else {
                    af.b(v.f17360a, "engineUpdate is close");
                    t.a(context, str, i);
                }
            }
        }.start();
    }
}
