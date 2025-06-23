package com.baidu.navisdk.module.carlogo.views;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class ThreeDColorView extends View {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7085a;

    @ColorInt
    private int b;

    @ColorInt
    private int c;

    @ColorInt
    private int d;
    private Paint e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private int m;
    private Bitmap n;
    private RectF o;
    private PaintFlagsDrawFilter p;

    public ThreeDColorView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        setBackgroundResource(R.color.transparent);
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.e.setStyle(Paint.Style.FILL);
        Resources resources = context.getResources();
        int i = com.baidu.navisdk.embed.R.dimen.navi_dimens_29dp;
        this.m = resources.getDimensionPixelSize(i) / 2;
        this.l = resources.getDimensionPixelSize(com.baidu.navisdk.embed.R.dimen.navi_dimens_1dp);
        this.k = resources.getDimension(i) / 2.0f;
        float dimension = resources.getDimension(com.baidu.navisdk.embed.R.dimen.navi_dimens_17dp) / 2.0f;
        float f = this.l / 2.0f;
        float f2 = dimension - f;
        this.j = f2;
        this.i = f2 - f;
        this.h = resources.getDimension(com.baidu.navisdk.embed.R.dimen.navi_dimens_21dp) / 2.0f;
        float dimension2 = resources.getDimension(com.baidu.navisdk.embed.R.dimen.navi_dimens_13dp) / 2.0f;
        float f3 = this.l;
        float f4 = f3 / 2.0f;
        float f5 = dimension2 - f4;
        this.g = f5;
        this.f = f5 - f4;
        this.l = f3 + 0.03f;
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, com.baidu.navisdk.embed.R.drawable.nsdk_icon_3d_color_selected);
        this.n = decodeResource;
        float f6 = (r1 - r6) / 2.0f;
        float f7 = (r1 - r0) / 2.0f;
        this.o = new RectF(f6, f7, decodeResource.getWidth() + f6, this.n.getHeight() + f7);
        this.p = new PaintFlagsDrawFilter(0, 3);
    }

    private void b(Canvas canvas) {
        Paint paint = this.e;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.e.setStrokeWidth(0.0f);
        this.e.setColor(this.b);
        float f = this.m;
        canvas.drawCircle(f, f, this.h, this.e);
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setStrokeWidth(this.l);
        this.e.setColor(this.c);
        float f2 = this.m;
        canvas.drawCircle(f2, f2, this.g, this.e);
        this.e.setStyle(style);
        this.e.setStrokeWidth(0.0f);
        this.e.setColor(this.d);
        float f3 = this.m;
        canvas.drawCircle(f3, f3, this.f, this.e);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f7085a) {
            a(canvas);
        } else {
            b(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.m * 2;
        setMeasuredDimension(i3, i3);
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ThreeDColorView", "setSelected: " + z + ", last:" + this.f7085a);
        }
        this.f7085a = z;
        invalidate();
    }

    public ThreeDColorView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ThreeDColorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public void a(@ColorInt int i, @ColorInt int i2, @ColorInt int i3, boolean z) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.f7085a = z;
        invalidate();
    }

    private void a(Canvas canvas) {
        Paint paint = this.e;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.e.setStrokeWidth(0.0f);
        this.e.setColor(this.b);
        float f = this.m;
        canvas.drawCircle(f, f, this.k, this.e);
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setStrokeWidth(this.l);
        this.e.setColor(this.c);
        float f2 = this.m;
        canvas.drawCircle(f2, f2, this.j, this.e);
        this.e.setStyle(style);
        this.e.setStrokeWidth(0.0f);
        this.e.setColor(this.d);
        float f3 = this.m;
        canvas.drawCircle(f3, f3, this.i, this.e);
        canvas.setDrawFilter(this.p);
        canvas.drawBitmap(this.n, (Rect) null, this.o, (Paint) null);
    }

    public void a() {
        Bitmap bitmap = this.n;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.n.recycle();
            this.n = null;
        }
        this.o = null;
    }
}
