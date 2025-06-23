package com.sma.smartv3.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public class NoScollViewPager extends ViewPager {
    private boolean canScoll;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public NoScollViewPager(@OXOo.OOXIXo Context context, @OXOo.OOXIXo AttributeSet attrs) {
        super(context, attrs);
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(attrs, "attrs");
        this.canScoll = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@OXOo.OOXIXo MotionEvent ev) {
        IIX0o.x0xO0oo(ev, "ev");
        if (this.canScoll && super.onInterceptTouchEvent(ev)) {
            return true;
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(@OXOo.OOXIXo MotionEvent ev) {
        IIX0o.x0xO0oo(ev, "ev");
        if (this.canScoll && super.onTouchEvent(ev)) {
            return true;
        }
        return false;
    }

    public final void setCanScoll(boolean z) {
        this.canScoll = z;
    }
}
