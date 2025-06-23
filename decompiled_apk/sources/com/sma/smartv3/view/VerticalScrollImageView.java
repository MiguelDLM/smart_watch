package com.sma.smartv3.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public class VerticalScrollImageView extends AppCompatImageView {

    @OXOo.OOXIXo
    private final String TAG;
    private boolean haveMove;
    private boolean isDragging;
    private float mLastY;

    @OXOo.OOXIXo
    private Rect mParentBounds;
    private Scroller mScroller;
    private int mTouchSlop;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public VerticalScrollImageView(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    @Override // android.view.View
    public void computeScroll() {
        Scroller scroller = this.mScroller;
        Scroller scroller2 = null;
        if (scroller == null) {
            IIX0o.XOxIOxOx("mScroller");
            scroller = null;
        }
        if (scroller.computeScrollOffset()) {
            Scroller scroller3 = this.mScroller;
            if (scroller3 == null) {
                IIX0o.XOxIOxOx("mScroller");
            } else {
                scroller2 = scroller3;
            }
            int currY = scroller2.getCurrY();
            layout(getLeft(), currY, getRight(), getHeight() + currY);
            postInvalidate();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Object parent = getParent();
        if (parent instanceof View) {
            ((View) parent).getHitRect(this.mParentBounds);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@OXOo.oOoXoXO MotionEvent motionEvent) {
        Float f;
        Integer num;
        Scroller scroller = null;
        if (motionEvent != null) {
            f = Float.valueOf(motionEvent.getRawY());
        } else {
            f = null;
        }
        if (motionEvent != null) {
            num = Integer.valueOf(motionEvent.getAction());
        } else {
            num = null;
        }
        int i = 0;
        if (num != null && num.intValue() == 0) {
            this.isDragging = false;
            IIX0o.ooOOo0oXI(f);
            this.mLastY = f.floatValue();
            Scroller scroller2 = this.mScroller;
            if (scroller2 == null) {
                IIX0o.XOxIOxOx("mScroller");
            } else {
                scroller = scroller2;
            }
            scroller.forceFinished(true);
            this.haveMove = false;
        } else if (num != null && num.intValue() == 2) {
            IIX0o.ooOOo0oXI(f);
            float floatValue = f.floatValue() - this.mLastY;
            if (Math.abs(floatValue) > this.mTouchSlop) {
                this.isDragging = true;
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            if (this.isDragging) {
                int top = getTop() + ((int) floatValue);
                if (top >= 0) {
                    int height = getHeight() + top;
                    Rect rect = this.mParentBounds;
                    int i2 = rect.bottom;
                    int i3 = rect.top;
                    if (height > i2 - i3) {
                        i = (i2 - i3) - getHeight();
                    } else {
                        i = top;
                    }
                }
                layout(getLeft(), i, getRight(), getHeight() + i);
                this.haveMove = true;
                this.mLastY = f.floatValue();
            }
        } else if (num != null && num.intValue() == 1) {
            if (!this.haveMove) {
                performClick();
            }
        } else if (num != null && num.intValue() == 3) {
            this.isDragging = false;
        }
        return true;
    }

    public final void smoothScrollTo(int i) {
        int top = getTop();
        int i2 = i - top;
        Scroller scroller = this.mScroller;
        if (scroller == null) {
            IIX0o.XOxIOxOx("mScroller");
            scroller = null;
        }
        scroller.startScroll(0, top, 0, i2, 500);
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public VerticalScrollImageView(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ VerticalScrollImageView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public VerticalScrollImageView(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.TAG = "VerticalScrollImageView";
        this.mParentBounds = new Rect();
        this.mScroller = new Scroller(context);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
