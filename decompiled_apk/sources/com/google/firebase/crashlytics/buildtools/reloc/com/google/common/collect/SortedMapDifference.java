package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.MapDifference;
import java.util.Map;
import java.util.SortedMap;

@GwtCompatible
/* loaded from: classes10.dex */
public interface SortedMapDifference<K, V> extends MapDifference<K, V> {
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.MapDifference
    /* bridge */ /* synthetic */ Map entriesDiffering();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.MapDifference
    SortedMap<K, MapDifference.ValueDifference<V>> entriesDiffering();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.MapDifference
    /* bridge */ /* synthetic */ Map entriesInCommon();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.MapDifference
    SortedMap<K, V> entriesInCommon();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.MapDifference
    /* bridge */ /* synthetic */ Map entriesOnlyOnLeft();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.MapDifference
    SortedMap<K, V> entriesOnlyOnLeft();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.MapDifference
    /* bridge */ /* synthetic */ Map entriesOnlyOnRight();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.MapDifference
    SortedMap<K, V> entriesOnlyOnRight();
}
