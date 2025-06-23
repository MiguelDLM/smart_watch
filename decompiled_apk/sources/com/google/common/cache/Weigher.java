package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes7.dex */
public interface Weigher<K, V> {
    int weigh(K k, V v);
}
