package androidx.work;

import XO0OX.x0XOIxOo;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.work.impl.WorkManagerImpl;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.UUID;
import kotlin.XX;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@SuppressLint({"AddedAbstractMethod"})
/* loaded from: classes.dex */
public abstract class WorkManager {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @kotlin.OOXIXo(message = "Use the overload receiving Context", replaceWith = @XX(expression = "WorkManager.getContext(context)", imports = {}))
        @OXOo.OOXIXo
        public WorkManager getInstance() {
            WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance();
            if (workManagerImpl != null) {
                return workManagerImpl;
            }
            throw new IllegalStateException("WorkManager is not initialized properly.  The most likely cause is that you disabled WorkManagerInitializer in your manifest but forgot to call WorkManager#initialize in your Application#onCreate or a ContentProvider.");
        }

        @x0XOIxOo
        public void initialize(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Configuration configuration) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(configuration, "configuration");
            WorkManagerImpl.initialize(context, configuration);
        }

        @x0XOIxOo
        public boolean isInitialized() {
            return WorkManagerImpl.isInitialized();
        }

        private Companion() {
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public WorkManager getInstance(@OXOo.OOXIXo Context context) {
            IIX0o.x0xO0oo(context, "context");
            WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(context);
            IIX0o.oO(workManagerImpl, "getInstance(context)");
            return workManagerImpl;
        }
    }

    /* loaded from: classes.dex */
    public enum UpdateResult {
        NOT_APPLIED,
        APPLIED_IMMEDIATELY,
        APPLIED_FOR_NEXT_RUN
    }

    @x0XOIxOo
    @kotlin.OOXIXo(message = "Use the overload receiving Context", replaceWith = @XX(expression = "WorkManager.getContext(context)", imports = {}))
    @OXOo.OOXIXo
    public static WorkManager getInstance() {
        return Companion.getInstance();
    }

    @x0XOIxOo
    public static void initialize(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Configuration configuration) {
        Companion.initialize(context, configuration);
    }

    @x0XOIxOo
    public static boolean isInitialized() {
        return Companion.isInitialized();
    }

    @OXOo.OOXIXo
    public final WorkContinuation beginUniqueWork(@OXOo.OOXIXo String uniqueWorkName, @OXOo.OOXIXo ExistingWorkPolicy existingWorkPolicy, @OXOo.OOXIXo OneTimeWorkRequest request) {
        IIX0o.x0xO0oo(uniqueWorkName, "uniqueWorkName");
        IIX0o.x0xO0oo(existingWorkPolicy, "existingWorkPolicy");
        IIX0o.x0xO0oo(request, "request");
        return beginUniqueWork(uniqueWorkName, existingWorkPolicy, oI0IIXIo.OOXIXo(request));
    }

    @OXOo.OOXIXo
    public abstract WorkContinuation beginUniqueWork(@OXOo.OOXIXo String str, @OXOo.OOXIXo ExistingWorkPolicy existingWorkPolicy, @OXOo.OOXIXo List<OneTimeWorkRequest> list);

    @OXOo.OOXIXo
    public final WorkContinuation beginWith(@OXOo.OOXIXo OneTimeWorkRequest request) {
        IIX0o.x0xO0oo(request, "request");
        return beginWith(oI0IIXIo.OOXIXo(request));
    }

    @OXOo.OOXIXo
    public abstract WorkContinuation beginWith(@OXOo.OOXIXo List<OneTimeWorkRequest> list);

    @OXOo.OOXIXo
    public abstract Operation cancelAllWork();

    @OXOo.OOXIXo
    public abstract Operation cancelAllWorkByTag(@OXOo.OOXIXo String str);

    @OXOo.OOXIXo
    public abstract Operation cancelUniqueWork(@OXOo.OOXIXo String str);

    @OXOo.OOXIXo
    public abstract Operation cancelWorkById(@OXOo.OOXIXo UUID uuid);

    @OXOo.OOXIXo
    public abstract PendingIntent createCancelPendingIntent(@OXOo.OOXIXo UUID uuid);

    @OXOo.OOXIXo
    public final Operation enqueue(@OXOo.OOXIXo WorkRequest request) {
        IIX0o.x0xO0oo(request, "request");
        return enqueue(oI0IIXIo.OOXIXo(request));
    }

    @OXOo.OOXIXo
    public abstract Operation enqueue(@OXOo.OOXIXo List<? extends WorkRequest> list);

    @OXOo.OOXIXo
    public abstract Operation enqueueUniquePeriodicWork(@OXOo.OOXIXo String str, @OXOo.OOXIXo ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, @OXOo.OOXIXo PeriodicWorkRequest periodicWorkRequest);

    @OXOo.OOXIXo
    public Operation enqueueUniqueWork(@OXOo.OOXIXo String uniqueWorkName, @OXOo.OOXIXo ExistingWorkPolicy existingWorkPolicy, @OXOo.OOXIXo OneTimeWorkRequest request) {
        IIX0o.x0xO0oo(uniqueWorkName, "uniqueWorkName");
        IIX0o.x0xO0oo(existingWorkPolicy, "existingWorkPolicy");
        IIX0o.x0xO0oo(request, "request");
        return enqueueUniqueWork(uniqueWorkName, existingWorkPolicy, oI0IIXIo.OOXIXo(request));
    }

    @OXOo.OOXIXo
    public abstract Operation enqueueUniqueWork(@OXOo.OOXIXo String str, @OXOo.OOXIXo ExistingWorkPolicy existingWorkPolicy, @OXOo.OOXIXo List<OneTimeWorkRequest> list);

    @OXOo.OOXIXo
    public abstract Configuration getConfiguration();

    @OXOo.OOXIXo
    public abstract ListenableFuture<Long> getLastCancelAllTimeMillis();

    @OXOo.OOXIXo
    public abstract LiveData<Long> getLastCancelAllTimeMillisLiveData();

    @OXOo.OOXIXo
    public abstract ListenableFuture<WorkInfo> getWorkInfoById(@OXOo.OOXIXo UUID uuid);

    @OXOo.OOXIXo
    public abstract kotlinx.coroutines.flow.X0o0xo<WorkInfo> getWorkInfoByIdFlow(@OXOo.OOXIXo UUID uuid);

    @OXOo.OOXIXo
    public abstract LiveData<WorkInfo> getWorkInfoByIdLiveData(@OXOo.OOXIXo UUID uuid);

    @OXOo.OOXIXo
    public abstract ListenableFuture<List<WorkInfo>> getWorkInfos(@OXOo.OOXIXo WorkQuery workQuery);

    @OXOo.OOXIXo
    public abstract ListenableFuture<List<WorkInfo>> getWorkInfosByTag(@OXOo.OOXIXo String str);

    @OXOo.OOXIXo
    public abstract kotlinx.coroutines.flow.X0o0xo<List<WorkInfo>> getWorkInfosByTagFlow(@OXOo.OOXIXo String str);

    @OXOo.OOXIXo
    public abstract LiveData<List<WorkInfo>> getWorkInfosByTagLiveData(@OXOo.OOXIXo String str);

    @OXOo.OOXIXo
    public abstract kotlinx.coroutines.flow.X0o0xo<List<WorkInfo>> getWorkInfosFlow(@OXOo.OOXIXo WorkQuery workQuery);

    @OXOo.OOXIXo
    public abstract ListenableFuture<List<WorkInfo>> getWorkInfosForUniqueWork(@OXOo.OOXIXo String str);

    @OXOo.OOXIXo
    public abstract kotlinx.coroutines.flow.X0o0xo<List<WorkInfo>> getWorkInfosForUniqueWorkFlow(@OXOo.OOXIXo String str);

    @OXOo.OOXIXo
    public abstract LiveData<List<WorkInfo>> getWorkInfosForUniqueWorkLiveData(@OXOo.OOXIXo String str);

    @OXOo.OOXIXo
    public abstract LiveData<List<WorkInfo>> getWorkInfosLiveData(@OXOo.OOXIXo WorkQuery workQuery);

    @OXOo.OOXIXo
    public abstract Operation pruneWork();

    @OXOo.OOXIXo
    public abstract ListenableFuture<UpdateResult> updateWork(@OXOo.OOXIXo WorkRequest workRequest);

    @x0XOIxOo
    @OXOo.OOXIXo
    public static WorkManager getInstance(@OXOo.OOXIXo Context context) {
        return Companion.getInstance(context);
    }
}
