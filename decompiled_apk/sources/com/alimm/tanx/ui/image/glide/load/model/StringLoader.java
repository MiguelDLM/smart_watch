package com.alimm.tanx.ui.image.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import com.alimm.tanx.ui.image.glide.load.data.DataFetcher;
import java.io.File;

/* loaded from: classes.dex */
public class StringLoader<T> implements ModelLoader<String, T> {
    private final ModelLoader<Uri, T> uriLoader;

    public StringLoader(ModelLoader<Uri, T> modelLoader) {
        this.uriLoader = modelLoader;
    }

    private static Uri toFileUri(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public DataFetcher<T> getResourceFetcher(String str, int i, int i2) {
        Uri fileUri;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("/")) {
            fileUri = toFileUri(str);
        } else {
            Uri parse = Uri.parse(str);
            fileUri = parse.getScheme() == null ? toFileUri(str) : parse;
        }
        return this.uriLoader.getResourceFetcher(fileUri, i, i2);
    }
}
