package com.kwad.components.ad.reward.presenter.d.b;

import android.view.View;
import android.widget.TextView;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.R;

/* loaded from: classes11.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, c {
    private TextView vM;
    private TextView vN;

    private void cc() {
        g gVar = this.qp;
        com.kwad.sdk.core.adlog.c.b(gVar.mAdTemplate, 17, gVar.mReportExtData);
    }

    private void iC() {
        String dG = com.kwad.sdk.core.response.b.d.dG(this.qp.mAdTemplate);
        if (this.qp.mScreenOrientation == 1) {
            this.vN.setVisibility(8);
            this.vM.setText(dG);
            this.vM.setVisibility(0);
            this.vM.setOnClickListener(this);
        } else {
            this.vM.setVisibility(8);
            this.vN.setText(dG);
            this.vN.setVisibility(0);
            this.vN.setOnClickListener(this);
        }
        cc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iE() {
        com.kwad.sdk.core.adlog.c.b cK = new com.kwad.sdk.core.adlog.c.b().f(this.qp.mRootContainer.getTouchCoords()).cK(39);
        g gVar = this.qp;
        com.kwad.components.ad.reward.j.b.a(gVar.mAdTemplate, "native_id", "endTopBar", cK, gVar.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        this.qp.oJ.bJ();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
    }

    @Override // com.kwad.components.ad.reward.presenter.d.b.c
    public final void iF() {
        if (this.qp.pk) {
            return;
        }
        iC();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.vM || view == this.vN) {
            com.kwad.components.core.e.d.a.a(new a.C0788a(view.getContext()).ar(this.qp.mAdTemplate).b(this.qp.mApkDownloadHelper).ao(false).an(1).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.d.b.a.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    a.this.iE();
                    a.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vM = (TextView) findViewById(R.id.ksad_end_left_call_btn);
        this.vN = (TextView) findViewById(R.id.ksad_end_right_call_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vM.setVisibility(8);
        this.vN.setVisibility(8);
    }
}
