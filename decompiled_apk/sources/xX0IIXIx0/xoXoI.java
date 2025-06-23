package xX0IIXIx0;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import java.util.List;

/* loaded from: classes9.dex */
public class xoXoI extends OxxIIOOXO {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public RadarChart f34608IXxxXO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public Path f34609Oxx0xo;

    public xoXoI(XIXIX.oOoXoXO oooxoxo, YAxis yAxis, RadarChart radarChart) {
        super(oooxoxo, yAxis, null);
        this.f34609Oxx0xo = new Path();
        this.f34608IXxxXO = radarChart;
    }

    @Override // xX0IIXIx0.oIX0oI
    public void II0xO0(float f, float f2) {
        double ceil;
        double oo0xXOI0I2;
        int i;
        float f3 = f;
        int XIxXXX0x02 = this.f34558II0xO0.XIxXXX0x0();
        double abs = Math.abs(f2 - f3);
        if (XIxXXX0x02 != 0 && abs > XIXIX.OOXIXo.f3760XO && !Double.isInfinite(abs)) {
            double IoOoX2 = XIXIX.OOXIXo.IoOoX(abs / XIxXXX0x02);
            if (this.f34558II0xO0.XOxIOxOx() && IoOoX2 < this.f34558II0xO0.OxI()) {
                IoOoX2 = this.f34558II0xO0.OxI();
            }
            double IoOoX3 = XIXIX.OOXIXo.IoOoX(Math.pow(10.0d, (int) Math.log10(IoOoX2)));
            if (((int) (IoOoX2 / IoOoX3)) > 5) {
                IoOoX2 = Math.floor(IoOoX3 * 10.0d);
            }
            boolean IoOoX4 = this.f34558II0xO0.IoOoX();
            if (this.f34558II0xO0.x0o()) {
                float f4 = ((float) abs) / (XIxXXX0x02 - 1);
                XX0xXo.oIX0oI oix0oi = this.f34558II0xO0;
                oix0oi.f4026x0XOIxOo = XIxXXX0x02;
                if (oix0oi.f4023oOoXoXO.length < XIxXXX0x02) {
                    oix0oi.f4023oOoXoXO = new float[XIxXXX0x02];
                }
                for (int i2 = 0; i2 < XIxXXX0x02; i2++) {
                    this.f34558II0xO0.f4023oOoXoXO[i2] = f3;
                    f3 += f4;
                }
            } else {
                if (IoOoX2 == XIXIX.OOXIXo.f3760XO) {
                    ceil = XIXIX.OOXIXo.f3760XO;
                } else {
                    ceil = Math.ceil(f3 / IoOoX2) * IoOoX2;
                }
                if (IoOoX4) {
                    ceil -= IoOoX2;
                }
                if (IoOoX2 == XIXIX.OOXIXo.f3760XO) {
                    oo0xXOI0I2 = XIXIX.OOXIXo.f3760XO;
                } else {
                    oo0xXOI0I2 = XIXIX.OOXIXo.oo0xXOI0I(Math.floor(f2 / IoOoX2) * IoOoX2);
                }
                if (IoOoX2 != XIXIX.OOXIXo.f3760XO) {
                    i = IoOoX4 ? 1 : 0;
                    for (double d = ceil; d <= oo0xXOI0I2; d += IoOoX2) {
                        i++;
                    }
                } else {
                    i = IoOoX4 ? 1 : 0;
                }
                int i3 = i + 1;
                XX0xXo.oIX0oI oix0oi2 = this.f34558II0xO0;
                oix0oi2.f4026x0XOIxOo = i3;
                if (oix0oi2.f4023oOoXoXO.length < i3) {
                    oix0oi2.f4023oOoXoXO = new float[i3];
                }
                for (int i4 = 0; i4 < i3; i4++) {
                    if (ceil == XIXIX.OOXIXo.f3760XO) {
                        ceil = 0.0d;
                    }
                    this.f34558II0xO0.f4023oOoXoXO[i4] = (float) ceil;
                    ceil += IoOoX2;
                }
                XIxXXX0x02 = i3;
            }
            if (IoOoX2 < 1.0d) {
                this.f34558II0xO0.f4022oO = (int) Math.ceil(-Math.log10(IoOoX2));
            } else {
                this.f34558II0xO0.f4022oO = 0;
            }
            if (IoOoX4) {
                XX0xXo.oIX0oI oix0oi3 = this.f34558II0xO0;
                if (oix0oi3.f4024ooOOo0oXI.length < XIxXXX0x02) {
                    oix0oi3.f4024ooOOo0oXI = new float[XIxXXX0x02];
                }
                float[] fArr = oix0oi3.f4023oOoXoXO;
                float f5 = (fArr[1] - fArr[0]) / 2.0f;
                for (int i5 = 0; i5 < XIxXXX0x02; i5++) {
                    XX0xXo.oIX0oI oix0oi4 = this.f34558II0xO0;
                    oix0oi4.f4024ooOOo0oXI[i5] = oix0oi4.f4023oOoXoXO[i5] + f5;
                }
            }
            XX0xXo.oIX0oI oix0oi5 = this.f34558II0xO0;
            float[] fArr2 = oix0oi5.f4023oOoXoXO;
            float f6 = fArr2[0];
            oix0oi5.f4025ooXIXxIX = f6;
            float f7 = fArr2[XIxXXX0x02 - 1];
            oix0oi5.f4006IIX0o = f7;
            oix0oi5.f4028xI = Math.abs(f7 - f6);
            return;
        }
        XX0xXo.oIX0oI oix0oi6 = this.f34558II0xO0;
        oix0oi6.f4023oOoXoXO = new float[0];
        oix0oi6.f4024ooOOo0oXI = new float[0];
        oix0oi6.f4026x0XOIxOo = 0;
    }

    @Override // xX0IIXIx0.OxxIIOOXO, xX0IIXIx0.oIX0oI
    public void Oxx0IOOO(Canvas canvas) {
        if (this.f34536II0XooXoX.XO() && this.f34536II0XooXoX.IO()) {
            this.f34560X0o0xo.setTypeface(this.f34536II0XooXoX.I0Io());
            this.f34560X0o0xo.setTextSize(this.f34536II0XooXoX.II0xO0());
            this.f34560X0o0xo.setColor(this.f34536II0XooXoX.oIX0oI());
            XIXIX.Oxx0IOOO centerOffsets = this.f34608IXxxXO.getCenterOffsets();
            XIXIX.Oxx0IOOO I0Io2 = XIXIX.Oxx0IOOO.I0Io(0.0f, 0.0f);
            float factor = this.f34608IXxxXO.getFactor();
            int i = this.f34536II0XooXoX.XIXIX() ? this.f34536II0XooXoX.f4026x0XOIxOo : this.f34536II0XooXoX.f4026x0XOIxOo - 1;
            for (int i2 = !this.f34536II0XooXoX.xOOOX() ? 1 : 0; i2 < i; i2++) {
                YAxis yAxis = this.f34536II0XooXoX;
                XIXIX.OOXIXo.XI0IXoo(centerOffsets, (yAxis.f4023oOoXoXO[i2] - yAxis.f4025ooXIXxIX) * factor, this.f34608IXxxXO.getRotationAngle(), I0Io2);
                canvas.drawText(this.f34536II0XooXoX.o00(i2), I0Io2.f3771IXxxXO + 10.0f, I0Io2.f3772Oxx0xo, this.f34560X0o0xo);
            }
            XIXIX.Oxx0IOOO.II0XooXoX(centerOffsets);
            XIXIX.Oxx0IOOO.II0XooXoX(I0Io2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xX0IIXIx0.OxxIIOOXO, xX0IIXIx0.oIX0oI
    public void xoIox(Canvas canvas) {
        List<LimitLine> xxX2 = this.f34536II0XooXoX.xxX();
        if (xxX2 == null) {
            return;
        }
        float sliceAngle = this.f34608IXxxXO.getSliceAngle();
        float factor = this.f34608IXxxXO.getFactor();
        XIXIX.Oxx0IOOO centerOffsets = this.f34608IXxxXO.getCenterOffsets();
        XIXIX.Oxx0IOOO I0Io2 = XIXIX.Oxx0IOOO.I0Io(0.0f, 0.0f);
        for (int i = 0; i < xxX2.size(); i++) {
            LimitLine limitLine = xxX2.get(i);
            if (limitLine.XO()) {
                this.f34559Oxx0IOOO.setColor(limitLine.Oxx0xo());
                this.f34559Oxx0IOOO.setPathEffect(limitLine.oO());
                this.f34559Oxx0IOOO.setStrokeWidth(limitLine.oI0IIXIo());
                float IXxxXO2 = (limitLine.IXxxXO() - this.f34608IXxxXO.getYChartMin()) * factor;
                Path path = this.f34609Oxx0xo;
                path.reset();
                for (int i2 = 0; i2 < ((o0xxxXXxX.IXxxXO) this.f34608IXxxXO.getData()).xoXoI().X0xxXX0(); i2++) {
                    XIXIX.OOXIXo.XI0IXoo(centerOffsets, IXxxXO2, (i2 * sliceAngle) + this.f34608IXxxXO.getRotationAngle(), I0Io2);
                    if (i2 == 0) {
                        path.moveTo(I0Io2.f3771IXxxXO, I0Io2.f3772Oxx0xo);
                    } else {
                        path.lineTo(I0Io2.f3771IXxxXO, I0Io2.f3772Oxx0xo);
                    }
                }
                path.close();
                canvas.drawPath(path, this.f34559Oxx0IOOO);
            }
        }
        XIXIX.Oxx0IOOO.II0XooXoX(centerOffsets);
        XIXIX.Oxx0IOOO.II0XooXoX(I0Io2);
    }
}
