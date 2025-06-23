package androidx.room;

import android.annotation.SuppressLint;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LiveData;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.IIX0o;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class RoomTrackingLiveData<T> extends LiveData<T> {

    @OXOo.OOXIXo
    private final Callable<T> computeFunction;

    @OXOo.OOXIXo
    private final AtomicBoolean computing;

    @OXOo.OOXIXo
    private final InvalidationLiveDataContainer container;

    @OXOo.OOXIXo
    private final RoomDatabase database;
    private final boolean inTransaction;

    @OXOo.OOXIXo
    private final AtomicBoolean invalid;

    @OXOo.OOXIXo
    private final Runnable invalidationRunnable;

    @OXOo.OOXIXo
    private final InvalidationTracker.Observer observer;

    @OXOo.OOXIXo
    private final Runnable refreshRunnable;

    @OXOo.OOXIXo
    private final AtomicBoolean registeredObserver;

    public RoomTrackingLiveData(@OXOo.OOXIXo RoomDatabase database, @OXOo.OOXIXo InvalidationLiveDataContainer container, boolean z, @OXOo.OOXIXo Callable<T> computeFunction, @OXOo.OOXIXo final String[] tableNames) {
        IIX0o.x0xO0oo(database, "database");
        IIX0o.x0xO0oo(container, "container");
        IIX0o.x0xO0oo(computeFunction, "computeFunction");
        IIX0o.x0xO0oo(tableNames, "tableNames");
        this.database = database;
        this.container = container;
        this.inTransaction = z;
        this.computeFunction = computeFunction;
        this.observer = new InvalidationTracker.Observer(tableNames) { // from class: androidx.room.RoomTrackingLiveData$observer$1
            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(@OXOo.OOXIXo Set<String> tables) {
                IIX0o.x0xO0oo(tables, "tables");
                ArchTaskExecutor.getInstance().executeOnMainThread(this.getInvalidationRunnable());
            }
        };
        this.invalid = new AtomicBoolean(true);
        this.computing = new AtomicBoolean(false);
        this.registeredObserver = new AtomicBoolean(false);
        this.refreshRunnable = new Runnable() { // from class: androidx.room.OxI
            @Override // java.lang.Runnable
            public final void run() {
                RoomTrackingLiveData.refreshRunnable$lambda$0(RoomTrackingLiveData.this);
            }
        };
        this.invalidationRunnable = new Runnable() { // from class: androidx.room.O0xOxO
            @Override // java.lang.Runnable
            public final void run() {
                RoomTrackingLiveData.invalidationRunnable$lambda$1(RoomTrackingLiveData.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invalidationRunnable$lambda$1(RoomTrackingLiveData this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        boolean hasActiveObservers = this$0.hasActiveObservers();
        if (this$0.invalid.compareAndSet(false, true) && hasActiveObservers) {
            this$0.getQueryExecutor().execute(this$0.refreshRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshRunnable$lambda$0(RoomTrackingLiveData this$0) {
        boolean z;
        IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.registeredObserver.compareAndSet(false, true)) {
            this$0.database.getInvalidationTracker().addWeakObserver(this$0.observer);
        }
        do {
            if (this$0.computing.compareAndSet(false, true)) {
                T t = null;
                z = false;
                while (this$0.invalid.compareAndSet(true, false)) {
                    try {
                        try {
                            t = this$0.computeFunction.call();
                            z = true;
                        } catch (Exception e) {
                            throw new RuntimeException("Exception while computing database live data.", e);
                        }
                    } finally {
                        this$0.computing.set(false);
                    }
                }
                if (z) {
                    this$0.postValue(t);
                }
            } else {
                z = false;
            }
            if (!z) {
                return;
            }
        } while (this$0.invalid.get());
    }

    @OXOo.OOXIXo
    public final Callable<T> getComputeFunction() {
        return this.computeFunction;
    }

    @OXOo.OOXIXo
    public final AtomicBoolean getComputing() {
        return this.computing;
    }

    @OXOo.OOXIXo
    public final RoomDatabase getDatabase() {
        return this.database;
    }

    public final boolean getInTransaction() {
        return this.inTransaction;
    }

    @OXOo.OOXIXo
    public final AtomicBoolean getInvalid() {
        return this.invalid;
    }

    @OXOo.OOXIXo
    public final Runnable getInvalidationRunnable() {
        return this.invalidationRunnable;
    }

    @OXOo.OOXIXo
    public final InvalidationTracker.Observer getObserver() {
        return this.observer;
    }

    @OXOo.OOXIXo
    public final Executor getQueryExecutor() {
        if (this.inTransaction) {
            return this.database.getTransactionExecutor();
        }
        return this.database.getQueryExecutor();
    }

    @OXOo.OOXIXo
    public final Runnable getRefreshRunnable() {
        return this.refreshRunnable;
    }

    @OXOo.OOXIXo
    public final AtomicBoolean getRegisteredObserver() {
        return this.registeredObserver;
    }

    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        InvalidationLiveDataContainer invalidationLiveDataContainer = this.container;
        IIX0o.x0XOIxOo(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        invalidationLiveDataContainer.onActive(this);
        getQueryExecutor().execute(this.refreshRunnable);
    }

    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        InvalidationLiveDataContainer invalidationLiveDataContainer = this.container;
        IIX0o.x0XOIxOo(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        invalidationLiveDataContainer.onInactive(this);
    }
}
