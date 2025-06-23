package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Preconditions;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.UnmodifiableIterator;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.NullableDecl;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class MapIteratorCache<K, V> {
    private final Map<K, V> backingMap;

    @NullableDecl
    private transient Map.Entry<K, V> entrySetCache;

    public MapIteratorCache(Map<K, V> map) {
        this.backingMap = (Map) Preconditions.checkNotNull(map);
    }

    public void clear() {
        clearCache();
        this.backingMap.clear();
    }

    public void clearCache() {
        this.entrySetCache = null;
    }

    public final boolean containsKey(@NullableDecl Object obj) {
        if (getIfCached(obj) == null && !this.backingMap.containsKey(obj)) {
            return false;
        }
        return true;
    }

    public V get(@NullableDecl Object obj) {
        V ifCached = getIfCached(obj);
        if (ifCached == null) {
            return getWithoutCaching(obj);
        }
        return ifCached;
    }

    public V getIfCached(@NullableDecl Object obj) {
        Map.Entry<K, V> entry = this.entrySetCache;
        if (entry != null && entry.getKey() == obj) {
            return entry.getValue();
        }
        return null;
    }

    public final V getWithoutCaching(@NullableDecl Object obj) {
        return this.backingMap.get(obj);
    }

    @CanIgnoreReturnValue
    public V put(@NullableDecl K k, @NullableDecl V v) {
        clearCache();
        return this.backingMap.put(k, v);
    }

    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object obj) {
        clearCache();
        return this.backingMap.remove(obj);
    }

    public final Set<K> unmodifiableKeySet() {
        return new AbstractSet<K>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.MapIteratorCache.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                return MapIteratorCache.this.containsKey(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return MapIteratorCache.this.backingMap.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<K> iterator() {
                final Iterator<Map.Entry<K, V>> it = MapIteratorCache.this.backingMap.entrySet().iterator();
                return new UnmodifiableIterator<K>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.MapIteratorCache.1.1
                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override // java.util.Iterator
                    public K next() {
                        Map.Entry entry = (Map.Entry) it.next();
                        MapIteratorCache.this.entrySetCache = entry;
                        return (K) entry.getKey();
                    }
                };
            }
        };
    }
}
