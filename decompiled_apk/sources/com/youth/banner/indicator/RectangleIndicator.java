package com.youth.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

/* loaded from: classes13.dex */
public class RectangleIndicator extends BaseIndicator {
    RectF rectF;

    public RectangleIndicator(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int normalColor;
        int normalWidth;
        super.onDraw(canvas);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize <= 1) {
            return;
        }
        float f = 0.0f;
        for (int i = 0; i < indicatorSize; i++) {
            Paint paint = this.mPaint;
            if (this.config.getCurrentPosition() == i) {
                normalColor = this.config.getSelectedColor();
            } else {
                normalColor = this.config.getNormalColor();
            }
            paint.setColor(normalColor);
            if (this.config.getCurrentPosition() == i) {
                normalWidth = this.config.getSelectedWidth();
            } else {
                normalWidth = this.config.getNormalWidth();
            }
            this.rectF.set(f, 0.0f, normalWidth + f, this.config.getHeight());
            f += normalWidth + this.config.getIndicatorSpace();
            canvas.drawRoundRect(this.rectF, this.config.getRadius(), this.config.getRadius(), this.mPaint);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize <= 1) {
            return;
        }
        int i3 = indicatorSize - 1;
        setMeasuredDimension((this.config.getIndicatorSpace() * i3) + (this.config.getNormalWidth() * i3) + this.config.getSelectedWidth(), this.config.getHeight());
    }

    public RectangleIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RectangleIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rectF = new RectF();
    }
}
