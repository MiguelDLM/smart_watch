package com.baidu.mapclient.liteapp.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.ScrollView;
import com.baidu.mapclient.liteapp.custom.BNScrollLayout;

/* loaded from: classes7.dex */
public class BNScrollView extends ScrollView {
    private OnScrollChangedListener listener;

    /* loaded from: classes7.dex */
    public interface OnScrollChangedListener {
        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    public BNScrollView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof BNScrollLayout) {
                ((BNScrollLayout) parent).setAssociatedScrollView(this);
                return;
            }
        }
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollChangedListener onScrollChangedListener = this.listener;
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged(i, i2, i3, i4);
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent = getParent();
        if ((parent instanceof BNScrollLayout) && ((BNScrollLayout) parent).getCurrentStatus() == BNScrollLayout.Status.OPENED) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnScrollChangeListener(OnScrollChangedListener onScrollChangedListener) {
        this.listener = onScrollChangedListener;
    }

    public BNScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BNScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
