package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequest;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class RequestProgress {

    @OXOo.oOoXoXO
    private final Handler callbackHandler;
    private long lastReportedProgress;
    private long maxProgress;
    private long progress;

    @OXOo.OOXIXo
    private final GraphRequest request;
    private final long threshold;

    public RequestProgress(@OXOo.oOoXoXO Handler handler, @OXOo.OOXIXo GraphRequest request) {
        IIX0o.x0xO0oo(request, "request");
        this.callbackHandler = handler;
        this.request = request;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        this.threshold = FacebookSdk.getOnProgressThreshold();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: reportProgress$lambda-0, reason: not valid java name */
    public static final void m123reportProgress$lambda0(GraphRequest.Callback callback, long j, long j2) {
        ((GraphRequest.OnProgressCallback) callback).onProgress(j, j2);
    }

    public final void addProgress(long j) {
        long j2 = this.progress + j;
        this.progress = j2;
        if (j2 >= this.lastReportedProgress + this.threshold || j2 >= this.maxProgress) {
            reportProgress();
        }
    }

    public final void addToMax(long j) {
        this.maxProgress += j;
    }

    public final long getMaxProgress() {
        return this.maxProgress;
    }

    public final long getProgress() {
        return this.progress;
    }

    public final void reportProgress() {
        Boolean valueOf;
        if (this.progress > this.lastReportedProgress) {
            final GraphRequest.Callback callback = this.request.getCallback();
            final long j = this.maxProgress;
            if (j > 0 && (callback instanceof GraphRequest.OnProgressCallback)) {
                final long j2 = this.progress;
                Handler handler = this.callbackHandler;
                if (handler == null) {
                    valueOf = null;
                } else {
                    valueOf = Boolean.valueOf(handler.post(new Runnable() { // from class: com.facebook.IIXOooo
                        @Override // java.lang.Runnable
                        public final void run() {
                            RequestProgress.m123reportProgress$lambda0(GraphRequest.Callback.this, j2, j);
                        }
                    }));
                }
                if (valueOf == null) {
                    ((GraphRequest.OnProgressCallback) callback).onProgress(j2, j);
                }
                this.lastReportedProgress = this.progress;
            }
        }
    }
}
