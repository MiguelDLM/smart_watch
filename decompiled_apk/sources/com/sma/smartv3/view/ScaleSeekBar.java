package com.sma.smartv3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.view.ViewCompat;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class ScaleSeekBar extends AppCompatSeekBar {
    private boolean isShowTopOfThumb;
    private int mScaleColor;
    private int mScaleCount;

    @OXOo.oOoXoXO
    private Paint mScalePaint;
    private int mScaleWidth;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public ScaleSeekBar(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(@OXOo.OOXIXo Canvas canvas) {
        Rect rect;
        try {
            IIX0o.x0xO0oo(canvas, "canvas");
            super.onDraw(canvas);
            int i = 1;
            this.mScaleCount = getMax() - 1;
            if (getWidth() > 0 && this.mScaleCount > 0) {
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int i2 = this.mScaleCount;
                int i3 = (width - (this.mScaleWidth * i2)) / (i2 + 1);
                int height = ((getHeight() / 2) - (getMinimumHeight() / 2)) + ((getMinimumHeight() * 2) / 5);
                int minimumHeight = (getMinimumHeight() / 5) + height;
                if (getThumb() != null) {
                    rect = getThumb().getBounds();
                } else {
                    rect = null;
                }
                int i4 = this.mScaleCount;
                if (1 <= i4) {
                    while (true) {
                        int paddingLeft = (i * i3) + getPaddingLeft();
                        int i5 = this.mScaleWidth;
                        int i6 = paddingLeft + i5;
                        int i7 = (i5 * 2) + i6;
                        if (this.isShowTopOfThumb || rect == null || i6 - getPaddingLeft() <= rect.left || i7 - getPaddingLeft() >= rect.right) {
                            Paint paint = this.mScalePaint;
                            IIX0o.ooOOo0oXI(paint);
                            canvas.drawRect(i6, height, i7, minimumHeight, paint);
                        }
                        if (i == i4) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
        } finally {
        }
    }

    public final void setRulerColor(int i) {
        this.mScaleColor = i;
        Paint paint = this.mScalePaint;
        if (paint != null) {
            IIX0o.ooOOo0oXI(paint);
            paint.setColor(i);
            requestLayout();
        }
    }

    public final void setRulerCount(int i) {
        this.mScaleCount = i;
        requestLayout();
    }

    public final void setRulerWidth(int i) {
        this.mScaleWidth = i;
        requestLayout();
    }

    public final void setShowTopOfThumb(boolean z) {
        this.isShowTopOfThumb = z;
        requestLayout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public ScaleSeekBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ ScaleSeekBar(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public ScaleSeekBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.mScaleCount = 1;
        this.mScaleWidth = 1;
        this.mScaleColor = ViewCompat.MEASURED_STATE_MASK;
        Paint paint = new Paint();
        this.mScalePaint = paint;
        IIX0o.ooOOo0oXI(paint);
        paint.setColor(this.mScaleColor);
        Paint paint2 = this.mScalePaint;
        IIX0o.ooOOo0oXI(paint2);
        paint2.setAntiAlias(true);
        setSplitTrack(false);
    }
}
