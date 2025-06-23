package com.kwad.components.ad.interstitial.e.a;

import android.app.Activity;
import android.app.Dialog;
import android.os.Vibrator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.h.a.a.b;
import com.kwad.components.ad.interstitial.e.c;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.s.j;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.ao;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.bf;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.g;
import com.kwad.components.core.webview.tachikoma.a.n;
import com.kwad.components.core.webview.tachikoma.a.q;
import com.kwad.components.core.webview.tachikoma.b;
import com.kwad.components.core.webview.tachikoma.b.k;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.b.x;
import com.kwad.components.core.webview.tachikoma.e;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.r;
import com.kwad.sdk.core.g.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bj;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.br;
import java.io.File;

/* loaded from: classes11.dex */
public final class b extends a {
    private static long le = 400;
    private d eg;
    private Vibrator eh;
    private aw fD;

    @Nullable
    private com.kwad.components.ad.h.a.a.b lc;
    private FrameLayout ld;
    private boolean lg;
    private e lh;
    private boolean lf = false;
    private final c.a jP = new c.a() { // from class: com.kwad.components.ad.interstitial.e.a.b.1
        @Override // com.kwad.components.ad.interstitial.e.c.a
        public final void b(long j, long j2) {
            com.kwad.components.ad.interstitial.report.a.dN().b(b.this.jK.mAdTemplate, j, j2);
            if (b.this.lh != null) {
                com.kwad.components.core.webview.tachikoma.b.a aVar = new com.kwad.components.core.webview.tachikoma.b.a();
                aVar.aaQ = b.this.jK.jM ? 1 : 0;
                b.this.lh.b(aVar);
            }
        }
    };
    private com.kwad.sdk.core.h.c df = new com.kwad.sdk.core.h.d() { // from class: com.kwad.components.ad.interstitial.e.a.b.9
        @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
        public final void aM() {
            if (b.this.fD != null && !b.this.lf) {
                b.a(b.this, true);
                b.this.fD.sV();
                b.this.fD.sW();
            }
            if (b.this.fD != null) {
                b.this.fD.sZ();
            }
            if (b.this.lc != null) {
                b.this.lc.eI();
            }
            if (!b.this.lg) {
                b.this.jK.f18436io.getTimerHelper().startTiming();
            }
            if (!b.this.lg && !b.this.jK.jO && b.this.jK.ie != null) {
                b.this.jK.ie.onAdShow();
                com.kwad.components.ad.interstitial.report.c.dR().a(b.this.jK.mAdTemplate, 3);
                b.b(b.this, true);
            }
        }

        @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
        public final void aN() {
            if (b.this.fD != null) {
                b.this.fD.ta();
            }
            if (b.this.lc != null) {
                b.this.lc.eH();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bu() {
        if (getContext() != null) {
            this.eh = (Vibrator) getContext().getSystemService("vibrator");
        }
        float cT = com.kwad.sdk.core.response.b.b.cT(this.jK.mAdTemplate);
        if (this.eg == null) {
            d dVar = new d(cT);
            this.eg = dVar;
            dVar.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.interstitial.e.a.b.7
                @Override // com.kwad.sdk.core.g.b
                public final void a(double d) {
                    if (br.o(b.this.getTKContainer(), 100)) {
                        b.this.d(d);
                    }
                    bo.a(new az() { // from class: com.kwad.components.ad.interstitial.e.a.b.7.1
                        @Override // com.kwad.sdk.utils.az
                        public final void doTask() {
                            b.this.eg.Ge();
                        }
                    }, null, 500L);
                }

                @Override // com.kwad.sdk.core.g.b
                public final void aV() {
                }
            });
        }
        this.eg.g(cT);
        this.eg.bv(getContext());
    }

    private com.kwad.components.core.webview.tachikoma.c dC() {
        return new com.kwad.components.core.webview.tachikoma.c() { // from class: com.kwad.components.ad.interstitial.e.a.b.14
            @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.b.c cVar2 = new com.kwad.components.core.webview.tachikoma.b.c();
                cVar2.aaS = com.kwad.components.ad.interstitial.d.a.cO();
                cVar.a(cVar2);
            }
        };
    }

    private e dD() {
        return new e() { // from class: com.kwad.components.ad.interstitial.e.a.b.15
            @Override // com.kwad.components.core.webview.tachikoma.e, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.b.a aVar = new com.kwad.components.core.webview.tachikoma.b.a();
                aVar.aaQ = b.this.jK.jM ? 1 : 0;
                cVar.a(aVar);
            }
        };
    }

    private g dE() {
        k kVar = new k();
        kVar.aaX = this.jK.jZ;
        return new g(kVar);
    }

    private com.kwad.components.ad.h.a.a.a dF() {
        final com.kwad.components.ad.h.a.a.a aVar = new com.kwad.components.ad.h.a.a.a();
        this.jK.jU.add(new c.InterfaceC0745c() { // from class: com.kwad.components.ad.interstitial.e.a.b.16
            @Override // com.kwad.components.ad.interstitial.e.c.InterfaceC0745c
            public final void da() {
                aVar.eF();
            }
        });
        return aVar;
    }

    private bf dG() {
        bf bfVar = new bf(getContext(), this.jK.mAdTemplate);
        bfVar.a(new bf.a() { // from class: com.kwad.components.ad.interstitial.e.a.b.3
            @Override // com.kwad.components.core.webview.jshandler.bf.a
            public final boolean dL() {
                com.kwad.components.core.page.a.launch(b.this.getContext(), b.this.jK.mAdTemplate);
                b.this.jK.a(true, -1, null);
                bo.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.a.b.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.du();
                    }
                }, 0L);
                return false;
            }
        });
        return bfVar;
    }

    @NonNull
    private n dH() {
        return new n() { // from class: com.kwad.components.ad.interstitial.e.a.b.4
            @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull final com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                bo.runOnUiThreadDelay(new az() { // from class: com.kwad.components.ad.interstitial.e.a.b.4.1
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        boolean z;
                        com.kwad.components.core.webview.tachikoma.b.d dVar = new com.kwad.components.core.webview.tachikoma.b.d();
                        if (!ah.isWifiConnected(b.this.getContext()) && !b.this.jK.dU.isDataFlowAutoStart() && !b.l(b.this.jK.mAdTemplate)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        dVar.aaT = z;
                        cVar.a(dVar);
                    }
                }, 0L);
            }
        };
    }

    @NonNull
    private ai dI() {
        return new ai(new ai.b() { // from class: com.kwad.components.ad.interstitial.e.a.b.5
            @Override // com.kwad.components.core.webview.jshandler.ai.b
            public final void a(final ai.a aVar) {
                if (b.this.jK.f18436io != null) {
                    b.this.jK.jS.post(new az() { // from class: com.kwad.components.ad.interstitial.e.a.b.5.1
                        @Override // com.kwad.sdk.utils.az
                        public final void doTask() {
                            boolean z = true;
                            if (aVar.type != 0 || b.this.jK.jM || b.this.jK.jN || !com.kwad.components.ad.interstitial.f.a.d(b.this.jK)) {
                                b.this.dK();
                                c cVar = b.this.jK;
                                ai.a aVar2 = aVar;
                                if (aVar2.type != 3) {
                                    z = false;
                                }
                                cVar.a(z, aVar2.XY, null);
                                b.this.du();
                                return;
                            }
                            b.this.jK.jN = true;
                            com.kwad.components.ad.interstitial.c.b.H(b.this.getContext());
                        }
                    });
                }
            }
        });
    }

    private v dJ() {
        return new v() { // from class: com.kwad.components.ad.interstitial.e.a.b.6
            @Override // com.kwad.components.core.webview.jshandler.v
            public final void a(x xVar) {
                super.a(xVar);
                if (!b.this.jK.jO && b.this.jK.ie != null) {
                    b.this.jK.ie.onVideoPlayStart();
                }
            }

            @Override // com.kwad.components.core.webview.jshandler.v
            public final void c(x xVar) {
                super.c(xVar);
                if (!b.this.jK.jO && b.this.jK.ie != null) {
                    b.this.jK.ie.onVideoPlayEnd();
                }
            }

            @Override // com.kwad.components.core.webview.jshandler.v
            public final void d(x xVar) {
                super.d(xVar);
                b.this.jK.mAdTemplate.setmCurPlayTime(xVar.nF);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dK() {
        aw awVar = this.fD;
        if (awVar != null) {
            awVar.sX();
            this.fD.sY();
        }
        com.kwad.components.ad.h.a.a.b bVar = this.lc;
        if (bVar != null) {
            bVar.eH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void du() {
        c cVar = this.jK;
        if (cVar == null) {
            return;
        }
        com.kwad.components.ad.interstitial.d dVar = cVar.f18436io;
        if (dVar != null && a(dVar)) {
            this.jK.f18436io.dismiss();
        }
        try {
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.jK.ie;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClosed();
            }
        } catch (Throwable th) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        }
    }

    private ao.a getOpenNewPageListener() {
        return new ao.a() { // from class: com.kwad.components.ad.interstitial.e.a.b.8
            @Override // com.kwad.components.core.webview.jshandler.ao.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(b.this.getContext(), new AdWebViewActivityProxy.a.C0799a().at(bVar.title).au(bVar.url).aC(true).m(b.this.jK.mAdResultData).pK());
            }
        };
    }

    @Override // com.kwad.components.ad.interstitial.e.a.a, com.kwad.components.ad.interstitial.e.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        com.kwad.components.ad.interstitial.report.c.dR().s(this.jK.mAdTemplate);
        com.kwad.components.core.webview.tachikoma.e.e eVar = this.jK.jR;
        if (eVar != null) {
            eVar.a(getTkTemplateId(), 0L, 0L, 0L);
        }
        if (this.fD != null && this.jK.ib.dX()) {
            this.lf = true;
            this.fD.sV();
            this.fD.sW();
        }
        this.jK.ib.a(this.df);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.ld;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_interstitial";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dv(this.jK.mAdTemplate);
    }

    @Override // com.kwad.components.ad.interstitial.e.a.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ksad_tk_view);
        this.ld = frameLayout;
        frameLayout.setVisibility(0);
    }

    @Override // com.kwad.components.ad.interstitial.e.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.lf = false;
        this.lg = false;
        bo.b(getContext(), this.eh);
        d dVar = this.eg;
        if (dVar != null) {
            dVar.bw(getContext());
        }
        com.kwad.components.ad.interstitial.f.b bVar = this.jK.ib;
        if (bVar != null) {
            bVar.b(this.df);
        }
        this.jK.b(this.jP);
    }

    public static /* synthetic */ boolean b(b bVar, boolean z) {
        bVar.lg = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(double d) {
        this.jK.a(new c.b(getContext()).l(true).c(d).z(2).a(this.jK.jS.getTouchCoords()).A(157));
        bo.vibrate(getContext(), this.eh, le);
    }

    public static boolean l(@NonNull AdTemplate adTemplate) {
        File bZ = com.kwad.sdk.core.diskcache.b.a.DM().bZ(com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.dS(adTemplate)));
        return bZ != null && bZ.exists();
    }

    public static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.lf = true;
        return true;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aW = com.kwad.sdk.c.a.a.aW(getContext());
        aVar.width = (int) ((bj.getScreenWidth(getContext()) / aW) + 0.5f);
        aVar.height = (int) ((bj.getScreenHeight(getContext()) / aW) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        this.ld.setVisibility(8);
        com.kwad.components.core.webview.tachikoma.e.e eVar = this.jK.jR;
        if (eVar != null) {
            getTkTemplateId();
            eVar.q(getTKReaderScene());
        }
    }

    @Override // com.kwad.components.ad.interstitial.e.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(r rVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(rVar, bVar);
        com.kwad.components.ad.h.a.a.b z = com.kwad.components.ad.h.a.a.b.z(this.jK.mAdTemplate);
        this.lc = z;
        if (z != null) {
            z.a(new b.InterfaceC0737b() { // from class: com.kwad.components.ad.interstitial.e.a.b.10
                @Override // com.kwad.components.ad.h.a.a.b.InterfaceC0737b
                public final void E(int i) {
                    if (i == com.kwad.components.ad.h.a.a.b.nv) {
                        b.this.jK.b(b.this.getContext(), b.this.jK.mAdTemplate);
                        b.this.jK.a(true, -1, null);
                    }
                    b.this.du();
                }
            });
            rVar.c(this.lc);
            this.lc.eG();
        }
        rVar.c(dI());
        rVar.c(new ao(getOpenNewPageListener()));
        if (com.kwad.sdk.core.response.b.b.dv(com.kwad.sdk.core.response.b.e.dS(this.jK.mAdTemplate))) {
            rVar.c(new ay(new ay.a() { // from class: com.kwad.components.ad.interstitial.e.a.b.11
                @Override // com.kwad.components.core.webview.jshandler.ay.a
                public final void bB() {
                    b.this.bu();
                }
            }));
        }
        rVar.c(dH());
        rVar.c(dG());
        rVar.c(dE());
        rVar.c(a(bVar));
        rVar.c(dJ());
        rVar.c(dF());
        rVar.c(new q() { // from class: com.kwad.components.ad.interstitial.e.a.b.12
            @Override // com.kwad.components.core.webview.tachikoma.a.q, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                j.e(b.this.getContext(), b.this.jK.mAdTemplate);
            }
        });
        this.lh = dD();
        this.jK.a(this.jP);
        rVar.c(this.lh);
        rVar.c(new com.kwad.components.core.webview.tachikoma.b(new b.a() { // from class: com.kwad.components.ad.interstitial.e.a.b.13
            @Override // com.kwad.components.core.webview.tachikoma.b.a
            public final void dM() {
                com.kwad.components.ad.interstitial.d.a.I(b.this.getContext());
            }
        }));
        rVar.c(dC());
    }

    @Override // com.kwad.components.ad.interstitial.e.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        super.a(awVar);
        this.fD = awVar;
    }

    @NonNull
    private com.kwad.components.core.webview.jshandler.x a(com.kwad.sdk.core.webview.b bVar) {
        return new com.kwad.components.core.webview.jshandler.x(bVar, this.jK.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.interstitial.e.a.b.2
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    com.kwad.components.ad.interstitial.report.a.dN().a(b.this.jK.mAdTemplate, aVar.aGa, aVar.kl);
                    b.this.jK.jM = true;
                    if (!b.this.jK.jO) {
                        b.this.jK.b(aVar.aGa, aVar.kl);
                    }
                    if (b.this.jK.f18436io != null && com.kwad.components.ad.interstitial.d.b.k(b.this.jK.mAdTemplate)) {
                        b.this.jK.a(false, -1, b.this.jK.eN);
                        b.this.jK.f18436io.dismiss();
                        b.this.jK.cR();
                    }
                }
            }
        });
    }

    @Override // com.kwad.components.ad.interstitial.e.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
        super.a(tVar);
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.jK.ie;
        if (adInteractionListener != null) {
            adInteractionListener.onSkippedAd();
        }
    }

    private static boolean a(Dialog dialog) {
        Activity ownerActivity = dialog.getOwnerActivity();
        return (ownerActivity == null || ownerActivity.isFinishing()) ? false : true;
    }

    @Override // com.kwad.components.ad.interstitial.e.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        this.jK.a(webCloseStatus.closeType == 2, -1, null);
        du();
    }
}
