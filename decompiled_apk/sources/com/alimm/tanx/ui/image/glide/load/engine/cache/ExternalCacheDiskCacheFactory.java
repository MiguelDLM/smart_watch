package com.alimm.tanx.ui.image.glide.load.engine.cache;

import android.content.Context;
import com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

/* loaded from: classes.dex */
public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public ExternalCacheDiskCacheFactory(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public ExternalCacheDiskCacheFactory(Context context, int i) {
        this(context, "image_manager_disk_cache", i);
    }

    public ExternalCacheDiskCacheFactory(final Context context, final String str, int i) {
        super(new DiskLruCacheFactory.CacheDirectoryGetter() { // from class: com.alimm.tanx.ui.image.glide.load.engine.cache.ExternalCacheDiskCacheFactory.1
            @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir == null) {
                    return null;
                }
                String str2 = str;
                if (str2 != null) {
                    return new File(externalCacheDir, str2);
                }
                return externalCacheDir;
            }
        }, i);
    }
}
