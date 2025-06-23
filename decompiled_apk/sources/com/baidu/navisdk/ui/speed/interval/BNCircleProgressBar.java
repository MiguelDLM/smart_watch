package com.baidu.navisdk.ui.speed.interval;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class BNCircleProgressBar extends View {
    private static int i = 100;

    /* renamed from: a, reason: collision with root package name */
    private Paint f9187a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public BNCircleProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Canvas canvas) {
        this.f9187a.setColor(this.g);
        this.f9187a.setStyle(Paint.Style.FILL);
        float f = this.c / 2;
        canvas.drawCircle(f, f, f, this.f9187a);
    }

    private void b(Canvas canvas) {
        RectF rectF = new RectF();
        float f = this.b / 2;
        rectF.left = f;
        rectF.top = f;
        rectF.right = this.c - r0;
        rectF.bottom = this.d - r0;
        this.f9187a.setStyle(Paint.Style.STROKE);
        this.f9187a.setColor(this.h);
        canvas.drawArc(rectF, -90.0f, 360.0f, false, this.f9187a);
        this.f9187a.setColor(this.e);
        canvas.drawArc(rectF, -90.0f, (float) (((this.f * 1.0d) / i) * (-360.0d)), false, this.f9187a);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(0);
        a(canvas);
        b(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.c = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.d = measuredHeight;
        int i4 = this.c;
        if (i4 != measuredHeight) {
            int min = Math.min(i4, measuredHeight);
            this.c = min;
            this.d = min;
        }
    }

    public void setBarStrokeBgColor(@ColorInt int i2) {
        this.h = i2;
    }

    public void setBgColor(@ColorInt int i2) {
        this.g = i2;
    }

    public void setCircleStrokeWidth(int i2) {
        this.b = i2;
        Paint paint = this.f9187a;
        if (paint != null) {
            paint.setStrokeWidth(i2);
        }
    }

    public void setProgressColor(int i2) {
        this.e = i2;
    }

    public BNCircleProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f = 100;
        b();
        a();
        new ValueAnimator();
    }

    public void a() {
        Paint paint = new Paint();
        this.f9187a = paint;
        paint.setAntiAlias(true);
        this.f9187a.setStrokeWidth(this.b);
    }

    public void b() {
        this.g = -1;
        this.h = JarUtils.getResources().getColor(R.color.nsdk_interval_speed_progress_bar_bg);
    }
}
