package com.sma.smartv3.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.baidu.mobads.sdk.internal.cn;
import com.blankj.utilcode.util.SizeUtils;
import com.sma.smartv3.R;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.oxxXoxO;
import skin.support.widget.SkinCompatView;

/* loaded from: classes12.dex */
public final class SportGoalProgressBar extends SkinCompatView {

    /* renamed from: I0X0x0oIo, reason: collision with root package name */
    public int f25272I0X0x0oIo;

    /* renamed from: I0oOoX, reason: collision with root package name */
    public float f25273I0oOoX;

    /* renamed from: IIX0o, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f25274IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25275IIXOooo;

    /* renamed from: IO, reason: collision with root package name */
    public int f25276IO;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f25277IXxxXO;

    /* renamed from: Io, reason: collision with root package name */
    public final float f25278Io;

    /* renamed from: IoOoX, reason: collision with root package name */
    public int f25279IoOoX;

    /* renamed from: O0Xx, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f25280O0Xx;

    /* renamed from: O0xOxO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25281O0xOxO;

    /* renamed from: OI0, reason: collision with root package name */
    public int f25282OI0;

    /* renamed from: Oo, reason: collision with root package name */
    public float f25283Oo;

    /* renamed from: OxI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25284OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public float f25285Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25286OxxIIOOXO;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public int f25287X00IoxXI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25288X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25289XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25290XIxXXX0x0;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public int f25291XOxIOxOx;

    /* renamed from: XX, reason: collision with root package name */
    public float f25292XX;

    /* renamed from: XX0, reason: collision with root package name */
    public int f25293XX0;

    /* renamed from: Xo0, reason: collision with root package name */
    public float f25294Xo0;

    /* renamed from: XoI0Ixx0, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f25295XoI0Ixx0;

    /* renamed from: XoX, reason: collision with root package name */
    public float f25296XoX;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public int f25297Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25298XxX0x0xxx;

    /* renamed from: o0, reason: collision with root package name */
    public float f25299o0;

    /* renamed from: o00, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25300o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public float f25301oI0IIXIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public int f25302oOXoIIIo;

    /* renamed from: oX, reason: collision with root package name */
    public float f25303oX;

    /* renamed from: oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f25304oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f25305oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f25306ooXIXxIX;

    /* renamed from: oxXx0IX, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Bitmap f25307oxXx0IX;

    /* renamed from: oxxXoxO, reason: collision with root package name */
    public float f25308oxxXoxO;

    /* renamed from: x0o, reason: collision with root package name */
    public int f25309x0o;

    /* renamed from: xI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f25310xI;

    /* renamed from: xII, reason: collision with root package name */
    public int f25311xII;

    /* renamed from: xXOx, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25312xXOx;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f25313xXxxox0I;

    /* renamed from: xo0x, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Bitmap f25314xo0x;

    /* renamed from: xoXoI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25315xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25316xxX;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public SportGoalProgressBar(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    private final void II0xO0(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GoalProgressBar);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f25277IXxxXO = obtainStyledAttributes.getBoolean(0, true);
        this.f25279IoOoX = obtainStyledAttributes.getColor(8, 0);
        this.f25302oOXoIIIo = obtainStyledAttributes.getColor(7, 0);
        this.f25297Xx000oIo = obtainStyledAttributes.getColor(2, 0);
        this.f25287X00IoxXI = obtainStyledAttributes.getColor(1, 0);
        this.f25276IO = obtainStyledAttributes.getColor(4, 0);
        this.f25311xII = obtainStyledAttributes.getColor(3, 0);
        obtainStyledAttributes.recycle();
    }

    private final float oIX0oI(int i) {
        return SizeUtils.dp2px(i);
    }

    public final void I0Io(float f, float f2) {
        this.f25273I0oOoX = f;
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
        IIX0o.oO(format, "format(...)");
        this.f25295XoI0Ixx0 = format;
        this.f25292XX = f2;
        invalidate();
    }

    @Override // skin.support.widget.SkinCompatView, xxoXO.Oxx0IOOO
    public void applySkin() {
        super.applySkin();
        invalidate();
    }

    public final float getCenterPoint() {
        return this.f25294Xo0;
    }

    @OXOo.OOXIXo
    public final String getMDistance() {
        return this.f25295XoI0Ixx0;
    }

    @OXOo.OOXIXo
    public final String getMKcal() {
        return this.f25280O0Xx;
    }

    public final float getRectWidth() {
        return this.f25303oX;
    }

    public final int getViewHeight() {
        return this.f25272I0X0x0oIo;
    }

    public final int getViewWidth() {
        return this.f25293XX0;
    }

    @Override // android.view.View
    public void onDraw(@OXOo.OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        canvas.drawArc(this.f25305oo0xXOI0I, 0.0f, 360.0f, false, this.f25290XIxXXX0x0);
        canvas.drawArc(this.f25274IIX0o, 90.0f, 360.0f, false, this.f25300o00);
        float f = (this.f25273I0oOoX / this.f25292XX) * 360.0f;
        this.f25283Oo = f;
        canvas.drawArc(this.f25274IIX0o, 90.0f, f, false, this.f25315xoXoI);
        canvas.drawArc(this.f25304oo, 0.0f, 360.0f, false, this.f25316xxX);
        canvas.drawArc(this.f25306ooXIXxIX, 90.0f, 360.0f, false, this.f25281O0xOxO);
        float f2 = (this.f25296XoX / this.f25308oxxXoxO) * 360.0f;
        this.f25283Oo = f2;
        canvas.drawArc(this.f25306ooXIXxIX, 90.0f, f2, false, this.f25284OxI);
        float f3 = 2;
        float width = ((this.f25293XX0 / 2) - this.f25301oI0IIXIo) - (this.f25274IIX0o.width() / f3);
        float height = this.f25285Oxx0xo + this.f25294Xo0 + (this.f25274IIX0o.height() / f3) + oIX0oI(10);
        String str = this.f25295XoI0Ixx0;
        canvas.drawText(str, width - (this.f25288X0IIOO.measureText(str) / f3), height, this.f25288X0IIOO);
        String string = getContext().getString(com.sma.smartv3.co_fit.R.string.aerobic_training_effect);
        IIX0o.oO(string, "getString(...)");
        canvas.drawText(string, width - (this.f25298XxX0x0xxx.measureText(string) / f3), height + oIX0oI(30), this.f25298XxX0x0xxx);
        float width2 = (this.f25293XX0 / 2) + this.f25301oI0IIXIo + (this.f25274IIX0o.width() / f3);
        float height2 = this.f25285Oxx0xo + this.f25294Xo0 + (this.f25306ooXIXxIX.height() / f3) + oIX0oI(10);
        String str2 = this.f25280O0Xx;
        canvas.drawText(str2, width2 - (this.f25288X0IIOO.measureText(str2) / f3), height2, this.f25288X0IIOO);
        String string2 = getContext().getString(com.sma.smartv3.co_fit.R.string.effect_of_anaerobic_training);
        IIX0o.oO(string2, "getString(...)");
        canvas.drawText(string2, width2 - (this.f25298XxX0x0xxx.measureText(string2) / f3), height2 + oIX0oI(30), this.f25298XxX0x0xxx);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f25293XX0 = i;
        this.f25272I0X0x0oIo = i2;
        this.f25315xoXoI.setStrokeWidth(this.f25285Oxx0xo);
        this.f25300o00.setStrokeWidth(this.f25285Oxx0xo);
        this.f25284OxI.setStrokeWidth(this.f25285Oxx0xo);
        this.f25281O0xOxO.setStrokeWidth(this.f25285Oxx0xo);
        int i5 = this.f25293XX0;
        float f = this.f25301oI0IIXIo;
        float f2 = 2;
        float f3 = this.f25285Oxx0xo;
        float f4 = (i5 / 2.0f) - ((f * f2) + f3);
        this.f25303oX = f4;
        this.f25274IIX0o.set(((i5 / 2) - f) - f4, f3 * f2, (i5 / 2) - f, f4 + (f3 * f2));
        RectF rectF = this.f25306ooXIXxIX;
        int i6 = this.f25293XX0;
        float f5 = this.f25301oI0IIXIo;
        float f6 = this.f25285Oxx0xo;
        float f7 = this.f25303oX;
        rectF.set((i6 / 2) + f5, f6 * f2, (i6 / 2) + f5 + f7, f7 + (f6 * f2));
        applySkin();
    }

    public final void oxoX(float f, float f2) {
        this.f25296XoX = f;
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
        IIX0o.oO(format, "format(...)");
        this.f25280O0Xx = format;
        this.f25308oxxXoxO = f2;
        invalidate();
    }

    public final void setCenterPoint(float f) {
        this.f25294Xo0 = f;
    }

    public final void setMDistance(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f25295XoI0Ixx0 = str;
    }

    public final void setMKcal(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f25280O0Xx = str;
    }

    public final void setRectWidth(float f) {
        this.f25303oX = f;
    }

    public final void setViewHeight(int i) {
        this.f25272I0X0x0oIo = i;
    }

    public final void setViewWidth(int i) {
        this.f25293XX0 = i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public SportGoalProgressBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ SportGoalProgressBar(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public SportGoalProgressBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f25283Oo = 50.0f;
        this.f25277IXxxXO = true;
        this.f25285Oxx0xo = oIX0oI(12);
        this.f25301oI0IIXIo = oIX0oI(15);
        Paint paint = new Paint();
        this.f25286OxxIIOOXO = paint;
        Paint paint2 = new Paint();
        this.f25275IIXOooo = paint2;
        Paint paint3 = new Paint();
        this.f25315xoXoI = paint3;
        Paint paint4 = new Paint();
        this.f25300o00 = paint4;
        Paint paint5 = new Paint();
        this.f25284OxI = paint5;
        Paint paint6 = new Paint();
        this.f25281O0xOxO = paint6;
        Paint paint7 = new Paint();
        this.f25288X0IIOO = paint7;
        Paint paint8 = new Paint();
        this.f25289XI0IXoo = paint8;
        Paint paint9 = new Paint();
        this.f25290XIxXXX0x0 = paint9;
        Paint paint10 = new Paint();
        this.f25316xxX = paint10;
        Paint paint11 = new Paint();
        this.f25298XxX0x0xxx = paint11;
        this.f25313xXxxox0I = new RectF();
        this.f25274IIX0o = new RectF();
        this.f25306ooXIXxIX = new RectF();
        this.f25310xI = new RectF();
        this.f25305oo0xXOI0I = new RectF();
        this.f25304oo = new RectF();
        this.f25309x0o = Color.parseColor("#FFF3EE");
        this.f25291XOxIOxOx = Color.parseColor("#EAF3F8");
        this.f25282OI0 = Color.parseColor("#FBE8EB");
        this.f25278Io = 100.0f;
        this.f25299o0 = 1.0f;
        this.f25292XX = 100.0f;
        this.f25273I0oOoX = 1.0f;
        this.f25308oxxXoxO = 100.0f;
        this.f25296XoX = 1.0f;
        this.f25312xXOx = new Paint();
        II0xO0(context, attributeSet);
        paint.setAntiAlias(this.f25277IXxxXO);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        paint.setStrokeWidth(this.f25285Oxx0xo);
        paint.setColor(this.f25279IoOoX);
        paint2.setAntiAlias(this.f25277IXxxXO);
        paint2.setStyle(style);
        paint2.setStrokeCap(cap);
        paint2.setStrokeWidth(this.f25285Oxx0xo);
        paint2.setColor(this.f25302oOXoIIIo);
        paint3.setAntiAlias(this.f25277IXxxXO);
        paint3.setStyle(style);
        paint3.setStrokeCap(cap);
        paint3.setStrokeWidth(this.f25285Oxx0xo);
        paint3.setColor(this.f25297Xx000oIo);
        paint4.setAntiAlias(this.f25277IXxxXO);
        paint4.setStyle(style);
        paint4.setStrokeCap(cap);
        paint4.setStrokeWidth(this.f25285Oxx0xo);
        paint4.setColor(this.f25287X00IoxXI);
        paint5.setAntiAlias(this.f25277IXxxXO);
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        paint5.setStrokeWidth(this.f25285Oxx0xo);
        paint5.setColor(this.f25276IO);
        paint6.setAntiAlias(this.f25277IXxxXO);
        paint6.setStyle(style);
        paint6.setStrokeCap(cap);
        paint6.setStrokeWidth(this.f25285Oxx0xo);
        paint6.setColor(this.f25311xII);
        paint8.setAntiAlias(this.f25277IXxxXO);
        Paint.Style style2 = Paint.Style.FILL;
        paint8.setStyle(style2);
        paint8.setColor(this.f25309x0o);
        paint9.setAntiAlias(this.f25277IXxxXO);
        paint9.setStyle(style2);
        paint9.setStrokeWidth(this.f25285Oxx0xo);
        paint9.setColor(this.f25291XOxIOxOx);
        paint10.setAntiAlias(this.f25277IXxxXO);
        paint10.setStyle(style2);
        paint10.setStrokeWidth(this.f25285Oxx0xo);
        paint10.setColor(this.f25282OI0);
        paint7.setAntiAlias(this.f25277IXxxXO);
        paint7.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint7.setTextSize(SizeUtils.dp2px(32.0f));
        paint11.setAntiAlias(this.f25277IXxxXO);
        paint11.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint11.setTextSize(SizeUtils.dp2px(14.0f));
        applySkin();
        this.f25295XoI0Ixx0 = cn.d;
        this.f25280O0Xx = cn.d;
    }
}
