package OxxIIOOXO;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kwad.sdk.m.e;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class IXxxXO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static SparseArrayCompat<WeakReference<Interpolator>> f3079I0Io = null;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final float f3082oIX0oI = 100.0f;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final Interpolator f3080II0xO0 = new LinearInterpolator();

    /* renamed from: oxoX, reason: collision with root package name */
    public static JsonReader.oIX0oI f3083oxoX = JsonReader.oIX0oI.oIX0oI("t", "s", e.TAG, "o", "i", IAdInterListener.AdReqParam.HEIGHT, "to", "ti");

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static JsonReader.oIX0oI f3081X0o0xo = JsonReader.oIX0oI.oIX0oI("x", "y");

    public static <T> xoXoI.oIX0oI<T> I0Io(JsonReader jsonReader, com.airbnb.lottie.Oxx0IOOO oxx0IOOO, float f, oOXoIIIo<T> ooxoiiio, boolean z, boolean z2) throws IOException {
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
            f3079I0Io.put(i, weakReference);
        }
    }

    public static Interpolator II0xO0(PointF pointF, PointF pointF2) {
        Interpolator interpolator;
        Interpolator linearInterpolator;
        pointF.x = IIXOooo.xxIXOIIO.I0Io(pointF.x, -1.0f, 1.0f);
        pointF.y = IIXOooo.xxIXOIIO.I0Io(pointF.y, -100.0f, 100.0f);
        pointF2.x = IIXOooo.xxIXOIIO.I0Io(pointF2.x, -1.0f, 1.0f);
        float I0Io2 = IIXOooo.xxIXOIIO.I0Io(pointF2.y, -100.0f, 100.0f);
        pointF2.y = I0Io2;
        int xxIXOIIO2 = IIXOooo.xoIox.xxIXOIIO(pointF.x, pointF.y, pointF2.x, I0Io2);
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
        if (f3079I0Io == null) {
            f3079I0Io = new SparseArrayCompat<>();
        }
        return f3079I0Io;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0023. Please report as an issue. */
    public static <T> xoXoI.oIX0oI<T> X0o0xo(com.airbnb.lottie.Oxx0IOOO oxx0IOOO, JsonReader jsonReader, float f, oOXoIIIo<T> ooxoiiio) throws IOException {
        Interpolator interpolator;
        Interpolator II0xO02;
        Interpolator II0xO03;
        T t;
        PointF pointF;
        xoXoI.oIX0oI<T> oix0oi;
        PointF pointF2;
        float f2;
        PointF pointF3;
        float f3;
        jsonReader.I0Io();
        PointF pointF4 = null;
        boolean z = false;
        PointF pointF5 = null;
        PointF pointF6 = null;
        PointF pointF7 = null;
        T t2 = null;
        PointF pointF8 = null;
        PointF pointF9 = null;
        PointF pointF10 = null;
        float f4 = 0.0f;
        PointF pointF11 = null;
        T t3 = null;
        while (jsonReader.XO()) {
            switch (jsonReader.Oo(f3083oxoX)) {
                case 0:
                    pointF2 = pointF4;
                    f4 = (float) jsonReader.II0XooXoX();
                    pointF4 = pointF2;
                    break;
                case 1:
                    pointF2 = pointF4;
                    t2 = ooxoiiio.oIX0oI(jsonReader, f);
                    pointF4 = pointF2;
                    break;
                case 2:
                    pointF2 = pointF4;
                    t3 = ooxoiiio.oIX0oI(jsonReader, f);
                    pointF4 = pointF2;
                    break;
                case 3:
                    pointF2 = pointF4;
                    f2 = f4;
                    PointF pointF12 = pointF11;
                    if (jsonReader.x0XOIxOo() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.I0Io();
                        float f5 = 0.0f;
                        float f6 = 0.0f;
                        float f7 = 0.0f;
                        float f8 = 0.0f;
                        while (jsonReader.XO()) {
                            int Oo2 = jsonReader.Oo(f3081X0o0xo);
                            if (Oo2 != 0) {
                                if (Oo2 != 1) {
                                    jsonReader.Oxx0xo();
                                } else if (jsonReader.x0XOIxOo() == JsonReader.Token.NUMBER) {
                                    f8 = (float) jsonReader.II0XooXoX();
                                    f6 = f8;
                                } else {
                                    jsonReader.II0xO0();
                                    f6 = (float) jsonReader.II0XooXoX();
                                    f8 = (float) jsonReader.II0XooXoX();
                                    jsonReader.oxoX();
                                }
                            } else if (jsonReader.x0XOIxOo() == JsonReader.Token.NUMBER) {
                                f7 = (float) jsonReader.II0XooXoX();
                                f5 = f7;
                            } else {
                                jsonReader.II0xO0();
                                f5 = (float) jsonReader.II0XooXoX();
                                f7 = (float) jsonReader.II0XooXoX();
                                jsonReader.oxoX();
                            }
                        }
                        PointF pointF13 = new PointF(f5, f6);
                        PointF pointF14 = new PointF(f7, f8);
                        jsonReader.X0o0xo();
                        pointF8 = pointF14;
                        pointF7 = pointF13;
                        pointF11 = pointF12;
                        f4 = f2;
                        pointF4 = pointF2;
                        break;
                    } else {
                        pointF5 = x0xO0oo.X0o0xo(jsonReader, f);
                        f4 = f2;
                        pointF11 = pointF12;
                        pointF4 = pointF2;
                    }
                case 4:
                    if (jsonReader.x0XOIxOo() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.I0Io();
                        float f9 = 0.0f;
                        float f10 = 0.0f;
                        float f11 = 0.0f;
                        float f12 = 0.0f;
                        while (jsonReader.XO()) {
                            PointF pointF15 = pointF11;
                            int Oo3 = jsonReader.Oo(f3081X0o0xo);
                            if (Oo3 != 0) {
                                pointF3 = pointF4;
                                if (Oo3 != 1) {
                                    jsonReader.Oxx0xo();
                                } else if (jsonReader.x0XOIxOo() == JsonReader.Token.NUMBER) {
                                    f12 = (float) jsonReader.II0XooXoX();
                                    f4 = f4;
                                    f10 = f12;
                                } else {
                                    f3 = f4;
                                    jsonReader.II0xO0();
                                    f10 = (float) jsonReader.II0XooXoX();
                                    f12 = (float) jsonReader.II0XooXoX();
                                    jsonReader.oxoX();
                                    f4 = f3;
                                }
                            } else {
                                pointF3 = pointF4;
                                f3 = f4;
                                if (jsonReader.x0XOIxOo() == JsonReader.Token.NUMBER) {
                                    f11 = (float) jsonReader.II0XooXoX();
                                    f4 = f3;
                                    f9 = f11;
                                } else {
                                    jsonReader.II0xO0();
                                    f9 = (float) jsonReader.II0XooXoX();
                                    f11 = (float) jsonReader.II0XooXoX();
                                    jsonReader.oxoX();
                                    f4 = f3;
                                }
                            }
                            pointF11 = pointF15;
                            pointF4 = pointF3;
                        }
                        pointF2 = pointF4;
                        f2 = f4;
                        PointF pointF16 = new PointF(f9, f10);
                        PointF pointF17 = new PointF(f11, f12);
                        jsonReader.X0o0xo();
                        pointF10 = pointF17;
                        pointF9 = pointF16;
                        f4 = f2;
                        pointF4 = pointF2;
                        break;
                    } else {
                        pointF2 = pointF4;
                        pointF6 = x0xO0oo.X0o0xo(jsonReader, f);
                        pointF4 = pointF2;
                    }
                case 5:
                    if (jsonReader.xxIXOIIO() == 1) {
                        z = true;
                        break;
                    } else {
                        z = false;
                        break;
                    }
                case 6:
                    pointF11 = x0xO0oo.X0o0xo(jsonReader, f);
                    break;
                case 7:
                    pointF4 = x0xO0oo.X0o0xo(jsonReader, f);
                    break;
                default:
                    jsonReader.Oxx0xo();
                    break;
            }
        }
        PointF pointF18 = pointF4;
        float f13 = f4;
        PointF pointF19 = pointF11;
        jsonReader.X0o0xo();
        if (z) {
            interpolator = f3080II0xO0;
            t = t2;
        } else {
            if (pointF5 != null && pointF6 != null) {
                interpolator = II0xO0(pointF5, pointF6);
            } else {
                if (pointF7 != null && pointF8 != null && pointF9 != null && pointF10 != null) {
                    II0xO02 = II0xO0(pointF7, pointF9);
                    II0xO03 = II0xO0(pointF8, pointF10);
                    t = t3;
                    interpolator = null;
                    if (II0xO02 == null && II0xO03 != null) {
                        pointF = pointF19;
                        oix0oi = new xoXoI.oIX0oI<>(oxx0IOOO, t2, t, II0xO02, II0xO03, f13, null);
                    } else {
                        pointF = pointF19;
                        oix0oi = new xoXoI.oIX0oI<>(oxx0IOOO, t2, t, interpolator, f13, null);
                    }
                    oix0oi.f35172oO = pointF;
                    oix0oi.f35177x0xO0oo = pointF18;
                    return oix0oi;
                }
                interpolator = f3080II0xO0;
            }
            t = t3;
        }
        II0xO02 = null;
        II0xO03 = null;
        if (II0xO02 == null) {
        }
        pointF = pointF19;
        oix0oi = new xoXoI.oIX0oI<>(oxx0IOOO, t2, t, interpolator, f13, null);
        oix0oi.f35172oO = pointF;
        oix0oi.f35177x0xO0oo = pointF18;
        return oix0oi;
    }

    public static <T> xoXoI.oIX0oI<T> XO(JsonReader jsonReader, float f, oOXoIIIo<T> ooxoiiio) throws IOException {
        return new xoXoI.oIX0oI<>(ooxoiiio.oIX0oI(jsonReader, f));
    }

    @Nullable
    public static WeakReference<Interpolator> oIX0oI(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (IXxxXO.class) {
            weakReference = Oxx0IOOO().get(i);
        }
        return weakReference;
    }

    public static <T> xoXoI.oIX0oI<T> oxoX(com.airbnb.lottie.Oxx0IOOO oxx0IOOO, JsonReader jsonReader, float f, oOXoIIIo<T> ooxoiiio) throws IOException {
        Interpolator interpolator;
        Interpolator interpolator2;
        T t;
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
            switch (jsonReader.Oo(f3083oxoX)) {
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
                    if (jsonReader.xxIXOIIO() == 1) {
                        z = true;
                        break;
                    } else {
                        z = false;
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
            interpolator2 = f3080II0xO0;
            t = t3;
        } else {
            if (pointF != null && pointF2 != null) {
                interpolator = II0xO0(pointF, pointF2);
            } else {
                interpolator = f3080II0xO0;
            }
            interpolator2 = interpolator;
            t = t2;
        }
        xoXoI.oIX0oI<T> oix0oi = new xoXoI.oIX0oI<>(oxx0IOOO, t3, t, interpolator2, f2, null);
        oix0oi.f35172oO = pointF3;
        oix0oi.f35177x0xO0oo = pointF4;
        return oix0oi;
    }
}
