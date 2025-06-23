package OxxIIOOXO;

import IIXOooo.XO;
import IIXOooo.xoIox;
import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.OOXIXo;
import com.airbnb.lottie.Oxx0IOOO;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import x0xO0oo.I0Io;
import x0xO0oo.II0xO0;

public class OxxIIOOXO {

    /* renamed from: I0Io  reason: collision with root package name */
    public static final JsonReader.oIX0oI f192I0Io = JsonReader.oIX0oI.oIX0oI("list");

    /* renamed from: II0xO0  reason: collision with root package name */
    public static JsonReader.oIX0oI f193II0xO0 = JsonReader.oIX0oI.oIX0oI("id", "layers", IAdInterListener.AdReqParam.WIDTH, IAdInterListener.AdReqParam.HEIGHT, "p", t.i);

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static final JsonReader.oIX0oI f194oIX0oI = JsonReader.oIX0oI.oIX0oI(IAdInterListener.AdReqParam.WIDTH, IAdInterListener.AdReqParam.HEIGHT, "ip", "op", "fr", t.c, "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: oxoX  reason: collision with root package name */
    public static final JsonReader.oIX0oI f195oxoX = JsonReader.oIX0oI.oIX0oI("cm", "tm", "dr");

    public static void I0Io(JsonReader jsonReader, Oxx0IOOO oxx0IOOO, SparseArrayCompat<I0Io> sparseArrayCompat) throws IOException {
        jsonReader.II0xO0();
        while (jsonReader.XO()) {
            I0Io oIX0oI2 = xoIox.oIX0oI(jsonReader, oxx0IOOO);
            sparseArrayCompat.put(oIX0oI2.hashCode(), oIX0oI2);
        }
        jsonReader.oxoX();
    }

    public static void II0xO0(JsonReader jsonReader, Oxx0IOOO oxx0IOOO, Map<String, List<Layer>> map, Map<String, OOXIXo> map2) throws IOException {
        jsonReader.II0xO0();
        while (jsonReader.XO()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.I0Io();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i = 0;
            int i2 = 0;
            while (jsonReader.XO()) {
                int Oo2 = jsonReader.Oo(f193II0xO0);
                if (Oo2 == 0) {
                    str = jsonReader.OOXIXo();
                } else if (Oo2 == 1) {
                    jsonReader.II0xO0();
                    while (jsonReader.XO()) {
                        Layer II0xO02 = oI0IIXIo.II0xO0(jsonReader, oxx0IOOO);
                        longSparseArray.put(II0xO02.II0xO0(), II0xO02);
                        arrayList.add(II0xO02);
                    }
                    jsonReader.oxoX();
                } else if (Oo2 == 2) {
                    i = jsonReader.xxIXOIIO();
                } else if (Oo2 == 3) {
                    i2 = jsonReader.xxIXOIIO();
                } else if (Oo2 == 4) {
                    str2 = jsonReader.OOXIXo();
                } else if (Oo2 != 5) {
                    jsonReader.IXxxXO();
                    jsonReader.Oxx0xo();
                } else {
                    str3 = jsonReader.OOXIXo();
                }
            }
            jsonReader.X0o0xo();
            if (str2 != null) {
                OOXIXo oOXIXo = new OOXIXo(i, i2, str, str2, str3);
                map2.put(oOXIXo.X0o0xo(), oOXIXo);
            } else {
                map.put(str, arrayList);
            }
        }
        jsonReader.oxoX();
    }

    public static void X0o0xo(JsonReader jsonReader, Oxx0IOOO oxx0IOOO, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        jsonReader.II0xO0();
        int i = 0;
        while (jsonReader.XO()) {
            Layer II0xO02 = oI0IIXIo.II0xO0(jsonReader, oxx0IOOO);
            if (II0xO02.oxoX() == Layer.LayerType.IMAGE) {
                i++;
            }
            list.add(II0xO02);
            longSparseArray.put(II0xO02.II0xO0(), II0xO02);
            if (i > 4) {
                XO.X0o0xo("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.oxoX();
    }

    public static void XO(JsonReader jsonReader, Oxx0IOOO oxx0IOOO, List<x0xO0oo.Oxx0IOOO> list) throws IOException {
        jsonReader.II0xO0();
        while (jsonReader.XO()) {
            jsonReader.I0Io();
            float f = 0.0f;
            String str = null;
            float f2 = 0.0f;
            while (jsonReader.XO()) {
                int Oo2 = jsonReader.Oo(f195oxoX);
                if (Oo2 == 0) {
                    str = jsonReader.OOXIXo();
                } else if (Oo2 == 1) {
                    f = (float) jsonReader.II0XooXoX();
                } else if (Oo2 != 2) {
                    jsonReader.IXxxXO();
                    jsonReader.Oxx0xo();
                } else {
                    f2 = (float) jsonReader.II0XooXoX();
                }
            }
            jsonReader.X0o0xo();
            list.add(new x0xO0oo.Oxx0IOOO(str, f, f2));
        }
        jsonReader.oxoX();
    }

    public static Oxx0IOOO oIX0oI(JsonReader jsonReader) throws IOException {
        HashMap hashMap;
        ArrayList arrayList;
        JsonReader jsonReader2 = jsonReader;
        float X0o0xo2 = xoIox.X0o0xo();
        LongSparseArray longSparseArray = new LongSparseArray();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
        Oxx0IOOO oxx0IOOO = new Oxx0IOOO();
        jsonReader.I0Io();
        int i = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = 0;
        while (jsonReader.XO()) {
            switch (jsonReader2.Oo(f194oIX0oI)) {
                case 0:
                    HashMap hashMap5 = hashMap4;
                    ArrayList arrayList4 = arrayList3;
                    i = jsonReader.xxIXOIIO();
                    continue;
                case 1:
                    HashMap hashMap6 = hashMap4;
                    ArrayList arrayList5 = arrayList3;
                    i2 = jsonReader.xxIXOIIO();
                    continue;
                case 2:
                    HashMap hashMap7 = hashMap4;
                    ArrayList arrayList6 = arrayList3;
                    f = (float) jsonReader.II0XooXoX();
                    continue;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f2 = ((float) jsonReader.II0XooXoX()) - 0.01f;
                    break;
                case 4:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f3 = (float) jsonReader.II0XooXoX();
                    break;
                case 5:
                    String[] split = jsonReader.OOXIXo().split("\\.");
                    if (xoIox.xoIox(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        break;
                    } else {
                        oxx0IOOO.oIX0oI("Lottie only supports bodymovin >= 4.4.0");
                        continue;
                    }
                case 6:
                    X0o0xo(jsonReader2, oxx0IOOO, arrayList2, longSparseArray);
                    continue;
                case 7:
                    II0xO0(jsonReader2, oxx0IOOO, hashMap2, hashMap3);
                    continue;
                case 8:
                    oxoX(jsonReader2, hashMap4);
                    continue;
                case 9:
                    I0Io(jsonReader2, oxx0IOOO, sparseArrayCompat);
                    continue;
                case 10:
                    XO(jsonReader2, oxx0IOOO, arrayList3);
                    continue;
                default:
                    jsonReader.IXxxXO();
                    jsonReader.Oxx0xo();
                    continue;
            }
            hashMap4 = hashMap;
            arrayList3 = arrayList;
            jsonReader2 = jsonReader;
        }
        ArrayList arrayList7 = arrayList3;
        oxx0IOOO.OxxIIOOXO(new Rect(0, 0, (int) (((float) i) * X0o0xo2), (int) (((float) i2) * X0o0xo2)), f, f2, f3, arrayList2, longSparseArray, hashMap2, hashMap3, sparseArrayCompat, hashMap4, arrayList3);
        return oxx0IOOO;
    }

    public static void oxoX(JsonReader jsonReader, Map<String, II0xO0> map) throws IOException {
        jsonReader.I0Io();
        while (jsonReader.XO()) {
            if (jsonReader.Oo(f192I0Io) != 0) {
                jsonReader.IXxxXO();
                jsonReader.Oxx0xo();
            } else {
                jsonReader.II0xO0();
                while (jsonReader.XO()) {
                    II0xO0 oIX0oI2 = OOXIXo.oIX0oI(jsonReader);
                    map.put(oIX0oI2.I0Io(), oIX0oI2);
                }
                jsonReader.oxoX();
            }
        }
        jsonReader.X0o0xo();
    }
}
