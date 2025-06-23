package androidx.work;

import O0IoXXOx.XO;
import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.work.impl.WorkManagerImpl;
import com.google.common.util.concurrent.ListenableFuture;
import com.huawei.openalliance.ad.constant.bn;
import java.util.List;
import java.util.UUID;
import kotlin.XX;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlinx.coroutines.flow.X0o0xo;

@SuppressLint({"AddedAbstractMethod"})
public abstract class WorkManager {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @kotlin.OOXIXo(message = "Use the overload receiving Context", replaceWith = @XX(expression = "WorkManager.getContext(context)", imports = {}))
        @x0XOIxOo
        @OOXIXo
        public WorkManager getInstance() {
            WorkManagerImpl instance = WorkManagerImpl.getInstance();
            if (instance != null) {
                return instance;
            }
            throw new IllegalStateException("WorkManager is not initialized properly.  The most likely cause is that you disabled WorkManagerInitializer in your manifest but forgot to call WorkManager#initialize in your Application#onCreate or a ContentProvider.");
        }

        @x0XOIxOo
        public void initialize(@OOXIXo Context context, @OOXIXo Configuration configuration) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(configuration, XO.f15419Oxx0IOOO);
            WorkManagerImpl.initialize(context, configuration);
        }

        @x0XOIxOo
        public boolean isInitialized() {
            return WorkManagerImpl.isInitialized();
        }

        private Companion() {
        }

        @x0XOIxOo
        @OOXIXo
        public WorkManager getInstance(@OOXIXo Context context) {
            IIX0o.x0xO0oo(context, bn.f.o);
            WorkManagerImpl instance = WorkManagerImpl.getInstance(context);
            IIX0o.oO(instance, "getInstance(context)");
            return instance;
        }
    }

    public enum UpdateResult {
        NOT_APPLIED,
        APPLIED_IMMEDIATELY,
        APPLIED_FOR_NEXT_RUN
    }

    @kotlin.OOXIXo(message = "Use the overload receiving Context", replaceWith = @XX(expression = "WorkManager.getContext(context)", imports = {}))
    @x0XOIxOo
    @OOXIXo
    public static WorkManager getInstance() {
        return Companion.getInstance();
    }

    @x0XOIxOo
    public static void initialize(@OOXIXo Context context, @OOXIXo Configuration configuration) {
        Companion.initialize(context, configuration);
    }

    @x0XOIxOo
    public static boolean isInitialized() {
        return Companion.isInitialized();
    }

    @OOXIXo
    public final WorkContinuation beginUniqueWork(@OOXIXo String str, @OOXIXo ExistingWorkPolicy existingWorkPolicy, @OOXIXo OneTimeWorkRequest oneTimeWorkRequest) {
        IIX0o.x0xO0oo(str, "uniqueWorkName");
        IIX0o.x0xO0oo(existingWorkPolicy, "existingWorkPolicy");
        IIX0o.x0xO0oo(oneTimeWorkRequest, "request");
        return beginUniqueWork(str, existingWorkPolicy, (List<OneTimeWorkRequest>) oI0IIXIo.OOXIXo(oneTimeWorkRequest));
    }

    @OOXIXo
    public abstract WorkContinuation beginUniqueWork(@OOXIXo String str, @OOXIXo ExistingWorkPolicy existingWorkPolicy, @OOXIXo List<OneTimeWorkRequest> list);

    @OOXIXo
    public final WorkContinuation beginWith(@OOXIXo OneTimeWorkRequest oneTimeWorkRequest) {
        IIX0o.x0xO0oo(oneTimeWorkRequest, "request");
        return beginWith((List<OneTimeWorkRequest>) oI0IIXIo.OOXIXo(oneTimeWorkRequest));
    }

    @OOXIXo
    public abstract WorkContinuation beginWith(@OOXIXo List<OneTimeWorkRequest> list);

    @OOXIXo
    public abstract Operation cancelAllWork();

    @OOXIXo
    public abstract Operation cancelAllWorkByTag(@OOXIXo String str);

    @OOXIXo
    public abstract Operation cancelUniqueWork(@OOXIXo String str);

    @OOXIXo
    public abstract Operation cancelWorkById(@OOXIXo UUID uuid);

    @OOXIXo
    public abstract PendingIntent createCancelPendingIntent(@OOXIXo UUID uuid);

    @OOXIXo
    public final Operation enqueue(@OOXIXo WorkRequest workRequest) {
        IIX0o.x0xO0oo(workRequest, "request");
        return enqueue((List<? extends WorkRequest>) oI0IIXIo.OOXIXo(workRequest));
    }

    @OOXIXo
    public abstract Operation enqueue(@OOXIXo List<? extends WorkRequest> list);

    @OOXIXo
    public abstract Operation enqueueUniquePeriodicWork(@OOXIXo String str, @OOXIXo ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, @OOXIXo PeriodicWorkRequest periodicWorkRequest);

    @OOXIXo
    public Operation enqueueUniqueWork(@OOXIXo String str, @OOXIXo ExistingWorkPolicy existingWorkPolicy, @OOXIXo OneTimeWorkRequest oneTimeWorkRequest) {
        IIX0o.x0xO0oo(str, "uniqueWorkName");
        IIX0o.x0xO0oo(existingWorkPolicy, "existingWorkPolicy");
        IIX0o.x0xO0oo(oneTimeWorkRequest, "request");
        return enqueueUniqueWork(str, existingWorkPolicy, (List<OneTimeWorkRequest>) oI0IIXIo.OOXIXo(oneTimeWorkRequest));
    }

    @OOXIXo
    public abstract Operation enqueueUniqueWork(@OOXIXo String str, @OOXIXo ExistingWorkPolicy existingWorkPolicy, @OOXIXo List<OneTimeWorkRequest> list);

    @OOXIXo
    public abstract Configuration getConfiguration();

    @OOXIXo
    public abstract ListenableFuture<Long> getLastCancelAllTimeMillis();

    @OOXIXo
    public abstract LiveData<Long> getLastCancelAllTimeMillisLiveData();

    @OOXIXo
    public abstract ListenableFuture<WorkInfo> getWorkInfoById(@OOXIXo UUID uuid);

    @OOXIXo
    public abstract X0o0xo<WorkInfo> getWorkInfoByIdFlow(@OOXIXo UUID uuid);

    @OOXIXo
    public abstract LiveData<WorkInfo> getWorkInfoByIdLiveData(@OOXIXo UUID uuid);

    @OOXIXo
    public abstract ListenableFuture<List<WorkInfo>> getWorkInfos(@OOXIXo WorkQuery workQuery);

    @OOXIXo
    public abstract ListenableFuture<List<WorkInfo>> getWorkInfosByTag(@OOXIXo String str);

    @OOXIXo
    public abstract X0o0xo<List<WorkInfo>> getWorkInfosByTagFlow(@OOXIXo String str);

    @OOXIXo
    public abstract LiveData<List<WorkInfo>> getWorkInfosByTagLiveData(@OOXIXo String str);

    @OOXIXo
    public abstract X0o0xo<List<WorkInfo>> getWorkInfosFlow(@OOXIXo WorkQuery workQuery);

    @OOXIXo
    public abstract ListenableFuture<List<WorkInfo>> getWorkInfosForUniqueWork(@OOXIXo String str);

    @OOXIXo
    public abstract X0o0xo<List<WorkInfo>> getWorkInfosForUniqueWorkFlow(@OOXIXo String str);

    @OOXIXo
    public abstract LiveData<List<WorkInfo>> getWorkInfosForUniqueWorkLiveData(@OOXIXo String str);

    @OOXIXo
    public abstract LiveData<List<WorkInfo>> getWorkInfosLiveData(@OOXIXo WorkQuery workQuery);

    @OOXIXo
    public abstract Operation pruneWork();

    @OOXIXo
    public abstract ListenableFuture<UpdateResult> updateWork(@OOXIXo WorkRequest workRequest);

    @x0XOIxOo
    @OOXIXo
    public static WorkManager getInstance(@OOXIXo Context context) {
        return Companion.getInstance(context);
    }
}
