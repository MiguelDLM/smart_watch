package com.alimm.tanx.core.web.cache;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WebCacheThreadPool {
    private static final int CORE_POOL_SIZE = 1;
    private static final int DEFAULT_QUEUE_SIZE = 100;
    private static final int KEEP_ALIVE_SECONDS = 60;
    private static final int MAX_POOL_SIZE = 1;
    private static final String TAG = "WebCacheThreadPool";
    private static final ThreadPoolExecutor sExecutor;
    private static Handler sHandler;
    private static long sIndex;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(100), new ThreadFactory() {
            public Thread newThread(@NonNull Runnable runnable) {
                return new Thread(runnable, "WebCacheThreadPool-" + WebCacheThreadPool.access$008());
            }
        });
        sExecutor = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
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
            LogUtils.d(TAG, "UserReport :post exception", th);
        }
    }

    public static void postDelayed(@NonNull final Runnable runnable, int i) {
        if (i == 0) {
            post(runnable);
        } else if (i > 0) {
            if (sHandler == null) {
                sHandler = new Handler(Looper.getMainLooper());
            }
            sHandler.postDelayed(new Runnable() {
                public void run() {
                    WebCacheThreadPool.post(runnable);
                }
            }, (long) i);
        }
    }

    public static void removeTask(@NonNull Runnable runnable) {
        Handler handler = sHandler;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
