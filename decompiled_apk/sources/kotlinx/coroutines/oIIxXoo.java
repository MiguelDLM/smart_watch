package kotlinx.coroutines;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@kotlin.jvm.internal.XX({"SMAP\nThreadPoolDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadPoolDispatcher.kt\nkotlinx/coroutines/ThreadPoolDispatcherKt__ThreadPoolDispatcherKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,47:1\n1#2:48\n*E\n"})
/* loaded from: classes6.dex */
public final /* synthetic */ class oIIxXoo {
    public static final Thread I0Io(int i, String str, AtomicInteger atomicInteger, Runnable runnable) {
        if (i != 1) {
            str = str + '-' + atomicInteger.incrementAndGet();
        }
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(true);
        return thread;
    }

    @OXOo.OOXIXo
    @xo0x
    public static final ExecutorCoroutineDispatcher II0xO0(final int i, @OXOo.OOXIXo final String str) {
        if (i >= 1) {
            final AtomicInteger atomicInteger = new AtomicInteger();
            return O00XxXI.oxoX(Executors.newScheduledThreadPool(i, new ThreadFactory() { // from class: kotlinx.coroutines.IOoo
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread I0Io2;
                    I0Io2 = oIIxXoo.I0Io(i, str, atomicInteger, runnable);
                    return I0Io2;
                }
            }));
        }
        throw new IllegalArgumentException(("Expected at least one thread, but " + i + " specified").toString());
    }
}
