package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* loaded from: classes6.dex */
public class x0XOIxOo<I, O> implements Oxx0IOOO<I, O> {

    /* renamed from: I0Io, reason: collision with root package name */
    public final boolean f32727I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Oxx0IOOO<I, O> f32728II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final ConcurrentMap<I, Future<O>> f32729oIX0oI;

    public x0XOIxOo(Oxx0IOOO<I, O> oxx0IOOO) {
        this(oxx0IOOO, false);
    }

    public final /* synthetic */ Object I0Io(Object obj) throws Exception {
        return this.f32728II0xO0.oIX0oI(obj);
    }

    @Override // org.apache.commons.lang3.concurrent.Oxx0IOOO
    public O oIX0oI(final I i) throws InterruptedException {
        FutureTask futureTask;
        while (true) {
            Future<O> future = this.f32729oIX0oI.get(i);
            if (future == null && (future = this.f32729oIX0oI.putIfAbsent(i, (futureTask = new FutureTask(new Callable() { // from class: org.apache.commons.lang3.concurrent.ooOOo0oXI
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Object I0Io2;
                    I0Io2 = x0XOIxOo.this.I0Io(i);
                    return I0Io2;
                }
            })))) == null) {
                futureTask.run();
                future = futureTask;
            }
            try {
                continue;
                return future.get();
            } catch (CancellationException unused) {
                this.f32729oIX0oI.remove(i, future);
            } catch (ExecutionException e) {
                if (this.f32727I0Io) {
                    this.f32729oIX0oI.remove(i, future);
                }
                throw oxoX(e.getCause());
            }
        }
    }

    public final RuntimeException oxoX(Throwable th) {
        if (th instanceof RuntimeException) {
            return (RuntimeException) th;
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        throw new IllegalStateException("Unchecked exception", th);
    }

    public x0XOIxOo(Oxx0IOOO<I, O> oxx0IOOO, boolean z) {
        this.f32729oIX0oI = new ConcurrentHashMap();
        this.f32728II0xO0 = oxx0IOOO;
        this.f32727I0Io = z;
    }
}
