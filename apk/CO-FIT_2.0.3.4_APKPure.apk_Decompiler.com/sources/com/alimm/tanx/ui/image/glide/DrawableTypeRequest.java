package com.alimm.tanx.ui.image.glide;

import android.os.ParcelFileDescriptor;
import com.alimm.tanx.ui.image.glide.RequestManager;
import com.alimm.tanx.ui.image.glide.load.model.ImageVideoModelLoader;
import com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoader;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder;
import com.alimm.tanx.ui.image.glide.provider.FixedLoadProvider;
import com.alimm.tanx.ui.image.glide.request.FutureTarget;
import com.alimm.tanx.ui.image.glide.request.target.Target;
import java.io.File;
import java.io.InputStream;

public class DrawableTypeRequest<ModelType> extends DrawableRequestBuilder<ModelType> implements DownloadOptions {
    private final ModelLoader<ModelType, ParcelFileDescriptor> fileDescriptorModelLoader;
    private final RequestManager.OptionsApplier optionsApplier;
    private final ModelLoader<ModelType, InputStream> streamModelLoader;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DrawableTypeRequest(java.lang.Class<ModelType> r9, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<ModelType, java.io.InputStream> r10, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<ModelType, android.os.ParcelFileDescriptor> r11, android.content.Context r12, com.alimm.tanx.ui.image.glide.Glide r13, com.alimm.tanx.ui.image.glide.manager.RequestTracker r14, com.alimm.tanx.ui.image.glide.manager.Lifecycle r15, com.alimm.tanx.ui.image.glide.RequestManager.OptionsApplier r16) {
        /*
            r8 = this;
            r7 = r8
            java.lang.Class<com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable> r4 = com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable.class
            r5 = 0
            java.lang.Class<com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> r3 = com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper.class
            r0 = r13
            r1 = r10
            r2 = r11
            com.alimm.tanx.ui.image.glide.provider.FixedLoadProvider r3 = buildProvider(r0, r1, r2, r3, r4, r5)
            r0 = r8
            r1 = r12
            r2 = r9
            r4 = r13
            r5 = r14
            r6 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = r10
            r7.streamModelLoader = r0
            r0 = r11
            r7.fileDescriptorModelLoader = r0
            r0 = r16
            r7.optionsApplier = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.ui.image.glide.DrawableTypeRequest.<init>(java.lang.Class, com.alimm.tanx.ui.image.glide.load.model.ModelLoader, com.alimm.tanx.ui.image.glide.load.model.ModelLoader, android.content.Context, com.alimm.tanx.ui.image.glide.Glide, com.alimm.tanx.ui.image.glide.manager.RequestTracker, com.alimm.tanx.ui.image.glide.manager.Lifecycle, com.alimm.tanx.ui.image.glide.RequestManager$OptionsApplier):void");
    }

    private static <A, Z, R> FixedLoadProvider<A, ImageVideoWrapper, Z, R> buildProvider(Glide glide, ModelLoader<A, InputStream> modelLoader, ModelLoader<A, ParcelFileDescriptor> modelLoader2, Class<Z> cls, Class<R> cls2, ResourceTranscoder<Z, R> resourceTranscoder) {
        if (modelLoader == null && modelLoader2 == null) {
            return null;
        }
        if (resourceTranscoder == null) {
            resourceTranscoder = glide.buildTranscoder(cls, cls2);
        }
        return new FixedLoadProvider<>(new ImageVideoModelLoader(modelLoader, modelLoader2), resourceTranscoder, glide.buildDataProvider(ImageVideoWrapper.class, cls));
    }

    private GenericTranscodeRequest<ModelType, InputStream, File> getDownloadOnlyRequest() {
        RequestManager.OptionsApplier optionsApplier2 = this.optionsApplier;
        return (GenericTranscodeRequest) optionsApplier2.apply(new GenericTranscodeRequest(File.class, this, this.streamModelLoader, InputStream.class, File.class, optionsApplier2));
    }

    public BitmapTypeRequest<ModelType> asBitmap() {
        RequestManager.OptionsApplier optionsApplier2 = this.optionsApplier;
        return (BitmapTypeRequest) optionsApplier2.apply(new BitmapTypeRequest(this, this.streamModelLoader, this.fileDescriptorModelLoader, optionsApplier2));
    }

    public GifTypeRequest<ModelType> asGif() {
        RequestManager.OptionsApplier optionsApplier2 = this.optionsApplier;
        return (GifTypeRequest) optionsApplier2.apply(new GifTypeRequest(this, this.streamModelLoader, optionsApplier2));
    }

    public <Y extends Target<File>> Y downloadOnly(Y y) {
        return getDownloadOnlyRequest().downloadOnly(y);
    }

    public FutureTarget<File> downloadOnly(int i, int i2) {
        return getDownloadOnlyRequest().downloadOnly(i, i2);
    }
}
