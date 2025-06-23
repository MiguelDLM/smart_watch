package com.angcyo.dsladapter.internal;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

/* loaded from: classes7.dex */
public final class XO {

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final /* synthetic */ kotlin.reflect.x0XOIxOo<Object>[] f5402xxIXOIIO = {IO.OOXIXo(new MutablePropertyReference1Impl(XO.class, "textPaint", "getTextPaint()Landroid/text/TextPaint;", 0)), IO.OOXIXo(new MutablePropertyReference1Impl(XO.class, "drawText", "getDrawText()Ljava/lang/CharSequence;", 0)), IO.OOXIXo(new MutablePropertyReference1Impl(XO.class, "textWidth", "getTextWidth()I", 0)), IO.OOXIXo(new MutablePropertyReference1Impl(XO.class, "spacingMult", "getSpacingMult()F", 0)), IO.OOXIXo(new MutablePropertyReference1Impl(XO.class, "spacingAdd", "getSpacingAdd()F", 0)), IO.OOXIXo(new MutablePropertyReference1Impl(XO.class, "includePad", "getIncludePad()Z", 0)), IO.OOXIXo(new MutablePropertyReference1Impl(XO.class, "alignment", "getAlignment()Landroid/text/Layout$Alignment;", 0))};

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.oOoXoXO
    public StaticLayout f5404II0XooXoX;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final oIX0oI f5409oIX0oI = new oIX0oI(new TextPaint(1));

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final oIX0oI f5405II0xO0 = new oIX0oI(null);

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final oIX0oI f5403I0Io = new oIX0oI(-2);

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final oIX0oI f5410oxoX = new oIX0oI(Float.valueOf(1.0f));

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final oIX0oI f5407X0o0xo = new oIX0oI(Float.valueOf(0.0f));

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final oIX0oI f5408XO = new oIX0oI(Boolean.FALSE);

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final oIX0oI f5406Oxx0IOOO = new oIX0oI(Layout.Alignment.ALIGN_NORMAL);

    /* loaded from: classes7.dex */
    public static final class oIX0oI<T> implements xOxOoo.XO<XO, T> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public T f5411oIX0oI;

        public oIX0oI(T t) {
            this.f5411oIX0oI = t;
        }

        public final T I0Io() {
            return this.f5411oIX0oI;
        }

        @Override // xOxOoo.XO
        /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
        public void II0xO0(@OXOo.OOXIXo XO thisRef, @OXOo.OOXIXo kotlin.reflect.x0XOIxOo<?> property, T t) {
            IIX0o.x0xO0oo(thisRef, "thisRef");
            IIX0o.x0xO0oo(property, "property");
            this.f5411oIX0oI = t;
            thisRef.IIXOooo(null);
        }

        public final void XO(T t) {
            this.f5411oIX0oI = t;
        }

        @Override // xOxOoo.XO, xOxOoo.X0o0xo
        /* renamed from: oxoX, reason: merged with bridge method [inline-methods] */
        public T oIX0oI(@OXOo.OOXIXo XO thisRef, @OXOo.OOXIXo kotlin.reflect.x0XOIxOo<?> property) {
            IIX0o.x0xO0oo(thisRef, "thisRef");
            IIX0o.x0xO0oo(property, "property");
            return this.f5411oIX0oI;
        }
    }

    @OXOo.OOXIXo
    public final Rect I0Io(@OXOo.OOXIXo Rect rect) {
        IIX0o.x0xO0oo(rect, "rect");
        StaticLayout ooOOo0oXI2 = ooOOo0oXI();
        rect.set(0, 0, ooOOo0oXI2.getWidth(), ooOOo0oXI2.getHeight());
        return rect;
    }

    public final float II0XooXoX() {
        return ((Number) this.f5410oxoX.oIX0oI(this, f5402xxIXOIIO[3])).floatValue();
    }

    @OXOo.oOoXoXO
    public final Layout.Alignment II0xO0() {
        return (Layout.Alignment) this.f5406Oxx0IOOO.oIX0oI(this, f5402xxIXOIIO[6]);
    }

    public final void IIXOooo(@OXOo.oOoXoXO StaticLayout staticLayout) {
        this.f5404II0XooXoX = staticLayout;
    }

    public final void IXxxXO(float f) {
        this.f5407X0o0xo.II0xO0(this, f5402xxIXOIIO[4], Float.valueOf(f));
    }

    public final int OOXIXo() {
        return ooOOo0oXI().getWidth();
    }

    public final void Oo(boolean z) {
        this.f5408XO.II0xO0(this, f5402xxIXOIIO[5], Boolean.valueOf(z));
    }

    public final float Oxx0IOOO() {
        return ((Number) this.f5407X0o0xo.oIX0oI(this, f5402xxIXOIIO[4])).floatValue();
    }

    public final void Oxx0xo(float f) {
        this.f5410oxoX.II0xO0(this, f5402xxIXOIIO[3], Float.valueOf(f));
    }

    public final void OxxIIOOXO(int i) {
        this.f5403I0Io.II0xO0(this, f5402xxIXOIIO[2], Integer.valueOf(i));
    }

    public final int X0o0xo() {
        return ooOOo0oXI().getHeight();
    }

    public final boolean XO() {
        return ((Boolean) this.f5408XO.oIX0oI(this, f5402xxIXOIIO[5])).booleanValue();
    }

    public final void oI0IIXIo(@OXOo.OOXIXo TextPaint textPaint) {
        IIX0o.x0xO0oo(textPaint, "<set-?>");
        this.f5409oIX0oI.II0xO0(this, f5402xxIXOIIO[0], textPaint);
    }

    @OXOo.OOXIXo
    public final StaticLayout oIX0oI(int i) {
        StaticLayout staticLayout;
        StaticLayout.Builder obtain;
        CharSequence oxoX2 = oxoX();
        if (oxoX2 == null) {
            oxoX2 = "";
        }
        CharSequence charSequence = oxoX2;
        if (Build.VERSION.SDK_INT >= 23) {
            obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), xxIXOIIO(), i);
            Layout.Alignment II0xO02 = II0xO0();
            if (II0xO02 != null) {
                obtain.setAlignment(II0xO02);
            }
            obtain.setLineSpacing(Oxx0IOOO(), II0XooXoX());
            obtain.setIncludePad(XO());
            staticLayout = obtain.build();
        } else {
            staticLayout = new StaticLayout(charSequence, xxIXOIIO(), i, II0xO0(), II0XooXoX(), Oxx0IOOO(), XO());
        }
        IIX0o.oO(staticLayout, "if (Build.VERSION.SDK_IN…dd, includePad)\n        }");
        return staticLayout;
    }

    public final void oO(@OXOo.oOoXoXO Layout.Alignment alignment) {
        this.f5406Oxx0IOOO.II0xO0(this, f5402xxIXOIIO[6], alignment);
    }

    @OXOo.oOoXoXO
    public final StaticLayout oOoXoXO() {
        return this.f5404II0XooXoX;
    }

    @OXOo.OOXIXo
    public final StaticLayout ooOOo0oXI() {
        int i;
        if (xoIox() >= 0) {
            i = xoIox();
        } else {
            i = Integer.MAX_VALUE;
        }
        StaticLayout oIX0oI2 = oIX0oI(i);
        this.f5404II0XooXoX = oIX0oI2;
        if (xoIox() < 0) {
            int lineCount = oIX0oI2.getLineCount();
            float f = 0.0f;
            for (int i2 = 0; i2 < lineCount; i2++) {
                f = Math.max(oIX0oI2.getLineWidth(i2), f);
            }
            this.f5404II0XooXoX = oIX0oI((int) f);
        }
        StaticLayout staticLayout = this.f5404II0XooXoX;
        IIX0o.ooOOo0oXI(staticLayout);
        return staticLayout;
    }

    @OXOo.oOoXoXO
    public final CharSequence oxoX() {
        return (CharSequence) this.f5405II0xO0.oIX0oI(this, f5402xxIXOIIO[1]);
    }

    public final void x0XOIxOo(@OXOo.OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        CharSequence oxoX2 = oxoX();
        if (oxoX2 != null && oxoX2.length() != 0) {
            StaticLayout staticLayout = this.f5404II0XooXoX;
            if (staticLayout == null) {
                staticLayout = ooOOo0oXI();
            }
            staticLayout.draw(canvas);
        }
    }

    public final void x0xO0oo(@OXOo.oOoXoXO CharSequence charSequence) {
        this.f5405II0xO0.II0xO0(this, f5402xxIXOIIO[1], charSequence);
    }

    public final int xoIox() {
        return ((Number) this.f5403I0Io.oIX0oI(this, f5402xxIXOIIO[2])).intValue();
    }

    @OXOo.OOXIXo
    public final TextPaint xxIXOIIO() {
        return (TextPaint) this.f5409oIX0oI.oIX0oI(this, f5402xxIXOIIO[0]);
    }
}
