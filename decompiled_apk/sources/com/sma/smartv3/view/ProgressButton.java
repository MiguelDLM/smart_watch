package com.sma.smartv3.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.text.MyTypeface;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.oxxXoxO;

/* loaded from: classes12.dex */
public final class ProgressButton extends View {

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Xfermode f25145IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25146IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public int f25147O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public int f25148Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public int f25149OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f25150Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f25151OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f25152X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public float f25153XI0IXoo;

    /* renamed from: XO, reason: collision with root package name */
    public int f25154XO;

    /* renamed from: o00, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25155o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f25156oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public final float f25157xoXoI;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public ProgressButton(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public static /* synthetic */ void X0o0xo(ProgressButton progressButton, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        progressButton.I0Io(i, z);
    }

    public static /* synthetic */ void XO(ProgressButton progressButton, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        progressButton.oxoX(str, z);
    }

    private final int getBackgroundColor() {
        if (ProjectManager.f19822oIX0oI.IxX00()) {
            return R.color.colorAccent;
        }
        return R.color.view_page_secondary_bg;
    }

    private final int getProgressColor() {
        if (ProjectManager.f19822oIX0oI.IxX00()) {
            return R.color.line_color;
        }
        return R.color.colorAccent;
    }

    private final int getTextColor() {
        if (ProjectManager.f19822oIX0oI.IxX00()) {
            return R.color.white;
        }
        return R.color.line_color;
    }

    public final void I0Io(int i, boolean z) {
        if (z) {
            this.f25155o00.setColor(this.f25147O0xOxO);
            this.f25153XI0IXoo = 1.0f;
        } else {
            this.f25153XI0IXoo = 0.0f;
            if (ProjectManager.f19822oIX0oI.IxX00()) {
                this.f25155o00.setColor(this.f25147O0xOxO);
            } else {
                this.f25155o00.setColor(this.f25149OxI);
            }
        }
        String string = getContext().getString(i);
        IIX0o.oO(string, "getString(...)");
        this.f25152X0IIOO = string;
        invalidate();
    }

    public final void II0xO0(@OXOo.OOXIXo String text, float f) {
        IIX0o.x0xO0oo(text, "text");
        this.f25153XI0IXoo = f;
        this.f25152X0IIOO = text;
        this.f25155o00.setColor(this.f25147O0xOxO);
        invalidate();
    }

    public final void oIX0oI(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.sma.smartv3.R.styleable.ProgressButton);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        if (obtainStyledAttributes.hasValue(1)) {
            this.f25156oI0IIXIo = obtainStyledAttributes.getColor(1, this.f25156oI0IIXIo);
        }
        if (obtainStyledAttributes.hasValue(0)) {
            this.f25151OxxIIOOXO = obtainStyledAttributes.getColor(0, this.f25151OxxIIOOXO);
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.f25149OxI = obtainStyledAttributes.getColor(3, this.f25149OxI);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.f25147O0xOxO = obtainStyledAttributes.getColor(2, this.f25147O0xOxO);
        }
    }

    @Override // android.view.View
    public void onDraw(@OXOo.OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        int saveLayer = canvas.saveLayer(null, null, 31);
        Paint paint = this.f25146IXxxXO;
        paint.setXfermode(null);
        paint.setColor(this.f25151OxxIIOOXO);
        RectF rectF = this.f25150Oxx0xo;
        float f = this.f25157xoXoI;
        rectF.set(f, f, this.f25154XO - f, this.f25148Oo - f);
        RectF rectF2 = this.f25150Oxx0xo;
        int i = this.f25148Oo;
        canvas.drawRoundRect(rectF2, i / 2.0f, i / 2.0f, this.f25146IXxxXO);
        Paint paint2 = this.f25146IXxxXO;
        paint2.setXfermode(this.f25145IIXOooo);
        paint2.setColor(this.f25156oI0IIXIo);
        this.f25150Oxx0xo.set(0.0f, 0.0f, this.f25154XO * this.f25153XI0IXoo, this.f25148Oo);
        canvas.drawRect(this.f25150Oxx0xo, this.f25146IXxxXO);
        canvas.restoreToCount(saveLayer);
        canvas.drawText(this.f25152X0IIOO, this.f25154XO / 2.0f, (this.f25148Oo / 2.0f) + (this.f25155o00.getTextSize() / 2.5f), this.f25155o00);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f25154XO = i;
        this.f25148Oo = i2;
    }

    public final void oxoX(@OXOo.OOXIXo String string, boolean z) {
        IIX0o.x0xO0oo(string, "string");
        if (z) {
            this.f25155o00.setColor(this.f25147O0xOxO);
            this.f25153XI0IXoo = 1.0f;
        } else {
            this.f25153XI0IXoo = 0.0f;
            if (ProjectManager.f19822oIX0oI.IxX00()) {
                this.f25155o00.setColor(this.f25147O0xOxO);
            } else {
                this.f25155o00.setColor(this.f25149OxI);
            }
        }
        this.f25152X0IIOO = string;
        invalidate();
    }

    public final void setProgress(float f) {
        this.f25153XI0IXoo = f;
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("%d%%", Arrays.copyOf(new Object[]{Integer.valueOf((int) (f * 100))}, 1));
        IIX0o.oO(format, "format(...)");
        this.f25152X0IIOO = format;
        this.f25155o00.setColor(this.f25147O0xOxO);
        invalidate();
    }

    public final void setProgressDecimalPlaces(float f) {
        this.f25153XI0IXoo = f;
        StringBuilder sb = new StringBuilder();
        String format = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f * 100)}, 1));
        IIX0o.oO(format, "format(...)");
        sb.append(format);
        sb.append(org.apache.log4j.helpers.x0XOIxOo.f33309xxIXOIIO);
        this.f25152X0IIOO = sb.toString();
        this.f25155o00.setColor(this.f25147O0xOxO);
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public ProgressButton(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ ProgressButton(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public ProgressButton(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        Paint paint = new Paint();
        this.f25146IXxxXO = paint;
        this.f25150Oxx0xo = new RectF();
        this.f25156oI0IIXIo = oIxOXo.oxoX.I0Io(context, getProgressColor());
        this.f25151OxxIIOOXO = oIxOXo.oxoX.I0Io(context, getBackgroundColor());
        this.f25145IIXOooo = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.f25157xoXoI = SizeUtils.dp2px(1.0f);
        Paint paint2 = new Paint();
        this.f25155o00 = paint2;
        this.f25149OxI = oIxOXo.oxoX.I0Io(context, getProgressColor());
        this.f25147O0xOxO = oIxOXo.oxoX.I0Io(context, getTextColor());
        this.f25152X0IIOO = "";
        oIxOXo.oxoX.f31821II0XooXoX = isInEditMode();
        oIX0oI(context, attributeSet);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        paint2.setTextSize(ConvertUtils.dp2px(13.0f));
        paint2.setTypeface(OOxOI.oIX0oI.f1804oIX0oI.oIX0oI(MyTypeface.PF_MEDIUM, context));
        paint2.setTextAlign(Paint.Align.CENTER);
    }
}
