package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bo;

/* loaded from: classes11.dex */
public final class n extends b {
    private com.kwad.components.core.video.l gO = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.n.2
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            try {
                super.onMediaPlayCompleted();
                n.this.hx();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    };
    private final com.kwad.components.ad.reward.e.m gP = new com.kwad.components.ad.reward.e.m() { // from class: com.kwad.components.ad.reward.presenter.n.3
        @Override // com.kwad.components.ad.reward.e.m
        public final void a(com.kwad.components.core.webview.tachikoma.b.q qVar) {
            if (qVar != null && qVar.type == 1) {
                n.this.qp.oK.release();
                n.this.qp.fC();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void hx() {
        com.kwad.components.ad.reward.g gVar = this.qp;
        if (com.kwad.components.core.s.j.d(gVar.mAdTemplate, gVar.pe)) {
            com.kwad.components.ad.reward.g gVar2 = this.qp;
            com.kwad.components.core.s.j.e(gVar2.mContext, gVar2.mAdTemplate);
        }
        if (!i.x(this.qp)) {
            com.kwad.components.ad.reward.g gVar3 = this.qp;
            if (!com.kwad.components.core.s.j.d(gVar3.mAdTemplate, gVar3.pe)) {
                this.qp.fC();
                return;
            }
        }
        bo.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.n.1
            @Override // java.lang.Runnable
            public final void run() {
                n.this.qp.fC();
            }
        }, 200L);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qp.oK.a(this.gO);
        com.kwad.components.ad.reward.c.ff().a(this.gP);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qp.oK.b(this.gO);
        com.kwad.components.ad.reward.c.ff().b(this.gP);
    }
}
