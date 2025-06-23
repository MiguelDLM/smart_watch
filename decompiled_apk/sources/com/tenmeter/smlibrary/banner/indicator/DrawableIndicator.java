package com.tenmeter.smlibrary.banner.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import com.tenmeter.smlibrary.R;

/* loaded from: classes13.dex */
public class DrawableIndicator extends BaseIndicator {
    private Bitmap normalBitmap;
    private Bitmap selectedBitmap;

    public DrawableIndicator(Context context, @DrawableRes int i, @DrawableRes int i2) {
        super(context);
        this.normalBitmap = BitmapFactory.decodeResource(getResources(), i);
        this.selectedBitmap = BitmapFactory.decodeResource(getResources(), i2);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        super.onDraw(canvas);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize > 1 && this.normalBitmap != null && this.selectedBitmap != null) {
            float f = 0.0f;
            for (int i = 0; i < indicatorSize; i++) {
                if (this.config.getCurrentPosition() == i) {
                    bitmap = this.selectedBitmap;
                } else {
                    bitmap = this.normalBitmap;
                }
                canvas.drawBitmap(bitmap, f, 0.0f, this.mPaint);
                f += this.normalBitmap.getWidth() + this.config.getIndicatorSpace();
            }
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
        setMeasuredDimension((this.selectedBitmap.getWidth() * i3) + this.selectedBitmap.getWidth() + (this.config.getIndicatorSpace() * i3), Math.max(this.normalBitmap.getHeight(), this.selectedBitmap.getHeight()));
    }

    public DrawableIndicator(Context context) {
        this(context, null);
    }

    public DrawableIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawableIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SMDrawableIndicator);
        if (obtainStyledAttributes != null) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) obtainStyledAttributes.getDrawable(R.styleable.SMDrawableIndicator_sm_normal_drawable);
            BitmapDrawable bitmapDrawable2 = (BitmapDrawable) obtainStyledAttributes.getDrawable(R.styleable.SMDrawableIndicator_sm_selected_drawable);
            this.normalBitmap = bitmapDrawable.getBitmap();
            this.selectedBitmap = bitmapDrawable2.getBitmap();
        }
    }
}
