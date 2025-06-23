package com.adp.sdk;

import android.content.Context;
import android.util.Log;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.InformationController;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f4715a = false;

    public static synchronized boolean a(Context context) {
        synchronized (h.class) {
            if (f4715a) {
                return true;
            }
            HwAds.init(context);
            f4715a = true;
            return true;
        }
    }

    public static boolean a() {
        return f4715a;
    }

    public static AdParam a(int i) {
        if (ADP.adpConfig == null) {
            return new AdParam.Builder().build();
        }
        AdParam.Builder builder = new AdParam.Builder();
        boolean isEnablePersonalRecommend = ADP.adpConfig.isEnablePersonalRecommend();
        boolean z = !isEnablePersonalRecommend;
        if (!isEnablePersonalRecommend) {
            builder.setNonPersonalizedAd(0);
            builder.setHwNonPersonalizedAd(0);
            builder.setRequestLocation(true);
            Log.i("adsplus", "动能个性化");
        } else {
            builder.setNonPersonalizedAd(1);
            builder.setHwNonPersonalizedAd(1);
            builder.setRequestLocation(false);
        }
        builder.setTMax(Integer.valueOf(i));
        HwAds.setInfoController(new InformationController.Builder().setUseWifi(Boolean.valueOf(z)).setUseBluetooth(Boolean.valueOf(z)).setUseAndroidId(Boolean.valueOf(z)).build());
        return builder.build();
    }
}
