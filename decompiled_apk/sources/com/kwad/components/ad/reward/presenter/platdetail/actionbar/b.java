package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.n.h;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarH5;
import com.kwad.components.core.s.n;
import com.kwad.components.core.video.l;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aj;

/* loaded from: classes11.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {

    @Nullable
    private ValueAnimator cV;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private RewardActionBarControl oN;
    private KsLogoView ss;

    @Nullable
    private ViewGroup uA;

    @Nullable
    private ViewGroup uB;

    @Nullable
    private ViewGroup uC;
    private h uD;
    private boolean uE;
    private ActionBarAppLandscape uv;
    private ActionBarAppPortrait uw;
    private ActionBarH5 ux;
    private boolean uz;
    private boolean uy = false;
    private final l sw = new l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            b.this.uE = true;
            if (com.kwad.sdk.core.response.b.a.cM(b.this.mAdInfo) && b.this.uC != null) {
                b.this.uC.setVisibility(8);
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.uE = false;
            if (com.kwad.sdk.core.response.b.a.cM(b.this.mAdInfo) && b.this.uC != null) {
                b.this.uC.setVisibility(0);
            }
        }
    };
    private RewardActionBarControl.b uF = new RewardActionBarControl.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.4
        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.b
        public final void a(boolean z, a aVar) {
            b.this.uz = true;
            b.this.a(z, aVar);
        }
    };
    private g uG = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.5
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            b.this.uz = false;
            b.this.L(false);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z) {
        if (!this.uy) {
            return;
        }
        this.uy = false;
        this.ss.setVisibility(8);
        ViewGroup viewGroup = this.uA;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        ViewGroup viewGroup2 = this.uC;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
        if (com.kwad.sdk.core.response.b.a.aE(this.mAdInfo)) {
            if (this.qp.mScreenOrientation == 1) {
                if (z) {
                    hX();
                    return;
                } else {
                    hY();
                    return;
                }
            }
            if (z) {
                ActionBarAppPortrait actionBarAppPortrait = this.uw;
                if (actionBarAppPortrait != null) {
                    g(actionBarAppPortrait, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
                    return;
                }
                return;
            }
            ActionBarAppPortrait actionBarAppPortrait2 = this.uw;
            if (actionBarAppPortrait2 != null) {
                actionBarAppPortrait2.setVisibility(8);
                return;
            }
            return;
        }
        if (z) {
            g(this.ux, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
        } else {
            this.ux.setVisibility(8);
        }
    }

    private void aG() {
        ValueAnimator valueAnimator = this.cV;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.cV.cancel();
        }
    }

    private void ca() {
        if (com.kwad.sdk.core.response.b.a.cG(this.mAdInfo)) {
            this.uA = (ViewGroup) findViewById(R.id.ksad_reward_jinniu_root);
        }
        this.ss.aE(this.mAdTemplate);
        com.kwad.components.ad.reward.g gVar = this.qp;
        this.mApkDownloadHelper = gVar.mApkDownloadHelper;
        RewardActionBarControl rewardActionBarControl = gVar.oN;
        this.oN = rewardActionBarControl;
        rewardActionBarControl.a(this.uF);
        this.qp.b(this.uG);
    }

    private void hV() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.view_stub_action_bar_landscape);
        if (viewStub != null) {
            this.uv = (ActionBarAppLandscape) viewStub.inflate();
        } else {
            this.uv = (ActionBarAppLandscape) findViewById(R.id.ksad_video_play_bar_app_landscape);
        }
    }

    private void hW() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.view_stub_action_bar);
        if (viewStub != null) {
            this.uw = (ActionBarAppPortrait) viewStub.inflate();
        } else {
            this.uw = (ActionBarAppPortrait) findViewById(R.id.ksad_video_play_bar_app_portrait);
        }
    }

    private void hX() {
        hW();
        f(this.uw, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
    }

    private void hY() {
        ActionBarAppPortrait actionBarAppPortrait = this.uw;
        if (actionBarAppPortrait != null) {
            actionBarAppPortrait.setVisibility(8);
        }
    }

    public final void M(boolean z) {
        int i;
        if (z) {
            i = 1;
        } else {
            i = 153;
        }
        com.kwad.sdk.core.adlog.c.b cK = new com.kwad.sdk.core.adlog.c.b().f(this.qp.mRootContainer.getTouchCoords()).cK(i);
        com.kwad.components.ad.reward.g gVar = this.qp;
        com.kwad.components.ad.reward.j.b.a(gVar.mAdTemplate, "native_id", (String) null, cK, gVar.mReportExtData);
        this.qp.oJ.bJ();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdTemplate adTemplate = this.qp.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        this.qp.oK.a(this.sw);
        ca();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ss = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
        this.ux = (ActionBarH5) findViewById(R.id.ksad_video_play_bar_h5);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        RewardActionBarControl rewardActionBarControl = this.oN;
        if (rewardActionBarControl != null) {
            rewardActionBarControl.a((RewardActionBarControl.b) null);
        }
        this.qp.oK.b(this.sw);
        this.qp.c(this.uG);
        aG();
    }

    private void d(boolean z, a aVar) {
        this.ux.a(this.mAdTemplate, new ActionBarH5.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.10
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.a
            public final void N(boolean z2) {
                b.this.M(z2);
            }
        });
        if (z) {
            f(this.ux, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
        } else {
            this.ux.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.ux, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void e(final View view, int i) {
        aG();
        view.setVisibility(0);
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ValueAnimator c = n.c(view, i, 0);
        this.cV = c;
        c.setInterpolator(create);
        this.cV.setDuration(500L);
        this.cV.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }
        });
        this.cV.start();
    }

    @Deprecated
    private void f(final View view, int i) {
        aG();
        view.setVisibility(0);
        ValueAnimator b = n.b(view, 0, i);
        this.cV = b;
        b.setInterpolator(new DecelerateInterpolator(2.0f));
        this.cV.setDuration(500L);
        this.cV.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }
        });
        this.cV.start();
    }

    private void g(final View view, int i) {
        aG();
        view.setVisibility(0);
        ValueAnimator b = n.b(view, i, 0);
        this.cV = b;
        b.setInterpolator(new DecelerateInterpolator(2.0f));
        this.cV.setDuration(300L);
        this.cV.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }
        });
        this.cV.start();
    }

    private void b(boolean z, a aVar) {
        hV();
        this.uv.a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppLandscape.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.8
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.a
            public final void N(boolean z2) {
                b.this.M(z2);
            }
        });
        if (z) {
            f(this.uv, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
        } else {
            this.uv.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.uv, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void c(boolean z, a aVar) {
        hW();
        this.uw.a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppPortrait.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.9
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.a
            public final void N(boolean z2) {
                b.this.M(z2);
            }
        });
        if (z) {
            f(this.uw, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
        } else {
            this.uw.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.uw, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, a aVar) {
        ViewGroup viewGroup;
        if (this.uy) {
            return;
        }
        this.uy = true;
        this.ss.setVisibility(com.kwad.sdk.core.response.b.a.cM(this.mAdInfo) ? 8 : 0);
        getContext();
        final boolean z2 = !aj.ML();
        if (com.kwad.sdk.core.response.b.a.bc(this.mAdInfo)) {
            if (this.uD == null) {
                h hVar = new h() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.6
                    @Override // com.kwad.components.ad.reward.n.h
                    public final int hZ() {
                        if (z2) {
                            return R.id.ksad_common_app_card_land_stub;
                        }
                        return super.hZ();
                    }
                };
                this.uD = hVar;
                hVar.a(new h.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.7
                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void ia() {
                        b.this.qp.a(1, b.this.getContext(), 29, 1);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void ib() {
                        b.this.qp.a(1, b.this.getContext(), 30, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void ic() {
                        b.this.qp.a(1, b.this.getContext(), 31, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void id() {
                        b.this.qp.a(1, b.this.getContext(), 32, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void ie() {
                        b.this.qp.a(1, b.this.getContext(), 84, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    /* renamed from: if */
                    public final void mo273if() {
                        b.this.qp.a(1, b.this.getContext(), 53, 2);
                    }
                });
                this.uD.f((ViewGroup) getRootView());
                this.uD.b(r.a(this.mAdTemplate, this.mApkDownloadHelper));
            }
            this.uD.show();
            RewardActionBarControl.a(aVar, this.uD.gG(), RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT);
            return;
        }
        if (com.kwad.sdk.core.response.b.a.ca(this.mAdInfo) == 1 && (viewGroup = this.uA) != null) {
            viewGroup.setVisibility(0);
            RewardActionBarControl.a(aVar, this.uA, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_JINNIU);
            return;
        }
        if (com.kwad.sdk.core.response.b.a.cM(this.mAdInfo)) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.ksad_reward_origin_live_root);
            this.uC = viewGroup2;
            if (viewGroup2 != null) {
                if (!this.uE) {
                    viewGroup2.setVisibility(0);
                }
                RewardActionBarControl.a(aVar, this.uC, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_ORIGIN_LIVE);
                return;
            }
        }
        if (com.kwad.sdk.core.response.b.a.cd(this.mAdTemplate)) {
            ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.ksad_reward_live_subscribe_root);
            this.uB = viewGroup3;
            if (viewGroup3 != null) {
                Resources resources = viewGroup3.getResources();
                e(this.uB, (int) (resources.getDimension(R.dimen.ksad_live_subscribe_card_full_height) + resources.getDimension(R.dimen.ksad_live_subscribe_card_margin)));
                RewardActionBarControl.a(aVar, this.uB, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_LIVE_SUBSCRIBE);
                return;
            }
        }
        if (com.kwad.sdk.core.response.b.a.aE(this.mAdInfo)) {
            if (this.qp.mScreenOrientation == 1) {
                b(z, aVar);
                return;
            } else {
                c(z, aVar);
                return;
            }
        }
        d(z, aVar);
    }
}
