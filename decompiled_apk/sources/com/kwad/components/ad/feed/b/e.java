package com.kwad.components.ad.feed.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.az;

/* loaded from: classes11.dex */
public final class e extends FrameLayout {
    private View fp;
    private ImageView fq;

    @Nullable
    private Animator fr;
    private com.kwad.sdk.widget.c fs;

    public e(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator bq() {
        View view = this.fp;
        if (view != null && this.fq != null && view.getWidth() + this.fp.getHeight() != 0 && this.fq.getWidth() + this.fq.getHeight() != 0) {
            Animator br = br();
            Animator a2 = a(this.fq, 100L, 16.0f);
            Animator bs = bs();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(br, a2, bs);
            return animatorSet;
        }
        return null;
    }

    private Animator br() {
        Animator b = b(this.fp, com.kwad.sdk.c.a.a.a(getContext(), 128.0f));
        Animator b2 = b(this.fq, com.kwad.sdk.c.a.a.a(getContext(), 71.11f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.playTogether(b, b2);
        return animatorSet;
    }

    private Animator bs() {
        Animator f = f(this.fp);
        Animator f2 = f(this.fq);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.playTogether(f, f2);
        return animatorSet;
    }

    private Animator f(final View view) {
        if (view == null) {
            return null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.setDuration(500L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.b.e.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }
        });
        return animatorSet;
    }

    private void init(Context context) {
        com.kwad.sdk.n.l.inflate(context, R.layout.ksad_feed_shake, this);
        setClickable(false);
        this.fp = findViewById(R.id.ksad_feed_shake_bg);
        this.fq = (ImageView) findViewById(R.id.ksad_feed_shake_icon);
    }

    public final void setOnViewEventListener(com.kwad.sdk.widget.c cVar) {
        this.fs = cVar;
    }

    private e(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private Animator b(final View view, int i) {
        if (view == null) {
            return null;
        }
        view.setPivotX(view.getWidth() / 2.0f);
        view.setPivotY(view.getHeight() / 2.0f);
        float min = i / Math.min(view.getHeight(), view.getWidth());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", min, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", min, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.setDuration(500L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.b.e.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                view.setVisibility(0);
                view.setClickable(true);
                new com.kwad.sdk.widget.f(view, e.this.fs);
            }
        });
        return animatorSet;
    }

    private e(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        init(context);
    }

    @MainThread
    public final void a(final AnimatorListenerAdapter animatorListenerAdapter) {
        Animator animator = this.fr;
        if (animator != null) {
            animator.cancel();
            this.fr = null;
        }
        this.fq.post(new az() { // from class: com.kwad.components.ad.feed.b.e.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                e eVar = e.this;
                eVar.fr = eVar.bq();
                if (e.this.fr != null) {
                    e.this.fr.addListener(animatorListenerAdapter);
                    e.this.fr.start();
                } else {
                    animatorListenerAdapter.onAnimationEnd(null);
                }
            }
        });
    }

    private Animator a(View view, long j, float f) {
        if (view == null) {
            return null;
        }
        Interpolator create = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
        this.fq.setPivotX(view.getWidth());
        this.fq.setPivotY(view.getHeight());
        Animator a2 = com.kwad.components.core.s.n.a(view, create, 100L, 16.0f);
        Animator a3 = com.kwad.components.core.s.n.a(view, create, 100L, 16.0f);
        Animator a4 = com.kwad.components.core.s.n.a(view, create, 100L, 16.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(a2, a3, a4);
        return animatorSet;
    }
}
