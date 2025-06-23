package OxxIIOOXO;

import IIXOooo.XO;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.Oxx0IOOO;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.util.List;

public class IIXOooo {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static JsonReader.oIX0oI f181oIX0oI = JsonReader.oIX0oI.oIX0oI(IAdInterListener.AdReqParam.WIDTH, IAdInterListener.AdReqParam.HEIGHT, "ip", "op", "fr", t.c, "layers", "assets", "fonts", "chars", "markers");

    public static void II0xO0(JsonReader jsonReader, Oxx0IOOO oxx0IOOO, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
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

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x007e, code lost:
        r0 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0089, code lost:
        r12 = r0;
        r13 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x004a, code lost:
        r24.Oxx0xo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.airbnb.lottie.Oxx0IOOO oIX0oI(com.airbnb.lottie.parser.moshi.JsonReader r24) throws java.io.IOException {
        /*
            r0 = r24
            float r1 = IIXOooo.xoIox.X0o0xo()
            androidx.collection.LongSparseArray r8 = new androidx.collection.LongSparseArray
            r8.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            androidx.collection.SparseArrayCompat r11 = new androidx.collection.SparseArrayCompat
            r11.<init>()
            com.airbnb.lottie.Oxx0IOOO r14 = new com.airbnb.lottie.Oxx0IOOO
            r14.<init>()
            r24.I0Io()
            r2 = 0
            r2 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r15 = 0
        L_0x0037:
            boolean r16 = r24.XO()
            if (r16 == 0) goto L_0x00b4
            com.airbnb.lottie.parser.moshi.JsonReader$oIX0oI r3 = f181oIX0oI
            int r3 = r0.Oo(r3)
            switch(r3) {
                case 0: goto L_0x00ac;
                case 1: goto L_0x00a4;
                case 2: goto L_0x009b;
                case 3: goto L_0x008d;
                case 4: goto L_0x0081;
                case 5: goto L_0x004e;
                case 6: goto L_0x0047;
                default: goto L_0x0046;
            }
        L_0x0046:
            goto L_0x004a
        L_0x0047:
            II0xO0(r0, r14, r7, r8)
        L_0x004a:
            r24.Oxx0xo()
            goto L_0x007e
        L_0x004e:
            java.lang.String r3 = r24.OOXIXo()
            java.lang.String r0 = "\\."
            java.lang.String[] r0 = r3.split(r0)
            r3 = 0
            r17 = r0[r3]
            int r18 = java.lang.Integer.parseInt(r17)
            r3 = 1
            r3 = r0[r3]
            int r19 = java.lang.Integer.parseInt(r3)
            r3 = 2
            r0 = r0[r3]
            int r20 = java.lang.Integer.parseInt(r0)
            r22 = 4
            r23 = 0
            r21 = 4
            boolean r0 = IIXOooo.xoIox.xoIox(r18, r19, r20, r21, r22, r23)
            if (r0 != 0) goto L_0x007e
            java.lang.String r0 = "Lottie only supports bodymovin >= 4.4.0"
            r14.oIX0oI(r0)
        L_0x007e:
            r0 = r24
            goto L_0x0037
        L_0x0081:
            r0 = r12
            r17 = r13
            double r12 = r24.II0XooXoX()
            float r6 = (float) r12
        L_0x0089:
            r12 = r0
            r13 = r17
            goto L_0x007e
        L_0x008d:
            r0 = r12
            r17 = r13
            double r12 = r24.II0XooXoX()
            float r3 = (float) r12
            r5 = 1008981770(0x3c23d70a, float:0.01)
            float r5 = r3 - r5
            goto L_0x0089
        L_0x009b:
            r0 = r12
            r17 = r13
            double r3 = r24.II0XooXoX()
            float r4 = (float) r3
            goto L_0x007e
        L_0x00a4:
            r0 = r12
            r17 = r13
            int r15 = r24.xxIXOIIO()
            goto L_0x007e
        L_0x00ac:
            r0 = r12
            r17 = r13
            int r2 = r24.xxIXOIIO()
            goto L_0x007e
        L_0x00b4:
            r0 = r12
            r17 = r13
            float r2 = (float) r2
            float r2 = r2 * r1
            int r2 = (int) r2
            float r3 = (float) r15
            float r3 = r3 * r1
            int r1 = (int) r3
            android.graphics.Rect r3 = new android.graphics.Rect
            r12 = 0
            r3.<init>(r12, r12, r2, r1)
            r2 = r14
            r12 = r0
            r2.OxxIIOOXO(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: OxxIIOOXO.IIXOooo.oIX0oI(com.airbnb.lottie.parser.moshi.JsonReader):com.airbnb.lottie.Oxx0IOOO");
    }
}
