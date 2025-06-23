package kotlinx.coroutines;

import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* loaded from: classes6.dex */
public final class Ioxxx {
    public static final void I0Io(@OXOo.OOXIXo Oox.oIX0oI<kotlin.oXIO0o0XI> oix0oi) {
        oix0oi.invoke();
    }

    @OX00O0xII
    @xo0x
    @kotlin.o0
    public static final boolean II0xO0(@OXOo.OOXIXo Thread thread) {
        if (!(thread instanceof CoroutineScheduler.I0Io)) {
            return false;
        }
        return ((CoroutineScheduler.I0Io) thread).x0xO0oo();
    }

    @OX00O0xII
    @xo0x
    @kotlin.o0
    public static final long X0o0xo() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof CoroutineScheduler.I0Io) {
            return ((CoroutineScheduler.I0Io) currentThread).oI0IIXIo();
        }
        throw new IllegalStateException("Expected CoroutineScheduler.Worker, but got " + currentThread);
    }

    @OXOo.OOXIXo
    public static final x0xO oIX0oI() {
        return new Oxx0IOOO(Thread.currentThread());
    }

    @OX00O0xII
    public static final long oxoX() {
        x0xO oIX0oI2 = IO0XoXxO.f29694oIX0oI.oIX0oI();
        if (oIX0oI2 != null) {
            return oIX0oI2.X00IoxXI();
        }
        return Long.MAX_VALUE;
    }
}
