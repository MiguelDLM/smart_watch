package com.kwad.components.ad.reward.presenter;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes11.dex */
public final class h extends b implements com.kwad.sdk.app.a {
    private AdInfo mAdInfo;

    @Override // com.kwad.sdk.app.a
    public final void O(String str) {
        if (!TextUtils.equals(com.kwad.sdk.core.response.b.a.ax(this.mAdInfo), str)) {
            return;
        }
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(this.qp.mAdTemplate);
        if (!com.kwad.sdk.core.response.b.a.aN(dS) || com.kwad.sdk.core.response.b.a.aM(dS) != 1) {
            com.kwad.components.ad.reward.e.b bVar = this.qp.oJ;
            if (bVar != null) {
                bVar.onRewardVerify();
            }
            this.qp.oK.pause();
            this.qp.fC();
        }
    }

    @Override // com.kwad.sdk.app.a
    public final void P(String str) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dS(this.qp.mAdTemplate);
        com.kwad.sdk.app.b.AW().a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.app.b.AW().b(this);
    }
}
