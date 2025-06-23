package OxxIIOOXO;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class x0xO0oo {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static final JsonReader.oIX0oI f218oIX0oI = JsonReader.oIX0oI.oIX0oI("x", "y");

    public static /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI  reason: collision with root package name */
        public static final /* synthetic */ int[] f219oIX0oI;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.airbnb.lottie.parser.moshi.JsonReader$Token[] r0 = com.airbnb.lottie.parser.moshi.JsonReader.Token.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f219oIX0oI = r0
                com.airbnb.lottie.parser.moshi.JsonReader$Token r1 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f219oIX0oI     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.parser.moshi.JsonReader$Token r1 = com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f219oIX0oI     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.parser.moshi.JsonReader$Token r1 = com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: OxxIIOOXO.x0xO0oo.oIX0oI.<clinit>():void");
        }
    }

    public static PointF I0Io(JsonReader jsonReader, float f) throws IOException {
        jsonReader.I0Io();
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (jsonReader.XO()) {
            int Oo2 = jsonReader.Oo(f218oIX0oI);
            if (Oo2 == 0) {
                f2 = Oxx0IOOO(jsonReader);
            } else if (Oo2 != 1) {
                jsonReader.IXxxXO();
                jsonReader.Oxx0xo();
            } else {
                f3 = Oxx0IOOO(jsonReader);
            }
        }
        jsonReader.X0o0xo();
        return new PointF(f2 * f, f3 * f);
    }

    public static PointF II0xO0(JsonReader jsonReader, float f) throws IOException {
        float II0XooXoX2 = (float) jsonReader.II0XooXoX();
        float II0XooXoX3 = (float) jsonReader.II0XooXoX();
        while (jsonReader.XO()) {
            jsonReader.Oxx0xo();
        }
        return new PointF(II0XooXoX2 * f, II0XooXoX3 * f);
    }

    public static float Oxx0IOOO(JsonReader jsonReader) throws IOException {
        JsonReader.Token x0XOIxOo2 = jsonReader.x0XOIxOo();
        int i = oIX0oI.f219oIX0oI[x0XOIxOo2.ordinal()];
        if (i == 1) {
            return (float) jsonReader.II0XooXoX();
        }
        if (i == 2) {
            jsonReader.II0xO0();
            float II0XooXoX2 = (float) jsonReader.II0XooXoX();
            while (jsonReader.XO()) {
                jsonReader.Oxx0xo();
            }
            jsonReader.oxoX();
            return II0XooXoX2;
        }
        throw new IllegalArgumentException("Unknown value for token of type " + x0XOIxOo2);
    }

    public static PointF X0o0xo(JsonReader jsonReader, float f) throws IOException {
        int i = oIX0oI.f219oIX0oI[jsonReader.x0XOIxOo().ordinal()];
        if (i == 1) {
            return II0xO0(jsonReader, f);
        }
        if (i == 2) {
            return oIX0oI(jsonReader, f);
        }
        if (i == 3) {
            return I0Io(jsonReader, f);
        }
        throw new IllegalArgumentException("Unknown point starts with " + jsonReader.x0XOIxOo());
    }

    public static List<PointF> XO(JsonReader jsonReader, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.II0xO0();
        while (jsonReader.x0XOIxOo() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.II0xO0();
            arrayList.add(X0o0xo(jsonReader, f));
            jsonReader.oxoX();
        }
        jsonReader.oxoX();
        return arrayList;
    }

    public static PointF oIX0oI(JsonReader jsonReader, float f) throws IOException {
        jsonReader.II0xO0();
        float II0XooXoX2 = (float) jsonReader.II0XooXoX();
        float II0XooXoX3 = (float) jsonReader.II0XooXoX();
        while (jsonReader.x0XOIxOo() != JsonReader.Token.END_ARRAY) {
            jsonReader.Oxx0xo();
        }
        jsonReader.oxoX();
        return new PointF(II0XooXoX2 * f, II0XooXoX3 * f);
    }

    @ColorInt
    public static int oxoX(JsonReader jsonReader) throws IOException {
        jsonReader.II0xO0();
        int II0XooXoX2 = (int) (jsonReader.II0XooXoX() * 255.0d);
        int II0XooXoX3 = (int) (jsonReader.II0XooXoX() * 255.0d);
        int II0XooXoX4 = (int) (jsonReader.II0XooXoX() * 255.0d);
        while (jsonReader.XO()) {
            jsonReader.Oxx0xo();
        }
        jsonReader.oxoX();
        return Color.argb(255, II0XooXoX2, II0XooXoX3, II0XooXoX4);
    }
}
