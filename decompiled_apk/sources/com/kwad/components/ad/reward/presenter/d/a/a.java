package com.kwad.components.ad.reward.presenter.d.a;

import android.widget.FrameLayout;
import com.kwad.components.ad.l.a;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.presenter.f;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes11.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements a.b {
    private FrameLayout da;
    private l sv;
    private volatile long vA = 0;
    private volatile boolean vB = false;
    private l sw = new l() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            a.this.vB = false;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.vB = true;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            a.this.vA = j2;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.vB = false;
        }
    };
    private l gO = new l() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.2
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            boolean z;
            super.onMediaPlayProgress(j, j2);
            a.this.vA = j2;
            a aVar = a.this;
            if (j - j2 < 800) {
                z = true;
            } else {
                z = false;
            }
            aVar.vB = z;
        }
    };
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.4
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            if (!a.this.qp.pq && a.this.qp.oP != null) {
                a.this.qp.oP.ar();
            }
        }
    };
    private com.kwad.sdk.core.webview.d.a.a cR = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.5
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            a.this.qp.oJ.bJ();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        l lVar;
        super.aj();
        this.vA = 0L;
        this.vB = false;
        com.kwad.components.ad.reward.g gVar = this.qp;
        AdTemplate adTemplate = gVar.mAdTemplate;
        com.kwad.components.ad.l.a aVar = gVar.oP;
        if (gVar.oK.jN()) {
            lVar = this.sw;
        } else {
            lVar = this.gO;
        }
        this.sv = lVar;
        if (aVar != null) {
            this.qp.pk = true;
            aVar.a(this);
            aVar.a(this.cR);
            aVar.a(this.da, this.qp.mRootContainer, adTemplate);
            aVar.a(new a.InterfaceC0749a() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.3
                @Override // com.kwad.components.ad.l.a.InterfaceC0749a
                public final void R(boolean z) {
                    a.this.qp.pk = z;
                }
            });
            aVar.setActivity(this.qp.getActivity());
            aVar.ay();
            this.qp.b(this.mPlayEndPageListener);
            this.qp.oK.a(this.sv);
        }
    }

    @Override // com.kwad.components.ad.l.a.b
    public final void iw() {
        f.r(this.qp);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.da = (FrameLayout) findViewById(R.id.ksad_landing_page_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qp.c(this.mPlayEndPageListener);
        this.qp.oK.b(this.sv);
    }
}
