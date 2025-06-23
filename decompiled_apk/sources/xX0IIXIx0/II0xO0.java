package xX0IIXIx0;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.BarEntry;
import java.util.List;

/* loaded from: classes9.dex */
public class II0xO0 extends I0Io {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public OOXIxO0.oIX0oI f34512II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public Paint f34513OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public Paint f34514oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public RectF f34515ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    public xxIO.oxoX[] f34516xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public RectF f34517xxIXOIIO;

    public II0xO0(OOXIxO0.oIX0oI oix0oi, Ioxxx.oIX0oI oix0oi2, XIXIX.oOoXoXO oooxoxo) {
        super(oix0oi2, oooxoxo);
        this.f34517xxIXOIIO = new RectF();
        this.f34515ooOOo0oXI = new RectF();
        this.f34512II0XooXoX = oix0oi;
        Paint paint = new Paint(1);
        this.f34533oxoX = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.f34533oxoX.setColor(Color.rgb(0, 0, 0));
        this.f34533oxoX.setAlpha(120);
        Paint paint2 = new Paint(1);
        this.f34513OOXIXo = paint2;
        paint2.setStyle(style);
        Paint paint3 = new Paint(1);
        this.f34514oOoXoXO = paint3;
        paint3.setStyle(Paint.Style.STROKE);
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void II0xO0(Canvas canvas) {
        o0xxxXXxX.oIX0oI barData = this.f34512II0XooXoX.getBarData();
        for (int i = 0; i < barData.ooOOo0oXI(); i++) {
            IIxOXoOo0.oIX0oI oix0oi = (IIxOXoOo0.oIX0oI) barData.OOXIXo(i);
            if (oix0oi.isVisible()) {
                x0XOIxOo(canvas, oix0oi, i);
            }
        }
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void X0o0xo(Canvas canvas, String str, float f, float f2, int i) {
        this.f34532XO.setColor(i);
        canvas.drawText(str, f, f2, this.f34532XO);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xX0IIXIx0.Oxx0IOOO
    public void XO(Canvas canvas) {
        float f;
        float f2;
        List list;
        XIXIX.Oxx0IOOO oxx0IOOO;
        int i;
        float f3;
        boolean z;
        float[] fArr;
        XIXIX.xxIXOIIO xxixoiio;
        boolean z2;
        float f4;
        XIXIX.xxIXOIIO xxixoiio2;
        float[] fArr2;
        int i2;
        BarEntry barEntry;
        int i3;
        float f5;
        float f6;
        float f7;
        BarEntry barEntry2;
        float f8;
        float f9;
        float f10;
        boolean z3;
        int i4;
        ox.x0xO0oo x0xo0oo;
        List list2;
        XIXIX.Oxx0IOOO oxx0IOOO2;
        BarEntry barEntry3;
        float f11;
        float f12;
        float f13;
        if (OOXIXo(this.f34512II0XooXoX)) {
            List Oo2 = this.f34512II0XooXoX.getBarData().Oo();
            float X0o0xo2 = XIXIX.OOXIXo.X0o0xo(4.5f);
            boolean oIX0oI2 = this.f34512II0XooXoX.oIX0oI();
            int i5 = 0;
            while (i5 < this.f34512II0XooXoX.getBarData().ooOOo0oXI()) {
                IIxOXoOo0.oIX0oI oix0oi = (IIxOXoOo0.oIX0oI) Oo2.get(i5);
                if (!ooOOo0oXI(oix0oi)) {
                    list = Oo2;
                    f10 = X0o0xo2;
                    z3 = oIX0oI2;
                } else {
                    oIX0oI(oix0oi);
                    boolean X0o0xo3 = this.f34512II0XooXoX.X0o0xo(oix0oi.OX00O0xII());
                    float oIX0oI3 = XIXIX.OOXIXo.oIX0oI(this.f34532XO, "8");
                    if (oIX0oI2) {
                        f = -X0o0xo2;
                    } else {
                        f = oIX0oI3 + X0o0xo2;
                    }
                    if (oIX0oI2) {
                        f2 = oIX0oI3 + X0o0xo2;
                    } else {
                        f2 = -X0o0xo2;
                    }
                    if (X0o0xo3) {
                        f = (-f) - oIX0oI3;
                        f2 = (-f2) - oIX0oI3;
                    }
                    float f14 = f;
                    float f15 = f2;
                    xxIO.oxoX oxox = this.f34516xoIox[i5];
                    float xxIXOIIO2 = this.f34530II0xO0.xxIXOIIO();
                    ox.x0xO0oo xxIO2 = oix0oi.xxIO();
                    XIXIX.Oxx0IOOO oxoX2 = XIXIX.Oxx0IOOO.oxoX(oix0oi.IO0XoXxO());
                    oxoX2.f3771IXxxXO = XIXIX.OOXIXo.X0o0xo(oxoX2.f3771IXxxXO);
                    oxoX2.f3772Oxx0xo = XIXIX.OOXIXo.X0o0xo(oxoX2.f3772Oxx0xo);
                    if (!oix0oi.XoX()) {
                        int i6 = 0;
                        while (i6 < oxox.f35293II0xO0.length * this.f34530II0xO0.II0XooXoX()) {
                            float[] fArr3 = oxox.f35293II0xO0;
                            float f16 = (fArr3[i6] + fArr3[i6 + 2]) / 2.0f;
                            if (!this.f34563oIX0oI.oo0xXOI0I(f16)) {
                                break;
                            }
                            int i7 = i6 + 1;
                            if (!this.f34563oIX0oI.oOXoIIIo(oxox.f35293II0xO0[i7]) || !this.f34563oIX0oI.xI(f16)) {
                                i4 = i6;
                                x0xo0oo = xxIO2;
                                list2 = Oo2;
                                oxx0IOOO2 = oxoX2;
                            } else {
                                int i8 = i6 / 4;
                                BarEntry barEntry4 = (BarEntry) oix0oi.OOXIXo(i8);
                                float I0Io2 = barEntry4.I0Io();
                                if (oix0oi.xoO0xx0()) {
                                    String oxoX3 = xxIO2.oxoX(barEntry4);
                                    float[] fArr4 = oxox.f35293II0xO0;
                                    if (I0Io2 >= 0.0f) {
                                        f13 = fArr4[i7] + f14;
                                    } else {
                                        f13 = fArr4[i6 + 3] + f15;
                                    }
                                    barEntry3 = barEntry4;
                                    f11 = f16;
                                    i4 = i6;
                                    list2 = Oo2;
                                    oxx0IOOO2 = oxoX2;
                                    float f17 = f13;
                                    x0xo0oo = xxIO2;
                                    X0o0xo(canvas, oxoX3, f11, f17, oix0oi.x0xO0oo(i8));
                                } else {
                                    barEntry3 = barEntry4;
                                    f11 = f16;
                                    i4 = i6;
                                    x0xo0oo = xxIO2;
                                    list2 = Oo2;
                                    oxx0IOOO2 = oxoX2;
                                }
                                if (barEntry3.II0xO0() != null && oix0oi.oo0xXOI0I()) {
                                    Drawable II0xO02 = barEntry3.II0xO0();
                                    if (I0Io2 >= 0.0f) {
                                        f12 = oxox.f35293II0xO0[i7] + f14;
                                    } else {
                                        f12 = oxox.f35293II0xO0[i4 + 3] + f15;
                                    }
                                    XIXIX.OOXIXo.OOXIXo(canvas, II0xO02, (int) (f11 + oxx0IOOO2.f3771IXxxXO), (int) (f12 + oxx0IOOO2.f3772Oxx0xo), II0xO02.getIntrinsicWidth(), II0xO02.getIntrinsicHeight());
                                }
                            }
                            i6 = i4 + 4;
                            oxoX2 = oxx0IOOO2;
                            xxIO2 = x0xo0oo;
                            Oo2 = list2;
                        }
                        list = Oo2;
                        oxx0IOOO = oxoX2;
                    } else {
                        list = Oo2;
                        oxx0IOOO = oxoX2;
                        XIXIX.xxIXOIIO oxoX4 = this.f34512II0XooXoX.oxoX(oix0oi.OX00O0xII());
                        int i9 = 0;
                        int i10 = 0;
                        while (i9 < oix0oi.X0xxXX0() * this.f34530II0xO0.II0XooXoX()) {
                            BarEntry barEntry5 = (BarEntry) oix0oi.OOXIXo(i9);
                            float[] oI0IIXIo2 = barEntry5.oI0IIXIo();
                            float[] fArr5 = oxox.f35293II0xO0;
                            float f18 = (fArr5[i10] + fArr5[i10 + 2]) / 2.0f;
                            int x0xO0oo2 = oix0oi.x0xO0oo(i9);
                            if (oI0IIXIo2 == null) {
                                if (!this.f34563oIX0oI.oo0xXOI0I(f18)) {
                                    break;
                                }
                                int i11 = i10 + 1;
                                if (this.f34563oIX0oI.oOXoIIIo(oxox.f35293II0xO0[i11]) && this.f34563oIX0oI.xI(f18)) {
                                    if (oix0oi.xoO0xx0()) {
                                        String oxoX5 = xxIO2.oxoX(barEntry5);
                                        float f19 = oxox.f35293II0xO0[i11];
                                        if (barEntry5.I0Io() >= 0.0f) {
                                            f9 = f14;
                                        } else {
                                            f9 = f15;
                                        }
                                        float f20 = f19 + f9;
                                        f7 = f18;
                                        f3 = X0o0xo2;
                                        fArr = oI0IIXIo2;
                                        barEntry2 = barEntry5;
                                        i = i9;
                                        z = oIX0oI2;
                                        xxixoiio = oxoX4;
                                        X0o0xo(canvas, oxoX5, f7, f20, x0xO0oo2);
                                    } else {
                                        f7 = f18;
                                        i = i9;
                                        f3 = X0o0xo2;
                                        z = oIX0oI2;
                                        fArr = oI0IIXIo2;
                                        barEntry2 = barEntry5;
                                        xxixoiio = oxoX4;
                                    }
                                    if (barEntry2.II0xO0() != null && oix0oi.oo0xXOI0I()) {
                                        Drawable II0xO03 = barEntry2.II0xO0();
                                        float f21 = oxox.f35293II0xO0[i11];
                                        if (barEntry2.I0Io() >= 0.0f) {
                                            f8 = f14;
                                        } else {
                                            f8 = f15;
                                        }
                                        XIXIX.OOXIXo.OOXIXo(canvas, II0xO03, (int) (f7 + oxx0IOOO.f3771IXxxXO), (int) (f21 + f8 + oxx0IOOO.f3772Oxx0xo), II0xO03.getIntrinsicWidth(), II0xO03.getIntrinsicHeight());
                                    }
                                } else {
                                    oxoX4 = oxoX4;
                                    oIX0oI2 = oIX0oI2;
                                    X0o0xo2 = X0o0xo2;
                                    i9 = i9;
                                }
                            } else {
                                float f22 = f18;
                                BarEntry barEntry6 = barEntry5;
                                i = i9;
                                f3 = X0o0xo2;
                                z = oIX0oI2;
                                fArr = oI0IIXIo2;
                                xxixoiio = oxoX4;
                                int length = fArr.length * 2;
                                float[] fArr6 = new float[length];
                                float f23 = -barEntry6.x0xO0oo();
                                int i12 = 0;
                                int i13 = 0;
                                float f24 = 0.0f;
                                while (i12 < length) {
                                    float f25 = fArr[i13];
                                    if (f25 == 0.0f && (f24 == 0.0f || f23 == 0.0f)) {
                                        float f26 = f23;
                                        f23 = f25;
                                        f6 = f26;
                                    } else if (f25 >= 0.0f) {
                                        f24 += f25;
                                        f6 = f23;
                                        f23 = f24;
                                    } else {
                                        f6 = f23 - f25;
                                    }
                                    fArr6[i12 + 1] = f23 * xxIXOIIO2;
                                    i12 += 2;
                                    i13++;
                                    f23 = f6;
                                }
                                xxixoiio.oO(fArr6);
                                int i14 = 0;
                                while (i14 < length) {
                                    float f27 = fArr[i14 / 2];
                                    if ((f27 == 0.0f && f23 == 0.0f && f24 > 0.0f) || f27 < 0.0f) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    float f28 = fArr6[i14 + 1];
                                    if (z2) {
                                        f4 = f15;
                                    } else {
                                        f4 = f14;
                                    }
                                    float f29 = f28 + f4;
                                    xxixoiio2 = xxixoiio;
                                    float f30 = f22;
                                    if (!this.f34563oIX0oI.oo0xXOI0I(f30)) {
                                        break;
                                    }
                                    if (!this.f34563oIX0oI.oOXoIIIo(f29) || !this.f34563oIX0oI.xI(f30)) {
                                        fArr2 = fArr6;
                                        i2 = length;
                                        barEntry = barEntry6;
                                        i3 = i14;
                                    } else {
                                        if (oix0oi.xoO0xx0()) {
                                            BarEntry barEntry7 = barEntry6;
                                            barEntry = barEntry7;
                                            f5 = f29;
                                            i3 = i14;
                                            fArr2 = fArr6;
                                            i2 = length;
                                            X0o0xo(canvas, xxIO2.X0o0xo(f27, barEntry7), f30, f5, x0xO0oo2);
                                        } else {
                                            f5 = f29;
                                            fArr2 = fArr6;
                                            i2 = length;
                                            barEntry = barEntry6;
                                            i3 = i14;
                                        }
                                        if (barEntry.II0xO0() != null && oix0oi.oo0xXOI0I()) {
                                            Drawable II0xO04 = barEntry.II0xO0();
                                            XIXIX.OOXIXo.OOXIXo(canvas, II0xO04, (int) (f30 + oxx0IOOO.f3771IXxxXO), (int) (f5 + oxx0IOOO.f3772Oxx0xo), II0xO04.getIntrinsicWidth(), II0xO04.getIntrinsicHeight());
                                        }
                                    }
                                    i14 = i3 + 2;
                                    barEntry6 = barEntry;
                                    fArr6 = fArr2;
                                    length = i2;
                                    f22 = f30;
                                    xxixoiio = xxixoiio2;
                                }
                            }
                            xxixoiio2 = xxixoiio;
                            if (fArr == null) {
                                i10 += 4;
                            } else {
                                i10 += fArr.length * 4;
                            }
                            i9 = i + 1;
                            oIX0oI2 = z;
                            X0o0xo2 = f3;
                            oxoX4 = xxixoiio2;
                        }
                    }
                    f10 = X0o0xo2;
                    z3 = oIX0oI2;
                    XIXIX.Oxx0IOOO.II0XooXoX(oxx0IOOO);
                }
                i5++;
                oIX0oI2 = z3;
                Oo2 = list;
                X0o0xo2 = f10;
            }
        }
    }

    public void oO(float f, float f2, float f3, float f4, XIXIX.xxIXOIIO xxixoiio) {
        this.f34517xxIXOIIO.set(f - f4, f2, f + f4, f3);
        xxixoiio.IXxxXO(this.f34517xxIXOIIO, this.f34530II0xO0.xxIXOIIO());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xX0IIXIx0.Oxx0IOOO
    public void oxoX(Canvas canvas, XI0oooXX.oxoX[] oxoxArr) {
        float I0Io2;
        float f;
        o0xxxXXxX.oIX0oI barData = this.f34512II0XooXoX.getBarData();
        for (XI0oooXX.oxoX oxox : oxoxArr) {
            IIxOXoOo0.oIX0oI oix0oi = (IIxOXoOo0.oIX0oI) barData.OOXIXo(oxox.oxoX());
            if (oix0oi != null && oix0oi.XX0()) {
                BarEntry barEntry = (BarEntry) oix0oi.Ox0O(oxox.II0XooXoX(), oxox.xoIox());
                if (oOoXoXO(barEntry, oix0oi)) {
                    XIXIX.xxIXOIIO oxoX2 = this.f34512II0XooXoX.oxoX(oix0oi.OX00O0xII());
                    this.f34533oxoX.setColor(oix0oi.X0xII0I());
                    this.f34533oxoX.setAlpha(oix0oi.x0OxxIOxX());
                    if (oxox.Oxx0IOOO() >= 0 && barEntry.OxxIIOOXO()) {
                        if (this.f34512II0XooXoX.II0xO0()) {
                            float Oo2 = barEntry.Oo();
                            f = -barEntry.x0xO0oo();
                            I0Io2 = Oo2;
                        } else {
                            XI0oooXX.xoIox xoiox = barEntry.IXxxXO()[oxox.Oxx0IOOO()];
                            I0Io2 = xoiox.f3731oIX0oI;
                            f = xoiox.f3730II0xO0;
                        }
                    } else {
                        I0Io2 = barEntry.I0Io();
                        f = 0.0f;
                    }
                    oO(barEntry.xxIXOIIO(), I0Io2, f, barData.xII() / 2.0f, oxoX2);
                    x0xO0oo(oxox, this.f34517xxIXOIIO);
                    canvas.drawRect(this.f34517xxIXOIIO, this.f34533oxoX);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
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
                RectF rectF = this.f34515ooOOo0oXI;
                rectF.left = xxIXOIIO3 - xII2;
                rectF.right = xxIXOIIO3 + xII2;
                oxoX2.oI0IIXIo(rectF);
                if (this.f34563oIX0oI.xI(this.f34515ooOOo0oXI.right)) {
                    if (!this.f34563oIX0oI.oo0xXOI0I(this.f34515ooOOo0oXI.left)) {
                        break;
                    }
                    this.f34515ooOOo0oXI.top = this.f34563oIX0oI.xoIox();
                    this.f34515ooOOo0oXI.bottom = this.f34563oIX0oI.XO();
                    canvas.drawRect(this.f34515ooOOo0oXI, this.f34513OOXIXo);
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
            int i4 = i3 + 2;
            if (this.f34563oIX0oI.xI(oxox.f35293II0xO0[i4])) {
                if (this.f34563oIX0oI.oo0xXOI0I(oxox.f35293II0xO0[i3])) {
                    if (!z2) {
                        this.f34529I0Io.setColor(oix0oi.XXoOx0(i3 / 4));
                    }
                    if (oix0oi.IoIOOxIIo() != null) {
                        OX00O0xII.oIX0oI IoIOOxIIo2 = oix0oi.IoIOOxIIo();
                        Paint paint = this.f34529I0Io;
                        float[] fArr = oxox.f35293II0xO0;
                        float f = fArr[i3];
                        paint.setShader(new LinearGradient(f, fArr[i3 + 3], f, fArr[i3 + 1], IoIOOxIIo2.II0xO0(), IoIOOxIIo2.oIX0oI(), Shader.TileMode.MIRROR));
                    }
                    if (oix0oi.IIXOooo() != null) {
                        Paint paint2 = this.f34529I0Io;
                        float[] fArr2 = oxox.f35293II0xO0;
                        float f2 = fArr2[i3];
                        float f3 = fArr2[i3 + 3];
                        float f4 = fArr2[i3 + 1];
                        int i5 = i3 / 4;
                        paint2.setShader(new LinearGradient(f2, f3, f2, f4, oix0oi.oXxOI0oIx(i5).II0xO0(), oix0oi.oXxOI0oIx(i5).oIX0oI(), Shader.TileMode.MIRROR));
                    }
                    float[] fArr3 = oxox.f35293II0xO0;
                    int i6 = i3 + 1;
                    int i7 = i3 + 3;
                    canvas.drawRect(fArr3[i3], fArr3[i6], fArr3[i4], fArr3[i7], this.f34529I0Io);
                    if (z) {
                        float[] fArr4 = oxox.f35293II0xO0;
                        canvas.drawRect(fArr4[i3], fArr4[i6], fArr4[i4], fArr4[i7], this.f34514oOoXoXO);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void x0xO0oo(XI0oooXX.oxoX oxox, RectF rectF) {
        oxox.x0XOIxOo(rectF.centerX(), rectF.top);
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void xoIox() {
        int i;
        o0xxxXXxX.oIX0oI barData = this.f34512II0XooXoX.getBarData();
        this.f34516xoIox = new xxIO.oxoX[barData.ooOOo0oXI()];
        for (int i2 = 0; i2 < this.f34516xoIox.length; i2++) {
            IIxOXoOo0.oIX0oI oix0oi = (IIxOXoOo0.oIX0oI) barData.OOXIXo(i2);
            xxIO.oxoX[] oxoxArr = this.f34516xoIox;
            int X0xxXX02 = oix0oi.X0xxXX0() * 4;
            if (oix0oi.XoX()) {
                i = oix0oi.IXxxXO();
            } else {
                i = 1;
            }
            oxoxArr[i2] = new xxIO.oxoX(X0xxXX02 * i, barData.ooOOo0oXI(), oix0oi.XoX());
        }
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void I0Io(Canvas canvas) {
    }
}
