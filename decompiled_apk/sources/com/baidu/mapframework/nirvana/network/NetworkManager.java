package com.baidu.mapframework.nirvana.network;

import androidx.annotation.NonNull;
import com.baidu.mapframework.nirvana.ExceptionCallback;
import com.baidu.mapframework.nirvana.NirvanaExecutors;
import com.baidu.mapframework.nirvana.NirvanaFramework;
import com.baidu.mapframework.nirvana.Utils;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.monitor.RecordType;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* loaded from: classes7.dex */
public class NetworkManager {

    /* renamed from: a, reason: collision with root package name */
    private static final ExecutorService f6109a = NirvanaExecutors.newDefaultThreadPool("NetworkManager");

    public static void excuteRunnable(@NonNull final Runnable runnable) {
        f6109a.execute(new Runnable() { // from class: com.baidu.mapframework.nirvana.network.NetworkManager.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } catch (Exception e) {
                    Utils.loge("NetworkManager executeTask exception", e);
                }
            }
        });
    }

    public static Future executeCallble(@NonNull Module module, @NonNull Callable callable, @NonNull ScheduleConfig scheduleConfig) {
        try {
            return f6109a.submit(callable);
        } catch (Exception unused) {
            return new FutureTask(new Callable() { // from class: com.baidu.mapframework.nirvana.network.NetworkManager.2
                @Override // java.util.concurrent.Callable
                public Object call() throws Exception {
                    return null;
                }
            });
        }
    }

    public static void executeTask(@NonNull Module module, @NonNull final NetworkTask networkTask, @NonNull ScheduleConfig scheduleConfig) {
        if (!Utils.executeParamCheck(module, networkTask, scheduleConfig)) {
            return;
        }
        NirvanaFramework.getMonitor().markSubmit(RecordType.NETWORK, networkTask, module, scheduleConfig);
        f6109a.execute(new Runnable() { // from class: com.baidu.mapframework.nirvana.network.NetworkManager.1
            @Override // java.lang.Runnable
            public void run() {
                NirvanaFramework.getMonitor().markRunning(NetworkTask.this);
                try {
                    NetworkTask.this.c.run();
                } catch (Exception e) {
                    Utils.loge("NetworkManager executeTask exception", e);
                    ExceptionCallback exceptionCallback = NetworkTask.this.getExceptionCallback();
                    if (exceptionCallback != null) {
                        exceptionCallback.onException(e);
                    } else {
                        NirvanaFramework.onUncaughtException("NetworkManager", e);
                    }
                }
                NirvanaFramework.getMonitor().markFinish(NetworkTask.this);
            }
        });
    }

    public static ExecutorService getAppNetworkThreadPool() {
        return f6109a;
    }
}
