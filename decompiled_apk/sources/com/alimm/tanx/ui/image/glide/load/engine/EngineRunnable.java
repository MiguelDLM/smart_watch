package com.alimm.tanx.ui.image.glide.load.engine;

import android.util.Log;
import com.alimm.tanx.ui.image.glide.Priority;
import com.alimm.tanx.ui.image.glide.load.engine.executor.Prioritized;
import com.alimm.tanx.ui.image.glide.request.ResourceCallback;

/* loaded from: classes.dex */
class EngineRunnable implements Runnable, Prioritized {
    private static final String TAG = "EngineRunnable";
    private final DecodeJob<?, ?, ?> decodeJob;
    private volatile boolean isCancelled;
    private final EngineRunnableManager manager;
    private final Priority priority;
    private Stage stage = Stage.CACHE;

    /* loaded from: classes.dex */
    public interface EngineRunnableManager extends ResourceCallback {
        void submitForSource(EngineRunnable engineRunnable);
    }

    /* loaded from: classes.dex */
    public enum Stage {
        CACHE,
        SOURCE
    }

    public EngineRunnable(EngineRunnableManager engineRunnableManager, DecodeJob<?, ?, ?> decodeJob, Priority priority) {
        this.manager = engineRunnableManager;
        this.decodeJob = decodeJob;
        this.priority = priority;
    }

    private Resource<?> decode() throws Exception {
        if (isDecodingFromCache()) {
            return decodeFromCache();
        }
        return decodeFromSource();
    }

    private Resource<?> decodeFromCache() throws Exception {
        Resource<?> resource;
        try {
            resource = this.decodeJob.decodeResultFromCache();
        } catch (Exception e) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Exception decoding result from cache: " + e);
            }
            resource = null;
        }
        if (resource == null) {
            return this.decodeJob.decodeSourceFromCache();
        }
        return resource;
    }

    private Resource<?> decodeFromSource() throws Exception {
        return this.decodeJob.decodeFromSource();
    }

    private boolean isDecodingFromCache() {
        if (this.stage == Stage.CACHE) {
            return true;
        }
        return false;
    }

    private void onLoadComplete(Resource resource) {
        this.manager.onResourceReady(resource);
    }

    private void onLoadFailed(Exception exc) {
        if (isDecodingFromCache()) {
            this.stage = Stage.SOURCE;
            this.manager.submitForSource(this);
        } else {
            this.manager.onException(exc);
        }
    }

    public void cancel() {
        this.isCancelled = true;
        this.decodeJob.cancel();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.executor.Prioritized
    public int getPriority() {
        return this.priority.ordinal();
    }

    @Override // java.lang.Runnable
    public void run() {
        Exception errorWrappingGlideException;
        if (this.isCancelled) {
            return;
        }
        Resource<?> resource = null;
        try {
            resource = decode();
            errorWrappingGlideException = null;
        } catch (Exception e) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Exception decoding", e);
            }
            errorWrappingGlideException = e;
        } catch (OutOfMemoryError e2) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Out Of Memory Error decoding", e2);
            }
            errorWrappingGlideException = new ErrorWrappingGlideException(e2);
        }
        if (this.isCancelled) {
            if (resource != null) {
                resource.recycle();
            }
        } else if (resource == null) {
            onLoadFailed(errorWrappingGlideException);
        } else {
            this.manager.onResourceReady(resource);
        }
    }
}
