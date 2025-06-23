package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.errorprone.annotations.CanIgnoreReturnValue;

@GwtCompatible
@FunctionalInterface
/* loaded from: classes10.dex */
public interface Supplier<T> extends java.util.function.Supplier<T> {
    @Override // java.util.function.Supplier
    @CanIgnoreReturnValue
    T get();
}
