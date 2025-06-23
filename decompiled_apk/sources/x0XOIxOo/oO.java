package x0XOIxOo;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import x0XOIxOo.oIX0oI;

/* loaded from: classes.dex */
public class oO {

    /* renamed from: I0Io, reason: collision with root package name */
    public final Matrix f33981I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @NonNull
    public oIX0oI<xoXoI.OOXIXo, xoXoI.OOXIXo> f33982II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Matrix f33983II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @Nullable
    public I0Io f33984OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @NonNull
    public oIX0oI<?, PointF> f33985Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final float[] f33986X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @NonNull
    public oIX0oI<PointF, PointF> f33987XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Matrix f33988oIX0oI = new Matrix();

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @Nullable
    public I0Io f33989oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @Nullable
    public oIX0oI<?, Float> f33990ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final Matrix f33991oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @Nullable
    public oIX0oI<?, Float> f33992x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    @NonNull
    public oIX0oI<Integer, Integer> f33993xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @NonNull
    public oIX0oI<Float, Float> f33994xxIXOIIO;

    public oO(Oo.oO oOVar) {
        oIX0oI<PointF, PointF> oIX0oI2;
        oIX0oI<PointF, PointF> oIX0oI3;
        oIX0oI<xoXoI.OOXIXo, xoXoI.OOXIXo> oIX0oI4;
        oIX0oI<Float, Float> oIX0oI5;
        I0Io i0Io;
        I0Io i0Io2;
        if (oOVar.I0Io() == null) {
            oIX0oI2 = null;
        } else {
            oIX0oI2 = oOVar.I0Io().oIX0oI();
        }
        this.f33987XO = oIX0oI2;
        if (oOVar.XO() == null) {
            oIX0oI3 = null;
        } else {
            oIX0oI3 = oOVar.XO().oIX0oI();
        }
        this.f33985Oxx0IOOO = oIX0oI3;
        if (oOVar.II0XooXoX() == null) {
            oIX0oI4 = null;
        } else {
            oIX0oI4 = oOVar.II0XooXoX().oIX0oI();
        }
        this.f33982II0XooXoX = oIX0oI4;
        if (oOVar.Oxx0IOOO() == null) {
            oIX0oI5 = null;
        } else {
            oIX0oI5 = oOVar.Oxx0IOOO().oIX0oI();
        }
        this.f33994xxIXOIIO = oIX0oI5;
        if (oOVar.xxIXOIIO() == null) {
            i0Io = null;
        } else {
            i0Io = (I0Io) oOVar.xxIXOIIO().oIX0oI();
        }
        this.f33984OOXIXo = i0Io;
        if (i0Io != null) {
            this.f33983II0xO0 = new Matrix();
            this.f33981I0Io = new Matrix();
            this.f33991oxoX = new Matrix();
            this.f33986X0o0xo = new float[9];
        } else {
            this.f33983II0xO0 = null;
            this.f33981I0Io = null;
            this.f33991oxoX = null;
            this.f33986X0o0xo = null;
        }
        if (oOVar.xoIox() == null) {
            i0Io2 = null;
        } else {
            i0Io2 = (I0Io) oOVar.xoIox().oIX0oI();
        }
        this.f33989oOoXoXO = i0Io2;
        if (oOVar.X0o0xo() != null) {
            this.f33993xoIox = oOVar.X0o0xo().oIX0oI();
        }
        if (oOVar.OOXIXo() != null) {
            this.f33990ooOOo0oXI = oOVar.OOXIXo().oIX0oI();
        } else {
            this.f33990ooOOo0oXI = null;
        }
        if (oOVar.oxoX() != null) {
            this.f33992x0XOIxOo = oOVar.oxoX().oIX0oI();
        } else {
            this.f33992x0XOIxOo = null;
        }
    }

    public <T> boolean I0Io(T t, @Nullable xoXoI.xoIox<T> xoiox) {
        I0Io i0Io;
        I0Io i0Io2;
        oIX0oI<?, Float> oix0oi;
        oIX0oI<?, Float> oix0oi2;
        if (t == com.airbnb.lottie.oO.f4972X0o0xo) {
            oIX0oI<PointF, PointF> oix0oi3 = this.f33987XO;
            if (oix0oi3 == null) {
                this.f33987XO = new x0xO0oo(xoiox, new PointF());
                return true;
            }
            oix0oi3.x0XOIxOo(xoiox);
            return true;
        }
        if (t == com.airbnb.lottie.oO.f4975XO) {
            oIX0oI<?, PointF> oix0oi4 = this.f33985Oxx0IOOO;
            if (oix0oi4 == null) {
                this.f33985Oxx0IOOO = new x0xO0oo(xoiox, new PointF());
                return true;
            }
            oix0oi4.x0XOIxOo(xoiox);
            return true;
        }
        if (t == com.airbnb.lottie.oO.f4968Oxx0IOOO) {
            oIX0oI<?, PointF> oix0oi5 = this.f33985Oxx0IOOO;
            if (oix0oi5 instanceof ooOOo0oXI) {
                ((ooOOo0oXI) oix0oi5).IXxxXO(xoiox);
                return true;
            }
        }
        if (t == com.airbnb.lottie.oO.f4960II0XooXoX) {
            oIX0oI<?, PointF> oix0oi6 = this.f33985Oxx0IOOO;
            if (oix0oi6 instanceof ooOOo0oXI) {
                ((ooOOo0oXI) oix0oi6).Oxx0xo(xoiox);
                return true;
            }
        }
        if (t == com.airbnb.lottie.oO.f4982ooOOo0oXI) {
            oIX0oI<xoXoI.OOXIXo, xoXoI.OOXIXo> oix0oi7 = this.f33982II0XooXoX;
            if (oix0oi7 == null) {
                this.f33982II0XooXoX = new x0xO0oo(xoiox, new xoXoI.OOXIXo());
                return true;
            }
            oix0oi7.x0XOIxOo(xoiox);
            return true;
        }
        if (t == com.airbnb.lottie.oO.f4984x0XOIxOo) {
            oIX0oI<Float, Float> oix0oi8 = this.f33994xxIXOIIO;
            if (oix0oi8 == null) {
                this.f33994xxIXOIIO = new x0xO0oo(xoiox, Float.valueOf(0.0f));
                return true;
            }
            oix0oi8.x0XOIxOo(xoiox);
            return true;
        }
        if (t == com.airbnb.lottie.oO.f4959I0Io) {
            oIX0oI<Integer, Integer> oix0oi9 = this.f33993xoIox;
            if (oix0oi9 == null) {
                this.f33993xoIox = new x0xO0oo(xoiox, 100);
                return true;
            }
            oix0oi9.x0XOIxOo(xoiox);
            return true;
        }
        if (t == com.airbnb.lottie.oO.f4971X0IIOO && (oix0oi2 = this.f33990ooOOo0oXI) != null) {
            if (oix0oi2 == null) {
                this.f33990ooOOo0oXI = new x0xO0oo(xoiox, 100);
                return true;
            }
            oix0oi2.x0XOIxOo(xoiox);
            return true;
        }
        if (t == com.airbnb.lottie.oO.f4973XI0IXoo && (oix0oi = this.f33992x0XOIxOo) != null) {
            if (oix0oi == null) {
                this.f33992x0XOIxOo = new x0xO0oo(xoiox, 100);
                return true;
            }
            oix0oi.x0XOIxOo(xoiox);
            return true;
        }
        if (t == com.airbnb.lottie.oO.f4980oO && (i0Io2 = this.f33984OOXIXo) != null) {
            if (i0Io2 == null) {
                this.f33984OOXIXo = new I0Io(Collections.singletonList(new xoXoI.oIX0oI(Float.valueOf(0.0f))));
            }
            this.f33984OOXIXo.x0XOIxOo(xoiox);
            return true;
        }
        if (t == com.airbnb.lottie.oO.f4985x0xO0oo && (i0Io = this.f33989oOoXoXO) != null) {
            if (i0Io == null) {
                this.f33989oOoXoXO = new I0Io(Collections.singletonList(new xoXoI.oIX0oI(Float.valueOf(0.0f))));
            }
            this.f33989oOoXoXO.x0XOIxOo(xoiox);
            return true;
        }
        return false;
    }

    @Nullable
    public oIX0oI<?, Integer> II0XooXoX() {
        return this.f33993xoIox;
    }

    public void II0xO0(oIX0oI.II0xO0 iI0xO0) {
        oIX0oI<Integer, Integer> oix0oi = this.f33993xoIox;
        if (oix0oi != null) {
            oix0oi.oIX0oI(iI0xO0);
        }
        oIX0oI<?, Float> oix0oi2 = this.f33990ooOOo0oXI;
        if (oix0oi2 != null) {
            oix0oi2.oIX0oI(iI0xO0);
        }
        oIX0oI<?, Float> oix0oi3 = this.f33992x0XOIxOo;
        if (oix0oi3 != null) {
            oix0oi3.oIX0oI(iI0xO0);
        }
        oIX0oI<PointF, PointF> oix0oi4 = this.f33987XO;
        if (oix0oi4 != null) {
            oix0oi4.oIX0oI(iI0xO0);
        }
        oIX0oI<?, PointF> oix0oi5 = this.f33985Oxx0IOOO;
        if (oix0oi5 != null) {
            oix0oi5.oIX0oI(iI0xO0);
        }
        oIX0oI<xoXoI.OOXIXo, xoXoI.OOXIXo> oix0oi6 = this.f33982II0XooXoX;
        if (oix0oi6 != null) {
            oix0oi6.oIX0oI(iI0xO0);
        }
        oIX0oI<Float, Float> oix0oi7 = this.f33994xxIXOIIO;
        if (oix0oi7 != null) {
            oix0oi7.oIX0oI(iI0xO0);
        }
        I0Io i0Io = this.f33984OOXIXo;
        if (i0Io != null) {
            i0Io.oIX0oI(iI0xO0);
        }
        I0Io i0Io2 = this.f33989oOoXoXO;
        if (i0Io2 != null) {
            i0Io2.oIX0oI(iI0xO0);
        }
    }

    public Matrix Oxx0IOOO(float f) {
        PointF II0XooXoX2;
        xoXoI.OOXIXo II0XooXoX3;
        float f2;
        oIX0oI<?, PointF> oix0oi = this.f33985Oxx0IOOO;
        PointF pointF = null;
        if (oix0oi == null) {
            II0XooXoX2 = null;
        } else {
            II0XooXoX2 = oix0oi.II0XooXoX();
        }
        oIX0oI<xoXoI.OOXIXo, xoXoI.OOXIXo> oix0oi2 = this.f33982II0XooXoX;
        if (oix0oi2 == null) {
            II0XooXoX3 = null;
        } else {
            II0XooXoX3 = oix0oi2.II0XooXoX();
        }
        this.f33988oIX0oI.reset();
        if (II0XooXoX2 != null) {
            this.f33988oIX0oI.preTranslate(II0XooXoX2.x * f, II0XooXoX2.y * f);
        }
        if (II0XooXoX3 != null) {
            double d = f;
            this.f33988oIX0oI.preScale((float) Math.pow(II0XooXoX3.II0xO0(), d), (float) Math.pow(II0XooXoX3.I0Io(), d));
        }
        oIX0oI<Float, Float> oix0oi3 = this.f33994xxIXOIIO;
        if (oix0oi3 != null) {
            float floatValue = oix0oi3.II0XooXoX().floatValue();
            oIX0oI<PointF, PointF> oix0oi4 = this.f33987XO;
            if (oix0oi4 != null) {
                pointF = oix0oi4.II0XooXoX();
            }
            Matrix matrix = this.f33988oIX0oI;
            float f3 = floatValue * f;
            float f4 = 0.0f;
            if (pointF == null) {
                f2 = 0.0f;
            } else {
                f2 = pointF.x;
            }
            if (pointF != null) {
                f4 = pointF.y;
            }
            matrix.preRotate(f3, f2, f4);
        }
        return this.f33988oIX0oI;
    }

    @Nullable
    public oIX0oI<?, Float> X0o0xo() {
        return this.f33992x0XOIxOo;
    }

    public Matrix XO() {
        float cos;
        float sin;
        float x0xO0oo2;
        this.f33988oIX0oI.reset();
        oIX0oI<?, PointF> oix0oi = this.f33985Oxx0IOOO;
        if (oix0oi != null) {
            PointF II0XooXoX2 = oix0oi.II0XooXoX();
            float f = II0XooXoX2.x;
            if (f != 0.0f || II0XooXoX2.y != 0.0f) {
                this.f33988oIX0oI.preTranslate(f, II0XooXoX2.y);
            }
        }
        oIX0oI<Float, Float> oix0oi2 = this.f33994xxIXOIIO;
        if (oix0oi2 != null) {
            if (oix0oi2 instanceof x0xO0oo) {
                x0xO0oo2 = oix0oi2.II0XooXoX().floatValue();
            } else {
                x0xO0oo2 = ((I0Io) oix0oi2).x0xO0oo();
            }
            if (x0xO0oo2 != 0.0f) {
                this.f33988oIX0oI.preRotate(x0xO0oo2);
            }
        }
        if (this.f33984OOXIXo != null) {
            if (this.f33989oOoXoXO == null) {
                cos = 0.0f;
            } else {
                cos = (float) Math.cos(Math.toRadians((-r0.x0xO0oo()) + 90.0f));
            }
            if (this.f33989oOoXoXO == null) {
                sin = 1.0f;
            } else {
                sin = (float) Math.sin(Math.toRadians((-r4.x0xO0oo()) + 90.0f));
            }
            float tan = (float) Math.tan(Math.toRadians(this.f33984OOXIXo.x0xO0oo()));
            oxoX();
            float[] fArr = this.f33986X0o0xo;
            fArr[0] = cos;
            fArr[1] = sin;
            float f2 = -sin;
            fArr[3] = f2;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.f33983II0xO0.setValues(fArr);
            oxoX();
            float[] fArr2 = this.f33986X0o0xo;
            fArr2[0] = 1.0f;
            fArr2[3] = tan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f33981I0Io.setValues(fArr2);
            oxoX();
            float[] fArr3 = this.f33986X0o0xo;
            fArr3[0] = cos;
            fArr3[1] = f2;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.f33991oxoX.setValues(fArr3);
            this.f33981I0Io.preConcat(this.f33983II0xO0);
            this.f33991oxoX.preConcat(this.f33981I0Io);
            this.f33988oIX0oI.preConcat(this.f33991oxoX);
        }
        oIX0oI<xoXoI.OOXIXo, xoXoI.OOXIXo> oix0oi3 = this.f33982II0XooXoX;
        if (oix0oi3 != null) {
            xoXoI.OOXIXo II0XooXoX3 = oix0oi3.II0XooXoX();
            if (II0XooXoX3.II0xO0() != 1.0f || II0XooXoX3.I0Io() != 1.0f) {
                this.f33988oIX0oI.preScale(II0XooXoX3.II0xO0(), II0XooXoX3.I0Io());
            }
        }
        oIX0oI<PointF, PointF> oix0oi4 = this.f33987XO;
        if (oix0oi4 != null) {
            PointF II0XooXoX4 = oix0oi4.II0XooXoX();
            float f3 = II0XooXoX4.x;
            if (f3 != 0.0f || II0XooXoX4.y != 0.0f) {
                this.f33988oIX0oI.preTranslate(-f3, -II0XooXoX4.y);
            }
        }
        return this.f33988oIX0oI;
    }

    public void oIX0oI(com.airbnb.lottie.model.layer.oIX0oI oix0oi) {
        oix0oi.xxIXOIIO(this.f33993xoIox);
        oix0oi.xxIXOIIO(this.f33990ooOOo0oXI);
        oix0oi.xxIXOIIO(this.f33992x0XOIxOo);
        oix0oi.xxIXOIIO(this.f33987XO);
        oix0oi.xxIXOIIO(this.f33985Oxx0IOOO);
        oix0oi.xxIXOIIO(this.f33982II0XooXoX);
        oix0oi.xxIXOIIO(this.f33994xxIXOIIO);
        oix0oi.xxIXOIIO(this.f33984OOXIXo);
        oix0oi.xxIXOIIO(this.f33989oOoXoXO);
    }

    public final void oxoX() {
        for (int i = 0; i < 9; i++) {
            this.f33986X0o0xo[i] = 0.0f;
        }
    }

    public void xoIox(float f) {
        oIX0oI<Integer, Integer> oix0oi = this.f33993xoIox;
        if (oix0oi != null) {
            oix0oi.ooOOo0oXI(f);
        }
        oIX0oI<?, Float> oix0oi2 = this.f33990ooOOo0oXI;
        if (oix0oi2 != null) {
            oix0oi2.ooOOo0oXI(f);
        }
        oIX0oI<?, Float> oix0oi3 = this.f33992x0XOIxOo;
        if (oix0oi3 != null) {
            oix0oi3.ooOOo0oXI(f);
        }
        oIX0oI<PointF, PointF> oix0oi4 = this.f33987XO;
        if (oix0oi4 != null) {
            oix0oi4.ooOOo0oXI(f);
        }
        oIX0oI<?, PointF> oix0oi5 = this.f33985Oxx0IOOO;
        if (oix0oi5 != null) {
            oix0oi5.ooOOo0oXI(f);
        }
        oIX0oI<xoXoI.OOXIXo, xoXoI.OOXIXo> oix0oi6 = this.f33982II0XooXoX;
        if (oix0oi6 != null) {
            oix0oi6.ooOOo0oXI(f);
        }
        oIX0oI<Float, Float> oix0oi7 = this.f33994xxIXOIIO;
        if (oix0oi7 != null) {
            oix0oi7.ooOOo0oXI(f);
        }
        I0Io i0Io = this.f33984OOXIXo;
        if (i0Io != null) {
            i0Io.ooOOo0oXI(f);
        }
        I0Io i0Io2 = this.f33989oOoXoXO;
        if (i0Io2 != null) {
            i0Io2.ooOOo0oXI(f);
        }
    }

    @Nullable
    public oIX0oI<?, Float> xxIXOIIO() {
        return this.f33990ooOOo0oXI;
    }
}
