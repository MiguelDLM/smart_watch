package OxxIIOOXO;

import IXxxXO.X0o0xo;
import Oo.x0xO0oo;
import Oo.xxIXOIIO;
import android.graphics.PointF;
import com.airbnb.lottie.Oxx0IOOO;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class XIxXXX0x0 {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static JsonReader.oIX0oI f199oIX0oI = JsonReader.oIX0oI.oIX0oI("nm", "p", "s", "r", "hd");

    public static X0o0xo oIX0oI(JsonReader jsonReader, Oxx0IOOO oxx0IOOO) throws IOException {
        String str = null;
        x0xO0oo<PointF, PointF> x0xo0oo = null;
        xxIXOIIO xxixoiio = null;
        Oo.X0o0xo x0o0xo = null;
        boolean z = false;
        while (jsonReader.XO()) {
            int Oo2 = jsonReader.Oo(f199oIX0oI);
            if (Oo2 == 0) {
                str = jsonReader.OOXIXo();
            } else if (Oo2 == 1) {
                x0xo0oo = oIX0oI.II0xO0(jsonReader, oxx0IOOO);
            } else if (Oo2 == 2) {
                xxixoiio = oxoX.xxIXOIIO(jsonReader, oxx0IOOO);
            } else if (Oo2 == 3) {
                x0o0xo = oxoX.X0o0xo(jsonReader, oxx0IOOO);
            } else if (Oo2 != 4) {
                jsonReader.Oxx0xo();
            } else {
                z = jsonReader.Oxx0IOOO();
            }
        }
        return new X0o0xo(str, x0xo0oo, xxixoiio, x0o0xo, z);
    }
}
