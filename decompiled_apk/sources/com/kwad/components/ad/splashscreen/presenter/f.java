package com.kwad.components.ad.splashscreen.presenter;

import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;

/* loaded from: classes11.dex */
public final class f extends e {
    private ComplianceTextView cj;

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        int i;
        super.aj();
        if (com.kwad.components.ad.splashscreen.e.c.z(com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate))) {
            i = R.id.ksad_compliance_right_view;
        } else {
            i = R.id.ksad_compliance_left_view;
        }
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(i);
        this.cj = complianceTextView;
        complianceTextView.setBackgroundColor(0);
        this.cj.setVisibility(0);
        this.cj.setAdTemplate(this.Di.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
