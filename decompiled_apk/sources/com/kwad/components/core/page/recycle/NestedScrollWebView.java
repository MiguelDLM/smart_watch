package com.kwad.components.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.VelocityTrackerCompat;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: classes11.dex */
public class NestedScrollWebView extends KsAdWebView implements NestedScrollingChild {
    private int QA;
    private int Qq;
    private int Qr;
    private final int[] Qs;
    private final int[] Qt;
    private int Qu;
    private boolean Qv;
    private int Qw;
    private int Qx;
    private NestedScrollingChildHelper Qy;
    private VelocityTracker Qz;

    public NestedScrollWebView(Context context) {
        super(context);
        this.Qs = new int[2];
        this.Qt = new int[2];
        qs();
    }

    private void qs() {
        this.QA = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.Qy = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.Qx = viewConfiguration.getScaledMaximumFlingVelocity();
        this.Qw = viewConfiguration.getScaledMinimumFlingVelocity();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.Qy.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.Qy.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.Qy.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.Qy.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.Qy.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.Qy.isNestedScrollingEnabled();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int screenHeight;
        if (this.QA != 0) {
            if (com.kwad.components.core.s.d.rG()) {
                i3 = com.kwad.sdk.c.a.a.getStatusBarHeight(getContext());
            } else {
                i3 = 0;
            }
            if (getContext() instanceof Activity) {
                screenHeight = com.kwad.sdk.c.a.a.e((Activity) getContext());
            } else {
                screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
            }
            i2 = View.MeasureSpec.makeMeasureSpec((screenHeight - i3) - this.QA, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (!hasFocus()) {
            requestFocus();
        }
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent;
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        boolean z = false;
        if (actionMasked == 0) {
            this.Qu = 0;
        }
        if (this.Qz == null) {
            this.Qz = VelocityTracker.obtain();
        }
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        int y = (int) motionEvent.getY();
        motionEvent.offsetLocation(0.0f, this.Qu);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 5) {
                            stopNestedScroll();
                            onTouchEvent = super.onTouchEvent(motionEvent);
                        }
                        onTouchEvent = false;
                    }
                } else {
                    int i = this.Qq - y;
                    if (dispatchNestedPreScroll(0, i, this.Qt, this.Qs)) {
                        i -= this.Qt[1];
                        obtain.offsetLocation(0.0f, this.Qs[1]);
                        this.Qu += this.Qs[1];
                    }
                    int scrollY = getScrollY();
                    this.Qq = y - this.Qs[1];
                    int max = Math.max(0, scrollY + i);
                    int i2 = i - (max - scrollY);
                    if (dispatchNestedScroll(0, max - i2, 0, i2, this.Qs)) {
                        int i3 = this.Qq;
                        int i4 = this.Qs[1];
                        this.Qq = i3 - i4;
                        obtain.offsetLocation(0.0f, i4);
                        this.Qu += this.Qs[1];
                    }
                    if (Math.abs(this.Qt[1]) < 5 && Math.abs(this.Qs[1]) < 5) {
                        if (this.Qv) {
                            this.Qv = false;
                            onTouchEvent = false;
                        } else {
                            onTouchEvent = super.onTouchEvent(obtain);
                        }
                        obtain.recycle();
                    } else {
                        if (!this.Qv) {
                            this.Qv = true;
                            super.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
                        }
                        onTouchEvent = false;
                    }
                }
            }
            this.Qz.addMovement(motionEvent);
            this.Qz.computeCurrentVelocity(1000, this.Qx);
            float f = -VelocityTrackerCompat.getYVelocity(this.Qz, MotionEventCompat.getPointerId(motionEvent, actionIndex));
            if (Math.abs(f) > this.Qw && !dispatchNestedPreFling(0.0f, f) && hasNestedScrollingParent()) {
                dispatchNestedFling(0.0f, f, true);
            }
            boolean onTouchEvent2 = super.onTouchEvent(motionEvent);
            stopNestedScroll();
            if (Math.abs(motionEvent.getY() - this.Qq) < 10.0f) {
                Math.abs(motionEvent.getX() - this.Qr);
            }
            onTouchEvent = onTouchEvent2;
            z = true;
        } else {
            this.Qq = y;
            this.Qr = (int) motionEvent.getX();
            startNestedScroll(2);
            int[] iArr = this.Qt;
            iArr[0] = 0;
            iArr[1] = 0;
            int[] iArr2 = this.Qs;
            iArr2[0] = 0;
            iArr2[1] = 0;
            onTouchEvent = super.onTouchEvent(motionEvent);
            this.Qv = false;
        }
        if (!z) {
            this.Qz.addMovement(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.Qy.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.Qy.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.Qy.stopNestedScroll();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Qs = new int[2];
        this.Qt = new int[2];
        qs();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Qs = new int[2];
        this.Qt = new int[2];
        qs();
    }
}
