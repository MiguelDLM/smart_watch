package IO0XoXxO;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes11.dex */
public class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final ThreadPoolExecutor f414I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f415II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f416oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public static Handler f417oxoX;

    /* renamed from: IO0XoXxO.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class RunnableC0013oIX0oI implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Runnable f418XO;

        public RunnableC0013oIX0oI(Runnable runnable) {
            this.f418XO = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            oIX0oI.f417oxoX.post(this.f418XO);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f416oIX0oI = availableProcessors;
        int max = Math.max(availableProcessors, 5);
        f415II0xO0 = max;
        f414I0Io = new ThreadPoolExecutor(max, max, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128));
        f417oxoX = new Handler(Looper.getMainLooper());
    }

    public static void I0Io(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            f417oxoX.post(runnable);
        }
    }

    public static void II0xO0(Runnable runnable) {
        f414I0Io.execute(runnable);
    }

    public static <T> Future<T> oIX0oI(Callable<T> callable) {
        return f414I0Io.submit(callable);
    }

    public static void oxoX(Runnable runnable) {
        f414I0Io.execute(new RunnableC0013oIX0oI(runnable));
    }
}
