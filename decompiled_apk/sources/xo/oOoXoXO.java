package xo;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes13.dex */
public class oOoXoXO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f34927I0Io = 4;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static Handler f34928II0XooXoX = null;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f34929II0xO0 = 2;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static ThreadPoolExecutor f34930Oxx0IOOO = null;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f34931X0o0xo = 100;

    /* renamed from: XO, reason: collision with root package name */
    public static long f34932XO = 0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f34933oIX0oI = "UserReportAddThreadPool";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f34934oxoX = 60;

    /* loaded from: classes13.dex */
    public static class I0Io implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Runnable f34935XO;

        public I0Io(Runnable runnable) {
            this.f34935XO = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            oOoXoXO.II0xO0(this.f34935XO);
        }
    }

    /* loaded from: classes13.dex */
    public static class oIX0oI implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "UserReportAddThreadPool-" + oOoXoXO.oIX0oI());
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(100), new oIX0oI());
        f34930Oxx0IOOO = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f34930Oxx0IOOO.setRejectedExecutionHandler(new II0xO0());
    }

    public static void I0Io(Runnable runnable, int i) {
        if (i == 0) {
            II0xO0(runnable);
        } else if (i > 0) {
            if (f34928II0XooXoX == null) {
                f34928II0XooXoX = new Handler(Looper.getMainLooper());
            }
            f34928II0XooXoX.postDelayed(new I0Io(runnable), i);
        }
    }

    public static void II0xO0(Runnable runnable) {
        try {
            f34930Oxx0IOOO.execute(runnable);
        } catch (Throwable unused) {
            xxIXOIIO.I0Io(f34933oIX0oI, "post error");
        }
    }

    public static /* synthetic */ long oIX0oI() {
        long j = f34932XO;
        f34932XO = 1 + j;
        return j;
    }

    public static void oxoX(Runnable runnable) {
        Handler handler = f34928II0XooXoX;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    /* loaded from: classes13.dex */
    public static class II0xO0 implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    }
}
