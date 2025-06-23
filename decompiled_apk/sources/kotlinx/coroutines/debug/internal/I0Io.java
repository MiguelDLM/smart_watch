package kotlinx.coroutines.debug.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.o0;

@o0
/* loaded from: classes6.dex */
public final class I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public final long f29933I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OOXIXo
    public final List<StackTraceElement> f29934II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    @oOoXoXO
    public final IXIxx0.I0Io f29935II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @oOoXoXO
    public final IXIxx0.I0Io f29936Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OOXIXo
    public final String f29937X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @oOoXoXO
    public final Thread f29938XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final CoroutineContext f29939oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OOXIXo
    public final List<StackTraceElement> f29940oxoX;

    public I0Io(@OOXIXo DebugCoroutineInfoImpl debugCoroutineInfoImpl, @OOXIXo CoroutineContext coroutineContext) {
        this.f29939oIX0oI = coroutineContext;
        this.f29935II0xO0 = debugCoroutineInfoImpl.oxoX();
        this.f29933I0Io = debugCoroutineInfoImpl.f29914II0xO0;
        this.f29940oxoX = debugCoroutineInfoImpl.X0o0xo();
        this.f29937X0o0xo = debugCoroutineInfoImpl.Oxx0IOOO();
        this.f29938XO = debugCoroutineInfoImpl.lastObservedThread;
        this.f29936Oxx0IOOO = debugCoroutineInfoImpl.XO();
        this.f29934II0XooXoX = debugCoroutineInfoImpl.II0XooXoX();
    }

    @OOXIXo
    public final List<StackTraceElement> I0Io() {
        return this.f29940oxoX;
    }

    @OOXIXo
    @XO0OX.xxIXOIIO(name = "lastObservedStackTrace")
    public final List<StackTraceElement> II0XooXoX() {
        return this.f29934II0XooXoX;
    }

    @oOoXoXO
    public final IXIxx0.I0Io II0xO0() {
        return this.f29935II0xO0;
    }

    @OOXIXo
    public final String Oxx0IOOO() {
        return this.f29937X0o0xo;
    }

    @oOoXoXO
    public final Thread X0o0xo() {
        return this.f29938XO;
    }

    public final long XO() {
        return this.f29933I0Io;
    }

    @OOXIXo
    public final CoroutineContext oIX0oI() {
        return this.f29939oIX0oI;
    }

    @oOoXoXO
    public final IXIxx0.I0Io oxoX() {
        return this.f29936Oxx0IOOO;
    }
}
