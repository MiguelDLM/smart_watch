package androidx.lifecycle;

import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.Xo0;
import kotlinx.coroutines.o0oIxOo;

/* loaded from: classes.dex */
public final class DispatchQueue {
    private boolean finished;
    private boolean isDraining;
    private boolean paused = true;

    @OXOo.OOXIXo
    private final Queue<Runnable> queue = new ArrayDeque();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchAndEnqueue$lambda$2$lambda$1(DispatchQueue this$0, Runnable runnable) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(runnable, "$runnable");
        this$0.enqueue(runnable);
    }

    @MainThread
    private final void enqueue(Runnable runnable) {
        if (this.queue.offer(runnable)) {
            drainQueue();
            return;
        }
        throw new IllegalStateException("cannot enqueue any more runnables");
    }

    @MainThread
    public final boolean canRun() {
        if (!this.finished && this.paused) {
            return false;
        }
        return true;
    }

    @AnyThread
    public final void dispatchAndEnqueue(@OXOo.OOXIXo CoroutineContext context, @OXOo.OOXIXo final Runnable runnable) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(runnable, "runnable");
        o0oIxOo IIXOooo2 = Xo0.X0o0xo().IIXOooo();
        if (!IIXOooo2.isDispatchNeeded(context) && !canRun()) {
            enqueue(runnable);
        } else {
            IIXOooo2.dispatch(context, new Runnable() { // from class: androidx.lifecycle.oxoX
                @Override // java.lang.Runnable
                public final void run() {
                    DispatchQueue.dispatchAndEnqueue$lambda$2$lambda$1(DispatchQueue.this, runnable);
                }
            });
        }
    }

    @MainThread
    public final void drainQueue() {
        if (this.isDraining) {
            return;
        }
        try {
            this.isDraining = true;
            while (!this.queue.isEmpty() && canRun()) {
                Runnable poll = this.queue.poll();
                if (poll != null) {
                    poll.run();
                }
            }
        } finally {
            this.isDraining = false;
        }
    }

    @MainThread
    public final void finish() {
        this.finished = true;
        drainQueue();
    }

    @MainThread
    public final void pause() {
        this.paused = true;
    }

    @MainThread
    public final void resume() {
        if (!this.paused) {
            return;
        }
        if (!this.finished) {
            this.paused = false;
            drainQueue();
            return;
        }
        throw new IllegalStateException("Cannot resume a finished dispatcher");
    }
}
