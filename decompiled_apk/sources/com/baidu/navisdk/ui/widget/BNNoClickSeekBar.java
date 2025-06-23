package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;

/* loaded from: classes8.dex */
public class BNNoClickSeekBar extends SeekBar {
    public BNNoClickSeekBar(Context context) {
        super(context);
    }

    private boolean isTouchInThumb(MotionEvent motionEvent, Rect rect) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int thumbOffset = (rect.left - getThumbOffset()) + getPaddingLeft();
        int width = rect.width() + thumbOffset;
        if (x >= thumbOffset && x <= width && y >= rect.top && y <= rect.bottom) {
            return true;
        }
        return false;
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && !isTouchInThumb(motionEvent, getThumb().getBounds())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public BNNoClickSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BNNoClickSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
