package com.kwad.components.ad.reward.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.s.i;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.R;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import com.kwad.sdk.utils.bs;

/* loaded from: classes11.dex */
public class KsAuthorIconView extends FrameLayout implements bs.a {
    private ViewGroup AC;
    private KSCornerImageView AE;
    private KSCornerImageView AF;
    private KSCornerImageView AG;
    private TextView AH;
    private View AI;
    private View AJ;
    private ImageView AK;
    private View AL;
    private View AM;
    private View AN;
    private View AO;
    private final bs hh;
    private KSCornerImageView zA;

    public KsAuthorIconView(@NonNull Context context) {
        super(context);
        this.hh = new bs(this);
        P(context);
    }

    private void P(@NonNull Context context) {
        l.inflate(context, R.layout.ksad_author_icon, this);
        this.AC = (ViewGroup) findViewById(R.id.ksad_author_icon_frame);
        this.zA = (KSCornerImageView) findViewById(R.id.ksad_author_icon);
        this.AE = (KSCornerImageView) findViewById(R.id.ksad_author_icon_outer);
        this.AF = (KSCornerImageView) findViewById(R.id.ksad_author_animator);
        this.AG = (KSCornerImageView) findViewById(R.id.ksad_author_animator2);
        this.AH = (TextView) findViewById(R.id.ksad_fans_count);
        this.AJ = findViewById(R.id.ksad_fans_hot_icon);
        this.AI = findViewById(R.id.ksad_author_btn_follow);
        this.AK = (ImageView) findViewById(R.id.ksad_author_arrow_down);
        this.AM = findViewById(R.id.ksad_origin_live_bottom_layout);
        this.AL = findViewById(R.id.ksad_top_layout);
        this.AO = findViewById(R.id.ksad_author_icon_layout);
        this.AN = findViewById(R.id.ksad_top_flag_layout);
    }

    private Animator c(View view, long j) {
        if (view != null && view.getWidth() != 0 && view.getHeight() != 0) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(view.getWidth(), getResources().getDimension(R.dimen.ksad_reward_author_icon_width));
            ofFloat.addUpdateListener(f(view, false));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(j);
            animatorSet.setInterpolator(create);
            animatorSet.playTogether(ofFloat, ofFloat2);
            return animatorSet;
        }
        return null;
    }

    private static Animator e(View view, boolean z) {
        float width = view.getWidth();
        if (width <= 0.0f) {
            return null;
        }
        float f = 0.9f * width;
        c.d("KsAuthorIconView", "getIconScaleAnimator size: " + width + ", endSize: " + f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(width, f);
        ofFloat.addUpdateListener(f(view, false));
        Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(create);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(f, width);
        ofFloat2.addUpdateListener(f(view, false));
        Interpolator create2 = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ofFloat2.setDuration(500L);
        ofFloat2.setInterpolator(create2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2);
        return animatorSet;
    }

    private static ValueAnimator.AnimatorUpdateListener f(final View view, final boolean z) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.KsAuthorIconView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    int i = (int) floatValue;
                    layoutParams.width = i;
                    if (!z) {
                        layoutParams.height = i;
                    }
                    view.setLayoutParams(layoutParams);
                }
            }
        };
    }

    private static Animator i(View view, int i) {
        if (view == null) {
            return null;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.setPivotX(width / 2.0f);
        view.setPivotY(height);
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.1f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.1f, 1.0f));
        animatorSet.setInterpolator(create);
        animatorSet.setDuration(250L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        Interpolator create2 = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        animatorSet2.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.1f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.1f, 1.0f));
        animatorSet2.setInterpolator(create2);
        animatorSet2.setDuration(250L);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(animatorSet, animatorSet2);
        animatorSet3.setDuration(500L);
        return animatorSet3;
    }

    public final void a(e eVar) {
        i.a(eVar, this);
        this.AK.setImageResource(R.drawable.ksad_reward_follow_arrow_down);
        a(eVar, this.AF.getBackground());
        a(eVar, this.AE.getBackground());
        a(eVar, this.AG.getBackground());
        a(eVar, this.AC.getBackground());
    }

    public final void b(AdTemplate adTemplate) {
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        String cg = a.cg(dS);
        if (!TextUtils.isEmpty(cg)) {
            KSImageLoader.loadImage(this.zA, cg, adTemplate);
        }
        int be = a.be(dS);
        if (a.cM(com.kwad.sdk.core.response.b.e.dS(adTemplate))) {
            this.AH.setText("直播中");
            this.AJ.setVisibility(8);
            this.AI.setVisibility(8);
            if (be == 8) {
                this.AN.setVisibility(8);
                this.AK.setVisibility(8);
                this.AM.setVisibility(0);
            } else {
                this.AM.setVisibility(8);
                this.AK.setVisibility(0);
                this.AM.setVisibility(8);
            }
        } else {
            this.AH.setText(a.cH(dS));
        }
        this.hh.sendEmptyMessageAtTime(1, 500L);
    }

    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hh = new bs(this);
        P(context);
    }

    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hh = new bs(this);
        P(context);
    }

    private void a(e eVar, Drawable drawable) {
        if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setStroke(getResources().getDimensionPixelSize(R.dimen.ksad_reward_author_icon_stroke_width), eVar.tX());
        }
    }

    @RequiresApi(api = 21)
    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.hh = new bs(this);
        P(context);
    }

    @Override // com.kwad.sdk.utils.bs.a
    public final void a(Message message) {
        if (message.what != 1) {
            return;
        }
        c.d("KsAuthorIconView", "handleMsg MSG_CHECKING");
        final Animator c = c(this.AF, 900L);
        final Animator c2 = c(this.AG, 1000L);
        final Animator e = e(this.zA, false);
        final Animator i = i(this.AL, 500);
        if (i != null && c != null && c2 != null && e != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(e, c, c2);
            animatorSet.start();
            e.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.widget.KsAuthorIconView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.start();
                    c2.start();
                    e.start();
                    i.start();
                }
            });
            return;
        }
        this.hh.sendEmptyMessageDelayed(1, 500L);
    }
}
