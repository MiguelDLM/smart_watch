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
import com.blankj.utilcode.util.SizeUtils;
import com.sma.smartv3.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import skin.support.widget.SkinCompatView;

/* loaded from: classes12.dex */
public final class Goal4ProgressBar extends SkinCompatView {

    /* renamed from: IIX0o, reason: collision with root package name */
    public int f24985IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24986IIXOooo;

    /* renamed from: IO, reason: collision with root package name */
    public int f24987IO;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f24988IXxxXO;

    /* renamed from: Io, reason: collision with root package name */
    public int f24989Io;

    /* renamed from: IoOoX, reason: collision with root package name */
    public final float f24990IoOoX;

    /* renamed from: O0xOxO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24991O0xOxO;

    /* renamed from: OI0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24992OI0;

    /* renamed from: Oo, reason: collision with root package name */
    public float f24993Oo;

    /* renamed from: OxI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24994OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public float f24995Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24996OxxIIOOXO;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public float f24997X00IoxXI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f24998X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f24999XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f25000XIxXXX0x0;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Bitmap f25001XOxIOxOx;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public final float f25002Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public int f25003XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25004o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public float f25005oI0IIXIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public float f25006oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public float f25007oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public final float f25008oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public int f25009ooXIXxIX;

    /* renamed from: x0o, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Bitmap f25010x0o;

    /* renamed from: xI, reason: collision with root package name */
    public int f25011xI;

    /* renamed from: xII, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Bitmap f25012xII;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public int f25013xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25014xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public int f25015xxX;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public Goal4ProgressBar(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    private final void II0xO0(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GoalProgressBar);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f24988IXxxXO = obtainStyledAttributes.getBoolean(0, true);
        this.f25015xxX = obtainStyledAttributes.getColor(8, 0);
        this.f25003XxX0x0xxx = obtainStyledAttributes.getColor(7, 0);
        this.f25013xXxxox0I = obtainStyledAttributes.getColor(2, 0);
        this.f24985IIX0o = obtainStyledAttributes.getColor(1, 0);
        this.f25009ooXIXxIX = obtainStyledAttributes.getColor(4, 0);
        this.f25011xI = obtainStyledAttributes.getColor(3, 0);
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
        float f2 = this.f24990IoOoX;
        if (f > f2) {
            f = f2;
        }
        if (f != 0.0f) {
            this.f25006oOXoIIIo = f;
        }
        invalidate();
    }

    public final void X0o0xo(int i, int i2) {
        if (i2 == 0) {
            i2 = 10000;
        }
        float f = (i / i2) * 100;
        float f2 = this.f25008oo0xXOI0I;
        if (f > f2) {
            f = f2;
        }
        if (f != 0.0f) {
            this.f25007oo = f;
        }
        invalidate();
    }

    @Override // skin.support.widget.SkinCompatView, xxoXO.Oxx0IOOO
    public void applySkin() {
        super.applySkin();
        invalidate();
        if (this.f24987IO > 0) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getContext().getResources(), com.sma.smartv3.co_fit.R.drawable.ic_gpb_step);
            int i = this.f24987IO;
            this.f25012xII = Bitmap.createScaledBitmap(decodeResource, i, i, true);
            Bitmap decodeResource2 = BitmapFactory.decodeResource(getContext().getResources(), com.sma.smartv3.co_fit.R.drawable.ic_gpb_dis);
            int i2 = this.f24987IO;
            this.f25010x0o = Bitmap.createScaledBitmap(decodeResource2, i2, i2, true);
            Bitmap decodeResource3 = BitmapFactory.decodeResource(getContext().getResources(), com.sma.smartv3.co_fit.R.drawable.ic_gpb_kcal);
            int i3 = this.f24987IO;
            this.f25001XOxIOxOx = Bitmap.createScaledBitmap(decodeResource3, i3, i3, true);
        }
    }

    public final int getViewWidth() {
        return this.f24989Io;
    }

    @Override // android.view.View
    public void onDraw(@OXOo.OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        canvas.drawArc(this.f24998X0IIOO, 270.0f, 360.0f, false, this.f24986IIXOooo);
        float f = (this.f25007oo / this.f25008oo0xXOI0I) * 360.0f;
        this.f24993Oo = f;
        canvas.drawArc(this.f24998X0IIOO, 270.0f, f, false, this.f24996OxxIIOOXO);
        canvas.drawArc(this.f24999XI0IXoo, 270.0f, 360.0f, false, this.f25004o00);
        float f2 = (this.f25006oOXoIIIo / this.f24990IoOoX) * 360.0f;
        this.f24993Oo = f2;
        canvas.drawArc(this.f24999XI0IXoo, 270.0f, f2, false, this.f25014xoXoI);
        canvas.drawArc(this.f25000XIxXXX0x0, 270.0f, 360.0f, false, this.f24991O0xOxO);
        float f3 = (this.f24997X00IoxXI / this.f25002Xx000oIo) * 360.0f;
        this.f24993Oo = f3;
        canvas.drawArc(this.f25000XIxXXX0x0, 270.0f, f3, false, this.f24994OxI);
        Bitmap bitmap = this.f25012xII;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, this.f24989Io / 2.0f, this.f24998X0IIOO.top - (bitmap.getHeight() / 2), this.f24992OI0);
        }
        Bitmap bitmap2 = this.f25001XOxIOxOx;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, this.f24989Io / 2.0f, this.f24999XI0IXoo.top - (bitmap2.getHeight() / 2), this.f24992OI0);
        }
        Bitmap bitmap3 = this.f25010x0o;
        if (bitmap3 != null) {
            canvas.drawBitmap(bitmap3, this.f24989Io / 2.0f, this.f25000XIxXXX0x0.top - (bitmap3.getHeight() / 2), this.f24992OI0);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        View.MeasureSpec.getSize(i);
        int size = View.MeasureSpec.getSize(i2);
        float f = size;
        float f2 = (f - (this.f25005oI0IIXIo * 4)) / 8;
        this.f24995Oxx0xo = f2;
        setMeasuredDimension((int) (f + f2), size);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f24989Io = i;
        float f = this.f24995Oxx0xo;
        float f2 = f / 2;
        this.f24996OxxIIOOXO.setStrokeWidth(f);
        this.f24986IIXOooo.setStrokeWidth(this.f24995Oxx0xo);
        this.f25014xoXoI.setStrokeWidth(this.f24995Oxx0xo);
        this.f25004o00.setStrokeWidth(this.f24995Oxx0xo);
        this.f24994OxI.setStrokeWidth(this.f24995Oxx0xo);
        this.f24991O0xOxO.setStrokeWidth(this.f24995Oxx0xo);
        this.f24998X0IIOO.set((i - i2) + f2, f2, i - f2, i2 - f2);
        RectF rectF = this.f24999XI0IXoo;
        RectF rectF2 = this.f24998X0IIOO;
        float f3 = rectF2.left;
        float f4 = this.f24995Oxx0xo;
        float f5 = this.f25005oI0IIXIo;
        rectF.set(f3 + f4 + f5, rectF2.top + f4 + f5, (rectF2.right - f4) - f5, (rectF2.bottom - f4) - f5);
        RectF rectF3 = this.f25000XIxXXX0x0;
        RectF rectF4 = this.f24999XI0IXoo;
        float f6 = rectF4.left;
        float f7 = this.f24995Oxx0xo;
        float f8 = this.f25005oI0IIXIo;
        rectF3.set(f6 + f7 + f8, rectF4.top + f7 + f8, (rectF4.right - f7) - f8, (rectF4.bottom - f7) - f8);
        this.f24987IO = (int) (this.f24995Oxx0xo * 0.9d);
        applySkin();
    }

    public final void oxoX(int i, int i2) {
        if (i2 == 0) {
            i2 = 10000;
        }
        float f = (i / i2) * 100;
        float f2 = this.f25002Xx000oIo;
        if (f > f2) {
            f = f2;
        }
        if (f != 0.0f) {
            this.f24997X00IoxXI = f;
        }
        invalidate();
    }

    public final void setViewWidth(int i) {
        this.f24989Io = i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public Goal4ProgressBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ Goal4ProgressBar(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public Goal4ProgressBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f24993Oo = 50.0f;
        this.f24988IXxxXO = true;
        this.f24995Oxx0xo = oIX0oI(10);
        this.f25005oI0IIXIo = oIX0oI(4);
        Paint paint = new Paint();
        this.f24996OxxIIOOXO = paint;
        Paint paint2 = new Paint();
        this.f24986IIXOooo = paint2;
        Paint paint3 = new Paint();
        this.f25014xoXoI = paint3;
        Paint paint4 = new Paint();
        this.f25004o00 = paint4;
        Paint paint5 = new Paint();
        this.f24994OxI = paint5;
        Paint paint6 = new Paint();
        this.f24991O0xOxO = paint6;
        this.f24998X0IIOO = new RectF();
        this.f24999XI0IXoo = new RectF();
        this.f25000XIxXXX0x0 = new RectF();
        this.f25008oo0xXOI0I = 100.0f;
        this.f24990IoOoX = 100.0f;
        this.f25002Xx000oIo = 100.0f;
        this.f24987IO = SizeUtils.dp2px(50.0f);
        this.f24992OI0 = new Paint();
        II0xO0(context, attributeSet);
        paint.setAntiAlias(this.f24988IXxxXO);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        paint.setStrokeWidth(this.f24995Oxx0xo);
        paint.setColor(this.f25015xxX);
        paint2.setAntiAlias(this.f24988IXxxXO);
        paint2.setStyle(style);
        paint2.setStrokeCap(cap);
        paint2.setStrokeWidth(this.f24995Oxx0xo);
        paint2.setColor(this.f25003XxX0x0xxx);
        paint3.setAntiAlias(this.f24988IXxxXO);
        paint3.setStyle(style);
        paint3.setStrokeCap(cap);
        paint3.setStrokeWidth(this.f24995Oxx0xo);
        paint3.setColor(this.f25013xXxxox0I);
        paint4.setAntiAlias(this.f24988IXxxXO);
        paint4.setStyle(style);
        paint4.setStrokeCap(cap);
        paint4.setStrokeWidth(this.f24995Oxx0xo);
        paint4.setColor(this.f24985IIX0o);
        paint5.setAntiAlias(this.f24988IXxxXO);
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        paint5.setStrokeWidth(this.f24995Oxx0xo);
        paint5.setColor(this.f25009ooXIXxIX);
        paint6.setAntiAlias(this.f24988IXxxXO);
        paint6.setStyle(style);
        paint6.setStrokeCap(cap);
        paint6.setStrokeWidth(this.f24995Oxx0xo);
        paint6.setColor(this.f25011xI);
        applySkin();
    }
}
