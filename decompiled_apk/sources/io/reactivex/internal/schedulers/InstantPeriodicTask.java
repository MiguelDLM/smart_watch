package io.reactivex.internal.schedulers;

import androidx.lifecycle.Oxx0IOOO;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class InstantPeriodicTask implements Callable<Void>, Disposable {
    static final FutureTask<Void> CANCELLED = new FutureTask<>(Functions.EMPTY_RUNNABLE, null);
    final ExecutorService executor;
    final AtomicReference<Future<?>> first = new AtomicReference<>();
    final AtomicReference<Future<?>> rest = new AtomicReference<>();
    Thread runner;
    final Runnable task;

    public InstantPeriodicTask(Runnable runnable, ExecutorService executorService) {
        this.task = runnable;
        this.executor = executorService;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        boolean z;
        AtomicReference<Future<?>> atomicReference = this.first;
        FutureTask<Void> futureTask = CANCELLED;
        Future<?> andSet = atomicReference.getAndSet(futureTask);
        boolean z2 = false;
        if (andSet != null && andSet != futureTask) {
            if (this.runner != Thread.currentThread()) {
                z = true;
            } else {
                z = false;
            }
            andSet.cancel(z);
        }
        Future<?> andSet2 = this.rest.getAndSet(futureTask);
        if (andSet2 != null && andSet2 != futureTask) {
            if (this.runner != Thread.currentThread()) {
                z2 = true;
            }
            andSet2.cancel(z2);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.first.get() == CANCELLED) {
            return true;
        }
        return false;
    }

    public void setFirst(Future<?> future) {
        Future<?> future2;
        boolean z;
        do {
            future2 = this.first.get();
            if (future2 == CANCELLED) {
                if (this.runner != Thread.currentThread()) {
                    z = true;
                } else {
                    z = false;
                }
                future.cancel(z);
                return;
            }
        } while (!Oxx0IOOO.oIX0oI(this.first, future2, future));
    }

    public void setRest(Future<?> future) {
        Future<?> future2;
        boolean z;
        do {
            future2 = this.rest.get();
            if (future2 == CANCELLED) {
                if (this.runner != Thread.currentThread()) {
                    z = true;
                } else {
                    z = false;
                }
                future.cancel(z);
                return;
            }
        } while (!Oxx0IOOO.oIX0oI(this.rest, future2, future));
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.runner = Thread.currentThread();
        try {
            this.task.run();
            setRest(this.executor.submit(this));
            this.runner = null;
        } catch (Throwable th) {
            this.runner = null;
            RxJavaPlugins.onError(th);
        }
        return null;
    }
}
