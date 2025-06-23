package OxxIIOOXO;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class XO implements oOXoIIIo<Integer> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final XO f3097oIX0oI = new XO();

    @Override // OxxIIOOXO.oOXoIIIo
    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public Integer oIX0oI(JsonReader jsonReader, float f) throws IOException {
        boolean z;
        double d;
        if (jsonReader.x0XOIxOo() == JsonReader.Token.BEGIN_ARRAY) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            jsonReader.II0xO0();
        }
        double II0XooXoX2 = jsonReader.II0XooXoX();
        double II0XooXoX3 = jsonReader.II0XooXoX();
        double II0XooXoX4 = jsonReader.II0XooXoX();
        if (jsonReader.x0XOIxOo() == JsonReader.Token.NUMBER) {
            d = jsonReader.II0XooXoX();
        } else {
            d = 1.0d;
        }
        if (z) {
            jsonReader.oxoX();
        }
        if (II0XooXoX2 <= 1.0d && II0XooXoX3 <= 1.0d && II0XooXoX4 <= 1.0d) {
            II0XooXoX2 *= 255.0d;
            II0XooXoX3 *= 255.0d;
            II0XooXoX4 *= 255.0d;
            if (d <= 1.0d) {
                d *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) d, (int) II0XooXoX2, (int) II0XooXoX3, (int) II0XooXoX4));
    }
}
