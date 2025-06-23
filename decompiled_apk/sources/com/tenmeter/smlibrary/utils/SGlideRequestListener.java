package com.tenmeter.smlibrary.utils;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/* loaded from: classes13.dex */
public class SGlideRequestListener implements RequestListener<Drawable> {
    private ImageView.ScaleType mActualScaleType;
    private ImageView mImageView;
    private ImageView.ScaleType mPlaceScaleType;

    public SGlideRequestListener(ImageView imageView, ImageView.ScaleType scaleType, ImageView.ScaleType scaleType2) {
        this.mPlaceScaleType = scaleType;
        this.mActualScaleType = scaleType2;
        this.mImageView = imageView;
        imageView.setScaleType(scaleType);
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
        this.mImageView.setScaleType(this.mPlaceScaleType);
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
        this.mImageView.setScaleType(this.mActualScaleType);
        return false;
    }
}
