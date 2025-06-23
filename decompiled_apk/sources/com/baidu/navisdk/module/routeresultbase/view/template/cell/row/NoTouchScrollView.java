package com.baidu.navisdk.module.routeresultbase.view.template.cell.row;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/* loaded from: classes7.dex */
public class NoTouchScrollView extends ScrollView {
    public NoTouchScrollView(Context context) {
        super(context);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public NoTouchScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NoTouchScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
