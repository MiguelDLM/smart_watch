package OxxIIOOXO;

import Oo.X0o0xo;
import Oo.oxoX;
import Oo.x0XOIxOo;
import com.airbnb.lottie.Oxx0IOOO;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class II0xO0 {

    /* renamed from: II0xO0  reason: collision with root package name */
    public static JsonReader.oIX0oI f178II0xO0 = JsonReader.oIX0oI.oIX0oI("fc", "sc", "sw", "t");

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static JsonReader.oIX0oI f179oIX0oI = JsonReader.oIX0oI.oIX0oI("a");

    public static x0XOIxOo II0xO0(JsonReader jsonReader, Oxx0IOOO oxx0IOOO) throws IOException {
        jsonReader.I0Io();
        oxoX oxox = null;
        oxoX oxox2 = null;
        X0o0xo x0o0xo = null;
        X0o0xo x0o0xo2 = null;
        while (jsonReader.XO()) {
            int Oo2 = jsonReader.Oo(f178II0xO0);
            if (Oo2 == 0) {
                oxox = oxoX.I0Io(jsonReader, oxx0IOOO);
            } else if (Oo2 == 1) {
                oxox2 = oxoX.I0Io(jsonReader, oxx0IOOO);
            } else if (Oo2 == 2) {
                x0o0xo = oxoX.X0o0xo(jsonReader, oxx0IOOO);
            } else if (Oo2 != 3) {
                jsonReader.IXxxXO();
                jsonReader.Oxx0xo();
            } else {
                x0o0xo2 = oxoX.X0o0xo(jsonReader, oxx0IOOO);
            }
        }
        jsonReader.X0o0xo();
        return new x0XOIxOo(oxox, oxox2, x0o0xo, x0o0xo2);
    }

    public static x0XOIxOo oIX0oI(JsonReader jsonReader, Oxx0IOOO oxx0IOOO) throws IOException {
        jsonReader.I0Io();
        x0XOIxOo x0xoixoo = null;
        while (jsonReader.XO()) {
            if (jsonReader.Oo(f179oIX0oI) != 0) {
                jsonReader.IXxxXO();
                jsonReader.Oxx0xo();
            } else {
                x0xoixoo = II0xO0(jsonReader, oxx0IOOO);
            }
        }
        jsonReader.X0o0xo();
        if (x0xoixoo == null) {
            return new x0XOIxOo((oxoX) null, (oxoX) null, (X0o0xo) null, (X0o0xo) null);
        }
        return x0xoixoo;
    }
}
