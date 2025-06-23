package com.github.mikephil.charting.charts;

import OOXIxO0.oxoX;
import android.content.Context;
import android.util.AttributeSet;
import o0xxxXXxX.xxIXOIIO;
import xX0IIXIx0.X0o0xo;

/* loaded from: classes9.dex */
public class CandleStickChart extends BarLineChartBase<xxIXOIIO> implements oxoX {
    public CandleStickChart(Context context) {
        super(context);
    }

    @Override // OOXIxO0.oxoX
    public xxIXOIIO getCandleData() {
        return (xxIXOIIO) this.f15871Oo;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void ooXIXxIX() {
        super.ooXIXxIX();
        this.f15863IIX0o = new X0o0xo(this, this.f15887oo0xXOI0I, this.f15890xI);
        getXAxis().XX0xXo(0.5f);
        getXAxis().xxIO(0.5f);
    }

    public CandleStickChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CandleStickChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
