package com.sma.smartv3.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.sma.smartv3.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class SportEndProgress extends View {

    /* renamed from: IIX0o, reason: collision with root package name */
    public long f25249IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25250IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public float f25251IXxxXO;

    /* renamed from: IoOoX, reason: collision with root package name */
    public boolean f25252IoOoX;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public float f25253O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public float f25254Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public final float f25255OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public float f25256Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25257OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public int f25258X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f25259XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public int f25260XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public int f25261XO;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    @OXOo.OOXIXo
    public ValueAnimator f25262XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public final float f25263o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25264oI0IIXIo;

    /* renamed from: oo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public oIX0oI f25265oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    @OXOo.oOoXoXO
    public II0xO0 f25266oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public final float f25267ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public float f25268xI;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public float f25269xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f25270xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public boolean f25271xxX;

    /* loaded from: classes12.dex */
    public interface II0xO0 {
        void start(boolean z);
    }

    /* loaded from: classes12.dex */
    public interface oIX0oI {
        void end();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public SportEndProgress(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public static final void X0o0xo(SportEndProgress this$0, ValueAnimator animation) {
        oIX0oI oix0oi;
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        IIX0o.x0XOIxOo(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.f25269xXxxox0I = floatValue;
        this$0.f25268xI = floatValue * this$0.f25267ooXIXxIX;
        this$0.invalidate();
        if (this$0.f25268xI == this$0.f25267ooXIXxIX && this$0.f25252IoOoX && (oix0oi = this$0.f25265oo) != null) {
            oix0oi.end();
        }
    }

    private final void setProgress(float f) {
        float f2 = this.f25267ooXIXxIX;
        if (f > f2) {
            f = f2;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f25269xXxxox0I, f / f2);
        IIX0o.oO(ofFloat, "ofFloat(...)");
        this.f25262XxX0x0xxx = ofFloat;
        ofFloat.setDuration(this.f25249IIX0o);
        this.f25262XxX0x0xxx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sma.smartv3.view.IXxxXO
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SportEndProgress.X0o0xo(SportEndProgress.this, valueAnimator);
            }
        });
        this.f25262XxX0x0xxx.start();
    }

    public final void I0Io(@OXOo.OOXIXo oIX0oI callback) {
        IIX0o.x0xO0oo(callback, "callback");
        this.f25265oo = callback;
    }

    public final float II0xO0(int i) {
        return SizeUtils.dp2px(i);
    }

    public final void XO(@OXOo.OOXIXo II0xO0 callback) {
        IIX0o.x0xO0oo(callback, "callback");
        this.f25266oo0xXOI0I = callback;
    }

    @Override // android.view.View
    public void onDraw(@OXOo.OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        float f = this.f25254Oo;
        canvas.drawCircle(f, f, this.f25251IXxxXO, this.f25257OxxIIOOXO);
        float f2 = this.f25254Oo;
        float f3 = this.f25256Oxx0xo;
        float f4 = f2 - f3;
        float f5 = f2 - f3;
        float f6 = this.f25251IXxxXO;
        canvas.drawRect(f4, f5, f6 + f3, f6 + f3, this.f25264oI0IIXIo);
        float f7 = (this.f25268xI / this.f25267ooXIXxIX) * 360.0f;
        this.f25253O0xOxO = f7;
        canvas.drawArc(this.f25270xoXoI, 270.0f, f7, false, this.f25250IIXOooo);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int min = Math.min(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        this.f25261XO = min;
        setMeasuredDimension(min, min);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = this.f25261XO;
        float f = i5 / 2.0f;
        this.f25254Oo = f;
        this.f25251IXxxXO = f;
        this.f25256Oxx0xo = (i5 / 3.0f) / 2.0f;
        RectF rectF = this.f25270xoXoI;
        float f2 = this.f25255OxI;
        rectF.set(f2, f2, getWidth() - this.f25255OxI, getWidth() - this.f25255OxI);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@OXOo.OOXIXo MotionEvent event) {
        IIX0o.x0xO0oo(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                this.f25252IoOoX = false;
                LogUtils.d("ACTION_UP");
                this.f25262XxX0x0xxx.cancel();
                this.f25249IIX0o = 1L;
                setProgress(0.0f);
                II0xO0 iI0xO0 = this.f25266oo0xXOI0I;
                if (iI0xO0 != null) {
                    iI0xO0.start(false);
                }
            }
        } else {
            this.f25252IoOoX = true;
            LogUtils.d("ACTION_DOWN");
            this.f25249IIX0o = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
            setProgress(5.0f);
            II0xO0 iI0xO02 = this.f25266oo0xXOI0I;
            if (iI0xO02 != null) {
                iI0xO02.start(true);
            }
        }
        return super.onTouchEvent(event);
    }

    public final void oxoX(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SportEndProgress);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f25271xxX = obtainStyledAttributes.getBoolean(0, true);
        this.f25258X0IIOO = obtainStyledAttributes.getColor(3, -1);
        this.f25259XI0IXoo = obtainStyledAttributes.getColor(1, SupportMenu.CATEGORY_MASK);
        this.f25260XIxXXX0x0 = obtainStyledAttributes.getColor(2, -1);
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public SportEndProgress(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ SportEndProgress(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public SportEndProgress(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f25251IXxxXO = II0xO0(60);
        this.f25256Oxx0xo = II0xO0(60);
        Paint paint = new Paint();
        this.f25264oI0IIXIo = paint;
        Paint paint2 = new Paint();
        this.f25257OxxIIOOXO = paint2;
        Paint paint3 = new Paint();
        this.f25250IIXOooo = paint3;
        this.f25270xoXoI = new RectF();
        float II0xO02 = II0xO0(4);
        this.f25263o00 = II0xO02;
        this.f25255OxI = II0xO0(6);
        this.f25271xxX = true;
        this.f25262XxX0x0xxx = new ValueAnimator();
        this.f25249IIX0o = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
        this.f25267ooXIXxIX = 5.0f;
        oxoX(context, attributeSet);
        paint.setAntiAlias(this.f25271xxX);
        paint.setColor(this.f25258X0IIOO);
        paint2.setAntiAlias(this.f25271xxX);
        paint2.setColor(this.f25259XI0IXoo);
        paint3.setAntiAlias(this.f25271xxX);
        paint3.setColor(this.f25260XIxXXX0x0);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(II0xO02);
    }
}
