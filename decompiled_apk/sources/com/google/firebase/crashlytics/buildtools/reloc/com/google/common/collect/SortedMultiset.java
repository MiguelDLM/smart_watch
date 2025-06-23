package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multiset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public interface SortedMultiset<E> extends SortedMultisetBridge<E>, SortedIterable<E> {
    Comparator<? super E> comparator();

    SortedMultiset<E> descendingMultiset();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.SortedMultisetBridge, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multiset
    NavigableSet<E> elementSet();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.SortedMultisetBridge, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multiset
    /* bridge */ /* synthetic */ Set elementSet();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.SortedMultisetBridge, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multiset
    /* bridge */ /* synthetic */ SortedSet elementSet();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multiset
    Set<Multiset.Entry<E>> entrySet();

    Multiset.Entry<E> firstEntry();

    SortedMultiset<E> headMultiset(E e, BoundType boundType);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multiset, java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    Multiset.Entry<E> lastEntry();

    Multiset.Entry<E> pollFirstEntry();

    Multiset.Entry<E> pollLastEntry();

    SortedMultiset<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2);

    SortedMultiset<E> tailMultiset(E e, BoundType boundType);
}
