package com.kwad.components.ad.draw.b.b;

import android.view.ViewGroup;
import com.kwad.components.ad.draw.b.b.a;
import com.kwad.components.ad.draw.view.playcard.DrawCardApp;
import com.kwad.components.ad.draw.view.playcard.DrawCardH5;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes11.dex */
public final class b extends com.kwad.components.ad.draw.a.a {
    private a.InterfaceC0727a cF = new a.InterfaceC0727a() { // from class: com.kwad.components.ad.draw.b.b.b.1
        @Override // com.kwad.components.ad.draw.b.b.a.InterfaceC0727a
        public final void aq() {
            b.this.aq();
        }
    };
    private DrawCardApp cI;
    private DrawCardH5 cJ;
    private ViewGroup co;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    /* JADX INFO: Access modifiers changed from: private */
    public void aq() {
        if (com.kwad.sdk.core.response.b.a.aE(this.mAdInfo)) {
            as();
        } else {
            at();
        }
    }

    private void as() {
        this.co.setVisibility(8);
        this.cI.a(this.mAdTemplate, new DrawCardApp.a() { // from class: com.kwad.components.ad.draw.b.b.b.2
            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardApp.a
            public final void av() {
                b.this.co.setVisibility(0);
            }

            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardApp.a
            public final void aw() {
                b.this.au();
            }
        });
        this.cI.setVisibility(0);
        this.cI.aO();
    }

    private void at() {
        this.co.setVisibility(8);
        this.cJ.a(this.mAdTemplate, new DrawCardH5.a() { // from class: com.kwad.components.ad.draw.b.b.b.3
            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardH5.a
            public final void av() {
                b.this.co.setVisibility(0);
            }

            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardH5.a
            public final void aw() {
                b.this.au();
            }
        });
        this.cJ.setVisibility(0);
        this.cJ.aO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au() {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, 29, this.bO.mRootContainer.getTouchCoords());
        KsDrawAd.AdInteractionListener adInteractionListener = this.bO.bN;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.components.ad.draw.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdTemplate adTemplate = this.bO.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.dS(adTemplate);
        this.bO.ch.a(this.cF);
        this.cI.setVisibility(8);
        this.cJ.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.co = (ViewGroup) findViewById(R.id.ksad_ad_normal_container);
        this.cI = (DrawCardApp) findViewById(R.id.ksad_card_app_container);
        this.cJ = (DrawCardH5) findViewById(R.id.ksad_card_h5_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.cI.release();
        this.cJ.release();
        this.bO.ch.a((a.InterfaceC0727a) null);
    }
}
