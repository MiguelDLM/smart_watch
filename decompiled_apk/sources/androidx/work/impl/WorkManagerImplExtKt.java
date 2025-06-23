package androidx.work.impl;

import Oox.OxxIIOOXO;
import android.content.Context;
import androidx.work.Configuration;
import androidx.work.R;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.x0o;
import kotlinx.coroutines.xII;

/* loaded from: classes.dex */
public final class WorkManagerImplExtKt {
    public static final void close(@OXOo.OOXIXo WorkManagerImpl workManagerImpl) {
        IIX0o.x0xO0oo(workManagerImpl, "<this>");
        kotlinx.coroutines.xxIXOIIO.II0xO0(null, new WorkManagerImplExtKt$close$1(workManagerImpl, null), 1, null);
        workManagerImpl.getWorkDatabase().close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Scheduler> createSchedulers(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
        Scheduler createBestAvailableBackgroundScheduler = Schedulers.createBestAvailableBackgroundScheduler(context, workDatabase, configuration);
        IIX0o.oO(createBestAvailableBackgroundScheduler, "createBestAvailableBackg…kDatabase, configuration)");
        return CollectionsKt__CollectionsKt.X00IoxXI(createBestAvailableBackgroundScheduler, new GreedyScheduler(context, configuration, trackers, processor, new WorkLauncherImpl(processor, taskExecutor), taskExecutor));
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "createTestWorkManager")
    public static final WorkManagerImpl createTestWorkManager(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Configuration configuration, @OXOo.OOXIXo TaskExecutor workTaskExecutor) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(configuration, "configuration");
        IIX0o.x0xO0oo(workTaskExecutor, "workTaskExecutor");
        WorkDatabase.Companion companion = WorkDatabase.Companion;
        SerialExecutor serialTaskExecutor = workTaskExecutor.getSerialTaskExecutor();
        IIX0o.oO(serialTaskExecutor, "workTaskExecutor.serialTaskExecutor");
        return createWorkManager$default(context, configuration, workTaskExecutor, companion.create(context, serialTaskExecutor, configuration.getClock(), true), null, null, null, 112, null);
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "createWorkManager")
    @XO0OX.xoIox
    public static final WorkManagerImpl createWorkManager(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Configuration configuration) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(configuration, "configuration");
        return createWorkManager$default(context, configuration, null, null, null, null, null, 124, null);
    }

    public static /* synthetic */ WorkManagerImpl createWorkManager$default(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor, OxxIIOOXO oxxIIOOXO, int i, Object obj) {
        TaskExecutor taskExecutor2;
        WorkDatabase workDatabase2;
        Trackers trackers2;
        Processor processor2;
        OxxIIOOXO oxxIIOOXO2;
        if ((i & 4) != 0) {
            taskExecutor2 = new WorkManagerTaskExecutor(configuration.getTaskExecutor());
        } else {
            taskExecutor2 = taskExecutor;
        }
        if ((i & 8) != 0) {
            WorkDatabase.Companion companion = WorkDatabase.Companion;
            Context applicationContext = context.getApplicationContext();
            IIX0o.oO(applicationContext, "context.applicationContext");
            SerialExecutor serialTaskExecutor = taskExecutor2.getSerialTaskExecutor();
            IIX0o.oO(serialTaskExecutor, "workTaskExecutor.serialTaskExecutor");
            workDatabase2 = companion.create(applicationContext, serialTaskExecutor, configuration.getClock(), context.getResources().getBoolean(R.bool.workmanager_test_configuration));
        } else {
            workDatabase2 = workDatabase;
        }
        if ((i & 16) != 0) {
            Context applicationContext2 = context.getApplicationContext();
            IIX0o.oO(applicationContext2, "context.applicationContext");
            trackers2 = new Trackers(applicationContext2, taskExecutor2, null, null, null, null, 60, null);
        } else {
            trackers2 = trackers;
        }
        if ((i & 32) != 0) {
            processor2 = new Processor(context.getApplicationContext(), configuration, taskExecutor2, workDatabase2);
        } else {
            processor2 = processor;
        }
        if ((i & 64) != 0) {
            oxxIIOOXO2 = WorkManagerImplExtKt$WorkManagerImpl$1.INSTANCE;
        } else {
            oxxIIOOXO2 = oxxIIOOXO;
        }
        return createWorkManager(context, configuration, taskExecutor2, workDatabase2, trackers2, processor2, oxxIIOOXO2);
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "createWorkManagerScope")
    public static final xII createWorkManagerScope(@OXOo.OOXIXo TaskExecutor taskExecutor) {
        IIX0o.x0xO0oo(taskExecutor, "taskExecutor");
        CoroutineDispatcher taskCoroutineDispatcher = taskExecutor.getTaskCoroutineDispatcher();
        IIX0o.oO(taskCoroutineDispatcher, "taskExecutor.taskCoroutineDispatcher");
        return x0o.oIX0oI(taskCoroutineDispatcher);
    }

    @OXOo.OOXIXo
    public static final OxxIIOOXO<Context, Configuration, TaskExecutor, WorkDatabase, Trackers, Processor, List<Scheduler>> schedulers(@OXOo.OOXIXo final Scheduler... schedulers) {
        IIX0o.x0xO0oo(schedulers, "schedulers");
        return new OxxIIOOXO<Context, Configuration, TaskExecutor, WorkDatabase, Trackers, Processor, List<? extends Scheduler>>() { // from class: androidx.work.impl.WorkManagerImplExtKt$schedulers$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(6);
            }

            @Override // Oox.OxxIIOOXO
            public final List<Scheduler> invoke(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
                IIX0o.x0xO0oo(context, "<anonymous parameter 0>");
                IIX0o.x0xO0oo(configuration, "<anonymous parameter 1>");
                IIX0o.x0xO0oo(taskExecutor, "<anonymous parameter 2>");
                IIX0o.x0xO0oo(workDatabase, "<anonymous parameter 3>");
                IIX0o.x0xO0oo(trackers, "<anonymous parameter 4>");
                IIX0o.x0xO0oo(processor, "<anonymous parameter 5>");
                return ArraysKt___ArraysKt.IoXOX(schedulers);
            }
        };
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "createWorkManager")
    @XO0OX.xoIox
    public static final WorkManagerImpl createWorkManager(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Configuration configuration, @OXOo.OOXIXo TaskExecutor workTaskExecutor) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(configuration, "configuration");
        IIX0o.x0xO0oo(workTaskExecutor, "workTaskExecutor");
        return createWorkManager$default(context, configuration, workTaskExecutor, null, null, null, null, 120, null);
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "createWorkManager")
    @XO0OX.xoIox
    public static final WorkManagerImpl createWorkManager(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Configuration configuration, @OXOo.OOXIXo TaskExecutor workTaskExecutor, @OXOo.OOXIXo WorkDatabase workDatabase) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(configuration, "configuration");
        IIX0o.x0xO0oo(workTaskExecutor, "workTaskExecutor");
        IIX0o.x0xO0oo(workDatabase, "workDatabase");
        return createWorkManager$default(context, configuration, workTaskExecutor, workDatabase, null, null, null, 112, null);
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "createWorkManager")
    @XO0OX.xoIox
    public static final WorkManagerImpl createWorkManager(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Configuration configuration, @OXOo.OOXIXo TaskExecutor workTaskExecutor, @OXOo.OOXIXo WorkDatabase workDatabase, @OXOo.OOXIXo Trackers trackers) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(configuration, "configuration");
        IIX0o.x0xO0oo(workTaskExecutor, "workTaskExecutor");
        IIX0o.x0xO0oo(workDatabase, "workDatabase");
        IIX0o.x0xO0oo(trackers, "trackers");
        return createWorkManager$default(context, configuration, workTaskExecutor, workDatabase, trackers, null, null, 96, null);
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "createWorkManager")
    @XO0OX.xoIox
    public static final WorkManagerImpl createWorkManager(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Configuration configuration, @OXOo.OOXIXo TaskExecutor workTaskExecutor, @OXOo.OOXIXo WorkDatabase workDatabase, @OXOo.OOXIXo Trackers trackers, @OXOo.OOXIXo Processor processor) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(configuration, "configuration");
        IIX0o.x0xO0oo(workTaskExecutor, "workTaskExecutor");
        IIX0o.x0xO0oo(workDatabase, "workDatabase");
        IIX0o.x0xO0oo(trackers, "trackers");
        IIX0o.x0xO0oo(processor, "processor");
        return createWorkManager$default(context, configuration, workTaskExecutor, workDatabase, trackers, processor, null, 64, null);
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "createWorkManager")
    @XO0OX.xoIox
    public static final WorkManagerImpl createWorkManager(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Configuration configuration, @OXOo.OOXIXo TaskExecutor workTaskExecutor, @OXOo.OOXIXo WorkDatabase workDatabase, @OXOo.OOXIXo Trackers trackers, @OXOo.OOXIXo Processor processor, @OXOo.OOXIXo OxxIIOOXO<? super Context, ? super Configuration, ? super TaskExecutor, ? super WorkDatabase, ? super Trackers, ? super Processor, ? extends List<? extends Scheduler>> schedulersCreator) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(configuration, "configuration");
        IIX0o.x0xO0oo(workTaskExecutor, "workTaskExecutor");
        IIX0o.x0xO0oo(workDatabase, "workDatabase");
        IIX0o.x0xO0oo(trackers, "trackers");
        IIX0o.x0xO0oo(processor, "processor");
        IIX0o.x0xO0oo(schedulersCreator, "schedulersCreator");
        return new WorkManagerImpl(context.getApplicationContext(), configuration, workTaskExecutor, workDatabase, schedulersCreator.invoke(context, configuration, workTaskExecutor, workDatabase, trackers, processor), processor, trackers);
    }
}
