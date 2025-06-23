package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps;
import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes10.dex */
public final class WellBehavedMap<K, V> extends ForwardingMap<K, V> {
    private final Map<K, V> delegate;

    @MonotonicNonNullDecl
    private Set<Map.Entry<K, V>> entrySet;

    /* loaded from: classes10.dex */
    public final class EntrySet extends Maps.EntrySet<K, V> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new TransformedIterator<K, Map.Entry<K, V>>(WellBehavedMap.this.keySet().iterator()) { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.WellBehavedMap.EntrySet.1
                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TransformedIterator
                public /* bridge */ /* synthetic */ Object transform(Object obj) {
                    return transform((AnonymousClass1) obj);
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TransformedIterator
                public Map.Entry<K, V> transform(final K k) {
                    return new AbstractMapEntry<K, V>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.WellBehavedMap.EntrySet.1.1
                        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                        public K getKey() {
                            return (K) k;
                        }

                        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                        public V getValue() {
                            return WellBehavedMap.this.get(k);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                        public V setValue(V v) {
                            return (V) WellBehavedMap.this.put(k, v);
                        }
                    };
                }
            };
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.EntrySet
        public Map<K, V> map() {
            return WellBehavedMap.this;
        }
    }

    private WellBehavedMap(Map<K, V> map) {
        this.delegate = map;
    }

    public static <K, V> WellBehavedMap<K, V> wrap(Map<K, V> map) {
        return new WellBehavedMap<>(map);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ForwardingMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ForwardingMap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ForwardingObject
    public Map<K, V> delegate() {
        return this.delegate;
    }
}
