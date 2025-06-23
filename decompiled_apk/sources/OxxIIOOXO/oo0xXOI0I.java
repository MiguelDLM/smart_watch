package OxxIIOOXO;

import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public class oo0xXOI0I {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static JsonReader.oIX0oI f3108oIX0oI = JsonReader.oIX0oI.oIX0oI("nm", "c", IAdInterListener.AdReqParam.WIDTH, "o", "lc", "lj", "ml", "hd", "d");

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final JsonReader.oIX0oI f3107II0xO0 = JsonReader.oIX0oI.oIX0oI("n", t.c);

    public static ShapeStroke oIX0oI(JsonReader jsonReader, com.airbnb.lottie.Oxx0IOOO oxx0IOOO) throws IOException {
        Oo.Oxx0IOOO oxx0IOOO2;
        char c;
        ArrayList arrayList = new ArrayList();
        String str = null;
        Oo.X0o0xo x0o0xo = null;
        Oo.oxoX oxox = null;
        Oo.X0o0xo x0o0xo2 = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f = 0.0f;
        boolean z = false;
        Oo.Oxx0IOOO oxx0IOOO3 = null;
        while (jsonReader.XO()) {
            switch (jsonReader.Oo(f3108oIX0oI)) {
                case 0:
                    str = jsonReader.OOXIXo();
                    break;
                case 1:
                    oxox = oxoX.I0Io(jsonReader, oxx0IOOO);
                    break;
                case 2:
                    x0o0xo2 = oxoX.X0o0xo(jsonReader, oxx0IOOO);
                    break;
                case 3:
                    oxx0IOOO3 = oxoX.II0XooXoX(jsonReader, oxx0IOOO);
                    break;
                case 4:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.xxIXOIIO() - 1];
                    break;
                case 5:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.xxIXOIIO() - 1];
                    break;
                case 6:
                    f = (float) jsonReader.II0XooXoX();
                    break;
                case 7:
                    z = jsonReader.Oxx0IOOO();
                    break;
                case 8:
                    jsonReader.II0xO0();
                    while (jsonReader.XO()) {
                        jsonReader.I0Io();
                        String str2 = null;
                        Oo.X0o0xo x0o0xo3 = null;
                        while (jsonReader.XO()) {
                            int Oo2 = jsonReader.Oo(f3107II0xO0);
                            if (Oo2 != 0) {
                                if (Oo2 != 1) {
                                    jsonReader.IXxxXO();
                                    jsonReader.Oxx0xo();
                                } else {
                                    x0o0xo3 = oxoX.X0o0xo(jsonReader, oxx0IOOO);
                                }
                            } else {
                                str2 = jsonReader.OOXIXo();
                            }
                        }
                        jsonReader.X0o0xo();
                        str2.hashCode();
                        switch (str2.hashCode()) {
                            case 100:
                                if (str2.equals("d")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 103:
                                if (str2.equals("g")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 111:
                                if (str2.equals("o")) {
                                    c = 2;
                                    break;
                                }
                                break;
                        }
                        c = 65535;
                        switch (c) {
                            case 0:
                            case 1:
                                oxx0IOOO.xoXoI(true);
                                arrayList.add(x0o0xo3);
                                break;
                            case 2:
                                x0o0xo = x0o0xo3;
                                break;
                        }
                    }
                    jsonReader.oxoX();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                    break;
                default:
                    jsonReader.Oxx0xo();
                    break;
            }
        }
        if (oxx0IOOO3 == null) {
            oxx0IOOO2 = new Oo.Oxx0IOOO(Collections.singletonList(new xoXoI.oIX0oI(100)));
        } else {
            oxx0IOOO2 = oxx0IOOO3;
        }
        return new ShapeStroke(str, x0o0xo, arrayList, oxox, oxx0IOOO2, x0o0xo2, lineCapType, lineJoinType, f, z);
    }
}
