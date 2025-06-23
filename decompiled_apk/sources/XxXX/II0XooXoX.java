package XxXX;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes13.dex */
public final class II0XooXoX {

    /* renamed from: I0Io, reason: collision with root package name */
    public static Handler f4205I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public static HandlerThread f4208oxoX;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static Object f4207oIX0oI = new Object();

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final Executor f4206II0xO0 = oxoX();

    /* loaded from: classes13.dex */
    public static class II0xO0 implements Executor {

        /* renamed from: Oo, reason: collision with root package name */
        public Runnable f4209Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final Queue<Runnable> f4210XO;

        /* loaded from: classes13.dex */
        public class oIX0oI implements Runnable {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ Runnable f4212XO;

            public oIX0oI(Runnable runnable) {
                this.f4212XO = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f4212XO.run();
                } finally {
                    II0xO0.this.oIX0oI();
                }
            }
        }

        public II0xO0() {
            this.f4210XO = new LinkedList();
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            this.f4210XO.offer(new oIX0oI(runnable));
            if (this.f4209Oo == null) {
                oIX0oI();
            }
        }

        public synchronized void oIX0oI() {
            Runnable poll = this.f4210XO.poll();
            this.f4209Oo = poll;
            if (poll != null) {
                II0XooXoX.f4206II0xO0.execute(poll);
            }
        }
    }

    public static Executor I0Io() {
        return new II0xO0();
    }

    public static void II0xO0(Runnable runnable) {
        oIX0oI().post(runnable);
    }

    public static Handler oIX0oI() {
        if (f4205I0Io == null) {
            synchronized (II0XooXoX.class) {
                HandlerThread handlerThread = new HandlerThread("SDK_SUB");
                f4208oxoX = handlerThread;
                handlerThread.start();
                f4205I0Io = new Handler(f4208oxoX.getLooper());
            }
        }
        return f4205I0Io;
    }

    public static Executor oxoX() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        if (threadPoolExecutor instanceof ThreadPoolExecutor) {
            threadPoolExecutor.setCorePoolSize(3);
        }
        return threadPoolExecutor;
    }
}
