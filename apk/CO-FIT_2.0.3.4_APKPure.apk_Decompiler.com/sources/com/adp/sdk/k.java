package com.adp.sdk;

import com.adp.sdk.dto.ADPConfig;
import oOoIIO0.oO;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f734a = false;

    public static class a extends oO {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ADPConfig f735a;

        public a(ADPConfig aDPConfig) {
            this.f735a = aDPConfig;
        }

        public String getImei() {
            return "";
        }

        public String getOaid() {
            return ADP.oaid;
        }

        public boolean isCanUsePhoneState() {
            return !this.f735a.isEnablePersonalRecommend();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0050, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean a(android.content.Context r6) {
        /*
            java.lang.Class<com.adp.sdk.k> r0 = com.adp.sdk.k.class
            monitor-enter(r0)
            boolean r1 = f734a     // Catch:{ all -> 0x002f }
            r2 = 1
            if (r1 == 0) goto L_0x000a
            monitor-exit(r0)
            return r2
        L_0x000a:
            r1 = 0
            if (r6 != 0) goto L_0x000f
            monitor-exit(r0)
            return r1
        L_0x000f:
            com.adp.sdk.dto.AdInfo r3 = com.adp.sdk.a.b     // Catch:{ all -> 0x002f }
            if (r3 == 0) goto L_0x004f
            java.lang.String r3 = r3.getOctopus()     // Catch:{ all -> 0x002f }
            boolean r3 = a((java.lang.String) r3)     // Catch:{ all -> 0x002f }
            if (r3 == 0) goto L_0x001e
            goto L_0x004f
        L_0x001e:
            java.lang.String r3 = "com.octopus.ad.Octopus"
            boolean r3 = com.adp.sdk.utils.b.a(r3)     // Catch:{ all -> 0x002f }
            if (r3 != 0) goto L_0x0031
            java.lang.String r6 = "adsplus"
            java.lang.String r2 = "octo not found"
            android.util.Log.e(r6, r2)     // Catch:{ all -> 0x002f }
            monitor-exit(r0)
            return r1
        L_0x002f:
            r6 = move-exception
            goto L_0x0051
        L_0x0031:
            com.adp.sdk.dto.ADPConfig r3 = com.adp.sdk.ADP.adpConfig     // Catch:{ all -> 0x002f }
            com.adp.sdk.dto.AdInfo r4 = com.adp.sdk.a.b     // Catch:{ all -> 0x002f }
            java.lang.String r4 = r4.getOctopus()     // Catch:{ all -> 0x002f }
            com.adp.sdk.k$a r5 = new com.adp.sdk.k$a     // Catch:{ all -> 0x002f }
            r5.<init>(r3)     // Catch:{ all -> 0x002f }
            oOoIIO0.x0XOIxOo.Oxx0IOOO(r6, r4, r5)     // Catch:{ all -> 0x002f }
            oOoIIO0.x0XOIxOo.x0XOIxOo(r1)     // Catch:{ all -> 0x002f }
            boolean r6 = r3.isEnablePersonalRecommend()     // Catch:{ all -> 0x002f }
            oOoIIO0.x0XOIxOo.oO(r6)     // Catch:{ all -> 0x002f }
            f734a = r2     // Catch:{ all -> 0x002f }
            monitor-exit(r0)
            return r2
        L_0x004f:
            monitor-exit(r0)
            return r1
        L_0x0051:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adp.sdk.k.a(android.content.Context):boolean");
    }

    public static boolean a() {
        return f734a;
    }

    private static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }
}
