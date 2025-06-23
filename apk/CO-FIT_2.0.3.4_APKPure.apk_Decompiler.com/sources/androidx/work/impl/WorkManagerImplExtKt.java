package androidx.work.impl;

import O0IoXXOx.XO;
import OXOo.OOXIXo;
import Oox.OxxIIOOXO;
import XO0OX.xoIox;
import android.content.Context;
import androidx.work.Configuration;
import androidx.work.R;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.constraints.trackers.BatteryNotLowTracker;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import com.huawei.openalliance.ad.constant.bn;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.I0Io;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.x0o;
import kotlinx.coroutines.xII;
import kotlinx.coroutines.xxIXOIIO;

public final class WorkManagerImplExtKt {
    public static final void close(@OOXIXo WorkManagerImpl workManagerImpl) {
        IIX0o.x0xO0oo(workManagerImpl, "<this>");
        Object unused = xxIXOIIO.II0xO0((CoroutineContext) null, new WorkManagerImplExtKt$close$1(workManagerImpl, (I0Io<? super WorkManagerImplExtKt$close$1>) null), 1, (Object) null);
        workManagerImpl.getWorkDatabase().close();
    }

    /* access modifiers changed from: private */
    public static final List<Scheduler> createSchedulers(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
        Scheduler createBestAvailableBackgroundScheduler = Schedulers.createBestAvailableBackgroundScheduler(context, workDatabase, configuration);
        IIX0o.oO(createBestAvailableBackgroundScheduler, "createBestAvailableBackg…kDatabase, configuration)");
        return CollectionsKt__CollectionsKt.X00IoxXI(createBestAvailableBackgroundScheduler, new GreedyScheduler(context, configuration, trackers, processor, new WorkLauncherImpl(processor, taskExecutor), taskExecutor));
    }

    @OOXIXo
    @XO0OX.xxIXOIIO(name = "createTestWorkManager")
    public static final WorkManagerImpl createTestWorkManager(@OOXIXo Context context, @OOXIXo Configuration configuration, @OOXIXo TaskExecutor taskExecutor) {
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(configuration, XO.f15419Oxx0IOOO);
        IIX0o.x0xO0oo(taskExecutor, "workTaskExecutor");
        WorkDatabase.Companion companion = WorkDatabase.Companion;
        SerialExecutor serialTaskExecutor = taskExecutor.getSerialTaskExecutor();
        IIX0o.oO(serialTaskExecutor, "workTaskExecutor.serialTaskExecutor");
        return createWorkManager$default(context, configuration, taskExecutor, companion.create(context, serialTaskExecutor, configuration.getClock(), true), (Trackers) null, (Processor) null, (OxxIIOOXO) null, 112, (Object) null);
    }

    @xoIox
    @OOXIXo
    @XO0OX.xxIXOIIO(name = "createWorkManager")
    public static final WorkManagerImpl createWorkManager(@OOXIXo Context context, @OOXIXo Configuration configuration) {
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(configuration, XO.f15419Oxx0IOOO);
        return createWorkManager$default(context, configuration, (TaskExecutor) null, (WorkDatabase) null, (Trackers) null, (Processor) null, (OxxIIOOXO) null, 124, (Object) null);
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
            trackers2 = new Trackers(applicationContext2, taskExecutor2, (ConstraintTracker) null, (BatteryNotLowTracker) null, (ConstraintTracker) null, (ConstraintTracker) null, 60, (IIXOooo) null);
        } else {
            trackers2 = trackers;
        }
        if ((i & 32) != 0) {
            Configuration configuration2 = configuration;
            processor2 = new Processor(context.getApplicationContext(), configuration, taskExecutor2, workDatabase2);
        } else {
            Configuration configuration3 = configuration;
            processor2 = processor;
        }
        if ((i & 64) != 0) {
            oxxIIOOXO2 = WorkManagerImplExtKt$WorkManagerImpl$1.INSTANCE;
        } else {
            oxxIIOOXO2 = oxxIIOOXO;
        }
        return createWorkManager(context, configuration, taskExecutor2, workDatabase2, trackers2, processor2, oxxIIOOXO2);
    }

    @OOXIXo
    @XO0OX.xxIXOIIO(name = "createWorkManagerScope")
    public static final xII createWorkManagerScope(@OOXIXo TaskExecutor taskExecutor) {
        IIX0o.x0xO0oo(taskExecutor, "taskExecutor");
        CoroutineDispatcher taskCoroutineDispatcher = taskExecutor.getTaskCoroutineDispatcher();
        IIX0o.oO(taskCoroutineDispatcher, "taskExecutor.taskCoroutineDispatcher");
        return x0o.oIX0oI(taskCoroutineDispatcher);
    }

    @OOXIXo
    public static final OxxIIOOXO<Context, Configuration, TaskExecutor, WorkDatabase, Trackers, Processor, List<Scheduler>> schedulers(@OOXIXo Scheduler... schedulerArr) {
        IIX0o.x0xO0oo(schedulerArr, "schedulers");
        return new WorkManagerImplExtKt$schedulers$1(schedulerArr);
    }

    @xoIox
    @OOXIXo
    @XO0OX.xxIXOIIO(name = "createWorkManager")
    public static final WorkManagerImpl createWorkManager(@OOXIXo Context context, @OOXIXo Configuration configuration, @OOXIXo TaskExecutor taskExecutor) {
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(configuration, XO.f15419Oxx0IOOO);
        IIX0o.x0xO0oo(taskExecutor, "workTaskExecutor");
        return createWorkManager$default(context, configuration, taskExecutor, (WorkDatabase) null, (Trackers) null, (Processor) null, (OxxIIOOXO) null, 120, (Object) null);
    }

    @xoIox
    @OOXIXo
    @XO0OX.xxIXOIIO(name = "createWorkManager")
    public static final WorkManagerImpl createWorkManager(@OOXIXo Context context, @OOXIXo Configuration configuration, @OOXIXo TaskExecutor taskExecutor, @OOXIXo WorkDatabase workDatabase) {
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(configuration, XO.f15419Oxx0IOOO);
        IIX0o.x0xO0oo(taskExecutor, "workTaskExecutor");
        IIX0o.x0xO0oo(workDatabase, "workDatabase");
        return createWorkManager$default(context, configuration, taskExecutor, workDatabase, (Trackers) null, (Processor) null, (OxxIIOOXO) null, 112, (Object) null);
    }

    @xoIox
    @OOXIXo
    @XO0OX.xxIXOIIO(name = "createWorkManager")
    public static final WorkManagerImpl createWorkManager(@OOXIXo Context context, @OOXIXo Configuration configuration, @OOXIXo TaskExecutor taskExecutor, @OOXIXo WorkDatabase workDatabase, @OOXIXo Trackers trackers) {
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(configuration, XO.f15419Oxx0IOOO);
        IIX0o.x0xO0oo(taskExecutor, "workTaskExecutor");
        IIX0o.x0xO0oo(workDatabase, "workDatabase");
        IIX0o.x0xO0oo(trackers, "trackers");
        return createWorkManager$default(context, configuration, taskExecutor, workDatabase, trackers, (Processor) null, (OxxIIOOXO) null, 96, (Object) null);
    }

    @xoIox
    @OOXIXo
    @XO0OX.xxIXOIIO(name = "createWorkManager")
    public static final WorkManagerImpl createWorkManager(@OOXIXo Context context, @OOXIXo Configuration configuration, @OOXIXo TaskExecutor taskExecutor, @OOXIXo WorkDatabase workDatabase, @OOXIXo Trackers trackers, @OOXIXo Processor processor) {
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(configuration, XO.f15419Oxx0IOOO);
        IIX0o.x0xO0oo(taskExecutor, "workTaskExecutor");
        IIX0o.x0xO0oo(workDatabase, "workDatabase");
        IIX0o.x0xO0oo(trackers, "trackers");
        IIX0o.x0xO0oo(processor, "processor");
        return createWorkManager$default(context, configuration, taskExecutor, workDatabase, trackers, processor, (OxxIIOOXO) null, 64, (Object) null);
    }

    @XO0OX.xxIXOIIO(name = "createWorkManager")
    @xoIox
    @OOXIXo
    public static final WorkManagerImpl createWorkManager(@OOXIXo Context context, @OOXIXo Configuration configuration, @OOXIXo TaskExecutor taskExecutor, @OOXIXo WorkDatabase workDatabase, @OOXIXo Trackers trackers, @OOXIXo Processor processor, @OOXIXo OxxIIOOXO<? super Context, ? super Configuration, ? super TaskExecutor, ? super WorkDatabase, ? super Trackers, ? super Processor, ? extends List<? extends Scheduler>> oxxIIOOXO) {
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(configuration, XO.f15419Oxx0IOOO);
        IIX0o.x0xO0oo(taskExecutor, "workTaskExecutor");
        IIX0o.x0xO0oo(workDatabase, "workDatabase");
        IIX0o.x0xO0oo(trackers, "trackers");
        IIX0o.x0xO0oo(processor, "processor");
        IIX0o.x0xO0oo(oxxIIOOXO, "schedulersCreator");
        Configuration configuration2 = configuration;
        TaskExecutor taskExecutor2 = taskExecutor;
        WorkDatabase workDatabase2 = workDatabase;
        Processor processor2 = processor;
        return new WorkManagerImpl(context.getApplicationContext(), configuration2, taskExecutor2, workDatabase2, (List) oxxIIOOXO.invoke(context, configuration2, taskExecutor2, workDatabase2, trackers, processor2), processor2, trackers);
    }
}
