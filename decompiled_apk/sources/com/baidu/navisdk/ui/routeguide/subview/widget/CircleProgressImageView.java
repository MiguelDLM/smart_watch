package com.baidu.navisdk.ui.routeguide.subview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class CircleProgressImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private a f9099a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;
    private Drawable i;
    private String j;

    /* loaded from: classes8.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public RectF f9100a = new RectF();
        public boolean b = true;
        public int c = 0;
        public int d = 0;
        public int e = 0;
        public int f = 0;
        public int g = -90;
        public int h;
        public int i;
        public Paint j;
        public Paint k;
        public Paint l;
        public Paint m;

        public a() {
            Paint paint = new Paint();
            this.j = paint;
            paint.setAntiAlias(true);
            Paint paint2 = this.j;
            Paint.Style style = Paint.Style.FILL;
            paint2.setStyle(style);
            this.j.setStrokeWidth(this.d);
            this.j.setColor(this.f);
            Paint paint3 = new Paint();
            this.k = paint3;
            paint3.setAntiAlias(true);
            this.k.setStyle(style);
            this.k.setStrokeWidth(this.d);
            this.k.setColor(this.f);
            Paint paint4 = new Paint();
            this.l = paint4;
            paint4.setAntiAlias(true);
            this.l.setStyle(style);
            this.l.setStrokeWidth(this.d);
            this.l.setColor(-7829368);
            Paint paint5 = new Paint();
            this.m = paint5;
            paint5.setAntiAlias(true);
            this.m.setTextAlign(Paint.Align.CENTER);
            this.m.setStyle(style);
            this.m.setStrokeWidth(this.d);
            this.m.setColor(ViewCompat.MEASURED_STATE_MASK);
            this.m.setTextSize(ScreenUtil.getInstance().dip2px(25));
        }

        public void a(int i) {
            this.l.setColor(i);
        }

        public void b(int i) {
            this.j.setColor(i);
            this.k.setColor((i & 16777215) | 1711276032);
        }

        public void c(int i) {
            float f = i;
            this.j.setStrokeWidth(f);
            this.k.setStrokeWidth(f);
            this.l.setStrokeWidth(f);
        }

        public void d(int i) {
            this.j.setStrokeWidth(i);
            this.e = i;
        }

        public void e(int i) {
            this.h = i;
            this.m.setColor(i);
        }

        public void a(boolean z) {
            this.b = z;
            if (z) {
                Paint paint = this.j;
                Paint.Style style = Paint.Style.FILL;
                paint.setStyle(style);
                this.k.setStyle(style);
                this.l.setStyle(style);
                return;
            }
            Paint paint2 = this.j;
            Paint.Style style2 = Paint.Style.STROKE;
            paint2.setStyle(style2);
            this.k.setStyle(style2);
            this.l.setStyle(style2);
        }

        public void a(int i, int i2) {
            int max = Math.max(this.d, this.e);
            int i3 = this.c;
            if (i3 != 0) {
                RectF rectF = this.f9100a;
                int i4 = max / 2;
                float dip2px = i3 + i4 + ScreenUtil.getInstance().dip2px(1);
                int i5 = this.c;
                int i6 = i - i4;
                int i7 = i2 - i4;
                rectF.set(dip2px, i4 + i5, (i6 - i5) - ScreenUtil.getInstance().dip2px(1), (i7 - this.c) - ScreenUtil.getInstance().dip2px(2));
                g gVar = g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("wangyang", "autoFix " + (this.c + i4 + ScreenUtil.getInstance().dip2px(1)) + " ; " + (i4 + this.c) + "," + ((i6 - this.c) - ScreenUtil.getInstance().dip2px(1)) + " ; " + ((i7 - this.c) - ScreenUtil.getInstance().dip2px(2)));
                    return;
                }
                return;
            }
            int paddingLeft = CircleProgressImageView.this.getPaddingLeft();
            int paddingRight = CircleProgressImageView.this.getPaddingRight();
            int i8 = max / 2;
            int i9 = paddingLeft + i8;
            int paddingTop = CircleProgressImageView.this.getPaddingTop() + i8;
            int i10 = (i - paddingRight) - i8;
            int paddingBottom = (i2 - CircleProgressImageView.this.getPaddingBottom()) - i8;
            this.f9100a.set(i9, paddingTop, i10, paddingBottom);
            g gVar2 = g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("wangyang", "autoFix " + i9 + " ; " + paddingTop + "," + i10 + " ; " + paddingBottom);
            }
        }
    }

    public CircleProgressImageView(Context context) {
        super(context);
        this.h = false;
        a();
    }

    private void a() {
        this.f9099a = new a();
        this.b = 100;
        this.c = 0;
        this.d = 0;
        this.j = "";
    }

    public synchronized int getMainProgress() {
        return this.c;
    }

    public synchronized int getSubProgress() {
        return this.d;
    }

    public String getText() {
        return this.j;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a aVar = this.f9099a;
        canvas.drawArc(aVar.f9100a, aVar.g, (this.d / this.b) * 360.0f, aVar.b, aVar.k);
        a aVar2 = this.f9099a;
        canvas.drawArc(aVar2.f9100a, aVar2.g, (this.c / this.b) * 360.0f, aVar2.b, aVar2.j);
        a(canvas);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("wangyang", "CircleProgressImageView onDraw ");
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Drawable background = getBackground();
        this.i = background;
        if (background != null) {
            size = background.getMinimumWidth();
            size2 = this.i.getMinimumHeight();
        }
        setMeasuredDimension(View.resolveSize(size, i), View.resolveSize(size2, i2));
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("wangyang", "CircleProgressImageView onMeasure  mode =" + View.MeasureSpec.getMode(i2) + " widthMeasureSpec=" + i + " heightMeasureSpec=" + i2 + " width=" + size + " height=" + size2 + "resolvewidthSize= " + View.resolveSize(size, i) + "resolveHeightSize= " + View.resolveSize(size2, i2));
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f9099a.a(i, i2);
    }

    public void setBeamHeight(int i) {
        this.f9099a.i = i;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageDrawable(JarUtils.getResources().getDrawable(i));
    }

    public synchronized void setMainProgress(int i) {
        try {
            if (this.c != i) {
                this.c = i;
                if (i < 0) {
                    this.c = 0;
                }
                int i2 = this.c;
                int i3 = this.b;
                if (i2 > i3) {
                    this.c = i3;
                }
                invalidate();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setSubProgress(int i) {
        try {
            if (this.d != i) {
                this.d = i;
                if (i < 0) {
                    this.d = 0;
                }
                int i2 = this.d;
                int i3 = this.b;
                if (i2 > i3) {
                    this.d = i3;
                }
                invalidate();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setText(String str) {
        if (str == null) {
            return;
        }
        String str2 = this.j;
        if (str2 == null || !str2.equals(str)) {
            this.j = str;
            invalidate();
        }
    }

    public CircleProgressImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = false;
        a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleProgressImageView);
        this.b = obtainStyledAttributes.getInteger(R.styleable.CircleProgressImageView_nsdk_bn_max, 100);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.CircleProgressImageView_nsdk_bn_fill, true);
        int dimension = (int) obtainStyledAttributes.getDimension(R.styleable.CircleProgressImageView_nsdk_bn_paint_width, 10.0f);
        this.f9099a.a(z);
        int integer = obtainStyledAttributes.getInteger(R.styleable.CircleProgressImageView_nsdk_bn_sub_progress_paint_color, 0);
        this.e = integer;
        this.f9099a.k.setColor(integer);
        int integer2 = obtainStyledAttributes.getInteger(R.styleable.CircleProgressImageView_nsdk_bn_circle_background_color, 0);
        this.f = integer2;
        if (integer2 != 0) {
            this.f9099a.a(integer2);
        }
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.CircleProgressImageView_nsdk_bn_circle_fill, z);
        this.g = z2;
        if (z2) {
            this.f9099a.l.setStyle(Paint.Style.FILL);
        } else {
            this.f9099a.l.setStyle(Paint.Style.STROKE);
        }
        if (!z) {
            this.f9099a.c(dimension);
        }
        this.f9099a.d((int) obtainStyledAttributes.getDimension(R.styleable.CircleProgressImageView_nsdk_bn_progress_paint_width, 10.0f));
        this.f9099a.b(obtainStyledAttributes.getColor(R.styleable.CircleProgressImageView_nsdk_bn_paint_color, 0));
        this.f9099a.c = (int) obtainStyledAttributes.getDimension(R.styleable.CircleProgressImageView_nsdk_bn_inside_interval, 0.0f);
        this.f9099a.e(obtainStyledAttributes.getColor(R.styleable.CircleProgressImageView_nsdk_bn_text_color, ViewCompat.MEASURED_STATE_MASK));
        boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.CircleProgressImageView_nsdk_bn_main_progress_cap_round, false);
        this.h = z3;
        if (z3) {
            this.f9099a.j.setStrokeCap(Paint.Cap.ROUND);
        }
        obtainStyledAttributes.recycle();
    }

    private void a(Canvas canvas) {
        if (TextUtils.isEmpty(this.j)) {
            return;
        }
        a aVar = this.f9099a;
        if (aVar.i != 0) {
            aVar.i = getHeight() / 3;
        }
        Rect rect = new Rect();
        this.f9099a.m.getTextBounds(this.j, 0, r2.length() - 1, rect);
        int abs = Math.abs(rect.bottom - rect.top);
        int height = getHeight() + abs;
        canvas.drawText(this.j, (int) (getWidth() * 0.5d), (int) ((height + r0.i) * 0.5d), this.f9099a.m);
    }
}
