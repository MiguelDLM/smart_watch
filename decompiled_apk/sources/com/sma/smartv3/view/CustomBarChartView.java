package com.sma.smartv3.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.github.mikephil.charting.charts.BarChart;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class CustomBarChartView extends BarChart {

    /* renamed from: xx0X0, reason: collision with root package name */
    @OXOo.oOoXoXO
    public oIX0oI f24877xx0X0;

    /* loaded from: classes12.dex */
    public interface oIX0oI {
        void oIX0oI(@OXOo.OOXIXo MotionEvent motionEvent);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public CustomBarChartView(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@OXOo.OOXIXo MotionEvent event) {
        IIX0o.x0xO0oo(event, "event");
        oIX0oI oix0oi = this.f24877xx0X0;
        if (oix0oi != null) {
            oix0oi.oIX0oI(event);
        }
        return super.dispatchTouchEvent(event);
    }

    public final void setOnChartTouchListener(@OXOo.oOoXoXO oIX0oI oix0oi) {
        this.f24877xx0X0 = oix0oi;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public CustomBarChartView(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ CustomBarChartView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public CustomBarChartView(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
    }
}
