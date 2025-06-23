package com.github.mikephil.charting.charts;

import OOXIxO0.II0XooXoX;
import android.content.Context;
import android.util.AttributeSet;
import o0xxxXXxX.oI0IIXIo;
import xX0IIXIx0.x0xO0oo;

/* loaded from: classes9.dex */
public class ScatterChart extends BarLineChartBase<oI0IIXIo> implements II0XooXoX {

    /* loaded from: classes9.dex */
    public enum ScatterShape {
        SQUARE("SQUARE"),
        CIRCLE("CIRCLE"),
        TRIANGLE("TRIANGLE"),
        CROSS("CROSS"),
        X("X"),
        CHEVRON_UP("CHEVRON_UP"),
        CHEVRON_DOWN("CHEVRON_DOWN");

        private final String shapeIdentifier;

        ScatterShape(String str) {
            this.shapeIdentifier = str;
        }

        public static ScatterShape[] getAllDefaultShapes() {
            return new ScatterShape[]{SQUARE, CIRCLE, TRIANGLE, CROSS, X, CHEVRON_UP, CHEVRON_DOWN};
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.shapeIdentifier;
        }
    }

    public ScatterChart(Context context) {
        super(context);
    }

    @Override // OOXIxO0.II0XooXoX
    public oI0IIXIo getScatterData() {
        return (oI0IIXIo) this.f15871Oo;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void ooXIXxIX() {
        super.ooXIXxIX();
        this.f15863IIX0o = new x0xO0oo(this, this.f15887oo0xXOI0I, this.f15890xI);
        getXAxis().XX0xXo(0.5f);
        getXAxis().xxIO(0.5f);
    }

    public ScatterChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScatterChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
