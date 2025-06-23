package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: classes11.dex */
public final class p extends b {
    private com.kwad.components.core.playable.a oM;
    private PlayableSource sJ;
    private final com.kwad.components.ad.reward.e.j sK = new com.kwad.components.ad.reward.e.k() { // from class: com.kwad.components.ad.reward.presenter.p.1
        @Override // com.kwad.components.ad.reward.e.k, com.kwad.components.ad.reward.e.j
        public final void a(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.e.n nVar) {
            p.this.sJ = playableSource;
            if (p.this.oM != null && p.this.oM.qF()) {
                p.this.oM.e(playableSource);
                com.kwad.components.ad.reward.g gVar = p.this.qp;
                if (gVar != null) {
                    gVar.d(playableSource);
                    p.this.qp.B(true);
                    if (p.this.qp.oK.jN()) {
                        p.this.qp.oK.jO().pause();
                    }
                }
                com.kwad.components.ad.reward.a.eY().b(playableSource);
                return;
            }
            if (p.this.oM != null) {
                p.this.oM.hA();
            }
            if (nVar != null) {
                nVar.gU();
                com.kwad.sdk.core.e.c.d("RewardPlayablePresenter", "onEnterPlayable outer handled");
            } else if (com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dS(p.this.qp.mAdTemplate))) {
                DownloadLandPageActivity.launch(p.this.getActivity(), p.this.qp.mAdTemplate, true);
            }
        }

        @Override // com.kwad.components.ad.reward.e.k, com.kwad.components.ad.reward.e.j
        public final void bY() {
            p.this.oM.hA();
            com.kwad.components.ad.reward.g gVar = p.this.qp;
            if (gVar != null) {
                gVar.d((PlayableSource) null);
                if (p.this.qp.oK.jN()) {
                    p.this.qp.oK.jO().resume();
                }
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.ad.reward.g gVar = this.qp;
        com.kwad.components.core.playable.a aVar = gVar.oM;
        this.oM = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(gVar.mAdTemplate, gVar.mRootContainer, gVar.mApkDownloadHelper);
        com.kwad.components.ad.reward.monitor.c.a(this.qp.oZ, "playable");
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(this.qp.mAdTemplate);
        com.kwad.components.ad.reward.g gVar2 = this.qp;
        com.kwad.components.ad.reward.monitor.c.a(gVar2.mAdTemplate, gVar2.oZ, "playable", com.kwad.sdk.core.response.b.a.bO(dS));
        this.oM.qE();
        this.oM.a(new aq.b() { // from class: com.kwad.components.ad.reward.presenter.p.2
            @Override // com.kwad.components.core.webview.jshandler.aq.b
            public final void a(aq.a aVar2) {
                if (!aVar2.isSuccess()) {
                    AdInfo dS2 = com.kwad.sdk.core.response.b.e.dS(p.this.qp.mAdTemplate);
                    long loadTime = p.this.qp.oM.getLoadTime();
                    if (loadTime == -1) {
                        return;
                    }
                    com.kwad.components.ad.reward.g gVar3 = p.this.qp;
                    com.kwad.components.ad.reward.monitor.c.a(gVar3.mAdTemplate, gVar3.oZ, "playable", com.kwad.sdk.core.response.b.a.bO(dS2), System.currentTimeMillis() - loadTime, 3);
                }
            }
        });
        this.oM.a(new KsAdWebView.e() { // from class: com.kwad.components.ad.reward.presenter.p.3
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                AdInfo dS2 = com.kwad.sdk.core.response.b.e.dS(p.this.qp.mAdTemplate);
                long loadTime = p.this.qp.oM.getLoadTime();
                if (loadTime == -1) {
                    return;
                }
                com.kwad.components.ad.reward.monitor.c.a(p.this.qp.oZ, "playable", com.kwad.sdk.core.response.b.a.bO(dS2), System.currentTimeMillis() - loadTime);
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
                com.kwad.components.ad.reward.g gVar3 = p.this.qp;
                AdTemplate adTemplate = gVar3.mAdTemplate;
                com.kwad.components.ad.reward.monitor.c.a(adTemplate, gVar3.oZ, "playable", com.kwad.sdk.core.response.b.a.bO(com.kwad.sdk.core.response.b.e.dS(adTemplate)), System.currentTimeMillis() - p.this.qp.oM.getLoadTime(), 2);
            }
        });
        com.kwad.components.ad.reward.a.eY().a(this.sK);
    }

    public final void e(@Nullable PlayableSource playableSource) {
        com.kwad.components.core.playable.a aVar = this.oM;
        if (aVar != null) {
            if (playableSource != null) {
                aVar.e(playableSource);
            } else {
                aVar.e(this.sJ);
            }
        }
    }

    public final void hA() {
        com.kwad.components.core.playable.a aVar = this.oM;
        if (aVar != null) {
            aVar.hA();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ((KsAdWebView) findViewById(R.id.ksad_playable_webview)).setVisibility(4);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.playable.a aVar = this.oM;
        if (aVar == null) {
            return;
        }
        aVar.qD();
        this.oM.hA();
        com.kwad.components.ad.reward.a.eY().b(this.sK);
    }
}
