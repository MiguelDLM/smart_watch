package xxIXOIIO;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class oOoXoXO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static volatile ThreadPoolExecutor f35482oIX0oI;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static Handler f35481II0xO0 = new Handler(Looper.getMainLooper());

    /* renamed from: I0Io, reason: collision with root package name */
    public static final Random f35480I0Io = new Random();

    public static void I0Io(Runnable runnable) {
        if (f35482oIX0oI == null) {
            II0xO0();
        }
        f35482oIX0oI.execute(runnable);
    }

    public static void II0xO0() {
        f35482oIX0oI = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static void X0o0xo(Runnable runnable) {
        f35481II0xO0.post(runnable);
    }

    public static <T> Future<T> oIX0oI(Callable<T> callable) {
        if (f35482oIX0oI == null) {
            II0xO0();
        }
        return f35482oIX0oI.submit(callable);
    }

    public static void oxoX(String str, Context context) {
        if (context != null && f35480I0Io.nextInt(100) < 5) {
            try {
                context.getSharedPreferences("cb_test", 0).edit().putString(MediationConstant.ADN_GDT, str).apply();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
