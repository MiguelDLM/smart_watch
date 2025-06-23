package com.adp.sdk;

import android.util.Log;
import com.alimm.tanx.core.TanxInitListener;

public class l {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static boolean f736a = false;

    public static class a implements TanxInitListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f737a;

        public a(b bVar) {
            this.f737a = bVar;
        }

        public void error(int i, String str) {
            b bVar = this.f737a;
            if (bVar != null) {
                bVar.a(i, str);
            }
            boolean unused = l.f736a = false;
        }

        public void succ() {
            boolean unused = l.f736a = true;
            b bVar = this.f737a;
            if (bVar != null) {
                bVar.success();
            }
        }
    }

    public interface b {
        void a(int i, String str);

        void success();
    }

    public static boolean b() {
        if (com.adp.sdk.utils.b.a("com.alimm.tanx.ui.TanxSdk")) {
            return true;
        }
        Log.e("adsplus", "tanx not found");
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0045, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x005e, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x013b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean a(android.app.Application r9, com.adp.sdk.l.b r10) {
        /*
            java.lang.Class<com.adp.sdk.l> r0 = com.adp.sdk.l.class
            monitor-enter(r0)
            boolean r1 = f736a     // Catch:{ all -> 0x002b }
            r2 = 1
            if (r1 == 0) goto L_0x000a
            monitor-exit(r0)
            return r2
        L_0x000a:
            r1 = 0
            if (r9 != 0) goto L_0x000f
            monitor-exit(r0)
            return r1
        L_0x000f:
            com.adp.sdk.dto.AdInfo r3 = com.adp.sdk.a.b     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x013a
            java.lang.String r3 = r3.getTanx()     // Catch:{ all -> 0x002b }
            boolean r3 = a((java.lang.String) r3)     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x002e
            com.adp.sdk.dto.AdInfo r3 = com.adp.sdk.a.b     // Catch:{ all -> 0x002b }
            java.lang.String r3 = r3.getTanx()     // Catch:{ all -> 0x002b }
            boolean r3 = a((java.lang.String) r3)     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x002e
            goto L_0x013a
        L_0x002b:
            r9 = move-exception
            goto L_0x013c
        L_0x002e:
            com.adp.sdk.dto.AdInfo r3 = com.adp.sdk.a.b     // Catch:{ all -> 0x002b }
            java.lang.String r3 = r3.getTanx()     // Catch:{ all -> 0x002b }
            java.lang.String r4 = "#"
            boolean r3 = r3.contains(r4)     // Catch:{ all -> 0x002b }
            r4 = -1
            if (r3 != 0) goto L_0x0046
            if (r10 == 0) goto L_0x0044
            java.lang.String r9 = "tanx appid or appkey is not correct"
            r10.a(r4, r9)     // Catch:{ all -> 0x002b }
        L_0x0044:
            monitor-exit(r0)
            return r1
        L_0x0046:
            com.adp.sdk.dto.AdInfo r3 = com.adp.sdk.a.b     // Catch:{ all -> 0x002b }
            java.lang.String r3 = r3.getTanx()     // Catch:{ all -> 0x002b }
            java.lang.String r5 = "#"
            java.lang.String[] r3 = r3.split(r5)     // Catch:{ all -> 0x002b }
            int r3 = r3.length     // Catch:{ all -> 0x002b }
            r5 = 2
            if (r3 >= r5) goto L_0x005f
            if (r10 == 0) goto L_0x005d
            java.lang.String r9 = "tanx appid or appkey is not correct"
            r10.a(r4, r9)     // Catch:{ all -> 0x002b }
        L_0x005d:
            monitor-exit(r0)
            return r1
        L_0x005f:
            com.adp.sdk.dto.AdInfo r3 = com.adp.sdk.a.b     // Catch:{ all -> 0x002b }
            java.lang.String r3 = r3.getTanx()     // Catch:{ all -> 0x002b }
            java.lang.String r4 = "#"
            java.lang.String[] r3 = r3.split(r4)     // Catch:{ all -> 0x002b }
            r3 = r3[r1]     // Catch:{ all -> 0x002b }
            java.lang.String r3 = r3.trim()     // Catch:{ all -> 0x002b }
            com.adp.sdk.dto.AdInfo r4 = com.adp.sdk.a.b     // Catch:{ all -> 0x002b }
            java.lang.String r4 = r4.getTanx()     // Catch:{ all -> 0x002b }
            java.lang.String r5 = "#"
            java.lang.String[] r4 = r4.split(r5)     // Catch:{ all -> 0x002b }
            r4 = r4[r2]     // Catch:{ all -> 0x002b }
            java.lang.String r4 = r4.trim()     // Catch:{ all -> 0x002b }
            com.adp.sdk.dto.ADPConfig r5 = com.adp.sdk.ADP.adpConfig     // Catch:{ all -> 0x002b }
            if (r5 == 0) goto L_0x00a9
            boolean r6 = r5.isEnablePersonalRecommend()     // Catch:{ all -> 0x002b }
            r6 = r6 ^ r2
            boolean r5 = r5.getDebug()     // Catch:{ all -> 0x002b }
            if (r5 == 0) goto L_0x00aa
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x002b }
            r5.<init>()     // Catch:{ all -> 0x002b }
            java.lang.String r7 = "init tx:"
            r5.append(r7)     // Catch:{ all -> 0x002b }
            r5.append(r6)     // Catch:{ all -> 0x002b }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x002b }
            java.lang.String r7 = "adsplus"
            android.util.Log.e(r7, r5)     // Catch:{ all -> 0x002b }
            goto L_0x00aa
        L_0x00a9:
            r6 = 0
        L_0x00aa:
            if (r6 == 0) goto L_0x00c1
            java.lang.String r5 = com.adp.sdk.ADP.oaid     // Catch:{ all -> 0x002b }
            if (r5 == 0) goto L_0x00c1
            int r5 = r5.length()     // Catch:{ all -> 0x002b }
            if (r5 <= 0) goto L_0x00c1
            java.lang.String r5 = com.adp.sdk.ADP.oaid     // Catch:{ all -> 0x002b }
            java.lang.String r7 = "00000000-0000-0000-0000-000000000000"
            boolean r5 = r5.contains(r7)     // Catch:{ all -> 0x002b }
            if (r5 != 0) goto L_0x00c1
            r6 = 0
        L_0x00c1:
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x002b }
            r5.<init>()     // Catch:{ all -> 0x002b }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x002b }
            r7.<init>()     // Catch:{ all -> 0x002b }
            java.lang.String r8 = "1"
            r7.add(r8)     // Catch:{ all -> 0x002b }
            java.lang.String r8 = "quality"
            r5.put(r8, r7)     // Catch:{ all -> 0x002b }
            com.alimm.tanx.core.config.TanxConfig$Builder r7 = new com.alimm.tanx.core.config.TanxConfig$Builder     // Catch:{ all -> 0x002b }
            r7.<init>()     // Catch:{ all -> 0x002b }
            com.adp.sdk.dto.AdInfo r8 = com.adp.sdk.a.b     // Catch:{ all -> 0x002b }
            java.lang.String r8 = r8.getAppname()     // Catch:{ all -> 0x002b }
            com.alimm.tanx.core.config.TanxConfig$Builder r7 = r7.appName(r8)     // Catch:{ all -> 0x002b }
            com.alimm.tanx.core.config.TanxConfig$Builder r3 = r7.appId(r3)     // Catch:{ all -> 0x002b }
            com.alimm.tanx.core.config.TanxConfig$Builder r3 = r3.appKey(r4)     // Catch:{ all -> 0x002b }
            com.alimm.tanx.core.config.TanxConfig$Builder r3 = r3.oaidSwitch(r6)     // Catch:{ all -> 0x002b }
            com.alimm.tanx.core.config.TanxConfig$Builder r3 = r3.imeiSwitch(r6)     // Catch:{ all -> 0x002b }
            com.alimm.tanx.core.config.TanxConfig$Builder r3 = r3.idAllSwitch(r6)     // Catch:{ all -> 0x002b }
            com.alimm.tanx.core.config.TanxConfig$Builder r3 = r3.netDebug(r1)     // Catch:{ all -> 0x002b }
            com.alimm.tanx.core.config.TanxConfig$Builder r1 = r3.debug(r1)     // Catch:{ all -> 0x002b }
            com.alimm.tanx.core.config.SettingConfig r3 = new com.alimm.tanx.core.config.SettingConfig     // Catch:{ all -> 0x002b }
            r3.<init>()     // Catch:{ all -> 0x002b }
            com.alimm.tanx.core.config.SettingConfig r3 = r3.setNightConfig()     // Catch:{ all -> 0x002b }
            com.alimm.tanx.core.config.TanxConfig$Builder r1 = r1.dark(r3)     // Catch:{ all -> 0x002b }
            com.alimm.tanx.core.config.TanxConfig$Builder r1 = r1.setUserTag(r5)     // Catch:{ all -> 0x002b }
            com.alimm.tanx.core.config.TanxConfig r1 = r1.build()     // Catch:{ all -> 0x002b }
            if (r6 != 0) goto L_0x0130
            java.lang.String r3 = com.adp.sdk.ADP.oaid     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x0130
            int r3 = r3.length()     // Catch:{ all -> 0x002b }
            if (r3 <= 0) goto L_0x0130
            java.lang.String r3 = com.adp.sdk.ADP.oaid     // Catch:{ all -> 0x002b }
            java.lang.String r4 = "00000000-0000-0000-0000-000000000000"
            boolean r3 = r3.contains(r4)     // Catch:{ all -> 0x002b }
            if (r3 != 0) goto L_0x0130
            java.lang.String r3 = com.adp.sdk.ADP.oaid     // Catch:{ all -> 0x002b }
            r1.setmOaid(r3)     // Catch:{ all -> 0x002b }
        L_0x0130:
            com.adp.sdk.l$a r3 = new com.adp.sdk.l$a     // Catch:{ all -> 0x002b }
            r3.<init>(r10)     // Catch:{ all -> 0x002b }
            com.alimm.tanx.ui.TanxSdk.init(r9, r1, r3)     // Catch:{ all -> 0x002b }
            monitor-exit(r0)
            return r2
        L_0x013a:
            monitor-exit(r0)
            return r1
        L_0x013c:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adp.sdk.l.a(android.app.Application, com.adp.sdk.l$b):boolean");
    }

    public static boolean a() {
        return f736a;
    }

    private static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }
}
