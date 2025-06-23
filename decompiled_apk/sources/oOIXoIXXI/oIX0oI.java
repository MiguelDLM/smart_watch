package oOIXoIXXI;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes6.dex */
public class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static ExecutorService f31987I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static Handler f31988II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static ExecutorService f31989X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static Executor f31990oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public static ExecutorService f31991oxoX;

    /* loaded from: classes6.dex */
    public static class I0Io implements ThreadFactory {

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public static final AtomicInteger f31992Oxx0xo = new AtomicInteger(1);

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final String f31993IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final AtomicInteger f31994Oo = new AtomicInteger(1);

        /* renamed from: XO, reason: collision with root package name */
        public final ThreadGroup f31995XO;

        public I0Io() {
            ThreadGroup threadGroup;
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
            } else {
                threadGroup = Thread.currentThread().getThreadGroup();
            }
            this.f31995XO = threadGroup;
            this.f31993IXxxXO = "CZXingPool-" + f31992Oxx0xo.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f31995XO, runnable, this.f31993IXxxXO + this.f31994Oo.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    /* loaded from: classes6.dex */
    public class II0xO0 implements ThreadFactory {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ boolean f31996Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ String f31997XO;

        public II0xO0(String str, boolean z) {
            this.f31997XO = str;
            this.f31996Oo = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f31997XO);
            thread.setDaemon(this.f31996Oo);
            return thread;
        }
    }

    /* renamed from: oOIXoIXXI.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class ExecutorC1127oIX0oI implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            oIX0oI.f31988II0xO0.post(runnable);
        }
    }

    public static synchronized ExecutorService I0Io() {
        ExecutorService executorService;
        synchronized (oIX0oI.class) {
            try {
                if (f31989X0o0xo == null) {
                    f31989X0o0xo = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new I0Io());
                }
                executorService = f31989X0o0xo;
            } catch (Throwable th) {
                throw th;
            }
        }
        return executorService;
    }

    public static ThreadFactory II0XooXoX(String str, boolean z) {
        return new II0xO0(str, z);
    }

    public static synchronized ExecutorService II0xO0() {
        ExecutorService executorService;
        synchronized (oIX0oI.class) {
            try {
                if (f31987I0Io == null) {
                    int availableProcessors = Runtime.getRuntime().availableProcessors();
                    f31987I0Io = new ThreadPoolExecutor(availableProcessors, availableProcessors, 500L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(1), new I0Io(), new ThreadPoolExecutor.DiscardOldestPolicy());
                }
                executorService = f31987I0Io;
            } catch (Throwable th) {
                throw th;
            }
        }
        return executorService;
    }

    public static void Oxx0IOOO(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            oxoX().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public static synchronized ExecutorService X0o0xo() {
        ExecutorService executorService;
        synchronized (oIX0oI.class) {
            try {
                if (f31991oxoX == null) {
                    f31991oxoX = Executors.newSingleThreadExecutor();
                }
                executorService = f31991oxoX;
            } catch (Throwable th) {
                throw th;
            }
        }
        return executorService;
    }

    public static void XO(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        II0xO0().execute(runnable);
    }

    public static synchronized Executor oxoX() {
        Executor executor;
        synchronized (oIX0oI.class) {
            try {
                if (f31990oIX0oI == null) {
                    f31988II0xO0 = new Handler(Looper.getMainLooper());
                    f31990oIX0oI = new ExecutorC1127oIX0oI();
                }
                executor = f31990oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
        return executor;
    }
}
