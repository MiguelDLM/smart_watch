package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public class X0o0xo<T> extends I0Io<T> {

    /* renamed from: oxoX, reason: collision with root package name */
    public final Callable<T> f32706oxoX;

    public X0o0xo(Callable<T> callable) {
        OOXIXo(callable);
        this.f32706oxoX = callable;
    }

    public final void OOXIXo(Callable<T> callable) {
        xoIxX.xo0x(callable, "Callable must not be null!", new Object[0]);
    }

    @Override // org.apache.commons.lang3.concurrent.I0Io
    public T Oxx0IOOO() throws Exception {
        return this.f32706oxoX.call();
    }

    public X0o0xo(Callable<T> callable, ExecutorService executorService) {
        super(executorService);
        OOXIXo(callable);
        this.f32706oxoX = callable;
    }
}
