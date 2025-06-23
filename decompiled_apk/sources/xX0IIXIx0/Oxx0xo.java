package xX0IIXIx0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import java.util.List;

/* loaded from: classes9.dex */
public class Oxx0xo extends IXxxXO {

    /* renamed from: Oo, reason: collision with root package name */
    public Path f34534Oo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public BarChart f34535x0xO0oo;

    public Oxx0xo(XIXIX.oOoXoXO oooxoxo, XAxis xAxis, XIXIX.xxIXOIIO xxixoiio, BarChart barChart) {
        super(oooxoxo, xAxis, xxixoiio);
        this.f34534Oo = new Path();
        this.f34535x0xO0oo = barChart;
    }

    @Override // xX0IIXIx0.IXxxXO, xX0IIXIx0.oIX0oI
    public void II0XooXoX(Canvas canvas) {
        if (this.f34521II0XooXoX.oOXoIIIo() && this.f34521II0XooXoX.XO()) {
            this.f34561XO.setColor(this.f34521II0XooXoX.Oxx0xo());
            this.f34561XO.setStrokeWidth(this.f34521II0XooXoX.OxxIIOOXO());
            if (this.f34521II0XooXoX.ox() == XAxis.XAxisPosition.TOP || this.f34521II0XooXoX.ox() == XAxis.XAxisPosition.TOP_INSIDE || this.f34521II0XooXoX.ox() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f34563oIX0oI.xxIXOIIO(), this.f34563oIX0oI.xoIox(), this.f34563oIX0oI.xxIXOIIO(), this.f34563oIX0oI.XO(), this.f34561XO);
            }
            if (this.f34521II0XooXoX.ox() == XAxis.XAxisPosition.BOTTOM || this.f34521II0XooXoX.ox() == XAxis.XAxisPosition.BOTTOM_INSIDE || this.f34521II0XooXoX.ox() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f34563oIX0oI.II0XooXoX(), this.f34563oIX0oI.xoIox(), this.f34563oIX0oI.II0XooXoX(), this.f34563oIX0oI.XO(), this.f34561XO);
            }
        }
    }

    @Override // xX0IIXIx0.IXxxXO
    public void OOXIXo() {
        this.f34560X0o0xo.setTypeface(this.f34521II0XooXoX.I0Io());
        this.f34560X0o0xo.setTextSize(this.f34521II0XooXoX.II0xO0());
        XIXIX.I0Io II0xO02 = XIXIX.OOXIXo.II0xO0(this.f34560X0o0xo, this.f34521II0XooXoX.XxX0x0xxx());
        float oxoX2 = (int) (II0xO02.f3743IXxxXO + (this.f34521II0XooXoX.oxoX() * 3.5f));
        float f = II0xO02.f3744Oxx0xo;
        XIXIX.I0Io xxX2 = XIXIX.OOXIXo.xxX(II0xO02.f3743IXxxXO, f, this.f34521II0XooXoX.O00XxXI());
        this.f34521II0XooXoX.f15979oo0xXOI0I = Math.round(oxoX2);
        this.f34521II0XooXoX.f15978oo = Math.round(f);
        XAxis xAxis = this.f34521II0XooXoX;
        xAxis.f15974IoOoX = (int) (xxX2.f3743IXxxXO + (xAxis.oxoX() * 3.5f));
        this.f34521II0XooXoX.f15977oOXoIIIo = Math.round(xxX2.f3744Oxx0xo);
        XIXIX.I0Io.I0Io(xxX2);
    }

    @Override // xX0IIXIx0.IXxxXO, xX0IIXIx0.oIX0oI
    public void Oxx0IOOO(Canvas canvas) {
        if (this.f34521II0XooXoX.XO() && this.f34521II0XooXoX.IO()) {
            float oxoX2 = this.f34521II0XooXoX.oxoX();
            this.f34560X0o0xo.setTypeface(this.f34521II0XooXoX.I0Io());
            this.f34560X0o0xo.setTextSize(this.f34521II0XooXoX.II0xO0());
            this.f34560X0o0xo.setColor(this.f34521II0XooXoX.oIX0oI());
            XIXIX.Oxx0IOOO I0Io2 = XIXIX.Oxx0IOOO.I0Io(0.0f, 0.0f);
            if (this.f34521II0XooXoX.ox() == XAxis.XAxisPosition.TOP) {
                I0Io2.f3771IXxxXO = 0.0f;
                I0Io2.f3772Oxx0xo = 0.5f;
                x0XOIxOo(canvas, this.f34563oIX0oI.xxIXOIIO() + oxoX2, I0Io2);
            } else if (this.f34521II0XooXoX.ox() == XAxis.XAxisPosition.TOP_INSIDE) {
                I0Io2.f3771IXxxXO = 1.0f;
                I0Io2.f3772Oxx0xo = 0.5f;
                x0XOIxOo(canvas, this.f34563oIX0oI.xxIXOIIO() - oxoX2, I0Io2);
            } else if (this.f34521II0XooXoX.ox() == XAxis.XAxisPosition.BOTTOM) {
                I0Io2.f3771IXxxXO = 1.0f;
                I0Io2.f3772Oxx0xo = 0.5f;
                x0XOIxOo(canvas, this.f34563oIX0oI.II0XooXoX() - oxoX2, I0Io2);
            } else if (this.f34521II0XooXoX.ox() == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                I0Io2.f3771IXxxXO = 1.0f;
                I0Io2.f3772Oxx0xo = 0.5f;
                x0XOIxOo(canvas, this.f34563oIX0oI.II0XooXoX() + oxoX2, I0Io2);
            } else {
                I0Io2.f3771IXxxXO = 0.0f;
                I0Io2.f3772Oxx0xo = 0.5f;
                x0XOIxOo(canvas, this.f34563oIX0oI.xxIXOIIO() + oxoX2, I0Io2);
                I0Io2.f3771IXxxXO = 1.0f;
                I0Io2.f3772Oxx0xo = 0.5f;
                x0XOIxOo(canvas, this.f34563oIX0oI.II0XooXoX() - oxoX2, I0Io2);
            }
            XIXIX.Oxx0IOOO.II0XooXoX(I0Io2);
        }
    }

    @Override // xX0IIXIx0.IXxxXO, xX0IIXIx0.oIX0oI
    public void oIX0oI(float f, float f2, boolean z) {
        float f3;
        double d;
        if (this.f34563oIX0oI.OOXIXo() > 10.0f && !this.f34563oIX0oI.xXxxox0I()) {
            XIXIX.XO xoIox2 = this.f34557I0Io.xoIox(this.f34563oIX0oI.II0XooXoX(), this.f34563oIX0oI.XO());
            XIXIX.XO xoIox3 = this.f34557I0Io.xoIox(this.f34563oIX0oI.II0XooXoX(), this.f34563oIX0oI.xoIox());
            if (z) {
                f3 = (float) xoIox3.f3775Oxx0xo;
                d = xoIox2.f3775Oxx0xo;
            } else {
                f3 = (float) xoIox2.f3775Oxx0xo;
                d = xoIox3.f3775Oxx0xo;
            }
            float f4 = (float) d;
            XIXIX.XO.I0Io(xoIox2);
            XIXIX.XO.I0Io(xoIox3);
            f = f3;
            f2 = f4;
        }
        II0xO0(f, f2);
    }

    @Override // xX0IIXIx0.IXxxXO
    public RectF oO() {
        this.f34522OOXIXo.set(this.f34563oIX0oI.Oo());
        this.f34522OOXIXo.inset(0.0f, -this.f34558II0xO0.XI0IXoo());
        return this.f34522OOXIXo;
    }

    @Override // xX0IIXIx0.IXxxXO
    public void oOoXoXO(Canvas canvas, float f, float f2, Path path) {
        path.moveTo(this.f34563oIX0oI.xxIXOIIO(), f2);
        path.lineTo(this.f34563oIX0oI.II0XooXoX(), f2);
        canvas.drawPath(path, this.f34562oxoX);
        path.reset();
    }

    @Override // xX0IIXIx0.IXxxXO
    public void x0XOIxOo(Canvas canvas, float f, XIXIX.Oxx0IOOO oxx0IOOO) {
        float O00XxXI2 = this.f34521II0XooXoX.O00XxXI();
        boolean IoOoX2 = this.f34521II0XooXoX.IoOoX();
        int i = this.f34521II0XooXoX.f4026x0XOIxOo * 2;
        float[] fArr = new float[i];
        for (int i2 = 0; i2 < i; i2 += 2) {
            if (IoOoX2) {
                fArr[i2 + 1] = this.f34521II0XooXoX.f4024ooOOo0oXI[i2 / 2];
            } else {
                fArr[i2 + 1] = this.f34521II0XooXoX.f4023oOoXoXO[i2 / 2];
            }
        }
        this.f34557I0Io.oO(fArr);
        for (int i3 = 0; i3 < i; i3 += 2) {
            float f2 = fArr[i3 + 1];
            if (this.f34563oIX0oI.oOXoIIIo(f2)) {
                ox.x0xO0oo ooXIXxIX2 = this.f34521II0XooXoX.ooXIXxIX();
                XAxis xAxis = this.f34521II0XooXoX;
                ooOOo0oXI(canvas, ooXIXxIX2.I0Io(xAxis.f4023oOoXoXO[i3 / 2], xAxis), f, f2, oxx0IOOO, O00XxXI2);
            }
        }
    }

    @Override // xX0IIXIx0.IXxxXO, xX0IIXIx0.oIX0oI
    public void xoIox(Canvas canvas) {
        List<LimitLine> xxX2 = this.f34521II0XooXoX.xxX();
        if (xxX2 != null && xxX2.size() > 0) {
            float[] fArr = this.f34524oOoXoXO;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            Path path = this.f34534Oo;
            path.reset();
            for (int i = 0; i < xxX2.size(); i++) {
                LimitLine limitLine = xxX2.get(i);
                if (limitLine.XO()) {
                    int save = canvas.save();
                    this.f34525ooOOo0oXI.set(this.f34563oIX0oI.Oo());
                    this.f34525ooOOo0oXI.inset(0.0f, -limitLine.oI0IIXIo());
                    canvas.clipRect(this.f34525ooOOo0oXI);
                    this.f34559Oxx0IOOO.setStyle(Paint.Style.STROKE);
                    this.f34559Oxx0IOOO.setColor(limitLine.Oxx0xo());
                    this.f34559Oxx0IOOO.setStrokeWidth(limitLine.oI0IIXIo());
                    this.f34559Oxx0IOOO.setPathEffect(limitLine.oO());
                    fArr[1] = limitLine.IXxxXO();
                    this.f34557I0Io.oO(fArr);
                    path.moveTo(this.f34563oIX0oI.II0XooXoX(), fArr[1]);
                    path.lineTo(this.f34563oIX0oI.xxIXOIIO(), fArr[1]);
                    canvas.drawPath(path, this.f34559Oxx0IOOO);
                    path.reset();
                    String x0xO0oo2 = limitLine.x0xO0oo();
                    if (x0xO0oo2 != null && !x0xO0oo2.equals("")) {
                        this.f34559Oxx0IOOO.setStyle(limitLine.OxxIIOOXO());
                        this.f34559Oxx0IOOO.setPathEffect(null);
                        this.f34559Oxx0IOOO.setColor(limitLine.oIX0oI());
                        this.f34559Oxx0IOOO.setStrokeWidth(0.5f);
                        this.f34559Oxx0IOOO.setTextSize(limitLine.II0xO0());
                        float oIX0oI2 = XIXIX.OOXIXo.oIX0oI(this.f34559Oxx0IOOO, x0xO0oo2);
                        float X0o0xo2 = XIXIX.OOXIXo.X0o0xo(4.0f) + limitLine.oxoX();
                        float oI0IIXIo2 = limitLine.oI0IIXIo() + oIX0oI2 + limitLine.X0o0xo();
                        LimitLine.LimitLabelPosition Oo2 = limitLine.Oo();
                        if (Oo2 == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                            this.f34559Oxx0IOOO.setTextAlign(Paint.Align.RIGHT);
                            canvas.drawText(x0xO0oo2, this.f34563oIX0oI.xxIXOIIO() - X0o0xo2, (fArr[1] - oI0IIXIo2) + oIX0oI2, this.f34559Oxx0IOOO);
                        } else if (Oo2 == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                            this.f34559Oxx0IOOO.setTextAlign(Paint.Align.RIGHT);
                            canvas.drawText(x0xO0oo2, this.f34563oIX0oI.xxIXOIIO() - X0o0xo2, fArr[1] + oI0IIXIo2, this.f34559Oxx0IOOO);
                        } else if (Oo2 == LimitLine.LimitLabelPosition.LEFT_TOP) {
                            this.f34559Oxx0IOOO.setTextAlign(Paint.Align.LEFT);
                            canvas.drawText(x0xO0oo2, this.f34563oIX0oI.II0XooXoX() + X0o0xo2, (fArr[1] - oI0IIXIo2) + oIX0oI2, this.f34559Oxx0IOOO);
                        } else {
                            this.f34559Oxx0IOOO.setTextAlign(Paint.Align.LEFT);
                            canvas.drawText(x0xO0oo2, this.f34563oIX0oI.IO() + X0o0xo2, fArr[1] + oI0IIXIo2, this.f34559Oxx0IOOO);
                        }
                    }
                    canvas.restoreToCount(save);
                }
            }
        }
    }
}
