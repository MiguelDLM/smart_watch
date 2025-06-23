package OxxIIOOXO;

import IIXOooo.xoIox;
import IXxxXO.II0xO0;
import Oo.X0o0xo;
import Oo.oO;
import Oo.ooOOo0oXI;
import Oo.x0XOIxOo;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.animation.Interpolator;
import com.airbnb.lottie.Oxx0IOOO;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.facebook.appevents.UserDataStore;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class oI0IIXIo {

    /* renamed from: I0Io  reason: collision with root package name */
    public static final JsonReader.oIX0oI f203I0Io = JsonReader.oIX0oI.oIX0oI("nm");

    /* renamed from: II0xO0  reason: collision with root package name */
    public static final JsonReader.oIX0oI f204II0xO0 = JsonReader.oIX0oI.oIX0oI("d", "a");

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static final JsonReader.oIX0oI f205oIX0oI = JsonReader.oIX0oI.oIX0oI("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", MediationConstant.ADN_KS, TtmlNode.TAG_TT, "masksProperties", "shapes", "t", "ef", "sr", UserDataStore.STATE, IAdInterListener.AdReqParam.WIDTH, IAdInterListener.AdReqParam.HEIGHT, "ip", "op", "tm", "cl", "hd");

    public static /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI  reason: collision with root package name */
        public static final /* synthetic */ int[] f206oIX0oI;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.airbnb.lottie.model.layer.Layer$MatteType[] r0 = com.airbnb.lottie.model.layer.Layer.MatteType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f206oIX0oI = r0
                com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.LUMA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f206oIX0oI     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.LUMA_INVERTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: OxxIIOOXO.oI0IIXIo.oIX0oI.<clinit>():void");
        }
    }

    public static Layer II0xO0(JsonReader jsonReader, Oxx0IOOO oxx0IOOO) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        JsonReader jsonReader2 = jsonReader;
        Oxx0IOOO oxx0IOOO2 = oxx0IOOO;
        Layer.MatteType matteType = Layer.MatteType.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader.I0Io();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        Layer.MatteType matteType2 = matteType;
        String str = "UNSET";
        String str2 = null;
        oO oOVar = null;
        ooOOo0oXI ooooo0oxi = null;
        x0XOIxOo x0xoixoo = null;
        X0o0xo x0o0xo = null;
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
            switch (jsonReader2.Oo(f205oIX0oI)) {
                case 0:
                    str = jsonReader.OOXIXo();
                    break;
                case 1:
                    j = (long) jsonReader.xxIXOIIO();
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
                    j2 = (long) jsonReader.xxIXOIIO();
                    break;
                case 5:
                    i = (int) (((float) jsonReader.xxIXOIIO()) * xoIox.X0o0xo());
                    break;
                case 6:
                    i2 = (int) (((float) jsonReader.xxIXOIIO()) * xoIox.X0o0xo());
                    break;
                case 7:
                    i3 = Color.parseColor(jsonReader.OOXIXo());
                    break;
                case 8:
                    oOVar = I0Io.Oxx0IOOO(jsonReader, oxx0IOOO);
                    break;
                case 9:
                    int xxIXOIIO3 = jsonReader.xxIXOIIO();
                    if (xxIXOIIO3 < Layer.MatteType.values().length) {
                        matteType2 = Layer.MatteType.values()[xxIXOIIO3];
                        int i6 = oIX0oI.f206oIX0oI[matteType2.ordinal()];
                        if (i6 == 1) {
                            oxx0IOOO2.oIX0oI("Unsupported matte type: Luma");
                        } else if (i6 == 2) {
                            oxx0IOOO2.oIX0oI("Unsupported matte type: Luma Inverted");
                        }
                        oxx0IOOO2.oI0IIXIo(1);
                        break;
                    } else {
                        oxx0IOOO2.oIX0oI("Unsupported matte type: " + xxIXOIIO3);
                        break;
                    }
                case 10:
                    jsonReader.II0xO0();
                    while (jsonReader.XO()) {
                        arrayList3.add(xoXoI.oIX0oI(jsonReader, oxx0IOOO));
                    }
                    oxx0IOOO2.oI0IIXIo(arrayList3.size());
                    jsonReader.oxoX();
                    break;
                case 11:
                    jsonReader.II0xO0();
                    while (jsonReader.XO()) {
                        II0xO0 oIX0oI2 = Oxx0IOOO.oIX0oI(jsonReader, oxx0IOOO);
                        if (oIX0oI2 != null) {
                            arrayList4.add(oIX0oI2);
                        }
                    }
                    jsonReader.oxoX();
                    break;
                case 12:
                    jsonReader.I0Io();
                    while (jsonReader.XO()) {
                        int Oo2 = jsonReader2.Oo(f204II0xO0);
                        if (Oo2 == 0) {
                            ooooo0oxi = oxoX.oxoX(jsonReader, oxx0IOOO);
                        } else if (Oo2 != 1) {
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
                    }
                    jsonReader.X0o0xo();
                    break;
                case 13:
                    jsonReader.II0xO0();
                    ArrayList arrayList5 = new ArrayList();
                    while (jsonReader.XO()) {
                        jsonReader.I0Io();
                        while (jsonReader.XO()) {
                            if (jsonReader2.Oo(f203I0Io) != 0) {
                                jsonReader.IXxxXO();
                                jsonReader.Oxx0xo();
                            } else {
                                arrayList5.add(jsonReader.OOXIXo());
                            }
                        }
                        jsonReader.X0o0xo();
                    }
                    jsonReader.oxoX();
                    oxx0IOOO2.oIX0oI("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    f3 = (float) jsonReader.II0XooXoX();
                    break;
                case 15:
                    f4 = (float) jsonReader.II0XooXoX();
                    break;
                case 16:
                    i4 = (int) (((float) jsonReader.xxIXOIIO()) * xoIox.X0o0xo());
                    break;
                case 17:
                    i5 = (int) (((float) jsonReader.xxIXOIIO()) * xoIox.X0o0xo());
                    break;
                case 18:
                    f = (float) jsonReader.II0XooXoX();
                    break;
                case 19:
                    f2 = (float) jsonReader.II0XooXoX();
                    break;
                case 20:
                    x0o0xo = oxoX.XO(jsonReader2, oxx0IOOO2, false);
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
            xoXoI.oIX0oI oix0oi = r0;
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            xoXoI.oIX0oI oix0oi2 = new xoXoI.oIX0oI(oxx0IOOO, valueOf2, valueOf2, (Interpolator) null, 0.0f, Float.valueOf(f5));
            arrayList2.add(oix0oi);
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
        }
        if (f6 <= 0.0f) {
            f6 = oxx0IOOO.XO();
        }
        Oxx0IOOO oxx0IOOO3 = oxx0IOOO;
        arrayList2.add(new xoXoI.oIX0oI(oxx0IOOO3, valueOf, valueOf, (Interpolator) null, f5, Float.valueOf(f6)));
        arrayList2.add(new xoXoI.oIX0oI(oxx0IOOO3, valueOf2, valueOf2, (Interpolator) null, f6, Float.valueOf(Float.MAX_VALUE)));
        if (str.endsWith(".ai") || "ai".equals(str3)) {
            oxx0IOOO2.oIX0oI("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList4, oxx0IOOO, str, j, layerType, j2, str2, arrayList, oOVar, i, i2, i3, f3, f4, i4, i5, ooooo0oxi, x0xoixoo, arrayList2, matteType2, x0o0xo, z);
    }

    public static Layer oIX0oI(Oxx0IOOO oxx0IOOO) {
        Rect II0xO02 = oxx0IOOO.II0xO0();
        List emptyList = Collections.emptyList();
        Layer.LayerType layerType = Layer.LayerType.PRE_COMP;
        List emptyList2 = Collections.emptyList();
        oO oOVar = r4;
        oO oOVar2 = new oO();
        return new Layer(emptyList, oxx0IOOO, "__container", -1, layerType, -1, (String) null, emptyList2, oOVar, 0, 0, 0, 0.0f, 0.0f, II0xO02.width(), II0xO02.height(), (ooOOo0oXI) null, (x0XOIxOo) null, Collections.emptyList(), Layer.MatteType.NONE, (X0o0xo) null, false);
    }
}
