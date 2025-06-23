package com.baidu.navisdk.imageloader.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes7.dex */
public abstract class ImageLoaderDrawableTarget extends DrawableImageViewTarget {
    public ImageLoaderDrawableTarget(ImageView imageView) {
        super(imageView);
    }

    public void onImageLoaderLoadFailed(Drawable drawable) {
    }

    public abstract void onImageLoaderResourceReady(Drawable drawable);

    public void onImageLoaderStart() {
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadFailed(@Nullable Drawable drawable) {
        super.onLoadFailed(drawable);
        onImageLoaderLoadFailed(drawable);
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable Transition transition) {
        onResourceReady((Drawable) obj, (Transition<? super Drawable>) transition);
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        super.onStart();
        onImageLoaderStart();
    }

    public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
        super.onResourceReady((ImageLoaderDrawableTarget) drawable, (Transition<? super ImageLoaderDrawableTarget>) transition);
        onImageLoaderResourceReady(drawable);
    }
}
