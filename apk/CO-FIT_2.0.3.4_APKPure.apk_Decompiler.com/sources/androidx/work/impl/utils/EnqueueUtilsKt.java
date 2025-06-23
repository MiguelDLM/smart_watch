package androidx.work.impl.utils;

import O0IoXXOx.XO;
import OXOo.OOXIXo;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import androidx.work.BackoffPolicy;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.impl.workers.ConstraintTrackingWorkerKt;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.OxI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nEnqueueUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EnqueueUtils.kt\nandroidx/work/impl/utils/EnqueueUtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Data_.kt\nandroidx/work/Data\n*L\n1#1,168:1\n1774#2,4:169\n1747#2,3:177\n1#3:173\n229#4:174\n229#4:175\n229#4:176\n*S KotlinDebug\n*F\n+ 1 EnqueueUtils.kt\nandroidx/work/impl/utils/EnqueueUtilsKt\n*L\n45#1:169,4\n140#1:177,3\n71#1:174\n72#1:175\n73#1:176\n*E\n"})
public final class EnqueueUtilsKt {
    @OOXIXo
    public static final String ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME = "androidx.work.multiprocess.RemoteListenableDelegatingWorker.ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME";
    @OOXIXo
    public static final String ARGUMENT_SERVICE_CLASS_NAME = "androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_CLASS_NAME";
    @OOXIXo
    public static final String ARGUMENT_SERVICE_PACKAGE_NAME = "androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_PACKAGE_NAME";
    @OOXIXo
    public static final String REMOTE_DELEGATING_LISTENABLE_WORKER_CLASS_NAME = "androidx.work.multiprocess.RemoteListenableDelegatingWorker";

    public static final void checkContentUriTriggerWorkerLimits(@OOXIXo WorkDatabase workDatabase, @OOXIXo Configuration configuration, @OOXIXo WorkContinuationImpl workContinuationImpl) {
        int i;
        IIX0o.x0xO0oo(workDatabase, "workDatabase");
        IIX0o.x0xO0oo(configuration, XO.f15419Oxx0IOOO);
        IIX0o.x0xO0oo(workContinuationImpl, "continuation");
        if (Build.VERSION.SDK_INT >= 24) {
            List XOxIOxOx2 = CollectionsKt__CollectionsKt.XOxIOxOx(workContinuationImpl);
            int i2 = 0;
            while (!XOxIOxOx2.isEmpty()) {
                WorkContinuationImpl workContinuationImpl2 = (WorkContinuationImpl) OxI.xx0X0(XOxIOxOx2);
                List<? extends WorkRequest> work = workContinuationImpl2.getWork();
                IIX0o.oO(work, "current.work");
                Iterable<WorkRequest> iterable = work;
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    i = 0;
                    for (WorkRequest workSpec : iterable) {
                        if (workSpec.getWorkSpec().constraints.hasContentUriTriggers() && (i = i + 1) < 0) {
                            CollectionsKt__CollectionsKt.oxxXoxO();
                        }
                    }
                } else {
                    i = 0;
                }
                i2 += i;
                List<WorkContinuationImpl> parents = workContinuationImpl2.getParents();
                if (parents != null) {
                    XOxIOxOx2.addAll(parents);
                }
            }
            if (i2 != 0) {
                int countNonFinishedContentUriTriggerWorkers = workDatabase.workSpecDao().countNonFinishedContentUriTriggerWorkers();
                int contentUriTriggerWorkersLimit = configuration.getContentUriTriggerWorkersLimit();
                if (countNonFinishedContentUriTriggerWorkers + i2 > contentUriTriggerWorkersLimit) {
                    throw new IllegalArgumentException("Too many workers with contentUriTriggers are enqueued:\ncontentUriTrigger workers limit: " + contentUriTriggerWorkersLimit + ";\nalready enqueued count: " + countNonFinishedContentUriTriggerWorkers + ";\ncurrent enqueue operation count: " + i2 + ".\nTo address this issue you can: \n1. enqueue less workers or batch some of workers with content uri triggers together;\n2. increase limit via Configuration.Builder.setContentUriTriggerWorkersLimit;\nPlease beware that workers with content uri triggers immediately occupy slots in JobScheduler so no updates to content uris are missed.");
                }
            }
        }
    }

    @OOXIXo
    public static final WorkSpec tryDelegateConstrainedWorkSpec(@OOXIXo WorkSpec workSpec) {
        WorkSpec workSpec2 = workSpec;
        IIX0o.x0xO0oo(workSpec2, "workSpec");
        Constraints constraints = workSpec2.constraints;
        String str = workSpec2.workerClassName;
        Class<ConstraintTrackingWorker> cls = ConstraintTrackingWorker.class;
        if (IIX0o.Oxx0IOOO(str, cls.getName())) {
            return workSpec2;
        }
        if (!constraints.requiresBatteryNotLow() && !constraints.requiresStorageNotLow()) {
            return workSpec2;
        }
        Data build = new Data.Builder().putAll(workSpec2.input).putString(ConstraintTrackingWorkerKt.ARGUMENT_CLASS_NAME, str).build();
        String name = cls.getName();
        IIX0o.oO(name, "name");
        return WorkSpec.copy$default(workSpec, (String) null, (WorkInfo.State) null, name, (String) null, build, (Data) null, 0, 0, 0, (Constraints) null, 0, (BackoffPolicy) null, 0, 0, 0, 0, false, (OutOfQuotaPolicy) null, 0, 0, 0, 0, 0, (String) null, 16777195, (Object) null);
    }

    @VisibleForTesting
    @OOXIXo
    public static final WorkSpec tryDelegateRemoteListenableWorker(@OOXIXo WorkSpec workSpec) {
        WorkSpec workSpec2 = workSpec;
        IIX0o.x0xO0oo(workSpec2, "workSpec");
        Class<String> cls = String.class;
        boolean hasKeyWithValueOfType = workSpec2.input.hasKeyWithValueOfType(ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME, cls);
        boolean hasKeyWithValueOfType2 = workSpec2.input.hasKeyWithValueOfType(ARGUMENT_SERVICE_PACKAGE_NAME, cls);
        boolean hasKeyWithValueOfType3 = workSpec2.input.hasKeyWithValueOfType(ARGUMENT_SERVICE_CLASS_NAME, cls);
        if (hasKeyWithValueOfType || !hasKeyWithValueOfType2 || !hasKeyWithValueOfType3) {
            return workSpec2;
        }
        String str = workSpec2.workerClassName;
        return WorkSpec.copy$default(workSpec, (String) null, (WorkInfo.State) null, REMOTE_DELEGATING_LISTENABLE_WORKER_CLASS_NAME, (String) null, new Data.Builder().putAll(workSpec2.input).putString(ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME, str).build(), (Data) null, 0, 0, 0, (Constraints) null, 0, (BackoffPolicy) null, 0, 0, 0, 0, false, (OutOfQuotaPolicy) null, 0, 0, 0, 0, 0, (String) null, 16777195, (Object) null);
    }

    private static final boolean usesScheduler(List<? extends Scheduler> list, String str) {
        try {
            Class<?> cls = Class.forName(str);
            Iterable<Scheduler> iterable = list;
            if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
                return false;
            }
            for (Scheduler scheduler : iterable) {
                if (cls.isAssignableFrom(scheduler.getClass())) {
                    return true;
                }
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @OOXIXo
    public static final WorkSpec wrapWorkSpecIfNeeded(@OOXIXo List<? extends Scheduler> list, @OOXIXo WorkSpec workSpec) {
        IIX0o.x0xO0oo(list, "schedulers");
        IIX0o.x0xO0oo(workSpec, "workSpec");
        WorkSpec tryDelegateRemoteListenableWorker = tryDelegateRemoteListenableWorker(workSpec);
        int i = Build.VERSION.SDK_INT;
        if (23 <= i && i < 26) {
            return tryDelegateConstrainedWorkSpec(tryDelegateRemoteListenableWorker);
        }
        if (i > 22 || !usesScheduler(list, Schedulers.GCM_SCHEDULER)) {
            return tryDelegateRemoteListenableWorker;
        }
        return tryDelegateConstrainedWorkSpec(tryDelegateRemoteListenableWorker);
    }
}
