package com.baidu.navisdk.ui.widget.likebutton;

import XIXIX.OOXIXo;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import androidx.annotation.ColorInt;

/* loaded from: classes8.dex */
public class DotsView extends View {
    private static final int DOTS_COUNT = 8;
    public static final Property<DotsView, Float> DOTS_PROGRESS = new Property<DotsView, Float>(Float.class, "dotsProgress") { // from class: com.baidu.navisdk.ui.widget.likebutton.DotsView.1
        @Override // android.util.Property
        public Float get(DotsView dotsView) {
            return Float.valueOf(dotsView.getCurrentProgress());
        }

        @Override // android.util.Property
        public void set(DotsView dotsView, Float f) {
            dotsView.setCurrentProgress(f.floatValue());
        }
    };
    private static final int OUTER_DOTS_POSITION_ANGLE = 45;
    private int COLOR_1;
    private int COLOR_2;
    private int COLOR_3;
    private int COLOR_4;
    private ArgbEvaluator argbEvaluator;
    private int centerX;
    private int centerY;
    private final Paint[] circlePaints;
    private float currentDotSize1;
    private float currentProgress;
    private float currentRadius1;
    private float maxDotSize;
    private float maxOuterDotsRadius;

    public DotsView(Context context) {
        super(context);
        this.COLOR_1 = -16121;
        this.COLOR_2 = -26624;
        this.COLOR_3 = -43230;
        this.COLOR_4 = -769226;
        this.circlePaints = new Paint[4];
        this.currentProgress = 0.0f;
        this.currentRadius1 = 0.0f;
        this.currentDotSize1 = 0.0f;
        this.argbEvaluator = new ArgbEvaluator();
        init();
    }

    private float dip2px(Context context, float f) {
        return (context.getResources().getDisplayMetrics().density * f) + 0.5f;
    }

    private void drawOuterDotsFrame(Canvas canvas) {
        for (int i = 0; i < 8; i++) {
            double d = ((i * 45) * 3.141592653589793d) / 180.0d;
            int cos = (int) (this.centerX + (this.currentRadius1 * Math.cos(d)));
            float sin = (int) (this.centerY + (this.currentRadius1 * Math.sin(d)));
            float f = this.currentDotSize1;
            Paint[] paintArr = this.circlePaints;
            canvas.drawCircle(cos, sin, f, paintArr[i % paintArr.length]);
        }
    }

    private void init() {
        int i = 0;
        while (true) {
            Paint[] paintArr = this.circlePaints;
            if (i < paintArr.length) {
                paintArr[i] = new Paint();
                this.circlePaints[i].setStyle(Paint.Style.FILL);
                i++;
            } else {
                return;
            }
        }
    }

    private void updateDotsAlpha() {
        int mapValueFromRangeToRange = (int) Utils.mapValueFromRangeToRange((float) Utils.clamp(this.currentProgress, 0.6000000238418579d, 1.0d), 0.6000000238418579d, 1.0d, 255.0d, OOXIXo.f3760XO);
        this.circlePaints[0].setAlpha(mapValueFromRangeToRange);
        this.circlePaints[1].setAlpha(mapValueFromRangeToRange);
        this.circlePaints[2].setAlpha(mapValueFromRangeToRange);
        this.circlePaints[3].setAlpha(mapValueFromRangeToRange);
    }

    private void updateDotsPaints() {
        float f = this.currentProgress;
        if (f < 0.5f) {
            float mapValueFromRangeToRange = (float) Utils.mapValueFromRangeToRange(f, OOXIXo.f3760XO, 0.5d, OOXIXo.f3760XO, 1.0d);
            this.circlePaints[0].setColor(((Integer) this.argbEvaluator.evaluate(mapValueFromRangeToRange, Integer.valueOf(this.COLOR_1), Integer.valueOf(this.COLOR_2))).intValue());
            this.circlePaints[1].setColor(((Integer) this.argbEvaluator.evaluate(mapValueFromRangeToRange, Integer.valueOf(this.COLOR_2), Integer.valueOf(this.COLOR_3))).intValue());
            this.circlePaints[2].setColor(((Integer) this.argbEvaluator.evaluate(mapValueFromRangeToRange, Integer.valueOf(this.COLOR_3), Integer.valueOf(this.COLOR_4))).intValue());
            this.circlePaints[3].setColor(((Integer) this.argbEvaluator.evaluate(mapValueFromRangeToRange, Integer.valueOf(this.COLOR_4), Integer.valueOf(this.COLOR_1))).intValue());
            return;
        }
        float mapValueFromRangeToRange2 = (float) Utils.mapValueFromRangeToRange(f, 0.5d, 1.0d, OOXIXo.f3760XO, 1.0d);
        this.circlePaints[0].setColor(((Integer) this.argbEvaluator.evaluate(mapValueFromRangeToRange2, Integer.valueOf(this.COLOR_2), Integer.valueOf(this.COLOR_3))).intValue());
        this.circlePaints[1].setColor(((Integer) this.argbEvaluator.evaluate(mapValueFromRangeToRange2, Integer.valueOf(this.COLOR_3), Integer.valueOf(this.COLOR_4))).intValue());
        this.circlePaints[2].setColor(((Integer) this.argbEvaluator.evaluate(mapValueFromRangeToRange2, Integer.valueOf(this.COLOR_4), Integer.valueOf(this.COLOR_1))).intValue());
        this.circlePaints[3].setColor(((Integer) this.argbEvaluator.evaluate(mapValueFromRangeToRange2, Integer.valueOf(this.COLOR_1), Integer.valueOf(this.COLOR_2))).intValue());
    }

    private void updateOuterDotsPosition() {
        float f = this.currentProgress;
        if (f < 0.3f) {
            this.currentRadius1 = (float) Utils.mapValueFromRangeToRange(f, OOXIXo.f3760XO, 0.30000001192092896d, OOXIXo.f3760XO, this.maxOuterDotsRadius * 0.8f);
        } else {
            this.currentRadius1 = (float) Utils.mapValueFromRangeToRange(f, 0.30000001192092896d, 1.0d, 0.8f * r3, this.maxOuterDotsRadius);
        }
        float f2 = this.currentProgress;
        if (f2 == 0.0f) {
            this.currentDotSize1 = 0.0f;
            return;
        }
        double d = f2;
        if (d < 0.7d) {
            this.currentDotSize1 = this.maxDotSize;
        } else {
            this.currentDotSize1 = (float) Utils.mapValueFromRangeToRange(d, 0.699999988079071d, 1.0d, this.maxDotSize, OOXIXo.f3760XO);
        }
    }

    public float getCurrentProgress() {
        return this.currentProgress;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        drawOuterDotsFrame(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = i / 2;
        this.centerX = i5;
        this.centerY = i2 / 2;
        float dip2px = dip2px(getContext(), 0.75f);
        this.maxDotSize = dip2px;
        this.maxOuterDotsRadius = (i5 - (dip2px * 2.0f)) + dip2px(getContext(), 12.0f);
    }

    public void setColors(@ColorInt int i, @ColorInt int i2) {
        this.COLOR_1 = i;
        this.COLOR_2 = i2;
        this.COLOR_3 = i;
        this.COLOR_4 = i2;
        invalidate();
    }

    public void setCurrentProgress(float f) {
        this.currentProgress = f;
        updateOuterDotsPosition();
        updateDotsPaints();
        updateDotsAlpha();
        postInvalidate();
    }

    public DotsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.COLOR_1 = -16121;
        this.COLOR_2 = -26624;
        this.COLOR_3 = -43230;
        this.COLOR_4 = -769226;
        this.circlePaints = new Paint[4];
        this.currentProgress = 0.0f;
        this.currentRadius1 = 0.0f;
        this.currentDotSize1 = 0.0f;
        this.argbEvaluator = new ArgbEvaluator();
        init();
    }

    public DotsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.COLOR_1 = -16121;
        this.COLOR_2 = -26624;
        this.COLOR_3 = -43230;
        this.COLOR_4 = -769226;
        this.circlePaints = new Paint[4];
        this.currentProgress = 0.0f;
        this.currentRadius1 = 0.0f;
        this.currentDotSize1 = 0.0f;
        this.argbEvaluator = new ArgbEvaluator();
        init();
    }
}
