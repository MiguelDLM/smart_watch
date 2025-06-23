package com.kwad.components.ad.reward.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes11.dex */
public class KsShadowImageView extends ImageView {
    private Paint AV;
    private BlurMaskFilter AW;
    private int AX;
    private boolean AY;
    private boolean AZ;
    private boolean Ba;
    private boolean Bb;
    private Rect Bc;

    @ColorInt
    private int Bd;

    public KsShadowImageView(Context context) {
        super(context);
        this.Bb = true;
        a(context, null, 0);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet, int i) {
        this.AV = new Paint();
        this.AW = new BlurMaskFilter(50.0f, BlurMaskFilter.Blur.OUTER);
        this.Bc = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShadowImageView, i, 0);
        this.AX = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_KsShadowImageView_ksad_shadowSize, 20);
        this.Bd = obtainStyledAttributes.getColor(R.styleable.ksad_KsShadowImageView_ksad_shadowColor, Color.parseColor("#33000000"));
        this.AY = obtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableLeftShadow, true);
        this.AZ = obtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableRightShadow, true);
        this.Ba = obtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableTopShadow, true);
        this.Bb = obtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableBottomShadow, true);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        super.onDraw(canvas);
        this.AV.setMaskFilter(this.AW);
        this.AV.setColor(this.Bd);
        this.AV.setStyle(Paint.Style.FILL);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        Rect rect = this.Bc;
        int i4 = 0;
        if (this.AY) {
            i = this.AX;
        } else {
            i = 0;
        }
        rect.left = i;
        if (this.Ba) {
            i2 = this.AX;
        } else {
            i2 = 0;
        }
        rect.top = i2;
        if (this.AZ) {
            i3 = this.AX;
        } else {
            i3 = 0;
        }
        rect.right = measuredWidth - i3;
        if (this.Bb) {
            i4 = this.AX;
        }
        rect.bottom = measuredHeight - i4;
        canvas.drawRect(rect, this.AV);
    }

    public KsShadowImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Bb = true;
        a(context, attributeSet, 0);
    }

    public KsShadowImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Bb = true;
        a(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public KsShadowImageView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Bb = true;
        a(context, attributeSet, i);
    }
}
