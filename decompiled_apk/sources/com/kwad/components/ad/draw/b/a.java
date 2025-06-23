package com.kwad.components.ad.draw.b;

import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;

/* loaded from: classes11.dex */
public final class a extends com.kwad.components.ad.draw.a.a {
    private ComplianceTextView cj;

    @Override // com.kwad.components.ad.draw.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.cj.setVisibility(0);
        this.cj.setAdTemplate(this.bO.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cj = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
    }
}
