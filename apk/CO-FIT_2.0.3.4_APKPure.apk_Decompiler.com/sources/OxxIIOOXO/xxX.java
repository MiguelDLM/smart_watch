package OxxIIOOXO;

import IXxxXO.XO;
import Oo.X0o0xo;
import Oo.oO;
import com.airbnb.lottie.Oxx0IOOO;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class xxX {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static JsonReader.oIX0oI f226oIX0oI = JsonReader.oIX0oI.oIX0oI("nm", "c", "o", "tr", "hd");

    public static XO oIX0oI(JsonReader jsonReader, Oxx0IOOO oxx0IOOO) throws IOException {
        String str = null;
        X0o0xo x0o0xo = null;
        X0o0xo x0o0xo2 = null;
        oO oOVar = null;
        boolean z = false;
        while (jsonReader.XO()) {
            int Oo2 = jsonReader.Oo(f226oIX0oI);
            if (Oo2 == 0) {
                str = jsonReader.OOXIXo();
            } else if (Oo2 == 1) {
                x0o0xo = oxoX.XO(jsonReader, oxx0IOOO, false);
            } else if (Oo2 == 2) {
                x0o0xo2 = oxoX.XO(jsonReader, oxx0IOOO, false);
            } else if (Oo2 == 3) {
                oOVar = I0Io.Oxx0IOOO(jsonReader, oxx0IOOO);
            } else if (Oo2 != 4) {
                jsonReader.Oxx0xo();
            } else {
                z = jsonReader.Oxx0IOOO();
            }
        }
        return new XO(str, x0o0xo, x0o0xo2, oOVar, z);
    }
}
