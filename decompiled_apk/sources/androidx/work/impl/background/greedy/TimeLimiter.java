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
/* loaded from: classes.dex */
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @xoIox
    public TimeLimiter(@OOXIXo RunnableScheduler runnableScheduler, @OOXIXo WorkLauncher launcher) {
        this(runnableScheduler, launcher, 0L, 4, null);
        IIX0o.x0xO0oo(runnableScheduler, "runnableScheduler");
        IIX0o.x0xO0oo(launcher, "launcher");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void track$lambda$0(TimeLimiter timeLimiter, StartStopToken startStopToken) {
        timeLimiter.launcher.stopWork(startStopToken, 3);
    }

    public final void cancel(@OOXIXo StartStopToken token) {
        Runnable remove;
        IIX0o.x0xO0oo(token, "token");
        synchronized (this.lock) {
            remove = this.tracked.remove(token);
        }
        if (remove != null) {
            this.runnableScheduler.cancel(remove);
        }
    }

    public final void track(@OOXIXo final StartStopToken token) {
        IIX0o.x0xO0oo(token, "token");
        Runnable runnable = new Runnable() { // from class: androidx.work.impl.background.greedy.oIX0oI
            @Override // java.lang.Runnable
            public final void run() {
                TimeLimiter.track$lambda$0(TimeLimiter.this, token);
            }
        };
        synchronized (this.lock) {
            this.tracked.put(token, runnable);
        }
        this.runnableScheduler.scheduleWithDelay(this.timeoutMs, runnable);
    }

    @xoIox
    public TimeLimiter(@OOXIXo RunnableScheduler runnableScheduler, @OOXIXo WorkLauncher launcher, long j) {
        IIX0o.x0xO0oo(runnableScheduler, "runnableScheduler");
        IIX0o.x0xO0oo(launcher, "launcher");
        this.runnableScheduler = runnableScheduler;
        this.launcher = launcher;
        this.timeoutMs = j;
        this.lock = new Object();
        this.tracked = new LinkedHashMap();
    }

    public /* synthetic */ TimeLimiter(RunnableScheduler runnableScheduler, WorkLauncher workLauncher, long j, int i, IIXOooo iIXOooo) {
        this(runnableScheduler, workLauncher, (i & 4) != 0 ? TimeUnit.MINUTES.toMillis(90L) : j);
    }
}
