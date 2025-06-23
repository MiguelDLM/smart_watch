package com.github.mikephil.charting.charts;

import XI0oooXX.xxIXOIIO;
import XIXIX.OOXIXo;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import o0xxxXXxX.IXxxXO;
import xX0IIXIx0.oI0IIXIo;
import xX0IIXIx0.x0XOIxOo;
import xX0IIXIx0.xoXoI;

/* loaded from: classes9.dex */
public class RadarChart extends PieRadarChartBase<IXxxXO> {

    /* renamed from: I0oOIX, reason: collision with root package name */
    public int f15927I0oOIX;

    /* renamed from: IoOoo, reason: collision with root package name */
    public int f15928IoOoo;

    /* renamed from: O0Xx, reason: collision with root package name */
    public int f15929O0Xx;

    /* renamed from: OO, reason: collision with root package name */
    public boolean f15930OO;

    /* renamed from: OO0x0xX, reason: collision with root package name */
    public oI0IIXIo f15931OO0x0xX;

    /* renamed from: Xo0, reason: collision with root package name */
    public float f15932Xo0;

    /* renamed from: XoI0Ixx0, reason: collision with root package name */
    public float f15933XoI0Ixx0;

    /* renamed from: x0xO, reason: collision with root package name */
    public xoXoI f15934x0xO;

    /* renamed from: xoIxX, reason: collision with root package name */
    public YAxis f15935xoIxX;

    /* renamed from: xoxXI, reason: collision with root package name */
    public int f15936xoxXI;

    public RadarChart(Context context) {
        super(context);
        this.f15932Xo0 = 2.5f;
        this.f15933XoI0Ixx0 = 1.5f;
        this.f15929O0Xx = Color.rgb(122, 122, 122);
        this.f15927I0oOIX = Color.rgb(122, 122, 122);
        this.f15936xoxXI = 150;
        this.f15930OO = true;
        this.f15928IoOoo = 0;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void X00IoxXI() {
        if (this.f15871Oo == 0) {
            return;
        }
        oO();
        xoXoI xoxoi = this.f15934x0xO;
        YAxis yAxis = this.f15935xoIxX;
        xoxoi.oIX0oI(yAxis.f4025ooXIXxIX, yAxis.f4006IIX0o, yAxis.oOo());
        oI0IIXIo oi0iixio = this.f15931OO0x0xX;
        XAxis xAxis = this.f15883o00;
        oi0iixio.oIX0oI(xAxis.f4025ooXIXxIX, xAxis.f4006IIX0o, false);
        Legend legend = this.f15876X0IIOO;
        if (legend != null && !legend.xI()) {
            this.f15892xXxxox0I.oIX0oI(this.f15871Oo);
        }
        x0xO0oo();
    }

    public float getFactor() {
        RectF Oo2 = this.f15890xI.Oo();
        return Math.min(Oo2.width() / 2.0f, Oo2.height() / 2.0f) / this.f15935xoIxX.f4028xI;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        RectF Oo2 = this.f15890xI.Oo();
        return Math.min(Oo2.width() / 2.0f, Oo2.height() / 2.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRequiredBaseOffset() {
        if (this.f15883o00.XO() && this.f15883o00.IO()) {
            return this.f15883o00.f15974IoOoX;
        }
        return OOXIXo.X0o0xo(10.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRequiredLegendOffset() {
        return this.f15892xXxxox0I.X0o0xo().getTextSize() * 4.0f;
    }

    public int getSkipWebLineCount() {
        return this.f15928IoOoo;
    }

    public float getSliceAngle() {
        return 360.0f / ((IXxxXO) this.f15871Oo).xoXoI().X0xxXX0();
    }

    public int getWebAlpha() {
        return this.f15936xoxXI;
    }

    public int getWebColor() {
        return this.f15929O0Xx;
    }

    public int getWebColorInner() {
        return this.f15927I0oOIX;
    }

    public float getWebLineWidth() {
        return this.f15932Xo0;
    }

    public float getWebLineWidthInner() {
        return this.f15933XoI0Ixx0;
    }

    public YAxis getYAxis() {
        return this.f15935xoIxX;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, OOXIxO0.X0o0xo
    public float getYChartMax() {
        return this.f15935xoIxX.f4006IIX0o;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, OOXIxO0.X0o0xo
    public float getYChartMin() {
        return this.f15935xoIxX.f4025ooXIXxIX;
    }

    public float getYRange() {
        return this.f15935xoIxX.f4028xI;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void oO() {
        super.oO();
        YAxis yAxis = this.f15935xoIxX;
        IXxxXO iXxxXO = (IXxxXO) this.f15871Oo;
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        yAxis.x0XOIxOo(iXxxXO.XIxXXX0x0(axisDependency), ((IXxxXO) this.f15871Oo).X0IIOO(axisDependency));
        this.f15883o00.x0XOIxOo(0.0f, ((IXxxXO) this.f15871Oo).xoXoI().X0xxXX0());
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f15871Oo == 0) {
            return;
        }
        if (this.f15883o00.XO()) {
            oI0IIXIo oi0iixio = this.f15931OO0x0xX;
            XAxis xAxis = this.f15883o00;
            oi0iixio.oIX0oI(xAxis.f4025ooXIXxIX, xAxis.f4006IIX0o, false);
        }
        this.f15931OO0x0xX.Oxx0IOOO(canvas);
        if (this.f15930OO) {
            this.f15863IIX0o.I0Io(canvas);
        }
        if (this.f15935xoIxX.XO() && this.f15935xoIxX.xII()) {
            this.f15934x0xO.xoIox(canvas);
        }
        this.f15863IIX0o.II0xO0(canvas);
        if (oxxXoxO()) {
            this.f15863IIX0o.oxoX(canvas, this.f15865IO);
        }
        if (this.f15935xoIxX.XO() && !this.f15935xoIxX.xII()) {
            this.f15934x0xO.xoIox(canvas);
        }
        this.f15934x0xO.Oxx0IOOO(canvas);
        this.f15863IIX0o.XO(canvas);
        this.f15892xXxxox0I.XO(canvas);
        OxxIIOOXO(canvas);
        IIXOooo(canvas);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void ooXIXxIX() {
        super.ooXIXxIX();
        this.f15935xoIxX = new YAxis(YAxis.AxisDependency.LEFT);
        this.f15932Xo0 = OOXIXo.X0o0xo(1.5f);
        this.f15933XoI0Ixx0 = OOXIXo.X0o0xo(0.75f);
        this.f15863IIX0o = new x0XOIxOo(this, this.f15887oo0xXOI0I, this.f15890xI);
        this.f15934x0xO = new xoXoI(this.f15890xI, this.f15935xoIxX, this);
        this.f15931OO0x0xX = new oI0IIXIo(this.f15890xI, this.f15883o00, this);
        this.f15888ooXIXxIX = new xxIXOIIO(this);
    }

    public void setDrawWeb(boolean z) {
        this.f15930OO = z;
    }

    public void setSkipWebLineCount(int i) {
        this.f15928IoOoo = Math.max(0, i);
    }

    public void setWebAlpha(int i) {
        this.f15936xoxXI = i;
    }

    public void setWebColor(int i) {
        this.f15929O0Xx = i;
    }

    public void setWebColorInner(int i) {
        this.f15927I0oOIX = i;
    }

    public void setWebLineWidth(float f) {
        this.f15932Xo0 = OOXIXo.X0o0xo(f);
    }

    public void setWebLineWidthInner(float f) {
        this.f15933XoI0Ixx0 = OOXIXo.X0o0xo(f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public int xo0x(float f) {
        float O0xOxO2 = OOXIXo.O0xOxO(f - getRotationAngle());
        float sliceAngle = getSliceAngle();
        int X0xxXX02 = ((IXxxXO) this.f15871Oo).xoXoI().X0xxXX0();
        int i = 0;
        while (i < X0xxXX02) {
            int i2 = i + 1;
            if ((i2 * sliceAngle) - (sliceAngle / 2.0f) > O0xOxO2) {
                return i;
            }
            i = i2;
        }
        return 0;
    }

    public RadarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15932Xo0 = 2.5f;
        this.f15933XoI0Ixx0 = 1.5f;
        this.f15929O0Xx = Color.rgb(122, 122, 122);
        this.f15927I0oOIX = Color.rgb(122, 122, 122);
        this.f15936xoxXI = 150;
        this.f15930OO = true;
        this.f15928IoOoo = 0;
    }

    public RadarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15932Xo0 = 2.5f;
        this.f15933XoI0Ixx0 = 1.5f;
        this.f15929O0Xx = Color.rgb(122, 122, 122);
        this.f15927I0oOIX = Color.rgb(122, 122, 122);
        this.f15936xoxXI = 150;
        this.f15930OO = true;
        this.f15928IoOoo = 0;
    }
}
