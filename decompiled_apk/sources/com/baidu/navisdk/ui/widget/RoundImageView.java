package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.navisdk.embed.R;

/* loaded from: classes8.dex */
public class RoundImageView extends ImageView {
    private Path mClipPath;
    private float mRadio;
    private float mRadius;

    /* loaded from: classes8.dex */
    public static final class Size {
        public final float height;
        public final float width;

        public Size(float f, float f2) {
            this.width = f;
            this.height = f2;
        }
    }

    public RoundImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mClipPath == null) {
            Path path = new Path();
            this.mClipPath = path;
            RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            float f = this.mRadius;
            path.addRoundRect(rectF, new float[]{f, f, f, f, f, f, f, f}, Path.Direction.CW);
        }
        canvas.clipPath(this.mClipPath);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mRadio <= 0.0f) {
            super.onMeasure(i, i2);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (size / this.mRadio), 1073741824));
    }

    public void setRadio(float f) {
        this.mRadio = f;
    }

    public void setRadius(float f) {
        this.mRadius = f;
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRadio = 1.0f;
        this.mRadius = 0.0f;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundedImageView);
            this.mRadio = obtainStyledAttributes.getFloat(R.styleable.RoundedImageView_roundedImageViewSizeRadio, this.mRadio);
            this.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_roundedImageViewCornerRadius, (int) this.mRadius);
            obtainStyledAttributes.recycle();
        }
    }
}
