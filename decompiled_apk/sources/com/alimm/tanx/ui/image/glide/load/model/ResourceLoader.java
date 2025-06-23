package com.alimm.tanx.ui.image.glide.load.model;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import com.alimm.tanx.ui.image.glide.load.data.DataFetcher;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;

/* loaded from: classes.dex */
public class ResourceLoader<T> implements ModelLoader<Integer, T> {
    private static final String TAG = "ResourceLoader";
    private final Resources resources;
    private final ModelLoader<Uri, T> uriLoader;

    public ResourceLoader(Context context, ModelLoader<Uri, T> modelLoader) {
        this(context.getResources(), modelLoader);
    }

    public ResourceLoader(Resources resources, ModelLoader<Uri, T> modelLoader) {
        this.resources = resources;
        this.uriLoader = modelLoader;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public DataFetcher<T> getResourceFetcher(Integer num, int i, int i2) {
        Uri uri;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("android.resource://");
            sb.append(this.resources.getResourcePackageName(num.intValue()));
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append(this.resources.getResourceTypeName(num.intValue()));
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append(this.resources.getResourceEntryName(num.intValue()));
            uri = Uri.parse(sb.toString());
        } catch (Resources.NotFoundException e) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Received invalid resource id: " + num, e);
            }
            uri = null;
        }
        if (uri != null) {
            return this.uriLoader.getResourceFetcher(uri, i, i2);
        }
        return null;
    }
}
