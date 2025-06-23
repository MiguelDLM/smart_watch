package com.alimm.tanx.ui.image.glide.request.animation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.alimm.tanx.ui.image.glide.request.animation.ViewAnimation;

/* loaded from: classes.dex */
public class DrawableCrossFadeFactory<T extends Drawable> implements GlideAnimationFactory<T> {
    private static final int DEFAULT_DURATION_MS = 300;
    private final ViewAnimationFactory<T> animationFactory;
    private final int duration;
    private DrawableCrossFadeViewAnimation<T> firstResourceAnimation;
    private DrawableCrossFadeViewAnimation<T> secondResourceAnimation;

    /* loaded from: classes.dex */
    public static class DefaultAnimationFactory implements ViewAnimation.AnimationFactory {
        private final int duration;

        public DefaultAnimationFactory(int i) {
            this.duration = i;
        }

        @Override // com.alimm.tanx.ui.image.glide.request.animation.ViewAnimation.AnimationFactory
        public Animation build() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(this.duration);
            return alphaAnimation;
        }
    }

    public DrawableCrossFadeFactory() {
        this(300);
    }

    private GlideAnimation<T> getFirstResourceAnimation() {
        if (this.firstResourceAnimation == null) {
            this.firstResourceAnimation = new DrawableCrossFadeViewAnimation<>(this.animationFactory.build(false, true), this.duration);
        }
        return this.firstResourceAnimation;
    }

    private GlideAnimation<T> getSecondResourceAnimation() {
        if (this.secondResourceAnimation == null) {
            this.secondResourceAnimation = new DrawableCrossFadeViewAnimation<>(this.animationFactory.build(false, false), this.duration);
        }
        return this.secondResourceAnimation;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory
    public GlideAnimation<T> build(boolean z, boolean z2) {
        if (z) {
            return NoAnimation.get();
        }
        if (z2) {
            return getFirstResourceAnimation();
        }
        return getSecondResourceAnimation();
    }

    public DrawableCrossFadeFactory(int i) {
        this.animationFactory = new ViewAnimationFactory<>(new DefaultAnimationFactory(i));
        this.duration = i;
    }

    public DrawableCrossFadeFactory(Context context, int i, int i2) {
        this.animationFactory = new ViewAnimationFactory<>(context, i);
        this.duration = i2;
    }

    public DrawableCrossFadeFactory(Animation animation, int i) {
        this.animationFactory = new ViewAnimationFactory<>(animation);
        this.duration = i;
    }

    public DrawableCrossFadeFactory(ViewAnimationFactory<T> viewAnimationFactory, int i) {
        this.animationFactory = viewAnimationFactory;
        this.duration = i;
    }
}
