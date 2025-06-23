package com.sma.smartv3.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.blankj.utilcode.util.SizeUtils;
import com.sma.smartv3.R;
import com.sma.smartv3.view.text.MyTypeface;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class DfuProgress extends View {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public final float f24880IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24881IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public float f24882Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public float f24883OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f24884Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f24885OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public float f24886XO;

    /* renamed from: o00, reason: collision with root package name */
    public boolean f24887o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f24888oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public final float f24889xoXoI;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public DfuProgress(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public final void oIX0oI(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DfuProgress);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f24887o00 = obtainStyledAttributes.getBoolean(2, this.f24887o00);
        if (obtainStyledAttributes.hasValue(1)) {
            this.f24885OxxIIOOXO = obtainStyledAttributes.getColor(1, this.f24885OxxIIOOXO);
        }
        if (obtainStyledAttributes.hasValue(0)) {
            this.f24888oI0IIXIo = obtainStyledAttributes.getColor(0, this.f24888oI0IIXIo);
        }
    }

    @Override // android.view.View
    public void onDraw(@OXOo.OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        Paint paint = this.f24881IXxxXO;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f24880IIXOooo);
        paint.setColor(this.f24888oI0IIXIo);
        float f = this.f24882Oo;
        float f2 = 2;
        canvas.drawCircle(f, f, f - (this.f24880IIXOooo / f2), this.f24881IXxxXO);
        canvas.save();
        float f3 = this.f24882Oo;
        canvas.rotate(-90.0f, f3, f3);
        this.f24881IXxxXO.setColor(this.f24885OxxIIOOXO);
        RectF rectF = this.f24884Oxx0xo;
        float f4 = this.f24880IIXOooo;
        float f5 = this.f24886XO;
        rectF.set(f4 / f2, f4 / f2, f5 - (f4 / f2), f5 - (f4 / f2));
        canvas.drawArc(this.f24884Oxx0xo, 0.0f, this.f24883OxI * 360, false, this.f24881IXxxXO);
        canvas.restore();
        if (this.f24887o00) {
            this.f24881IXxxXO.setStrokeWidth(this.f24889xoXoI);
            float f6 = this.f24882Oo;
            canvas.drawCircle(f6, f6, f6 - (this.f24880IIXOooo * 2.0f), this.f24881IXxxXO);
        }
        this.f24881IXxxXO.setStyle(Paint.Style.FILL);
        StringBuilder sb = new StringBuilder();
        sb.append((int) (this.f24883OxI * 100));
        sb.append(org.apache.log4j.helpers.x0XOIxOo.f33309xxIXOIIO);
        String sb2 = sb.toString();
        float f7 = this.f24882Oo;
        canvas.drawText(sb2, f7, (this.f24881IXxxXO.getTextSize() / f2) + f7, this.f24881IXxxXO);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i;
        this.f24886XO = f;
        float f2 = f / 2;
        this.f24882Oo = f2;
        this.f24881IXxxXO.setTextSize(f2 / 4);
    }

    public final void setProgress(float f) {
        this.f24883OxI = f;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public DfuProgress(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ DfuProgress(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public DfuProgress(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        Paint paint = new Paint();
        this.f24881IXxxXO = paint;
        this.f24884Oxx0xo = new RectF();
        this.f24888oI0IIXIo = ContextCompat.getColor(context, com.sma.smartv3.co_fit.R.color.line_color);
        this.f24885OxxIIOOXO = ContextCompat.getColor(context, com.sma.smartv3.co_fit.R.color.colorAccent);
        this.f24880IIXOooo = SizeUtils.dp2px(12.0f);
        this.f24889xoXoI = SizeUtils.dp2px(1.0f);
        this.f24887o00 = true;
        oIX0oI(context, attributeSet);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setTypeface(OOxOI.oIX0oI.f1804oIX0oI.oIX0oI(MyTypeface.PF_MEDIUM, context));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }
}
