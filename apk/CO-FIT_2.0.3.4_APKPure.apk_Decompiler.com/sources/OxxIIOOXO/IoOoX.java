package OxxIIOOXO;

import Oo.X0o0xo;
import com.airbnb.lottie.Oxx0IOOO;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.kwad.sdk.m.e;
import java.io.IOException;

public class IoOoX {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static JsonReader.oIX0oI f187oIX0oI = JsonReader.oIX0oI.oIX0oI("s", e.TAG, "o", "nm", "m", "hd");

    public static ShapeTrimPath oIX0oI(JsonReader jsonReader, Oxx0IOOO oxx0IOOO) throws IOException {
        String str = null;
        ShapeTrimPath.Type type = null;
        X0o0xo x0o0xo = null;
        X0o0xo x0o0xo2 = null;
        X0o0xo x0o0xo3 = null;
        boolean z = false;
        while (jsonReader.XO()) {
            int Oo2 = jsonReader.Oo(f187oIX0oI);
            if (Oo2 == 0) {
                x0o0xo = oxoX.XO(jsonReader, oxx0IOOO, false);
            } else if (Oo2 == 1) {
                x0o0xo2 = oxoX.XO(jsonReader, oxx0IOOO, false);
            } else if (Oo2 == 2) {
                x0o0xo3 = oxoX.XO(jsonReader, oxx0IOOO, false);
            } else if (Oo2 == 3) {
                str = jsonReader.OOXIXo();
            } else if (Oo2 == 4) {
                type = ShapeTrimPath.Type.forId(jsonReader.xxIXOIIO());
            } else if (Oo2 != 5) {
                jsonReader.Oxx0xo();
            } else {
                z = jsonReader.Oxx0IOOO();
            }
        }
        return new ShapeTrimPath(str, type, x0o0xo, x0o0xo2, x0o0xo3, z);
    }
}
