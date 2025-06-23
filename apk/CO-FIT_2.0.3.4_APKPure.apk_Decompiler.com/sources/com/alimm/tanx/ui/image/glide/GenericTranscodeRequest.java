package com.alimm.tanx.ui.image.glide;

import com.alimm.tanx.ui.image.glide.RequestManager;
import com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoader;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.UnitTranscoder;
import com.alimm.tanx.ui.image.glide.provider.FixedLoadProvider;
import com.alimm.tanx.ui.image.glide.provider.LoadProvider;
import com.alimm.tanx.ui.image.glide.request.FutureTarget;
import com.alimm.tanx.ui.image.glide.request.target.Target;
import java.io.File;

public class GenericTranscodeRequest<ModelType, DataType, ResourceType> extends GenericRequestBuilder<ModelType, DataType, ResourceType, ResourceType> implements DownloadOptions {
    private final Class<DataType> dataClass;
    private final ModelLoader<ModelType, DataType> modelLoader;
    private final RequestManager.OptionsApplier optionsApplier;
    private final Class<ResourceType> resourceClass;

    public GenericTranscodeRequest(Class<ResourceType> cls, GenericRequestBuilder<ModelType, ?, ?, ?> genericRequestBuilder, ModelLoader<ModelType, DataType> modelLoader2, Class<DataType> cls2, Class<ResourceType> cls3, RequestManager.OptionsApplier optionsApplier2) {
        super(build(genericRequestBuilder.glide, modelLoader2, cls2, cls3, UnitTranscoder.get()), cls, genericRequestBuilder);
        this.modelLoader = modelLoader2;
        this.dataClass = cls2;
        this.resourceClass = cls3;
        this.optionsApplier = optionsApplier2;
    }

    private static <A, T, Z, R> LoadProvider<A, T, Z, R> build(Glide glide, ModelLoader<A, T> modelLoader2, Class<T> cls, Class<Z> cls2, ResourceTranscoder<Z, R> resourceTranscoder) {
        return new FixedLoadProvider(modelLoader2, resourceTranscoder, glide.buildDataProvider(cls, cls2));
    }

    private GenericRequestBuilder<ModelType, DataType, File, File> getDownloadOnlyRequest() {
        Class<File> cls = File.class;
        return this.optionsApplier.apply(new GenericRequestBuilder(new FixedLoadProvider(this.modelLoader, UnitTranscoder.get(), this.glide.buildDataProvider(this.dataClass, cls)), cls, this)).priority(Priority.LOW).diskCacheStrategy(DiskCacheStrategy.SOURCE).skipMemoryCache(true);
    }

    public <Y extends Target<File>> Y downloadOnly(Y y) {
        return getDownloadOnlyRequest().into(y);
    }

    public <TranscodeType> GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> transcode(ResourceTranscoder<ResourceType, TranscodeType> resourceTranscoder, Class<TranscodeType> cls) {
        return this.optionsApplier.apply(new GenericRequestBuilder(build(this.glide, this.modelLoader, this.dataClass, this.resourceClass, resourceTranscoder), cls, this));
    }

    public FutureTarget<File> downloadOnly(int i, int i2) {
        return getDownloadOnlyRequest().into(i, i2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GenericTranscodeRequest(android.content.Context r13, com.alimm.tanx.ui.image.glide.Glide r14, java.lang.Class<ModelType> r15, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<ModelType, DataType> r16, java.lang.Class<DataType> r17, java.lang.Class<ResourceType> r18, com.alimm.tanx.ui.image.glide.manager.RequestTracker r19, com.alimm.tanx.ui.image.glide.manager.Lifecycle r20, com.alimm.tanx.ui.image.glide.RequestManager.OptionsApplier r21) {
        /*
            r12 = this;
            r8 = r12
            r9 = r16
            r10 = r17
            r11 = r18
            com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder r0 = com.alimm.tanx.ui.image.glide.load.resource.transcode.UnitTranscoder.get()
            r5 = r14
            com.alimm.tanx.ui.image.glide.provider.DataLoadProvider r1 = r14.buildDataProvider(r10, r11)
            com.alimm.tanx.ui.image.glide.provider.FixedLoadProvider r3 = new com.alimm.tanx.ui.image.glide.provider.FixedLoadProvider
            r3.<init>(r9, r0, r1)
            r0 = r12
            r1 = r13
            r2 = r15
            r4 = r18
            r6 = r19
            r7 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r8.modelLoader = r9
            r8.dataClass = r10
            r8.resourceClass = r11
            r0 = r21
            r8.optionsApplier = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.ui.image.glide.GenericTranscodeRequest.<init>(android.content.Context, com.alimm.tanx.ui.image.glide.Glide, java.lang.Class, com.alimm.tanx.ui.image.glide.load.model.ModelLoader, java.lang.Class, java.lang.Class, com.alimm.tanx.ui.image.glide.manager.RequestTracker, com.alimm.tanx.ui.image.glide.manager.Lifecycle, com.alimm.tanx.ui.image.glide.RequestManager$OptionsApplier):void");
    }
}
