package com.github.mikephil.charting.charts;

import OOXIxO0.I0Io;
import android.content.Context;
import android.util.AttributeSet;
import o0xxxXXxX.Oxx0IOOO;
import xX0IIXIx0.oxoX;

/* loaded from: classes9.dex */
public class BubbleChart extends BarLineChartBase<Oxx0IOOO> implements I0Io {
    public BubbleChart(Context context) {
        super(context);
    }

    @Override // OOXIxO0.I0Io
    public Oxx0IOOO getBubbleData() {
        return (Oxx0IOOO) this.f15871Oo;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void ooXIXxIX() {
        super.ooXIXxIX();
        this.f15863IIX0o = new oxoX(this, this.f15887oo0xXOI0I, this.f15890xI);
    }

    public BubbleChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BubbleChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
