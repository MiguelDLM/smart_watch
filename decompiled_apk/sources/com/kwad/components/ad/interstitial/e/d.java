package com.kwad.components.ad.interstitial.e;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.kwad.components.ad.interstitial.e.c;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class d extends b {
    private static float ks = 0.749f;
    private static float kt = 0.8f;
    private static float ku = 1.0f;
    private com.kwad.components.core.widget.a.b bQ;
    private com.kwad.sdk.core.video.videoview.a eN;
    private KsAutoCloseView jH;
    private c jK;
    private c.a jP;
    private boolean kq;
    private KSFrameLayout kr;
    private com.kwad.sdk.core.h.d kv = new com.kwad.sdk.core.h.d() { // from class: com.kwad.components.ad.interstitial.e.d.5
        @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
        public final void aM() {
            if (!d.this.mAdTemplate.mPvReported && !d.this.jK.jO && d.this.jK.ie != null) {
                d.this.jK.ie.onAdShow();
                d.this.jK.f18436io.getTimerHelper().startTiming();
                com.kwad.components.ad.interstitial.report.c.dR().a(d.this.jK.mAdTemplate, 1);
            }
            com.kwad.sdk.core.adlog.c.b cW = new com.kwad.sdk.core.adlog.c.b().cW(d.this.jK.jZ);
            if (!d.this.mAdTemplate.mPvReported) {
                com.kwad.components.ad.interstitial.report.c.dR().u(d.this.mAdTemplate);
            }
            com.kwad.components.core.s.b.rC().a(d.this.mAdTemplate, null, cW);
            d.this.jH.setCountDownPaused(false);
        }

        @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
        public final void aN() {
            d.this.jH.setCountDownPaused(true);
        }
    };
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    /* JADX INFO: Access modifiers changed from: private */
    public static ViewGroup.LayoutParams B(int i) {
        int i2 = (int) (i * ks);
        return new ViewGroup.LayoutParams((int) (i2 / 0.749f), i2);
    }

    private static float b(boolean z, boolean z2) {
        return (z && z2) ? 1.7777778f : 0.749f;
    }

    private c.a dc() {
        c.a aVar = new c.a() { // from class: com.kwad.components.ad.interstitial.e.d.4
            @Override // com.kwad.components.ad.interstitial.e.c.a
            public final void b(long j, long j2) {
                com.kwad.components.ad.interstitial.report.a.dN().b(d.this.mAdTemplate, j, j2);
            }
        };
        this.jP = aVar;
        return aVar;
    }

    private void dd() {
        final com.kwad.components.ad.interstitial.g.d dVar = this.jK.jL;
        dVar.setAdTemplate(this.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.bc(this.mAdInfo)) {
            dVar.c(com.kwad.sdk.core.response.b.a.aT(this.mAdInfo).materialUrl, this.mAdTemplate);
            dVar.c(true, true);
            dVar.t(false);
        } else {
            dVar.t(true);
            String url = com.kwad.sdk.core.response.b.a.bs(this.mAdInfo).getUrl();
            if (!TextUtils.isEmpty(url)) {
                dVar.c(url, this.mAdTemplate);
                dVar.c(true, false);
            } else {
                dVar.c(false, false);
            }
            com.kwad.sdk.core.video.videoview.a aVar = this.jK.eN;
            this.eN = aVar;
            if (aVar.getParent() != null) {
                ((ViewGroup) this.eN.getParent()).removeView(this.eN);
            }
            if (com.kwad.sdk.core.response.b.a.bb(this.mAdInfo)) {
                dVar.a(com.kwad.sdk.core.response.b.a.aU(this.mAdInfo).height / com.kwad.sdk.core.response.b.a.aU(this.mAdInfo).width, this.eN);
            }
            dVar.u(this.jK.dU.isVideoSoundEnable());
            final int L = com.kwad.sdk.core.response.b.a.L(this.mAdInfo);
            this.jK.a(new a.c() { // from class: com.kwad.components.ad.interstitial.e.d.6
                @Override // com.kwad.components.core.video.a.c
                public final void bl() {
                    dVar.c(false, false);
                }

                @Override // com.kwad.components.core.video.a.c
                public final void bm() {
                    d.this.eN.setVisibility(8);
                    if (!d.this.jK.J(d.this.getContext())) {
                        dVar.eh();
                    }
                }

                @Override // com.kwad.components.core.video.a.c
                @SuppressLint({"SetTextI18n"})
                public final void e(long j) {
                    int i = L - ((int) (j / 1000));
                    if (i >= 0) {
                        dVar.w(String.valueOf(i));
                    } else {
                        dVar.ef();
                    }
                }

                @Override // com.kwad.components.core.video.a.c
                public final void onVideoPlayStart() {
                    dVar.t(true);
                }
            });
            dVar.a(this.mAdTemplate, this.mAdInfo);
            dVar.t(true);
            this.jK.jU.add(new c.InterfaceC0745c() { // from class: com.kwad.components.ad.interstitial.e.d.7
                @Override // com.kwad.components.ad.interstitial.e.c.InterfaceC0745c
                public final void da() {
                    dVar.ei();
                    d.this.eN.setVisibility(0);
                }
            });
        }
        this.jK.a(getContext(), this.mAdInfo, this.mAdTemplate, dVar.getBlurBgView());
        String O = com.kwad.sdk.core.response.b.a.O(this.mAdInfo);
        if (TextUtils.isEmpty(O)) {
            O = com.kwad.sdk.core.response.b.a.W(this.mAdInfo);
        }
        KSImageLoader.loadImage(dVar.getTailFrameView(), O, this.mAdTemplate);
        if (c(this.mAdInfo)) {
            this.jH.aY(true);
            de();
        } else {
            this.jH.aY(false);
        }
    }

    private void de() {
        AdInfo adInfo = this.mAdInfo;
        int i = adInfo.adInsertScreenInfo.autoCloseTime;
        if (com.kwad.sdk.core.response.b.a.bb(adInfo)) {
            i = Math.min(i, com.kwad.sdk.core.response.b.a.L(this.mAdInfo));
            this.jK.jL.ef();
            this.jK.jL.eg();
        }
        this.jH.U(i);
        com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 165, (JSONObject) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z) {
        c cVar = this.jK;
        if (!cVar.jO && !z && !cVar.jM && !cVar.jN && com.kwad.components.ad.interstitial.f.a.d(cVar)) {
            this.jK.jN = true;
            com.kwad.components.ad.interstitial.c.b.H(getContext());
            return;
        }
        this.jK.a(z, -1, this.eN);
        this.jK.f18436io.dismiss();
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar != null) {
            aVar.release();
        }
        this.jK.cR();
    }

    @Override // com.kwad.components.ad.interstitial.e.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        c cVar = (c) Kf();
        this.jK = cVar;
        this.mAdTemplate = cVar.mAdTemplate;
        com.kwad.components.ad.interstitial.report.c.dR().t(this.jK.mAdTemplate);
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dS(this.jK.mAdTemplate);
        this.jK.jS.setBackgroundColor(Color.parseColor("#99000000"));
        this.jK.jL.setVisibility(0);
        this.jK.jL.y(this.mAdTemplate);
        this.jK.a(dc());
        dd();
        this.jK.jL.setViewListener(new com.kwad.components.ad.interstitial.g.e() { // from class: com.kwad.components.ad.interstitial.e.d.2
            @Override // com.kwad.components.ad.interstitial.g.e
            public final void a(KSFrameLayout kSFrameLayout) {
                d.this.kr = kSFrameLayout;
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void dg() {
                d.this.n(false);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void dh() {
                int i;
                if (d.this.jK.jL.ej()) {
                    i = 53;
                } else {
                    i = 85;
                }
                d.this.e(3, i);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void di() {
                d.this.e(1, 39);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void dj() {
                d.this.e(1, 29);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void dk() {
                d.this.e(3, 85);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void dl() {
                d.this.e(3, 85);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void dm() {
                d.this.e(2, 53);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void dn() {
                d.this.e(2, 30);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            /* renamed from: do, reason: not valid java name */
            public final void mo272do() {
                d.this.e(2, 31);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void dp() {
                d.this.e(2, 32);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void dq() {
                d.this.e(2, 15);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void dr() {
                d.this.e(2, 16);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void ds() {
                d.this.e(2, 17);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void dt() {
                d.this.e(2, 35);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void o(boolean z) {
                if (d.this.eN != null) {
                    d.this.eN.setVideoSoundEnable(z);
                }
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void p(boolean z) {
                d.this.kq = z;
            }
        });
        com.kwad.components.core.widget.a.b bVar = new com.kwad.components.core.widget.a.b(this.jK.jL, 100);
        this.bQ = bVar;
        bVar.a(this.kv);
        this.bQ.ua();
        final boolean aV = com.kwad.sdk.core.response.b.a.aV(this.mAdInfo);
        getContext();
        final boolean ML = aj.ML();
        this.jK.jL.setRatio(b(ML, aV));
        final ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_interstitial_native);
        viewGroup.setVisibility(0);
        viewGroup.post(new az() { // from class: com.kwad.components.ad.interstitial.e.d.3
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                ViewGroup.LayoutParams B;
                if (!ML) {
                    B = d.B(d.this.getRootView().getHeight());
                } else {
                    B = d.a(d.this.getRootView().getWidth(), aV);
                }
                ViewParent parent = d.this.jK.jL.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(d.this.jK.jL);
                }
                viewGroup.addView(d.this.jK.jL);
                d.this.jK.jL.f(B.width, B.height);
                viewGroup.requestLayout();
                viewGroup.post(new az() { // from class: com.kwad.components.ad.interstitial.e.d.3.1
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        if (d.this.eN != null) {
                            d.this.eN.requestLayout();
                        }
                    }
                });
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        KsAutoCloseView ksAutoCloseView = (KsAutoCloseView) findViewById(R.id.ksad_interstitial_auto_close);
        this.jH = ksAutoCloseView;
        ksAutoCloseView.setViewListener(new KsAutoCloseView.a() { // from class: com.kwad.components.ad.interstitial.e.d.1
            @Override // com.kwad.components.core.widget.KsAutoCloseView.a
            public final void df() {
                d.this.n(true);
            }

            @Override // com.kwad.components.core.widget.KsAutoCloseView.a
            public final void dg() {
                d.this.n(false);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.jK.b(this.jP);
        com.kwad.components.core.widget.a.b bVar = this.bQ;
        if (bVar != null) {
            bVar.b(this.kv);
            this.bQ.ub();
        }
    }

    private static boolean c(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.autoCloseTime > 0 && !com.kwad.sdk.core.response.b.a.bI(adInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i, int i2) {
        this.jK.a(new c.b(getContext()).k(this.kq).a(this.kr.getTouchCoords()).z(i).A(i2));
        if (com.kwad.components.ad.interstitial.d.b.k(this.mAdTemplate)) {
            c cVar = this.jK;
            if (cVar.f18436io != null) {
                cVar.a(false, -1, cVar.eN);
                this.jK.f18436io.dismiss();
                this.jK.cR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ViewGroup.LayoutParams a(int i, boolean z) {
        float f;
        if (z) {
            f = kt;
        } else {
            f = ku;
        }
        int i2 = (int) (i * f);
        return new ViewGroup.LayoutParams(i2, (int) (i2 * (z ? 1.7777778f : 0.749f)));
    }
}
