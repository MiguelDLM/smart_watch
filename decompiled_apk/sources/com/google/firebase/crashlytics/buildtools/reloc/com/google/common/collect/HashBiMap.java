package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtIncompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Objects;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Preconditions;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.j2objc.annotations.RetainedWith;
import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.NullableDecl;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public final class HashBiMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> implements BiMap<K, V>, Serializable {
    private static final double LOAD_FACTOR = 1.0d;

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    @NullableDecl
    private transient BiEntry<K, V> firstInKeyInsertionOrder;
    private transient BiEntry<K, V>[] hashTableKToV;
    private transient BiEntry<K, V>[] hashTableVToK;

    @MonotonicNonNullDecl
    @RetainedWith
    private transient BiMap<V, K> inverse;

    @NullableDecl
    private transient BiEntry<K, V> lastInKeyInsertionOrder;
    private transient int mask;
    private transient int modCount;
    private transient int size;

    /* loaded from: classes10.dex */
    public static final class BiEntry<K, V> extends ImmutableEntry<K, V> {
        final int keyHash;

        @NullableDecl
        BiEntry<K, V> nextInKToVBucket;

        @NullableDecl
        BiEntry<K, V> nextInKeyInsertionOrder;

        @NullableDecl
        BiEntry<K, V> nextInVToKBucket;

        @NullableDecl
        BiEntry<K, V> prevInKeyInsertionOrder;
        final int valueHash;

        public BiEntry(K k, int i, V v, int i2) {
            super(k, v);
            this.keyHash = i;
            this.valueHash = i2;
        }
    }

    /* loaded from: classes10.dex */
    public final class Inverse extends Maps.IteratorBasedAbstractMap<V, K> implements BiMap<V, K>, Serializable {

        /* loaded from: classes10.dex */
        public final class InverseKeySet extends Maps.KeySet<V, K> {
            public InverseKeySet() {
                super(Inverse.this);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<V> iterator() {
                return new HashBiMap<K, V>.Itr<V>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.HashBiMap.Inverse.InverseKeySet.1
                    {
                        HashBiMap hashBiMap = HashBiMap.this;
                    }

                    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.HashBiMap.Itr
                    public V output(BiEntry<K, V> biEntry) {
                        return biEntry.value;
                    }
                };
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@NullableDecl Object obj) {
                BiEntry seekByValue = HashBiMap.this.seekByValue(obj, Hashing.smearedHash(obj));
                if (seekByValue != null) {
                    HashBiMap.this.delete(seekByValue);
                    return true;
                }
                return false;
            }
        }

        private Inverse() {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            forward().clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return forward().containsValue(obj);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<V, K>> entryIterator() {
            return new HashBiMap<K, V>.Itr<Map.Entry<V, K>>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.HashBiMap.Inverse.1

                /* renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.HashBiMap$Inverse$1$InverseEntry */
                /* loaded from: classes10.dex */
                public class InverseEntry extends AbstractMapEntry<V, K> {
                    BiEntry<K, V> delegate;

                    public InverseEntry(BiEntry<K, V> biEntry) {
                        this.delegate = biEntry;
                    }

                    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                    public V getKey() {
                        return this.delegate.value;
                    }

                    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                    public K getValue() {
                        return this.delegate.key;
                    }

                    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                    public K setValue(K k) {
                        boolean z;
                        K k2 = this.delegate.key;
                        int smearedHash = Hashing.smearedHash(k);
                        if (smearedHash == this.delegate.keyHash && Objects.equal(k, k2)) {
                            return k;
                        }
                        if (HashBiMap.this.seekByKey(k, smearedHash) == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        Preconditions.checkArgument(z, "value already present: %s", k);
                        HashBiMap.this.delete(this.delegate);
                        BiEntry<K, V> biEntry = this.delegate;
                        BiEntry<K, V> biEntry2 = new BiEntry<>(k, smearedHash, biEntry.value, biEntry.valueHash);
                        this.delegate = biEntry2;
                        HashBiMap.this.insert(biEntry2, null);
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.expectedModCount = HashBiMap.this.modCount;
                        return k2;
                    }
                }

                {
                    HashBiMap hashBiMap = HashBiMap.this;
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.HashBiMap.Itr
                public Map.Entry<V, K> output(BiEntry<K, V> biEntry) {
                    return new InverseEntry(biEntry);
                }
            };
        }

        @Override // java.util.Map
        public void forEach(final BiConsumer<? super V, ? super K> biConsumer) {
            Preconditions.checkNotNull(biConsumer);
            HashBiMap.this.forEach(new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.oOoIIO0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    biConsumer.accept(obj2, obj);
                }
            });
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.BiMap
        public K forcePut(@NullableDecl V v, @NullableDecl K k) {
            return (K) HashBiMap.this.putInverse(v, k, true);
        }

        public BiMap<K, V> forward() {
            return HashBiMap.this;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K get(@NullableDecl Object obj) {
            return (K) Maps.keyOrNull(HashBiMap.this.seekByValue(obj, Hashing.smearedHash(obj)));
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.BiMap
        public BiMap<K, V> inverse() {
            return forward();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return new InverseKeySet();
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.BiMap
        @CanIgnoreReturnValue
        public K put(@NullableDecl V v, @NullableDecl K k) {
            return (K) HashBiMap.this.putInverse(v, k, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K remove(@NullableDecl Object obj) {
            BiEntry seekByValue = HashBiMap.this.seekByValue(obj, Hashing.smearedHash(obj));
            if (seekByValue != null) {
                HashBiMap.this.delete(seekByValue);
                seekByValue.prevInKeyInsertionOrder = null;
                seekByValue.nextInKeyInsertionOrder = null;
                return seekByValue.key;
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public void replaceAll(BiFunction<? super V, ? super K, ? extends K> biFunction) {
            Object apply;
            Preconditions.checkNotNull(biFunction);
            clear();
            for (BiEntry<K, V> biEntry = HashBiMap.this.firstInKeyInsertionOrder; biEntry != null; biEntry = biEntry.nextInKeyInsertionOrder) {
                V v = biEntry.value;
                apply = biFunction.apply(v, biEntry.key);
                put(v, apply);
            }
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return HashBiMap.this.size;
        }

        public Object writeReplace() {
            return new InverseSerializedForm(HashBiMap.this);
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.BiMap
        public Set<K> values() {
            return forward().keySet();
        }
    }

    /* loaded from: classes10.dex */
    public static final class InverseSerializedForm<K, V> implements Serializable {
        private final HashBiMap<K, V> bimap;

        public InverseSerializedForm(HashBiMap<K, V> hashBiMap) {
            this.bimap = hashBiMap;
        }

        public Object readResolve() {
            return this.bimap.inverse();
        }
    }

    /* loaded from: classes10.dex */
    public abstract class Itr<T> implements Iterator<T> {
        int expectedModCount;
        BiEntry<K, V> next;
        int remaining;
        BiEntry<K, V> toRemove = null;

        public Itr() {
            this.next = HashBiMap.this.firstInKeyInsertionOrder;
            this.expectedModCount = HashBiMap.this.modCount;
            this.remaining = HashBiMap.this.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (HashBiMap.this.modCount == this.expectedModCount) {
                if (this.next != null && this.remaining > 0) {
                    return true;
                }
                return false;
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                BiEntry<K, V> biEntry = this.next;
                this.next = biEntry.nextInKeyInsertionOrder;
                this.toRemove = biEntry;
                this.remaining--;
                return output(biEntry);
            }
            throw new NoSuchElementException();
        }

        public abstract T output(BiEntry<K, V> biEntry);

        @Override // java.util.Iterator
        public void remove() {
            boolean z;
            if (HashBiMap.this.modCount == this.expectedModCount) {
                if (this.toRemove != null) {
                    z = true;
                } else {
                    z = false;
                }
                CollectPreconditions.checkRemove(z);
                HashBiMap.this.delete(this.toRemove);
                this.expectedModCount = HashBiMap.this.modCount;
                this.toRemove = null;
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    /* loaded from: classes10.dex */
    public final class KeySet extends Maps.KeySet<K, V> {
        public KeySet() {
            super(HashBiMap.this);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new HashBiMap<K, V>.Itr<K>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.HashBiMap.KeySet.1
                {
                    HashBiMap hashBiMap = HashBiMap.this;
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.HashBiMap.Itr
                public K output(BiEntry<K, V> biEntry) {
                    return biEntry.key;
                }
            };
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            BiEntry seekByKey = HashBiMap.this.seekByKey(obj, Hashing.smearedHash(obj));
            if (seekByKey != null) {
                HashBiMap.this.delete(seekByKey);
                seekByKey.prevInKeyInsertionOrder = null;
                seekByKey.nextInKeyInsertionOrder = null;
                return true;
            }
            return false;
        }
    }

    private HashBiMap(int i) {
        init(i);
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    private BiEntry<K, V>[] createTable(int i) {
        return new BiEntry[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete(BiEntry<K, V> biEntry) {
        BiEntry<K, V> biEntry2;
        int i = biEntry.keyHash & this.mask;
        BiEntry<K, V> biEntry3 = null;
        BiEntry<K, V> biEntry4 = null;
        for (BiEntry<K, V> biEntry5 = this.hashTableKToV[i]; biEntry5 != biEntry; biEntry5 = biEntry5.nextInKToVBucket) {
            biEntry4 = biEntry5;
        }
        if (biEntry4 == null) {
            this.hashTableKToV[i] = biEntry.nextInKToVBucket;
        } else {
            biEntry4.nextInKToVBucket = biEntry.nextInKToVBucket;
        }
        int i2 = biEntry.valueHash & this.mask;
        BiEntry<K, V> biEntry6 = this.hashTableVToK[i2];
        while (true) {
            biEntry2 = biEntry3;
            biEntry3 = biEntry6;
            if (biEntry3 == biEntry) {
                break;
            } else {
                biEntry6 = biEntry3.nextInVToKBucket;
            }
        }
        if (biEntry2 == null) {
            this.hashTableVToK[i2] = biEntry.nextInVToKBucket;
        } else {
            biEntry2.nextInVToKBucket = biEntry.nextInVToKBucket;
        }
        BiEntry<K, V> biEntry7 = biEntry.prevInKeyInsertionOrder;
        if (biEntry7 == null) {
            this.firstInKeyInsertionOrder = biEntry.nextInKeyInsertionOrder;
        } else {
            biEntry7.nextInKeyInsertionOrder = biEntry.nextInKeyInsertionOrder;
        }
        BiEntry<K, V> biEntry8 = biEntry.nextInKeyInsertionOrder;
        if (biEntry8 == null) {
            this.lastInKeyInsertionOrder = biEntry7;
        } else {
            biEntry8.prevInKeyInsertionOrder = biEntry7;
        }
        this.size--;
        this.modCount++;
    }

    private void init(int i) {
        CollectPreconditions.checkNonnegative(i, "expectedSize");
        int closedTableSize = Hashing.closedTableSize(i, 1.0d);
        this.hashTableKToV = createTable(closedTableSize);
        this.hashTableVToK = createTable(closedTableSize);
        this.firstInKeyInsertionOrder = null;
        this.lastInKeyInsertionOrder = null;
        this.size = 0;
        this.mask = closedTableSize - 1;
        this.modCount = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insert(BiEntry<K, V> biEntry, @NullableDecl BiEntry<K, V> biEntry2) {
        int i = biEntry.keyHash;
        int i2 = this.mask;
        int i3 = i & i2;
        BiEntry<K, V>[] biEntryArr = this.hashTableKToV;
        biEntry.nextInKToVBucket = biEntryArr[i3];
        biEntryArr[i3] = biEntry;
        int i4 = biEntry.valueHash & i2;
        BiEntry<K, V>[] biEntryArr2 = this.hashTableVToK;
        biEntry.nextInVToKBucket = biEntryArr2[i4];
        biEntryArr2[i4] = biEntry;
        if (biEntry2 == null) {
            BiEntry<K, V> biEntry3 = this.lastInKeyInsertionOrder;
            biEntry.prevInKeyInsertionOrder = biEntry3;
            biEntry.nextInKeyInsertionOrder = null;
            if (biEntry3 == null) {
                this.firstInKeyInsertionOrder = biEntry;
            } else {
                biEntry3.nextInKeyInsertionOrder = biEntry;
            }
            this.lastInKeyInsertionOrder = biEntry;
        } else {
            BiEntry<K, V> biEntry4 = biEntry2.prevInKeyInsertionOrder;
            biEntry.prevInKeyInsertionOrder = biEntry4;
            if (biEntry4 == null) {
                this.firstInKeyInsertionOrder = biEntry;
            } else {
                biEntry4.nextInKeyInsertionOrder = biEntry;
            }
            BiEntry<K, V> biEntry5 = biEntry2.nextInKeyInsertionOrder;
            biEntry.nextInKeyInsertionOrder = biEntry5;
            if (biEntry5 == null) {
                this.lastInKeyInsertionOrder = biEntry;
            } else {
                biEntry5.prevInKeyInsertionOrder = biEntry;
            }
        }
        this.size++;
        this.modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NullableDecl
    public K putInverse(@NullableDecl V v, @NullableDecl K k, boolean z) {
        int smearedHash = Hashing.smearedHash(v);
        int smearedHash2 = Hashing.smearedHash(k);
        BiEntry<K, V> seekByValue = seekByValue(v, smearedHash);
        BiEntry<K, V> seekByKey = seekByKey(k, smearedHash2);
        if (seekByValue != null && smearedHash2 == seekByValue.keyHash && Objects.equal(k, seekByValue.key)) {
            return k;
        }
        if (seekByKey != null && !z) {
            throw new IllegalArgumentException("key already present: " + k);
        }
        if (seekByValue != null) {
            delete(seekByValue);
        }
        if (seekByKey != null) {
            delete(seekByKey);
        }
        insert(new BiEntry<>(k, smearedHash2, v, smearedHash), seekByKey);
        if (seekByKey != null) {
            seekByKey.prevInKeyInsertionOrder = null;
            seekByKey.nextInKeyInsertionOrder = null;
        }
        if (seekByValue != null) {
            seekByValue.prevInKeyInsertionOrder = null;
            seekByValue.nextInKeyInsertionOrder = null;
        }
        rehashIfNecessary();
        return (K) Maps.keyOrNull(seekByValue);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readCount = Serialization.readCount(objectInputStream);
        init(16);
        Serialization.populateMap(this, objectInputStream, readCount);
    }

    private void rehashIfNecessary() {
        BiEntry<K, V>[] biEntryArr = this.hashTableKToV;
        if (Hashing.needsResizing(this.size, biEntryArr.length, 1.0d)) {
            int length = biEntryArr.length * 2;
            this.hashTableKToV = createTable(length);
            this.hashTableVToK = createTable(length);
            this.mask = length - 1;
            this.size = 0;
            for (BiEntry<K, V> biEntry = this.firstInKeyInsertionOrder; biEntry != null; biEntry = biEntry.nextInKeyInsertionOrder) {
                insert(biEntry, biEntry);
            }
            this.modCount++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BiEntry<K, V> seekByKey(@NullableDecl Object obj, int i) {
        for (BiEntry<K, V> biEntry = this.hashTableKToV[this.mask & i]; biEntry != null; biEntry = biEntry.nextInKToVBucket) {
            if (i == biEntry.keyHash && Objects.equal(obj, biEntry.key)) {
                return biEntry;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BiEntry<K, V> seekByValue(@NullableDecl Object obj, int i) {
        for (BiEntry<K, V> biEntry = this.hashTableVToK[this.mask & i]; biEntry != null; biEntry = biEntry.nextInVToKBucket) {
            if (i == biEntry.valueHash && Objects.equal(obj, biEntry.value)) {
                return biEntry;
            }
        }
        return null;
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMap(this, objectOutputStream);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        this.size = 0;
        Arrays.fill(this.hashTableKToV, (Object) null);
        Arrays.fill(this.hashTableVToK, (Object) null);
        this.firstInKeyInsertionOrder = null;
        this.lastInKeyInsertionOrder = null;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        if (seekByKey(obj, Hashing.smearedHash(obj)) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        if (seekByValue(obj, Hashing.smearedHash(obj)) != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.IteratorBasedAbstractMap
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new HashBiMap<K, V>.Itr<Map.Entry<K, V>>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.HashBiMap.1

            /* renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.HashBiMap$1$MapEntry */
            /* loaded from: classes10.dex */
            public class MapEntry extends AbstractMapEntry<K, V> {
                BiEntry<K, V> delegate;

                public MapEntry(BiEntry<K, V> biEntry) {
                    this.delegate = biEntry;
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public K getKey() {
                    return this.delegate.key;
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public V getValue() {
                    return this.delegate.value;
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public V setValue(V v) {
                    boolean z;
                    V v2 = this.delegate.value;
                    int smearedHash = Hashing.smearedHash(v);
                    if (smearedHash == this.delegate.valueHash && Objects.equal(v, v2)) {
                        return v;
                    }
                    if (HashBiMap.this.seekByValue(v, smearedHash) == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Preconditions.checkArgument(z, "value already present: %s", v);
                    HashBiMap.this.delete(this.delegate);
                    BiEntry<K, V> biEntry = this.delegate;
                    BiEntry<K, V> biEntry2 = new BiEntry<>(biEntry.key, biEntry.keyHash, v, smearedHash);
                    HashBiMap.this.insert(biEntry2, this.delegate);
                    BiEntry<K, V> biEntry3 = this.delegate;
                    biEntry3.prevInKeyInsertionOrder = null;
                    biEntry3.nextInKeyInsertionOrder = null;
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    anonymousClass1.expectedModCount = HashBiMap.this.modCount;
                    AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                    if (anonymousClass12.toRemove == this.delegate) {
                        anonymousClass12.toRemove = biEntry2;
                    }
                    this.delegate = biEntry2;
                    return v2;
                }
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.HashBiMap.Itr
            public Map.Entry<K, V> output(BiEntry<K, V> biEntry) {
                return new MapEntry(biEntry);
            }
        };
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        Preconditions.checkNotNull(biConsumer);
        for (BiEntry<K, V> biEntry = this.firstInKeyInsertionOrder; biEntry != null; biEntry = biEntry.nextInKeyInsertionOrder) {
            biConsumer.accept(biEntry.key, biEntry.value);
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    public V forcePut(@NullableDecl K k, @NullableDecl V v) {
        return put(k, v, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        return (V) Maps.valueOrNull(seekByKey(obj, Hashing.smearedHash(obj)));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.BiMap
    public BiMap<V, K> inverse() {
        BiMap<V, K> biMap = this.inverse;
        if (biMap == null) {
            Inverse inverse = new Inverse();
            this.inverse = inverse;
            return inverse;
        }
        return biMap;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        return new KeySet();
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    public V put(@NullableDecl K k, @NullableDecl V v) {
        return put(k, v, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object obj) {
        BiEntry<K, V> seekByKey = seekByKey(obj, Hashing.smearedHash(obj));
        if (seekByKey == null) {
            return null;
        }
        delete(seekByKey);
        seekByKey.prevInKeyInsertionOrder = null;
        seekByKey.nextInKeyInsertionOrder = null;
        return seekByKey.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        Object apply;
        Preconditions.checkNotNull(biFunction);
        clear();
        for (BiEntry<K, V> biEntry = this.firstInKeyInsertionOrder; biEntry != null; biEntry = biEntry.nextInKeyInsertionOrder) {
            K k = biEntry.key;
            apply = biFunction.apply(k, biEntry.value);
            put(k, apply);
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public static <K, V> HashBiMap<K, V> create(int i) {
        return new HashBiMap<>(i);
    }

    private V put(@NullableDecl K k, @NullableDecl V v, boolean z) {
        int smearedHash = Hashing.smearedHash(k);
        int smearedHash2 = Hashing.smearedHash(v);
        BiEntry<K, V> seekByKey = seekByKey(k, smearedHash);
        if (seekByKey != null && smearedHash2 == seekByKey.valueHash && Objects.equal(v, seekByKey.value)) {
            return v;
        }
        BiEntry<K, V> seekByValue = seekByValue(v, smearedHash2);
        if (seekByValue != null) {
            if (z) {
                delete(seekByValue);
            } else {
                throw new IllegalArgumentException("value already present: " + v);
            }
        }
        BiEntry<K, V> biEntry = new BiEntry<>(k, smearedHash, v, smearedHash2);
        if (seekByKey != null) {
            delete(seekByKey);
            insert(biEntry, seekByKey);
            seekByKey.prevInKeyInsertionOrder = null;
            seekByKey.nextInKeyInsertionOrder = null;
            rehashIfNecessary();
            return seekByKey.value;
        }
        insert(biEntry, null);
        rehashIfNecessary();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.BiMap
    public Set<V> values() {
        return inverse().keySet();
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }
}
