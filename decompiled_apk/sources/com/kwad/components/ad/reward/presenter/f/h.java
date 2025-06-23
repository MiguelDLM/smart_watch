package com.kwad.components.ad.reward.presenter.f;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.e;
import com.kwad.sdk.R;
import com.kwad.sdk.components.r;

/* loaded from: classes11.dex */
public final class h extends g implements j, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private aw wA;
    private boolean wB;
    private boolean wC;

    @Nullable
    private View wF;
    private boolean wG = false;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.f.h.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            h.this.wE.setVisibility(8);
        }
    };
    private g.a wH = new g.a() { // from class: com.kwad.components.ad.reward.presenter.f.h.2
        @Override // com.kwad.components.ad.reward.g.a
        public final void fV() {
            h.this.wC = true;
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void fW() {
            h.this.wC = true;
            h.this.iZ();
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void fX() {
            h.this.wC = false;
            if (h.this.wA != null) {
                h.this.wA.ta();
            }
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void fY() {
            h.this.wC = false;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void iZ() {
        aw awVar = this.wA;
        if (awVar != null && this.wC) {
            if (!this.wB) {
                awVar.sV();
                this.wA.sW();
                this.wB = true;
                return;
            }
            awVar.sZ();
        }
    }

    private e.b jc() {
        return new e.b() { // from class: com.kwad.components.ad.reward.presenter.f.h.3
            @Override // com.kwad.components.core.webview.tachikoma.a.e.b
            public final int jd() {
                if (h.this.qp.pp != null) {
                    return com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), r0.cf());
                }
                if (h.this.wF != null) {
                    if (h.this.wF.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        return com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), h.this.wF.getHeight() + ((ViewGroup.MarginLayoutParams) r0).bottomMargin);
                    }
                    return com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), h.this.wF.getHeight());
                }
                return 0;
            }
        };
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qp.a(this.wH);
        this.qp.oN.a(this);
        this.qp.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.eY().a(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        super.bF();
        iZ();
        this.wG = true;
        this.wE.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bY() {
        if (this.wG) {
            this.wE.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bZ() {
        if (this.wG) {
            this.wE.setVisibility(8);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_top_floor_bar";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dn(this.qp.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int hN() {
        return R.id.ksad_js_topfloor;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        aw awVar = this.wA;
        if (awVar != null) {
            awVar.sX();
            this.wA.sY();
        }
        super.onUnbind();
        this.qp.b(this.wH);
        this.qp.oN.b(this);
        this.qp.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.eY().b(this);
        this.qp.a((com.kwad.components.core.webview.tachikoma.e.a) null);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aW = com.kwad.sdk.c.a.a.aW(getContext());
        float screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) / aW) + 0.5f);
        aVar.height = (int) ((screenHeight / aW) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        aw awVar = this.wA;
        if (awVar != null) {
            awVar.sX();
            this.wA.sY();
        }
        this.wG = false;
        this.wE.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(r rVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(rVar, bVar);
        rVar.c(new com.kwad.components.core.webview.tachikoma.a.e(jc()));
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        super.a(awVar);
        this.wA = awVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        this.wF = view;
    }
}
