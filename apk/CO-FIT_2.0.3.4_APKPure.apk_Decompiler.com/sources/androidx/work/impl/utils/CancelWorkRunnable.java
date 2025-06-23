package androidx.work.impl.utils;

import OXOo.OOXIXo;
import XO0OX.xxIXOIIO;
import androidx.work.Operation;
import androidx.work.OperationKt;
import androidx.work.Tracer;
import androidx.work.WorkInfo;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import java.util.List;
import java.util.UUID;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.OxI;
import kotlin.jvm.internal.IIX0o;

@xxIXOIIO(name = "CancelWorkRunnable")
public final class CancelWorkRunnable {
    /* access modifiers changed from: private */
    public static final void cancel(WorkManagerImpl workManagerImpl, String str) {
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        IIX0o.oO(workDatabase, "workManagerImpl.workDatabase");
        iterativelyCancelWorkAndDependents(workDatabase, str);
        Processor processor = workManagerImpl.getProcessor();
        IIX0o.oO(processor, "workManagerImpl.processor");
        processor.stopAndCancelWork(str, 1);
        for (Scheduler cancel : workManagerImpl.getSchedulers()) {
            cancel.cancel(str);
        }
    }

    @OOXIXo
    public static final Operation forAll(@OOXIXo WorkManagerImpl workManagerImpl) {
        IIX0o.x0xO0oo(workManagerImpl, "workManagerImpl");
        Tracer tracer = workManagerImpl.getConfiguration().getTracer();
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        IIX0o.oO(serialTaskExecutor, "workManagerImpl.workTask…ecutor.serialTaskExecutor");
        return OperationKt.launchOperation(tracer, "CancelAllWork", serialTaskExecutor, new CancelWorkRunnable$forAll$1(workManagerImpl));
    }

    @OOXIXo
    public static final Operation forId(@OOXIXo UUID uuid, @OOXIXo WorkManagerImpl workManagerImpl) {
        IIX0o.x0xO0oo(uuid, "id");
        IIX0o.x0xO0oo(workManagerImpl, "workManagerImpl");
        Tracer tracer = workManagerImpl.getConfiguration().getTracer();
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        IIX0o.oO(serialTaskExecutor, "workManagerImpl.workTask…ecutor.serialTaskExecutor");
        return OperationKt.launchOperation(tracer, "CancelWorkById", serialTaskExecutor, new CancelWorkRunnable$forId$1(workManagerImpl, uuid));
    }

    @OOXIXo
    public static final Operation forName(@OOXIXo String str, @OOXIXo WorkManagerImpl workManagerImpl) {
        IIX0o.x0xO0oo(str, "name");
        IIX0o.x0xO0oo(workManagerImpl, "workManagerImpl");
        Tracer tracer = workManagerImpl.getConfiguration().getTracer();
        String str2 = "CancelWorkByName_" + str;
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        IIX0o.oO(serialTaskExecutor, "workManagerImpl.workTask…ecutor.serialTaskExecutor");
        return OperationKt.launchOperation(tracer, str2, serialTaskExecutor, new CancelWorkRunnable$forName$1(str, workManagerImpl));
    }

    public static final void forNameInline(@OOXIXo String str, @OOXIXo WorkManagerImpl workManagerImpl) {
        IIX0o.x0xO0oo(str, "name");
        IIX0o.x0xO0oo(workManagerImpl, "workManagerImpl");
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        IIX0o.oO(workDatabase, "workManagerImpl.workDatabase");
        workDatabase.runInTransaction((Runnable) new oIX0oI(workDatabase, str, workManagerImpl));
    }

    /* access modifiers changed from: private */
    public static final void forNameInline$lambda$0(WorkDatabase workDatabase, String str, WorkManagerImpl workManagerImpl) {
        for (String cancel : workDatabase.workSpecDao().getUnfinishedWorkWithName(str)) {
            cancel(workManagerImpl, cancel);
        }
    }

    @OOXIXo
    public static final Operation forTag(@OOXIXo String str, @OOXIXo WorkManagerImpl workManagerImpl) {
        IIX0o.x0xO0oo(str, "tag");
        IIX0o.x0xO0oo(workManagerImpl, "workManagerImpl");
        Tracer tracer = workManagerImpl.getConfiguration().getTracer();
        String str2 = "CancelWorkByTag_" + str;
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        IIX0o.oO(serialTaskExecutor, "workManagerImpl.workTask…ecutor.serialTaskExecutor");
        return OperationKt.launchOperation(tracer, str2, serialTaskExecutor, new CancelWorkRunnable$forTag$1(workManagerImpl, str));
    }

    private static final void iterativelyCancelWorkAndDependents(WorkDatabase workDatabase, String str) {
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        DependencyDao dependencyDao = workDatabase.dependencyDao();
        List XOxIOxOx2 = CollectionsKt__CollectionsKt.XOxIOxOx(str);
        while (!XOxIOxOx2.isEmpty()) {
            String str2 = (String) OxI.xx0X0(XOxIOxOx2);
            WorkInfo.State state = workSpecDao.getState(str2);
            if (!(state == WorkInfo.State.SUCCEEDED || state == WorkInfo.State.FAILED)) {
                workSpecDao.setCancelledState(str2);
            }
            XOxIOxOx2.addAll(dependencyDao.getDependentWorkIds(str2));
        }
    }

    /* access modifiers changed from: private */
    public static final void reschedulePendingWorkers(WorkManagerImpl workManagerImpl) {
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }
}
