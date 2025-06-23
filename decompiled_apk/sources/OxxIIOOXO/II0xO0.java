package OxxIIOOXO;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class II0xO0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static JsonReader.oIX0oI f3076oIX0oI = JsonReader.oIX0oI.oIX0oI("a");

    /* renamed from: II0xO0, reason: collision with root package name */
    public static JsonReader.oIX0oI f3075II0xO0 = JsonReader.oIX0oI.oIX0oI("fc", "sc", "sw", "t");

    public static Oo.x0XOIxOo II0xO0(JsonReader jsonReader, com.airbnb.lottie.Oxx0IOOO oxx0IOOO) throws IOException {
        jsonReader.I0Io();
        Oo.oxoX oxox = null;
        Oo.oxoX oxox2 = null;
        Oo.X0o0xo x0o0xo = null;
        Oo.X0o0xo x0o0xo2 = null;
        while (jsonReader.XO()) {
            int Oo2 = jsonReader.Oo(f3075II0xO0);
            if (Oo2 != 0) {
                if (Oo2 != 1) {
                    if (Oo2 != 2) {
                        if (Oo2 != 3) {
                            jsonReader.IXxxXO();
                            jsonReader.Oxx0xo();
                        } else {
                            x0o0xo2 = oxoX.X0o0xo(jsonReader, oxx0IOOO);
                        }
                    } else {
                        x0o0xo = oxoX.X0o0xo(jsonReader, oxx0IOOO);
                    }
                } else {
                    oxox2 = oxoX.I0Io(jsonReader, oxx0IOOO);
                }
            } else {
                oxox = oxoX.I0Io(jsonReader, oxx0IOOO);
            }
        }
        jsonReader.X0o0xo();
        return new Oo.x0XOIxOo(oxox, oxox2, x0o0xo, x0o0xo2);
    }

    public static Oo.x0XOIxOo oIX0oI(JsonReader jsonReader, com.airbnb.lottie.Oxx0IOOO oxx0IOOO) throws IOException {
        jsonReader.I0Io();
        Oo.x0XOIxOo x0xoixoo = null;
        while (jsonReader.XO()) {
            if (jsonReader.Oo(f3076oIX0oI) != 0) {
                jsonReader.IXxxXO();
                jsonReader.Oxx0xo();
            } else {
                x0xoixoo = II0xO0(jsonReader, oxx0IOOO);
            }
        }
        jsonReader.X0o0xo();
        if (x0xoixoo == null) {
            return new Oo.x0XOIxOo(null, null, null, null);
        }
        return x0xoixoo;
    }
}
