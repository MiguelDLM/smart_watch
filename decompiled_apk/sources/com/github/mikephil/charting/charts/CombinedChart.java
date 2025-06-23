package com.github.mikephil.charting.charts;

import IIxOXoOo0.II0xO0;
import OOXIxO0.XO;
import XI0oooXX.I0Io;
import XI0oooXX.oxoX;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.data.Entry;
import o0xxxXXxX.Oxx0IOOO;
import o0xxxXXxX.oI0IIXIo;
import o0xxxXXxX.oIX0oI;
import o0xxxXXxX.oOoXoXO;
import o0xxxXXxX.ooOOo0oXI;
import o0xxxXXxX.xxIXOIIO;

/* loaded from: classes9.dex */
public class CombinedChart extends BarLineChartBase<oOoXoXO> implements XO {

    /* renamed from: IIX0, reason: collision with root package name */
    public boolean f15897IIX0;

    /* renamed from: O0, reason: collision with root package name */
    public DrawOrder[] f15898O0;

    /* renamed from: Ox0O, reason: collision with root package name */
    public boolean f15899Ox0O;

    /* renamed from: xOoOIoI, reason: collision with root package name */
    public boolean f15900xOoOIoI;

    /* loaded from: classes9.dex */
    public enum DrawOrder {
        BAR,
        BUBBLE,
        LINE,
        CANDLE,
        SCATTER
    }

    public CombinedChart(Context context) {
        super(context);
        this.f15897IIX0 = true;
        this.f15900xOoOIoI = false;
        this.f15899Ox0O = false;
    }

    @Override // OOXIxO0.oIX0oI
    public boolean I0Io() {
        return this.f15899Ox0O;
    }

    @Override // OOXIxO0.oIX0oI
    public boolean II0xO0() {
        return this.f15900xOoOIoI;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void IIXOooo(Canvas canvas) {
        if (this.f15880XOxIOxOx != null && oo() && oxxXoxO()) {
            int i = 0;
            while (true) {
                oxoX[] oxoxArr = this.f15865IO;
                if (i < oxoxArr.length) {
                    oxoX oxox = oxoxArr[i];
                    II0xO0<? extends Entry> XX2 = ((oOoXoXO) this.f15871Oo).XX(oxox);
                    Entry Oxx0xo2 = ((oOoXoXO) this.f15871Oo).Oxx0xo(oxox);
                    if (Oxx0xo2 != null && XX2.oxoX(Oxx0xo2) <= XX2.X0xxXX0() * this.f15887oo0xXOI0I.II0XooXoX()) {
                        float[] OxI2 = OxI(oxox);
                        if (this.f15890xI.IIX0o(OxI2[0], OxI2[1])) {
                            this.f15880XOxIOxOx.I0Io(Oxx0xo2, oxox);
                            this.f15880XOxIOxOx.oIX0oI(canvas, OxI2[0], OxI2[1]);
                        }
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // OOXIxO0.oIX0oI
    public oIX0oI getBarData() {
        T t = this.f15871Oo;
        if (t == 0) {
            return null;
        }
        return ((oOoXoXO) t).x0o();
    }

    @Override // OOXIxO0.I0Io
    public Oxx0IOOO getBubbleData() {
        T t = this.f15871Oo;
        if (t == 0) {
            return null;
        }
        return ((oOoXoXO) t).XOxIOxOx();
    }

    @Override // OOXIxO0.oxoX
    public xxIXOIIO getCandleData() {
        T t = this.f15871Oo;
        if (t == 0) {
            return null;
        }
        return ((oOoXoXO) t).OI0();
    }

    @Override // OOXIxO0.XO
    public oOoXoXO getCombinedData() {
        return (oOoXoXO) this.f15871Oo;
    }

    public DrawOrder[] getDrawOrder() {
        return this.f15898O0;
    }

    @Override // OOXIxO0.Oxx0IOOO
    public ooOOo0oXI getLineData() {
        T t = this.f15871Oo;
        if (t == 0) {
            return null;
        }
        return ((oOoXoXO) t).I0oOoX();
    }

    @Override // OOXIxO0.II0XooXoX
    public oI0IIXIo getScatterData() {
        T t = this.f15871Oo;
        if (t == 0) {
            return null;
        }
        return ((oOoXoXO) t).oxxXoxO();
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
        return this.f15897IIX0;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void ooXIXxIX() {
        super.ooXIXxIX();
        this.f15898O0 = new DrawOrder[]{DrawOrder.BAR, DrawOrder.BUBBLE, DrawOrder.LINE, DrawOrder.CANDLE, DrawOrder.SCATTER};
        setHighlighter(new I0Io(this, this));
        setHighlightFullBarEnabled(true);
        this.f15863IIX0o = new xX0IIXIx0.XO(this, this.f15887oo0xXOI0I, this.f15890xI);
    }

    public void setDrawBarShadow(boolean z) {
        this.f15899Ox0O = z;
    }

    public void setDrawOrder(DrawOrder[] drawOrderArr) {
        if (drawOrderArr != null && drawOrderArr.length > 0) {
            this.f15898O0 = drawOrderArr;
        }
    }

    public void setDrawValueAboveBar(boolean z) {
        this.f15897IIX0 = z;
    }

    public void setHighlightFullBarEnabled(boolean z) {
        this.f15900xOoOIoI = z;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void setData(oOoXoXO oooxoxo) {
        super.setData((CombinedChart) oooxoxo);
        setHighlighter(new I0Io(this, this));
        ((xX0IIXIx0.XO) this.f15863IIX0o).oOoXoXO();
        this.f15863IIX0o.xoIox();
    }

    public CombinedChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15897IIX0 = true;
        this.f15900xOoOIoI = false;
        this.f15899Ox0O = false;
    }

    public CombinedChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15897IIX0 = true;
        this.f15900xOoOIoI = false;
        this.f15899Ox0O = false;
    }
}
