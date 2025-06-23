package OxxIIOOXO;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.facebook.appevents.UserDataStore;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public class oI0IIXIo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final JsonReader.oIX0oI f3102oIX0oI = JsonReader.oIX0oI.oIX0oI("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", MediationConstant.ADN_KS, TtmlNode.TAG_TT, "masksProperties", "shapes", "t", "ef", "sr", UserDataStore.STATE, IAdInterListener.AdReqParam.WIDTH, IAdInterListener.AdReqParam.HEIGHT, "ip", "op", "tm", "cl", "hd");

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final JsonReader.oIX0oI f3101II0xO0 = JsonReader.oIX0oI.oIX0oI("d", "a");

    /* renamed from: I0Io, reason: collision with root package name */
    public static final JsonReader.oIX0oI f3100I0Io = JsonReader.oIX0oI.oIX0oI("nm");

    /* loaded from: classes.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f3103oIX0oI;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f3103oIX0oI = iArr;
            try {
                iArr[Layer.MatteType.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3103oIX0oI[Layer.MatteType.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static Layer II0xO0(JsonReader jsonReader, com.airbnb.lottie.Oxx0IOOO oxx0IOOO) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        Layer.MatteType matteType = Layer.MatteType.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader.I0Io();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        Layer.MatteType matteType2 = matteType;
        String str = "UNSET";
        String str2 = null;
        Oo.oO oOVar = null;
        Oo.ooOOo0oXI ooooo0oxi = null;
        Oo.x0XOIxOo x0xoixoo = null;
        Oo.X0o0xo x0o0xo = null;
        long j = 0;
        long j2 = -1;
        float f = 0.0f;
        float f2 = 0.0f;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        float f3 = 1.0f;
        float f4 = 0.0f;
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        String str3 = null;
        Layer.LayerType layerType = null;
        while (jsonReader.XO()) {
            switch (jsonReader.Oo(f3102oIX0oI)) {
                case 0:
                    str = jsonReader.OOXIXo();
                    break;
                case 1:
                    j = jsonReader.xxIXOIIO();
                    break;
                case 2:
                    str2 = jsonReader.OOXIXo();
                    break;
                case 3:
                    int xxIXOIIO2 = jsonReader.xxIXOIIO();
                    layerType = Layer.LayerType.UNKNOWN;
                    if (xxIXOIIO2 >= layerType.ordinal()) {
                        break;
                    } else {
                        layerType = Layer.LayerType.values()[xxIXOIIO2];
                        break;
                    }
                case 4:
                    j2 = jsonReader.xxIXOIIO();
                    break;
                case 5:
                    i = (int) (jsonReader.xxIXOIIO() * IIXOooo.xoIox.X0o0xo());
                    break;
                case 6:
                    i2 = (int) (jsonReader.xxIXOIIO() * IIXOooo.xoIox.X0o0xo());
                    break;
                case 7:
                    i3 = Color.parseColor(jsonReader.OOXIXo());
                    break;
                case 8:
                    oOVar = I0Io.Oxx0IOOO(jsonReader, oxx0IOOO);
                    break;
                case 9:
                    int xxIXOIIO3 = jsonReader.xxIXOIIO();
                    if (xxIXOIIO3 >= Layer.MatteType.values().length) {
                        oxx0IOOO.oIX0oI("Unsupported matte type: " + xxIXOIIO3);
                        break;
                    } else {
                        matteType2 = Layer.MatteType.values()[xxIXOIIO3];
                        int i6 = oIX0oI.f3103oIX0oI[matteType2.ordinal()];
                        if (i6 != 1) {
                            if (i6 == 2) {
                                oxx0IOOO.oIX0oI("Unsupported matte type: Luma Inverted");
                            }
                        } else {
                            oxx0IOOO.oIX0oI("Unsupported matte type: Luma");
                        }
                        oxx0IOOO.oI0IIXIo(1);
                        break;
                    }
                case 10:
                    jsonReader.II0xO0();
                    while (jsonReader.XO()) {
                        arrayList3.add(xoXoI.oIX0oI(jsonReader, oxx0IOOO));
                    }
                    oxx0IOOO.oI0IIXIo(arrayList3.size());
                    jsonReader.oxoX();
                    break;
                case 11:
                    jsonReader.II0xO0();
                    while (jsonReader.XO()) {
                        IXxxXO.II0xO0 oIX0oI2 = Oxx0IOOO.oIX0oI(jsonReader, oxx0IOOO);
                        if (oIX0oI2 != null) {
                            arrayList4.add(oIX0oI2);
                        }
                    }
                    jsonReader.oxoX();
                    break;
                case 12:
                    jsonReader.I0Io();
                    while (jsonReader.XO()) {
                        int Oo2 = jsonReader.Oo(f3101II0xO0);
                        if (Oo2 != 0) {
                            if (Oo2 != 1) {
                                jsonReader.IXxxXO();
                                jsonReader.Oxx0xo();
                            } else {
                                jsonReader.II0xO0();
                                if (jsonReader.XO()) {
                                    x0xoixoo = II0xO0.oIX0oI(jsonReader, oxx0IOOO);
                                }
                                while (jsonReader.XO()) {
                                    jsonReader.Oxx0xo();
                                }
                                jsonReader.oxoX();
                            }
                        } else {
                            ooooo0oxi = oxoX.oxoX(jsonReader, oxx0IOOO);
                        }
                    }
                    jsonReader.X0o0xo();
                    break;
                case 13:
                    jsonReader.II0xO0();
                    ArrayList arrayList5 = new ArrayList();
                    while (jsonReader.XO()) {
                        jsonReader.I0Io();
                        while (jsonReader.XO()) {
                            if (jsonReader.Oo(f3100I0Io) != 0) {
                                jsonReader.IXxxXO();
                                jsonReader.Oxx0xo();
                            } else {
                                arrayList5.add(jsonReader.OOXIXo());
                            }
                        }
                        jsonReader.X0o0xo();
                    }
                    jsonReader.oxoX();
                    oxx0IOOO.oIX0oI("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    f3 = (float) jsonReader.II0XooXoX();
                    break;
                case 15:
                    f4 = (float) jsonReader.II0XooXoX();
                    break;
                case 16:
                    i4 = (int) (jsonReader.xxIXOIIO() * IIXOooo.xoIox.X0o0xo());
                    break;
                case 17:
                    i5 = (int) (jsonReader.xxIXOIIO() * IIXOooo.xoIox.X0o0xo());
                    break;
                case 18:
                    f = (float) jsonReader.II0XooXoX();
                    break;
                case 19:
                    f2 = (float) jsonReader.II0XooXoX();
                    break;
                case 20:
                    x0o0xo = oxoX.XO(jsonReader, oxx0IOOO, false);
                    break;
                case 21:
                    str3 = jsonReader.OOXIXo();
                    break;
                case 22:
                    z = jsonReader.Oxx0IOOO();
                    break;
                default:
                    jsonReader.IXxxXO();
                    jsonReader.Oxx0xo();
                    break;
            }
        }
        jsonReader.X0o0xo();
        float f5 = f / f3;
        float f6 = f2 / f3;
        ArrayList arrayList6 = new ArrayList();
        if (f5 > 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new xoXoI.oIX0oI(oxx0IOOO, valueOf2, valueOf2, null, 0.0f, Float.valueOf(f5)));
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
        }
        if (f6 <= 0.0f) {
            f6 = oxx0IOOO.XO();
        }
        arrayList2.add(new xoXoI.oIX0oI(oxx0IOOO, valueOf, valueOf, null, f5, Float.valueOf(f6)));
        arrayList2.add(new xoXoI.oIX0oI(oxx0IOOO, valueOf2, valueOf2, null, f6, Float.valueOf(Float.MAX_VALUE)));
        if (str.endsWith(".ai") || "ai".equals(str3)) {
            oxx0IOOO.oIX0oI("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList4, oxx0IOOO, str, j, layerType, j2, str2, arrayList, oOVar, i, i2, i3, f3, f4, i4, i5, ooooo0oxi, x0xoixoo, arrayList2, matteType2, x0o0xo, z);
    }

    public static Layer oIX0oI(com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
        Rect II0xO02 = oxx0IOOO.II0xO0();
        return new Layer(Collections.emptyList(), oxx0IOOO, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, Collections.emptyList(), new Oo.oO(), 0, 0, 0, 0.0f, 0.0f, II0xO02.width(), II0xO02.height(), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false);
    }
}
