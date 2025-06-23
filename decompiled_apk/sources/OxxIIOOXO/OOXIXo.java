package OxxIIOOXO;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.garmin.fit.xOxOoo;
import java.io.IOException;

/* loaded from: classes.dex */
public class OOXIXo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final JsonReader.oIX0oI f3086oIX0oI = JsonReader.oIX0oI.oIX0oI("fFamily", "fName", "fStyle", xOxOoo.f15469XxX0x0xxx);

    public static x0xO0oo.II0xO0 oIX0oI(JsonReader jsonReader) throws IOException {
        jsonReader.I0Io();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f = 0.0f;
        while (jsonReader.XO()) {
            int Oo2 = jsonReader.Oo(f3086oIX0oI);
            if (Oo2 != 0) {
                if (Oo2 != 1) {
                    if (Oo2 != 2) {
                        if (Oo2 != 3) {
                            jsonReader.IXxxXO();
                            jsonReader.Oxx0xo();
                        } else {
                            f = (float) jsonReader.II0XooXoX();
                        }
                    } else {
                        str3 = jsonReader.OOXIXo();
                    }
                } else {
                    str2 = jsonReader.OOXIXo();
                }
            } else {
                str = jsonReader.OOXIXo();
            }
        }
        jsonReader.X0o0xo();
        return new x0xO0oo.II0xO0(str, str2, str3, f);
    }
}
