package com.baidu.mapclient.liteapp.view.WheelView;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* loaded from: classes7.dex */
final class LoopViewGestureListener extends GestureDetector.SimpleOnGestureListener {
    private WheelView loopView;

    public LoopViewGestureListener(WheelView wheelView) {
        this.loopView = wheelView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.loopView.scrollBy(f2);
        return true;
    }
}
