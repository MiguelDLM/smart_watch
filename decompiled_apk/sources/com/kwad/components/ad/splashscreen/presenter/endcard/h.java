package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.r;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class h extends com.kwad.components.ad.splashscreen.presenter.a.c implements com.kwad.sdk.core.h.c {
    private FrameLayout ld;
    private aw wA;

    private void Z(int i) {
        a.C0845a c0845a = new a.C0845a();
        bn bnVar = this.Di.mTimerHelper;
        if (bnVar != null) {
            c0845a.duration = bnVar.getTime();
        }
        com.kwad.sdk.core.adlog.c.b b = new com.kwad.sdk.core.adlog.c.b().cT(6).b(c0845a);
        if (i == 2) {
            b.cL(14);
        } else {
            b.cL(1);
        }
        com.kwad.sdk.core.adlog.c.b(this.Di.mAdTemplate, b, (JSONObject) null);
    }

    private void lU() {
        this.Di.mRootContainer.findViewById(R.id.splash_play_card_view).setVisibility(8);
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        aw awVar = this.wA;
        if (awVar != null) {
            awVar.sZ();
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        aw awVar = this.wA;
        if (awVar != null) {
            awVar.ta();
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.Di.Ct.a(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        aw awVar = this.wA;
        if (awVar != null) {
            awVar.sV();
            this.wA.sW();
        }
        lU();
        this.ld.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.ld;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_splash_end_card";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.du(this.Di.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ld = (FrameLayout) findViewById(R.id.splash_end_card_view);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        aw awVar = this.wA;
        if (awVar != null) {
            awVar.sX();
            this.wA.sY();
        }
        super.onUnbind();
        this.Di.Ct.b(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        aw awVar = this.wA;
        if (awVar != null) {
            awVar.sX();
            this.wA.sY();
        }
        lU();
        this.ld.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        aVar.width = com.kwad.sdk.c.a.a.px2dip(getContext(), this.Di.mRootContainer.getWidth());
        aVar.height = com.kwad.sdk.c.a.a.px2dip(getContext(), this.Di.mRootContainer.getHeight());
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
        Z(webCloseStatus.closeType);
        if (webCloseStatus.closeType == 2) {
            this.Di.kT();
        } else {
            com.kwad.components.ad.splashscreen.monitor.a.kU().Z(this.Di.mAdTemplate);
            this.Di.kP();
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        super.a(awVar);
        this.wA = awVar;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(r rVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(rVar, bVar);
        rVar.c(a(bVar));
    }

    @NonNull
    private x a(com.kwad.sdk.core.webview.b bVar) {
        return new x(bVar, this.Di.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.h.1
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    h.this.Di.mRootContainer.post(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.h.1.1
                        @Override // com.kwad.sdk.utils.az
                        public final void doTask() {
                            h.this.Di.kC();
                        }
                    });
                }
            }
        });
    }
}
