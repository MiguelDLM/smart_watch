package com.baidu.navisdk.imageloader.target;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes7.dex */
public abstract class ImageLoaderCustomViewTarget<Z> extends CustomViewTarget {
    public ImageLoaderCustomViewTarget(View view) {
        super(view);
    }

    public void onImageLoaderLoadFailed(Drawable drawable) {
    }

    public abstract void onImageLoaderResourceReady(Z z);

    public void onImageLoaderStart() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadFailed(@Nullable Drawable drawable) {
        onImageLoaderLoadFailed(drawable);
    }

    @Override // com.bumptech.glide.request.target.CustomViewTarget
    public void onResourceCleared(@Nullable Drawable drawable) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(@NonNull Object obj, @Nullable Transition transition) {
        if (obj != 0) {
            onImageLoaderResourceReady(obj);
        }
    }

    @Override // com.bumptech.glide.request.target.CustomViewTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        super.onStart();
        onImageLoaderStart();
    }
}
