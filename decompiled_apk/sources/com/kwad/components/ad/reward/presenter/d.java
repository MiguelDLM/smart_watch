package com.kwad.components.ad.reward.presenter;

import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;

/* loaded from: classes11.dex */
public final class d extends b {
    private ComplianceTextView cj;

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.cj.setVisibility(0);
        this.cj.setAdTemplate(this.qp.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cj = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
    }
}
