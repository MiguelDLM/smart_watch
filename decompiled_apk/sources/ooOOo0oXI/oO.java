package ooOOo0oXI;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
import x0XOIxOo.oIX0oI;

/* loaded from: classes.dex */
public class oO implements x0XOIxOo, oIX0oI.II0xO0, OOXIXo {

    /* renamed from: oO, reason: collision with root package name */
    public static final float f32391oO = 0.47829f;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final float f32392x0xO0oo = 0.25f;

    /* renamed from: I0Io, reason: collision with root package name */
    public final com.airbnb.lottie.xoIox f32393I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<?, Float> f32394II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final String f32395II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @Nullable
    public final x0XOIxOo.oIX0oI<?, Float> f32396OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<?, PointF> f32397Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final boolean f32398X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<?, Float> f32399XO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<?, Float> f32401oOoXoXO;

    /* renamed from: oxoX, reason: collision with root package name */
    public final PolystarShape.Type f32403oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public boolean f32404x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<?, Float> f32405xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @Nullable
    public final x0XOIxOo.oIX0oI<?, Float> f32406xxIXOIIO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Path f32400oIX0oI = new Path();

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public II0xO0 f32402ooOOo0oXI = new II0xO0();

    /* loaded from: classes.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f32407oIX0oI;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            f32407oIX0oI = iArr;
            try {
                iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32407oIX0oI[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public oO(com.airbnb.lottie.xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi, PolystarShape polystarShape) {
        this.f32393I0Io = xoiox;
        this.f32395II0xO0 = polystarShape.oxoX();
        PolystarShape.Type xoIox2 = polystarShape.xoIox();
        this.f32403oxoX = xoIox2;
        this.f32398X0o0xo = polystarShape.OOXIXo();
        x0XOIxOo.oIX0oI<Float, Float> oIX0oI2 = polystarShape.Oxx0IOOO().oIX0oI();
        this.f32399XO = oIX0oI2;
        x0XOIxOo.oIX0oI<PointF, PointF> oIX0oI3 = polystarShape.II0XooXoX().oIX0oI();
        this.f32397Oxx0IOOO = oIX0oI3;
        x0XOIxOo.oIX0oI<Float, Float> oIX0oI4 = polystarShape.xxIXOIIO().oIX0oI();
        this.f32394II0XooXoX = oIX0oI4;
        x0XOIxOo.oIX0oI<Float, Float> oIX0oI5 = polystarShape.X0o0xo().oIX0oI();
        this.f32405xoIox = oIX0oI5;
        x0XOIxOo.oIX0oI<Float, Float> oIX0oI6 = polystarShape.XO().oIX0oI();
        this.f32401oOoXoXO = oIX0oI6;
        PolystarShape.Type type = PolystarShape.Type.STAR;
        if (xoIox2 == type) {
            this.f32406xxIXOIIO = polystarShape.II0xO0().oIX0oI();
            this.f32396OOXIXo = polystarShape.I0Io().oIX0oI();
        } else {
            this.f32406xxIXOIIO = null;
            this.f32396OOXIXo = null;
        }
        oix0oi.xxIXOIIO(oIX0oI2);
        oix0oi.xxIXOIIO(oIX0oI3);
        oix0oi.xxIXOIIO(oIX0oI4);
        oix0oi.xxIXOIIO(oIX0oI5);
        oix0oi.xxIXOIIO(oIX0oI6);
        if (xoIox2 == type) {
            oix0oi.xxIXOIIO(this.f32406xxIXOIIO);
            oix0oi.xxIXOIIO(this.f32396OOXIXo);
        }
        oIX0oI2.oIX0oI(this);
        oIX0oI3.oIX0oI(this);
        oIX0oI4.oIX0oI(this);
        oIX0oI5.oIX0oI(this);
        oIX0oI6.oIX0oI(this);
        if (xoIox2 == type) {
            this.f32406xxIXOIIO.oIX0oI(this);
            this.f32396OOXIXo.oIX0oI(this);
        }
    }

    private void xxIXOIIO() {
        this.f32404x0XOIxOo = false;
        this.f32393I0Io.invalidateSelf();
    }

    public final void II0XooXoX() {
        double floatValue;
        float f;
        float f2;
        int i;
        float f3;
        float f4;
        double d;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        double d2;
        float f10;
        float f11;
        float f12;
        double d3;
        float f13;
        float f14;
        float f15;
        float f16;
        float floatValue2 = this.f32399XO.II0XooXoX().floatValue();
        x0XOIxOo.oIX0oI<?, Float> oix0oi = this.f32394II0XooXoX;
        if (oix0oi == null) {
            floatValue = XIXIX.OOXIXo.f3760XO;
        } else {
            floatValue = oix0oi.II0XooXoX().floatValue();
        }
        double radians = Math.toRadians(floatValue - 90.0d);
        double d4 = floatValue2;
        float f17 = (float) (6.283185307179586d / d4);
        float f18 = f17 / 2.0f;
        float f19 = floatValue2 - ((int) floatValue2);
        int i2 = (f19 > 0.0f ? 1 : (f19 == 0.0f ? 0 : -1));
        if (i2 != 0) {
            radians += (1.0f - f19) * f18;
        }
        float floatValue3 = this.f32405xoIox.II0XooXoX().floatValue();
        float floatValue4 = this.f32406xxIXOIIO.II0XooXoX().floatValue();
        x0XOIxOo.oIX0oI<?, Float> oix0oi2 = this.f32396OOXIXo;
        if (oix0oi2 != null) {
            f = oix0oi2.II0XooXoX().floatValue() / 100.0f;
        } else {
            f = 0.0f;
        }
        x0XOIxOo.oIX0oI<?, Float> oix0oi3 = this.f32401oOoXoXO;
        if (oix0oi3 != null) {
            f2 = oix0oi3.II0XooXoX().floatValue() / 100.0f;
        } else {
            f2 = 0.0f;
        }
        if (i2 != 0) {
            f6 = ((floatValue3 - floatValue4) * f19) + floatValue4;
            i = i2;
            double d5 = f6;
            float cos = (float) (d5 * Math.cos(radians));
            f5 = (float) (d5 * Math.sin(radians));
            this.f32400oIX0oI.moveTo(cos, f5);
            d = radians + ((f17 * f19) / 2.0f);
            f3 = cos;
            f4 = f18;
        } else {
            i = i2;
            double d6 = floatValue3;
            float cos2 = (float) (Math.cos(radians) * d6);
            float sin = (float) (d6 * Math.sin(radians));
            this.f32400oIX0oI.moveTo(cos2, sin);
            f3 = cos2;
            f4 = f18;
            d = radians + f4;
            f5 = sin;
            f6 = 0.0f;
        }
        double ceil = Math.ceil(d4) * 2.0d;
        int i3 = 0;
        float f20 = f4;
        float f21 = f3;
        boolean z = false;
        while (true) {
            double d7 = i3;
            if (d7 < ceil) {
                if (z) {
                    f7 = floatValue3;
                } else {
                    f7 = floatValue4;
                }
                if (f6 != 0.0f && d7 == ceil - 2.0d) {
                    f8 = f17;
                    f9 = (f17 * f19) / 2.0f;
                } else {
                    f8 = f17;
                    f9 = f20;
                }
                if (f6 != 0.0f && d7 == ceil - 1.0d) {
                    d2 = d7;
                    f10 = f6;
                } else {
                    d2 = d7;
                    f10 = f6;
                    f6 = f7;
                }
                double d8 = f6;
                double d9 = ceil;
                float cos3 = (float) (d8 * Math.cos(d));
                float sin2 = (float) (d8 * Math.sin(d));
                if (f == 0.0f && f2 == 0.0f) {
                    this.f32400oIX0oI.lineTo(cos3, sin2);
                    d3 = d;
                    f11 = f;
                    f12 = f2;
                } else {
                    f11 = f;
                    double atan2 = (float) (Math.atan2(f5, f21) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan2);
                    float sin3 = (float) Math.sin(atan2);
                    f12 = f2;
                    d3 = d;
                    double atan22 = (float) (Math.atan2(sin2, cos3) - 1.5707963267948966d);
                    float cos5 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    if (z) {
                        f13 = f11;
                    } else {
                        f13 = f12;
                    }
                    if (z) {
                        f14 = f12;
                    } else {
                        f14 = f11;
                    }
                    if (z) {
                        f15 = floatValue4;
                    } else {
                        f15 = floatValue3;
                    }
                    if (z) {
                        f16 = floatValue3;
                    } else {
                        f16 = floatValue4;
                    }
                    float f22 = f15 * f13 * 0.47829f;
                    float f23 = cos4 * f22;
                    float f24 = f22 * sin3;
                    float f25 = f16 * f14 * 0.47829f;
                    float f26 = cos5 * f25;
                    float f27 = f25 * sin4;
                    if (i != 0) {
                        if (i3 == 0) {
                            f23 *= f19;
                            f24 *= f19;
                        } else if (d2 == d9 - 1.0d) {
                            f26 *= f19;
                            f27 *= f19;
                        }
                    }
                    this.f32400oIX0oI.cubicTo(f21 - f23, f5 - f24, cos3 + f26, sin2 + f27, cos3, sin2);
                }
                d = d3 + f9;
                z = !z;
                i3++;
                f21 = cos3;
                f5 = sin2;
                f2 = f12;
                f = f11;
                f6 = f10;
                f17 = f8;
                ceil = d9;
            } else {
                PointF II0XooXoX2 = this.f32397Oxx0IOOO.II0XooXoX();
                this.f32400oIX0oI.offset(II0XooXoX2.x, II0XooXoX2.y);
                this.f32400oIX0oI.close();
                return;
            }
        }
    }

    public final void II0xO0() {
        double floatValue;
        int i;
        double d;
        double d2;
        double d3;
        int floor = (int) Math.floor(this.f32399XO.II0XooXoX().floatValue());
        x0XOIxOo.oIX0oI<?, Float> oix0oi = this.f32394II0XooXoX;
        if (oix0oi == null) {
            floatValue = XIXIX.OOXIXo.f3760XO;
        } else {
            floatValue = oix0oi.II0XooXoX().floatValue();
        }
        double radians = Math.toRadians(floatValue - 90.0d);
        double d4 = floor;
        float floatValue2 = this.f32401oOoXoXO.II0XooXoX().floatValue() / 100.0f;
        float floatValue3 = this.f32405xoIox.II0XooXoX().floatValue();
        double d5 = floatValue3;
        float cos = (float) (Math.cos(radians) * d5);
        float sin = (float) (Math.sin(radians) * d5);
        this.f32400oIX0oI.moveTo(cos, sin);
        double d6 = (float) (6.283185307179586d / d4);
        double d7 = radians + d6;
        double ceil = Math.ceil(d4);
        int i2 = 0;
        while (i2 < ceil) {
            float cos2 = (float) (Math.cos(d7) * d5);
            double d8 = ceil;
            float sin2 = (float) (d5 * Math.sin(d7));
            if (floatValue2 != 0.0f) {
                d2 = d5;
                i = i2;
                d = d7;
                double atan2 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                d3 = d6;
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float f = floatValue3 * floatValue2 * 0.25f;
                this.f32400oIX0oI.cubicTo(cos - (cos3 * f), sin - (sin3 * f), cos2 + (((float) Math.cos(atan22)) * f), sin2 + (f * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                i = i2;
                d = d7;
                d2 = d5;
                d3 = d6;
                this.f32400oIX0oI.lineTo(cos2, sin2);
            }
            d7 = d + d3;
            i2 = i + 1;
            sin = sin2;
            cos = cos2;
            ceil = d8;
            d5 = d2;
            d6 = d3;
        }
        PointF II0XooXoX2 = this.f32397Oxx0IOOO.II0XooXoX();
        this.f32400oIX0oI.offset(II0XooXoX2.x, II0XooXoX2.y);
        this.f32400oIX0oI.close();
    }

    @Override // x0xO0oo.X0o0xo
    public void Oxx0IOOO(x0xO0oo.oxoX oxox, int i, List<x0xO0oo.oxoX> list, x0xO0oo.oxoX oxox2) {
        IIXOooo.xxIXOIIO.ooOOo0oXI(oxox, i, list, oxox2, this);
    }

    @Override // ooOOo0oXI.I0Io
    public void X0o0xo(List<I0Io> list, List<I0Io> list2) {
        for (int i = 0; i < list.size(); i++) {
            I0Io i0Io = list.get(i);
            if (i0Io instanceof OxxIIOOXO) {
                OxxIIOOXO oxxIIOOXO = (OxxIIOOXO) i0Io;
                if (oxxIIOOXO.xxIXOIIO() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f32402ooOOo0oXI.oIX0oI(oxxIIOOXO);
                    oxxIIOOXO.II0xO0(this);
                }
            }
        }
    }

    @Override // x0xO0oo.X0o0xo
    public <T> void XO(T t, @Nullable xoXoI.xoIox<T> xoiox) {
        x0XOIxOo.oIX0oI<?, Float> oix0oi;
        x0XOIxOo.oIX0oI<?, Float> oix0oi2;
        if (t == com.airbnb.lottie.oO.f4970OxxIIOOXO) {
            this.f32399XO.x0XOIxOo(xoiox);
            return;
        }
        if (t == com.airbnb.lottie.oO.f4962IIXOooo) {
            this.f32394II0XooXoX.x0XOIxOo(xoiox);
            return;
        }
        if (t == com.airbnb.lottie.oO.f4981oOoXoXO) {
            this.f32397Oxx0IOOO.x0XOIxOo(xoiox);
            return;
        }
        if (t == com.airbnb.lottie.oO.f4988xoXoI && (oix0oi2 = this.f32406xxIXOIIO) != null) {
            oix0oi2.x0XOIxOo(xoiox);
            return;
        }
        if (t == com.airbnb.lottie.oO.f4977o00) {
            this.f32405xoIox.x0XOIxOo(xoiox);
            return;
        }
        if (t == com.airbnb.lottie.oO.f4967OxI && (oix0oi = this.f32396OOXIXo) != null) {
            oix0oi.x0XOIxOo(xoiox);
        } else if (t == com.airbnb.lottie.oO.f4964O0xOxO) {
            this.f32401oOoXoXO.x0XOIxOo(xoiox);
        }
    }

    @Override // ooOOo0oXI.I0Io
    public String getName() {
        return this.f32395II0xO0;
    }

    @Override // ooOOo0oXI.x0XOIxOo
    public Path getPath() {
        if (this.f32404x0XOIxOo) {
            return this.f32400oIX0oI;
        }
        this.f32400oIX0oI.reset();
        if (this.f32398X0o0xo) {
            this.f32404x0XOIxOo = true;
            return this.f32400oIX0oI;
        }
        int i = oIX0oI.f32407oIX0oI[this.f32403oxoX.ordinal()];
        if (i != 1) {
            if (i == 2) {
                II0xO0();
            }
        } else {
            II0XooXoX();
        }
        this.f32400oIX0oI.close();
        this.f32402ooOOo0oXI.II0xO0(this.f32400oIX0oI);
        this.f32404x0XOIxOo = true;
        return this.f32400oIX0oI;
    }

    @Override // x0XOIxOo.oIX0oI.II0xO0
    public void oxoX() {
        xxIXOIIO();
    }
}
