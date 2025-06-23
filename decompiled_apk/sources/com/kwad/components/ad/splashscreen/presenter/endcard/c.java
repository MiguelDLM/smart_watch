package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.widget.CloseCountDownView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.adlog.a;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class c extends com.kwad.components.ad.splashscreen.presenter.e implements View.OnClickListener, com.kwad.sdk.widget.c {
    private CloseCountDownView EE;
    private ViewGroup EF;
    private ViewGroup EG;
    private ImageView EH;
    private TextView EI;
    private TextView EJ;
    private SplashEndLandView EK;
    private CloseCountDownView.a EL = new CloseCountDownView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.c.1
        @Override // com.kwad.components.ad.splashscreen.widget.CloseCountDownView.a
        public final void dg() {
            a.C0845a c0845a = new a.C0845a();
            com.kwad.components.ad.splashscreen.monitor.a.kU().Z(c.this.Di.mAdTemplate);
            if (c.this.Di.mTimerHelper != null) {
                c0845a.duration = c.this.Di.mTimerHelper.getTime();
            }
            com.kwad.sdk.core.adlog.c.b(c.this.Di.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cL(1).b(c0845a).cT(6), (JSONObject) null);
            c.this.Di.kP();
        }

        @Override // com.kwad.components.ad.splashscreen.widget.CloseCountDownView.a
        public final void lc() {
            a.C0845a c0845a = new a.C0845a();
            if (c.this.Di.mTimerHelper != null) {
                c0845a.duration = c.this.Di.mTimerHelper.getTime();
            }
            com.kwad.sdk.core.adlog.c.b(c.this.Di.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cL(14).b(c0845a).cT(6), (JSONObject) null);
            c.this.Di.kT();
        }
    };

    private void t(View view) {
        if (view == this.EF) {
            this.Di.c(2, view.getContext(), 104, 2);
            return;
        }
        if (view == this.EG) {
            this.Di.c(2, view.getContext(), 26, 1);
            return;
        }
        if (view == this.EH) {
            this.Di.c(2, view.getContext(), 15, 2);
        } else if (view == this.EI) {
            this.Di.c(2, view.getContext(), 16, 2);
        } else if (view == this.EJ) {
            this.Di.c(2, view.getContext(), 17, 2);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (this.EK == null) {
            SplashEndLandView splashEndLandView = (SplashEndLandView) findViewById(R.id.ksad_splash_end_card_native_dialog_root);
            this.EK = splashEndLandView;
            this.EE = splashEndLandView.getCloseView();
            this.EF = this.EK.getGiftBoxView();
            this.EG = this.EK.getActionBarView();
            this.EH = this.EK.getAppIcon();
            this.EI = this.EK.getAppName();
            this.EJ = this.EK.getAppDesc();
        }
        this.EE.setOnViewClickListener(this.EL);
        this.EG.setOnClickListener(this);
        new com.kwad.sdk.widget.f(this.EG.getContext(), this.EG, this);
        if (com.kwad.sdk.core.response.b.b.dm(com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate))) {
            this.EF.setOnClickListener(this);
            this.EH.setOnClickListener(this);
            this.EI.setOnClickListener(this);
            this.EJ.setOnClickListener(this);
            new com.kwad.sdk.widget.f(this.EG.getContext(), this.EF, this);
            new com.kwad.sdk.widget.f(this.EG.getContext(), this.EH, this);
            new com.kwad.sdk.widget.f(this.EG.getContext(), this.EI, this);
            new com.kwad.sdk.widget.f(this.EG.getContext(), this.EJ, this);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        t(view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        t(view);
    }
}
