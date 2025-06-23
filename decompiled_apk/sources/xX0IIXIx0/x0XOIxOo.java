package xX0IIXIx0;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarEntry;

/* loaded from: classes9.dex */
public class x0XOIxOo extends OOXIXo {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public Paint f34586OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public Path f34587oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public Path f34588ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    public Paint f34589xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public RadarChart f34590xxIXOIIO;

    public x0XOIxOo(RadarChart radarChart, Ioxxx.oIX0oI oix0oi, XIXIX.oOoXoXO oooxoxo) {
        super(oix0oi, oooxoxo);
        this.f34587oOoXoXO = new Path();
        this.f34588ooOOo0oXI = new Path();
        this.f34590xxIXOIIO = radarChart;
        Paint paint = new Paint(1);
        this.f34533oxoX = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f34533oxoX.setStrokeWidth(2.0f);
        this.f34533oxoX.setColor(Color.rgb(255, 187, 115));
        Paint paint2 = new Paint(1);
        this.f34589xoIox = paint2;
        paint2.setStyle(style);
        this.f34586OOXIXo = new Paint(1);
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void I0Io(Canvas canvas) {
        oI0IIXIo(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xX0IIXIx0.Oxx0IOOO
    public void II0xO0(Canvas canvas) {
        o0xxxXXxX.IXxxXO iXxxXO = (o0xxxXXxX.IXxxXO) this.f34590xxIXOIIO.getData();
        int X0xxXX02 = iXxxXO.xoXoI().X0xxXX0();
        for (IIxOXoOo0.xoIox xoiox : iXxxXO.Oo()) {
            if (xoiox.isVisible()) {
                IXxxXO(canvas, xoiox, X0xxXX02);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void IXxxXO(Canvas canvas, IIxOXoOo0.xoIox xoiox, int i) {
        float II0XooXoX2 = this.f34530II0xO0.II0XooXoX();
        float xxIXOIIO2 = this.f34530II0xO0.xxIXOIIO();
        float sliceAngle = this.f34590xxIXOIIO.getSliceAngle();
        float factor = this.f34590xxIXOIIO.getFactor();
        XIXIX.Oxx0IOOO centerOffsets = this.f34590xxIXOIIO.getCenterOffsets();
        XIXIX.Oxx0IOOO I0Io2 = XIXIX.Oxx0IOOO.I0Io(0.0f, 0.0f);
        Path path = this.f34587oOoXoXO;
        path.reset();
        boolean z = false;
        for (int i2 = 0; i2 < xoiox.X0xxXX0(); i2++) {
            this.f34529I0Io.setColor(xoiox.XXoOx0(i2));
            XIXIX.OOXIXo.XI0IXoo(centerOffsets, (((RadarEntry) xoiox.OOXIXo(i2)).I0Io() - this.f34590xxIXOIIO.getYChartMin()) * factor * xxIXOIIO2, (i2 * sliceAngle * II0XooXoX2) + this.f34590xxIXOIIO.getRotationAngle(), I0Io2);
            if (!Float.isNaN(I0Io2.f3771IXxxXO)) {
                if (!z) {
                    path.moveTo(I0Io2.f3771IXxxXO, I0Io2.f3772Oxx0xo);
                    z = true;
                } else {
                    path.lineTo(I0Io2.f3771IXxxXO, I0Io2.f3772Oxx0xo);
                }
            }
        }
        if (xoiox.X0xxXX0() > i) {
            path.lineTo(centerOffsets.f3771IXxxXO, centerOffsets.f3772Oxx0xo);
        }
        path.close();
        if (xoiox.OIOoIIOIx()) {
            Drawable xxIXOIIO3 = xoiox.xxIXOIIO();
            if (xxIXOIIO3 != null) {
                Oo(canvas, path, xxIXOIIO3);
            } else {
                x0xO0oo(canvas, path, xoiox.XxX0x0xxx(), xoiox.I0oOIX());
            }
        }
        this.f34529I0Io.setStrokeWidth(xoiox.IoOoo());
        this.f34529I0Io.setStyle(Paint.Style.STROKE);
        if (!xoiox.OIOoIIOIx() || xoiox.I0oOIX() < 255) {
            canvas.drawPath(path, this.f34529I0Io);
        }
        XIXIX.Oxx0IOOO.II0XooXoX(centerOffsets);
        XIXIX.Oxx0IOOO.II0XooXoX(I0Io2);
    }

    public void Oxx0xo(Canvas canvas, XIXIX.Oxx0IOOO oxx0IOOO, float f, float f2, int i, int i2, float f3) {
        canvas.save();
        float X0o0xo2 = XIXIX.OOXIXo.X0o0xo(f2);
        float X0o0xo3 = XIXIX.OOXIXo.X0o0xo(f);
        if (i != 1122867) {
            Path path = this.f34588ooOOo0oXI;
            path.reset();
            path.addCircle(oxx0IOOO.f3771IXxxXO, oxx0IOOO.f3772Oxx0xo, X0o0xo2, Path.Direction.CW);
            if (X0o0xo3 > 0.0f) {
                path.addCircle(oxx0IOOO.f3771IXxxXO, oxx0IOOO.f3772Oxx0xo, X0o0xo3, Path.Direction.CCW);
            }
            this.f34586OOXIXo.setColor(i);
            this.f34586OOXIXo.setStyle(Paint.Style.FILL);
            canvas.drawPath(path, this.f34586OOXIXo);
        }
        if (i2 != 1122867) {
            this.f34586OOXIXo.setColor(i2);
            this.f34586OOXIXo.setStyle(Paint.Style.STROKE);
            this.f34586OOXIXo.setStrokeWidth(XIXIX.OOXIXo.X0o0xo(f3));
            canvas.drawCircle(oxx0IOOO.f3771IXxxXO, oxx0IOOO.f3772Oxx0xo, X0o0xo2, this.f34586OOXIXo);
        }
        canvas.restore();
    }

    public Paint OxxIIOOXO() {
        return this.f34589xoIox;
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void X0o0xo(Canvas canvas, String str, float f, float f2, int i) {
        this.f34532XO.setColor(i);
        canvas.drawText(str, f, f2, this.f34532XO);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xX0IIXIx0.Oxx0IOOO
    public void XO(Canvas canvas) {
        int i;
        float f;
        RadarEntry radarEntry;
        int i2;
        IIxOXoOo0.xoIox xoiox;
        int i3;
        float f2;
        XIXIX.Oxx0IOOO oxx0IOOO;
        ox.x0xO0oo x0xo0oo;
        float II0XooXoX2 = this.f34530II0xO0.II0XooXoX();
        float xxIXOIIO2 = this.f34530II0xO0.xxIXOIIO();
        float sliceAngle = this.f34590xxIXOIIO.getSliceAngle();
        float factor = this.f34590xxIXOIIO.getFactor();
        XIXIX.Oxx0IOOO centerOffsets = this.f34590xxIXOIIO.getCenterOffsets();
        XIXIX.Oxx0IOOO I0Io2 = XIXIX.Oxx0IOOO.I0Io(0.0f, 0.0f);
        XIXIX.Oxx0IOOO I0Io3 = XIXIX.Oxx0IOOO.I0Io(0.0f, 0.0f);
        float X0o0xo2 = XIXIX.OOXIXo.X0o0xo(5.0f);
        int i4 = 0;
        while (i4 < ((o0xxxXXxX.IXxxXO) this.f34590xxIXOIIO.getData()).ooOOo0oXI()) {
            IIxOXoOo0.xoIox OOXIXo2 = ((o0xxxXXxX.IXxxXO) this.f34590xxIXOIIO.getData()).OOXIXo(i4);
            if (!ooOOo0oXI(OOXIXo2)) {
                i = i4;
                f = II0XooXoX2;
            } else {
                oIX0oI(OOXIXo2);
                ox.x0xO0oo xxIO2 = OOXIXo2.xxIO();
                XIXIX.Oxx0IOOO oxoX2 = XIXIX.Oxx0IOOO.oxoX(OOXIXo2.IO0XoXxO());
                oxoX2.f3771IXxxXO = XIXIX.OOXIXo.X0o0xo(oxoX2.f3771IXxxXO);
                oxoX2.f3772Oxx0xo = XIXIX.OOXIXo.X0o0xo(oxoX2.f3772Oxx0xo);
                int i5 = 0;
                while (i5 < OOXIXo2.X0xxXX0()) {
                    RadarEntry radarEntry2 = (RadarEntry) OOXIXo2.OOXIXo(i5);
                    XIXIX.Oxx0IOOO oxx0IOOO2 = oxoX2;
                    float f3 = i5 * sliceAngle * II0XooXoX2;
                    XIXIX.OOXIXo.XI0IXoo(centerOffsets, (radarEntry2.I0Io() - this.f34590xxIXOIIO.getYChartMin()) * factor * xxIXOIIO2, f3 + this.f34590xxIXOIIO.getRotationAngle(), I0Io2);
                    if (OOXIXo2.xoO0xx0()) {
                        radarEntry = radarEntry2;
                        i2 = i5;
                        f2 = II0XooXoX2;
                        oxx0IOOO = oxx0IOOO2;
                        x0xo0oo = xxIO2;
                        xoiox = OOXIXo2;
                        i3 = i4;
                        X0o0xo(canvas, xxIO2.OOXIXo(radarEntry2), I0Io2.f3771IXxxXO, I0Io2.f3772Oxx0xo - X0o0xo2, OOXIXo2.x0xO0oo(i5));
                    } else {
                        radarEntry = radarEntry2;
                        i2 = i5;
                        xoiox = OOXIXo2;
                        i3 = i4;
                        f2 = II0XooXoX2;
                        oxx0IOOO = oxx0IOOO2;
                        x0xo0oo = xxIO2;
                    }
                    if (radarEntry.II0xO0() != null && xoiox.oo0xXOI0I()) {
                        Drawable II0xO02 = radarEntry.II0xO0();
                        XIXIX.OOXIXo.XI0IXoo(centerOffsets, (radarEntry.I0Io() * factor * xxIXOIIO2) + oxx0IOOO.f3772Oxx0xo, f3 + this.f34590xxIXOIIO.getRotationAngle(), I0Io3);
                        float f4 = I0Io3.f3772Oxx0xo + oxx0IOOO.f3771IXxxXO;
                        I0Io3.f3772Oxx0xo = f4;
                        XIXIX.OOXIXo.OOXIXo(canvas, II0xO02, (int) I0Io3.f3771IXxxXO, (int) f4, II0xO02.getIntrinsicWidth(), II0xO02.getIntrinsicHeight());
                    }
                    i5 = i2 + 1;
                    oxoX2 = oxx0IOOO;
                    OOXIXo2 = xoiox;
                    xxIO2 = x0xo0oo;
                    i4 = i3;
                    II0XooXoX2 = f2;
                }
                i = i4;
                f = II0XooXoX2;
                XIXIX.Oxx0IOOO.II0XooXoX(oxoX2);
            }
            i4 = i + 1;
            II0XooXoX2 = f;
        }
        XIXIX.Oxx0IOOO.II0XooXoX(centerOffsets);
        XIXIX.Oxx0IOOO.II0XooXoX(I0Io2);
        XIXIX.Oxx0IOOO.II0XooXoX(I0Io3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void oI0IIXIo(Canvas canvas) {
        float sliceAngle = this.f34590xxIXOIIO.getSliceAngle();
        float factor = this.f34590xxIXOIIO.getFactor();
        float rotationAngle = this.f34590xxIXOIIO.getRotationAngle();
        XIXIX.Oxx0IOOO centerOffsets = this.f34590xxIXOIIO.getCenterOffsets();
        this.f34589xoIox.setStrokeWidth(this.f34590xxIXOIIO.getWebLineWidth());
        this.f34589xoIox.setColor(this.f34590xxIXOIIO.getWebColor());
        this.f34589xoIox.setAlpha(this.f34590xxIXOIIO.getWebAlpha());
        int skipWebLineCount = this.f34590xxIXOIIO.getSkipWebLineCount() + 1;
        int X0xxXX02 = ((o0xxxXXxX.IXxxXO) this.f34590xxIXOIIO.getData()).xoXoI().X0xxXX0();
        XIXIX.Oxx0IOOO I0Io2 = XIXIX.Oxx0IOOO.I0Io(0.0f, 0.0f);
        for (int i = 0; i < X0xxXX02; i += skipWebLineCount) {
            XIXIX.OOXIXo.XI0IXoo(centerOffsets, this.f34590xxIXOIIO.getYRange() * factor, (i * sliceAngle) + rotationAngle, I0Io2);
            canvas.drawLine(centerOffsets.f3771IXxxXO, centerOffsets.f3772Oxx0xo, I0Io2.f3771IXxxXO, I0Io2.f3772Oxx0xo, this.f34589xoIox);
        }
        XIXIX.Oxx0IOOO.II0XooXoX(I0Io2);
        this.f34589xoIox.setStrokeWidth(this.f34590xxIXOIIO.getWebLineWidthInner());
        this.f34589xoIox.setColor(this.f34590xxIXOIIO.getWebColorInner());
        this.f34589xoIox.setAlpha(this.f34590xxIXOIIO.getWebAlpha());
        int i2 = this.f34590xxIXOIIO.getYAxis().f4026x0XOIxOo;
        XIXIX.Oxx0IOOO I0Io3 = XIXIX.Oxx0IOOO.I0Io(0.0f, 0.0f);
        XIXIX.Oxx0IOOO I0Io4 = XIXIX.Oxx0IOOO.I0Io(0.0f, 0.0f);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = 0;
            while (i4 < ((o0xxxXXxX.IXxxXO) this.f34590xxIXOIIO.getData()).IXxxXO()) {
                float yChartMin = (this.f34590xxIXOIIO.getYAxis().f4023oOoXoXO[i3] - this.f34590xxIXOIIO.getYChartMin()) * factor;
                XIXIX.OOXIXo.XI0IXoo(centerOffsets, yChartMin, (i4 * sliceAngle) + rotationAngle, I0Io3);
                i4++;
                XIXIX.OOXIXo.XI0IXoo(centerOffsets, yChartMin, (i4 * sliceAngle) + rotationAngle, I0Io4);
                canvas.drawLine(I0Io3.f3771IXxxXO, I0Io3.f3772Oxx0xo, I0Io4.f3771IXxxXO, I0Io4.f3772Oxx0xo, this.f34589xoIox);
            }
        }
        XIXIX.Oxx0IOOO.II0XooXoX(I0Io3);
        XIXIX.Oxx0IOOO.II0XooXoX(I0Io4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xX0IIXIx0.Oxx0IOOO
    public void oxoX(Canvas canvas, XI0oooXX.oxoX[] oxoxArr) {
        int i;
        float sliceAngle = this.f34590xxIXOIIO.getSliceAngle();
        float factor = this.f34590xxIXOIIO.getFactor();
        XIXIX.Oxx0IOOO centerOffsets = this.f34590xxIXOIIO.getCenterOffsets();
        XIXIX.Oxx0IOOO I0Io2 = XIXIX.Oxx0IOOO.I0Io(0.0f, 0.0f);
        o0xxxXXxX.IXxxXO iXxxXO = (o0xxxXXxX.IXxxXO) this.f34590xxIXOIIO.getData();
        int length = oxoxArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            XI0oooXX.oxoX oxox = oxoxArr[i3];
            IIxOXoOo0.xoIox OOXIXo2 = iXxxXO.OOXIXo(oxox.oxoX());
            if (OOXIXo2 != null && OOXIXo2.XX0()) {
                Entry entry = (RadarEntry) OOXIXo2.OOXIXo((int) oxox.II0XooXoX());
                if (oOoXoXO(entry, OOXIXo2)) {
                    XIXIX.OOXIXo.XI0IXoo(centerOffsets, (entry.I0Io() - this.f34590xxIXOIIO.getYChartMin()) * factor * this.f34530II0xO0.xxIXOIIO(), (oxox.II0XooXoX() * sliceAngle * this.f34530II0xO0.II0XooXoX()) + this.f34590xxIXOIIO.getRotationAngle(), I0Io2);
                    oxox.x0XOIxOo(I0Io2.f3771IXxxXO, I0Io2.f3772Oxx0xo);
                    x0XOIxOo(canvas, I0Io2.f3771IXxxXO, I0Io2.f3772Oxx0xo, OOXIXo2);
                    if (OOXIXo2.O0() && !Float.isNaN(I0Io2.f3771IXxxXO) && !Float.isNaN(I0Io2.f3772Oxx0xo)) {
                        int OO2 = OOXIXo2.OO();
                        if (OO2 == 1122867) {
                            OO2 = OOXIXo2.XXoOx0(i2);
                        }
                        if (OOXIXo2.xXxxox0I() < 255) {
                            OO2 = XIXIX.oIX0oI.oIX0oI(OO2, OOXIXo2.xXxxox0I());
                        }
                        i = i3;
                        Oxx0xo(canvas, I0Io2, OOXIXo2.O0X(), OOXIXo2.OO0x0xX(), OOXIXo2.II0xO0(), OO2, OOXIXo2.XIXIX());
                        i3 = i + 1;
                        i2 = 0;
                    }
                }
            }
            i = i3;
            i3 = i + 1;
            i2 = 0;
        }
        XIXIX.Oxx0IOOO.II0XooXoX(centerOffsets);
        XIXIX.Oxx0IOOO.II0XooXoX(I0Io2);
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void xoIox() {
    }
}
