package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: classes6.dex */
public abstract class I0Io<T> implements II0XooXoX<T> {

    /* renamed from: I0Io, reason: collision with root package name */
    public Future<T> f32677I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public ExecutorService f32678II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public ExecutorService f32679oIX0oI;

    /* loaded from: classes6.dex */
    public class oIX0oI implements Callable<T> {

        /* renamed from: XO, reason: collision with root package name */
        public final ExecutorService f32681XO;

        public oIX0oI(ExecutorService executorService) {
            this.f32681XO = executorService;
        }

        @Override // java.util.concurrent.Callable
        public T call() throws Exception {
            try {
                return (T) I0Io.this.Oxx0IOOO();
            } finally {
                ExecutorService executorService = this.f32681XO;
                if (executorService != null) {
                    executorService.shutdown();
                }
            }
        }
    }

    public I0Io() {
        this(null);
    }

    public final synchronized ExecutorService I0Io() {
        return this.f32678II0xO0;
    }

    public synchronized boolean II0XooXoX() {
        boolean z;
        if (this.f32677I0Io != null) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public final Callable<T> II0xO0(ExecutorService executorService) {
        return new oIX0oI(executorService);
    }

    public abstract T Oxx0IOOO() throws Exception;

    public synchronized Future<T> X0o0xo() {
        Future<T> future;
        future = this.f32677I0Io;
        if (future == null) {
            throw new IllegalStateException("start() must be called first!");
        }
        return future;
    }

    public int XO() {
        return 1;
    }

    @Override // org.apache.commons.lang3.concurrent.II0XooXoX
    public T get() throws ConcurrentException {
        try {
            return X0o0xo().get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ConcurrentException(e);
        } catch (ExecutionException e2) {
            xxIXOIIO.Oxx0IOOO(e2);
            return null;
        }
    }

    public final ExecutorService oIX0oI() {
        return Executors.newFixedThreadPool(XO());
    }

    public final synchronized ExecutorService oxoX() {
        return this.f32679oIX0oI;
    }

    public synchronized boolean xoIox() {
        ExecutorService executorService;
        try {
            if (!II0XooXoX()) {
                ExecutorService oxoX2 = oxoX();
                this.f32678II0xO0 = oxoX2;
                if (oxoX2 == null) {
                    executorService = oIX0oI();
                    this.f32678II0xO0 = executorService;
                } else {
                    executorService = null;
                }
                this.f32677I0Io = this.f32678II0xO0.submit(II0xO0(executorService));
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void xxIXOIIO(ExecutorService executorService) {
        if (!II0XooXoX()) {
            this.f32679oIX0oI = executorService;
        } else {
            throw new IllegalStateException("Cannot set ExecutorService after start()!");
        }
    }

    public I0Io(ExecutorService executorService) {
        xxIXOIIO(executorService);
    }
}
