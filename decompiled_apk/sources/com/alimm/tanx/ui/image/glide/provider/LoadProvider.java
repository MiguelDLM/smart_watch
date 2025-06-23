package com.alimm.tanx.ui.image.glide.provider;

import com.alimm.tanx.ui.image.glide.load.model.ModelLoader;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder;

/* loaded from: classes.dex */
public interface LoadProvider<A, T, Z, R> extends DataLoadProvider<T, Z> {
    ModelLoader<A, T> getModelLoader();

    ResourceTranscoder<Z, R> getTranscoder();
}
