package com.baidu.navisdk.module.navifeedback.ugcfee.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes7.dex */
public class BNNaviResultIndicatorView extends View {

    /* renamed from: a, reason: collision with root package name */
    private final Paint f7204a;
    private final RectF b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private int h;
    private int i;

    public BNNaviResultIndicatorView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f7204a = paint;
        this.b = new RectF();
        this.c = ScreenUtil.getInstance().dip2px(8);
        this.d = ScreenUtil.getInstance().dip2px(3);
        this.e = ScreenUtil.getInstance().dip2px(3);
        this.f = ScreenUtil.getInstance().dip2px(1.5f);
        this.g = ScreenUtil.getInstance().dip2px(5);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
    }

    private boolean a(int i, int i2) {
        return i2 >= 0 && i2 < i;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        int i;
        if (!a(this.h, this.i)) {
            return;
        }
        int width = getWidth();
        int i2 = this.h - 1;
        int i3 = (((width - (this.d * i2)) - this.c) - (i2 * this.g)) / 2;
        for (int i4 = 0; i4 < this.h; i4++) {
            if (this.i == i4) {
                z = true;
            } else {
                z = false;
            }
            this.f7204a.setColor(-13938793);
            if (z) {
                i = this.c;
            } else {
                i = this.d;
            }
            this.b.set(i3, 0.0f, i3 + i, this.e);
            RectF rectF = this.b;
            float f = this.f;
            canvas.drawRoundRect(rectF, f, f, this.f7204a);
            i3 += i + this.g;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824);
        if (a(this.h, this.i)) {
            i3 = this.e;
        } else {
            i3 = 0;
        }
        super.onMeasure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
    }

    public BNNaviResultIndicatorView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f7204a = paint;
        this.b = new RectF();
        this.c = ScreenUtil.getInstance().dip2px(8);
        this.d = ScreenUtil.getInstance().dip2px(3);
        this.e = ScreenUtil.getInstance().dip2px(3);
        this.f = ScreenUtil.getInstance().dip2px(1.5f);
        this.g = ScreenUtil.getInstance().dip2px(5);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
    }

    public BNNaviResultIndicatorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Paint paint = new Paint();
        this.f7204a = paint;
        this.b = new RectF();
        this.c = ScreenUtil.getInstance().dip2px(8);
        this.d = ScreenUtil.getInstance().dip2px(3);
        this.e = ScreenUtil.getInstance().dip2px(3);
        this.f = ScreenUtil.getInstance().dip2px(1.5f);
        this.g = ScreenUtil.getInstance().dip2px(5);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
    }

    @RequiresApi(api = 21)
    public BNNaviResultIndicatorView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Paint paint = new Paint();
        this.f7204a = paint;
        this.b = new RectF();
        this.c = ScreenUtil.getInstance().dip2px(8);
        this.d = ScreenUtil.getInstance().dip2px(3);
        this.e = ScreenUtil.getInstance().dip2px(3);
        this.f = ScreenUtil.getInstance().dip2px(1.5f);
        this.g = ScreenUtil.getInstance().dip2px(5);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
    }
}
