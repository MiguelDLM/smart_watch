package com.kwad.components.ad.draw.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.kwad.components.ad.draw.b.b.a;
import com.kwad.components.core.s.n;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
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
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: classes11.dex */
public final class c extends com.kwad.components.ad.draw.a.a {
    private KsAdWebView cL;
    private aj.a cM;
    private com.kwad.components.core.webview.a cN;
    private com.kwad.sdk.core.webview.b cO;
    private aw cQ;
    private ValueAnimator cV;
    private ValueAnimator cW;
    private ViewGroup co;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private int cP = -1;
    private k mVideoPlayStateListener = new l() { // from class: com.kwad.components.ad.draw.b.b.c.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            c.this.release();
        }
    };
    private a.b cG = new a.b() { // from class: com.kwad.components.ad.draw.b.b.c.2
        @Override // com.kwad.components.ad.draw.b.b.a.b
        public final boolean ar() {
            return c.this.aB();
        }
    };
    private com.kwad.sdk.core.webview.d.a.a cR = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.draw.b.b.c.3
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (c.this.bO.bN != null) {
                c.this.bO.bN.onAdClicked();
            }
        }
    };
    private aj.b cS = new aj.b() { // from class: com.kwad.components.ad.draw.b.b.c.4
        @Override // com.kwad.components.core.webview.jshandler.aj.b
        public final void a(aj.a aVar) {
            c.this.cM = aVar;
            c.this.cL.setTranslationY(aVar.height + aVar.bottomMargin);
        }
    };
    private ai.b cT = new ai.b() { // from class: com.kwad.components.ad.draw.b.b.c.5
        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            c.this.aE();
        }
    };
    private aq.b cU = new aq.b() { // from class: com.kwad.components.ad.draw.b.b.c.6
        @Override // com.kwad.components.core.webview.jshandler.aq.b
        public final void a(aq.a aVar) {
            c.this.cP = aVar.status;
            com.kwad.sdk.core.e.c.i("DrawPlayWebCard", "updatePageStatus mPageState: " + aVar);
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
    public boolean aB() {
        if (this.cP == 1) {
            aC();
            return true;
        }
        aH();
        return false;
    }

    private void aC() {
        if (this.cM == null) {
            aD();
            return;
        }
        aG();
        this.co.setVisibility(8);
        this.cL.setVisibility(0);
        KsAdWebView ksAdWebView = this.cL;
        aj.a aVar = this.cM;
        ValueAnimator c = n.c(ksAdWebView, aVar.height + aVar.bottomMargin, 0);
        this.cV = c;
        c.setInterpolator(new DecelerateInterpolator(2.0f));
        this.cV.setDuration(300L);
        this.cV.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.draw.b.b.c.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (c.this.cQ != null) {
                    c.this.cQ.sW();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.cQ != null) {
                    c.this.cQ.sV();
                }
            }
        });
        this.cV.start();
    }

    private void aD() {
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sV();
        }
        this.co.setVisibility(8);
        this.cL.setVisibility(0);
        aw awVar2 = this.cQ;
        if (awVar2 != null) {
            awVar2.sW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE() {
        if (this.cL.getVisibility() != 0) {
            return;
        }
        if (this.cM == null) {
            aF();
            return;
        }
        aG();
        KsAdWebView ksAdWebView = this.cL;
        aj.a aVar = this.cM;
        ValueAnimator c = n.c(ksAdWebView, 0, aVar.height + aVar.bottomMargin);
        this.cW = c;
        c.setInterpolator(new DecelerateInterpolator(2.0f));
        this.cW.setDuration(300L);
        this.cW.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.draw.b.b.c.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.cL.setVisibility(4);
                c.this.co.setVisibility(0);
                if (c.this.cQ != null) {
                    c.this.cQ.sY();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.cQ != null) {
                    c.this.cQ.sX();
                }
            }
        });
        this.cW.start();
    }

    private void aF() {
        if (this.cL.getVisibility() != 0) {
            return;
        }
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sX();
        }
        this.cL.setVisibility(4);
        this.co.setVisibility(0);
        aw awVar2 = this.cQ;
        if (awVar2 != null) {
            awVar2.sY();
        }
    }

    private void aG() {
        ValueAnimator valueAnimator = this.cV;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.cV.cancel();
        }
        ValueAnimator valueAnimator2 = this.cW;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.cW.cancel();
        }
    }

    private void aH() {
        String str;
        int i = this.cP;
        if (i == -1) {
            str = "timeout";
        } else if (i != 1) {
            str = "h5error";
        } else {
            str = "others";
        }
        com.kwad.sdk.core.e.c.w("DrawPlayWebCard", "show webCard fail, reason: " + str);
    }

    private void ax() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cO = bVar;
        bVar.setAdTemplate(this.bO.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cO;
        bVar2.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout = this.bO.mRootContainer;
        bVar2.aEW = adBaseFrameLayout;
        bVar2.Ph = adBaseFrameLayout;
        bVar2.OA = this.cL;
    }

    private void ay() {
        this.cP = -1;
        az();
        this.cL.setBackgroundColor(0);
        this.cL.getBackground().setAlpha(0);
        this.cL.setVisibility(4);
        this.cL.loadUrl(com.kwad.sdk.core.response.b.b.cm(this.mAdTemplate));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void az() {
        aA();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.cL);
        this.cN = aVar;
        a(aVar);
        this.cL.addJavascriptInterface(this.cN, "KwaiAd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        this.cP = -1;
        this.cL.setVisibility(8);
        aA();
    }

    @Override // com.kwad.components.ad.draw.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.ad.draw.a.b bVar = this.bO;
        this.mAdTemplate = bVar.mAdTemplate;
        bVar.ch.a(this.cG);
        com.kwad.components.ad.draw.a.b bVar2 = this.bO;
        this.mApkDownloadHelper = bVar2.mApkDownloadHelper;
        bVar2.bP.b(this.mVideoPlayStateListener);
        ax();
        ay();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.co = (ViewGroup) findViewById(R.id.ksad_ad_normal_container);
        this.cL = (KsAdWebView) findViewById(R.id.ksad_play_web_card_webView);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.bO.ch.a((a.b) null);
        this.bO.bP.a(this.mVideoPlayStateListener);
        aG();
        release();
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new aa(this.cO, this.mApkDownloadHelper, this.cR, (byte) 0));
        aVar.a(new x(this.cO, this.mApkDownloadHelper, this.cR));
        aVar.a(new ad(this.cO));
        aVar.a(new ag(this.cO));
        aVar.a(new ac(this.cO));
        aVar.a(new aj(this.cO, this.cS));
        aVar.a(new aq(this.cU, com.kwad.sdk.core.response.b.b.cm(this.mAdTemplate)));
        aw awVar = new aw();
        this.cQ = awVar;
        aVar.a(awVar);
        aVar.a(new az(this.cO, this.mApkDownloadHelper));
        aVar.a(new ai(this.cT));
        aVar.a(new ak(this.cO));
        aVar.b(new m(this.cO));
        aVar.b(new com.kwad.components.core.webview.jshandler.l(this.cO));
    }
}
