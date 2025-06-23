package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.n.n;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.s.i;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes11.dex */
public final class e extends com.kwad.components.ad.reward.presenter.b implements RewardActionBarControl.c {
    private ViewGroup gS;
    private KsLogoView ss;
    private n uW;
    private int uX;
    private FrameLayout.LayoutParams uY;
    private n.a uZ;

    public e(ViewGroup viewGroup, n.a aVar) {
        this.gS = viewGroup;
        this.uZ = aVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qp.oN.a(this);
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(this.qp.mAdTemplate);
        this.uX = this.ss.getVisibility();
        this.uY = d.a(getContext(), dS, this.ss, R.dimen.ksad_reward_order_logo_margin_bottom, !this.qp.oK.jN());
        n nVar = new n(this.gS, new com.kwad.components.ad.reward.n.a(getContext(), this.qp) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.e.1
            @Override // com.kwad.components.ad.reward.n.a, com.kwad.components.ad.reward.n.b
            public final void ii() {
                e.this.qp.a(1, e.this.getContext(), 10, 2);
            }

            @Override // com.kwad.components.ad.reward.n.a, com.kwad.components.ad.reward.n.b
            public final void ij() {
                e.this.qp.a(1, e.this.getContext(), 10, 2);
            }
        });
        this.uW = nVar;
        nVar.a(this.uZ);
        this.uW.b(r.R(this.qp.mAdTemplate));
        i.a(new com.kwad.components.core.widget.e(), this.uW.gG());
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.c
    public final void e(a aVar) {
        this.gS.setVisibility(0);
        RewardActionBarControl.a(aVar, this.gS, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_ORDER);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ss = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.ss.setVisibility(this.uX);
        FrameLayout.LayoutParams layoutParams = this.uY;
        if (layoutParams != null) {
            this.ss.setLayoutParams(layoutParams);
        }
    }
}
