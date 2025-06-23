package com.adp.sdk;

import android.content.Context;
import android.util.Log;
import com.adp.sdk.dto.ADPConfig;
import com.adp.sdk.dto.AdInfo;
import oOoIIO0.oO;
import oOoIIO0.x0XOIxOo;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f4728a = false;

    /* loaded from: classes.dex */
    public static class a extends oO {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ADPConfig f4729a;

        public a(ADPConfig aDPConfig) {
            this.f4729a = aDPConfig;
        }

        @Override // oOoIIO0.oO
        public String getImei() {
            return "";
        }

        @Override // oOoIIO0.oO
        public String getOaid() {
            return ADP.oaid;
        }

        @Override // oOoIIO0.oO
        public boolean isCanUsePhoneState() {
            return !this.f4729a.isEnablePersonalRecommend();
        }
    }

    public static synchronized boolean a(Context context) {
        synchronized (k.class) {
            if (f4728a) {
                return true;
            }
            if (context == null) {
                return false;
            }
            AdInfo adInfo = com.adp.sdk.a.b;
            if (adInfo != null && !a(adInfo.getOctopus())) {
                if (!com.adp.sdk.utils.b.a("com.octopus.ad.Octopus")) {
                    Log.e("adsplus", "octo not found");
                    return false;
                }
                ADPConfig aDPConfig = ADP.adpConfig;
                x0XOIxOo.Oxx0IOOO(context, com.adp.sdk.a.b.getOctopus(), new a(aDPConfig));
                x0XOIxOo.x0XOIxOo(false);
                x0XOIxOo.oO(aDPConfig.isEnablePersonalRecommend());
                f4728a = true;
                return true;
            }
            return false;
        }
    }

    public static boolean a() {
        return f4728a;
    }

    private static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }
}
