package com.baidu.navisdk.comapi.mapcontrol;

import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class BNMapGestureDetector extends GestureDetector {
    private boolean hasLongPressEvent;
    private boolean hasTriggerDoubleTapEvent;
    private GestureDetector.OnGestureListener mListener;

    public BNMapGestureDetector(GestureDetector.OnGestureListener onGestureListener) {
        super(onGestureListener, new Handler(Looper.getMainLooper()));
        this.hasTriggerDoubleTapEvent = false;
        this.hasLongPressEvent = false;
        this.mListener = onGestureListener;
    }

    @Override // android.view.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        LogUtil.e("BNMapGestureDetector", "onTouchEvent()");
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        StringBuilder sb = new StringBuilder();
        int i = action & 255;
        sb.append(i);
        sb.append("");
        sb.append(this.hasTriggerDoubleTapEvent);
        sb.append(this.hasLongPressEvent);
        sb.append(this.mListener instanceof GestureDetector.OnDoubleTapListener);
        LogUtil.e("BNMapGestureDetector", sb.toString());
        if (i == 2) {
            if (this.hasTriggerDoubleTapEvent && this.hasLongPressEvent) {
                LogUtil.e("BNMapGestureDetector", "onDoubleTapEvent()");
                GestureDetector.OnGestureListener onGestureListener = this.mListener;
                if (onGestureListener != null && (onGestureListener instanceof GestureDetector.OnDoubleTapListener)) {
                    return ((GestureDetector.OnDoubleTapListener) onGestureListener).onDoubleTapEvent(motionEvent);
                }
            }
        } else if (i == 1) {
            this.hasTriggerDoubleTapEvent = false;
            this.hasLongPressEvent = false;
        }
        return onTouchEvent;
    }

    public void setHasLongPressEvent(boolean z) {
        this.hasLongPressEvent = z;
    }

    public void setHasTriggerDoubleTapEvent(boolean z) {
        this.hasTriggerDoubleTapEvent = z;
    }
}
