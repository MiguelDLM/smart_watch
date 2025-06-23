package com.kwad.sdk.core.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.ColorInt;
import java.lang.ref.WeakReference;

/* loaded from: classes11.dex */
public class ScaleAnimSeekBar extends View {
    private Rect aEA;
    private Drawable aEB;
    private boolean aEC;
    private boolean aED;
    private boolean aEE;
    private boolean aEF;
    private boolean aEG;
    private WeakReference<a> aEH;
    private boolean aEI;
    private boolean aEJ;
    private ValueAnimator aEK;
    private ValueAnimator aEL;
    private ValueAnimator aEM;
    private float aEN;
    private float aEO;
    private float aEP;
    private float aEQ;
    private int aER;
    private boolean aES;
    private Paint aEd;
    private int aEe;
    private int aEf;
    private int aEg;
    private int aEh;
    private int aEi;
    private int aEj;
    private int aEk;
    private int aEl;
    private boolean aEm;
    private int aEn;
    private int aEo;
    private int aEp;
    private int aEq;
    private int aEr;
    private int aEs;
    private int aEt;
    private GradientDrawable aEu;
    private GradientDrawable aEv;
    private GradientDrawable aEw;
    private Rect aEx;
    private Rect aEy;
    private Rect aEz;

    /* loaded from: classes11.dex */
    public interface a {
        void a(ScaleAnimSeekBar scaleAnimSeekBar);

        void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z);

        void tV();
    }

    public ScaleAnimSeekBar(Context context) {
        this(context, null);
    }

    private void bp(boolean z) {
        if (!this.aEI) {
            return;
        }
        if (z) {
            bq(true);
            br(true);
        } else {
            bq(false);
            br(false);
        }
    }

    private void bq(boolean z) {
        float f;
        float f2 = this.aEN;
        if (z) {
            f = this.aEO;
        } else {
            f = 1.0f;
        }
        ValueAnimator valueAnimator = this.aEK;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.aEK = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.aEK.setInterpolator(new LinearInterpolator());
            this.aEK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.aEN = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.aEK.setFloatValues(f2, f);
        this.aEK.start();
    }

    private void br(boolean z) {
        float f;
        float f2 = this.aEP;
        if (z) {
            f = this.aEQ;
        } else {
            f = 1.0f;
        }
        ValueAnimator valueAnimator = this.aEL;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.aEL = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.aEL.setInterpolator(new LinearInterpolator());
            this.aEL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.aEP = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.aEL.setFloatValues(f2, f);
        this.aEL.start();
    }

    private void bz(Context context) {
        this.aEI = true;
        this.aER = com.kwad.sdk.c.a.a.a(context, 10.0f);
        this.aEh = com.kwad.sdk.c.a.a.a(context, 3.0f);
        this.aEo = com.kwad.sdk.c.a.a.a(context, 20.0f);
        this.aEB = null;
        this.aEJ = false;
        this.aEl = com.kwad.sdk.c.a.a.a(context, 0.5f);
        this.aEk = com.kwad.sdk.c.a.a.a(context, 1.0f);
        this.aEe = 654311423;
        this.aEf = -1;
        this.aEg = 1090519039;
        this.aEi = 0;
        this.aEj = 100;
        this.aEm = false;
    }

    private boolean d(float f, float f2) {
        int i;
        int i2;
        Rect rect = this.aEA;
        int i3 = rect.left;
        int i4 = rect.right;
        if (i3 < i4 && (i = rect.top) < (i2 = rect.bottom)) {
            float f3 = this.aEN;
            int i5 = this.aEo;
            if (f >= (i3 * f3) - i5 && f <= (i4 * f3) + i5 && f2 >= (i * f3) - i5 && f2 <= (i2 * f3) + i5) {
                return true;
            }
            return false;
        }
        return false;
    }

    private float dv(int i) {
        int i2 = this.aEn;
        int i3 = this.aEi;
        return ((i2 * (i - i3)) / (this.aEj - i3)) - (i2 / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dw(int i) {
        int i2 = this.aEn;
        if (i > i2 / 2) {
            return this.aEj;
        }
        if (i < (-i2) / 2) {
            return this.aEi;
        }
        return Math.round(((i + (i2 / 2.0f)) * (this.aEj - this.aEi)) / i2) + this.aEi;
    }

    private boolean e(float f, float f2) {
        int i;
        int i2;
        Rect rect = this.aEx;
        int i3 = rect.left;
        int i4 = rect.right;
        if (i3 < i4 && (i = rect.top) < (i2 = rect.bottom)) {
            float f3 = this.aEP;
            int i5 = this.aEo;
            if (f >= (i3 * f3) - i5 && f <= (i4 * f3) + i5 && f2 >= (i * f3) - i5 && f2 <= (i2 * f3) + i5) {
                return true;
            }
            return false;
        }
        return false;
    }

    private a getOnSeekBarChangedListener() {
        WeakReference<a> weakReference = this.aEH;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void i(boolean z, int i) {
        if (z) {
            float j = j(dv(this.aEp));
            float j2 = j(dv(i));
            ValueAnimator valueAnimator = this.aEM;
            if (valueAnimator == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.aEM = valueAnimator2;
                valueAnimator2.setDuration(300L);
                this.aEM.setInterpolator(new Interpolator() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.1
                    @Override // android.animation.TimeInterpolator
                    public final float getInterpolation(float f) {
                        float f2 = f - 1.0f;
                        return (f2 * f2 * f2) + 1.0f;
                    }
                });
                this.aEM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        float floatValue = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                        ScaleAnimSeekBar scaleAnimSeekBar = ScaleAnimSeekBar.this;
                        scaleAnimSeekBar.aEp = scaleAnimSeekBar.dw((int) floatValue);
                        ScaleAnimSeekBar.this.i(floatValue);
                    }
                });
            } else {
                valueAnimator.cancel();
            }
            this.aEM.setFloatValues(j, j2);
            this.aEM.start();
            return;
        }
        this.aEp = i;
        i(j(dv(i)));
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            bz(context);
        }
        Paint paint = new Paint();
        this.aEd = paint;
        paint.setStyle(Paint.Style.FILL);
        this.aEd.setAntiAlias(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.aEu = gradientDrawable;
        gradientDrawable.setShape(0);
        this.aEu.setColor(this.aEe);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.aEv = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.aEv.setColor(this.aEf);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.aEw = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.aEw.setColor(this.aEg);
        this.aEx = new Rect();
        this.aEy = new Rect();
        this.aEA = new Rect();
        this.aEz = new Rect();
        this.aEp = this.aEi;
    }

    private float j(float f) {
        float f2 = this.aEn / 2;
        if (f > f2) {
            return f2;
        }
        float f3 = -f2;
        if (f < f3) {
            return f3;
        }
        return f;
    }

    private void x(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (i > 0 && i2 > 0) {
            if (this.aEI) {
                this.aEn = (int) (i - ((this.aER * 2) * (this.aEO - this.aEN)));
            } else {
                this.aEn = i - (this.aER * 2);
            }
            Rect rect = this.aEx;
            int i7 = this.aEl;
            int i8 = -i7;
            rect.top = i8;
            rect.bottom = -i8;
            boolean z = this.aEm;
            if (z) {
                i3 = -i;
            } else {
                i3 = -this.aEn;
            }
            rect.left = i3 / 2;
            if (z) {
                i4 = i / 2;
            } else {
                i4 = this.aEn / 2;
            }
            rect.right = i4;
            Rect rect2 = this.aEy;
            int i9 = -i7;
            rect2.top = i9;
            rect2.bottom = -i9;
            if (z) {
                i5 = -i;
            } else {
                i5 = -this.aEn;
            }
            rect2.left = i5 / 2;
            int i10 = this.aEn;
            rect2.right = (-i10) / 2;
            Rect rect3 = this.aEz;
            rect3.top = -i7;
            rect3.bottom = -rect2.top;
            if (z) {
                i6 = -i;
            } else {
                i6 = -i10;
            }
            rect3.left = i6 / 2;
            rect3.right = (-i10) / 2;
            Rect rect4 = this.aEA;
            int i11 = this.aEh;
            rect4.top = -i11;
            rect4.bottom = i11;
            rect4.left = ((-i10) / 2) - i11;
            rect4.right = ((-i10) / 2) + i11;
            setThumbDrawable(this.aEB);
            setProgress(this.aEp);
            setSecondaryProgress(this.aEr);
        }
    }

    public final void bo(boolean z) {
        this.aES = z;
        bp(z);
    }

    public int getMaxProgress() {
        return this.aEj;
    }

    public int getProgress() {
        return this.aEp;
    }

    public int getProgressLength() {
        return this.aEn;
    }

    public int getProgressX() {
        return (int) (getX() + (this.aEh * this.aEO));
    }

    public int getSecondaryProgress() {
        return this.aEr;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(this.aEt / 2, this.aEs / 2);
        a(canvas, this.aEx, this.aEu);
        a(canvas, this.aEz, this.aEw);
        a(canvas, this.aEy, this.aEv);
        if (this.aES) {
            c(canvas);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            this.aEt = size;
        } else {
            this.aEt = getWidth();
        }
        if (mode2 == 1073741824) {
            this.aEs = size2;
        } else {
            this.aEs = getHeight();
        }
        x(this.aEt, this.aEs);
        setMeasuredDimension(this.aEt, this.aEs);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX() - (this.aEt / 2);
        float y = motionEvent.getY() - (this.aEs / 2);
        ViewParent parent = getParent();
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && (this.aEC || this.aED)) {
                    a(dw((int) x), false, true);
                }
            } else {
                this.aEG = false;
                if (this.aED || this.aEC) {
                    this.aED = false;
                    this.aEC = false;
                    a(dw((int) x), this.aEJ, true);
                    if (onSeekBarChangedListener != null) {
                        onSeekBarChangedListener.a(this);
                    }
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }
        } else {
            if (!this.aEF) {
                return super.onTouchEvent(motionEvent);
            }
            if (d(x, y)) {
                bp(true);
                this.aEC = true;
                this.aEG = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.tV();
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if (e(x, y)) {
                bp(true);
                this.aED = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.tV();
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
        return true;
    }

    public void setMaxProgress(int i) {
        this.aEj = i;
    }

    public void setMinProgress(int i) {
        this.aEi = i;
        if (this.aEp < i) {
            this.aEp = i;
        }
    }

    public void setOnSeekBarChangeListener(a aVar) {
        this.aEH = new WeakReference<>(aVar);
    }

    public void setProgress(int i) {
        a(i, false, false);
    }

    public void setProgressBackgroundColor(@ColorInt int i) {
        this.aEe = i;
        this.aEu.setColor(i);
    }

    public void setProgressColor(@ColorInt int i) {
        this.aEf = i;
        this.aEv.setColor(i);
    }

    public void setSecondaryProgress(int i) {
        int i2 = this.aEi;
        if (i <= i2 || i >= (i2 = this.aEj)) {
            i = i2;
        }
        this.aEr = i;
        this.aEz.right = (int) j(dv(i));
        invalidate();
    }

    public void setSecondaryProgressColor(@ColorInt int i) {
        this.aEg = i;
        this.aEw.setColor(i);
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        this.aEB = drawable;
    }

    public void setThumbEnable(boolean z) {
        this.aEF = z;
    }

    public void setThumbScale(float f) {
        this.aEN = f;
    }

    public void setThumbTouchOffset(int i) {
        this.aEo = i;
        invalidate();
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Canvas canvas) {
        canvas.save();
        Drawable drawable = this.aEB;
        if (drawable != null) {
            drawable.setBounds(this.aEA);
            this.aEB.draw(canvas);
        } else {
            this.aEd.setColor(this.aEf);
            canvas.drawCircle(this.aEA.centerX(), this.aEA.centerY(), (this.aEA.width() * this.aEN) / 2.0f, this.aEd);
        }
        canvas.restore();
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEj = 100;
        this.aEm = false;
        this.aEB = null;
        this.aEC = false;
        this.aED = false;
        this.aEE = false;
        this.aEF = true;
        this.aEI = true;
        this.aEJ = false;
        this.aEN = 1.0f;
        this.aEO = 1.34f;
        this.aEP = 1.0f;
        this.aEQ = 2.0f;
        init(context, attributeSet);
    }

    private void a(Canvas canvas, Rect rect, GradientDrawable gradientDrawable) {
        canvas.save();
        Rect rect2 = new Rect();
        float f = rect.top;
        float f2 = this.aEP;
        rect2.top = (int) (f * f2);
        rect2.bottom = (int) (rect.bottom * f2);
        rect2.left = rect.left;
        rect2.right = rect.right;
        gradientDrawable.setBounds(rect2);
        gradientDrawable.setCornerRadius(this.aEk * this.aEP);
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    private void a(int i, boolean z, boolean z2) {
        int i2 = this.aEi;
        if (i <= i2 || i >= (i2 = this.aEj)) {
            i = i2;
        }
        i(z, i);
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        if (onSeekBarChangedListener != null && this.aEq != this.aEp) {
            this.aEE = z2;
            onSeekBarChangedListener.a(this, z2);
            this.aEE = false;
        }
        this.aEq = this.aEp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(float f) {
        Rect rect = this.aEA;
        int i = this.aEh;
        rect.left = (int) (f - i);
        rect.right = (int) (i + f);
        this.aEy.right = (int) f;
        invalidate();
    }
}
