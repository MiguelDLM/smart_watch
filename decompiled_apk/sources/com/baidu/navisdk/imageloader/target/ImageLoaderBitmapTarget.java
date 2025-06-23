package com.baidu.navisdk.imageloader.target;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes7.dex */
public abstract class ImageLoaderBitmapTarget extends BitmapImageViewTarget {
    public ImageLoaderBitmapTarget(ImageView imageView) {
        super(imageView);
    }

    public void onImageLoaderLoadFailed(Drawable drawable) {
    }

    public abstract void onImageLoaderResourceReady(Bitmap bitmap);

    public void onImageLoaderStart() {
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable drawable) {
        super.onLoadFailed(drawable);
        onImageLoaderLoadFailed(drawable);
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable Transition transition) {
        onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        super.onStart();
        onImageLoaderStart();
    }

    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
        super.onResourceReady((ImageLoaderBitmapTarget) bitmap, (Transition<? super ImageLoaderBitmapTarget>) transition);
        onImageLoaderResourceReady(bitmap);
    }
}
