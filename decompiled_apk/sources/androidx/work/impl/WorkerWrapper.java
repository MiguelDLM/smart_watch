package androidx.work.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Clock;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.ListenableFutureKt;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Ox0O;
import kotlinx.coroutines.XI0IXoo;

@XX({"SMAP\nWorkerWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkerWrapper.kt\nandroidx/work/impl/WorkerWrapper\n+ 2 LoggerExt.kt\nandroidx/work/LoggerExtKt\n*L\n1#1,607:1\n29#2:608\n29#2:609\n27#2:610\n32#2:611\n19#2:612\n19#2:613\n24#2:614\n24#2:615\n24#2:616\n24#2:617\n19#2:618\n*S KotlinDebug\n*F\n+ 1 WorkerWrapper.kt\nandroidx/work/impl/WorkerWrapper\n*L\n206#1:608\n240#1:609\n315#1:610\n318#1:611\n354#1:612\n367#1:613\n374#1:614\n381#1:615\n384#1:616\n477#1:617\n151#1:618\n*E\n"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class WorkerWrapper {

    @OXOo.OOXIXo
    private final Context appContext;

    @OXOo.oOoXoXO
    private final ListenableWorker builderWorker;

    @OXOo.OOXIXo
    private final Clock clock;

    @OXOo.OOXIXo
    private final Configuration configuration;

    @OXOo.OOXIXo
    private final DependencyDao dependencyDao;

    @OXOo.OOXIXo
    private final ForegroundProcessor foregroundProcessor;

    @OXOo.OOXIXo
    private final WorkerParameters.RuntimeExtras runtimeExtras;

    @OXOo.OOXIXo
    private final List<String> tags;

    @OXOo.OOXIXo
    private final WorkDatabase workDatabase;

    @OXOo.OOXIXo
    private final String workDescription;

    @OXOo.OOXIXo
    private final WorkSpec workSpec;

    @OXOo.OOXIXo
    private final WorkSpecDao workSpecDao;

    @OXOo.OOXIXo
    private final String workSpecId;

    @OXOo.OOXIXo
    private final TaskExecutor workTaskExecutor;

    @OXOo.OOXIXo
    private final XI0IXoo workerJob;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public static final class Builder {

        @OXOo.OOXIXo
        private final Context appContext;

        @OXOo.OOXIXo
        private final Configuration configuration;

        @OXOo.OOXIXo
        private final ForegroundProcessor foregroundProcessor;

        @OXOo.OOXIXo
        private WorkerParameters.RuntimeExtras runtimeExtras;

        @OXOo.OOXIXo
        private final List<String> tags;

        @OXOo.OOXIXo
        private final WorkDatabase workDatabase;

        @OXOo.OOXIXo
        private final WorkSpec workSpec;

        @OXOo.OOXIXo
        private final TaskExecutor workTaskExecutor;

        @OXOo.oOoXoXO
        private ListenableWorker worker;

        @SuppressLint({"LambdaLast"})
        public Builder(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Configuration configuration, @OXOo.OOXIXo TaskExecutor workTaskExecutor, @OXOo.OOXIXo ForegroundProcessor foregroundProcessor, @OXOo.OOXIXo WorkDatabase workDatabase, @OXOo.OOXIXo WorkSpec workSpec, @OXOo.OOXIXo List<String> tags) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(configuration, "configuration");
            IIX0o.x0xO0oo(workTaskExecutor, "workTaskExecutor");
            IIX0o.x0xO0oo(foregroundProcessor, "foregroundProcessor");
            IIX0o.x0xO0oo(workDatabase, "workDatabase");
            IIX0o.x0xO0oo(workSpec, "workSpec");
            IIX0o.x0xO0oo(tags, "tags");
            this.configuration = configuration;
            this.workTaskExecutor = workTaskExecutor;
            this.foregroundProcessor = foregroundProcessor;
            this.workDatabase = workDatabase;
            this.workSpec = workSpec;
            this.tags = tags;
            Context applicationContext = context.getApplicationContext();
            IIX0o.oO(applicationContext, "context.applicationContext");
            this.appContext = applicationContext;
            this.runtimeExtras = new WorkerParameters.RuntimeExtras();
        }

        @OXOo.OOXIXo
        public final WorkerWrapper build() {
            return new WorkerWrapper(this);
        }

        @OXOo.OOXIXo
        public final Context getAppContext() {
            return this.appContext;
        }

        @OXOo.OOXIXo
        public final Configuration getConfiguration() {
            return this.configuration;
        }

        @OXOo.OOXIXo
        public final ForegroundProcessor getForegroundProcessor() {
            return this.foregroundProcessor;
        }

        @OXOo.OOXIXo
        public final WorkerParameters.RuntimeExtras getRuntimeExtras() {
            return this.runtimeExtras;
        }

        @OXOo.OOXIXo
        public final List<String> getTags() {
            return this.tags;
        }

        @OXOo.OOXIXo
        public final WorkDatabase getWorkDatabase() {
            return this.workDatabase;
        }

        @OXOo.OOXIXo
        public final WorkSpec getWorkSpec() {
            return this.workSpec;
        }

        @OXOo.OOXIXo
        public final TaskExecutor getWorkTaskExecutor() {
            return this.workTaskExecutor;
        }

        @OXOo.oOoXoXO
        public final ListenableWorker getWorker() {
            return this.worker;
        }

        public final void setRuntimeExtras(@OXOo.OOXIXo WorkerParameters.RuntimeExtras runtimeExtras) {
            IIX0o.x0xO0oo(runtimeExtras, "<set-?>");
            this.runtimeExtras = runtimeExtras;
        }

        public final void setWorker(@OXOo.oOoXoXO ListenableWorker listenableWorker) {
            this.worker = listenableWorker;
        }

        @OXOo.OOXIXo
        public final Builder withRuntimeExtras(@OXOo.oOoXoXO WorkerParameters.RuntimeExtras runtimeExtras) {
            if (runtimeExtras != null) {
                this.runtimeExtras = runtimeExtras;
            }
            return this;
        }

        @OXOo.OOXIXo
        @VisibleForTesting
        public final Builder withWorker(@OXOo.OOXIXo ListenableWorker worker) {
            IIX0o.x0xO0oo(worker, "worker");
            this.worker = worker;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Resolution {

        /* loaded from: classes.dex */
        public static final class Failed extends Resolution {

            @OXOo.OOXIXo
            private final ListenableWorker.Result result;

            /* JADX WARN: Multi-variable type inference failed */
            public Failed() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            @OXOo.OOXIXo
            public final ListenableWorker.Result getResult() {
                return this.result;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failed(@OXOo.OOXIXo ListenableWorker.Result result) {
                super(null);
                IIX0o.x0xO0oo(result, "result");
                this.result = result;
            }

            public /* synthetic */ Failed(ListenableWorker.Result result, int i, IIXOooo iIXOooo) {
                this((i & 1) != 0 ? new ListenableWorker.Result.Failure() : result);
            }
        }

        /* loaded from: classes.dex */
        public static final class Finished extends Resolution {

            @OXOo.OOXIXo
            private final ListenableWorker.Result result;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Finished(@OXOo.OOXIXo ListenableWorker.Result result) {
                super(null);
                IIX0o.x0xO0oo(result, "result");
                this.result = result;
            }

            @OXOo.OOXIXo
            public final ListenableWorker.Result getResult() {
                return this.result;
            }
        }

        /* loaded from: classes.dex */
        public static final class ResetWorkerStatus extends Resolution {
            private final int reason;

            public ResetWorkerStatus() {
                this(0, 1, null);
            }

            public final int getReason() {
                return this.reason;
            }

            public ResetWorkerStatus(int i) {
                super(null);
                this.reason = i;
            }

            public /* synthetic */ ResetWorkerStatus(int i, int i2, IIXOooo iIXOooo) {
                this((i2 & 1) != 0 ? -256 : i);
            }
        }

        public /* synthetic */ Resolution(IIXOooo iIXOooo) {
            this();
        }

        private Resolution() {
        }
    }

    public WorkerWrapper(@OXOo.OOXIXo Builder builder) {
        XI0IXoo I0Io2;
        IIX0o.x0xO0oo(builder, "builder");
        WorkSpec workSpec = builder.getWorkSpec();
        this.workSpec = workSpec;
        this.appContext = builder.getAppContext();
        this.workSpecId = workSpec.id;
        this.runtimeExtras = builder.getRuntimeExtras();
        this.builderWorker = builder.getWorker();
        this.workTaskExecutor = builder.getWorkTaskExecutor();
        Configuration configuration = builder.getConfiguration();
        this.configuration = configuration;
        this.clock = configuration.getClock();
        this.foregroundProcessor = builder.getForegroundProcessor();
        WorkDatabase workDatabase = builder.getWorkDatabase();
        this.workDatabase = workDatabase;
        this.workSpecDao = workDatabase.workSpecDao();
        this.dependencyDao = workDatabase.dependencyDao();
        List<String> tags = builder.getTags();
        this.tags = tags;
        this.workDescription = createWorkDescription(tags);
        I0Io2 = Ox0O.I0Io(null, 1, null);
        this.workerJob = I0Io2;
    }

    private final String createWorkDescription(List<String> list) {
        return "Work [ id=" + this.workSpecId + ", tags={ " + CollectionsKt___CollectionsKt.OoIXo(list, ",", null, null, 0, null, null, 62, null) + " } ]";
    }

    private final boolean handleResult(ListenableWorker.Result result) {
        if (result instanceof ListenableWorker.Result.Success) {
            String access$getTAG$p = WorkerWrapperKt.access$getTAG$p();
            Logger.get().info(access$getTAG$p, "Worker result SUCCESS for " + this.workDescription);
            if (this.workSpec.isPeriodic()) {
                return resetPeriodic();
            }
            return setSucceeded(result);
        }
        if (result instanceof ListenableWorker.Result.Retry) {
            String access$getTAG$p2 = WorkerWrapperKt.access$getTAG$p();
            Logger.get().info(access$getTAG$p2, "Worker result RETRY for " + this.workDescription);
            return reschedule(-256);
        }
        String access$getTAG$p3 = WorkerWrapperKt.access$getTAG$p();
        Logger.get().info(access$getTAG$p3, "Worker result FAILURE for " + this.workDescription);
        if (this.workSpec.isPeriodic()) {
            return resetPeriodic();
        }
        if (result == null) {
            result = new ListenableWorker.Result.Failure();
        }
        return setFailed(result);
    }

    private final void iterativelyFailWorkAndDependents(String str) {
        List XOxIOxOx2 = CollectionsKt__CollectionsKt.XOxIOxOx(str);
        while (!XOxIOxOx2.isEmpty()) {
            String str2 = (String) OxI.xx0X0(XOxIOxOx2);
            if (this.workSpecDao.getState(str2) != WorkInfo.State.CANCELLED) {
                this.workSpecDao.setState(WorkInfo.State.FAILED, str2);
            }
            XOxIOxOx2.addAll(this.dependencyDao.getDependentWorkIds(str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean onWorkFinished(ListenableWorker.Result result) {
        WorkInfo.State state = this.workSpecDao.getState(this.workSpecId);
        this.workDatabase.workProgressDao().delete(this.workSpecId);
        if (state == null) {
            return false;
        }
        if (state == WorkInfo.State.RUNNING) {
            return handleResult(result);
        }
        if (state.isFinished()) {
            return false;
        }
        return reschedule(WorkInfo.STOP_REASON_UNKNOWN);
    }

    private final boolean reschedule(int i) {
        this.workSpecDao.setState(WorkInfo.State.ENQUEUED, this.workSpecId);
        this.workSpecDao.setLastEnqueueTime(this.workSpecId, this.clock.currentTimeMillis());
        this.workSpecDao.resetWorkSpecNextScheduleTimeOverride(this.workSpecId, this.workSpec.getNextScheduleTimeOverrideGeneration());
        this.workSpecDao.markWorkSpecScheduled(this.workSpecId, -1L);
        this.workSpecDao.setStopReason(this.workSpecId, i);
        return true;
    }

    private final boolean resetPeriodic() {
        this.workSpecDao.setLastEnqueueTime(this.workSpecId, this.clock.currentTimeMillis());
        this.workSpecDao.setState(WorkInfo.State.ENQUEUED, this.workSpecId);
        this.workSpecDao.resetWorkSpecRunAttemptCount(this.workSpecId);
        this.workSpecDao.resetWorkSpecNextScheduleTimeOverride(this.workSpecId, this.workSpec.getNextScheduleTimeOverrideGeneration());
        this.workSpecDao.incrementPeriodCount(this.workSpecId);
        this.workSpecDao.markWorkSpecScheduled(this.workSpecId, -1L);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean resetWorkerStatus(int i) {
        WorkInfo.State state = this.workSpecDao.getState(this.workSpecId);
        if (state != null && !state.isFinished()) {
            String access$getTAG$p = WorkerWrapperKt.access$getTAG$p();
            Logger.get().debug(access$getTAG$p, "Status for " + this.workSpecId + " is " + state + "; not doing any work and rescheduling for later execution");
            this.workSpecDao.setState(WorkInfo.State.ENQUEUED, this.workSpecId);
            this.workSpecDao.setStopReason(this.workSpecId, i);
            this.workSpecDao.markWorkSpecScheduled(this.workSpecId, -1L);
            return true;
        }
        String access$getTAG$p2 = WorkerWrapperKt.access$getTAG$p();
        Logger.get().debug(access$getTAG$p2, "Status for " + this.workSpecId + " is " + state + " ; not doing any work");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object runWorker(kotlin.coroutines.I0Io<? super androidx.work.impl.WorkerWrapper.Resolution> r24) {
        /*
            Method dump skipped, instructions count: 616
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.WorkerWrapper.runWorker(kotlin.coroutines.I0Io):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean runWorker$lambda$1(WorkerWrapper workerWrapper) {
        WorkSpec workSpec = workerWrapper.workSpec;
        if (workSpec.state != WorkInfo.State.ENQUEUED) {
            String access$getTAG$p = WorkerWrapperKt.access$getTAG$p();
            Logger.get().debug(access$getTAG$p, workerWrapper.workSpec.workerClassName + " is not in ENQUEUED state. Nothing more to do");
            return Boolean.TRUE;
        }
        if ((workSpec.isPeriodic() || workerWrapper.workSpec.isBackedOff()) && workerWrapper.clock.currentTimeMillis() < workerWrapper.workSpec.calculateNextRunTime()) {
            Logger.get().debug(WorkerWrapperKt.access$getTAG$p(), "Delaying execution for " + workerWrapper.workSpec.workerClassName + " because it is being executed before schedule.");
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private final boolean setSucceeded(ListenableWorker.Result result) {
        this.workSpecDao.setState(WorkInfo.State.SUCCEEDED, this.workSpecId);
        IIX0o.x0XOIxOo(result, "null cannot be cast to non-null type androidx.work.ListenableWorker.Result.Success");
        Data outputData = ((ListenableWorker.Result.Success) result).getOutputData();
        IIX0o.oO(outputData, "success.outputData");
        this.workSpecDao.setOutput(this.workSpecId, outputData);
        long currentTimeMillis = this.clock.currentTimeMillis();
        for (String str : this.dependencyDao.getDependentWorkIds(this.workSpecId)) {
            if (this.workSpecDao.getState(str) == WorkInfo.State.BLOCKED && this.dependencyDao.hasCompletedAllPrerequisites(str)) {
                String access$getTAG$p = WorkerWrapperKt.access$getTAG$p();
                Logger.get().info(access$getTAG$p, "Setting status to enqueued for " + str);
                this.workSpecDao.setState(WorkInfo.State.ENQUEUED, str);
                this.workSpecDao.setLastEnqueueTime(str, currentTimeMillis);
            }
        }
        return false;
    }

    private final boolean trySetRunning() {
        Object runInTransaction = this.workDatabase.runInTransaction((Callable<Object>) new Callable() { // from class: androidx.work.impl.x0xO0oo
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean trySetRunning$lambda$11;
                trySetRunning$lambda$11 = WorkerWrapper.trySetRunning$lambda$11(WorkerWrapper.this);
                return trySetRunning$lambda$11;
            }
        });
        IIX0o.oO(runInTransaction, "workDatabase.runInTransa…e\n            }\n        )");
        return ((Boolean) runInTransaction).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean trySetRunning$lambda$11(WorkerWrapper workerWrapper) {
        boolean z;
        if (workerWrapper.workSpecDao.getState(workerWrapper.workSpecId) == WorkInfo.State.ENQUEUED) {
            workerWrapper.workSpecDao.setState(WorkInfo.State.RUNNING, workerWrapper.workSpecId);
            workerWrapper.workSpecDao.incrementWorkSpecRunAttemptCount(workerWrapper.workSpecId);
            workerWrapper.workSpecDao.setStopReason(workerWrapper.workSpecId, -256);
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    @OXOo.OOXIXo
    public final WorkGenerationalId getWorkGenerationalId() {
        return WorkSpecKt.generationalId(this.workSpec);
    }

    @OXOo.OOXIXo
    public final WorkSpec getWorkSpec() {
        return this.workSpec;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void interrupt(int i) {
        this.workerJob.II0xO0(new WorkerStoppedException(i));
    }

    @OXOo.OOXIXo
    public final ListenableFuture<Boolean> launch() {
        XI0IXoo I0Io2;
        CoroutineDispatcher taskCoroutineDispatcher = this.workTaskExecutor.getTaskCoroutineDispatcher();
        I0Io2 = Ox0O.I0Io(null, 1, null);
        return ListenableFutureKt.launchFuture$default(taskCoroutineDispatcher.plus(I0Io2), null, new WorkerWrapper$launch$1(this, null), 2, null);
    }

    @VisibleForTesting
    public final boolean setFailed(@OXOo.OOXIXo ListenableWorker.Result result) {
        IIX0o.x0xO0oo(result, "result");
        iterativelyFailWorkAndDependents(this.workSpecId);
        Data outputData = ((ListenableWorker.Result.Failure) result).getOutputData();
        IIX0o.oO(outputData, "failure.outputData");
        this.workSpecDao.resetWorkSpecNextScheduleTimeOverride(this.workSpecId, this.workSpec.getNextScheduleTimeOverrideGeneration());
        this.workSpecDao.setOutput(this.workSpecId, outputData);
        return false;
    }
}
