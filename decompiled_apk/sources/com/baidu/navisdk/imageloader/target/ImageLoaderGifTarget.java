package com.baidu.navisdk.imageloader.target;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes7.dex */
public class ImageLoaderGifTarget extends CustomViewTarget {
    public static final int LOOP_FOREVER = -1;
    public static final int LOOP_INTRINSIC = 0;
    Animatable2Compat.AnimationCallback animationCallback;
    private GifDrawable gifDrawable;
    private int maxLoopCount;
    private View view;

    public ImageLoaderGifTarget(View view) {
        this(view, 0);
    }

    public void onAnimationCallback() {
    }

    public void onImageLoaderLoadFailed(Drawable drawable) {
    }

    public void onImageLoaderResourceReady(Object obj) {
    }

    public void onImageLoaderStart() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadFailed(@Nullable Drawable drawable) {
        onImageLoaderLoadFailed(drawable);
    }

    @Override // com.bumptech.glide.request.target.CustomViewTarget
    public void onResourceCleared(@Nullable Drawable drawable) {
        GifDrawable gifDrawable = this.gifDrawable;
        if (gifDrawable != null) {
            gifDrawable.unregisterAnimationCallback(this.animationCallback);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(@NonNull Object obj, @Nullable Transition transition) {
        if (obj instanceof GifDrawable) {
            int i = this.maxLoopCount;
            if (i <= 0 && i != -1 && i != 0) {
                return;
            }
            GifDrawable gifDrawable = (GifDrawable) obj;
            this.gifDrawable = gifDrawable;
            gifDrawable.setLoopCount(i);
            this.gifDrawable.registerAnimationCallback(this.animationCallback);
            View view = this.view;
            if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(this.gifDrawable);
            } else {
                view.setBackground(this.gifDrawable);
            }
            if (!this.gifDrawable.isRunning()) {
                this.gifDrawable.start();
            }
            onImageLoaderResourceReady(this.gifDrawable);
        }
    }

    @Override // com.bumptech.glide.request.target.CustomViewTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        super.onStart();
        onImageLoaderStart();
    }

    public ImageLoaderGifTarget(View view, int i) {
        super(view);
        this.animationCallback = new Animatable2Compat.AnimationCallback() { // from class: com.baidu.navisdk.imageloader.target.ImageLoaderGifTarget.1
            @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
            public void onAnimationEnd(Drawable drawable) {
                super.onAnimationEnd(drawable);
                ImageLoaderGifTarget.this.onAnimationCallback();
            }
        };
        this.view = view;
        this.maxLoopCount = i;
    }
}
