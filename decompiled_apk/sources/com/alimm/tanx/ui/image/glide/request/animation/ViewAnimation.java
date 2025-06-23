package com.alimm.tanx.ui.image.glide.request.animation;

import android.view.View;
import android.view.animation.Animation;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation;

/* loaded from: classes.dex */
public class ViewAnimation<R> implements GlideAnimation<R> {
    private final AnimationFactory animationFactory;

    /* loaded from: classes.dex */
    public interface AnimationFactory {
        Animation build();
    }

    public ViewAnimation(AnimationFactory animationFactory) {
        this.animationFactory = animationFactory;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation
    public boolean animate(R r, GlideAnimation.ViewAdapter viewAdapter) {
        View view = viewAdapter.getView();
        if (view != null) {
            view.clearAnimation();
            view.startAnimation(this.animationFactory.build());
            return false;
        }
        return false;
    }
}
