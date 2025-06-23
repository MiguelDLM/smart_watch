package com.alimm.tanx.ui.image.glide.load.model.stream;

import android.content.Context;
import com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory;
import com.alimm.tanx.ui.image.glide.load.model.GlideUrl;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoader;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory;
import com.alimm.tanx.ui.image.glide.load.model.UrlLoader;
import java.io.InputStream;
import java.net.URL;

/* loaded from: classes.dex */
public class StreamUrlLoader extends UrlLoader<InputStream> {

    /* loaded from: classes.dex */
    public static class Factory implements ModelLoaderFactory<URL, InputStream> {
        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public ModelLoader<URL, InputStream> build(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new StreamUrlLoader(genericLoaderFactory.buildModelLoader(GlideUrl.class, InputStream.class));
        }

        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public StreamUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        super(modelLoader);
    }
}
