package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: classes8.dex */
public class MaxHeightRelativeLayout extends RelativeLayout {
    private int mMaxHeight;

    public MaxHeightRelativeLayout(Context context) {
        super(context);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.mMaxHeight;
        if (size > i3) {
            size = i3;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i) {
        this.mMaxHeight = i;
        requestLayout();
    }

    public MaxHeightRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MaxHeightRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
