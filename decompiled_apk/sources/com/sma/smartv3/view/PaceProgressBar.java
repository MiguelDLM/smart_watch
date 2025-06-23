package com.sma.smartv3.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.sma.smartv3.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class PaceProgressBar extends View {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public float f25110IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f25111IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public int f25112Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public int f25113OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25114Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public float f25115OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public int f25116XO;

    /* renamed from: o00, reason: collision with root package name */
    public int f25117o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25118oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public float f25119xoXoI;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public PaceProgressBar(@OXOo.OOXIXo Context context, @OXOo.OOXIXo AttributeSet attrs) {
        this(context, attrs, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(attrs, "attrs");
    }

    public final void oIX0oI(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PaceProgressBar);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f25111IXxxXO = obtainStyledAttributes.getBoolean(0, true);
        this.f25117o00 = obtainStyledAttributes.getColor(1, -1);
        this.f25113OxI = obtainStyledAttributes.getColor(2, -256);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onDraw(@OXOo.OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        canvas.drawRect(0.0f, 0.0f, this.f25116XO - this.f25115OxxIIOOXO, this.f25112Oo, this.f25114Oxx0xo);
        float f = this.f25116XO;
        float f2 = this.f25115OxxIIOOXO;
        canvas.drawCircle(f - f2, f2, f2, this.f25114Oxx0xo);
        if (this.f25119xoXoI == 0.0f) {
            this.f25119xoXoI = this.f25110IIXOooo * this.f25116XO;
        }
        canvas.drawRect(0.0f, 0.0f, this.f25119xoXoI - this.f25115OxxIIOOXO, this.f25112Oo, this.f25118oI0IIXIo);
        float f3 = this.f25119xoXoI;
        float f4 = this.f25115OxxIIOOXO;
        canvas.drawCircle(f3 - f4, f4, f4, this.f25118oI0IIXIo);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f25116XO = View.MeasureSpec.getSize(i);
        int size = View.MeasureSpec.getSize(i2);
        this.f25112Oo = size;
        this.f25115OxxIIOOXO = size / 2.0f;
    }

    public final void setPB(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        this.f25110IIXOooo = f;
        this.f25119xoXoI = 0.0f;
        invalidate();
    }

    public /* synthetic */ PaceProgressBar(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public PaceProgressBar(@OXOo.OOXIXo Context context, @OXOo.OOXIXo AttributeSet attrs, int i) {
        super(context, attrs, i);
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(attrs, "attrs");
        this.f25111IXxxXO = true;
        Paint paint = new Paint();
        this.f25114Oxx0xo = paint;
        Paint paint2 = new Paint();
        this.f25118oI0IIXIo = paint2;
        oIX0oI(context, attrs);
        paint.setAntiAlias(this.f25111IXxxXO);
        paint.setColor(this.f25117o00);
        paint2.setAntiAlias(this.f25111IXxxXO);
        paint2.setColor(this.f25113OxI);
    }
}
