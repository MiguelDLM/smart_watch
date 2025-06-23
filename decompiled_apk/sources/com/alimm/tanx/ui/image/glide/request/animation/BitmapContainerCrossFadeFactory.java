package com.alimm.tanx.ui.image.glide.request.animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation;

/* loaded from: classes.dex */
public abstract class BitmapContainerCrossFadeFactory<T> implements GlideAnimationFactory<T> {
    private final GlideAnimationFactory<Drawable> realFactory;

    /* loaded from: classes.dex */
    public class BitmapGlideAnimation implements GlideAnimation<T> {
        private final GlideAnimation<Drawable> transition;

        public BitmapGlideAnimation(GlideAnimation<Drawable> glideAnimation) {
            this.transition = glideAnimation;
        }

        @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation
        public boolean animate(T t, GlideAnimation.ViewAdapter viewAdapter) {
            return this.transition.animate(new BitmapDrawable(viewAdapter.getView().getResources(), BitmapContainerCrossFadeFactory.this.getBitmap(t)), viewAdapter);
        }
    }

    public BitmapContainerCrossFadeFactory() {
        this.realFactory = new DrawableCrossFadeFactory();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory
    public GlideAnimation<T> build(boolean z, boolean z2) {
        return new BitmapGlideAnimation(this.realFactory.build(z, z2));
    }

    public abstract Bitmap getBitmap(T t);

    public BitmapContainerCrossFadeFactory(int i) {
        this.realFactory = new DrawableCrossFadeFactory(i);
    }

    public BitmapContainerCrossFadeFactory(Context context, int i, int i2) {
        this.realFactory = new DrawableCrossFadeFactory(context, i, i2);
    }

    public BitmapContainerCrossFadeFactory(Animation animation, int i) {
        this.realFactory = new DrawableCrossFadeFactory(animation, i);
    }

    public BitmapContainerCrossFadeFactory(GlideAnimationFactory<Drawable> glideAnimationFactory) {
        this.realFactory = glideAnimationFactory;
    }
}
