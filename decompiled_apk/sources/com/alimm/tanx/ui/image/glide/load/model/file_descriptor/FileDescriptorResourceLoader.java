package com.alimm.tanx.ui.image.glide.load.model.file_descriptor;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.alimm.tanx.ui.image.glide.Glide;
import com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoader;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory;
import com.alimm.tanx.ui.image.glide.load.model.ResourceLoader;

/* loaded from: classes.dex */
public class FileDescriptorResourceLoader extends ResourceLoader<ParcelFileDescriptor> implements FileDescriptorModelLoader<Integer> {

    /* loaded from: classes.dex */
    public static class Factory implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {
        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, ParcelFileDescriptor> build(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new FileDescriptorResourceLoader(context, genericLoaderFactory.buildModelLoader(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public FileDescriptorResourceLoader(Context context, ModelLoader<Uri, ParcelFileDescriptor> modelLoader) {
        super(context.getResources(), modelLoader);
    }

    public FileDescriptorResourceLoader(Context context) {
        this(context, Glide.buildFileDescriptorModelLoader(Uri.class, context));
    }
}
