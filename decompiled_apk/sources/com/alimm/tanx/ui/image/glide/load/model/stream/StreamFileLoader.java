package com.alimm.tanx.ui.image.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.alimm.tanx.ui.image.glide.Glide;
import com.alimm.tanx.ui.image.glide.load.model.FileLoader;
import com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoader;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes.dex */
public class StreamFileLoader extends FileLoader<InputStream> implements StreamModelLoader<File> {

    /* loaded from: classes.dex */
    public static class Factory implements ModelLoaderFactory<File, InputStream> {
        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public ModelLoader<File, InputStream> build(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new StreamFileLoader((ModelLoader<Uri, InputStream>) genericLoaderFactory.buildModelLoader(Uri.class, InputStream.class));
        }

        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public StreamFileLoader(Context context) {
        super(Glide.buildStreamModelLoader(Uri.class, context));
    }

    public StreamFileLoader(ModelLoader<Uri, InputStream> modelLoader) {
        super(modelLoader);
    }
}
