package OxxIIOOXO;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.garmin.fit.xOxOoo;
import java.io.IOException;
import x0xO0oo.II0xO0;

public class OOXIXo {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static final JsonReader.oIX0oI f189oIX0oI = JsonReader.oIX0oI.oIX0oI("fFamily", "fName", "fStyle", xOxOoo.f33865XxX0x0xxx);

    public static II0xO0 oIX0oI(JsonReader jsonReader) throws IOException {
        jsonReader.I0Io();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f = 0.0f;
        while (jsonReader.XO()) {
            int Oo2 = jsonReader.Oo(f189oIX0oI);
            if (Oo2 == 0) {
                str = jsonReader.OOXIXo();
            } else if (Oo2 == 1) {
                str2 = jsonReader.OOXIXo();
            } else if (Oo2 == 2) {
                str3 = jsonReader.OOXIXo();
            } else if (Oo2 != 3) {
                jsonReader.IXxxXO();
                jsonReader.Oxx0xo();
            } else {
                f = (float) jsonReader.II0XooXoX();
            }
        }
        jsonReader.X0o0xo();
        return new II0xO0(str, str2, str3, f);
    }
}
