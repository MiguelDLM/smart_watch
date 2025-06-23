package IIXOooo;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import java.util.List;

/* loaded from: classes.dex */
public class xxIXOIIO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static PointF f320oIX0oI = new PointF();

    public static float I0Io(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static int II0XooXoX(int i, int i2) {
        return i - (i2 * XO(i, i2));
    }

    public static double II0xO0(double d, double d2, double d3) {
        return Math.max(d2, Math.min(d3, d));
    }

    public static float OOXIXo(float f, float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int Oxx0IOOO(float f, float f2) {
        return II0XooXoX((int) f, (int) f2);
    }

    public static boolean X0o0xo(float f, float f2, float f3) {
        if (f >= f2 && f <= f3) {
            return true;
        }
        return false;
    }

    public static int XO(int i, int i2) {
        boolean z;
        int i3 = i / i2;
        if ((i ^ i2) >= 0) {
            z = true;
        } else {
            z = false;
        }
        int i4 = i % i2;
        if (!z && i4 != 0) {
            return i3 - 1;
        }
        return i3;
    }

    public static PointF oIX0oI(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static int oOoXoXO(int i, int i2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static void ooOOo0oXI(x0xO0oo.oxoX oxox, int i, List<x0xO0oo.oxoX> list, x0xO0oo.oxoX oxox2, ooOOo0oXI.OOXIXo oOXIXo) {
        if (oxox.I0Io(oOXIXo.getName(), i)) {
            list.add(oxox2.oIX0oI(oOXIXo.getName()).xoIox(oOXIXo));
        }
    }

    public static int oxoX(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static double xoIox(double d, double d2, @FloatRange(from = 0.0d, to = 1.0d) double d3) {
        return d + (d3 * (d2 - d));
    }

    public static void xxIXOIIO(IXxxXO.Oxx0IOOO oxx0IOOO, Path path) {
        path.reset();
        PointF II0xO02 = oxx0IOOO.II0xO0();
        path.moveTo(II0xO02.x, II0xO02.y);
        f320oIX0oI.set(II0xO02.x, II0xO02.y);
        for (int i = 0; i < oxx0IOOO.oIX0oI().size(); i++) {
            x0xO0oo.oIX0oI oix0oi = oxx0IOOO.oIX0oI().get(i);
            PointF oIX0oI2 = oix0oi.oIX0oI();
            PointF II0xO03 = oix0oi.II0xO0();
            PointF I0Io2 = oix0oi.I0Io();
            if (oIX0oI2.equals(f320oIX0oI) && II0xO03.equals(I0Io2)) {
                path.lineTo(I0Io2.x, I0Io2.y);
            } else {
                path.cubicTo(oIX0oI2.x, oIX0oI2.y, II0xO03.x, II0xO03.y, I0Io2.x, I0Io2.y);
            }
            f320oIX0oI.set(I0Io2.x, I0Io2.y);
        }
        if (oxx0IOOO.oxoX()) {
            path.close();
        }
    }
}
