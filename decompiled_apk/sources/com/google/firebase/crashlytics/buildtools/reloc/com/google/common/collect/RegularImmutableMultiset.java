package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.VisibleForTesting;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Objects;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Preconditions;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multiset;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multisets;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives.Ints;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.NullableDecl;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes10.dex */
public class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    static final ImmutableMultiset<Object> EMPTY = create(ImmutableList.of());

    @VisibleForTesting
    static final double HASH_FLOODING_FPP = 0.001d;

    @VisibleForTesting
    static final int MAX_HASH_BUCKET_LENGTH = 9;

    @VisibleForTesting
    static final double MAX_LOAD_FACTOR = 1.0d;

    @LazyInit
    private transient ImmutableSet<E> elementSet;
    private final transient Multisets.ImmutableEntry<E>[] entries;
    private final transient int hashCode;

    @NullableDecl
    private final transient Multisets.ImmutableEntry<E>[] hashTable;
    private final transient int size;

    /* loaded from: classes10.dex */
    public static final class NonTerminalEntry<E> extends Multisets.ImmutableEntry<E> {
        private final Multisets.ImmutableEntry<E> nextInBucket;

        public NonTerminalEntry(E e, int i, Multisets.ImmutableEntry<E> immutableEntry) {
            super(e, i);
            this.nextInBucket = immutableEntry;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multisets.ImmutableEntry
        public Multisets.ImmutableEntry<E> nextInBucket() {
            return this.nextInBucket;
        }
    }

    private RegularImmutableMultiset(Multisets.ImmutableEntry<E>[] immutableEntryArr, Multisets.ImmutableEntry<E>[] immutableEntryArr2, int i, int i2, ImmutableSet<E> immutableSet) {
        this.entries = immutableEntryArr;
        this.hashTable = immutableEntryArr2;
        this.size = i;
        this.hashCode = i2;
        this.elementSet = immutableSet;
    }

    public static <E> ImmutableMultiset<E> create(Collection<? extends Multiset.Entry<? extends E>> collection) {
        Multisets.ImmutableEntry nonTerminalEntry;
        int size = collection.size();
        Multisets.ImmutableEntry[] immutableEntryArr = new Multisets.ImmutableEntry[size];
        if (size == 0) {
            return new RegularImmutableMultiset(immutableEntryArr, null, 0, 0, ImmutableSet.of());
        }
        int closedTableSize = Hashing.closedTableSize(size, 1.0d);
        int i = closedTableSize - 1;
        Multisets.ImmutableEntry[] immutableEntryArr2 = new Multisets.ImmutableEntry[closedTableSize];
        int i2 = 0;
        long j = 0;
        int i3 = 0;
        for (Multiset.Entry<? extends E> entry : collection) {
            Object checkNotNull = Preconditions.checkNotNull(entry.getElement());
            int count = entry.getCount();
            int hashCode = checkNotNull.hashCode();
            int smear = Hashing.smear(hashCode) & i;
            Multisets.ImmutableEntry immutableEntry = immutableEntryArr2[smear];
            if (immutableEntry == null) {
                if ((entry instanceof Multisets.ImmutableEntry) && !(entry instanceof NonTerminalEntry)) {
                    nonTerminalEntry = (Multisets.ImmutableEntry) entry;
                } else {
                    nonTerminalEntry = new Multisets.ImmutableEntry(checkNotNull, count);
                }
            } else {
                nonTerminalEntry = new NonTerminalEntry(checkNotNull, count, immutableEntry);
            }
            i3 += hashCode ^ count;
            immutableEntryArr[i2] = nonTerminalEntry;
            immutableEntryArr2[smear] = nonTerminalEntry;
            j += count;
            i2++;
        }
        if (hashFloodingDetected(immutableEntryArr2)) {
            return JdkBackedImmutableMultiset.create(ImmutableList.asImmutableList(immutableEntryArr));
        }
        return new RegularImmutableMultiset(immutableEntryArr, immutableEntryArr2, Ints.saturatedCast(j), i3, null);
    }

    private static boolean hashFloodingDetected(Multisets.ImmutableEntry<?>[] immutableEntryArr) {
        for (Multisets.ImmutableEntry<?> immutableEntry : immutableEntryArr) {
            int i = 0;
            for (; immutableEntry != null; immutableEntry = immutableEntry.nextInBucket()) {
                i++;
                if (i > 9) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multiset
    public int count(@NullableDecl Object obj) {
        Multisets.ImmutableEntry<E>[] immutableEntryArr = this.hashTable;
        if (obj != null && immutableEntryArr != null) {
            for (Multisets.ImmutableEntry<E> immutableEntry = immutableEntryArr[Hashing.smearedHash(obj) & (immutableEntryArr.length - 1)]; immutableEntry != null; immutableEntry = immutableEntry.nextInBucket()) {
                if (Objects.equal(obj, immutableEntry.getElement())) {
                    return immutableEntry.getCount();
                }
            }
        }
        return 0;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset
    public Multiset.Entry<E> getEntry(int i) {
        return this.entries[i];
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, java.util.Collection, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multiset
    public int hashCode() {
        return this.hashCode;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multiset
    public int size() {
        return this.size;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multiset
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> immutableSet = this.elementSet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableMultiset.ElementSet elementSet = new ImmutableMultiset.ElementSet(Arrays.asList(this.entries), this);
        this.elementSet = elementSet;
        return elementSet;
    }
}
