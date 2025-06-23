package XXIoX0;

import X0.IIXOooo;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.I0oOoX;
import kotlinx.coroutines.internal.o0;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* loaded from: classes6.dex */
public final class ooOOo0oXI {

    /* renamed from: I0Io, reason: collision with root package name */
    @XO0OX.XO
    public static final int f4061I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f4062II0XooXoX = 1;

    /* renamed from: II0xO0, reason: collision with root package name */
    @XO0OX.XO
    public static final long f4063II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f4064Oxx0IOOO = 0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @XO0OX.XO
    public static final long f4065X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public static II0XooXoX f4066XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public static final String f4067oIX0oI = o0.X0o0xo("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");

    /* renamed from: oxoX, reason: collision with root package name */
    @XO0OX.XO
    public static final int f4068oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public static final xoIox f4069xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public static final xoIox f4070xxIXOIIO;

    static {
        long XO2;
        int X0o0xo2;
        int X0o0xo3;
        long XO3;
        XO2 = I0oOoX.XO("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        f4063II0xO0 = XO2;
        X0o0xo2 = I0oOoX.X0o0xo("kotlinx.coroutines.scheduler.core.pool.size", IIXOooo.OxxIIOOXO(o0.oIX0oI(), 2), 1, 0, 8, null);
        f4061I0Io = X0o0xo2;
        X0o0xo3 = I0oOoX.X0o0xo("kotlinx.coroutines.scheduler.max.pool.size", CoroutineScheduler.f30363oo, 0, CoroutineScheduler.f30363oo, 4, null);
        f4068oxoX = X0o0xo3;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        XO3 = I0oOoX.XO("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        f4065X0o0xo = timeUnit.toNanos(XO3);
        f4066XO = XO.f4052oIX0oI;
        f4070xxIXOIIO = new OOXIXo(0);
        f4069xoIox = new OOXIXo(1);
    }

    public static final boolean oIX0oI(@OXOo.OOXIXo xxIXOIIO xxixoiio) {
        if (xxixoiio.f4080Oo.oI0IIXIo() == 1) {
            return true;
        }
        return false;
    }
}
