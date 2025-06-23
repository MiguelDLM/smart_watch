package com.kwad.components.ad.splashscreen.presenter;

/* loaded from: classes11.dex */
public final class k extends e implements com.kwad.sdk.core.h.c {
    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        this.Di.Q(getContext());
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.Di.Ct.a(this);
        com.kwad.components.ad.splashscreen.monitor.b.kW();
        com.kwad.components.ad.splashscreen.monitor.b.aa(this.Di.mAdTemplate);
        com.kwad.components.ad.splashscreen.monitor.b.kW();
        com.kwad.components.ad.splashscreen.monitor.b.ac(this.Di.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.cA(com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate))) {
            this.Di.Q(getContext());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Di.Ct.b(this);
    }
}
