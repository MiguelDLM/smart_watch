package com.kwad.components.ad.splashscreen.presenter.a;

import android.os.SystemClock;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.f;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.m;
import com.kwad.components.core.webview.tachikoma.a.u;
import com.kwad.sdk.R;
import com.kwad.sdk.components.r;
import com.kwad.sdk.utils.az;

/* loaded from: classes11.dex */
public final class a extends c implements com.kwad.sdk.core.h.c {
    private m Fx;
    private FrameLayout ld;
    private aw wA;
    private boolean FA = false;
    f ES = new f() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.3
        @Override // com.kwad.components.ad.splashscreen.f
        public final void kx() {
            a.this.ld.postDelayed(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.ld.setVisibility(8);
                }
            }, 500L);
            if (a.this.wA != null) {
                a.this.wA.sX();
                a.this.wA.sY();
            }
        }
    };

    @NonNull
    private m md() {
        m mVar = new m();
        this.Fx = mVar;
        return mVar;
    }

    private void me() {
        com.kwad.components.ad.splashscreen.d.a aVar = this.Di.Cr;
        if (aVar != null) {
            aVar.mh();
        }
    }

    @NonNull
    private u mf() {
        u uVar = new u();
        uVar.a(new u.a() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.2
            @Override // com.kwad.components.core.webview.tachikoma.a.u.a
            public final void a(final u.b bVar) {
                int i = bVar.status;
                if (i == 1) {
                    a.this.Di.mRootContainer.post(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.2.1
                        @Override // com.kwad.sdk.utils.az
                        public final void doTask() {
                            if (com.kwad.components.core.e.c.b.nQ()) {
                                a.this.Di.mRootContainer.postDelayed(this, 1000L);
                            } else {
                                a.this.Di.kN();
                            }
                        }
                    });
                    return;
                }
                if (i == 2) {
                    a.this.Di.mRootContainer.post(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.2.2
                        @Override // com.kwad.sdk.utils.az
                        public final void doTask() {
                            com.kwad.components.ad.splashscreen.monitor.a.kU().Z(a.this.Di.mAdTemplate);
                            a.this.Di.kP();
                        }
                    });
                } else if (i == 3) {
                    a.this.Di.mRootContainer.post(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.2.3
                        @Override // com.kwad.sdk.utils.az
                        public final void doTask() {
                            a.this.Di.kE();
                        }
                    });
                } else if (i == 4) {
                    a.this.Di.mRootContainer.post(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.2.4
                        @Override // com.kwad.sdk.utils.az
                        public final void doTask() {
                            h hVar = a.this.Di;
                            u.b bVar2 = bVar;
                            hVar.i(bVar2.errorCode, bVar2.errorMsg);
                        }
                    });
                }
            }
        });
        return uVar;
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        if (this.Di.CA) {
            return;
        }
        aw awVar = this.wA;
        if (awVar != null) {
            awVar.sZ();
        } else {
            this.FA = true;
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        aw awVar;
        if (!this.Di.CA && (awVar = this.wA) != null) {
            awVar.ta();
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.ad.splashscreen.monitor.b.kW();
        h hVar = this.Di;
        com.kwad.components.ad.splashscreen.monitor.b.b(hVar.mAdTemplate, hVar.Cs);
        this.Di.Ct.a(this);
        this.Di.a(this.ES);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        aw awVar;
        if (this.Di.CA) {
            return;
        }
        aw awVar2 = this.wA;
        if (awVar2 != null) {
            awVar2.sV();
            this.wA.sW();
        }
        if (this.FA && (awVar = this.wA) != null) {
            awVar.sZ();
        }
        this.ld.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.ld;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_splash";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.cg(this.Di.mAdTemplate).splashPlayCardTKInfo.templateId;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c
    public final int mc() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        h hVar = this.Di;
        return (int) (com.kwad.sdk.core.response.b.b.dg(hVar.mAdTemplate) - (elapsedRealtime - hVar.CB));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ld = (FrameLayout) findViewById(R.id.splash_full_tk_play_card_view);
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
        this.Di.b(this.ES);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        aw awVar = this.wA;
        if (awVar != null) {
            awVar.sX();
            this.wA.sY();
        }
        this.ld.setVisibility(8);
        me();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        aVar.width = com.kwad.sdk.c.a.a.px2dip(getContext(), this.Di.mRootContainer.getWidth());
        aVar.height = com.kwad.sdk.c.a.a.px2dip(getContext(), this.Di.mRootContainer.getHeight());
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
        rVar.c(md());
        rVar.c(mf());
    }

    @NonNull
    private x a(com.kwad.sdk.core.webview.b bVar) {
        return new x(bVar, this.Di.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.1
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    a.this.Di.mRootContainer.post(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.1.1
                        @Override // com.kwad.sdk.utils.az
                        public final void doTask() {
                            a.this.Di.kC();
                        }
                    });
                }
            }
        });
    }
}
