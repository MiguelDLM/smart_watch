package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
/* loaded from: classes10.dex */
public interface RowSortedTable<R, C, V> extends Table<R, C, V> {
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Table
    /* bridge */ /* synthetic */ Set rowKeySet();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Table
    SortedSet<R> rowKeySet();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Table
    /* bridge */ /* synthetic */ Map rowMap();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Table
    SortedMap<R, Map<C, V>> rowMap();
}
