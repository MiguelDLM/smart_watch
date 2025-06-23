package com.sma.smartv3.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import com.blankj.utilcode.util.SizeUtils;
import com.sma.smartv3.R;
import com.sma.smartv3.util.xxIO;
import com.sma.smartv3.view.text.MyTypeface;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import skin.support.widget.SkinCompatView;

/* loaded from: classes12.dex */
public final class SimpleStepProgressBar extends SkinCompatView {

    /* renamed from: IIX0o, reason: collision with root package name */
    public int f25176IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public float f25177IIXOooo;

    /* renamed from: IO, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f25178IO;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public float f25179IXxxXO;

    /* renamed from: Io, reason: collision with root package name */
    public final float f25180Io;

    /* renamed from: IoOoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public Bitmap f25181IoOoX;

    /* renamed from: O0xOxO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25182O0xOxO;

    /* renamed from: OI0, reason: collision with root package name */
    public final long f25183OI0;

    /* renamed from: Oo, reason: collision with root package name */
    public float f25184Oo;

    /* renamed from: OxI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25185OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public float f25186Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f25187OxxIIOOXO;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public float f25188X00IoxXI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f25189X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f25190XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public int f25191XIxXXX0x0;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public float f25192XOxIOxOx;

    /* renamed from: XX, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f25193XX;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public Paint f25194Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public int f25195XxX0x0xxx;

    /* renamed from: o0, reason: collision with root package name */
    public float f25196o0;

    /* renamed from: o00, reason: collision with root package name */
    public float f25197o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f25198oI0IIXIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public Paint f25199oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public int f25200oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f25201oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25202ooXIXxIX;

    /* renamed from: x0o, reason: collision with root package name */
    @OXOo.OOXIXo
    public ValueAnimator f25203x0o;

    /* renamed from: xI, reason: collision with root package name */
    public int f25204xI;

    /* renamed from: xII, reason: collision with root package name */
    public int f25205xII;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public int f25206xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    public final float f25207xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public int f25208xxX;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public SimpleStepProgressBar(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    private final void I0Io(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SimpleStepProgressBar);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f25198oI0IIXIo = obtainStyledAttributes.getBoolean(0, true);
        this.f25190XI0IXoo = obtainStyledAttributes.getResourceId(4, 0);
        this.f25206xXxxox0I = obtainStyledAttributes.getResourceId(2, 0);
        this.f25208xxX = obtainStyledAttributes.getResourceId(3, 0);
        this.f25178IO = obtainStyledAttributes.getText(6).toString();
        this.f25201oo0xXOI0I = obtainStyledAttributes.getResourceId(5, 0);
        this.f25200oo = obtainStyledAttributes.getColor(1, 0);
        obtainStyledAttributes.recycle();
    }

    private final float II0xO0(int i) {
        return SizeUtils.dp2px(i);
    }

    public static final void Oxx0IOOO(SimpleStepProgressBar this$0, ValueAnimator animation) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        IIX0o.x0XOIxOo(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.f25192XOxIOxOx = floatValue;
        this$0.f25196o0 = floatValue * this$0.f25180Io;
        this$0.invalidate();
    }

    private final float X0o0xo(int i) {
        return SizeUtils.sp2px(i);
    }

    private final void XO(float f, float f2, long j) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        IIX0o.oO(ofFloat, "ofFloat(...)");
        this.f25203x0o = ofFloat;
        ofFloat.setDuration(j);
        this.f25203x0o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sma.smartv3.view.x0xO0oo
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SimpleStepProgressBar.Oxx0IOOO(SimpleStepProgressBar.this, valueAnimator);
            }
        });
        this.f25203x0o.start();
    }

    @Override // skin.support.widget.SkinCompatView, xxoXO.Oxx0IOOO
    public void applySkin() {
        super.applySkin();
        Context context = getContext();
        IIX0o.oO(context, "getContext(...)");
        xxIO.oIX0oI(context, this.f25202ooXIXxIX, this.f25204xI);
        Context context2 = getContext();
        IIX0o.oO(context2, "getContext(...)");
        xxIO.oIX0oI(context2, this.f25194Xx000oIo, this.f25201oo0xXOI0I);
        Context context3 = getContext();
        IIX0o.oO(context3, "getContext(...)");
        xxIO.oIX0oI(context3, this.f25199oOXoIIIo, this.f25201oo0xXOI0I);
        Context context4 = getContext();
        IIX0o.oO(context4, "getContext(...)");
        this.f25191XIxXXX0x0 = xxIO.II0xO0(context4, this.f25190XI0IXoo);
        Context context5 = getContext();
        IIX0o.oO(context5, "getContext(...)");
        this.f25176IIX0o = xxIO.II0xO0(context5, this.f25206xXxxox0I);
        Context context6 = getContext();
        IIX0o.oO(context6, "getContext(...)");
        this.f25195XxX0x0xxx = xxIO.II0xO0(context6, this.f25208xxX);
        int i = this.f25191XIxXXX0x0;
        int i2 = this.f25195XxX0x0xxx;
        int i3 = this.f25176IIX0o;
        this.f25185OxI.setShader(new SweepGradient(this.f25187OxxIIOOXO / 2, 1.0f, new int[]{i, i2, i3, i3}, new float[]{0.0f, 0.3f, 0.5f, 1.0f}));
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(@OXOo.OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        canvas.drawArc(this.f25189X0IIOO, 270.0f, 360.0f, false, this.f25182O0xOxO);
        float f = (this.f25196o0 / this.f25180Io) * 360.0f;
        this.f25186Oxx0xo = f;
        canvas.drawArc(this.f25189X0IIOO, 270.0f, f, false, this.f25185OxI);
        canvas.drawBitmap(this.f25181IoOoX, this.f25184Oo - II0xO0(14), this.f25184Oo / 3, this.f25202ooXIXxIX);
        String str = this.f25193XX;
        float f2 = this.f25184Oo;
        canvas.drawText(str, f2, II0xO0(10) + f2, this.f25199oOXoIIIo);
        String str2 = this.f25178IO;
        float f3 = this.f25184Oo;
        canvas.drawText(str2, f3 - this.f25188X00IoxXI, f3 + (f3 / 2), this.f25194Xx000oIo);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int min = Math.min(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        this.f25205xII = min;
        setMeasuredDimension(min, min);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f25187OxxIIOOXO = i;
        float f = this.f25205xII / 2.0f;
        this.f25184Oo = f;
        this.f25179IXxxXO = f - (this.f25177IIXOooo / 2);
        RectF rectF = this.f25189X0IIOO;
        float f2 = this.f25197o00;
        rectF.set(f2, f2, getWidth() - this.f25197o00, getWidth() - this.f25197o00);
        applySkin();
    }

    public final void oxoX(int i, int i2) {
        this.f25193XX = String.valueOf(i);
        if (i2 == 0) {
            i2 = 10000;
        }
        float f = (i / i2) * 100;
        float f2 = this.f25180Io;
        if (f > f2) {
            f = f2;
        }
        XO(this.f25192XOxIOxOx, f / f2, this.f25183OI0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public SimpleStepProgressBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ SimpleStepProgressBar(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public SimpleStepProgressBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f25198oI0IIXIo = true;
        float II0xO02 = II0xO0(10);
        this.f25177IIXOooo = II0xO02;
        float f = 2;
        float II0xO03 = (II0xO02 * f) + II0xO0(8);
        this.f25207xoXoI = II0xO03;
        this.f25197o00 = II0xO0(6);
        Paint paint = new Paint();
        this.f25185OxI = paint;
        Paint paint2 = new Paint();
        this.f25182O0xOxO = paint2;
        this.f25189X0IIOO = new RectF();
        Paint paint3 = new Paint();
        this.f25202ooXIXxIX = paint3;
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), com.sma.smartv3.co_fit.R.drawable.going_fit_icon_step);
        IIX0o.oO(decodeResource, "decodeResource(...)");
        this.f25181IoOoX = decodeResource;
        this.f25199oOXoIIIo = new Paint();
        this.f25194Xx000oIo = new Paint();
        this.f25178IO = "Steps";
        this.f25203x0o = new ValueAnimator();
        this.f25183OI0 = 1000L;
        this.f25180Io = 100.0f;
        this.f25196o0 = 90.0f;
        this.f25193XX = "10000";
        I0Io(context, attributeSet);
        paint.setAntiAlias(this.f25198oI0IIXIo);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        paint.setStrokeWidth(this.f25177IIXOooo);
        paint2.setAntiAlias(this.f25198oI0IIXIo);
        paint2.setStyle(style);
        paint2.setStrokeCap(cap);
        paint2.setStrokeWidth(this.f25177IIXOooo);
        paint2.setColor(this.f25200oo);
        paint3.setAntiAlias(this.f25198oI0IIXIo);
        paint3.setStyle(Paint.Style.FILL_AND_STROKE);
        paint3.setColor(-1);
        paint3.setStrokeWidth(II0xO03);
        this.f25199oOXoIIIo.setAntiAlias(this.f25198oI0IIXIo);
        this.f25199oOXoIIIo.setColor(this.f25201oo0xXOI0I);
        this.f25199oOXoIIIo.setTextSize(X0o0xo(36));
        this.f25199oOXoIIIo.setTextAlign(Paint.Align.CENTER);
        Paint paint4 = this.f25199oOXoIIIo;
        OOxOI.oIX0oI oix0oi = OOxOI.oIX0oI.f1804oIX0oI;
        paint4.setTypeface(oix0oi.oIX0oI(MyTypeface.DIN_COND_BOLD, context));
        this.f25194Xx000oIo.setAntiAlias(this.f25198oI0IIXIo);
        this.f25194Xx000oIo.setColor(this.f25201oo0xXOI0I);
        this.f25194Xx000oIo.setTextSize(X0o0xo(14));
        this.f25194Xx000oIo.setTypeface(oix0oi.oIX0oI(MyTypeface.PF_REGULAR, context));
        this.f25188X00IoxXI = this.f25194Xx000oIo.measureText(this.f25178IO) / f;
        applySkin();
    }
}
