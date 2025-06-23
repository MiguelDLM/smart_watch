package androidx.room;

import OXOo.OOXIXo;
import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import androidx.room.InvalidationTracker;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.IIX0o;

@SuppressLint({"RestrictedApi"})
public final class RoomTrackingLiveData<T> extends LiveData<T> {
    @OOXIXo
    private final Callable<T> computeFunction;
    @OOXIXo
    private final AtomicBoolean computing = new AtomicBoolean(false);
    @OOXIXo
    private final InvalidationLiveDataContainer container;
    @OOXIXo
    private final RoomDatabase database;
    private final boolean inTransaction;
    @OOXIXo
    private final AtomicBoolean invalid = new AtomicBoolean(true);
    @OOXIXo
    private final Runnable invalidationRunnable = new O0xOxO(this);
    @OOXIXo
    private final InvalidationTracker.Observer observer;
    @OOXIXo
    private final Runnable refreshRunnable = new OxI(this);
    @OOXIXo
    private final AtomicBoolean registeredObserver = new AtomicBoolean(false);

    public RoomTrackingLiveData(@OOXIXo RoomDatabase roomDatabase, @OOXIXo InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z, @OOXIXo Callable<T> callable, @OOXIXo String[] strArr) {
        IIX0o.x0xO0oo(roomDatabase, "database");
        IIX0o.x0xO0oo(invalidationLiveDataContainer, TtmlNode.RUBY_CONTAINER);
        IIX0o.x0xO0oo(callable, "computeFunction");
        IIX0o.x0xO0oo(strArr, "tableNames");
        this.database = roomDatabase;
        this.container = invalidationLiveDataContainer;
        this.inTransaction = z;
        this.computeFunction = callable;
        this.observer = new RoomTrackingLiveData$observer$1(strArr, this);
    }

    /* access modifiers changed from: private */
    public static final void invalidationRunnable$lambda$1(RoomTrackingLiveData roomTrackingLiveData) {
        IIX0o.x0xO0oo(roomTrackingLiveData, "this$0");
        boolean hasActiveObservers = roomTrackingLiveData.hasActiveObservers();
        if (roomTrackingLiveData.invalid.compareAndSet(false, true) && hasActiveObservers) {
            roomTrackingLiveData.getQueryExecutor().execute(roomTrackingLiveData.refreshRunnable);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void refreshRunnable$lambda$0(androidx.room.RoomTrackingLiveData r5) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r0)
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.registeredObserver
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L_0x001a
            androidx.room.RoomDatabase r0 = r5.database
            androidx.room.InvalidationTracker r0 = r0.getInvalidationTracker()
            androidx.room.InvalidationTracker$Observer r3 = r5.observer
            r0.addWeakObserver(r3)
        L_0x001a:
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.computing
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L_0x0050
            r0 = 0
            r3 = 0
        L_0x0024:
            java.util.concurrent.atomic.AtomicBoolean r4 = r5.invalid     // Catch:{ all -> 0x0034 }
            boolean r4 = r4.compareAndSet(r2, r1)     // Catch:{ all -> 0x0034 }
            if (r4 == 0) goto L_0x003f
            java.util.concurrent.Callable<T> r0 = r5.computeFunction     // Catch:{ Exception -> 0x0036 }
            java.lang.Object r0 = r0.call()     // Catch:{ Exception -> 0x0036 }
            r3 = 1
            goto L_0x0024
        L_0x0034:
            r0 = move-exception
            goto L_0x004a
        L_0x0036:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x0034 }
            java.lang.String r3 = "Exception while computing database live data."
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0034 }
            throw r2     // Catch:{ all -> 0x0034 }
        L_0x003f:
            if (r3 == 0) goto L_0x0044
            r5.postValue(r0)     // Catch:{ all -> 0x0034 }
        L_0x0044:
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.computing
            r0.set(r1)
            goto L_0x0051
        L_0x004a:
            java.util.concurrent.atomic.AtomicBoolean r5 = r5.computing
            r5.set(r1)
            throw r0
        L_0x0050:
            r3 = 0
        L_0x0051:
            if (r3 == 0) goto L_0x005b
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.invalid
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x001a
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomTrackingLiveData.refreshRunnable$lambda$0(androidx.room.RoomTrackingLiveData):void");
    }

    @OOXIXo
    public final Callable<T> getComputeFunction() {
        return this.computeFunction;
    }

    @OOXIXo
    public final AtomicBoolean getComputing() {
        return this.computing;
    }

    @OOXIXo
    public final RoomDatabase getDatabase() {
        return this.database;
    }

    public final boolean getInTransaction() {
        return this.inTransaction;
    }

    @OOXIXo
    public final AtomicBoolean getInvalid() {
        return this.invalid;
    }

    @OOXIXo
    public final Runnable getInvalidationRunnable() {
        return this.invalidationRunnable;
    }

    @OOXIXo
    public final InvalidationTracker.Observer getObserver() {
        return this.observer;
    }

    @OOXIXo
    public final Executor getQueryExecutor() {
        if (this.inTransaction) {
            return this.database.getTransactionExecutor();
        }
        return this.database.getQueryExecutor();
    }

    @OOXIXo
    public final Runnable getRefreshRunnable() {
        return this.refreshRunnable;
    }

    @OOXIXo
    public final AtomicBoolean getRegisteredObserver() {
        return this.registeredObserver;
    }

    public void onActive() {
        super.onActive();
        InvalidationLiveDataContainer invalidationLiveDataContainer = this.container;
        IIX0o.x0XOIxOo(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        invalidationLiveDataContainer.onActive(this);
        getQueryExecutor().execute(this.refreshRunnable);
    }

    public void onInactive() {
        super.onInactive();
        InvalidationLiveDataContainer invalidationLiveDataContainer = this.container;
        IIX0o.x0XOIxOo(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        invalidationLiveDataContainer.onInactive(this);
    }
}
