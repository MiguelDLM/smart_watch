package OxxIIOOXO;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.IOException;

/* loaded from: classes.dex */
public class xI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static JsonReader.oIX0oI f3117oIX0oI = JsonReader.oIX0oI.oIX0oI("nm", "ind", MediationConstant.ADN_KS, "hd");

    public static IXxxXO.xoIox oIX0oI(JsonReader jsonReader, com.airbnb.lottie.Oxx0IOOO oxx0IOOO) throws IOException {
        String str = null;
        Oo.OOXIXo oOXIXo = null;
        int i = 0;
        boolean z = false;
        while (jsonReader.XO()) {
            int Oo2 = jsonReader.Oo(f3117oIX0oI);
            if (Oo2 != 0) {
                if (Oo2 != 1) {
                    if (Oo2 != 2) {
                        if (Oo2 != 3) {
                            jsonReader.Oxx0xo();
                        } else {
                            z = jsonReader.Oxx0IOOO();
                        }
                    } else {
                        oOXIXo = oxoX.OOXIXo(jsonReader, oxx0IOOO);
                    }
                } else {
                    i = jsonReader.xxIXOIIO();
                }
            } else {
                str = jsonReader.OOXIXo();
            }
        }
        return new IXxxXO.xoIox(str, i, oOXIXo, z);
    }
}
