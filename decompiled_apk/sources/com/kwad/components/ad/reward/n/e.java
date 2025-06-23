package com.kwad.components.ad.reward.n;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.bh;

/* loaded from: classes11.dex */
public class e extends com.kwad.sdk.core.download.a.a implements aj.b, aq.b {
    private KsAdWebView cL;
    private com.kwad.components.core.webview.a cN;
    private com.kwad.sdk.core.webview.b cO;
    private com.kwad.sdk.core.webview.d.a.a cR;

    @Nullable
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private final com.kwad.components.ad.reward.e.l mRewardVerifyListener = new com.kwad.components.ad.reward.e.l() { // from class: com.kwad.components.ad.reward.n.e.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (e.this.yu != null) {
                e.this.yu.ag(true);
            }
        }
    };
    private View yt;
    private bb yu;
    private f yv;

    public e(KsAdWebView ksAdWebView, View view, @Nullable com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar) {
        this.yt = view;
        this.cL = ksAdWebView;
        this.mApkDownloadHelper = cVar;
        this.cR = aVar;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void S(String str) {
        if (bh.isNullString(str)) {
            jU();
            return;
        }
        aA();
        this.cL.setClientConfig(this.cL.getClientConfig().ek(this.mAdTemplate).b(getWebErrorListener()));
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.cL);
        this.cN = aVar;
        a(aVar, str);
        this.cL.addJavascriptInterface(this.cN, "KwaiAd");
        this.cL.loadUrl(str);
    }

    private void aA() {
        com.kwad.components.core.webview.a aVar = this.cN;
        if (aVar != null) {
            aVar.destroy();
            this.cN = null;
        }
    }

    private void ac(boolean z) {
        int i;
        com.kwad.sdk.core.e.c.d("BottomCardWebViewHelper", "switchWebView: " + z);
        KsAdWebView ksAdWebView = this.cL;
        if (ksAdWebView == null) {
            return;
        }
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        ksAdWebView.setVisibility(i);
    }

    @NonNull
    private KsAdWebView.e getWebErrorListener() {
        return new KsAdWebView.e() { // from class: com.kwad.components.ad.reward.n.e.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
                com.kwad.sdk.core.e.c.d("BottomCardWebViewHelper", "onReceivedHttpError: " + i + ", " + str);
                e.this.jU();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jU() {
        View view = this.yt;
        if (view != null) {
            view.setVisibility(0);
        }
        ac(false);
    }

    private void k(String str, int i) {
        f fVar = this.yv;
        if (fVar != null) {
            fVar.i(str, i);
        }
    }

    public final void jT() {
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this);
        }
        com.kwad.components.ad.reward.b.fc().b(this.mRewardVerifyListener);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        String str;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            str = com.kwad.sdk.core.response.b.a.aD(com.kwad.sdk.core.response.b.e.dS(adTemplate));
        } else {
            str = "立即下载";
        }
        k(str, 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        String ca;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null) {
            ca = "";
        } else {
            ca = com.kwad.sdk.core.response.b.a.ca(adTemplate);
        }
        k(ca, 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        String str;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            str = com.kwad.sdk.core.response.b.a.aD(com.kwad.sdk.core.response.b.e.dS(adTemplate));
        } else {
            str = "立即下载";
        }
        k(str, 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        String str;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            str = com.kwad.sdk.core.response.b.a.ab(com.kwad.sdk.core.response.b.e.dS(adTemplate));
        } else {
            str = "立即打开";
        }
        k(str, 100);
    }

    @Override // com.kwad.sdk.core.download.a.a
    public final void onPaused(int i) {
        k(com.kwad.sdk.core.response.b.a.dn(i), i);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        if (i != 0) {
            k(com.kwad.sdk.core.response.b.a.dm(i), i);
        }
    }

    private void b(AdTemplate adTemplate, ViewGroup viewGroup) {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cO = bVar;
        bVar.setAdTemplate(adTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cO;
        bVar2.mScreenOrientation = 0;
        bVar2.aEW = null;
        bVar2.Ph = viewGroup;
        bVar2.OA = this.cL;
        bVar2.mReportExtData = null;
        bVar2.aEY = true;
    }

    public final void a(f fVar) {
        this.yv = fVar;
    }

    public final void a(AdTemplate adTemplate, ViewGroup viewGroup) {
        KsAdWebView ksAdWebView = this.cL;
        if (ksAdWebView != null) {
            ksAdWebView.setBackgroundColor(0);
            if (this.cL.getBackground() != null) {
                this.cL.getBackground().setAlpha(0);
            }
        }
        com.kwad.components.ad.reward.b.fc().a(this.mRewardVerifyListener);
        this.mAdTemplate = adTemplate;
        b(adTemplate, viewGroup);
        S(com.kwad.sdk.core.response.b.b.cm(this.mAdTemplate));
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    private void a(com.kwad.components.core.webview.a aVar, String str) {
        aVar.a(new x(this.cO, this.mApkDownloadHelper, this.cR));
        aVar.a(new ad(this.cO));
        aVar.a(new ac(this.cO));
        aVar.a(new aq(this, str));
        bb bbVar = new bb();
        this.yu = bbVar;
        aVar.a(bbVar);
        aVar.a(new ak(this.cO));
        aVar.b(new com.kwad.components.core.webview.jshandler.m(this.cO));
        aVar.b(new com.kwad.components.core.webview.jshandler.l(this.cO));
        aVar.a(new ag(this.cO));
        aVar.a(new com.kwad.components.core.webview.tachikoma.a.f());
        aVar.a(new aj(this.cO, this));
        aVar.a(new az(this.cO, this.mApkDownloadHelper));
        aVar.a(new com.kwad.components.ad.reward.i.b(this.cL.getContext(), this.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
    }

    @Override // com.kwad.components.core.webview.jshandler.aq.b
    public final void a(aq.a aVar) {
        com.kwad.sdk.core.e.c.d("BottomCardWebViewHelper", getClass().getName() + " updatePageStatus: " + aVar);
        if (aVar.status == 1) {
            ac(true);
        } else {
            jU();
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.aj.b
    public final void a(@NonNull aj.a aVar) {
        com.kwad.sdk.core.e.c.d("BottomCardWebViewHelper", "onAdFrameValid : " + aVar.toJson());
    }
}
