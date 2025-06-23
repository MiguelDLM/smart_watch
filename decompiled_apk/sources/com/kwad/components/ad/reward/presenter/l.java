package com.kwad.components.ad.reward.presenter;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.n.g;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;

/* loaded from: classes11.dex */
public final class l extends b implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private RewardActionBarControl oN;

    @Nullable
    private com.kwad.components.ad.reward.n.g sq;
    private KsLogoView ss;

    @Nullable
    private com.kwad.components.ad.reward.n.l st;
    private boolean sr = false;
    private com.kwad.components.core.video.l gO = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.l.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            l.this.hv();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void hv() {
        if (!this.sr) {
            com.kwad.components.ad.reward.n.g gVar = this.sq;
            if (gVar == null) {
                this.oN.O(false);
            } else {
                gVar.a(new g.a() { // from class: com.kwad.components.ad.reward.presenter.l.2
                    @Override // com.kwad.components.ad.reward.n.g.a
                    public final void hw() {
                        l.this.oN.O(true);
                    }
                }, 500L);
            }
            this.sr = true;
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.ad.reward.g gVar = this.qp;
        this.oN = gVar.oN;
        gVar.oK.a(this.gO);
        AdTemplate adTemplate = this.qp.mAdTemplate;
        boolean z = com.kwad.sdk.core.response.b.b.dd(adTemplate).displayWeakCard;
        this.qp.A(z);
        if (z) {
            if (this.sq == null) {
                this.sq = new com.kwad.components.ad.reward.n.g(this.qp);
            }
            this.sq.f((AdBaseFrameLayout) findViewById(R.id.ksad_root_container));
            this.sq.b(com.kwad.components.ad.reward.n.r.R(adTemplate));
        }
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        if (com.kwad.sdk.core.response.b.a.cd(adTemplate)) {
            if (this.st == null) {
                this.st = new com.kwad.components.ad.reward.n.l(this.qp);
            }
            this.st.h(this.qp.mRootContainer);
            this.st.b(com.kwad.components.ad.reward.n.r.R(adTemplate));
            com.kwad.components.ad.reward.presenter.platdetail.actionbar.d.a(getContext(), dS, this.ss, R.dimen.ksad_live_subscribe_card_logo_margin_bottom, false);
        }
        this.qp.oN.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ss = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qp.oK.b(this.gO);
        this.qp.oN.b(this);
        com.kwad.components.ad.reward.n.l lVar = this.st;
        if (lVar != null) {
            lVar.onUnbind();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        com.kwad.components.ad.reward.n.l lVar = this.st;
        if (lVar != null) {
            lVar.ka();
        }
    }
}
