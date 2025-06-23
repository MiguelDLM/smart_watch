package OxxIIOOXO;

import IIXOooo.xoIox;
import Oo.II0XooXoX;
import Oo.X0o0xo;
import Oo.oOoXoXO;
import Oo.x0xO0oo;
import android.graphics.PointF;
import com.airbnb.lottie.Oxx0IOOO;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.util.ArrayList;

public class oIX0oI {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static final JsonReader.oIX0oI f207oIX0oI = JsonReader.oIX0oI.oIX0oI(t.f3784a, "x", "y");

    public static x0xO0oo<PointF, PointF> II0xO0(JsonReader jsonReader, Oxx0IOOO oxx0IOOO) throws IOException {
        jsonReader.I0Io();
        II0XooXoX iI0XooXoX = null;
        X0o0xo x0o0xo = null;
        X0o0xo x0o0xo2 = null;
        boolean z = false;
        while (jsonReader.x0XOIxOo() != JsonReader.Token.END_OBJECT) {
            int Oo2 = jsonReader.Oo(f207oIX0oI);
            if (Oo2 != 0) {
                if (Oo2 != 1) {
                    if (Oo2 != 2) {
                        jsonReader.IXxxXO();
                        jsonReader.Oxx0xo();
                    } else if (jsonReader.x0XOIxOo() == JsonReader.Token.STRING) {
                        jsonReader.Oxx0xo();
                    } else {
                        x0o0xo2 = oxoX.X0o0xo(jsonReader, oxx0IOOO);
                    }
                } else if (jsonReader.x0XOIxOo() == JsonReader.Token.STRING) {
                    jsonReader.Oxx0xo();
                } else {
                    x0o0xo = oxoX.X0o0xo(jsonReader, oxx0IOOO);
                }
                z = true;
            } else {
                iI0XooXoX = oIX0oI(jsonReader, oxx0IOOO);
            }
        }
        jsonReader.X0o0xo();
        if (z) {
            oxx0IOOO.oIX0oI("Lottie doesn't support expressions.");
        }
        if (iI0XooXoX != null) {
            return iI0XooXoX;
        }
        return new oOoXoXO(x0o0xo, x0o0xo2);
    }

    public static II0XooXoX oIX0oI(JsonReader jsonReader, Oxx0IOOO oxx0IOOO) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.x0XOIxOo() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.II0xO0();
            while (jsonReader.XO()) {
                arrayList.add(OxI.oIX0oI(jsonReader, oxx0IOOO));
            }
            jsonReader.oxoX();
            Oxx0xo.II0xO0(arrayList);
        } else {
            arrayList.add(new xoXoI.oIX0oI(x0xO0oo.X0o0xo(jsonReader, xoIox.X0o0xo())));
        }
        return new II0XooXoX(arrayList);
    }
}
