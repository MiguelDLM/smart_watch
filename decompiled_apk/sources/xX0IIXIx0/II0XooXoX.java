package xX0IIXIx0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.BarEntry;
import java.util.List;

/* loaded from: classes9.dex */
public class II0XooXoX extends II0xO0 {

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public RectF f34511x0XOIxOo;

    public II0XooXoX(OOXIxO0.oIX0oI oix0oi, Ioxxx.oIX0oI oix0oi2, XIXIX.oOoXoXO oooxoxo) {
        super(oix0oi, oix0oi2, oooxoxo);
        this.f34511x0XOIxOo = new RectF();
        this.f34532XO.setTextAlign(Paint.Align.LEFT);
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public boolean OOXIXo(OOXIxO0.X0o0xo x0o0xo) {
        if (x0o0xo.getData().IXxxXO() < x0o0xo.getMaxVisibleCount() * this.f34563oIX0oI.o00()) {
            return true;
        }
        return false;
    }

    @Override // xX0IIXIx0.II0xO0, xX0IIXIx0.Oxx0IOOO
    public void X0o0xo(Canvas canvas, String str, float f, float f2, int i) {
        this.f34532XO.setColor(i);
        canvas.drawText(str, f, f2, this.f34532XO);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xX0IIXIx0.II0xO0, xX0IIXIx0.Oxx0IOOO
    public void XO(Canvas canvas) {
        List list;
        int i;
        XIXIX.Oxx0IOOO oxx0IOOO;
        int i2;
        float f;
        float[] fArr;
        float f2;
        float f3;
        boolean z;
        float f4;
        int i3;
        float[] fArr2;
        float f5;
        float f6;
        float f7;
        float f8;
        BarEntry barEntry;
        float f9;
        float f10;
        float f11;
        int i4;
        List list2;
        int i5;
        float f12;
        XIXIX.Oxx0IOOO oxx0IOOO2;
        xxIO.oxoX oxox;
        ox.x0xO0oo x0xo0oo;
        float f13;
        if (OOXIXo(this.f34512II0XooXoX)) {
            List Oo2 = this.f34512II0XooXoX.getBarData().Oo();
            float X0o0xo2 = XIXIX.OOXIXo.X0o0xo(5.0f);
            boolean oIX0oI2 = this.f34512II0XooXoX.oIX0oI();
            int i6 = 0;
            while (i6 < this.f34512II0XooXoX.getBarData().ooOOo0oXI()) {
                IIxOXoOo0.oIX0oI oix0oi = (IIxOXoOo0.oIX0oI) Oo2.get(i6);
                if (!ooOOo0oXI(oix0oi)) {
                    list = Oo2;
                    i = i6;
                } else {
                    boolean X0o0xo3 = this.f34512II0XooXoX.X0o0xo(oix0oi.OX00O0xII());
                    oIX0oI(oix0oi);
                    float f14 = 2.0f;
                    float oIX0oI3 = XIXIX.OOXIXo.oIX0oI(this.f34532XO, "10") / 2.0f;
                    ox.x0xO0oo xxIO2 = oix0oi.xxIO();
                    xxIO.oxoX oxox2 = this.f34516xoIox[i6];
                    float xxIXOIIO2 = this.f34530II0xO0.xxIXOIIO();
                    XIXIX.Oxx0IOOO oxoX2 = XIXIX.Oxx0IOOO.oxoX(oix0oi.IO0XoXxO());
                    oxoX2.f3771IXxxXO = XIXIX.OOXIXo.X0o0xo(oxoX2.f3771IXxxXO);
                    oxoX2.f3772Oxx0xo = XIXIX.OOXIXo.X0o0xo(oxoX2.f3772Oxx0xo);
                    if (!oix0oi.XoX()) {
                        int i7 = 0;
                        while (i7 < oxox2.f35293II0xO0.length * this.f34530II0xO0.II0XooXoX()) {
                            float[] fArr3 = oxox2.f35293II0xO0;
                            int i8 = i7 + 1;
                            float f15 = fArr3[i8];
                            float f16 = (fArr3[i7 + 3] + f15) / f14;
                            if (!this.f34563oIX0oI.oo(f15)) {
                                break;
                            }
                            if (!this.f34563oIX0oI.IoOoX(oxox2.f35293II0xO0[i7]) || !this.f34563oIX0oI.ooXIXxIX(oxox2.f35293II0xO0[i8])) {
                                i4 = i7;
                                oxox = oxox2;
                                list2 = Oo2;
                                i5 = i6;
                                oxx0IOOO2 = oxoX2;
                                x0xo0oo = xxIO2;
                            } else {
                                BarEntry barEntry2 = (BarEntry) oix0oi.OOXIXo(i7 / 4);
                                float I0Io2 = barEntry2.I0Io();
                                String oxoX3 = xxIO2.oxoX(barEntry2);
                                float oxoX4 = XIXIX.OOXIXo.oxoX(this.f34532XO, oxoX3);
                                if (oIX0oI2) {
                                    f10 = X0o0xo2;
                                } else {
                                    f10 = -(oxoX4 + X0o0xo2);
                                }
                                if (oIX0oI2) {
                                    f11 = -(oxoX4 + X0o0xo2);
                                } else {
                                    f11 = X0o0xo2;
                                }
                                if (X0o0xo3) {
                                    f10 = (-f10) - oxoX4;
                                    f11 = (-f11) - oxoX4;
                                }
                                float f17 = f10;
                                float f18 = f11;
                                if (oix0oi.xoO0xx0()) {
                                    float f19 = oxox2.f35293II0xO0[i7 + 2];
                                    if (I0Io2 >= 0.0f) {
                                        f13 = f17;
                                    } else {
                                        f13 = f18;
                                    }
                                    i4 = i7;
                                    list2 = Oo2;
                                    oxx0IOOO2 = oxoX2;
                                    f12 = f18;
                                    oxox = oxox2;
                                    i5 = i6;
                                    x0xo0oo = xxIO2;
                                    X0o0xo(canvas, oxoX3, f19 + f13, f16 + oIX0oI3, oix0oi.x0xO0oo(i7 / 2));
                                } else {
                                    i4 = i7;
                                    list2 = Oo2;
                                    i5 = i6;
                                    f12 = f18;
                                    oxx0IOOO2 = oxoX2;
                                    oxox = oxox2;
                                    x0xo0oo = xxIO2;
                                }
                                if (barEntry2.II0xO0() != null && oix0oi.oo0xXOI0I()) {
                                    Drawable II0xO02 = barEntry2.II0xO0();
                                    float f20 = oxox.f35293II0xO0[i4 + 2];
                                    if (I0Io2 < 0.0f) {
                                        f17 = f12;
                                    }
                                    XIXIX.OOXIXo.OOXIXo(canvas, II0xO02, (int) (f20 + f17 + oxx0IOOO2.f3771IXxxXO), (int) (f16 + oxx0IOOO2.f3772Oxx0xo), II0xO02.getIntrinsicWidth(), II0xO02.getIntrinsicHeight());
                                }
                            }
                            i7 = i4 + 4;
                            oxoX2 = oxx0IOOO2;
                            xxIO2 = x0xo0oo;
                            oxox2 = oxox;
                            Oo2 = list2;
                            i6 = i5;
                            f14 = 2.0f;
                        }
                        list = Oo2;
                        i = i6;
                        oxx0IOOO = oxoX2;
                    } else {
                        list = Oo2;
                        i = i6;
                        oxx0IOOO = oxoX2;
                        XIXIX.xxIXOIIO oxoX5 = this.f34512II0XooXoX.oxoX(oix0oi.OX00O0xII());
                        int i9 = 0;
                        int i10 = 0;
                        while (i9 < oix0oi.X0xxXX0() * this.f34530II0xO0.II0XooXoX()) {
                            BarEntry barEntry3 = (BarEntry) oix0oi.OOXIXo(i9);
                            int x0xO0oo2 = oix0oi.x0xO0oo(i9);
                            float[] oI0IIXIo2 = barEntry3.oI0IIXIo();
                            if (oI0IIXIo2 == null) {
                                int i11 = i10 + 1;
                                if (!this.f34563oIX0oI.oo(oxox2.f35293II0xO0[i11])) {
                                    break;
                                }
                                if (this.f34563oIX0oI.IoOoX(oxox2.f35293II0xO0[i10]) && this.f34563oIX0oI.ooXIXxIX(oxox2.f35293II0xO0[i11])) {
                                    String oxoX6 = xxIO2.oxoX(barEntry3);
                                    float oxoX7 = XIXIX.OOXIXo.oxoX(this.f34532XO, oxoX6);
                                    if (oIX0oI2) {
                                        f7 = X0o0xo2;
                                    } else {
                                        f7 = -(oxoX7 + X0o0xo2);
                                    }
                                    if (oIX0oI2) {
                                        f8 = -(oxoX7 + X0o0xo2);
                                    } else {
                                        f8 = X0o0xo2;
                                    }
                                    if (X0o0xo3) {
                                        f7 = (-f7) - oxoX7;
                                        f8 = (-f8) - oxoX7;
                                    }
                                    float f21 = f7;
                                    float f22 = f8;
                                    if (oix0oi.xoO0xx0()) {
                                        float f23 = oxox2.f35293II0xO0[i10 + 2];
                                        if (barEntry3.I0Io() >= 0.0f) {
                                            f9 = f21;
                                        } else {
                                            f9 = f22;
                                        }
                                        float f24 = oxox2.f35293II0xO0[i11] + oIX0oI3;
                                        f = oIX0oI3;
                                        fArr = oI0IIXIo2;
                                        barEntry = barEntry3;
                                        i2 = i9;
                                        X0o0xo(canvas, oxoX6, f23 + f9, f24, x0xO0oo2);
                                    } else {
                                        i2 = i9;
                                        f = oIX0oI3;
                                        fArr = oI0IIXIo2;
                                        barEntry = barEntry3;
                                    }
                                    if (barEntry.II0xO0() != null && oix0oi.oo0xXOI0I()) {
                                        Drawable II0xO03 = barEntry.II0xO0();
                                        float f25 = oxox2.f35293II0xO0[i10 + 2];
                                        if (barEntry.I0Io() < 0.0f) {
                                            f21 = f22;
                                        }
                                        XIXIX.OOXIXo.OOXIXo(canvas, II0xO03, (int) (f25 + f21 + oxx0IOOO.f3771IXxxXO), (int) (oxox2.f35293II0xO0[i11] + oxx0IOOO.f3772Oxx0xo), II0xO03.getIntrinsicWidth(), II0xO03.getIntrinsicHeight());
                                    }
                                }
                            } else {
                                i2 = i9;
                                f = oIX0oI3;
                                fArr = oI0IIXIo2;
                                int length = fArr.length * 2;
                                float[] fArr4 = new float[length];
                                float f26 = -barEntry3.x0xO0oo();
                                int i12 = 0;
                                int i13 = 0;
                                float f27 = 0.0f;
                                while (i12 < length) {
                                    float f28 = fArr[i13];
                                    if (f28 == 0.0f && (f27 == 0.0f || f26 == 0.0f)) {
                                        float f29 = f26;
                                        f26 = f28;
                                        f6 = f29;
                                    } else if (f28 >= 0.0f) {
                                        f27 += f28;
                                        f6 = f26;
                                        f26 = f27;
                                    } else {
                                        f6 = f26 - f28;
                                    }
                                    fArr4[i12] = f26 * xxIXOIIO2;
                                    i12 += 2;
                                    i13++;
                                    f26 = f6;
                                }
                                oxoX5.oO(fArr4);
                                int i14 = 0;
                                while (i14 < length) {
                                    float f30 = fArr[i14 / 2];
                                    String X0o0xo4 = xxIO2.X0o0xo(f30, barEntry3);
                                    float oxoX8 = XIXIX.OOXIXo.oxoX(this.f34532XO, X0o0xo4);
                                    if (oIX0oI2) {
                                        f2 = X0o0xo2;
                                    } else {
                                        f2 = -(oxoX8 + X0o0xo2);
                                    }
                                    int i15 = length;
                                    if (oIX0oI2) {
                                        f3 = -(oxoX8 + X0o0xo2);
                                    } else {
                                        f3 = X0o0xo2;
                                    }
                                    if (X0o0xo3) {
                                        f2 = (-f2) - oxoX8;
                                        f3 = (-f3) - oxoX8;
                                    }
                                    if ((f30 == 0.0f && f26 == 0.0f && f27 > 0.0f) || f30 < 0.0f) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    float f31 = fArr4[i14];
                                    if (z) {
                                        f2 = f3;
                                    }
                                    float f32 = f31 + f2;
                                    float[] fArr5 = oxox2.f35293II0xO0;
                                    float f33 = (fArr5[i10 + 1] + fArr5[i10 + 3]) / 2.0f;
                                    if (!this.f34563oIX0oI.oo(f33)) {
                                        break;
                                    }
                                    if (!this.f34563oIX0oI.IoOoX(f32) || !this.f34563oIX0oI.ooXIXxIX(f33)) {
                                        i3 = i14;
                                        fArr2 = fArr4;
                                    } else {
                                        if (oix0oi.xoO0xx0()) {
                                            f4 = f33;
                                            i3 = i14;
                                            fArr2 = fArr4;
                                            f5 = f32;
                                            X0o0xo(canvas, X0o0xo4, f32, f33 + f, x0xO0oo2);
                                        } else {
                                            f4 = f33;
                                            i3 = i14;
                                            fArr2 = fArr4;
                                            f5 = f32;
                                        }
                                        if (barEntry3.II0xO0() != null && oix0oi.oo0xXOI0I()) {
                                            Drawable II0xO04 = barEntry3.II0xO0();
                                            XIXIX.OOXIXo.OOXIXo(canvas, II0xO04, (int) (f5 + oxx0IOOO.f3771IXxxXO), (int) (f4 + oxx0IOOO.f3772Oxx0xo), II0xO04.getIntrinsicWidth(), II0xO04.getIntrinsicHeight());
                                        }
                                    }
                                    i14 = i3 + 2;
                                    length = i15;
                                    fArr4 = fArr2;
                                }
                            }
                            if (fArr == null) {
                                i10 += 4;
                            } else {
                                i10 += fArr.length * 4;
                            }
                            i9 = i2 + 1;
                            oIX0oI3 = f;
                        }
                    }
                    XIXIX.Oxx0IOOO.II0XooXoX(oxx0IOOO);
                }
                i6 = i + 1;
                Oo2 = list;
            }
        }
    }

    @Override // xX0IIXIx0.II0xO0
    public void oO(float f, float f2, float f3, float f4, XIXIX.xxIXOIIO xxixoiio) {
        this.f34517xxIXOIIO.set(f2, f - f4, f3, f + f4);
        xxixoiio.Oxx0xo(this.f34517xxIXOIIO, this.f34530II0xO0.xxIXOIIO());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xX0IIXIx0.II0xO0
    public void x0XOIxOo(Canvas canvas, IIxOXoOo0.oIX0oI oix0oi, int i) {
        boolean z;
        XIXIX.xxIXOIIO oxoX2 = this.f34512II0XooXoX.oxoX(oix0oi.OX00O0xII());
        this.f34514oOoXoXO.setColor(oix0oi.xoIxX());
        this.f34514oOoXoXO.setStrokeWidth(XIXIX.OOXIXo.X0o0xo(oix0oi.IoOoX()));
        boolean z2 = true;
        if (oix0oi.IoOoX() > 0.0f) {
            z = true;
        } else {
            z = false;
        }
        float II0XooXoX2 = this.f34530II0xO0.II0XooXoX();
        float xxIXOIIO2 = this.f34530II0xO0.xxIXOIIO();
        if (this.f34512II0XooXoX.I0Io()) {
            this.f34513OOXIXo.setColor(oix0oi.oOoIIO0());
            float xII2 = this.f34512II0XooXoX.getBarData().xII() / 2.0f;
            int min = Math.min((int) Math.ceil(oix0oi.X0xxXX0() * II0XooXoX2), oix0oi.X0xxXX0());
            for (int i2 = 0; i2 < min; i2++) {
                float xxIXOIIO3 = ((BarEntry) oix0oi.OOXIXo(i2)).xxIXOIIO();
                RectF rectF = this.f34511x0XOIxOo;
                rectF.top = xxIXOIIO3 - xII2;
                rectF.bottom = xxIXOIIO3 + xII2;
                oxoX2.oI0IIXIo(rectF);
                if (this.f34563oIX0oI.oo(this.f34511x0XOIxOo.bottom)) {
                    if (!this.f34563oIX0oI.ooXIXxIX(this.f34511x0XOIxOo.top)) {
                        break;
                    }
                    this.f34511x0XOIxOo.left = this.f34563oIX0oI.II0XooXoX();
                    this.f34511x0XOIxOo.right = this.f34563oIX0oI.xxIXOIIO();
                    canvas.drawRect(this.f34511x0XOIxOo, this.f34513OOXIXo);
                }
            }
        }
        xxIO.oxoX oxox = this.f34516xoIox[i];
        oxox.X0o0xo(II0XooXoX2, xxIXOIIO2);
        oxox.xoIox(i);
        oxox.OOXIXo(this.f34512II0XooXoX.X0o0xo(oix0oi.OX00O0xII()));
        oxox.xxIXOIIO(this.f34512II0XooXoX.getBarData().xII());
        oxox.oIX0oI(oix0oi);
        oxoX2.oO(oxox.f35293II0xO0);
        if (oix0oi.OOXIxO0().size() != 1) {
            z2 = false;
        }
        if (z2) {
            this.f34529I0Io.setColor(oix0oi.xX0IIXIx0());
        }
        for (int i3 = 0; i3 < oxox.XO(); i3 += 4) {
            int i4 = i3 + 3;
            if (this.f34563oIX0oI.oo(oxox.f35293II0xO0[i4])) {
                int i5 = i3 + 1;
                if (this.f34563oIX0oI.ooXIXxIX(oxox.f35293II0xO0[i5])) {
                    if (!z2) {
                        this.f34529I0Io.setColor(oix0oi.XXoOx0(i3 / 4));
                    }
                    float[] fArr = oxox.f35293II0xO0;
                    int i6 = i3 + 2;
                    canvas.drawRect(fArr[i3], fArr[i5], fArr[i6], fArr[i4], this.f34529I0Io);
                    if (z) {
                        float[] fArr2 = oxox.f35293II0xO0;
                        canvas.drawRect(fArr2[i3], fArr2[i5], fArr2[i6], fArr2[i4], this.f34514oOoXoXO);
                    }
                }
            } else {
                return;
            }
        }
    }

    @Override // xX0IIXIx0.II0xO0
    public void x0xO0oo(XI0oooXX.oxoX oxox, RectF rectF) {
        oxox.x0XOIxOo(rectF.centerY(), rectF.right);
    }

    @Override // xX0IIXIx0.II0xO0, xX0IIXIx0.Oxx0IOOO
    public void xoIox() {
        int i;
        o0xxxXXxX.oIX0oI barData = this.f34512II0XooXoX.getBarData();
        this.f34516xoIox = new xxIO.X0o0xo[barData.ooOOo0oXI()];
        for (int i2 = 0; i2 < this.f34516xoIox.length; i2++) {
            IIxOXoOo0.oIX0oI oix0oi = (IIxOXoOo0.oIX0oI) barData.OOXIXo(i2);
            xxIO.oxoX[] oxoxArr = this.f34516xoIox;
            int X0xxXX02 = oix0oi.X0xxXX0() * 4;
            if (oix0oi.XoX()) {
                i = oix0oi.IXxxXO();
            } else {
                i = 1;
            }
            oxoxArr[i2] = new xxIO.X0o0xo(X0xxXX02 * i, barData.ooOOo0oXI(), oix0oi.XoX());
        }
    }
}
