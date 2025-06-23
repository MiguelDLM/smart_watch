package xX0IIXIx0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import java.util.List;

/* loaded from: classes9.dex */
public class IXxxXO extends oIX0oI {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public XAxis f34521II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public RectF f34522OOXIXo;

    /* renamed from: oO, reason: collision with root package name */
    public Path f34523oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public float[] f34524oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public RectF f34525ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public float[] f34526x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public float[] f34527xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public Path f34528xxIXOIIO;

    public IXxxXO(XIXIX.oOoXoXO oooxoxo, XAxis xAxis, XIXIX.xxIXOIIO xxixoiio) {
        super(oooxoxo, xxixoiio, xAxis);
        this.f34528xxIXOIIO = new Path();
        this.f34527xoIox = new float[2];
        this.f34522OOXIXo = new RectF();
        this.f34524oOoXoXO = new float[2];
        this.f34525ooOOo0oXI = new RectF();
        this.f34526x0XOIxOo = new float[4];
        this.f34523oO = new Path();
        this.f34521II0XooXoX = xAxis;
        this.f34560X0o0xo.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f34560X0o0xo.setTextAlign(Paint.Align.CENTER);
        this.f34560X0o0xo.setTextSize(XIXIX.OOXIXo.X0o0xo(10.0f));
    }

    @Override // xX0IIXIx0.oIX0oI
    public void II0XooXoX(Canvas canvas) {
        if (this.f34521II0XooXoX.oOXoIIIo() && this.f34521II0XooXoX.XO()) {
            this.f34561XO.setColor(this.f34521II0XooXoX.Oxx0xo());
            this.f34561XO.setStrokeWidth(this.f34521II0XooXoX.OxxIIOOXO());
            this.f34561XO.setPathEffect(this.f34521II0XooXoX.oI0IIXIo());
            if (this.f34521II0XooXoX.ox() == XAxis.XAxisPosition.TOP || this.f34521II0XooXoX.ox() == XAxis.XAxisPosition.TOP_INSIDE || this.f34521II0XooXoX.ox() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f34563oIX0oI.II0XooXoX(), this.f34563oIX0oI.xoIox(), this.f34563oIX0oI.xxIXOIIO(), this.f34563oIX0oI.xoIox(), this.f34561XO);
            }
            if (this.f34521II0XooXoX.ox() == XAxis.XAxisPosition.BOTTOM || this.f34521II0XooXoX.ox() == XAxis.XAxisPosition.BOTTOM_INSIDE || this.f34521II0XooXoX.ox() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f34563oIX0oI.II0XooXoX(), this.f34563oIX0oI.XO(), this.f34563oIX0oI.xxIXOIIO(), this.f34563oIX0oI.XO(), this.f34561XO);
            }
        }
    }

    @Override // xX0IIXIx0.oIX0oI
    public void II0xO0(float f, float f2) {
        super.II0xO0(f, f2);
        OOXIXo();
    }

    public void IXxxXO() {
        this.f34562oxoX.setColor(this.f34521II0XooXoX.O0xOxO());
        this.f34562oxoX.setStrokeWidth(this.f34521II0XooXoX.XI0IXoo());
        this.f34562oxoX.setPathEffect(this.f34521II0XooXoX.X0IIOO());
    }

    public void OOXIXo() {
        String XxX0x0xxx2 = this.f34521II0XooXoX.XxX0x0xxx();
        this.f34560X0o0xo.setTypeface(this.f34521II0XooXoX.I0Io());
        this.f34560X0o0xo.setTextSize(this.f34521II0XooXoX.II0xO0());
        XIXIX.I0Io II0xO02 = XIXIX.OOXIXo.II0xO0(this.f34560X0o0xo, XxX0x0xxx2);
        float f = II0xO02.f3743IXxxXO;
        float oIX0oI2 = XIXIX.OOXIXo.oIX0oI(this.f34560X0o0xo, "Q");
        XIXIX.I0Io xxX2 = XIXIX.OOXIXo.xxX(f, oIX0oI2, this.f34521II0XooXoX.O00XxXI());
        this.f34521II0XooXoX.f15979oo0xXOI0I = Math.round(f);
        this.f34521II0XooXoX.f15978oo = Math.round(oIX0oI2);
        this.f34521II0XooXoX.f15974IoOoX = Math.round(xxX2.f3743IXxxXO);
        this.f34521II0XooXoX.f15977oOXoIIIo = Math.round(xxX2.f3744Oxx0xo);
        XIXIX.I0Io.I0Io(xxX2);
        XIXIX.I0Io.I0Io(II0xO02);
    }

    public void Oo(Canvas canvas, LimitLine limitLine, float[] fArr) {
        float[] fArr2 = this.f34526x0XOIxOo;
        fArr2[0] = fArr[0];
        fArr2[1] = this.f34563oIX0oI.xoIox();
        float[] fArr3 = this.f34526x0XOIxOo;
        fArr3[2] = fArr[0];
        fArr3[3] = this.f34563oIX0oI.XO();
        this.f34523oO.reset();
        Path path = this.f34523oO;
        float[] fArr4 = this.f34526x0XOIxOo;
        path.moveTo(fArr4[0], fArr4[1]);
        Path path2 = this.f34523oO;
        float[] fArr5 = this.f34526x0XOIxOo;
        path2.lineTo(fArr5[2], fArr5[3]);
        this.f34559Oxx0IOOO.setStyle(Paint.Style.STROKE);
        this.f34559Oxx0IOOO.setColor(limitLine.Oxx0xo());
        this.f34559Oxx0IOOO.setStrokeWidth(limitLine.oI0IIXIo());
        this.f34559Oxx0IOOO.setPathEffect(limitLine.oO());
        canvas.drawPath(this.f34523oO, this.f34559Oxx0IOOO);
    }

    @Override // xX0IIXIx0.oIX0oI
    public void Oxx0IOOO(Canvas canvas) {
        if (this.f34521II0XooXoX.XO() && this.f34521II0XooXoX.IO()) {
            float X0o0xo2 = this.f34521II0XooXoX.X0o0xo();
            this.f34560X0o0xo.setTypeface(this.f34521II0XooXoX.I0Io());
            this.f34560X0o0xo.setTextSize(this.f34521II0XooXoX.II0xO0());
            this.f34560X0o0xo.setColor(this.f34521II0XooXoX.oIX0oI());
            XIXIX.Oxx0IOOO I0Io2 = XIXIX.Oxx0IOOO.I0Io(0.0f, 0.0f);
            if (this.f34521II0XooXoX.ox() == XAxis.XAxisPosition.TOP) {
                I0Io2.f3771IXxxXO = 0.5f;
                I0Io2.f3772Oxx0xo = 1.0f;
                x0XOIxOo(canvas, this.f34563oIX0oI.xoIox() - X0o0xo2, I0Io2);
            } else if (this.f34521II0XooXoX.ox() == XAxis.XAxisPosition.TOP_INSIDE) {
                I0Io2.f3771IXxxXO = 0.5f;
                I0Io2.f3772Oxx0xo = 1.0f;
                x0XOIxOo(canvas, this.f34563oIX0oI.xoIox() + X0o0xo2 + this.f34521II0XooXoX.f15977oOXoIIIo, I0Io2);
            } else if (this.f34521II0XooXoX.ox() == XAxis.XAxisPosition.BOTTOM) {
                I0Io2.f3771IXxxXO = 0.5f;
                I0Io2.f3772Oxx0xo = 0.0f;
                x0XOIxOo(canvas, this.f34563oIX0oI.XO() + X0o0xo2, I0Io2);
            } else if (this.f34521II0XooXoX.ox() == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                I0Io2.f3771IXxxXO = 0.5f;
                I0Io2.f3772Oxx0xo = 0.0f;
                x0XOIxOo(canvas, (this.f34563oIX0oI.XO() - X0o0xo2) - this.f34521II0XooXoX.f15977oOXoIIIo, I0Io2);
            } else {
                I0Io2.f3771IXxxXO = 0.5f;
                I0Io2.f3772Oxx0xo = 1.0f;
                x0XOIxOo(canvas, this.f34563oIX0oI.xoIox() - X0o0xo2, I0Io2);
                I0Io2.f3771IXxxXO = 0.5f;
                I0Io2.f3772Oxx0xo = 0.0f;
                x0XOIxOo(canvas, this.f34563oIX0oI.XO() + X0o0xo2, I0Io2);
            }
            XIXIX.Oxx0IOOO.II0XooXoX(I0Io2);
        }
    }

    @Override // xX0IIXIx0.oIX0oI
    public void oIX0oI(float f, float f2, boolean z) {
        float f3;
        double d;
        if (this.f34563oIX0oI.OOXIXo() > 10.0f && !this.f34563oIX0oI.XxX0x0xxx()) {
            XIXIX.XO xoIox2 = this.f34557I0Io.xoIox(this.f34563oIX0oI.II0XooXoX(), this.f34563oIX0oI.xoIox());
            XIXIX.XO xoIox3 = this.f34557I0Io.xoIox(this.f34563oIX0oI.xxIXOIIO(), this.f34563oIX0oI.xoIox());
            if (z) {
                f3 = (float) xoIox3.f3774IXxxXO;
                d = xoIox2.f3774IXxxXO;
            } else {
                f3 = (float) xoIox2.f3774IXxxXO;
                d = xoIox3.f3774IXxxXO;
            }
            float f4 = (float) d;
            XIXIX.XO.I0Io(xoIox2);
            XIXIX.XO.I0Io(xoIox3);
            f = f3;
            f2 = f4;
        }
        II0xO0(f, f2);
    }

    public RectF oO() {
        this.f34522OOXIXo.set(this.f34563oIX0oI.Oo());
        this.f34522OOXIXo.inset(-this.f34558II0xO0.XI0IXoo(), 0.0f);
        return this.f34522OOXIXo;
    }

    public void oOoXoXO(Canvas canvas, float f, float f2, Path path) {
        path.moveTo(f, this.f34563oIX0oI.XO());
        path.lineTo(f, this.f34563oIX0oI.xoIox());
        canvas.drawPath(path, this.f34562oxoX);
        path.reset();
    }

    public void ooOOo0oXI(Canvas canvas, String str, float f, float f2, XIXIX.Oxx0IOOO oxx0IOOO, float f3) {
        XIXIX.OOXIXo.x0XOIxOo(canvas, str, f, f2, this.f34560X0o0xo, oxx0IOOO, f3);
    }

    public void x0XOIxOo(Canvas canvas, float f, XIXIX.Oxx0IOOO oxx0IOOO) {
        float O00XxXI2 = this.f34521II0XooXoX.O00XxXI();
        boolean IoOoX2 = this.f34521II0XooXoX.IoOoX();
        int i = this.f34521II0XooXoX.f4026x0XOIxOo * 2;
        float[] fArr = new float[i];
        for (int i2 = 0; i2 < i; i2 += 2) {
            if (IoOoX2) {
                fArr[i2] = this.f34521II0XooXoX.f4024ooOOo0oXI[i2 / 2];
            } else {
                fArr[i2] = this.f34521II0XooXoX.f4023oOoXoXO[i2 / 2];
            }
        }
        this.f34557I0Io.oO(fArr);
        for (int i3 = 0; i3 < i; i3 += 2) {
            float f2 = fArr[i3];
            if (this.f34563oIX0oI.IoOoX(f2)) {
                ox.x0xO0oo ooXIXxIX2 = this.f34521II0XooXoX.ooXIXxIX();
                XAxis xAxis = this.f34521II0XooXoX;
                int i4 = i3 / 2;
                String I0Io2 = ooXIXxIX2.I0Io(xAxis.f4023oOoXoXO[i4], xAxis);
                if (this.f34521II0XooXoX.XI0oooXX()) {
                    int i5 = this.f34521II0XooXoX.f4026x0XOIxOo;
                    if (i4 == i5 - 1 && i5 > 1) {
                        float oxoX2 = XIXIX.OOXIXo.oxoX(this.f34560X0o0xo, I0Io2);
                        if (oxoX2 > this.f34563oIX0oI.xII() * 2.0f && f2 + oxoX2 > this.f34563oIX0oI.oO()) {
                            f2 -= oxoX2 / 2.0f;
                        }
                    } else if (i3 == 0) {
                        f2 += XIXIX.OOXIXo.oxoX(this.f34560X0o0xo, I0Io2) / 2.0f;
                    }
                }
                ooOOo0oXI(canvas, I0Io2, f2, f, oxx0IOOO, O00XxXI2);
            }
        }
    }

    public void x0xO0oo(Canvas canvas, LimitLine limitLine, float[] fArr, float f) {
        String x0xO0oo2 = limitLine.x0xO0oo();
        if (x0xO0oo2 != null && !x0xO0oo2.equals("")) {
            this.f34559Oxx0IOOO.setStyle(limitLine.OxxIIOOXO());
            this.f34559Oxx0IOOO.setPathEffect(null);
            this.f34559Oxx0IOOO.setColor(limitLine.oIX0oI());
            this.f34559Oxx0IOOO.setStrokeWidth(0.5f);
            this.f34559Oxx0IOOO.setTextSize(limitLine.II0xO0());
            float oI0IIXIo2 = limitLine.oI0IIXIo() + limitLine.oxoX();
            LimitLine.LimitLabelPosition Oo2 = limitLine.Oo();
            if (Oo2 == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                float oIX0oI2 = XIXIX.OOXIXo.oIX0oI(this.f34559Oxx0IOOO, x0xO0oo2);
                this.f34559Oxx0IOOO.setTextAlign(Paint.Align.LEFT);
                canvas.drawText(x0xO0oo2, fArr[0] + oI0IIXIo2, this.f34563oIX0oI.xoIox() + f + oIX0oI2, this.f34559Oxx0IOOO);
            } else if (Oo2 == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                this.f34559Oxx0IOOO.setTextAlign(Paint.Align.LEFT);
                canvas.drawText(x0xO0oo2, fArr[0] + oI0IIXIo2, this.f34563oIX0oI.XO() - f, this.f34559Oxx0IOOO);
            } else if (Oo2 == LimitLine.LimitLabelPosition.LEFT_TOP) {
                this.f34559Oxx0IOOO.setTextAlign(Paint.Align.RIGHT);
                canvas.drawText(x0xO0oo2, fArr[0] - oI0IIXIo2, this.f34563oIX0oI.xoIox() + f + XIXIX.OOXIXo.oIX0oI(this.f34559Oxx0IOOO, x0xO0oo2), this.f34559Oxx0IOOO);
            } else {
                this.f34559Oxx0IOOO.setTextAlign(Paint.Align.RIGHT);
                canvas.drawText(x0xO0oo2, fArr[0] - oI0IIXIo2, this.f34563oIX0oI.XO() - f, this.f34559Oxx0IOOO);
            }
        }
    }

    @Override // xX0IIXIx0.oIX0oI
    public void xoIox(Canvas canvas) {
        List<LimitLine> xxX2 = this.f34521II0XooXoX.xxX();
        if (xxX2 != null && xxX2.size() > 0) {
            float[] fArr = this.f34524oOoXoXO;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            for (int i = 0; i < xxX2.size(); i++) {
                LimitLine limitLine = xxX2.get(i);
                if (limitLine.XO()) {
                    int save = canvas.save();
                    this.f34525ooOOo0oXI.set(this.f34563oIX0oI.Oo());
                    this.f34525ooOOo0oXI.inset(-limitLine.oI0IIXIo(), 0.0f);
                    canvas.clipRect(this.f34525ooOOo0oXI);
                    fArr[0] = limitLine.IXxxXO();
                    fArr[1] = 0.0f;
                    this.f34557I0Io.oO(fArr);
                    Oo(canvas, limitLine, fArr);
                    x0xO0oo(canvas, limitLine, fArr, limitLine.X0o0xo() + 2.0f);
                    canvas.restoreToCount(save);
                }
            }
        }
    }

    @Override // xX0IIXIx0.oIX0oI
    public void xxIXOIIO(Canvas canvas) {
        if (this.f34521II0XooXoX.X00IoxXI() && this.f34521II0XooXoX.XO()) {
            int save = canvas.save();
            canvas.clipRect(oO());
            if (this.f34527xoIox.length != this.f34558II0xO0.f4026x0XOIxOo * 2) {
                this.f34527xoIox = new float[this.f34521II0XooXoX.f4026x0XOIxOo * 2];
            }
            float[] fArr = this.f34527xoIox;
            for (int i = 0; i < fArr.length; i += 2) {
                float[] fArr2 = this.f34521II0XooXoX.f4023oOoXoXO;
                int i2 = i / 2;
                fArr[i] = fArr2[i2];
                fArr[i + 1] = fArr2[i2];
            }
            this.f34557I0Io.oO(fArr);
            IXxxXO();
            Path path = this.f34528xxIXOIIO;
            path.reset();
            for (int i3 = 0; i3 < fArr.length; i3 += 2) {
                oOoXoXO(canvas, fArr[i3], fArr[i3 + 1], path);
            }
            canvas.restoreToCount(save);
        }
    }
}
