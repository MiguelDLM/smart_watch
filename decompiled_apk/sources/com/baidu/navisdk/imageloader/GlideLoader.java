package com.baidu.navisdk.imageloader;

import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.navisdk.imageloader.config.ContextChecker;
import com.baidu.navisdk.imageloader.config.ImageConfig;
import com.baidu.navisdk.imageloader.config.ImagePriority;
import com.baidu.navisdk.imageloader.interfaces.ILoader;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

/* loaded from: classes7.dex */
public class GlideLoader extends ILoader {
    private ImageConfig mImageConfig;

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
    
        if (r1 != 3) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e0 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.bumptech.glide.load.resource.bitmap.BitmapTransformation[] getBitmapTransFormations(com.baidu.navisdk.imageloader.config.ImageConfig r11) {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = r11.getScaleMode()
            r2 = 1
            if (r1 == r2) goto L25
            r3 = 4
            if (r1 == r3) goto L1c
            r3 = 5
            if (r1 == r3) goto L13
            goto L2d
        L13:
            com.bumptech.glide.load.resource.bitmap.FitCenter r1 = new com.bumptech.glide.load.resource.bitmap.FitCenter
            r1.<init>()
            r0.add(r1)
            goto L2d
        L1c:
            com.bumptech.glide.load.resource.bitmap.CenterInside r1 = new com.bumptech.glide.load.resource.bitmap.CenterInside
            r1.<init>()
            r0.add(r1)
            goto L2d
        L25:
            com.bumptech.glide.load.resource.bitmap.CenterCrop r1 = new com.bumptech.glide.load.resource.bitmap.CenterCrop
            r1.<init>()
            r0.add(r1)
        L2d:
            int r1 = r11.getShapeMode()
            r3 = 3
            if (r1 == r2) goto L71
            r2 = 2
            if (r1 == r2) goto L3b
            if (r1 == r3) goto L71
            goto Lc1
        L3b:
            int r1 = r11.getBorderWidth()
            if (r1 <= 0) goto L68
            int r1 = r11.getBorderColor()
            if (r1 == 0) goto L68
            com.baidu.navisdk.imageloader.transform.CropCircleWithBorderTransformation r1 = new com.baidu.navisdk.imageloader.transform.CropCircleWithBorderTransformation
            android.content.Context r2 = r11.getContext()
            int r3 = r11.getBorderWidth()
            android.content.Context r4 = r11.getContext()
            android.content.res.Resources r4 = r4.getResources()
            int r11 = r11.getBorderColor()
            int r11 = r4.getColor(r11)
            r1.<init>(r2, r3, r11)
            r0.add(r1)
            goto Lc1
        L68:
            com.baidu.navisdk.imageloader.transform.CropCircleTransformation r11 = new com.baidu.navisdk.imageloader.transform.CropCircleTransformation
            r11.<init>()
            r0.add(r11)
            goto Lc1
        L71:
            com.baidu.navisdk.imageloader.transform.RoundedCornersTransformation$CornerType r2 = com.baidu.navisdk.imageloader.transform.RoundedCornersTransformation.CornerType.ALL
            if (r1 != r3) goto L77
            com.baidu.navisdk.imageloader.transform.RoundedCornersTransformation$CornerType r2 = com.baidu.navisdk.imageloader.transform.RoundedCornersTransformation.CornerType.TOP
        L77:
            int r1 = r11.getBorderWidth()
            if (r1 <= 0) goto Lad
            int r1 = r11.getBorderColor()
            if (r1 == 0) goto Lad
            com.baidu.navisdk.imageloader.transform.BorderRoundTransformation r1 = new com.baidu.navisdk.imageloader.transform.BorderRoundTransformation
            android.content.Context r4 = r11.getContext()
            int r5 = r11.getRectRoundRadius()
            int r7 = r11.getBorderWidth()
            android.content.Context r2 = r11.getContext()
            android.content.res.Resources r2 = r2.getResources()
            int r11 = r11.getBorderColor()
            int r8 = r2.getColor(r11)
            r6 = 0
            r9 = 725248(0xb1100, float:1.016289E-39)
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r0.add(r1)
            goto Lc1
        Lad:
            com.baidu.navisdk.imageloader.transform.RoundedCornersTransformation r1 = new com.baidu.navisdk.imageloader.transform.RoundedCornersTransformation
            android.content.Context r3 = r11.getContext()
            int r4 = r11.getRectRoundRadius()
            int r11 = r11.getBorderWidth()
            r1.<init>(r3, r4, r11, r2)
            r0.add(r1)
        Lc1:
            boolean r11 = r0.isEmpty()
            if (r11 != 0) goto Le0
            int r11 = r0.size()
            com.bumptech.glide.load.resource.bitmap.BitmapTransformation[] r11 = new com.bumptech.glide.load.resource.bitmap.BitmapTransformation[r11]
            r1 = 0
        Lce:
            int r2 = r0.size()
            if (r1 >= r2) goto Ldf
            java.lang.Object r2 = r0.get(r1)
            com.bumptech.glide.load.resource.bitmap.BitmapTransformation r2 = (com.bumptech.glide.load.resource.bitmap.BitmapTransformation) r2
            r11[r1] = r2
            int r1 = r1 + 1
            goto Lce
        Ldf:
            return r11
        Le0:
            r11 = 0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.imageloader.GlideLoader.getBitmapTransFormations(com.baidu.navisdk.imageloader.config.ImageConfig):com.bumptech.glide.load.resource.bitmap.BitmapTransformation[]");
    }

    private DiskCacheStrategy getDiskCacheStrategy(ImageConfig imageConfig) {
        if (!imageConfig.getDiskCacheStrategy().cacheSource() && !imageConfig.getDiskCacheStrategy().cacheResult()) {
            return DiskCacheStrategy.NONE;
        }
        if (!imageConfig.getDiskCacheStrategy().cacheSource() && imageConfig.getDiskCacheStrategy().cacheResult()) {
            return DiskCacheStrategy.DATA;
        }
        if (imageConfig.getDiskCacheStrategy().cacheSource() && !imageConfig.getDiskCacheStrategy().cacheResult()) {
            return DiskCacheStrategy.RESOURCE;
        }
        return DiskCacheStrategy.AUTOMATIC;
    }

    private Priority getPriority(ImageConfig imageConfig) {
        if (imageConfig.getPriority() == ImagePriority.HIGH) {
            return Priority.HIGH;
        }
        if (imageConfig.getPriority() == ImagePriority.IMMEDIATE) {
            return Priority.IMMEDIATE;
        }
        if (imageConfig.getPriority() == ImagePriority.LOW) {
            return Priority.LOW;
        }
        return Priority.NORMAL;
    }

    @Nullable
    private RequestBuilder getRequestBuilder(ImageConfig imageConfig) {
        RequestManager with = Glide.with(imageConfig.getContext());
        if (imageConfig.isToBytes()) {
            return with.as(byte[].class).load(imageConfig.getSource());
        }
        if (imageConfig.isGif()) {
            return with.asGif().load(imageConfig.getSource());
        }
        if (imageConfig.isAsBitmap()) {
            return with.asBitmap().load(imageConfig.getSource());
        }
        if (imageConfig.asFile()) {
            return with.asFile().load(imageConfig.getSource());
        }
        return with.load(imageConfig.getSource());
    }

    @Override // com.baidu.navisdk.imageloader.interfaces.ILoader
    public void clearDiskCache() {
        ImageConfig imageConfig = this.mImageConfig;
        if (imageConfig != null && ContextChecker.check(imageConfig.getContext())) {
            Glide.get(this.mImageConfig.getContext()).clearDiskCache();
        }
    }

    @Override // com.baidu.navisdk.imageloader.interfaces.ILoader
    public void clearMemoryCache() {
        ImageConfig imageConfig = this.mImageConfig;
        if (imageConfig == null || !ContextChecker.check(imageConfig.getContext())) {
            return;
        }
        Glide.get(this.mImageConfig.getContext()).clearMemory();
    }

    @Override // com.baidu.navisdk.imageloader.interfaces.ILoader
    public Object getObject(ImageConfig imageConfig) {
        RequestBuilder requestBuilder = getRequestBuilder(imageConfig);
        if (requestBuilder == null) {
            return null;
        }
        try {
            BitmapTransformation[] bitmapTransFormations = getBitmapTransFormations(imageConfig);
            RequestOptions requestOptions = new RequestOptions();
            if (imageConfig.isdontTransform()) {
                requestOptions.dontTransform();
            } else if (bitmapTransFormations != null && bitmapTransFormations.length > 0) {
                requestOptions.transform(bitmapTransFormations);
            }
            if ((imageConfig.getWidth() > 0 && imageConfig.getHeight() > 0) || (imageConfig.getWidth() == Integer.MIN_VALUE && imageConfig.getHeight() == Integer.MIN_VALUE)) {
                return requestBuilder.apply((BaseRequestOptions<?>) requestOptions).submit(imageConfig.getWidth(), imageConfig.getHeight()).get();
            }
            return requestBuilder.apply((BaseRequestOptions<?>) requestOptions).submit().get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.navisdk.imageloader.interfaces.ILoader
    public void onLowMemory() {
        ImageConfig imageConfig = this.mImageConfig;
        if (imageConfig != null && ContextChecker.check(imageConfig.getContext())) {
            Glide.with(this.mImageConfig.getContext()).onLowMemory();
        }
    }

    @Override // com.baidu.navisdk.imageloader.interfaces.ILoader
    public void pause() {
        ImageConfig imageConfig = this.mImageConfig;
        if (imageConfig != null && ContextChecker.check(imageConfig.getContext())) {
            Glide.with(this.mImageConfig.getContext()).pauseRequestsRecursive();
        }
    }

    @Override // com.baidu.navisdk.imageloader.interfaces.ILoader
    public void requestData(final ImageConfig imageConfig) {
        if (imageConfig == null) {
            return;
        }
        this.mImageConfig = imageConfig;
        RequestBuilder requestBuilder = getRequestBuilder(imageConfig);
        if (requestBuilder == null) {
            return;
        }
        RequestOptions requestOptions = new RequestOptions();
        if (imageConfig.isdontTransform()) {
            requestOptions.dontTransform();
        } else {
            BitmapTransformation[] bitmapTransFormations = getBitmapTransFormations(imageConfig);
            if (bitmapTransFormations != null && bitmapTransFormations.length > 0) {
                requestOptions.transform(bitmapTransFormations);
            }
        }
        if (imageConfig.isDontAnimate()) {
            requestOptions.dontAnimate();
        }
        if (imageConfig.getPlaceHolderDrawable() != null) {
            requestOptions.placeholder(imageConfig.getPlaceHolderDrawable());
        } else if (imageConfig.getPlaceHolderResId() != 0) {
            requestOptions.placeholder(imageConfig.getPlaceHolderResId());
        }
        if (imageConfig.getSource() instanceof Integer) {
            requestOptions.placeholder(((Integer) imageConfig.getSource()).intValue());
        }
        if (imageConfig.getErrorResId() > 0) {
            requestOptions.error(imageConfig.getErrorResId());
        } else if (imageConfig.getErrorDrawable() != null) {
            requestOptions.error(imageConfig.getErrorDrawable());
        }
        if (imageConfig.getWidth() > 0 && imageConfig.getHeight() > 0) {
            requestOptions.override(imageConfig.getWidth(), imageConfig.getHeight());
        } else if (imageConfig.getWidth() == Integer.MIN_VALUE && imageConfig.getHeight() == Integer.MIN_VALUE) {
            requestOptions.override(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        requestOptions.skipMemoryCache(!imageConfig.isMemoryCache());
        requestOptions.priority(getPriority(imageConfig));
        if (imageConfig.getDiskCacheStrategy() == null) {
            requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        } else {
            requestOptions.diskCacheStrategy(getDiskCacheStrategy(imageConfig));
        }
        requestBuilder.apply((BaseRequestOptions<?>) requestOptions);
        if (imageConfig.isCrossFade()) {
            if (imageConfig.isAsBitmap()) {
                requestBuilder.transition(new BitmapTransitionOptions().crossFade());
            } else {
                requestBuilder.transition(new DrawableTransitionOptions().crossFade());
            }
        }
        requestBuilder.listener(new RequestListener() { // from class: com.baidu.navisdk.imageloader.GlideLoader.1
            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target target, boolean z) {
                if (imageConfig.getImageLoaderRequestListener() != null) {
                    imageConfig.getImageLoaderRequestListener().onFail(glideException, imageConfig.getSource());
                    return false;
                }
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onResourceReady(Object obj, Object obj2, Target target, DataSource dataSource, boolean z) {
                if (imageConfig.getImageLoaderRequestListener() != null) {
                    imageConfig.getImageLoaderRequestListener().onSuccess(obj, imageConfig.getSource());
                    return false;
                }
                return false;
            }
        });
        if (imageConfig.getTargetView() != null) {
            requestBuilder.into(imageConfig.getTargetView());
            return;
        }
        if (imageConfig.getImageLoaderCustomTarget() != null) {
            requestBuilder.into((RequestBuilder) imageConfig.getImageLoaderCustomTarget());
            return;
        }
        if (imageConfig.getImageLoaderViewTarget() != null) {
            requestBuilder.into((RequestBuilder) imageConfig.getImageLoaderViewTarget());
            return;
        }
        if (imageConfig.getImageLoaderBitmapTarget() != null) {
            requestBuilder.into((RequestBuilder) imageConfig.getImageLoaderBitmapTarget());
            return;
        }
        if (imageConfig.getImageLoaderDrawableTarget() != null) {
            requestBuilder.into((RequestBuilder) imageConfig.getImageLoaderDrawableTarget());
        } else if (imageConfig.getImageLoaderGifTarget() != null) {
            requestBuilder.into((RequestBuilder) imageConfig.getImageLoaderGifTarget());
        } else if (imageConfig.isPreload()) {
            requestBuilder.preload();
        }
    }

    @Override // com.baidu.navisdk.imageloader.interfaces.ILoader
    public void resume() {
        ImageConfig imageConfig = this.mImageConfig;
        if (imageConfig != null && ContextChecker.check(imageConfig.getContext())) {
            Glide.with(this.mImageConfig.getContext()).resumeRequestsRecursive();
        }
    }

    @Override // com.baidu.navisdk.imageloader.interfaces.ILoader
    public void trimMemory(int i) {
        ImageConfig imageConfig = this.mImageConfig;
        if (imageConfig != null && ContextChecker.check(imageConfig.getContext())) {
            Glide.with(this.mImageConfig.getContext()).onTrimMemory(i);
        }
    }

    @Override // com.baidu.navisdk.imageloader.interfaces.ILoader
    public void clearMemoryCache(View view) {
        ImageConfig imageConfig = this.mImageConfig;
        if (imageConfig == null || !ContextChecker.check(imageConfig.getContext())) {
            return;
        }
        Glide.with(this.mImageConfig.getContext()).clear(view);
    }
}
