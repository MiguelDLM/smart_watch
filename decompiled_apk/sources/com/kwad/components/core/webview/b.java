package com.kwad.components.core.webview;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.c.b;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.ap;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.au;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bd;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.t;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.components.core.webview.tachikoma.a.f;
import com.kwad.components.core.webview.tachikoma.a.j;
import com.kwad.components.core.webview.tachikoma.a.k;
import com.kwad.components.core.webview.tachikoma.a.s;
import com.kwad.components.core.webview.tachikoma.b.g;
import com.kwad.components.core.webview.tachikoma.b.n;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.download.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.v;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class b {
    private KsAdWebView HZ;
    private KsAdWebView.c Pm;
    private ViewGroup Wj;
    private com.kwad.components.core.webview.a.a Wk;
    private au Wl;
    private d Wm;
    private boolean Wn;
    private aq.b Wo = new aq.b() { // from class: com.kwad.components.core.webview.b.13
        @Override // com.kwad.components.core.webview.jshandler.aq.b
        public final void a(aq.a aVar) {
            if (b.this.fY != null) {
                b.this.fY.a(aVar);
            }
        }
    };
    private com.kwad.components.core.webview.a cN;
    private com.kwad.sdk.core.webview.b cO;
    private c fY;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private String mPageUrl;

    /* loaded from: classes11.dex */
    public static class a {
        private KsAdWebView HZ;
        private KsAdWebView.c Pm;
        private ViewGroup Wj;
        private boolean Wn;
        private c fY;
        private AdTemplate mAdTemplate;
        private com.kwad.components.core.e.d.c mApkDownloadHelper;
        private String mPageUrl;
        private JSONObject mReportExtData;

        @Nullable
        public final a a(c cVar) {
            this.fY = cVar;
            return this;
        }

        @Nullable
        public final a aA(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
            return this;
        }

        @NonNull
        public final a aH(String str) {
            this.mPageUrl = str;
            return this;
        }

        public final a aS(boolean z) {
            this.Wn = z;
            return this;
        }

        @Nullable
        public final a b(KsAdWebView.c cVar) {
            this.Pm = cVar;
            return this;
        }

        @NonNull
        public final a d(KsAdWebView ksAdWebView) {
            this.HZ = ksAdWebView;
            return this;
        }

        public final a e(JSONObject jSONObject) {
            this.mReportExtData = jSONObject;
            return this;
        }

        public final a f(com.kwad.components.core.e.d.c cVar) {
            this.mApkDownloadHelper = cVar;
            return this;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        public final com.kwad.components.core.e.d.c ha() {
            return this.mApkDownloadHelper;
        }

        @NonNull
        public final a k(ViewGroup viewGroup) {
            this.Wj = viewGroup;
            return this;
        }

        public final String pF() {
            return this.mPageUrl;
        }

        public final KsAdWebView.c qa() {
            return this.Pm;
        }

        public final ViewGroup sM() {
            return this.Wj;
        }

        public final KsAdWebView sN() {
            return this.HZ;
        }

        public final c sO() {
            return this.fY;
        }

        public final boolean sP() {
            return this.Wn;
        }
    }

    private void aA() {
        com.kwad.components.core.webview.a aVar = this.cN;
        if (aVar != null) {
            aVar.destroy();
            this.cN = null;
        }
        com.kwad.components.core.webview.a.a aVar2 = this.Wk;
        if (aVar2 != null) {
            aVar2.destroy();
            this.Wk = null;
        }
    }

    private void ax() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cO = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cO;
        bVar2.mScreenOrientation = 0;
        bVar2.OA = this.HZ;
        bVar2.Ph = this.Wj;
    }

    private void et() {
        this.HZ.setClientConfig(this.HZ.getClientConfig().ek(this.mAdTemplate).dx(sK()).b(sJ()).a(sI()).c(this.Pm));
    }

    @NonNull
    private com.kwad.sdk.core.webview.d.a.a getClickListener() {
        return new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.core.webview.b.2
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (b.this.fY != null) {
                    b.this.fY.a(aVar);
                }
            }
        };
    }

    private boolean sF() {
        c cVar = this.fY;
        if (cVar == null) {
            return false;
        }
        return cVar.qh();
    }

    private boolean sG() {
        return false;
    }

    private ak.a sH() {
        return new ak.a() { // from class: com.kwad.components.core.webview.b.3
            @Override // com.kwad.components.core.webview.jshandler.ak.a
            public final void onAdShow() {
                if (b.this.fY != null) {
                    b.this.fY.onAdShow();
                }
            }
        };
    }

    @NonNull
    private KsAdWebView.b sI() {
        return new KsAdWebView.b() { // from class: com.kwad.components.core.webview.b.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (b.this.Wl != null) {
                    b.this.Wl.onFailed();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (b.this.Wl != null) {
                    b.this.Wl.onSuccess();
                }
            }
        };
    }

    private KsAdWebView.e sJ() {
        return new KsAdWebView.e() { // from class: com.kwad.components.core.webview.b.5
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                if (b.this.fY != null) {
                    b.this.fY.onPageFinished();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
                if (b.this.fY != null) {
                    b.this.fY.g(i, str);
                }
            }
        };
    }

    private int sK() {
        if (com.kwad.sdk.core.response.b.a.S(e.dS(this.mAdTemplate))) {
            return 5;
        }
        return 1;
    }

    public final void jq() {
        aA();
        if (this.Wm != null) {
            com.kwad.sdk.core.download.b.DO().a(this.Wm);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void b(KsAdWebView ksAdWebView) {
        aA();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(ksAdWebView);
        this.cN = aVar;
        b(aVar, this.cO);
        c cVar = this.fY;
        if (cVar != null) {
            cVar.a(this.cN, this.cO);
        }
        ksAdWebView.addJavascriptInterface(this.cN, "KwaiAd");
    }

    private void c(KsAdWebView ksAdWebView) {
        aA();
        com.kwad.components.core.webview.a.a aVar = new com.kwad.components.core.webview.a.a(ksAdWebView, this.cO);
        this.Wk = aVar;
        ksAdWebView.addJavascriptInterface(aVar, "KwaiAdForThird");
    }

    public final void a(a aVar) {
        this.mPageUrl = aVar.pF();
        this.mAdTemplate = aVar.getAdTemplate();
        this.Wj = aVar.sM();
        this.HZ = aVar.sN();
        this.fY = aVar.sO();
        this.mApkDownloadHelper = aVar.ha();
        this.Wn = aVar.sP();
        this.Pm = aVar.qa();
        et();
        a(this.fY, this.HZ);
        ax();
        if (com.kwad.sdk.core.response.b.a.P(e.dS(this.mAdTemplate))) {
            c(this.HZ);
        } else if (com.kwad.sdk.core.response.b.b.ez(this.mPageUrl)) {
            b(this.HZ);
        }
    }

    private void b(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
        aw awVar = new aw();
        aVar.a(awVar);
        a(awVar);
        aVar.a(new t());
        aVar.a(new com.kwad.components.core.webview.jshandler.b());
        aVar.a(new u());
        aVar.a(new o());
        aVar.a(new p());
        ak akVar = new ak(bVar);
        aVar.b(new m(bVar));
        aVar.b(new l(bVar));
        akVar.a(sH());
        aVar.a(akVar);
        aVar.a(new ad(bVar));
        aVar.a(new f());
        if (this.mApkDownloadHelper == null) {
            this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        }
        if (!this.Wn) {
            aVar.a(new aa(this.cO, this.mApkDownloadHelper, getClickListener(), sF(), false, true));
            aVar.a(new x(this.cO, this.mApkDownloadHelper, getClickListener(), sF(), 0, sG(), true));
        }
        aVar.a(new az(this.cO, this.mApkDownloadHelper));
        aVar.a(new as(this.cO));
        aVar.a(new ap(this.cO.OA.getContext(), this.mAdTemplate));
        aVar.a(new bd(new bd.a() { // from class: com.kwad.components.core.webview.b.1
            @Override // com.kwad.components.core.webview.jshandler.bd.a
            public final void sL() {
                if (com.kwad.sdk.core.response.b.b.cZ(b.this.mAdTemplate)) {
                    com.kwad.components.core.e.c.b.a(b.this.cO.OA.getContext(), new b.a().aq(b.this.mAdTemplate).af(com.kwad.sdk.core.response.b.b.cY(b.this.mAdTemplate)).nT());
                }
            }
        }));
        aVar.a(new ah(this.cO));
        aVar.a(new aq(this.Wo, this.mPageUrl));
        au auVar = new au();
        this.Wl = auVar;
        aVar.a(auVar);
        aVar.a(new y(new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.core.webview.b.6
            @Override // com.kwad.sdk.core.webview.d.a.b
            public final void b(WebCloseStatus webCloseStatus) {
                if (b.this.fY != null) {
                    b.this.fY.a(webCloseStatus);
                }
            }
        }));
        s sVar = new s();
        sVar.a(new s.a() { // from class: com.kwad.components.core.webview.b.7
            @Override // com.kwad.components.core.webview.tachikoma.a.s.a
            public final void a(com.kwad.components.core.webview.tachikoma.b.s sVar2) {
                if (!TextUtils.isEmpty(sVar2.message)) {
                    v.d(b.this.cO.OA.getContext(), sVar2.message, 0L);
                }
            }
        });
        aVar.a(sVar);
        aVar.a(new k());
        aVar.a(new ag(bVar));
        if (com.kwad.sdk.core.response.b.a.aE(e.dS(this.mAdTemplate))) {
            final com.kwad.components.core.webview.tachikoma.a.l lVar = new com.kwad.components.core.webview.tachikoma.a.l();
            aVar.a(lVar);
            this.Wm = new d(this.mAdTemplate) { // from class: com.kwad.components.core.webview.b.8
                @Override // com.kwad.sdk.core.download.d, com.kwad.sdk.core.download.c
                public final void b(String str, String str2, com.kwad.sdk.core.download.e eVar) {
                    super.b(str, str2, eVar);
                    com.kwad.components.core.webview.tachikoma.b.b bVar2 = new com.kwad.components.core.webview.tachikoma.b.b();
                    bVar2.aaR = 1;
                    lVar.a(bVar2);
                }
            };
            com.kwad.sdk.core.download.b.DO().a(this.Wm, this.mAdTemplate);
        }
        aVar.a(new com.kwad.components.core.webview.tachikoma.a.d() { // from class: com.kwad.components.core.webview.b.9
            @Override // com.kwad.components.core.webview.tachikoma.a.d
            public final void a(g gVar) {
                com.kwad.components.core.o.a.qI().a(gVar.actionType, b.this.mAdTemplate, gVar.Lh);
            }
        });
        aVar.a(new j() { // from class: com.kwad.components.core.webview.b.10
            @Override // com.kwad.components.core.webview.tachikoma.a.j
            public final void a(n nVar) {
                super.a(nVar);
                AdWebViewActivityProxy.launch(b.this.cO.OA.getContext(), new AdWebViewActivityProxy.a.C0799a().at(nVar.title).au(nVar.url).aC(true).at(b.this.mAdTemplate).pK());
            }
        });
        aVar.a(new com.kwad.components.core.webview.jshandler.d());
        aVar.a(new com.kwad.components.core.webview.jshandler.g());
        aVar.a(new com.kwad.components.core.webview.jshandler.j());
        aVar.a(new com.kwad.components.core.webview.jshandler.c());
        ac acVar = new ac(this.cO);
        acVar.a(new ac.b() { // from class: com.kwad.components.core.webview.b.11
            @Override // com.kwad.components.core.webview.jshandler.ac.b
            public final void c(ac.a aVar2) {
                if (b.this.fY != null) {
                    b.this.fY.a(aVar2);
                }
            }
        });
        aVar.a(acVar);
        aVar.a(new com.kwad.components.core.webview.jshandler.k(this.cO.OA.getContext(), this.mAdTemplate));
        aVar.a(new aj(this.cO, new aj.b() { // from class: com.kwad.components.core.webview.b.12
            @Override // com.kwad.components.core.webview.jshandler.aj.b
            public final void a(aj.a aVar2) {
                if (b.this.fY != null) {
                    b.this.fY.a(aVar2);
                }
            }
        }));
        aVar.a(new i());
        aVar.a(new com.kwad.components.core.webview.jshandler.s());
        aVar.a(new r());
        aVar.a(new q());
    }

    private void a(aw awVar) {
        c cVar = this.fY;
        if (cVar == null) {
            return;
        }
        cVar.a(awVar);
    }

    private static void a(c cVar, WebView webView) {
        if (cVar == null || !cVar.qg()) {
            return;
        }
        webView.getSettings().setAllowFileAccess(true);
    }
}
