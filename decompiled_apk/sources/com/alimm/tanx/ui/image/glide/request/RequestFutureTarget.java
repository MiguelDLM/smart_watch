package com.alimm.tanx.ui.image.glide.request;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation;
import com.alimm.tanx.ui.image.glide.request.target.SizeReadyCallback;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class RequestFutureTarget<T, R> implements FutureTarget<R>, Runnable {
    private static final Waiter DEFAULT_WAITER = new Waiter();
    private final boolean assertBackgroundThread;
    private Exception exception;
    private boolean exceptionReceived;
    private final int height;
    private boolean isCancelled;
    private final Handler mainHandler;
    private Request request;
    private R resource;
    private boolean resultReceived;
    private final Waiter waiter;
    private final int width;

    /* loaded from: classes.dex */
    public static class Waiter {
        public void notifyAll(Object obj) {
            obj.notifyAll();
        }

        public void waitForTimeout(Object obj, long j) throws InterruptedException {
            obj.wait(j);
        }
    }

    public RequestFutureTarget(Handler handler, int i, int i2) {
        this(handler, i, i2, true, DEFAULT_WAITER);
    }

    private synchronized R doGet(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        try {
            if (this.assertBackgroundThread) {
                Util.assertBackgroundThread();
            }
            if (!this.isCancelled) {
                if (!this.exceptionReceived) {
                    if (this.resultReceived) {
                        return this.resource;
                    }
                    if (l == null) {
                        this.waiter.waitForTimeout(this, 0L);
                    } else if (l.longValue() > 0) {
                        this.waiter.waitForTimeout(this, l.longValue());
                    }
                    if (!Thread.interrupted()) {
                        if (!this.exceptionReceived) {
                            if (!this.isCancelled) {
                                if (this.resultReceived) {
                                    return this.resource;
                                }
                                throw new TimeoutException();
                            }
                            throw new CancellationException();
                        }
                        throw new ExecutionException(this.exception);
                    }
                    throw new InterruptedException();
                }
                throw new ExecutionException(this.exception);
            }
            throw new CancellationException();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        try {
            if (this.isCancelled) {
                return true;
            }
            boolean isDone = isDone();
            boolean z2 = !isDone;
            if (!isDone) {
                this.isCancelled = true;
                if (z) {
                    clear();
                }
                this.waiter.notifyAll(this);
            }
            return z2;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.request.FutureTarget
    public void clear() {
        this.mainHandler.post(this);
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        try {
            return doGet(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public Request getRequest() {
        return this.request;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void getSize(SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.width, this.height);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.isCancelled;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.isCancelled) {
            if (!this.resultReceived) {
                z = false;
            }
        }
        z = true;
        return z;
    }

    @Override // com.alimm.tanx.ui.image.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public synchronized void onLoadFailed(Exception exc, Drawable drawable) {
        this.exceptionReceived = true;
        this.exception = exc;
        this.waiter.notifyAll(this);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public synchronized void onResourceReady(R r, GlideAnimation<? super R> glideAnimation) {
        this.resultReceived = true;
        this.resource = r;
        this.waiter.notifyAll(this);
    }

    @Override // com.alimm.tanx.ui.image.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.alimm.tanx.ui.image.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // java.lang.Runnable
    public void run() {
        Request request = this.request;
        if (request != null) {
            request.clear();
            cancel(false);
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void setRequest(Request request) {
        this.request = request;
    }

    public RequestFutureTarget(Handler handler, int i, int i2, boolean z, Waiter waiter) {
        this.mainHandler = handler;
        this.width = i;
        this.height = i2;
        this.assertBackgroundThread = z;
        this.waiter = waiter;
    }

    @Override // java.util.concurrent.Future
    public R get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return doGet(Long.valueOf(timeUnit.toMillis(j)));
    }
}
