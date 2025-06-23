package com.baidu.navisdk.ui.widget.nestedscroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* loaded from: classes8.dex */
public class BlankLinearLayout extends LinearLayout {
    private int height;

    public BlankLinearLayout(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.height;
        if (i3 > 0) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
        } else {
            super.onMeasure(i, i2);
        }
    }

    public void setMinHeight(int i) {
        this.height = i;
        if (i > 0) {
            setMeasuredDimension(getMeasuredWidth(), i);
        }
    }

    public BlankLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BlankLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
