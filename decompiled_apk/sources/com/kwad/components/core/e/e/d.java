package com.kwad.components.core.e.e;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.kwad.sdk.R;

/* loaded from: classes11.dex */
public final class d extends b implements View.OnClickListener {
    private TextView LT;
    private TextView LU;
    private TextView qP;

    @Override // com.kwad.components.core.e.e.b, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetTextI18n"})
    public final void aj() {
        super.aj();
        if (this.LS.LR.oa() == 1) {
            this.qP.setText("即将打开" + com.kwad.sdk.core.response.b.a.ce(this.mAdInfo));
        } else if (this.LS.LR.oa() == 2) {
            this.qP.setText("即将打开第三方页面");
        }
        com.kwad.sdk.c.a.a.a(this, this.LT, this.LU);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.LS.LR.ak(true);
        this.LS.LP.dismiss();
        if (view == this.LT) {
            com.kwad.components.core.e.d.a.a(this.LS.LR);
            com.kwad.sdk.core.adlog.c.p(this.LS.LR.getAdTemplate(), 230);
        } else if (view == this.LU) {
            com.kwad.sdk.core.adlog.c.p(this.LS.LR.getAdTemplate(), 231);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.qP = (TextView) findViewById(R.id.ksad_second_confirm_content_view);
        this.LT = (TextView) findViewById(R.id.ksad_second_confirm_ensure);
        this.LU = (TextView) findViewById(R.id.ksad_second_confirm_cancle);
    }
}
