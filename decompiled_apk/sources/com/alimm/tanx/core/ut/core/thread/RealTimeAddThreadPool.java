package com.alimm.tanx.core.ut.core.thread;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class RealTimeAddThreadPool {
    private static final int CORE_POOL_SIZE = 1;
    private static final int DEFAULT_QUEUE_SIZE = 100;
    private static final int KEEP_ALIVE_SECONDS = 60;
    private static final int MAX_POOL_SIZE = 1;
    private static final String TAG = "UserReportAddThreadPool";
    private static final ThreadPoolExecutor sExecutor;
    private static Handler sHandler;
    private static long sIndex;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(100), new ThreadFactory() { // from class: com.alimm.tanx.core.ut.core.thread.RealTimeAddThreadPool.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull Runnable runnable) {
                return new Thread(runnable, "UserReportAddThreadPool-" + RealTimeAddThreadPool.access$008());
            }
        });
        sExecutor = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() { // from class: com.alimm.tanx.core.ut.core.thread.RealTimeAddThreadPool.2
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
            }
        });
    }

    public static /* synthetic */ long access$008() {
        long j = sIndex;
        sIndex = 1 + j;
        return j;
    }

    public static void post(@NonNull Runnable runnable) {
        try {
            sExecutor.execute(runnable);
        } catch (Throwable th) {
            LogUtils.d("UserReportAddThreadPool", "UserReport :post exception", th);
        }
    }

    public static void postDelayed(@NonNull final Runnable runnable, int i) {
        if (i == 0) {
            post(runnable);
        } else if (i > 0) {
            if (sHandler == null) {
                sHandler = new Handler(Looper.getMainLooper());
            }
            sHandler.postDelayed(new Runnable() { // from class: com.alimm.tanx.core.ut.core.thread.RealTimeAddThreadPool.3
                @Override // java.lang.Runnable
                public void run() {
                    RealTimeAddThreadPool.post(runnable);
                }
            }, i);
        }
    }

    public static void removeTask(@NonNull Runnable runnable) {
        Handler handler = sHandler;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
