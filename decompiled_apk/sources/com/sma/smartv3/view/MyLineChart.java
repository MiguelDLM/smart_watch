package com.sma.smartv3.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.github.mikephil.charting.charts.LineChart;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class MyLineChart extends LineChart {

    /* renamed from: IIX0, reason: collision with root package name */
    public boolean f25075IIX0;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public MyLineChart(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public final boolean getDisallowIntercept() {
        return this.f25075IIX0;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@OXOo.oOoXoXO MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 2) {
            getParent().requestDisallowInterceptTouchEvent(this.f25075IIX0);
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setDisallowIntercept(boolean z) {
        this.f25075IIX0 = z;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public MyLineChart(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ MyLineChart(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public MyLineChart(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f25075IIX0 = true;
    }
}
