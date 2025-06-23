package com.facebook.bolts;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class AndroidExecutors {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private static final AndroidExecutors INSTANCE = new AndroidExecutors();
    private static final long KEEP_ALIVE_TIME = 1;
    private static final int MAX_POOL_SIZE;

    @OXOo.OOXIXo
    private final Executor uiThread = new UIThreadExecutor();

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final ExecutorService newCachedThreadPool() {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(AndroidExecutors.CORE_POOL_SIZE, AndroidExecutors.MAX_POOL_SIZE, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return threadPoolExecutor;
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final Executor uiThread() {
            return AndroidExecutors.INSTANCE.uiThread;
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class UIThreadExecutor implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(@OXOo.OOXIXo Runnable command) {
            IIX0o.x0xO0oo(command, "command");
            new Handler(Looper.getMainLooper()).post(command);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        CORE_POOL_SIZE = availableProcessors + 1;
        MAX_POOL_SIZE = (availableProcessors * 2) + 1;
    }

    private AndroidExecutors() {
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final ExecutorService newCachedThreadPool() {
        return Companion.newCachedThreadPool();
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Executor uiThread() {
        return Companion.uiThread();
    }
}
