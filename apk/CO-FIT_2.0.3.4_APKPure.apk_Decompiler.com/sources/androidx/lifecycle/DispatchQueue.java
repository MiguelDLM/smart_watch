package androidx.lifecycle;

import OXOo.OOXIXo;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import com.huawei.openalliance.ad.constant.bn;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.Xo0;
import kotlinx.coroutines.o0oIxOo;

public final class DispatchQueue {
    private boolean finished;
    private boolean isDraining;
    private boolean paused = true;
    @OOXIXo
    private final Queue<Runnable> queue = new ArrayDeque();

    /* access modifiers changed from: private */
    public static final void dispatchAndEnqueue$lambda$2$lambda$1(DispatchQueue dispatchQueue, Runnable runnable) {
        IIX0o.x0xO0oo(dispatchQueue, "this$0");
        IIX0o.x0xO0oo(runnable, "$runnable");
        dispatchQueue.enqueue(runnable);
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
        if (this.finished || !this.paused) {
            return true;
        }
        return false;
    }

    @AnyThread
    public final void dispatchAndEnqueue(@OOXIXo CoroutineContext coroutineContext, @OOXIXo Runnable runnable) {
        IIX0o.x0xO0oo(coroutineContext, bn.f.o);
        IIX0o.x0xO0oo(runnable, "runnable");
        o0oIxOo IIXOooo2 = Xo0.X0o0xo().IIXOooo();
        if (IIXOooo2.isDispatchNeeded(coroutineContext) || canRun()) {
            IIXOooo2.dispatch(coroutineContext, new oxoX(this, runnable));
        } else {
            enqueue(runnable);
        }
    }

    @MainThread
    public final void drainQueue() {
        if (!this.isDraining) {
            boolean z = true;
            z = false;
            try {
                while (true) {
                    if (this.queue.isEmpty()) {
                        break;
                    } else if (!canRun()) {
                        break;
                    } else {
                        Runnable poll = this.queue.poll();
                        if (poll != null) {
                            poll.run();
                        }
                    }
                }
                this.isDraining = z;
            } finally {
                this.isDraining = z;
            }
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
        if (this.paused) {
            if (!this.finished) {
                this.paused = false;
                drainQueue();
                return;
            }
            throw new IllegalStateException("Cannot resume a finished dispatcher");
        }
    }
}
