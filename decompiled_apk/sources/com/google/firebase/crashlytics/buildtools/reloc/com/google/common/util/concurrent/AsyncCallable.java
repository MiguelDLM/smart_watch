package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.Beta;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;

@Beta
@GwtCompatible
@FunctionalInterface
/* loaded from: classes10.dex */
public interface AsyncCallable<V> {
    ListenableFuture<V> call() throws Exception;
}
