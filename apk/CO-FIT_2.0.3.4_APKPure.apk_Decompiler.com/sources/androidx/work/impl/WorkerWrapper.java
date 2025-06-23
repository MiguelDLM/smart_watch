package androidx.work.impl;

import O0IoXXOx.XO;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
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
import com.huawei.openalliance.ad.constant.bn;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxI;
import kotlin.coroutines.I0Io;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Ox0O;
import kotlinx.coroutines.XI0IXoo;
import kotlinx.coroutines.oXIO0o0XI;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@XX({"SMAP\nWorkerWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkerWrapper.kt\nandroidx/work/impl/WorkerWrapper\n+ 2 LoggerExt.kt\nandroidx/work/LoggerExtKt\n*L\n1#1,607:1\n29#2:608\n29#2:609\n27#2:610\n32#2:611\n19#2:612\n19#2:613\n24#2:614\n24#2:615\n24#2:616\n24#2:617\n19#2:618\n*S KotlinDebug\n*F\n+ 1 WorkerWrapper.kt\nandroidx/work/impl/WorkerWrapper\n*L\n206#1:608\n240#1:609\n315#1:610\n318#1:611\n354#1:612\n367#1:613\n374#1:614\n381#1:615\n384#1:616\n477#1:617\n151#1:618\n*E\n"})
public final class WorkerWrapper {
    /* access modifiers changed from: private */
    @OOXIXo
    public final Context appContext;
    @oOoXoXO
    private final ListenableWorker builderWorker;
    @OOXIXo
    private final Clock clock;
    /* access modifiers changed from: private */
    @OOXIXo
    public final Configuration configuration;
    @OOXIXo
    private final DependencyDao dependencyDao;
    @OOXIXo
    private final ForegroundProcessor foregroundProcessor;
    @OOXIXo
    private final WorkerParameters.RuntimeExtras runtimeExtras;
    @OOXIXo
    private final List<String> tags;
    /* access modifiers changed from: private */
    @OOXIXo
    public final WorkDatabase workDatabase;
    @OOXIXo
    private final String workDescription;
    @OOXIXo
    private final WorkSpec workSpec;
    @OOXIXo
    private final WorkSpecDao workSpecDao;
    @OOXIXo
    private final String workSpecId;
    /* access modifiers changed from: private */
    @OOXIXo
    public final TaskExecutor workTaskExecutor;
    /* access modifiers changed from: private */
    @OOXIXo
    public final XI0IXoo workerJob = Ox0O.I0Io((oXIO0o0XI) null, 1, (Object) null);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Builder {
        @OOXIXo
        private final Context appContext;
        @OOXIXo
        private final Configuration configuration;
        @OOXIXo
        private final ForegroundProcessor foregroundProcessor;
        @OOXIXo
        private WorkerParameters.RuntimeExtras runtimeExtras = new WorkerParameters.RuntimeExtras();
        @OOXIXo
        private final List<String> tags;
        @OOXIXo
        private final WorkDatabase workDatabase;
        @OOXIXo
        private final WorkSpec workSpec;
        @OOXIXo
        private final TaskExecutor workTaskExecutor;
        @oOoXoXO
        private ListenableWorker worker;

        @SuppressLint({"LambdaLast"})
        public Builder(@OOXIXo Context context, @OOXIXo Configuration configuration2, @OOXIXo TaskExecutor taskExecutor, @OOXIXo ForegroundProcessor foregroundProcessor2, @OOXIXo WorkDatabase workDatabase2, @OOXIXo WorkSpec workSpec2, @OOXIXo List<String> list) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(configuration2, XO.f15419Oxx0IOOO);
            IIX0o.x0xO0oo(taskExecutor, "workTaskExecutor");
            IIX0o.x0xO0oo(foregroundProcessor2, "foregroundProcessor");
            IIX0o.x0xO0oo(workDatabase2, "workDatabase");
            IIX0o.x0xO0oo(workSpec2, "workSpec");
            IIX0o.x0xO0oo(list, com.baidu.mobads.sdk.internal.bn.l);
            this.configuration = configuration2;
            this.workTaskExecutor = taskExecutor;
            this.foregroundProcessor = foregroundProcessor2;
            this.workDatabase = workDatabase2;
            this.workSpec = workSpec2;
            this.tags = list;
            Context applicationContext = context.getApplicationContext();
            IIX0o.oO(applicationContext, "context.applicationContext");
            this.appContext = applicationContext;
        }

        @OOXIXo
        public final WorkerWrapper build() {
            return new WorkerWrapper(this);
        }

        @OOXIXo
        public final Context getAppContext() {
            return this.appContext;
        }

        @OOXIXo
        public final Configuration getConfiguration() {
            return this.configuration;
        }

        @OOXIXo
        public final ForegroundProcessor getForegroundProcessor() {
            return this.foregroundProcessor;
        }

        @OOXIXo
        public final WorkerParameters.RuntimeExtras getRuntimeExtras() {
            return this.runtimeExtras;
        }

        @OOXIXo
        public final List<String> getTags() {
            return this.tags;
        }

        @OOXIXo
        public final WorkDatabase getWorkDatabase() {
            return this.workDatabase;
        }

        @OOXIXo
        public final WorkSpec getWorkSpec() {
            return this.workSpec;
        }

        @OOXIXo
        public final TaskExecutor getWorkTaskExecutor() {
            return this.workTaskExecutor;
        }

        @oOoXoXO
        public final ListenableWorker getWorker() {
            return this.worker;
        }

        public final void setRuntimeExtras(@OOXIXo WorkerParameters.RuntimeExtras runtimeExtras2) {
            IIX0o.x0xO0oo(runtimeExtras2, "<set-?>");
            this.runtimeExtras = runtimeExtras2;
        }

        public final void setWorker(@oOoXoXO ListenableWorker listenableWorker) {
            this.worker = listenableWorker;
        }

        @OOXIXo
        public final Builder withRuntimeExtras(@oOoXoXO WorkerParameters.RuntimeExtras runtimeExtras2) {
            if (runtimeExtras2 != null) {
                this.runtimeExtras = runtimeExtras2;
            }
            return this;
        }

        @VisibleForTesting
        @OOXIXo
        public final Builder withWorker(@OOXIXo ListenableWorker listenableWorker) {
            IIX0o.x0xO0oo(listenableWorker, "worker");
            this.worker = listenableWorker;
            return this;
        }
    }

    public static abstract class Resolution {

        public static final class Failed extends Resolution {
            @OOXIXo
            private final ListenableWorker.Result result;

            public Failed() {
                this((ListenableWorker.Result) null, 1, (IIXOooo) null);
            }

            @OOXIXo
            public final ListenableWorker.Result getResult() {
                return this.result;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Failed(@OOXIXo ListenableWorker.Result result2) {
                super((IIXOooo) null);
                IIX0o.x0xO0oo(result2, "result");
                this.result = result2;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Failed(ListenableWorker.Result result2, int i, IIXOooo iIXOooo) {
                this((i & 1) != 0 ? new ListenableWorker.Result.Failure() : result2);
            }
        }

        public static final class Finished extends Resolution {
            @OOXIXo
            private final ListenableWorker.Result result;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Finished(@OOXIXo ListenableWorker.Result result2) {
                super((IIXOooo) null);
                IIX0o.x0xO0oo(result2, "result");
                this.result = result2;
            }

            @OOXIXo
            public final ListenableWorker.Result getResult() {
                return this.result;
            }
        }

        public static final class ResetWorkerStatus extends Resolution {
            private final int reason;

            public ResetWorkerStatus() {
                this(0, 1, (IIXOooo) null);
            }

            public final int getReason() {
                return this.reason;
            }

            public ResetWorkerStatus(int i) {
                super((IIXOooo) null);
                this.reason = i;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
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

    public WorkerWrapper(@OOXIXo Builder builder) {
        IIX0o.x0xO0oo(builder, "builder");
        WorkSpec workSpec2 = builder.getWorkSpec();
        this.workSpec = workSpec2;
        this.appContext = builder.getAppContext();
        this.workSpecId = workSpec2.id;
        this.runtimeExtras = builder.getRuntimeExtras();
        this.builderWorker = builder.getWorker();
        this.workTaskExecutor = builder.getWorkTaskExecutor();
        Configuration configuration2 = builder.getConfiguration();
        this.configuration = configuration2;
        this.clock = configuration2.getClock();
        this.foregroundProcessor = builder.getForegroundProcessor();
        WorkDatabase workDatabase2 = builder.getWorkDatabase();
        this.workDatabase = workDatabase2;
        this.workSpecDao = workDatabase2.workSpecDao();
        this.dependencyDao = workDatabase2.dependencyDao();
        List<String> tags2 = builder.getTags();
        this.tags = tags2;
        this.workDescription = createWorkDescription(tags2);
    }

    private final String createWorkDescription(List<String> list) {
        return "Work [ id=" + this.workSpecId + ", tags={ " + CollectionsKt___CollectionsKt.OoIXo(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Oox.oOoXoXO) null, 62, (Object) null) + " } ]";
    }

    private final boolean handleResult(ListenableWorker.Result result) {
        if (result instanceof ListenableWorker.Result.Success) {
            String access$getTAG$p = WorkerWrapperKt.TAG;
            Logger logger = Logger.get();
            logger.info(access$getTAG$p, "Worker result SUCCESS for " + this.workDescription);
            if (this.workSpec.isPeriodic()) {
                return resetPeriodic();
            }
            return setSucceeded(result);
        } else if (result instanceof ListenableWorker.Result.Retry) {
            String access$getTAG$p2 = WorkerWrapperKt.TAG;
            Logger logger2 = Logger.get();
            logger2.info(access$getTAG$p2, "Worker result RETRY for " + this.workDescription);
            return reschedule(-256);
        } else {
            String access$getTAG$p3 = WorkerWrapperKt.TAG;
            Logger logger3 = Logger.get();
            logger3.info(access$getTAG$p3, "Worker result FAILURE for " + this.workDescription);
            if (this.workSpec.isPeriodic()) {
                return resetPeriodic();
            }
            if (result == null) {
                result = new ListenableWorker.Result.Failure();
            }
            return setFailed(result);
        }
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

    /* access modifiers changed from: private */
    public final boolean onWorkFinished(ListenableWorker.Result result) {
        WorkInfo.State state = this.workSpecDao.getState(this.workSpecId);
        this.workDatabase.workProgressDao().delete(this.workSpecId);
        if (state == null) {
            return false;
        }
        if (state == WorkInfo.State.RUNNING) {
            return handleResult(result);
        }
        if (!state.isFinished()) {
            return reschedule(WorkInfo.STOP_REASON_UNKNOWN);
        }
        return false;
    }

    private final boolean reschedule(int i) {
        this.workSpecDao.setState(WorkInfo.State.ENQUEUED, this.workSpecId);
        this.workSpecDao.setLastEnqueueTime(this.workSpecId, this.clock.currentTimeMillis());
        this.workSpecDao.resetWorkSpecNextScheduleTimeOverride(this.workSpecId, this.workSpec.getNextScheduleTimeOverrideGeneration());
        this.workSpecDao.markWorkSpecScheduled(this.workSpecId, -1);
        this.workSpecDao.setStopReason(this.workSpecId, i);
        return true;
    }

    private final boolean resetPeriodic() {
        this.workSpecDao.setLastEnqueueTime(this.workSpecId, this.clock.currentTimeMillis());
        this.workSpecDao.setState(WorkInfo.State.ENQUEUED, this.workSpecId);
        this.workSpecDao.resetWorkSpecRunAttemptCount(this.workSpecId);
        this.workSpecDao.resetWorkSpecNextScheduleTimeOverride(this.workSpecId, this.workSpec.getNextScheduleTimeOverrideGeneration());
        this.workSpecDao.incrementPeriodCount(this.workSpecId);
        this.workSpecDao.markWorkSpecScheduled(this.workSpecId, -1);
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean resetWorkerStatus(int i) {
        WorkInfo.State state = this.workSpecDao.getState(this.workSpecId);
        if (state == null || state.isFinished()) {
            String access$getTAG$p = WorkerWrapperKt.TAG;
            Logger logger = Logger.get();
            logger.debug(access$getTAG$p, "Status for " + this.workSpecId + " is " + state + " ; not doing any work");
            return false;
        }
        String access$getTAG$p2 = WorkerWrapperKt.TAG;
        Logger logger2 = Logger.get();
        logger2.debug(access$getTAG$p2, "Status for " + this.workSpecId + " is " + state + "; not doing any work and rescheduling for later execution");
        this.workSpecDao.setState(WorkInfo.State.ENQUEUED, this.workSpecId);
        this.workSpecDao.setStopReason(this.workSpecId, i);
        this.workSpecDao.markWorkSpecScheduled(this.workSpecId, -1);
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object runWorker(kotlin.coroutines.I0Io<? super androidx.work.impl.WorkerWrapper.Resolution> r24) {
        /*
            r23 = this;
            r1 = r23
            r0 = r24
            boolean r2 = r0 instanceof androidx.work.impl.WorkerWrapper$runWorker$1
            if (r2 == 0) goto L_0x0017
            r2 = r0
            androidx.work.impl.WorkerWrapper$runWorker$1 r2 = (androidx.work.impl.WorkerWrapper$runWorker$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001c
        L_0x0017:
            androidx.work.impl.WorkerWrapper$runWorker$1 r2 = new androidx.work.impl.WorkerWrapper$runWorker$1
            r2.<init>(r1, r0)
        L_0x001c:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0045
            if (r4 != r5) goto L_0x003d
            java.lang.Object r3 = r2.L$1
            androidx.work.WorkerParameters r3 = (androidx.work.WorkerParameters) r3
            java.lang.Object r2 = r2.L$0
            androidx.work.impl.WorkerWrapper r2 = (androidx.work.impl.WorkerWrapper) r2
            kotlin.I0oOoX.x0XOIxOo(r0)     // Catch:{ CancellationException -> 0x003a, all -> 0x0037 }
            goto L_0x01f7
        L_0x0037:
            r0 = move-exception
            goto L_0x020b
        L_0x003a:
            r0 = move-exception
            goto L_0x0249
        L_0x003d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0045:
            kotlin.I0oOoX.x0XOIxOo(r0)
            androidx.work.Configuration r0 = r1.configuration
            androidx.work.Tracer r0 = r0.getTracer()
            boolean r0 = r0.isEnabled()
            androidx.work.impl.model.WorkSpec r4 = r1.workSpec
            java.lang.String r4 = r4.getTraceTag()
            if (r0 == 0) goto L_0x006b
            if (r4 == 0) goto L_0x006b
            androidx.work.Configuration r7 = r1.configuration
            androidx.work.Tracer r7 = r7.getTracer()
            androidx.work.impl.model.WorkSpec r8 = r1.workSpec
            int r8 = r8.hashCode()
            r7.beginAsyncSection(r4, r8)
        L_0x006b:
            androidx.work.impl.WorkDatabase r7 = r1.workDatabase
            androidx.work.impl.oO r8 = new androidx.work.impl.oO
            r8.<init>(r1)
            java.lang.Object r7 = r7.runInTransaction(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            java.lang.String r8 = "shouldExit"
            kotlin.jvm.internal.IIX0o.oO(r7, r8)
            boolean r7 = r7.booleanValue()
            r8 = 0
            if (r7 == 0) goto L_0x008a
            androidx.work.impl.WorkerWrapper$Resolution$ResetWorkerStatus r0 = new androidx.work.impl.WorkerWrapper$Resolution$ResetWorkerStatus
            r0.<init>(r8, r5, r6)
            return r0
        L_0x008a:
            androidx.work.impl.model.WorkSpec r7 = r1.workSpec
            boolean r7 = r7.isPeriodic()
            if (r7 == 0) goto L_0x0098
            androidx.work.impl.model.WorkSpec r7 = r1.workSpec
            androidx.work.Data r7 = r7.input
        L_0x0096:
            r11 = r7
            goto L_0x00eb
        L_0x0098:
            androidx.work.Configuration r7 = r1.configuration
            androidx.work.InputMergerFactory r7 = r7.getInputMergerFactory()
            androidx.work.impl.model.WorkSpec r9 = r1.workSpec
            java.lang.String r9 = r9.inputMergerClassName
            androidx.work.InputMerger r7 = r7.createInputMergerWithDefaultFallback(r9)
            if (r7 != 0) goto L_0x00ce
            java.lang.String r0 = androidx.work.impl.WorkerWrapperKt.TAG
            androidx.work.Logger r2 = androidx.work.Logger.get()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Could not create Input Merger "
            r3.append(r4)
            androidx.work.impl.model.WorkSpec r4 = r1.workSpec
            java.lang.String r4 = r4.inputMergerClassName
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.error(r0, r3)
            androidx.work.impl.WorkerWrapper$Resolution$Failed r0 = new androidx.work.impl.WorkerWrapper$Resolution$Failed
            r0.<init>(r6, r5, r6)
            return r0
        L_0x00ce:
            androidx.work.impl.model.WorkSpec r9 = r1.workSpec
            androidx.work.Data r9 = r9.input
            java.util.List r9 = kotlin.collections.oI0IIXIo.OOXIXo(r9)
            java.util.Collection r9 = (java.util.Collection) r9
            androidx.work.impl.model.WorkSpecDao r10 = r1.workSpecDao
            java.lang.String r11 = r1.workSpecId
            java.util.List r10 = r10.getInputsFromPrerequisites(r11)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.List r9 = kotlin.collections.CollectionsKt___CollectionsKt.o0xIIX0(r9, r10)
            androidx.work.Data r7 = r7.merge(r9)
            goto L_0x0096
        L_0x00eb:
            androidx.work.WorkerParameters r7 = new androidx.work.WorkerParameters
            java.lang.String r9 = r1.workSpecId
            java.util.UUID r10 = java.util.UUID.fromString(r9)
            java.util.List<java.lang.String> r9 = r1.tags
            r12 = r9
            java.util.Collection r12 = (java.util.Collection) r12
            androidx.work.WorkerParameters$RuntimeExtras r13 = r1.runtimeExtras
            androidx.work.impl.model.WorkSpec r9 = r1.workSpec
            int r14 = r9.runAttemptCount
            int r15 = r9.getGeneration()
            androidx.work.Configuration r9 = r1.configuration
            java.util.concurrent.Executor r16 = r9.getExecutor()
            androidx.work.Configuration r9 = r1.configuration
            kotlin.coroutines.CoroutineContext r17 = r9.getWorkerCoroutineContext()
            androidx.work.impl.utils.taskexecutor.TaskExecutor r9 = r1.workTaskExecutor
            androidx.work.Configuration r8 = r1.configuration
            androidx.work.WorkerFactory r19 = r8.getWorkerFactory()
            androidx.work.impl.utils.WorkProgressUpdater r8 = new androidx.work.impl.utils.WorkProgressUpdater
            androidx.work.impl.WorkDatabase r5 = r1.workDatabase
            androidx.work.impl.utils.taskexecutor.TaskExecutor r6 = r1.workTaskExecutor
            r8.<init>(r5, r6)
            androidx.work.impl.utils.WorkForegroundUpdater r5 = new androidx.work.impl.utils.WorkForegroundUpdater
            androidx.work.impl.WorkDatabase r6 = r1.workDatabase
            r18 = r9
            androidx.work.impl.foreground.ForegroundProcessor r9 = r1.foregroundProcessor
            r22 = r3
            androidx.work.impl.utils.taskexecutor.TaskExecutor r3 = r1.workTaskExecutor
            r5.<init>(r6, r9, r3)
            r3 = r18
            r9 = r7
            r20 = r8
            r21 = r5
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            androidx.work.ListenableWorker r3 = r1.builderWorker
            if (r3 != 0) goto L_0x018e
            androidx.work.Configuration r3 = r1.configuration     // Catch:{ all -> 0x014d }
            androidx.work.WorkerFactory r3 = r3.getWorkerFactory()     // Catch:{ all -> 0x014d }
            android.content.Context r5 = r1.appContext     // Catch:{ all -> 0x014d }
            androidx.work.impl.model.WorkSpec r6 = r1.workSpec     // Catch:{ all -> 0x014d }
            java.lang.String r6 = r6.workerClassName     // Catch:{ all -> 0x014d }
            androidx.work.ListenableWorker r3 = r3.createWorkerWithDefaultFallback(r5, r6, r7)     // Catch:{ all -> 0x014d }
            goto L_0x018e
        L_0x014d:
            r0 = move-exception
            java.lang.String r2 = androidx.work.impl.WorkerWrapperKt.TAG
            androidx.work.Logger r3 = androidx.work.Logger.get()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Could not create Worker "
            r4.append(r5)
            androidx.work.impl.model.WorkSpec r5 = r1.workSpec
            java.lang.String r5 = r5.workerClassName
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.error(r2, r4)
            androidx.work.Configuration r2 = r1.configuration
            androidx.core.util.Consumer r2 = r2.getWorkerInitializationExceptionHandler()
            if (r2 == 0) goto L_0x0186
            androidx.work.WorkerExceptionInfo r3 = new androidx.work.WorkerExceptionInfo
            androidx.work.impl.model.WorkSpec r4 = r1.workSpec
            java.lang.String r4 = r4.workerClassName
            r3.<init>(r4, r7, r0)
            java.lang.String r0 = androidx.work.impl.WorkerWrapperKt.TAG
            androidx.work.impl.utils.WorkerExceptionUtilsKt.safeAccept(r2, r3, r0)
        L_0x0186:
            androidx.work.impl.WorkerWrapper$Resolution$Failed r0 = new androidx.work.impl.WorkerWrapper$Resolution$Failed
            r2 = 1
            r3 = 0
            r0.<init>(r3, r2, r3)
            return r0
        L_0x018e:
            r3.setUsed()
            kotlin.coroutines.CoroutineContext r5 = r2.getContext()
            kotlinx.coroutines.oXIO0o0XI$II0xO0 r6 = kotlinx.coroutines.oXIO0o0XI.f20106xxIXOIIO
            kotlin.coroutines.CoroutineContext$oIX0oI r5 = r5.get(r6)
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r5)
            kotlinx.coroutines.oXIO0o0XI r5 = (kotlinx.coroutines.oXIO0o0XI) r5
            androidx.work.impl.WorkerWrapper$runWorker$2 r6 = new androidx.work.impl.WorkerWrapper$runWorker$2
            r6.<init>(r3, r0, r4, r1)
            r5.Oo(r6)
            boolean r0 = r23.trySetRunning()
            if (r0 != 0) goto L_0x01b7
            androidx.work.impl.WorkerWrapper$Resolution$ResetWorkerStatus r0 = new androidx.work.impl.WorkerWrapper$Resolution$ResetWorkerStatus
            r4 = 1
            r6 = 0
            r8 = 0
            r0.<init>(r8, r4, r6)
            return r0
        L_0x01b7:
            r4 = 1
            r6 = 0
            r8 = 0
            boolean r0 = r5.isCancelled()
            if (r0 == 0) goto L_0x01c6
            androidx.work.impl.WorkerWrapper$Resolution$ResetWorkerStatus r0 = new androidx.work.impl.WorkerWrapper$Resolution$ResetWorkerStatus
            r0.<init>(r8, r4, r6)
            return r0
        L_0x01c6:
            androidx.work.ForegroundUpdater r0 = r7.getForegroundUpdater()
            java.lang.String r4 = "params.foregroundUpdater"
            kotlin.jvm.internal.IIX0o.oO(r0, r4)
            androidx.work.impl.utils.taskexecutor.TaskExecutor r4 = r1.workTaskExecutor
            java.util.concurrent.Executor r4 = r4.getMainThreadExecutor()
            java.lang.String r5 = "workTaskExecutor.getMainThreadExecutor()"
            kotlin.jvm.internal.IIX0o.oO(r4, r5)
            kotlinx.coroutines.CoroutineDispatcher r4 = kotlinx.coroutines.O00XxXI.I0Io(r4)
            androidx.work.impl.WorkerWrapper$runWorker$result$1 r5 = new androidx.work.impl.WorkerWrapper$runWorker$result$1     // Catch:{ CancellationException -> 0x0208, all -> 0x0204 }
            r6 = 0
            r5.<init>(r1, r3, r0, r6)     // Catch:{ CancellationException -> 0x0208, all -> 0x0204 }
            r2.L$0 = r1     // Catch:{ CancellationException -> 0x0208, all -> 0x0204 }
            r2.L$1 = r7     // Catch:{ CancellationException -> 0x0208, all -> 0x0204 }
            r3 = 1
            r2.label = r3     // Catch:{ CancellationException -> 0x0208, all -> 0x0204 }
            java.lang.Object r0 = kotlinx.coroutines.II0XooXoX.II0XooXoX(r4, r5, r2)     // Catch:{ CancellationException -> 0x0208, all -> 0x0204 }
            r2 = r22
            if (r0 != r2) goto L_0x01f5
            return r2
        L_0x01f5:
            r2 = r1
            r3 = r7
        L_0x01f7:
            androidx.work.ListenableWorker$Result r0 = (androidx.work.ListenableWorker.Result) r0     // Catch:{ CancellationException -> 0x003a, all -> 0x0037 }
            androidx.work.impl.WorkerWrapper$Resolution$Finished r4 = new androidx.work.impl.WorkerWrapper$Resolution$Finished     // Catch:{ CancellationException -> 0x003a, all -> 0x0037 }
            java.lang.String r5 = "result"
            kotlin.jvm.internal.IIX0o.oO(r0, r5)     // Catch:{ CancellationException -> 0x003a, all -> 0x0037 }
            r4.<init>(r0)     // Catch:{ CancellationException -> 0x003a, all -> 0x0037 }
            return r4
        L_0x0204:
            r0 = move-exception
            r2 = r1
            r3 = r7
            goto L_0x020b
        L_0x0208:
            r0 = move-exception
            r2 = r1
            goto L_0x0249
        L_0x020b:
            java.lang.String r4 = androidx.work.impl.WorkerWrapperKt.TAG
            androidx.work.Logger r5 = androidx.work.Logger.get()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = r2.workDescription
            r6.append(r7)
            java.lang.String r7 = " failed because it threw an exception/error"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.error(r4, r6, r0)
            androidx.work.Configuration r4 = r2.configuration
            androidx.core.util.Consumer r4 = r4.getWorkerExecutionExceptionHandler()
            if (r4 == 0) goto L_0x0241
            androidx.work.WorkerExceptionInfo r5 = new androidx.work.WorkerExceptionInfo
            androidx.work.impl.model.WorkSpec r2 = r2.workSpec
            java.lang.String r2 = r2.workerClassName
            r5.<init>(r2, r3, r0)
            java.lang.String r0 = androidx.work.impl.WorkerWrapperKt.TAG
            androidx.work.impl.utils.WorkerExceptionUtilsKt.safeAccept(r4, r5, r0)
        L_0x0241:
            androidx.work.impl.WorkerWrapper$Resolution$Failed r0 = new androidx.work.impl.WorkerWrapper$Resolution$Failed
            r2 = 1
            r3 = 0
            r0.<init>(r3, r2, r3)
            return r0
        L_0x0249:
            java.lang.String r3 = androidx.work.impl.WorkerWrapperKt.TAG
            androidx.work.Logger r4 = androidx.work.Logger.get()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r2 = r2.workDescription
            r5.append(r2)
            java.lang.String r2 = " was cancelled"
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r4.info(r3, r2, r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.WorkerWrapper.runWorker(kotlin.coroutines.I0Io):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final Boolean runWorker$lambda$1(WorkerWrapper workerWrapper) {
        WorkSpec workSpec2 = workerWrapper.workSpec;
        if (workSpec2.state != WorkInfo.State.ENQUEUED) {
            String access$getTAG$p = WorkerWrapperKt.TAG;
            Logger logger = Logger.get();
            logger.debug(access$getTAG$p, workerWrapper.workSpec.workerClassName + " is not in ENQUEUED state. Nothing more to do");
            return Boolean.TRUE;
        } else if ((!workSpec2.isPeriodic() && !workerWrapper.workSpec.isBackedOff()) || workerWrapper.clock.currentTimeMillis() >= workerWrapper.workSpec.calculateNextRunTime()) {
            return Boolean.FALSE;
        } else {
            Logger logger2 = Logger.get();
            String access$getTAG$p2 = WorkerWrapperKt.TAG;
            logger2.debug(access$getTAG$p2, "Delaying execution for " + workerWrapper.workSpec.workerClassName + " because it is being executed before schedule.");
            return Boolean.TRUE;
        }
    }

    private final boolean setSucceeded(ListenableWorker.Result result) {
        this.workSpecDao.setState(WorkInfo.State.SUCCEEDED, this.workSpecId);
        IIX0o.x0XOIxOo(result, "null cannot be cast to non-null type androidx.work.ListenableWorker.Result.Success");
        Data outputData = ((ListenableWorker.Result.Success) result).getOutputData();
        IIX0o.oO(outputData, "success.outputData");
        this.workSpecDao.setOutput(this.workSpecId, outputData);
        long currentTimeMillis = this.clock.currentTimeMillis();
        for (String next : this.dependencyDao.getDependentWorkIds(this.workSpecId)) {
            if (this.workSpecDao.getState(next) == WorkInfo.State.BLOCKED && this.dependencyDao.hasCompletedAllPrerequisites(next)) {
                String access$getTAG$p = WorkerWrapperKt.TAG;
                Logger logger = Logger.get();
                logger.info(access$getTAG$p, "Setting status to enqueued for " + next);
                this.workSpecDao.setState(WorkInfo.State.ENQUEUED, next);
                this.workSpecDao.setLastEnqueueTime(next, currentTimeMillis);
            }
        }
        return false;
    }

    private final boolean trySetRunning() {
        Object runInTransaction = this.workDatabase.runInTransaction(new x0xO0oo(this));
        IIX0o.oO(runInTransaction, "workDatabase.runInTransa…e\n            }\n        )");
        return ((Boolean) runInTransaction).booleanValue();
    }

    /* access modifiers changed from: private */
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

    @OOXIXo
    public final WorkGenerationalId getWorkGenerationalId() {
        return WorkSpecKt.generationalId(this.workSpec);
    }

    @OOXIXo
    public final WorkSpec getWorkSpec() {
        return this.workSpec;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void interrupt(int i) {
        this.workerJob.II0xO0(new WorkerStoppedException(i));
    }

    @OOXIXo
    public final ListenableFuture<Boolean> launch() {
        return ListenableFutureKt.launchFuture$default(this.workTaskExecutor.getTaskCoroutineDispatcher().plus(Ox0O.I0Io((oXIO0o0XI) null, 1, (Object) null)), (CoroutineStart) null, new WorkerWrapper$launch$1(this, (I0Io<? super WorkerWrapper$launch$1>) null), 2, (Object) null);
    }

    @VisibleForTesting
    public final boolean setFailed(@OOXIXo ListenableWorker.Result result) {
        IIX0o.x0xO0oo(result, "result");
        iterativelyFailWorkAndDependents(this.workSpecId);
        Data outputData = ((ListenableWorker.Result.Failure) result).getOutputData();
        IIX0o.oO(outputData, "failure.outputData");
        this.workSpecDao.resetWorkSpecNextScheduleTimeOverride(this.workSpecId, this.workSpec.getNextScheduleTimeOverrideGeneration());
        this.workSpecDao.setOutput(this.workSpecId, outputData);
        return false;
    }
}
