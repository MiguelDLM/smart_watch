package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/* loaded from: classes8.dex */
public class BNHorizontalForbidScrollView extends HorizontalScrollView {
    public BNHorizontalForbidScrollView(Context context) {
        super(context);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public BNHorizontalForbidScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BNHorizontalForbidScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
