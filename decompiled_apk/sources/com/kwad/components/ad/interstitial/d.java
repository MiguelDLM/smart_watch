package com.kwad.components.ad.interstitial;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.components.core.e.a.h;
import com.kwad.components.core.widget.f;
import com.kwad.components.core.widget.g;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bn;

/* loaded from: classes11.dex */
public final class d extends com.kwad.components.core.proxy.d {
    private com.kwad.components.ad.interstitial.g.a hZ;
    private boolean ia;
    private com.kwad.components.ad.interstitial.f.b ib;

    @NonNull
    private final KsAdVideoPlayConfig ic;
    private KsInterstitialAd.AdInteractionListener ie;

    /* renamed from: if, reason: not valid java name */
    private final g f7if;
    private final AdResultData mAdResultData;
    private final AdTemplate mAdTemplate;
    private bn mTimerHelper;

    public d(@NonNull Activity activity, @NonNull AdResultData adResultData, KsVideoPlayConfig ksVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        super(activity);
        boolean z;
        this.f7if = new g() { // from class: com.kwad.components.ad.interstitial.d.1
            @Override // com.kwad.components.core.widget.g
            public final void j(boolean z2) {
                int i;
                if (d.this.ia) {
                    Activity activity2 = d.this.mActivity;
                    com.kwad.sdk.core.c.b.En();
                    if (activity2 == com.kwad.sdk.core.c.b.getCurrentActivity()) {
                        AdTemplate adTemplate = d.this.mAdTemplate;
                        if (z2) {
                            i = 2;
                        } else {
                            i = 1;
                        }
                        com.kwad.sdk.core.adlog.c.i(adTemplate, i);
                        d.this.cn();
                    }
                }
            }
        };
        this.ie = adInteractionListener;
        KsAdVideoPlayConfig.Builder builder = new KsAdVideoPlayConfig.Builder();
        if (ksVideoPlayConfig != null && ksVideoPlayConfig.isVideoSoundEnable()) {
            z = true;
        } else {
            z = false;
        }
        this.ic = builder.videoSoundEnable(z).dataFlowAutoStart(com.kwad.components.ad.interstitial.b.b.cE()).build();
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.n(adResultData);
    }

    private boolean cl() {
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(this.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.cs(dS) && !cm() && com.kwad.components.ad.interstitial.c.a.cM() < com.kwad.sdk.core.response.b.a.cv(dS)) {
            return true;
        }
        return false;
    }

    private boolean cm() {
        if (!com.kwad.sdk.core.response.b.b.ci(this.mAdTemplate) || com.kwad.components.ad.interstitial.d.a.cO() >= com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.asE)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn() {
        com.kwad.components.ad.interstitial.g.a cVar;
        if (cl()) {
            cVar = new com.kwad.components.ad.interstitial.aggregate.b(this.mContext);
        } else {
            cVar = new com.kwad.components.ad.interstitial.g.c(this.mContext);
        }
        this.hZ = cVar;
        cVar.a(this.mAdResultData, this, this.ic, this.ie);
        this.zh.removeAllViews();
        this.zh.addView(this.hZ);
        co();
    }

    private void co() {
        com.kwad.components.ad.interstitial.f.b bVar = new com.kwad.components.ad.interstitial.f.b(this.hZ, 100);
        this.ib = bVar;
        bVar.a(new com.kwad.sdk.core.h.c() { // from class: com.kwad.components.ad.interstitial.d.2
            @Override // com.kwad.sdk.core.h.c
            public final void aM() {
                d.this.getTimerHelper().Oa();
            }

            @Override // com.kwad.sdk.core.h.c
            public final void aN() {
                d.this.getTimerHelper().Ob();
            }
        });
        this.ib.ua();
    }

    @Override // com.kwad.components.core.proxy.d
    public final float cj() {
        return 0.0f;
    }

    @Override // com.kwad.components.core.proxy.d
    public final ViewGroup ck() {
        f fVar = new f(this.mContext);
        fVar.setOrientationChangeListener(this.f7if);
        return fVar;
    }

    @Override // com.kwad.components.core.proxy.d, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        try {
            super.dismiss();
            com.kwad.sdk.a.a.c.Au().Ax();
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.ie;
            if (adInteractionListener != null) {
                adInteractionListener.onPageDismiss();
            }
            com.kwad.components.ad.interstitial.g.a aVar = this.hZ;
            if ((aVar instanceof com.kwad.components.ad.interstitial.g.c) && !((com.kwad.components.ad.interstitial.g.c) aVar).ed() && com.kwad.sdk.core.response.b.a.cN(com.kwad.sdk.core.response.b.e.dS(this.mAdTemplate))) {
                com.kwad.sdk.core.adlog.c.m(this.mAdTemplate, (int) Math.ceil(((float) getTimerHelper().getTime()) / 1000.0f));
            }
            h.nL();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.d
    public final void g(View view) {
        h.a(getWindow());
        cn();
        com.kwad.components.ad.interstitial.report.c.dR().r(this.mAdTemplate);
        com.kwad.sdk.commercial.d.c.bA(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.d
    public final int getLayoutId() {
        return 0;
    }

    public final bn getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bn();
        }
        return this.mTimerHelper;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        if (com.kwad.components.ad.interstitial.b.b.cI()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.components.ad.interstitial.f.b bVar = this.ib;
        if (bVar != null) {
            bVar.release();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.ia = z;
        com.kwad.components.ad.interstitial.g.a aVar = this.hZ;
        if (aVar != null) {
            if (z) {
                aVar.cr();
            } else {
                aVar.cs();
            }
        }
    }

    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.ie = adInteractionListener;
        com.kwad.components.ad.interstitial.g.a aVar = this.hZ;
        if (aVar != null) {
            aVar.setAdInteractionListener(adInteractionListener);
        }
    }
}
