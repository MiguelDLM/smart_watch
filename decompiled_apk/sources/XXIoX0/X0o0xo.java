package XXIoX0;

import XO0OX.o00;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* loaded from: classes6.dex */
public final class X0o0xo extends ExecutorCoroutineDispatcher implements xoIox, Executor {

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicIntegerFieldUpdater f4046IIXOooo = AtomicIntegerFieldUpdater.newUpdater(X0o0xo.class, "inFlightTasks");

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final int f4047IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final I0Io f4048Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final String f4049Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ConcurrentLinkedQueue<Runnable> f4050OxxIIOOXO = new ConcurrentLinkedQueue<>();

    @o00
    private volatile int inFlightTasks;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public final int f4051oI0IIXIo;

    public X0o0xo(@OXOo.OOXIXo I0Io i0Io, int i, @OXOo.oOoXoXO String str, int i2) {
        this.f4048Oo = i0Io;
        this.f4047IXxxXO = i;
        this.f4049Oxx0xo = str;
        this.f4051oI0IIXIo = i2;
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Runnable runnable) {
        xoXoI(runnable, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Runnable runnable) {
        xoXoI(runnable, true);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@OXOo.OOXIXo Runnable runnable) {
        xoXoI(runnable, false);
    }

    @Override // XXIoX0.xoIox
    public int oI0IIXIo() {
        return this.f4051oI0IIXIo;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @OXOo.OOXIXo
    public String toString() {
        String str = this.f4049Oxx0xo;
        if (str == null) {
            return super.toString() + "[dispatcher = " + this.f4048Oo + ']';
        }
        return str;
    }

    public final void xoXoI(Runnable runnable, boolean z) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f4046IIXOooo;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.f4047IXxxXO) {
                this.f4048Oo.XIxXXX0x0(runnable, this, z);
                return;
            }
            this.f4050OxxIIOOXO.add(runnable);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) >= this.f4047IXxxXO) {
                return;
            } else {
                runnable = this.f4050OxxIIOOXO.poll();
            }
        } while (runnable != null);
    }

    @Override // XXIoX0.xoIox
    public void xxIXOIIO() {
        Runnable poll = this.f4050OxxIIOOXO.poll();
        if (poll != null) {
            this.f4048Oo.XIxXXX0x0(poll, this, true);
            return;
        }
        f4046IIXOooo.decrementAndGet(this);
        Runnable poll2 = this.f4050OxxIIOOXO.poll();
        if (poll2 == null) {
            return;
        }
        xoXoI(poll2, true);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @OXOo.OOXIXo
    public Executor IIXOooo() {
        return this;
    }
}
