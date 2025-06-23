package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: classes11.dex */
public class b extends Presenter {
    public AdTemplate mAdTemplate;
    public com.kwad.components.ad.reward.g qp;

    @Override // com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        com.kwad.components.ad.reward.g gVar = (com.kwad.components.ad.reward.g) Kf();
        this.qp = gVar;
        this.mAdTemplate = gVar.mAdTemplate;
    }

    public final void hq() {
        this.qp.hq();
    }

    public final boolean hr() {
        return com.kwad.sdk.core.response.b.a.bc(com.kwad.sdk.core.response.b.e.dS(this.qp.mAdTemplate));
    }
}
