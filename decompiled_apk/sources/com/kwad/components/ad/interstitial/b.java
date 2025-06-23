package com.kwad.components.ad.interstitial;

import android.app.Activity;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes11.dex */
public final class b implements com.kwad.components.core.internal.api.a, KsInterstitialAd {
    private com.kwad.components.core.internal.api.c bZ = new com.kwad.components.core.internal.api.c();
    private KsScene hU;
    private c hV;
    private d hW;

    @NonNull
    private final AdResultData mAdResultData;

    @NonNull
    private final AdTemplate mAdTemplate;

    public b(@NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
        this.hU = ksScene;
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.n(adResultData);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean ag() {
        return true;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.b.a.aQ(com.kwad.sdk.core.response.b.e.dS(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aP(com.kwad.sdk.core.response.b.e.dS(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.bd(com.kwad.sdk.core.response.b.e.dS(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.d.CH()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final boolean isVideo() {
        return com.kwad.sdk.core.response.b.a.bb(com.kwad.sdk.core.response.b.e.dS(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setAdInteractionListener(@NonNull KsInterstitialAd.AdInteractionListener adInteractionListener) {
        if (this.hV == null) {
            this.hV = new c() { // from class: com.kwad.components.ad.interstitial.b.1
                @Override // com.kwad.components.ad.interstitial.c, com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public final void onAdShow() {
                    super.onAdShow();
                    com.kwad.components.ad.interstitial.report.a.dN().m(b.this.mAdTemplate);
                    b.this.bZ.h(b.this);
                }

                @Override // com.kwad.components.ad.interstitial.c, com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public final void onPageDismiss() {
                    super.onPageDismiss();
                    com.kwad.components.ad.interstitial.report.a.dN().n(b.this.mAdTemplate);
                    b.this.bZ.i(b.this);
                }
            };
        }
        this.hV.a(adInteractionListener);
        d dVar = this.hW;
        if (dVar != null) {
            dVar.setAdInteractionListener(this.hV);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void showInterstitialAd(Activity activity, @Nullable KsVideoPlayConfig ksVideoPlayConfig) {
        com.kwad.components.ad.interstitial.report.c.dR().p(this.mAdTemplate);
        if (com.kwad.sdk.core.config.d.Cj() && (activity == null || activity.isFinishing())) {
            com.kwad.sdk.core.c.b.En();
            activity = com.kwad.sdk.core.c.b.getCurrentActivity();
        }
        if (activity != null && !activity.isFinishing()) {
            if (!l.zJ().yY()) {
                com.kwad.components.ad.interstitial.report.c dR = com.kwad.components.ad.interstitial.report.c.dR();
                AdTemplate adTemplate = this.mAdTemplate;
                com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.awR;
                dR.a(adTemplate, eVar.errorCode, eVar.msg);
                com.kwad.sdk.core.e.c.e("StayAdHelper", "showInterstitialAd please init sdk first");
                return;
            }
            if (ksVideoPlayConfig == null) {
                ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
            }
            com.kwad.sdk.commercial.d.c.bz(this.mAdTemplate);
            this.mAdTemplate.adShowStartTimeStamp = SystemClock.elapsedRealtime();
            if (ksVideoPlayConfig.isVideoSoundEnable()) {
                this.mAdTemplate.mInitVoiceStatus = 2;
            } else {
                this.mAdTemplate.mInitVoiceStatus = 1;
            }
            com.kwad.sdk.a.a.c.Au().bj(true);
            if (this.hW == null) {
                try {
                    d dVar = new d(activity, this.mAdResultData, ksVideoPlayConfig, this.hV);
                    this.hW = dVar;
                    dVar.show();
                    com.kwad.components.ad.interstitial.c.b.G(activity);
                } catch (Throwable th) {
                    com.kwad.components.ad.interstitial.report.realtime.a.dV();
                    com.kwad.components.ad.interstitial.report.realtime.a.a(th.getMessage(), this.mAdTemplate);
                }
                com.kwad.components.ad.interstitial.report.c.dR().q(this.mAdTemplate);
                return;
            }
            return;
        }
        com.kwad.sdk.core.e.c.e("StayAdHelper", "showInterstitialAd activity must not be null");
        com.kwad.components.ad.interstitial.report.realtime.a.dV();
        com.kwad.components.ad.interstitial.report.realtime.a.x(this.mAdTemplate);
        com.kwad.components.ad.interstitial.report.c dR2 = com.kwad.components.ad.interstitial.report.c.dR();
        AdTemplate adTemplate2 = this.mAdTemplate;
        com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.awQ;
        dR2.a(adTemplate2, eVar2.errorCode, eVar2.msg);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bZ.a(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bZ.b(bVar);
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setBidEcpm(long j, long j2) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j;
        com.kwad.sdk.core.adlog.c.l(adTemplate, j);
    }
}
