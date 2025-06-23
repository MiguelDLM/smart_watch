package OxxIIOOXO;

import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public class x0XOIxOo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static JsonReader.oIX0oI f3114oIX0oI = JsonReader.oIX0oI.oIX0oI("nm", "g", "o", "t", "s", e.TAG, IAdInterListener.AdReqParam.WIDTH, "lc", "lj", "ml", "hd", "d");

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final JsonReader.oIX0oI f3113II0xO0 = JsonReader.oIX0oI.oIX0oI("p", t.f18411a);

    /* renamed from: I0Io, reason: collision with root package name */
    public static final JsonReader.oIX0oI f3112I0Io = JsonReader.oIX0oI.oIX0oI("n", t.c);

    public static com.airbnb.lottie.model.content.oIX0oI oIX0oI(JsonReader jsonReader, com.airbnb.lottie.Oxx0IOOO oxx0IOOO) throws IOException {
        String str;
        Oo.XO xo2;
        GradientType gradientType;
        ArrayList arrayList = new ArrayList();
        String str2 = null;
        GradientType gradientType2 = null;
        Oo.XO xo3 = null;
        Oo.xxIXOIIO xxixoiio = null;
        Oo.xxIXOIIO xxixoiio2 = null;
        Oo.X0o0xo x0o0xo = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f = 0.0f;
        Oo.X0o0xo x0o0xo2 = null;
        boolean z = false;
        Oo.Oxx0IOOO oxx0IOOO2 = null;
        while (jsonReader.XO()) {
            switch (jsonReader.Oo(f3114oIX0oI)) {
                case 0:
                    str2 = jsonReader.OOXIXo();
                    continue;
                case 1:
                    str = str2;
                    jsonReader.I0Io();
                    int i = -1;
                    while (jsonReader.XO()) {
                        int Oo2 = jsonReader.Oo(f3113II0xO0);
                        if (Oo2 != 0) {
                            xo2 = xo3;
                            if (Oo2 != 1) {
                                jsonReader.IXxxXO();
                                jsonReader.Oxx0xo();
                            } else {
                                xo3 = oxoX.Oxx0IOOO(jsonReader, oxx0IOOO, i);
                            }
                        } else {
                            xo2 = xo3;
                            i = jsonReader.xxIXOIIO();
                        }
                        xo3 = xo2;
                    }
                    jsonReader.X0o0xo();
                    break;
                case 2:
                    oxx0IOOO2 = oxoX.II0XooXoX(jsonReader, oxx0IOOO);
                    continue;
                case 3:
                    str = str2;
                    if (jsonReader.xxIXOIIO() == 1) {
                        gradientType = GradientType.LINEAR;
                    } else {
                        gradientType = GradientType.RADIAL;
                    }
                    gradientType2 = gradientType;
                    break;
                case 4:
                    xxixoiio = oxoX.xxIXOIIO(jsonReader, oxx0IOOO);
                    continue;
                case 5:
                    xxixoiio2 = oxoX.xxIXOIIO(jsonReader, oxx0IOOO);
                    continue;
                case 6:
                    x0o0xo = oxoX.X0o0xo(jsonReader, oxx0IOOO);
                    continue;
                case 7:
                    str = str2;
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.xxIXOIIO() - 1];
                    break;
                case 8:
                    str = str2;
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.xxIXOIIO() - 1];
                    break;
                case 9:
                    str = str2;
                    f = (float) jsonReader.II0XooXoX();
                    break;
                case 10:
                    z = jsonReader.Oxx0IOOO();
                    continue;
                case 11:
                    jsonReader.II0xO0();
                    while (jsonReader.XO()) {
                        jsonReader.I0Io();
                        String str3 = null;
                        Oo.X0o0xo x0o0xo3 = null;
                        while (jsonReader.XO()) {
                            int Oo3 = jsonReader.Oo(f3112I0Io);
                            if (Oo3 != 0) {
                                Oo.X0o0xo x0o0xo4 = x0o0xo2;
                                if (Oo3 != 1) {
                                    jsonReader.IXxxXO();
                                    jsonReader.Oxx0xo();
                                } else {
                                    x0o0xo3 = oxoX.X0o0xo(jsonReader, oxx0IOOO);
                                }
                                x0o0xo2 = x0o0xo4;
                            } else {
                                str3 = jsonReader.OOXIXo();
                            }
                        }
                        Oo.X0o0xo x0o0xo5 = x0o0xo2;
                        jsonReader.X0o0xo();
                        if (str3.equals("o")) {
                            x0o0xo2 = x0o0xo3;
                        } else {
                            if (str3.equals("d") || str3.equals("g")) {
                                oxx0IOOO.xoXoI(true);
                                arrayList.add(x0o0xo3);
                            }
                            x0o0xo2 = x0o0xo5;
                        }
                    }
                    Oo.X0o0xo x0o0xo6 = x0o0xo2;
                    jsonReader.oxoX();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    x0o0xo2 = x0o0xo6;
                    continue;
                default:
                    jsonReader.IXxxXO();
                    jsonReader.Oxx0xo();
                    continue;
            }
            str2 = str;
        }
        String str4 = str2;
        if (oxx0IOOO2 == null) {
            oxx0IOOO2 = new Oo.Oxx0IOOO(Collections.singletonList(new xoXoI.oIX0oI(100)));
        }
        return new com.airbnb.lottie.model.content.oIX0oI(str4, gradientType2, xo3, oxx0IOOO2, xxixoiio, xxixoiio2, x0o0xo, lineCapType, lineJoinType, f, arrayList, x0o0xo2, z);
    }
}
