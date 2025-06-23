package com.baidu.mapframework.nirvana.concurrent;

import androidx.annotation.NonNull;
import com.baidu.mapframework.nirvana.ExceptionCallback;
import com.baidu.mapframework.nirvana.NirvanaExecutors;
import com.baidu.mapframework.nirvana.NirvanaFramework;
import com.baidu.mapframework.nirvana.Utils;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.monitor.RecordType;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.mapframework.nirvana.schedule.UITaskType;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class ConcurrentManager {

    /* renamed from: a, reason: collision with root package name */
    private static final ExecutorService f6083a = NirvanaExecutors.defaultThreadPool();
    private static final ExecutorService b = NirvanaExecutors.newCachedThreadPool("ConcurrentManager.UI.worker");
    private static final ScheduledThreadPoolExecutor c = NirvanaExecutors.newScheduledThreadPool("ConcurrentManager.SCHEDULE.worker", 1);

    private static Runnable a(@NonNull final Runnable runnable, final ExceptionCallback exceptionCallback, final ScheduleConfig scheduleConfig) {
        return new Runnable() { // from class: com.baidu.mapframework.nirvana.concurrent.ConcurrentManager.2
            @Override // java.lang.Runnable
            public void run() {
                NirvanaFramework.getMonitor().markRunning(runnable);
                try {
                    if (scheduleConfig.isLifecycleActive()) {
                        runnable.run();
                    }
                } catch (Exception e) {
                    ExceptionCallback exceptionCallback2 = exceptionCallback;
                    if (exceptionCallback2 != null) {
                        exceptionCallback2.onException(e);
                    } else {
                        NirvanaFramework.onUncaughtException("ConcurrentManager", e);
                    }
                }
                NirvanaFramework.getMonitor().markFinish(runnable);
            }
        };
    }

    public static void executeTask(@NonNull Module module, @NonNull ConcurrentTask concurrentTask, @NonNull ScheduleConfig scheduleConfig) {
        if (!Utils.executeParamCheck(module, concurrentTask, scheduleConfig)) {
            return;
        }
        NirvanaFramework.getMonitor().markSubmit(RecordType.CONCURRENT, concurrentTask, module, scheduleConfig);
        Runnable a2 = a(concurrentTask, concurrentTask.getExceptionCallback(), scheduleConfig);
        if (concurrentTask.a() == null) {
            if (a(scheduleConfig)) {
                b.execute(a2);
                return;
            } else {
                f6083a.execute(a2);
                return;
            }
        }
        concurrentTask.a().a().a(a2);
    }

    public static QueueToken obtainSingleTaskQueue(Module module) {
        return new QueueToken(new ConcurrentQueueRunner(NirvanaExecutors.newFixedThreadPool(module.name(), 1)));
    }

    public static QueueToken obtainTaskQueue(Module module) {
        return new QueueToken(new ConcurrentQueueRunner(f6083a));
    }

    public static void scheduleTask(@NonNull Module module, @NonNull ScheduleTask scheduleTask, @NonNull ScheduleConfig scheduleConfig) {
        if (!Utils.executeParamCheck(module, scheduleTask, scheduleConfig)) {
            return;
        }
        NirvanaFramework.getMonitor().markSubmit(RecordType.CONCURRENT, scheduleTask, module, scheduleConfig);
        c.schedule(a(scheduleTask, scheduleTask.getExceptionCallback(), scheduleConfig), scheduleTask.getDelay(), TimeUnit.MILLISECONDS);
    }

    public static <T> FutureTask submitTask(@NonNull Module module, @NonNull ConcurrentCallable<T> concurrentCallable, @NonNull ScheduleConfig scheduleConfig) {
        if (!Utils.executeParamCheck(module, concurrentCallable, scheduleConfig)) {
            return new FutureTask(new Callable<T>() { // from class: com.baidu.mapframework.nirvana.concurrent.ConcurrentManager.1
                @Override // java.util.concurrent.Callable
                public T call() throws Exception {
                    return null;
                }
            });
        }
        FutureTask futureTask = new FutureTask(concurrentCallable);
        NirvanaFramework.getMonitor().markSubmit(RecordType.CONCURRENT, futureTask, module, scheduleConfig);
        Runnable a2 = a(futureTask, concurrentCallable.getExceptionCallback(), scheduleConfig);
        if (concurrentCallable.a() == null) {
            if (a(scheduleConfig)) {
                b.execute(a2);
            } else {
                f6083a.execute(a2);
            }
        } else {
            concurrentCallable.a().a().a(a2);
        }
        return futureTask;
    }

    private static boolean a(ScheduleConfig scheduleConfig) {
        try {
            return scheduleConfig.getType() instanceof UITaskType;
        } catch (Exception unused) {
            return false;
        }
    }
}
