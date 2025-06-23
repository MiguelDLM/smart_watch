package com.kwad.components.ad.splashscreen.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.R;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bo;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class p extends e implements com.kwad.components.ad.splashscreen.e, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.h.c {
    private com.kwad.components.ad.splashscreen.e.b Ea;
    private boolean Eb;
    private long Ed;
    private aw Ee;
    private ViewGroup Eg;

    @Nullable
    private KsAdWebView cL;
    private com.kwad.components.core.webview.a cN;
    private com.kwad.sdk.core.webview.b cO;
    private com.kwad.sdk.core.g.d eg;
    private Vibrator eh;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private long mStartTime;
    private boolean Ec = false;
    private boolean Ef = false;
    private final Runnable Eh = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.p.1
        @Override // java.lang.Runnable
        public final void run() {
            p.a(p.this, true);
            com.kwad.components.ad.splashscreen.monitor.c.a(p.this.mAdTemplate, com.kwad.sdk.core.response.b.b.ck(p.this.mAdTemplate), SystemClock.elapsedRealtime() - p.this.Ed, 1, "");
            p.this.lx();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public Vibrator C(Context context) {
        if (context != null) {
            return (Vibrator) getContext().getSystemService("vibrator");
        }
        return null;
    }

    private void aA() {
        com.kwad.components.core.webview.a aVar = this.cN;
        if (aVar != null) {
            aVar.destroy();
            this.cN = null;
        }
    }

    private void ax() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cO = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cO;
        bVar2.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout = this.Di.mRootContainer;
        bVar2.aEW = adBaseFrameLayout;
        bVar2.Ph = adBaseFrameLayout;
        bVar2.OA = this.cL;
        bVar2.mReportExtData = null;
        bVar2.aEY = false;
        bVar2.aEZ = com.kwad.components.ad.splashscreen.h.n(this.mAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu() {
        if (this.eg == null && !this.Ec) {
            com.kwad.sdk.core.g.d dVar = new com.kwad.sdk.core.g.d(com.kwad.sdk.core.response.b.b.cV(this.Di.mAdTemplate));
            this.eg = dVar;
            dVar.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.splashscreen.presenter.p.6
                @Override // com.kwad.sdk.core.g.b
                public final void a(double d) {
                    boolean nQ = com.kwad.components.core.e.c.b.nQ();
                    if (p.this.Di.Ct.ud() && !nQ) {
                        p.this.h(d);
                        if (p.this.eh == null) {
                            p pVar = p.this;
                            pVar.eh = pVar.C(pVar.getContext());
                        }
                        bo.a(p.this.getContext(), p.this.eh);
                        p.this.eg.bw(p.this.getContext());
                    }
                }

                @Override // com.kwad.sdk.core.g.b
                public final void aV() {
                }
            });
            this.eg.bv(getContext());
        }
    }

    private aa lA() {
        return new aa(this.cO, this.Di.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.p.10
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                int i;
                if (!aVar.Yl && com.kwad.components.ad.splashscreen.h.n(p.this.mAdInfo)) {
                    return;
                }
                if (aVar.Yl) {
                    i = 1;
                } else {
                    i = 3;
                }
                p.this.a(false, i, aVar.kl, "");
            }
        }, (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lx() {
        this.Ec = true;
        KsAdWebView ksAdWebView = this.cL;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        ViewGroup viewGroup = this.Eg;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        final Presenter y = y(this.mAdInfo);
        if (y != null) {
            bo.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.p.8
                @Override // java.lang.Runnable
                public final void run() {
                    p.this.a(y, true);
                }
            });
        } else {
            ly();
        }
    }

    private void ly() {
        lw();
        com.kwad.components.ad.splashscreen.e.b bVar = new com.kwad.components.ad.splashscreen.e.b((ViewGroup) getRootView(), (ViewStub) findViewById(R.id.ksad_splash_actionbar_native_stub), com.kwad.sdk.core.response.b.d.dH(this.mAdTemplate), this.Di.mApkDownloadHelper);
        this.Ea = bVar;
        bVar.ai(this.mAdTemplate);
        this.Ea.a(this);
        this.Ea.lx();
    }

    private x lz() {
        return new x(this.cO, this.Di.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.p.9
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (com.kwad.sdk.c.a.a.Bc()) {
                    return;
                }
                if (aVar.HM() || com.kwad.components.ad.splashscreen.h.n(p.this.mAdInfo)) {
                    p.this.a(false, aVar.Yn, aVar.kl, aVar.Yo.Lh);
                }
            }
        });
    }

    private Presenter y(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.dg(com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate))) {
            if (!com.kwad.sdk.core.response.b.b.dG(adInfo)) {
                return null;
            }
            return new l();
        }
        if (com.kwad.sdk.core.response.b.b.dE(this.mAdInfo)) {
            return new m();
        }
        if (com.kwad.sdk.core.response.b.b.dG(this.mAdInfo)) {
            return new l();
        }
        if (!com.kwad.sdk.core.response.b.b.dJ(this.mAdInfo)) {
            return null;
        }
        return new n();
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void W(int i) {
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar != null) {
            dVar.bv(getContext());
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar != null) {
            dVar.bw(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.mStartTime = SystemClock.elapsedRealtime();
        this.Di.Ct.a(this);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_splash_webview_container);
        this.Eg = viewGroup;
        viewGroup.setVisibility(0);
        try {
            this.cL = new KsAdWebView(getContext());
            this.cL.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.Eg.addView(this.cL);
        } catch (Throwable unused) {
        }
        AdTemplate adTemplate = this.Di.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        this.Eb = false;
        this.Ec = false;
        String ck = com.kwad.sdk.core.response.b.b.ck(this.mAdTemplate);
        if (this.cL != null && !TextUtils.isEmpty(ck) && !this.Di.Cy) {
            this.Ed = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.c.ah(this.mAdTemplate);
            a(this.cL, ck);
            bo.a(this.Eh, null, com.kwad.sdk.core.response.b.b.dN(this.mAdInfo));
        } else {
            lx();
        }
        this.Di.a(this);
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void kB() {
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar != null) {
            dVar.bw(getContext());
        }
    }

    @SuppressLint({"WrongConstant"})
    public final void lw() {
        if (this.Eb) {
            return;
        }
        this.Eb = true;
        a.C0845a c0845a = new a.C0845a();
        c0845a.aqh = com.kwad.components.ad.splashscreen.local.b.s(this.mAdInfo);
        com.kwad.sdk.core.adlog.c.d(this.Di.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cM(123).b(c0845a));
        com.kwad.components.core.webview.tachikoma.d.a.tC().aW(123);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        com.kwad.sdk.core.h.a aVar;
        super.onUnbind();
        com.kwad.components.ad.splashscreen.e.b bVar = this.Ea;
        if (bVar != null) {
            bVar.onUnbind();
        }
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar != null) {
            dVar.bw(getContext());
        }
        aw awVar = this.Ee;
        if (awVar != null) {
            awVar.sX();
            this.Ee.sY();
        }
        com.kwad.components.ad.splashscreen.h hVar = this.Di;
        if (hVar != null && (aVar = hVar.Ct) != null) {
            aVar.b(this);
        }
        aA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final double d) {
        com.kwad.components.ad.splashscreen.h hVar = this.Di;
        if (hVar != null) {
            hVar.a(1, getContext(), 157, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.p.7
                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                    bVar.l(d);
                }
            });
        }
    }

    @Override // com.kwad.components.ad.splashscreen.e
    public final void h(boolean z, boolean z2) {
        com.kwad.sdk.core.e.c.d("SplashWebViewPresenter", "isClick: " + z + ", isActionBar: " + z2);
        a(!z, z2 ? 1 : 2, 132, null);
    }

    public static /* synthetic */ boolean a(p pVar, boolean z) {
        pVar.Ef = true;
        return true;
    }

    private void a(KsAdWebView ksAdWebView, final String str) {
        ksAdWebView.setBackgroundColor(0);
        ksAdWebView.setVisibility(0);
        ax();
        a((WebView) ksAdWebView, str);
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().ek(this.Di.mAdTemplate).b(new com.kwad.sdk.core.webview.f() { // from class: com.kwad.components.ad.splashscreen.presenter.p.3
            @Override // com.kwad.sdk.core.webview.f, com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                super.onPageFinished();
                com.kwad.components.ad.splashscreen.monitor.c.b(p.this.mAdTemplate, str, SystemClock.elapsedRealtime() - p.this.Ed);
            }

            @Override // com.kwad.sdk.core.webview.f, com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str2, String str3) {
                super.onReceivedHttpError(i, str2, str3);
                bo.c(p.this.Eh);
                p.this.lx();
                com.kwad.components.ad.splashscreen.monitor.c.a(p.this.mAdTemplate, str, SystemClock.elapsedRealtime() - p.this.Ed, 2, str2);
            }
        }));
        com.kwad.components.ad.splashscreen.monitor.c.d(str, this.mAdTemplate);
        try {
            ksAdWebView.loadUrl(str);
        } catch (Throwable unused) {
            lx();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void a(WebView webView, String str) {
        aA();
        webView.getSettings().setAllowFileAccess(true);
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(webView);
        this.cN = aVar;
        a(aVar, str);
        webView.addJavascriptInterface(this.cN, "KwaiAd");
    }

    private void a(com.kwad.components.core.webview.a aVar, final String str) {
        aVar.a(new az(this.cO, this.Di.mApkDownloadHelper));
        aVar.a(lA());
        aVar.a(lz());
        aVar.a(new ad(this.cO));
        aVar.a(new com.kwad.components.core.webview.tachikoma.a.f());
        aVar.a(new aq(new aq.b() { // from class: com.kwad.components.ad.splashscreen.presenter.p.4
            @Override // com.kwad.components.core.webview.jshandler.aq.b
            public final void a(aq.a aVar2) {
                com.kwad.sdk.core.e.c.d("SplashWebViewPresenter", "updatePageStatus: " + aVar2);
                bo.c(p.this.Eh);
                if (aVar2.status == 1) {
                    p.this.Di.CK = SystemClock.elapsedRealtime() - p.this.mStartTime;
                    if (!p.this.Ef) {
                        if (p.this.Ee != null) {
                            p.this.Ee.sV();
                            p.this.Ee.sW();
                        }
                    } else {
                        p.this.Di.isWebTimeout = true;
                    }
                    if (com.kwad.sdk.core.response.b.b.dL(p.this.mAdInfo)) {
                        p.this.lw();
                        return;
                    }
                    return;
                }
                com.kwad.components.ad.splashscreen.monitor.c.a(p.this.mAdTemplate, str, SystemClock.elapsedRealtime() - p.this.Ed, 3, "");
                p.this.lx();
            }
        }, str));
        aVar.a(new ay(new ay.a() { // from class: com.kwad.components.ad.splashscreen.presenter.p.5
            @Override // com.kwad.components.core.webview.jshandler.ay.a
            public final void bB() {
                p.this.bu();
            }
        }));
        aVar.a(new ak(this.cO));
        aVar.b(new com.kwad.components.core.webview.jshandler.m(this.cO));
        aVar.b(new com.kwad.components.core.webview.jshandler.l(this.cO));
        aw awVar = new aw();
        this.Ee = awVar;
        aVar.a(awVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r11, int r12, int r13, java.lang.String r14) {
        /*
            r10 = this;
            com.kwad.components.ad.splashscreen.h r0 = r10.Di
            r0.kC()
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            r1 = r0 ^ 1
            r2 = 0
            r3 = 1
            if (r12 != r3) goto L11
            r4 = 1
            goto L12
        L11:
            r4 = 0
        L12:
            if (r0 == 0) goto L4d
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            com.kwad.components.ad.splashscreen.h r6 = r10.Di     // Catch: org.json.JSONException -> L2b
            if (r6 == 0) goto L4d
            com.kwad.components.ad.splashscreen.d.a r6 = r6.Cr     // Catch: org.json.JSONException -> L2b
            if (r6 == 0) goto L2e
            java.lang.String r7 = "duration"
            long r8 = r6.getCurrentPosition()     // Catch: org.json.JSONException -> L2b
            r5.put(r7, r8)     // Catch: org.json.JSONException -> L2b
            goto L2e
        L2b:
            r11 = move-exception
            r2 = r13
            goto L49
        L2e:
            if (r11 == 0) goto L33
            r2 = 153(0x99, float:2.14E-43)
            goto L37
        L33:
            if (r4 == 0) goto L37
            r2 = 132(0x84, float:1.85E-43)
        L37:
            com.kwad.sdk.core.adlog.c.b r11 = new com.kwad.sdk.core.adlog.c.b     // Catch: org.json.JSONException -> L48
            r11.<init>()     // Catch: org.json.JSONException -> L48
            com.kwad.sdk.core.adlog.c.b r11 = r11.cK(r2)     // Catch: org.json.JSONException -> L48
            com.kwad.components.ad.splashscreen.h r6 = r10.Di     // Catch: org.json.JSONException -> L48
            com.kwad.sdk.core.response.model.AdTemplate r6 = r6.mAdTemplate     // Catch: org.json.JSONException -> L48
            com.kwad.sdk.core.adlog.c.a(r6, r11, r5)     // Catch: org.json.JSONException -> L48
            goto L4e
        L48:
            r11 = move-exception
        L49:
            com.kwad.sdk.core.e.c.printStackTrace(r11)
            goto L4e
        L4d:
            r2 = r13
        L4e:
            com.kwad.components.core.e.d.a$a r11 = new com.kwad.components.core.e.d.a$a
            com.kwad.components.ad.splashscreen.h r5 = r10.Di
            com.kwad.sdk.core.view.AdBaseFrameLayout r5 = r5.mRootContainer
            android.content.Context r5 = r5.getContext()
            r11.<init>(r5)
            com.kwad.components.ad.splashscreen.h r5 = r10.Di
            com.kwad.sdk.core.response.model.AdTemplate r5 = r5.mAdTemplate
            com.kwad.components.core.e.d.a$a r11 = r11.ar(r5)
            com.kwad.components.ad.splashscreen.h r5 = r10.Di
            com.kwad.components.core.e.d.c r5 = r5.mApkDownloadHelper
            com.kwad.components.core.e.d.a$a r11 = r11.b(r5)
            com.kwad.components.core.e.d.a$a r11 = r11.ao(r4)
            com.kwad.components.core.e.d.a$a r11 = r11.an(r12)
            if (r0 != 0) goto L76
            goto L77
        L76:
            r13 = r2
        L77:
            com.kwad.components.core.e.d.a$a r11 = r11.am(r13)
            com.kwad.components.core.e.d.a$a r11 = r11.ah(r14)
            com.kwad.components.core.e.d.a$a r11 = r11.al(r3)
            com.kwad.components.core.e.d.a$a r11 = r11.aq(r1)
            com.kwad.components.ad.splashscreen.presenter.p$2 r12 = new com.kwad.components.ad.splashscreen.presenter.p$2
            r12.<init>()
            com.kwad.components.core.e.d.a$a r11 = r11.a(r12)
            com.kwad.components.core.e.d.a.a(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.splashscreen.presenter.p.a(boolean, int, int, java.lang.String):void");
    }
}
