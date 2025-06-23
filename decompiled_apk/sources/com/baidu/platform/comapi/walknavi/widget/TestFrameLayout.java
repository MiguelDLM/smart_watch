package com.baidu.platform.comapi.walknavi.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* loaded from: classes8.dex */
public class TestFrameLayout extends FrameLayout {
    public TestFrameLayout(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public TestFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
