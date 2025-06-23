package com.sma.smartv3.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.text.MyTypeface;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.oxxXoxO;

/* loaded from: classes12.dex */
public final class ProgressButtonV2 extends View {

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Xfermode f25158IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25159IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public int f25160O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public int f25161Oo;

    /* renamed from: OxI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25162OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f25163Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f25164OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public int f25165X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f25166XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f25167XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public int f25168XO;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f25169XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25170o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f25171oI0IIXIo;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public int f25172xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    public final float f25173xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public float f25174xxX;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public ProgressButtonV2(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public static /* synthetic */ void II0xO0(ProgressButtonV2 progressButtonV2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = R.drawable.limited_time_icon;
        }
        progressButtonV2.setDrawablesLift(i);
    }

    public static /* synthetic */ void Oxx0IOOO(ProgressButtonV2 progressButtonV2, String str, boolean z, int i, boolean z2, int i2, String str2, int i3, Object obj) {
        boolean z3;
        int i4;
        boolean z4;
        String str3;
        int i5 = 0;
        if ((i3 & 2) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i3 & 4) != 0) {
            i4 = 0;
        } else {
            i4 = i;
        }
        if ((i3 & 8) != 0) {
            z4 = true;
        } else {
            z4 = z2;
        }
        if ((i3 & 16) == 0) {
            i5 = i2;
        }
        if ((i3 & 32) != 0) {
            str3 = "";
        } else {
            str3 = str2;
        }
        progressButtonV2.X0o0xo(str, z3, i4, z4, i5, str3);
    }

    public static /* synthetic */ void XO(ProgressButtonV2 progressButtonV2, int i, boolean z, int i2, boolean z2, int i3, String str, int i4, Object obj) {
        boolean z3;
        int i5;
        boolean z4;
        String str2;
        int i6 = 0;
        if ((i4 & 2) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i4 & 4) != 0) {
            i5 = 0;
        } else {
            i5 = i2;
        }
        if ((i4 & 8) != 0) {
            z4 = true;
        } else {
            z4 = z2;
        }
        if ((i4 & 16) == 0) {
            i6 = i3;
        }
        if ((i4 & 32) != 0) {
            str2 = "";
        } else {
            str2 = str;
        }
        progressButtonV2.oxoX(i, z3, i5, z4, i6, str2);
    }

    public final void I0Io(@OXOo.OOXIXo String text, float f) {
        IIX0o.x0xO0oo(text, "text");
        this.f25174xxX = f;
        this.f25167XIxXXX0x0 = text;
        this.f25170o00.setColor(this.f25165X0IIOO);
        invalidate();
    }

    public final void X0o0xo(@OXOo.OOXIXo String text, boolean z, int i, boolean z2, int i2, @OXOo.OOXIXo String originalPrice) {
        int i3;
        IIX0o.x0xO0oo(text, "text");
        IIX0o.x0xO0oo(originalPrice, "originalPrice");
        if (z2) {
            this.f25172xXxxox0I = 0;
        }
        if (z) {
            this.f25170o00.setColor(this.f25165X0IIOO);
            this.f25174xxX = 1.0f;
        } else {
            this.f25174xxX = 0.0f;
            Paint paint = this.f25170o00;
            if (i2 != 0) {
                i3 = oIxOXo.oxoX.I0Io(getContext(), i2);
            } else if (i == 1) {
                i3 = this.f25166XI0IXoo;
            } else {
                i3 = this.f25160O0xOxO;
            }
            paint.setColor(i3);
        }
        this.f25167XIxXXX0x0 = text;
        this.f25169XxX0x0xxx = originalPrice;
        invalidate();
    }

    public final int getMDrawablesLiftId() {
        return this.f25172xXxxox0I;
    }

    @OXOo.OOXIXo
    public final String getMOriginalPrice() {
        return this.f25169XxX0x0xxx;
    }

    public final void oIX0oI(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.sma.smartv3.R.styleable.ProgressButton);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        if (obtainStyledAttributes.hasValue(1)) {
            this.f25171oI0IIXIo = obtainStyledAttributes.getColor(1, this.f25171oI0IIXIo);
        }
        if (obtainStyledAttributes.hasValue(0)) {
            this.f25164OxxIIOOXO = obtainStyledAttributes.getColor(0, this.f25164OxxIIOOXO);
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.f25160O0xOxO = obtainStyledAttributes.getColor(3, this.f25160O0xOxO);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.f25165X0IIOO = obtainStyledAttributes.getColor(2, this.f25165X0IIOO);
        }
    }

    @Override // android.view.View
    public void onDraw(@OXOo.OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        int saveLayer = canvas.saveLayer(null, null, 31);
        Paint paint = this.f25159IXxxXO;
        paint.setXfermode(null);
        paint.setColor(this.f25164OxxIIOOXO);
        RectF rectF = this.f25163Oxx0xo;
        float f = this.f25173xoXoI;
        rectF.set(f, f, this.f25168XO - f, this.f25161Oo - f);
        RectF rectF2 = this.f25163Oxx0xo;
        int i = this.f25161Oo;
        canvas.drawRoundRect(rectF2, i / 2.0f, i / 2.0f, this.f25159IXxxXO);
        Paint paint2 = this.f25159IXxxXO;
        paint2.setXfermode(this.f25158IIXOooo);
        paint2.setColor(this.f25171oI0IIXIo);
        this.f25163Oxx0xo.set(0.0f, 0.0f, this.f25168XO * this.f25174xxX, this.f25161Oo);
        canvas.drawRect(this.f25163Oxx0xo, this.f25159IXxxXO);
        canvas.restoreToCount(saveLayer);
        if (this.f25172xXxxox0I != 0) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), this.f25172xXxxox0I);
            float measureText = this.f25170o00.measureText(this.f25167XIxXXX0x0);
            float width = decodeResource.getWidth() + measureText;
            canvas.drawBitmap(decodeResource, (this.f25168XO / 2) - (width / 2.0f), (this.f25161Oo / 2.0f) - (decodeResource.getHeight() / 2), this.f25170o00);
            canvas.drawText(this.f25167XIxXXX0x0, (this.f25168XO / 2.0f) + (decodeResource.getWidth() / 2.0f), (this.f25161Oo / 2.0f) + (this.f25170o00.getTextSize() / 2.5f), this.f25170o00);
            if (this.f25169XxX0x0xxx.length() > 0) {
                canvas.drawText(this.f25169XxX0x0xxx, (this.f25168XO / 2.0f) + measureText + (width / 8.0f), (this.f25161Oo / 2.0f) + (this.f25170o00.getTextSize() / 2.5f) + (this.f25162OxI.getTextSize() / 3.5f), this.f25162OxI);
                return;
            }
            return;
        }
        canvas.drawText(this.f25167XIxXXX0x0, this.f25168XO / 2.0f, (this.f25161Oo / 2.0f) + (this.f25170o00.getTextSize() / 2.5f), this.f25170o00);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f25168XO = i;
        this.f25161Oo = i2;
    }

    public final void oxoX(int i, boolean z, int i2, boolean z2, int i3, @OXOo.OOXIXo String originalPrice) {
        int i4;
        IIX0o.x0xO0oo(originalPrice, "originalPrice");
        if (z2) {
            this.f25172xXxxox0I = 0;
        }
        if (z) {
            this.f25170o00.setColor(this.f25165X0IIOO);
            this.f25174xxX = 1.0f;
        } else {
            this.f25174xxX = 0.0f;
            Paint paint = this.f25170o00;
            if (i3 != 0) {
                i4 = oIxOXo.oxoX.I0Io(getContext(), i3);
            } else if (i2 == 1) {
                i4 = this.f25166XI0IXoo;
            } else {
                i4 = this.f25160O0xOxO;
            }
            paint.setColor(i4);
        }
        String string = getContext().getString(i);
        IIX0o.oO(string, "getString(...)");
        this.f25167XIxXXX0x0 = string;
        this.f25169XxX0x0xxx = originalPrice;
        invalidate();
    }

    public final void setDrawablesLift(int i) {
        this.f25172xXxxox0I = i;
    }

    public final void setMDrawablesLiftId(int i) {
        this.f25172xXxxox0I = i;
    }

    public final void setMOriginalPrice(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f25169XxX0x0xxx = str;
    }

    public final void setProgress(float f) {
        this.f25174xxX = f;
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("%d%%", Arrays.copyOf(new Object[]{Integer.valueOf((int) (f * 100))}, 1));
        IIX0o.oO(format, "format(...)");
        this.f25167XIxXXX0x0 = format;
        this.f25170o00.setColor(this.f25165X0IIOO);
        invalidate();
    }

    public final void setProgressDecimalPlaces(float f) {
        this.f25174xxX = f;
        StringBuilder sb = new StringBuilder();
        String format = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f * 100)}, 1));
        IIX0o.oO(format, "format(...)");
        sb.append(format);
        sb.append(org.apache.log4j.helpers.x0XOIxOo.f33309xxIXOIIO);
        this.f25167XIxXXX0x0 = sb.toString();
        this.f25170o00.setColor(this.f25165X0IIOO);
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public ProgressButtonV2(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ ProgressButtonV2(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public ProgressButtonV2(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        Paint paint = new Paint();
        this.f25159IXxxXO = paint;
        this.f25163Oxx0xo = new RectF();
        this.f25171oI0IIXIo = oIxOXo.oxoX.I0Io(context, R.color.colorAccent);
        this.f25164OxxIIOOXO = oIxOXo.oxoX.I0Io(context, R.color.progress_v2_button_bg);
        this.f25158IIXOooo = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.f25173xoXoI = SizeUtils.dp2px(1.0f);
        Paint paint2 = new Paint();
        this.f25170o00 = paint2;
        Paint paint3 = new Paint();
        this.f25162OxI = paint3;
        this.f25160O0xOxO = oIxOXo.oxoX.I0Io(context, R.color.colorAccent);
        this.f25165X0IIOO = oIxOXo.oxoX.I0Io(context, R.color.white);
        this.f25166XI0IXoo = oIxOXo.oxoX.I0Io(context, R.color.line_color);
        this.f25167XIxXXX0x0 = "";
        this.f25169XxX0x0xxx = "";
        oIxOXo.oxoX.f31821II0XooXoX = isInEditMode();
        oIX0oI(context, attributeSet);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint3.setAntiAlias(true);
        paint3.setDither(true);
        paint3.setTextSize(ConvertUtils.dp2px(6.0f));
        OOxOI.oIX0oI oix0oi = OOxOI.oIX0oI.f1804oIX0oI;
        MyTypeface myTypeface = MyTypeface.PF_MEDIUM;
        paint3.setTypeface(oix0oi.oIX0oI(myTypeface, context));
        Paint.Align align = Paint.Align.CENTER;
        paint3.setTextAlign(align);
        paint3.setStrikeThruText(true);
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        paint2.setTextSize(ConvertUtils.dp2px(13.0f));
        paint2.setTypeface(oix0oi.oIX0oI(myTypeface, context));
        paint2.setTextAlign(align);
    }
}
