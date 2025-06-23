package com.alimm.tanx.ui.image.glide.request.animation;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.alimm.tanx.ui.image.glide.request.animation.ViewAnimation;

/* loaded from: classes.dex */
public class ViewAnimationFactory<R> implements GlideAnimationFactory<R> {
    private final ViewAnimation.AnimationFactory animationFactory;
    private GlideAnimation<R> glideAnimation;

    /* loaded from: classes.dex */
    public static class ConcreteAnimationFactory implements ViewAnimation.AnimationFactory {
        private final Animation animation;

        public ConcreteAnimationFactory(Animation animation) {
            this.animation = animation;
        }

        @Override // com.alimm.tanx.ui.image.glide.request.animation.ViewAnimation.AnimationFactory
        public Animation build() {
            return this.animation;
        }
    }

    /* loaded from: classes.dex */
    public static class ResourceAnimationFactory implements ViewAnimation.AnimationFactory {
        private final int animationId;
        private final Context context;

        public ResourceAnimationFactory(Context context, int i) {
            this.context = context.getApplicationContext();
            this.animationId = i;
        }

        @Override // com.alimm.tanx.ui.image.glide.request.animation.ViewAnimation.AnimationFactory
        public Animation build() {
            return AnimationUtils.loadAnimation(this.context, this.animationId);
        }
    }

    public ViewAnimationFactory(Animation animation) {
        this.animationFactory = new ConcreteAnimationFactory(animation);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory
    public GlideAnimation<R> build(boolean z, boolean z2) {
        if (!z && z2) {
            if (this.glideAnimation == null) {
                this.glideAnimation = new ViewAnimation(this.animationFactory);
            }
            return this.glideAnimation;
        }
        return NoAnimation.get();
    }

    public ViewAnimationFactory(Context context, int i) {
        this.animationFactory = new ResourceAnimationFactory(context, i);
    }

    public ViewAnimationFactory(ViewAnimation.AnimationFactory animationFactory) {
        this.animationFactory = animationFactory;
    }
}
