package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtIncompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Preconditions;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap;
import java.util.concurrent.ExecutionException;

@GwtIncompatible
/* loaded from: classes10.dex */
public abstract class ForwardingLoadingCache<K, V> extends ForwardingCache<K, V> implements LoadingCache<K, V> {
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LoadingCache, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Function, java.util.function.Function
    public V apply(K k) {
        return delegate().apply(k);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.ForwardingCache, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ForwardingObject
    public abstract LoadingCache<K, V> delegate();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LoadingCache
    public V get(K k) throws ExecutionException {
        return delegate().get(k);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LoadingCache
    public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
        return delegate().getAll(iterable);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LoadingCache
    public V getUnchecked(K k) {
        return delegate().getUnchecked(k);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LoadingCache
    public void refresh(K k) {
        delegate().refresh(k);
    }

    /* loaded from: classes10.dex */
    public static abstract class SimpleForwardingLoadingCache<K, V> extends ForwardingLoadingCache<K, V> {
        private final LoadingCache<K, V> delegate;

        public SimpleForwardingLoadingCache(LoadingCache<K, V> loadingCache) {
            this.delegate = (LoadingCache) Preconditions.checkNotNull(loadingCache);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.ForwardingLoadingCache, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.ForwardingCache, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ForwardingObject
        public final LoadingCache<K, V> delegate() {
            return this.delegate;
        }
    }
}
