package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;

/* loaded from: classes6.dex */
public final class I0Io {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static II0xO0 f29683oIX0oI;

    @xx0o0O.XO
    public static final long I0Io() {
        II0xO0 II0xO02 = II0xO0();
        if (II0xO02 != null) {
            return II0xO02.II0xO0();
        }
        return System.nanoTime();
    }

    @xx0o0O.XO
    public static final void II0XooXoX() {
        II0xO0 II0xO02 = II0xO0();
        if (II0xO02 != null) {
            II0xO02.XO();
        }
    }

    @OXOo.oOoXoXO
    public static final II0xO0 II0xO0() {
        return f29683oIX0oI;
    }

    @xx0o0O.XO
    public static final Runnable OOXIXo(Runnable runnable) {
        Runnable xxIXOIIO2;
        II0xO0 II0xO02 = II0xO0();
        if (II0xO02 != null && (xxIXOIIO2 = II0xO02.xxIXOIIO(runnable)) != null) {
            return xxIXOIIO2;
        }
        return runnable;
    }

    @xx0o0O.XO
    public static final void Oxx0IOOO() {
        II0xO0 II0xO02 = II0xO0();
        if (II0xO02 != null) {
            II0xO02.X0o0xo();
        }
    }

    @xx0o0O.XO
    public static final void X0o0xo() {
        II0xO0 II0xO02 = II0xO0();
        if (II0xO02 != null) {
            II0xO02.oxoX();
        }
    }

    public static final void XO(@OXOo.oOoXoXO II0xO0 iI0xO0) {
        f29683oIX0oI = iI0xO0;
    }

    @xx0o0O.XO
    public static final long oIX0oI() {
        II0xO0 II0xO02 = II0xO0();
        if (II0xO02 != null) {
            return II0xO02.oIX0oI();
        }
        return System.currentTimeMillis();
    }

    @xx0o0O.XO
    public static final void oxoX(Object obj, long j) {
        kotlin.oXIO0o0XI oxio0o0xi;
        II0xO0 II0xO02 = II0xO0();
        if (II0xO02 != null) {
            II0xO02.I0Io(obj, j);
            oxio0o0xi = kotlin.oXIO0o0XI.f29392oIX0oI;
        } else {
            oxio0o0xi = null;
        }
        if (oxio0o0xi == null) {
            LockSupport.parkNanos(obj, j);
        }
    }

    @xx0o0O.XO
    public static final void xoIox() {
        II0xO0 II0xO02 = II0xO0();
        if (II0xO02 != null) {
            II0xO02.II0XooXoX();
        }
    }

    @xx0o0O.XO
    public static final void xxIXOIIO(Thread thread) {
        kotlin.oXIO0o0XI oxio0o0xi;
        II0xO0 II0xO02 = II0xO0();
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
