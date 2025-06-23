package com.baidu.navisdk.ui.routeguide.subview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class RGTruckAvoidanceBGView extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f9105a;
    private Paint b;
    private Paint c;
    private RectF d;
    private int e;
    private int f;
    private int g;
    private float h;
    private String i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;

    public RGTruckAvoidanceBGView(Context context) {
        super(context);
        this.i = "";
        this.j = 50;
        this.k = 20;
        this.l = -1;
        this.m = ViewCompat.MEASURED_STATE_MASK;
        this.n = JarUtils.getResources().getColor(R.color.nsdk_rg_truck_aboidance_info_bg_color);
        a();
    }

    private void a() {
        Paint paint = new Paint(1);
        this.f9105a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f9105a.setColor(this.n);
        this.f9105a.setStrokeWidth(this.k);
        Paint paint2 = new Paint(1);
        this.b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.b.setColor(this.l);
        Paint paint3 = new Paint(1);
        this.c = paint3;
        paint3.setTextAlign(Paint.Align.CENTER);
        this.c.setTypeface(Typeface.DEFAULT_BOLD);
        this.c.setColor(this.m);
        this.c.setTextSize(this.j);
    }

    private void b() {
        this.e = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f = measuredHeight;
        int min = Math.min(this.e, measuredHeight);
        int i = this.k;
        float f = i;
        float f2 = min - i;
        RectF rectF = new RectF(f, f, f2, f2);
        this.d = rectF;
        this.g = min / 2;
        this.h = (rectF.right - rectF.left) / 2.0f;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.g;
        canvas.drawCircle(f, f, this.h, this.b);
        canvas.drawArc(this.d, 0.0f, 360.0f, false, this.f9105a);
        String str = this.i;
        canvas.drawText(str, 0, str.length(), this.g, r0 + (this.j / 4), this.c);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        b();
    }

    public void setArcStrockeColor(int i) {
        this.n = i;
        this.f9105a.setColor(i);
    }

    public void setArcStrokeWidth(int i) {
        this.k = i;
        this.f9105a.setStrokeWidth(i);
    }

    public void setCircleColor(int i) {
        this.l = i;
        this.b.setColor(i);
    }

    public void setText(String str) {
        this.i = str;
        requestLayout();
        invalidate();
    }

    public void setTextColor(int i) {
        this.m = i;
        this.c.setColor(i);
    }

    public void setTextSize(int i) {
        this.j = i;
        this.c.setTextSize(i);
    }

    public RGTruckAvoidanceBGView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = "";
        this.j = 50;
        this.k = 20;
        this.l = -1;
        this.m = ViewCompat.MEASURED_STATE_MASK;
        this.n = JarUtils.getResources().getColor(R.color.nsdk_rg_truck_aboidance_info_bg_color);
        a();
    }

    public RGTruckAvoidanceBGView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = "";
        this.j = 50;
        this.k = 20;
        this.l = -1;
        this.m = ViewCompat.MEASURED_STATE_MASK;
        this.n = JarUtils.getResources().getColor(R.color.nsdk_rg_truck_aboidance_info_bg_color);
        a();
    }
}
