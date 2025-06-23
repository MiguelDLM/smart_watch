package com.adp.sdk;

import android.content.Context;
import com.adp.sdk.dto.ADPConfig;
import com.adp.sdk.dto.AdInfo;
import com.jd.ad.sdk.bl.initsdk.JADPrivateController;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig;
import com.jd.ad.sdk.dl.baseinfo.JADLocation;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f4724a = false;

    /* loaded from: classes.dex */
    public static class a extends JADPrivateController {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ADPConfig f4725a;

        public a(ADPConfig aDPConfig) {
            this.f4725a = aDPConfig;
        }

        @Override // com.jd.ad.sdk.bl.initsdk.JADPrivateController
        public String getIP() {
            return "";
        }

        @Override // com.jd.ad.sdk.bl.initsdk.JADPrivateController
        public String getImei() {
            return "";
        }

        @Override // com.jd.ad.sdk.bl.initsdk.JADPrivateController
        public JADLocation getLocation() {
            return new JADLocation();
        }

        @Override // com.jd.ad.sdk.bl.initsdk.JADPrivateController
        public String getOaid() {
            return ADP.oaid;
        }

        @Override // com.jd.ad.sdk.bl.initsdk.JADPrivateController
        public boolean isCanUseIP() {
            return !this.f4725a.isEnablePersonalRecommend();
        }

        @Override // com.jd.ad.sdk.bl.initsdk.JADPrivateController
        public boolean isCanUseLocation() {
            return !this.f4725a.isEnablePersonalRecommend();
        }

        @Override // com.jd.ad.sdk.bl.initsdk.JADPrivateController
        public boolean isCanUsePhoneState() {
            return !this.f4725a.isEnablePersonalRecommend();
        }
    }

    public static synchronized boolean a(Context context) {
        synchronized (j.class) {
            if (f4724a) {
                return true;
            }
            if (context == null) {
                return false;
            }
            AdInfo adInfo = com.adp.sdk.a.b;
            if (adInfo != null && !a(adInfo.getJingdong())) {
                b(context);
                JADYunSdk.init(context, new JADYunSdkConfig.Builder().setAppId(com.adp.sdk.a.b.getJingdong()).setPrivateController(new a(ADP.adpConfig)).build());
                f4724a = true;
                return true;
            }
            return false;
        }
    }

    private static void b(Context context) {
    }

    public static boolean a() {
        return f4724a;
    }

    private static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }
}
