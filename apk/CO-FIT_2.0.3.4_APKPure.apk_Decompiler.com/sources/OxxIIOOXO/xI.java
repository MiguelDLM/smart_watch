package OxxIIOOXO;

import IXxxXO.xoIox;
import Oo.OOXIXo;
import com.airbnb.lottie.Oxx0IOOO;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.IOException;

public class xI {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static JsonReader.oIX0oI f220oIX0oI = JsonReader.oIX0oI.oIX0oI("nm", "ind", MediationConstant.ADN_KS, "hd");

    public static xoIox oIX0oI(JsonReader jsonReader, Oxx0IOOO oxx0IOOO) throws IOException {
        String str = null;
        OOXIXo oOXIXo = null;
        int i = 0;
        boolean z = false;
        while (jsonReader.XO()) {
            int Oo2 = jsonReader.Oo(f220oIX0oI);
            if (Oo2 == 0) {
                str = jsonReader.OOXIXo();
            } else if (Oo2 == 1) {
                i = jsonReader.xxIXOIIO();
            } else if (Oo2 == 2) {
                oOXIXo = oxoX.OOXIXo(jsonReader, oxx0IOOO);
            } else if (Oo2 != 3) {
                jsonReader.Oxx0xo();
            } else {
                z = jsonReader.Oxx0IOOO();
            }
        }
        return new xoIox(str, i, oOXIXo, z);
    }
}
