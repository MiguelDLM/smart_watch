package OxxIIOOXO;

import IXxxXO.II0XooXoX;
import Oo.oxoX;
import android.graphics.Path;
import com.airbnb.lottie.Oxx0IOOO;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.Collections;
import xoXoI.oIX0oI;

public class IIX0o {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static final JsonReader.oIX0oI f180oIX0oI = JsonReader.oIX0oI.oIX0oI("nm", "c", "o", "fillEnabled", "r", "hd");

    public static II0XooXoX oIX0oI(JsonReader jsonReader, Oxx0IOOO oxx0IOOO) throws IOException {
        Path.FillType fillType;
        Oo.Oxx0IOOO oxx0IOOO2 = null;
        String str = null;
        oxoX oxox = null;
        int i = 1;
        boolean z = false;
        boolean z2 = false;
        while (jsonReader.XO()) {
            int Oo2 = jsonReader.Oo(f180oIX0oI);
            if (Oo2 == 0) {
                str = jsonReader.OOXIXo();
            } else if (Oo2 == 1) {
                oxox = oxoX.I0Io(jsonReader, oxx0IOOO);
            } else if (Oo2 == 2) {
                oxx0IOOO2 = oxoX.II0XooXoX(jsonReader, oxx0IOOO);
            } else if (Oo2 == 3) {
                z = jsonReader.Oxx0IOOO();
            } else if (Oo2 == 4) {
                i = jsonReader.xxIXOIIO();
            } else if (Oo2 != 5) {
                jsonReader.IXxxXO();
                jsonReader.Oxx0xo();
            } else {
                z2 = jsonReader.Oxx0IOOO();
            }
        }
        if (oxx0IOOO2 == null) {
            oxx0IOOO2 = new Oo.Oxx0IOOO(Collections.singletonList(new oIX0oI(100)));
        }
        Oo.Oxx0IOOO oxx0IOOO3 = oxx0IOOO2;
        if (i == 1) {
            fillType = Path.FillType.WINDING;
        } else {
            fillType = Path.FillType.EVEN_ODD;
        }
        return new II0XooXoX(str, z, fillType, oxox, oxx0IOOO3, z2);
    }
}
