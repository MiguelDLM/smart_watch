package com.sma.smartv3.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.blankj.utilcode.util.SizeUtils;
import com.sma.smartv3.R;
import com.sma.smartv3.util.xxIO;
import com.sma.smartv3.view.text.MyTypeface;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import skin.support.widget.SkinCompatView;

/* loaded from: classes12.dex */
public final class BmiProgressBar extends SkinCompatView {

    /* renamed from: IIX0o, reason: collision with root package name */
    public int f24790IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24791IIXOooo;

    /* renamed from: IO, reason: collision with root package name */
    public final float f24792IO;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24793IXxxXO;

    /* renamed from: IoOoX, reason: collision with root package name */
    public int f24794IoOoX;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public float f24795O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f24796Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public float f24797OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24798Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public float f24799OxxIIOOXO;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public float f24800X00IoxXI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public float f24801X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public float f24802XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public float f24803XIxXXX0x0;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public float f24804XOxIOxOx;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public float f24805Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public float f24806XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public int f24807o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public final float f24808oI0IIXIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public List<String> f24809oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public int f24810oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f24811oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public int f24812ooXIXxIX;

    /* renamed from: x0o, reason: collision with root package name */
    @OXOo.OOXIXo
    public Paint.FontMetrics f24813x0o;

    /* renamed from: xI, reason: collision with root package name */
    public int f24814xI;

    /* renamed from: xII, reason: collision with root package name */
    public final float f24815xII;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public int f24816xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24817xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public float f24818xxX;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public BmiProgressBar(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    private final void I0Io(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BmiProgressBar);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f24796Oo = obtainStyledAttributes.getBoolean(0, true);
        this.f24816xXxxox0I = obtainStyledAttributes.getResourceId(6, 0);
        this.f24790IIX0o = obtainStyledAttributes.getColor(1, -1);
        this.f24812ooXIXxIX = obtainStyledAttributes.getColor(4, -1);
        this.f24814xI = obtainStyledAttributes.getColor(3, -1);
        this.f24811oo0xXOI0I = obtainStyledAttributes.getColor(7, -1);
        this.f24810oo = obtainStyledAttributes.getColor(5, -1);
        this.f24794IoOoX = obtainStyledAttributes.getColor(2, -1);
        obtainStyledAttributes.recycle();
    }

    public final float II0xO0(int i) {
        return SizeUtils.dp2px(i);
    }

    @Override // skin.support.widget.SkinCompatView, xxoXO.Oxx0IOOO
    public void applySkin() {
        super.applySkin();
        Context context = getContext();
        IIX0o.oO(context, "getContext(...)");
        xxIO.oIX0oI(context, this.f24798Oxx0xo, this.f24816xXxxox0I);
        Context context2 = getContext();
        IIX0o.oO(context2, "getContext(...)");
        xxIO.oIX0oI(context2, this.f24791IIXOooo, this.f24816xXxxox0I);
        invalidate();
    }

    public final void oIX0oI() {
        float f = this.f24800X00IoxXI;
        if (f <= 16.4f) {
            this.f24805Xx000oIo = (this.f24802XI0IXoo / 2) / this.f24807o00;
            return;
        }
        if (f <= 18.4f) {
            this.f24805Xx000oIo = (((f - 16.4f) / 2.0f) * this.f24803XIxXXX0x0) / this.f24807o00;
            return;
        }
        if (f <= 24.9f) {
            float f2 = this.f24803XIxXXX0x0;
            this.f24805Xx000oIo = (f2 + (((f - 18.4f) / 6.5f) * f2)) / this.f24807o00;
        } else if (f <= 29.9f) {
            this.f24805Xx000oIo = (this.f24818xxX + (((f - 24.9f) / 5.0f) * this.f24803XIxXXX0x0)) / this.f24807o00;
        } else if (f <= 34.9f) {
            this.f24805Xx000oIo = (this.f24806XxX0x0xxx + (((f - 29.9f) / 5.000002f) * this.f24803XIxXXX0x0)) / this.f24807o00;
        } else {
            int i = this.f24807o00;
            this.f24805Xx000oIo = (i - (this.f24802XI0IXoo / 2)) / i;
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(@OXOo.OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        if (this.f24809oOXoIIIo.size() > 1) {
            float f = 20;
            canvas.drawText(this.f24809oOXoIIIo.get(0), this.f24803XIxXXX0x0 - f, this.f24808oI0IIXIo, this.f24798Oxx0xo);
            canvas.drawText(this.f24809oOXoIIIo.get(1), this.f24818xxX - f, this.f24808oI0IIXIo, this.f24798Oxx0xo);
            canvas.drawText(this.f24809oOXoIIIo.get(2), this.f24806XxX0x0xxx - f, this.f24808oI0IIXIo, this.f24798Oxx0xo);
            float f2 = this.f24815xII;
            RectF rectF = new RectF(0.0f, f2, this.f24803XIxXXX0x0, this.f24792IO + f2);
            float centerY = rectF.centerY() + this.f24804XOxIOxOx;
            String string = getContext().getResources().getString(com.sma.smartv3.co_fit.R.string.thin);
            IIX0o.oO(string, "getString(...)");
            canvas.drawText(string, rectF.centerX(), centerY, this.f24791IIXOooo);
            float f3 = this.f24803XIxXXX0x0;
            float f4 = this.f24815xII;
            RectF rectF2 = new RectF(f3, f4, this.f24818xxX, this.f24792IO + f4);
            float centerY2 = rectF2.centerY() + this.f24804XOxIOxOx;
            String string2 = getContext().getResources().getString(com.sma.smartv3.co_fit.R.string.normal);
            IIX0o.oO(string2, "getString(...)");
            canvas.drawText(string2, rectF2.centerX(), centerY2, this.f24791IIXOooo);
            float f5 = this.f24818xxX;
            float f6 = this.f24815xII;
            RectF rectF3 = new RectF(f5, f6, this.f24806XxX0x0xxx, this.f24792IO + f6);
            float centerY3 = rectF3.centerY() + this.f24804XOxIOxOx;
            String string3 = getContext().getResources().getString(com.sma.smartv3.co_fit.R.string.too_heavy);
            IIX0o.oO(string3, "getString(...)");
            canvas.drawText(string3, rectF3.centerX(), centerY3, this.f24791IIXOooo);
            float f7 = this.f24806XxX0x0xxx;
            float f8 = this.f24815xII;
            RectF rectF4 = new RectF(f7, f8, this.f24807o00, this.f24792IO + f8);
            float centerY4 = rectF4.centerY() + this.f24804XOxIOxOx;
            String string4 = getContext().getResources().getString(com.sma.smartv3.co_fit.R.string.class_1_obesity);
            IIX0o.oO(string4, "getString(...)");
            canvas.drawText(string4, rectF4.centerX(), centerY4, this.f24791IIXOooo);
        }
        this.f24793IXxxXO.setColor(this.f24814xI);
        canvas.drawRect(0.0f, this.f24797OxI, this.f24803XIxXXX0x0, this.f24801X0IIOO, this.f24793IXxxXO);
        this.f24793IXxxXO.setColor(this.f24811oo0xXOI0I);
        canvas.drawRect(this.f24803XIxXXX0x0, this.f24797OxI, this.f24818xxX, this.f24801X0IIOO, this.f24793IXxxXO);
        this.f24793IXxxXO.setColor(this.f24810oo);
        canvas.drawRect(this.f24818xxX, this.f24797OxI, this.f24806XxX0x0xxx, this.f24801X0IIOO, this.f24793IXxxXO);
        this.f24793IXxxXO.setColor(this.f24794IoOoX);
        canvas.drawRect(this.f24806XxX0x0xxx, this.f24797OxI, this.f24807o00, this.f24801X0IIOO, this.f24793IXxxXO);
        this.f24817xoXoI.setColor(this.f24812ooXIXxIX);
        float f9 = this.f24807o00 * this.f24805Xx000oIo;
        float f10 = this.f24797OxI;
        float f11 = 2;
        canvas.drawCircle(f9, f10 + ((this.f24801X0IIOO - f10) / f11), this.f24802XI0IXoo / f11, this.f24817xoXoI);
        this.f24817xoXoI.setColor(this.f24790IIX0o);
        float f12 = this.f24807o00 * this.f24805Xx000oIo;
        float f13 = this.f24797OxI;
        canvas.drawCircle(f12, f13 + ((this.f24801X0IIOO - f13) / f11), (this.f24802XI0IXoo / f11) - f11, this.f24817xoXoI);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        this.f24807o00 = size;
        float f = size * 0.25f;
        this.f24803XIxXXX0x0 = f;
        this.f24818xxX = 2 * f;
        this.f24806XxX0x0xxx = f * 3;
        oIX0oI();
    }

    public final float oxoX(int i) {
        return SizeUtils.sp2px(i);
    }

    public final void setBmi(float f) {
        this.f24800X00IoxXI = f;
        this.f24809oOXoIIIo.clear();
        this.f24809oOXoIIIo.add("18.4");
        this.f24809oOXoIIIo.add("24.9");
        this.f24809oOXoIIIo.add("29.9");
        oIX0oI();
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public BmiProgressBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ BmiProgressBar(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public BmiProgressBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f24796Oo = true;
        Paint paint = new Paint();
        this.f24793IXxxXO = paint;
        Paint paint2 = new Paint();
        this.f24798Oxx0xo = paint2;
        float oxoX2 = oxoX(10);
        this.f24808oI0IIXIo = oxoX2;
        this.f24799OxxIIOOXO = II0xO0(6);
        Paint paint3 = new Paint();
        this.f24791IIXOooo = paint3;
        Paint paint4 = new Paint();
        this.f24817xoXoI = paint4;
        this.f24797OxI = II0xO0(12) + this.f24799OxxIIOOXO;
        float II0xO02 = II0xO0(2);
        this.f24795O0xOxO = II0xO02;
        this.f24801X0IIOO = this.f24797OxI + II0xO02;
        this.f24802XI0IXoo = II0xO0(4) + this.f24795O0xOxO;
        this.f24809oOXoIIIo = new ArrayList();
        float oxoX3 = oxoX(11);
        this.f24792IO = oxoX3;
        this.f24815xII = this.f24801X0IIOO + II0xO0(12);
        I0Io(context, attributeSet);
        paint.setAntiAlias(this.f24796Oo);
        paint2.setAntiAlias(this.f24796Oo);
        OOxOI.oIX0oI oix0oi = OOxOI.oIX0oI.f1804oIX0oI;
        paint2.setTypeface(oix0oi.oIX0oI(MyTypeface.DIN_COND_BOLD, context));
        paint2.setColor(this.f24816xXxxox0I);
        paint2.setTextSize(oxoX2);
        paint3.setAntiAlias(this.f24796Oo);
        paint3.setTypeface(oix0oi.oIX0oI(MyTypeface.PF_MEDIUM, context));
        paint3.setColor(this.f24816xXxxox0I);
        paint3.setTextSize(oxoX3);
        paint3.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics = paint3.getFontMetrics();
        IIX0o.oO(fontMetrics, "getFontMetrics(...)");
        this.f24813x0o = fontMetrics;
        float f = fontMetrics.bottom;
        this.f24804XOxIOxOx = ((f - fontMetrics.top) / 2) - f;
        paint4.setAntiAlias(this.f24796Oo);
        applySkin();
    }
}
