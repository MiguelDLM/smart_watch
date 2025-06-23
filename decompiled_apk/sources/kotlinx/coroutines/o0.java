package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.OO0x0xX;

@kotlin.jvm.internal.XX({"SMAP\nDefaultExecutor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultExecutor.kt\nkotlinx/coroutines/DefaultExecutor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,187:1\n1#2:188\n*E\n"})
/* loaded from: classes6.dex */
public final class o0 extends OO0x0xX implements Runnable {

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final o0 f30326IIXOooo;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f30327O0xOxO = 0;

    /* renamed from: OxI, reason: collision with root package name */
    public static final long f30328OxI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final int f30329X0IIOO = 1;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final int f30330XI0IXoo = 2;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final int f30331XIxXXX0x0 = 3;

    @OXOo.oOoXoXO
    private static volatile Thread _thread = null;
    private static volatile int debugStatus = 0;

    /* renamed from: o00, reason: collision with root package name */
    public static final long f30332o00 = 1000;

    /* renamed from: xoXoI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f30333xoXoI = "kotlinx.coroutines.DefaultExecutor";

    /* renamed from: xxX, reason: collision with root package name */
    public static final int f30334xxX = 4;

    static {
        Long l;
        o0 o0Var = new o0();
        f30326IIXOooo = o0Var;
        x0xO.XxX0x0xxx(o0Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        f30328OxI = timeUnit.toNanos(l.longValue());
    }

    public static /* synthetic */ void OO() {
    }

    public final synchronized Thread I0oOIX() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, f30333xoXoI);
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    public final boolean IoOoo() {
        if (debugStatus == 4) {
            return true;
        }
        return false;
    }

    public final synchronized void Ioxxx(long j) {
        kotlin.oXIO0o0XI oxio0o0xi;
        try {
            long currentTimeMillis = System.currentTimeMillis() + j;
            if (!xoIxX()) {
                debugStatus = 2;
            }
            while (debugStatus != 3 && _thread != null) {
                Thread thread = _thread;
                if (thread != null) {
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
                if (currentTimeMillis - System.currentTimeMillis() <= 0) {
                    break;
                }
                kotlin.jvm.internal.IIX0o.x0XOIxOo(this, "null cannot be cast to non-null type java.lang.Object");
                wait(j);
            }
            debugStatus = 0;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void O0Xx() {
        if (!xoIxX()) {
            return;
        }
        debugStatus = 3;
        xXOx();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
    }

    public final synchronized boolean OO0x0xX() {
        if (xoIxX()) {
            return false;
        }
        debugStatus = 1;
        kotlin.jvm.internal.IIX0o.x0XOIxOo(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    @Override // kotlinx.coroutines.OO0x0xX, kotlinx.coroutines.XoX
    @OXOo.OOXIXo
    public I0oOIX Oxx0xo(long j, @OXOo.OOXIXo Runnable runnable, @OXOo.OOXIXo CoroutineContext coroutineContext) {
        return oX(j, runnable);
    }

    public final void XIo0oOXIx() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // kotlinx.coroutines.XIo0oOXIx
    public void XOxIOxOx(long j, @OXOo.OOXIXo OO0x0xX.I0Io i0Io) {
        XIo0oOXIx();
    }

    @Override // kotlinx.coroutines.OO0x0xX
    public void oxxXoxO(@OXOo.OOXIXo Runnable runnable) {
        if (IoOoo()) {
            XIo0oOXIx();
        }
        super.oxxXoxO(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        kotlin.oXIO0o0XI oxio0o0xi;
        long nanoTime;
        IO0XoXxO.f29694oIX0oI.oxoX(this);
        II0xO0 II0xO02 = I0Io.II0xO0();
        if (II0xO02 != null) {
            II0xO02.oxoX();
        }
        try {
            if (!OO0x0xX()) {
                _thread = null;
                O0Xx();
                II0xO0 II0xO03 = I0Io.II0xO0();
                if (II0xO03 != null) {
                    II0xO03.II0XooXoX();
                }
                if (!ooXIXxIX()) {
                    x0o();
                    return;
                }
                return;
            }
            long j = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long X00IoxXI2 = X00IoxXI();
                if (X00IoxXI2 == Long.MAX_VALUE) {
                    II0xO0 II0xO04 = I0Io.II0xO0();
                    if (II0xO04 != null) {
                        nanoTime = II0xO04.II0xO0();
                    } else {
                        nanoTime = System.nanoTime();
                    }
                    if (j == Long.MAX_VALUE) {
                        j = f30328OxI + nanoTime;
                    }
                    long j2 = j - nanoTime;
                    if (j2 <= 0) {
                        _thread = null;
                        O0Xx();
                        II0xO0 II0xO05 = I0Io.II0xO0();
                        if (II0xO05 != null) {
                            II0xO05.II0XooXoX();
                        }
                        if (!ooXIXxIX()) {
                            x0o();
                            return;
                        }
                        return;
                    }
                    X00IoxXI2 = X0.IIXOooo.XIxXXX0x0(X00IoxXI2, j2);
                } else {
                    j = Long.MAX_VALUE;
                }
                if (X00IoxXI2 > 0) {
                    if (xoIxX()) {
                        _thread = null;
                        O0Xx();
                        II0xO0 II0xO06 = I0Io.II0xO0();
                        if (II0xO06 != null) {
                            II0xO06.II0XooXoX();
                        }
                        if (!ooXIXxIX()) {
                            x0o();
                            return;
                        }
                        return;
                    }
                    II0xO0 II0xO07 = I0Io.II0xO0();
                    if (II0xO07 != null) {
                        II0xO07.I0Io(this, X00IoxXI2);
                        oxio0o0xi = kotlin.oXIO0o0XI.f29392oIX0oI;
                    } else {
                        oxio0o0xi = null;
                    }
                    if (oxio0o0xi == null) {
                        LockSupport.parkNanos(this, X00IoxXI2);
                    }
                }
            }
        } catch (Throwable th) {
            _thread = null;
            O0Xx();
            II0xO0 II0xO08 = I0Io.II0xO0();
            if (II0xO08 != null) {
                II0xO08.II0XooXoX();
            }
            if (!ooXIXxIX()) {
                x0o();
            }
            throw th;
        }
    }

    @Override // kotlinx.coroutines.OO0x0xX, kotlinx.coroutines.x0xO
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // kotlinx.coroutines.XIo0oOXIx
    @OXOo.OOXIXo
    public Thread x0o() {
        Thread thread = _thread;
        if (thread == null) {
            return I0oOIX();
        }
        return thread;
    }

    public final boolean x0xO() {
        if (_thread != null) {
            return true;
        }
        return false;
    }

    public final boolean xoIxX() {
        int i = debugStatus;
        if (i != 2 && i != 3) {
            return false;
        }
        return true;
    }

    public final synchronized void xoxXI() {
        debugStatus = 0;
        I0oOIX();
        while (debugStatus == 0) {
            kotlin.jvm.internal.IIX0o.x0XOIxOo(this, "null cannot be cast to non-null type java.lang.Object");
            wait();
        }
    }
}
