package androidx.work.impl.background.greedy;

import OXOo.OOXIXo;
import XO0OX.xoIox;
import androidx.work.RunnableScheduler;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkLauncher;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nTimeLimiter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeLimiter.kt\nandroidx/work/impl/background/greedy/TimeLimiter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,45:1\n1#2:46\n*E\n"})
public final class TimeLimiter {
    @OOXIXo
    private final WorkLauncher launcher;
    @OOXIXo
    private final Object lock;
    @OOXIXo
    private final RunnableScheduler runnableScheduler;
    private final long timeoutMs;
    @OOXIXo
    private final Map<StartStopToken, Runnable> tracked;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @xoIox
    public TimeLimiter(@OOXIXo RunnableScheduler runnableScheduler2, @OOXIXo WorkLauncher workLauncher) {
        this(runnableScheduler2, workLauncher, 0, 4, (IIXOooo) null);
        IIX0o.x0xO0oo(runnableScheduler2, "runnableScheduler");
        IIX0o.x0xO0oo(workLauncher, "launcher");
    }

    /* access modifiers changed from: private */
    public static final void track$lambda$0(TimeLimiter timeLimiter, StartStopToken startStopToken) {
        timeLimiter.launcher.stopWork(startStopToken, 3);
    }

    public final void cancel(@OOXIXo StartStopToken startStopToken) {
        Runnable remove;
        IIX0o.x0xO0oo(startStopToken, "token");
        synchronized (this.lock) {
            remove = this.tracked.remove(startStopToken);
        }
        if (remove != null) {
            this.runnableScheduler.cancel(remove);
        }
    }

    public final void track(@OOXIXo StartStopToken startStopToken) {
        IIX0o.x0xO0oo(startStopToken, "token");
        oIX0oI oix0oi = new oIX0oI(this, startStopToken);
        synchronized (this.lock) {
            Runnable put = this.tracked.put(startStopToken, oix0oi);
        }
        this.runnableScheduler.scheduleWithDelay(this.timeoutMs, oix0oi);
    }

    @xoIox
    public TimeLimiter(@OOXIXo RunnableScheduler runnableScheduler2, @OOXIXo WorkLauncher workLauncher, long j) {
        IIX0o.x0xO0oo(runnableScheduler2, "runnableScheduler");
        IIX0o.x0xO0oo(workLauncher, "launcher");
        this.runnableScheduler = runnableScheduler2;
        this.launcher = workLauncher;
        this.timeoutMs = j;
        this.lock = new Object();
        this.tracked = new LinkedHashMap();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TimeLimiter(RunnableScheduler runnableScheduler2, WorkLauncher workLauncher, long j, int i, IIXOooo iIXOooo) {
        this(runnableScheduler2, workLauncher, (i & 4) != 0 ? TimeUnit.MINUTES.toMillis(90) : j);
    }
}
