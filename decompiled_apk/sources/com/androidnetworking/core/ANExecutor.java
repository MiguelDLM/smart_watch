package com.androidnetworking.core;

import android.net.NetworkInfo;
import com.androidnetworking.common.Priority;
import com.androidnetworking.internal.InternalRunnable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ANExecutor extends ThreadPoolExecutor {
    private static final int DEFAULT_THREAD_COUNT = 3;

    /* loaded from: classes.dex */
    public static final class AndroidNetworkingFutureTask extends FutureTask<InternalRunnable> implements Comparable<AndroidNetworkingFutureTask> {
        private final InternalRunnable hunter;

        public AndroidNetworkingFutureTask(InternalRunnable internalRunnable) {
            super(internalRunnable, null);
            this.hunter = internalRunnable;
        }

        @Override // java.lang.Comparable
        public int compareTo(AndroidNetworkingFutureTask androidNetworkingFutureTask) {
            Priority priority = this.hunter.getPriority();
            Priority priority2 = androidNetworkingFutureTask.hunter.getPriority();
            return priority == priority2 ? this.hunter.sequence - androidNetworkingFutureTask.hunter.sequence : priority2.ordinal() - priority.ordinal();
        }
    }

    public ANExecutor(int i, ThreadFactory threadFactory) {
        super(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), threadFactory);
    }

    private void setThreadCount(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    public void adjustThreadCount(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            int type = networkInfo.getType();
            if (type != 0) {
                if (type != 1 && type != 6 && type != 9) {
                    setThreadCount(3);
                    return;
                } else {
                    setThreadCount(4);
                    return;
                }
            }
            int subtype = networkInfo.getSubtype();
            switch (subtype) {
                case 1:
                case 2:
                    setThreadCount(1);
                    return;
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                default:
                    switch (subtype) {
                        case 12:
                            break;
                        case 13:
                        case 14:
                        case 15:
                            setThreadCount(3);
                            return;
                        default:
                            setThreadCount(3);
                            return;
                    }
            }
            setThreadCount(2);
            return;
        }
        setThreadCount(3);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        AndroidNetworkingFutureTask androidNetworkingFutureTask = new AndroidNetworkingFutureTask((InternalRunnable) runnable);
        execute(androidNetworkingFutureTask);
        return androidNetworkingFutureTask;
    }
}
