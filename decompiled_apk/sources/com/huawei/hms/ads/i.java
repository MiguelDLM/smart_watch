package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.hms.ads.utils.c;
import com.huawei.openalliance.ad.inter.HiAd;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public class i implements p, com.huawei.openalliance.ad.inter.listeners.j {
    private static final Integer Z = 2;
    NativeAdConfiguration Code;
    private NativeAd.NativeAdLoadedListener D;
    private String F;
    private AdListener L;
    private Context S;
    com.huawei.openalliance.ad.inter.m V;

    /* renamed from: a, reason: collision with root package name */
    private boolean f17294a = false;
    private int b;
    private boolean c;

    public i(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.S = applicationContext;
        this.F = str;
        this.b = com.huawei.openalliance.ad.utils.n.I(applicationContext);
    }

    private void Code(int i) {
        AdListener adListener = this.L;
        if (adListener != null) {
            adListener.onAdFailed(i);
        }
    }

    private com.huawei.openalliance.ad.inter.i V() {
        if (this.V == null) {
            this.V = new com.huawei.openalliance.ad.inter.m(this.S, new String[]{this.F}, 3);
        }
        return this.V;
    }

    private void V(AdParam adParam) {
        com.huawei.openalliance.ad.inter.m mVar;
        if (adParam == null || (mVar = this.V) == null) {
            return;
        }
        mVar.Code(c.Code(adParam.V()));
        this.V.Code(true);
        this.V.Code(adParam.Code());
        this.V.Code(adParam.getKeywords());
        this.V.Code(adParam.getGender());
        this.V.V(adParam.getTargetingContentUrl());
        this.V.I(adParam.I());
        this.V.Code(adParam.B());
        this.V.Z(adParam.C());
        this.V.Z(adParam.S());
        HiAd.getInstance(this.S).setCountryCode(adParam.Z());
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.j
    public void Code(int i, boolean z) {
        Code(com.huawei.hms.ads.utils.b.Code(i));
        if (z) {
            this.f17294a = false;
        }
    }

    private void V(NativeAdConfiguration nativeAdConfiguration) {
        if (nativeAdConfiguration != null) {
            com.huawei.openalliance.ad.inter.m mVar = this.V;
            if (mVar instanceof com.huawei.openalliance.ad.inter.m) {
                mVar.Code(nativeAdConfiguration);
                Integer V = nativeAdConfiguration.V();
                if (V != null) {
                    if (V.intValue() == -1) {
                        this.V.Code((Integer) 0);
                    } else {
                        this.V.Code(Integer.valueOf(V.intValue() + Z.intValue()));
                    }
                }
                AdSize adSize = nativeAdConfiguration.getAdSize();
                if (adSize != null) {
                    if (AdSize.AD_SIZE_SMART.equals(adSize)) {
                        this.V.Code((Integer) 1);
                    } else {
                        this.V.Code((Integer) 0);
                    }
                    this.V.V(Integer.valueOf(adSize.getWidthPx(this.S)));
                    this.V.I(Integer.valueOf(adSize.getHeightPx(this.S)));
                }
                int adType = nativeAdConfiguration.getAdType();
                if (-1 != adType) {
                    this.V.I(adType);
                }
            }
        }
    }

    @Override // com.huawei.hms.ads.p
    public void Code(AdListener adListener) {
        this.L = adListener;
    }

    @Override // com.huawei.hms.ads.p
    public void Code(AdParam adParam) {
        Code(adParam, 1);
    }

    @Override // com.huawei.hms.ads.p
    public void Code(AdParam adParam, int i) {
        if (TextUtils.isEmpty(this.F)) {
            Code(1);
            fb.V("AdLoadMediator", " ad uint id is invalid.");
            return;
        }
        k.Code().Code(this.S);
        V();
        V(adParam);
        V(this.Code);
        com.huawei.openalliance.ad.inter.m mVar = this.V;
        if (mVar != null) {
            this.f17294a = true;
            mVar.V(i);
            this.V.Code(this);
            this.V.I(this.c);
            this.V.Code(this.b, false);
        }
    }

    @Override // com.huawei.hms.ads.p
    public void Code(NativeAd.NativeAdLoadedListener nativeAdLoadedListener) {
        this.D = nativeAdLoadedListener;
    }

    @Override // com.huawei.hms.ads.p
    public void Code(NativeAdConfiguration nativeAdConfiguration) {
        this.Code = nativeAdConfiguration;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.j
    public void Code(Map<String, List<com.huawei.openalliance.ad.inter.data.g>> map, boolean z) {
        if (z) {
            this.f17294a = false;
        }
        if (map == null || map.size() <= 0) {
            fb.V("AdLoadMediator", " ads map is empty.");
            Code(3);
            return;
        }
        List<com.huawei.openalliance.ad.inter.data.g> list = map.get(this.F);
        if (list == null || list.size() <= 0) {
            return;
        }
        for (com.huawei.openalliance.ad.inter.data.g gVar : list) {
            if (this.D != null && gVar != null) {
                by byVar = new by(this.S, gVar);
                NativeAdConfiguration nativeAdConfiguration = this.Code;
                if (nativeAdConfiguration != null) {
                    byVar.Code(nativeAdConfiguration.Code());
                }
                byVar.Code(this.L);
                this.D.onNativeAdLoaded(byVar);
            }
        }
        AdListener adListener = this.L;
        if (adListener != null) {
            adListener.onAdLoaded();
        }
    }

    @Override // com.huawei.hms.ads.p
    public void Code(boolean z) {
        this.c = z;
    }

    @Override // com.huawei.hms.ads.p
    public boolean Code() {
        return this.f17294a;
    }
}
