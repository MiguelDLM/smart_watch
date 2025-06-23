package com.sma.smartv3.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.blankj.utilcode.util.SizeUtils;
import com.sma.smartv3.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class PaceProgressBarV2 extends View {

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f25120IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f25121IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public float f25122O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public int f25123Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public float f25124OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25125Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25126OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public int f25127X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f25128XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public int f25129XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public int f25130XO;

    /* renamed from: o00, reason: collision with root package name */
    public float f25131o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25132oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f25133xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public final float f25134xxX;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public PaceProgressBarV2(@OXOo.OOXIXo Context context, @OXOo.OOXIXo AttributeSet attrs) {
        this(context, attrs, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(attrs, "attrs");
    }

    public final void I0Io(float f, @OXOo.OOXIXo String str, int i) {
        IIX0o.x0xO0oo(str, "str");
        if (f < 0.0f) {
            f = 0.0f;
        } else if (0.0f < f && f < 0.25d) {
            f = 0.25f;
        } else if (f > 1.0f) {
            f = 1.0f;
        } else if (f > 0.9d) {
            f = (f / 10) + 0.9f;
        }
        this.f25124OxI = f;
        this.f25122O0xOxO = 0.0f;
        this.f25120IIXOooo = str;
        this.f25133xoXoI = i;
        invalidate();
    }

    public final void II0xO0(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PaceProgressBar);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f25121IXxxXO = obtainStyledAttributes.getBoolean(0, true);
        this.f25127X0IIOO = obtainStyledAttributes.getColor(1, -1);
        this.f25129XIxXXX0x0 = obtainStyledAttributes.getColor(3, -256);
        this.f25128XI0IXoo = obtainStyledAttributes.getColor(2, -256);
        obtainStyledAttributes.recycle();
    }

    public final float oIX0oI(int i) {
        return SizeUtils.dp2px(i);
    }

    @Override // android.view.View
    public void onDraw(@OXOo.OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        if (this.f25131o00 == 0.0f) {
            this.f25131o00 = this.f25123Oo / 2.0f;
        }
        float f = this.f25131o00;
        canvas.drawCircle(f, f, f, this.f25125Oxx0xo);
        float f2 = this.f25131o00;
        canvas.drawRect(f2, 0.0f, this.f25130XO - f2, this.f25123Oo, this.f25125Oxx0xo);
        float f3 = this.f25130XO;
        float f4 = this.f25131o00;
        canvas.drawCircle(f3 - f4, f4, f4, this.f25125Oxx0xo);
        if (this.f25122O0xOxO == 0.0f) {
            this.f25122O0xOxO = this.f25124OxI * this.f25130XO;
        }
        if (this.f25120IIXOooo.length() > 0) {
            if (this.f25133xoXoI == 0) {
                this.f25132oI0IIXIo.setColor(this.f25129XIxXXX0x0);
            } else {
                int color = this.f25132oI0IIXIo.getColor();
                int i = this.f25128XI0IXoo;
                if (color != i) {
                    this.f25132oI0IIXIo.setColor(i);
                }
            }
            float f5 = this.f25131o00;
            canvas.drawCircle(f5, f5, f5, this.f25132oI0IIXIo);
            float f6 = this.f25131o00;
            canvas.drawRect(f6, 0.0f, this.f25122O0xOxO - f6, this.f25123Oo, this.f25132oI0IIXIo);
            float f7 = this.f25122O0xOxO;
            float f8 = this.f25131o00;
            canvas.drawCircle(f7 - f8, f8, f8, this.f25132oI0IIXIo);
            String str = this.f25120IIXOooo;
            canvas.drawText(str, (this.f25122O0xOxO - this.f25131o00) - this.f25126OxxIIOOXO.measureText(str), this.f25123Oo - oIX0oI(4), this.f25126OxxIIOOXO);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f25130XO = View.MeasureSpec.getSize(i);
        int size = View.MeasureSpec.getSize(i2);
        this.f25123Oo = size;
        this.f25131o00 = size / 2.0f;
    }

    public /* synthetic */ PaceProgressBarV2(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public PaceProgressBarV2(@OXOo.OOXIXo Context context, @OXOo.OOXIXo AttributeSet attrs, int i) {
        super(context, attrs, i);
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(attrs, "attrs");
        this.f25121IXxxXO = true;
        Paint paint = new Paint();
        this.f25125Oxx0xo = paint;
        Paint paint2 = new Paint();
        this.f25132oI0IIXIo = paint2;
        Paint paint3 = new Paint();
        this.f25126OxxIIOOXO = paint3;
        this.f25120IIXOooo = "";
        float oIX0oI2 = oIX0oI(12);
        this.f25134xxX = oIX0oI2;
        II0xO0(context, attrs);
        paint.setAntiAlias(this.f25121IXxxXO);
        paint.setColor(this.f25127X0IIOO);
        paint2.setAntiAlias(this.f25121IXxxXO);
        paint2.setColor(this.f25128XI0IXoo);
        paint3.setAntiAlias(this.f25121IXxxXO);
        paint3.setColor(-1);
        paint3.setTextSize(oIX0oI2);
    }
}
