package XI0IXoo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final ExecutorService f3714oIX0oI = Executors.newCachedThreadPool();

    public static void II0xO0(Runnable runnable) {
        f3714oIX0oI.execute(runnable);
    }

    public static Executor oIX0oI() {
        return f3714oIX0oI;
    }
}
