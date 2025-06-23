package androidx.work;

import android.os.Build;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.core.util.Consumer;
import androidx.work.impl.DefaultRunnableScheduler;
import com.google.android.exoplayer2.DefaultLivePlaybackSpeedControl;
import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlinx.coroutines.O00XxXI;
import kotlinx.coroutines.Xo0;

/* loaded from: classes.dex */
public final class Configuration {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int MIN_SCHEDULER_LIMIT = 20;

    @OXOo.OOXIXo
    private final Clock clock;
    private final int contentUriTriggerWorkersLimit;

    @OXOo.oOoXoXO
    private final String defaultProcessName;

    @OXOo.OOXIXo
    private final Executor executor;

    @OXOo.oOoXoXO
    private final Consumer<Throwable> initializationExceptionHandler;

    @OXOo.OOXIXo
    private final InputMergerFactory inputMergerFactory;
    private final boolean isMarkingJobsAsImportantWhileForeground;
    private final boolean isUsingDefaultTaskExecutor;
    private final int maxJobSchedulerId;
    private final int maxSchedulerLimit;
    private final int minJobSchedulerId;
    private final int minimumLoggingLevel;

    @OXOo.OOXIXo
    private final RunnableScheduler runnableScheduler;

    @OXOo.oOoXoXO
    private final Consumer<Throwable> schedulingExceptionHandler;

    @OXOo.OOXIXo
    private final Executor taskExecutor;

    @OXOo.OOXIXo
    private final Tracer tracer;

    @OXOo.OOXIXo
    private final CoroutineContext workerCoroutineContext;

    @OXOo.oOoXoXO
    private final Consumer<WorkerExceptionInfo> workerExecutionExceptionHandler;

    @OXOo.OOXIXo
    private final WorkerFactory workerFactory;

    @OXOo.oOoXoXO
    private final Consumer<WorkerExceptionInfo> workerInitializationExceptionHandler;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes.dex */
    public interface Provider {
        @OXOo.OOXIXo
        Configuration getWorkManagerConfiguration();
    }

    public Configuration(@OXOo.OOXIXo Builder builder) {
        int maxSchedulerLimit$work_runtime_release;
        IIX0o.x0xO0oo(builder, "builder");
        CoroutineContext workerContext$work_runtime_release = builder.getWorkerContext$work_runtime_release();
        Executor executor$work_runtime_release = builder.getExecutor$work_runtime_release();
        if (executor$work_runtime_release == null) {
            if (workerContext$work_runtime_release != null) {
                executor$work_runtime_release = ConfigurationKt.access$asExecutor(workerContext$work_runtime_release);
            } else {
                executor$work_runtime_release = null;
            }
            if (executor$work_runtime_release == null) {
                executor$work_runtime_release = ConfigurationKt.access$createDefaultExecutor(false);
            }
        }
        this.executor = executor$work_runtime_release;
        if (workerContext$work_runtime_release == null) {
            if (builder.getExecutor$work_runtime_release() != null) {
                workerContext$work_runtime_release = O00XxXI.I0Io(executor$work_runtime_release);
            } else {
                workerContext$work_runtime_release = Xo0.oIX0oI();
            }
        }
        this.workerCoroutineContext = workerContext$work_runtime_release;
        this.isUsingDefaultTaskExecutor = builder.getTaskExecutor$work_runtime_release() == null;
        Executor taskExecutor$work_runtime_release = builder.getTaskExecutor$work_runtime_release();
        this.taskExecutor = taskExecutor$work_runtime_release == null ? ConfigurationKt.access$createDefaultExecutor(true) : taskExecutor$work_runtime_release;
        Clock clock$work_runtime_release = builder.getClock$work_runtime_release();
        this.clock = clock$work_runtime_release == null ? new SystemClock() : clock$work_runtime_release;
        WorkerFactory workerFactory$work_runtime_release = builder.getWorkerFactory$work_runtime_release();
        this.workerFactory = workerFactory$work_runtime_release == null ? DefaultWorkerFactory.INSTANCE : workerFactory$work_runtime_release;
        InputMergerFactory inputMergerFactory$work_runtime_release = builder.getInputMergerFactory$work_runtime_release();
        this.inputMergerFactory = inputMergerFactory$work_runtime_release == null ? NoOpInputMergerFactory.INSTANCE : inputMergerFactory$work_runtime_release;
        RunnableScheduler runnableScheduler$work_runtime_release = builder.getRunnableScheduler$work_runtime_release();
        this.runnableScheduler = runnableScheduler$work_runtime_release == null ? new DefaultRunnableScheduler() : runnableScheduler$work_runtime_release;
        this.minimumLoggingLevel = builder.getLoggingLevel$work_runtime_release();
        this.minJobSchedulerId = builder.getMinJobSchedulerId$work_runtime_release();
        this.maxJobSchedulerId = builder.getMaxJobSchedulerId$work_runtime_release();
        if (Build.VERSION.SDK_INT == 23) {
            maxSchedulerLimit$work_runtime_release = builder.getMaxSchedulerLimit$work_runtime_release() / 2;
        } else {
            maxSchedulerLimit$work_runtime_release = builder.getMaxSchedulerLimit$work_runtime_release();
        }
        this.maxSchedulerLimit = maxSchedulerLimit$work_runtime_release;
        this.initializationExceptionHandler = builder.getInitializationExceptionHandler$work_runtime_release();
        this.schedulingExceptionHandler = builder.getSchedulingExceptionHandler$work_runtime_release();
        this.workerInitializationExceptionHandler = builder.getWorkerInitializationExceptionHandler$work_runtime_release();
        this.workerExecutionExceptionHandler = builder.getWorkerExecutionExceptionHandler$work_runtime_release();
        this.defaultProcessName = builder.getDefaultProcessName$work_runtime_release();
        this.contentUriTriggerWorkersLimit = builder.getContentUriTriggerWorkersLimit$work_runtime_release();
        this.isMarkingJobsAsImportantWhileForeground = builder.getMarkJobsAsImportantWhileForeground$work_runtime_release();
        Tracer tracer$work_runtime_release = builder.getTracer$work_runtime_release();
        this.tracer = tracer$work_runtime_release == null ? ConfigurationKt.access$createDefaultTracer() : tracer$work_runtime_release;
    }

    @ExperimentalConfigurationApi
    public static /* synthetic */ void isMarkingJobsAsImportantWhileForeground$annotations() {
    }

    @OXOo.OOXIXo
    public final Clock getClock() {
        return this.clock;
    }

    public final int getContentUriTriggerWorkersLimit() {
        return this.contentUriTriggerWorkersLimit;
    }

    @OXOo.oOoXoXO
    public final String getDefaultProcessName() {
        return this.defaultProcessName;
    }

    @OXOo.OOXIXo
    public final Executor getExecutor() {
        return this.executor;
    }

    @OXOo.oOoXoXO
    public final Consumer<Throwable> getInitializationExceptionHandler() {
        return this.initializationExceptionHandler;
    }

    @OXOo.OOXIXo
    public final InputMergerFactory getInputMergerFactory() {
        return this.inputMergerFactory;
    }

    public final int getMaxJobSchedulerId() {
        return this.maxJobSchedulerId;
    }

    @IntRange(from = DefaultLivePlaybackSpeedControl.DEFAULT_MAX_LIVE_OFFSET_ERROR_MS_FOR_UNIT_SPEED, to = 50)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int getMaxSchedulerLimit() {
        return this.maxSchedulerLimit;
    }

    public final int getMinJobSchedulerId() {
        return this.minJobSchedulerId;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int getMinimumLoggingLevel() {
        return this.minimumLoggingLevel;
    }

    @OXOo.OOXIXo
    public final RunnableScheduler getRunnableScheduler() {
        return this.runnableScheduler;
    }

    @OXOo.oOoXoXO
    public final Consumer<Throwable> getSchedulingExceptionHandler() {
        return this.schedulingExceptionHandler;
    }

    @OXOo.OOXIXo
    public final Executor getTaskExecutor() {
        return this.taskExecutor;
    }

    @OXOo.OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Tracer getTracer() {
        return this.tracer;
    }

    @OXOo.OOXIXo
    public final CoroutineContext getWorkerCoroutineContext() {
        return this.workerCoroutineContext;
    }

    @OXOo.oOoXoXO
    public final Consumer<WorkerExceptionInfo> getWorkerExecutionExceptionHandler() {
        return this.workerExecutionExceptionHandler;
    }

    @OXOo.OOXIXo
    public final WorkerFactory getWorkerFactory() {
        return this.workerFactory;
    }

    @OXOo.oOoXoXO
    public final Consumer<WorkerExceptionInfo> getWorkerInitializationExceptionHandler() {
        return this.workerInitializationExceptionHandler;
    }

    @ExperimentalConfigurationApi
    public final boolean isMarkingJobsAsImportantWhileForeground() {
        return this.isMarkingJobsAsImportantWhileForeground;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean isUsingDefaultTaskExecutor() {
        return this.isUsingDefaultTaskExecutor;
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        @OXOo.oOoXoXO
        private Clock clock;
        private int contentUriTriggerWorkersLimit;

        @OXOo.oOoXoXO
        private String defaultProcessName;

        @OXOo.oOoXoXO
        private Executor executor;

        @OXOo.oOoXoXO
        private Consumer<Throwable> initializationExceptionHandler;

        @OXOo.oOoXoXO
        private InputMergerFactory inputMergerFactory;
        private int loggingLevel;
        private boolean markJobsAsImportantWhileForeground;
        private int maxJobSchedulerId;
        private int maxSchedulerLimit;
        private int minJobSchedulerId;

        @OXOo.oOoXoXO
        private RunnableScheduler runnableScheduler;

        @OXOo.oOoXoXO
        private Consumer<Throwable> schedulingExceptionHandler;

        @OXOo.oOoXoXO
        private Executor taskExecutor;

        @OXOo.oOoXoXO
        private Tracer tracer;

        @OXOo.oOoXoXO
        private CoroutineContext workerContext;

        @OXOo.oOoXoXO
        private Consumer<WorkerExceptionInfo> workerExecutionExceptionHandler;

        @OXOo.oOoXoXO
        private WorkerFactory workerFactory;

        @OXOo.oOoXoXO
        private Consumer<WorkerExceptionInfo> workerInitializationExceptionHandler;

        public Builder() {
            this.loggingLevel = 4;
            this.maxJobSchedulerId = Integer.MAX_VALUE;
            this.maxSchedulerLimit = 20;
            this.contentUriTriggerWorkersLimit = 8;
            this.markJobsAsImportantWhileForeground = true;
        }

        @OXOo.OOXIXo
        public final Configuration build() {
            return new Configuration(this);
        }

        @OXOo.oOoXoXO
        public final Clock getClock$work_runtime_release() {
            return this.clock;
        }

        public final int getContentUriTriggerWorkersLimit$work_runtime_release() {
            return this.contentUriTriggerWorkersLimit;
        }

        @OXOo.oOoXoXO
        public final String getDefaultProcessName$work_runtime_release() {
            return this.defaultProcessName;
        }

        @OXOo.oOoXoXO
        public final Executor getExecutor$work_runtime_release() {
            return this.executor;
        }

        @OXOo.oOoXoXO
        public final Consumer<Throwable> getInitializationExceptionHandler$work_runtime_release() {
            return this.initializationExceptionHandler;
        }

        @OXOo.oOoXoXO
        public final InputMergerFactory getInputMergerFactory$work_runtime_release() {
            return this.inputMergerFactory;
        }

        public final int getLoggingLevel$work_runtime_release() {
            return this.loggingLevel;
        }

        public final boolean getMarkJobsAsImportantWhileForeground$work_runtime_release() {
            return this.markJobsAsImportantWhileForeground;
        }

        public final int getMaxJobSchedulerId$work_runtime_release() {
            return this.maxJobSchedulerId;
        }

        public final int getMaxSchedulerLimit$work_runtime_release() {
            return this.maxSchedulerLimit;
        }

        public final int getMinJobSchedulerId$work_runtime_release() {
            return this.minJobSchedulerId;
        }

        @OXOo.oOoXoXO
        public final RunnableScheduler getRunnableScheduler$work_runtime_release() {
            return this.runnableScheduler;
        }

        @OXOo.oOoXoXO
        public final Consumer<Throwable> getSchedulingExceptionHandler$work_runtime_release() {
            return this.schedulingExceptionHandler;
        }

        @OXOo.oOoXoXO
        public final Executor getTaskExecutor$work_runtime_release() {
            return this.taskExecutor;
        }

        @OXOo.oOoXoXO
        public final Tracer getTracer$work_runtime_release() {
            return this.tracer;
        }

        @OXOo.oOoXoXO
        public final CoroutineContext getWorkerContext$work_runtime_release() {
            return this.workerContext;
        }

        @OXOo.oOoXoXO
        public final Consumer<WorkerExceptionInfo> getWorkerExecutionExceptionHandler$work_runtime_release() {
            return this.workerExecutionExceptionHandler;
        }

        @OXOo.oOoXoXO
        public final WorkerFactory getWorkerFactory$work_runtime_release() {
            return this.workerFactory;
        }

        @OXOo.oOoXoXO
        public final Consumer<WorkerExceptionInfo> getWorkerInitializationExceptionHandler$work_runtime_release() {
            return this.workerInitializationExceptionHandler;
        }

        @OXOo.OOXIXo
        public final Builder setClock(@OXOo.OOXIXo Clock clock) {
            IIX0o.x0xO0oo(clock, "clock");
            this.clock = clock;
            return this;
        }

        public final void setClock$work_runtime_release(@OXOo.oOoXoXO Clock clock) {
            this.clock = clock;
        }

        @OXOo.OOXIXo
        public final Builder setContentUriTriggerWorkersLimit(int i) {
            this.contentUriTriggerWorkersLimit = Math.max(i, 0);
            return this;
        }

        public final void setContentUriTriggerWorkersLimit$work_runtime_release(int i) {
            this.contentUriTriggerWorkersLimit = i;
        }

        @OXOo.OOXIXo
        public final Builder setDefaultProcessName(@OXOo.OOXIXo String processName) {
            IIX0o.x0xO0oo(processName, "processName");
            this.defaultProcessName = processName;
            return this;
        }

        public final void setDefaultProcessName$work_runtime_release(@OXOo.oOoXoXO String str) {
            this.defaultProcessName = str;
        }

        @OXOo.OOXIXo
        public final Builder setExecutor(@OXOo.OOXIXo Executor executor) {
            IIX0o.x0xO0oo(executor, "executor");
            this.executor = executor;
            return this;
        }

        public final void setExecutor$work_runtime_release(@OXOo.oOoXoXO Executor executor) {
            this.executor = executor;
        }

        @OXOo.OOXIXo
        public final Builder setInitializationExceptionHandler(@OXOo.OOXIXo Consumer<Throwable> exceptionHandler) {
            IIX0o.x0xO0oo(exceptionHandler, "exceptionHandler");
            this.initializationExceptionHandler = exceptionHandler;
            return this;
        }

        public final void setInitializationExceptionHandler$work_runtime_release(@OXOo.oOoXoXO Consumer<Throwable> consumer) {
            this.initializationExceptionHandler = consumer;
        }

        @OXOo.OOXIXo
        public final Builder setInputMergerFactory(@OXOo.OOXIXo InputMergerFactory inputMergerFactory) {
            IIX0o.x0xO0oo(inputMergerFactory, "inputMergerFactory");
            this.inputMergerFactory = inputMergerFactory;
            return this;
        }

        public final void setInputMergerFactory$work_runtime_release(@OXOo.oOoXoXO InputMergerFactory inputMergerFactory) {
            this.inputMergerFactory = inputMergerFactory;
        }

        @OXOo.OOXIXo
        public final Builder setJobSchedulerJobIdRange(int i, int i2) {
            if (i2 - i >= 1000) {
                this.minJobSchedulerId = i;
                this.maxJobSchedulerId = i2;
                return this;
            }
            throw new IllegalArgumentException("WorkManager needs a range of at least 1000 job ids.");
        }

        public final void setLoggingLevel$work_runtime_release(int i) {
            this.loggingLevel = i;
        }

        public final void setMarkJobsAsImportantWhileForeground$work_runtime_release(boolean z) {
            this.markJobsAsImportantWhileForeground = z;
        }

        @OXOo.OOXIXo
        @ExperimentalConfigurationApi
        public final Builder setMarkingJobsAsImportantWhileForeground(boolean z) {
            this.markJobsAsImportantWhileForeground = z;
            return this;
        }

        public final void setMaxJobSchedulerId$work_runtime_release(int i) {
            this.maxJobSchedulerId = i;
        }

        @OXOo.OOXIXo
        public final Builder setMaxSchedulerLimit(int i) {
            if (i >= 20) {
                this.maxSchedulerLimit = Math.min(i, 50);
                return this;
            }
            throw new IllegalArgumentException("WorkManager needs to be able to schedule at least 20 jobs in JobScheduler.");
        }

        public final void setMaxSchedulerLimit$work_runtime_release(int i) {
            this.maxSchedulerLimit = i;
        }

        public final void setMinJobSchedulerId$work_runtime_release(int i) {
            this.minJobSchedulerId = i;
        }

        @OXOo.OOXIXo
        public final Builder setMinimumLoggingLevel(int i) {
            this.loggingLevel = i;
            return this;
        }

        @OXOo.OOXIXo
        public final Builder setRunnableScheduler(@OXOo.OOXIXo RunnableScheduler runnableScheduler) {
            IIX0o.x0xO0oo(runnableScheduler, "runnableScheduler");
            this.runnableScheduler = runnableScheduler;
            return this;
        }

        public final void setRunnableScheduler$work_runtime_release(@OXOo.oOoXoXO RunnableScheduler runnableScheduler) {
            this.runnableScheduler = runnableScheduler;
        }

        @OXOo.OOXIXo
        public final Builder setSchedulingExceptionHandler(@OXOo.OOXIXo Consumer<Throwable> schedulingExceptionHandler) {
            IIX0o.x0xO0oo(schedulingExceptionHandler, "schedulingExceptionHandler");
            this.schedulingExceptionHandler = schedulingExceptionHandler;
            return this;
        }

        public final void setSchedulingExceptionHandler$work_runtime_release(@OXOo.oOoXoXO Consumer<Throwable> consumer) {
            this.schedulingExceptionHandler = consumer;
        }

        @OXOo.OOXIXo
        public final Builder setTaskExecutor(@OXOo.OOXIXo Executor taskExecutor) {
            IIX0o.x0xO0oo(taskExecutor, "taskExecutor");
            this.taskExecutor = taskExecutor;
            return this;
        }

        public final void setTaskExecutor$work_runtime_release(@OXOo.oOoXoXO Executor executor) {
            this.taskExecutor = executor;
        }

        @OXOo.OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final Builder setTracer(@OXOo.OOXIXo Tracer tracer) {
            IIX0o.x0xO0oo(tracer, "tracer");
            this.tracer = tracer;
            return this;
        }

        public final void setTracer$work_runtime_release(@OXOo.oOoXoXO Tracer tracer) {
            this.tracer = tracer;
        }

        public final void setWorkerContext$work_runtime_release(@OXOo.oOoXoXO CoroutineContext coroutineContext) {
            this.workerContext = coroutineContext;
        }

        @OXOo.OOXIXo
        public final Builder setWorkerCoroutineContext(@OXOo.OOXIXo CoroutineContext context) {
            IIX0o.x0xO0oo(context, "context");
            this.workerContext = context;
            return this;
        }

        @OXOo.OOXIXo
        public final Builder setWorkerExecutionExceptionHandler(@OXOo.OOXIXo Consumer<WorkerExceptionInfo> workerExceptionHandler) {
            IIX0o.x0xO0oo(workerExceptionHandler, "workerExceptionHandler");
            this.workerExecutionExceptionHandler = workerExceptionHandler;
            return this;
        }

        public final void setWorkerExecutionExceptionHandler$work_runtime_release(@OXOo.oOoXoXO Consumer<WorkerExceptionInfo> consumer) {
            this.workerExecutionExceptionHandler = consumer;
        }

        @OXOo.OOXIXo
        public final Builder setWorkerFactory(@OXOo.OOXIXo WorkerFactory workerFactory) {
            IIX0o.x0xO0oo(workerFactory, "workerFactory");
            this.workerFactory = workerFactory;
            return this;
        }

        public final void setWorkerFactory$work_runtime_release(@OXOo.oOoXoXO WorkerFactory workerFactory) {
            this.workerFactory = workerFactory;
        }

        @OXOo.OOXIXo
        public final Builder setWorkerInitializationExceptionHandler(@OXOo.OOXIXo Consumer<WorkerExceptionInfo> workerExceptionHandler) {
            IIX0o.x0xO0oo(workerExceptionHandler, "workerExceptionHandler");
            this.workerInitializationExceptionHandler = workerExceptionHandler;
            return this;
        }

        public final void setWorkerInitializationExceptionHandler$work_runtime_release(@OXOo.oOoXoXO Consumer<WorkerExceptionInfo> consumer) {
            this.workerInitializationExceptionHandler = consumer;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(@OXOo.OOXIXo Configuration configuration) {
            IIX0o.x0xO0oo(configuration, "configuration");
            this.loggingLevel = 4;
            this.maxJobSchedulerId = Integer.MAX_VALUE;
            this.maxSchedulerLimit = 20;
            this.contentUriTriggerWorkersLimit = 8;
            this.markJobsAsImportantWhileForeground = true;
            this.executor = configuration.getExecutor();
            this.workerFactory = configuration.getWorkerFactory();
            this.inputMergerFactory = configuration.getInputMergerFactory();
            this.taskExecutor = configuration.getTaskExecutor();
            this.clock = configuration.getClock();
            this.loggingLevel = configuration.getMinimumLoggingLevel();
            this.minJobSchedulerId = configuration.getMinJobSchedulerId();
            this.maxJobSchedulerId = configuration.getMaxJobSchedulerId();
            this.maxSchedulerLimit = configuration.getMaxSchedulerLimit();
            this.runnableScheduler = configuration.getRunnableScheduler();
            this.initializationExceptionHandler = configuration.getInitializationExceptionHandler();
            this.schedulingExceptionHandler = configuration.getSchedulingExceptionHandler();
            this.workerInitializationExceptionHandler = configuration.getWorkerInitializationExceptionHandler();
            this.workerExecutionExceptionHandler = configuration.getWorkerExecutionExceptionHandler();
            this.defaultProcessName = configuration.getDefaultProcessName();
            this.contentUriTriggerWorkersLimit = configuration.getContentUriTriggerWorkersLimit();
            this.markJobsAsImportantWhileForeground = configuration.isMarkingJobsAsImportantWhileForeground();
            this.tracer = configuration.getTracer();
        }
    }
}
