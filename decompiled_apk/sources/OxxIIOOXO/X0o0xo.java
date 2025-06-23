package OxxIIOOXO;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class X0o0xo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static JsonReader.oIX0oI f3094oIX0oI = JsonReader.oIX0oI.oIX0oI("nm", "p", "s", "hd", "d");

    public static IXxxXO.oIX0oI oIX0oI(JsonReader jsonReader, com.airbnb.lottie.Oxx0IOOO oxx0IOOO, int i) throws IOException {
        boolean z;
        if (i == 3) {
            z = true;
        } else {
            z = false;
        }
        boolean z2 = z;
        String str = null;
        Oo.x0xO0oo<PointF, PointF> x0xo0oo = null;
        Oo.xxIXOIIO xxixoiio = null;
        boolean z3 = false;
        while (jsonReader.XO()) {
            int Oo2 = jsonReader.Oo(f3094oIX0oI);
            if (Oo2 != 0) {
                if (Oo2 != 1) {
                    if (Oo2 != 2) {
                        if (Oo2 != 3) {
                            if (Oo2 != 4) {
                                jsonReader.IXxxXO();
                                jsonReader.Oxx0xo();
                            } else if (jsonReader.xxIXOIIO() == 3) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        } else {
                            z3 = jsonReader.Oxx0IOOO();
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
        return new IXxxXO.oIX0oI(str, x0xo0oo, xxixoiio, z2, z3);
    }
}
