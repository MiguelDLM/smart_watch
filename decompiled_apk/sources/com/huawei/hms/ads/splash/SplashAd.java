package com.huawei.hms.ads.splash;

import android.content.Context;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.utils.c;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.ipc.g;
import com.huawei.openalliance.ad.utils.d;
import com.huawei.openalliance.ad.utils.h;
import com.huawei.openalliance.ad.utils.n;
import java.util.ArrayList;

@GlobalApi
/* loaded from: classes10.dex */
public class SplashAd {
    private static int Z;

    private static int Code(Context context, int i) {
        if (i != 0) {
            return (i == 1 || context == null || context.getResources().getConfiguration().orientation != 2) ? 1 : 0;
        }
        return 0;
    }

    @GlobalApi
    public static void dismissExSplashSlogan(final Context context) {
        h.I(new Runnable() { // from class: com.huawei.hms.ads.splash.SplashAd.1
            @Override // java.lang.Runnable
            public void run() {
                g.V(context).Code(s.k, null, null, null);
            }
        });
    }

    @GlobalApi
    public static boolean isExSplashEnable(Context context) {
        return d.L(context);
    }

    @GlobalApi
    public static void preloadAd(Context context, String str, int i, AdParam adParam) {
        if (context == null || str == null) {
            return;
        }
        Z = n.I(context);
        com.huawei.openalliance.ad.inter.h Code = com.huawei.openalliance.ad.inter.g.Code(context);
        if (Code instanceof com.huawei.openalliance.ad.inter.g) {
            AdSlotParam.a aVar = new AdSlotParam.a();
            Code(context, str, i, adParam, aVar);
            ((com.huawei.openalliance.ad.inter.g) Code).I(aVar.S());
            Code.Code();
        }
    }

    @GlobalApi
    public static void setDefaultSplashMode(Context context, int i) {
        com.huawei.openalliance.ad.inter.g.Code(context).C(i);
    }

    @GlobalApi
    public static void setSloganShowTimeWhenNoAd(final Context context, final int i) {
        h.I(new Runnable() { // from class: com.huawei.hms.ads.splash.SplashAd.2
            @Override // java.lang.Runnable
            public void run() {
                g.V(context).Code(s.l, String.valueOf(i), null, null);
            }
        });
    }

    @GlobalApi
    public void dismissExSplash(final Context context) {
        h.I(new Runnable() { // from class: com.huawei.hms.ads.splash.SplashAd.3
            @Override // java.lang.Runnable
            public void run() {
                g.V(context).Code(s.m, null, null, null);
            }
        });
    }

    @GlobalApi
    public void setExSplashShowTime(final Context context, final int i) {
        h.I(new Runnable() { // from class: com.huawei.hms.ads.splash.SplashAd.4
            @Override // java.lang.Runnable
            public void run() {
                g.V(context).Code(s.n, String.valueOf(i), null, null);
            }
        });
    }

    public static void Code(Context context, String str, int i, AdParam adParam, AdSlotParam.a aVar) {
        if (adParam == null || aVar == null) {
            return;
        }
        aVar.V(Z).I(d.Z(context)).Z(d.B(context)).Code(c.Code(adParam.V())).S(adParam.getGender()).V(adParam.getTargetingContentUrl()).Code(adParam.getKeywords()).I(adParam.I()).C(adParam.C());
        if (adParam.Code() != null) {
            aVar.Code(adParam.Code());
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(str);
        aVar.Code(arrayList).Code(Code(context, i));
    }
}
