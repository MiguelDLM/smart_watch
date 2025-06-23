package com.kwad.components.core.e.c;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.c.b;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.v;
import com.kwad.sdk.utils.w;

/* loaded from: classes11.dex */
public final class e extends c implements View.OnClickListener {

    @Nullable
    public b KF;
    public b.C0787b KG;
    private Runnable KO;
    private KsAdWebView cL;
    private com.kwad.components.core.webview.a cN;
    private com.kwad.sdk.core.webview.b cO;
    private aw cQ;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private boolean KP = false;
    private com.kwad.sdk.core.webview.d.a.a cR = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.core.e.c.e.1
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            com.kwad.sdk.core.e.c.d("DownloadTipsDialogWebCardPresenter", "onAdClicked convertBridgeClicked: " + e.this.KP);
            e.a(e.this, true);
        }
    };
    private aj.b cS = new aj.b() { // from class: com.kwad.components.core.e.c.e.4
        @Override // com.kwad.components.core.webview.jshandler.aj.b
        public final void a(aj.a aVar) {
            com.kwad.sdk.core.e.c.d("DownloadTipsDialogWebCardPresenter", "onAdFrameValid=" + aVar);
            e.this.cL.setTranslationY((float) (aVar.height + aVar.bottomMargin));
        }
    };
    private ai.b cT = new ai.b() { // from class: com.kwad.components.core.e.c.e.5
        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            com.kwad.sdk.core.e.c.d("DownloadTipsDialogWebCardPresenter", "handleWebCardHide");
            e.this.aF();
        }
    };
    private aq.b cU = new aq.b() { // from class: com.kwad.components.core.e.c.e.6
        @Override // com.kwad.components.core.webview.jshandler.aq.b
        public final void a(aq.a aVar) {
            com.kwad.sdk.core.e.c.i("DownloadTipsDialogWebCardPresenter", "updatePageStatus mPageState: " + aVar);
            if (aVar.status == 1) {
                e.this.nW();
                return;
            }
            e.this.aF();
            if (e.this.getContext() != null) {
                v.P(e.this.getContext(), w.ck(e.this.getContext()));
            }
        }
    };

    private void aA() {
        com.kwad.components.core.webview.a aVar = this.cN;
        if (aVar != null) {
            aVar.destroy();
            this.cN = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF() {
        com.kwad.sdk.core.e.c.d("DownloadTipsDialogWebCardPresenter", "hideWithOutAnimation  convertBridgeClicked: " + this.KP);
        if (this.cL.getVisibility() != 0) {
            return;
        }
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sX();
        }
        this.cL.setVisibility(4);
        aw awVar2 = this.cQ;
        if (awVar2 != null) {
            awVar2.sY();
        }
        if (this.KP) {
            com.kwad.sdk.core.adlog.c.bQ(this.mAdTemplate);
        }
        b bVar = this.KF;
        if (bVar != null && bVar.isShowing()) {
            this.KF.aj(this.KP);
        }
    }

    private void ax() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cO = bVar;
        bVar.setAdTemplate(this.KH.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cO;
        AdBaseFrameLayout adBaseFrameLayout = this.KH.mRootContainer;
        bVar2.aEW = adBaseFrameLayout;
        bVar2.Ph = adBaseFrameLayout;
        bVar2.OA = this.cL;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void az() {
        com.kwad.sdk.core.e.c.d("DownloadTipsDialogWebCardPresenter", "setupJsBridge");
        aA();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.cL);
        this.cN = aVar;
        a(aVar);
        this.cL.addJavascriptInterface(this.cN, "KwaiAd");
    }

    private void nU() {
        az();
        this.cL.loadUrl(this.KG.url);
        this.cL.postDelayed(nV(), 1500L);
        this.cL.setBackgroundColor(0);
        this.cL.getBackground().setAlpha(0);
        this.cL.setVisibility(0);
    }

    private Runnable nV() {
        if (this.KO == null) {
            this.KO = new Runnable() { // from class: com.kwad.components.core.e.c.e.2
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.aF();
                    if (e.this.getContext() != null) {
                        v.P(e.this.getContext(), w.ck(e.this.getContext()));
                    }
                }
            };
        }
        return this.KO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nW() {
        Runnable runnable = this.KO;
        if (runnable != null) {
            this.cL.removeCallbacks(runnable);
        }
    }

    private void release() {
        this.cL.setVisibility(8);
        this.cL.release();
        aA();
    }

    @Override // com.kwad.components.core.e.c.c, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        d dVar = this.KH;
        this.KF = dVar.KF;
        this.KG = dVar.KG;
        this.mAdTemplate = dVar.mAdTemplate;
        dVar.mRootContainer.setOnClickListener(this);
        this.mApkDownloadHelper = this.KH.mApkDownloadHelper;
        ax();
        nU();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.sdk.core.adlog.c.bQ(this.mAdTemplate);
        b bVar = this.KF;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cL = (KsAdWebView) findViewById(R.id.ksad_download_tips_web_card_webView);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        release();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        nW();
    }

    public static /* synthetic */ boolean a(e eVar, boolean z) {
        eVar.KP = true;
        return true;
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new aa(this.cO, this.mApkDownloadHelper, this.cR));
        aVar.a(new x(this.cO, this.mApkDownloadHelper, this.cR, 1));
        aVar.a(new ad(this.cO));
        aVar.a(new ag(this.cO));
        aVar.a(new ac(this.cO));
        aVar.a(new aj(this.cO, this.cS));
        aVar.a(new aq(this.cU, this.KG.url));
        aw awVar = new aw();
        this.cQ = awVar;
        aVar.a(awVar);
        aVar.a(new az(this.cO, this.mApkDownloadHelper, new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.components.core.e.c.e.3
            @Override // com.kwad.sdk.core.download.a.c, com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                super.onInstalled();
                AdInfo dS = com.kwad.sdk.core.response.b.e.dS(e.this.mAdTemplate);
                String ax = com.kwad.sdk.core.response.b.a.ax(dS);
                if (com.kwad.sdk.core.response.b.a.aN(dS) && com.kwad.sdk.core.response.b.a.aE(dS) && al.an(e.this.getContext(), ax) && com.kwad.components.core.q.a.rj().rn() && com.kwad.sdk.core.response.b.a.aM(dS) == 1) {
                    e.this.KF.dismiss();
                }
            }
        }));
        aVar.a(new ai(this.cT));
        aVar.a(new ak(this.cO));
        aVar.b(new m(this.cO));
        aVar.b(new l(this.cO));
    }
}
