package o0IXXIx;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes11.dex */
public class ooOOo0oXI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final LinkedBlockingQueue<Runnable> f31091I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f31092II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final ArrayBlockingQueue<Runnable> f31093X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public static final LinkedBlockingQueue<Runnable> f31094XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f31095oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final LinkedBlockingQueue<Runnable> f31096oxoX;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f31095oIX0oI = availableProcessors;
        f31092II0xO0 = Math.max((availableProcessors / 2) + 1, 4);
        f31091I0Io = new LinkedBlockingQueue<>();
        f31096oxoX = new LinkedBlockingQueue<>();
        f31093X0o0xo = new ArrayBlockingQueue<>(50);
        f31094XO = new LinkedBlockingQueue<>();
    }

    public static ThreadPoolExecutor I0Io() {
        return new ThreadPoolExecutor(2, 6, 20L, TimeUnit.SECONDS, f31093X0o0xo, new oOoXoXO(5, "Octopus-adsdk-file-log-upload-thread-"), X0o0xo());
    }

    public static ThreadPoolExecutor II0xO0() {
        return new ThreadPoolExecutor(0, 2, 5L, TimeUnit.SECONDS, f31096oxoX, new oOoXoXO(5, "Octopus-adsdk-heartbeat-thread-"), X0o0xo());
    }

    public static RejectedExecutionHandler X0o0xo() {
        return new oIX0oI();
    }

    public static ThreadPoolExecutor oIX0oI() {
        return new ThreadPoolExecutor(2, f31092II0xO0, 5L, TimeUnit.SECONDS, f31091I0Io, new oOoXoXO(5, "Octopus-adsdk-adrequest-thread-"), X0o0xo());
    }

    public static ThreadPoolExecutor oxoX() {
        return new ThreadPoolExecutor(2, f31092II0xO0, 20L, TimeUnit.SECONDS, f31094XO, new oOoXoXO(5, "afIt-"), X0o0xo());
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    }
}
