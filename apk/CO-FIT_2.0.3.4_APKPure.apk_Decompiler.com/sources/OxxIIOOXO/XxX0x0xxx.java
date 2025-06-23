package OxxIIOOXO;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import xoXoI.OOXIXo;

public class XxX0x0xxx implements oOXoIIIo<OOXIXo> {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static final XxX0x0xxx f201oIX0oI = new XxX0x0xxx();

    /* renamed from: II0xO0 */
    public OOXIXo oIX0oI(JsonReader jsonReader, float f) throws IOException {
        boolean z;
        if (jsonReader.x0XOIxOo() == JsonReader.Token.BEGIN_ARRAY) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            jsonReader.II0xO0();
        }
        float II0XooXoX2 = (float) jsonReader.II0XooXoX();
        float II0XooXoX3 = (float) jsonReader.II0XooXoX();
        while (jsonReader.XO()) {
            jsonReader.Oxx0xo();
        }
        if (z) {
            jsonReader.oxoX();
        }
        return new OOXIXo((II0XooXoX2 / 100.0f) * f, (II0XooXoX3 / 100.0f) * f);
    }
}
