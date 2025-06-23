package OxxIIOOXO;

import com.airbnb.lottie.Oxx0IOOO;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import x0XOIxOo.II0XooXoX;
import xoXoI.oIX0oI;

public class Oxx0xo {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static JsonReader.oIX0oI f191oIX0oI = JsonReader.oIX0oI.oIX0oI(t.f3784a);

    public static <T> void II0xO0(List<? extends oIX0oI<T>> list) {
        int i;
        T t;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            oIX0oI oix0oi = (oIX0oI) list.get(i2);
            i2++;
            oIX0oI oix0oi2 = (oIX0oI) list.get(i2);
            oix0oi.f1611II0XooXoX = Float.valueOf(oix0oi2.f1614Oxx0IOOO);
            if (oix0oi.f1610I0Io == null && (t = oix0oi2.f1612II0xO0) != null) {
                oix0oi.f1610I0Io = t;
                if (oix0oi instanceof II0XooXoX) {
                    ((II0XooXoX) oix0oi).xxIXOIIO();
                }
            }
        }
        oIX0oI oix0oi3 = (oIX0oI) list.get(i);
        if ((oix0oi3.f1612II0xO0 == null || oix0oi3.f1610I0Io == null) && list.size() > 1) {
            list.remove(oix0oi3);
        }
    }

    public static <T> List<oIX0oI<T>> oIX0oI(JsonReader jsonReader, Oxx0IOOO oxx0IOOO, float f, oOXoIIIo<T> ooxoiiio, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.x0XOIxOo() == JsonReader.Token.STRING) {
            oxx0IOOO.oIX0oI("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.I0Io();
        while (jsonReader.XO()) {
            if (jsonReader.Oo(f191oIX0oI) != 0) {
                jsonReader.Oxx0xo();
            } else if (jsonReader.x0XOIxOo() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.II0xO0();
                if (jsonReader.x0XOIxOo() == JsonReader.Token.NUMBER) {
                    arrayList.add(IXxxXO.I0Io(jsonReader, oxx0IOOO, f, ooxoiiio, false, z));
                } else {
                    while (jsonReader.XO()) {
                        arrayList.add(IXxxXO.I0Io(jsonReader, oxx0IOOO, f, ooxoiiio, true, z));
                    }
                }
                jsonReader.oxoX();
            } else {
                arrayList.add(IXxxXO.I0Io(jsonReader, oxx0IOOO, f, ooxoiiio, false, z));
            }
        }
        jsonReader.X0o0xo();
        II0xO0(arrayList);
        return arrayList;
    }
}
