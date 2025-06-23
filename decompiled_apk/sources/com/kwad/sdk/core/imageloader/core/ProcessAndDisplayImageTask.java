package com.kwad.sdk.core.imageloader.core;

import android.os.Handler;
import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.process.BitmapProcessor;
import com.kwad.sdk.core.imageloader.utils.L;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class ProcessAndDisplayImageTask implements Runnable {
    private static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
    private final DecodedResult decodedResult;
    private final ImageLoaderEngine engine;
    private final Handler handler;
    private final ImageLoadingInfo imageLoadingInfo;

    public ProcessAndDisplayImageTask(ImageLoaderEngine imageLoaderEngine, DecodedResult decodedResult, ImageLoadingInfo imageLoadingInfo, Handler handler) {
        this.engine = imageLoaderEngine;
        this.imageLoadingInfo = imageLoadingInfo;
        this.handler = handler;
        this.decodedResult = decodedResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        L.d(LOG_POSTPROCESS_IMAGE, this.imageLoadingInfo.memoryCacheKey);
        BitmapProcessor postProcessor = this.imageLoadingInfo.options.getPostProcessor();
        DecodedResult decodedResult = this.decodedResult;
        decodedResult.mBitmap = postProcessor.process(decodedResult.mBitmap);
        LoadAndDisplayImageTask.runTask(new DisplayBitmapTask(this.decodedResult, this.imageLoadingInfo, this.engine, LoadedFrom.MEMORY_CACHE), this.imageLoadingInfo.options.isSyncLoading(), this.handler, this.engine);
    }
}
