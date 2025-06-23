package com.youth.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

/* loaded from: classes13.dex */
public class CircleIndicator extends BaseIndicator {
    private int mNormalRadius;
    private int mSelectedRadius;
    private int maxRadius;

    public CircleIndicator(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int normalColor;
        int normalWidth;
        int i;
        super.onDraw(canvas);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize <= 1) {
            return;
        }
        float f = 0.0f;
        for (int i2 = 0; i2 < indicatorSize; i2++) {
            Paint paint = this.mPaint;
            if (this.config.getCurrentPosition() == i2) {
                normalColor = this.config.getSelectedColor();
            } else {
                normalColor = this.config.getNormalColor();
            }
            paint.setColor(normalColor);
            if (this.config.getCurrentPosition() == i2) {
                normalWidth = this.config.getSelectedWidth();
            } else {
                normalWidth = this.config.getNormalWidth();
            }
            if (this.config.getCurrentPosition() == i2) {
                i = this.mSelectedRadius;
            } else {
                i = this.mNormalRadius;
            }
            float f2 = i;
            canvas.drawCircle(f + f2, this.maxRadius, f2, this.mPaint);
            f += normalWidth + this.config.getIndicatorSpace();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize <= 1) {
            return;
        }
        this.mNormalRadius = this.config.getNormalWidth() / 2;
        int selectedWidth = this.config.getSelectedWidth() / 2;
        this.mSelectedRadius = selectedWidth;
        this.maxRadius = Math.max(selectedWidth, this.mNormalRadius);
        int i3 = indicatorSize - 1;
        setMeasuredDimension((this.config.getIndicatorSpace() * i3) + this.config.getSelectedWidth() + (this.config.getNormalWidth() * i3), Math.max(this.config.getNormalWidth(), this.config.getSelectedWidth()));
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mNormalRadius = this.config.getNormalWidth() / 2;
        this.mSelectedRadius = this.config.getSelectedWidth() / 2;
    }
}
