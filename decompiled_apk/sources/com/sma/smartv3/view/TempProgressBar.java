package com.sma.smartv3.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.blankj.utilcode.util.SizeUtils;
import com.sma.smartv3.R;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.xxIO;
import com.sma.smartv3.view.text.MyTypeface;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import skin.support.widget.SkinCompatView;

/* loaded from: classes12.dex */
public final class TempProgressBar extends SkinCompatView {

    /* renamed from: IIX0o, reason: collision with root package name */
    public int f25364IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25365IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25366IXxxXO;

    /* renamed from: IoOoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public List<String> f25367IoOoX;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public float f25368O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f25369Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public float f25370OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25371Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public float f25372OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public float f25373X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public float f25374XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public float f25375XIxXXX0x0;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public float f25376XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public int f25377o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public final float f25378oI0IIXIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public float f25379oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public int f25380oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f25381oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public int f25382ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public int f25383xI;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public int f25384xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25385xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public float f25386xxX;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public TempProgressBar(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    private final void II0xO0(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TempProgressBar);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f25369Oo = obtainStyledAttributes.getBoolean(0, true);
        this.f25384xXxxox0I = obtainStyledAttributes.getResourceId(5, 0);
        this.f25364IIX0o = obtainStyledAttributes.getColor(1, -1);
        this.f25382ooXIXxIX = obtainStyledAttributes.getColor(3, -1);
        this.f25383xI = obtainStyledAttributes.getColor(2, -1);
        this.f25381oo0xXOI0I = obtainStyledAttributes.getColor(6, -1);
        this.f25380oo = obtainStyledAttributes.getColor(4, -1);
        obtainStyledAttributes.recycle();
    }

    private final float oIX0oI(int i) {
        return SizeUtils.dp2px(i);
    }

    private final float oxoX(int i) {
        return SizeUtils.sp2px(i);
    }

    public final void I0Io(int i, boolean z) {
        float Oxx0xo2 = TextConvertKt.Oxx0xo(i, z);
        this.f25367IoOoX.clear();
        List<String> list = this.f25367IoOoX;
        Context context = getContext();
        IIX0o.oO(context, "getContext(...)");
        list.add(TextConvertKt.O0xOxO(context, 36.0f, z));
        List<String> list2 = this.f25367IoOoX;
        Context context2 = getContext();
        IIX0o.oO(context2, "getContext(...)");
        list2.add(TextConvertKt.O0xOxO(context2, 37.4f, z));
        float XIxXXX0x02 = TextConvertKt.XIxXXX0x0(35.0f, z);
        float XIxXXX0x03 = TextConvertKt.XIxXXX0x0(38.0f, z);
        if (Oxx0xo2 < XIxXXX0x02) {
            Oxx0xo2 = XIxXXX0x02;
        }
        if (Oxx0xo2 > XIxXXX0x03) {
            Oxx0xo2 = XIxXXX0x03;
        }
        this.f25379oOXoIIIo = (Oxx0xo2 - XIxXXX0x02) / (XIxXXX0x03 - XIxXXX0x02);
        invalidate();
    }

    @Override // skin.support.widget.SkinCompatView, xxoXO.Oxx0IOOO
    public void applySkin() {
        super.applySkin();
        Context context = getContext();
        IIX0o.oO(context, "getContext(...)");
        xxIO.oIX0oI(context, this.f25371Oxx0xo, this.f25384xXxxox0I);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(@OXOo.OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        if (this.f25367IoOoX.size() > 1) {
            float f = 20;
            canvas.drawText(this.f25367IoOoX.get(0), this.f25375XIxXXX0x0 - f, this.f25378oI0IIXIo, this.f25371Oxx0xo);
            canvas.drawText(this.f25367IoOoX.get(1), this.f25386xxX - f, this.f25378oI0IIXIo, this.f25371Oxx0xo);
        }
        this.f25366IXxxXO.setColor(this.f25383xI);
        canvas.drawRect(0.0f, this.f25370OxI, this.f25375XIxXXX0x0, this.f25373X0IIOO, this.f25366IXxxXO);
        this.f25366IXxxXO.setColor(this.f25381oo0xXOI0I);
        canvas.drawRect(this.f25375XIxXXX0x0, this.f25370OxI, this.f25386xxX, this.f25373X0IIOO, this.f25366IXxxXO);
        this.f25366IXxxXO.setColor(this.f25380oo);
        canvas.drawRect(this.f25386xxX, this.f25370OxI, this.f25376XxX0x0xxx, this.f25373X0IIOO, this.f25366IXxxXO);
        this.f25385xoXoI.setColor(this.f25382ooXIXxIX);
        float f2 = this.f25377o00 * this.f25379oOXoIIIo;
        float f3 = this.f25374XI0IXoo;
        float f4 = 2;
        float f5 = this.f25370OxI;
        canvas.drawCircle(f2 - (f3 / f4), f5 + ((this.f25373X0IIOO - f5) / f4), f3 / f4, this.f25385xoXoI);
        this.f25385xoXoI.setColor(this.f25364IIX0o);
        float f6 = this.f25377o00 * this.f25379oOXoIIIo;
        float f7 = this.f25374XI0IXoo;
        float f8 = this.f25370OxI;
        canvas.drawCircle(f6 - (f7 / f4), f8 + ((this.f25373X0IIOO - f8) / f4), (f7 / f4) - f4, this.f25385xoXoI);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        this.f25377o00 = size;
        this.f25375XIxXXX0x0 = 0.33333334f * size;
        this.f25386xxX = 0.8000005f * size;
        this.f25376XxX0x0xxx = 1.0f * size;
        float f = this.f25373X0IIOO;
        float f2 = this.f25368O0xOxO;
        this.f25373X0IIOO = f + f2;
        this.f25374XI0IXoo += f2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public TempProgressBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ TempProgressBar(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public TempProgressBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f25369Oo = true;
        Paint paint = new Paint();
        this.f25366IXxxXO = paint;
        Paint paint2 = new Paint();
        this.f25371Oxx0xo = paint2;
        float oxoX2 = oxoX(10);
        this.f25378oI0IIXIo = oxoX2;
        this.f25372OxxIIOOXO = oIX0oI(6);
        Paint paint3 = new Paint();
        this.f25365IIXOooo = paint3;
        Paint paint4 = new Paint();
        this.f25385xoXoI = paint4;
        this.f25370OxI = oIX0oI(12) + this.f25372OxxIIOOXO;
        this.f25368O0xOxO = oIX0oI(1);
        this.f25373X0IIOO = this.f25370OxI;
        this.f25374XI0IXoo = oIX0oI(4);
        this.f25367IoOoX = new ArrayList();
        II0xO0(context, attributeSet);
        paint.setAntiAlias(this.f25369Oo);
        paint2.setAntiAlias(this.f25369Oo);
        OOxOI.oIX0oI oix0oi = OOxOI.oIX0oI.f1804oIX0oI;
        paint2.setTypeface(oix0oi.oIX0oI(MyTypeface.DIN_COND_BOLD, context));
        paint2.setColor(this.f25384xXxxox0I);
        paint2.setTextSize(oxoX2);
        paint3.setAntiAlias(this.f25369Oo);
        paint3.setTypeface(oix0oi.oIX0oI(MyTypeface.PF_MEDIUM, context));
        paint3.setTextSize(oxoX2);
        paint4.setAntiAlias(this.f25369Oo);
        applySkin();
    }
}
