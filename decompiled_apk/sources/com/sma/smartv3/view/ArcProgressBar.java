package com.sma.smartv3.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import com.blankj.utilcode.util.SizeUtils;
import com.sma.smartv3.R;
import com.sma.smartv3.util.xxIO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import skin.support.widget.SkinCompatView;

/* loaded from: classes12.dex */
public final class ArcProgressBar extends SkinCompatView {

    /* renamed from: IIX0o, reason: collision with root package name */
    public float f24771IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public final float f24772IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f24773IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public int f24774O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public int f24775Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public float f24776OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24777Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Xfermode f24778OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public int f24779X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f24780XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public int f24781XIxXXX0x0;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public int f24782XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public int f24783o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f24784oI0IIXIo;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public final long f24785ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public final float f24786xI;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    @OXOo.OOXIXo
    public ValueAnimator f24787xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f24788xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public int f24789xxX;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public ArcProgressBar(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public static final void X0o0xo(ArcProgressBar this$0, ValueAnimator animation) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        IIX0o.x0XOIxOo(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.f24771IIX0o = floatValue;
        this$0.setProgress(floatValue);
    }

    public final void I0Io(int i, int i2) {
        float f = (i / i2) * 100;
        float f2 = this.f24786xI;
        if (f > f2) {
            f = f2;
        }
        oxoX(this.f24771IIX0o, f / f2, this.f24785ooXIXxIX);
    }

    public final void II0xO0(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ArcProgressBar);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f24781XIxXXX0x0 = obtainStyledAttributes.getResourceId(5, 0);
        this.f24782XxX0x0xxx = obtainStyledAttributes.getResourceId(2, 0);
        this.f24783o00 = obtainStyledAttributes.getDimensionPixelSize(1, this.f24783o00);
        this.f24788xoXoI = obtainStyledAttributes.getDimensionPixelSize(3, this.f24788xoXoI);
        this.f24776OxI = obtainStyledAttributes.getFloat(4, this.f24776OxI);
        this.f24779X0IIOO = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // skin.support.widget.SkinCompatView, xxoXO.Oxx0IOOO
    public void applySkin() {
        super.applySkin();
        Context context = getContext();
        IIX0o.oO(context, "getContext(...)");
        this.f24774O0xOxO = xxIO.II0xO0(context, this.f24779X0IIOO);
        Context context2 = getContext();
        IIX0o.oO(context2, "getContext(...)");
        this.f24780XI0IXoo = xxIO.II0xO0(context2, this.f24781XIxXXX0x0);
        Context context3 = getContext();
        IIX0o.oO(context3, "getContext(...)");
        this.f24789xxX = xxIO.II0xO0(context3, this.f24782XxX0x0xxx);
    }

    @Override // android.view.View
    public void onDraw(@OXOo.OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        int saveLayer = canvas.saveLayer(null, null, 31);
        Paint paint = this.f24777Oxx0xo;
        paint.setXfermode(null);
        paint.setColor(this.f24774O0xOxO);
        paint.setShader(null);
        RectF rectF = this.f24784oI0IIXIo;
        float f = this.f24772IIXOooo;
        rectF.set(f, f, this.f24775Oo - f, this.f24773IXxxXO - f);
        RectF rectF2 = this.f24784oI0IIXIo;
        int i = this.f24783o00;
        canvas.drawRoundRect(rectF2, i, i, this.f24777Oxx0xo);
        Paint paint2 = this.f24777Oxx0xo;
        paint2.setXfermode(this.f24778OxxIIOOXO);
        float f2 = this.f24772IIXOooo;
        paint2.setShader(new LinearGradient(f2, f2, (this.f24775Oo - f2) * this.f24776OxI, this.f24773IXxxXO - f2, this.f24780XI0IXoo, this.f24789xxX, Shader.TileMode.CLAMP));
        RectF rectF3 = this.f24784oI0IIXIo;
        float f3 = this.f24772IIXOooo;
        rectF3.set(f3, f3, (this.f24775Oo - f3) * this.f24776OxI, this.f24773IXxxXO - f3);
        try {
            RectF rectF4 = this.f24784oI0IIXIo;
            int i2 = this.f24788xoXoI;
            canvas.drawRoundRect(rectF4, i2, i2, this.f24777Oxx0xo);
            if (this.f24776OxI == 1.0f) {
                RectF rectF5 = this.f24784oI0IIXIo;
                int i3 = this.f24783o00;
                canvas.drawRoundRect(rectF5, i3, i3, this.f24777Oxx0xo);
            } else {
                Path path = new Path();
                RectF rectF6 = this.f24784oI0IIXIo;
                int i4 = this.f24783o00;
                int i5 = this.f24788xoXoI;
                path.addRoundRect(rectF6, new float[]{i4, i4, i5, i5, i5, i5, i4, i4}, Path.Direction.CW);
                canvas.drawPath(path, this.f24777Oxx0xo);
            }
        } catch (Exception unused) {
        }
        canvas.restoreToCount(saveLayer);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f24775Oo = i;
        this.f24773IXxxXO = i2;
        applySkin();
    }

    public final void oxoX(float f, float f2, long j) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        IIX0o.oO(ofFloat, "ofFloat(...)");
        this.f24787xXxxox0I = ofFloat;
        ofFloat.setDuration(j);
        this.f24787xXxxox0I.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sma.smartv3.view.I0Io
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ArcProgressBar.X0o0xo(ArcProgressBar.this, valueAnimator);
            }
        });
        this.f24787xXxxox0I.start();
    }

    public final void setProgress(float f) {
        this.f24776OxI = f;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public ArcProgressBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ ArcProgressBar(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public ArcProgressBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        Paint paint = new Paint();
        this.f24777Oxx0xo = paint;
        this.f24784oI0IIXIo = new RectF();
        this.f24778OxxIIOOXO = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.f24772IIXOooo = SizeUtils.dp2px(1.0f);
        this.f24788xoXoI = SizeUtils.dp2px(1.0f);
        this.f24783o00 = SizeUtils.dp2px(1.0f);
        this.f24776OxI = 0.05f;
        this.f24787xXxxox0I = new ValueAnimator();
        this.f24785ooXIXxIX = 1000L;
        this.f24786xI = 100.0f;
        II0xO0(context, attributeSet);
        paint.setAntiAlias(true);
        paint.setDither(true);
        applySkin();
    }
}
