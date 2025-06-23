package com.sma.smartv3.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.sma.smartv3.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import skin.support.widget.SkinCompatView;

/* loaded from: classes12.dex */
public final class Goal2ProgressBar extends SkinCompatView {

    /* renamed from: IIX0o, reason: collision with root package name */
    public int f24927IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24928IIXOooo;

    /* renamed from: IO, reason: collision with root package name */
    public float f24929IO;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f24930IXxxXO;

    /* renamed from: Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24931Io;

    /* renamed from: IoOoX, reason: collision with root package name */
    public final float f24932IoOoX;

    /* renamed from: O0xOxO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24933O0xOxO;

    /* renamed from: OI0, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Bitmap f24934OI0;

    /* renamed from: Oo, reason: collision with root package name */
    public float f24935Oo;

    /* renamed from: OxI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24936OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public float f24937Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24938OxxIIOOXO;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public float f24939X00IoxXI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f24940X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f24941XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f24942XIxXXX0x0;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Bitmap f24943XOxIOxOx;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public final float f24944Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public int f24945XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24946o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public float f24947oI0IIXIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public float f24948oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public float f24949oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public final float f24950oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public int f24951ooXIXxIX;

    /* renamed from: x0o, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Bitmap f24952x0o;

    /* renamed from: xI, reason: collision with root package name */
    public int f24953xI;

    /* renamed from: xII, reason: collision with root package name */
    public int f24954xII;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public int f24955xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24956xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public int f24957xxX;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public Goal2ProgressBar(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    private final void II0xO0(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GoalProgressBar);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f24930IXxxXO = obtainStyledAttributes.getBoolean(0, true);
        this.f24957xxX = obtainStyledAttributes.getColor(8, 0);
        this.f24945XxX0x0xxx = obtainStyledAttributes.getColor(7, 0);
        this.f24955xXxxox0I = obtainStyledAttributes.getColor(2, 0);
        this.f24927IIX0o = obtainStyledAttributes.getColor(1, 0);
        this.f24951ooXIXxIX = obtainStyledAttributes.getColor(4, 0);
        this.f24953xI = obtainStyledAttributes.getColor(3, 0);
        this.f24929IO = obtainStyledAttributes.getDimension(9, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private final float oIX0oI(int i) {
        return SizeUtils.dp2px(i);
    }

    public final void I0Io(@OXOo.OOXIXo Canvas canvas, @OXOo.OOXIXo Bitmap it, float f, float f2) {
        IIX0o.x0xO0oo(canvas, "canvas");
        IIX0o.x0xO0oo(it, "it");
        if (this.f24929IO > 0.0f) {
            canvas.drawBitmap(ImageUtils.rotate(it, 90, (it.getWidth() / 2) + f2, (it.getHeight() / 2) + f), f2, f, this.f24931Io);
        } else {
            canvas.drawBitmap(it, f2, f, this.f24931Io);
        }
    }

    public final void X0o0xo(int i, int i2) {
        if (i2 == 0) {
            i2 = 10000;
        }
        float f = (i / i2) * 100;
        float f2 = this.f24944Xx000oIo;
        if (f > f2) {
            f = f2;
        }
        if (f != 0.0f) {
            this.f24939X00IoxXI = f;
        }
        invalidate();
    }

    public final void XO(int i, int i2) {
        if (i2 == 0) {
            i2 = 10000;
        }
        float f = (i / i2) * 100;
        float f2 = this.f24950oo0xXOI0I;
        if (f > f2) {
            f = f2;
        }
        if (f != 0.0f) {
            this.f24949oo = f;
        }
        invalidate();
    }

    @Override // skin.support.widget.SkinCompatView, xxoXO.Oxx0IOOO
    public void applySkin() {
        super.applySkin();
        invalidate();
        if (this.f24954xII > 0) {
            this.f24952x0o = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), com.sma.smartv3.co_fit.R.drawable.ic_gpb_step), this.f24954xII + SizeUtils.dp2px(1.0f), this.f24954xII + SizeUtils.dp2px(1.0f), true);
            Bitmap decodeResource = BitmapFactory.decodeResource(getContext().getResources(), com.sma.smartv3.co_fit.R.drawable.ic_gpb_dis);
            int i = this.f24954xII;
            this.f24943XOxIOxOx = Bitmap.createScaledBitmap(decodeResource, i, i, true);
            Bitmap decodeResource2 = BitmapFactory.decodeResource(getContext().getResources(), com.sma.smartv3.co_fit.R.drawable.ic_gpb_kcal);
            int i2 = this.f24954xII;
            this.f24934OI0 = Bitmap.createScaledBitmap(decodeResource2, i2, i2, true);
        }
    }

    @Override // android.view.View
    public void onDraw(@OXOo.OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        canvas.drawArc(this.f24940X0IIOO, 270.0f, 180.0f, false, this.f24928IIXOooo);
        float f = (this.f24949oo / this.f24950oo0xXOI0I) * 180.0f;
        this.f24935Oo = f;
        canvas.drawArc(this.f24940X0IIOO, 270.0f, f, false, this.f24938OxxIIOOXO);
        canvas.drawArc(this.f24941XI0IXoo, 270.0f, 180.0f, false, this.f24946o00);
        float f2 = (this.f24948oOXoIIIo / this.f24932IoOoX) * 180.0f;
        this.f24935Oo = f2;
        canvas.drawArc(this.f24941XI0IXoo, 270.0f, f2, false, this.f24956xoXoI);
        canvas.drawArc(this.f24942XIxXXX0x0, 270.0f, 180.0f, false, this.f24933O0xOxO);
        float f3 = (this.f24939X00IoxXI / this.f24944Xx000oIo) * 180.0f;
        this.f24935Oo = f3;
        canvas.drawArc(this.f24942XIxXXX0x0, 270.0f, f3, false, this.f24936OxI);
        Bitmap bitmap = this.f24952x0o;
        if (bitmap != null) {
            I0Io(canvas, bitmap, this.f24940X0IIOO.top - (bitmap.getHeight() / 2), ((this.f24940X0IIOO.width() / 2) - Math.abs(this.f24940X0IIOO.left)) - (bitmap.getWidth() / 2));
        }
        Bitmap bitmap2 = this.f24943XOxIOxOx;
        if (bitmap2 != null) {
            I0Io(canvas, bitmap2, this.f24941XI0IXoo.top - (bitmap2.getHeight() / 2), ((this.f24941XI0IXoo.width() / 2) - Math.abs(this.f24941XI0IXoo.left)) - (bitmap2.getWidth() / 2));
        }
        Bitmap bitmap3 = this.f24934OI0;
        if (bitmap3 != null) {
            I0Io(canvas, bitmap3, this.f24942XIxXXX0x0.top - (bitmap3.getHeight() / 2), ((this.f24942XIxXXX0x0.width() / 2) - Math.abs(this.f24942XIxXXX0x0.left)) - (bitmap3.getWidth() / 2));
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        View.MeasureSpec.getSize(i);
        int size = View.MeasureSpec.getSize(i2);
        float f = size;
        float f2 = (f - (this.f24947oI0IIXIo * 4)) / 8;
        this.f24937Oxx0xo = f2;
        setMeasuredDimension((int) ((f + f2) / 2), size);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = this.f24937Oxx0xo;
        float f2 = f / 2;
        this.f24938OxxIIOOXO.setStrokeWidth(f);
        this.f24928IIXOooo.setStrokeWidth(this.f24937Oxx0xo);
        this.f24956xoXoI.setStrokeWidth(this.f24937Oxx0xo);
        this.f24946o00.setStrokeWidth(this.f24937Oxx0xo);
        this.f24936OxI.setStrokeWidth(this.f24937Oxx0xo);
        this.f24933O0xOxO.setStrokeWidth(this.f24937Oxx0xo);
        this.f24940X0IIOO.set((i - i2) + f2, f2, i - f2, i2 - f2);
        RectF rectF = this.f24941XI0IXoo;
        RectF rectF2 = this.f24940X0IIOO;
        float f3 = rectF2.left;
        float f4 = this.f24937Oxx0xo;
        float f5 = this.f24947oI0IIXIo;
        rectF.set(f3 + f4 + f5, rectF2.top + f4 + f5, (rectF2.right - f4) - f5, (rectF2.bottom - f4) - f5);
        RectF rectF3 = this.f24942XIxXXX0x0;
        RectF rectF4 = this.f24941XI0IXoo;
        float f6 = rectF4.left;
        float f7 = this.f24937Oxx0xo;
        float f8 = this.f24947oI0IIXIo;
        rectF3.set(f6 + f7 + f8, rectF4.top + f7 + f8, (rectF4.right - f7) - f8, (rectF4.bottom - f7) - f8);
        this.f24954xII = (int) (this.f24937Oxx0xo * 0.6d);
        applySkin();
    }

    public final void oxoX(int i, int i2) {
        if (i2 == 0) {
            i2 = 10000;
        }
        float f = (i / i2) * 100;
        float f2 = this.f24932IoOoX;
        if (f > f2) {
            f = f2;
        }
        if (f != 0.0f) {
            this.f24948oOXoIIIo = f;
        }
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public Goal2ProgressBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ Goal2ProgressBar(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public Goal2ProgressBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f24935Oo = 50.0f;
        this.f24930IXxxXO = true;
        this.f24937Oxx0xo = oIX0oI(10);
        this.f24947oI0IIXIo = oIX0oI(4);
        Paint paint = new Paint();
        this.f24938OxxIIOOXO = paint;
        Paint paint2 = new Paint();
        this.f24928IIXOooo = paint2;
        Paint paint3 = new Paint();
        this.f24956xoXoI = paint3;
        Paint paint4 = new Paint();
        this.f24946o00 = paint4;
        Paint paint5 = new Paint();
        this.f24936OxI = paint5;
        Paint paint6 = new Paint();
        this.f24933O0xOxO = paint6;
        this.f24940X0IIOO = new RectF();
        this.f24941XI0IXoo = new RectF();
        this.f24942XIxXXX0x0 = new RectF();
        this.f24950oo0xXOI0I = 100.0f;
        this.f24949oo = 1.0f;
        this.f24932IoOoX = 100.0f;
        this.f24948oOXoIIIo = 1.0f;
        this.f24944Xx000oIo = 100.0f;
        this.f24939X00IoxXI = 1.0f;
        this.f24954xII = SizeUtils.dp2px(20.0f);
        this.f24931Io = new Paint();
        II0xO0(context, attributeSet);
        paint.setAntiAlias(this.f24930IXxxXO);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        paint.setStrokeWidth(this.f24937Oxx0xo);
        paint.setColor(this.f24957xxX);
        paint2.setAntiAlias(this.f24930IXxxXO);
        paint2.setStyle(style);
        paint2.setStrokeCap(cap);
        paint2.setStrokeWidth(this.f24937Oxx0xo);
        paint2.setColor(this.f24945XxX0x0xxx);
        paint3.setAntiAlias(this.f24930IXxxXO);
        paint3.setStyle(style);
        paint3.setStrokeCap(cap);
        paint3.setStrokeWidth(this.f24937Oxx0xo);
        paint3.setColor(this.f24955xXxxox0I);
        paint4.setAntiAlias(this.f24930IXxxXO);
        paint4.setStyle(style);
        paint4.setStrokeCap(cap);
        paint4.setStrokeWidth(this.f24937Oxx0xo);
        paint4.setColor(this.f24927IIX0o);
        paint5.setAntiAlias(this.f24930IXxxXO);
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        paint5.setStrokeWidth(this.f24937Oxx0xo);
        paint5.setColor(this.f24951ooXIXxIX);
        paint6.setAntiAlias(this.f24930IXxxXO);
        paint6.setStyle(style);
        paint6.setStrokeCap(cap);
        paint6.setStrokeWidth(this.f24937Oxx0xo);
        paint6.setColor(this.f24953xI);
        applySkin();
    }
}
