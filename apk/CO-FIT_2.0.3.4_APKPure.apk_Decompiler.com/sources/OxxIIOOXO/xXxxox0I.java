package OxxIIOOXO;

import IIXOooo.xxIXOIIO;
import IXxxXO.Oxx0IOOO;
import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import x0xO0oo.oIX0oI;

public class xXxxox0I implements oOXoIIIo<Oxx0IOOO> {

    /* renamed from: II0xO0  reason: collision with root package name */
    public static final JsonReader.oIX0oI f221II0xO0 = JsonReader.oIX0oI.oIX0oI("c", t.c, "i", "o");

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static final xXxxox0I f222oIX0oI = new xXxxox0I();

    /* renamed from: II0xO0 */
    public Oxx0IOOO oIX0oI(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.x0XOIxOo() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.II0xO0();
        }
        jsonReader.I0Io();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (jsonReader.XO()) {
            int Oo2 = jsonReader.Oo(f221II0xO0);
            if (Oo2 == 0) {
                z = jsonReader.Oxx0IOOO();
            } else if (Oo2 == 1) {
                list = x0xO0oo.XO(jsonReader, f);
            } else if (Oo2 == 2) {
                list2 = x0xO0oo.XO(jsonReader, f);
            } else if (Oo2 != 3) {
                jsonReader.IXxxXO();
                jsonReader.Oxx0xo();
            } else {
                list3 = x0xO0oo.XO(jsonReader, f);
            }
        }
        jsonReader.X0o0xo();
        if (jsonReader.x0XOIxOo() == JsonReader.Token.END_ARRAY) {
            jsonReader.oxoX();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        } else if (list.isEmpty()) {
            return new Oxx0IOOO(new PointF(), false, Collections.emptyList());
        } else {
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i = 1; i < size; i++) {
                PointF pointF2 = list.get(i);
                int i2 = i - 1;
                arrayList.add(new oIX0oI(xxIXOIIO.oIX0oI(list.get(i2), list3.get(i2)), xxIXOIIO.oIX0oI(pointF2, list2.get(i)), pointF2));
            }
            if (z) {
                PointF pointF3 = list.get(0);
                int i3 = size - 1;
                arrayList.add(new oIX0oI(xxIXOIIO.oIX0oI(list.get(i3), list3.get(i3)), xxIXOIIO.oIX0oI(pointF3, list2.get(0)), pointF3));
            }
            return new Oxx0IOOO(pointF, z, arrayList);
        }
    }
}
