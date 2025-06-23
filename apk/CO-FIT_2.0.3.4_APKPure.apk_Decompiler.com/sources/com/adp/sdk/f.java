package com.adp.sdk;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import com.adp.sdk.dto.ADPConfig;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig;

public class f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static boolean f715a = false;
    private static boolean b = false;

    public static class a implements TTAdSdk.Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f716a;

        public a(c cVar) {
            this.f716a = cVar;
        }

        public void fail(int i, String str) {
            c cVar = this.f716a;
            if (cVar != null) {
                cVar.a(-1, "init fail:csj");
            }
        }

        public void success() {
            boolean unused = f.f715a = true;
            c cVar = this.f716a;
            if (cVar != null) {
                cVar.success();
            }
        }
    }

    public static class b extends TTCustomController {

        /* renamed from: a  reason: collision with root package name */
        String f717a = null;
        final /* synthetic */ boolean b;
        final /* synthetic */ ADPConfig c;
        final /* synthetic */ Context d;

        public class a extends MediationPrivacyConfig {
            public a() {
            }

            public boolean isCanUseOaid() {
                return b.this.b;
            }

            public boolean isLimitPersonalAds() {
                return !b.this.b;
            }

            public boolean isProgrammaticRecommend() {
                return b.this.b;
            }
        }

        public b(boolean z, ADPConfig aDPConfig, Context context) {
            this.b = z;
            this.c = aDPConfig;
            this.d = context;
        }

        /* renamed from: a */
        public MediationPrivacyConfig getMediationPrivacyConfig() {
            return new a();
        }

        public boolean alist() {
            if (!this.b || !this.c.getPermissionAppListBoolean()) {
                return false;
            }
            return true;
        }

        public String getAndroidId() {
            if (this.f717a == null && this.b) {
                this.f717a = f.a(this.d);
            }
            return this.f717a;
        }

        public String getDevOaid() {
            return ADP.oaid;
        }

        public String getMacAddress() {
            return super.getMacAddress();
        }

        public boolean isCanUseAndroidId() {
            return this.b;
        }

        public boolean isCanUseLocation() {
            return this.b;
        }

        public boolean isCanUsePermissionRecordAudio() {
            return false;
        }

        public boolean isCanUsePhoneState() {
            return this.b;
        }

        public boolean isCanUseWifiState() {
            return this.b;
        }

        public boolean isCanUseWriteExternal() {
            return this.b;
        }
    }

    public interface c {
        void a(int i, String str);

        void success();
    }

    public static boolean b() {
        return b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006f, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean a(android.content.Context r6, com.adp.sdk.f.c r7) {
        /*
            java.lang.Class<com.adp.sdk.f> r0 = com.adp.sdk.f.class
            monitor-enter(r0)
            boolean r1 = f715a     // Catch:{ all -> 0x002a }
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
            com.adp.sdk.dto.AdInfo r3 = com.adp.sdk.a.b     // Catch:{ all -> 0x002a }
            if (r3 == 0) goto L_0x006e
            java.lang.String r3 = r3.getGromore()     // Catch:{ all -> 0x002a }
            boolean r3 = a((java.lang.String) r3)     // Catch:{ all -> 0x002a }
            if (r3 == 0) goto L_0x002c
            com.adp.sdk.dto.AdInfo r3 = com.adp.sdk.a.b     // Catch:{ all -> 0x002a }
            java.lang.String r3 = r3.getBytedance()     // Catch:{ all -> 0x002a }
            boolean r3 = a((java.lang.String) r3)     // Catch:{ all -> 0x002a }
            if (r3 == 0) goto L_0x002c
            goto L_0x006e
        L_0x002a:
            r6 = move-exception
            goto L_0x0070
        L_0x002c:
            com.adp.sdk.dto.AdInfo r3 = com.adp.sdk.a.b     // Catch:{ all -> 0x002a }
            java.lang.String r3 = r3.getBytedance()     // Catch:{ all -> 0x002a }
            com.adp.sdk.dto.AdInfo r4 = com.adp.sdk.a.b     // Catch:{ all -> 0x002a }
            java.lang.String r4 = r4.getGromore()     // Catch:{ all -> 0x002a }
            boolean r4 = a((java.lang.String) r4)     // Catch:{ all -> 0x002a }
            if (r4 != 0) goto L_0x005e
            com.adp.sdk.dto.AdInfo r3 = com.adp.sdk.a.b     // Catch:{ all -> 0x002a }
            java.lang.String r3 = r3.getGromore()     // Catch:{ all -> 0x002a }
            b = r2     // Catch:{ all -> 0x002a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
            r4.<init>()     // Catch:{ all -> 0x002a }
            java.lang.String r5 = "useMediation:"
            r4.append(r5)     // Catch:{ all -> 0x002a }
            boolean r5 = b     // Catch:{ all -> 0x002a }
            r4.append(r5)     // Catch:{ all -> 0x002a }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x002a }
            java.lang.String r5 = "adsplus"
            android.util.Log.i(r5, r4)     // Catch:{ all -> 0x002a }
        L_0x005e:
            com.adp.sdk.dto.ADPConfig r4 = com.adp.sdk.ADP.adpConfig     // Catch:{ all -> 0x002a }
            com.adp.sdk.f$a r5 = new com.adp.sdk.f$a     // Catch:{ Exception -> 0x006c }
            r5.<init>(r7)     // Catch:{ Exception -> 0x006c }
            boolean r7 = b     // Catch:{ Exception -> 0x006c }
            a(r4, r6, r3, r5, r7)     // Catch:{ Exception -> 0x006c }
            monitor-exit(r0)
            return r2
        L_0x006c:
            monitor-exit(r0)
            return r1
        L_0x006e:
            monitor-exit(r0)
            return r1
        L_0x0070:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adp.sdk.f.a(android.content.Context, com.adp.sdk.f$c):boolean");
    }

    public static boolean a() {
        return f715a;
    }

    private static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    private static void a(ADPConfig aDPConfig, Context context, String str, TTAdSdk.Callback callback, boolean z) {
        TTAdSdk.init(context, a(aDPConfig, str, false, false, context, z));
        TTAdSdk.start(callback);
    }

    public static String a(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            Log.e("DeviceIdUtil", "Error getting Android ID: " + e.getMessage());
            return null;
        }
    }

    private static TTAdConfig a(ADPConfig aDPConfig, String str, boolean z, boolean z2, Context context, boolean z3) {
        return new TTAdConfig.Builder().appId(str).appName(a.b.getAppname()).allowShowNotify(true).debug(z2).directDownloadNetworkType(4).supportMultiProcess(z).useMediation(z3).customController(new b(!aDPConfig.isEnablePersonalRecommend(), aDPConfig, context)).build();
    }
}
