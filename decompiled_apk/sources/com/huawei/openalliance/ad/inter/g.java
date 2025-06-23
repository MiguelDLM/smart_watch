package com.huawei.openalliance.ad.inter;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.huawei.hms.ads.ck;
import com.huawei.hms.ads.ed;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.af;

/* loaded from: classes10.dex */
public final class g implements h {
    private static final byte[] I = new byte[0];
    private static g V;
    private ed B;
    private AdSlotParam C;
    private com.huawei.openalliance.ad.inter.listeners.f F;
    private Integer S = null;
    private Context Z;

    private g(Context context) {
        this.Z = context.getApplicationContext();
        this.B = ed.Code(context);
        if (ck.V(this.Z)) {
            IntentFilter intentFilter = new IntentFilter(x.bq);
            Intent registerReceiver = this.Z.registerReceiver(null, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
            if (registerReceiver != null && registerReceiver.getAction() != null && registerReceiver.getAction().equals(x.bq)) {
                Log.d("HiAdSplash", "HiAd: getIntent");
                new c(this.Z).onReceive(this.Z, registerReceiver);
            }
            this.Z.registerReceiver(new c(this.Z), intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
            d.Code(this.Z).V();
        }
    }

    public static h Code(Context context) {
        return I(context);
    }

    @Override // com.huawei.openalliance.ad.inter.h
    public com.huawei.openalliance.ad.inter.listeners.f C() {
        return this.F;
    }

    public void Z(final AdSlotParam adSlotParam) {
        fb.V("HiAdSplash", "preloadAd request");
        if (adSlotParam != null) {
            fb.V("HiAdSplash", "request preload splash ad");
            com.huawei.openalliance.ad.utils.h.V(new Runnable() { // from class: com.huawei.openalliance.ad.inter.g.2
                @Override // java.lang.Runnable
                public void run() {
                    adSlotParam.Code(true);
                    adSlotParam.I(g.this.S);
                    AdSlotParam adSlotParam2 = adSlotParam;
                    adSlotParam2.Code(com.huawei.hms.ads.utils.c.Code(adSlotParam2.B()));
                    if (ck.Code(g.this.Z).V()) {
                        adSlotParam.I(com.huawei.openalliance.ad.utils.a.Code(g.this.Z));
                    }
                    adSlotParam.a(com.huawei.openalliance.ad.utils.d.d(g.this.Z));
                    adSlotParam.Z(com.huawei.hms.ads.g.Code());
                    com.huawei.openalliance.ad.ipc.g.V(g.this.Z).Code("reqPreSplashAd", aa.V(adSlotParam), null, null);
                }
            });
            af.Code(this.Z, adSlotParam.B());
        }
    }

    private static h I(Context context) {
        g gVar;
        synchronized (I) {
            try {
                if (V == null) {
                    V = new g(context);
                }
                gVar = V;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    @Override // com.huawei.openalliance.ad.inter.h
    public void C(int i) {
        if (1 == i || 2 == i) {
            ed.Code(this.Z).S(i);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.h
    public void Code() {
        Z(this.C);
    }

    @Override // com.huawei.openalliance.ad.inter.h
    public Integer I() {
        return this.S;
    }

    public void I(AdSlotParam adSlotParam) {
        if (adSlotParam != null) {
            this.C = adSlotParam.g();
        }
    }
}
