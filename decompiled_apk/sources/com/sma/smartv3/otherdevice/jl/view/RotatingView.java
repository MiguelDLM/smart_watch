package com.sma.smartv3.otherdevice.jl.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.sma.smartv3.R;

/* loaded from: classes12.dex */
public class RotatingView extends View {

    /* renamed from: IIX0o, reason: collision with root package name */
    public oIX0oI f21110IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public Paint f21111IIXOooo;

    /* renamed from: IO, reason: collision with root package name */
    public int f21112IO;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f21113IXxxXO;

    /* renamed from: Io, reason: collision with root package name */
    public boolean f21114Io;

    /* renamed from: IoOoX, reason: collision with root package name */
    public float f21115IoOoX;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public int f21116O0xOxO;

    /* renamed from: OI0, reason: collision with root package name */
    public boolean f21117OI0;

    /* renamed from: Oo, reason: collision with root package name */
    public int f21118Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public int f21119OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public Paint f21120Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public Paint f21121OxxIIOOXO;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public int f21122X00IoxXI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public Bitmap f21123X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public Bitmap f21124XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public Bitmap f21125XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public int f21126XO;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public float f21127XOxIOxOx;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public int f21128Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public PaintFlagsDrawFilter f21129XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public int f21130o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public Paint f21131oI0IIXIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public int f21132oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public float f21133oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f21134oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public int f21135ooXIXxIX;

    /* renamed from: x0o, reason: collision with root package name */
    public int f21136x0o;

    /* renamed from: xI, reason: collision with root package name */
    public int f21137xI;

    /* renamed from: xII, reason: collision with root package name */
    public SweepGradient f21138xII;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public II0xO0 f21139xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f21140xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public Bitmap f21141xxX;

    /* loaded from: classes12.dex */
    public interface II0xO0 {
        void oIX0oI(RotatingView view, int value, boolean end);
    }

    /* loaded from: classes12.dex */
    public interface oIX0oI {
        void onClick(int temp);
    }

    public RotatingView(Context context) {
        this(context, null);
    }

    private int getMaxRotateAngle() {
        return 360 - ((this.f21136x0o - 90) * 2);
    }

    public static Bitmap ooOOo0oXI(Bitmap bm, int newWidth, int newHeight) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(newWidth / width, newHeight / height);
        return Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
    }

    public int I0Io(float dp) {
        return (int) TypedValue.applyDimension(1, dp, getResources().getDisplayMetrics());
    }

    public final void II0XooXoX(Canvas canvas) {
        String str = this.f21119OxI + "";
        Rect rect = new Rect();
        this.f21120Oxx0xo.getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(this.f21119OxI + "", getWidth() / 2, (getHeight() / 2) + (rect.height() / 2), this.f21120Oxx0xo);
    }

    public final float II0xO0(float targetX, float targetY) {
        double d;
        float f = targetX - (this.f21126XO / 2.0f);
        float f2 = targetY - (this.f21118Oo / 2.0f);
        if (f != 0.0f) {
            float abs = Math.abs(f2 / f);
            if (f > 0.0f) {
                if (f2 >= 0.0f) {
                    d = Math.atan(abs);
                } else {
                    d = 6.283185307179586d - Math.atan(abs);
                }
            } else if (f2 >= 0.0f) {
                d = 3.141592653589793d - Math.atan(abs);
            } else {
                d = Math.atan(abs) + 3.141592653589793d;
            }
        } else if (f2 > 0.0f) {
            d = 1.5707963267948966d;
        } else {
            d = -1.5707963267948966d;
        }
        return (float) ((d * 180.0d) / 3.141592653589793d);
    }

    public void OOXIXo(int min, int max, int value) {
        if (min == this.f21140xoXoI && this.f21130o00 == max && this.f21119OxI == value) {
            return;
        }
        this.f21140xoXoI = min;
        this.f21130o00 = max;
        this.f21119OxI = Math.max(min, value);
        float maxRotateAngle = (getMaxRotateAngle() / (max - min)) / this.f21116O0xOxO;
        this.f21127XOxIOxOx = maxRotateAngle;
        this.f21133oo = (r5 - min) * r4 * maxRotateAngle;
        invalidate();
    }

    public final void Oxx0IOOO(Canvas canvas) {
        float sin = (float) (this.f21113IXxxXO * Math.sin(Math.toRadians(this.f21136x0o - 90)));
        float height = getHeight() - this.f21141xxX.getWidth();
        canvas.drawBitmap(this.f21125XIxXXX0x0, ((getWidth() / 2.0f) - sin) - (this.f21125XIxXXX0x0.getWidth() / 2.0f), height, (Paint) null);
        canvas.drawBitmap(this.f21141xxX, ((getWidth() / 2.0f) + sin) - (this.f21125XIxXXX0x0.getWidth() / 2.0f), height, (Paint) null);
    }

    public final void X0o0xo(Canvas canvas) {
        int strokeWidth = (int) (this.f21111IIXOooo.getStrokeWidth() * 1.2d);
        Bitmap bitmap = this.f21123X0IIOO;
        int i = this.f21113IXxxXO;
        Bitmap ooOOo0oXI2 = ooOOo0oXI(bitmap, (i * 2) - strokeWidth, (i * 2) - strokeWidth);
        int width = ooOOo0oXI2.getWidth();
        int height = ooOOo0oXI2.getHeight();
        Matrix matrix = new Matrix();
        matrix.setTranslate((this.f21126XO - width) / 2.0f, (this.f21118Oo - height) / 2.0f);
        canvas.setDrawFilter(this.f21129XxX0x0xxx);
        canvas.drawBitmap(ooOOo0oXI2, matrix, this.f21121OxxIIOOXO);
    }

    public final void XO(Canvas canvas) {
        canvas.save();
        canvas.rotate((this.f21133oo + this.f21136x0o) - 180.0f, getWidth() / 2.0f, getHeight() / 2.0f);
        canvas.setDrawFilter(this.f21129XxX0x0xxx);
        canvas.drawBitmap(this.f21124XI0IXoo, ((this.f21126XO / 2.0f) - this.f21113IXxxXO) - (r0.getWidth() / 2.0f), (getHeight() / 2.0f) - (r0.getHeight() / 2.0f), this.f21121OxxIIOOXO);
        canvas.restore();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(event);
    }

    public int getValue() {
        return this.f21119OxI;
    }

    public final void oIX0oI(float angle) {
        float f = this.f21133oo + angle;
        this.f21133oo = f;
        if (f < 0.0f) {
            this.f21133oo = 0.0f;
        } else {
            int i = this.f21136x0o;
            if (f > 360 - ((i - 90) * 2)) {
                this.f21133oo = 360 - ((i - 90) * 2);
            }
        }
        this.f21119OxI = ((int) (((this.f21133oo / this.f21127XOxIOxOx) / this.f21116O0xOxO) + 0.5d)) + this.f21140xoXoI;
    }

    public final int oOoXoXO(float sp) {
        return (int) TypedValue.applyDimension(2, sp, getResources().getDisplayMetrics());
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        oxoX(canvas);
        X0o0xo(canvas);
        XO(canvas);
        Oxx0IOOO(canvas);
        II0XooXoX(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(xoIox(widthMeasureSpec), xoIox(heightMeasureSpec));
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int min = Math.min(h, w);
        this.f21118Oo = min;
        this.f21126XO = min;
        this.f21113IXxxXO = (min / 2) - (this.f21122X00IoxXI * 2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
    
        if (r2 != 3) goto L41;
     */
    @Override // android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            boolean r0 = r6.isClickable()
            r1 = 1
            if (r0 != 0) goto L8
            return r1
        L8:
            int r0 = r6.f21119OxI
            int r2 = r7.getAction()
            if (r2 == 0) goto L92
            r3 = 0
            if (r2 == r1) goto L5d
            r4 = 2
            if (r2 == r4) goto L1b
            r7 = 3
            if (r2 == r7) goto L5d
            goto La5
        L1b:
            r6.f21114Io = r1
            float r2 = r7.getX()
            float r7 = r7.getY()
            float r7 = r6.II0xO0(r2, r7)
            float r2 = r6.f21115IoOoX
            float r2 = r7 - r2
            int r4 = r6.getMaxRotateAngle()
            int r4 = -r4
            float r4 = (float) r4
            r5 = 1135869952(0x43b40000, float:360.0)
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 >= 0) goto L3b
            float r2 = r2 + r5
            goto L45
        L3b:
            int r4 = r6.getMaxRotateAngle()
            float r4 = (float) r4
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 <= 0) goto L45
            float r2 = r2 - r5
        L45:
            r6.oIX0oI(r2)
            r6.f21115IoOoX = r7
            com.sma.smartv3.otherdevice.jl.view.RotatingView$II0xO0 r7 = r6.f21139xXxxox0I
            if (r7 == 0) goto L59
            boolean r2 = r6.f21117OI0
            if (r2 == 0) goto L59
            int r2 = r6.f21119OxI
            if (r2 == r0) goto L59
            r7.oIX0oI(r6, r2, r3)
        L59:
            r6.invalidate()
            goto La5
        L5d:
            r6.setPressed(r3)
            boolean r7 = r6.f21117OI0
            if (r7 == 0) goto La5
            boolean r7 = r6.f21114Io
            if (r7 == 0) goto L86
            int r7 = r6.f21119OxI
            int r0 = r6.f21140xoXoI
            int r0 = r7 - r0
            int r2 = r6.f21116O0xOxO
            int r0 = r0 * r2
            float r0 = (float) r0
            float r2 = r6.f21127XOxIOxOx
            float r0 = r0 * r2
            r6.f21133oo = r0
            com.sma.smartv3.otherdevice.jl.view.RotatingView$II0xO0 r0 = r6.f21139xXxxox0I
            if (r0 == 0) goto L80
            r0.oIX0oI(r6, r7, r1)
        L80:
            r6.invalidate()
            r6.f21114Io = r3
            goto L8f
        L86:
            com.sma.smartv3.otherdevice.jl.view.RotatingView$oIX0oI r7 = r6.f21110IIX0o
            if (r7 == 0) goto L8f
            int r0 = r6.f21119OxI
            r7.onClick(r0)
        L8f:
            r6.f21117OI0 = r3
            goto La5
        L92:
            r6.f21117OI0 = r1
            float r0 = r7.getX()
            float r7 = r7.getY()
            float r7 = r6.II0xO0(r0, r7)
            r6.f21115IoOoX = r7
            r6.setPressed(r1)
        La5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.otherdevice.jl.view.RotatingView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void oxoX(Canvas canvas) {
        canvas.save();
        canvas.translate(getWidth() / 2.0f, getHeight() / 2.0f);
        canvas.rotate(this.f21136x0o);
        int i = this.f21113IXxxXO;
        RectF rectF = new RectF(-i, -i, i, i);
        canvas.drawArc(rectF, 0.0f, getMaxRotateAngle(), false, this.f21131oI0IIXIo);
        canvas.drawArc(rectF, 0.0f, this.f21133oo, false, this.f21111IIXOooo);
        canvas.restore();
    }

    public void setContentEndColor(int colorResId) {
        int color;
        if (Build.VERSION.SDK_INT >= 23) {
            color = getResources().getColor(colorResId, null);
            this.f21137xI = color;
        } else {
            this.f21137xI = getResources().getColor(colorResId);
        }
        int i = this.f21135ooXIXxIX;
        SweepGradient sweepGradient = new SweepGradient(0.0f, 0.0f, new int[]{i, i, this.f21137xI, i}, new float[]{0.0f, 0.05f, 0.8f, 0.99f});
        this.f21138xII = sweepGradient;
        this.f21111IIXOooo.setShader(sweepGradient);
    }

    public void setContentStartColor(int colorResId) {
        int color;
        if (Build.VERSION.SDK_INT >= 23) {
            color = getResources().getColor(colorResId, null);
            this.f21135ooXIXxIX = color;
        } else {
            this.f21135ooXIXxIX = getResources().getColor(colorResId);
        }
        int i = this.f21135ooXIXxIX;
        SweepGradient sweepGradient = new SweepGradient(0.0f, 0.0f, new int[]{i, i, this.f21137xI, i}, new float[]{0.0f, 0.05f, 0.8f, 0.99f});
        this.f21138xII = sweepGradient;
        this.f21111IIXOooo.setShader(sweepGradient);
    }

    public void setContentTextColor(int colorResId) {
        int color;
        if (Build.VERSION.SDK_INT >= 23) {
            color = getResources().getColor(colorResId, null);
            this.f21134oo0xXOI0I = color;
        } else {
            this.f21134oo0xXOI0I = getResources().getColor(colorResId);
        }
        this.f21120Oxx0xo.setColor(this.f21134oo0xXOI0I);
    }

    public void setIndicatorImage(int imageResId) {
        this.f21124XI0IXoo = BitmapFactory.decodeResource(getResources(), imageResId);
    }

    public void setOnClickListener(oIX0oI onClickListener) {
        this.f21110IIX0o = onClickListener;
    }

    public void setOnValueChangeListener(II0xO0 onValueChangeListener) {
        this.f21139xXxxox0I = onValueChangeListener;
    }

    public void setValue(int value) {
        OOXIXo(this.f21140xoXoI, this.f21130o00, value);
    }

    public final int xoIox(int widthMeasureSpec) {
        View.MeasureSpec.getMode(widthMeasureSpec);
        return View.MeasureSpec.getSize(widthMeasureSpec);
    }

    public final void xxIXOIIO(AttributeSet attrs) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.RotatingView);
        if (obtainStyledAttributes != null) {
            this.f21135ooXIXxIX = obtainStyledAttributes.getColor(3, this.f21135ooXIXxIX);
            this.f21137xI = obtainStyledAttributes.getColor(1, this.f21137xI);
            this.f21134oo0xXOI0I = obtainStyledAttributes.getColor(4, this.f21134oo0xXOI0I);
            this.f21132oOXoIIIo = obtainStyledAttributes.getDimensionPixelSize(2, this.f21132oOXoIIIo);
            this.f21128Xx000oIo = obtainStyledAttributes.getDimensionPixelSize(0, this.f21128Xx000oIo);
            this.f21122X00IoxXI = obtainStyledAttributes.getDimensionPixelSize(6, this.f21122X00IoxXI);
            this.f21112IO = obtainStyledAttributes.getDimensionPixelSize(7, this.f21112IO);
            int resourceId = obtainStyledAttributes.getResourceId(5, -1);
            if (resourceId != -1) {
                this.f21124XI0IXoo = BitmapFactory.decodeResource(getResources(), resourceId);
            }
        }
        Paint paint = new Paint();
        this.f21120Oxx0xo = paint;
        paint.setAntiAlias(true);
        this.f21120Oxx0xo.setTextSize(this.f21112IO);
        this.f21120Oxx0xo.setColor(this.f21134oo0xXOI0I);
        this.f21120Oxx0xo.setTextAlign(Paint.Align.CENTER);
        Paint paint2 = new Paint();
        this.f21131oI0IIXIo = paint2;
        paint2.setAntiAlias(true);
        this.f21131oI0IIXIo.setColor(Color.parseColor("#3CB7EA"));
        this.f21131oI0IIXIo.setStrokeWidth(this.f21128Xx000oIo);
        Paint paint3 = this.f21131oI0IIXIo;
        Paint.Style style = Paint.Style.STROKE;
        paint3.setStyle(style);
        Paint paint4 = this.f21131oI0IIXIo;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint4.setStrokeCap(cap);
        this.f21131oI0IIXIo.setColor(-1973791);
        this.f21121OxxIIOOXO = new Paint();
        this.f21129XxX0x0xxx = new PaintFlagsDrawFilter(0, 3);
        Paint paint5 = new Paint();
        this.f21111IIXOooo = paint5;
        paint5.setAntiAlias(true);
        this.f21111IIXOooo.setStrokeWidth(this.f21132oOXoIIIo);
        this.f21111IIXOooo.setStyle(style);
        this.f21111IIXOooo.setStrokeCap(cap);
        int i = this.f21135ooXIXxIX;
        SweepGradient sweepGradient = new SweepGradient(0.0f, 0.0f, new int[]{i, i, this.f21137xI, i}, new float[]{0.0f, 0.05f, 0.8f, 0.99f});
        this.f21138xII = sweepGradient;
        this.f21111IIXOooo.setShader(sweepGradient);
    }

    public RotatingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RotatingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f21140xoXoI = -12;
        this.f21130o00 = 12;
        this.f21119OxI = -12;
        this.f21116O0xOxO = 1;
        this.f21123X0IIOO = BitmapFactory.decodeResource(getResources(), com.sma.smartv3.co_fit.R.drawable.ic_rotatview_thumb);
        this.f21124XI0IXoo = BitmapFactory.decodeResource(getResources(), com.sma.smartv3.co_fit.R.drawable.ic_rotatview_indicator_sup);
        this.f21125XIxXXX0x0 = BitmapFactory.decodeResource(getResources(), com.sma.smartv3.co_fit.R.drawable.ic_rotatview_reduce);
        this.f21141xxX = BitmapFactory.decodeResource(getResources(), com.sma.smartv3.co_fit.R.drawable.ic_rotatview_plus);
        this.f21135ooXIXxIX = -8365077;
        this.f21137xI = 2136883691;
        this.f21134oo0xXOI0I = -11053225;
        this.f21132oOXoIIIo = I0Io(5.0f);
        this.f21128Xx000oIo = I0Io(3.0f);
        this.f21122X00IoxXI = I0Io(3.0f);
        this.f21112IO = oOoXoXO(16.0f);
        this.f21136x0o = 130;
        this.f21127XOxIOxOx = ((getMaxRotateAngle() * 1.0f) / (this.f21130o00 - this.f21140xoXoI)) / this.f21116O0xOxO;
        xxIXOIIO(attrs);
    }
}
