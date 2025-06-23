package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes11.dex */
public abstract class c extends KSFrameLayout {
    private Animator Gs;
    private boolean Gt;

    public c(@NonNull Context context) {
        this(context, null, 0);
    }

    public void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        Animator animator = this.Gs;
        if (animator != null) {
            animator.cancel();
        }
    }

    public abstract int getAnimationDelayTime();

    public abstract View getInteractionView();

    @MainThread
    public final void lp() {
        Animator animator = this.Gs;
        if (animator != null) {
            animator.cancel();
            this.Gs = null;
        }
        Animator ms = ms();
        this.Gs = ms;
        if (ms != null) {
            ms.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.c.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                    c.this.mt();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (c.this.Gt) {
                        return;
                    }
                    c.this.getInteractionView().postDelayed(new az() { // from class: com.kwad.components.ad.splashscreen.widget.c.1.1
                        @Override // com.kwad.sdk.utils.az
                        public final void doTask() {
                            if (c.this.Gs != null) {
                                c.this.Gs.start();
                            }
                        }
                    }, c.this.getAnimationDelayTime());
                }
            });
            this.Gs.start();
        }
    }

    public abstract void mr();

    public abstract Animator ms();

    public abstract void mt();

    public final void mu() {
        this.Gt = true;
        Animator animator = this.Gs;
        if (animator != null) {
            animator.cancel();
        }
    }

    public c(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Gt = false;
        a(context, attributeSet, i);
        mr();
    }
}
