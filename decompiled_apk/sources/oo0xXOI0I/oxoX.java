package oo0xXOI0I;

import OXOo.OOXIXo;

/* loaded from: classes8.dex */
public final class oxoX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final oxoX f32289oIX0oI = new oxoX();

    public final double I0Io(double d) {
        return II0xO0(d, 360.0d);
    }

    public final double II0xO0(double d, double d2) {
        return d - (d2 * Math.floor(d / d2));
    }

    public final double oIX0oI(double d) {
        if (d < -180.0d || d > 180.0d) {
            return d - (oOIx.oxoX.IIX0(d / 360) * 360);
        }
        return d;
    }
}
