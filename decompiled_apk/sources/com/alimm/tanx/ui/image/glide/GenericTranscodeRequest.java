package com.alimm.tanx.ui.image.glide;

import android.content.Context;
import com.alimm.tanx.ui.image.glide.RequestManager;
import com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoader;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.UnitTranscoder;
import com.alimm.tanx.ui.image.glide.manager.Lifecycle;
import com.alimm.tanx.ui.image.glide.manager.RequestTracker;
import com.alimm.tanx.ui.image.glide.provider.FixedLoadProvider;
import com.alimm.tanx.ui.image.glide.provider.LoadProvider;
import com.alimm.tanx.ui.image.glide.request.FutureTarget;
import com.alimm.tanx.ui.image.glide.request.target.Target;
import java.io.File;

/* loaded from: classes.dex */
public class GenericTranscodeRequest<ModelType, DataType, ResourceType> extends GenericRequestBuilder<ModelType, DataType, ResourceType, ResourceType> implements DownloadOptions {
    private final Class<DataType> dataClass;
    private final ModelLoader<ModelType, DataType> modelLoader;
    private final RequestManager.OptionsApplier optionsApplier;
    private final Class<ResourceType> resourceClass;

    public GenericTranscodeRequest(Class<ResourceType> cls, GenericRequestBuilder<ModelType, ?, ?, ?> genericRequestBuilder, ModelLoader<ModelType, DataType> modelLoader, Class<DataType> cls2, Class<ResourceType> cls3, RequestManager.OptionsApplier optionsApplier) {
        super(build(genericRequestBuilder.glide, modelLoader, cls2, cls3, UnitTranscoder.get()), cls, genericRequestBuilder);
        this.modelLoader = modelLoader;
        this.dataClass = cls2;
        this.resourceClass = cls3;
        this.optionsApplier = optionsApplier;
    }

    private static <A, T, Z, R> LoadProvider<A, T, Z, R> build(Glide glide, ModelLoader<A, T> modelLoader, Class<T> cls, Class<Z> cls2, ResourceTranscoder<Z, R> resourceTranscoder) {
        return new FixedLoadProvider(modelLoader, resourceTranscoder, glide.buildDataProvider(cls, cls2));
    }

    private GenericRequestBuilder<ModelType, DataType, File, File> getDownloadOnlyRequest() {
        return this.optionsApplier.apply(new GenericRequestBuilder(new FixedLoadProvider(this.modelLoader, UnitTranscoder.get(), this.glide.buildDataProvider(this.dataClass, File.class)), File.class, this)).priority(Priority.LOW).diskCacheStrategy(DiskCacheStrategy.SOURCE).skipMemoryCache(true);
    }

    @Override // com.alimm.tanx.ui.image.glide.DownloadOptions
    public <Y extends Target<File>> Y downloadOnly(Y y) {
        return (Y) getDownloadOnlyRequest().into((GenericRequestBuilder<ModelType, DataType, File, File>) y);
    }

    public <TranscodeType> GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> transcode(ResourceTranscoder<ResourceType, TranscodeType> resourceTranscoder, Class<TranscodeType> cls) {
        return this.optionsApplier.apply(new GenericRequestBuilder(build(this.glide, this.modelLoader, this.dataClass, this.resourceClass, resourceTranscoder), cls, this));
    }

    @Override // com.alimm.tanx.ui.image.glide.DownloadOptions
    public FutureTarget<File> downloadOnly(int i, int i2) {
        return getDownloadOnlyRequest().into(i, i2);
    }

    public GenericTranscodeRequest(Context context, Glide glide, Class<ModelType> cls, ModelLoader<ModelType, DataType> modelLoader, Class<DataType> cls2, Class<ResourceType> cls3, RequestTracker requestTracker, Lifecycle lifecycle, RequestManager.OptionsApplier optionsApplier) {
        super(context, cls, new FixedLoadProvider(modelLoader, UnitTranscoder.get(), glide.buildDataProvider(cls2, cls3)), cls3, glide, requestTracker, lifecycle);
        this.modelLoader = modelLoader;
        this.dataClass = cls2;
        this.resourceClass = cls3;
        this.optionsApplier = optionsApplier;
    }
}
