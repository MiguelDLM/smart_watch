package com.baidu.navisdk.ui.speed.interval;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class RGMMIntervalSpeedBgView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private int f9189a;
    private int b;
    private int c;
    private int d;
    private Drawable e;
    private Drawable f;

    public RGMMIntervalSpeedBgView(Context context) {
        super(context);
        this.f9189a = 0;
        this.b = 0;
        a(context, (AttributeSet) null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LayoutDirectionView);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.IntervalSpeedView);
        this.d = obtainStyledAttributes.getInt(R.styleable.LayoutDirectionView_nsdk_LayoutDirection, 1);
        this.f9189a = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.IntervalSpeedView_nsdk_maxSize, JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_142dp));
        this.b = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.IntervalSpeedView_nsdk_minSize, JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_76dp));
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMIntervalSpeedBgView", "mMaxSize:" + this.f9189a + ",mMinSize:" + this.b);
        }
        this.f = getResources().getDrawable(R.drawable.bnav_interval_camera_bg);
        this.e = getResources().getDrawable(R.drawable.bnav_interval_camera_land_bg);
        obtainStyledAttributes.recycle();
        obtainStyledAttributes2.recycle();
    }

    public void b(@DrawableRes int i, @DrawableRes int i2) {
        this.f = JarUtils.getResources().getDrawable(i);
        this.e = JarUtils.getResources().getDrawable(i2);
        invalidate();
    }

    public int getOffset() {
        return this.c;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.d == 2) {
            setMeasuredDimension(this.f9189a, this.b);
        } else {
            setMeasuredDimension(this.b, this.f9189a);
        }
    }

    public void setOffset(int i) {
        this.c = i;
        invalidate();
        setBackgroundColor(0);
    }

    public RGMMIntervalSpeedBgView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9189a = 0;
        this.b = 0;
        a(context, attributeSet);
    }

    public RGMMIntervalSpeedBgView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9189a = 0;
        this.b = 0;
        a(context, attributeSet);
    }

    public void a(int i, int i2) {
        this.d = i2;
        this.c = i;
        invalidate();
        setBackgroundColor(0);
    }

    public void a() {
        this.f = JarUtils.getResources().getDrawable(R.drawable.bnav_interval_camera_bg);
        this.e = JarUtils.getResources().getDrawable(R.drawable.bnav_interval_camera_land_bg);
        invalidate();
    }

    private void a(Canvas canvas) {
        Drawable drawable;
        boolean z = this.d == 2;
        if (z) {
            if (this.e == null) {
                this.e = getResources().getDrawable(R.drawable.bnav_interval_camera_land_bg);
            }
        } else if (this.f == null) {
            this.f = getResources().getDrawable(R.drawable.bnav_interval_camera_bg);
        }
        if (z) {
            drawable = this.e;
            drawable.setBounds(0, 0, this.c, this.b);
        } else {
            drawable = this.f;
            drawable.setBounds(0, 0, this.b, this.c);
        }
        drawable.draw(canvas);
    }
}
