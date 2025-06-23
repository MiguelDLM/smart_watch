package OxxIIOOXO;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class xxX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static JsonReader.oIX0oI f3123oIX0oI = JsonReader.oIX0oI.oIX0oI("nm", "c", "o", "tr", "hd");

    public static IXxxXO.XO oIX0oI(JsonReader jsonReader, com.airbnb.lottie.Oxx0IOOO oxx0IOOO) throws IOException {
        String str = null;
        Oo.X0o0xo x0o0xo = null;
        Oo.X0o0xo x0o0xo2 = null;
        Oo.oO oOVar = null;
        boolean z = false;
        while (jsonReader.XO()) {
            int Oo2 = jsonReader.Oo(f3123oIX0oI);
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
                            oOVar = I0Io.Oxx0IOOO(jsonReader, oxx0IOOO);
                        }
                    } else {
                        x0o0xo2 = oxoX.XO(jsonReader, oxx0IOOO, false);
                    }
                } else {
                    x0o0xo = oxoX.XO(jsonReader, oxx0IOOO, false);
                }
            } else {
                str = jsonReader.OOXIXo();
            }
        }
        return new IXxxXO.XO(str, x0o0xo, x0o0xo2, oOVar, z);
    }
}
