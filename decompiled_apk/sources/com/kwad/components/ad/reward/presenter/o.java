package com.kwad.components.ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.ExoPlayer;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class o extends b implements View.OnClickListener, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private static long sz = 300;
    private ImageView fq;
    private ViewGroup sA;
    private TextView sB;
    private boolean sC;
    private float sD;
    private WeakReference<View> sE;
    private r sF;
    private boolean sG = false;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.o.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            o.this.hide();
        }
    };

    public o(r rVar) {
        this.sF = rVar;
    }

    private synchronized void hy() {
        if (this.sG) {
            return;
        }
        com.kwad.sdk.core.adlog.c.d(this.qp.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cM(192).ao(this.qp.oK.getPlayDuration()));
        this.sG = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator hz() {
        ValueAnimator valueAnimator;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.sA, "translationX", getContext().getResources().getDimension(R.dimen.ksad_reward_playable_pre_tips_transx));
        Drawable background = this.fq.getBackground();
        if (background instanceof ColorDrawable) {
            final ColorDrawable colorDrawable = (ColorDrawable) background;
            valueAnimator = com.kwad.sdk.widget.a.ofArgb(getContext().getResources().getColor(R.color.ksad_playable_pre_tips_icon_bg), getContext().getResources().getColor(R.color.ksad_reward_main_color));
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.o.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    colorDrawable.setColor(((Integer) valueAnimator2.getAnimatedValue()).intValue());
                }
            });
        } else {
            valueAnimator = null;
        }
        animatorSet.playTogether(ofFloat, valueAnimator, ObjectAnimator.ofFloat(this.sB, "alpha", 0.0f, 1.0f));
        animatorSet.setDuration(sz);
        return animatorSet;
    }

    private void initView() {
        ViewGroup viewGroup = this.sA;
        if (viewGroup == null) {
            return;
        }
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.ksad_playabel_pre_tips_icon);
        this.fq = imageView;
        imageView.setBackgroundColor(getContext().getResources().getColor(R.color.ksad_playable_pre_tips_icon_bg));
        this.sB = (TextView) this.sA.findViewById(R.id.ksad_playabel_pre_tips_text);
        this.sA.setOnClickListener(this);
    }

    public final void H(boolean z) {
        ViewGroup viewGroup = this.sA;
        if (viewGroup == null || viewGroup.getVisibility() == 0) {
            return;
        }
        hy();
        WeakReference<View> weakReference = this.sE;
        if (weakReference != null && weakReference.get() != null) {
            a(this.sE.get().getLayoutParams());
        }
        this.sA.setVisibility(0);
        if (z) {
            this.sA.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.o.2
                @Override // java.lang.Runnable
                public final void run() {
                    o.this.hz().start();
                }
            }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (this.sA == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_playable_pre_tips_stub);
            if (viewStub != null) {
                this.sA = (ViewGroup) viewStub.inflate();
            } else {
                this.sA = (ViewGroup) findViewById(R.id.ksad_playable_pre_tips_root);
            }
            initView();
        }
        if (this.qp.fG()) {
            a(new ViewGroup.LayoutParams(-1, this.sA.getResources().getDimensionPixelSize(R.dimen.ksad_reward_js_actionbar_height)));
        } else {
            this.qp.oN.a(this);
        }
        this.qp.b(this.mPlayEndPageListener);
    }

    public final void hide() {
        ViewGroup viewGroup = this.sA;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ViewGroup viewGroup = this.sA;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        com.kwad.components.ad.reward.a.eY().a(PlayableSource.PENDANT_CLICK_NOT_AUTO);
        com.kwad.sdk.core.adlog.c.e(this.qp.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cM(192).ao(this.qp.oK.getPlayDuration()));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        boolean z;
        super.onCreate();
        this.sD = com.kwad.components.ad.reward.a.b.gw();
        if (!com.kwad.components.ad.reward.a.b.gy() && com.kwad.components.ad.reward.a.b.gx()) {
            z = true;
        } else {
            z = false;
        }
        this.sC = z;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qp.c(this.mPlayEndPageListener);
        this.qp.oN.b(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        this.sE = new WeakReference<>(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        com.kwad.sdk.core.e.c.d("RewardPlayablePreTips", "onActionBarShown: type: " + showActionBarResult + ", params.height: " + layoutParams.height + ", params.width: " + layoutParams.width);
        a(layoutParams);
    }

    private void a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.sA.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            if (layoutParams.height == -1) {
                marginLayoutParams.bottomMargin = this.sA.getResources().getDimensionPixelSize(R.dimen.ksad_reward_playable_pre_tips_margin_bottom_without_actionbar);
            } else {
                int dimensionPixelSize = this.sA.getResources().getDimensionPixelSize(R.dimen.ksad_reward_playable_pre_tips_margin_bottom);
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                    WeakReference<View> weakReference = this.sE;
                    View view = weakReference != null ? weakReference.get() : null;
                    int i = marginLayoutParams2.height;
                    if (i <= 0 && view != null) {
                        i = view.getHeight();
                    }
                    marginLayoutParams.bottomMargin = i + marginLayoutParams2.bottomMargin + dimensionPixelSize;
                } else {
                    marginLayoutParams.bottomMargin = layoutParams.height + dimensionPixelSize;
                }
            }
            this.sA.setLayoutParams(marginLayoutParams);
        }
    }
}
