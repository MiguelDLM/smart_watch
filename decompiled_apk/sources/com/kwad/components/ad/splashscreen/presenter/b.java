package com.kwad.components.ad.splashscreen.presenter;

import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.az;

/* loaded from: classes11.dex */
public final class b extends e {
    private KsLogoView mLogoView;

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ViewGroup viewGroup) {
        if (!com.kwad.components.ad.splashscreen.e.c.z(com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate))) {
            if (com.kwad.components.ad.splashscreen.e.c.a(getContext(), this.Di.mRootContainer.getWidth(), this.Di.mRootContainer.getHeight())) {
                com.kwad.components.ad.splashscreen.e.c.a(findViewById(R.id.ksad_splash_logo_container), -1, 16, 16, -1);
            }
            if (com.kwad.sdk.core.response.b.a.dg(com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate))) {
                com.kwad.components.ad.splashscreen.e.c.a(findViewById(R.id.ksad_splash_logo_container), -1, 34, 16, -1);
                return;
            }
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        layoutParams.gravity = 51;
        viewGroup.setLayoutParams(layoutParams);
        DisplayMetrics displayMetrics = viewGroup.getContext().getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels / displayMetrics.widthPixels > 1.7777777910232544d) {
            ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(viewGroup.getContext(), 12.0f);
                marginLayoutParams.topMargin = com.kwad.sdk.c.a.a.a(viewGroup.getContext(), 12.0f);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        AdInfo.AdSplashInfo adSplashInfo;
        super.aj();
        KsLogoView ksLogoView = (KsLogoView) findViewById(R.id.ksad_splash_logo_container);
        this.mLogoView = ksLogoView;
        ksLogoView.post(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.b.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                b bVar = b.this;
                bVar.i(bVar.mLogoView);
            }
        });
        if (!this.Di.mAdTemplate.adInfoList.isEmpty() && (adSplashInfo = this.Di.mAdTemplate.adInfoList.get(0).adSplashInfo) != null) {
            if (adSplashInfo.logoPosition != 0) {
                this.mLogoView.setVisibility(0);
                this.mLogoView.aE(this.Di.mAdTemplate);
            } else {
                this.mLogoView.setVisibility(8);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
