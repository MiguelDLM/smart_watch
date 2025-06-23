package com.kwad.sdk.core.imageloader.core;

import android.graphics.Bitmap;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.display.BitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.L;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class DisplayBitmapTask implements Runnable {
    private static final String LOG_BITMAP_RECYCLED = "Display bitmap recycled by GC. Task is failed. [%s]";
    private static final String LOG_DISPLAY_IMAGE_IN_IMAGEAWARE = "Display image in ImageAware (loaded from %1$s) [%2$s]";
    private static final String LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED = "ImageAware was collected by GC. Task is cancelled. [%s]";
    private static final String LOG_TASK_CANCELLED_IMAGEAWARE_REUSED = "ImageAware is reused for another image. Task is cancelled. [%s]";
    private final DecodedResult decodedResult;
    private final BitmapDisplayer displayer;
    private final ImageLoaderEngine engine;
    private final ImageAware imageAware;
    private final String imageUri;
    private final ImageLoadingListener listener;
    private final LoadedFrom loadedFrom;
    private final String memoryCacheKey;

    public DisplayBitmapTask(DecodedResult decodedResult, ImageLoadingInfo imageLoadingInfo, ImageLoaderEngine imageLoaderEngine, LoadedFrom loadedFrom) {
        this.decodedResult = decodedResult;
        this.imageUri = imageLoadingInfo.uri;
        this.imageAware = imageLoadingInfo.imageAware;
        this.memoryCacheKey = imageLoadingInfo.memoryCacheKey;
        this.displayer = imageLoadingInfo.options.getDisplayer();
        this.listener = imageLoadingInfo.listener;
        this.engine = imageLoaderEngine;
        this.loadedFrom = loadedFrom;
    }

    private boolean canDisplayBitmap() {
        Bitmap bitmap;
        DecodedResult decodedResult = this.decodedResult;
        if (decodedResult == null || (bitmap = decodedResult.mBitmap) == null || bitmap.isRecycled()) {
            return false;
        }
        return true;
    }

    private boolean isViewWasReused() {
        if (!this.memoryCacheKey.equals(this.engine.getLoadingUriForView(this.imageAware))) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.imageAware.isCollected()) {
            L.d(LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED, this.memoryCacheKey);
            this.listener.onLoadingCancelled(this.imageUri, this.imageAware.getWrappedView());
            return;
        }
        if (isViewWasReused()) {
            L.d(LOG_TASK_CANCELLED_IMAGEAWARE_REUSED, this.memoryCacheKey);
            this.listener.onLoadingCancelled(this.imageUri, this.imageAware.getWrappedView());
        } else if (!canDisplayBitmap()) {
            L.d(LOG_BITMAP_RECYCLED, this.memoryCacheKey);
            this.listener.onLoadingFailed(this.imageUri, this.imageAware.getWrappedView(), new FailReason(FailReason.FailType.DECODING_ERROR, new IllegalStateException("Cannot create BitmapShader for recycled bitmap")));
        } else {
            L.d(LOG_DISPLAY_IMAGE_IN_IMAGEAWARE, this.loadedFrom, this.memoryCacheKey);
            this.displayer.display(this.decodedResult, this.imageAware, this.loadedFrom);
            this.engine.cancelDisplayTaskFor(this.imageAware);
            this.listener.onLoadingComplete(this.imageUri, this.imageAware.getWrappedView(), this.decodedResult);
        }
    }
}
