package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.concurrent;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes10.dex */
public class BasicFuture<T> implements Future<T>, Cancellable {
    private final FutureCallback<T> callback;
    private volatile boolean cancelled;
    private volatile boolean completed;
    private volatile Exception ex;
    private volatile T result;

    public BasicFuture(FutureCallback<T> futureCallback) {
        this.callback = futureCallback;
    }

    private T getResult() throws ExecutionException {
        if (this.ex == null) {
            if (!this.cancelled) {
                return this.result;
            }
            throw new CancellationException();
        }
        throw new ExecutionException(this.ex);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        synchronized (this) {
            try {
                if (this.completed) {
                    return false;
                }
                this.completed = true;
                this.cancelled = true;
                notifyAll();
                FutureCallback<T> futureCallback = this.callback;
                if (futureCallback != null) {
                    futureCallback.cancelled();
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean completed(T t) {
        synchronized (this) {
            try {
                if (this.completed) {
                    return false;
                }
                this.completed = true;
                this.result = t;
                notifyAll();
                FutureCallback<T> futureCallback = this.callback;
                if (futureCallback != null) {
                    futureCallback.completed(t);
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean failed(Exception exc) {
        synchronized (this) {
            try {
                if (this.completed) {
                    return false;
                }
                this.completed = true;
                this.ex = exc;
                notifyAll();
                FutureCallback<T> futureCallback = this.callback;
                if (futureCallback != null) {
                    futureCallback.failed(exc);
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Future
    public synchronized T get() throws InterruptedException, ExecutionException {
        while (!this.completed) {
            try {
                wait();
            } catch (Throwable th) {
                throw th;
            }
        }
        return getResult();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.completed;
    }

    @Override // java.util.concurrent.Future
    public synchronized T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        Args.notNull(timeUnit, "Time unit");
        long millis = timeUnit.toMillis(j);
        long currentTimeMillis = millis <= 0 ? 0L : System.currentTimeMillis();
        if (this.completed) {
            return getResult();
        }
        if (millis > 0) {
            long j2 = millis;
            do {
                wait(j2);
                if (this.completed) {
                    return getResult();
                }
                j2 = millis - (System.currentTimeMillis() - currentTimeMillis);
            } while (j2 > 0);
            throw new TimeoutException();
        }
        throw new TimeoutException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.concurrent.Cancellable
    public boolean cancel() {
        return cancel(true);
    }
}
