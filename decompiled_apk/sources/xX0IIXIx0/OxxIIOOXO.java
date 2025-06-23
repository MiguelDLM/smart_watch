package xX0IIXIx0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import java.util.List;

/* loaded from: classes9.dex */
public class OxxIIOOXO extends oIX0oI {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public YAxis f34536II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public RectF f34537OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public RectF f34538Oo;

    /* renamed from: oO, reason: collision with root package name */
    public Path f34539oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public float[] f34540oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public Path f34541ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public RectF f34542x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public float[] f34543x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public Path f34544xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public Paint f34545xxIXOIIO;

    public OxxIIOOXO(XIXIX.oOoXoXO oooxoxo, YAxis yAxis, XIXIX.xxIXOIIO xxixoiio) {
        super(oooxoxo, xxixoiio, yAxis);
        this.f34544xoIox = new Path();
        this.f34537OOXIXo = new RectF();
        this.f34540oOoXoXO = new float[2];
        this.f34541ooOOo0oXI = new Path();
        this.f34542x0XOIxOo = new RectF();
        this.f34539oO = new Path();
        this.f34543x0xO0oo = new float[2];
        this.f34538Oo = new RectF();
        this.f34536II0XooXoX = yAxis;
        if (this.f34563oIX0oI != null) {
            this.f34560X0o0xo.setColor(ViewCompat.MEASURED_STATE_MASK);
            this.f34560X0o0xo.setTextSize(XIXIX.OOXIXo.X0o0xo(10.0f));
            Paint paint = new Paint(1);
            this.f34545xxIXOIIO = paint;
            paint.setColor(-7829368);
            this.f34545xxIXOIIO.setStrokeWidth(1.0f);
            this.f34545xxIXOIIO.setStyle(Paint.Style.STROKE);
        }
    }

    @Override // xX0IIXIx0.oIX0oI
    public void II0XooXoX(Canvas canvas) {
        if (this.f34536II0XooXoX.XO() && this.f34536II0XooXoX.oOXoIIIo()) {
            this.f34561XO.setColor(this.f34536II0XooXoX.Oxx0xo());
            this.f34561XO.setStrokeWidth(this.f34536II0XooXoX.OxxIIOOXO());
            if (this.f34536II0XooXoX.O00XxXI() == YAxis.AxisDependency.LEFT) {
                canvas.drawLine(this.f34563oIX0oI.II0XooXoX(), this.f34563oIX0oI.xoIox(), this.f34563oIX0oI.II0XooXoX(), this.f34563oIX0oI.XO(), this.f34561XO);
            } else {
                canvas.drawLine(this.f34563oIX0oI.xxIXOIIO(), this.f34563oIX0oI.xoIox(), this.f34563oIX0oI.xxIXOIIO(), this.f34563oIX0oI.XO(), this.f34561XO);
            }
        }
    }

    public void OOXIXo(Canvas canvas, float f, float[] fArr, float f2) {
        int i = this.f34536II0XooXoX.XIXIX() ? this.f34536II0XooXoX.f4026x0XOIxOo : this.f34536II0XooXoX.f4026x0XOIxOo - 1;
        for (int i2 = !this.f34536II0XooXoX.xOOOX() ? 1 : 0; i2 < i; i2++) {
            canvas.drawText(this.f34536II0XooXoX.o00(i2), f, fArr[(i2 * 2) + 1] + f2, this.f34560X0o0xo);
        }
    }

    @Override // xX0IIXIx0.oIX0oI
    public void Oxx0IOOO(Canvas canvas) {
        float xxIXOIIO2;
        float xxIXOIIO3;
        float f;
        if (this.f34536II0XooXoX.XO() && this.f34536II0XooXoX.IO()) {
            float[] x0XOIxOo2 = x0XOIxOo();
            this.f34560X0o0xo.setTypeface(this.f34536II0XooXoX.I0Io());
            this.f34560X0o0xo.setTextSize(this.f34536II0XooXoX.II0xO0());
            this.f34560X0o0xo.setColor(this.f34536II0XooXoX.oIX0oI());
            float oxoX2 = this.f34536II0XooXoX.oxoX();
            float oIX0oI2 = (XIXIX.OOXIXo.oIX0oI(this.f34560X0o0xo, "A") / 2.5f) + this.f34536II0XooXoX.X0o0xo();
            YAxis.AxisDependency O00XxXI2 = this.f34536II0XooXoX.O00XxXI();
            YAxis.YAxisLabelPosition ox2 = this.f34536II0XooXoX.ox();
            if (O00XxXI2 == YAxis.AxisDependency.LEFT) {
                if (ox2 == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                    this.f34560X0o0xo.setTextAlign(Paint.Align.RIGHT);
                    xxIXOIIO2 = this.f34563oIX0oI.IO();
                    f = xxIXOIIO2 - oxoX2;
                } else {
                    this.f34560X0o0xo.setTextAlign(Paint.Align.LEFT);
                    xxIXOIIO3 = this.f34563oIX0oI.IO();
                    f = xxIXOIIO3 + oxoX2;
                }
            } else if (ox2 == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                this.f34560X0o0xo.setTextAlign(Paint.Align.LEFT);
                xxIXOIIO3 = this.f34563oIX0oI.xxIXOIIO();
                f = xxIXOIIO3 + oxoX2;
            } else {
                this.f34560X0o0xo.setTextAlign(Paint.Align.RIGHT);
                xxIXOIIO2 = this.f34563oIX0oI.xxIXOIIO();
                f = xxIXOIIO2 - oxoX2;
            }
            OOXIXo(canvas, f, x0XOIxOo2, oIX0oI2);
        }
    }

    public Path oO(Path path, int i, float[] fArr) {
        int i2 = i + 1;
        path.moveTo(this.f34563oIX0oI.IO(), fArr[i2]);
        path.lineTo(this.f34563oIX0oI.xxIXOIIO(), fArr[i2]);
        return path;
    }

    public void oOoXoXO(Canvas canvas) {
        int save = canvas.save();
        this.f34542x0XOIxOo.set(this.f34563oIX0oI.Oo());
        this.f34542x0XOIxOo.inset(0.0f, -this.f34536II0XooXoX.xX0IIXIx0());
        canvas.clipRect(this.f34542x0XOIxOo);
        XIXIX.XO XO2 = this.f34557I0Io.XO(0.0f, 0.0f);
        this.f34545xxIXOIIO.setColor(this.f34536II0XooXoX.OX00O0xII());
        this.f34545xxIXOIIO.setStrokeWidth(this.f34536II0XooXoX.xX0IIXIx0());
        Path path = this.f34541ooOOo0oXI;
        path.reset();
        path.moveTo(this.f34563oIX0oI.II0XooXoX(), (float) XO2.f3775Oxx0xo);
        path.lineTo(this.f34563oIX0oI.xxIXOIIO(), (float) XO2.f3775Oxx0xo);
        canvas.drawPath(path, this.f34545xxIXOIIO);
        canvas.restoreToCount(save);
    }

    public RectF ooOOo0oXI() {
        this.f34537OOXIXo.set(this.f34563oIX0oI.Oo());
        this.f34537OOXIXo.inset(0.0f, -this.f34558II0xO0.XI0IXoo());
        return this.f34537OOXIXo;
    }

    public float[] x0XOIxOo() {
        int length = this.f34540oOoXoXO.length;
        int i = this.f34536II0XooXoX.f4026x0XOIxOo;
        if (length != i * 2) {
            this.f34540oOoXoXO = new float[i * 2];
        }
        float[] fArr = this.f34540oOoXoXO;
        for (int i2 = 0; i2 < fArr.length; i2 += 2) {
            fArr[i2 + 1] = this.f34536II0XooXoX.f4023oOoXoXO[i2 / 2];
        }
        this.f34557I0Io.oO(fArr);
        return fArr;
    }

    @Override // xX0IIXIx0.oIX0oI
    public void xoIox(Canvas canvas) {
        List<LimitLine> xxX2 = this.f34536II0XooXoX.xxX();
        if (xxX2 != null && xxX2.size() > 0) {
            float[] fArr = this.f34543x0xO0oo;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            Path path = this.f34539oO;
            path.reset();
            for (int i = 0; i < xxX2.size(); i++) {
                LimitLine limitLine = xxX2.get(i);
                if (limitLine.XO()) {
                    int save = canvas.save();
                    this.f34538Oo.set(this.f34563oIX0oI.Oo());
                    this.f34538Oo.inset(0.0f, -limitLine.oI0IIXIo());
                    canvas.clipRect(this.f34538Oo);
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
                        this.f34559Oxx0IOOO.setTypeface(limitLine.I0Io());
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

    @Override // xX0IIXIx0.oIX0oI
    public void xxIXOIIO(Canvas canvas) {
        if (!this.f34536II0XooXoX.XO()) {
            return;
        }
        if (this.f34536II0XooXoX.X00IoxXI()) {
            int save = canvas.save();
            canvas.clipRect(ooOOo0oXI());
            float[] x0XOIxOo2 = x0XOIxOo();
            this.f34562oxoX.setColor(this.f34536II0XooXoX.O0xOxO());
            this.f34562oxoX.setStrokeWidth(this.f34536II0XooXoX.XI0IXoo());
            this.f34562oxoX.setPathEffect(this.f34536II0XooXoX.X0IIOO());
            Path path = this.f34544xoIox;
            path.reset();
            for (int i = 0; i < x0XOIxOo2.length; i += 2) {
                canvas.drawPath(oO(path, i, x0XOIxOo2), this.f34562oxoX);
                path.reset();
            }
            canvas.restoreToCount(save);
        }
        if (this.f34536II0XooXoX.oXIO0o0XI()) {
            oOoXoXO(canvas);
        }
    }
}
