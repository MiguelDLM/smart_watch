package com.sma.smartv3.otherdevice.jl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: classes12.dex */
public class ViewPager2RecycleView extends RecyclerView {
    private MotionEvent mDownEvent;
    private float mStartX;

    public ViewPager2RecycleView(@NonNull Context context) {
        super(context);
        this.mDownEvent = null;
    }

    private ViewPager2 getViewPager2() {
        ViewParent viewParent = this;
        do {
            viewParent = viewParent.getParent();
            if (viewParent == null) {
                return null;
            }
        } while (!(viewParent instanceof ViewPager2));
        return (ViewPager2) viewParent;
    }

    private void setViewPager2InputEnable(boolean enable) {
        ViewPager2 viewPager2 = getViewPager2();
        if (viewPager2 != null) {
            viewPager2.setUserInputEnabled(enable);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent e) {
        int action = e.getAction();
        if (action == 0) {
            this.mDownEvent = e;
            this.mStartX = e.getX();
            setViewPager2InputEnable(false);
        } else if (action != 1 && action != 3) {
            if (action == 2 && this.mDownEvent != null) {
                float x = e.getX() - this.mStartX;
                boolean canScrollHorizontally = canScrollHorizontally(1);
                boolean canScrollHorizontally2 = canScrollHorizontally(-1);
                if (x < 0.0f) {
                    setViewPager2InputEnable(!canScrollHorizontally);
                } else {
                    setViewPager2InputEnable(!canScrollHorizontally2);
                }
                this.mDownEvent = null;
            }
        } else {
            setViewPager2InputEnable(true);
            this.mDownEvent = null;
        }
        return super.dispatchTouchEvent(e);
    }

    public ViewPager2RecycleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mDownEvent = null;
    }

    public ViewPager2RecycleView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mDownEvent = null;
    }
}
