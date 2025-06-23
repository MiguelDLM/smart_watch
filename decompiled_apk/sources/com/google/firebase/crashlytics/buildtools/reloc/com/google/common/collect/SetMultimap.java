package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.NullableDecl;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@GwtCompatible
/* loaded from: classes10.dex */
public interface SetMultimap<K, V> extends Multimap<K, V> {
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ListMultimap
    Map<K, Collection<V>> asMap();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multimap
    /* bridge */ /* synthetic */ Collection entries();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multimap
    Set<Map.Entry<K, V>> entries();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ListMultimap
    boolean equals(@NullableDecl Object obj);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ListMultimap
    /* bridge */ /* synthetic */ Collection get(@NullableDecl Object obj);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ListMultimap
    Set<V> get(@NullableDecl K k);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Collection removeAll(@NullableDecl Object obj);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    Set<V> removeAll(@NullableDecl Object obj);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    Set<V> replaceValues(K k, Iterable<? extends V> iterable);
}
