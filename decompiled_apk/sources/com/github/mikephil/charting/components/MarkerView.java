package com.github.mikephil.charting.components;

import XIXIX.Oxx0IOOO;
import XX0xXo.oxoX;
import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import java.lang.ref.WeakReference;

/* loaded from: classes9.dex */
public class MarkerView extends RelativeLayout implements oxoX {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public WeakReference<Chart> f15970IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public Oxx0IOOO f15971Oo;

    /* renamed from: XO, reason: collision with root package name */
    public Oxx0IOOO f15972XO;

    public MarkerView(Context context, int i) {
        super(context);
        this.f15972XO = new Oxx0IOOO();
        this.f15971Oo = new Oxx0IOOO();
        setupLayoutResource(i);
    }

    private void setupLayoutResource(int i) {
        View inflate = LayoutInflater.from(getContext()).inflate(i, this);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
    }

    @Override // XX0xXo.oxoX
    public void I0Io(Entry entry, XI0oooXX.oxoX oxox) {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // XX0xXo.oxoX
    public Oxx0IOOO II0xO0(float f, float f2) {
        Oxx0IOOO offset = getOffset();
        Oxx0IOOO oxx0IOOO = this.f15971Oo;
        oxx0IOOO.f3771IXxxXO = offset.f3771IXxxXO;
        oxx0IOOO.f3772Oxx0xo = offset.f3772Oxx0xo;
        Chart chartView = getChartView();
        float width = getWidth();
        float height = getHeight();
        Oxx0IOOO oxx0IOOO2 = this.f15971Oo;
        float f3 = oxx0IOOO2.f3771IXxxXO;
        if (f + f3 < 0.0f) {
            oxx0IOOO2.f3771IXxxXO = -f;
        } else if (chartView != null && f + width + f3 > chartView.getWidth()) {
            this.f15971Oo.f3771IXxxXO = (chartView.getWidth() - f) - width;
        }
        Oxx0IOOO oxx0IOOO3 = this.f15971Oo;
        float f4 = oxx0IOOO3.f3772Oxx0xo;
        if (f2 + f4 < 0.0f) {
            oxx0IOOO3.f3772Oxx0xo = -f2;
        } else if (chartView != null && f2 + height + f4 > chartView.getHeight()) {
            this.f15971Oo.f3772Oxx0xo = (chartView.getHeight() - f2) - height;
        }
        return this.f15971Oo;
    }

    public Chart getChartView() {
        WeakReference<Chart> weakReference = this.f15970IXxxXO;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // XX0xXo.oxoX
    public Oxx0IOOO getOffset() {
        return this.f15972XO;
    }

    @Override // XX0xXo.oxoX
    public void oIX0oI(Canvas canvas, float f, float f2) {
        Oxx0IOOO II0xO02 = II0xO0(f, f2);
        int save = canvas.save();
        canvas.translate(f + II0xO02.f3771IXxxXO, f2 + II0xO02.f3772Oxx0xo);
        draw(canvas);
        canvas.restoreToCount(save);
    }

    public void oxoX(float f, float f2) {
        Oxx0IOOO oxx0IOOO = this.f15972XO;
        oxx0IOOO.f3771IXxxXO = f;
        oxx0IOOO.f3772Oxx0xo = f2;
    }

    public void setChartView(Chart chart) {
        this.f15970IXxxXO = new WeakReference<>(chart);
    }

    public void setOffset(Oxx0IOOO oxx0IOOO) {
        this.f15972XO = oxx0IOOO;
        if (oxx0IOOO == null) {
            this.f15972XO = new Oxx0IOOO();
        }
    }
}
