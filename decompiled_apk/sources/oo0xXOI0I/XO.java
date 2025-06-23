package oo0xXOI0I;

/* loaded from: classes8.dex */
public final class XO {

    /* renamed from: I0Io, reason: collision with root package name */
    public final double f32285I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final double f32286II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final double f32287oIX0oI;

    public XO(double d) {
        double oIX0oI2 = II0xO0.f32274oIX0oI.oIX0oI(d);
        oIX0oI oix0oi = oIX0oI.f32288oIX0oI;
        double x0XOIxOo2 = oix0oi.x0XOIxOo(oIX0oI2);
        double xoIox2 = oix0oi.xoIox(oIX0oI2);
        double X0o0xo2 = oix0oi.X0o0xo(oIX0oI2);
        double II0xO02 = I0Io.II0xO0(oix0oi.I0Io(oIX0oI2, x0XOIxOo2));
        double oOoXoXO2 = oix0oi.oOoXoXO(oIX0oI2);
        double oO2 = oix0oi.oO(oIX0oI2, x0XOIxOo2, xoIox2, X0o0xo2);
        double x0xO0oo2 = oix0oi.x0xO0oo(oIX0oI2, x0XOIxOo2, xoIox2, X0o0xo2);
        double OOXIXo2 = oix0oi.OOXIXo(oIX0oI2);
        double II0xO03 = I0Io.II0xO0(oix0oi.II0xO0(oIX0oI2, OOXIXo2));
        this.f32287oIX0oI = I0Io.oIX0oI(Math.asin(Math.sin(II0xO03) * Math.sin(II0xO02)));
        this.f32286II0xO0 = oxoX.f32289oIX0oI.I0Io(I0Io.oIX0oI(Math.atan2(Math.cos(II0xO03) * Math.sin(II0xO02), Math.cos(II0xO02))));
        double d2 = 3600;
        this.f32285I0Io = oOoXoXO2 + (((oO2 * d2) * Math.cos(I0Io.II0xO0(OOXIXo2 + x0xO0oo2))) / d2);
    }

    public final double I0Io() {
        return this.f32286II0xO0;
    }

    public final double II0xO0() {
        return this.f32287oIX0oI;
    }

    public final double oIX0oI() {
        return this.f32285I0Io;
    }
}
