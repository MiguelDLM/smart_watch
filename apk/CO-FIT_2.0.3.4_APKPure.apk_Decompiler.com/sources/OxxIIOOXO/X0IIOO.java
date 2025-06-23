package OxxIIOOXO;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class X0IIOO implements oOXoIIIo<PointF> {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static final X0IIOO f196oIX0oI = new X0IIOO();

    /* renamed from: II0xO0 */
    public PointF oIX0oI(JsonReader jsonReader, float f) throws IOException {
        JsonReader.Token x0XOIxOo2 = jsonReader.x0XOIxOo();
        if (x0XOIxOo2 == JsonReader.Token.BEGIN_ARRAY) {
            return x0xO0oo.X0o0xo(jsonReader, f);
        }
        if (x0XOIxOo2 == JsonReader.Token.BEGIN_OBJECT) {
            return x0xO0oo.X0o0xo(jsonReader, f);
        }
        if (x0XOIxOo2 == JsonReader.Token.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.II0XooXoX()) * f, ((float) jsonReader.II0XooXoX()) * f);
            while (jsonReader.XO()) {
                jsonReader.Oxx0xo();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + x0XOIxOo2);
    }
}
