package com.kwad.components.ad.fullscreen;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.j;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes11.dex */
public final class g implements com.kwad.components.core.internal.api.a, KsFullScreenVideoAd {
    private com.kwad.components.core.internal.api.c bZ = new com.kwad.components.core.internal.api.c();
    private c gG;
    private AdInfo mAdInfo;

    @NonNull
    private final AdResultData mAdResultData;

    @NonNull
    private AdTemplate mAdTemplate;

    public g(@NonNull AdResultData adResultData) {
        this.mAdResultData = adResultData;
        AdTemplate n = com.kwad.sdk.core.response.b.c.n(adResultData);
        this.mAdTemplate = n;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dS(n);
        com.kwad.components.ad.i.b.eJ().a(this);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean ag() {
        return true;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bZ.b(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.b.a.aQ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aP(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.bd(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.d.CH()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final boolean isAdEnable() {
        if (com.kwad.sdk.core.response.b.e.ei(this.mAdTemplate) >= 0) {
            return true;
        }
        return j.ay(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void setFullScreenVideoAdInteractionListener(KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        if (this.gG == null) {
            this.gG = new c() { // from class: com.kwad.components.ad.fullscreen.g.1
                @Override // com.kwad.components.ad.fullscreen.c, com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onPageDismiss() {
                    super.onPageDismiss();
                    g.this.bZ.i(g.this);
                }

                @Override // com.kwad.components.ad.fullscreen.c, com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onVideoPlayStart() {
                    super.onVideoPlayStart();
                    g.this.bZ.h(g.this);
                }
            };
        }
        this.gG.a(fullScreenVideoAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void showFullScreenVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        if (activity != null && !activity.isFinishing()) {
            com.kwad.components.ad.reward.monitor.c.h(false, this.mAdTemplate);
            com.kwad.sdk.commercial.d.c.bz(this.mAdTemplate);
            if (!com.kwad.sdk.core.config.d.Dp() && !isAdEnable()) {
                com.kwad.sdk.core.e.c.i("KsFullScreenVideoAdControl", "isAdEnable is false");
                com.kwad.components.ad.reward.monitor.c.b(false, this.mAdTemplate, "cache_not_ready");
                return;
            } else {
                if (ksVideoPlayConfig == null) {
                    ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
                }
                KsFullScreenVideoActivityProxy.launch(activity, this.mAdResultData, ksVideoPlayConfig, this.gG);
                return;
            }
        }
        com.kwad.sdk.core.e.c.e("KsFullScreenVideoAdControl", "showFullScreenVideoAd error, activity is null or finished");
        com.kwad.components.ad.reward.monitor.c.b(false, this.mAdTemplate, "illegal_activity");
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bZ.a(bVar);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void setBidEcpm(long j, long j2) {
        com.kwad.sdk.core.adlog.c.l(this.mAdTemplate, j2);
    }
}
