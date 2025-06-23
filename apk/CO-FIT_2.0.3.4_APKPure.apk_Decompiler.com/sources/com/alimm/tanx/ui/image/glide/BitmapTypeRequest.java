package com.alimm.tanx.ui.image.glide;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.alimm.tanx.ui.image.glide.RequestManager;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoader;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder;
import java.io.InputStream;

public class BitmapTypeRequest<ModelType> extends BitmapRequestBuilder<ModelType, Bitmap> {
    private final ModelLoader<ModelType, ParcelFileDescriptor> fileDescriptorModelLoader;
    private final Glide glide;
    private final RequestManager.OptionsApplier optionsApplier;
    private final ModelLoader<ModelType, InputStream> streamModelLoader;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BitmapTypeRequest(com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, ?, ?, ?> r4, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<ModelType, java.io.InputStream> r5, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<ModelType, android.os.ParcelFileDescriptor> r6, com.alimm.tanx.ui.image.glide.RequestManager.OptionsApplier r7) {
        /*
            r3 = this;
            com.alimm.tanx.ui.image.glide.Glide r0 = r4.glide
            r1 = 0
            java.lang.Class<android.graphics.Bitmap> r2 = android.graphics.Bitmap.class
            com.alimm.tanx.ui.image.glide.provider.FixedLoadProvider r0 = buildProvider(r0, r5, r6, r2, r1)
            r3.<init>(r0, r2, r4)
            r3.streamModelLoader = r5
            r3.fileDescriptorModelLoader = r6
            com.alimm.tanx.ui.image.glide.Glide r4 = r4.glide
            r3.glide = r4
            r3.optionsApplier = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.ui.image.glide.BitmapTypeRequest.<init>(com.alimm.tanx.ui.image.glide.GenericRequestBuilder, com.alimm.tanx.ui.image.glide.load.model.ModelLoader, com.alimm.tanx.ui.image.glide.load.model.ModelLoader, com.alimm.tanx.ui.image.glide.RequestManager$OptionsApplier):void");
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Class, java.lang.Class<R>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <A, R> com.alimm.tanx.ui.image.glide.provider.FixedLoadProvider<A, com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper, android.graphics.Bitmap, R> buildProvider(com.alimm.tanx.ui.image.glide.Glide r1, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<A, java.io.InputStream> r2, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<A, android.os.ParcelFileDescriptor> r3, java.lang.Class<R> r4, com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<android.graphics.Bitmap, R> r5) {
        /*
            if (r2 != 0) goto L_0x0006
            if (r3 != 0) goto L_0x0006
            r1 = 0
            return r1
        L_0x0006:
            java.lang.Class<android.graphics.Bitmap> r0 = android.graphics.Bitmap.class
            if (r5 != 0) goto L_0x000e
            com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder r5 = r1.buildTranscoder(r0, r4)
        L_0x000e:
            java.lang.Class<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper> r4 = com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper.class
            com.alimm.tanx.ui.image.glide.provider.DataLoadProvider r1 = r1.buildDataProvider(r4, r0)
            com.alimm.tanx.ui.image.glide.load.model.ImageVideoModelLoader r4 = new com.alimm.tanx.ui.image.glide.load.model.ImageVideoModelLoader
            r4.<init>(r2, r3)
            com.alimm.tanx.ui.image.glide.provider.FixedLoadProvider r2 = new com.alimm.tanx.ui.image.glide.provider.FixedLoadProvider
            r2.<init>(r4, r5, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.ui.image.glide.BitmapTypeRequest.buildProvider(com.alimm.tanx.ui.image.glide.Glide, com.alimm.tanx.ui.image.glide.load.model.ModelLoader, com.alimm.tanx.ui.image.glide.load.model.ModelLoader, java.lang.Class, com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder):com.alimm.tanx.ui.image.glide.provider.FixedLoadProvider");
    }

    public BitmapRequestBuilder<ModelType, byte[]> toBytes() {
        return transcode(new BitmapBytesTranscoder(), byte[].class);
    }

    public <R> BitmapRequestBuilder<ModelType, R> transcode(ResourceTranscoder<Bitmap, R> resourceTranscoder, Class<R> cls) {
        return (BitmapRequestBuilder) this.optionsApplier.apply(new BitmapRequestBuilder(buildProvider(this.glide, this.streamModelLoader, this.fileDescriptorModelLoader, cls, resourceTranscoder), cls, this));
    }

    public BitmapRequestBuilder<ModelType, byte[]> toBytes(Bitmap.CompressFormat compressFormat, int i) {
        return transcode(new BitmapBytesTranscoder(compressFormat, i), byte[].class);
    }
}
