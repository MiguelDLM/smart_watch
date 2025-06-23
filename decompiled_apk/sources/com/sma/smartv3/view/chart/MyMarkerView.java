package com.sma.smartv3.view.chart;

import XI0oooXX.oxoX;
import XIXIX.OOXIXo;
import XIXIX.Oxx0IOOO;
import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.sma.smartv3.co_fit.R;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes12.dex */
public class MyMarkerView extends MarkerView {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public final TextView f25450Oxx0xo;

    public MyMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);
        this.f25450Oxx0xo = (TextView) findViewById(R.id.tvContent);
    }

    @Override // com.github.mikephil.charting.components.MarkerView, XX0xXo.oxoX
    public void I0Io(Entry e, oxoX highlight) {
        if (e instanceof CandleEntry) {
            this.f25450Oxx0xo.setText(OOXIXo.oO(((CandleEntry) e).x0XOIxOo(), 0, true));
        } else {
            this.f25450Oxx0xo.setText(OOXIXo.oO(e.I0Io(), 0, true));
        }
        super.I0Io(e, highlight);
    }

    @Override // com.github.mikephil.charting.components.MarkerView, XX0xXo.oxoX
    public Oxx0IOOO getOffset() {
        return new Oxx0IOOO(-(getWidth() / 2), -getHeight());
    }
}
