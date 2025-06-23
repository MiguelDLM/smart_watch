package com.alimm.tanx.ui.image.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.alimm.tanx.core.utils.AssetsUtil;
import com.alimm.tanx.ui.image.glide.Glide;
import com.alimm.tanx.ui.image.glide.load.data.DataFetcher;
import com.alimm.tanx.ui.image.glide.load.data.StreamAssetPathFetcher;
import com.alimm.tanx.ui.image.glide.load.data.StreamLocalUriFetcher;
import com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory;
import com.alimm.tanx.ui.image.glide.load.model.GlideUrl;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoader;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory;
import com.alimm.tanx.ui.image.glide.load.model.UriLoader;
import java.io.InputStream;

/* loaded from: classes.dex */
public class StreamUriLoader extends UriLoader<InputStream> implements StreamModelLoader<Uri> {

    /* loaded from: classes.dex */
    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {
        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, InputStream> build(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new StreamUriLoader(context, genericLoaderFactory.buildModelLoader(GlideUrl.class, InputStream.class));
        }

        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public StreamUriLoader(Context context) {
        super(context, Glide.buildStreamModelLoader(GlideUrl.class, context));
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.UriLoader
    public DataFetcher<InputStream> getAssetPathFetcher(Context context, String str) {
        return new StreamAssetPathFetcher(AssetsUtil.getApplicationAssets(context), str);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.UriLoader
    public DataFetcher<InputStream> getLocalUriFetcher(Context context, Uri uri) {
        return new StreamLocalUriFetcher(context, uri);
    }

    public StreamUriLoader(Context context, ModelLoader<GlideUrl, InputStream> modelLoader) {
        super(context, modelLoader);
    }
}
