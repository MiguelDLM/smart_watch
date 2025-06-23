package androidx.work.impl.utils;

import android.os.Build;
import androidx.annotation.VisibleForTesting;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.WorkRequest;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.impl.workers.ConstraintTrackingWorkerKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.OxI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nEnqueueUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EnqueueUtils.kt\nandroidx/work/impl/utils/EnqueueUtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Data_.kt\nandroidx/work/Data\n*L\n1#1,168:1\n1774#2,4:169\n1747#2,3:177\n1#3:173\n229#4:174\n229#4:175\n229#4:176\n*S KotlinDebug\n*F\n+ 1 EnqueueUtils.kt\nandroidx/work/impl/utils/EnqueueUtilsKt\n*L\n45#1:169,4\n140#1:177,3\n71#1:174\n72#1:175\n73#1:176\n*E\n"})
/* loaded from: classes.dex */
public final class EnqueueUtilsKt {

    @OXOo.OOXIXo
    public static final String ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME = "androidx.work.multiprocess.RemoteListenableDelegatingWorker.ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME";

    @OXOo.OOXIXo
    public static final String ARGUMENT_SERVICE_CLASS_NAME = "androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_CLASS_NAME";

    @OXOo.OOXIXo
    public static final String ARGUMENT_SERVICE_PACKAGE_NAME = "androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_PACKAGE_NAME";

    @OXOo.OOXIXo
    public static final String REMOTE_DELEGATING_LISTENABLE_WORKER_CLASS_NAME = "androidx.work.multiprocess.RemoteListenableDelegatingWorker";

    public static final void checkContentUriTriggerWorkerLimits(@OXOo.OOXIXo WorkDatabase workDatabase, @OXOo.OOXIXo Configuration configuration, @OXOo.OOXIXo WorkContinuationImpl continuation) {
        int i;
        IIX0o.x0xO0oo(workDatabase, "workDatabase");
        IIX0o.x0xO0oo(configuration, "configuration");
        IIX0o.x0xO0oo(continuation, "continuation");
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        List XOxIOxOx2 = CollectionsKt__CollectionsKt.XOxIOxOx(continuation);
        int i2 = 0;
        while (!XOxIOxOx2.isEmpty()) {
            WorkContinuationImpl workContinuationImpl = (WorkContinuationImpl) OxI.xx0X0(XOxIOxOx2);
            List<? extends WorkRequest> work = workContinuationImpl.getWork();
            IIX0o.oO(work, "current.work");
            List<? extends WorkRequest> list = work;
            if ((list instanceof Collection) && list.isEmpty()) {
                i = 0;
            } else {
                Iterator<T> it = list.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (((WorkRequest) it.next()).getWorkSpec().constraints.hasContentUriTriggers() && (i = i + 1) < 0) {
                        CollectionsKt__CollectionsKt.oxxXoxO();
                    }
                }
            }
            i2 += i;
            List<WorkContinuationImpl> parents = workContinuationImpl.getParents();
            if (parents != null) {
                XOxIOxOx2.addAll(parents);
            }
        }
        if (i2 == 0) {
            return;
        }
        int countNonFinishedContentUriTriggerWorkers = workDatabase.workSpecDao().countNonFinishedContentUriTriggerWorkers();
        int contentUriTriggerWorkersLimit = configuration.getContentUriTriggerWorkersLimit();
        if (countNonFinishedContentUriTriggerWorkers + i2 <= contentUriTriggerWorkersLimit) {
            return;
        }
        throw new IllegalArgumentException("Too many workers with contentUriTriggers are enqueued:\ncontentUriTrigger workers limit: " + contentUriTriggerWorkersLimit + ";\nalready enqueued count: " + countNonFinishedContentUriTriggerWorkers + ";\ncurrent enqueue operation count: " + i2 + ".\nTo address this issue you can: \n1. enqueue less workers or batch some of workers with content uri triggers together;\n2. increase limit via Configuration.Builder.setContentUriTriggerWorkersLimit;\nPlease beware that workers with content uri triggers immediately occupy slots in JobScheduler so no updates to content uris are missed.");
    }

    @OXOo.OOXIXo
    public static final WorkSpec tryDelegateConstrainedWorkSpec(@OXOo.OOXIXo WorkSpec workSpec) {
        IIX0o.x0xO0oo(workSpec, "workSpec");
        Constraints constraints = workSpec.constraints;
        String str = workSpec.workerClassName;
        if (IIX0o.Oxx0IOOO(str, ConstraintTrackingWorker.class.getName())) {
            return workSpec;
        }
        if (!constraints.requiresBatteryNotLow() && !constraints.requiresStorageNotLow()) {
            return workSpec;
        }
        Data build = new Data.Builder().putAll(workSpec.input).putString(ConstraintTrackingWorkerKt.ARGUMENT_CLASS_NAME, str).build();
        String name = ConstraintTrackingWorker.class.getName();
        IIX0o.oO(name, "name");
        return WorkSpec.copy$default(workSpec, null, null, name, null, build, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, null, 16777195, null);
    }

    @OXOo.OOXIXo
    @VisibleForTesting
    public static final WorkSpec tryDelegateRemoteListenableWorker(@OXOo.OOXIXo WorkSpec workSpec) {
        IIX0o.x0xO0oo(workSpec, "workSpec");
        boolean hasKeyWithValueOfType = workSpec.input.hasKeyWithValueOfType(ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME, String.class);
        boolean hasKeyWithValueOfType2 = workSpec.input.hasKeyWithValueOfType(ARGUMENT_SERVICE_PACKAGE_NAME, String.class);
        boolean hasKeyWithValueOfType3 = workSpec.input.hasKeyWithValueOfType(ARGUMENT_SERVICE_CLASS_NAME, String.class);
        if (hasKeyWithValueOfType || !hasKeyWithValueOfType2 || !hasKeyWithValueOfType3) {
            return workSpec;
        }
        return WorkSpec.copy$default(workSpec, null, null, REMOTE_DELEGATING_LISTENABLE_WORKER_CLASS_NAME, null, new Data.Builder().putAll(workSpec.input).putString(ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME, workSpec.workerClassName).build(), null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, null, 16777195, null);
    }

    private static final boolean usesScheduler(List<? extends Scheduler> list, String str) {
        try {
            Class<?> cls = Class.forName(str);
            List<? extends Scheduler> list2 = list;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                return false;
            }
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                if (cls.isAssignableFrom(((Scheduler) it.next()).getClass())) {
                    return true;
                }
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @OXOo.OOXIXo
    public static final WorkSpec wrapWorkSpecIfNeeded(@OXOo.OOXIXo List<? extends Scheduler> schedulers, @OXOo.OOXIXo WorkSpec workSpec) {
        IIX0o.x0xO0oo(schedulers, "schedulers");
        IIX0o.x0xO0oo(workSpec, "workSpec");
        WorkSpec tryDelegateRemoteListenableWorker = tryDelegateRemoteListenableWorker(workSpec);
        int i = Build.VERSION.SDK_INT;
        if (23 <= i && i < 26) {
            return tryDelegateConstrainedWorkSpec(tryDelegateRemoteListenableWorker);
        }
        if (i <= 22 && usesScheduler(schedulers, Schedulers.GCM_SCHEDULER)) {
            return tryDelegateConstrainedWorkSpec(tryDelegateRemoteListenableWorker);
        }
        return tryDelegateRemoteListenableWorker;
    }
}
