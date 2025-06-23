package OxxIIOOXO;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mapsdkplatform.comapi.f;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.io.IOException;

/* loaded from: classes.dex */
public class II0XooXoX implements oOXoIIIo<DocumentData> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final II0XooXoX f3074oIX0oI = new II0XooXoX();

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final JsonReader.oIX0oI f3073II0xO0 = JsonReader.oIX0oI.oIX0oI("t", f.f6163a, "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", MapBundleKey.MapObjKey.OBJ_OFFSET);

    @Override // OxxIIOOXO.oOXoIIIo
    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public DocumentData oIX0oI(JsonReader jsonReader, float f) throws IOException {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.I0Io();
        DocumentData.Justification justification2 = justification;
        String str = null;
        String str2 = null;
        float f2 = 0.0f;
        int i = 0;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        float f5 = 0.0f;
        boolean z = true;
        while (jsonReader.XO()) {
            switch (jsonReader.Oo(f3073II0xO0)) {
                case 0:
                    str = jsonReader.OOXIXo();
                    break;
                case 1:
                    str2 = jsonReader.OOXIXo();
                    break;
                case 2:
                    f2 = (float) jsonReader.II0XooXoX();
                    break;
                case 3:
                    int xxIXOIIO2 = jsonReader.xxIXOIIO();
                    justification2 = DocumentData.Justification.CENTER;
                    if (xxIXOIIO2 <= justification2.ordinal() && xxIXOIIO2 >= 0) {
                        justification2 = DocumentData.Justification.values()[xxIXOIIO2];
                        break;
                    }
                    break;
                case 4:
                    i = jsonReader.xxIXOIIO();
                    break;
                case 5:
                    f3 = (float) jsonReader.II0XooXoX();
                    break;
                case 6:
                    f4 = (float) jsonReader.II0XooXoX();
                    break;
                case 7:
                    i2 = x0xO0oo.oxoX(jsonReader);
                    break;
                case 8:
                    i3 = x0xO0oo.oxoX(jsonReader);
                    break;
                case 9:
                    f5 = (float) jsonReader.II0XooXoX();
                    break;
                case 10:
                    z = jsonReader.Oxx0IOOO();
                    break;
                default:
                    jsonReader.IXxxXO();
                    jsonReader.Oxx0xo();
                    break;
            }
        }
        jsonReader.X0o0xo();
        return new DocumentData(str, str2, f2, justification2, i, f3, f4, i2, i3, f5, z);
    }
}
