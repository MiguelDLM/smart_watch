package kotlin.time;

import kotlin.oxxXoxO;
import kotlin.time.IXxxXO;

@oxxXoxO(version = "1.3")
/* loaded from: classes6.dex */
public final class x0XOIxOo implements IXxxXO.I0Io {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0XOIxOo f29652II0xO0 = new x0XOIxOo();

    /* renamed from: I0Io, reason: collision with root package name */
    public static final long f29651I0Io = System.nanoTime();

    private final long XO() {
        return System.nanoTime() - f29651I0Io;
    }

    public final long I0Io(long j, long j2) {
        return OOXIXo.II0XooXoX(j, j2, DurationUnit.NANOSECONDS);
    }

    public final long II0xO0(long j, long j2) {
        return IXxxXO.II0xO0.oIX0oI.OOXIXo(OOXIXo.oxoX(j, DurationUnit.NANOSECONDS, j2));
    }

    public long X0o0xo() {
        return IXxxXO.II0xO0.oIX0oI.OOXIXo(XO());
    }

    @Override // kotlin.time.IXxxXO.I0Io, kotlin.time.IXxxXO
    public /* bridge */ /* synthetic */ I0Io oIX0oI() {
        return IXxxXO.II0xO0.oIX0oI.Oxx0IOOO(X0o0xo());
    }

    public final long oxoX(long j) {
        return OOXIXo.XO(XO(), j, DurationUnit.NANOSECONDS);
    }

    @OXOo.OOXIXo
    public String toString() {
        return "TimeSource(System.nanoTime())";
    }

    @Override // kotlin.time.IXxxXO
    public /* bridge */ /* synthetic */ x0xO0oo oIX0oI() {
        return IXxxXO.II0xO0.oIX0oI.Oxx0IOOO(X0o0xo());
    }
}
