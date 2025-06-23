package com.kwad.components.ad.reward.presenter.b;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.o;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes11.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private RewardActionBarControl oN;
    private l sw = new l() { // from class: com.kwad.components.ad.reward.presenter.b.c.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            c.this.hv();
        }
    };

    @Nullable
    private o tU;

    /* JADX INFO: Access modifiers changed from: private */
    public void hv() {
        this.oN.O(false);
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        g gVar = this.qp;
        this.oN = gVar.oN;
        gVar.oK.a(this.sw);
        AdTemplate adTemplate = this.qp.mAdTemplate;
        AdInfo dS = e.dS(adTemplate);
        if (com.kwad.sdk.core.response.b.a.cM(dS)) {
            if (this.tU == null) {
                this.tU = new o(this.qp);
            }
            this.tU.a(this.qp.mRootContainer, com.kwad.sdk.core.response.b.a.be(dS));
            this.tU.b(r.R(adTemplate));
            findViewById(R.id.ksad_reward_origin_live_root).setVisibility(8);
        }
        this.qp.oN.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qp.oK.b(this.sw);
        this.qp.oN.b(this);
        o oVar = this.tU;
        if (oVar != null) {
            oVar.onUnbind();
        }
    }
}
