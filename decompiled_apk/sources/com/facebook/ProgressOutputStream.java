package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequestBatch;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class ProgressOutputStream extends FilterOutputStream implements RequestOutputStream {
    private long batchProgress;

    @OXOo.oOoXoXO
    private RequestProgress currentRequestProgress;
    private long lastReportedProgress;
    private final long maxProgress;

    @OXOo.OOXIXo
    private final Map<GraphRequest, RequestProgress> progressMap;

    @OXOo.OOXIXo
    private final GraphRequestBatch requests;
    private final long threshold;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressOutputStream(@OXOo.OOXIXo OutputStream out, @OXOo.OOXIXo GraphRequestBatch requests, @OXOo.OOXIXo Map<GraphRequest, RequestProgress> progressMap, long j) {
        super(out);
        IIX0o.x0xO0oo(out, "out");
        IIX0o.x0xO0oo(requests, "requests");
        IIX0o.x0xO0oo(progressMap, "progressMap");
        this.requests = requests;
        this.progressMap = progressMap;
        this.maxProgress = j;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        this.threshold = FacebookSdk.getOnProgressThreshold();
    }

    private final void addProgress(long j) {
        RequestProgress requestProgress = this.currentRequestProgress;
        if (requestProgress != null) {
            requestProgress.addProgress(j);
        }
        long j2 = this.batchProgress + j;
        this.batchProgress = j2;
        if (j2 >= this.lastReportedProgress + this.threshold || j2 >= this.maxProgress) {
            reportBatchProgress();
        }
    }

    private final void reportBatchProgress() {
        Boolean valueOf;
        if (this.batchProgress > this.lastReportedProgress) {
            for (final GraphRequestBatch.Callback callback : this.requests.getCallbacks()) {
                if (callback instanceof GraphRequestBatch.OnProgressCallback) {
                    Handler callbackHandler = this.requests.getCallbackHandler();
                    if (callbackHandler == null) {
                        valueOf = null;
                    } else {
                        valueOf = Boolean.valueOf(callbackHandler.post(new Runnable() { // from class: com.facebook.OxxIIOOXO
                            @Override // java.lang.Runnable
                            public final void run() {
                                ProgressOutputStream.m122reportBatchProgress$lambda0(GraphRequestBatch.Callback.this, this);
                            }
                        }));
                    }
                    if (valueOf == null) {
                        ((GraphRequestBatch.OnProgressCallback) callback).onBatchProgress(this.requests, this.batchProgress, this.maxProgress);
                    }
                }
            }
            this.lastReportedProgress = this.batchProgress;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: reportBatchProgress$lambda-0, reason: not valid java name */
    public static final void m122reportBatchProgress$lambda0(GraphRequestBatch.Callback callback, ProgressOutputStream this$0) {
        IIX0o.x0xO0oo(callback, "$callback");
        IIX0o.x0xO0oo(this$0, "this$0");
        ((GraphRequestBatch.OnProgressCallback) callback).onBatchProgress(this$0.requests, this$0.getBatchProgress(), this$0.getMaxProgress());
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        Iterator<RequestProgress> it = this.progressMap.values().iterator();
        while (it.hasNext()) {
            it.next().reportProgress();
        }
        reportBatchProgress();
    }

    public final long getBatchProgress() {
        return this.batchProgress;
    }

    public final long getMaxProgress() {
        return this.maxProgress;
    }

    @Override // com.facebook.RequestOutputStream
    public void setCurrentRequest(@OXOo.oOoXoXO GraphRequest graphRequest) {
        RequestProgress requestProgress;
        if (graphRequest != null) {
            requestProgress = this.progressMap.get(graphRequest);
        } else {
            requestProgress = null;
        }
        this.currentRequestProgress = requestProgress;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(@OXOo.OOXIXo byte[] buffer) throws IOException {
        IIX0o.x0xO0oo(buffer, "buffer");
        ((FilterOutputStream) this).out.write(buffer);
        addProgress(buffer.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(@OXOo.OOXIXo byte[] buffer, int i, int i2) throws IOException {
        IIX0o.x0xO0oo(buffer, "buffer");
        ((FilterOutputStream) this).out.write(buffer, i, i2);
        addProgress(i2);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        ((FilterOutputStream) this).out.write(i);
        addProgress(1L);
    }
}
