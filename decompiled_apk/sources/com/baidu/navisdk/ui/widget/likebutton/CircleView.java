package com.baidu.navisdk.ui.widget.likebutton;

import XIXIX.OOXIXo;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import androidx.annotation.ColorInt;

/* loaded from: classes8.dex */
public class CircleView extends View {
    public static final Property<CircleView, Float> INNER_CIRCLE_RADIUS_PROGRESS;
    public static final Property<CircleView, Float> OUTER_CIRCLE_RADIUS_PROGRESS;
    private int END_COLOR;
    private int START_COLOR;
    private ArgbEvaluator argbEvaluator;
    private Paint circlePaint;
    private float innerCircleRadiusProgress;
    private Paint maskPaint;
    private int maxCircleSize;
    private float outerCircleRadiusProgress;
    private Bitmap tempBitmap;
    private Canvas tempCanvas;

    static {
        Class<Float> cls = Float.class;
        INNER_CIRCLE_RADIUS_PROGRESS = new Property<CircleView, Float>(cls, "innerCircleRadiusProgress") { // from class: com.baidu.navisdk.ui.widget.likebutton.CircleView.1
            @Override // android.util.Property
            public Float get(CircleView circleView) {
                return Float.valueOf(circleView.getInnerCircleRadiusProgress());
            }

            @Override // android.util.Property
            public void set(CircleView circleView, Float f) {
                circleView.setInnerCircleRadiusProgress(f.floatValue());
            }
        };
        OUTER_CIRCLE_RADIUS_PROGRESS = new Property<CircleView, Float>(cls, "outerCircleRadiusProgress") { // from class: com.baidu.navisdk.ui.widget.likebutton.CircleView.2
            @Override // android.util.Property
            public Float get(CircleView circleView) {
                return Float.valueOf(circleView.getOuterCircleRadiusProgress());
            }

            @Override // android.util.Property
            public void set(CircleView circleView, Float f) {
                circleView.setOuterCircleRadiusProgress(f.floatValue());
            }
        };
    }

    public CircleView(Context context) {
        super(context);
        this.START_COLOR = -43230;
        this.END_COLOR = -16121;
        this.argbEvaluator = new ArgbEvaluator();
        this.circlePaint = new Paint();
        this.maskPaint = new Paint();
        this.outerCircleRadiusProgress = 0.0f;
        this.innerCircleRadiusProgress = 0.0f;
        init();
    }

    private void init() {
        this.circlePaint.setStyle(Paint.Style.FILL);
        this.maskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    private void updateCircleColor() {
        this.circlePaint.setColor(((Integer) this.argbEvaluator.evaluate((float) Utils.mapValueFromRangeToRange((float) Utils.clamp(this.outerCircleRadiusProgress, 0.5d, 1.0d), 0.5d, 1.0d, OOXIXo.f3760XO, 1.0d), Integer.valueOf(this.START_COLOR), Integer.valueOf(this.END_COLOR))).intValue());
    }

    public float getInnerCircleRadiusProgress() {
        return this.innerCircleRadiusProgress;
    }

    public float getOuterCircleRadiusProgress() {
        return this.outerCircleRadiusProgress;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.tempCanvas.drawColor(16777215, PorterDuff.Mode.CLEAR);
        this.tempCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.outerCircleRadiusProgress * this.maxCircleSize, this.circlePaint);
        this.tempCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.innerCircleRadiusProgress * this.maxCircleSize, this.maskPaint);
        canvas.drawBitmap(this.tempBitmap, 0.0f, 0.0f, (Paint) null);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.maxCircleSize = i / 2;
        this.tempBitmap = Bitmap.createBitmap(getWidth(), getWidth(), Bitmap.Config.ARGB_8888);
        this.tempCanvas = new Canvas(this.tempBitmap);
    }

    public void setEndColor(@ColorInt int i) {
        this.END_COLOR = i;
        invalidate();
    }

    public void setInnerCircleRadiusProgress(float f) {
        this.innerCircleRadiusProgress = f;
        postInvalidate();
    }

    public void setOuterCircleRadiusProgress(float f) {
        this.outerCircleRadiusProgress = f;
        updateCircleColor();
        postInvalidate();
    }

    public void setStartColor(@ColorInt int i) {
        this.START_COLOR = i;
        invalidate();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.START_COLOR = -43230;
        this.END_COLOR = -16121;
        this.argbEvaluator = new ArgbEvaluator();
        this.circlePaint = new Paint();
        this.maskPaint = new Paint();
        this.outerCircleRadiusProgress = 0.0f;
        this.innerCircleRadiusProgress = 0.0f;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.START_COLOR = -43230;
        this.END_COLOR = -16121;
        this.argbEvaluator = new ArgbEvaluator();
        this.circlePaint = new Paint();
        this.maskPaint = new Paint();
        this.outerCircleRadiusProgress = 0.0f;
        this.innerCircleRadiusProgress = 0.0f;
        init();
    }
}
