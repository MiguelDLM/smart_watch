package OxxIIOOXO;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class XIxXXX0x0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static JsonReader.oIX0oI f3096oIX0oI = JsonReader.oIX0oI.oIX0oI("nm", "p", "s", "r", "hd");

    public static IXxxXO.X0o0xo oIX0oI(JsonReader jsonReader, com.airbnb.lottie.Oxx0IOOO oxx0IOOO) throws IOException {
        String str = null;
        Oo.x0xO0oo<PointF, PointF> x0xo0oo = null;
        Oo.xxIXOIIO xxixoiio = null;
        Oo.X0o0xo x0o0xo = null;
        boolean z = false;
        while (jsonReader.XO()) {
            int Oo2 = jsonReader.Oo(f3096oIX0oI);
            if (Oo2 != 0) {
                if (Oo2 != 1) {
                    if (Oo2 != 2) {
                        if (Oo2 != 3) {
                            if (Oo2 != 4) {
                                jsonReader.Oxx0xo();
                            } else {
                                z = jsonReader.Oxx0IOOO();
                            }
                        } else {
                            x0o0xo = oxoX.X0o0xo(jsonReader, oxx0IOOO);
                        }
                    } else {
                        xxixoiio = oxoX.xxIXOIIO(jsonReader, oxx0IOOO);
                    }
                } else {
                    x0xo0oo = oIX0oI.II0xO0(jsonReader, oxx0IOOO);
                }
            } else {
                str = jsonReader.OOXIXo();
            }
        }
        return new IXxxXO.X0o0xo(str, x0xo0oo, xxixoiio, x0o0xo, z);
    }
}
