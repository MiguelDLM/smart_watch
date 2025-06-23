package xX0IIXIx0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import java.util.List;

/* loaded from: classes9.dex */
public class IIXOooo extends OxxIIOOXO {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Path f34518IXxxXO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public Path f34519Oxx0xo;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public float[] f34520oI0IIXIo;

    public IIXOooo(XIXIX.oOoXoXO oooxoxo, YAxis yAxis, XIXIX.xxIXOIIO xxixoiio) {
        super(oooxoxo, yAxis, xxixoiio);
        this.f34518IXxxXO = new Path();
        this.f34519Oxx0xo = new Path();
        this.f34520oI0IIXIo = new float[4];
        this.f34559Oxx0IOOO.setTextAlign(Paint.Align.LEFT);
    }

    @Override // xX0IIXIx0.OxxIIOOXO, xX0IIXIx0.oIX0oI
    public void II0XooXoX(Canvas canvas) {
        if (this.f34536II0XooXoX.XO() && this.f34536II0XooXoX.oOXoIIIo()) {
            this.f34561XO.setColor(this.f34536II0XooXoX.Oxx0xo());
            this.f34561XO.setStrokeWidth(this.f34536II0XooXoX.OxxIIOOXO());
            if (this.f34536II0XooXoX.O00XxXI() == YAxis.AxisDependency.LEFT) {
                canvas.drawLine(this.f34563oIX0oI.II0XooXoX(), this.f34563oIX0oI.xoIox(), this.f34563oIX0oI.xxIXOIIO(), this.f34563oIX0oI.xoIox(), this.f34561XO);
            } else {
                canvas.drawLine(this.f34563oIX0oI.II0XooXoX(), this.f34563oIX0oI.XO(), this.f34563oIX0oI.xxIXOIIO(), this.f34563oIX0oI.XO(), this.f34561XO);
            }
        }
    }

    @Override // xX0IIXIx0.OxxIIOOXO
    public void OOXIXo(Canvas canvas, float f, float[] fArr, float f2) {
        this.f34560X0o0xo.setTypeface(this.f34536II0XooXoX.I0Io());
        this.f34560X0o0xo.setTextSize(this.f34536II0XooXoX.II0xO0());
        this.f34560X0o0xo.setColor(this.f34536II0XooXoX.oIX0oI());
        int i = this.f34536II0XooXoX.XIXIX() ? this.f34536II0XooXoX.f4026x0XOIxOo : this.f34536II0XooXoX.f4026x0XOIxOo - 1;
        for (int i2 = !this.f34536II0XooXoX.xOOOX() ? 1 : 0; i2 < i; i2++) {
            canvas.drawText(this.f34536II0XooXoX.o00(i2), fArr[i2 * 2], f - f2, this.f34560X0o0xo);
        }
    }

    @Override // xX0IIXIx0.OxxIIOOXO, xX0IIXIx0.oIX0oI
    public void Oxx0IOOO(Canvas canvas) {
        float XO2;
        float f;
        float xoIox2;
        if (this.f34536II0XooXoX.XO() && this.f34536II0XooXoX.IO()) {
            float[] x0XOIxOo2 = x0XOIxOo();
            this.f34560X0o0xo.setTypeface(this.f34536II0XooXoX.I0Io());
            this.f34560X0o0xo.setTextSize(this.f34536II0XooXoX.II0xO0());
            this.f34560X0o0xo.setColor(this.f34536II0XooXoX.oIX0oI());
            this.f34560X0o0xo.setTextAlign(Paint.Align.CENTER);
            float X0o0xo2 = XIXIX.OOXIXo.X0o0xo(2.5f);
            float oIX0oI2 = XIXIX.OOXIXo.oIX0oI(this.f34560X0o0xo, "Q");
            YAxis.AxisDependency O00XxXI2 = this.f34536II0XooXoX.O00XxXI();
            YAxis.YAxisLabelPosition ox2 = this.f34536II0XooXoX.ox();
            if (O00XxXI2 == YAxis.AxisDependency.LEFT) {
                if (ox2 == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                    xoIox2 = this.f34563oIX0oI.xoIox();
                } else {
                    xoIox2 = this.f34563oIX0oI.xoIox();
                }
                f = xoIox2 - X0o0xo2;
            } else {
                if (ox2 == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                    XO2 = this.f34563oIX0oI.XO();
                } else {
                    XO2 = this.f34563oIX0oI.XO();
                }
                f = XO2 + oIX0oI2 + X0o0xo2;
            }
            OOXIXo(canvas, f, x0XOIxOo2, this.f34536II0XooXoX.X0o0xo());
        }
    }

    @Override // xX0IIXIx0.oIX0oI
    public void oIX0oI(float f, float f2, boolean z) {
        float f3;
        double d;
        if (this.f34563oIX0oI.Oxx0IOOO() > 10.0f && !this.f34563oIX0oI.XxX0x0xxx()) {
            XIXIX.XO xoIox2 = this.f34557I0Io.xoIox(this.f34563oIX0oI.II0XooXoX(), this.f34563oIX0oI.xoIox());
            XIXIX.XO xoIox3 = this.f34557I0Io.xoIox(this.f34563oIX0oI.xxIXOIIO(), this.f34563oIX0oI.xoIox());
            if (!z) {
                f3 = (float) xoIox2.f3774IXxxXO;
                d = xoIox3.f3774IXxxXO;
            } else {
                f3 = (float) xoIox3.f3774IXxxXO;
                d = xoIox2.f3774IXxxXO;
            }
            float f4 = (float) d;
            XIXIX.XO.I0Io(xoIox2);
            XIXIX.XO.I0Io(xoIox3);
            f = f3;
            f2 = f4;
        }
        II0xO0(f, f2);
    }

    @Override // xX0IIXIx0.OxxIIOOXO
    public Path oO(Path path, int i, float[] fArr) {
        path.moveTo(fArr[i], this.f34563oIX0oI.xoIox());
        path.lineTo(fArr[i], this.f34563oIX0oI.XO());
        return path;
    }

    @Override // xX0IIXIx0.OxxIIOOXO
    public void oOoXoXO(Canvas canvas) {
        int save = canvas.save();
        this.f34542x0XOIxOo.set(this.f34563oIX0oI.Oo());
        this.f34542x0XOIxOo.inset(-this.f34536II0XooXoX.xX0IIXIx0(), 0.0f);
        canvas.clipRect(this.f34538Oo);
        XIXIX.XO XO2 = this.f34557I0Io.XO(0.0f, 0.0f);
        this.f34545xxIXOIIO.setColor(this.f34536II0XooXoX.OX00O0xII());
        this.f34545xxIXOIIO.setStrokeWidth(this.f34536II0XooXoX.xX0IIXIx0());
        Path path = this.f34518IXxxXO;
        path.reset();
        path.moveTo(((float) XO2.f3774IXxxXO) - 1.0f, this.f34563oIX0oI.xoIox());
        path.lineTo(((float) XO2.f3774IXxxXO) - 1.0f, this.f34563oIX0oI.XO());
        canvas.drawPath(path, this.f34545xxIXOIIO);
        canvas.restoreToCount(save);
    }

    @Override // xX0IIXIx0.OxxIIOOXO
    public RectF ooOOo0oXI() {
        this.f34537OOXIXo.set(this.f34563oIX0oI.Oo());
        this.f34537OOXIXo.inset(-this.f34558II0xO0.XI0IXoo(), 0.0f);
        return this.f34537OOXIXo;
    }

    @Override // xX0IIXIx0.OxxIIOOXO
    public float[] x0XOIxOo() {
        int length = this.f34540oOoXoXO.length;
        int i = this.f34536II0XooXoX.f4026x0XOIxOo;
        if (length != i * 2) {
            this.f34540oOoXoXO = new float[i * 2];
        }
        float[] fArr = this.f34540oOoXoXO;
        for (int i2 = 0; i2 < fArr.length; i2 += 2) {
            fArr[i2] = this.f34536II0XooXoX.f4023oOoXoXO[i2 / 2];
        }
        this.f34557I0Io.oO(fArr);
        return fArr;
    }

    @Override // xX0IIXIx0.OxxIIOOXO, xX0IIXIx0.oIX0oI
    public void xoIox(Canvas canvas) {
        List<LimitLine> xxX2 = this.f34536II0XooXoX.xxX();
        if (xxX2 != null && xxX2.size() > 0) {
            float[] fArr = this.f34520oI0IIXIo;
            float f = 0.0f;
            fArr[0] = 0.0f;
            char c = 1;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            Path path = this.f34519Oxx0xo;
            path.reset();
            int i = 0;
            while (i < xxX2.size()) {
                LimitLine limitLine = xxX2.get(i);
                if (limitLine.XO()) {
                    int save = canvas.save();
                    this.f34538Oo.set(this.f34563oIX0oI.Oo());
                    this.f34538Oo.inset(-limitLine.oI0IIXIo(), f);
                    canvas.clipRect(this.f34538Oo);
                    fArr[0] = limitLine.IXxxXO();
                    fArr[2] = limitLine.IXxxXO();
                    this.f34557I0Io.oO(fArr);
                    fArr[c] = this.f34563oIX0oI.xoIox();
                    fArr[3] = this.f34563oIX0oI.XO();
                    path.moveTo(fArr[0], fArr[c]);
                    path.lineTo(fArr[2], fArr[3]);
                    this.f34559Oxx0IOOO.setStyle(Paint.Style.STROKE);
                    this.f34559Oxx0IOOO.setColor(limitLine.Oxx0xo());
                    this.f34559Oxx0IOOO.setPathEffect(limitLine.oO());
                    this.f34559Oxx0IOOO.setStrokeWidth(limitLine.oI0IIXIo());
                    canvas.drawPath(path, this.f34559Oxx0IOOO);
                    path.reset();
                    String x0xO0oo2 = limitLine.x0xO0oo();
                    if (x0xO0oo2 != null && !x0xO0oo2.equals("")) {
                        this.f34559Oxx0IOOO.setStyle(limitLine.OxxIIOOXO());
                        this.f34559Oxx0IOOO.setPathEffect(null);
                        this.f34559Oxx0IOOO.setColor(limitLine.oIX0oI());
                        this.f34559Oxx0IOOO.setTypeface(limitLine.I0Io());
                        this.f34559Oxx0IOOO.setStrokeWidth(0.5f);
                        this.f34559Oxx0IOOO.setTextSize(limitLine.II0xO0());
                        float oI0IIXIo2 = limitLine.oI0IIXIo() + limitLine.oxoX();
                        float X0o0xo2 = XIXIX.OOXIXo.X0o0xo(2.0f) + limitLine.X0o0xo();
                        LimitLine.LimitLabelPosition Oo2 = limitLine.Oo();
                        if (Oo2 == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                            float oIX0oI2 = XIXIX.OOXIXo.oIX0oI(this.f34559Oxx0IOOO, x0xO0oo2);
                            this.f34559Oxx0IOOO.setTextAlign(Paint.Align.LEFT);
                            canvas.drawText(x0xO0oo2, fArr[0] + oI0IIXIo2, this.f34563oIX0oI.xoIox() + X0o0xo2 + oIX0oI2, this.f34559Oxx0IOOO);
                        } else if (Oo2 == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                            this.f34559Oxx0IOOO.setTextAlign(Paint.Align.LEFT);
                            canvas.drawText(x0xO0oo2, fArr[0] + oI0IIXIo2, this.f34563oIX0oI.XO() - X0o0xo2, this.f34559Oxx0IOOO);
                        } else if (Oo2 == LimitLine.LimitLabelPosition.LEFT_TOP) {
                            this.f34559Oxx0IOOO.setTextAlign(Paint.Align.RIGHT);
                            canvas.drawText(x0xO0oo2, fArr[0] - oI0IIXIo2, this.f34563oIX0oI.xoIox() + X0o0xo2 + XIXIX.OOXIXo.oIX0oI(this.f34559Oxx0IOOO, x0xO0oo2), this.f34559Oxx0IOOO);
                        } else {
                            this.f34559Oxx0IOOO.setTextAlign(Paint.Align.RIGHT);
                            canvas.drawText(x0xO0oo2, fArr[0] - oI0IIXIo2, this.f34563oIX0oI.XO() - X0o0xo2, this.f34559Oxx0IOOO);
                        }
                    }
                    canvas.restoreToCount(save);
                }
                i++;
                f = 0.0f;
                c = 1;
            }
        }
    }
}
