package androidx.lifecycle;

import OXOo.OOXIXo;
import XO0OX.XO;
import XO0OX.xoIox;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class ComputableLiveData<T> {
    @OOXIXo
    private final LiveData<T> _liveData;
    @OOXIXo
    private final AtomicBoolean computing;
    @OOXIXo
    private final Executor executor;
    @OOXIXo
    private final AtomicBoolean invalid;
    @XO
    @OOXIXo
    public final Runnable invalidationRunnable;
    @OOXIXo
    private final LiveData<T> liveData;
    @XO
    @OOXIXo
    public final Runnable refreshRunnable;

    @xoIox
    public ComputableLiveData() {
        this((Executor) null, 1, (IIXOooo) null);
    }

    @VisibleForTesting
    public static /* synthetic */ void getInvalidationRunnable$lifecycle_livedata_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getRefreshRunnable$lifecycle_livedata_release$annotations() {
    }

    /* access modifiers changed from: private */
    public static final void invalidationRunnable$lambda$1(ComputableLiveData computableLiveData) {
        IIX0o.x0xO0oo(computableLiveData, "this$0");
        boolean hasActiveObservers = computableLiveData.getLiveData().hasActiveObservers();
        if (computableLiveData.invalid.compareAndSet(false, true) && hasActiveObservers) {
            computableLiveData.executor.execute(computableLiveData.refreshRunnable);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x000f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void refreshRunnable$lambda$0(androidx.lifecycle.ComputableLiveData r5) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r0)
        L_0x0005:
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.computing
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L_0x0037
            r0 = 0
            r3 = 0
        L_0x0011:
            java.util.concurrent.atomic.AtomicBoolean r4 = r5.invalid     // Catch:{ all -> 0x001f }
            boolean r4 = r4.compareAndSet(r2, r1)     // Catch:{ all -> 0x001f }
            if (r4 == 0) goto L_0x0021
            java.lang.Object r0 = r5.compute()     // Catch:{ all -> 0x001f }
            r3 = 1
            goto L_0x0011
        L_0x001f:
            r0 = move-exception
            goto L_0x0031
        L_0x0021:
            if (r3 == 0) goto L_0x002a
            androidx.lifecycle.LiveData r2 = r5.getLiveData()     // Catch:{ all -> 0x001f }
            r2.postValue(r0)     // Catch:{ all -> 0x001f }
        L_0x002a:
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.computing
            r0.set(r1)
            r1 = r3
            goto L_0x0037
        L_0x0031:
            java.util.concurrent.atomic.AtomicBoolean r5 = r5.computing
            r5.set(r1)
            throw r0
        L_0x0037:
            if (r1 == 0) goto L_0x0041
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.invalid
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x0005
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ComputableLiveData.refreshRunnable$lambda$0(androidx.lifecycle.ComputableLiveData):void");
    }

    @WorkerThread
    public abstract T compute();

    @OOXIXo
    public final AtomicBoolean getComputing$lifecycle_livedata_release() {
        return this.computing;
    }

    @OOXIXo
    public final Executor getExecutor$lifecycle_livedata_release() {
        return this.executor;
    }

    @OOXIXo
    public final AtomicBoolean getInvalid$lifecycle_livedata_release() {
        return this.invalid;
    }

    @OOXIXo
    public LiveData<T> getLiveData() {
        return this.liveData;
    }

    public void invalidate() {
        ArchTaskExecutor.getInstance().executeOnMainThread(this.invalidationRunnable);
    }

    @xoIox
    public ComputableLiveData(@OOXIXo Executor executor2) {
        IIX0o.x0xO0oo(executor2, "executor");
        this.executor = executor2;
        ComputableLiveData$_liveData$1 computableLiveData$_liveData$1 = new ComputableLiveData$_liveData$1(this);
        this._liveData = computableLiveData$_liveData$1;
        this.liveData = computableLiveData$_liveData$1;
        this.invalid = new AtomicBoolean(true);
        this.computing = new AtomicBoolean(false);
        this.refreshRunnable = new oIX0oI(this);
        this.invalidationRunnable = new II0xO0(this);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ComputableLiveData(java.util.concurrent.Executor r1, int r2, kotlin.jvm.internal.IIXOooo r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto L_0x000d
            java.util.concurrent.Executor r1 = androidx.arch.core.executor.ArchTaskExecutor.getIOThreadExecutor()
            java.lang.String r2 = "getIOThreadExecutor()"
            kotlin.jvm.internal.IIX0o.oO(r1, r2)
        L_0x000d:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ComputableLiveData.<init>(java.util.concurrent.Executor, int, kotlin.jvm.internal.IIXOooo):void");
    }
}
