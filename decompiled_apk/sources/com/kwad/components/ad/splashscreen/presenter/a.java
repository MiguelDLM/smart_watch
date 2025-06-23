package com.kwad.components.ad.splashscreen.presenter;

import android.view.View;
import com.kwad.sdk.R;

/* loaded from: classes11.dex */
public final class a extends e implements com.kwad.sdk.widget.c {
    private View CX;
    private boolean CY;

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        this.Di.c(1, view.getContext(), 53, 2);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        int i;
        super.aj();
        com.kwad.components.ad.splashscreen.h hVar = this.Di;
        if (hVar == null) {
            return;
        }
        this.CY = com.kwad.sdk.core.response.b.d.dH(hVar.mAdTemplate);
        boolean n = com.kwad.components.ad.splashscreen.h.n(com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate));
        View view = this.CX;
        if (n) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
        if (n) {
            new com.kwad.sdk.widget.f(this.CX.getContext(), this.CX, this);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        com.kwad.sdk.core.e.c.d("FullScreenTouchConvertPresenter", "onSlide: enableSlickClick: " + this.CY);
        if (!this.CY) {
            return;
        }
        this.Di.c(1, view.getContext(), 153, 2);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.CX = findViewById(R.id.ksad_splash_actionbar_full_screen);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
