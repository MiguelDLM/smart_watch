package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: classes10.dex */
interface FilteredSetMultimap<K, V> extends FilteredMultimap<K, V>, SetMultimap<K, V> {
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.FilteredMultimap
    /* bridge */ /* synthetic */ Multimap unfiltered();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.FilteredMultimap
    SetMultimap<K, V> unfiltered();
}
