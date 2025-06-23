package com.sma.smartv3.otherdevice.jl.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.sma.smartv3.R;
import com.sma.smartv3.otherdevice.jl.view.RulerView;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;

/* loaded from: classes12.dex */
public class RulerView extends View {

    /* renamed from: XI0oooXX, reason: collision with root package name */
    public static final String f21142XI0oooXX = "RulerView";

    /* renamed from: I0X0x0oIo, reason: collision with root package name */
    public RectF f21143I0X0x0oIo;

    /* renamed from: I0oOIX, reason: collision with root package name */
    public int f21144I0oOIX;

    /* renamed from: I0oOoX, reason: collision with root package name */
    public Paint f21145I0oOoX;

    /* renamed from: IIX0o, reason: collision with root package name */
    public int f21146IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public float f21147IIXOooo;

    /* renamed from: IO, reason: collision with root package name */
    public float f21148IO;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f21149IXxxXO;

    /* renamed from: Io, reason: collision with root package name */
    public Paint f21150Io;

    /* renamed from: IoOoX, reason: collision with root package name */
    public int f21151IoOoX;

    /* renamed from: IoOoo, reason: collision with root package name */
    public float f21152IoOoo;

    /* renamed from: Ioxxx, reason: collision with root package name */
    public int f21153Ioxxx;

    /* renamed from: O00XxXI, reason: collision with root package name */
    public int f21154O00XxXI;

    /* renamed from: O0Xx, reason: collision with root package name */
    public int f21155O0Xx;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public int f21156O0xOxO;

    /* renamed from: OI0, reason: collision with root package name */
    public String f21157OI0;

    /* renamed from: OO, reason: collision with root package name */
    public int f21158OO;

    /* renamed from: OO0x0xX, reason: collision with root package name */
    public float f21159OO0x0xX;

    /* renamed from: Oo, reason: collision with root package name */
    public int f21160Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public int f21161OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f21162Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f21163OxxIIOOXO;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public X0o0xo f21164X00IoxXI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public int f21165X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f21166XI0IXoo;

    /* renamed from: XIo0oOXIx, reason: collision with root package name */
    public boolean f21167XIo0oOXIx;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public int f21168XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public int f21169XO;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public final VelocityTracker f21170XOxIOxOx;

    /* renamed from: XX, reason: collision with root package name */
    public Paint f21171XX;

    /* renamed from: XX0, reason: collision with root package name */
    public Rect f21172XX0;

    /* renamed from: XX0xXo, reason: collision with root package name */
    public int f21173XX0xXo;

    /* renamed from: Xo0, reason: collision with root package name */
    public int f21174Xo0;

    /* renamed from: XoI0Ixx0, reason: collision with root package name */
    public int f21175XoI0Ixx0;

    /* renamed from: XoX, reason: collision with root package name */
    public Paint f21176XoX;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public boolean f21177Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public String f21178XxX0x0xxx;

    /* renamed from: o0, reason: collision with root package name */
    public Paint f21179o0;

    /* renamed from: o00, reason: collision with root package name */
    public float f21180o00;

    /* renamed from: o0xxxXXxX, reason: collision with root package name */
    public int f21181o0xxxXXxX;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f21182oI0IIXIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public boolean f21183oOXoIIIo;

    /* renamed from: oX, reason: collision with root package name */
    public int f21184oX;

    /* renamed from: oo, reason: collision with root package name */
    public int f21185oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f21186oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public int f21187ooXIXxIX;

    /* renamed from: ox, reason: collision with root package name */
    public boolean f21188ox;

    /* renamed from: oxXx0IX, reason: collision with root package name */
    public Paint f21189oxXx0IX;

    /* renamed from: oxxXoxO, reason: collision with root package name */
    public Paint f21190oxxXoxO;

    /* renamed from: x0o, reason: collision with root package name */
    public ValueAnimator f21191x0o;

    /* renamed from: x0xO, reason: collision with root package name */
    public float f21192x0xO;

    /* renamed from: xI, reason: collision with root package name */
    public int f21193xI;

    /* renamed from: xII, reason: collision with root package name */
    public float f21194xII;

    /* renamed from: xXOx, reason: collision with root package name */
    public Rect f21195xXOx;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public int f21196xXxxox0I;

    /* renamed from: xo0x, reason: collision with root package name */
    public Rect f21197xo0x;

    /* renamed from: xoIxX, reason: collision with root package name */
    public float f21198xoIxX;

    /* renamed from: xoXoI, reason: collision with root package name */
    public float f21199xoXoI;

    /* renamed from: xoxXI, reason: collision with root package name */
    public int f21200xoxXI;

    /* renamed from: xxIO, reason: collision with root package name */
    public int f21201xxIO;

    /* renamed from: xxX, reason: collision with root package name */
    public int f21202xxX;

    /* loaded from: classes12.dex */
    public class I0Io extends AnimatorListenerAdapter {
        public I0Io() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            RulerView rulerView = RulerView.this;
            if (rulerView.f21194xII == rulerView.f21148IO) {
                if (RulerView.this.f21164X00IoxXI != null) {
                    RulerView.this.f21164X00IoxXI.oIX0oI(RulerView.this.f21157OI0);
                }
            } else {
                RulerView rulerView2 = RulerView.this;
                rulerView2.f21198xoIxX = rulerView2.OxxIIOOXO(rulerView2.f21148IO);
                RulerView rulerView3 = RulerView.this;
                rulerView3.f21159OO0x0xX = rulerView3.f21198xoIxX;
                RulerView.this.f21188ox = true;
            }
            RulerView.this.f21148IO = -1.0f;
        }
    }

    /* loaded from: classes12.dex */
    public class II0xO0 extends AnimatorListenerAdapter {
        public II0xO0() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            RulerView.this.f21167XIo0oOXIx = true;
            RulerView.this.invalidate();
        }
    }

    /* loaded from: classes12.dex */
    public interface X0o0xo {
        void II0xO0(String result);

        void oIX0oI(String result);
    }

    /* loaded from: classes12.dex */
    public class oIX0oI implements ValueAnimator.AnimatorUpdateListener {
        public oIX0oI() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            RulerView.X0o0xo(RulerView.this, ((Integer) animation.getAnimatedValue()).intValue());
            if (RulerView.this.f21198xoIxX < RulerView.this.f21174Xo0 / 2) {
                float f = RulerView.this.f21198xoIxX;
                RulerView rulerView = RulerView.this;
                if (f <= rulerView.OxxIIOOXO(rulerView.f21199xoXoI)) {
                    RulerView rulerView2 = RulerView.this;
                    rulerView2.f21198xoIxX = rulerView2.OxxIIOOXO(rulerView2.f21199xoXoI);
                }
            } else {
                RulerView.this.f21198xoIxX = r3.f21174Xo0 / 2;
            }
            RulerView rulerView3 = RulerView.this;
            rulerView3.f21159OO0x0xX = rulerView3.f21198xoIxX;
            RulerView.this.invalidate();
        }
    }

    /* loaded from: classes12.dex */
    public class oxoX extends AnimatorListenerAdapter {
        public oxoX() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            if (RulerView.this.f21164X00IoxXI != null) {
                RulerView.this.f21164X00IoxXI.oIX0oI(RulerView.this.f21157OI0);
            }
        }
    }

    public RulerView(Context context) {
        this(context, null);
    }

    public static /* synthetic */ float X0o0xo(RulerView rulerView, float f) {
        float f2 = rulerView.f21198xoIxX + f;
        rulerView.f21198xoIxX = f2;
        return f2;
    }

    public final void IIXOooo() {
        this.f21150Io = new Paint(1);
        this.f21179o0 = new Paint(1);
        this.f21171XX = new Paint(1);
        this.f21145I0oOoX = new Paint(1);
        this.f21190oxxXoxO = new Paint(1);
        this.f21176XoX = new Paint(1);
        this.f21189oxXx0IX = new Paint(1);
        this.f21150Io.setColor(this.f21161OxI);
        this.f21179o0.setColor(this.f21156O0xOxO);
        this.f21171XX.setColor(this.f21165X0IIOO);
        this.f21145I0oOoX.setColor(this.f21166XI0IXoo);
        this.f21190oxxXoxO.setColor(this.f21168XIxXXX0x0);
        this.f21176XoX.setColor(this.f21202xxX);
        this.f21189oxXx0IX.setColor(this.f21196xXxxox0I);
        Paint paint = this.f21176XoX;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.f21189oxXx0IX.setStyle(style);
        this.f21150Io.setStyle(style);
        this.f21179o0.setStyle(style);
        this.f21171XX.setStyle(style);
        this.f21145I0oOoX.setStyle(style);
        Paint paint2 = this.f21145I0oOoX;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint2.setStrokeCap(cap);
        this.f21171XX.setStrokeCap(cap);
        this.f21179o0.setStrokeCap(cap);
        this.f21179o0.setStrokeWidth(this.f21146IIX0o);
        this.f21171XX.setStrokeWidth(this.f21187ooXIXxIX);
        this.f21145I0oOoX.setStrokeWidth(this.f21193xI);
        this.f21176XoX.setTextSize(this.f21186oo0xXOI0I);
        this.f21189oxXx0IX.setTextSize(this.f21151IoOoX);
        this.f21190oxxXoxO.setTextSize(this.f21185oo);
        this.f21143I0X0x0oIo = new RectF();
        this.f21195xXOx = new Rect();
        this.f21197xo0x = new Rect();
        this.f21172XX0 = new Rect();
        Paint paint3 = this.f21176XoX;
        String str = this.f21157OI0;
        paint3.getTextBounds(str, 0, str.length(), this.f21195xXOx);
        this.f21189oxXx0IX.getTextBounds(this.f21157OI0, 0, 1, this.f21172XX0);
        int i = this.f21160Oo;
        this.f21175XoI0Ixx0 = i / 4;
        this.f21155O0Xx = i / 2;
        this.f21144I0oOIX = i;
        this.f21181o0xxxXXxX = i / 2;
        this.f21191x0o = new ValueAnimator();
    }

    public final void IXxxXO(Canvas canvas) {
        this.f21143I0X0x0oIo.set(0.0f, 0.0f, this.f21174Xo0, this.f21184oX);
        if (this.f21177Xx000oIo) {
            canvas.drawRoundRect(this.f21143I0X0x0oIo, 20.0f, 20.0f, this.f21150Io);
        } else {
            canvas.drawRect(this.f21143I0X0x0oIo, this.f21150Io);
        }
    }

    public void O0xOxO(int minScale, float maxScale, float firstScale) {
        int i = this.f21169XO;
        this.f21163OxxIIOOXO = minScale / i;
        this.f21199xoXoI = maxScale / i;
        this.f21147IIXOooo = firstScale / i;
        this.f21180o00 = maxScale;
        invalidate();
    }

    public void Oo(float scale) {
        float f = scale / this.f21169XO;
        if (f >= this.f21163OxxIIOOXO && f <= this.f21199xoXoI) {
            this.f21148IO = f;
            invalidate();
        }
    }

    public final void OxI(AttributeSet attrs, int defStyleAttr) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.RulerView, defStyleAttr, 0);
        this.f21169XO = obtainStyledAttributes.getInt(16, this.f21169XO);
        this.f21160Oo = obtainStyledAttributes.getDimensionPixelSize(11, (int) TypedValue.applyDimension(1, this.f21160Oo, getResources().getDisplayMetrics()));
        this.f21149IXxxXO = obtainStyledAttributes.getDimensionPixelSize(13, (int) TypedValue.applyDimension(1, this.f21149IXxxXO, getResources().getDisplayMetrics()));
        this.f21162Oxx0xo = obtainStyledAttributes.getInt(14, this.f21162Oxx0xo);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(15, (int) TypedValue.applyDimension(1, this.f21182oI0IIXIo, getResources().getDisplayMetrics()));
        this.f21182oI0IIXIo = dimensionPixelSize;
        this.f21182oI0IIXIo = SizeUtils.dp2px(dimensionPixelSize);
        this.f21163OxxIIOOXO = obtainStyledAttributes.getInt(7, this.f21163OxxIIOOXO) / this.f21169XO;
        this.f21147IIXOooo = obtainStyledAttributes.getFloat(0, this.f21147IIXOooo) / this.f21169XO;
        this.f21199xoXoI = obtainStyledAttributes.getFloat(4, this.f21199xoXoI) / this.f21169XO;
        this.f21161OxI = obtainStyledAttributes.getColor(10, this.f21161OxI);
        this.f21156O0xOxO = obtainStyledAttributes.getColor(12, this.f21156O0xOxO);
        this.f21165X0IIOO = obtainStyledAttributes.getColor(5, this.f21165X0IIOO);
        this.f21166XI0IXoo = obtainStyledAttributes.getColor(2, this.f21166XI0IXoo);
        this.f21168XIxXXX0x0 = obtainStyledAttributes.getColor(17, this.f21168XIxXXX0x0);
        this.f21202xxX = obtainStyledAttributes.getColor(8, this.f21202xxX);
        this.f21196xXxxox0I = obtainStyledAttributes.getColor(22, this.f21196xXxxox0I);
        String str = this.f21178XxX0x0xxx;
        String string = obtainStyledAttributes.getString(21);
        this.f21178XxX0x0xxx = string;
        if (TextUtils.isEmpty(string)) {
            this.f21178XxX0x0xxx = str;
        }
        this.f21146IIX0o = obtainStyledAttributes.getDimensionPixelSize(20, (int) TypedValue.applyDimension(1, this.f21146IIX0o, getResources().getDisplayMetrics()));
        this.f21187ooXIXxIX = obtainStyledAttributes.getDimensionPixelSize(6, (int) TypedValue.applyDimension(1, this.f21187ooXIXxIX, getResources().getDisplayMetrics()));
        this.f21193xI = obtainStyledAttributes.getDimensionPixelSize(3, (int) TypedValue.applyDimension(1, this.f21193xI, getResources().getDisplayMetrics()));
        this.f21186oo0xXOI0I = obtainStyledAttributes.getDimensionPixelSize(9, (int) TypedValue.applyDimension(2, this.f21186oo0xXOI0I, getResources().getDisplayMetrics()));
        this.f21185oo = obtainStyledAttributes.getDimensionPixelSize(18, (int) TypedValue.applyDimension(2, this.f21185oo, getResources().getDisplayMetrics()));
        this.f21151IoOoX = obtainStyledAttributes.getDimensionPixelSize(23, (int) TypedValue.applyDimension(2, this.f21151IoOoX, getResources().getDisplayMetrics()));
        this.f21183oOXoIIIo = obtainStyledAttributes.getBoolean(19, this.f21183oOXoIIIo);
        this.f21177Xx000oIo = obtainStyledAttributes.getBoolean(1, this.f21177Xx000oIo);
        obtainStyledAttributes.recycle();
    }

    public final void Oxx0xo(Canvas canvas, String resultText) {
        if (!this.f21183oOXoIIIo) {
            return;
        }
        canvas.translate(0.0f, (-this.f21195xXOx.height()) - (this.f21149IXxxXO / 2));
        this.f21176XoX.getTextBounds(resultText, 0, resultText.length(), this.f21195xXOx);
        canvas.drawText(resultText, (this.f21174Xo0 / 2) - (this.f21195xXOx.width() / 2), this.f21195xXOx.height(), this.f21176XoX);
        int width = (this.f21174Xo0 / 2) + (this.f21195xXOx.width() / 2) + 10;
        this.f21158OO = width;
        canvas.drawText(this.f21178XxX0x0xxx, width, this.f21172XX0.height() + 2, this.f21189oxXx0IX);
    }

    public final float OxxIIOOXO(float scale) {
        return (this.f21174Xo0 / 2) - ((this.f21182oI0IIXIo * this.f21162Oxx0xo) * (scale - this.f21163OxxIIOOXO));
    }

    public float getMaxScale() {
        return this.f21199xoXoI * this.f21169XO;
    }

    public float getMaxScaleValue() {
        return this.f21180o00;
    }

    public int getMinScale() {
        return this.f21163OxxIIOOXO * this.f21169XO;
    }

    public final /* synthetic */ void o00(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f21198xoIxX = floatValue;
        this.f21159OO0x0xX = floatValue;
        invalidate();
    }

    public final void oI0IIXIo(Canvas canvas) {
        int i;
        int round;
        float f;
        float f2;
        if (this.f21183oOXoIIIo) {
            i = this.f21195xXOx.height();
        } else {
            i = 0;
        }
        float f3 = 0.0f;
        canvas.translate(0.0f, i + this.f21149IXxxXO);
        float f4 = this.f21147IIXOooo;
        if (f4 != -1.0f) {
            float OxxIIOOXO2 = OxxIIOOXO(f4);
            this.f21198xoIxX = OxxIIOOXO2;
            this.f21159OO0x0xX = OxxIIOOXO2;
            this.f21147IIXOooo = -1.0f;
        }
        if (this.f21148IO != -1.0f) {
            Log.d(f21142XI0oooXX, "moveX 000 >> " + this.f21198xoIxX + ", computeScale >> " + this.f21148IO);
            this.f21159OO0x0xX = this.f21198xoIxX;
            ValueAnimator valueAnimator = this.f21191x0o;
            if (valueAnimator != null && !valueAnimator.isRunning()) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f21159OO0x0xX, OxxIIOOXO(this.f21148IO));
                this.f21191x0o = ofFloat;
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: OxXXx0X.oIX0oI
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        RulerView.this.xoXoI(valueAnimator2);
                    }
                });
                this.f21191x0o.addListener(new I0Io());
                this.f21191x0o.setDuration(Math.abs(OxxIIOOXO(this.f21148IO) - this.f21159OO0x0xX));
                this.f21191x0o.start();
            }
        }
        float f5 = this.f21198xoIxX;
        int i2 = this.f21182oI0IIXIo;
        int i3 = -((int) (f5 / i2));
        float f6 = f5 % i2;
        canvas.save();
        this.f21200xoxXI = 0;
        if (this.f21167XIo0oOXIx) {
            float f7 = this.f21198xoIxX;
            int i4 = this.f21174Xo0 / 2;
            int i5 = this.f21182oI0IIXIo;
            float f8 = (f7 - (i4 % i5)) % i5;
            if (f8 <= 0.0f) {
                f8 = i5 - Math.abs(f8);
            }
            this.f21153Ioxxx = (int) Math.abs(f8);
            int abs = (int) (this.f21182oI0IIXIo - Math.abs(f8));
            this.f21201xxIO = abs;
            if (f8 <= this.f21182oI0IIXIo / 2) {
                f2 = this.f21198xoIxX - this.f21153Ioxxx;
            } else {
                f2 = this.f21198xoIxX + abs;
            }
            ValueAnimator valueAnimator2 = this.f21191x0o;
            if (valueAnimator2 != null && !valueAnimator2.isRunning()) {
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(this.f21198xoIxX, f2);
                this.f21191x0o = ofFloat2;
                ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: OxXXx0X.II0xO0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        RulerView.this.o00(valueAnimator3);
                    }
                });
                this.f21191x0o.addListener(new oxoX());
                this.f21191x0o.setDuration(300L);
                this.f21191x0o.start();
                this.f21167XIo0oOXIx = false;
            }
            float f9 = this.f21198xoIxX;
            int i6 = this.f21182oI0IIXIo;
            i3 = (int) (-(f9 / i6));
            f6 = f9 % i6;
        }
        canvas.translate(f6, 0.0f);
        float floatValue = ((BigDecimal) new WeakReference(new BigDecimal(((((this.f21174Xo0 / 2) - this.f21198xoIxX) / (this.f21182oI0IIXIo * this.f21162Oxx0xo)) + this.f21163OxxIIOOXO) * this.f21169XO)).get()).setScale(1, 4).floatValue();
        this.f21194xII = floatValue;
        String valueOf = String.valueOf(floatValue);
        this.f21157OI0 = valueOf;
        X0o0xo x0o0xo = this.f21164X00IoxXI;
        if (x0o0xo != null) {
            x0o0xo.II0xO0(valueOf);
        }
        if (this.f21188ox) {
            this.f21188ox = false;
            X0o0xo x0o0xo2 = this.f21164X00IoxXI;
            if (x0o0xo2 != null) {
                x0o0xo2.oIX0oI(this.f21157OI0);
            }
        }
        float f10 = this.f21174Xo0;
        if (this.f21199xoXoI > Math.round(r2)) {
            round = Math.round(this.f21199xoXoI) + 1;
        } else {
            round = Math.round(this.f21199xoXoI);
        }
        int i7 = round;
        float f11 = f10;
        int i8 = i3;
        float f12 = 0.0f;
        while (true) {
            int i9 = this.f21200xoxXI;
            if (i9 < this.f21174Xo0) {
                if (i8 % this.f21162Oxx0xo == 0) {
                    float f13 = this.f21198xoIxX;
                    if ((f13 < f3 || i9 >= f13 - this.f21182oI0IIXIo) && (r2 / 2) - i9 > OxxIIOOXO(i7 + 1) - this.f21198xoIxX) {
                        int i10 = this.f21169XO;
                        float f14 = ((i8 / this.f21162Oxx0xo) + this.f21163OxxIIOOXO) * i10;
                        if (f14 <= this.f21199xoXoI * i10) {
                            f = f14;
                            canvas.drawLine(0.0f, this.f21181o0xxxXXxX, 0.0f, r1 + this.f21155O0Xx, this.f21171XX);
                            this.f21190oxxXoxO.getTextBounds(((i8 / this.f21182oI0IIXIo) + this.f21163OxxIIOOXO) + "", 0, (((i8 / this.f21182oI0IIXIo) + this.f21163OxxIIOOXO) + "").length(), this.f21197xo0x);
                            float f15 = (-this.f21197xo0x.width()) / 2;
                            int i11 = this.f21144I0oOIX;
                            canvas.drawText(((int) f) + "", f15, i11 + ((this.f21160Oo - i11) / 2) + this.f21197xo0x.height() + SizeUtils.dp2px(10.0f), this.f21190oxxXoxO);
                        } else {
                            f = f14;
                        }
                        int i12 = this.f21163OxxIIOOXO;
                        int i13 = this.f21169XO;
                        if (f == i12 * i13) {
                            f12 = (this.f21174Xo0 >> 1) - ((((this.f21194xII - f) * this.f21182oI0IIXIo) / i13) * this.f21162Oxx0xo);
                        } else if (f == i7 * i13) {
                            f11 = ((((f - this.f21194xII) * this.f21182oI0IIXIo) / i13) * this.f21162Oxx0xo) + (this.f21174Xo0 / 2);
                        }
                    }
                } else {
                    float f16 = this.f21198xoIxX;
                    if ((f16 < 0.0f || i9 >= f16) && (r2 / 2) - i9 >= OxxIIOOXO(i7) - this.f21198xoIxX) {
                        float f17 = (i8 / this.f21162Oxx0xo) + this.f21163OxxIIOOXO;
                        int i14 = this.f21169XO;
                        if (f17 * i14 <= this.f21199xoXoI * i14) {
                            canvas.drawLine(0.0f, this.f21181o0xxxXXxX, 0.0f, r1 + this.f21175XoI0Ixx0, this.f21179o0);
                        }
                    }
                }
                i8++;
                int i15 = this.f21200xoxXI;
                int i16 = this.f21182oI0IIXIo;
                this.f21200xoxXI = i15 + i16;
                canvas.translate(i16, 0.0f);
                f3 = 0.0f;
            } else {
                canvas.restore();
                int i17 = this.f21174Xo0;
                canvas.drawLine(i17 / 2, 0.0f, i17 / 2, this.f21160Oo, this.f21145I0oOoX);
                int i18 = this.f21181o0xxxXXxX;
                canvas.drawLine(f12, i18, f11, i18, this.f21179o0);
                return;
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        IXxxXO(canvas);
        oI0IIXIo(canvas);
        Oxx0xo(canvas, this.f21157OI0);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(widthMeasureSpec);
        if (mode != Integer.MIN_VALUE && mode != 0) {
            if (mode == 1073741824) {
                this.f21184oX = size + getPaddingTop() + getPaddingBottom();
            }
        } else {
            int i2 = this.f21160Oo;
            if (this.f21183oOXoIIIo) {
                i = this.f21195xXOx.height();
            } else {
                i = 0;
            }
            this.f21184oX = i2 + i + (this.f21149IXxxXO * 2) + getPaddingTop() + getPaddingBottom() + SizeUtils.dp2px(20.0f);
        }
        int paddingLeft = size2 + getPaddingLeft() + getPaddingRight();
        this.f21174Xo0 = paddingLeft;
        setMeasuredDimension(paddingLeft, this.f21184oX);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        this.f21192x0xO = event.getX();
        this.f21167XIo0oOXIx = false;
        this.f21170XOxIOxOx.computeCurrentVelocity(500);
        this.f21170XOxIOxOx.addMovement(event);
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float f = (this.f21192x0xO - this.f21152IoOoo) + this.f21159OO0x0xX;
                    this.f21198xoIxX = f;
                    int i = this.f21174Xo0;
                    if (f >= i / 2) {
                        this.f21198xoIxX = i / 2;
                    } else if (f <= OxxIIOOXO(this.f21199xoXoI)) {
                        this.f21198xoIxX = OxxIIOOXO(this.f21199xoXoI);
                        LogUtils.d(f21142XI0oooXX, "moveX = " + this.f21198xoIxX + ", max = " + OxxIIOOXO(this.f21199xoXoI));
                    }
                }
            } else {
                this.f21159OO0x0xX = this.f21198xoIxX;
                int xVelocity = (int) this.f21170XOxIOxOx.getXVelocity();
                this.f21173XX0xXo = xVelocity;
                x0xO0oo(xVelocity);
                this.f21170XOxIOxOx.clear();
            }
        } else {
            ValueAnimator valueAnimator = this.f21191x0o;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f21191x0o.end();
                this.f21191x0o.cancel();
            }
            this.f21152IoOoo = event.getX();
        }
        invalidate();
        return true;
    }

    public void setBgColor(int bgColor) {
        this.f21161OxI = bgColor;
        invalidate();
    }

    public void setFirstScale(float firstScale) {
        this.f21147IIXOooo = firstScale / this.f21169XO;
        invalidate();
    }

    public void setIsBgRoundRect(boolean bgRoundRect) {
        this.f21177Xx000oIo = bgRoundRect;
        invalidate();
    }

    public void setLargeScaleColor(int largeScaleColor) {
        this.f21166XI0IXoo = largeScaleColor;
    }

    public void setLargeScaleStroke(int largeScaleStroke) {
        this.f21193xI = largeScaleStroke;
        invalidate();
    }

    public void setMaxScale(float maxScale) {
        this.f21199xoXoI = maxScale / this.f21169XO;
        this.f21180o00 = maxScale;
        invalidate();
    }

    public void setMaxScaleValue(float maxScaleValue) {
        this.f21180o00 = maxScaleValue;
    }

    public void setMidScaleColor(int midScaleColor) {
        this.f21165X0IIOO = midScaleColor;
        invalidate();
    }

    public void setMidScaleStroke(int midScaleStroke) {
        this.f21187ooXIXxIX = midScaleStroke;
        invalidate();
    }

    public void setMinScale(int minScale) {
        this.f21163OxxIIOOXO = minScale / this.f21169XO;
        invalidate();
    }

    public void setOnChooseResulterListener(X0o0xo onChooseResulterListener) {
        this.f21164X00IoxXI = onChooseResulterListener;
    }

    public void setResultNumColor(int resultNumColor) {
        this.f21202xxX = resultNumColor;
        invalidate();
    }

    public void setResultNumTextSize(int resultNumTextSize) {
        this.f21186oo0xXOI0I = resultNumTextSize;
        invalidate();
    }

    public void setRulerHeight(int rulerHeight) {
        this.f21160Oo = rulerHeight;
        invalidate();
    }

    public void setRulerToResultgap(int rulerToResultgap) {
        this.f21149IXxxXO = rulerToResultgap;
        invalidate();
    }

    public void setScaleCount(int scaleCount) {
        this.f21162Oxx0xo = scaleCount;
        invalidate();
    }

    public void setScaleGap(int scaleGap) {
        this.f21182oI0IIXIo = scaleGap;
        invalidate();
    }

    public void setScaleLimit(int scaleLimit) {
        this.f21169XO = scaleLimit;
        invalidate();
    }

    public void setScaleNumColor(int scaleNumColor) {
        this.f21168XIxXXX0x0 = scaleNumColor;
        invalidate();
    }

    public void setScaleNumTextSize(int scaleNumTextSize) {
        this.f21185oo = scaleNumTextSize;
        invalidate();
    }

    public void setShowScaleResult(boolean showScaleResult) {
        this.f21183oOXoIIIo = showScaleResult;
        invalidate();
    }

    public void setSmallScaleColor(int smallScaleColor) {
        this.f21156O0xOxO = smallScaleColor;
        invalidate();
    }

    public void setSmallScaleStroke(int smallScaleStroke) {
        this.f21146IIX0o = smallScaleStroke;
        invalidate();
    }

    public void setUnit(String unit) {
        this.f21178XxX0x0xxx = unit;
        invalidate();
    }

    public void setUnitColor(int unitColor) {
        this.f21196xXxxox0I = unitColor;
        invalidate();
    }

    public void setUnitTextSize(int unitTextSize) {
        this.f21151IoOoX = unitTextSize;
        invalidate();
    }

    public final void x0xO0oo(int xVelocity) {
        if (Math.abs(xVelocity) < 50) {
            this.f21167XIo0oOXIx = true;
            return;
        }
        if (this.f21191x0o.isRunning()) {
            return;
        }
        ValueAnimator duration = ValueAnimator.ofInt(0, xVelocity / 20).setDuration(Math.abs(xVelocity / 10));
        this.f21191x0o = duration;
        duration.setInterpolator(new DecelerateInterpolator());
        this.f21191x0o.addUpdateListener(new oIX0oI());
        this.f21191x0o.addListener(new II0xO0());
        this.f21191x0o.start();
    }

    public final /* synthetic */ void xoXoI(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f21198xoIxX = floatValue;
        this.f21159OO0x0xX = floatValue;
        invalidate();
    }

    public RulerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RulerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f21169XO = 1;
        this.f21160Oo = 50;
        this.f21149IXxxXO = 50 / 4;
        this.f21162Oxx0xo = 10;
        this.f21182oI0IIXIo = 20;
        this.f21163OxxIIOOXO = 0;
        this.f21147IIXOooo = 50.0f;
        this.f21199xoXoI = 100.0f;
        this.f21180o00 = 100.0f;
        this.f21161OxI = -196612;
        this.f21156O0xOxO = -6710887;
        this.f21165X0IIOO = -10066330;
        this.f21166XI0IXoo = -11487866;
        this.f21168XIxXXX0x0 = -13421773;
        this.f21202xxX = -11487866;
        this.f21178XxX0x0xxx = "kg";
        this.f21196xXxxox0I = -11487866;
        this.f21146IIX0o = 1;
        this.f21187ooXIXxIX = 2;
        this.f21193xI = 3;
        this.f21186oo0xXOI0I = 20;
        this.f21185oo = 16;
        this.f21151IoOoX = 13;
        this.f21183oOXoIIIo = true;
        this.f21177Xx000oIo = true;
        this.f21148IO = -1.0f;
        this.f21194xII = 50.0f;
        this.f21170XOxIOxOx = VelocityTracker.obtain();
        this.f21157OI0 = String.valueOf(this.f21147IIXOooo);
        this.f21200xoxXI = 0;
        this.f21198xoIxX = 0.0f;
        this.f21159OO0x0xX = 0.0f;
        this.f21167XIo0oOXIx = false;
        OxI(attrs, defStyleAttr);
        IIXOooo();
    }
}
