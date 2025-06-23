package com.sma.smartv3.view.segmentedbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Html;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.sma.smartv3.R;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import o0Xo.oIX0oI;

/* loaded from: classes12.dex */
public class SegmentedBarView2 extends View {

    /* renamed from: XI0oooXX, reason: collision with root package name */
    public static final int f25672XI0oooXX = 1;

    /* renamed from: ox, reason: collision with root package name */
    public static final int f25673ox = 0;

    /* renamed from: I0X0x0oIo, reason: collision with root package name */
    public int f25674I0X0x0oIo;

    /* renamed from: I0oOIX, reason: collision with root package name */
    public boolean f25675I0oOIX;

    /* renamed from: I0oOoX, reason: collision with root package name */
    public int f25676I0oOoX;

    /* renamed from: IIX0o, reason: collision with root package name */
    public int f25677IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f25678IIXOooo;

    /* renamed from: IO, reason: collision with root package name */
    public List<oIX0oI> f25679IO;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Paint f25680IXxxXO;

    /* renamed from: Io, reason: collision with root package name */
    public int f25681Io;

    /* renamed from: IoOoX, reason: collision with root package name */
    public int f25682IoOoX;

    /* renamed from: IoOoo, reason: collision with root package name */
    public Point f25683IoOoo;

    /* renamed from: Ioxxx, reason: collision with root package name */
    public Paint f25684Ioxxx;

    /* renamed from: O00XxXI, reason: collision with root package name */
    public float f25685O00XxXI;

    /* renamed from: O0Xx, reason: collision with root package name */
    public Paint f25686O0Xx;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public String f25687O0xOxO;

    /* renamed from: OI0, reason: collision with root package name */
    public int f25688OI0;

    /* renamed from: OO, reason: collision with root package name */
    public Point f25689OO;

    /* renamed from: OO0x0xX, reason: collision with root package name */
    public boolean f25690OO0x0xX;

    /* renamed from: Oo, reason: collision with root package name */
    public Paint f25691Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public String f25692OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f25693Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f25694OxxIIOOXO;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public int f25695X00IoxXI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public Integer f25696X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public Integer f25697XI0IXoo;

    /* renamed from: XIo0oOXIx, reason: collision with root package name */
    public int f25698XIo0oOXIx;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public String f25699XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public RectF f25700XO;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public DecimalFormat f25701XOxIOxOx;

    /* renamed from: XX, reason: collision with root package name */
    public int f25702XX;

    /* renamed from: XX0, reason: collision with root package name */
    public int f25703XX0;

    /* renamed from: XX0xXo, reason: collision with root package name */
    public float f25704XX0xXo;

    /* renamed from: Xo0, reason: collision with root package name */
    public int f25705Xo0;

    /* renamed from: XoI0Ixx0, reason: collision with root package name */
    public int f25706XoI0Ixx0;

    /* renamed from: XoX, reason: collision with root package name */
    public StaticLayout f25707XoX;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public int f25708Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public Rect f25709XxX0x0xxx;

    /* renamed from: o0, reason: collision with root package name */
    public Paint f25710o0;

    /* renamed from: o00, reason: collision with root package name */
    public Float f25711o00;

    /* renamed from: o0xxxXXxX, reason: collision with root package name */
    public float f25712o0xxxXXxX;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f25713oI0IIXIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public int f25714oOXoIIIo;

    /* renamed from: oX, reason: collision with root package name */
    public int f25715oX;

    /* renamed from: oo, reason: collision with root package name */
    public int f25716oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public ArrayList<Rect> f25717oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public float f25718ooXIXxIX;

    /* renamed from: oxXx0IX, reason: collision with root package name */
    public TextPaint f25719oxXx0IX;

    /* renamed from: oxxXoxO, reason: collision with root package name */
    public StaticLayout f25720oxxXoxO;

    /* renamed from: x0o, reason: collision with root package name */
    public Paint f25721x0o;

    /* renamed from: x0xO, reason: collision with root package name */
    public Rect f25722x0xO;

    /* renamed from: xI, reason: collision with root package name */
    public float f25723xI;

    /* renamed from: xII, reason: collision with root package name */
    public String f25724xII;

    /* renamed from: xXOx, reason: collision with root package name */
    public int f25725xXOx;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public Rect f25726xXxxox0I;

    /* renamed from: xo0x, reason: collision with root package name */
    public int f25727xo0x;

    /* renamed from: xoIxX, reason: collision with root package name */
    public Point f25728xoIxX;

    /* renamed from: xoXoI, reason: collision with root package name */
    public Float f25729xoXoI;

    /* renamed from: xoxXI, reason: collision with root package name */
    public Path f25730xoxXI;

    /* renamed from: xxIO, reason: collision with root package name */
    public int f25731xxIO;

    /* renamed from: xxX, reason: collision with root package name */
    public Rect f25732xxX;

    public SegmentedBarView2(Context context) {
        super(context);
        this.f25718ooXIXxIX = -1.0f;
        this.f25723xI = -1.0f;
        this.f25717oo0xXOI0I = new ArrayList<>();
        this.f25688OI0 = 0;
        this.f25681Io = 1;
        this.f25676I0oOoX = -1;
        this.f25727xo0x = -12303292;
        this.f25725xXOx = 65536;
        this.f25715oX = -1;
        this.f25690OO0x0xX = false;
        this.f25684Ioxxx = new Paint();
        this.f25731xxIO = 0;
        this.f25704XX0xXo = 4.0f;
        this.f25712o0xxxXXxX = 15.0f;
        this.f25685O00XxXI = 0.1f;
        ooOOo0oXI(context, null);
    }

    private int getContentWidth() {
        return ((getWidth() - getPaddingLeft()) - getPaddingRight()) - (getXLeft() * 2);
    }

    private int getXLeft() {
        return 0;
    }

    private int getXtop() {
        return 0;
    }

    public final int I0Io() {
        if (oI0IIXIo()) {
            return 0;
        }
        return this.f25706XoI0Ixx0;
    }

    public final void II0XooXoX(Canvas canvas, Paint paint, String text, float left, float top, float right, float bottom) {
        paint.setTextAlign(Paint.Align.CENTER);
        float descent = ((paint.descent() - paint.ascent()) / 2.0f) - paint.descent();
        if (TextUtils.isEmpty(text)) {
            return;
        }
        canvas.drawText(text, (left + right) / 2.0f, ((top + bottom) / 2.0f) + descent, paint);
    }

    public final void II0xO0() {
        String str;
        String str2;
        if (oI0IIXIo()) {
            this.f25720oxxXoxO = null;
            return;
        }
        Float f = this.f25729xoXoI;
        if (f != null) {
            str = this.f25701XOxIOxOx.format(f);
        } else {
            str = this.f25699XIxXXX0x0;
        }
        if (this.f25729xoXoI != null && (str2 = this.f25724xII) != null && !str2.isEmpty()) {
            str = str + String.format("<br><small>%s</small>", this.f25724xII);
        }
        if (!TextUtils.isEmpty(this.f25692OxI)) {
            str = this.f25692OxI;
        }
        this.f25720oxxXoxO = new StaticLayout(Html.fromHtml(str), this.f25719oxXx0IX, this.f25713oI0IIXIo, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void IXxxXO(Float value, String unitHtml) {
        this.f25729xoXoI = value;
        this.f25724xII = unitHtml;
        if (!oI0IIXIo()) {
            II0xO0();
        }
        invalidate();
        requestLayout();
    }

    public final void OOXIXo(Canvas canvas, int valueSignSpaceHeight, int valueSignCenter) {
        boolean z;
        int i = 0;
        if (valueSignCenter == -1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            valueSignCenter = (getContentWidth() / 2) + getPaddingLeft();
        }
        this.f25726xXxxox0I.set(valueSignCenter - (this.f25713oI0IIXIo / 2), getPaddingTop(), (this.f25713oI0IIXIo / 2) + valueSignCenter, (this.f25693Oxx0xo - this.f25716oo) + getPaddingTop());
        this.f25680IXxxXO.setColor(this.f25678IIXOooo);
        if (this.f25726xXxxox0I.left < getPaddingLeft()) {
            int paddingLeft = (-this.f25726xXxxox0I.left) + getPaddingLeft();
            RectF rectF = this.f25700XO;
            Rect rect = this.f25726xXxxox0I;
            rectF.set(rect.left + paddingLeft, rect.top, rect.right + paddingLeft, rect.bottom);
        } else if (this.f25726xXxxox0I.right > getMeasuredWidth() - getPaddingRight()) {
            int measuredWidth = (this.f25726xXxxox0I.right - getMeasuredWidth()) + getPaddingRight();
            RectF rectF2 = this.f25700XO;
            Rect rect2 = this.f25726xXxxox0I;
            rectF2.set(rect2.left - measuredWidth, rect2.top, rect2.right - measuredWidth, rect2.bottom);
        } else {
            RectF rectF3 = this.f25700XO;
            Rect rect3 = this.f25726xXxxox0I;
            rectF3.set(rect3.left, rect3.top, rect3.right, rect3.bottom);
        }
        RectF rectF4 = this.f25700XO;
        int i2 = this.f25677IIX0o;
        canvas.drawRoundRect(rectF4, i2, i2, this.f25680IXxxXO);
        if (!z) {
            if (valueSignCenter - (this.f25682IoOoX / 2) < this.f25688OI0 + getPaddingLeft()) {
                i = getPaddingLeft() + (this.f25688OI0 - valueSignCenter);
            } else if ((this.f25682IoOoX / 2) + valueSignCenter > (getMeasuredWidth() - this.f25688OI0) - getPaddingRight()) {
                i = ((getMeasuredWidth() - this.f25688OI0) - valueSignCenter) - getPaddingRight();
            }
            this.f25689OO.set((valueSignCenter - (this.f25682IoOoX / 2)) + i, (valueSignSpaceHeight - this.f25716oo) + getPaddingTop());
            this.f25683IoOoo.set((this.f25682IoOoX / 2) + valueSignCenter + i, (valueSignSpaceHeight - this.f25716oo) + getPaddingTop());
            this.f25728xoIxX.set(valueSignCenter + i, valueSignSpaceHeight + getPaddingTop());
            xoIox(canvas, this.f25689OO, this.f25683IoOoo, this.f25728xoIxX, this.f25680IXxxXO);
        }
        int OxxIIOOXO2 = (((OxxIIOOXO() + getPaddingTop()) + I0Io()) + getXtop()) - 15;
        int OxxIIOOXO3 = this.f25695X00IoxXI + OxxIIOOXO() + I0Io() + getXtop() + 15;
        int i3 = this.f25728xoIxX.x;
        canvas.drawRoundRect(new RectF(i3 - 10.0f, OxxIIOOXO2, i3 + 10.0f, OxxIIOOXO3), 10.0f, 10.0f, this.f25680IXxxXO);
        if (this.f25707XoX != null) {
            canvas.save();
            RectF rectF5 = this.f25700XO;
            canvas.translate(rectF5.left, (rectF5.top + (rectF5.height() / 2.0f)) - (this.f25707XoX.getHeight() / 2));
            this.f25707XoX.draw(canvas);
            canvas.restore();
        }
    }

    public void Oo(int width, int height) {
        this.f25713oI0IIXIo = width;
        this.f25693Oxx0xo = height;
        if (!oI0IIXIo()) {
            II0xO0();
        }
        invalidate();
        requestLayout();
    }

    public final void Oxx0IOOO(Canvas canvas, Paint paint, String text, Rect outsideRect) {
        II0XooXoX(canvas, paint, text, outsideRect.left, outsideRect.top, outsideRect.right, outsideRect.bottom);
    }

    public final boolean Oxx0xo() {
        if (this.f25711o00 == null && this.f25697XI0IXoo == null) {
            return true;
        }
        return false;
    }

    public final int OxxIIOOXO() {
        if (oI0IIXIo()) {
            return 0;
        }
        return this.f25693Oxx0xo;
    }

    public final void X0o0xo(Canvas canvas) {
        Rect rect = new Rect();
        boolean z = false;
        for (int i = 0; i < this.f25717oo0xXOI0I.size(); i++) {
            rect.set(this.f25717oo0xXOI0I.get(i));
            oIX0oI oix0oi = this.f25679IO.get(i);
            int i2 = rect.left;
            float f = i2;
            float f2 = this.f25718ooXIXxIX;
            boolean z2 = true;
            if (f < f2 && f2 < rect.right) {
                rect.left = (int) f2;
                int XO2 = oix0oi.XO();
                this.f25694OxxIIOOXO = XO2;
                float f3 = this.f25723xI;
                if (f3 < rect.right) {
                    rect.right = (int) f3;
                    this.f25678IIXOooo = XO2;
                    z2 = false;
                }
                this.f25691Oo.setColor(XO2);
                canvas.drawRect(rect, this.f25691Oo);
                z = z2;
            } else if (i2 == f2) {
                rect.left = (int) f2;
                this.f25694OxxIIOOXO = oix0oi.XO();
                z = true;
            }
            if (z) {
                float f4 = this.f25723xI;
                if (f4 <= rect.right) {
                    rect.right = (int) f4;
                    int XO3 = oix0oi.XO();
                    this.f25678IIXOooo = XO3;
                    this.f25691Oo.setColor(XO3);
                    canvas.drawRect(rect, this.f25691Oo);
                    z = false;
                } else {
                    this.f25691Oo.setColor(oix0oi.XO());
                    canvas.drawRect(rect, this.f25691Oo);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0283 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0574  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0552  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void XO(android.graphics.Canvas r20, o0Xo.oIX0oI r21, int r22, int r23, float r24) {
        /*
            Method dump skipped, instructions count: 1505
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.view.segmentedbar.SegmentedBarView2.XO(android.graphics.Canvas, o0Xo.oIX0oI, int, int, float):void");
    }

    public Integer getValueSegment() {
        return this.f25696X0IIOO;
    }

    public String getValueSegmentText() {
        return this.f25699XIxXXX0x0;
    }

    public final boolean oI0IIXIo() {
        if (this.f25729xoXoI == null && this.f25696X0IIOO == null) {
            return true;
        }
        return false;
    }

    public final void oIX0oI() {
        String str;
        String str2;
        if (Oxx0xo()) {
            this.f25707XoX = null;
            return;
        }
        Float f = this.f25711o00;
        if (f != null) {
            str = this.f25701XOxIOxOx.format(f);
        } else {
            str = this.f25699XIxXXX0x0;
        }
        if (this.f25711o00 != null && (str2 = this.f25724xII) != null && !str2.isEmpty()) {
            str = str + String.format("<br><small>%s</small>", this.f25724xII);
        }
        if (!TextUtils.isEmpty(this.f25687O0xOxO)) {
            str = this.f25687O0xOxO;
        }
        this.f25707XoX = new StaticLayout(Html.fromHtml(str), this.f25719oxXx0IX, this.f25713oI0IIXIo, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void oO(float value2, String valueText) {
        this.f25687O0xOxO = valueText;
        this.f25711o00 = Float.valueOf(value2);
        oIX0oI();
        invalidate();
        requestLayout();
    }

    public final void oOoXoXO(Canvas canvas, int valueSignSpaceHeight, int valueSignCenter) {
        boolean z;
        int i = 0;
        if (valueSignCenter == -1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            valueSignCenter = (getContentWidth() / 2) + getPaddingLeft();
        }
        this.f25709XxX0x0xxx.set(valueSignCenter - (this.f25713oI0IIXIo / 2), getPaddingTop(), (this.f25713oI0IIXIo / 2) + valueSignCenter, (this.f25693Oxx0xo - this.f25716oo) + getPaddingTop());
        this.f25680IXxxXO.setColor(this.f25694OxxIIOOXO);
        if (this.f25709XxX0x0xxx.left < getPaddingLeft()) {
            int paddingLeft = (-this.f25709XxX0x0xxx.left) + getPaddingLeft();
            RectF rectF = this.f25700XO;
            Rect rect = this.f25709XxX0x0xxx;
            rectF.set(rect.left + paddingLeft, rect.top, rect.right + paddingLeft, rect.bottom);
        } else if (this.f25709XxX0x0xxx.right > getMeasuredWidth() - getPaddingRight()) {
            int measuredWidth = (this.f25709XxX0x0xxx.right - getMeasuredWidth()) + getPaddingRight();
            RectF rectF2 = this.f25700XO;
            Rect rect2 = this.f25709XxX0x0xxx;
            rectF2.set(rect2.left - measuredWidth, rect2.top, rect2.right - measuredWidth, rect2.bottom);
        } else {
            RectF rectF3 = this.f25700XO;
            Rect rect3 = this.f25709XxX0x0xxx;
            rectF3.set(rect3.left, rect3.top, rect3.right, rect3.bottom);
        }
        RectF rectF4 = this.f25700XO;
        int i2 = this.f25677IIX0o;
        canvas.drawRoundRect(rectF4, i2, i2, this.f25680IXxxXO);
        if (!z) {
            if (valueSignCenter - (this.f25682IoOoX / 2) < this.f25688OI0 + getPaddingLeft()) {
                i = getPaddingLeft() + (this.f25688OI0 - valueSignCenter);
            } else if ((this.f25682IoOoX / 2) + valueSignCenter > (getMeasuredWidth() - this.f25688OI0) - getPaddingRight()) {
                i = ((getMeasuredWidth() - this.f25688OI0) - valueSignCenter) - getPaddingRight();
            }
            this.f25689OO.set((valueSignCenter - (this.f25682IoOoX / 2)) + i, (valueSignSpaceHeight - this.f25716oo) + getPaddingTop());
            this.f25683IoOoo.set((this.f25682IoOoX / 2) + valueSignCenter + i, (valueSignSpaceHeight - this.f25716oo) + getPaddingTop());
            this.f25728xoIxX.set(valueSignCenter + i, valueSignSpaceHeight + getPaddingTop());
            xoIox(canvas, this.f25689OO, this.f25683IoOoo, this.f25728xoIxX, this.f25680IXxxXO);
        }
        int OxxIIOOXO2 = (((OxxIIOOXO() + getPaddingTop()) + I0Io()) + getXtop()) - 15;
        int OxxIIOOXO3 = this.f25695X00IoxXI + OxxIIOOXO() + I0Io() + getXtop() + 15;
        int i3 = this.f25728xoIxX.x;
        canvas.drawRoundRect(new RectF(i3 - 10.0f, OxxIIOOXO2, i3 + 10.0f, OxxIIOOXO3), 10.0f, 10.0f, this.f25680IXxxXO);
        if (this.f25720oxxXoxO != null) {
            canvas.save();
            RectF rectF5 = this.f25700XO;
            canvas.translate(rectF5.left, (rectF5.top + (rectF5.height() / 2.0f)) - (this.f25720oxxXoxO.getHeight() / 2));
            this.f25720oxxXoxO.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f25717oo0xXOI0I.clear();
        this.f25718ooXIXxIX = -1.0f;
        this.f25723xI = -1.0f;
        int size = this.f25679IO.size();
        oIX0oI oix0oi = this.f25679IO.get(r1.size() - 1);
        for (int i = 0; i < size; i++) {
            XO(canvas, this.f25679IO.get(i), i, size, oix0oi.oxoX());
        }
        X0o0xo(canvas);
        oOoXoXO(canvas, OxxIIOOXO(), (int) this.f25718ooXIXxIX);
        OOXIXo(canvas, OxxIIOOXO(), (int) this.f25723xI);
        oxoX(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingBottom = this.f25695X00IoxXI + getPaddingBottom() + getPaddingTop();
        if (!oI0IIXIo()) {
            paddingBottom += this.f25693Oxx0xo + this.f25716oo;
        }
        if (this.f25675I0oOIX) {
            paddingBottom += this.f25705Xo0;
        }
        setMeasuredDimension(View.resolveSizeAndState(paddingLeft, widthMeasureSpec, 0), View.resolveSizeAndState(paddingBottom, heightMeasureSpec, 0));
    }

    public final void ooOOo0oXI(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SegmentedBarView, 0, 0);
        try {
            Resources resources = getResources();
            this.f25703XX0 = obtainStyledAttributes.getInt(3, 0);
            this.f25702XX = obtainStyledAttributes.getDimensionPixelSize(42, resources.getDimensionPixelSize(com.sma.smartv3.co_fit.R.dimen.sbv_value_text_size));
            this.f25674I0X0x0oIo = obtainStyledAttributes.getDimensionPixelSize(10, resources.getDimensionPixelSize(com.sma.smartv3.co_fit.R.dimen.sbv_description_text_size));
            this.f25715oX = obtainStyledAttributes.getDimensionPixelSize(8, -1);
            this.f25695X00IoxXI = obtainStyledAttributes.getDimensionPixelSize(2, resources.getDimensionPixelSize(com.sma.smartv3.co_fit.R.dimen.sbv_bar_height));
            this.f25693Oxx0xo = obtainStyledAttributes.getDimensionPixelSize(39, resources.getDimensionPixelSize(com.sma.smartv3.co_fit.R.dimen.sbv_value_sign_height));
            this.f25713oI0IIXIo = obtainStyledAttributes.getDimensionPixelSize(41, resources.getDimensionPixelSize(com.sma.smartv3.co_fit.R.dimen.sbv_value_sign_width));
            this.f25716oo = obtainStyledAttributes.getDimensionPixelSize(0, resources.getDimensionPixelSize(com.sma.smartv3.co_fit.R.dimen.sbv_arrow_height));
            this.f25682IoOoX = obtainStyledAttributes.getDimensionPixelSize(1, resources.getDimensionPixelSize(com.sma.smartv3.co_fit.R.dimen.sbv_arrow_width));
            this.f25714oOXoIIIo = obtainStyledAttributes.getDimensionPixelSize(18, resources.getDimensionPixelSize(com.sma.smartv3.co_fit.R.dimen.sbv_segment_gap_width));
            this.f25688OI0 = obtainStyledAttributes.getDimensionPixelSize(22, 0);
            this.f25708Xx000oIo = obtainStyledAttributes.getColor(17, -1);
            this.f25677IIX0o = obtainStyledAttributes.getDimensionPixelSize(40, resources.getDimensionPixelSize(com.sma.smartv3.co_fit.R.dimen.sbv_value_sign_round));
            this.f25705Xo0 = obtainStyledAttributes.getDimensionPixelSize(5, resources.getDimensionPixelSize(com.sma.smartv3.co_fit.R.dimen.sbv_description_box_height));
            this.f25675I0oOIX = obtainStyledAttributes.getBoolean(25, false);
            String string = obtainStyledAttributes.getString(35);
            this.f25699XIxXXX0x0 = string;
            if (string == null) {
                this.f25699XIxXXX0x0 = resources.getString(com.sma.smartv3.co_fit.R.string.sbv_value_segment);
            }
            this.f25727xo0x = obtainStyledAttributes.getColor(9, this.f25727xo0x);
            this.f25725xXOx = obtainStyledAttributes.getColor(7, 65536);
            this.f25681Io = obtainStyledAttributes.getInt(29, 1);
            this.f25698XIo0oOXIx = obtainStyledAttributes.getInt(23, 1);
            obtainStyledAttributes.recycle();
            this.f25701XOxIOxOx = new DecimalFormat("##.####");
            TextPaint textPaint = new TextPaint(1);
            this.f25710o0 = textPaint;
            textPaint.setColor(-1);
            Paint paint = this.f25710o0;
            Paint.Style style = Paint.Style.FILL;
            paint.setStyle(style);
            TextPaint textPaint2 = new TextPaint(1);
            this.f25719oxXx0IX = textPaint2;
            textPaint2.setColor(-1);
            this.f25719oxXx0IX.setStyle(style);
            this.f25719oxXx0IX.setTextSize(this.f25702XX);
            this.f25719oxXx0IX.setColor(this.f25676I0oOoX);
            TextPaint textPaint3 = new TextPaint(1);
            this.f25686O0Xx = textPaint3;
            textPaint3.setColor(-12303292);
            this.f25686O0Xx.setStyle(style);
            Paint paint2 = new Paint(1);
            this.f25691Oo = paint2;
            paint2.setStyle(style);
            this.f25691Oo.setAntiAlias(true);
            Paint paint3 = new Paint(1);
            this.f25680IXxxXO = paint3;
            paint3.setStyle(style);
            this.f25680IXxxXO.setAntiAlias(true);
            Paint paint4 = new Paint(1);
            this.f25721x0o = paint4;
            paint4.setStyle(style);
            this.f25732xxX = new Rect();
            this.f25700XO = new RectF();
            this.f25709XxX0x0xxx = new Rect();
            this.f25726xXxxox0I = new Rect();
            this.f25722x0xO = new Rect();
            Path path = new Path();
            this.f25730xoxXI = path;
            path.setFillType(Path.FillType.EVEN_ODD);
            this.f25689OO = new Point();
            this.f25683IoOoo = new Point();
            this.f25728xoIxX = new Point();
            this.f25706XoI0Ixx0 = 0;
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void oxoX(Canvas canvas) {
        this.f25684Ioxxx.setStrokeWidth(this.f25704XX0xXo);
        this.f25684Ioxxx.setColor(-1);
        this.f25684Ioxxx.setAntiAlias(true);
        oIX0oI oix0oi = this.f25679IO.get(0);
        List<oIX0oI> list = this.f25679IO;
        oIX0oI oix0oi2 = list.get(list.size() - 1);
        Rect rect = this.f25717oo0xXOI0I.get(0);
        ArrayList<Rect> arrayList = this.f25717oo0xXOI0I;
        Rect rect2 = arrayList.get(arrayList.size() - 1);
        int oxoX2 = (int) ((oix0oi2.oxoX() - oix0oi.X0o0xo()) / this.f25685O00XxXI);
        this.f25731xxIO = oxoX2;
        float f = (rect2.right - rect.left) / oxoX2;
        for (int i = 0; i <= this.f25731xxIO; i++) {
            float f2 = rect.left + (i * f);
            float height = (rect.height() - this.f25712o0xxxXXxX) / 2.0f;
            canvas.drawLine(f2, rect.top + height, f2, rect.bottom - height, this.f25684Ioxxx);
        }
    }

    public void setBarHeight(int barHeight) {
        this.f25695X00IoxXI = barHeight;
        invalidate();
        requestLayout();
    }

    public void setGapColor(int gapColor) {
        this.f25708Xx000oIo = gapColor;
        invalidate();
        requestLayout();
    }

    public void setGapWidth(int gapWidth) {
        this.f25714oOXoIIIo = gapWidth;
        invalidate();
        requestLayout();
    }

    public void setSegmentSideRule(int sideRule) {
        this.f25698XIo0oOXIx = sideRule;
        invalidate();
        requestLayout();
    }

    public void setSegments(List<oIX0oI> segments) {
        this.f25679IO = segments;
        invalidate();
        requestLayout();
    }

    public void setShowDescriptionText(boolean showDescriptionText) {
        this.f25675I0oOIX = showDescriptionText;
        invalidate();
        requestLayout();
    }

    public void setUnit(String unit) {
        this.f25724xII = unit;
        II0xO0();
        invalidate();
        requestLayout();
    }

    public void setValue(Float value) {
        this.f25729xoXoI = value;
        II0xO0();
        invalidate();
        requestLayout();
    }

    public void setValue2(Float value) {
        this.f25711o00 = value;
        oIX0oI();
        invalidate();
        requestLayout();
    }

    public void setValue2Segment(Integer value2Segment) {
        this.f25698XIo0oOXIx = 1;
        this.f25697XI0IXoo = value2Segment;
        invalidate();
        requestLayout();
    }

    public void setValueSegment(Integer valueSegment) {
        this.f25698XIo0oOXIx = 1;
        this.f25696X0IIOO = valueSegment;
        invalidate();
        requestLayout();
    }

    public void setValueSegmentText(String valueSegmentText) {
        this.f25699XIxXXX0x0 = valueSegmentText;
        II0xO0();
        invalidate();
        requestLayout();
    }

    public void setValueSignColor(int valueSignColor) {
        this.f25694OxxIIOOXO = valueSignColor;
        invalidate();
        requestLayout();
    }

    public void x0XOIxOo(float value, String valueText) {
        this.f25692OxI = valueText;
        this.f25729xoXoI = Float.valueOf(value);
        II0xO0();
        invalidate();
        requestLayout();
    }

    public void x0xO0oo(Float value2, String unitHtml) {
        this.f25711o00 = value2;
        this.f25724xII = unitHtml;
        if (!Oxx0xo()) {
            oIX0oI();
        }
        invalidate();
        requestLayout();
    }

    public final void xoIox(Canvas canvas, Point point1, Point point2, Point point3, Paint paint) {
        this.f25730xoxXI.reset();
        this.f25730xoxXI.moveTo(point1.x, point1.y);
        this.f25730xoxXI.lineTo(point2.x, point2.y);
        this.f25730xoxXI.lineTo(point3.x, point3.y);
        this.f25730xoxXI.lineTo(point1.x, point1.y);
        this.f25730xoxXI.close();
        canvas.drawPath(this.f25730xoxXI, paint);
    }

    public final void xxIXOIIO(Canvas canvas, Paint paint, String text, float left, float top, float right, float bottom, boolean isLeftSegment, boolean isRightSegment, int index) {
        paint.setTextAlign(Paint.Align.CENTER);
        float descent = ((paint.descent() - paint.ascent()) / 2.0f) - paint.descent();
        float measureText = paint.measureText(text);
        if (isLeftSegment) {
            canvas.drawText(text, left + (measureText / 2.0f), ((top + bottom) / 2.0f) + descent, paint);
            return;
        }
        if (isRightSegment) {
            if (this.f25679IO.size() <= 2 && text.contains("&")) {
                String[] split = TextUtils.split(text, "&");
                float f = ((top + bottom) / 2.0f) + descent;
                canvas.drawText(split[0], left, f, paint);
                canvas.drawText(split[1], right - (paint.measureText(split[1]) / 2.0f), f, paint);
                return;
            }
            canvas.drawText(text, right - (measureText / 2.0f), ((top + bottom) / 2.0f) + descent, paint);
            return;
        }
        if (!isLeftSegment && !isRightSegment) {
            if (text.contains("&")) {
                String[] split2 = TextUtils.split(text, "&");
                if (index % 2 == 1) {
                    float f2 = ((top + bottom) / 2.0f) + descent;
                    canvas.drawText(split2[0], left, f2, paint);
                    canvas.drawText(split2[1], right, f2, paint);
                    return;
                }
                canvas.drawText(split2[1], right, ((top + bottom) / 2.0f) + descent, paint);
                return;
            }
            return;
        }
        canvas.drawText(text, right - (measureText / 2.0f), ((top + bottom) / 2.0f) + descent, paint);
    }

    public SegmentedBarView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f25718ooXIXxIX = -1.0f;
        this.f25723xI = -1.0f;
        this.f25717oo0xXOI0I = new ArrayList<>();
        this.f25688OI0 = 0;
        this.f25681Io = 1;
        this.f25676I0oOoX = -1;
        this.f25727xo0x = -12303292;
        this.f25725xXOx = 65536;
        this.f25715oX = -1;
        this.f25690OO0x0xX = false;
        this.f25684Ioxxx = new Paint();
        this.f25731xxIO = 0;
        this.f25704XX0xXo = 4.0f;
        this.f25712o0xxxXXxX = 15.0f;
        this.f25685O00XxXI = 0.1f;
        ooOOo0oXI(context, attrs);
    }
}
