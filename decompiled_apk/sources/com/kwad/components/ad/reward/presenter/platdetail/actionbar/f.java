package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.k.q;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.s.n;
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
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: classes11.dex */
public final class f extends com.kwad.components.ad.reward.presenter.b {

    @Nullable
    private KsAdWebView cL;
    private aj.a cM;
    private com.kwad.components.core.webview.a cN;
    private com.kwad.sdk.core.webview.b cO;
    private aw cQ;
    private ValueAnimator cV;
    private ValueAnimator cW;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private String mUrl;
    private RewardActionBarControl oN;
    private KsLogoView ss;
    private boolean vb;
    private long vc;
    private int cP = -1;
    private RewardActionBarControl.d uJ = new RewardActionBarControl.d() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.1
        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.d
        public final boolean f(a aVar) {
            f fVar = f.this;
            fVar.vb = fVar.f(aVar);
            return f.this.vb;
        }
    };
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.2
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            f.this.release();
        }
    };
    private com.kwad.sdk.core.webview.d.a.a cR = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.3
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            f.this.qp.oJ.bJ();
        }
    };
    private aj.b cS = new aj.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.5
        @Override // com.kwad.components.core.webview.jshandler.aj.b
        public final void a(aj.a aVar) {
            f.this.cM = aVar;
            f.this.cL.setTranslationY(aVar.height + aVar.bottomMargin);
        }
    };
    private ai.b cT = new ai.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.6
        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            f.this.vb = false;
            f.this.aE();
        }
    };
    private aq.b cU = new aq.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.7
        @Override // com.kwad.components.core.webview.jshandler.aq.b
        public final void a(aq.a aVar) {
            f.this.cP = aVar.status;
            long elapsedRealtime = SystemClock.elapsedRealtime() - f.this.vc;
            com.kwad.sdk.core.e.c.i("RewardActionBarWeb", "load time:" + elapsedRealtime + ", pageStatus: " + f.this.cP);
            if (f.this.cP == 1) {
                com.kwad.components.core.o.a.qI().h(f.this.qp.mAdTemplate, elapsedRealtime);
            } else {
                com.kwad.components.ad.reward.monitor.c.a(f.this.qp.mAdTemplate, f.this.qp.oZ, "play_card", com.kwad.sdk.core.response.b.b.cm(f.this.qp.mAdTemplate), System.currentTimeMillis() - f.this.cL.getLoadTime(), 3);
            }
            if (!f.this.qp.fE()) {
                f.this.oN.ig();
            }
        }
    };

    private void O(AdTemplate adTemplate) {
        KsLogoView ksLogoView;
        if (com.kwad.sdk.core.response.b.a.cG(com.kwad.sdk.core.response.b.e.dS(adTemplate)) && !com.kwad.sdk.utils.aj.isOrientationPortrait() && (ksLogoView = this.ss) != null) {
            ksLogoView.setVisibility(0);
        }
    }

    private void aA() {
        com.kwad.components.core.webview.a aVar = this.cN;
        if (aVar != null) {
            aVar.destroy();
            this.cN = null;
        }
    }

    private void aD() {
        O(this.qp.mAdTemplate);
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sV();
        }
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
        this.cW.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                f.this.cL.setVisibility(4);
                if (f.this.cQ != null) {
                    f.this.cQ.sY();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (f.this.cQ != null) {
                    f.this.cQ.sX();
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
        com.kwad.sdk.core.e.c.w("RewardActionBarWeb", "show webCard fail, reason: " + str);
    }

    private void ax() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cO = bVar;
        bVar.setAdTemplate(this.qp.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cO;
        com.kwad.components.ad.reward.g gVar = this.qp;
        bVar2.mScreenOrientation = gVar.mScreenOrientation;
        AdBaseFrameLayout adBaseFrameLayout = gVar.mRootContainer;
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
        this.cL.setClientConfig(this.cL.getClientConfig().ek(this.qp.mAdTemplate).b(ik()));
        this.vc = SystemClock.elapsedRealtime();
        this.mUrl = com.kwad.sdk.core.response.b.b.cm(this.qp.mAdTemplate);
        com.kwad.sdk.core.e.c.d("RewardActionBarWeb", "startPreloadWebView url: " + this.mUrl);
        com.kwad.components.ad.reward.g gVar = this.qp;
        com.kwad.components.ad.reward.monitor.c.a(gVar.mAdTemplate, gVar.oZ, "play_card", this.mUrl);
        this.cL.loadUrl(this.mUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void az() {
        aA();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.cL);
        this.cN = aVar;
        a(aVar);
        this.cL.addJavascriptInterface(this.cN, "KwaiAd");
    }

    private void ca() {
        if (this.cL != null && com.kwad.sdk.core.response.b.b.co(this.qp.mAdTemplate)) {
            this.mApkDownloadHelper = this.qp.mApkDownloadHelper;
            ax();
            ay();
            this.qp.b(this.mPlayEndPageListener);
        }
    }

    private KsAdWebView.e ik() {
        return new KsAdWebView.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                com.kwad.components.ad.reward.monitor.c.a(f.this.qp.oZ, "play_card", f.this.mUrl, System.currentTimeMillis() - f.this.cL.getLoadTime());
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
                com.kwad.components.ad.reward.monitor.c.a(f.this.qp.mAdTemplate, f.this.qp.oZ, "play_card", com.kwad.sdk.core.response.b.b.cm(f.this.qp.mAdTemplate), System.currentTimeMillis() - f.this.cL.getLoadTime(), 2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        this.cP = -1;
        KsAdWebView ksAdWebView = this.cL;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        aA();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.ad.reward.monitor.c.a(this.qp.oZ, "play_card");
        RewardActionBarControl rewardActionBarControl = this.qp.oN;
        this.oN = rewardActionBarControl;
        rewardActionBarControl.a(this.uJ);
        ca();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cL = (KsAdWebView) findViewById(R.id.ksad_play_web_card_webView);
        this.ss = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        RewardActionBarControl rewardActionBarControl = this.oN;
        if (rewardActionBarControl != null) {
            rewardActionBarControl.a((RewardActionBarControl.d) null);
        }
        this.qp.c(this.mPlayEndPageListener);
        aG();
        release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(a aVar) {
        KsAdWebView ksAdWebView = this.cL;
        if (ksAdWebView == null) {
            return false;
        }
        if (ksAdWebView.getVisibility() == 0) {
            return true;
        }
        if (this.cP == 1) {
            g(aVar);
            return true;
        }
        aH();
        return false;
    }

    private void g(final a aVar) {
        if (this.cM == null) {
            aD();
            return;
        }
        O(this.qp.mAdTemplate);
        aG();
        this.cL.setVisibility(0);
        KsAdWebView ksAdWebView = this.cL;
        aj.a aVar2 = this.cM;
        ValueAnimator c = n.c(ksAdWebView, aVar2.height + aVar2.bottomMargin, 0);
        this.cV = c;
        c.setInterpolator(new DecelerateInterpolator(2.0f));
        this.cV.setDuration(500L);
        this.cV.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (f.this.cQ != null) {
                    f.this.cQ.sW();
                }
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a(RewardActionBarControl.ShowActionBarResult.SHOW_H5_SUCCESS, f.this.cL);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (f.this.cQ != null) {
                    f.this.cQ.sV();
                }
            }
        });
        this.cV.start();
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new aa(this.cO, this.mApkDownloadHelper, this.cR, (byte) 0));
        aVar.a(new com.kwad.components.core.webview.tachikoma.a.f());
        aVar.a(new q(this.cO, this.mApkDownloadHelper, this.qp, -1L, this.cR, null));
        aVar.a(new ad(this.cO));
        aVar.a(new ag(this.cO));
        aVar.a(new ac(this.cO));
        aVar.a(new aj(this.cO, this.cS));
        aVar.a(new aq(this.cU, com.kwad.sdk.core.response.b.b.cm(this.qp.mAdTemplate)));
        aw awVar = new aw();
        this.cQ = awVar;
        aVar.a(awVar);
        aVar.a(new az(this.cO, this.mApkDownloadHelper));
        aVar.a(new ai(this.cT));
        aVar.a(new ak(this.cO));
        aVar.b(new m(this.cO));
        aVar.b(new l(this.cO));
        aVar.a(new com.kwad.components.ad.reward.i.b(getContext(), this.qp.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
    }
}
