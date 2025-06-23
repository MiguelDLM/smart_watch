package OxxIIOOXO;

import IIXOooo.xoIox;
import IIXOooo.xxIXOIIO;
import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.Oxx0IOOO;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kwad.sdk.m.e;
import java.io.IOException;
import java.lang.ref.WeakReference;
import xoXoI.oIX0oI;

public class IXxxXO {

    /* renamed from: I0Io  reason: collision with root package name */
    public static SparseArrayCompat<WeakReference<Interpolator>> f182I0Io = null;

    /* renamed from: II0xO0  reason: collision with root package name */
    public static final Interpolator f183II0xO0 = new LinearInterpolator();

    /* renamed from: X0o0xo  reason: collision with root package name */
    public static JsonReader.oIX0oI f184X0o0xo = JsonReader.oIX0oI.oIX0oI("x", "y");

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static final float f185oIX0oI = 100.0f;

    /* renamed from: oxoX  reason: collision with root package name */
    public static JsonReader.oIX0oI f186oxoX = JsonReader.oIX0oI.oIX0oI("t", "s", e.TAG, "o", "i", IAdInterListener.AdReqParam.HEIGHT, "to", "ti");

    public static <T> oIX0oI<T> I0Io(JsonReader jsonReader, Oxx0IOOO oxx0IOOO, float f, oOXoIIIo<T> ooxoiiio, boolean z, boolean z2) throws IOException {
        if (z && z2) {
            return X0o0xo(oxx0IOOO, jsonReader, f, ooxoiiio);
        }
        if (z) {
            return oxoX(oxx0IOOO, jsonReader, f, ooxoiiio);
        }
        return XO(jsonReader, f, ooxoiiio);
    }

    public static void II0XooXoX(int i, WeakReference<Interpolator> weakReference) {
        synchronized (IXxxXO.class) {
            f182I0Io.put(i, weakReference);
        }
    }

    public static Interpolator II0xO0(PointF pointF, PointF pointF2) {
        Interpolator interpolator;
        Interpolator linearInterpolator;
        pointF.x = xxIXOIIO.I0Io(pointF.x, -1.0f, 1.0f);
        pointF.y = xxIXOIIO.I0Io(pointF.y, -100.0f, 100.0f);
        pointF2.x = xxIXOIIO.I0Io(pointF2.x, -1.0f, 1.0f);
        float I0Io2 = xxIXOIIO.I0Io(pointF2.y, -100.0f, 100.0f);
        pointF2.y = I0Io2;
        int xxIXOIIO2 = xoIox.xxIXOIIO(pointF.x, pointF.y, pointF2.x, I0Io2);
        WeakReference<Interpolator> oIX0oI2 = oIX0oI(xxIXOIIO2);
        if (oIX0oI2 != null) {
            interpolator = oIX0oI2.get();
        } else {
            interpolator = null;
        }
        if (oIX0oI2 == null || interpolator == null) {
            try {
                linearInterpolator = PathInterpolatorCompat.create(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e) {
                if ("The Path cannot loop back on itself.".equals(e.getMessage())) {
                    linearInterpolator = PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            interpolator = linearInterpolator;
            try {
                II0XooXoX(xxIXOIIO2, new WeakReference(interpolator));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator;
    }

    public static SparseArrayCompat<WeakReference<Interpolator>> Oxx0IOOO() {
        if (f182I0Io == null) {
            f182I0Io = new SparseArrayCompat<>();
        }
        return f182I0Io;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c6, code lost:
        r14 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> xoXoI.oIX0oI<T> X0o0xo(com.airbnb.lottie.Oxx0IOOO r20, com.airbnb.lottie.parser.moshi.JsonReader r21, float r22, OxxIIOOXO.oOXoIIIo<T> r23) throws java.io.IOException {
        /*
            r0 = r21
            r1 = r22
            r2 = r23
            r21.I0Io()
            r3 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
        L_0x0016:
            boolean r17 = r21.XO()
            if (r17 == 0) goto L_0x017b
            com.airbnb.lottie.parser.moshi.JsonReader$oIX0oI r4 = f186oxoX
            int r4 = r0.Oo(r4)
            r5 = 1
            switch(r4) {
                case 0: goto L_0x0170;
                case 1: goto L_0x0165;
                case 2: goto L_0x015a;
                case 3: goto L_0x00d5;
                case 4: goto L_0x003e;
                case 5: goto L_0x0034;
                case 6: goto L_0x002f;
                case 7: goto L_0x002a;
                default: goto L_0x0026;
            }
        L_0x0026:
            r21.Oxx0xo()
            goto L_0x0016
        L_0x002a:
            android.graphics.PointF r3 = OxxIIOOXO.x0xO0oo.X0o0xo(r21, r22)
            goto L_0x0016
        L_0x002f:
            android.graphics.PointF r15 = OxxIIOOXO.x0xO0oo.X0o0xo(r21, r22)
            goto L_0x0016
        L_0x0034:
            int r4 = r21.xxIXOIIO()
            if (r4 != r5) goto L_0x003c
            r6 = 1
            goto L_0x0016
        L_0x003c:
            r6 = 0
            goto L_0x0016
        L_0x003e:
            com.airbnb.lottie.parser.moshi.JsonReader$Token r4 = r21.x0XOIxOo()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r5 = com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_OBJECT
            if (r4 != r5) goto L_0x00cb
            r21.I0Io()
            r4 = 0
            r5 = 0
            r12 = 0
            r13 = 0
        L_0x004d:
            boolean r18 = r21.XO()
            if (r18 == 0) goto L_0x00b2
            r18 = r15
            com.airbnb.lottie.parser.moshi.JsonReader$oIX0oI r15 = f184X0o0xo
            int r15 = r0.Oo(r15)
            if (r15 == 0) goto L_0x008e
            r19 = r3
            r3 = 1
            if (r15 == r3) goto L_0x006a
            r21.Oxx0xo()
        L_0x0065:
            r15 = r18
            r3 = r19
            goto L_0x004d
        L_0x006a:
            com.airbnb.lottie.parser.moshi.JsonReader$Token r3 = r21.x0XOIxOo()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r5 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r3 != r5) goto L_0x007b
            r3 = r14
            double r13 = r21.II0XooXoX()
            float r13 = (float) r13
            r14 = r3
            r5 = r13
            goto L_0x0065
        L_0x007b:
            r3 = r14
            r21.II0xO0()
            double r13 = r21.II0XooXoX()
            float r5 = (float) r13
            double r13 = r21.II0XooXoX()
            float r13 = (float) r13
            r21.oxoX()
        L_0x008c:
            r14 = r3
            goto L_0x0065
        L_0x008e:
            r19 = r3
            r3 = r14
            com.airbnb.lottie.parser.moshi.JsonReader$Token r4 = r21.x0XOIxOo()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r12 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r4 != r12) goto L_0x00a1
            double r14 = r21.II0XooXoX()
            float r12 = (float) r14
            r14 = r3
            r4 = r12
            goto L_0x0065
        L_0x00a1:
            r21.II0xO0()
            double r14 = r21.II0XooXoX()
            float r4 = (float) r14
            double r14 = r21.II0XooXoX()
            float r12 = (float) r14
            r21.oxoX()
            goto L_0x008c
        L_0x00b2:
            r19 = r3
            r3 = r14
            r18 = r15
            android.graphics.PointF r14 = new android.graphics.PointF
            r14.<init>(r4, r5)
            android.graphics.PointF r4 = new android.graphics.PointF
            r4.<init>(r12, r13)
            r21.X0o0xo()
            r13 = r4
            r12 = r14
        L_0x00c6:
            r14 = r3
        L_0x00c7:
            r3 = r19
            goto L_0x0016
        L_0x00cb:
            r19 = r3
            r3 = r14
            r18 = r15
            android.graphics.PointF r8 = OxxIIOOXO.x0xO0oo.X0o0xo(r21, r22)
            goto L_0x00c7
        L_0x00d5:
            r19 = r3
            r3 = r14
            r18 = r15
            com.airbnb.lottie.parser.moshi.JsonReader$Token r4 = r21.x0XOIxOo()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r5 = com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_OBJECT
            if (r4 != r5) goto L_0x0151
            r21.I0Io()
            r4 = 0
            r5 = 0
            r9 = 0
            r11 = 0
        L_0x00e9:
            boolean r14 = r21.XO()
            if (r14 == 0) goto L_0x013e
            com.airbnb.lottie.parser.moshi.JsonReader$oIX0oI r14 = f184X0o0xo
            int r14 = r0.Oo(r14)
            if (r14 == 0) goto L_0x011e
            r15 = 1
            if (r14 == r15) goto L_0x00fe
            r21.Oxx0xo()
            goto L_0x00e9
        L_0x00fe:
            com.airbnb.lottie.parser.moshi.JsonReader$Token r5 = r21.x0XOIxOo()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r11 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r5 != r11) goto L_0x010d
            double r14 = r21.II0XooXoX()
            float r11 = (float) r14
            r5 = r11
            goto L_0x00e9
        L_0x010d:
            r21.II0xO0()
            double r14 = r21.II0XooXoX()
            float r5 = (float) r14
            double r14 = r21.II0XooXoX()
            float r11 = (float) r14
            r21.oxoX()
            goto L_0x00e9
        L_0x011e:
            com.airbnb.lottie.parser.moshi.JsonReader$Token r4 = r21.x0XOIxOo()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r9 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r4 != r9) goto L_0x012d
            double r14 = r21.II0XooXoX()
            float r9 = (float) r14
            r4 = r9
            goto L_0x00e9
        L_0x012d:
            r21.II0xO0()
            double r14 = r21.II0XooXoX()
            float r4 = (float) r14
            double r14 = r21.II0XooXoX()
            float r9 = (float) r14
            r21.oxoX()
            goto L_0x00e9
        L_0x013e:
            android.graphics.PointF r14 = new android.graphics.PointF
            r14.<init>(r4, r5)
            android.graphics.PointF r4 = new android.graphics.PointF
            r4.<init>(r9, r11)
            r21.X0o0xo()
            r11 = r4
            r9 = r14
            r15 = r18
            goto L_0x00c6
        L_0x0151:
            android.graphics.PointF r7 = OxxIIOOXO.x0xO0oo.X0o0xo(r21, r22)
            r14 = r3
            r15 = r18
            goto L_0x00c7
        L_0x015a:
            r19 = r3
            r3 = r14
            r18 = r15
            java.lang.Object r16 = r2.oIX0oI(r0, r1)
            goto L_0x00c7
        L_0x0165:
            r19 = r3
            r3 = r14
            r18 = r15
            java.lang.Object r10 = r2.oIX0oI(r0, r1)
            goto L_0x00c7
        L_0x0170:
            r19 = r3
            r18 = r15
            double r3 = r21.II0XooXoX()
            float r14 = (float) r3
            goto L_0x00c7
        L_0x017b:
            r19 = r3
            r3 = r14
            r18 = r15
            r21.X0o0xo()
            if (r6 == 0) goto L_0x018b
            android.view.animation.Interpolator r0 = f183II0xO0
            r11 = r10
        L_0x0188:
            r12 = 0
            r13 = 0
            goto L_0x01af
        L_0x018b:
            if (r7 == 0) goto L_0x0196
            if (r8 == 0) goto L_0x0196
            android.view.animation.Interpolator r0 = II0xO0(r7, r8)
        L_0x0193:
            r11 = r16
            goto L_0x0188
        L_0x0196:
            if (r9 == 0) goto L_0x01ac
            if (r11 == 0) goto L_0x01ac
            if (r12 == 0) goto L_0x01ac
            if (r13 == 0) goto L_0x01ac
            android.view.animation.Interpolator r0 = II0xO0(r9, r12)
            android.view.animation.Interpolator r1 = II0xO0(r11, r13)
            r12 = r0
            r13 = r1
            r11 = r16
            r0 = 0
            goto L_0x01af
        L_0x01ac:
            android.view.animation.Interpolator r0 = f183II0xO0
            goto L_0x0193
        L_0x01af:
            if (r12 == 0) goto L_0x01c0
            if (r13 == 0) goto L_0x01c0
            xoXoI.oIX0oI r0 = new xoXoI.oIX0oI
            r15 = 0
            r8 = r0
            r9 = r20
            r14 = r3
            r1 = r18
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            goto L_0x01ce
        L_0x01c0:
            r1 = r18
            xoXoI.oIX0oI r2 = new xoXoI.oIX0oI
            r14 = 0
            r8 = r2
            r9 = r20
            r12 = r0
            r13 = r3
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r0 = r2
        L_0x01ce:
            r0.f1618oO = r1
            r3 = r19
            r0.f1623x0xO0oo = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: OxxIIOOXO.IXxxXO.X0o0xo(com.airbnb.lottie.Oxx0IOOO, com.airbnb.lottie.parser.moshi.JsonReader, float, OxxIIOOXO.oOXoIIIo):xoXoI.oIX0oI");
    }

    public static <T> oIX0oI<T> XO(JsonReader jsonReader, float f, oOXoIIIo<T> ooxoiiio) throws IOException {
        return new oIX0oI<>(ooxoiiio.oIX0oI(jsonReader, f));
    }

    @Nullable
    public static WeakReference<Interpolator> oIX0oI(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (IXxxXO.class) {
            weakReference = Oxx0IOOO().get(i);
        }
        return weakReference;
    }

    public static <T> oIX0oI<T> oxoX(Oxx0IOOO oxx0IOOO, JsonReader jsonReader, float f, oOXoIIIo<T> ooxoiiio) throws IOException {
        Interpolator interpolator;
        T t;
        Interpolator interpolator2;
        jsonReader.I0Io();
        PointF pointF = null;
        PointF pointF2 = null;
        T t2 = null;
        T t3 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        boolean z = false;
        float f2 = 0.0f;
        while (jsonReader.XO()) {
            switch (jsonReader.Oo(f186oxoX)) {
                case 0:
                    f2 = (float) jsonReader.II0XooXoX();
                    break;
                case 1:
                    t3 = ooxoiiio.oIX0oI(jsonReader, f);
                    break;
                case 2:
                    t2 = ooxoiiio.oIX0oI(jsonReader, f);
                    break;
                case 3:
                    pointF = x0xO0oo.X0o0xo(jsonReader, 1.0f);
                    break;
                case 4:
                    pointF2 = x0xO0oo.X0o0xo(jsonReader, 1.0f);
                    break;
                case 5:
                    if (jsonReader.xxIXOIIO() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 6:
                    pointF3 = x0xO0oo.X0o0xo(jsonReader, f);
                    break;
                case 7:
                    pointF4 = x0xO0oo.X0o0xo(jsonReader, f);
                    break;
                default:
                    jsonReader.Oxx0xo();
                    break;
            }
        }
        jsonReader.X0o0xo();
        if (z) {
            interpolator = f183II0xO0;
            t = t3;
        } else {
            if (pointF == null || pointF2 == null) {
                interpolator2 = f183II0xO0;
            } else {
                interpolator2 = II0xO0(pointF, pointF2);
            }
            interpolator = interpolator2;
            t = t2;
        }
        oIX0oI oix0oi = new oIX0oI(oxx0IOOO, t3, t, interpolator, f2, (Float) null);
        oix0oi.f1618oO = pointF3;
        oix0oi.f1623x0xO0oo = pointF4;
        return oix0oi;
    }
}
