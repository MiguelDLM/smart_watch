package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.fb;

/* loaded from: classes10.dex */
public class AutoScaleSizeRelativeLayout extends RelativeLayout {
    private static final String Code = "AutoScaleSizeRl";
    private float B;
    private Path C;
    private final RectF I;
    private boolean S;
    private Float V;

    public AutoScaleSizeRelativeLayout(Context context) {
        super(context);
        this.I = new RectF();
        this.B = 0.0f;
        this.S = true;
        Code(context, (AttributeSet) null);
    }

    private int Code(int i, float f) {
        if (f <= 0.0f) {
            return 0;
        }
        float f2 = (i * 1.0f) / f;
        return Z() ? (int) Math.ceil(f2) : (int) f2;
    }

    private int V(int i, float f) {
        float f2 = f * i;
        return Z() ? (int) Math.ceil(f2) : (int) f2;
    }

    public boolean Z() {
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        try {
            if (canvas == null) {
                fb.I(Code, "canvas null");
                return;
            }
            if (this.B > 0.01f) {
                canvas.clipPath(this.C);
            }
            super.draw(canvas);
        } catch (Throwable th) {
            fb.I(Code, "draw err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            super.onLayout(z, i, i2, i3, i4);
            this.I.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            Code();
        } catch (Throwable th) {
            fb.I(Code, "onLayout err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        try {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (!this.S && layoutParams != null && layoutParams.width == -1 && layoutParams.height == -1) {
                super.onMeasure(i, i2);
                return;
            }
            Float f = this.V;
            if (f != null && f.floatValue() > 0.01f) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                if (View.MeasureSpec.getMode(i2) != 1073741824 && (size <= 0 || size2 <= 0)) {
                    i3 = Code(size, this.V.floatValue());
                    i = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                    i2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                }
                if ((size * 1.0f) / size2 > this.V.floatValue()) {
                    size = V(size2, this.V.floatValue());
                } else {
                    size2 = Code(size, this.V.floatValue());
                }
                i3 = size2;
                i = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            }
            super.onMeasure(i, i2);
        } catch (Throwable th) {
            fb.I(Code, "onMeasure err: %s", th.getClass().getSimpleName());
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setRatio(Float f) {
        this.V = f;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setRectCornerRadius(float f) {
        this.B = f;
        Code();
        postInvalidate();
    }

    public void setUseRatioInMatchParentMode(boolean z) {
        this.S = z;
    }

    public AutoScaleSizeRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = new RectF();
        this.B = 0.0f;
        this.S = true;
        Code(context, attributeSet);
    }

    private void Code() {
        this.C.reset();
        Path path = this.C;
        RectF rectF = this.I;
        float f = this.B;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
    }

    public AutoScaleSizeRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.I = new RectF();
        this.B = 0.0f;
        this.S = true;
        Code(context, attributeSet);
    }

    private void Code(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PPSRoundCornerLayout)) != null) {
            try {
                this.B = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PPSRoundCornerLayout_hiad_roundCorner, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        setWillNotDraw(false);
        this.C = new Path();
    }
}
