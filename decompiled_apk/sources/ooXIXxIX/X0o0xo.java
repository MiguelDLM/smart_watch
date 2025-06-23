package ooXIXxIX;

import IOI.IIX0o;
import IOI.oOoXoXO;
import IOI.xOOOX;
import OXOo.OOXIXo;

/* loaded from: classes8.dex */
public final class X0o0xo {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public final IIX0o f32456II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final IIX0o f32457oIX0oI;

    public X0o0xo(@OOXIXo com.batoulapps.adhan2.II0xO0 prayerTimes) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(prayerTimes, "prayerTimes");
        xI.II0xO0 iI0xO0 = xI.II0xO0.f34114oIX0oI;
        xOOOX X0o0xo2 = iI0xO0.X0o0xo(prayerTimes.oOoXoXO());
        oOoXoXO.oIX0oI oix0oi = oOoXoXO.Companion;
        double x0xO0oo2 = (com.batoulapps.adhan2.II0xO0.Oxx0IOOO(prayerTimes, null, xI.I0Io.f34110oxoX.II0xO0(iI0xO0.II0xO0(X0o0xo2, 1, oix0oi.II0xO0())), null, 5, null).x0XOIxOo().x0xO0oo() - prayerTimes.x0xO0oo().x0xO0oo()) / 1000;
        this.f32457oIX0oI = iI0xO0.II0XooXoX(xI.II0xO0.Oxx0IOOO(iI0xO0, iI0xO0.oIX0oI(prayerTimes.x0xO0oo(), (int) (x0xO0oo2 / 2.0d), oix0oi.xoIox()), null, 2, null));
        this.f32456II0xO0 = iI0xO0.II0XooXoX(xI.II0xO0.Oxx0IOOO(iI0xO0, iI0xO0.oIX0oI(prayerTimes.x0xO0oo(), (int) (x0xO0oo2 * 0.6666666666666666d), oix0oi.xoIox()), null, 2, null));
    }

    @OOXIXo
    public final IIX0o II0xO0() {
        return this.f32457oIX0oI;
    }

    @OOXIXo
    public final IIX0o oIX0oI() {
        return this.f32456II0xO0;
    }
}
