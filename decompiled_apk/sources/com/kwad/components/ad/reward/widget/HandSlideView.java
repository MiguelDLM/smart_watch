package com.kwad.components.ad.reward.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes11.dex */
public class HandSlideView extends KSFrameLayout {
    private View Ab;
    private AnimatorSet Ac;
    private float Ad;
    private float Ae;
    private float Af;
    private long Ag;
    private long Ah;
    private int Ai;
    private int Aj;

    /* renamed from: fi, reason: collision with root package name */
    private ImageView f18450fi;
    private boolean started;

    /* loaded from: classes11.dex */
    public interface a {
        void onHandSlideLoopEnd();
    }

    public HandSlideView(@NonNull Context context) {
        super(context);
        this.Ag = 600L;
        this.Ah = 500L;
        this.Ai = 3;
        this.Aj = 0;
        this.started = false;
    }

    public static /* synthetic */ int b(HandSlideView handSlideView) {
        int i = handSlideView.Aj;
        handSlideView.Aj = i + 1;
        return i;
    }

    private static ValueAnimator.AnimatorUpdateListener s(final View view) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.HandSlideView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = (int) floatValue;
                    view.setLayoutParams(layoutParams);
                }
            }
        };
    }

    public final void destroy() {
        this.started = false;
        AnimatorSet animatorSet = this.Ac;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.Ac.cancel();
            this.Ac = null;
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super.init(context, attributeSet);
        View.inflate(getContext(), R.layout.ksad_hand_slide, this);
        this.f18450fi = (ImageView) findViewById(R.id.ksad_hand_slide_hand);
        this.Ab = findViewById(R.id.ksad_hand_slide_tail);
        this.Ad = getContext().getResources().getDimension(R.dimen.ksad_hand_slide_up);
        this.Ae = getContext().getResources().getDimension(R.dimen.ksad_hand_slide_tail_height_start);
        this.Af = getContext().getResources().getDimension(R.dimen.ksad_hand_slide_tail_height_end);
    }

    public final boolean isStarted() {
        return this.started;
    }

    private AnimatorSet b(View view, View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -this.Ad);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "rotation", 30.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat3.setDuration(10L);
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(this.Ae, this.Af);
        ofFloat4.addUpdateListener(s(view2));
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(this.Ag);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5);
        animatorSet.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.2f, 1.0f));
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(view2, "alpha", 1.0f, 0.0f));
        animatorSet2.setDuration(this.Ah);
        animatorSet2.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.2f, 1.0f));
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(animatorSet, animatorSet2);
        return animatorSet3;
    }

    public final void a(@Nullable final a aVar) {
        this.started = true;
        AnimatorSet b = b(this.f18450fi, this.Ab);
        this.Ac = b;
        b.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.widget.HandSlideView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (HandSlideView.this.Ac == null) {
                    return;
                }
                HandSlideView.b(HandSlideView.this);
                if (HandSlideView.this.Aj < HandSlideView.this.Ai) {
                    HandSlideView.this.Ac.start();
                    return;
                }
                HandSlideView.this.Ac.removeListener(this);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onHandSlideLoopEnd();
                }
            }
        });
        this.Ac.start();
    }

    public HandSlideView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ag = 600L;
        this.Ah = 500L;
        this.Ai = 3;
        this.Aj = 0;
        this.started = false;
    }

    public HandSlideView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ag = 600L;
        this.Ah = 500L;
        this.Ai = 3;
        this.Aj = 0;
        this.started = false;
    }
}
