package OxxIIOOXO;

import Oo.X0o0xo;
import Oo.x0xO0oo;
import android.graphics.PointF;
import com.airbnb.lottie.Oxx0IOOO;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import o0oIxXOx.oO;

public class XI0IXoo {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static final JsonReader.oIX0oI f198oIX0oI = JsonReader.oIX0oI.oIX0oI("nm", "sy", "pt", "p", "r", "or", oO.f20819XO, "ir", "is", "hd");

    public static PolystarShape oIX0oI(JsonReader jsonReader, Oxx0IOOO oxx0IOOO) throws IOException {
        String str = null;
        PolystarShape.Type type = null;
        X0o0xo x0o0xo = null;
        x0xO0oo<PointF, PointF> x0xo0oo = null;
        X0o0xo x0o0xo2 = null;
        X0o0xo x0o0xo3 = null;
        X0o0xo x0o0xo4 = null;
        X0o0xo x0o0xo5 = null;
        X0o0xo x0o0xo6 = null;
        boolean z = false;
        while (jsonReader.XO()) {
            switch (jsonReader.Oo(f198oIX0oI)) {
                case 0:
                    str = jsonReader.OOXIXo();
                    break;
                case 1:
                    type = PolystarShape.Type.forValue(jsonReader.xxIXOIIO());
                    break;
                case 2:
                    x0o0xo = oxoX.XO(jsonReader, oxx0IOOO, false);
                    break;
                case 3:
                    x0xo0oo = oIX0oI.II0xO0(jsonReader, oxx0IOOO);
                    break;
                case 4:
                    x0o0xo2 = oxoX.XO(jsonReader, oxx0IOOO, false);
                    break;
                case 5:
                    x0o0xo4 = oxoX.X0o0xo(jsonReader, oxx0IOOO);
                    break;
                case 6:
                    x0o0xo6 = oxoX.XO(jsonReader, oxx0IOOO, false);
                    break;
                case 7:
                    x0o0xo3 = oxoX.X0o0xo(jsonReader, oxx0IOOO);
                    break;
                case 8:
                    x0o0xo5 = oxoX.XO(jsonReader, oxx0IOOO, false);
                    break;
                case 9:
                    z = jsonReader.Oxx0IOOO();
                    break;
                default:
                    jsonReader.IXxxXO();
                    jsonReader.Oxx0xo();
                    break;
            }
        }
        return new PolystarShape(str, type, x0o0xo, x0xo0oo, x0o0xo2, x0o0xo3, x0o0xo4, x0o0xo5, x0o0xo6, z);
    }
}
