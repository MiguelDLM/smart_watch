package oo0xXOI0I;

import OXOo.OOXIXo;
import com.batoulapps.adhan2.internal.ShadowLength;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class Oxx0IOOO {

    /* renamed from: I0Io, reason: collision with root package name */
    public final double f32275I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final double f32276II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final double f32277II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OOXIXo
    public final XO f32278Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OOXIXo
    public final XO f32279X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final XO f32280XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final double f32281oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OOXIXo
    public final ooXIXxIX.II0xO0 f32282oxoX;

    public Oxx0IOOO(@OOXIXo xI.I0Io date, @OOXIXo ooXIXxIX.II0xO0 coordinates) {
        IIX0o.x0xO0oo(date, "date");
        IIX0o.x0xO0oo(coordinates, "coordinates");
        double X0o0xo2 = II0xO0.X0o0xo(II0xO0.f32274oIX0oI, date.I0Io(), date.II0xO0(), date.oIX0oI(), XIXIX.OOXIXo.f3760XO, 8, null);
        double d = 1;
        XO xo2 = new XO(X0o0xo2 - d);
        this.f32280XO = xo2;
        XO xo3 = new XO(X0o0xo2);
        this.f32279X0o0xo = xo3;
        XO xo4 = new XO(X0o0xo2 + d);
        this.f32278Oxx0IOOO = xo4;
        oIX0oI oix0oi = oIX0oI.f32288oIX0oI;
        double oxoX2 = oix0oi.oxoX(coordinates.II0xO0(), xo3.oIX0oI(), xo3.I0Io());
        this.f32276II0XooXoX = oxoX2;
        this.f32282oxoX = coordinates;
        this.f32281oIX0oI = oix0oi.Oxx0IOOO(oxoX2, coordinates.II0xO0(), xo3.oIX0oI(), xo3.I0Io(), xo2.I0Io(), xo4.I0Io());
        this.f32277II0xO0 = oix0oi.XO(oxoX2, -0.8333333333333334d, coordinates, false, xo3.oIX0oI(), xo3.I0Io(), xo2.I0Io(), xo4.I0Io(), xo3.II0xO0(), xo2.II0xO0(), xo4.II0xO0());
        this.f32275I0Io = oix0oi.XO(oxoX2, -0.8333333333333334d, coordinates, true, xo3.oIX0oI(), xo3.I0Io(), xo2.I0Io(), xo4.I0Io(), xo3.II0xO0(), xo2.II0xO0(), xo4.II0xO0());
    }

    public final double I0Io() {
        return this.f32275I0Io;
    }

    public final double II0xO0() {
        return this.f32277II0xO0;
    }

    public final double X0o0xo(double d, boolean z) {
        return oIX0oI.f32288oIX0oI.XO(this.f32276II0XooXoX, d, this.f32282oxoX, z, this.f32279X0o0xo.oIX0oI(), this.f32279X0o0xo.I0Io(), this.f32280XO.I0Io(), this.f32278Oxx0IOOO.I0Io(), this.f32279X0o0xo.II0xO0(), this.f32280XO.II0xO0(), this.f32278Oxx0IOOO.II0xO0());
    }

    public final double oIX0oI(@OOXIXo ShadowLength shadowLength) {
        IIX0o.x0xO0oo(shadowLength, "shadowLength");
        return X0o0xo(I0Io.oIX0oI(Math.atan(1.0d / (shadowLength.getShadowLength() + Math.tan(I0Io.II0xO0(Math.abs(this.f32282oxoX.oIX0oI() - this.f32279X0o0xo.II0xO0())))))), true);
    }

    public final double oxoX() {
        return this.f32281oIX0oI;
    }
}
