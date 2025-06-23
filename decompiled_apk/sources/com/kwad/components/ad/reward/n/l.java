package com.kwad.components.ad.reward.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.google.android.exoplayer2.ExoPlayer;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes11.dex */
public final class l extends s implements View.OnClickListener {
    private ImageView fq;
    private TextView lw;
    private com.kwad.components.ad.reward.g qp;
    private ImageView zk;
    private TextView zl;
    private TextView zm;
    private TextView zn;
    private View zo;
    private Set<ImageView> zp = new HashSet();
    private TextView zq;
    private Animator zr;

    public l(com.kwad.components.ad.reward.g gVar) {
        this.qp = gVar;
    }

    private void initView() {
        ViewGroup viewGroup = this.sA;
        if (viewGroup == null) {
            return;
        }
        this.zn = (TextView) viewGroup.findViewById(R.id.ksad_reward_live_subscribe_badge);
        this.zk = (ImageView) this.sA.findViewById(R.id.ksad_reward_live_subscribe_kwai_logo);
        this.fq = (ImageView) this.sA.findViewById(R.id.ksad_reward_live_subscribe_icon);
        this.zl = (TextView) this.sA.findViewById(R.id.ksad_reward_live_subscribe_name);
        this.lw = (TextView) this.sA.findViewById(R.id.ksad_reward_live_subscribe_desc);
        this.zm = (TextView) this.sA.findViewById(R.id.ksad_reward_live_subscribe_btn_follow);
        this.zo = this.sA.findViewById(R.id.ksad_reward_live_subscribe_follower_area);
        ImageView imageView = (ImageView) this.sA.findViewById(R.id.ksad_reward_live_subscribe_follower_icon1);
        ImageView imageView2 = (ImageView) this.sA.findViewById(R.id.ksad_reward_live_subscribe_follower_icon2);
        ImageView imageView3 = (ImageView) this.sA.findViewById(R.id.ksad_reward_live_subscribe_follower_icon3);
        this.zp.add(imageView);
        this.zp.add(imageView2);
        this.zp.add(imageView3);
        this.zq = (TextView) this.sA.findViewById(R.id.ksad_reward_live_subscribe_count);
        this.sA.setOnClickListener(this);
        this.zm.setOnClickListener(this);
    }

    private void kb() {
        this.zn.postDelayed(new az() { // from class: com.kwad.components.ad.reward.n.l.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                l lVar = l.this;
                lVar.zr = l.a(lVar, lVar.zn, 100L, 8.0f);
                l.this.zr.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.l.1.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (l.this.zr != null) {
                            l.this.zr.start();
                        }
                    }
                });
                l.this.zr.start();
            }
        }, 500L);
    }

    private void kc() {
        bo.runOnUiThreadDelay(new az() { // from class: com.kwad.components.ad.reward.n.l.2
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                l lVar = l.this;
                l.a(lVar, lVar.zo).start();
            }
        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    private static Animator r(View view) {
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", view.getResources().getDimension(R.dimen.ksad_live_subscribe_card_count_area_trans_y)).setDuration(250L);
        duration.setInterpolator(create);
        return duration;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void ab(boolean z) {
        super.ab(z);
        Context context = this.sA.getContext();
        if (!aj.ML()) {
            ViewGroup.LayoutParams layoutParams = this.sA.getLayoutParams();
            layoutParams.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
            this.sA.setLayoutParams(layoutParams);
        }
    }

    public final void h(ViewGroup viewGroup) {
        super.a(viewGroup, R.id.ksad_reward_live_subscribe_stub, R.id.ksad_reward_live_subscribe_root);
        initView();
    }

    public final void ka() {
        kb();
        kc();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.zm)) {
            this.qp.a(1, view.getContext(), 29, 1);
        } else if (view.equals(this.sA)) {
            this.qp.a(1, view.getContext(), 53, 2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void onUnbind() {
        super.onUnbind();
        Animator animator = this.zr;
        if (animator != null) {
            animator.cancel();
            this.zr = null;
        }
    }

    public static /* synthetic */ Animator a(l lVar, View view) {
        return r(view);
    }

    public static /* synthetic */ Animator a(l lVar, View view, long j, float f) {
        return a(view, 100L, 8.0f);
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        AdTemplate adTemplate = rVar.getAdTemplate();
        if (adTemplate != null) {
            a(com.kwad.components.ad.reward.model.a.J(adTemplate));
        }
    }

    private void a(com.kwad.components.ad.reward.model.a aVar) {
        this.zl.setText(aVar.getTitle());
        this.lw.setText(aVar.hi());
        this.zm.setText(aVar.hf());
        String gg = aVar.gg();
        Drawable drawable = this.fq.getResources().getDrawable(R.drawable.ksad_ic_default_user_avatar);
        KSImageLoader.loadCircleIcon(this.fq, gg, drawable);
        String Z = com.kwad.components.ad.d.b.Z();
        if (!bh.isNullString(Z)) {
            KSImageLoader.loadImage(this.zk, Z, aVar.gZ());
        }
        if (aVar.hg()) {
            this.zo.setVisibility(0);
            String he = aVar.he();
            if (!TextUtils.isEmpty(he)) {
                this.zq.setText(String.format("%s已预约直播", he));
            }
            if (aVar.hh() != null) {
                List<String> hh = aVar.hh();
                int i = 0;
                for (ImageView imageView : this.zp) {
                    if (i < hh.size()) {
                        imageView.setVisibility(0);
                        KSImageLoader.loadCircleIcon(imageView, hh.get(i), drawable);
                    }
                    i++;
                }
                return;
            }
            return;
        }
        this.zo.setVisibility(8);
    }

    private static Animator a(View view, long j, float f) {
        if (view == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator create = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
        view.setPivotX(0.0f);
        view.setPivotY(view.getHeight());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f);
        ofFloat.setDuration(100L);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "rotation", 0.0f, f).setDuration(j);
        float f2 = -f;
        long j2 = j * 2;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "rotation", f, f2).setDuration(j2);
        duration2.setInterpolator(create);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "rotation", f2, f).setDuration(j2);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, "rotation", f, f2).setDuration(j2);
        duration4.setInterpolator(create);
        animatorSet.playSequentially(ofFloat, duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, "rotation", f2, 0.0f).setDuration(j));
        return animatorSet;
    }
}
