package com.kwad.components.core.page.c.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.c.a.f;
import com.kwad.components.core.webview.b;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.tachikoma.b.k;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.a.c;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.bo;

/* loaded from: classes11.dex */
public final class g extends a {
    private static final Handler fS = new Handler(Looper.getMainLooper());
    public AdWebViewActivityProxy.a OV;
    private aw PM;
    private at PN;
    private String PO;
    private Runnable PP;
    private com.kwad.components.core.webview.b fX;
    public AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private boolean PK = false;
    private boolean PL = false;
    private final com.kwad.sdk.core.c.c wU = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.page.c.a.g.2
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityDestroyed */
        public final void b(Activity activity) {
            super.b(activity);
            if (g.this.mAdWebView != null && g.this.getActivity() != null && g.this.getActivity().equals(activity)) {
                g.this.mAdWebView.onActivityDestroy();
                g.a(g.this, (KsAdWebView) null);
            }
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityPaused */
        public final void c(Activity activity) {
            super.c(activity);
            g.this.hide();
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityResumed */
        public final void d(Activity activity) {
            super.d(activity);
            g.this.show();
        }
    };
    private at.b Po = new at.b() { // from class: com.kwad.components.core.page.c.a.g.3
        @Override // com.kwad.components.core.webview.jshandler.at.b
        public final void qf() {
            if (g.this.PN != null) {
                g.this.PN.sU();
            }
        }
    };
    private com.kwad.components.core.webview.c fY = new com.kwad.components.core.webview.c() { // from class: com.kwad.components.core.page.c.a.g.4
        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            aVar.a(new bc(new bc.b() { // from class: com.kwad.components.core.page.c.a.g.4.1
                @Override // com.kwad.components.core.webview.jshandler.bc.b
                public final void a(bc.a aVar2) {
                    f.a aVar3 = g.this.Pk.Pn;
                    if (aVar3 != null && aVar2 != null) {
                        aVar3.aB(aVar2.visibility);
                    }
                }
            }));
            g.this.PN = new at(new at.c() { // from class: com.kwad.components.core.page.c.a.g.4.2
                @Override // com.kwad.components.core.webview.jshandler.at.c
                public final void qi() {
                    g gVar = g.this;
                    gVar.Pk.a(gVar.Po);
                }
            });
            aVar.a(g.this.PN);
            aVar.a(new com.kwad.components.core.webview.tachikoma.a.b(bVar, g.this.Pk.mAdTemplate));
            k kVar = new k();
            kVar.aaY = g.this.Pk.mAutoShow ? 1 : 0;
            aVar.a(new com.kwad.components.core.webview.tachikoma.a.g(kVar));
        }

        @Override // com.kwad.components.core.webview.c
        public final void g(int i, String str) {
            g.this.PK = false;
            g gVar = g.this;
            com.kwad.sdk.commercial.g.a.a(gVar.mAdTemplate, gVar.OV.pG(), g.this.OV.pF(), i, str);
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            g.this.PK = true;
            if (!g.this.PL) {
                g.b(g.this, true);
                g gVar = g.this;
                com.kwad.sdk.commercial.g.a.m(gVar.mAdTemplate, gVar.OV.pG(), g.this.OV.pF());
            }
            if (g.this.Pk.pT()) {
                g.this.show();
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final boolean qg() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final boolean qh() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(aw awVar) {
            g.this.PM = awVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(aq.a aVar) {
            g.this.Pk.Pp = aVar.isSuccess();
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(WebCloseStatus webCloseStatus) {
            com.kwad.sdk.core.webview.d.a.b bVar = g.this.Pk.mWebCardCloseListener;
            if (bVar != null) {
                bVar.b(webCloseStatus);
            }
        }
    };

    private void et() {
        this.fX = new com.kwad.components.core.webview.b();
        this.fX.a(new b.a().aA(this.Pk.mAdTemplate).aH(this.Pk.mPageUrl).d(this.mAdWebView).k(this.Pk.gS).a(this.fY).b(this.Pk.Pm));
        qd();
        com.kwad.sdk.commercial.g.a.l(this.mAdTemplate, this.OV.pG(), this.OV.pF());
        com.kwad.sdk.core.webview.a.c cVar = new com.kwad.sdk.core.webview.a.c() { // from class: com.kwad.components.core.page.c.a.g.1
            @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                com.kwad.sdk.core.e.c.w("KsAdWebViewClient", "shouldOverrideUrlLoading url=" + str);
                com.kwad.sdk.core.webview.b.c.b.ae(this.mUniqueId, "shouldOverrideUrlLoading");
                AdInfo dS = com.kwad.sdk.core.response.b.e.dS(g.this.mAdTemplate);
                g.this.PO = str;
                if (com.kwad.sdk.core.response.b.a.bi(dS) && af.cv(g.this.Pk.mContext) && af.gJ(str)) {
                    final c.a clientConfig = g.this.mAdWebView.getClientConfig();
                    final com.kwad.components.core.urlReplace.c cVar2 = new com.kwad.components.core.urlReplace.c();
                    final Object obj = new Object();
                    g.this.PP = new Runnable() { // from class: com.kwad.components.core.page.c.a.g.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            synchronized (obj) {
                                try {
                                    com.kwad.components.core.urlReplace.c cVar3 = cVar2;
                                    if (cVar3 != null) {
                                        cVar3.ry();
                                    }
                                    c.a aVar = clientConfig;
                                    if (aVar != null && aVar.HF() && clientConfig.HB()) {
                                        if (com.kwad.sdk.core.webview.a.c.a(clientConfig, g.this.PO) == 1) {
                                            com.kwad.sdk.core.adlog.c.g(g.this.mAdTemplate, false);
                                        } else {
                                            com.kwad.sdk.core.adlog.c.h(g.this.mAdTemplate, false);
                                        }
                                    } else {
                                        com.kwad.sdk.core.e.c.i("LandPageWebViewLoadPresenter", "deeplink unable");
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    };
                    g.fS.postDelayed(g.this.PP, com.kwad.sdk.core.response.b.a.bj(dS));
                    cVar2.a(str, new com.kwad.components.core.urlReplace.a() { // from class: com.kwad.components.core.page.c.a.g.1.2
                        @Override // com.kwad.components.core.urlReplace.a
                        public final void onSuccess(String str2) {
                            synchronized (obj) {
                                try {
                                    g.this.PO = str2;
                                    if (g.this.PP != null) {
                                        g.fS.removeCallbacks(g.this.PP);
                                    }
                                    c.a aVar = clientConfig;
                                    if (aVar != null && aVar.HF() && clientConfig.HB()) {
                                        if (com.kwad.sdk.core.webview.a.c.a(clientConfig, g.this.PO) == 1) {
                                            com.kwad.sdk.core.adlog.c.g(g.this.mAdTemplate, true);
                                        } else {
                                            com.kwad.sdk.core.adlog.c.h(g.this.mAdTemplate, true);
                                        }
                                    } else {
                                        com.kwad.sdk.core.e.c.i("LandPageWebViewLoadPresenter", "deeplink unable");
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    });
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
        };
        cVar.setClientConfig(this.mAdWebView.getClientConfig());
        this.mAdWebView.setWebViewClient(cVar);
        this.mAdWebView.loadUrl(this.Pk.mPageUrl);
        this.mAdWebView.onActivityCreate();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void qd() {
        KsAdWebView ksAdWebView;
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().bw(true).ek(this.Pk.mAdTemplate).bu(false));
        if (com.kwad.sdk.core.response.b.a.bJ(com.kwad.sdk.core.response.b.e.dS(this.Pk.mAdTemplate)) > 0) {
            bo.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.c.a.g.5
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public final void run() {
                    if (g.this.mAdWebView != null) {
                        g.this.mAdWebView.getClientConfig().bu(true);
                    }
                }
            }, com.kwad.sdk.core.response.b.a.bJ(com.kwad.sdk.core.response.b.e.dS(this.Pk.mAdTemplate)));
        } else if (com.kwad.sdk.core.response.b.a.bJ(com.kwad.sdk.core.response.b.e.dS(this.Pk.mAdTemplate)) == 0 && (ksAdWebView = this.mAdWebView) != null) {
            ksAdWebView.getClientConfig().bu(true);
        }
        this.mAdWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.page.c.a.g.6
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    g.this.mAdWebView.getClientConfig().bu(true);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        b bVar = this.Pk;
        this.OV = bVar.OV;
        this.mAdTemplate = bVar.mAdTemplate;
        et();
        com.kwad.sdk.core.c.b.En();
        com.kwad.sdk.core.c.b.a(this.wU);
    }

    public final void hide() {
        aw awVar = this.PM;
        if (awVar != null) {
            awVar.sX();
        }
        KsAdWebView ksAdWebView = this.Pk.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        aw awVar2 = this.PM;
        if (awVar2 != null) {
            awVar2.sY();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.fX.jq();
        com.kwad.sdk.core.c.b.En();
        com.kwad.sdk.core.c.b.b(this.wU);
    }

    public final void show() {
        if (!this.PK) {
            return;
        }
        aw awVar = this.PM;
        if (awVar != null) {
            awVar.sV();
        }
        try {
            KsAdWebView ksAdWebView = this.Pk.mAdWebView;
            if (ksAdWebView != null) {
                ksAdWebView.setVisibility(0);
            }
        } catch (Exception e) {
            com.kwad.components.core.d.a.reportSdkCaughtException(e);
        }
        aw awVar2 = this.PM;
        if (awVar2 != null) {
            awVar2.sW();
        }
    }

    public static /* synthetic */ boolean b(g gVar, boolean z) {
        gVar.PL = true;
        return true;
    }

    public static /* synthetic */ KsAdWebView a(g gVar, KsAdWebView ksAdWebView) {
        gVar.mAdWebView = null;
        return null;
    }
}
