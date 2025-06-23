package com.github.mikephil.charting.charts;

import OOXIxO0.Oxx0IOOO;
import android.content.Context;
import android.util.AttributeSet;
import o0xxxXXxX.ooOOo0oXI;
import xX0IIXIx0.xoIox;

/* loaded from: classes9.dex */
public class LineChart extends BarLineChartBase<ooOOo0oXI> implements Oxx0IOOO {
    public LineChart(Context context) {
        super(context);
    }

    @Override // OOXIxO0.Oxx0IOOO
    public ooOOo0oXI getLineData() {
        return (ooOOo0oXI) this.f15871Oo;
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        xX0IIXIx0.Oxx0IOOO oxx0IOOO = this.f15863IIX0o;
        if (oxx0IOOO != null && (oxx0IOOO instanceof xoIox)) {
            ((xoIox) oxx0IOOO).X0IIOO();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void ooXIXxIX() {
        super.ooXIXxIX();
        this.f15863IIX0o = new xoIox(this, this.f15887oo0xXOI0I, this.f15890xI);
    }

    public LineChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LineChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
