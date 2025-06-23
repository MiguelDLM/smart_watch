package OxxIIOOXO;

import IIXOooo.xoIox;
import Oo.OOXIXo;
import Oo.X0o0xo;
import Oo.XO;
import Oo.ooOOo0oXI;
import Oo.xxIXOIIO;
import com.airbnb.lottie.Oxx0IOOO;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.List;
import xoXoI.oIX0oI;

public class oxoX {
    public static Oo.oxoX I0Io(JsonReader jsonReader, Oxx0IOOO oxx0IOOO) throws IOException {
        return new Oo.oxoX(II0xO0(jsonReader, oxx0IOOO, XO.f200oIX0oI));
    }

    public static Oo.Oxx0IOOO II0XooXoX(JsonReader jsonReader, Oxx0IOOO oxx0IOOO) throws IOException {
        return new Oo.Oxx0IOOO(II0xO0(jsonReader, oxx0IOOO, oO.f208oIX0oI));
    }

    public static <T> List<oIX0oI<T>> II0xO0(JsonReader jsonReader, Oxx0IOOO oxx0IOOO, oOXoIIIo<T> ooxoiiio) throws IOException {
        return Oxx0xo.oIX0oI(jsonReader, oxx0IOOO, 1.0f, ooxoiiio, false);
    }

    public static OOXIXo OOXIXo(JsonReader jsonReader, Oxx0IOOO oxx0IOOO) throws IOException {
        return new OOXIXo(oIX0oI(jsonReader, xoIox.X0o0xo(), oxx0IOOO, xXxxox0I.f222oIX0oI));
    }

    public static XO Oxx0IOOO(JsonReader jsonReader, Oxx0IOOO oxx0IOOO, int i) throws IOException {
        return new XO(II0xO0(jsonReader, oxx0IOOO, new oOoXoXO(i)));
    }

    public static X0o0xo X0o0xo(JsonReader jsonReader, Oxx0IOOO oxx0IOOO) throws IOException {
        return XO(jsonReader, oxx0IOOO, true);
    }

    public static X0o0xo XO(JsonReader jsonReader, Oxx0IOOO oxx0IOOO, boolean z) throws IOException {
        float f;
        if (z) {
            f = xoIox.X0o0xo();
        } else {
            f = 1.0f;
        }
        return new X0o0xo(oIX0oI(jsonReader, f, oxx0IOOO, xxIXOIIO.f225oIX0oI));
    }

    public static <T> List<oIX0oI<T>> oIX0oI(JsonReader jsonReader, float f, Oxx0IOOO oxx0IOOO, oOXoIIIo<T> ooxoiiio) throws IOException {
        return Oxx0xo.oIX0oI(jsonReader, oxx0IOOO, f, ooxoiiio, false);
    }

    public static ooOOo0oXI oxoX(JsonReader jsonReader, Oxx0IOOO oxx0IOOO) throws IOException {
        return new ooOOo0oXI(II0xO0(jsonReader, oxx0IOOO, II0XooXoX.f177oIX0oI));
    }

    public static Oo.xoIox xoIox(JsonReader jsonReader, Oxx0IOOO oxx0IOOO) throws IOException {
        return new Oo.xoIox((List<oIX0oI<xoXoI.OOXIXo>>) II0xO0(jsonReader, oxx0IOOO, XxX0x0xxx.f201oIX0oI));
    }

    public static xxIXOIIO xxIXOIIO(JsonReader jsonReader, Oxx0IOOO oxx0IOOO) throws IOException {
        return new xxIXOIIO(Oxx0xo.oIX0oI(jsonReader, oxx0IOOO, xoIox.X0o0xo(), X0IIOO.f196oIX0oI, true));
    }
}
