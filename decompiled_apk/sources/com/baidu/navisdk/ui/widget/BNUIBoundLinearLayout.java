package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.baidu.navisdk.ui.widget.BNUIBoundRelativeLayout;

/* loaded from: classes8.dex */
public class BNUIBoundLinearLayout extends LinearLayout {
    private BNUIBoundRelativeLayout.UIBounderProxy mUIBounderProxy;

    public BNUIBoundLinearLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.mUIBounderProxy = new BNUIBoundRelativeLayout.UIBounderProxy(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mUIBounderProxy.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mUIBounderProxy.onDetachedFromWindow();
    }

    public void setOnGlobalLayoutListener(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.mUIBounderProxy.setOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public BNUIBoundLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public BNUIBoundLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
