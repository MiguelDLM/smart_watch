package com.adp.sdk;

import com.baidu.mobads.sdk.api.BDAdConfig;

public class d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static boolean f713a = false;

    public static class a implements BDAdConfig.BDAdInitListener {
        public void fail() {
        }

        public void success() {
            boolean unused = d.f713a = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008a, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean a(android.content.Context r5, com.adp.sdk.listener.a r6) {
        /*
            java.lang.Class<com.adp.sdk.d> r6 = com.adp.sdk.d.class
            monitor-enter(r6)
            boolean r0 = f713a     // Catch:{ all -> 0x007f }
            r1 = 1
            if (r0 == 0) goto L_0x000a
            monitor-exit(r6)
            return r1
        L_0x000a:
            r0 = 0
            if (r5 != 0) goto L_0x000f
            monitor-exit(r6)
            return r0
        L_0x000f:
            com.adp.sdk.dto.AdInfo r2 = com.adp.sdk.a.b     // Catch:{ all -> 0x007f }
            if (r2 == 0) goto L_0x008d
            java.lang.String r2 = r2.getBaidu()     // Catch:{ all -> 0x007f }
            boolean r2 = a((java.lang.String) r2)     // Catch:{ all -> 0x007f }
            if (r2 == 0) goto L_0x001e
            goto L_0x008d
        L_0x001e:
            com.adp.sdk.dto.ADPConfig r2 = com.adp.sdk.ADP.adpConfig     // Catch:{ all -> 0x007f }
            com.baidu.mobads.sdk.api.BDAdConfig$Builder r3 = new com.baidu.mobads.sdk.api.BDAdConfig$Builder     // Catch:{ Exception -> 0x008b }
            r3.<init>()     // Catch:{ Exception -> 0x008b }
            com.adp.sdk.dto.AdInfo r4 = com.adp.sdk.a.b     // Catch:{ Exception -> 0x008b }
            java.lang.String r4 = r4.getBaidu()     // Catch:{ Exception -> 0x008b }
            com.baidu.mobads.sdk.api.BDAdConfig$Builder r3 = r3.setAppsid(r4)     // Catch:{ Exception -> 0x008b }
            com.baidu.mobads.sdk.api.BDDialogParams$Builder r4 = new com.baidu.mobads.sdk.api.BDDialogParams$Builder     // Catch:{ Exception -> 0x008b }
            r4.<init>()     // Catch:{ Exception -> 0x008b }
            com.baidu.mobads.sdk.api.BDDialogParams$Builder r4 = r4.setDlDialogType(r0)     // Catch:{ Exception -> 0x008b }
            com.baidu.mobads.sdk.api.BDDialogParams$Builder r4 = r4.setDlDialogAnimStyle(r0)     // Catch:{ Exception -> 0x008b }
            com.baidu.mobads.sdk.api.BDDialogParams r4 = r4.build()     // Catch:{ Exception -> 0x008b }
            com.baidu.mobads.sdk.api.BDAdConfig$Builder r3 = r3.setDialogParams(r4)     // Catch:{ Exception -> 0x008b }
            com.baidu.mobads.sdk.api.BDAdConfig$Builder r3 = r3.setDebug(r0)     // Catch:{ Exception -> 0x008b }
            java.lang.String r4 = ""
            com.baidu.mobads.sdk.api.BDAdConfig$Builder r3 = r3.setWXAppid(r4)     // Catch:{ Exception -> 0x008b }
            com.adp.sdk.d$a r4 = new com.adp.sdk.d$a     // Catch:{ Exception -> 0x008b }
            r4.<init>()     // Catch:{ Exception -> 0x008b }
            com.baidu.mobads.sdk.api.BDAdConfig$Builder r3 = r3.setBDAdInitListener(r4)     // Catch:{ Exception -> 0x008b }
            com.baidu.mobads.sdk.api.BDAdConfig r5 = r3.build(r5)     // Catch:{ Exception -> 0x008b }
            r5.init()     // Catch:{ Exception -> 0x008b }
            if (r2 == 0) goto L_0x0081
            boolean r5 = r2.isEnablePersonalRecommend()     // Catch:{ Exception -> 0x008b }
            if (r5 != 0) goto L_0x0081
            java.lang.String r5 = "adsplus"
            java.lang.String r3 = "允许"
            android.util.Log.i(r5, r3)     // Catch:{ Exception -> 0x008b }
            com.baidu.mobads.sdk.api.MobadsPermissionSettings.setPermissionReadDeviceID(r1)     // Catch:{ Exception -> 0x008b }
            com.baidu.mobads.sdk.api.MobadsPermissionSettings.setPermissionLocation(r1)     // Catch:{ Exception -> 0x008b }
            com.baidu.mobads.sdk.api.MobadsPermissionSettings.setPermissionStorage(r1)     // Catch:{ Exception -> 0x008b }
            boolean r5 = r2.getPermissionAppListBoolean()     // Catch:{ Exception -> 0x008b }
            com.baidu.mobads.sdk.api.MobadsPermissionSettings.setPermissionAppList(r5)     // Catch:{ Exception -> 0x008b }
            goto L_0x0089
        L_0x007f:
            r5 = move-exception
            goto L_0x008f
        L_0x0081:
            java.lang.String r5 = "adsplus"
            java.lang.String r2 = "不允许"
            android.util.Log.i(r5, r2)     // Catch:{ Exception -> 0x008b }
        L_0x0089:
            monitor-exit(r6)
            return r1
        L_0x008b:
            monitor-exit(r6)
            return r0
        L_0x008d:
            monitor-exit(r6)
            return r0
        L_0x008f:
            monitor-exit(r6)     // Catch:{ all -> 0x007f }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adp.sdk.d.a(android.content.Context, com.adp.sdk.listener.a):boolean");
    }

    public static boolean a() {
        return f713a;
    }

    private static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }
}
