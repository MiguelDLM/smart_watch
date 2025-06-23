package com.github.appintro.internal;

import OXOo.OOXIXo;
import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes9.dex */
public final class ScrollerCustomDuration extends Scroller {
    private double scrollDurationFactor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollerCustomDuration(@OOXIXo Context context, @OOXIXo Interpolator interpolator) {
        super(context, interpolator);
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(interpolator, "interpolator");
        this.scrollDurationFactor = 6.0d;
    }

    public final double getScrollDurationFactor() {
        return this.scrollDurationFactor;
    }

    public final void setScrollDurationFactor(double d) {
        this.scrollDurationFactor = d;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, (int) (i5 * this.scrollDurationFactor));
    }
}
