package com.kwad.components.ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.l.b;
import com.kwad.components.ad.reward.presenter.RewardPreEndCardPresenter;
import com.kwad.components.core.i.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public final class s extends b implements com.kwad.components.ad.reward.e.g, a.InterfaceC0793a, w.b {

    @Nullable
    private com.kwad.components.ad.reward.d oQ;
    private ImageView sd;
    private View te;
    private KsLogoView tf;
    private DetailVideoView tg;
    private int th;
    private View ti;
    private FrameLayout tj;
    private Animator tk;
    private Animator tl;
    private Animator tm;
    private AdTemplate tn;
    private List<com.kwad.components.core.i.c> to;
    private boolean tw;

    @RewardPreEndCardPresenter.PreEndPageStatus
    private int td = 1;
    private long tp = 500;
    private long tq = 50;
    private float tr = 1.2254902f;
    private float ts = 0.80472106f;
    private float tt = 0.0f;
    private boolean tu = false;
    private long showTime = -1;
    private long tv = -1;
    private com.kwad.components.core.video.l gO = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.s.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            s.this.g(j2);
        }
    };
    private com.kwad.sdk.core.webview.d.a.a cR = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.s.5
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (aVar != null && !com.kwad.sdk.core.response.b.e.c(s.this.mAdTemplate, aVar.creativeId, aVar.adStyle)) {
                com.kwad.components.core.i.c a2 = com.kwad.components.ad.reward.g.a((List<com.kwad.components.core.i.c>) s.this.to, aVar.creativeId);
                if (a2 != null) {
                    s.this.qp.a(a2);
                    return;
                }
                return;
            }
            s.this.qp.oJ.bJ();
        }
    };

    private boolean I(boolean z) {
        boolean z2;
        int b = b(hI());
        N(b);
        com.kwad.components.ad.reward.d dVar = this.oQ;
        if (dVar != null) {
            z2 = dVar.ar();
        } else {
            z2 = false;
        }
        com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "webLoadSuccess: " + z2);
        if (!z2) {
            return false;
        }
        int a2 = a(hI());
        float f = -b;
        this.tt = f;
        Animator a3 = a(true, f, a2, true, z);
        this.tk = a3;
        a3.start();
        Animator hH = hH();
        this.tm = hH;
        hH.start();
        this.td = 2;
        return true;
    }

    private void J(boolean z) {
        Animator a2 = a(false, (hI() - hJ()) + this.tt, a(hJ()), false, z);
        this.tl = a2;
        a2.start();
        com.kwad.sdk.core.d.a.Ep();
        com.kwad.sdk.core.d.a.bW(this.tn);
        this.td = 3;
        com.kwad.components.ad.reward.d dVar = this.oQ;
        if (dVar != null) {
            dVar.fm();
        }
    }

    private void N(int i) {
        ViewGroup.LayoutParams layoutParams = this.te.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = i;
            layoutParams2.bottomMargin = -i;
        } else {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
            layoutParams3.height = i;
            layoutParams3.bottomMargin = -i;
            this.te.setLayoutParams(layoutParams3);
        }
    }

    private void f(List<AdTemplate> list) {
        com.kwad.components.ad.reward.d dVar = new com.kwad.components.ad.reward.d(list, this.qp.mReportExtData, this);
        this.oQ = dVar;
        this.qp.oQ = dVar;
        dVar.setShowLandingPage(com.kwad.sdk.core.response.b.b.cv(this.mAdTemplate));
        this.oQ.a(this.cR);
        com.kwad.components.ad.reward.d dVar2 = this.oQ;
        FrameLayout frameLayout = this.tj;
        com.kwad.components.ad.reward.g gVar = this.qp;
        dVar2.a(frameLayout, gVar.mRootContainer, this.mAdTemplate, gVar.mApkDownloadHelper, gVar.mScreenOrientation);
        com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "startPreloadWebView");
        this.oQ.a(new b.InterfaceC0751b() { // from class: com.kwad.components.ad.reward.presenter.s.2
            @Override // com.kwad.components.ad.l.b.InterfaceC0751b
            public final void hK() {
                com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "onPreloadSuccess");
                s.this.qp.pq = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j) {
        boolean z;
        AdTemplate adTemplate = this.tn;
        if (adTemplate == null || this.tw) {
            return;
        }
        if (this.showTime <= 0) {
            this.showTime = com.kwad.sdk.core.response.b.b.cs(adTemplate);
            this.tv = com.kwad.sdk.core.response.b.b.cr(this.tn) + this.showTime;
        }
        long j2 = this.showTime;
        if (j2 > 0 && !this.tu && j > j2) {
            this.tw = !I(true);
            com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "showError: " + this.tw);
            if (this.tw) {
                return;
            } else {
                this.tu = true;
            }
        }
        if (this.td == 3) {
            z = true;
        } else {
            z = false;
        }
        long j3 = this.tv;
        if (j3 > 0 && !z && j > j3) {
            J(true);
        }
    }

    private Animator hH() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ti, "alpha", 255.0f, 0.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        ofFloat.setDuration(200L);
        return ofFloat;
    }

    private float hI() {
        return com.kwad.sdk.c.a.a.d(getActivity()) / this.tr;
    }

    private float hJ() {
        return com.kwad.sdk.c.a.a.d(getActivity()) / this.ts;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qp.oK.a(this.gO);
        this.qp.b((com.kwad.components.ad.reward.e.g) this);
        this.qp.a(this);
        this.th = com.kwad.sdk.c.a.a.F(this.tg);
        com.kwad.sdk.c.a.a.n(this.tg, 49);
        this.tf.aE(this.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void bL() {
        int i;
        if (this.tn != null && (i = this.td) != 3) {
            if (i == 1) {
                I(false);
                J(false);
            } else if (i == 2) {
                J(true);
            }
        }
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0793a
    public final void e(@Nullable List<com.kwad.components.core.i.c> list) {
        com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "onInnerAdLoad: " + list);
        if (list != null && list.size() != 0) {
            this.tn = list.get(0).getAdTemplate();
            this.to = list;
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.mAdTemplate);
            arrayList.addAll(com.kwad.components.core.i.c.m(list));
            f(arrayList);
        }
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.te = findViewById(R.id.ksad_middle_end_card);
        this.tg = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.tf = (KsLogoView) findViewById(R.id.ksad_splash_logo_container);
        this.sd = (ImageView) findViewById(R.id.ksad_blur_video_cover);
        this.ti = findViewById(R.id.ksad_play_web_card_webView);
        this.tj = (FrameLayout) findViewById(R.id.ksad_middle_end_card_webview_container);
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0793a
    public final void onError(int i, String str) {
        com.kwad.sdk.core.e.c.w("RewardPreEndCardPresenter", "onError : msg " + str);
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0793a
    public final void onRequestResult(int i) {
        com.kwad.sdk.core.e.c.w("RewardPreEndCardPresenter", "onRequestResult : adNumber " + i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.g gVar = this.qp;
        gVar.pq = false;
        gVar.oK.b(this.gO);
        this.qp.c(this);
        this.qp.b((a.InterfaceC0793a) this);
        com.kwad.components.ad.reward.d dVar = this.oQ;
        if (dVar != null) {
            dVar.mw();
        }
        Animator animator = this.tm;
        if (animator != null) {
            animator.cancel();
        }
        DetailVideoView detailVideoView = this.tg;
        if (detailVideoView != null) {
            com.kwad.sdk.c.a.a.n(detailVideoView, this.th);
        }
        Animator animator2 = this.tk;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.tm = null;
        this.tk = null;
    }

    private int b(float f) {
        return (int) (f + getContext().getResources().getDimensionPixelSize(R.dimen.ksad_reward_middle_end_card_logo_view_height) + getContext().getResources().getDimensionPixelSize(R.dimen.ksad_reward_middle_end_card_logo_view_margin_bottom));
    }

    private Animator a(boolean z, float f, int i, boolean z2, boolean z3) {
        ValueAnimator ofFloat;
        com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "getUpAnimator: translationY0: " + f + ", videoTargetHeight: " + i);
        if (z) {
            ofFloat = ObjectAnimator.ofFloat(this.te, "translationY", f);
        } else {
            int height = this.te.getHeight();
            final ViewGroup.LayoutParams layoutParams = this.te.getLayoutParams();
            ofFloat = ValueAnimator.ofFloat(height, Math.abs(f));
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    s.this.te.setLayoutParams(layoutParams);
                }
            });
        }
        ObjectAnimator ofFloat2 = z2 ? ObjectAnimator.ofFloat(this.tf, "alpha", 0.0f, 255.0f) : null;
        final ViewGroup.LayoutParams layoutParams2 = this.sd.getLayoutParams();
        ValueAnimator a2 = this.tg.a(this.mAdTemplate, i, new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams3 = layoutParams2;
                if (layoutParams3 != null) {
                    layoutParams3.height = intValue;
                    s.this.sd.setLayoutParams(layoutParams2);
                }
            }
        });
        long j = z3 ? this.tp : this.tq;
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j);
        animatorSet.setInterpolator(create);
        if (ofFloat2 != null) {
            if (z3) {
                animatorSet.playTogether(ofFloat, ofFloat2, a2);
            } else {
                animatorSet.playTogether(ofFloat, ofFloat2);
            }
        } else if (z3) {
            animatorSet.playTogether(ofFloat, a2);
        } else {
            animatorSet.playTogether(ofFloat);
        }
        return animatorSet;
    }

    @Override // com.kwad.components.core.webview.jshandler.w.b
    public final void N(AdTemplate adTemplate) {
        com.kwad.components.core.i.c cVar = new com.kwad.components.core.i.c(adTemplate, com.kwad.components.core.i.e.AGGREGATION);
        com.kwad.components.ad.reward.g gVar = this.qp;
        if (gVar != null) {
            gVar.b(cVar);
        }
    }

    private int a(float f) {
        return (int) (com.kwad.sdk.c.a.a.e(getActivity()) - f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
