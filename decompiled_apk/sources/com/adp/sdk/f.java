package com.adp.sdk;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import com.adp.sdk.dto.ADPConfig;
import com.adp.sdk.dto.AdInfo;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f4709a = false;
    private static boolean b = false;

    /* loaded from: classes.dex */
    public static class a implements TTAdSdk.Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f4710a;

        public a(c cVar) {
            this.f4710a = cVar;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void fail(int i, String str) {
            c cVar = this.f4710a;
            if (cVar != null) {
                cVar.a(-1, "init fail:csj");
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void success() {
            boolean unused = f.f4709a = true;
            c cVar = this.f4710a;
            if (cVar != null) {
                cVar.success();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends TTCustomController {

        /* renamed from: a, reason: collision with root package name */
        String f4711a = null;
        final /* synthetic */ boolean b;
        final /* synthetic */ ADPConfig c;
        final /* synthetic */ Context d;

        /* loaded from: classes.dex */
        public class a extends MediationPrivacyConfig {
            public a() {
            }

            @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
            public boolean isCanUseOaid() {
                return b.this.b;
            }

            @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
            public boolean isLimitPersonalAds() {
                return !b.this.b;
            }

            @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
            public boolean isProgrammaticRecommend() {
                return b.this.b;
            }
        }

        public b(boolean z, ADPConfig aDPConfig, Context context) {
            this.b = z;
            this.c = aDPConfig;
            this.d = context;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediationPrivacyConfig getMediationPrivacyConfig() {
            return new a();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean alist() {
            if (this.b && this.c.getPermissionAppListBoolean()) {
                return true;
            }
            return false;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getAndroidId() {
            if (this.f4711a == null && this.b) {
                this.f4711a = f.a(this.d);
            }
            return this.f4711a;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getDevOaid() {
            return ADP.oaid;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getMacAddress() {
            return super.getMacAddress();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseAndroidId() {
            return this.b;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseLocation() {
            return this.b;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUsePermissionRecordAudio() {
            return false;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUsePhoneState() {
            return this.b;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWifiState() {
            return this.b;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWriteExternal() {
            return this.b;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(int i, String str);

        void success();
    }

    public static boolean b() {
        return b;
    }

    public static synchronized boolean a(Context context, c cVar) {
        synchronized (f.class) {
            try {
                if (f4709a) {
                    return true;
                }
                if (context == null) {
                    return false;
                }
                AdInfo adInfo = com.adp.sdk.a.b;
                if (adInfo != null && (!a(adInfo.getGromore()) || !a(com.adp.sdk.a.b.getBytedance()))) {
                    String bytedance = com.adp.sdk.a.b.getBytedance();
                    if (!a(com.adp.sdk.a.b.getGromore())) {
                        bytedance = com.adp.sdk.a.b.getGromore();
                        b = true;
                        Log.i("adsplus", "useMediation:" + b);
                    }
                    try {
                        a(ADP.adpConfig, context, bytedance, new a(cVar), b);
                        return true;
                    } catch (Exception unused) {
                        return false;
                    }
                }
                return false;
            } finally {
            }
        }
    }

    public static boolean a() {
        return f4709a;
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
        return new TTAdConfig.Builder().appId(str).appName(com.adp.sdk.a.b.getAppname()).allowShowNotify(true).debug(z2).directDownloadNetworkType(4).supportMultiProcess(z).useMediation(z3).customController(new b(!aDPConfig.isEnablePersonalRecommend(), aDPConfig, context)).build();
    }
}
