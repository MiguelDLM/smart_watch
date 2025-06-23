package com.kwad.components.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.kwad.components.core.s.o;
import com.kwad.sdk.utils.s;

/* loaded from: classes11.dex */
public class DetailWebRecycleView extends b {
    private int Qg;
    private boolean Qh;
    private boolean Qi;
    private int Qj;
    private int Qk;
    private boolean Ql;
    a Qm;
    private Runnable Qn;
    private o Qo;
    private int mf;

    /* loaded from: classes11.dex */
    public interface a {
        boolean qr();
    }

    public DetailWebRecycleView(Context context) {
        this(context, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this.Qo, 50L);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.Qo);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar = this.Qm;
        if (aVar != null && aVar.qr()) {
            return true;
        }
        this.Qk = computeVerticalScrollOffset();
        if (motionEvent.getY() <= this.Qj - this.Qk) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.Qk = computeVerticalScrollOffset;
        if (computeVerticalScrollOffset >= this.Qj) {
            return false;
        }
        fling((int) f, (int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.Qk = computeVerticalScrollOffset;
        if (i2 > 0 && computeVerticalScrollOffset < this.Qj && !this.Ql && computeVerticalScrollOffset < this.mf) {
            scrollBy(0, i2);
            iArr[1] = i2;
        }
        if (i2 < 0 && this.Qk > 0 && !ViewCompat.canScrollVertically(view, -1)) {
            scrollBy(0, i2);
            iArr[1] = i2;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        super.onScrollStateChanged(i);
        if (i == 0) {
            View childAt = getLayoutManager().getChildAt(getLayoutManager().getChildCount() - 1);
            if (childAt != null) {
                int bottom = childAt.getBottom();
                int bottom2 = getBottom() - getPaddingBottom();
                int position = getLayoutManager().getPosition(childAt);
                if (bottom == bottom2 && position == getLayoutManager().getItemCount() - 1) {
                    this.Ql = true;
                    return;
                }
            }
            this.Ql = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.Qi) {
            this.Qi = false;
        } else if (!this.Qh) {
            super.requestChildFocus(view, view2);
        }
    }

    public void setInterceptRequestFocusForWeb(boolean z) {
        this.Qh = z;
    }

    public void setInterceptRequestFocusForWebFiredOnce(boolean z) {
        this.Qi = z;
    }

    public void setInterceptTouchListener(a aVar) {
        this.Qm = aVar;
    }

    public void setTopViewHeight(int i) {
        this.Qj = i;
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Qg = 1000;
        this.Qh = false;
        this.Qi = false;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.page.recycle.DetailWebRecycleView.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Object field = s.getField(DetailWebRecycleView.this, "mGapWorker");
                    if (field != null) {
                        s.callMethod(field, "postFromTraversal", DetailWebRecycleView.this, 0, Integer.valueOf(DetailWebRecycleView.this.Qg));
                    }
                } catch (RuntimeException e) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                }
            }
        };
        this.Qn = runnable;
        this.Qo = new o(runnable);
        if (context instanceof Activity) {
            this.mf = com.kwad.sdk.c.a.a.e((Activity) context);
        } else {
            this.mf = com.kwad.sdk.c.a.a.getScreenHeight(context);
        }
    }
}
