package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;

/* loaded from: classes11.dex */
public final class j extends b {
    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        try {
            this.qp.oK.jJ();
        } catch (Throwable th) {
            bo.postOnUiThread(new az() { // from class: com.kwad.components.ad.reward.presenter.j.1
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    ServiceProvider.reportSdkCaughtException(th);
                    j.this.hq();
                }
            });
        }
    }
}
