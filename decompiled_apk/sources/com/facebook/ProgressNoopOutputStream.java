package com.facebook;

import android.os.Handler;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class ProgressNoopOutputStream extends OutputStream implements RequestOutputStream {

    @OXOo.oOoXoXO
    private final Handler callbackHandler;

    @OXOo.oOoXoXO
    private GraphRequest currentRequest;

    @OXOo.oOoXoXO
    private RequestProgress currentRequestProgress;
    private int maxProgress;

    @OXOo.OOXIXo
    private final Map<GraphRequest, RequestProgress> progressMap = new HashMap();

    public ProgressNoopOutputStream(@OXOo.oOoXoXO Handler handler) {
        this.callbackHandler = handler;
    }

    public final void addProgress(long j) {
        GraphRequest graphRequest = this.currentRequest;
        if (graphRequest == null) {
            return;
        }
        if (this.currentRequestProgress == null) {
            RequestProgress requestProgress = new RequestProgress(this.callbackHandler, graphRequest);
            this.currentRequestProgress = requestProgress;
            this.progressMap.put(graphRequest, requestProgress);
        }
        RequestProgress requestProgress2 = this.currentRequestProgress;
        if (requestProgress2 != null) {
            requestProgress2.addToMax(j);
        }
        this.maxProgress += (int) j;
    }

    public final int getMaxProgress() {
        return this.maxProgress;
    }

    @OXOo.OOXIXo
    public final Map<GraphRequest, RequestProgress> getProgressMap() {
        return this.progressMap;
    }

    @Override // com.facebook.RequestOutputStream
    public void setCurrentRequest(@OXOo.oOoXoXO GraphRequest graphRequest) {
        RequestProgress requestProgress;
        this.currentRequest = graphRequest;
        if (graphRequest != null) {
            requestProgress = this.progressMap.get(graphRequest);
        } else {
            requestProgress = null;
        }
        this.currentRequestProgress = requestProgress;
    }

    @Override // java.io.OutputStream
    public void write(@OXOo.OOXIXo byte[] buffer) {
        IIX0o.x0xO0oo(buffer, "buffer");
        addProgress(buffer.length);
    }

    @Override // java.io.OutputStream
    public void write(@OXOo.OOXIXo byte[] buffer, int i, int i2) {
        IIX0o.x0xO0oo(buffer, "buffer");
        addProgress(i2);
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        addProgress(1L);
    }
}
