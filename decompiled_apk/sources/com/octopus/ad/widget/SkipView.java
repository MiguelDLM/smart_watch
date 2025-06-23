package com.octopus.ad.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.widget.FrameLayout;
import android.widget.TextView;
import x0.I0oOoX;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes11.dex */
public class SkipView extends TextView {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public RectF f19386IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public float f19387IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public final II0xO0 f19388O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public TextPaint f19389Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public SparseIntArray f19390OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public float f19391Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public RectF f19392OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public int f19393XO;

    /* renamed from: o00, reason: collision with root package name */
    public boolean f19394o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f19395oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f19396xoXoI;

    /* loaded from: classes11.dex */
    public interface II0xO0 {
        int oIX0oI(int i, RectF rectF);
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements II0xO0 {
        public oIX0oI() {
        }

        @Override // com.octopus.ad.widget.SkipView.II0xO0
        @TargetApi(16)
        public int oIX0oI(int i, RectF rectF) {
            SkipView.this.f19389Oo.setTextSize(i);
            String charSequence = SkipView.this.getText().toString();
            SkipView.this.f19392OxxIIOOXO.bottom = SkipView.this.f19389Oo.getFontSpacing();
            SkipView.this.f19392OxxIIOOXO.right = SkipView.this.f19389Oo.measureText(charSequence);
            SkipView.this.f19392OxxIIOOXO.offsetTo(0.0f, 0.0f);
            if (rectF.contains(SkipView.this.f19392OxxIIOOXO)) {
                return -1;
            }
            return 1;
        }
    }

    public SkipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19391Oxx0xo = 20.0f;
        this.f19392OxxIIOOXO = new RectF();
        this.f19394o00 = true;
        this.f19388O0xOxO = new oIX0oI();
        II0XooXoX(context);
    }

    public static int XO(int i, int i2, II0xO0 iI0xO0, RectF rectF) {
        int i3 = i2 - 1;
        int i4 = i;
        while (i <= i3) {
            i4 = (i + i3) >>> 1;
            int oIX0oI2 = iI0xO0.oIX0oI(i4, rectF);
            if (oIX0oI2 < 0) {
                int i5 = i4 + 1;
                i4 = i;
                i = i5;
            } else {
                if (oIX0oI2 <= 0) {
                    break;
                }
                i4--;
                i3 = i4;
            }
        }
        return i4;
    }

    public final void I0Io() {
        X0o0xo(getText().toString());
    }

    public void II0XooXoX(Context context) {
        setGravity(17);
        setLines(1);
        setMaxLines(1);
        setTextColor(-1);
        oxoX(context, 0);
        TextPaint textPaint = new TextPaint();
        this.f19389Oo = textPaint;
        textPaint.set(getPaint());
        this.f19387IXxxXO = getTextSize();
        this.f19386IIXOooo = new RectF();
        this.f19390OxI = new SparseIntArray();
        this.f19395oI0IIXIo = true;
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 53));
    }

    public final void X0o0xo(String str) {
        if (!this.f19395oI0IIXIo) {
            return;
        }
        int i = (int) this.f19391Oxx0xo;
        int measuredHeight = ((getMeasuredHeight() - getCompoundPaddingBottom()) - getCompoundPaddingTop()) - this.f19393XO;
        int measuredWidth = ((getMeasuredWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight()) - I0oOoX.x0XOIxOo(getContext(), 8.0f);
        this.f19396xoXoI = measuredWidth;
        RectF rectF = this.f19386IIXOooo;
        rectF.right = measuredWidth;
        rectF.bottom = measuredHeight;
        super.setTextSize(0, oIX0oI(i, (int) this.f19387IXxxXO, this.f19388O0xOxO, rectF));
    }

    public final int oIX0oI(int i, int i2, II0xO0 iI0xO0, RectF rectF) {
        int length;
        if (!this.f19394o00) {
            return XO(i, i2, iI0xO0, rectF);
        }
        String charSequence = getText().toString();
        if (charSequence == null) {
            length = 0;
        } else {
            length = charSequence.length();
        }
        int i3 = this.f19390OxI.get(length);
        if (i3 != 0) {
            return i3;
        }
        int XO2 = XO(i, i2, iI0xO0, rectF);
        this.f19390OxI.put(length, XO2);
        return XO2;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        SparseIntArray sparseIntArray = this.f19390OxI;
        if (sparseIntArray != null) {
            sparseIntArray.clear();
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            I0Io();
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        I0Io();
    }

    public final void oxoX(Context context, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#80000000"));
        if (i == 1) {
            gradientDrawable.setStroke(1, Color.parseColor("#C0C0C0"));
        }
        gradientDrawable.setCornerRadius(I0oOoX.x0XOIxOo(context, 45.0f));
        setBackgroundDrawable(gradientDrawable);
    }

    public void xxIXOIIO(int i, int i2) {
        oxoX(getContext(), i);
        this.f19393XO = i2;
    }

    public SkipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19391Oxx0xo = 20.0f;
        this.f19392OxxIIOOXO = new RectF();
        this.f19394o00 = true;
        this.f19388O0xOxO = new oIX0oI();
        II0XooXoX(context);
    }

    public SkipView(Context context) {
        super(context);
        this.f19391Oxx0xo = 20.0f;
        this.f19392OxxIIOOXO = new RectF();
        this.f19394o00 = true;
        this.f19388O0xOxO = new oIX0oI();
        II0XooXoX(context);
    }
}
