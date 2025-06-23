package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtIncompatible;
import java.util.Set;
import java.util.SortedSet;

@GwtIncompatible
/* loaded from: classes10.dex */
interface SortedMultisetBridge<E> extends Multiset<E> {
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multiset
    /* bridge */ /* synthetic */ Set elementSet();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multiset
    SortedSet<E> elementSet();
}
