package com.github.mikephil.charting.charts;

import IIxOXoOo0.oIX0oI;
import XI0oooXX.oxoX;
import XIXIX.OOXIXo;
import XIXIX.Oxx0IOOO;
import XIXIX.X0o0xo;
import XIXIX.xoIox;
import XIXIX.xxIXOIIO;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import xX0IIXIx0.II0XooXoX;
import xX0IIXIx0.IIXOooo;
import xX0IIXIx0.Oxx0xo;

/* loaded from: classes9.dex */
public class HorizontalBarChart extends BarChart {

    /* renamed from: xI0oxI00, reason: collision with root package name */
    public float[] f15901xI0oxI00;

    /* renamed from: xx0X0, reason: collision with root package name */
    public RectF f15902xx0X0;

    public HorizontalBarChart(Context context) {
        super(context);
        this.f15902xx0X0 = new RectF();
        this.f15901xI0oxI00 = new float[2];
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void O0(float f, float f2, YAxis.AxisDependency axisDependency) {
        this.f15890xI.oxXx0IX(Xo0(axisDependency) / f, Xo0(axisDependency) / f2);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void Ox0O(float f, float f2) {
        float f3 = this.f15883o00.f4028xI;
        this.f15890xI.xo0x(f3 / f, f3 / f2);
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public float[] OxI(oxoX oxox) {
        return new float[]{oxox.XO(), oxox.X0o0xo()};
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void XIXIX() {
        xxIXOIIO xxixoiio = this.f15825OOXIxO0;
        YAxis yAxis = this.f15834o0xxxXXxX;
        float f = yAxis.f4025ooXIXxIX;
        float f2 = yAxis.f4028xI;
        XAxis xAxis = this.f15883o00;
        xxixoiio.Oo(f, f2, xAxis.f4028xI, xAxis.f4025ooXIXxIX);
        xxIXOIIO xxixoiio2 = this.f15827XI0oooXX;
        YAxis yAxis2 = this.f15831XX0xXo;
        float f3 = yAxis2.f4025ooXIXxIX;
        float f4 = yAxis2.f4028xI;
        XAxis xAxis2 = this.f15883o00;
        xxixoiio2.Oo(f3, f4, xAxis2.f4028xI, xAxis2.f4025ooXIXxIX);
    }

    @Override // com.github.mikephil.charting.charts.BarChart
    public void XXoOx0(BarEntry barEntry, RectF rectF) {
        float f;
        oIX0oI oix0oi = (oIX0oI) ((o0xxxXXxX.oIX0oI) this.f15871Oo).x0XOIxOo(barEntry);
        if (oix0oi == null) {
            rectF.set(Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE);
            return;
        }
        float I0Io2 = barEntry.I0Io();
        float xxIXOIIO2 = barEntry.xxIXOIIO();
        float xII2 = ((o0xxxXXxX.oIX0oI) this.f15871Oo).xII() / 2.0f;
        float f2 = xxIXOIIO2 - xII2;
        float f3 = xxIXOIIO2 + xII2;
        if (I0Io2 >= 0.0f) {
            f = I0Io2;
        } else {
            f = 0.0f;
        }
        if (I0Io2 > 0.0f) {
            I0Io2 = 0.0f;
        }
        rectF.set(f, f2, I0Io2, f3);
        oxoX(oix0oi.OX00O0xII()).oI0IIXIo(rectF);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, OOXIxO0.II0xO0
    public float getHighestVisibleX() {
        oxoX(YAxis.AxisDependency.LEFT).OOXIXo(this.f15890xI.II0XooXoX(), this.f15890xI.xoIox(), this.f15835oOo);
        return (float) Math.min(this.f15883o00.f4006IIX0o, this.f15835oOo.f3775Oxx0xo);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, OOXIxO0.II0xO0
    public float getLowestVisibleX() {
        oxoX(YAxis.AxisDependency.LEFT).OOXIXo(this.f15890xI.II0XooXoX(), this.f15890xI.XO(), this.f15837oXIO0o0XI);
        return (float) Math.max(this.f15883o00.f4025ooXIXxIX, this.f15837oXIO0o0XI.f3775Oxx0xo);
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.Chart
    public oxoX o00(float f, float f2) {
        if (this.f15871Oo == 0) {
            if (this.f15879XO) {
                Log.e(Chart.f15859o0, "Can't select by touch. No data set.");
                return null;
            }
            return null;
        }
        return getHighlighter().oIX0oI(f2, f);
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void ooXIXxIX() {
        this.f15890xI = new X0o0xo();
        super.ooXIXxIX();
        this.f15827XI0oooXX = new xoIox(this.f15890xI);
        this.f15825OOXIxO0 = new xoIox(this.f15890xI);
        this.f15863IIX0o = new II0XooXoX(this, this.f15887oo0xXOI0I, this.f15890xI);
        setHighlighter(new XI0oooXX.X0o0xo(this));
        this.f15820O00XxXI = new IIXOooo(this.f15890xI, this.f15831XX0xXo, this.f15827XI0oooXX);
        this.f15839ox = new IIXOooo(this.f15890xI, this.f15834o0xxxXXxX, this.f15825OOXIxO0);
        this.f15817IIxOXoOo0 = new Oxx0xo(this.f15890xI, this.f15883o00, this.f15827XI0oooXX, this);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleXRangeMaximum(float f) {
        this.f15890xI.XX0(this.f15883o00.f4028xI / f);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleXRangeMinimum(float f) {
        this.f15890xI.XoX(this.f15883o00.f4028xI / f);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void x0xO0oo() {
        oxXx0IX(this.f15902xx0X0);
        RectF rectF = this.f15902xx0X0;
        float f = rectF.left + 0.0f;
        float f2 = rectF.top + 0.0f;
        float f3 = rectF.right + 0.0f;
        float f4 = rectF.bottom + 0.0f;
        if (this.f15831XX0xXo.xOoOIoI()) {
            f2 += this.f15831XX0xXo.IIxOXoOo0(this.f15820O00XxXI.I0Io());
        }
        if (this.f15834o0xxxXXxX.xOoOIoI()) {
            f4 += this.f15834o0xxxXXxX.IIxOXoOo0(this.f15839ox.I0Io());
        }
        XAxis xAxis = this.f15883o00;
        float f5 = xAxis.f15974IoOoX;
        if (xAxis.XO()) {
            if (this.f15883o00.ox() == XAxis.XAxisPosition.BOTTOM) {
                f += f5;
            } else {
                if (this.f15883o00.ox() != XAxis.XAxisPosition.TOP) {
                    if (this.f15883o00.ox() == XAxis.XAxisPosition.BOTH_SIDED) {
                        f += f5;
                    }
                }
                f3 += f5;
            }
        }
        float extraTopOffset = f2 + getExtraTopOffset();
        float extraRightOffset = f3 + getExtraRightOffset();
        float extraBottomOffset = f4 + getExtraBottomOffset();
        float extraLeftOffset = f + getExtraLeftOffset();
        float X0o0xo2 = OOXIXo.X0o0xo(this.f15829XIo0oOXIx);
        this.f15890xI.Io(Math.max(X0o0xo2, extraLeftOffset), Math.max(X0o0xo2, extraTopOffset), Math.max(X0o0xo2, extraRightOffset), Math.max(X0o0xo2, extraBottomOffset));
        if (this.f15879XO) {
            Log.i(Chart.f15859o0, "offsetLeft: " + extraLeftOffset + ", offsetTop: " + extraTopOffset + ", offsetRight: " + extraRightOffset + ", offsetBottom: " + extraBottomOffset);
            StringBuilder sb = new StringBuilder();
            sb.append("Content: ");
            sb.append(this.f15890xI.Oo().toString());
            Log.i(Chart.f15859o0, sb.toString());
        }
        xOOOX();
        XIXIX();
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void xI0oxI00(float f, YAxis.AxisDependency axisDependency) {
        this.f15890xI.oxxXoxO(Xo0(axisDependency) / f);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public Oxx0IOOO xoxXI(Entry entry, YAxis.AxisDependency axisDependency) {
        if (entry == null) {
            return null;
        }
        float[] fArr = this.f15901xI0oxI00;
        fArr[0] = entry.I0Io();
        fArr[1] = entry.xxIXOIIO();
        oxoX(axisDependency).oO(fArr);
        return Oxx0IOOO.I0Io(fArr[0], fArr[1]);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void xx0X0(float f, YAxis.AxisDependency axisDependency) {
        this.f15890xI.xXOx(Xo0(axisDependency) / f);
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15902xx0X0 = new RectF();
        this.f15901xI0oxI00 = new float[2];
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15902xx0X0 = new RectF();
        this.f15901xI0oxI00 = new float[2];
    }
}
