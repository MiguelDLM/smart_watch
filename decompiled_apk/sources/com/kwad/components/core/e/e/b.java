package com.kwad.components.core.e.e;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: classes11.dex */
public class b extends Presenter {
    protected c LS;
    protected AdInfo mAdInfo;

    @Override // com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        c cVar = (c) Kf();
        this.LS = cVar;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dS(cVar.LR.getAdTemplate());
    }
}
