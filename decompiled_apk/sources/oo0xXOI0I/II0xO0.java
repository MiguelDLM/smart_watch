package oo0xXOI0I;

import IOI.IIX0o;
import IOI.IO0XoXxO;
import IOI.X0xxXX0;
import IOI.xOOOX;
import OXOo.OOXIXo;

/* loaded from: classes8.dex */
public final class II0xO0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final II0xO0 f32274oIX0oI = new II0xO0();

    public static /* synthetic */ double X0o0xo(II0xO0 iI0xO0, int i, int i2, int i3, double d, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            d = XIXIX.OOXIXo.f3760XO;
        }
        return iI0xO0.II0xO0(i, i2, i3, d);
    }

    public final double I0Io(@OOXIXo IIX0o instant) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(instant, "instant");
        return oxoX(IO0XoXxO.XO(instant, X0xxXX0.Companion.I0Io()));
    }

    public final double II0xO0(int i, int i2, int i3, double d) {
        if (i2 <= 2) {
            i--;
        }
        if (i2 <= 2) {
            i2 += 12;
        }
        double d2 = i3 + (d / 24);
        int i4 = i / 100;
        return (((((int) ((i + 4716) * 365.25d)) + ((int) ((i2 + 1) * 30.6001d))) + d2) + ((2 - i4) + (i4 / 4))) - 1524.5d;
    }

    public final double oIX0oI(double d) {
        return (d - 2451545.0d) / 36525;
    }

    public final double oxoX(@OOXIXo xOOOX date) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(date, "date");
        return II0xO0(date.oI0IIXIo(), date.oO(), date.II0XooXoX(), (date.ooOOo0oXI() / 60.0d) + date.oOoXoXO());
    }
}
