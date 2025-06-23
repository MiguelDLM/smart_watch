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
public final class Goal3ProgressBar extends SkinCompatView {

    /* renamed from: IIX0o, reason: collision with root package name */
    public int f24958IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24959IIXOooo;

    /* renamed from: IO, reason: collision with root package name */
    public float f24960IO;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f24961IXxxXO;

    /* renamed from: IoOoX, reason: collision with root package name */
    public final float f24962IoOoX;

    /* renamed from: O0xOxO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24963O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public float f24964Oo;

    /* renamed from: OxI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24965OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public float f24966Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24967OxxIIOOXO;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public float f24968X00IoxXI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f24969X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f24970XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f24971XIxXXX0x0;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public final float f24972Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public int f24973XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24974o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public float f24975oI0IIXIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public float f24976oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public float f24977oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public final float f24978oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public int f24979ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public int f24980xI;

    /* renamed from: xII, reason: collision with root package name */
    public float f24981xII;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public int f24982xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24983xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public int f24984xxX;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public Goal3ProgressBar(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    private final void II0xO0(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GoalProgressBar);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f24961IXxxXO = obtainStyledAttributes.getBoolean(0, true);
        this.f24984xxX = obtainStyledAttributes.getColor(8, 0);
        this.f24973XxX0x0xxx = obtainStyledAttributes.getColor(7, 0);
        this.f24982xXxxox0I = obtainStyledAttributes.getColor(2, 0);
        this.f24958IIX0o = obtainStyledAttributes.getColor(1, 0);
        this.f24979ooXIXxIX = obtainStyledAttributes.getColor(4, 0);
        this.f24980xI = obtainStyledAttributes.getColor(3, 0);
        this.f24960IO = obtainStyledAttributes.getDimension(6, 0.0f);
        this.f24981xII = obtainStyledAttributes.getDimension(9, 360.0f);
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
        float f2 = this.f24962IoOoX;
        if (f > f2) {
            f = f2;
        }
        this.f24976oOXoIIIo = f;
        invalidate();
    }

    public final void X0o0xo(int i, int i2) {
        if (i2 == 0) {
            i2 = 10000;
        }
        float f = (i / i2) * 100;
        float f2 = this.f24978oo0xXOI0I;
        if (f > f2) {
            f = f2;
        }
        this.f24977oo = f;
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
        canvas.drawArc(this.f24969X0IIOO, this.f24960IO, this.f24981xII, false, this.f24959IIXOooo);
        float f = (this.f24977oo / this.f24978oo0xXOI0I) * this.f24981xII;
        this.f24964Oo = f;
        canvas.drawArc(this.f24969X0IIOO, this.f24960IO, f, false, this.f24967OxxIIOOXO);
        canvas.drawArc(this.f24970XI0IXoo, this.f24960IO, this.f24981xII, false, this.f24974o00);
        float f2 = (this.f24976oOXoIIIo / this.f24962IoOoX) * this.f24981xII;
        this.f24964Oo = f2;
        canvas.drawArc(this.f24970XI0IXoo, this.f24960IO, f2, false, this.f24983xoXoI);
        canvas.drawArc(this.f24971XIxXXX0x0, this.f24960IO, this.f24981xII, false, this.f24963O0xOxO);
        float f3 = (this.f24968X00IoxXI / this.f24972Xx000oIo) * this.f24981xII;
        this.f24964Oo = f3;
        canvas.drawArc(this.f24971XIxXXX0x0, this.f24960IO, f3, false, this.f24965OxI);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i2;
        float f2 = (f - (this.f24975oI0IIXIo * 4)) / 7;
        this.f24966Oxx0xo = f2;
        float f3 = f2 / 2;
        this.f24967OxxIIOOXO.setStrokeWidth(f2);
        this.f24959IIXOooo.setStrokeWidth(this.f24966Oxx0xo);
        this.f24983xoXoI.setStrokeWidth(this.f24966Oxx0xo);
        this.f24974o00.setStrokeWidth(this.f24966Oxx0xo);
        this.f24965OxI.setStrokeWidth(this.f24966Oxx0xo);
        this.f24963O0xOxO.setStrokeWidth(this.f24966Oxx0xo);
        float f4 = f - f3;
        this.f24969X0IIOO.set(f3, f3, f4, f4);
        RectF rectF = this.f24970XI0IXoo;
        RectF rectF2 = this.f24969X0IIOO;
        float f5 = rectF2.left;
        float f6 = this.f24966Oxx0xo;
        float f7 = this.f24975oI0IIXIo;
        rectF.set(f5 + f6 + f7, rectF2.top + f6 + f7, (rectF2.right - f6) - f7, (rectF2.bottom - f6) - f7);
        RectF rectF3 = this.f24971XIxXXX0x0;
        RectF rectF4 = this.f24970XI0IXoo;
        float f8 = rectF4.left;
        float f9 = this.f24966Oxx0xo;
        float f10 = this.f24975oI0IIXIo;
        rectF3.set(f8 + f9 + f10, rectF4.top + f9 + f10, (rectF4.right - f9) - f10, (rectF4.bottom - f9) - f10);
        applySkin();
    }

    public final void oxoX(int i, int i2) {
        if (i2 == 0) {
            i2 = 10000;
        }
        float f = (i / i2) * 100;
        float f2 = this.f24972Xx000oIo;
        if (f > f2) {
            f = f2;
        }
        this.f24968X00IoxXI = f;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public Goal3ProgressBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ Goal3ProgressBar(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public Goal3ProgressBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f24964Oo = 50.0f;
        this.f24961IXxxXO = true;
        this.f24966Oxx0xo = oIX0oI(10);
        this.f24975oI0IIXIo = oIX0oI(4);
        Paint paint = new Paint();
        this.f24967OxxIIOOXO = paint;
        Paint paint2 = new Paint();
        this.f24959IIXOooo = paint2;
        Paint paint3 = new Paint();
        this.f24983xoXoI = paint3;
        Paint paint4 = new Paint();
        this.f24974o00 = paint4;
        Paint paint5 = new Paint();
        this.f24965OxI = paint5;
        Paint paint6 = new Paint();
        this.f24963O0xOxO = paint6;
        this.f24969X0IIOO = new RectF();
        this.f24970XI0IXoo = new RectF();
        this.f24971XIxXXX0x0 = new RectF();
        this.f24978oo0xXOI0I = 100.0f;
        this.f24977oo = 34.0f;
        this.f24962IoOoX = 100.0f;
        this.f24976oOXoIIIo = 34.0f;
        this.f24972Xx000oIo = 100.0f;
        this.f24968X00IoxXI = 34.0f;
        this.f24981xII = 360.0f;
        II0xO0(context, attributeSet);
        paint.setAntiAlias(this.f24961IXxxXO);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        paint.setStrokeWidth(this.f24966Oxx0xo);
        paint.setColor(this.f24984xxX);
        paint2.setAntiAlias(this.f24961IXxxXO);
        paint2.setStyle(style);
        paint2.setStrokeCap(cap);
        paint2.setStrokeWidth(this.f24966Oxx0xo);
        paint2.setColor(this.f24973XxX0x0xxx);
        paint3.setAntiAlias(this.f24961IXxxXO);
        paint3.setStyle(style);
        paint3.setStrokeCap(cap);
        paint3.setStrokeWidth(this.f24966Oxx0xo);
        paint3.setColor(this.f24982xXxxox0I);
        paint4.setAntiAlias(this.f24961IXxxXO);
        paint4.setStyle(style);
        paint4.setStrokeCap(cap);
        paint4.setStrokeWidth(this.f24966Oxx0xo);
        paint4.setColor(this.f24958IIX0o);
        paint5.setAntiAlias(this.f24961IXxxXO);
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        paint5.setStrokeWidth(this.f24966Oxx0xo);
        paint5.setColor(this.f24979ooXIXxIX);
        paint6.setAntiAlias(this.f24961IXxxXO);
        paint6.setStyle(style);
        paint6.setStrokeCap(cap);
        paint6.setStrokeWidth(this.f24966Oxx0xo);
        paint6.setColor(this.f24980xI);
        applySkin();
    }
}
