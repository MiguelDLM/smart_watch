package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph;

import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.NullableDecl;
import java.util.Map;

/* loaded from: classes10.dex */
class MapRetrievalCache<K, V> extends MapIteratorCache<K, V> {

    @NullableDecl
    private transient CacheEntry<K, V> cacheEntry1;

    @NullableDecl
    private transient CacheEntry<K, V> cacheEntry2;

    /* loaded from: classes10.dex */
    public static final class CacheEntry<K, V> {
        final K key;
        final V value;

        public CacheEntry(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }

    public MapRetrievalCache(Map<K, V> map) {
        super(map);
    }

    private void addToCache(K k, V v) {
        addToCache(new CacheEntry<>(k, v));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.MapIteratorCache
    public void clearCache() {
        super.clearCache();
        this.cacheEntry1 = null;
        this.cacheEntry2 = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.MapIteratorCache
    public V get(@NullableDecl Object obj) {
        V ifCached = getIfCached(obj);
        if (ifCached != null) {
            return ifCached;
        }
        V withoutCaching = getWithoutCaching(obj);
        if (withoutCaching != null) {
            addToCache(obj, withoutCaching);
        }
        return withoutCaching;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.MapIteratorCache
    public V getIfCached(@NullableDecl Object obj) {
        V v = (V) super.getIfCached(obj);
        if (v != null) {
            return v;
        }
        CacheEntry<K, V> cacheEntry = this.cacheEntry1;
        if (cacheEntry != null && cacheEntry.key == obj) {
            return cacheEntry.value;
        }
        CacheEntry<K, V> cacheEntry2 = this.cacheEntry2;
        if (cacheEntry2 != null && cacheEntry2.key == obj) {
            addToCache(cacheEntry2);
            return cacheEntry2.value;
        }
        return null;
    }

    private void addToCache(CacheEntry<K, V> cacheEntry) {
        this.cacheEntry2 = this.cacheEntry1;
        this.cacheEntry1 = cacheEntry;
    }
}
