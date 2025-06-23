package OxxIIOOXO;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class xoIox {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final JsonReader.oIX0oI f3121oIX0oI = JsonReader.oIX0oI.oIX0oI("ch", MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE, IAdInterListener.AdReqParam.WIDTH, "style", "fFamily", "data");

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final JsonReader.oIX0oI f3120II0xO0 = JsonReader.oIX0oI.oIX0oI("shapes");

    public static x0xO0oo.I0Io oIX0oI(JsonReader jsonReader, com.airbnb.lottie.Oxx0IOOO oxx0IOOO) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.I0Io();
        double d = 0.0d;
        String str = null;
        String str2 = null;
        double d2 = 0.0d;
        char c = 0;
        while (jsonReader.XO()) {
            int Oo2 = jsonReader.Oo(f3121oIX0oI);
            if (Oo2 != 0) {
                if (Oo2 != 1) {
                    if (Oo2 != 2) {
                        if (Oo2 != 3) {
                            if (Oo2 != 4) {
                                if (Oo2 != 5) {
                                    jsonReader.IXxxXO();
                                    jsonReader.Oxx0xo();
                                } else {
                                    jsonReader.I0Io();
                                    while (jsonReader.XO()) {
                                        if (jsonReader.Oo(f3120II0xO0) != 0) {
                                            jsonReader.IXxxXO();
                                            jsonReader.Oxx0xo();
                                        } else {
                                            jsonReader.II0xO0();
                                            while (jsonReader.XO()) {
                                                arrayList.add((IXxxXO.xxIXOIIO) Oxx0IOOO.oIX0oI(jsonReader, oxx0IOOO));
                                            }
                                            jsonReader.oxoX();
                                        }
                                    }
                                    jsonReader.X0o0xo();
                                }
                            } else {
                                str2 = jsonReader.OOXIXo();
                            }
                        } else {
                            str = jsonReader.OOXIXo();
                        }
                    } else {
                        d = jsonReader.II0XooXoX();
                    }
                } else {
                    d2 = jsonReader.II0XooXoX();
                }
            } else {
                c = jsonReader.OOXIXo().charAt(0);
            }
        }
        jsonReader.X0o0xo();
        return new x0xO0oo.I0Io(arrayList, c, d2, d, str, str2);
    }
}
