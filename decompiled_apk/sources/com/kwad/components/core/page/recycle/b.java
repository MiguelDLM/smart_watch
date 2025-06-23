package com.kwad.components.core.page.recycle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes11.dex */
public class b extends g {
    private Rect PY;
    private int PZ;
    private int Qa;
    private boolean Qb;
    private int Qc;
    private a Qd;
    private boolean Qe;
    private boolean Qf;

    /* loaded from: classes11.dex */
    public interface a {
        boolean qq();
    }

    public b(Context context) {
        this(context, null);
    }

    private void a(int i, int i2, int i3) {
        while (true) {
            if (this.Qc == Integer.MIN_VALUE) {
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                this.Qc = iArr[1];
            }
            int findFirstVisibleItemPosition = f.b(this).findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = f.b(this).findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition != -1 && findLastVisibleItemPosition != -1) {
                if (i >= findFirstVisibleItemPosition && i <= findLastVisibleItemPosition) {
                    int i4 = i - findFirstVisibleItemPosition;
                    if (getChildCount() > i4) {
                        int[] iArr2 = new int[2];
                        getChildAt(i4).getLocationOnScreen(iArr2);
                        scrollBy(0, (iArr2[1] - this.Qc) - i3);
                        return;
                    }
                    return;
                }
                if (i > findLastVisibleItemPosition) {
                    scrollBy(0, i2);
                    a(i, i2, i3);
                    return;
                }
                scrollBy(0, -i2);
            } else {
                return;
            }
        }
    }

    private void qo() {
        Rect rect = this.PY;
        if (rect == null) {
            this.PY = new Rect();
        } else {
            rect.setEmpty();
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                this.PY.union(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            }
        }
    }

    private void qp() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter instanceof d) {
            ((d) adapter).qt();
        }
    }

    private void scrollToPositionWithOffset(int i, int i2) {
        a(i, getHeight(), 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        qp();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.PZ != 0) {
            qo();
            Rect rect = this.PY;
            if (rect != null && !rect.isEmpty()) {
                canvas.save();
                canvas.clipRect(this.PY);
                canvas.drawColor(this.PZ);
                canvas.restore();
            }
        }
        super.onDraw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Qe) {
            return false;
        }
        if (motionEvent.getAction() == 0 && this.Qf) {
            stopScroll();
        }
        a aVar = this.Qd;
        if (aVar != null && aVar.qq()) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.Qa;
        if (i3 > 0 && i3 < size) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.Qa, View.MeasureSpec.getMode(i2));
        }
        super.onMeasure(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Qe) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i) {
        if (this.Qb) {
            scrollToPositionWithOffset(i, 0);
        } else {
            super.scrollToPosition(i);
        }
    }

    public void setDisableScroll(boolean z) {
        this.Qe = z;
    }

    public void setDownStop(boolean z) {
        this.Qf = z;
    }

    public void setIgnoreTouchSwipeHandler(a aVar) {
        this.Qd = aVar;
    }

    public void setUnderneathColor(int i) {
        this.PZ = i;
        qo();
        invalidate();
    }

    public void setUseCustomScrollToPosition(boolean z) {
        this.Qb = z;
    }

    public b(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Qc = Integer.MIN_VALUE;
        this.Qf = false;
    }
}
