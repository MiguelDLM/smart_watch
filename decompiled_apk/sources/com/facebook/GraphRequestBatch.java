package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class GraphRequestBatch extends AbstractList<GraphRequest> {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private static final AtomicInteger idGenerator = new AtomicInteger();

    @OXOo.oOoXoXO
    private String batchApplicationId;

    @OXOo.oOoXoXO
    private Handler callbackHandler;

    @OXOo.OOXIXo
    private List<Callback> callbacks;

    @OXOo.OOXIXo
    private final String id;

    @OXOo.OOXIXo
    private List<GraphRequest> requests;
    private int timeoutInMilliseconds;

    /* loaded from: classes8.dex */
    public interface Callback {
        void onBatchCompleted(@OXOo.OOXIXo GraphRequestBatch graphRequestBatch);
    }

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public interface OnProgressCallback extends Callback {
        void onBatchProgress(@OXOo.OOXIXo GraphRequestBatch graphRequestBatch, long j, long j2);
    }

    public GraphRequestBatch() {
        this.id = String.valueOf(idGenerator.incrementAndGet());
        this.callbacks = new ArrayList();
        this.requests = new ArrayList();
    }

    private final List<GraphResponse> executeAndWaitImpl() {
        return GraphRequest.Companion.executeBatchAndWait(this);
    }

    private final GraphRequestAsyncTask executeAsyncImpl() {
        return GraphRequest.Companion.executeBatchAsync(this);
    }

    public final void addCallback(@OXOo.OOXIXo Callback callback) {
        IIX0o.x0xO0oo(callback, "callback");
        if (!this.callbacks.contains(callback)) {
            this.callbacks.add(callback);
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.requests.clear();
    }

    public /* bridge */ boolean contains(GraphRequest graphRequest) {
        return super.contains((Object) graphRequest);
    }

    @OXOo.OOXIXo
    public final List<GraphResponse> executeAndWait() {
        return executeAndWaitImpl();
    }

    @OXOo.OOXIXo
    public final GraphRequestAsyncTask executeAsync() {
        return executeAsyncImpl();
    }

    @OXOo.oOoXoXO
    public final String getBatchApplicationId() {
        return this.batchApplicationId;
    }

    @OXOo.oOoXoXO
    public final Handler getCallbackHandler() {
        return this.callbackHandler;
    }

    @OXOo.OOXIXo
    public final List<Callback> getCallbacks() {
        return this.callbacks;
    }

    @OXOo.OOXIXo
    public final String getId() {
        return this.id;
    }

    @OXOo.OOXIXo
    public final List<GraphRequest> getRequests() {
        return this.requests;
    }

    public int getSize() {
        return this.requests.size();
    }

    public final int getTimeout() {
        return this.timeoutInMilliseconds;
    }

    public /* bridge */ int indexOf(GraphRequest graphRequest) {
        return super.indexOf((Object) graphRequest);
    }

    public /* bridge */ int lastIndexOf(GraphRequest graphRequest) {
        return super.lastIndexOf((Object) graphRequest);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ GraphRequest remove(int i) {
        return removeAt(i);
    }

    @OXOo.OOXIXo
    public GraphRequest removeAt(int i) {
        return this.requests.remove(i);
    }

    public final void removeCallback(@OXOo.OOXIXo Callback callback) {
        IIX0o.x0xO0oo(callback, "callback");
        this.callbacks.remove(callback);
    }

    public final void setBatchApplicationId(@OXOo.oOoXoXO String str) {
        this.batchApplicationId = str;
    }

    public final void setCallbackHandler(@OXOo.oOoXoXO Handler handler) {
        this.callbackHandler = handler;
    }

    public final void setTimeout(int i) {
        boolean z;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.timeoutInMilliseconds = i;
            return;
        }
        throw new IllegalArgumentException("Argument timeoutInMilliseconds must be >= 0.");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof GraphRequest) {
            return contains((GraphRequest) obj);
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    @OXOo.OOXIXo
    public GraphRequest get(int i) {
        return this.requests.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj == null ? true : obj instanceof GraphRequest) {
            return indexOf((GraphRequest) obj);
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj == null ? true : obj instanceof GraphRequest) {
            return lastIndexOf((GraphRequest) obj);
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    @OXOo.OOXIXo
    public GraphRequest set(int i, @OXOo.OOXIXo GraphRequest element) {
        IIX0o.x0xO0oo(element, "element");
        return this.requests.set(i, element);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(@OXOo.OOXIXo GraphRequest element) {
        IIX0o.x0xO0oo(element, "element");
        return this.requests.add(element);
    }

    public /* bridge */ boolean remove(GraphRequest graphRequest) {
        return super.remove((Object) graphRequest);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, @OXOo.OOXIXo GraphRequest element) {
        IIX0o.x0xO0oo(element, "element");
        this.requests.add(i, element);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj == null ? true : obj instanceof GraphRequest) {
            return remove((GraphRequest) obj);
        }
        return false;
    }

    public GraphRequestBatch(@OXOo.OOXIXo Collection<GraphRequest> requests) {
        IIX0o.x0xO0oo(requests, "requests");
        this.id = String.valueOf(idGenerator.incrementAndGet());
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(requests);
    }

    public GraphRequestBatch(@OXOo.OOXIXo GraphRequest... requests) {
        IIX0o.x0xO0oo(requests, "requests");
        this.id = String.valueOf(idGenerator.incrementAndGet());
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(kotlin.collections.ooOOo0oXI.oI0IIXIo(requests));
    }

    public GraphRequestBatch(@OXOo.OOXIXo GraphRequestBatch requests) {
        IIX0o.x0xO0oo(requests, "requests");
        this.id = String.valueOf(idGenerator.incrementAndGet());
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(requests);
        this.callbackHandler = requests.callbackHandler;
        this.timeoutInMilliseconds = requests.timeoutInMilliseconds;
        this.callbacks = new ArrayList(requests.callbacks);
    }
}
