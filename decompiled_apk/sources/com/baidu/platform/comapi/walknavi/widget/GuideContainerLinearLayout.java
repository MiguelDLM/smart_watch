package com.baidu.platform.comapi.walknavi.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* loaded from: classes8.dex */
public class GuideContainerLinearLayout extends LinearLayout {
    public GuideContainerLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    public GuideContainerLinearLayout(Context context) {
        super(context);
    }
}
