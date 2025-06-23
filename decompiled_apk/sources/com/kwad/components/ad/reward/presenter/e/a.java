package com.kwad.components.ad.reward.presenter.e;

import android.widget.FrameLayout;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.f.g;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.R;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.b.b;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bj;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes11.dex */
public final class a extends g implements com.kwad.components.ad.reward.k.a {
    private AdMatrixInfo.PreLandingPageTKInfo vZ;
    private aw wa;
    private boolean nY = false;
    private com.kwad.components.ad.reward.e.g wb = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.e.a.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            c.d("TKPreFormPresenter", "handleToSkip PlayEndPageListener onPlayEndPageShow: " + a.this.qp.pe);
            if (!a.this.qp.pe) {
                a.this.iJ();
            }
        }
    };

    private void S(final boolean z) {
        c.d("TKPreFormPresenter", "switchPreForm: " + z);
        this.wE.post(new az() { // from class: com.kwad.components.ad.reward.presenter.e.a.2
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                int i;
                KSFrameLayout kSFrameLayout = a.this.wE;
                if (z) {
                    i = 0;
                } else {
                    i = 4;
                }
                kSFrameLayout.setVisibility(i);
                a.this.wE.setClickable(z);
                if (a.this.wa != null) {
                    if (z) {
                        a.this.wa.sV();
                        a.this.wa.sW();
                    } else {
                        a.this.wa.sX();
                        a.this.wa.sY();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iJ() {
        if (this.nY && this.vZ != null) {
            c.d("TKPreFormPresenter", "handleToSkip handleToPlayEnd isPlayEndShow: " + this.vZ.isPlayEndShow());
            if (this.vZ.isPlayEndShow()) {
                S(true);
            }
        }
    }

    private void iK() {
        if (this.nY && this.vZ != null) {
            c.d("TKPreFormPresenter", "handleToSkip mPreLandingPageData isSkipShow: " + this.vZ.isSkipShow());
            if (this.vZ.isSkipShow()) {
                S(true);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.vZ = b.dk(this.qp.mAdTemplate);
        this.qp.b(this.wb);
        this.qp.a((com.kwad.components.ad.reward.k.a) this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        super.bF();
        c.d("TKPreFormPresenter", "onTkLoadSuccess");
        this.nY = true;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_pre_landing_page";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return b.dB(this.qp.mAdTemplate);
    }

    public final BackPressHandleResult go() {
        KSFrameLayout kSFrameLayout;
        if (this.wl != null && (kSFrameLayout = this.wE) != null) {
            if (kSFrameLayout.getVisibility() == 0) {
                return this.wl.go();
            }
            return BackPressHandleResult.NOT_HANDLED;
        }
        return BackPressHandleResult.NOT_HANDLED;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int hN() {
        return R.id.ksad_pre_form_card;
    }

    @Override // com.kwad.components.ad.reward.k.a
    public final void iL() {
        c.d("TKPreFormPresenter", "onPlayComplete: ");
        iJ();
    }

    @Override // com.kwad.components.ad.reward.k.a
    public final void iM() {
        c.d("TKPreFormPresenter", "onSkipClick: ");
        iK();
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qp.c(this.wb);
        this.qp.b((com.kwad.components.ad.reward.k.a) this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final void a(FrameLayout frameLayout) {
        frameLayout.setVisibility(4);
        frameLayout.setClickable(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aW = com.kwad.sdk.c.a.a.aW(getContext());
        aVar.width = (int) ((bj.getScreenWidth(getContext()) / aW) + 0.5f);
        aVar.height = (int) ((bj.getScreenHeight(getContext()) / aW) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        super.a(awVar);
        this.wa = awVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        this.nY = false;
        c.d("TKPreFormPresenter", "onTkLoadFailed");
        S(false);
    }
}
