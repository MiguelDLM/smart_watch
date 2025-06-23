package com.alimm.tanx.ui.image.glide.load.engine.cache;

import com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache;
import java.io.File;

/* loaded from: classes.dex */
public class DiskLruCacheFactory implements DiskCache.Factory {
    private final CacheDirectoryGetter cacheDirectoryGetter;
    private final int diskCacheSize;

    /* loaded from: classes.dex */
    public interface CacheDirectoryGetter {
        File getCacheDirectory();
    }

    public DiskLruCacheFactory(final String str, int i) {
        CacheDirectoryGetter cacheDirectoryGetter = new CacheDirectoryGetter() { // from class: com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.1
            @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                return new File(str);
            }
        };
        this.diskCacheSize = i;
        this.cacheDirectoryGetter = cacheDirectoryGetter;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache.Factory
    public DiskCache build() {
        File cacheDirectory = this.cacheDirectoryGetter.getCacheDirectory();
        if (cacheDirectory == null) {
            return null;
        }
        if (!cacheDirectory.mkdirs() && (!cacheDirectory.exists() || !cacheDirectory.isDirectory())) {
            return null;
        }
        return DiskLruCacheWrapper.get(cacheDirectory, this.diskCacheSize);
    }

    public DiskLruCacheFactory(final String str, final String str2, int i) {
        CacheDirectoryGetter cacheDirectoryGetter = new CacheDirectoryGetter() { // from class: com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.2
            @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                return new File(str, str2);
            }
        };
        this.diskCacheSize = i;
        this.cacheDirectoryGetter = cacheDirectoryGetter;
    }

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter, int i) {
        this.diskCacheSize = i;
        this.cacheDirectoryGetter = cacheDirectoryGetter;
    }
}
