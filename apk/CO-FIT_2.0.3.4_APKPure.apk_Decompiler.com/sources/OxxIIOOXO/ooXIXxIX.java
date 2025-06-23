package OxxIIOOXO;

import IXxxXO.II0xO0;
import IXxxXO.xxIXOIIO;
import com.airbnb.lottie.Oxx0IOOO;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

public class ooXIXxIX {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static JsonReader.oIX0oI f214oIX0oI = JsonReader.oIX0oI.oIX0oI("nm", "hd", "it");

    public static xxIXOIIO oIX0oI(JsonReader jsonReader, Oxx0IOOO oxx0IOOO) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z = false;
        while (jsonReader.XO()) {
            int Oo2 = jsonReader.Oo(f214oIX0oI);
            if (Oo2 == 0) {
                str = jsonReader.OOXIXo();
            } else if (Oo2 == 1) {
                z = jsonReader.Oxx0IOOO();
            } else if (Oo2 != 2) {
                jsonReader.Oxx0xo();
            } else {
                jsonReader.II0xO0();
                while (jsonReader.XO()) {
                    II0xO0 oIX0oI2 = Oxx0IOOO.oIX0oI(jsonReader, oxx0IOOO);
                    if (oIX0oI2 != null) {
                        arrayList.add(oIX0oI2);
                    }
                }
                jsonReader.oxoX();
            }
        }
        return new xxIXOIIO(str, arrayList, z);
    }
}
