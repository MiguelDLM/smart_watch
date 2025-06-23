package oo0xXOI0I;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class X0o0xo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final X0o0xo f32284oIX0oI = new X0o0xo();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public static final ooXIXxIX.II0xO0 f32283II0xO0 = new ooXIXxIX.II0xO0(21.4225241d, 39.8261818d);

    public final double oIX0oI(@OOXIXo ooXIXxIX.II0xO0 coordinates) {
        IIX0o.x0xO0oo(coordinates, "coordinates");
        ooXIXxIX.II0xO0 iI0xO0 = f32283II0xO0;
        double II0xO02 = I0Io.II0xO0(iI0xO0.II0xO0()) - I0Io.II0xO0(coordinates.II0xO0());
        double II0xO03 = I0Io.II0xO0(coordinates.oIX0oI());
        return oxoX.f32289oIX0oI.I0Io(I0Io.oIX0oI(Math.atan2(Math.sin(II0xO02), (Math.cos(II0xO03) * Math.tan(I0Io.II0xO0(iI0xO0.oIX0oI()))) - (Math.sin(II0xO03) * Math.cos(II0xO02)))));
    }
}
