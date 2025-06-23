package com.github.mikephil.charting.charts;

import XI0oooXX.oxoX;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import o0xxxXXxX.oIX0oI;
import xX0IIXIx0.II0xO0;

/* loaded from: classes9.dex */
public class BarChart extends BarLineChartBase<oIX0oI> implements OOXIxO0.oIX0oI {

    /* renamed from: IIX0, reason: collision with root package name */
    public boolean f15810IIX0;

    /* renamed from: O0, reason: collision with root package name */
    public boolean f15811O0;

    /* renamed from: Ox0O, reason: collision with root package name */
    public boolean f15812Ox0O;

    /* renamed from: xOoOIoI, reason: collision with root package name */
    public boolean f15813xOoOIoI;

    public BarChart(Context context) {
        super(context);
        this.f15810IIX0 = false;
        this.f15813xOoOIoI = true;
        this.f15812Ox0O = false;
        this.f15811O0 = false;
    }

    @Override // OOXIxO0.oIX0oI
    public boolean I0Io() {
        return this.f15812Ox0O;
    }

    @Override // OOXIxO0.oIX0oI
    public boolean II0xO0() {
        return this.f15810IIX0;
    }

    public void IxIX0I(float f, float f2, float f3) {
        if (getBarData() != null) {
            getBarData().XOxIOxOx(f, f2, f3);
            X00IoxXI();
            return;
        }
        throw new RuntimeException("You need to set data for the chart before grouping bars.");
    }

    public void XXoOx0(BarEntry barEntry, RectF rectF) {
        float f;
        IIxOXoOo0.oIX0oI oix0oi = (IIxOXoOo0.oIX0oI) ((oIX0oI) this.f15871Oo).x0XOIxOo(barEntry);
        if (oix0oi == null) {
            rectF.set(Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE);
            return;
        }
        float I0Io2 = barEntry.I0Io();
        float xxIXOIIO2 = barEntry.xxIXOIIO();
        float xII2 = ((oIX0oI) this.f15871Oo).xII() / 2.0f;
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
        rectF.set(f2, f, f3, I0Io2);
        oxoX(oix0oi.OX00O0xII()).oI0IIXIo(rectF);
    }

    @Override // OOXIxO0.oIX0oI
    public oIX0oI getBarData() {
        return (oIX0oI) this.f15871Oo;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public oxoX o00(float f, float f2) {
        if (this.f15871Oo == 0) {
            Log.e(Chart.f15859o0, "Can't select by touch. No data set.");
            return null;
        }
        oxoX oIX0oI2 = getHighlighter().oIX0oI(f, f2);
        if (oIX0oI2 != null && II0xO0()) {
            return new oxoX(oIX0oI2.II0XooXoX(), oIX0oI2.xoIox(), oIX0oI2.xxIXOIIO(), oIX0oI2.OOXIXo(), oIX0oI2.oxoX(), -1, oIX0oI2.II0xO0());
        }
        return oIX0oI2;
    }

    @Override // OOXIxO0.oIX0oI
    public boolean oIX0oI() {
        return this.f15813xOoOIoI;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void oO() {
        if (this.f15811O0) {
            this.f15883o00.x0XOIxOo(((oIX0oI) this.f15871Oo).OxI() - (((oIX0oI) this.f15871Oo).xII() / 2.0f), ((oIX0oI) this.f15871Oo).o00() + (((oIX0oI) this.f15871Oo).xII() / 2.0f));
        } else {
            this.f15883o00.x0XOIxOo(((oIX0oI) this.f15871Oo).OxI(), ((oIX0oI) this.f15871Oo).o00());
        }
        YAxis yAxis = this.f15831XX0xXo;
        oIX0oI oix0oi = (oIX0oI) this.f15871Oo;
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        yAxis.x0XOIxOo(oix0oi.XIxXXX0x0(axisDependency), ((oIX0oI) this.f15871Oo).X0IIOO(axisDependency));
        YAxis yAxis2 = this.f15834o0xxxXXxX;
        oIX0oI oix0oi2 = (oIX0oI) this.f15871Oo;
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        yAxis2.x0XOIxOo(oix0oi2.XIxXXX0x0(axisDependency2), ((oIX0oI) this.f15871Oo).X0IIOO(axisDependency2));
    }

    public void oOoIIO0(float f, int i, int i2) {
        xXxxox0I(new oxoX(f, i, i2), false);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void ooXIXxIX() {
        super.ooXIXxIX();
        this.f15863IIX0o = new II0xO0(this, this.f15887oo0xXOI0I, this.f15890xI);
        setHighlighter(new XI0oooXX.oIX0oI(this));
        getXAxis().XX0xXo(0.5f);
        getXAxis().xxIO(0.5f);
    }

    public void setDrawBarShadow(boolean z) {
        this.f15812Ox0O = z;
    }

    public void setDrawValueAboveBar(boolean z) {
        this.f15813xOoOIoI = z;
    }

    public void setFitBars(boolean z) {
        this.f15811O0 = z;
    }

    public void setHighlightFullBarEnabled(boolean z) {
        this.f15810IIX0 = z;
    }

    public RectF x0OIX00oO(BarEntry barEntry) {
        RectF rectF = new RectF();
        XXoOx0(barEntry, rectF);
        return rectF;
    }

    public BarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15810IIX0 = false;
        this.f15813xOoOIoI = true;
        this.f15812Ox0O = false;
        this.f15811O0 = false;
    }

    public BarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15810IIX0 = false;
        this.f15813xOoOIoI = true;
        this.f15812Ox0O = false;
        this.f15811O0 = false;
    }
}
