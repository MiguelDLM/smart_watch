package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtIncompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.VisibleForTesting;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Preconditions;
import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import com.szabh.smable3.entity.BleWatchFaceId;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@GwtIncompatible
/* loaded from: classes10.dex */
class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    private static final int ENDPOINT = -2;
    private final boolean accessOrder;
    private transient int firstEntry;
    private transient int lastEntry;

    @VisibleForTesting
    @MonotonicNonNullDecl
    transient long[] links;

    public CompactLinkedHashMap() {
        this(3);
    }

    public static <K, V> CompactLinkedHashMap<K, V> create() {
        return new CompactLinkedHashMap<>();
    }

    public static <K, V> CompactLinkedHashMap<K, V> createWithExpectedSize(int i) {
        return new CompactLinkedHashMap<>(i);
    }

    private int getPredecessor(int i) {
        return (int) (this.links[i] >>> 32);
    }

    private void setPredecessor(int i, int i2) {
        long[] jArr = this.links;
        jArr[i] = (jArr[i] & BleWatchFaceId.WATCHFACE_ID_INVALID) | (i2 << 32);
    }

    private void setSucceeds(int i, int i2) {
        if (i == -2) {
            this.firstEntry = i2;
        } else {
            setSuccessor(i, i2);
        }
        if (i2 == -2) {
            this.lastEntry = i;
        } else {
            setPredecessor(i2, i);
        }
    }

    private void setSuccessor(int i, int i2) {
        long[] jArr = this.links;
        jArr[i] = (jArr[i] & (-4294967296L)) | (i2 & BleWatchFaceId.WATCHFACE_ID_INVALID);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactHashMap
    public void accessEntry(int i) {
        if (this.accessOrder) {
            setSucceeds(getPredecessor(i), getSuccessor(i));
            setSucceeds(this.lastEntry, i);
            setSucceeds(i, -2);
            this.modCount++;
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactHashMap
    public int adjustAfterRemove(int i, int i2) {
        if (i >= size()) {
            return i2;
        }
        return i;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactHashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        super.clear();
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactHashMap
    public Set<Map.Entry<K, V>> createEntrySet() {
        return new CompactHashMap<K, V>.EntrySetView() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactLinkedHashMap.1EntrySetImpl
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactHashMap.EntrySetView, java.util.Collection, java.lang.Iterable, java.util.Set
            public Spliterator<Map.Entry<K, V>> spliterator() {
                Spliterator<Map.Entry<K, V>> spliterator;
                spliterator = Spliterators.spliterator(this, 17);
                return spliterator;
            }
        };
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactHashMap
    public Set<K> createKeySet() {
        return new CompactHashMap<K, V>.KeySetView() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactLinkedHashMap.1KeySetImpl
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactHashMap.KeySetView, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.KeySet, java.lang.Iterable
            public void forEach(Consumer<? super K> consumer) {
                Preconditions.checkNotNull(consumer);
                int i = CompactLinkedHashMap.this.firstEntry;
                while (i != -2) {
                    consumer.accept(CompactLinkedHashMap.this.keys[i]);
                    i = CompactLinkedHashMap.this.getSuccessor(i);
                }
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactHashMap.KeySetView, java.util.Collection, java.lang.Iterable, java.util.Set
            public Spliterator<K> spliterator() {
                Spliterator<K> spliterator;
                spliterator = Spliterators.spliterator(this, 17);
                return spliterator;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactHashMap.KeySetView, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public Object[] toArray() {
                return ObjectArrays.toArrayImpl(this);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactHashMap.KeySetView, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public <T> T[] toArray(T[] tArr) {
                return (T[]) ObjectArrays.toArrayImpl(this, tArr);
            }
        };
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactHashMap
    public Collection<V> createValues() {
        return new CompactHashMap<K, V>.ValuesView() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactLinkedHashMap.1ValuesImpl
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactHashMap.ValuesView, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.Values, java.lang.Iterable
            public void forEach(Consumer<? super V> consumer) {
                Preconditions.checkNotNull(consumer);
                int i = CompactLinkedHashMap.this.firstEntry;
                while (i != -2) {
                    consumer.accept(CompactLinkedHashMap.this.values[i]);
                    i = CompactLinkedHashMap.this.getSuccessor(i);
                }
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactHashMap.ValuesView, java.util.Collection, java.lang.Iterable
            public Spliterator<V> spliterator() {
                Spliterator<V> spliterator;
                spliterator = Spliterators.spliterator(this, 16);
                return spliterator;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactHashMap.ValuesView, java.util.AbstractCollection, java.util.Collection
            public Object[] toArray() {
                return ObjectArrays.toArrayImpl(this);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactHashMap.ValuesView, java.util.AbstractCollection, java.util.Collection
            public <T> T[] toArray(T[] tArr) {
                return (T[]) ObjectArrays.toArrayImpl(this, tArr);
            }
        };
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactHashMap
    public int firstEntryIndex() {
        return this.firstEntry;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactHashMap, java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        Preconditions.checkNotNull(biConsumer);
        int i = this.firstEntry;
        while (i != -2) {
            biConsumer.accept(this.keys[i], this.values[i]);
            i = getSuccessor(i);
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactHashMap
    public int getSuccessor(int i) {
        return (int) this.links[i];
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactHashMap
    public void init(int i, float f) {
        super.init(i, f);
        this.firstEntry = -2;
        this.lastEntry = -2;
        long[] jArr = new long[i];
        this.links = jArr;
        Arrays.fill(jArr, -1L);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactHashMap
    public void insertEntry(int i, K k, V v, int i2) {
        super.insertEntry(i, k, v, i2);
        setSucceeds(this.lastEntry, i);
        setSucceeds(i, -2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactHashMap
    public void moveLastEntry(int i) {
        int size = size() - 1;
        setSucceeds(getPredecessor(i), getSuccessor(i));
        if (i < size) {
            setSucceeds(getPredecessor(size), i);
            setSucceeds(i, getSuccessor(size));
        }
        super.moveLastEntry(i);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CompactHashMap
    public void resizeEntries(int i) {
        super.resizeEntries(i);
        this.links = Arrays.copyOf(this.links, i);
    }

    public CompactLinkedHashMap(int i) {
        this(i, 1.0f, false);
    }

    public CompactLinkedHashMap(int i, float f, boolean z) {
        super(i, f);
        this.accessOrder = z;
    }
}
