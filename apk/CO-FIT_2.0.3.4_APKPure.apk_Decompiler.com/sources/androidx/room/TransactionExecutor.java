package androidx.room;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nTransactionExecutor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransactionExecutor.kt\nandroidx/room/TransactionExecutor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,55:1\n1#2:56\n*E\n"})
public final class TransactionExecutor implements Executor {
    @oOoXoXO
    private Runnable active;
    @OOXIXo
    private final Executor executor;
    @OOXIXo
    private final Object syncLock = new Object();
    @OOXIXo
    private final ArrayDeque<Runnable> tasks = new ArrayDeque<>();

    public TransactionExecutor(@OOXIXo Executor executor2) {
        IIX0o.x0xO0oo(executor2, "executor");
        this.executor = executor2;
    }

    /* access modifiers changed from: private */
    public static final void execute$lambda$1$lambda$0(Runnable runnable, TransactionExecutor transactionExecutor) {
        IIX0o.x0xO0oo(runnable, "$command");
        IIX0o.x0xO0oo(transactionExecutor, "this$0");
        try {
            runnable.run();
        } finally {
            transactionExecutor.scheduleNext();
        }
    }

    public void execute(@OOXIXo Runnable runnable) {
        IIX0o.x0xO0oo(runnable, "command");
        synchronized (this.syncLock) {
            try {
                this.tasks.offer(new X0IIOO(runnable, this));
                if (this.active == null) {
                    scheduleNext();
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void scheduleNext() {
        synchronized (this.syncLock) {
            try {
                Runnable poll = this.tasks.poll();
                Runnable runnable = poll;
                this.active = runnable;
                if (poll != null) {
                    this.executor.execute(runnable);
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
