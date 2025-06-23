package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.pool;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.concurrent.FutureCallback;
import java.util.concurrent.Future;

/* loaded from: classes10.dex */
public interface ConnPool<T, E> {
    Future<E> lease(T t, Object obj, FutureCallback<E> futureCallback);

    void release(E e, boolean z);
}
