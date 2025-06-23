package androidx.work;

import O0IoXXOx.XO;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Build;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.core.util.Consumer;
import androidx.work.impl.DefaultRunnableScheduler;
import com.huawei.openalliance.ad.constant.bn;
import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlinx.coroutines.O00XxXI;
import kotlinx.coroutines.Xo0;

public final class Configuration {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    public static final int MIN_SCHEDULER_LIMIT = 20;
    @OOXIXo
    private final Clock clock;
    private final int contentUriTriggerWorkersLimit;
    @oOoXoXO
    private final String defaultProcessName;
    @OOXIXo
    private final Executor executor;
    @oOoXoXO
    private final Consumer<Throwable> initializationExceptionHandler;
    @OOXIXo
    private final InputMergerFactory inputMergerFactory;
    private final boolean isMarkingJobsAsImportantWhileForeground;
    private final boolean isUsingDefaultTaskExecutor;
    private final int maxJobSchedulerId;
    private final int maxSchedulerLimit;
    private final int minJobSchedulerId;
    private final int minimumLoggingLevel;
    @OOXIXo
    private final RunnableScheduler runnableScheduler;
    @oOoXoXO
    private final Consumer<Throwable> schedulingExceptionHandler;
    @OOXIXo
    private final Executor taskExecutor;
    @OOXIXo
    private final Tracer tracer;
    @OOXIXo
    private final CoroutineContext workerCoroutineContext;
    @oOoXoXO
    private final Consumer<WorkerExceptionInfo> workerExecutionExceptionHandler;
    @OOXIXo
    private final WorkerFactory workerFactory;
    @oOoXoXO
    private final Consumer<WorkerExceptionInfo> workerInitializationExceptionHandler;

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public interface Provider {
        @OOXIXo
        Configuration getWorkManagerConfiguration();
    }

    public Configuration(@OOXIXo Builder builder) {
        int i;
        IIX0o.x0xO0oo(builder, "builder");
        CoroutineContext workerContext$work_runtime_release = builder.getWorkerContext$work_runtime_release();
        Executor executor$work_runtime_release = builder.getExecutor$work_runtime_release();
        boolean z = false;
        if (executor$work_runtime_release == null) {
            if (workerContext$work_runtime_release != null) {
                executor$work_runtime_release = ConfigurationKt.asExecutor(workerContext$work_runtime_release);
            } else {
                executor$work_runtime_release = null;
            }
            if (executor$work_runtime_release == null) {
                executor$work_runtime_release = ConfigurationKt.createDefaultExecutor(false);
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
        this.isUsingDefaultTaskExecutor = builder.getTaskExecutor$work_runtime_release() == null ? true : z;
        Executor taskExecutor$work_runtime_release = builder.getTaskExecutor$work_runtime_release();
        this.taskExecutor = taskExecutor$work_runtime_release == null ? ConfigurationKt.createDefaultExecutor(true) : taskExecutor$work_runtime_release;
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
            i = builder.getMaxSchedulerLimit$work_runtime_release() / 2;
        } else {
            i = builder.getMaxSchedulerLimit$work_runtime_release();
        }
        this.maxSchedulerLimit = i;
        this.initializationExceptionHandler = builder.getInitializationExceptionHandler$work_runtime_release();
        this.schedulingExceptionHandler = builder.getSchedulingExceptionHandler$work_runtime_release();
        this.workerInitializationExceptionHandler = builder.getWorkerInitializationExceptionHandler$work_runtime_release();
        this.workerExecutionExceptionHandler = builder.getWorkerExecutionExceptionHandler$work_runtime_release();
        this.defaultProcessName = builder.getDefaultProcessName$work_runtime_release();
        this.contentUriTriggerWorkersLimit = builder.getContentUriTriggerWorkersLimit$work_runtime_release();
        this.isMarkingJobsAsImportantWhileForeground = builder.getMarkJobsAsImportantWhileForeground$work_runtime_release();
        Tracer tracer$work_runtime_release = builder.getTracer$work_runtime_release();
        this.tracer = tracer$work_runtime_release == null ? ConfigurationKt.createDefaultTracer() : tracer$work_runtime_release;
    }

    @ExperimentalConfigurationApi
    public static /* synthetic */ void isMarkingJobsAsImportantWhileForeground$annotations() {
    }

    @OOXIXo
    public final Clock getClock() {
        return this.clock;
    }

    public final int getContentUriTriggerWorkersLimit() {
        return this.contentUriTriggerWorkersLimit;
    }

    @oOoXoXO
    public final String getDefaultProcessName() {
        return this.defaultProcessName;
    }

    @OOXIXo
    public final Executor getExecutor() {
        return this.executor;
    }

    @oOoXoXO
    public final Consumer<Throwable> getInitializationExceptionHandler() {
        return this.initializationExceptionHandler;
    }

    @OOXIXo
    public final InputMergerFactory getInputMergerFactory() {
        return this.inputMergerFactory;
    }

    public final int getMaxJobSchedulerId() {
        return this.maxJobSchedulerId;
    }

    @IntRange(from = 20, to = 50)
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

    @OOXIXo
    public final RunnableScheduler getRunnableScheduler() {
        return this.runnableScheduler;
    }

    @oOoXoXO
    public final Consumer<Throwable> getSchedulingExceptionHandler() {
        return this.schedulingExceptionHandler;
    }

    @OOXIXo
    public final Executor getTaskExecutor() {
        return this.taskExecutor;
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Tracer getTracer() {
        return this.tracer;
    }

    @OOXIXo
    public final CoroutineContext getWorkerCoroutineContext() {
        return this.workerCoroutineContext;
    }

    @oOoXoXO
    public final Consumer<WorkerExceptionInfo> getWorkerExecutionExceptionHandler() {
        return this.workerExecutionExceptionHandler;
    }

    @OOXIXo
    public final WorkerFactory getWorkerFactory() {
        return this.workerFactory;
    }

    @oOoXoXO
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

    public static final class Builder {
        @oOoXoXO
        private Clock clock;
        private int contentUriTriggerWorkersLimit = 8;
        @oOoXoXO
        private String defaultProcessName;
        @oOoXoXO
        private Executor executor;
        @oOoXoXO
        private Consumer<Throwable> initializationExceptionHandler;
        @oOoXoXO
        private InputMergerFactory inputMergerFactory;
        private int loggingLevel = 4;
        private boolean markJobsAsImportantWhileForeground = true;
        private int maxJobSchedulerId = Integer.MAX_VALUE;
        private int maxSchedulerLimit = 20;
        private int minJobSchedulerId;
        @oOoXoXO
        private RunnableScheduler runnableScheduler;
        @oOoXoXO
        private Consumer<Throwable> schedulingExceptionHandler;
        @oOoXoXO
        private Executor taskExecutor;
        @oOoXoXO
        private Tracer tracer;
        @oOoXoXO
        private CoroutineContext workerContext;
        @oOoXoXO
        private Consumer<WorkerExceptionInfo> workerExecutionExceptionHandler;
        @oOoXoXO
        private WorkerFactory workerFactory;
        @oOoXoXO
        private Consumer<WorkerExceptionInfo> workerInitializationExceptionHandler;

        public Builder() {
        }

        @OOXIXo
        public final Configuration build() {
            return new Configuration(this);
        }

        @oOoXoXO
        public final Clock getClock$work_runtime_release() {
            return this.clock;
        }

        public final int getContentUriTriggerWorkersLimit$work_runtime_release() {
            return this.contentUriTriggerWorkersLimit;
        }

        @oOoXoXO
        public final String getDefaultProcessName$work_runtime_release() {
            return this.defaultProcessName;
        }

        @oOoXoXO
        public final Executor getExecutor$work_runtime_release() {
            return this.executor;
        }

        @oOoXoXO
        public final Consumer<Throwable> getInitializationExceptionHandler$work_runtime_release() {
            return this.initializationExceptionHandler;
        }

        @oOoXoXO
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

        @oOoXoXO
        public final RunnableScheduler getRunnableScheduler$work_runtime_release() {
            return this.runnableScheduler;
        }

        @oOoXoXO
        public final Consumer<Throwable> getSchedulingExceptionHandler$work_runtime_release() {
            return this.schedulingExceptionHandler;
        }

        @oOoXoXO
        public final Executor getTaskExecutor$work_runtime_release() {
            return this.taskExecutor;
        }

        @oOoXoXO
        public final Tracer getTracer$work_runtime_release() {
            return this.tracer;
        }

        @oOoXoXO
        public final CoroutineContext getWorkerContext$work_runtime_release() {
            return this.workerContext;
        }

        @oOoXoXO
        public final Consumer<WorkerExceptionInfo> getWorkerExecutionExceptionHandler$work_runtime_release() {
            return this.workerExecutionExceptionHandler;
        }

        @oOoXoXO
        public final WorkerFactory getWorkerFactory$work_runtime_release() {
            return this.workerFactory;
        }

        @oOoXoXO
        public final Consumer<WorkerExceptionInfo> getWorkerInitializationExceptionHandler$work_runtime_release() {
            return this.workerInitializationExceptionHandler;
        }

        @OOXIXo
        public final Builder setClock(@OOXIXo Clock clock2) {
            IIX0o.x0xO0oo(clock2, "clock");
            this.clock = clock2;
            return this;
        }

        public final void setClock$work_runtime_release(@oOoXoXO Clock clock2) {
            this.clock = clock2;
        }

        @OOXIXo
        public final Builder setContentUriTriggerWorkersLimit(int i) {
            this.contentUriTriggerWorkersLimit = Math.max(i, 0);
            return this;
        }

        public final void setContentUriTriggerWorkersLimit$work_runtime_release(int i) {
            this.contentUriTriggerWorkersLimit = i;
        }

        @OOXIXo
        public final Builder setDefaultProcessName(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "processName");
            this.defaultProcessName = str;
            return this;
        }

        public final void setDefaultProcessName$work_runtime_release(@oOoXoXO String str) {
            this.defaultProcessName = str;
        }

        @OOXIXo
        public final Builder setExecutor(@OOXIXo Executor executor2) {
            IIX0o.x0xO0oo(executor2, "executor");
            this.executor = executor2;
            return this;
        }

        public final void setExecutor$work_runtime_release(@oOoXoXO Executor executor2) {
            this.executor = executor2;
        }

        @OOXIXo
        public final Builder setInitializationExceptionHandler(@OOXIXo Consumer<Throwable> consumer) {
            IIX0o.x0xO0oo(consumer, "exceptionHandler");
            this.initializationExceptionHandler = consumer;
            return this;
        }

        public final void setInitializationExceptionHandler$work_runtime_release(@oOoXoXO Consumer<Throwable> consumer) {
            this.initializationExceptionHandler = consumer;
        }

        @OOXIXo
        public final Builder setInputMergerFactory(@OOXIXo InputMergerFactory inputMergerFactory2) {
            IIX0o.x0xO0oo(inputMergerFactory2, "inputMergerFactory");
            this.inputMergerFactory = inputMergerFactory2;
            return this;
        }

        public final void setInputMergerFactory$work_runtime_release(@oOoXoXO InputMergerFactory inputMergerFactory2) {
            this.inputMergerFactory = inputMergerFactory2;
        }

        @OOXIXo
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

        @ExperimentalConfigurationApi
        @OOXIXo
        public final Builder setMarkingJobsAsImportantWhileForeground(boolean z) {
            this.markJobsAsImportantWhileForeground = z;
            return this;
        }

        public final void setMaxJobSchedulerId$work_runtime_release(int i) {
            this.maxJobSchedulerId = i;
        }

        @OOXIXo
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

        @OOXIXo
        public final Builder setMinimumLoggingLevel(int i) {
            this.loggingLevel = i;
            return this;
        }

        @OOXIXo
        public final Builder setRunnableScheduler(@OOXIXo RunnableScheduler runnableScheduler2) {
            IIX0o.x0xO0oo(runnableScheduler2, "runnableScheduler");
            this.runnableScheduler = runnableScheduler2;
            return this;
        }

        public final void setRunnableScheduler$work_runtime_release(@oOoXoXO RunnableScheduler runnableScheduler2) {
            this.runnableScheduler = runnableScheduler2;
        }

        @OOXIXo
        public final Builder setSchedulingExceptionHandler(@OOXIXo Consumer<Throwable> consumer) {
            IIX0o.x0xO0oo(consumer, "schedulingExceptionHandler");
            this.schedulingExceptionHandler = consumer;
            return this;
        }

        public final void setSchedulingExceptionHandler$work_runtime_release(@oOoXoXO Consumer<Throwable> consumer) {
            this.schedulingExceptionHandler = consumer;
        }

        @OOXIXo
        public final Builder setTaskExecutor(@OOXIXo Executor executor2) {
            IIX0o.x0xO0oo(executor2, "taskExecutor");
            this.taskExecutor = executor2;
            return this;
        }

        public final void setTaskExecutor$work_runtime_release(@oOoXoXO Executor executor2) {
            this.taskExecutor = executor2;
        }

        @OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final Builder setTracer(@OOXIXo Tracer tracer2) {
            IIX0o.x0xO0oo(tracer2, "tracer");
            this.tracer = tracer2;
            return this;
        }

        public final void setTracer$work_runtime_release(@oOoXoXO Tracer tracer2) {
            this.tracer = tracer2;
        }

        public final void setWorkerContext$work_runtime_release(@oOoXoXO CoroutineContext coroutineContext) {
            this.workerContext = coroutineContext;
        }

        @OOXIXo
        public final Builder setWorkerCoroutineContext(@OOXIXo CoroutineContext coroutineContext) {
            IIX0o.x0xO0oo(coroutineContext, bn.f.o);
            this.workerContext = coroutineContext;
            return this;
        }

        @OOXIXo
        public final Builder setWorkerExecutionExceptionHandler(@OOXIXo Consumer<WorkerExceptionInfo> consumer) {
            IIX0o.x0xO0oo(consumer, "workerExceptionHandler");
            this.workerExecutionExceptionHandler = consumer;
            return this;
        }

        public final void setWorkerExecutionExceptionHandler$work_runtime_release(@oOoXoXO Consumer<WorkerExceptionInfo> consumer) {
            this.workerExecutionExceptionHandler = consumer;
        }

        @OOXIXo
        public final Builder setWorkerFactory(@OOXIXo WorkerFactory workerFactory2) {
            IIX0o.x0xO0oo(workerFactory2, "workerFactory");
            this.workerFactory = workerFactory2;
            return this;
        }

        public final void setWorkerFactory$work_runtime_release(@oOoXoXO WorkerFactory workerFactory2) {
            this.workerFactory = workerFactory2;
        }

        @OOXIXo
        public final Builder setWorkerInitializationExceptionHandler(@OOXIXo Consumer<WorkerExceptionInfo> consumer) {
            IIX0o.x0xO0oo(consumer, "workerExceptionHandler");
            this.workerInitializationExceptionHandler = consumer;
            return this;
        }

        public final void setWorkerInitializationExceptionHandler$work_runtime_release(@oOoXoXO Consumer<WorkerExceptionInfo> consumer) {
            this.workerInitializationExceptionHandler = consumer;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(@OOXIXo Configuration configuration) {
            IIX0o.x0xO0oo(configuration, XO.f15419Oxx0IOOO);
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
