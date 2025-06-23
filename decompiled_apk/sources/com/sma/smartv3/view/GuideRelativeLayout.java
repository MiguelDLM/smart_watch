package com.sma.smartv3.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.blankj.utilcode.util.LogUtils;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class GuideRelativeLayout extends RelativeLayout {

    /* renamed from: XO, reason: collision with root package name */
    public boolean f25041XO;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public GuideRelativeLayout(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public final boolean oIX0oI() {
        return this.f25041XO;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@OXOo.oOoXoXO MotionEvent motionEvent) {
        if (this.f25041XO) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@OXOo.OOXIXo MotionEvent event) {
        IIX0o.x0xO0oo(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action == 1) {
                LogUtils.i("onTouchEvent" + event.getAction());
            }
        } else {
            LogUtils.i("onTouchEvent" + event.getAction());
        }
        return this.f25041XO;
    }

    public final void setIntercept(boolean z) {
        this.f25041XO = z;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public GuideRelativeLayout(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ GuideRelativeLayout(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public GuideRelativeLayout(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
    }
}
