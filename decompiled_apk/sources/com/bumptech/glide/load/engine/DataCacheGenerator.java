package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class DataCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {
    private File cacheFile;
    private final List<Key> cacheKeys;
    private final DataFetcherGenerator.FetcherReadyCallback cb;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private int modelLoaderIndex;
    private List<ModelLoader<File, ?>> modelLoaders;
    private int sourceIdIndex;
    private Key sourceKey;

    public DataCacheGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this(decodeHelper.getCacheKeys(), decodeHelper, fetcherReadyCallback);
    }

    private boolean hasNextModelLoader() {
        if (this.modelLoaderIndex < this.modelLoaders.size()) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.loadData;
        if (loadData != null) {
            loadData.fetcher.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onDataReady(Object obj) {
        this.cb.onDataFetcherReady(this.sourceKey, obj, this.loadData.fetcher, DataSource.DATA_DISK_CACHE, this.sourceKey);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(@NonNull Exception exc) {
        this.cb.onDataFetcherFailed(this.sourceKey, exc, this.loadData.fetcher, DataSource.DATA_DISK_CACHE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
    
        if (r2 != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
    
        if (hasNextModelLoader() == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
    
        r0 = r7.modelLoaders;
        r3 = r7.modelLoaderIndex;
        r7.modelLoaderIndex = r3 + 1;
        r7.loadData = r0.get(r3).buildLoadData(r7.cacheFile, r7.helper.getWidth(), r7.helper.getHeight(), r7.helper.getOptions());
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
    
        if (r7.loadData == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
    
        if (r7.helper.hasLoadPath(r7.loadData.fetcher.getDataClass()) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
    
        r7.loadData.fetcher.loadData(r7.helper.getPriority(), r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0066, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006d, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
    
        r7.loadData = null;
     */
    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean startNext() {
        /*
            r7 = this;
            java.lang.String r0 = "DataCacheGenerator.startNext"
            com.bumptech.glide.util.pool.GlideTrace.beginSection(r0)
        L5:
            java.util.List<com.bumptech.glide.load.model.ModelLoader<java.io.File, ?>> r0 = r7.modelLoaders     // Catch: java.lang.Throwable -> L68
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L6e
            boolean r0 = r7.hasNextModelLoader()     // Catch: java.lang.Throwable -> L68
            if (r0 != 0) goto L12
            goto L6e
        L12:
            r0 = 0
            r7.loadData = r0     // Catch: java.lang.Throwable -> L68
        L15:
            if (r2 != 0) goto L6a
            boolean r0 = r7.hasNextModelLoader()     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L6a
            java.util.List<com.bumptech.glide.load.model.ModelLoader<java.io.File, ?>> r0 = r7.modelLoaders     // Catch: java.lang.Throwable -> L68
            int r3 = r7.modelLoaderIndex     // Catch: java.lang.Throwable -> L68
            int r4 = r3 + 1
            r7.modelLoaderIndex = r4     // Catch: java.lang.Throwable -> L68
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.model.ModelLoader r0 = (com.bumptech.glide.load.model.ModelLoader) r0     // Catch: java.lang.Throwable -> L68
            java.io.File r3 = r7.cacheFile     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DecodeHelper<?> r4 = r7.helper     // Catch: java.lang.Throwable -> L68
            int r4 = r4.getWidth()     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DecodeHelper<?> r5 = r7.helper     // Catch: java.lang.Throwable -> L68
            int r5 = r5.getHeight()     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DecodeHelper<?> r6 = r7.helper     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.Options r6 = r6.getOptions()     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.model.ModelLoader$LoadData r0 = r0.buildLoadData(r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L68
            r7.loadData = r0     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r0 = r7.loadData     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L15
            com.bumptech.glide.load.engine.DecodeHelper<?> r0 = r7.helper     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r3 = r7.loadData     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.data.DataFetcher<Data> r3 = r3.fetcher     // Catch: java.lang.Throwable -> L68
            java.lang.Class r3 = r3.getDataClass()     // Catch: java.lang.Throwable -> L68
            boolean r0 = r0.hasLoadPath(r3)     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L15
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r0 = r7.loadData     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.data.DataFetcher<Data> r0 = r0.fetcher     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DecodeHelper<?> r2 = r7.helper     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.Priority r2 = r2.getPriority()     // Catch: java.lang.Throwable -> L68
            r0.loadData(r2, r7)     // Catch: java.lang.Throwable -> L68
            r2 = 1
            goto L15
        L68:
            r0 = move-exception
            goto Lb0
        L6a:
            com.bumptech.glide.util.pool.GlideTrace.endSection()
            return r2
        L6e:
            int r0 = r7.sourceIdIndex     // Catch: java.lang.Throwable -> L68
            int r0 = r0 + r1
            r7.sourceIdIndex = r0     // Catch: java.lang.Throwable -> L68
            java.util.List<com.bumptech.glide.load.Key> r1 = r7.cacheKeys     // Catch: java.lang.Throwable -> L68
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L68
            if (r0 < r1) goto L7f
            com.bumptech.glide.util.pool.GlideTrace.endSection()
            return r2
        L7f:
            java.util.List<com.bumptech.glide.load.Key> r0 = r7.cacheKeys     // Catch: java.lang.Throwable -> L68
            int r1 = r7.sourceIdIndex     // Catch: java.lang.Throwable -> L68
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.Key r0 = (com.bumptech.glide.load.Key) r0     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DataCacheKey r1 = new com.bumptech.glide.load.engine.DataCacheKey     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DecodeHelper<?> r3 = r7.helper     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.Key r3 = r3.getSignature()     // Catch: java.lang.Throwable -> L68
            r1.<init>(r0, r3)     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DecodeHelper<?> r3 = r7.helper     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.cache.DiskCache r3 = r3.getDiskCache()     // Catch: java.lang.Throwable -> L68
            java.io.File r1 = r3.get(r1)     // Catch: java.lang.Throwable -> L68
            r7.cacheFile = r1     // Catch: java.lang.Throwable -> L68
            if (r1 == 0) goto L5
            r7.sourceKey = r0     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DecodeHelper<?> r0 = r7.helper     // Catch: java.lang.Throwable -> L68
            java.util.List r0 = r0.getModelLoaders(r1)     // Catch: java.lang.Throwable -> L68
            r7.modelLoaders = r0     // Catch: java.lang.Throwable -> L68
            r7.modelLoaderIndex = r2     // Catch: java.lang.Throwable -> L68
            goto L5
        Lb0:
            com.bumptech.glide.util.pool.GlideTrace.endSection()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DataCacheGenerator.startNext():boolean");
    }

    public DataCacheGenerator(List<Key> list, DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.sourceIdIndex = -1;
        this.cacheKeys = list;
        this.helper = decodeHelper;
        this.cb = fetcherReadyCallback;
    }
}
