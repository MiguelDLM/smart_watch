package OxxIIOOXO;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class x0xO0oo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final JsonReader.oIX0oI f3115oIX0oI = JsonReader.oIX0oI.oIX0oI("x", "y");

    /* loaded from: classes.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f3116oIX0oI;

        static {
            int[] iArr = new int[JsonReader.Token.values().length];
            f3116oIX0oI = iArr;
            try {
                iArr[JsonReader.Token.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3116oIX0oI[JsonReader.Token.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3116oIX0oI[JsonReader.Token.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static PointF I0Io(JsonReader jsonReader, float f) throws IOException {
        jsonReader.I0Io();
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (jsonReader.XO()) {
            int Oo2 = jsonReader.Oo(f3115oIX0oI);
            if (Oo2 != 0) {
                if (Oo2 != 1) {
                    jsonReader.IXxxXO();
                    jsonReader.Oxx0xo();
                } else {
                    f3 = Oxx0IOOO(jsonReader);
                }
            } else {
                f2 = Oxx0IOOO(jsonReader);
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
        int i = oIX0oI.f3116oIX0oI[x0XOIxOo2.ordinal()];
        if (i != 1) {
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
        return (float) jsonReader.II0XooXoX();
    }

    public static PointF X0o0xo(JsonReader jsonReader, float f) throws IOException {
        int i = oIX0oI.f3116oIX0oI[jsonReader.x0XOIxOo().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return I0Io(jsonReader, f);
                }
                throw new IllegalArgumentException("Unknown point starts with " + jsonReader.x0XOIxOo());
            }
            return oIX0oI(jsonReader, f);
        }
        return II0xO0(jsonReader, f);
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
