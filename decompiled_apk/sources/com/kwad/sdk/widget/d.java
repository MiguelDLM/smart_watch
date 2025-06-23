package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes11.dex */
public class d extends ViewPager {
    private int aTX;
    private boolean aTY;

    public d(@NonNull Context context) {
        super(context);
        this.aTY = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int i) {
        if (!this.aTY) {
            return false;
        }
        return super.canScrollHorizontally(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.aTY) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int x = (int) motionEvent.getX();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                int i = x - this.aTX;
                if (getCurrentItem() == 0 && i > 0) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
        } else {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        this.aTX = x;
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.aTY && super.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aTY && super.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void setScrollable(boolean z) {
        this.aTY = z;
    }

    public d(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aTY = false;
    }
}
