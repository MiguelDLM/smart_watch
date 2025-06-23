package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.alimm.tanx.core.utils.LogUtils;

public class TouchTraceView extends View {
    private float tanxc_byte;
    private float tanxc_case;
    private float tanxc_char;
    Context tanxc_do;
    private int tanxc_else = 3;
    float tanxc_for = 0.56f;
    private final boolean tanxc_goto = false;
    InteractionCallBack tanxc_if;
    private final Paint tanxc_int;
    private final int tanxc_long = 55;
    private final Path tanxc_new;
    private final int tanxc_this = 120;
    private float tanxc_try;

    public interface InteractionCallBack {
        void onInteractionEnd(int i, int i2, int i3);

        void onInteractionStart();
    }

    public TouchTraceView(Context context, AttributeSet attributeSet, InteractionCallBack interactionCallBack) {
        super(context, attributeSet);
        this.tanxc_do = context;
        this.tanxc_new = new Path();
        Paint paint = new Paint();
        this.tanxc_int = paint;
        paint.setColor(-1);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(10.0f);
        this.tanxc_if = interactionCallBack;
    }

    private int tanxc_do(float f, float f2, float f3, float f4) {
        float f5 = f - f2;
        float f6 = f3 - f4;
        return (int) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        LogUtils.d("TouchTraceView", "onDraw");
        canvas.drawPath(this.tanxc_new, this.tanxc_int);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((int) (((float) View.MeasureSpec.getSize(i)) * this.tanxc_for), 1073741824));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            LogUtils.d("TouchTraceView", "ACTION_DOWN");
            this.tanxc_case = x;
            this.tanxc_char = y;
            this.tanxc_new.moveTo(x, y);
            InteractionCallBack interactionCallBack = this.tanxc_if;
            if (interactionCallBack != null) {
                interactionCallBack.onInteractionStart();
            }
        } else if (actionMasked == 1) {
            LogUtils.d("TouchTraceView", "ACTION_UP");
            LogUtils.d("touch--->", "x: " + (x - this.tanxc_case) + " y:" + (y - this.tanxc_char));
            this.tanxc_new.reset();
            requestLayout();
            InteractionCallBack interactionCallBack2 = this.tanxc_if;
            float f = this.tanxc_case;
            float f2 = this.tanxc_char;
            interactionCallBack2.onInteractionEnd((int) (x - f), (int) (y - f2), tanxc_do(x, f, y, f2));
            return true;
        } else if (actionMasked != 2) {
            LogUtils.d("TouchTraceView", "default");
            this.tanxc_new.reset();
        } else {
            LogUtils.d("TouchTraceView", "ACTION_MOVE");
            this.tanxc_new.quadTo(this.tanxc_try, this.tanxc_byte, x, y);
        }
        invalidate();
        this.tanxc_try = x;
        this.tanxc_byte = y;
        return true;
    }

    public void onVisibilityAggregated(boolean z) {
        Path path;
        super.onVisibilityAggregated(z);
        LogUtils.d("TouchTraceView", "onVisibilityAggregated:" + z);
        if (!z && (path = this.tanxc_new) != null) {
            path.reset();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        Path path;
        super.onWindowFocusChanged(z);
        if (!z && (path = this.tanxc_new) != null) {
            path.reset();
        }
        LogUtils.d("TouchTraceView", "onWindowFocusChanged:" + z);
    }

    public void tanxc_do(float f) {
        this.tanxc_for = f;
    }
}
