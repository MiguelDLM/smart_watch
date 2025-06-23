package org.apache.commons.lang3.concurrent;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public class xxIXOIIO {

    /* loaded from: classes6.dex */
    public static final class oIX0oI<T> implements Future<T> {

        /* renamed from: XO, reason: collision with root package name */
        public final T f32735XO;

        public oIX0oI(T t) {
            this.f32735XO = t;
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return false;
        }

        @Override // java.util.concurrent.Future
        public T get() {
            return this.f32735XO;
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return false;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return true;
        }

        @Override // java.util.concurrent.Future
        public T get(long j, TimeUnit timeUnit) {
            return this.f32735XO;
        }
    }

    public static <K, V> V I0Io(ConcurrentMap<K, V> concurrentMap, K k, II0XooXoX<V> iI0XooXoX) throws ConcurrentException {
        if (concurrentMap != null && iI0XooXoX != null) {
            V v = concurrentMap.get(k);
            if (v == null) {
                return (V) OOXIXo(concurrentMap, k, iI0XooXoX.get());
            }
            return v;
        }
        return null;
    }

    public static void II0XooXoX(ExecutionException executionException) {
        ConcurrentRuntimeException XO2 = XO(executionException);
        if (XO2 == null) {
        } else {
            throw XO2;
        }
    }

    public static <T> Future<T> II0xO0(T t) {
        return new oIX0oI(t);
    }

    public static <K, V> V OOXIXo(ConcurrentMap<K, V> concurrentMap, K k, V v) {
        if (concurrentMap == null) {
            return null;
        }
        V putIfAbsent = concurrentMap.putIfAbsent(k, v);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        return v;
    }

    public static void Oxx0IOOO(ExecutionException executionException) throws ConcurrentException {
        ConcurrentException X0o0xo2 = X0o0xo(executionException);
        if (X0o0xo2 == null) {
        } else {
            throw X0o0xo2;
        }
    }

    public static ConcurrentException X0o0xo(ExecutionException executionException) {
        if (executionException != null && executionException.getCause() != null) {
            oOoXoXO(executionException);
            return new ConcurrentException(executionException.getMessage(), executionException.getCause());
        }
        return null;
    }

    public static ConcurrentRuntimeException XO(ExecutionException executionException) {
        if (executionException != null && executionException.getCause() != null) {
            oOoXoXO(executionException);
            return new ConcurrentRuntimeException(executionException.getMessage(), executionException.getCause());
        }
        return null;
    }

    public static Throwable oIX0oI(Throwable th) {
        boolean z;
        if (th != null && !(th instanceof RuntimeException) && !(th instanceof Error)) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, "Not a checked exception: " + th, new Object[0]);
        return th;
    }

    public static void oOoXoXO(ExecutionException executionException) {
        if (!(executionException.getCause() instanceof RuntimeException)) {
            if (!(executionException.getCause() instanceof Error)) {
                return;
            } else {
                throw ((Error) executionException.getCause());
            }
        }
        throw ((RuntimeException) executionException.getCause());
    }

    public static <K, V> V oxoX(ConcurrentMap<K, V> concurrentMap, K k, II0XooXoX<V> iI0XooXoX) {
        try {
            return (V) I0Io(concurrentMap, k, iI0XooXoX);
        } catch (ConcurrentException e) {
            throw new ConcurrentRuntimeException(e.getCause());
        }
    }

    public static <T> T xoIox(II0XooXoX<T> iI0XooXoX) {
        try {
            return (T) xxIXOIIO(iI0XooXoX);
        } catch (ConcurrentException e) {
            throw new ConcurrentRuntimeException(e.getCause());
        }
    }

    public static <T> T xxIXOIIO(II0XooXoX<T> iI0XooXoX) throws ConcurrentException {
        if (iI0XooXoX != null) {
            return iI0XooXoX.get();
        }
        return null;
    }
}
