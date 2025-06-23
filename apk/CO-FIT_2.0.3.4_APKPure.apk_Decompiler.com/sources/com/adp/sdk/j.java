package com.adp.sdk;

import android.content.Context;
import com.adp.sdk.dto.ADPConfig;
import com.jd.ad.sdk.bl.initsdk.JADPrivateController;
import com.jd.ad.sdk.dl.baseinfo.JADLocation;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f730a = false;

    public static class a extends JADPrivateController {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ADPConfig f731a;

        public a(ADPConfig aDPConfig) {
            this.f731a = aDPConfig;
        }

        public String getIP() {
            return "";
        }

        public String getImei() {
            return "";
        }

        public JADLocation getLocation() {
            return new JADLocation();
        }

        public String getOaid() {
            return ADP.oaid;
        }

        public boolean isCanUseIP() {
            return !this.f731a.isEnablePersonalRecommend();
        }

        public boolean isCanUseLocation() {
            return !this.f731a.isEnablePersonalRecommend();
        }

        public boolean isCanUsePhoneState() {
            return !this.f731a.isEnablePersonalRecommend();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0049, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean a(android.content.Context r5) {
        /*
            java.lang.Class<com.adp.sdk.j> r0 = com.adp.sdk.j.class
            monitor-enter(r0)
            boolean r1 = f730a     // Catch:{ all -> 0x0046 }
            r2 = 1
            if (r1 == 0) goto L_0x000a
            monitor-exit(r0)
            return r2
        L_0x000a:
            r1 = 0
            if (r5 != 0) goto L_0x000f
            monitor-exit(r0)
            return r1
        L_0x000f:
            com.adp.sdk.dto.AdInfo r3 = com.adp.sdk.a.b     // Catch:{ all -> 0x0046 }
            if (r3 == 0) goto L_0x0048
            java.lang.String r3 = r3.getJingdong()     // Catch:{ all -> 0x0046 }
            boolean r3 = a((java.lang.String) r3)     // Catch:{ all -> 0x0046 }
            if (r3 == 0) goto L_0x001e
            goto L_0x0048
        L_0x001e:
            b(r5)     // Catch:{ all -> 0x0046 }
            com.adp.sdk.dto.ADPConfig r1 = com.adp.sdk.ADP.adpConfig     // Catch:{ all -> 0x0046 }
            com.adp.sdk.j$a r3 = new com.adp.sdk.j$a     // Catch:{ all -> 0x0046 }
            r3.<init>(r1)     // Catch:{ all -> 0x0046 }
            com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig$Builder r1 = new com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig$Builder     // Catch:{ all -> 0x0046 }
            r1.<init>()     // Catch:{ all -> 0x0046 }
            com.adp.sdk.dto.AdInfo r4 = com.adp.sdk.a.b     // Catch:{ all -> 0x0046 }
            java.lang.String r4 = r4.getJingdong()     // Catch:{ all -> 0x0046 }
            com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig$Builder r1 = r1.setAppId(r4)     // Catch:{ all -> 0x0046 }
            com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig$Builder r1 = r1.setPrivateController(r3)     // Catch:{ all -> 0x0046 }
            com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig r1 = r1.build()     // Catch:{ all -> 0x0046 }
            com.jd.ad.sdk.bl.initsdk.JADYunSdk.init(r5, r1)     // Catch:{ all -> 0x0046 }
            f730a = r2     // Catch:{ all -> 0x0046 }
            monitor-exit(r0)
            return r2
        L_0x0046:
            r5 = move-exception
            goto L_0x004a
        L_0x0048:
            monitor-exit(r0)
            return r1
        L_0x004a:
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adp.sdk.j.a(android.content.Context):boolean");
    }

    private static void b(Context context) {
    }

    public static boolean a() {
        return f730a;
    }

    private static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }
}
