package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps;
import java.util.function.BinaryOperator;

/* loaded from: classes10.dex */
public final /* synthetic */ class I00O implements BinaryOperator {
    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return ((Maps.Accumulator) obj).combine((Maps.Accumulator) obj2);
    }
}
