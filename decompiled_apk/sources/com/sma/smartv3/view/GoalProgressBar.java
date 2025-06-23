package com.sma.smartv3.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.blankj.utilcode.util.SizeUtils;
import com.sma.smartv3.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import skin.support.widget.SkinCompatView;

/* loaded from: classes12.dex */
public final class GoalProgressBar extends SkinCompatView {

    /* renamed from: IIX0o, reason: collision with root package name */
    public int f25016IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25017IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f25018IXxxXO;

    /* renamed from: IoOoX, reason: collision with root package name */
    public final float f25019IoOoX;

    /* renamed from: O0xOxO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25020O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public float f25021Oo;

    /* renamed from: OxI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25022OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public float f25023Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25024OxxIIOOXO;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public float f25025X00IoxXI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f25026X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f25027XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f25028XIxXXX0x0;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public final float f25029Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public int f25030XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25031o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public float f25032oI0IIXIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public float f25033oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public float f25034oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public final float f25035oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public int f25036ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public int f25037xI;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public int f25038xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25039xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public int f25040xxX;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public GoalProgressBar(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    private final void II0xO0(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GoalProgressBar);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f25018IXxxXO = obtainStyledAttributes.getBoolean(0, true);
        this.f25040xxX = obtainStyledAttributes.getColor(8, 0);
        this.f25030XxX0x0xxx = obtainStyledAttributes.getColor(7, 0);
        this.f25038xXxxox0I = obtainStyledAttributes.getColor(2, 0);
        this.f25016IIX0o = obtainStyledAttributes.getColor(1, 0);
        this.f25036ooXIXxIX = obtainStyledAttributes.getColor(4, 0);
        this.f25037xI = obtainStyledAttributes.getColor(3, 0);
        obtainStyledAttributes.recycle();
    }

    private final float oIX0oI(int i) {
        return SizeUtils.dp2px(i);
    }

    public final void I0Io(int i, int i2) {
        if (i2 == 0) {
            i2 = 10000;
        }
        float f = (i / i2) * 100;
        float f2 = this.f25019IoOoX;
        if (f > f2) {
            f = f2;
        }
        this.f25033oOXoIIIo = f;
        invalidate();
    }

    public final void X0o0xo(int i, int i2) {
        if (i2 == 0) {
            i2 = 10000;
        }
        float f = (i / i2) * 100;
        float f2 = this.f25035oo0xXOI0I;
        if (f > f2) {
            f = f2;
        }
        this.f25034oo = f;
        invalidate();
    }

    @Override // skin.support.widget.SkinCompatView, xxoXO.Oxx0IOOO
    public void applySkin() {
        super.applySkin();
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(@OXOo.OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        canvas.drawArc(this.f25026X0IIOO, 90.0f, 180.0f, false, this.f25017IIXOooo);
        float f = (this.f25034oo / this.f25035oo0xXOI0I) * 180.0f;
        this.f25021Oo = f;
        canvas.drawArc(this.f25026X0IIOO, 90.0f, f, false, this.f25024OxxIIOOXO);
        canvas.drawArc(this.f25027XI0IXoo, 90.0f, 180.0f, false, this.f25031o00);
        float f2 = (this.f25033oOXoIIIo / this.f25019IoOoX) * 180.0f;
        this.f25021Oo = f2;
        canvas.drawArc(this.f25027XI0IXoo, 90.0f, f2, false, this.f25039xoXoI);
        canvas.drawArc(this.f25028XIxXXX0x0, 90.0f, 180.0f, false, this.f25020O0xOxO);
        float f3 = (this.f25025X00IoxXI / this.f25029Xx000oIo) * 180.0f;
        this.f25021Oo = f3;
        canvas.drawArc(this.f25028XIxXXX0x0, 90.0f, f3, false, this.f25022OxI);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i2;
        float f2 = (f - (this.f25032oI0IIXIo * 4)) / 7;
        this.f25023Oxx0xo = f2;
        float f3 = f2 / 2;
        this.f25024OxxIIOOXO.setStrokeWidth(f2);
        this.f25017IIXOooo.setStrokeWidth(this.f25023Oxx0xo);
        this.f25039xoXoI.setStrokeWidth(this.f25023Oxx0xo);
        this.f25031o00.setStrokeWidth(this.f25023Oxx0xo);
        this.f25022OxI.setStrokeWidth(this.f25023Oxx0xo);
        this.f25020O0xOxO.setStrokeWidth(this.f25023Oxx0xo);
        float f4 = f - f3;
        this.f25026X0IIOO.set(f3, f3, f4, f4);
        RectF rectF = this.f25027XI0IXoo;
        RectF rectF2 = this.f25026X0IIOO;
        float f5 = rectF2.left;
        float f6 = this.f25023Oxx0xo;
        float f7 = this.f25032oI0IIXIo;
        rectF.set(f5 + f6 + f7, rectF2.top + f6 + f7, (rectF2.right - f6) - f7, (rectF2.bottom - f6) - f7);
        RectF rectF3 = this.f25028XIxXXX0x0;
        RectF rectF4 = this.f25027XI0IXoo;
        float f8 = rectF4.left;
        float f9 = this.f25023Oxx0xo;
        float f10 = this.f25032oI0IIXIo;
        rectF3.set(f8 + f9 + f10, rectF4.top + f9 + f10, (rectF4.right - f9) - f10, (rectF4.bottom - f9) - f10);
        applySkin();
    }

    public final void oxoX(int i, int i2) {
        if (i2 == 0) {
            i2 = 10000;
        }
        float f = (i / i2) * 100;
        float f2 = this.f25029Xx000oIo;
        if (f > f2) {
            f = f2;
        }
        this.f25025X00IoxXI = f;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public GoalProgressBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ GoalProgressBar(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public GoalProgressBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f25021Oo = 50.0f;
        this.f25018IXxxXO = true;
        this.f25023Oxx0xo = oIX0oI(10);
        this.f25032oI0IIXIo = oIX0oI(4);
        Paint paint = new Paint();
        this.f25024OxxIIOOXO = paint;
        Paint paint2 = new Paint();
        this.f25017IIXOooo = paint2;
        Paint paint3 = new Paint();
        this.f25039xoXoI = paint3;
        Paint paint4 = new Paint();
        this.f25031o00 = paint4;
        Paint paint5 = new Paint();
        this.f25022OxI = paint5;
        Paint paint6 = new Paint();
        this.f25020O0xOxO = paint6;
        this.f25026X0IIOO = new RectF();
        this.f25027XI0IXoo = new RectF();
        this.f25028XIxXXX0x0 = new RectF();
        this.f25035oo0xXOI0I = 100.0f;
        this.f25034oo = 34.0f;
        this.f25019IoOoX = 100.0f;
        this.f25033oOXoIIIo = 34.0f;
        this.f25029Xx000oIo = 100.0f;
        this.f25025X00IoxXI = 34.0f;
        II0xO0(context, attributeSet);
        paint.setAntiAlias(this.f25018IXxxXO);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        paint.setStrokeWidth(this.f25023Oxx0xo);
        paint.setColor(this.f25040xxX);
        paint2.setAntiAlias(this.f25018IXxxXO);
        paint2.setStyle(style);
        paint2.setStrokeCap(cap);
        paint2.setStrokeWidth(this.f25023Oxx0xo);
        paint2.setColor(this.f25030XxX0x0xxx);
        paint3.setAntiAlias(this.f25018IXxxXO);
        paint3.setStyle(style);
        paint3.setStrokeCap(cap);
        paint3.setStrokeWidth(this.f25023Oxx0xo);
        paint3.setColor(this.f25038xXxxox0I);
        paint4.setAntiAlias(this.f25018IXxxXO);
        paint4.setStyle(style);
        paint4.setStrokeCap(cap);
        paint4.setStrokeWidth(this.f25023Oxx0xo);
        paint4.setColor(this.f25016IIX0o);
        paint5.setAntiAlias(this.f25018IXxxXO);
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        paint5.setStrokeWidth(this.f25023Oxx0xo);
        paint5.setColor(this.f25036ooXIXxIX);
        paint6.setAntiAlias(this.f25018IXxxXO);
        paint6.setStyle(style);
        paint6.setStrokeCap(cap);
        paint6.setStrokeWidth(this.f25023Oxx0xo);
        paint6.setColor(this.f25037xI);
        applySkin();
    }
}
