package com.huawei.hms.ads;

import android.content.Context;
import com.google.android.exoplayer2.ExoPlayer;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import java.util.concurrent.Callable;

/* loaded from: classes10.dex */
public class fl extends fj {
    public fl(kk kkVar) {
        super(kkVar);
    }

    private void o() {
        com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.fl.3
            @Override // java.lang.Runnable
            public void run() {
                fl.this.c();
            }
        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    @Override // com.huawei.hms.ads.fj
    public void I(AdContentData adContentData) {
    }

    @Override // com.huawei.hms.ads.fj
    public String d() {
        return String.valueOf(1);
    }

    @Override // com.huawei.hms.ads.fn
    public void m() {
        fb.V("CacheAdMediator", "start");
        kk g = g();
        if (g == null) {
            I(-4);
            a();
            return;
        }
        AdContentData adContentData = this.C.Z() != 0 ? (AdContentData) com.huawei.openalliance.ad.utils.ba.Code(new Callable<AdContentData>() { // from class: com.huawei.hms.ads.fl.1
            @Override // java.util.concurrent.Callable
            /* renamed from: Code, reason: merged with bridge method [inline-methods] */
            public AdContentData call() {
                Context context;
                AdSlotParam b = fl.this.b();
                if (b == null || (context = fl.this.e) == null) {
                    fb.I("CacheAdMediator", "adslot is null");
                    return null;
                }
                CallResult Code = com.huawei.openalliance.ad.ipc.b.Code(context).Code("queryCacheSplashAd", com.huawei.openalliance.ad.utils.aa.V(b), String.class);
                fl.this.d = (String) Code.getData();
                return (AdContentData) com.huawei.openalliance.ad.utils.aa.V((String) Code.getData(), AdContentData.class, new Class[0]);
            }
        }, null) : null;
        this.B = adContentData;
        this.S = true;
        if (adContentData == null) {
            fb.V("CacheAdMediator", "show sloganView");
            g.Code(new ky() { // from class: com.huawei.hms.ads.fl.2
                @Override // com.huawei.hms.ads.ky
                public void Code() {
                    fb.V("CacheAdMediator", "on Slogan Reach Min Show Time");
                }

                @Override // com.huawei.hms.ads.ky
                public void V() {
                    fb.V("CacheAdMediator", "on Slogan Show End");
                    com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.fl.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            fl.this.I(com.huawei.openalliance.ad.constant.ah.x);
                            fl.this.a();
                        }
                    });
                }
            });
        } else {
            if (adContentData.l() == 12) {
                if (Z() != 1 || !(I() instanceof com.huawei.openalliance.ad.inter.listeners.m)) {
                    I(1200);
                    n();
                    o();
                    return;
                }
                com.huawei.openalliance.ad.inter.listeners.m mVar = (com.huawei.openalliance.ad.inter.listeners.m) I();
                com.huawei.openalliance.ad.inter.data.k Code = jd.Code(adContentData);
                fb.V("CacheAdMediator", "on content find, linkedAd loaded. ");
                this.F = System.currentTimeMillis();
                mVar.Code(Code);
                this.L = adContentData;
                o();
                B(200);
                return;
            }
            if (!V(adContentData)) {
                I(com.huawei.openalliance.ad.constant.ah.w);
                n();
            }
        }
        o();
    }

    @Override // com.huawei.hms.ads.fn
    public void n() {
        fb.V("CacheAdMediator", "onAdFailToDisplay");
        a();
    }
}
