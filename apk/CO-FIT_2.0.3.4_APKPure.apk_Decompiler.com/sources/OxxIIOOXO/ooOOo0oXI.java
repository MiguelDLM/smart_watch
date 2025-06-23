package OxxIIOOXO;

import IXxxXO.oxoX;
import Oo.X0o0xo;
import Oo.XO;
import Oo.xxIXOIIO;
import android.graphics.Path;
import com.airbnb.lottie.Oxx0IOOO;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import java.io.IOException;
import java.util.Collections;
import xoXoI.oIX0oI;

public class ooOOo0oXI {

    /* renamed from: II0xO0  reason: collision with root package name */
    public static final JsonReader.oIX0oI f212II0xO0 = JsonReader.oIX0oI.oIX0oI("p", t.f3784a);

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static final JsonReader.oIX0oI f213oIX0oI = JsonReader.oIX0oI.oIX0oI("nm", "g", "o", "t", "s", e.TAG, "r", "hd");

    public static oxoX oIX0oI(JsonReader jsonReader, Oxx0IOOO oxx0IOOO) throws IOException {
        Oo.Oxx0IOOO oxx0IOOO2;
        GradientType gradientType;
        Path.FillType fillType;
        Oo.Oxx0IOOO oxx0IOOO3 = null;
        Path.FillType fillType2 = Path.FillType.WINDING;
        String str = null;
        GradientType gradientType2 = null;
        XO xo2 = null;
        xxIXOIIO xxixoiio = null;
        xxIXOIIO xxixoiio2 = null;
        boolean z = false;
        while (jsonReader.XO()) {
            switch (jsonReader.Oo(f213oIX0oI)) {
                case 0:
                    str = jsonReader.OOXIXo();
                    break;
                case 1:
                    jsonReader.I0Io();
                    int i = -1;
                    while (jsonReader.XO()) {
                        int Oo2 = jsonReader.Oo(f212II0xO0);
                        if (Oo2 == 0) {
                            i = jsonReader.xxIXOIIO();
                        } else if (Oo2 != 1) {
                            jsonReader.IXxxXO();
                            jsonReader.Oxx0xo();
                        } else {
                            xo2 = oxoX.Oxx0IOOO(jsonReader, oxx0IOOO, i);
                        }
                    }
                    jsonReader.X0o0xo();
                    break;
                case 2:
                    oxx0IOOO3 = oxoX.II0XooXoX(jsonReader, oxx0IOOO);
                    break;
                case 3:
                    if (jsonReader.xxIXOIIO() == 1) {
                        gradientType = GradientType.LINEAR;
                    } else {
                        gradientType = GradientType.RADIAL;
                    }
                    gradientType2 = gradientType;
                    break;
                case 4:
                    xxixoiio = oxoX.xxIXOIIO(jsonReader, oxx0IOOO);
                    break;
                case 5:
                    xxixoiio2 = oxoX.xxIXOIIO(jsonReader, oxx0IOOO);
                    break;
                case 6:
                    if (jsonReader.xxIXOIIO() == 1) {
                        fillType = Path.FillType.WINDING;
                    } else {
                        fillType = Path.FillType.EVEN_ODD;
                    }
                    fillType2 = fillType;
                    break;
                case 7:
                    z = jsonReader.Oxx0IOOO();
                    break;
                default:
                    jsonReader.IXxxXO();
                    jsonReader.Oxx0xo();
                    break;
            }
        }
        if (oxx0IOOO3 == null) {
            oxx0IOOO2 = new Oo.Oxx0IOOO(Collections.singletonList(new oIX0oI(100)));
        } else {
            oxx0IOOO2 = oxx0IOOO3;
        }
        return new oxoX(str, gradientType2, fillType2, xo2, oxx0IOOO2, xxixoiio, xxixoiio2, (X0o0xo) null, (X0o0xo) null, z);
    }
}
