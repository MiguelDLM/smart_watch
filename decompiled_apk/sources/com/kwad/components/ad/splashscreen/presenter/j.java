package com.kwad.components.ad.splashscreen.presenter;

import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;

/* loaded from: classes11.dex */
public final class j extends e {
    /* JADX INFO: Access modifiers changed from: private */
    public void bQ() {
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate);
        a(new b(), true);
        a(new c(), true);
        if (com.kwad.sdk.core.response.b.a.bb(dS)) {
            a(new d(), true);
            a(new q(), true);
        } else {
            a(new h(), true);
        }
        if (this.Di.Cz) {
            a(new p(), true);
        } else {
            boolean dB = com.kwad.sdk.core.response.b.b.dB(dS);
            boolean dF = com.kwad.sdk.core.response.b.b.dF(dS);
            boolean dK = com.kwad.sdk.core.response.b.b.dK(dS);
            if (com.kwad.sdk.core.response.b.b.dH(dS)) {
                a(new n(), true);
            } else if (dB) {
                a(new m(), true);
            } else if (dF) {
                a(new l(), true);
            } else if (dK) {
                a(new p(), true);
            } else {
                a(new p(), true);
            }
        }
        if (com.kwad.sdk.core.response.b.a.aO(dS)) {
            a(new f(), true);
        }
        if (!this.Di.CA) {
            a(new com.kwad.components.ad.splashscreen.presenter.playcard.b(), true);
        }
        a(new a(), true);
        a(new g(), true);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        bo.postOnUiThread(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.j.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                j.this.bQ();
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        findViewById(R.id.splash_play_card_view).setVisibility(0);
    }
}
