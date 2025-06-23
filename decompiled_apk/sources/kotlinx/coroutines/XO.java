package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;

@kotlin.jvm.internal.XX({"SMAP\nBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/BlockingCoroutine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,102:1\n1#2:103\n*E\n"})
/* loaded from: classes6.dex */
public final class XO<T> extends oIX0oI<T> {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Thread f29765Oxx0xo;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final x0xO f29766oI0IIXIo;

    public XO(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Thread thread, @OXOo.oOoXoXO x0xO x0xo) {
        super(coroutineContext, true, true);
        this.f29765Oxx0xo = thread;
        this.f29766oI0IIXIo = x0xo;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void I0X0x0oIo(@OXOo.oOoXoXO Object obj) {
        kotlin.oXIO0o0XI oxio0o0xi;
        if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(Thread.currentThread(), this.f29765Oxx0xo)) {
            Thread thread = this.f29765Oxx0xo;
            II0xO0 II0xO02 = I0Io.II0xO0();
            if (II0xO02 != null) {
                II0xO02.Oxx0IOOO(thread);
                oxio0o0xi = kotlin.oXIO0o0XI.f29392oIX0oI;
            } else {
                oxio0o0xi = null;
            }
            if (oxio0o0xi == null) {
                LockSupport.unpark(thread);
            }
        }
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean O0() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T OooI() {
        long j;
        kotlin.oXIO0o0XI oxio0o0xi;
        II0xO0 II0xO02 = I0Io.II0xO0();
        if (II0xO02 != null) {
            II0xO02.oxoX();
        }
        try {
            x0xO x0xo = this.f29766oI0IIXIo;
            xxX xxx2 = null;
            if (x0xo != null) {
                x0xO.XxX0x0xxx(x0xo, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    x0xO x0xo2 = this.f29766oI0IIXIo;
                    if (x0xo2 != null) {
                        j = x0xo2.X00IoxXI();
                    } else {
                        j = Long.MAX_VALUE;
                    }
                    if (!isCompleted()) {
                        II0xO0 II0xO03 = I0Io.II0xO0();
                        if (II0xO03 != null) {
                            II0xO03.I0Io(this, j);
                            oxio0o0xi = kotlin.oXIO0o0XI.f29392oIX0oI;
                        } else {
                            oxio0o0xi = null;
                        }
                        if (oxio0o0xi == null) {
                            LockSupport.parkNanos(this, j);
                        }
                    } else {
                        x0xO x0xo3 = this.f29766oI0IIXIo;
                        if (x0xo3 != null) {
                            x0xO.xoXoI(x0xo3, false, 1, null);
                        }
                        T t = (T) xI0oxI00.II0XooXoX(oXIO0o0XI());
                        if (t instanceof xxX) {
                            xxx2 = (xxX) t;
                        }
                        if (xxx2 == null) {
                            return t;
                        }
                        throw xxx2.f30502oIX0oI;
                    }
                } catch (Throwable th) {
                    x0xO x0xo4 = this.f29766oI0IIXIo;
                    if (x0xo4 != null) {
                        x0xO.xoXoI(x0xo4, false, 1, null);
                    }
                    throw th;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            XoI0Ixx0(interruptedException);
            throw interruptedException;
        } finally {
            II0xO0 II0xO04 = I0Io.II0xO0();
            if (II0xO04 != null) {
                II0xO04.II0XooXoX();
            }
        }
    }
}
