package OxxIIOOXO;

import Oo.II0XooXoX;
import Oo.X0o0xo;
import Oo.oO;
import Oo.oOoXoXO;
import Oo.x0xO0oo;
import Oo.xoIox;
import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.Oxx0IOOO;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import xoXoI.OOXIXo;
import xoXoI.oIX0oI;

public class I0Io {

    /* renamed from: II0xO0  reason: collision with root package name */
    public static final JsonReader.oIX0oI f174II0xO0 = JsonReader.oIX0oI.oIX0oI(t.f3784a);

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static final JsonReader.oIX0oI f175oIX0oI = JsonReader.oIX0oI.oIX0oI("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");

    public static boolean I0Io(X0o0xo x0o0xo) {
        if (x0o0xo == null || (x0o0xo.I0Io() && ((Float) ((oIX0oI) x0o0xo.II0xO0().get(0)).f1612II0xO0).floatValue() == 0.0f)) {
            return true;
        }
        return false;
    }

    public static boolean II0xO0(x0xO0oo<PointF, PointF> x0xo0oo) {
        if (x0xo0oo == null || (!(x0xo0oo instanceof oOoXoXO) && x0xo0oo.I0Io() && ((PointF) x0xo0oo.II0xO0().get(0).f1612II0xO0).equals(0.0f, 0.0f))) {
            return true;
        }
        return false;
    }

    public static oO Oxx0IOOO(JsonReader jsonReader, Oxx0IOOO oxx0IOOO) throws IOException {
        boolean z;
        II0XooXoX iI0XooXoX;
        x0xO0oo<PointF, PointF> x0xo0oo;
        X0o0xo x0o0xo;
        X0o0xo x0o0xo2;
        X0o0xo x0o0xo3;
        JsonReader jsonReader2 = jsonReader;
        Oxx0IOOO oxx0IOOO2 = oxx0IOOO;
        boolean z2 = false;
        if (jsonReader.x0XOIxOo() == JsonReader.Token.BEGIN_OBJECT) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            jsonReader.I0Io();
        }
        X0o0xo x0o0xo4 = null;
        II0XooXoX iI0XooXoX2 = null;
        x0xO0oo<PointF, PointF> x0xo0oo2 = null;
        xoIox xoiox = null;
        X0o0xo x0o0xo5 = null;
        X0o0xo x0o0xo6 = null;
        Oo.Oxx0IOOO oxx0IOOO3 = null;
        X0o0xo x0o0xo7 = null;
        X0o0xo x0o0xo8 = null;
        while (jsonReader.XO()) {
            switch (jsonReader2.Oo(f175oIX0oI)) {
                case 0:
                    jsonReader.I0Io();
                    while (jsonReader.XO()) {
                        if (jsonReader2.Oo(f174II0xO0) != 0) {
                            jsonReader.IXxxXO();
                            jsonReader.Oxx0xo();
                        } else {
                            iI0XooXoX2 = oIX0oI.oIX0oI(jsonReader, oxx0IOOO);
                        }
                    }
                    jsonReader.X0o0xo();
                    break;
                case 1:
                    x0xo0oo2 = oIX0oI.II0xO0(jsonReader, oxx0IOOO);
                    break;
                case 2:
                    xoiox = oxoX.xoIox(jsonReader, oxx0IOOO);
                    break;
                case 3:
                    oxx0IOOO2.oIX0oI("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    oxx0IOOO3 = oxoX.II0XooXoX(jsonReader, oxx0IOOO);
                    continue;
                case 6:
                    x0o0xo7 = oxoX.XO(jsonReader2, oxx0IOOO2, z2);
                    continue;
                case 7:
                    x0o0xo8 = oxoX.XO(jsonReader2, oxx0IOOO2, z2);
                    continue;
                case 8:
                    x0o0xo5 = oxoX.XO(jsonReader2, oxx0IOOO2, z2);
                    continue;
                case 9:
                    x0o0xo6 = oxoX.XO(jsonReader2, oxx0IOOO2, z2);
                    continue;
                default:
                    jsonReader.IXxxXO();
                    jsonReader.Oxx0xo();
                    continue;
            }
            X0o0xo XO2 = oxoX.XO(jsonReader2, oxx0IOOO2, z2);
            if (XO2.II0xO0().isEmpty()) {
                oIX0oI oix0oi = r1;
                oIX0oI oix0oi2 = new oIX0oI(oxx0IOOO, Float.valueOf(0.0f), Float.valueOf(0.0f), (Interpolator) null, 0.0f, Float.valueOf(oxx0IOOO.XO()));
                XO2.II0xO0().add(oix0oi);
            } else if (((oIX0oI) XO2.II0xO0().get(0)).f1612II0xO0 == null) {
                XO2.II0xO0().set(0, new oIX0oI(oxx0IOOO, Float.valueOf(0.0f), Float.valueOf(0.0f), (Interpolator) null, 0.0f, Float.valueOf(oxx0IOOO.XO())));
                x0o0xo4 = XO2;
                z2 = false;
            }
            x0o0xo4 = XO2;
            z2 = false;
        }
        if (z) {
            jsonReader.X0o0xo();
        }
        if (oIX0oI(iI0XooXoX2)) {
            iI0XooXoX = null;
        } else {
            iI0XooXoX = iI0XooXoX2;
        }
        if (II0xO0(x0xo0oo2)) {
            x0xo0oo = null;
        } else {
            x0xo0oo = x0xo0oo2;
        }
        if (I0Io(x0o0xo4)) {
            x0o0xo = null;
        } else {
            x0o0xo = x0o0xo4;
        }
        if (oxoX(xoiox)) {
            xoiox = null;
        }
        if (XO(x0o0xo5)) {
            x0o0xo2 = null;
        } else {
            x0o0xo2 = x0o0xo5;
        }
        if (X0o0xo(x0o0xo6)) {
            x0o0xo3 = null;
        } else {
            x0o0xo3 = x0o0xo6;
        }
        return new oO(iI0XooXoX, x0xo0oo, xoiox, x0o0xo, oxx0IOOO3, x0o0xo7, x0o0xo8, x0o0xo2, x0o0xo3);
    }

    public static boolean X0o0xo(X0o0xo x0o0xo) {
        if (x0o0xo == null || (x0o0xo.I0Io() && ((Float) ((oIX0oI) x0o0xo.II0xO0().get(0)).f1612II0xO0).floatValue() == 0.0f)) {
            return true;
        }
        return false;
    }

    public static boolean XO(X0o0xo x0o0xo) {
        if (x0o0xo == null || (x0o0xo.I0Io() && ((Float) ((oIX0oI) x0o0xo.II0xO0().get(0)).f1612II0xO0).floatValue() == 0.0f)) {
            return true;
        }
        return false;
    }

    public static boolean oIX0oI(II0XooXoX iI0XooXoX) {
        if (iI0XooXoX == null || (iI0XooXoX.I0Io() && ((PointF) iI0XooXoX.II0xO0().get(0).f1612II0xO0).equals(0.0f, 0.0f))) {
            return true;
        }
        return false;
    }

    public static boolean oxoX(xoIox xoiox) {
        if (xoiox == null || (xoiox.I0Io() && ((OOXIXo) ((oIX0oI) xoiox.II0xO0().get(0)).f1612II0xO0).oIX0oI(1.0f, 1.0f))) {
            return true;
        }
        return false;
    }
}
