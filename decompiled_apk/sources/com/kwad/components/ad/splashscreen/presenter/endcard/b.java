package com.kwad.components.ad.splashscreen.presenter.endcard;

import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;

/* loaded from: classes11.dex */
public final class b extends com.kwad.components.ad.splashscreen.presenter.e {
    private ComplianceTextView cj;

    private void lC() {
        if (!com.kwad.sdk.core.response.b.a.aO(com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate))) {
            return;
        }
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(R.id.ksad_compliance_splash_endcard);
        this.cj = complianceTextView;
        complianceTextView.setBackgroundColor(0);
        this.cj.setVisibility(0);
        this.cj.setAdTemplate(this.Di.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        lC();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
