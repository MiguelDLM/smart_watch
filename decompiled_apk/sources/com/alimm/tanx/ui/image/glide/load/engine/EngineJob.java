package com.alimm.tanx.ui.image.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alimm.tanx.ui.image.glide.load.Key;
import com.alimm.tanx.ui.image.glide.load.engine.EngineRunnable;
import com.alimm.tanx.ui.image.glide.request.ResourceCallback;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
class EngineJob implements EngineRunnable.EngineRunnableManager {
    private static final EngineResourceFactory DEFAULT_FACTORY = new EngineResourceFactory();
    private static final Handler MAIN_THREAD_HANDLER = new Handler(Looper.getMainLooper(), new MainThreadCallback(null));
    private static final int MSG_COMPLETE = 1;
    private static final int MSG_EXCEPTION = 2;
    private final List<ResourceCallback> cbs;
    private final ExecutorService diskCacheService;
    private EngineResource<?> engineResource;
    private final EngineResourceFactory engineResourceFactory;
    private EngineRunnable engineRunnable;
    private Exception exception;
    private volatile Future<?> future;
    private boolean hasException;
    private boolean hasResource;
    private Set<ResourceCallback> ignoredCallbacks;
    private final boolean isCacheable;
    private boolean isCancelled;
    private final Key key;
    private final EngineJobListener listener;
    private Resource<?> resource;
    private final ExecutorService sourceService;

    /* loaded from: classes.dex */
    public static class EngineResourceFactory {
        public <R> EngineResource<R> build(Resource<R> resource, boolean z) {
            return new EngineResource<>(resource, z);
        }
    }

    /* loaded from: classes.dex */
    public static class MainThreadCallback implements Handler.Callback {
        private MainThreadCallback() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (1 != i && 2 != i) {
                return false;
            }
            EngineJob engineJob = (EngineJob) message.obj;
            if (1 == i) {
                engineJob.handleResultOnMainThread();
            } else {
                engineJob.handleExceptionOnMainThread();
            }
            return true;
        }

        public /* synthetic */ MainThreadCallback(AnonymousClass1 anonymousClass1) {
        }
    }

    public EngineJob(Key key, ExecutorService executorService, ExecutorService executorService2, boolean z, EngineJobListener engineJobListener) {
        this(key, executorService, executorService2, z, engineJobListener, DEFAULT_FACTORY);
    }

    private void addIgnoredCallback(ResourceCallback resourceCallback) {
        if (this.ignoredCallbacks == null) {
            this.ignoredCallbacks = new HashSet();
        }
        this.ignoredCallbacks.add(resourceCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleExceptionOnMainThread() {
        if (this.isCancelled) {
            return;
        }
        if (!this.cbs.isEmpty()) {
            this.hasException = true;
            this.listener.onEngineJobComplete(this.key, null);
            for (ResourceCallback resourceCallback : this.cbs) {
                if (!isInIgnoredCallbacks(resourceCallback)) {
                    resourceCallback.onException(this.exception);
                }
            }
            return;
        }
        throw new IllegalStateException("Received an exception without any callbacks to notify");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleResultOnMainThread() {
        if (this.isCancelled) {
            this.resource.recycle();
            return;
        }
        if (!this.cbs.isEmpty()) {
            EngineResource<?> build = this.engineResourceFactory.build(this.resource, this.isCacheable);
            this.engineResource = build;
            this.hasResource = true;
            build.acquire();
            this.listener.onEngineJobComplete(this.key, this.engineResource);
            for (ResourceCallback resourceCallback : this.cbs) {
                if (!isInIgnoredCallbacks(resourceCallback)) {
                    this.engineResource.acquire();
                    resourceCallback.onResourceReady(this.engineResource);
                }
            }
            this.engineResource.release();
            return;
        }
        throw new IllegalStateException("Received a resource without any callbacks to notify");
    }

    private boolean isInIgnoredCallbacks(ResourceCallback resourceCallback) {
        Set<ResourceCallback> set = this.ignoredCallbacks;
        if (set != null && set.contains(resourceCallback)) {
            return true;
        }
        return false;
    }

    public void addCallback(ResourceCallback resourceCallback) {
        Util.assertMainThread();
        if (this.hasResource) {
            resourceCallback.onResourceReady(this.engineResource);
        } else if (this.hasException) {
            resourceCallback.onException(this.exception);
        } else {
            this.cbs.add(resourceCallback);
        }
    }

    public void cancel() {
        if (!this.hasException && !this.hasResource && !this.isCancelled) {
            this.engineRunnable.cancel();
            Future<?> future = this.future;
            if (future != null) {
                future.cancel(true);
            }
            this.isCancelled = true;
            this.listener.onEngineJobCancelled(this, this.key);
        }
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.ResourceCallback
    public void onException(Exception exc) {
        this.exception = exc;
        MAIN_THREAD_HANDLER.obtainMessage(2, this).sendToTarget();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.ResourceCallback
    public void onResourceReady(Resource<?> resource) {
        this.resource = resource;
        MAIN_THREAD_HANDLER.obtainMessage(1, this).sendToTarget();
    }

    public void removeCallback(ResourceCallback resourceCallback) {
        Util.assertMainThread();
        if (!this.hasResource && !this.hasException) {
            this.cbs.remove(resourceCallback);
            if (this.cbs.isEmpty()) {
                cancel();
                return;
            }
            return;
        }
        addIgnoredCallback(resourceCallback);
    }

    public void start(EngineRunnable engineRunnable) {
        this.engineRunnable = engineRunnable;
        this.future = this.diskCacheService.submit(engineRunnable);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.EngineRunnable.EngineRunnableManager
    public void submitForSource(EngineRunnable engineRunnable) {
        this.future = this.sourceService.submit(engineRunnable);
    }

    public EngineJob(Key key, ExecutorService executorService, ExecutorService executorService2, boolean z, EngineJobListener engineJobListener, EngineResourceFactory engineResourceFactory) {
        this.cbs = new ArrayList();
        this.key = key;
        this.diskCacheService = executorService;
        this.sourceService = executorService2;
        this.isCacheable = z;
        this.listener = engineJobListener;
        this.engineResourceFactory = engineResourceFactory;
    }
}
