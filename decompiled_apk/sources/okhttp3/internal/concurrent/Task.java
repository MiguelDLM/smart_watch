package okhttp3.internal.concurrent;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Task.kt\nokhttp3/internal/concurrent/Task\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,71:1\n1#2:72\n*E\n"})
/* loaded from: classes6.dex */
public abstract class Task {
    private final boolean cancelable;

    @OOXIXo
    private final String name;
    private long nextExecuteNanoTime;

    @oOoXoXO
    private TaskQueue queue;

    public Task(@OOXIXo String name, boolean z) {
        IIX0o.x0xO0oo(name, "name");
        this.name = name;
        this.cancelable = z;
        this.nextExecuteNanoTime = -1L;
    }

    public final boolean getCancelable() {
        return this.cancelable;
    }

    @OOXIXo
    public final String getName() {
        return this.name;
    }

    public final long getNextExecuteNanoTime$okhttp() {
        return this.nextExecuteNanoTime;
    }

    @oOoXoXO
    public final TaskQueue getQueue$okhttp() {
        return this.queue;
    }

    public final void initQueue$okhttp(@OOXIXo TaskQueue queue) {
        IIX0o.x0xO0oo(queue, "queue");
        TaskQueue taskQueue = this.queue;
        if (taskQueue == queue) {
            return;
        }
        if (taskQueue == null) {
            this.queue = queue;
            return;
        }
        throw new IllegalStateException("task is in multiple queues");
    }

    public abstract long runOnce();

    public final void setNextExecuteNanoTime$okhttp(long j) {
        this.nextExecuteNanoTime = j;
    }

    public final void setQueue$okhttp(@oOoXoXO TaskQueue taskQueue) {
        this.queue = taskQueue;
    }

    @OOXIXo
    public String toString() {
        return this.name;
    }

    public /* synthetic */ Task(String str, boolean z, int i, IIXOooo iIXOooo) {
        this(str, (i & 2) != 0 ? true : z);
    }
}
