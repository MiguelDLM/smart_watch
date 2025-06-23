package com.huawei.openalliance.ad.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.huawei.hms.ads.splash.R;

/* loaded from: classes10.dex */
public class RoundLinearLayout extends LinearLayout {
    private final RectF Code;
    private Path I;
    private float V;

    public RoundLinearLayout(Context context) {
        super(context);
        this.Code = new RectF();
        this.V = 0.0f;
        Code(context, null);
    }

    private void Code() {
        this.I.reset();
        Path path = this.I;
        RectF rectF = this.Code;
        float f = this.V;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.V > 0.01f) {
            canvas.clipPath(this.I);
        }
        super.draw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.Code.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        Code();
    }

    public void setRectCornerRadius(float f) {
        this.V = f;
        Code();
        postInvalidate();
    }

    public RoundLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Code = new RectF();
        this.V = 0.0f;
        Code(context, attributeSet);
    }

    private void Code(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PPSRoundCornerLayout)) != null) {
            try {
                this.V = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PPSRoundCornerLayout_hiad_roundCorner, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        setWillNotDraw(false);
        this.I = new Path();
    }

    public RoundLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Code = new RectF();
        this.V = 0.0f;
        Code(context, attributeSet);
    }

    @TargetApi(21)
    public RoundLinearLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Code = new RectF();
        this.V = 0.0f;
        Code(context, attributeSet);
    }
}
