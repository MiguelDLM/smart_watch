package com.baidu.navisdk.imageloader.target;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes7.dex */
public abstract class ImageLoaderCustomTarget<Z> extends CustomTarget<Z> {
    public ImageLoaderCustomTarget() {
    }

    public void onImageLoaderLoadFailed(Drawable drawable) {
    }

    public abstract void onImageLoaderResourceReady(Z z);

    public void onImageLoaderStart() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
    public void onLoadFailed(@Nullable Drawable drawable) {
        super.onLoadFailed(drawable);
        onImageLoaderLoadFailed(drawable);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(@NonNull Z z, @Nullable Transition<? super Z> transition) {
        onImageLoaderResourceReady(z);
    }

    @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        super.onStart();
        onImageLoaderStart();
    }

    public ImageLoaderCustomTarget(int i, int i2) {
        super(i, i2);
    }
}
