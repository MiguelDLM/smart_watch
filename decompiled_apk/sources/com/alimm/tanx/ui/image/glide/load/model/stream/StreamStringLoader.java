package com.alimm.tanx.ui.image.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.alimm.tanx.ui.image.glide.Glide;
import com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoader;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory;
import com.alimm.tanx.ui.image.glide.load.model.StringLoader;
import java.io.InputStream;

/* loaded from: classes.dex */
public class StreamStringLoader extends StringLoader<InputStream> implements StreamModelLoader<String> {

    /* loaded from: classes.dex */
    public static class Factory implements ModelLoaderFactory<String, InputStream> {
        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public ModelLoader<String, InputStream> build(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new StreamStringLoader((ModelLoader<Uri, InputStream>) genericLoaderFactory.buildModelLoader(Uri.class, InputStream.class));
        }

        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public StreamStringLoader(Context context) {
        super(Glide.buildStreamModelLoader(Uri.class, context));
    }

    public StreamStringLoader(ModelLoader<Uri, InputStream> modelLoader) {
        super(modelLoader);
    }
}
