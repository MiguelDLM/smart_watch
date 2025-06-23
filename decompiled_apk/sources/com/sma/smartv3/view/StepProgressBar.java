package com.sma.smartv3.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
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
public final class StepProgressBar extends SkinCompatView {

    /* renamed from: I0X0x0oIo, reason: collision with root package name */
    public int f25317I0X0x0oIo;

    /* renamed from: I0oOIX, reason: collision with root package name */
    public float f25318I0oOIX;

    /* renamed from: I0oOoX, reason: collision with root package name */
    public int f25319I0oOoX;

    /* renamed from: IIX0o, reason: collision with root package name */
    public int f25320IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25321IIXOooo;

    /* renamed from: IO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25322IO;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public float f25323IXxxXO;

    /* renamed from: Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25324Io;

    /* renamed from: IoOoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25325IoOoX;

    /* renamed from: O0Xx, reason: collision with root package name */
    public final float f25326O0Xx;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public int f25327O0xOxO;

    /* renamed from: OI0, reason: collision with root package name */
    public int f25328OI0;

    /* renamed from: Oo, reason: collision with root package name */
    public float f25329Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public float f25330OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public float f25331Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f25332OxxIIOOXO;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public int f25333X00IoxXI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public float f25334X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final DashPathEffect f25335XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25336XIxXXX0x0;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public int f25337XOxIOxOx;

    /* renamed from: XX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25338XX;

    /* renamed from: XX0, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f25339XX0;

    /* renamed from: Xo0, reason: collision with root package name */
    public float f25340Xo0;

    /* renamed from: XoI0Ixx0, reason: collision with root package name */
    public final long f25341XoI0Ixx0;

    /* renamed from: XoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public Bitmap f25342XoX;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public final float f25343Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public float f25344XxX0x0xxx;

    /* renamed from: o0, reason: collision with root package name */
    public int f25345o0;

    /* renamed from: o00, reason: collision with root package name */
    public float f25346o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f25347oI0IIXIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public final float f25348oOXoIIIo;

    /* renamed from: oX, reason: collision with root package name */
    @OXOo.OOXIXo
    public ValueAnimator f25349oX;

    /* renamed from: oo, reason: collision with root package name */
    public int f25350oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f25351oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public int f25352ooXIXxIX;

    /* renamed from: oxXx0IX, reason: collision with root package name */
    @OXOo.OOXIXo
    public Paint f25353oxXx0IX;

    /* renamed from: oxxXoxO, reason: collision with root package name */
    public int f25354oxxXoxO;

    /* renamed from: x0o, reason: collision with root package name */
    public float f25355x0o;

    /* renamed from: xI, reason: collision with root package name */
    public int f25356xI;

    /* renamed from: xII, reason: collision with root package name */
    public float f25357xII;

    /* renamed from: xXOx, reason: collision with root package name */
    public float f25358xXOx;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public int f25359xXxxox0I;

    /* renamed from: xo0x, reason: collision with root package name */
    @OXOo.OOXIXo
    public Paint f25360xo0x;

    /* renamed from: xoXoI, reason: collision with root package name */
    public float f25361xoXoI;

    /* renamed from: xoxXI, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f25362xoxXI;

    /* renamed from: xxX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f25363xxX;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public StepProgressBar(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    private final void I0Io(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepProgressBar);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f25347oI0IIXIo = obtainStyledAttributes.getBoolean(0, true);
        this.f25359xXxxox0I = obtainStyledAttributes.getResourceId(9, 0);
        this.f25351oo0xXOI0I = obtainStyledAttributes.getResourceId(7, 0);
        this.f25352ooXIXxIX = obtainStyledAttributes.getResourceId(8, 0);
        this.f25327O0xOxO = obtainStyledAttributes.getResourceId(1, 0);
        this.f25333X00IoxXI = obtainStyledAttributes.getResourceId(3, 0);
        this.f25319I0oOoX = obtainStyledAttributes.getResourceId(6, 0);
        int resourceId = obtainStyledAttributes.getResourceId(4, 0);
        this.f25337XOxIOxOx = resourceId;
        this.f25328OI0 = obtainStyledAttributes.getResourceId(5, resourceId);
        this.f25345o0 = obtainStyledAttributes.getResourceId(2, 0);
        this.f25339XX0 = obtainStyledAttributes.getText(11).toString();
        this.f25354oxxXoxO = obtainStyledAttributes.getResourceId(10, 0);
        obtainStyledAttributes.recycle();
    }

    private final float II0xO0(int i) {
        return SizeUtils.dp2px(i);
    }

    public static final void Oxx0IOOO(StepProgressBar this$0, ValueAnimator animation) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        IIX0o.x0XOIxOo(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.f25340Xo0 = floatValue;
        this$0.f25318I0oOIX = floatValue * this$0.f25326O0Xx;
        this$0.invalidate();
    }

    private final float X0o0xo(int i) {
        return SizeUtils.sp2px(i);
    }

    private final void XO(float f, float f2, long j) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        IIX0o.oO(ofFloat, "ofFloat(...)");
        this.f25349oX = ofFloat;
        ofFloat.setDuration(j);
        this.f25349oX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sma.smartv3.view.Oxx0xo
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                StepProgressBar.Oxx0IOOO(StepProgressBar.this, valueAnimator);
            }
        });
        this.f25349oX.start();
    }

    @Override // skin.support.widget.SkinCompatView, xxoXO.Oxx0IOOO
    public void applySkin() {
        super.applySkin();
        Context context = getContext();
        IIX0o.oO(context, "getContext(...)");
        xxIO.oIX0oI(context, this.f25321IIXOooo, this.f25327O0xOxO);
        Context context2 = getContext();
        IIX0o.oO(context2, "getContext(...)");
        xxIO.oIX0oI(context2, this.f25325IoOoX, this.f25333X00IoxXI);
        Context context3 = getContext();
        IIX0o.oO(context3, "getContext(...)");
        xxIO.oIX0oI(context3, this.f25338XX, this.f25319I0oOoX);
        Context context4 = getContext();
        IIX0o.oO(context4, "getContext(...)");
        xxIO.oIX0oI(context4, this.f25322IO, this.f25337XOxIOxOx);
        Context context5 = getContext();
        IIX0o.oO(context5, "getContext(...)");
        xxIO.oIX0oI(context5, this.f25360xo0x, this.f25328OI0);
        Context context6 = getContext();
        IIX0o.oO(context6, "getContext(...)");
        xxIO.oIX0oI(context6, this.f25324Io, this.f25345o0);
        Context context7 = getContext();
        IIX0o.oO(context7, "getContext(...)");
        xxIO.oIX0oI(context7, this.f25353oxXx0IX, this.f25354oxxXoxO);
        Context context8 = getContext();
        IIX0o.oO(context8, "getContext(...)");
        this.f25320IIX0o = xxIO.II0xO0(context8, this.f25359xXxxox0I);
        Context context9 = getContext();
        IIX0o.oO(context9, "getContext(...)");
        this.f25350oo = xxIO.II0xO0(context9, this.f25351oo0xXOI0I);
        Context context10 = getContext();
        IIX0o.oO(context10, "getContext(...)");
        this.f25356xI = xxIO.II0xO0(context10, this.f25352ooXIXxIX);
        int i = this.f25320IIX0o;
        int i2 = this.f25356xI;
        int i3 = this.f25350oo;
        this.f25336XIxXXX0x0.setShader(new SweepGradient(this.f25332OxxIIOOXO / 2, 1.0f, new int[]{i, i2, i3, i3}, new float[]{0.0f, 0.3f, 0.5f, 1.0f}));
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(@OXOo.OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        float f = this.f25329Oo;
        canvas.drawCircle(f, f, this.f25323IXxxXO, this.f25321IIXOooo);
        float f2 = (this.f25318I0oOIX / this.f25326O0Xx) * 360.0f;
        this.f25331Oxx0xo = f2;
        canvas.drawArc(this.f25363xxX, 270.0f, f2, false, this.f25336XIxXXX0x0);
        float f3 = this.f25329Oo;
        canvas.drawCircle(f3, f3, this.f25323IXxxXO - this.f25348oOXoIIIo, this.f25325IoOoX);
        canvas.drawText("0%", this.f25329Oo - II0xO0(6), this.f25357xII, this.f25322IO);
        canvas.drawText("25%", (this.f25317I0X0x0oIo - this.f25357xII) - II0xO0(4), this.f25329Oo, this.f25322IO);
        canvas.drawText("50%", this.f25329Oo - II0xO0(8), (this.f25317I0X0x0oIo - this.f25357xII) + II0xO0(8), this.f25322IO);
        canvas.drawText("75%", this.f25357xII - II0xO0(18), this.f25329Oo, this.f25322IO);
        float f4 = this.f25317I0X0x0oIo;
        float f5 = this.f25355x0o;
        canvas.drawCircle(f4 - f5, f5, 10.0f, this.f25324Io);
        int i = this.f25317I0X0x0oIo;
        float f6 = this.f25355x0o;
        canvas.drawCircle(i - f6, i - f6, 10.0f, this.f25324Io);
        float f7 = this.f25355x0o;
        canvas.drawCircle(f7, this.f25317I0X0x0oIo - f7, 10.0f, this.f25324Io);
        float f8 = this.f25355x0o;
        canvas.drawCircle(f8, f8, 10.0f, this.f25324Io);
        float f9 = this.f25329Oo;
        canvas.drawCircle(f9, f9, ((this.f25323IXxxXO - this.f25348oOXoIIIo) - this.f25343Xx000oIo) + II0xO0(1), this.f25338XX);
        canvas.drawBitmap(this.f25342XoX, this.f25329Oo - II0xO0(12), (this.f25329Oo / 2) + II0xO0(10), this.f25338XX);
        String str = this.f25362xoxXI;
        float f10 = this.f25329Oo;
        canvas.drawText(str, f10, II0xO0(8) + f10, this.f25353oxXx0IX);
        canvas.drawText(this.f25339XX0, this.f25329Oo - this.f25358xXOx, ((this.f25317I0X0x0oIo - this.f25348oOXoIIIo) - this.f25343Xx000oIo) - II0xO0(6), this.f25360xo0x);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int min = Math.min(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        this.f25317I0X0x0oIo = min;
        setMeasuredDimension(min, min);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f25332OxxIIOOXO = i;
        float f = this.f25317I0X0x0oIo / 2.0f;
        this.f25329Oo = f;
        this.f25323IXxxXO = f - (this.f25361xoXoI / 2);
        RectF rectF = this.f25363xxX;
        float f2 = this.f25344XxX0x0xxx;
        rectF.set(f2, f2, getWidth() - this.f25344XxX0x0xxx, getWidth() - this.f25344XxX0x0xxx);
        applySkin();
    }

    public final void oxoX(int i, int i2) {
        this.f25362xoxXI = String.valueOf(i);
        if (i2 == 0) {
            i2 = 10000;
        }
        float f = (i / i2) * 100;
        float f2 = this.f25326O0Xx;
        if (f > f2) {
            f = f2;
        }
        XO(this.f25340Xo0, f / f2, this.f25341XoI0Ixx0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public StepProgressBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ StepProgressBar(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public StepProgressBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f25347oI0IIXIo = true;
        Paint paint = new Paint();
        this.f25321IIXOooo = paint;
        this.f25361xoXoI = II0xO0(10);
        this.f25346o00 = II0xO0(1);
        float II0xO02 = II0xO0(4);
        this.f25330OxI = II0xO02;
        this.f25334X0IIOO = this.f25346o00 + II0xO02 + 1;
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{this.f25346o00, this.f25330OxI}, this.f25334X0IIOO);
        this.f25335XI0IXoo = dashPathEffect;
        Paint paint2 = new Paint();
        this.f25336XIxXXX0x0 = paint2;
        this.f25363xxX = new RectF();
        float f = 2;
        this.f25344XxX0x0xxx = (this.f25361xoXoI * f) + II0xO0(4);
        Paint paint3 = new Paint();
        this.f25325IoOoX = paint3;
        float II0xO03 = this.f25344XxX0x0xxx + this.f25361xoXoI + II0xO0(12);
        this.f25348oOXoIIIo = II0xO03;
        float II0xO04 = (this.f25361xoXoI * f) + II0xO0(8);
        this.f25343Xx000oIo = II0xO04;
        Paint paint4 = new Paint();
        this.f25322IO = paint4;
        float II0xO05 = (II0xO03 + (II0xO04 / f)) - II0xO0(2);
        this.f25357xII = II0xO05;
        this.f25355x0o = II0xO05 + II0xO0(14);
        Paint paint5 = new Paint();
        this.f25324Io = paint5;
        Paint paint6 = new Paint();
        this.f25338XX = paint6;
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), com.sma.smartv3.co_fit.R.drawable.icon_step_progress_content);
        IIX0o.oO(decodeResource, "decodeResource(...)");
        this.f25342XoX = decodeResource;
        this.f25353oxXx0IX = new Paint();
        this.f25360xo0x = new Paint();
        this.f25339XX0 = "Steps";
        this.f25349oX = new ValueAnimator();
        this.f25341XoI0Ixx0 = 1000L;
        this.f25326O0Xx = 100.0f;
        this.f25318I0oOIX = 90.0f;
        this.f25362xoxXI = "0";
        I0Io(context, attributeSet);
        paint.setAntiAlias(this.f25347oI0IIXIo);
        paint.setColor(this.f25327O0xOxO);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        paint.setStrokeWidth(this.f25361xoXoI);
        paint.setPathEffect(dashPathEffect);
        paint2.setAntiAlias(this.f25347oI0IIXIo);
        paint2.setStyle(style);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        paint2.setStrokeWidth(this.f25361xoXoI);
        paint3.setAntiAlias(this.f25347oI0IIXIo);
        paint3.setStyle(style);
        paint3.setColor(this.f25333X00IoxXI);
        paint3.setStrokeWidth(II0xO04);
        paint4.setAntiAlias(this.f25347oI0IIXIo);
        paint4.setColor(this.f25337XOxIOxOx);
        paint4.setTextSize(X0o0xo(12));
        OOxOI.oIX0oI oix0oi = OOxOI.oIX0oI.f1804oIX0oI;
        MyTypeface myTypeface = MyTypeface.DIN_COND_BOLD;
        paint4.setTypeface(oix0oi.oIX0oI(myTypeface, context));
        paint5.setAntiAlias(this.f25347oI0IIXIo);
        paint5.setStyle(Paint.Style.FILL);
        paint5.setColor(this.f25345o0);
        paint6.setAntiAlias(this.f25347oI0IIXIo);
        paint6.setStyle(Paint.Style.FILL_AND_STROKE);
        paint6.setColor(this.f25319I0oOoX);
        paint6.setStrokeWidth(II0xO04);
        this.f25353oxXx0IX.setAntiAlias(this.f25347oI0IIXIo);
        this.f25353oxXx0IX.setColor(this.f25354oxxXoxO);
        this.f25353oxXx0IX.setTextSize(X0o0xo(32));
        this.f25353oxXx0IX.setTextAlign(Paint.Align.CENTER);
        this.f25353oxXx0IX.setTypeface(oix0oi.oIX0oI(myTypeface, context));
        this.f25360xo0x.setAntiAlias(this.f25347oI0IIXIo);
        this.f25360xo0x.setColor(this.f25328OI0);
        this.f25360xo0x.setTextSize(X0o0xo(14));
        this.f25360xo0x.setTypeface(oix0oi.oIX0oI(MyTypeface.PF_REGULAR, context));
        this.f25358xXOx = this.f25360xo0x.measureText(this.f25339XX0) / f;
        applySkin();
    }
}
