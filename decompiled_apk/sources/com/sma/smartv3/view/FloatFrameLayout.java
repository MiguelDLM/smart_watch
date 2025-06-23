package com.sma.smartv3.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class FloatFrameLayout extends FrameLayout {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public float f24906IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public float f24907Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.x0xO0oo<? super View, ? super MotionEvent, oXIO0o0XI> f24908Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f24909XO;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public FloatFrameLayout(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    @OXOo.oOoXoXO
    public final Oox.x0xO0oo<View, MotionEvent, oXIO0o0XI> getOnTouchList() {
        return this.f24908Oxx0xo;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@OXOo.OOXIXo MotionEvent ev) {
        IIX0o.x0xO0oo(ev, "ev");
        float x = ev.getX();
        float y = ev.getY();
        Oox.x0xO0oo<? super View, ? super MotionEvent, oXIO0o0XI> x0xo0oo = this.f24908Oxx0xo;
        if (x0xo0oo != null) {
            x0xo0oo.invoke(this, ev);
        }
        int action = ev.getAction();
        if (action != 0) {
            if (action == 1 || action != 2) {
                return false;
            }
            float abs = (float) Math.abs(x - this.f24907Oo);
            float abs2 = (float) Math.abs(y - this.f24906IXxxXO);
            int i = this.f24909XO;
            if (abs <= i && abs2 <= i) {
                return false;
            }
            return true;
        }
        this.f24907Oo = x;
        this.f24906IXxxXO = y;
        return false;
    }

    public final void setOnTouchList(@OXOo.oOoXoXO Oox.x0xO0oo<? super View, ? super MotionEvent, oXIO0o0XI> x0xo0oo) {
        this.f24908Oxx0xo = x0xo0oo;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public FloatFrameLayout(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ FloatFrameLayout(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public FloatFrameLayout(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f24909XO = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
