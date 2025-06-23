package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpRequest;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.utils.CloneUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.concurrent.Cancellable;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ClientConnectionRequest;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ConnectionReleaseTrigger;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.AbstractHttpMessage;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.HeaderGroup;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParams;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes10.dex */
public abstract class AbstractExecutionAwareRequest extends AbstractHttpMessage implements HttpExecutionAware, AbortableHttpRequest, Cloneable, HttpRequest {
    private final AtomicBoolean aborted = new AtomicBoolean(false);
    private final AtomicReference<Cancellable> cancellableRef = new AtomicReference<>(null);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.AbortableHttpRequest
    public void abort() {
        Cancellable andSet;
        if (this.aborted.compareAndSet(false, true) && (andSet = this.cancellableRef.getAndSet(null)) != null) {
            andSet.cancel();
        }
    }

    public Object clone() throws CloneNotSupportedException {
        AbstractExecutionAwareRequest abstractExecutionAwareRequest = (AbstractExecutionAwareRequest) super.clone();
        abstractExecutionAwareRequest.headergroup = (HeaderGroup) CloneUtils.cloneObject(this.headergroup);
        abstractExecutionAwareRequest.params = (HttpParams) CloneUtils.cloneObject(this.params);
        return abstractExecutionAwareRequest;
    }

    public void completed() {
        this.cancellableRef.set(null);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpExecutionAware
    public boolean isAborted() {
        return this.aborted.get();
    }

    public void reset() {
        Cancellable andSet = this.cancellableRef.getAndSet(null);
        if (andSet != null) {
            andSet.cancel();
        }
        this.aborted.set(false);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpExecutionAware
    public void setCancellable(Cancellable cancellable) {
        if (!this.aborted.get()) {
            this.cancellableRef.set(cancellable);
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.AbortableHttpRequest
    @Deprecated
    public void setConnectionRequest(final ClientConnectionRequest clientConnectionRequest) {
        setCancellable(new Cancellable() { // from class: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.AbstractExecutionAwareRequest.1
            @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.concurrent.Cancellable
            public boolean cancel() {
                clientConnectionRequest.abortRequest();
                return true;
            }
        });
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.AbortableHttpRequest
    @Deprecated
    public void setReleaseTrigger(final ConnectionReleaseTrigger connectionReleaseTrigger) {
        setCancellable(new Cancellable() { // from class: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.AbstractExecutionAwareRequest.2
            @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.concurrent.Cancellable
            public boolean cancel() {
                try {
                    connectionReleaseTrigger.abortConnection();
                    return true;
                } catch (IOException unused) {
                    return false;
                }
            }
        });
    }
}
