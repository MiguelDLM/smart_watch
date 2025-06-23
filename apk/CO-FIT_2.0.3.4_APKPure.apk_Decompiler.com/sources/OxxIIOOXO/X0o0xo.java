package OxxIIOOXO;

import IXxxXO.oIX0oI;
import Oo.x0xO0oo;
import Oo.xxIXOIIO;
import android.graphics.PointF;
import com.airbnb.lottie.Oxx0IOOO;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class X0o0xo {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static JsonReader.oIX0oI f197oIX0oI = JsonReader.oIX0oI.oIX0oI("nm", "p", "s", "hd", "d");

    public static oIX0oI oIX0oI(JsonReader jsonReader, Oxx0IOOO oxx0IOOO, int i) throws IOException {
        boolean z;
        if (i == 3) {
            z = true;
        } else {
            z = false;
        }
        boolean z2 = z;
        String str = null;
        x0xO0oo<PointF, PointF> x0xo0oo = null;
        xxIXOIIO xxixoiio = null;
        boolean z3 = false;
        while (jsonReader.XO()) {
            int Oo2 = jsonReader.Oo(f197oIX0oI);
            if (Oo2 == 0) {
                str = jsonReader.OOXIXo();
            } else if (Oo2 == 1) {
                x0xo0oo = oIX0oI.II0xO0(jsonReader, oxx0IOOO);
            } else if (Oo2 == 2) {
                xxixoiio = oxoX.xxIXOIIO(jsonReader, oxx0IOOO);
            } else if (Oo2 == 3) {
                z3 = jsonReader.Oxx0IOOO();
            } else if (Oo2 != 4) {
                jsonReader.IXxxXO();
                jsonReader.Oxx0xo();
            } else if (jsonReader.xxIXOIIO() == 3) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return new oIX0oI(str, x0xo0oo, xxixoiio, z2, z3);
    }
}
