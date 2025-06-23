package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.Beta;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtIncompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Preconditions;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.Exception;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
@Deprecated
@GwtIncompatible
/* loaded from: classes10.dex */
public abstract class ForwardingCheckedFuture<V, X extends Exception> extends ForwardingListenableFuture<V> implements CheckedFuture<V, X> {
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.CheckedFuture
    @CanIgnoreReturnValue
    public V checkedGet() throws Exception {
        return delegate().checkedGet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.ForwardingListenableFuture, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.ForwardingFuture, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ForwardingObject
    public abstract CheckedFuture<V, X> delegate();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.CheckedFuture
    @CanIgnoreReturnValue
    public V checkedGet(long j, TimeUnit timeUnit) throws TimeoutException, Exception {
        return delegate().checkedGet(j, timeUnit);
    }

    @Beta
    @Deprecated
    /* loaded from: classes10.dex */
    public static abstract class SimpleForwardingCheckedFuture<V, X extends Exception> extends ForwardingCheckedFuture<V, X> {
        private final CheckedFuture<V, X> delegate;

        public SimpleForwardingCheckedFuture(CheckedFuture<V, X> checkedFuture) {
            this.delegate = (CheckedFuture) Preconditions.checkNotNull(checkedFuture);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.ForwardingCheckedFuture, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.ForwardingListenableFuture, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.ForwardingFuture, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ForwardingObject
        public final CheckedFuture<V, X> delegate() {
            return this.delegate;
        }
    }
}
