package OxxIIOOXO;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class IIXOooo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static JsonReader.oIX0oI f3078oIX0oI = JsonReader.oIX0oI.oIX0oI(IAdInterListener.AdReqParam.WIDTH, IAdInterListener.AdReqParam.HEIGHT, "ip", "op", "fr", t.c, "layers", "assets", "fonts", "chars", "markers");

    public static void II0xO0(JsonReader jsonReader, com.airbnb.lottie.Oxx0IOOO oxx0IOOO, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
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
                IIXOooo.XO.X0o0xo("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.oxoX();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0043. Please report as an issue. */
    public static com.airbnb.lottie.Oxx0IOOO oIX0oI(JsonReader jsonReader) throws IOException {
        HashMap hashMap;
        ArrayList arrayList;
        JsonReader jsonReader2 = jsonReader;
        float X0o0xo2 = IIXOooo.xoIox.X0o0xo();
        LongSparseArray<Layer> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat<x0xO0oo.I0Io> sparseArrayCompat = new SparseArrayCompat<>();
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO = new com.airbnb.lottie.Oxx0IOOO();
        jsonReader.I0Io();
        int i = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = 0;
        while (jsonReader.XO()) {
            switch (jsonReader2.Oo(f3078oIX0oI)) {
                case 0:
                    i = jsonReader.xxIXOIIO();
                    break;
                case 1:
                    i2 = jsonReader.xxIXOIIO();
                    break;
                case 2:
                    f = (float) jsonReader.II0XooXoX();
                    break;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f2 = ((float) jsonReader.II0XooXoX()) - 0.01f;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 4:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f3 = (float) jsonReader.II0XooXoX();
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 5:
                    String[] split = jsonReader.OOXIXo().split("\\.");
                    if (!IIXOooo.xoIox.xoIox(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        oxx0IOOO.oIX0oI("Lottie only supports bodymovin >= 4.4.0");
                        break;
                    } else {
                        break;
                    }
                case 6:
                    II0xO0(jsonReader2, oxx0IOOO, arrayList2, longSparseArray);
                default:
                    jsonReader.Oxx0xo();
                    break;
            }
            jsonReader2 = jsonReader;
        }
        oxx0IOOO.OxxIIOOXO(new Rect(0, 0, (int) (i * X0o0xo2), (int) (i2 * X0o0xo2)), f, f2, f3, arrayList2, longSparseArray, hashMap2, hashMap3, sparseArrayCompat, hashMap4, arrayList3);
        return oxx0IOOO;
    }
}
